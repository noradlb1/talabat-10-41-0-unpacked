package com.talabat.sdsquad.ui.vendorslist.adapters.viewholders;

import android.view.View;
import android.widget.ImageButton;
import androidx.recyclerview.widget.RecyclerView;
import com.talabat.sdsquad.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.extensions.LayoutContainer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ou.c;
import ou.d;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u000eB\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rR\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u000f"}, d2 = {"Lcom/talabat/sdsquad/ui/vendorslist/adapters/viewholders/ToggleHeaderViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lkotlinx/android/extensions/LayoutContainer;", "containerView", "Landroid/view/View;", "clickListener", "Lcom/talabat/sdsquad/ui/vendorslist/adapters/viewholders/ToggleHeaderViewHolder$OnHeaderToggleClickListener;", "(Landroid/view/View;Lcom/talabat/sdsquad/ui/vendorslist/adapters/viewholders/ToggleHeaderViewHolder$OnHeaderToggleClickListener;)V", "getContainerView", "()Landroid/view/View;", "bind", "", "isList", "", "OnHeaderToggleClickListener", "com_talabat_NewArchi_sdsquad_sdsquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ToggleHeaderViewHolder extends RecyclerView.ViewHolder implements LayoutContainer {
    @Nullable
    private final OnHeaderToggleClickListener clickListener;
    @NotNull
    private final View containerView;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&¨\u0006\u0005"}, d2 = {"Lcom/talabat/sdsquad/ui/vendorslist/adapters/viewholders/ToggleHeaderViewHolder$OnHeaderToggleClickListener;", "", "cardViewClicked", "", "listViewClicked", "com_talabat_NewArchi_sdsquad_sdsquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface OnHeaderToggleClickListener {
        void cardViewClicked();

        void listViewClicked();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ToggleHeaderViewHolder(@NotNull View view, @Nullable OnHeaderToggleClickListener onHeaderToggleClickListener) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "containerView");
        this.containerView = view;
        this.clickListener = onHeaderToggleClickListener;
    }

    /* access modifiers changed from: private */
    /* renamed from: bind$lambda-0  reason: not valid java name */
    public static final void m10891bind$lambda0(ToggleHeaderViewHolder toggleHeaderViewHolder, View view) {
        OnHeaderToggleClickListener onHeaderToggleClickListener;
        Intrinsics.checkNotNullParameter(toggleHeaderViewHolder, "this$0");
        if (!((ImageButton) toggleHeaderViewHolder.getContainerView().findViewById(R.id.cardViewBtn)).isSelected() && (onHeaderToggleClickListener = toggleHeaderViewHolder.clickListener) != null) {
            onHeaderToggleClickListener.cardViewClicked();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: bind$lambda-1  reason: not valid java name */
    public static final void m10892bind$lambda1(ToggleHeaderViewHolder toggleHeaderViewHolder, View view) {
        OnHeaderToggleClickListener onHeaderToggleClickListener;
        Intrinsics.checkNotNullParameter(toggleHeaderViewHolder, "this$0");
        if (!((ImageButton) toggleHeaderViewHolder.getContainerView().findViewById(R.id.listViewBtn)).isSelected() && (onHeaderToggleClickListener = toggleHeaderViewHolder.clickListener) != null) {
            onHeaderToggleClickListener.listViewClicked();
        }
    }

    public final void bind(boolean z11) {
        if (z11) {
            ((ImageButton) getContainerView().findViewById(R.id.cardViewBtn)).setSelected(false);
            ((ImageButton) getContainerView().findViewById(R.id.listViewBtn)).setSelected(true);
        } else {
            ((ImageButton) getContainerView().findViewById(R.id.cardViewBtn)).setSelected(true);
            ((ImageButton) getContainerView().findViewById(R.id.listViewBtn)).setSelected(false);
        }
        ((ImageButton) getContainerView().findViewById(R.id.cardViewBtn)).setOnClickListener(new c(this));
        ((ImageButton) getContainerView().findViewById(R.id.listViewBtn)).setOnClickListener(new d(this));
    }

    @NotNull
    public View getContainerView() {
        return this.containerView;
    }
}
