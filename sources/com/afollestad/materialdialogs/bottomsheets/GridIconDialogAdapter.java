package com.afollestad.materialdialogs.bottomsheets;

import android.view.View;
import android.view.ViewGroup;
import androidx.navigation.compose.DialogNavigator;
import androidx.recyclerview.widget.RecyclerView;
import com.afollestad.materialdialogs.MaterialDialog;
import com.afollestad.materialdialogs.WhichButton;
import com.afollestad.materialdialogs.actions.DialogActionExtKt;
import com.afollestad.materialdialogs.bottomsheets.GridItem;
import com.afollestad.materialdialogs.internal.list.DialogAdapter;
import com.afollestad.materialdialogs.list.DialogListExtKt;
import com.afollestad.materialdialogs.utils.MDUtil;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u00032_\u0012\u0004\u0012\u0002H\u0001\u0012U\u0012S\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0013\u0012\u0011H\u0001¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0006j\b\u0012\u0004\u0012\u0002H\u0001`\u000f0\u0005B\u0001\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012W\u0010\u0016\u001aS\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0006j\b\u0012\u0004\u0012\u00028\u0000`\u000f¢\u0006\u0002\u0010\u0017J\b\u0010\u0019\u001a\u00020\u000eH\u0016J\u0010\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u0013H\u0016J\u0010\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u0013H\u0016J\b\u0010\u001d\u001a\u00020\u000bH\u0016J\u0010\u0010\u001e\u001a\u00020\u00152\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u000e\u0010\u001f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000bJ\u0018\u0010 \u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u000bH\u0016J\u0018\u0010#\u001a\u00020\u00042\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u000bH\u0016J\b\u0010'\u001a\u00020\u000eH\u0016Jo\u0010(\u001a\u00020\u000e2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u00112W\u0010)\u001aS\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0006j\b\u0012\u0004\u0012\u00028\u0000`\u000fH\u0016J\b\u0010*\u001a\u00020\u000eH\u0016J\u0010\u0010+\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u0013H\u0016J\b\u0010,\u001a\u00020\u000eH\u0016J\u0010\u0010-\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u0013H\u0016R\u000e\u0010\n\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011X\u000e¢\u0006\u0002\n\u0000R_\u0010\u0016\u001aS\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0006j\b\u0012\u0004\u0012\u00028\u0000`\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lcom/afollestad/materialdialogs/bottomsheets/GridIconDialogAdapter;", "IT", "Lcom/afollestad/materialdialogs/bottomsheets/GridItem;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/afollestad/materialdialogs/bottomsheets/GridItemViewHolder;", "Lcom/afollestad/materialdialogs/internal/list/DialogAdapter;", "Lkotlin/Function3;", "Lcom/afollestad/materialdialogs/MaterialDialog;", "Lkotlin/ParameterName;", "name", "dialog", "", "index", "item", "", "Lcom/afollestad/materialdialogs/bottomsheets/GridItemListener;", "items", "", "disabledItems", "", "waitForPositiveButton", "", "selection", "(Lcom/afollestad/materialdialogs/MaterialDialog;Ljava/util/List;[IZLkotlin/jvm/functions/Function3;)V", "disabledIndices", "checkAllItems", "checkItems", "indices", "disableItems", "getItemCount", "isItemChecked", "itemClicked", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "positiveButtonClicked", "replaceItems", "listener", "toggleAllChecked", "toggleItems", "uncheckAllItems", "uncheckItems", "com.afollestad.material-dialogs.bottomsheets"}, k = 1, mv = {1, 1, 15})
public final class GridIconDialogAdapter<IT extends GridItem> extends RecyclerView.Adapter<GridItemViewHolder> implements DialogAdapter<IT, Function3<? super MaterialDialog, ? super Integer, ? super IT, ? extends Unit>> {
    private MaterialDialog dialog;
    private int[] disabledIndices;
    private List<? extends IT> items;
    private Function3<? super MaterialDialog, ? super Integer, ? super IT, Unit> selection;
    private boolean waitForPositiveButton;

    public GridIconDialogAdapter(@NotNull MaterialDialog materialDialog, @NotNull List<? extends IT> list, @Nullable int[] iArr, boolean z11, @Nullable Function3<? super MaterialDialog, ? super Integer, ? super IT, Unit> function3) {
        Intrinsics.checkParameterIsNotNull(materialDialog, DialogNavigator.NAME);
        Intrinsics.checkParameterIsNotNull(list, FirebaseAnalytics.Param.ITEMS);
        this.dialog = materialDialog;
        this.items = list;
        this.waitForPositiveButton = z11;
        this.selection = function3;
        this.disabledIndices = iArr == null ? new int[0] : iArr;
    }

    public void checkAllItems() {
    }

    public void checkItems(@NotNull int[] iArr) {
        Intrinsics.checkParameterIsNotNull(iArr, "indices");
    }

    public void disableItems(@NotNull int[] iArr) {
        Intrinsics.checkParameterIsNotNull(iArr, "indices");
        this.disabledIndices = iArr;
        notifyDataSetChanged();
    }

    public int getItemCount() {
        return this.items.size();
    }

    public boolean isItemChecked(int i11) {
        return false;
    }

    public final void itemClicked(int i11) {
        if (!this.waitForPositiveButton || !DialogActionExtKt.hasActionButton(this.dialog, WhichButton.POSITIVE)) {
            Function3<? super MaterialDialog, ? super Integer, ? super IT, Unit> function3 = this.selection;
            if (function3 != null) {
                Unit invoke = function3.invoke(this.dialog, Integer.valueOf(i11), this.items.get(i11));
            }
            if (this.dialog.getAutoDismissEnabled() && !DialogActionExtKt.hasActionButtons(this.dialog)) {
                this.dialog.dismiss();
                return;
            }
            return;
        }
        Object obj = this.dialog.getConfig().get("activated_index");
        if (!(obj instanceof Integer)) {
            obj = null;
        }
        Integer num = (Integer) obj;
        this.dialog.getConfig().put("activated_index", Integer.valueOf(i11));
        if (num != null) {
            notifyItemChanged(num.intValue());
        }
        notifyItemChanged(i11);
    }

    public void positiveButtonClicked() {
        Object obj = this.dialog.getConfig().get("activated_index");
        if (!(obj instanceof Integer)) {
            obj = null;
        }
        Integer num = (Integer) obj;
        if (num != null) {
            Function3<? super MaterialDialog, ? super Integer, ? super IT, Unit> function3 = this.selection;
            if (function3 != null) {
                Unit invoke = function3.invoke(this.dialog, num, this.items.get(num.intValue()));
            }
            this.dialog.getConfig().remove("activated_index");
        }
    }

    public void toggleAllChecked() {
    }

    public void toggleItems(@NotNull int[] iArr) {
        Intrinsics.checkParameterIsNotNull(iArr, "indices");
    }

    public void uncheckAllItems() {
    }

    public void uncheckItems(@NotNull int[] iArr) {
        Intrinsics.checkParameterIsNotNull(iArr, "indices");
    }

    public void onBindViewHolder(@NotNull GridItemViewHolder gridItemViewHolder, int i11) {
        Intrinsics.checkParameterIsNotNull(gridItemViewHolder, "holder");
        View view = gridItemViewHolder.itemView;
        Intrinsics.checkExpressionValueIsNotNull(view, "holder.itemView");
        boolean z11 = true;
        view.setEnabled(!ArraysKt___ArraysKt.contains(this.disabledIndices, i11));
        GridItem gridItem = (GridItem) this.items.get(i11);
        gridItemViewHolder.getTitleView().setText(gridItem.getTitle());
        View view2 = gridItemViewHolder.itemView;
        Intrinsics.checkExpressionValueIsNotNull(view2, "holder.itemView");
        view2.setBackground(DialogListExtKt.getItemSelector(this.dialog));
        gridItem.populateIcon(gridItemViewHolder.getIconView());
        Object obj = this.dialog.getConfig().get("activated_index");
        if (!(obj instanceof Integer)) {
            obj = null;
        }
        Integer num = (Integer) obj;
        View view3 = gridItemViewHolder.itemView;
        Intrinsics.checkExpressionValueIsNotNull(view3, "holder.itemView");
        if (num == null || num.intValue() != i11) {
            z11 = false;
        }
        view3.setActivated(z11);
        if (this.dialog.getBodyFont() != null) {
            gridItemViewHolder.getTitleView().setTypeface(this.dialog.getBodyFont());
        }
    }

    @NotNull
    public GridItemViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i11) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
        MDUtil mDUtil = MDUtil.INSTANCE;
        GridItemViewHolder gridItemViewHolder = new GridItemViewHolder(mDUtil.inflate(viewGroup, this.dialog.getWindowContext(), R.layout.md_griditem), this);
        MDUtil.maybeSetTextColor$default(mDUtil, gridItemViewHolder.getTitleView(), this.dialog.getWindowContext(), Integer.valueOf(R.attr.md_color_content), (Integer) null, 4, (Object) null);
        return gridItemViewHolder;
    }

    public void replaceItems(@NotNull List<? extends IT> list, @Nullable Function3<? super MaterialDialog, ? super Integer, ? super IT, Unit> function3) {
        Intrinsics.checkParameterIsNotNull(list, FirebaseAnalytics.Param.ITEMS);
        this.items = list;
        if (function3 != null) {
            this.selection = function3;
        }
        notifyDataSetChanged();
    }
}
