package com.instabug.chat.notification;

import com.instabug.library.InstabugState;
import io.reactivex.functions.Consumer;

class e implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ s f46109b;

    public e(s sVar) {
        this.f46109b = sVar;
    }

    /* renamed from: a */
    public void accept(InstabugState instabugState) {
        if (instabugState == InstabugState.DISABLED) {
            this.f46109b.a();
            this.f46109b.b();
            if (this.f46109b.f46136f != null) {
                this.f46109b.f46136f.a();
            }
        }
    }
}
