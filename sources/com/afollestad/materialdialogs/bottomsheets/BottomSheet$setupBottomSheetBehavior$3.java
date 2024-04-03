package com.afollestad.materialdialogs.bottomsheets;

import com.afollestad.materialdialogs.MaterialDialog;
import com.afollestad.materialdialogs.internal.button.DialogActionButtonLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 1, 15})
public final class BottomSheet$setupBottomSheetBehavior$3 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ BottomSheet f40371g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BottomSheet$setupBottomSheetBehavior$3(BottomSheet bottomSheet) {
        super(0);
        this.f40371g = bottomSheet;
    }

    public final void invoke() {
        DialogActionButtonLayout access$getButtonsLayout$p = this.f40371g.buttonsLayout;
        if (access$getButtonsLayout$p != null) {
            access$getButtonsLayout$p.setVisibility(8);
        }
        MaterialDialog access$getDialog$p = this.f40371g.dialog;
        if (access$getDialog$p != null) {
            access$getDialog$p.dismiss();
        }
    }
}
