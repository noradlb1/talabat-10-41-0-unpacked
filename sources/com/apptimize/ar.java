package com.apptimize;

import android.os.Handler;
import android.os.Message;
import android.os.Messenger;

public class ar extends al {

    /* renamed from: a  reason: collision with root package name */
    private Messenger f41211a = null;

    public Messenger a() {
        if (this.f41211a == null) {
            this.f41211a = new Messenger(new Handler());
        }
        return this.f41211a;
    }

    public void a(Message message) {
    }

    public void a(Message message, boolean z11) {
    }

    public void a(String str, ft<Long> ftVar) {
    }

    public void a(String str, String str2, Object... objArr) {
    }

    public boolean a(long j11) {
        return true;
    }
}
