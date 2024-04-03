package com.talabat.sdsquad.ui.collections;

import android.graphics.drawable.GradientDrawable;
import android.widget.FrameLayout;
import com.google.android.material.appbar.AppBarLayout;
import com.talabat.sdsquad.R;
import eu.h;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\bH\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0002\u0010\u0004\"\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0012"}, d2 = {"com/talabat/sdsquad/ui/collections/CollectionsFragment$onActivityCreated$2", "Lcom/google/android/material/appbar/AppBarLayout$OnOffsetChangedListener;", "isShow", "", "()Z", "setShow", "(Z)V", "scrollRange", "", "getScrollRange", "()I", "setScrollRange", "(I)V", "onOffsetChanged", "", "appBarLayout", "Lcom/google/android/material/appbar/AppBarLayout;", "verticalOffset", "com_talabat_NewArchi_sdsquad_sdsquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CollectionsFragment$onActivityCreated$2 implements AppBarLayout.OnOffsetChangedListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CollectionsFragment f61327a;
    private boolean isShow;
    private int scrollRange = -1;

    public CollectionsFragment$onActivityCreated$2(CollectionsFragment collectionsFragment) {
        this.f61327a = collectionsFragment;
    }

    /* access modifiers changed from: private */
    /* renamed from: onOffsetChanged$lambda-0  reason: not valid java name */
    public static final void m10802onOffsetChanged$lambda0(CollectionsFragment$onActivityCreated$2 collectionsFragment$onActivityCreated$2, AppBarLayout appBarLayout, int i11, CollectionsFragment collectionsFragment) {
        Intrinsics.checkNotNullParameter(collectionsFragment$onActivityCreated$2, "this$0");
        Intrinsics.checkNotNullParameter(appBarLayout, "$appBarLayout");
        Intrinsics.checkNotNullParameter(collectionsFragment, "this$1");
        if (collectionsFragment$onActivityCreated$2.scrollRange == -1) {
            collectionsFragment$onActivityCreated$2.scrollRange = appBarLayout.getTotalScrollRange();
        }
        float abs = ((float) Math.abs(i11)) / ((float) appBarLayout.getTotalScrollRange());
        int i12 = (int) (((float) 22) * collectionsFragment.getResources().getDisplayMetrics().density);
        int i13 = R.id.toolbar;
        ((FrameLayout) collectionsFragment._$_findCachedViewById(i13)).setTranslationY(abs * ((float) i12));
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(-1);
        ((FrameLayout) collectionsFragment._$_findCachedViewById(i13)).setBackground(gradientDrawable);
        if (collectionsFragment$onActivityCreated$2.scrollRange + i11 == 0) {
            ((AppBarLayout) collectionsFragment._$_findCachedViewById(R.id.appbarLayout)).setBackgroundColor(collectionsFragment.getResources().getColor(com.designsystem.marshmallow.R.color.ds_secondary_10));
            collectionsFragment$onActivityCreated$2.isShow = true;
        } else if (collectionsFragment$onActivityCreated$2.isShow) {
            ((AppBarLayout) collectionsFragment._$_findCachedViewById(R.id.appbarLayout)).setBackgroundColor(collectionsFragment.getResources().getColor(com.talabat.talabatcommon.R.color.app_background));
            collectionsFragment$onActivityCreated$2.isShow = false;
        }
    }

    public final int getScrollRange() {
        return this.scrollRange;
    }

    public final boolean isShow() {
        return this.isShow;
    }

    public void onOffsetChanged(@NotNull AppBarLayout appBarLayout, int i11) {
        Intrinsics.checkNotNullParameter(appBarLayout, "appBarLayout");
        ((AppBarLayout) this.f61327a._$_findCachedViewById(R.id.appbarLayout)).post(new h(this, appBarLayout, i11, this.f61327a));
    }

    public final void setScrollRange(int i11) {
        this.scrollRange = i11;
    }

    public final void setShow(boolean z11) {
        this.isShow = z11;
    }
}
