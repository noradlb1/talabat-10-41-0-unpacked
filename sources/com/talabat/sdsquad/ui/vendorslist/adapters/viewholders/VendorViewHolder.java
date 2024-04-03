package com.talabat.sdsquad.ui.vendorslist.adapters.viewholders;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.MultiTransformation;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.talabat.localization.R;
import com.talabat.sdsquad.core.GlideActivityExceptionHandler;
import com.talabat.sdsquad.extentions.ViewExtentionsKt;
import com.talabat.sdsquad.ui.customviews.VendorTags;
import com.talabat.sdsquad.ui.vendorslist.displaymodels.VendorDisplayModel;
import com.talabat.talabatcommon.views.TalabatRateView;
import java.util.Arrays;
import jp.wasabeef.glide.transformations.RoundedCornersTransformation;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Regex;
import kotlinx.android.extensions.LayoutContainer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ou.f;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u001eB\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000fH\u0002J(\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0018\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u001aH\u0002J\u0010\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u000fH\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u001f"}, d2 = {"Lcom/talabat/sdsquad/ui/vendorslist/adapters/viewholders/VendorViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lkotlinx/android/extensions/LayoutContainer;", "containerView", "Landroid/view/View;", "clickListener", "Lcom/talabat/sdsquad/ui/vendorslist/adapters/viewholders/VendorViewHolder$VendorClickListener;", "(Landroid/view/View;Lcom/talabat/sdsquad/ui/vendorslist/adapters/viewholders/VendorViewHolder$VendorClickListener;)V", "getContainerView", "()Landroid/view/View;", "bind", "", "vendorDisplayModel", "Lcom/talabat/sdsquad/ui/vendorslist/displaymodels/VendorDisplayModel;", "getVendorLogoUrl", "", "baseUrl", "vendorLogo", "setDeliveryFee", "context", "Landroid/content/Context;", "isTgo", "", "deliveryFee", "", "decimalCount", "", "setDeliveryTime", "deliveryTime", "setVendorLogo", "VendorClickListener", "com_talabat_NewArchi_sdsquad_sdsquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VendorViewHolder extends RecyclerView.ViewHolder implements LayoutContainer {
    @Nullable
    private final VendorClickListener clickListener;
    @NotNull
    private final View containerView;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/talabat/sdsquad/ui/vendorslist/adapters/viewholders/VendorViewHolder$VendorClickListener;", "", "vendorClicked", "", "vendor", "Lcom/talabat/sdsquad/ui/vendorslist/displaymodels/VendorDisplayModel;", "com_talabat_NewArchi_sdsquad_sdsquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface VendorClickListener {
        void vendorClicked(@NotNull VendorDisplayModel vendorDisplayModel);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VendorViewHolder(@NotNull View view, @Nullable VendorClickListener vendorClickListener) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "containerView");
        this.containerView = view;
        this.clickListener = vendorClickListener;
    }

    /* access modifiers changed from: private */
    /* renamed from: bind$lambda-0  reason: not valid java name */
    public static final void m10894bind$lambda0(VendorViewHolder vendorViewHolder, VendorDisplayModel vendorDisplayModel, View view) {
        Intrinsics.checkNotNullParameter(vendorViewHolder, "this$0");
        Intrinsics.checkNotNullParameter(vendorDisplayModel, "$vendorDisplayModel");
        VendorClickListener vendorClickListener = vendorViewHolder.clickListener;
        if (vendorClickListener != null) {
            vendorClickListener.vendorClicked(vendorDisplayModel);
        }
    }

    private final String getVendorLogoUrl(String str, String str2) {
        boolean z11;
        if (str2.length() > 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11) {
            return "";
        }
        String replace = new Regex(" ").replace((CharSequence) str2, "%20");
        return str + "restaurants/" + replace;
    }

    private final String setDeliveryFee(Context context, boolean z11, double d11, int i11) {
        boolean z12;
        boolean z13;
        if (z11) {
            if (d11 == 0.0d) {
                z13 = true;
            } else {
                z13 = false;
            }
            if (z13) {
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String format = String.format("%s: %s", Arrays.copyOf(new Object[]{context.getResources().getString(R.string.vendor_service), context.getResources().getString(R.string.vendor_service_free)}, 2));
                Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                return format;
            }
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
            String format2 = String.format("%s: %." + i11 + "f", Arrays.copyOf(new Object[]{context.getResources().getString(R.string.vendor_service), Double.valueOf(d11)}, 2));
            Intrinsics.checkNotNullExpressionValue(format2, "format(format, *args)");
            return format2;
        }
        if (d11 == 0.0d) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (z12) {
            StringCompanionObject stringCompanionObject3 = StringCompanionObject.INSTANCE;
            String format3 = String.format("%s: %s", Arrays.copyOf(new Object[]{context.getResources().getString(R.string.vendor_delivery), context.getResources().getString(R.string.vendor_service_free)}, 2));
            Intrinsics.checkNotNullExpressionValue(format3, "format(format, *args)");
            return format3;
        }
        StringCompanionObject stringCompanionObject4 = StringCompanionObject.INSTANCE;
        String format4 = String.format("%s: %." + i11 + "f", Arrays.copyOf(new Object[]{context.getResources().getString(R.string.vendor_delivery), Double.valueOf(d11)}, 2));
        Intrinsics.checkNotNullExpressionValue(format4, "format(format, *args)");
        return format4;
    }

    private final String setDeliveryTime(Context context, int i11) {
        if (i11 < 120) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format("%d-%d %s", Arrays.copyOf(new Object[]{Integer.valueOf(i11 - 10), Integer.valueOf(i11), context.getResources().getString(R.string.vendor_deliver_minutes)}, 3));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            return format;
        } else if (i11 % 60 != 0) {
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
            String format2 = String.format("%s: %d %s", Arrays.copyOf(new Object[]{context.getResources().getString(R.string.vendor_deliver_time), Integer.valueOf(i11), context.getResources().getString(R.string.vendor_deliver_minutes)}, 3));
            Intrinsics.checkNotNullExpressionValue(format2, "format(format, *args)");
            return format2;
        } else {
            StringCompanionObject stringCompanionObject3 = StringCompanionObject.INSTANCE;
            String format3 = String.format("%s: %d %s", Arrays.copyOf(new Object[]{context.getResources().getString(R.string.vendor_deliver_time), Integer.valueOf(i11 / 60), context.getResources().getString(R.string.vendor_deliver_hours)}, 3));
            Intrinsics.checkNotNullExpressionValue(format3, "format(format, *args)");
            return format3;
        }
    }

    private final void setVendorLogo(String str) {
        boolean z11;
        if (str.length() > 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11 || !GlideActivityExceptionHandler.INSTANCE.isValidContextForGlide(getContainerView().getContext())) {
            ((ImageView) getContainerView().findViewById(com.talabat.sdsquad.R.id.vendorLogo)).setVisibility(8);
            ((ProgressBar) getContainerView().findViewById(com.talabat.sdsquad.R.id.progressBar)).setVisibility(8);
            return;
        }
        Resources resources = getContainerView().getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "containerView.resources");
        float applyDimension = TypedValue.applyDimension(1, 8.0f, resources.getDisplayMetrics());
        View containerView2 = getContainerView();
        int i11 = com.talabat.sdsquad.R.id.vendorLogo;
        ((ImageView) containerView2.findViewById(i11)).setVisibility(0);
        ((ProgressBar) getContainerView().findViewById(com.talabat.sdsquad.R.id.progressBar)).setVisibility(0);
        ((RequestBuilder) Glide.with(getContainerView().getContext()).load(str).transform((Transformation<Bitmap>) new MultiTransformation((Transformation<T>[]) new Transformation[]{new CenterCrop(), new RoundedCornersTransformation((int) applyDimension, 0)}))).listener(new VendorViewHolder$setVendorLogo$1(this)).into((ImageView) getContainerView().findViewById(i11));
    }

    public final void bind(@NotNull VendorDisplayModel vendorDisplayModel) {
        boolean z11;
        Intrinsics.checkNotNullParameter(vendorDisplayModel, "vendorDisplayModel");
        getContainerView().setOnClickListener(new f(this, vendorDisplayModel));
        ((TextView) getContainerView().findViewById(com.talabat.sdsquad.R.id.vendorName)).setText(vendorDisplayModel.getVendorName());
        ((TextView) getContainerView().findViewById(com.talabat.sdsquad.R.id.vendorCuisines)).setText(vendorDisplayModel.getCuisines());
        ((TextView) getContainerView().findViewById(com.talabat.sdsquad.R.id.vendorDeliverTime)).setText(vendorDisplayModel.getDeliveryTimeText());
        TextView textView = (TextView) getContainerView().findViewById(com.talabat.sdsquad.R.id.vendorNewTag);
        Intrinsics.checkNotNullExpressionValue(textView, "containerView.vendorNewTag");
        boolean z12 = false;
        ViewExtentionsKt.show$default(textView, vendorDisplayModel.isNew(), 0, 2, (Object) null);
        if (vendorDisplayModel.getRate() == 0.0f) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            TalabatRateView talabatRateView = (TalabatRateView) getContainerView().findViewById(com.talabat.sdsquad.R.id.vendorRateWidget);
            Intrinsics.checkNotNullExpressionValue(talabatRateView, "containerView.vendorRateWidget");
            ViewExtentionsKt.show$default(talabatRateView, false, 0, 2, (Object) null);
        } else {
            TalabatRateView talabatRateView2 = (TalabatRateView) getContainerView().findViewById(com.talabat.sdsquad.R.id.vendorRateWidget);
            Intrinsics.checkNotNullExpressionValue(talabatRateView2, "containerView.vendorRateWidget");
            ViewExtentionsKt.show$default(talabatRateView2, true, 0, 2, (Object) null);
        }
        ((TalabatRateView) getContainerView().findViewById(com.talabat.sdsquad.R.id.vendorRateWidget)).setRateValue(vendorDisplayModel.getRate());
        Context context = getContainerView().getContext();
        Intrinsics.checkNotNullExpressionValue(context, "containerView.context");
        ((TextView) getContainerView().findViewById(com.talabat.sdsquad.R.id.vendorDeliverFee)).setText(setDeliveryFee(context, vendorDisplayModel.isTgo(), vendorDisplayModel.getDeliveryFee(), vendorDisplayModel.getDecimalCount()));
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("%s: %." + vendorDisplayModel.getDecimalCount() + "f", Arrays.copyOf(new Object[]{getContainerView().getContext().getResources().getString(R.string.vendor_minimum_order), Double.valueOf(vendorDisplayModel.getMinimumOrderAmount())}, 2));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        ((TextView) getContainerView().findViewById(com.talabat.sdsquad.R.id.vendorMinimumOrder)).setText(format);
        setVendorLogo(getVendorLogoUrl(vendorDisplayModel.getBaseUrl(), vendorDisplayModel.getVendorLogo()));
        View containerView2 = getContainerView();
        int i11 = com.talabat.sdsquad.R.id.vendorTags;
        ((VendorTags) containerView2.findViewById(i11)).setOffersVisibility(vendorDisplayModel.getHasOffers());
        ((VendorTags) getContainerView().findViewById(i11)).setCashOnlyVisibility(vendorDisplayModel.isCashOnly());
        ((VendorTags) getContainerView().findViewById(i11)).setExtraTagVisibility(vendorDisplayModel.isExtra());
        ((VendorTags) getContainerView().findViewById(i11)).setSafeDropOffTagVisibility(vendorDisplayModel.isSafeDropOff());
        VendorTags vendorTags = (VendorTags) getContainerView().findViewById(i11);
        if (vendorDisplayModel.isTgo() || vendorDisplayModel.isLiveTracking()) {
            z12 = true;
        }
        vendorTags.setLiveTrackingVisibility(z12);
        ((VendorTags) getContainerView().findViewById(i11)).setDiscountVisibility(vendorDisplayModel.getHasDiscounts(), vendorDisplayModel.getDiscountTxt());
    }

    @NotNull
    public View getContainerView() {
        return this.containerView;
    }
}
