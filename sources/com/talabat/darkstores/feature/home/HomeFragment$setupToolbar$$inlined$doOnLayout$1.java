package com.talabat.darkstores.feature.home;

import android.view.View;
import androidx.appcompat.widget.Toolbar;
import com.talabat.darkstores.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JP\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0007H\u0016¨\u0006\u000f¸\u0006\u0010"}, d2 = {"androidx/core/view/ViewKt$doOnNextLayout$1", "Landroid/view/View$OnLayoutChangeListener;", "onLayoutChange", "", "view", "Landroid/view/View;", "left", "", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "core-ktx_release", "androidx/core/view/ViewKt$doOnLayout$$inlined$doOnNextLayout$1"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class HomeFragment$setupToolbar$$inlined$doOnLayout$1 implements View.OnLayoutChangeListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ HomeFragment f56377b;

    public HomeFragment$setupToolbar$$inlined$doOnLayout$1(HomeFragment homeFragment) {
        this.f56377b = homeFragment;
    }

    public void onLayoutChange(@NotNull View view, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18) {
        int i19;
        Intrinsics.checkNotNullParameter(view, "view");
        view.removeOnLayoutChangeListener(this);
        Toolbar toolbar = (Toolbar) this.f56377b._$_findCachedViewById(R.id.toolbar);
        Intrinsics.checkNotNullExpressionValue(toolbar, "toolbar");
        int childCount = toolbar.getChildCount();
        int i21 = 0;
        int i22 = 0;
        for (int i23 = 0; i23 < childCount; i23++) {
            View childAt = toolbar.getChildAt(i23);
            Intrinsics.checkNotNullExpressionValue(childAt, "getChildAt(index)");
            i22 += childAt.getWidth();
        }
        HomeFragment homeFragment = this.f56377b;
        int i24 = R.id.toolbar;
        int width = ((Toolbar) homeFragment._$_findCachedViewById(i24)).getWidth() - i22;
        View access$getNavigationIconView = this.f56377b.getNavigationIconView();
        if (access$getNavigationIconView != null) {
            i19 = access$getNavigationIconView.getWidth();
        } else {
            i19 = 0;
        }
        View access$getSearchIconView = this.f56377b.getSearchIconView();
        if (access$getSearchIconView != null) {
            i21 = access$getSearchIconView.getWidth();
        }
        ((Toolbar) this.f56377b._$_findCachedViewById(i24)).setTitleMargin((-width) - (i19 - i21), ((Toolbar) this.f56377b._$_findCachedViewById(i24)).getTitleMarginTop(), ((Toolbar) this.f56377b._$_findCachedViewById(i24)).getTitleMarginEnd(), ((Toolbar) this.f56377b._$_findCachedViewById(i24)).getTitleMarginBottom());
    }
}
