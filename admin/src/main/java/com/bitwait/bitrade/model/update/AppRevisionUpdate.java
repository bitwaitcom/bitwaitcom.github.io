package com.bitwait.bitrade.model.update;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import com.bitwait.bitrade.ability.UpdateAbility;
import com.bitwait.bitrade.constant.Platform;
import com.bitwait.bitrade.entity.AppRevision;

/**
 * @author ragan QQ:2098401701 E-mail:bitwait@qq.com
 * @Title: ${file_name}
 * @Description:
 * @date 2019/4/2416:48
 */
@Data
public class AppRevisionUpdate implements UpdateAbility<AppRevision> {

    private String remark;

    private String version;

    private String downloadUrl;

    private Platform platform;

    //转化
    @Override
    public AppRevision transformation(AppRevision appRevision) {
        if (StringUtils.isNotBlank(remark)) {
            appRevision.setRemark(remark);
        }
        if (StringUtils.isNotBlank(version)) {
            appRevision.setVersion(version);
        }
        if (StringUtils.isNotBlank(downloadUrl)) {
            appRevision.setDownloadUrl(downloadUrl);
        }
        if (platform != null) {
            appRevision.setPlatform(platform);
        }
        return appRevision;
    }


}
