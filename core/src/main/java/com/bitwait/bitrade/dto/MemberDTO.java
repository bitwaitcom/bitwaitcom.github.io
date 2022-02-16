package com.bitwait.bitrade.dto;

import com.bitwait.bitrade.entity.Member;
import com.bitwait.bitrade.entity.MemberWallet;
import lombok.Data;

import java.util.List;

@Data
public class MemberDTO {

    private Member member ;

    private List<MemberWallet> list ;

}
