package com.instabug.chat.ui.chats;

import com.instabug.chat.notification.v;
import com.instabug.library.Instabug;
import java.util.List;

class i implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ List f46274b;

    public i(k kVar, List list) {
        this.f46274b = list;
    }

    public void run() {
        if (Instabug.getApplicationContext() != null) {
            v.a().a(Instabug.getApplicationContext(), this.f46274b);
        }
    }
}
