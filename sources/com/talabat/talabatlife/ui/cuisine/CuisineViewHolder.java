package com.talabat.talabatlife.ui.cuisine;

import android.view.View;
import android.widget.TextView;
import android.widget.ToggleButton;
import androidx.recyclerview.widget.RecyclerView;
import com.talabat.talabatlife.R;
import fw.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.extensions.LayoutContainer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u000eB\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rR\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/talabat/talabatlife/ui/cuisine/CuisineViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lkotlinx/android/extensions/LayoutContainer;", "containerView", "Landroid/view/View;", "cuisineClickListener", "Lcom/talabat/talabatlife/ui/cuisine/CuisineViewHolder$OnCuisineClicked;", "(Landroid/view/View;Lcom/talabat/talabatlife/ui/cuisine/CuisineViewHolder$OnCuisineClicked;)V", "getContainerView", "()Landroid/view/View;", "bind", "", "cuisine", "Lcom/talabat/talabatlife/ui/cuisine/CuisineDisplayModel;", "OnCuisineClicked", "com_talabat_NewArchi_TalabatLife_TalabatLife"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CuisineViewHolder extends RecyclerView.ViewHolder implements LayoutContainer {
    @NotNull
    private final View containerView;
    @Nullable
    private final OnCuisineClicked cuisineClickListener;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/talabat/talabatlife/ui/cuisine/CuisineViewHolder$OnCuisineClicked;", "", "cuisineClick", "", "cuisine", "Lcom/talabat/talabatlife/ui/cuisine/CuisineDisplayModel;", "com_talabat_NewArchi_TalabatLife_TalabatLife"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface OnCuisineClicked {
        void cuisineClick(@NotNull CuisineDisplayModel cuisineDisplayModel);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CuisineViewHolder(@NotNull View view, @Nullable OnCuisineClicked onCuisineClicked) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "containerView");
        this.containerView = view;
        this.cuisineClickListener = onCuisineClicked;
    }

    /* access modifiers changed from: private */
    /* renamed from: bind$lambda-0  reason: not valid java name */
    public static final void m5830bind$lambda0(CuisineViewHolder cuisineViewHolder, CuisineDisplayModel cuisineDisplayModel, View view) {
        Intrinsics.checkNotNullParameter(cuisineViewHolder, "this$0");
        Intrinsics.checkNotNullParameter(cuisineDisplayModel, "$cuisine");
        OnCuisineClicked onCuisineClicked = cuisineViewHolder.cuisineClickListener;
        if (onCuisineClicked != null) {
            onCuisineClicked.cuisineClick(cuisineDisplayModel);
        }
    }

    public final void bind(@NotNull CuisineDisplayModel cuisineDisplayModel) {
        Intrinsics.checkNotNullParameter(cuisineDisplayModel, "cuisine");
        ((TextView) getContainerView().findViewById(R.id.cuisineName)).setText(cuisineDisplayModel.getName());
        ((ToggleButton) getContainerView().findViewById(R.id.cuisinesCheckBox)).setChecked(cuisineDisplayModel.isSelected());
        getContainerView().setOnClickListener(new b(this, cuisineDisplayModel));
    }

    @NotNull
    public View getContainerView() {
        return this.containerView;
    }
}
