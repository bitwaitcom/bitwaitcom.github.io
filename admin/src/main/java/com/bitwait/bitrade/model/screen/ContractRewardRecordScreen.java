package com.bitwait.bitrade.model.screen;

import com.bitwait.bitrade.constant.ContractRewardRecordType;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class ContractRewardRecordScreen {
    private ContractRewardRecordType type;
    private Long memberId;
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    private Date startTime;
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    private Date endTime;
}
