package com.instabug.chat.notification;

import android.view.View;

class j implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ s f46118b;

    public j(s sVar) {
        this.f46118b = sVar;
    }

    public void onClick(View view) {
        this.f46118b.a();
        this.f46118b.a(false);
        if (this.f46118b.f46136f != null) {
            this.f46118b.f46136f.b();
        }
    }
}
