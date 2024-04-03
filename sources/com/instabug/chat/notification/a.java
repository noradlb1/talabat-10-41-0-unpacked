package com.instabug.chat.notification;

import android.animation.Animator;
import android.view.View;

class a extends p {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ View f46105a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(s sVar, View view) {
        super(sVar, (e) null);
        this.f46105a = view;
    }

    public void onAnimationEnd(Animator animator) {
        this.f46105a.setVisibility(4);
    }
}
