package com.checkout.frames.utils.extensions;

import android.view.View;
import android.view.ViewTreeObserver;
import androidx.compose.runtime.ProduceStateScope;

public final /* synthetic */ class a implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ProduceStateScope f44269b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ View f44270c;

    public /* synthetic */ a(ProduceStateScope produceStateScope, View view) {
        this.f44269b = produceStateScope;
        this.f44270c = view;
    }

    public final void onGlobalLayout() {
        ModifierExtensionsKt$rememberKeyboardOpenState$1$1.m9327invokeSuspend$lambda0(this.f44269b, this.f44270c);
    }
}
