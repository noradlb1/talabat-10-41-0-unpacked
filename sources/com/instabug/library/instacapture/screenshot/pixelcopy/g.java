package com.instabug.library.instacapture.screenshot.pixelcopy;

import android.view.View;
import java.util.HashMap;
import java.util.Map;

class g implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ HashMap f34405b;

    public g(HashMap hashMap) {
        this.f34405b = hashMap;
    }

    public void run() {
        HashMap hashMap = this.f34405b;
        if (hashMap != null && hashMap.size() != 0) {
            for (Map.Entry entry : this.f34405b.entrySet()) {
                ((View) entry.getKey()).setVisibility(((Integer) entry.getValue()).intValue());
            }
        }
    }
}
