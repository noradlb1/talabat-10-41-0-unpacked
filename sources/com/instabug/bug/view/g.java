package com.instabug.bug.view;

import android.view.View;
import com.instabug.library.model.Attachment;

class g implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ View f45840b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Attachment f45841c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ l f45842d;

    public g(l lVar, View view, Attachment attachment) {
        this.f45842d = lVar;
        this.f45840b = view;
        this.f45841c = attachment;
    }

    public void onClick(View view) {
        this.f45842d.f45858d.a(this.f45840b, this.f45841c);
    }
}
