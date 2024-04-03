package com.instabug.featuresrequest.utils;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.TextView;

class l extends m {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TextView f46836b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f46837c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f46838d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ String f46839e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ boolean f46840f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Runnable f46841g;

    public l(TextView textView, String str, String str2, String str3, boolean z11, Runnable runnable) {
        this.f46836b = textView;
        this.f46837c = str;
        this.f46838d = str2;
        this.f46839e = str3;
        this.f46840f = z11;
        this.f46841g = runnable;
    }

    @SuppressLint({"STARVATION"})
    public void onClick(View view) {
        n.a(this.f46836b, this.f46837c, this.f46838d, this.f46839e, !this.f46840f, this.f46841g);
        Runnable runnable = this.f46841g;
        if (runnable != null) {
            runnable.run();
        }
    }
}
