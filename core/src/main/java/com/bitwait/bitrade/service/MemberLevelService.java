package com.bitwait.bitrade.service;

import com.bitwait.bitrade.service.Base.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitwait.bitrade.dao.MemberLevelDao;
import com.bitwait.bitrade.entity.MemberLevel;

import java.util.List;

/**
 * @author ragan QQ:2098401701 E-mail:bitwait@qq.com
 * @description
 * @date 2019/12/26 17:26
 */
@Service
public class MemberLevelService extends BaseService {
    @Autowired
    private MemberLevelDao memberLevelDao;

    @Override
    public List<MemberLevel> findAll(){
        return memberLevelDao.findAll();
    }

    /**
     * @author ragan QQ:2098401701 E-mail:bitwait@qq.com
     * @description id查询一个
     * @date 2019/12/27 10:54
     */
    public MemberLevel findOne(Long id){
        return  memberLevelDao.findOne(id);
    }

    /**
     * @author ragan QQ:2098401701 E-mail:bitwait@qq.com
     * @description 查询默认会员的等级
     * @date 2019/12/26 17:58
     */
    public MemberLevel findDefault() {
        return memberLevelDao.findOneByIsDefault(true);
    }

    /**
     * @author ragan QQ:2098401701 E-mail:bitwait@qq.com
     * @description 更新状态为false 不包括
     * @date 2019/12/27 11:02
     */
    public int updateDefault() {
       return memberLevelDao.updateDefault();
    }

    public MemberLevel save(MemberLevel memberLevel) {
        return memberLevelDao.save(memberLevel);
    }
}
