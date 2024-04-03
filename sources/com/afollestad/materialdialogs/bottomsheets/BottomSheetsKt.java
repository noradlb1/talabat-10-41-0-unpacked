package com.afollestad.materialdialogs.bottomsheets;

import android.content.Context;
import android.content.res.Resources;
import androidx.annotation.CheckResult;
import androidx.annotation.DimenRes;
import androidx.annotation.IntegerRes;
import androidx.annotation.Px;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.afollestad.materialdialogs.DialogBehavior;
import com.afollestad.materialdialogs.MaterialDialog;
import com.afollestad.materialdialogs.internal.list.DialogAdapter;
import com.afollestad.materialdialogs.list.DialogListExtKt;
import com.afollestad.materialdialogs.utils.MDUtil;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0001\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0001\u001a¦\u0001\u0010\u0003\u001a\u00020\u0001\"\b\b\u0000\u0010\u0004*\u00020\u0005*\u00020\u00012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00040\u00072\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2Y\b\u0002\u0010\u000e\u001aS\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0013\u0012\u0013\u0012\u0011H\u0004¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u000fj\b\u0012\u0004\u0012\u0002H\u0004`\u0016H\u0007¢\u0006\u0002\u0010\u0017\u001a'\u0010\u0018\u001a\u00020\u0001*\u00020\u00012\n\b\u0003\u0010\u0019\u001a\u0004\u0018\u00010\t2\n\b\u0003\u0010\u001a\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\u001b\u001a$\u0010\u001c\u001a\u00020\u0001*\u00020\u00012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b*\u0001\u0010\u001d\u001a\u0004\b\u0000\u0010\u0004\"I\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0013\u0012\u0013\u0012\u0011H\u0004¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u000f2I\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0013\u0012\u0013\u0012\u0011H\u0004¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u000f¨\u0006\u001e"}, d2 = {"collapseBottomSheet", "Lcom/afollestad/materialdialogs/MaterialDialog;", "expandBottomSheet", "gridItems", "IT", "Lcom/afollestad/materialdialogs/bottomsheets/GridItem;", "items", "", "customGridWidth", "", "disabledIndices", "", "waitForPositiveButton", "", "selection", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "dialog", "index", "item", "", "Lcom/afollestad/materialdialogs/bottomsheets/GridItemListener;", "(Lcom/afollestad/materialdialogs/MaterialDialog;Ljava/util/List;Ljava/lang/Integer;[IZLkotlin/jvm/functions/Function3;)Lcom/afollestad/materialdialogs/MaterialDialog;", "setPeekHeight", "literal", "res", "(Lcom/afollestad/materialdialogs/MaterialDialog;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/afollestad/materialdialogs/MaterialDialog;", "updateGridItems", "GridItemListener", "com.afollestad.material-dialogs.bottomsheets"}, k = 2, mv = {1, 1, 15})
public final class BottomSheetsKt {
    @NotNull
    public static final MaterialDialog collapseBottomSheet(@NotNull MaterialDialog materialDialog) {
        Intrinsics.checkParameterIsNotNull(materialDialog, "$this$collapseBottomSheet");
        if (materialDialog.getDialogBehavior() instanceof BottomSheet) {
            DialogBehavior dialogBehavior = materialDialog.getDialogBehavior();
            if (dialogBehavior != null) {
                BottomSheetBehavior<?> bottomSheetBehavior$com_afollestad_material_dialogs_bottomsheets = ((BottomSheet) dialogBehavior).getBottomSheetBehavior$com_afollestad_material_dialogs_bottomsheets();
                if (bottomSheetBehavior$com_afollestad_material_dialogs_bottomsheets != null) {
                    bottomSheetBehavior$com_afollestad_material_dialogs_bottomsheets.setState(4);
                }
                return materialDialog;
            }
            throw new TypeCastException("null cannot be cast to non-null type com.afollestad.materialdialogs.bottomsheets.BottomSheet");
        }
        throw new IllegalStateException("This dialog is not a bottom sheet dialog.".toString());
    }

    @NotNull
    public static final MaterialDialog expandBottomSheet(@NotNull MaterialDialog materialDialog) {
        Intrinsics.checkParameterIsNotNull(materialDialog, "$this$expandBottomSheet");
        if (materialDialog.getDialogBehavior() instanceof BottomSheet) {
            DialogBehavior dialogBehavior = materialDialog.getDialogBehavior();
            if (dialogBehavior != null) {
                BottomSheetBehavior<?> bottomSheetBehavior$com_afollestad_material_dialogs_bottomsheets = ((BottomSheet) dialogBehavior).getBottomSheetBehavior$com_afollestad_material_dialogs_bottomsheets();
                if (bottomSheetBehavior$com_afollestad_material_dialogs_bottomsheets != null) {
                    bottomSheetBehavior$com_afollestad_material_dialogs_bottomsheets.setState(3);
                }
                return materialDialog;
            }
            throw new TypeCastException("null cannot be cast to non-null type com.afollestad.materialdialogs.bottomsheets.BottomSheet");
        }
        throw new IllegalStateException("This dialog is not a bottom sheet dialog.".toString());
    }

    @CheckResult
    @NotNull
    public static final <IT extends GridItem> MaterialDialog gridItems(@NotNull MaterialDialog materialDialog, @NotNull List<? extends IT> list, @Nullable @IntegerRes Integer num, @Nullable int[] iArr, boolean z11, @Nullable Function3<? super MaterialDialog, ? super Integer, ? super IT, Unit> function3) {
        int i11;
        Intrinsics.checkParameterIsNotNull(materialDialog, "$this$gridItems");
        Intrinsics.checkParameterIsNotNull(list, FirebaseAnalytics.Param.ITEMS);
        if (DialogListExtKt.getListAdapter(materialDialog) != null) {
            return updateGridItems(materialDialog, list, iArr);
        }
        Resources resources = materialDialog.getWindowContext().getResources();
        if (num != null) {
            i11 = num.intValue();
        } else {
            i11 = R.integer.md_grid_width;
        }
        return DialogListExtKt.customListAdapter(materialDialog, new GridIconDialogAdapter(materialDialog, list, iArr, z11, function3), new GridLayoutManager(materialDialog.getWindowContext(), resources.getInteger(i11)));
    }

    public static /* synthetic */ MaterialDialog gridItems$default(MaterialDialog materialDialog, List list, Integer num, int[] iArr, boolean z11, Function3 function3, int i11, Object obj) {
        Integer num2 = (i11 & 2) != 0 ? null : num;
        int[] iArr2 = (i11 & 4) != 0 ? null : iArr;
        if ((i11 & 8) != 0) {
            z11 = true;
        }
        return gridItems(materialDialog, list, num2, iArr2, z11, (i11 & 16) != 0 ? null : function3);
    }

    @NotNull
    public static final MaterialDialog setPeekHeight(@NotNull MaterialDialog materialDialog, @Px @Nullable Integer num, @Nullable @DimenRes Integer num2) {
        int i11;
        boolean z11;
        Intrinsics.checkParameterIsNotNull(materialDialog, "$this$setPeekHeight");
        if (materialDialog.getDialogBehavior() instanceof BottomSheet) {
            MDUtil.INSTANCE.assertOneSet("setPeekHeight", num, num2);
            DialogBehavior dialogBehavior = materialDialog.getDialogBehavior();
            if (dialogBehavior != null) {
                BottomSheet bottomSheet = (BottomSheet) dialogBehavior;
                if (num != null) {
                    i11 = num.intValue();
                } else {
                    Context context = materialDialog.getContext();
                    Intrinsics.checkExpressionValueIsNotNull(context, "context");
                    Resources resources = context.getResources();
                    if (num2 == null) {
                        Intrinsics.throwNpe();
                    }
                    i11 = resources.getDimensionPixelSize(num2.intValue());
                }
                if (bottomSheet.getMaxPeekHeight$com_afollestad_material_dialogs_bottomsheets() > 0) {
                    i11 = Math.min(bottomSheet.getMaxPeekHeight$com_afollestad_material_dialogs_bottomsheets(), i11);
                }
                int i12 = i11;
                if (i12 > 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (z11) {
                    bottomSheet.setDefaultPeekHeight$com_afollestad_material_dialogs_bottomsheets(i12);
                    BottomSheetBehavior<?> bottomSheetBehavior$com_afollestad_material_dialogs_bottomsheets = bottomSheet.getBottomSheetBehavior$com_afollestad_material_dialogs_bottomsheets();
                    if (!materialDialog.isShowing()) {
                        if (bottomSheetBehavior$com_afollestad_material_dialogs_bottomsheets == null) {
                            Intrinsics.throwNpe();
                        }
                        bottomSheetBehavior$com_afollestad_material_dialogs_bottomsheets.setPeekHeight(i12);
                    } else if (bottomSheetBehavior$com_afollestad_material_dialogs_bottomsheets != null) {
                        UtilKt.animatePeekHeight$default(bottomSheetBehavior$com_afollestad_material_dialogs_bottomsheets, materialDialog.getView(), 0, i12, 250, (Function0) null, 18, (Object) null);
                    }
                    return materialDialog;
                }
                throw new IllegalArgumentException("Peek height must be > 0.".toString());
            }
            throw new TypeCastException("null cannot be cast to non-null type com.afollestad.materialdialogs.bottomsheets.BottomSheet");
        }
        throw new IllegalStateException("This dialog is not a bottom sheet dialog.".toString());
    }

    public static /* synthetic */ MaterialDialog setPeekHeight$default(MaterialDialog materialDialog, Integer num, Integer num2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            num = null;
        }
        if ((i11 & 2) != 0) {
            num2 = null;
        }
        return setPeekHeight(materialDialog, num, num2);
    }

    @NotNull
    public static final MaterialDialog updateGridItems(@NotNull MaterialDialog materialDialog, @NotNull List<? extends GridItem> list, @Nullable int[] iArr) {
        boolean z11;
        Intrinsics.checkParameterIsNotNull(materialDialog, "$this$updateGridItems");
        Intrinsics.checkParameterIsNotNull(list, FirebaseAnalytics.Param.ITEMS);
        RecyclerView.Adapter<?> listAdapter = DialogListExtKt.getListAdapter(materialDialog);
        if (listAdapter != null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            if (listAdapter instanceof DialogAdapter) {
                DialogAdapter dialogAdapter = (DialogAdapter) listAdapter;
                DialogAdapter.DefaultImpls.replaceItems$default(dialogAdapter, list, (Object) null, 2, (Object) null);
                if (iArr != null) {
                    dialogAdapter.disableItems(iArr);
                }
            }
            return materialDialog;
        }
        throw new IllegalStateException("updateGridItems(...) can't be used before you've created a bottom sheet grid dialog.".toString());
    }

    public static /* synthetic */ MaterialDialog updateGridItems$default(MaterialDialog materialDialog, List list, int[] iArr, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            iArr = null;
        }
        return updateGridItems(materialDialog, list, iArr);
    }
}
