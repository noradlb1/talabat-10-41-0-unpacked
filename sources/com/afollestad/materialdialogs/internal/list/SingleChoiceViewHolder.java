package com.afollestad.materialdialogs.internal.list;

import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.recyclerview.widget.RecyclerView;
import com.afollestad.materialdialogs.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0004H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR$\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r8F@FX\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/afollestad/materialdialogs/internal/list/SingleChoiceViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View$OnClickListener;", "itemView", "Landroid/view/View;", "adapter", "Lcom/afollestad/materialdialogs/internal/list/SingleChoiceDialogAdapter;", "(Landroid/view/View;Lcom/afollestad/materialdialogs/internal/list/SingleChoiceDialogAdapter;)V", "controlView", "Landroidx/appcompat/widget/AppCompatRadioButton;", "getControlView", "()Landroidx/appcompat/widget/AppCompatRadioButton;", "value", "", "isEnabled", "()Z", "setEnabled", "(Z)V", "titleView", "Landroid/widget/TextView;", "getTitleView", "()Landroid/widget/TextView;", "onClick", "", "view", "com.afollestad.material-dialogs.core"}, k = 1, mv = {1, 1, 15})
public final class SingleChoiceViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private final SingleChoiceDialogAdapter adapter;
    @NotNull
    private final AppCompatRadioButton controlView;
    @NotNull
    private final TextView titleView;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SingleChoiceViewHolder(@NotNull View view, @NotNull SingleChoiceDialogAdapter singleChoiceDialogAdapter) {
        super(view);
        Intrinsics.checkParameterIsNotNull(view, "itemView");
        Intrinsics.checkParameterIsNotNull(singleChoiceDialogAdapter, "adapter");
        this.adapter = singleChoiceDialogAdapter;
        view.setOnClickListener(this);
        View findViewById = view.findViewById(R.id.md_control);
        Intrinsics.checkExpressionValueIsNotNull(findViewById, "itemView.findViewById(R.id.md_control)");
        this.controlView = (AppCompatRadioButton) findViewById;
        View findViewById2 = view.findViewById(R.id.md_title);
        Intrinsics.checkExpressionValueIsNotNull(findViewById2, "itemView.findViewById(R.id.md_title)");
        this.titleView = (TextView) findViewById2;
    }

    @NotNull
    public final AppCompatRadioButton getControlView() {
        return this.controlView;
    }

    @NotNull
    public final TextView getTitleView() {
        return this.titleView;
    }

    public final boolean isEnabled() {
        View view = this.itemView;
        Intrinsics.checkExpressionValueIsNotNull(view, "itemView");
        return view.isEnabled();
    }

    public void onClick(@NotNull View view) {
        Intrinsics.checkParameterIsNotNull(view, "view");
        this.adapter.itemClicked$com_afollestad_material_dialogs_core(getAdapterPosition());
    }

    public final void setEnabled(boolean z11) {
        View view = this.itemView;
        Intrinsics.checkExpressionValueIsNotNull(view, "itemView");
        view.setEnabled(z11);
        this.controlView.setEnabled(z11);
        this.titleView.setEnabled(z11);
    }
}
