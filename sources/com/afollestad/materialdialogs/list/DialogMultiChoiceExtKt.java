package com.afollestad.materialdialogs.list;

import android.util.Log;
import androidx.annotation.ArrayRes;
import androidx.annotation.CheckResult;
import androidx.recyclerview.widget.RecyclerView;
import com.afollestad.materialdialogs.MaterialDialog;
import com.afollestad.materialdialogs.WhichButton;
import com.afollestad.materialdialogs.actions.DialogActionExtKt;
import com.afollestad.materialdialogs.internal.list.DialogAdapter;
import com.afollestad.materialdialogs.internal.list.MultiChoiceDialogAdapter;
import com.afollestad.materialdialogs.utils.MDUtil;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\u0012\u0010\u0003\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0005\u001a´\u0001\u0010\u0006\u001a\u00020\u0002*\u00020\u00022\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2Y\b\u0002\u0010\u0011\u001aS\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0004\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0012j\u0002`\u0016H\u0007¢\u0006\u0002\u0010\u0017\u001a\n\u0010\u0018\u001a\u00020\u0001*\u00020\u0002\u001a\u0012\u0010\u0019\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0005\u001a\n\u0010\u001a\u001a\u00020\u0001*\u00020\u0002\u001a\u0012\u0010\u001b\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u0001\u0010\u001c\u001a\u00020\u0002*\u00020\u00022\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052Y\b\u0002\u0010\u0011\u001aS\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0004\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0012j\u0002`\u0016¢\u0006\u0002\u0010\u001d¨\u0006\u001e"}, d2 = {"checkAllItems", "", "Lcom/afollestad/materialdialogs/MaterialDialog;", "checkItems", "indices", "", "listItemsMultiChoice", "res", "", "items", "", "", "disabledIndices", "initialSelection", "waitForPositiveButton", "", "allowEmptySelection", "selection", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "dialog", "Lcom/afollestad/materialdialogs/list/MultiChoiceListener;", "(Lcom/afollestad/materialdialogs/MaterialDialog;Ljava/lang/Integer;Ljava/util/List;[I[IZZLkotlin/jvm/functions/Function3;)Lcom/afollestad/materialdialogs/MaterialDialog;", "toggleAllItemsChecked", "toggleItemsChecked", "uncheckAllItems", "uncheckItems", "updateListItemsMultiChoice", "(Lcom/afollestad/materialdialogs/MaterialDialog;Ljava/lang/Integer;Ljava/util/List;[ILkotlin/jvm/functions/Function3;)Lcom/afollestad/materialdialogs/MaterialDialog;", "com.afollestad.material-dialogs.core"}, k = 2, mv = {1, 1, 15})
public final class DialogMultiChoiceExtKt {
    public static final void checkAllItems(@NotNull MaterialDialog materialDialog) {
        String str;
        Intrinsics.checkParameterIsNotNull(materialDialog, "$this$checkAllItems");
        RecyclerView.Adapter<?> listAdapter = DialogListExtKt.getListAdapter(materialDialog);
        if (listAdapter instanceof DialogAdapter) {
            ((DialogAdapter) listAdapter).checkAllItems();
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Can't check all items on adapter: ");
        if (listAdapter != null) {
            str = listAdapter.getClass().getName();
        } else {
            str = "null";
        }
        sb2.append(str);
        throw new UnsupportedOperationException(sb2.toString());
    }

    public static final void checkItems(@NotNull MaterialDialog materialDialog, @NotNull int[] iArr) {
        String str;
        Intrinsics.checkParameterIsNotNull(materialDialog, "$this$checkItems");
        Intrinsics.checkParameterIsNotNull(iArr, "indices");
        RecyclerView.Adapter<?> listAdapter = DialogListExtKt.getListAdapter(materialDialog);
        if (listAdapter instanceof DialogAdapter) {
            ((DialogAdapter) listAdapter).checkItems(iArr);
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Can't check items on adapter: ");
        if (listAdapter != null) {
            str = listAdapter.getClass().getName();
        } else {
            str = "null";
        }
        sb2.append(str);
        throw new UnsupportedOperationException(sb2.toString());
    }

    @CheckResult
    @NotNull
    public static final MaterialDialog listItemsMultiChoice(@NotNull MaterialDialog materialDialog, @Nullable @ArrayRes Integer num, @Nullable List<? extends CharSequence> list, @Nullable int[] iArr, @NotNull int[] iArr2, boolean z11, boolean z12, @Nullable Function3<? super MaterialDialog, ? super int[], ? super List<? extends CharSequence>, Unit> function3) {
        List<? extends CharSequence> list2;
        boolean z13;
        MaterialDialog materialDialog2 = materialDialog;
        Integer num2 = num;
        List<? extends CharSequence> list3 = list;
        int[] iArr3 = iArr2;
        Intrinsics.checkParameterIsNotNull(materialDialog, "$this$listItemsMultiChoice");
        Intrinsics.checkParameterIsNotNull(iArr2, "initialSelection");
        MDUtil mDUtil = MDUtil.INSTANCE;
        mDUtil.assertOneSet("listItemsMultiChoice", list, num);
        if (list3 != null) {
            list2 = list3;
        } else {
            list2 = ArraysKt___ArraysKt.toList((T[]) mDUtil.getStringArray(materialDialog.getWindowContext(), num));
        }
        if (DialogListExtKt.getListAdapter(materialDialog) != null) {
            Log.w("MaterialDialogs", "Prefer calling updateListItemsMultiChoice(...) over listItemsMultiChoice(...) again.");
            int[] iArr4 = iArr;
            return updateListItemsMultiChoice(materialDialog, num, list, iArr, function3);
        }
        int[] iArr5 = iArr;
        Function3<? super MaterialDialog, ? super int[], ? super List<? extends CharSequence>, Unit> function32 = function3;
        WhichButton whichButton = WhichButton.POSITIVE;
        boolean z14 = true;
        if (!z12) {
            if (iArr3.length == 0) {
                z13 = true;
            } else {
                z13 = false;
            }
            if (!(!z13)) {
                z14 = false;
            }
        }
        DialogActionExtKt.setActionButtonEnabled(materialDialog, whichButton, z14);
        return DialogListExtKt.customListAdapter$default(materialDialog, new MultiChoiceDialogAdapter(materialDialog, list2, iArr, iArr2, z11, z12, function3), (RecyclerView.LayoutManager) null, 2, (Object) null);
    }

    public static /* synthetic */ MaterialDialog listItemsMultiChoice$default(MaterialDialog materialDialog, Integer num, List list, int[] iArr, int[] iArr2, boolean z11, boolean z12, Function3 function3, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            num = null;
        }
        if ((i11 & 2) != 0) {
            list = null;
        }
        if ((i11 & 4) != 0) {
            iArr = null;
        }
        if ((i11 & 8) != 0) {
            iArr2 = new int[0];
        }
        if ((i11 & 16) != 0) {
            z11 = true;
        }
        if ((i11 & 32) != 0) {
            z12 = false;
        }
        if ((i11 & 64) != 0) {
            function3 = null;
        }
        return listItemsMultiChoice(materialDialog, num, list, iArr, iArr2, z11, z12, function3);
    }

    public static final void toggleAllItemsChecked(@NotNull MaterialDialog materialDialog) {
        String str;
        Intrinsics.checkParameterIsNotNull(materialDialog, "$this$toggleAllItemsChecked");
        RecyclerView.Adapter<?> listAdapter = DialogListExtKt.getListAdapter(materialDialog);
        if (listAdapter instanceof DialogAdapter) {
            ((DialogAdapter) listAdapter).toggleAllChecked();
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Can't uncheck all items on adapter: ");
        if (listAdapter != null) {
            str = listAdapter.getClass().getName();
        } else {
            str = "null";
        }
        sb2.append(str);
        throw new UnsupportedOperationException(sb2.toString());
    }

    public static final void toggleItemsChecked(@NotNull MaterialDialog materialDialog, @NotNull int[] iArr) {
        String str;
        Intrinsics.checkParameterIsNotNull(materialDialog, "$this$toggleItemsChecked");
        Intrinsics.checkParameterIsNotNull(iArr, "indices");
        RecyclerView.Adapter<?> listAdapter = DialogListExtKt.getListAdapter(materialDialog);
        if (listAdapter instanceof DialogAdapter) {
            ((DialogAdapter) listAdapter).toggleItems(iArr);
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Can't toggle checked items on adapter: ");
        if (listAdapter != null) {
            str = listAdapter.getClass().getName();
        } else {
            str = "null";
        }
        sb2.append(str);
        throw new UnsupportedOperationException(sb2.toString());
    }

    public static final void uncheckAllItems(@NotNull MaterialDialog materialDialog) {
        String str;
        Intrinsics.checkParameterIsNotNull(materialDialog, "$this$uncheckAllItems");
        RecyclerView.Adapter<?> listAdapter = DialogListExtKt.getListAdapter(materialDialog);
        if (listAdapter instanceof DialogAdapter) {
            ((DialogAdapter) listAdapter).uncheckAllItems();
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Can't uncheck all items on adapter: ");
        if (listAdapter != null) {
            str = listAdapter.getClass().getName();
        } else {
            str = "null";
        }
        sb2.append(str);
        throw new UnsupportedOperationException(sb2.toString());
    }

    public static final void uncheckItems(@NotNull MaterialDialog materialDialog, @NotNull int[] iArr) {
        String str;
        Intrinsics.checkParameterIsNotNull(materialDialog, "$this$uncheckItems");
        Intrinsics.checkParameterIsNotNull(iArr, "indices");
        RecyclerView.Adapter<?> listAdapter = DialogListExtKt.getListAdapter(materialDialog);
        if (listAdapter instanceof DialogAdapter) {
            ((DialogAdapter) listAdapter).uncheckItems(iArr);
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Can't uncheck items on adapter: ");
        if (listAdapter != null) {
            str = listAdapter.getClass().getName();
        } else {
            str = "null";
        }
        sb2.append(str);
        throw new UnsupportedOperationException(sb2.toString());
    }

    @NotNull
    public static final MaterialDialog updateListItemsMultiChoice(@NotNull MaterialDialog materialDialog, @Nullable @ArrayRes Integer num, @Nullable List<? extends CharSequence> list, @Nullable int[] iArr, @Nullable Function3<? super MaterialDialog, ? super int[], ? super List<? extends CharSequence>, Unit> function3) {
        Intrinsics.checkParameterIsNotNull(materialDialog, "$this$updateListItemsMultiChoice");
        MDUtil mDUtil = MDUtil.INSTANCE;
        mDUtil.assertOneSet("updateListItemsMultiChoice", list, num);
        if (list == null) {
            list = ArraysKt___ArraysKt.toList((T[]) mDUtil.getStringArray(materialDialog.getWindowContext(), num));
        }
        RecyclerView.Adapter<?> listAdapter = DialogListExtKt.getListAdapter(materialDialog);
        if (listAdapter instanceof MultiChoiceDialogAdapter) {
            MultiChoiceDialogAdapter multiChoiceDialogAdapter = (MultiChoiceDialogAdapter) listAdapter;
            multiChoiceDialogAdapter.replaceItems(list, function3);
            if (iArr != null) {
                multiChoiceDialogAdapter.disableItems(iArr);
            }
            return materialDialog;
        }
        throw new IllegalStateException("updateListItemsMultiChoice(...) can't be used before you've created a multiple choice list dialog.".toString());
    }

    public static /* synthetic */ MaterialDialog updateListItemsMultiChoice$default(MaterialDialog materialDialog, Integer num, List list, int[] iArr, Function3 function3, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            num = null;
        }
        if ((i11 & 2) != 0) {
            list = null;
        }
        if ((i11 & 4) != 0) {
            iArr = null;
        }
        if ((i11 & 8) != 0) {
            function3 = null;
        }
        return updateListItemsMultiChoice(materialDialog, num, list, iArr, function3);
    }
}
