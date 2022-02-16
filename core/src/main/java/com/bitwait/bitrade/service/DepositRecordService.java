package com.bitwait.bitrade.service;

import com.bitwait.bitrade.constant.DepositStatusEnum;
import com.bitwait.bitrade.constant.PageModel;
import com.bitwait.bitrade.service.Base.BaseService;
import com.bitwait.bitrade.dao.DepositRecordDao;
import com.bitwait.bitrade.entity.DepositRecord;
import com.bitwait.bitrade.entity.Member;
import com.querydsl.core.types.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ragan QQ:2098401701 E-mail:bitwait@qq.com
 * @date 2019/5/7
 */
@Service
public class DepositRecordService extends BaseService {
    @Autowired
    private DepositRecordDao depositRecordDao;

    public List<DepositRecord> getAll(){
        return depositRecordDao.findAll();
    }

    public Page<DepositRecord> list(Predicate predicate, PageModel pageModel){
        return depositRecordDao.findAll(predicate,pageModel.getPageable());
    }

    public List<DepositRecord> findAll(Predicate predicate){
        return (List<DepositRecord>) depositRecordDao.findAll(predicate);
    }

    public DepositRecord findOne(String id){
        return depositRecordDao.findById(id);
    }

    public void update(DepositRecord depositRecord){
        depositRecordDao.save(depositRecord);
    }

    public void create(DepositRecord depositRecord){
        depositRecordDao.save(depositRecord);
    }

    public List<DepositRecord> findByMemberAndStatus(Member member, DepositStatusEnum status){
        return depositRecordDao.findByMemberAndStatus(member,status);
    }

    public DepositRecord save(DepositRecord depositRecord){
        return depositRecordDao.save(depositRecord);
    }
}
