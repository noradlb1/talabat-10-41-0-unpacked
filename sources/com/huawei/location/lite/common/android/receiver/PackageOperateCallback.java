package com.huawei.location.lite.common.android.receiver;

public interface PackageOperateCallback {
    void onAdded(String str);

    void onRemoved(String str);

    void onReplaced(String str);
}
