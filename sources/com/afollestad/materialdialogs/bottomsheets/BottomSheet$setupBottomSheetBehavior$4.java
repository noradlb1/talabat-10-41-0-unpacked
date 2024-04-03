package com.afollestad.materialdialogs.bottomsheets;

import android.view.ViewGroup;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroid/view/ViewGroup;", "invoke"}, k = 3, mv = {1, 1, 15})
public final class BottomSheet$setupBottomSheetBehavior$4 extends Lambda implements Function1<ViewGroup, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ BottomSheet f40372g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BottomSheet$setupBottomSheetBehavior$4(BottomSheet bottomSheet) {
        super(1);
        this.f40372g = bottomSheet;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ViewGroup) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull ViewGroup viewGroup) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "$receiver");
        BottomSheet bottomSheet = this.f40372g;
        bottomSheet.setActualPeekHeight(Math.min(bottomSheet.getDefaultPeekHeight$com_afollestad_material_dialogs_bottomsheets(), Math.min(viewGroup.getMeasuredHeight(), this.f40372g.getDefaultPeekHeight$com_afollestad_material_dialogs_bottomsheets())));
    }
}
