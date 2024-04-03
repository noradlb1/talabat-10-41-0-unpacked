package com.huawei.wisesecurity.ucs.credential.outer;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.wisesecurity.ucs.common.exception.UcsErrorCode;
import com.huawei.wisesecurity.ucs.common.exception.UcsException;
import com.huawei.wisesecurity.ucs.common.log.LogUcs;
import com.huawei.wisesecurity.ucs.common.report.ReportOption;
import com.huawei.wisesecurity.ucs.credential.outer.impl.QuietHACapabilityImpl;
import com.huawei.wisesecurity.ucs_credential.l;
import com.huawei.wisesecurity.ucs_credential.m;
import com.huawei.wisesecurity.ucs_credential.n;
import com.huawei.wisesecurity.ucs_credential.p;
import com.huawei.wisesecurity.ucs_credential.u;

public class Selector {
    public static final String GRS_FEATURE_CLASS = "com.huawei.hms.framework.network.grs.GrsClient";
    public static final String HA_FEATURE_CLASS = "com.huawei.hianalytics.process.HiAnalyticsInstance";
    public static final String NETWORK_FEATURE_CLASS = "com.huawei.hms.network.restclient.RestClient";
    public static final int NETWORK_RETRY_TIME_MAX = 5;
    public static final int NETWORK_RETRY_TIME_MIN = 1;
    public static final int NETWORK_TIME_OUT_MAX = 20000;
    public static final int NETWORK_TIME_OUT_MIN = 10000;
    public static final int SER_COUNTRY_LENGTH_MAX = 7;
    public static final int SER_COUNTRY_LENGTH_MIN = 2;
    public static final String TAG = "Selector";

    public static l selectGrsCapability(GrsCapability grsCapability, Context context, String str) throws UcsException {
        if (grsCapability != null) {
            return new n(grsCapability);
        }
        try {
            if (!TextUtils.isEmpty(str)) {
                if (str.length() < 2 || str.length() > 7) {
                    throw new UcsException(UcsErrorCode.PARAM_ILLEGAL, "serCountry param error");
                }
            }
            LogUcs.i(TAG, "outer GRS capability is null, use inner capability", new Object[0]);
            return new m(context, str);
        } catch (ClassNotFoundException e11) {
            throw new UcsException(UcsErrorCode.LACK_CAPABILITY_COMPONENT_ERROR, "GRS capability not found : " + e11.getMessage());
        }
    }

    public static HACapability selectHACapability(HACapability hACapability, l lVar, ReportOption reportOption) throws UcsException {
        if (hACapability != null) {
            return hACapability;
        }
        if (ReportOption.REPORT_CLOSE == reportOption) {
            return new QuietHACapabilityImpl();
        }
        try {
            Class.forName(HA_FEATURE_CLASS);
            LogUcs.i(TAG, "outer HA capability is null, use inner capability", new Object[0]);
            return new u(lVar, reportOption);
        } catch (ClassNotFoundException e11) {
            throw new UcsException(UcsErrorCode.LACK_CAPABILITY_COMPONENT_ERROR, "HA capability not found : " + e11.getMessage());
        }
    }

    public static NetworkCapability selectNetWorkCapability(NetworkCapability networkCapability, Context context, int i11, int i12) throws UcsException {
        if (networkCapability != null) {
            networkCapability.initConfig(i11, i12);
            return networkCapability;
        }
        try {
            Class.forName(NETWORK_FEATURE_CLASS);
            if (i11 < 10000 || i11 > 20000 || i12 < 1 || i12 > 5) {
                throw new UcsException(UcsErrorCode.PARAM_ILLEGAL, "networkTimeOut or networkRetryTime param error");
            }
            p pVar = new p(context);
            pVar.initConfig(i11, i12);
            LogUcs.i(TAG, "outer Network capability is null, use inner capability", new Object[0]);
            return pVar;
        } catch (ClassNotFoundException e11) {
            throw new UcsException(UcsErrorCode.LACK_CAPABILITY_COMPONENT_ERROR, "Network capability not found : " + e11.getMessage());
        }
    }
}
