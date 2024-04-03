package com.talabat.growth.ui.lifecyclevoucher;

import android.view.View;
import androidx.lifecycle.Observer;
import com.talabat.talabatcore.exception.Failure;

public final /* synthetic */ class b implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ View f60589a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LoginLifecycleVoucherView f60590b;

    public /* synthetic */ b(View view, LoginLifecycleVoucherView loginLifecycleVoucherView) {
        this.f60589a = view;
        this.f60590b = loginLifecycleVoucherView;
    }

    public final void onChanged(Object obj) {
        LoginLifecycleVoucherView$init$1.m10597invoke$lambda3$lambda2$lambda1(this.f60589a, this.f60590b, (Failure) obj);
    }
}
