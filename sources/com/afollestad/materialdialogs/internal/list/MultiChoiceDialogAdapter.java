package com.afollestad.materialdialogs.internal.list;

import android.view.View;
import android.view.ViewGroup;
import androidx.core.widget.CompoundButtonCompat;
import androidx.navigation.compose.DialogNavigator;
import androidx.recyclerview.widget.RecyclerView;
import com.afollestad.materialdialogs.MaterialDialog;
import com.afollestad.materialdialogs.R;
import com.afollestad.materialdialogs.WhichButton;
import com.afollestad.materialdialogs.actions.DialogActionExtKt;
import com.afollestad.materialdialogs.list.DialogListExtKt;
import com.afollestad.materialdialogs.utils.ColorsKt;
import com.afollestad.materialdialogs.utils.IntArraysKt;
import com.afollestad.materialdialogs.utils.MDUtil;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012_\u0012\u0004\u0012\u00020\u0004\u0012U\u0012S\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00040\f¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0005j\u0002`\u000f0\u0003B\u0001\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\u0011\u001a\u00020\n\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012W\u0010\u0015\u001aS\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00040\f¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0005j\u0002`\u000f¢\u0006\u0002\u0010\u0016J\b\u0010$\u001a\u00020\u000eH\u0016J\u0010\u0010%\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010&\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010'\u001a\u00020(H\u0016J\u0010\u0010)\u001a\u00020\u00132\u0006\u0010*\u001a\u00020(H\u0016J\u0015\u0010+\u001a\u00020\u000e2\u0006\u0010*\u001a\u00020(H\u0000¢\u0006\u0002\b,J\u0018\u0010-\u001a\u00020\u000e2\u0006\u0010.\u001a\u00020\u00022\u0006\u0010/\u001a\u00020(H\u0016J&\u0010-\u001a\u00020\u000e2\u0006\u0010.\u001a\u00020\u00022\u0006\u0010/\u001a\u00020(2\f\u00100\u001a\b\u0012\u0004\u0012\u00020201H\u0016J\u0018\u00103\u001a\u00020\u00022\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u00020(H\u0016J\b\u00107\u001a\u00020\u000eH\u0016Jo\u00108\u001a\u00020\u000e2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\f2W\u00109\u001aS\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00040\f¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0005j\u0002`\u000fH\u0016J\b\u0010:\u001a\u00020\u000eH\u0016J\u0010\u0010;\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010<\u001a\u00020\u000eH\u0016J\u0010\u0010=\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\nH\u0016R\u000e\u0010\u0014\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\n@BX\u000e¢\u0006\b\n\u0000\"\u0004\b\u0019\u0010\u001aR\u000e\u0010\t\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R \u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fRk\u0010\u0015\u001aS\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00040\f¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0005j\u0002`\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000¨\u0006>"}, d2 = {"Lcom/afollestad/materialdialogs/internal/list/MultiChoiceDialogAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/afollestad/materialdialogs/internal/list/MultiChoiceViewHolder;", "Lcom/afollestad/materialdialogs/internal/list/DialogAdapter;", "", "Lkotlin/Function3;", "Lcom/afollestad/materialdialogs/MaterialDialog;", "Lkotlin/ParameterName;", "name", "dialog", "", "indices", "", "items", "", "Lcom/afollestad/materialdialogs/list/MultiChoiceListener;", "disabledItems", "initialSelection", "waitForActionButton", "", "allowEmptySelection", "selection", "(Lcom/afollestad/materialdialogs/MaterialDialog;Ljava/util/List;[I[IZZLkotlin/jvm/functions/Function3;)V", "value", "currentSelection", "setCurrentSelection", "([I)V", "disabledIndices", "getItems$com_afollestad_material_dialogs_core", "()Ljava/util/List;", "setItems$com_afollestad_material_dialogs_core", "(Ljava/util/List;)V", "getSelection$com_afollestad_material_dialogs_core", "()Lkotlin/jvm/functions/Function3;", "setSelection$com_afollestad_material_dialogs_core", "(Lkotlin/jvm/functions/Function3;)V", "checkAllItems", "checkItems", "disableItems", "getItemCount", "", "isItemChecked", "index", "itemClicked", "itemClicked$com_afollestad_material_dialogs_core", "onBindViewHolder", "holder", "position", "payloads", "", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "positiveButtonClicked", "replaceItems", "listener", "toggleAllChecked", "toggleItems", "uncheckAllItems", "uncheckItems", "com.afollestad.material-dialogs.core"}, k = 1, mv = {1, 1, 15})
public final class MultiChoiceDialogAdapter extends RecyclerView.Adapter<MultiChoiceViewHolder> implements DialogAdapter<CharSequence, Function3<? super MaterialDialog, ? super int[], ? super List<? extends CharSequence>, ? extends Unit>> {
    private final boolean allowEmptySelection;
    private int[] currentSelection;
    private MaterialDialog dialog;
    private int[] disabledIndices;
    @NotNull
    private List<? extends CharSequence> items;
    @Nullable
    private Function3<? super MaterialDialog, ? super int[], ? super List<? extends CharSequence>, Unit> selection;
    private final boolean waitForActionButton;

    public MultiChoiceDialogAdapter(@NotNull MaterialDialog materialDialog, @NotNull List<? extends CharSequence> list, @Nullable int[] iArr, @NotNull int[] iArr2, boolean z11, boolean z12, @Nullable Function3<? super MaterialDialog, ? super int[], ? super List<? extends CharSequence>, Unit> function3) {
        Intrinsics.checkParameterIsNotNull(materialDialog, DialogNavigator.NAME);
        Intrinsics.checkParameterIsNotNull(list, FirebaseAnalytics.Param.ITEMS);
        Intrinsics.checkParameterIsNotNull(iArr2, "initialSelection");
        this.dialog = materialDialog;
        this.items = list;
        this.waitForActionButton = z11;
        this.allowEmptySelection = z12;
        this.selection = function3;
        this.currentSelection = iArr2;
        this.disabledIndices = iArr == null ? new int[0] : iArr;
    }

    private final void setCurrentSelection(int[] iArr) {
        int[] iArr2 = this.currentSelection;
        this.currentSelection = iArr;
        for (int i11 : iArr2) {
            if (!ArraysKt___ArraysKt.contains(iArr, i11)) {
                notifyItemChanged(i11, UncheckPayload.INSTANCE);
            }
        }
        for (int i12 : iArr) {
            if (!ArraysKt___ArraysKt.contains(iArr2, i12)) {
                notifyItemChanged(i12, CheckPayload.INSTANCE);
            }
        }
    }

    public void checkAllItems() {
        int[] iArr = this.currentSelection;
        int itemCount = getItemCount();
        int[] iArr2 = new int[itemCount];
        boolean z11 = false;
        for (int i11 = 0; i11 < itemCount; i11++) {
            iArr2[i11] = i11;
        }
        ArrayList arrayList = new ArrayList();
        for (int i12 = 0; i12 < itemCount; i12++) {
            int i13 = iArr2[i12];
            if (true ^ ArraysKt___ArraysKt.contains(iArr, i13)) {
                arrayList.add(Integer.valueOf(i13));
            }
        }
        setCurrentSelection(IntArraysKt.appendAll(this.currentSelection, arrayList));
        if (iArr.length == 0) {
            z11 = true;
        }
        if (z11) {
            DialogActionExtKt.setActionButtonEnabled(this.dialog, WhichButton.POSITIVE, true);
        }
    }

    public void checkItems(@NotNull int[] iArr) {
        Intrinsics.checkParameterIsNotNull(iArr, "indices");
        int[] iArr2 = this.currentSelection;
        ArrayList arrayList = new ArrayList();
        boolean z11 = false;
        for (int i11 : iArr) {
            if (true ^ ArraysKt___ArraysKt.contains(iArr2, i11)) {
                arrayList.add(Integer.valueOf(i11));
            }
        }
        setCurrentSelection(IntArraysKt.appendAll(this.currentSelection, arrayList));
        if (iArr2.length == 0) {
            z11 = true;
        }
        if (z11) {
            DialogActionExtKt.setActionButtonEnabled(this.dialog, WhichButton.POSITIVE, true);
        }
    }

    public void disableItems(@NotNull int[] iArr) {
        Intrinsics.checkParameterIsNotNull(iArr, "indices");
        this.disabledIndices = iArr;
        notifyDataSetChanged();
    }

    public int getItemCount() {
        return this.items.size();
    }

    @NotNull
    public final List<CharSequence> getItems$com_afollestad_material_dialogs_core() {
        return this.items;
    }

    @Nullable
    public final Function3<MaterialDialog, int[], List<? extends CharSequence>, Unit> getSelection$com_afollestad_material_dialogs_core() {
        return this.selection;
    }

    public boolean isItemChecked(int i11) {
        return ArraysKt___ArraysKt.contains(this.currentSelection, i11);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v7, resolved type: boolean} */
    /* JADX WARNING: type inference failed for: r0v3 */
    /* JADX WARNING: type inference failed for: r0v4, types: [int] */
    /* JADX WARNING: type inference failed for: r0v8 */
    /* JADX WARNING: type inference failed for: r0v9 */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0047, code lost:
        if ((!r2) != false) goto L_0x0049;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void itemClicked$com_afollestad_material_dialogs_core(int r6) {
        /*
            r5 = this;
            int[] r0 = r5.currentSelection
            java.util.List r0 = kotlin.collections.ArraysKt___ArraysKt.toMutableList((int[]) r0)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r6)
            boolean r1 = r0.contains(r1)
            if (r1 == 0) goto L_0x0018
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            r0.remove(r6)
            goto L_0x001f
        L_0x0018:
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            r0.add(r6)
        L_0x001f:
            java.util.Collection r0 = (java.util.Collection) r0
            int[] r6 = kotlin.collections.CollectionsKt___CollectionsKt.toIntArray(r0)
            r5.setCurrentSelection(r6)
            boolean r6 = r5.waitForActionButton
            r0 = 0
            if (r6 == 0) goto L_0x004e
            com.afollestad.materialdialogs.MaterialDialog r6 = r5.dialog
            boolean r6 = com.afollestad.materialdialogs.actions.DialogActionExtKt.hasActionButtons(r6)
            if (r6 == 0) goto L_0x004e
            com.afollestad.materialdialogs.MaterialDialog r6 = r5.dialog
            com.afollestad.materialdialogs.WhichButton r1 = com.afollestad.materialdialogs.WhichButton.POSITIVE
            boolean r2 = r5.allowEmptySelection
            r3 = 1
            if (r2 != 0) goto L_0x0049
            int[] r2 = r5.currentSelection
            int r2 = r2.length
            if (r2 != 0) goto L_0x0045
            r2 = r3
            goto L_0x0046
        L_0x0045:
            r2 = r0
        L_0x0046:
            r2 = r2 ^ r3
            if (r2 == 0) goto L_0x004a
        L_0x0049:
            r0 = r3
        L_0x004a:
            com.afollestad.materialdialogs.actions.DialogActionExtKt.setActionButtonEnabled(r6, r1, r0)
            goto L_0x0089
        L_0x004e:
            java.util.List<? extends java.lang.CharSequence> r6 = r5.items
            int[] r1 = r5.currentSelection
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            int r3 = r1.length
        L_0x0058:
            if (r0 >= r3) goto L_0x0066
            r4 = r1[r0]
            java.lang.Object r4 = r6.get(r4)
            r2.add(r4)
            int r0 = r0 + 1
            goto L_0x0058
        L_0x0066:
            kotlin.jvm.functions.Function3<? super com.afollestad.materialdialogs.MaterialDialog, ? super int[], ? super java.util.List<? extends java.lang.CharSequence>, kotlin.Unit> r6 = r5.selection
            if (r6 == 0) goto L_0x0074
            com.afollestad.materialdialogs.MaterialDialog r0 = r5.dialog
            int[] r1 = r5.currentSelection
            java.lang.Object r6 = r6.invoke(r0, r1, r2)
            kotlin.Unit r6 = (kotlin.Unit) r6
        L_0x0074:
            com.afollestad.materialdialogs.MaterialDialog r6 = r5.dialog
            boolean r6 = r6.getAutoDismissEnabled()
            if (r6 == 0) goto L_0x0089
            com.afollestad.materialdialogs.MaterialDialog r6 = r5.dialog
            boolean r6 = com.afollestad.materialdialogs.actions.DialogActionExtKt.hasActionButtons(r6)
            if (r6 != 0) goto L_0x0089
            com.afollestad.materialdialogs.MaterialDialog r6 = r5.dialog
            r6.dismiss()
        L_0x0089:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.afollestad.materialdialogs.internal.list.MultiChoiceDialogAdapter.itemClicked$com_afollestad_material_dialogs_core(int):void");
    }

    public void positiveButtonClicked() {
        boolean z11;
        if (!this.allowEmptySelection) {
            if (this.currentSelection.length == 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (!(!z11)) {
                return;
            }
        }
        List<? extends CharSequence> list = this.items;
        int[] iArr = this.currentSelection;
        ArrayList arrayList = new ArrayList();
        for (int i11 : iArr) {
            arrayList.add(list.get(i11));
        }
        Function3<? super MaterialDialog, ? super int[], ? super List<? extends CharSequence>, Unit> function3 = this.selection;
        if (function3 != null) {
            Unit invoke = function3.invoke(this.dialog, this.currentSelection, arrayList);
        }
    }

    public final void setItems$com_afollestad_material_dialogs_core(@NotNull List<? extends CharSequence> list) {
        Intrinsics.checkParameterIsNotNull(list, "<set-?>");
        this.items = list;
    }

    public final void setSelection$com_afollestad_material_dialogs_core(@Nullable Function3<? super MaterialDialog, ? super int[], ? super List<? extends CharSequence>, Unit> function3) {
        this.selection = function3;
    }

    public void toggleAllChecked() {
        boolean z11;
        if (this.currentSelection.length == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            checkAllItems();
        } else {
            uncheckAllItems();
        }
    }

    public void toggleItems(@NotNull int[] iArr) {
        Intrinsics.checkParameterIsNotNull(iArr, "indices");
        List mutableList = ArraysKt___ArraysKt.toMutableList(this.currentSelection);
        boolean z11 = false;
        for (int i11 : iArr) {
            if (!ArraysKt___ArraysKt.contains(this.disabledIndices, i11)) {
                if (mutableList.contains(Integer.valueOf(i11))) {
                    mutableList.remove(Integer.valueOf(i11));
                } else {
                    mutableList.add(Integer.valueOf(i11));
                }
            }
        }
        int[] intArray = CollectionsKt___CollectionsKt.toIntArray(mutableList);
        MaterialDialog materialDialog = this.dialog;
        WhichButton whichButton = WhichButton.POSITIVE;
        boolean z12 = true;
        if (intArray.length == 0) {
            z11 = true;
        }
        if (z11) {
            z12 = this.allowEmptySelection;
        }
        DialogActionExtKt.setActionButtonEnabled(materialDialog, whichButton, z12);
        setCurrentSelection(intArray);
    }

    public void uncheckAllItems() {
        setCurrentSelection(new int[0]);
        DialogActionExtKt.setActionButtonEnabled(this.dialog, WhichButton.POSITIVE, this.allowEmptySelection);
    }

    public void uncheckItems(@NotNull int[] iArr) {
        Intrinsics.checkParameterIsNotNull(iArr, "indices");
        int[] iArr2 = this.currentSelection;
        ArrayList arrayList = new ArrayList();
        boolean z11 = false;
        for (int i11 : iArr) {
            if (ArraysKt___ArraysKt.contains(iArr2, i11)) {
                arrayList.add(Integer.valueOf(i11));
            }
        }
        int[] removeAll = IntArraysKt.removeAll(this.currentSelection, arrayList);
        if (removeAll.length == 0) {
            z11 = true;
        }
        if (z11) {
            DialogActionExtKt.setActionButtonEnabled(this.dialog, WhichButton.POSITIVE, this.allowEmptySelection);
        }
        setCurrentSelection(removeAll);
    }

    @NotNull
    public MultiChoiceViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i11) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
        MDUtil mDUtil = MDUtil.INSTANCE;
        MultiChoiceViewHolder multiChoiceViewHolder = new MultiChoiceViewHolder(mDUtil.inflate(viewGroup, this.dialog.getWindowContext(), R.layout.md_listitem_multichoice), this);
        MDUtil.maybeSetTextColor$default(mDUtil, multiChoiceViewHolder.getTitleView(), this.dialog.getWindowContext(), Integer.valueOf(R.attr.md_color_content), (Integer) null, 4, (Object) null);
        int[] resolveColors$default = ColorsKt.resolveColors$default(this.dialog, new int[]{R.attr.md_color_widget, R.attr.md_color_widget_unchecked}, (Function1) null, 2, (Object) null);
        CompoundButtonCompat.setButtonTintList(multiChoiceViewHolder.getControlView(), mDUtil.createColorSelector(this.dialog.getWindowContext(), resolveColors$default[1], resolveColors$default[0]));
        return multiChoiceViewHolder;
    }

    public void replaceItems(@NotNull List<? extends CharSequence> list, @Nullable Function3<? super MaterialDialog, ? super int[], ? super List<? extends CharSequence>, Unit> function3) {
        Intrinsics.checkParameterIsNotNull(list, FirebaseAnalytics.Param.ITEMS);
        this.items = list;
        if (function3 != null) {
            this.selection = function3;
        }
        notifyDataSetChanged();
    }

    public void onBindViewHolder(@NotNull MultiChoiceViewHolder multiChoiceViewHolder, int i11) {
        Intrinsics.checkParameterIsNotNull(multiChoiceViewHolder, "holder");
        multiChoiceViewHolder.setEnabled(!ArraysKt___ArraysKt.contains(this.disabledIndices, i11));
        multiChoiceViewHolder.getControlView().setChecked(ArraysKt___ArraysKt.contains(this.currentSelection, i11));
        multiChoiceViewHolder.getTitleView().setText((CharSequence) this.items.get(i11));
        View view = multiChoiceViewHolder.itemView;
        Intrinsics.checkExpressionValueIsNotNull(view, "holder.itemView");
        view.setBackground(DialogListExtKt.getItemSelector(this.dialog));
        if (this.dialog.getBodyFont() != null) {
            multiChoiceViewHolder.getTitleView().setTypeface(this.dialog.getBodyFont());
        }
    }

    public void onBindViewHolder(@NotNull MultiChoiceViewHolder multiChoiceViewHolder, int i11, @NotNull List<Object> list) {
        Intrinsics.checkParameterIsNotNull(multiChoiceViewHolder, "holder");
        Intrinsics.checkParameterIsNotNull(list, "payloads");
        Object firstOrNull = CollectionsKt___CollectionsKt.firstOrNull(list);
        if (Intrinsics.areEqual(firstOrNull, (Object) CheckPayload.INSTANCE)) {
            multiChoiceViewHolder.getControlView().setChecked(true);
        } else if (Intrinsics.areEqual(firstOrNull, (Object) UncheckPayload.INSTANCE)) {
            multiChoiceViewHolder.getControlView().setChecked(false);
        } else {
            super.onBindViewHolder(multiChoiceViewHolder, i11, list);
            super.onBindViewHolder(multiChoiceViewHolder, i11, list);
        }
    }
}
