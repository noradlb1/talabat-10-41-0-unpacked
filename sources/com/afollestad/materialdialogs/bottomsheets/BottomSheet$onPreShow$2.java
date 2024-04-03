package com.afollestad.materialdialogs.bottomsheets;

import android.view.ViewGroup;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroid/view/ViewGroup;", "invoke"}, k = 3, mv = {1, 1, 15})
public final class BottomSheet$onPreShow$2 extends Lambda implements Function1<ViewGroup, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ BottomSheet f40368g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BottomSheet$onPreShow$2(BottomSheet bottomSheet) {
        super(1);
        this.f40368g = bottomSheet;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ViewGroup) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull ViewGroup viewGroup) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "$receiver");
        BottomSheetBehavior<?> bottomSheetBehavior$com_afollestad_material_dialogs_bottomsheets = this.f40368g.getBottomSheetBehavior$com_afollestad_material_dialogs_bottomsheets();
        if (bottomSheetBehavior$com_afollestad_material_dialogs_bottomsheets != null) {
            bottomSheetBehavior$com_afollestad_material_dialogs_bottomsheets.setPeekHeight(0);
        }
        BottomSheetBehavior<?> bottomSheetBehavior$com_afollestad_material_dialogs_bottomsheets2 = this.f40368g.getBottomSheetBehavior$com_afollestad_material_dialogs_bottomsheets();
        if (bottomSheetBehavior$com_afollestad_material_dialogs_bottomsheets2 != null) {
            bottomSheetBehavior$com_afollestad_material_dialogs_bottomsheets2.setState(4);
        }
        BottomSheetBehavior<?> bottomSheetBehavior$com_afollestad_material_dialogs_bottomsheets3 = this.f40368g.getBottomSheetBehavior$com_afollestad_material_dialogs_bottomsheets();
        if (bottomSheetBehavior$com_afollestad_material_dialogs_bottomsheets3 != null) {
            ViewGroup access$getBottomSheetView$p = this.f40368g.bottomSheetView;
            if (access$getBottomSheetView$p == null) {
                Intrinsics.throwNpe();
            }
            UtilKt.animatePeekHeight(bottomSheetBehavior$com_afollestad_material_dialogs_bottomsheets3, access$getBottomSheetView$p, 0, this.f40368g.getActualPeekHeight(), 250, new Function0<Unit>(this) {

                /* renamed from: g  reason: collision with root package name */
                public final /* synthetic */ BottomSheet$onPreShow$2 f40369g;

                {
                    this.f40369g = r1;
                }

                public final void invoke() {
                    BottomSheet bottomSheet = this.f40369g.f40368g;
                    bottomSheet.invalidateDividers(bottomSheet.getActualPeekHeight());
                }
            });
        }
        this.f40368g.showButtons();
    }
}
