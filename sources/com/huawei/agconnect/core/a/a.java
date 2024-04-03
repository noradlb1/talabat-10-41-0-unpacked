package com.huawei.agconnect.core.a;

import com.huawei.agconnect.AGCInitFinishManager;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class a extends AGCInitFinishManager {

    /* renamed from: a  reason: collision with root package name */
    private static final List<AGCInitFinishManager.AGCInitFinishCallback> f47529a = new CopyOnWriteArrayList();

    public static void a() {
        for (AGCInitFinishManager.AGCInitFinishCallback onFinish : f47529a) {
            onFinish.onFinish();
        }
    }

    public void addAGCInitFinishCallback(AGCInitFinishManager.AGCInitFinishCallback aGCInitFinishCallback) {
        if (aGCInitFinishCallback != null) {
            f47529a.add(aGCInitFinishCallback);
        }
    }
}
