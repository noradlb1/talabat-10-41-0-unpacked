package com.instabug.featuresrequest.utils;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.TextView;

class k extends m {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TextView f46830b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f46831c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f46832d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ String f46833e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ boolean f46834f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Runnable f46835g;

    public k(TextView textView, String str, String str2, String str3, boolean z11, Runnable runnable) {
        this.f46830b = textView;
        this.f46831c = str;
        this.f46832d = str2;
        this.f46833e = str3;
        this.f46834f = z11;
        this.f46835g = runnable;
    }

    @SuppressLint({"STARVATION"})
    public void onClick(View view) {
        n.a(this.f46830b, this.f46831c, this.f46832d, this.f46833e, !this.f46834f, this.f46835g);
        Runnable runnable = this.f46835g;
        if (runnable != null) {
            runnable.run();
        }
    }
}
