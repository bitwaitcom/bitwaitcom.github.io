package com.bitwait.bitrade.controller;

import lombok.extern.slf4j.Slf4j;

import static com.bitwait.bitrade.constant.SysConstant.SESSION_MEMBER;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.bitwait.bitrade.entity.Feedback;
import com.bitwait.bitrade.entity.Member;
import com.bitwait.bitrade.entity.transform.AuthMember;
import com.bitwait.bitrade.service.FeedbackService;
import com.bitwait.bitrade.service.LocaleMessageSourceService;
import com.bitwait.bitrade.service.MemberService;
import com.bitwait.bitrade.util.MessageResult;

/**
 * @author ragan QQ:2098401701 E-mail:bitwait@qq.com
 * @date 2020年03月19日
 */
@RestController
@Slf4j
public class FeedbackController {
    @Autowired
    private FeedbackService feedbackService;
    @Autowired
    private MemberService memberService;
    @Autowired
    private LocaleMessageSourceService msService;

    /**
     * 提交反馈意见
     *
     * @param user
     * @param remark
     * @return
     */
    @RequestMapping("feedback")
    @Transactional(rollbackFor = Exception.class)
    public MessageResult feedback(@SessionAttribute(SESSION_MEMBER) AuthMember user, String remark) {
        Feedback feedback = new Feedback();
        Member member = memberService.findOne(user.getId());
        feedback.setMember(member);
        feedback.setRemark(remark);
        Feedback feedback1 = feedbackService.save(feedback);
        if (feedback1 != null) {
            return MessageResult.success();
        } else {
            return MessageResult.error(msService.getMessage("SYSTEM_ERROR"));
        }
    }
}
