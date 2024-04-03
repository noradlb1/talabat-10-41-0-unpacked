package com.designsystem.ds_bottom_sheet_v2;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.designsystem.ds_fixed_footer.DSBaseFixedFooter;
import com.designsystem.ds_navigation_bar.DSNavigationBar;
import com.designsystem.marshmallow.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JP\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0007H\u0016¨\u0006\u000f¸\u0006\u0010"}, d2 = {"androidx/core/view/ViewKt$doOnNextLayout$1", "Landroid/view/View$OnLayoutChangeListener;", "onLayoutChange", "", "view", "Landroid/view/View;", "left", "", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "core-ktx_release", "androidx/core/view/ViewKt$doOnLayout$$inlined$doOnNextLayout$1"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class BottomSheet$adjustContentMargins$$inlined$doOnLayout$1 implements View.OnLayoutChangeListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ BottomSheet f30591b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f30592c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f30593d;

    public BottomSheet$adjustContentMargins$$inlined$doOnLayout$1(BottomSheet bottomSheet, int i11, int i12) {
        this.f30591b = bottomSheet;
        this.f30592c = i11;
        this.f30593d = i12;
    }

    public void onLayoutChange(@NotNull View view, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18) {
        Integer num;
        Integer num2;
        Integer num3;
        Integer num4;
        int i19;
        int i21;
        Intrinsics.checkNotNullParameter(view, "view");
        view.removeOnLayoutChangeListener(this);
        DSNavigationBar navigationBar = this.f30591b.getNavigationBar();
        View view2 = null;
        if (navigationBar == null) {
            num = null;
        } else {
            num = Integer.valueOf(navigationBar.getHeight());
        }
        if (num == null) {
            num2 = 0;
        } else {
            DSNavigationBar navigationBar2 = this.f30591b.getNavigationBar();
            if (navigationBar2 == null) {
                num2 = null;
            } else {
                num2 = Integer.valueOf(navigationBar2.getHeight() - this.f30592c);
            }
        }
        DSBaseFixedFooter footer = this.f30591b.getFooter();
        if (footer == null) {
            num3 = null;
        } else {
            num3 = Integer.valueOf(footer.getHeight());
        }
        if (num3 == null) {
            num4 = 0;
        } else {
            DSBaseFixedFooter footer2 = this.f30591b.getFooter();
            if (footer2 == null) {
                num4 = null;
            } else {
                num4 = Integer.valueOf(footer2.getHeight() - this.f30593d);
            }
        }
        View view3 = this.f30591b.getView();
        if (view3 != null) {
            view2 = view3.findViewById(R.id.dsBottomSheetBodyFragmentContainer);
        }
        Intrinsics.checkNotNullExpressionValue(view2, "dsBottomSheetBodyFragmentContainer");
        ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
        if (layoutParams != null) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            if (num2 == null) {
                i19 = 0;
            } else {
                i19 = num2.intValue();
            }
            if (num4 == null) {
                i21 = 0;
            } else {
                i21 = num4.intValue();
            }
            layoutParams2.setMargins(0, i19, 0, i21);
            view2.setLayoutParams(layoutParams2);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
    }
}
