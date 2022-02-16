package com.bitwait.bitrade.system;

import com.bitwait.bitrade.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bitwait.bitrade.entity.DataDictionary;
import com.bitwait.bitrade.service.DataDictionaryService;
import com.bitwait.bitrade.util.MessageResult;

/**
 * @author ragan QQ:2098401701 E-mail:bitwait@qq.com
 * @Title: ${file_name}
 * @Description:
 * @date 2019/4/1214:21
 */
@RestController
@RequestMapping("data-dictionary")
public class DataDictionaryContrller extends BaseController {
    @Autowired
    private DataDictionaryService service;

    @GetMapping("{bond}")
    public MessageResult get(@PathVariable("bond") String bond) {
        DataDictionary data = service.findByBond(bond);
        if (data == null) {
            return error("validate bond");
        }
        return success((Object) data.getValue());
    }

}
