package com.talabat.sdsquad.ui.cuisines.adapters.viewholders;

import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.talabat.sdsquad.R;
import com.talabat.sdsquad.ui.cuisines.displaymodels.CuisineDisplayModel;
import gu.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.extensions.LayoutContainer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u000eB\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rR\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u000f"}, d2 = {"Lcom/talabat/sdsquad/ui/cuisines/adapters/viewholders/CuisineViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lkotlinx/android/extensions/LayoutContainer;", "containerView", "Landroid/view/View;", "clickListener", "Lcom/talabat/sdsquad/ui/cuisines/adapters/viewholders/CuisineViewHolder$OnCuisineClickListener;", "(Landroid/view/View;Lcom/talabat/sdsquad/ui/cuisines/adapters/viewholders/CuisineViewHolder$OnCuisineClickListener;)V", "getContainerView", "()Landroid/view/View;", "bind", "", "model", "Lcom/talabat/sdsquad/ui/cuisines/displaymodels/CuisineDisplayModel;", "OnCuisineClickListener", "com_talabat_NewArchi_sdsquad_sdsquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CuisineViewHolder extends RecyclerView.ViewHolder implements LayoutContainer {
    @Nullable
    private final OnCuisineClickListener clickListener;
    @NotNull
    private final View containerView;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/talabat/sdsquad/ui/cuisines/adapters/viewholders/CuisineViewHolder$OnCuisineClickListener;", "", "cuisineClicked", "", "cuisineModel", "Lcom/talabat/sdsquad/ui/cuisines/displaymodels/CuisineDisplayModel;", "com_talabat_NewArchi_sdsquad_sdsquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface OnCuisineClickListener {
        void cuisineClicked(@NotNull CuisineDisplayModel cuisineDisplayModel);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CuisineViewHolder(@NotNull View view, @Nullable OnCuisineClickListener onCuisineClickListener) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "containerView");
        this.containerView = view;
        this.clickListener = onCuisineClickListener;
    }

    /* access modifiers changed from: private */
    /* renamed from: bind$lambda-0  reason: not valid java name */
    public static final void m10817bind$lambda0(CuisineViewHolder cuisineViewHolder, CuisineDisplayModel cuisineDisplayModel, View view) {
        Intrinsics.checkNotNullParameter(cuisineViewHolder, "this$0");
        Intrinsics.checkNotNullParameter(cuisineDisplayModel, "$model");
        OnCuisineClickListener onCuisineClickListener = cuisineViewHolder.clickListener;
        if (onCuisineClickListener != null) {
            onCuisineClickListener.cuisineClicked(cuisineDisplayModel);
        }
    }

    public final void bind(@NotNull CuisineDisplayModel cuisineDisplayModel) {
        Intrinsics.checkNotNullParameter(cuisineDisplayModel, DeviceRequestsHelper.DEVICE_INFO_MODEL);
        ((TextView) getContainerView().findViewById(R.id.cuisineName)).setText(cuisineDisplayModel.getName());
        ((RadioButton) getContainerView().findViewById(R.id.cuisineRadioBtn)).setChecked(cuisineDisplayModel.isOn());
        getContainerView().setOnClickListener(new a(this, cuisineDisplayModel));
    }

    @NotNull
    public View getContainerView() {
        return this.containerView;
    }
}
