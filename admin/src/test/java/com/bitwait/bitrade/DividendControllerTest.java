package com.bitwait.bitrade;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.bitwait.bitrade.service.OrderDetailAggregationService;
import com.bitwait.bitrade.util.DateUtil;

/**
 * @author ragan QQ:2098401701 E-mail:bitwait@qq.com
 * @date 2020年03月22日
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes=AdminApplication.class)
public class DividendControllerTest {
    @Autowired
    private OrderDetailAggregationService orderDetailAggregationService;
    @Test
    public void queryStatistics(){
        long start = DateUtil.strToDate("2020-03-01 12:30:30").getTime();
        long end = DateUtil.strToDate("2020-03-22 14:30:30").getTime();
        System.out.println("start:"+start+"-----end:"+end);
        orderDetailAggregationService.queryStatistics(start,end);
    }
}
