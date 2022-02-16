package com.bitwait.bitrade.controller.activity;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bitwait.bitrade.constant.PageModel;
import com.bitwait.bitrade.controller.common.BaseAdminController;
import com.bitwait.bitrade.entity.MemberSignRecord;
import com.bitwait.bitrade.model.screen.MemberSignRecordScreen;
import com.bitwait.bitrade.model.vo.MemberSignRecordVO;
import com.bitwait.bitrade.service.MemberSignRecordService;
import com.bitwait.bitrade.util.MessageResult;

/**
 * @author ragan QQ:2098401701 E-mail:bitwait@qq.com
 * @Description: 会员签到记录
 * @date 2019/5/4
 */
@RestController
@RequestMapping("activity/member-sign-record")
public class MemberSignRecordControler extends BaseAdminController {
    @Autowired
    private MemberSignRecordService service;

    @RequiresPermissions("activity:member-sign-record:page-query")
    @GetMapping("page-query")
    public MessageResult pageQuery(MemberSignRecordScreen screen, PageModel pageModel) {
        Page<MemberSignRecord> source = service.findAllScreen(screen, pageModel);
        Page<MemberSignRecordVO> page = source.map(x -> MemberSignRecordVO.getMemberSignRecordVO(x));
        return success(page);
    }
}
