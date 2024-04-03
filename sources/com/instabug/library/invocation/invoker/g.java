package com.instabug.library.invocation.invoker;

import android.annotation.SuppressLint;
import io.reactivex.functions.Consumer;

class g implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ p f51342b;

    public g(p pVar) {
        this.f51342b = pVar;
    }

    @SuppressLint({"NULL_DEREFERENCE"})
    /* renamed from: a */
    public void accept(Boolean bool) {
        if (this.f51342b.f51377p != null) {
            this.f51342b.f51377p.setEnabled(bool.booleanValue());
        }
    }
}
