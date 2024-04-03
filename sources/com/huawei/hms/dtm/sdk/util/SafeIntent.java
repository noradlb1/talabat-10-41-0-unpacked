package com.huawei.hms.dtm.sdk.util;

import android.content.Intent;

public class SafeIntent extends Intent {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SafeIntent(Intent intent) {
        super(intent == null ? new Intent() : intent);
    }

    public String getAction() {
        try {
            return super.getAction();
        } catch (Throwable unused) {
            return "";
        }
    }
}
