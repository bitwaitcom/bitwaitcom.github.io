package com.bitwait.bitrade.service;

import com.bitwait.bitrade.pagination.Criteria;
import com.bitwait.bitrade.pagination.Restrictions;
import com.bitwait.bitrade.service.Base.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bitwait.bitrade.dao.TransferRecordDao;
import com.bitwait.bitrade.entity.TransferRecord;

/**
 * @author ragan QQ:2098401701 E-mail:bitwait@qq.com
 * @date 2020年02月27日
 */
@Service
public class TransferRecordService extends BaseService {
    @Autowired
    private TransferRecordDao transferRecordDao;

    public TransferRecord save(TransferRecord transferRecord){
        return transferRecordDao.save(transferRecord);
    }

    @Transactional(readOnly = true)
    public Page<TransferRecord> findAllByMemberId(Long memberId, int page, int pageSize) {
        Sort orders = Criteria.sortStatic("id.desc");
        PageRequest pageRequest = new PageRequest(page, pageSize, orders);
        Criteria<TransferRecord> specification = new Criteria<>();
        specification.add(Restrictions.eq("memberId", memberId, false));
        return transferRecordDao.findAll(specification, pageRequest);
    }
}
