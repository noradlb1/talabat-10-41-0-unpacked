package com.huawei.hms.push;

import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

public class e extends Handler {

    /* renamed from: a  reason: collision with root package name */
    private WeakReference<a> f49741a;

    public interface a {
        void a(Message message);
    }

    public e(a aVar) {
        this.f49741a = new WeakReference<>(aVar);
    }

    public void handleMessage(Message message) {
        super.handleMessage(message);
        a aVar = this.f49741a.get();
        if (aVar != null) {
            aVar.a(message);
        }
    }
}
