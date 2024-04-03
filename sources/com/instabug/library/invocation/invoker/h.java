package com.instabug.library.invocation.invoker;

import android.app.Activity;
import android.view.View;
import com.instabug.library.util.KeyboardUtils;

class h implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Activity f51343b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ p f51344c;

    public h(p pVar, Activity activity) {
        this.f51344c = pVar;
        this.f51343b = activity;
    }

    public void onClick(View view) {
        if (this.f51344c.f51372k) {
            KeyboardUtils.hide(this.f51343b);
            if (this.f51344c.B != null) {
                this.f51344c.B.stop(this.f51344c.d());
            }
            boolean unused = this.f51344c.f51372k = false;
            this.f51344c.f51384w.removeCallbacks(this.f51344c.F);
        }
    }
}
