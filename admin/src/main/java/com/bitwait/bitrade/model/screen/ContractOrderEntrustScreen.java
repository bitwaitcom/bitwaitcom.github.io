package com.bitwait.bitrade.model.screen;

import com.bitwait.bitrade.entity.ContractOrderDirection;
import com.bitwait.bitrade.entity.ContractOrderEntrustStatus;
import com.bitwait.bitrade.entity.ContractOrderEntrustType;
import com.bitwait.bitrade.entity.ContractOrderType;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class ContractOrderEntrustScreen {
    private ContractOrderEntrustStatus status;
    private ContractOrderType type;
    private ContractOrderDirection direction;
    private ContractOrderEntrustType entrustType;
    private Long memberId;
    private Long contractId;
    private BigDecimal volume;
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    private Date startTime;
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    private Date endTime;
    private Integer isFromSpot;
    private Integer isBlast;
    private BigDecimal profitAndLoss;
    private String phone;
    private String email;
}
