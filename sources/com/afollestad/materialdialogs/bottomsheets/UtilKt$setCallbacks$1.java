package com.afollestad.materialdialogs.bottomsheets;

import android.view.View;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0003H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"com/afollestad/materialdialogs/bottomsheets/UtilKt$setCallbacks$1", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior$BottomSheetCallback;", "currentState", "", "onSlide", "", "view", "Landroid/view/View;", "dY", "", "onStateChanged", "state", "com.afollestad.material-dialogs.bottomsheets"}, k = 1, mv = {1, 1, 15})
public final class UtilKt$setCallbacks$1 extends BottomSheetBehavior.BottomSheetCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BottomSheetBehavior f40385a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Function1 f40386b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Function0 f40387c;
    private int currentState = 4;

    public UtilKt$setCallbacks$1(BottomSheetBehavior<?> bottomSheetBehavior, Function1 function1, Function0 function0) {
        this.f40385a = bottomSheetBehavior;
        this.f40386b = function1;
        this.f40387c = function0;
    }

    public void onSlide(@NotNull View view, float f11) {
        Intrinsics.checkParameterIsNotNull(view, "view");
        if (this.f40385a.getState() != 5) {
            if (Float.isNaN(f11)) {
                f11 = 0.0f;
            }
            if (f11 > 0.0f) {
                this.f40386b.invoke(Integer.valueOf((int) (((float) this.f40385a.getPeekHeight()) + (((float) this.f40385a.getPeekHeight()) * Math.abs(f11)))));
                return;
            }
            this.f40386b.invoke(Integer.valueOf((int) (((float) this.f40385a.getPeekHeight()) - (((float) this.f40385a.getPeekHeight()) * Math.abs(f11)))));
        }
    }

    public void onStateChanged(@NotNull View view, int i11) {
        Intrinsics.checkParameterIsNotNull(view, "view");
        this.currentState = i11;
        if (i11 == 5) {
            this.f40387c.invoke();
        }
    }
}
