package cn.source.system.websocket;

import cn.source.system.constant.MsgConstant;
import cn.source.system.domain.CmsMsg;
import cn.source.system.service.ICmsMsgService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.util.concurrent.Semaphore;

/**
 * websocket 消息处理
 *
 * @author ruoyi
 */
@Component
@ServerEndpoint("/websocket/message")
public class WebSocketServer
{
    /**
     * WebSocketServer 日志控制器
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(WebSocketServer.class);


    /**
     * 注入消息service
     */
    private static ICmsMsgService cmsMsgService;

    @Autowired
    public void setCmsMsgService(ICmsMsgService cmsMsgService) {
        this.cmsMsgService = cmsMsgService;
    }

    /**
     * 默认最多允许同时在线人数1000
     */
    public static int socketMaxOnlineCount = 1000;

    private static Semaphore socketSemaphore = new Semaphore(socketMaxOnlineCount);

    /**
     * 连接建立成功调用的方法
     */
    @OnOpen
    public void onOpen(Session session) throws Exception
    {
        boolean semaphoreFlag = false;
        // 尝试获取信号量
        semaphoreFlag = SemaphoreUtils.tryAcquire(socketSemaphore);
        if (!semaphoreFlag)
        {
            // 未获取到信号量
            LOGGER.error("\n 当前在线人数超过限制数- {}", socketMaxOnlineCount);
           WebSocketUsers.sendMessageToUserByText(session, "当前在线人数超过限制数：" + socketMaxOnlineCount);
            session.close();
        }
        else
        {
            // 添加用户
            WebSocketUsers.put(session.getId(), session);
            LOGGER.info("\n 建立连接 - {}", session);
            LOGGER.info("\n 当前人数 - {}", WebSocketUsers.getUsers().size());
           // WebSocketUsers.sendMessageToUserByText(session, "连接成功");
        }
    }

    /**
     * 连接关闭时处理
     */
    @OnClose
    public void onClose(Session session)
    {
        LOGGER.info("\n 关闭连接 - {}", session);
        // 移除用户
        WebSocketUsers.remove(session.getId());
        // 获取到信号量则需释放
        SemaphoreUtils.release(socketSemaphore);
    }

    /**
     * 抛出异常时处理
     */
    @OnError
    public void onError(Session session, Throwable exception) throws Exception
    {
        if (session.isOpen())
        {
            // 关闭连接
            session.close();
        }
        String sessionId = session.getId();
        LOGGER.info("\n 连接异常 - {}", sessionId);
        LOGGER.info("\n 异常信息 - {}", exception);
        // 移出用户
        WebSocketUsers.remove(sessionId);
        // 获取到信号量则需释放
        SemaphoreUtils.release(socketSemaphore);
    }

    /**
     * 服务器接收到客户端消息时调用的方法
     */
    @OnMessage
    public void onMessage(String message, Session session)
    {
        String msg = message.replace("你", "我").replace("吗", "");
        LOGGER.info("\n 连接信息 - {}", session.getId());
        LOGGER.info("\n 收到消息 - {}", message);
        // 收到消息写入数据表中
        CmsMsg cmsMsg = new CmsMsg();
        cmsMsg.setMsgType(MsgConstant.SYS_USER);
        cmsMsg.setMsgContent(message);
        cmsMsg.setAvatar(MsgConstant.USER_AVATAR);
        cmsMsg.setMsgFromSession(session.getId());
        // 查询管理员的session,set到tosession
        cmsMsgService.insertCmsMsg(cmsMsg);
        // 回消息
        msg = "请留下你的联系方式，稍后会有产品经理联系你";
        WebSocketUsers.sendMessageToUserByText(session, msg);
}
}