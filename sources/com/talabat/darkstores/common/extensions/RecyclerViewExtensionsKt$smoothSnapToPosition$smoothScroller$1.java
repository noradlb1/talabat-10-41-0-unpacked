package com.talabat.darkstores.common.extensions;

import android.content.Context;
import android.util.DisplayMetrics;
import androidx.recyclerview.widget.LinearSmoothScroller;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0014J\b\u0010\u0006\u001a\u00020\u0007H\u0014J\b\u0010\b\u001a\u00020\u0007H\u0014¨\u0006\t"}, d2 = {"com/talabat/darkstores/common/extensions/RecyclerViewExtensionsKt$smoothSnapToPosition$smoothScroller$1", "Landroidx/recyclerview/widget/LinearSmoothScroller;", "calculateSpeedPerPixel", "", "displayMetrics", "Landroid/util/DisplayMetrics;", "getHorizontalSnapPreference", "", "getVerticalSnapPreference", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RecyclerViewExtensionsKt$smoothSnapToPosition$smoothScroller$1 extends LinearSmoothScroller {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f56134a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ float f56135b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RecyclerViewExtensionsKt$smoothSnapToPosition$smoothScroller$1(int i11, float f11, Context context) {
        super(context);
        this.f56134a = i11;
        this.f56135b = f11;
    }

    public float calculateSpeedPerPixel(@NotNull DisplayMetrics displayMetrics) {
        Intrinsics.checkNotNullParameter(displayMetrics, "displayMetrics");
        return super.calculateSpeedPerPixel(displayMetrics) / this.f56135b;
    }

    public int getHorizontalSnapPreference() {
        return this.f56134a;
    }

    public int getVerticalSnapPreference() {
        return this.f56134a;
    }
}
