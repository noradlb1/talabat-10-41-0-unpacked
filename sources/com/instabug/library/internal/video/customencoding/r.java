package com.instabug.library.internal.video.customencoding;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.instabug.library.internal.video.customencoding.q;

class r extends Handler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ q f51213a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public r(q qVar, Looper looper) {
        super(looper);
        this.f51213a = qVar;
    }

    public void handleMessage(Message message) {
        int i11 = message.what;
        if (i11 == 0) {
            try {
                this.f51213a.d();
                if (this.f51213a.f51206t != null) {
                    this.f51213a.f51206t.onStart();
                    return;
                }
                return;
            } catch (Exception e11) {
                message.obj = e11;
            }
        } else if (!(i11 == 1 || i11 == 2)) {
            return;
        }
        this.f51213a.i();
        if (message.arg1 != 1) {
            this.f51213a.f();
        }
        if (this.f51213a.f51206t != null) {
            this.f51213a.f51206t.a((Throwable) message.obj);
        }
        q.a unused = this.f51213a.f51206t = null;
        this.f51213a.e();
    }
}
