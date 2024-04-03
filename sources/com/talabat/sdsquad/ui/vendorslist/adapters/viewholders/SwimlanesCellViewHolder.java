package com.talabat.sdsquad.ui.vendorslist.adapters.viewholders;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.MultiTransformation;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.talabat.sdsquad.R;
import com.talabat.sdsquad.core.GlideActivityExceptionHandler;
import com.talabat.sdsquad.extentions.ViewExtentionsKt;
import com.talabat.sdsquad.ui.vendorslist.adapters.viewholders.VendorViewHolder;
import com.talabat.sdsquad.ui.vendorslist.displaymodels.VendorDisplayModel;
import com.talabat.talabatcommon.views.TalabatRateView;
import jp.wasabeef.glide.transformations.RoundedCornersTransformation;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.extensions.LayoutContainer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ou.b;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u0012\u0010\u000e\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0011"}, d2 = {"Lcom/talabat/sdsquad/ui/vendorslist/adapters/viewholders/SwimlanesCellViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lkotlinx/android/extensions/LayoutContainer;", "containerView", "Landroid/view/View;", "clickListener", "Lcom/talabat/sdsquad/ui/vendorslist/adapters/viewholders/VendorViewHolder$VendorClickListener;", "(Landroid/view/View;Lcom/talabat/sdsquad/ui/vendorslist/adapters/viewholders/VendorViewHolder$VendorClickListener;)V", "getContainerView", "()Landroid/view/View;", "bind", "", "vendorDisplayModel", "Lcom/talabat/sdsquad/ui/vendorslist/displaymodels/VendorDisplayModel;", "setVendorCover", "coverImage", "", "com_talabat_NewArchi_sdsquad_sdsquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SwimlanesCellViewHolder extends RecyclerView.ViewHolder implements LayoutContainer {
    @Nullable
    private final VendorViewHolder.VendorClickListener clickListener;
    @NotNull
    private final View containerView;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SwimlanesCellViewHolder(@NotNull View view, @Nullable VendorViewHolder.VendorClickListener vendorClickListener) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "containerView");
        this.containerView = view;
        this.clickListener = vendorClickListener;
    }

    /* access modifiers changed from: private */
    /* renamed from: bind$lambda-0  reason: not valid java name */
    public static final void m10890bind$lambda0(SwimlanesCellViewHolder swimlanesCellViewHolder, VendorDisplayModel vendorDisplayModel, View view) {
        Intrinsics.checkNotNullParameter(swimlanesCellViewHolder, "this$0");
        Intrinsics.checkNotNullParameter(vendorDisplayModel, "$vendorDisplayModel");
        VendorViewHolder.VendorClickListener vendorClickListener = swimlanesCellViewHolder.clickListener;
        if (vendorClickListener != null) {
            vendorClickListener.vendorClicked(vendorDisplayModel);
        }
    }

    private final void setVendorCover(String str) {
        boolean z11;
        if (str == null || str.length() == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11 || !GlideActivityExceptionHandler.INSTANCE.isValidContextForGlide(getContainerView().getContext())) {
            ((ImageView) getContainerView().findViewById(R.id.vendorImage)).setVisibility(4);
            return;
        }
        Resources resources = getContainerView().getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "containerView.resources");
        ((RequestBuilder) ((RequestBuilder) Glide.with(getContainerView().getContext()).load(str).override(getContainerView().getWidth(), (int) TypedValue.applyDimension(1, 120.0f, resources.getDisplayMetrics()))).transform((Transformation<Bitmap>) new MultiTransformation((Transformation<T>[]) new Transformation[]{new CenterCrop(), new RoundedCornersTransformation((int) TypedValue.applyDimension(1, 8.0f, resources.getDisplayMetrics()), 0)}))).into((ImageView) getContainerView().findViewById(R.id.vendorImage));
    }

    public final void bind(@NotNull VendorDisplayModel vendorDisplayModel) {
        boolean z11;
        Intrinsics.checkNotNullParameter(vendorDisplayModel, "vendorDisplayModel");
        getContainerView().setOnClickListener(new b(this, vendorDisplayModel));
        ((TextView) getContainerView().findViewById(R.id.vendorName)).setText(vendorDisplayModel.getVendorName());
        ((TextView) getContainerView().findViewById(R.id.vendorDeliverTime)).setText(vendorDisplayModel.getDeliveryTimeText());
        ((TextView) getContainerView().findViewById(R.id.vendorCuisines)).setText(vendorDisplayModel.getCuisines());
        if (vendorDisplayModel.getRate() == 0.0f) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            TalabatRateView talabatRateView = (TalabatRateView) getContainerView().findViewById(R.id.vendorRateWidget);
            Intrinsics.checkNotNullExpressionValue(talabatRateView, "containerView.vendorRateWidget");
            ViewExtentionsKt.show$default(talabatRateView, false, 0, 2, (Object) null);
        } else {
            TalabatRateView talabatRateView2 = (TalabatRateView) getContainerView().findViewById(R.id.vendorRateWidget);
            Intrinsics.checkNotNullExpressionValue(talabatRateView2, "containerView.vendorRateWidget");
            ViewExtentionsKt.show$default(talabatRateView2, true, 0, 2, (Object) null);
        }
        ((TalabatRateView) getContainerView().findViewById(R.id.vendorRateWidget)).setRateValue(vendorDisplayModel.getRate());
        setVendorCover(vendorDisplayModel.getBaseUrl() + "restaurants/" + vendorDisplayModel.getCoverImage());
    }

    @NotNull
    public View getContainerView() {
        return this.containerView;
    }
}
