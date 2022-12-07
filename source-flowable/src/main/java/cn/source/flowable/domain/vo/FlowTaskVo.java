package cn.source.flowable.domain.vo;

import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * <p>流程任务<p>
 *
 * @author 詹Sir
 * @date 2021-04-03
 */
@Data
public class FlowTaskVo {

    /**任务Id*/
    private String taskId;

    /**用户Id*/
    private String userId;

    /**任务意见*/
    private String comment;

    /**流程实例Id*/
    private String instanceId;

    /**节点*/
    private String targetKey;

    /**流程变量信息*/
    private Map<String, Object> values;

    /**审批人*/
    private String assignee;

    /**候选人*/
    private List<String> candidateUsers;

    /**审批组*/
    private List<String> candidateGroups;
}
