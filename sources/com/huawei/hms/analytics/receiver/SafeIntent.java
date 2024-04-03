package com.huawei.hms.analytics.receiver;

import android.content.Intent;
import android.os.Bundle;

public class SafeIntent extends Intent {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SafeIntent(Intent intent) {
        super(intent == null ? new Intent() : intent);
    }

    public String getAction() {
        try {
            String action = super.getAction();
            return action == null ? "" : action;
        } catch (Throwable unused) {
            return "";
        }
    }

    public Bundle getExtras() {
        try {
            Bundle extras = super.getExtras();
            return extras == null ? new Bundle() : extras;
        } catch (Throwable unused) {
            return new Bundle();
        }
    }

    public final boolean lmn() {
        try {
            getStringExtra("ANYTHING");
            return false;
        } catch (Throwable unused) {
            return true;
        }
    }
}
