package com.huawei.wearengine.notify;

public interface Action {
    void onError(Notification notification, int i11, String str);

    void onResult(Notification notification, int i11);
}
