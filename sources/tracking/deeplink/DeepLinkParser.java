package tracking.deeplink;

import com.huawei.hms.framework.common.ContainerUtils;
import com.talabat.core.tracking.data.constant.ConstantsKt;

public class DeepLinkParser {
    public static DeepLinkResult parse(String str) {
        DeepLinkResult deepLinkResult = new DeepLinkResult();
        if (str != null) {
            try {
                for (String str2 : str.split(ContainerUtils.FIELD_DELIMITER)) {
                    if (str2.startsWith(ConstantsKt.DEEPLINK_UTM_SOURCE)) {
                        String[] split = str2.split("=");
                        if (split.length > 1) {
                            deepLinkResult.source = split[1];
                        }
                    } else if (str2.startsWith(ConstantsKt.DEEPLINK_UTM_MEDIUM)) {
                        String[] split2 = str2.split("=");
                        if (split2.length > 1) {
                            deepLinkResult.medium = split2[1];
                        }
                    } else if (str2.startsWith(ConstantsKt.DEEPLINK_UTM_CAMPAIGN)) {
                        String[] split3 = str2.split("=");
                        if (split3.length > 1) {
                            deepLinkResult.campaign = split3[1];
                        }
                    } else if (str2.startsWith("adjust_tracker")) {
                        String[] split4 = str2.split("=");
                        if (split4.length > 1) {
                            deepLinkResult.adjust_tracker = split4[1];
                        }
                    } else if (str2.startsWith("adjust_campaign")) {
                        String[] split5 = str2.split("=");
                        if (split5.length > 1) {
                            deepLinkResult.adjust_campaign = split5[1];
                        }
                    } else if (str2.startsWith("adjust_adgroup")) {
                        String[] split6 = str2.split("=");
                        if (split6.length > 1) {
                            deepLinkResult.adjust_adgroup = split6[1];
                        }
                    } else if (str2.startsWith("adjust_creative")) {
                        String[] split7 = str2.split("=");
                        if (split7.length > 1) {
                            deepLinkResult.adjust_creative = split7[1];
                        }
                    } else if (str2.startsWith("adjust_label")) {
                        String[] split8 = str2.split("=");
                        if (split8.length > 1) {
                            deepLinkResult.adjust_label = split8[1];
                        }
                    } else if (str2.startsWith(ConstantsKt.DEEPLINK_UTM_ID)) {
                        String[] split9 = str2.split("=");
                        if (split9.length > 1) {
                            deepLinkResult.setId(split9[1]);
                        }
                    } else if (str2.startsWith(ConstantsKt.DEEPLINK_UTM_TERM)) {
                        String[] split10 = str2.split("=");
                        if (split10.length > 1) {
                            deepLinkResult.setTerm(split10[1]);
                        }
                    } else if (str2.startsWith(ConstantsKt.DEEPLINK_UTM_CONTENT)) {
                        String[] split11 = str2.split("=");
                        if (split11.length > 1) {
                            deepLinkResult.setContent(split11[1]);
                        }
                    } else if (str2.startsWith("gclid")) {
                        String[] split12 = str2.split("=");
                        if (split12.length > 1) {
                            deepLinkResult.setGclId(split12[1]);
                        }
                    }
                }
            } catch (Exception unused) {
            }
        }
        return deepLinkResult;
    }
}
