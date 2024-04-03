package com.talabat.adapters.restaurantslist.viewholders;

import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import cf.a;
import cf.b;
import com.talabat.R;
import com.talabat.core.experiment.data.TalabatExperiment;
import com.talabat.core.experiment.data.TalabatExperimentConstants;
import com.talabat.core.experiment.domain.TalabatExperimentDataSourceStrategy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.extensions.LayoutContainer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0013B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0018\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u000fH\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/talabat/adapters/restaurantslist/viewholders/ToggleHeaderViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lkotlinx/android/extensions/LayoutContainer;", "containerView", "Landroid/view/View;", "clickListener", "Lcom/talabat/adapters/restaurantslist/viewholders/ToggleHeaderViewHolder$OnHeaderToggleClickListener;", "(Landroid/view/View;Lcom/talabat/adapters/restaurantslist/viewholders/ToggleHeaderViewHolder$OnHeaderToggleClickListener;)V", "getContainerView", "()Landroid/view/View;", "bind", "", "isTgoStyle", "", "verticalId", "", "setColorFilter", "cardColor", "listColor", "OnHeaderToggleClickListener", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ToggleHeaderViewHolder extends RecyclerView.ViewHolder implements LayoutContainer {
    @Nullable
    private final OnHeaderToggleClickListener clickListener;
    @NotNull
    private final View containerView;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&¨\u0006\u0005"}, d2 = {"Lcom/talabat/adapters/restaurantslist/viewholders/ToggleHeaderViewHolder$OnHeaderToggleClickListener;", "", "cardViewClicked", "", "listViewClicked", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
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
    public static final void m9506bind$lambda0(ToggleHeaderViewHolder toggleHeaderViewHolder, View view) {
        Intrinsics.checkNotNullParameter(toggleHeaderViewHolder, "this$0");
        if (!((ImageButton) toggleHeaderViewHolder.getContainerView().findViewById(R.id.cardViewBtn)).isSelected()) {
            OnHeaderToggleClickListener onHeaderToggleClickListener = toggleHeaderViewHolder.clickListener;
            if (onHeaderToggleClickListener != null) {
                onHeaderToggleClickListener.cardViewClicked();
            }
            toggleHeaderViewHolder.setColorFilter(R.color.ds_primary_100, R.color.ds_neutral_100);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: bind$lambda-1  reason: not valid java name */
    public static final void m9507bind$lambda1(ToggleHeaderViewHolder toggleHeaderViewHolder, View view) {
        Intrinsics.checkNotNullParameter(toggleHeaderViewHolder, "this$0");
        if (!((ImageButton) toggleHeaderViewHolder.getContainerView().findViewById(R.id.listViewBtn)).isSelected()) {
            OnHeaderToggleClickListener onHeaderToggleClickListener = toggleHeaderViewHolder.clickListener;
            if (onHeaderToggleClickListener != null) {
                onHeaderToggleClickListener.listViewClicked();
            }
            toggleHeaderViewHolder.setColorFilter(R.color.ds_neutral_100, R.color.ds_primary_100);
        }
    }

    private final void setColorFilter(int i11, int i12) {
        ((ImageButton) getContainerView().findViewById(R.id.cardViewBtn)).setColorFilter(ContextCompat.getColor(getContainerView().getContext(), i11));
        ((ImageButton) getContainerView().findViewById(R.id.listViewBtn)).setColorFilter(ContextCompat.getColor(getContainerView().getContext(), i12));
    }

    public final void bind(boolean z11, int i11) {
        if (z11) {
            ((ImageButton) getContainerView().findViewById(R.id.cardViewBtn)).setSelected(true);
            ((ImageButton) getContainerView().findViewById(R.id.listViewBtn)).setSelected(false);
            setColorFilter(R.color.ds_primary_100, R.color.ds_neutral_100);
        } else {
            ((ImageButton) getContainerView().findViewById(R.id.cardViewBtn)).setSelected(false);
            ((ImageButton) getContainerView().findViewById(R.id.listViewBtn)).setSelected(true);
            setColorFilter(R.color.ds_neutral_100, R.color.ds_primary_100);
        }
        ((ImageButton) getContainerView().findViewById(R.id.cardViewBtn)).setOnClickListener(new a(this));
        ((ImageButton) getContainerView().findViewById(R.id.listViewBtn)).setOnClickListener(new b(this));
        if (TalabatExperiment.INSTANCE.getBooleanVariant(TalabatExperimentConstants.HIDE_TOGGLE_VIEW, false, TalabatExperimentDataSourceStrategy.APPTIMIZE)) {
            ((LinearLayout) getContainerView().findViewById(R.id.toggleContainer)).setVisibility(8);
        } else {
            ((LinearLayout) getContainerView().findViewById(R.id.toggleContainer)).setVisibility(0);
        }
        if (i11 == 0) {
            ((TextView) getContainerView().findViewById(R.id.title)).setText(R.string.header_all_restuarant);
        } else {
            ((TextView) getContainerView().findViewById(R.id.title)).setText(R.string.header_all_stores);
        }
    }

    @NotNull
    public View getContainerView() {
        return this.containerView;
    }
}
