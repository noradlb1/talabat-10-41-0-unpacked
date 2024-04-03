package com.jakewharton.rxbinding3.view;

import android.view.View;
import androidx.annotation.CheckResult;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u001a\u001e\u0010\u0000\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00020\u0001*\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0007¨\u0006\u0006"}, d2 = {"visibility", "Lio/reactivex/functions/Consumer;", "", "Landroid/view/View;", "visibilityWhenFalse", "", "rxbinding_release"}, k = 5, mv = {1, 1, 15}, xs = "com/jakewharton/rxbinding3/view/RxView")
final /* synthetic */ class RxView__ViewVisibilityConsumerKt {
    @CheckResult
    @NotNull
    @JvmOverloads
    public static final Consumer<? super Boolean> visibility(@NotNull View view) {
        return visibility$default(view, 0, 1, (Object) null);
    }

    @CheckResult
    @NotNull
    @JvmOverloads
    public static final Consumer<? super Boolean> visibility(@NotNull View view, int i11) {
        boolean z11;
        Intrinsics.checkParameterIsNotNull(view, "$this$visibility");
        boolean z12 = true;
        if (i11 != 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            if (!(i11 == 4 || i11 == 8)) {
                z12 = false;
            }
            if (z12) {
                return new RxView__ViewVisibilityConsumerKt$visibility$3(view, i11);
            }
            throw new IllegalArgumentException("Must set visibility to INVISIBLE or GONE when false.".toString());
        }
        throw new IllegalArgumentException("Setting visibility to VISIBLE when false would have no effect.".toString());
    }

    public static /* synthetic */ Consumer visibility$default(View view, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i11 = 8;
        }
        return RxView.visibility(view, i11);
    }
}
