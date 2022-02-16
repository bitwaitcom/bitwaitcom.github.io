package com.bitwait.bitrade.model.screen;

import com.bitwait.bitrade.ability.ScreenAbility;
import com.bitwait.bitrade.constant.Platform;
import com.bitwait.bitrade.entity.QAppRevision;
import com.querydsl.core.types.dsl.BooleanExpression;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;

/**
 * @author ragan QQ:2098401701 E-mail:bitwait@qq.com
 * @Title: ${file_name}
 * @Description:
 * @date 2019/4/2417:20
 */
@Data
public class AppRevisionScreen implements ScreenAbility {

    private String version;

    private Platform platform;

    @Override
    public ArrayList<BooleanExpression> getBooleanExpressions() {
        ArrayList<BooleanExpression> booleanExpressions = new ArrayList<>();
        if (StringUtils.isNotBlank(version)) {
            booleanExpressions.add(QAppRevision.appRevision.version.eq(version));
        }
        if (platform != null) {
            booleanExpressions.add(QAppRevision.appRevision.platform.eq(platform));
        }
        return booleanExpressions;
    }

}
