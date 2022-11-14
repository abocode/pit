package cn.source.system.domain.survey;

import cn.source.common.annotation.Excel;
import cn.source.common.core.domain.BaseEntity;

/**
 * @author Andy
 * @date 2022/10/31
 */
public class SurveyOptions extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /** 选项编号 */
    private Long optionId;

    /** 选项内容 */
    @Excel(name = "选项内容")
    private String optionContent;

    /** 问题编号 */
    @Excel(name = "问题编号")
    private Long questionId;

    /** 排序 */
    @Excel(name = "排序")
    private Integer optionOrder;


    public void setOptionId(Long optionId)
    {
        this.optionId = optionId;
    }

    public Long getOptionId()
    {
        return optionId;
    }
    public void setOptionContent(String optionContent)
    {
        this.optionContent = optionContent;
    }

    public String getOptionContent()
    {
        return optionContent;
    }
    public void setQuestionId(Long questionId)
    {
        this.questionId = questionId;
    }

    public Long getQuestionId()
    {
        return questionId;
    }
    public void setOptionOrder(Integer optionOrder)
    {
        this.optionOrder = optionOrder;
    }

    public Integer getOptionOrder() {
        return optionOrder;
    }

    @Override
    public String toString() {
        return "SurveyOptions{" +
                "optionId=" + optionId +
                ", optionContent='" + optionContent + '\'' +
                ", questionId=" + questionId +
                ", optionOrder=" + optionOrder +
                '}';
    }
}