package com.afollestad.materialdialogs.bottomsheets;

import com.afollestad.materialdialogs.internal.button.DialogActionButtonLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "currentHeight", "", "invoke"}, k = 3, mv = {1, 1, 15})
public final class BottomSheet$setupBottomSheetBehavior$2 extends Lambda implements Function1<Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ BottomSheet f40370g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BottomSheet$setupBottomSheetBehavior$2(BottomSheet bottomSheet) {
        super(1);
        this.f40370g = bottomSheet;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Number) obj).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int i11) {
        DialogActionButtonLayout access$getButtonsLayout$p;
        DialogActionButtonLayout access$getButtonsLayout$p2 = this.f40370g.buttonsLayout;
        int measuredHeight = access$getButtonsLayout$p2 != null ? access$getButtonsLayout$p2.getMeasuredHeight() : i11 + 1;
        if (1 <= i11 && measuredHeight >= i11) {
            int i12 = measuredHeight - i11;
            DialogActionButtonLayout access$getButtonsLayout$p3 = this.f40370g.buttonsLayout;
            if (access$getButtonsLayout$p3 != null) {
                access$getButtonsLayout$p3.setTranslationY((float) i12);
            }
        } else if (i11 > 0 && (access$getButtonsLayout$p = this.f40370g.buttonsLayout) != null) {
            access$getButtonsLayout$p.setTranslationY(0.0f);
        }
        this.f40370g.invalidateDividers(i11);
    }
}
