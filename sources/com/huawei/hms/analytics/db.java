package com.huawei.hms.analytics;

import android.os.Bundle;

public final class db extends de {
    private String ijk;
    public String klm;
    public String lmn;

    public db() {
    }

    public db(String str) {
        this.ijk = str;
    }

    public db(String str, String str2) {
        super(str2);
        this.ijk = str;
    }

    public final Bundle lmn() {
        Bundle klm2 = klm();
        String str = this.lmn;
        String str2 = "";
        if (str == null) {
            str = str2;
        }
        klm2.putString("$TrackId", str);
        String str3 = this.ijk;
        if (str3 == null) {
            str3 = str2;
        }
        klm2.putString("$ChannelType", str3);
        String str4 = this.klm;
        if (str4 != null) {
            str2 = str4;
        }
        klm2.putString("$TrackClickTime", str2);
        return klm2;
    }
}
