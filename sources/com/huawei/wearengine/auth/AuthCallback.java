package com.huawei.wearengine.auth;

public interface AuthCallback {
    void onCancel();

    void onOk(Permission[] permissionArr);
}
