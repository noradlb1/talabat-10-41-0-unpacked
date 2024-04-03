package com.afollestad.materialdialogs.internal.list;

import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.core.widget.CompoundButtonCompat;
import androidx.navigation.compose.DialogNavigator;
import androidx.recyclerview.widget.RecyclerView;
import com.afollestad.materialdialogs.MaterialDialog;
import com.afollestad.materialdialogs.R;
import com.afollestad.materialdialogs.WhichButton;
import com.afollestad.materialdialogs.actions.DialogActionExtKt;
import com.afollestad.materialdialogs.list.DialogListExtKt;
import com.afollestad.materialdialogs.utils.ColorsKt;
import com.afollestad.materialdialogs.utils.MDUtil;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u001b\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012Y\u0012\u0004\u0012\u00020\u0004\u0012O\u0012M\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r\u0018\u00010\u0005j\u0002`\u000e0\u0003B\u0001\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0010\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\u0006\u0010\u0013\u001a\u00020\n\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012Q\u0010\u0016\u001aM\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r\u0018\u00010\u0005j\u0002`\u000e¢\u0006\u0002\u0010\u0017J\b\u0010%\u001a\u00020\rH\u0016J\u0010\u0010&\u001a\u00020\r2\u0006\u0010'\u001a\u00020\u0012H\u0016J\u0010\u0010(\u001a\u00020\r2\u0006\u0010'\u001a\u00020\u0012H\u0016J\b\u0010)\u001a\u00020\nH\u0016J\u0010\u0010*\u001a\u00020\u00152\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0015\u0010+\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\nH\u0000¢\u0006\u0002\b,J\u0018\u0010-\u001a\u00020\r2\u0006\u0010.\u001a\u00020\u00022\u0006\u0010/\u001a\u00020\nH\u0016J&\u0010-\u001a\u00020\r2\u0006\u0010.\u001a\u00020\u00022\u0006\u0010/\u001a\u00020\n2\f\u00100\u001a\b\u0012\u0004\u0012\u00020201H\u0016J\u0018\u00103\u001a\u00020\u00022\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u00020\nH\u0016J\b\u00107\u001a\u00020\rH\u0016Ji\u00108\u001a\u00020\r2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u00102Q\u00109\u001aM\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r\u0018\u00010\u0005j\u0002`\u000eH\u0016J\b\u0010:\u001a\u00020\rH\u0016J\u0010\u0010;\u001a\u00020\r2\u0006\u0010'\u001a\u00020\u0012H\u0016J\b\u0010<\u001a\u00020\rH\u0016J\u0010\u0010=\u001a\u00020\r2\u0006\u0010'\u001a\u00020\u0012H\u0016R\u001e\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\n@BX\u000e¢\u0006\b\n\u0000\"\u0004\b\u001a\u0010\u001bR\u000e\u0010\t\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R \u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 Re\u0010\u0016\u001aM\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r\u0018\u00010\u0005j\u0002`\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u000e\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000¨\u0006>"}, d2 = {"Lcom/afollestad/materialdialogs/internal/list/SingleChoiceDialogAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/afollestad/materialdialogs/internal/list/SingleChoiceViewHolder;", "Lcom/afollestad/materialdialogs/internal/list/DialogAdapter;", "", "Lkotlin/Function3;", "Lcom/afollestad/materialdialogs/MaterialDialog;", "Lkotlin/ParameterName;", "name", "dialog", "", "index", "text", "", "Lcom/afollestad/materialdialogs/list/SingleChoiceListener;", "items", "", "disabledItems", "", "initialSelection", "waitForActionButton", "", "selection", "(Lcom/afollestad/materialdialogs/MaterialDialog;Ljava/util/List;[IIZLkotlin/jvm/functions/Function3;)V", "value", "currentSelection", "setCurrentSelection", "(I)V", "disabledIndices", "getItems$com_afollestad_material_dialogs_core", "()Ljava/util/List;", "setItems$com_afollestad_material_dialogs_core", "(Ljava/util/List;)V", "getSelection$com_afollestad_material_dialogs_core", "()Lkotlin/jvm/functions/Function3;", "setSelection$com_afollestad_material_dialogs_core", "(Lkotlin/jvm/functions/Function3;)V", "checkAllItems", "checkItems", "indices", "disableItems", "getItemCount", "isItemChecked", "itemClicked", "itemClicked$com_afollestad_material_dialogs_core", "onBindViewHolder", "holder", "position", "payloads", "", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "positiveButtonClicked", "replaceItems", "listener", "toggleAllChecked", "toggleItems", "uncheckAllItems", "uncheckItems", "com.afollestad.material-dialogs.core"}, k = 1, mv = {1, 1, 15})
public final class SingleChoiceDialogAdapter extends RecyclerView.Adapter<SingleChoiceViewHolder> implements DialogAdapter<CharSequence, Function3<? super MaterialDialog, ? super Integer, ? super CharSequence, ? extends Unit>> {
    private int currentSelection;
    private MaterialDialog dialog;
    private int[] disabledIndices;
    @NotNull
    private List<? extends CharSequence> items;
    @Nullable
    private Function3<? super MaterialDialog, ? super Integer, ? super CharSequence, Unit> selection;
    private final boolean waitForActionButton;

    public SingleChoiceDialogAdapter(@NotNull MaterialDialog materialDialog, @NotNull List<? extends CharSequence> list, @Nullable int[] iArr, int i11, boolean z11, @Nullable Function3<? super MaterialDialog, ? super Integer, ? super CharSequence, Unit> function3) {
        Intrinsics.checkParameterIsNotNull(materialDialog, DialogNavigator.NAME);
        Intrinsics.checkParameterIsNotNull(list, FirebaseAnalytics.Param.ITEMS);
        this.dialog = materialDialog;
        this.items = list;
        this.waitForActionButton = z11;
        this.selection = function3;
        this.currentSelection = i11;
        this.disabledIndices = iArr == null ? new int[0] : iArr;
    }

    private final void setCurrentSelection(int i11) {
        int i12 = this.currentSelection;
        if (i11 != i12) {
            this.currentSelection = i11;
            notifyItemChanged(i12, UncheckPayload.INSTANCE);
            notifyItemChanged(i11, CheckPayload.INSTANCE);
        }
    }

    public void checkAllItems() {
    }

    public void checkItems(@NotNull int[] iArr) {
        boolean z11;
        int i11;
        Intrinsics.checkParameterIsNotNull(iArr, "indices");
        if (iArr.length == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11) {
            i11 = iArr[0];
        } else {
            i11 = -1;
        }
        if (!ArraysKt___ArraysKt.contains(this.disabledIndices, i11)) {
            setCurrentSelection(i11);
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
    public final Function3<MaterialDialog, Integer, CharSequence, Unit> getSelection$com_afollestad_material_dialogs_core() {
        return this.selection;
    }

    public boolean isItemChecked(int i11) {
        return this.currentSelection == i11;
    }

    public final void itemClicked$com_afollestad_material_dialogs_core(int i11) {
        setCurrentSelection(i11);
        if (!this.waitForActionButton || !DialogActionExtKt.hasActionButtons(this.dialog)) {
            Function3<? super MaterialDialog, ? super Integer, ? super CharSequence, Unit> function3 = this.selection;
            if (function3 != null) {
                Unit invoke = function3.invoke(this.dialog, Integer.valueOf(i11), this.items.get(i11));
            }
            if (this.dialog.getAutoDismissEnabled() && !DialogActionExtKt.hasActionButtons(this.dialog)) {
                this.dialog.dismiss();
                return;
            }
            return;
        }
        DialogActionExtKt.setActionButtonEnabled(this.dialog, WhichButton.POSITIVE, true);
    }

    public void positiveButtonClicked() {
        Function3<? super MaterialDialog, ? super Integer, ? super CharSequence, Unit> function3;
        int i11 = this.currentSelection;
        if (i11 > -1 && (function3 = this.selection) != null) {
            Unit invoke = function3.invoke(this.dialog, Integer.valueOf(i11), this.items.get(this.currentSelection));
        }
    }

    public final void setItems$com_afollestad_material_dialogs_core(@NotNull List<? extends CharSequence> list) {
        Intrinsics.checkParameterIsNotNull(list, "<set-?>");
        this.items = list;
    }

    public final void setSelection$com_afollestad_material_dialogs_core(@Nullable Function3<? super MaterialDialog, ? super Integer, ? super CharSequence, Unit> function3) {
        this.selection = function3;
    }

    public void toggleAllChecked() {
    }

    public void toggleItems(@NotNull int[] iArr) {
        boolean z11;
        int i11;
        Intrinsics.checkParameterIsNotNull(iArr, "indices");
        boolean z12 = true;
        if (iArr.length == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11) {
            i11 = iArr[0];
        } else {
            i11 = -1;
        }
        if (!ArraysKt___ArraysKt.contains(this.disabledIndices, i11)) {
            if (iArr.length != 0) {
                z12 = false;
            }
            if (z12 || this.currentSelection == i11) {
                setCurrentSelection(-1);
            } else {
                setCurrentSelection(i11);
            }
        }
    }

    public void uncheckAllItems() {
    }

    public void uncheckItems(@NotNull int[] iArr) {
        boolean z11;
        int i11;
        Intrinsics.checkParameterIsNotNull(iArr, "indices");
        if (iArr.length == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11) {
            i11 = iArr[0];
        } else {
            i11 = -1;
        }
        if (!ArraysKt___ArraysKt.contains(this.disabledIndices, i11)) {
            setCurrentSelection(-1);
        }
    }

    @NotNull
    public SingleChoiceViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i11) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
        MDUtil mDUtil = MDUtil.INSTANCE;
        SingleChoiceViewHolder singleChoiceViewHolder = new SingleChoiceViewHolder(mDUtil.inflate(viewGroup, this.dialog.getWindowContext(), R.layout.md_listitem_singlechoice), this);
        MDUtil.maybeSetTextColor$default(mDUtil, singleChoiceViewHolder.getTitleView(), this.dialog.getWindowContext(), Integer.valueOf(R.attr.md_color_content), (Integer) null, 4, (Object) null);
        int[] resolveColors$default = ColorsKt.resolveColors$default(this.dialog, new int[]{R.attr.md_color_widget, R.attr.md_color_widget_unchecked}, (Function1) null, 2, (Object) null);
        CompoundButtonCompat.setButtonTintList(singleChoiceViewHolder.getControlView(), mDUtil.createColorSelector(this.dialog.getWindowContext(), resolveColors$default[1], resolveColors$default[0]));
        return singleChoiceViewHolder;
    }

    public void replaceItems(@NotNull List<? extends CharSequence> list, @Nullable Function3<? super MaterialDialog, ? super Integer, ? super CharSequence, Unit> function3) {
        Intrinsics.checkParameterIsNotNull(list, FirebaseAnalytics.Param.ITEMS);
        this.items = list;
        if (function3 != null) {
            this.selection = function3;
        }
        notifyDataSetChanged();
    }

    public void onBindViewHolder(@NotNull SingleChoiceViewHolder singleChoiceViewHolder, int i11) {
        Intrinsics.checkParameterIsNotNull(singleChoiceViewHolder, "holder");
        boolean z11 = true;
        singleChoiceViewHolder.setEnabled(!ArraysKt___ArraysKt.contains(this.disabledIndices, i11));
        AppCompatRadioButton controlView = singleChoiceViewHolder.getControlView();
        if (this.currentSelection != i11) {
            z11 = false;
        }
        controlView.setChecked(z11);
        singleChoiceViewHolder.getTitleView().setText((CharSequence) this.items.get(i11));
        View view = singleChoiceViewHolder.itemView;
        Intrinsics.checkExpressionValueIsNotNull(view, "holder.itemView");
        view.setBackground(DialogListExtKt.getItemSelector(this.dialog));
        if (this.dialog.getBodyFont() != null) {
            singleChoiceViewHolder.getTitleView().setTypeface(this.dialog.getBodyFont());
        }
    }

    public void onBindViewHolder(@NotNull SingleChoiceViewHolder singleChoiceViewHolder, int i11, @NotNull List<Object> list) {
        Intrinsics.checkParameterIsNotNull(singleChoiceViewHolder, "holder");
        Intrinsics.checkParameterIsNotNull(list, "payloads");
        Object firstOrNull = CollectionsKt___CollectionsKt.firstOrNull(list);
        if (Intrinsics.areEqual(firstOrNull, (Object) CheckPayload.INSTANCE)) {
            singleChoiceViewHolder.getControlView().setChecked(true);
        } else if (Intrinsics.areEqual(firstOrNull, (Object) UncheckPayload.INSTANCE)) {
            singleChoiceViewHolder.getControlView().setChecked(false);
        } else {
            super.onBindViewHolder(singleChoiceViewHolder, i11, list);
        }
    }
}
