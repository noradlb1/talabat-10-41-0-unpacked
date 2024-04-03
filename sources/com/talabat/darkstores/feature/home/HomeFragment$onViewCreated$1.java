package com.talabat.darkstores.feature.home;

import android.view.View;
import android.view.ViewTreeObserver;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/talabat/darkstores/feature/home/HomeFragment$onViewCreated$1", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class HomeFragment$onViewCreated$1 implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ View f56398b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ HomeFragment f56399c;

    public HomeFragment$onViewCreated$1(View view, HomeFragment homeFragment) {
        this.f56398b = view;
        this.f56399c = homeFragment;
    }

    public void onGlobalLayout() {
        this.f56398b.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        this.f56399c.getViewModel().onFirstLayout();
    }
}
