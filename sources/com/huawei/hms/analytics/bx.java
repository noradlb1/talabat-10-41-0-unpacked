package com.huawei.hms.analytics;

import android.content.Context;
import android.os.Build;
import com.huawei.hms.analytics.core.log.HiLog;
import com.huawei.hms.analytics.framework.config.CipherType;
import com.huawei.hms.analytics.framework.config.IMandatoryParameters;

public final class bx implements IMandatoryParameters {
    public final String getAppVer() {
        return av.lmn().lmn.klm;
    }

    public final CipherType getCipherType() {
        return CipherType.AESGCM;
    }

    public final Context getContext() {
        return av.lmn().lmn.ghi;
    }

    public final String getLoadWorkKey() {
        return bs.lmn().klm();
    }

    public final String getModel() {
        return Build.MODEL;
    }

    public final String getPubKeyVersion(String str) {
        return av.lmn().lmn.lmn(str);
    }

    public final byte[] getRsaPublicKey(String str) {
        String str2 = av.lmn().lmn.f47859f.get(str);
        if (str2 == null || str2.isEmpty()) {
            return new byte[0];
        }
        byte[] bArr = new byte[0];
        try {
            return dj.lmn(str2);
        } catch (Exception unused) {
            HiLog.e("OpennessDutyParams", "decode failed");
            return bArr;
        }
    }
}
