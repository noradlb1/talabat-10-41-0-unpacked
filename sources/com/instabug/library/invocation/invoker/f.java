package com.instabug.library.invocation.invoker;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import com.instabug.library.Instabug;
import com.instabug.library.util.l;

class f implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ p f51341b;

    public f(p pVar) {
        this.f51341b = pVar;
    }

    @SuppressLint({"NULL_DEREFERENCE"})
    public void onClick(View view) {
        Context applicationContext = Instabug.getApplicationContext();
        if (applicationContext == null) {
            return;
        }
        if (this.f51341b.f51376o == null || !this.f51341b.f51376o.f()) {
            l.a(applicationContext);
            boolean unused = this.f51341b.f51375n = true;
            return;
        }
        l.b(applicationContext);
        boolean unused2 = this.f51341b.f51375n = false;
    }
}
