package com.huawei.location.lite.common.plug;

import android.os.Bundle;
import android.os.Parcelable;

public class PluginReqMessage {
    private String data;
    private Bundle extraBundle;
    private Parcelable parcelable;

    public String getData() {
        return this.data;
    }

    public Bundle getExtraInfo() {
        return this.extraBundle;
    }

    public Parcelable getParcelable() {
        return this.parcelable;
    }

    public void setData(String str) {
        this.data = str;
    }

    public void setExtraData(Bundle bundle) {
        this.extraBundle = bundle;
    }

    public void setParcelable(Parcelable parcelable2) {
        this.parcelable = parcelable2;
    }
}
