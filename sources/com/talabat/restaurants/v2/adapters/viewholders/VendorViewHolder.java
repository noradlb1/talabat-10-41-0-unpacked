package com.talabat.restaurants.v2.adapters.viewholders;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.widget.ImageViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.load.MultiTransformation;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestListener;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.talabat.R;
import com.talabat.TalabatTextView;
import com.talabat.designhelpers.GlideActivityExceptionHandler;
import com.talabat.geminterfaces.OnGemAlertDialogClickListener;
import com.talabat.talabatcommon.helpers.GlideApp;
import datamodels.Restaurant;
import java.util.Arrays;
import jt.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.android.extensions.LayoutContainer;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rR\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/talabat/restaurants/v2/adapters/viewholders/VendorViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lkotlinx/android/extensions/LayoutContainer;", "containerView", "Landroid/view/View;", "listener", "Lcom/talabat/geminterfaces/OnGemAlertDialogClickListener;", "(Landroid/view/View;Lcom/talabat/geminterfaces/OnGemAlertDialogClickListener;)V", "getContainerView", "()Landroid/view/View;", "bind", "", "vendor", "Ldatamodels/Restaurant;", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VendorViewHolder extends RecyclerView.ViewHolder implements LayoutContainer {
    @NotNull
    private final View containerView;
    @NotNull
    private final OnGemAlertDialogClickListener listener;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VendorViewHolder(@NotNull View view, @NotNull OnGemAlertDialogClickListener onGemAlertDialogClickListener) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "containerView");
        Intrinsics.checkNotNullParameter(onGemAlertDialogClickListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.containerView = view;
        this.listener = onGemAlertDialogClickListener;
    }

    /* access modifiers changed from: private */
    /* renamed from: bind$lambda-0  reason: not valid java name */
    public static final void m10732bind$lambda0(VendorViewHolder vendorViewHolder, Restaurant restaurant, View view) {
        Intrinsics.checkNotNullParameter(vendorViewHolder, "this$0");
        Intrinsics.checkNotNullParameter(restaurant, "$vendor");
        vendorViewHolder.listener.onInterestClicked(restaurant);
    }

    public final void bind(@NotNull Restaurant restaurant) {
        boolean z11;
        Intrinsics.checkNotNullParameter(restaurant, "vendor");
        getContainerView().setOnClickListener(new a(this, restaurant));
        ((TextView) getContainerView().findViewById(R.id.vendorName)).setText(restaurant.f13873name);
        ((TextView) getContainerView().findViewById(R.id.textView_averageDeliveryTime)).setText(restaurant.deliveryTime);
        ((TextView) getContainerView().findViewById(R.id.textView_cuisines)).setText(restaurant.getCuisineString());
        View containerView2 = getContainerView();
        int i11 = R.id.imageView_restaurantLogo;
        ((ImageView) containerView2.findViewById(i11)).setImageDrawable((Drawable) null);
        ((ProgressBar) getContainerView().findViewById(R.id.progressBar)).setVisibility(0);
        if (restaurant.getLogo() == null) {
            ((ImageView) getContainerView().findViewById(i11)).setImageResource(0);
            ((ImageView) getContainerView().findViewById(i11)).setVisibility(0);
        } else if (GlideActivityExceptionHandler.INSTANCE.isValidContextForGlide(getContainerView().getContext())) {
            Resources resources = getContainerView().getContext().getResources();
            Intrinsics.checkNotNullExpressionValue(resources, "containerView.context.resources");
            float applyDimension = TypedValue.applyDimension(1, 8.0f, resources.getDisplayMetrics());
            GlideApp.with(getContainerView().getContext()).clear((View) (ImageView) getContainerView().findViewById(i11));
            GlideApp.with(getContainerView().getContext()).load(restaurant.getLogo()).transform((Transformation) new MultiTransformation((Transformation<T>[]) new Transformation[]{new CenterCrop(), new RoundedCorners((int) applyDimension)})).listener((RequestListener) new VendorViewHolder$bind$2(restaurant, this)).placeholder((int) R.drawable.glide_placeholder).into((ImageView) getContainerView().findViewById(i11));
        }
        if (restaurant.getDeliveryCharges() == 0.0f) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            String str = getContainerView().getContext().getResources().getString(R.string.delivery_amount_place_order) + " " + getContainerView().getContext().getResources().getString(R.string.free_caps);
            if (restaurant.isTalabatGo) {
                str = getContainerView().getContext().getResources().getString(R.string.f54892service) + " " + getContainerView().getContext().getResources().getString(R.string.free_caps);
            }
            ((TalabatTextView) getContainerView().findViewById(R.id.textView_deliveryCost)).setText(str);
        } else if (restaurant.isTalabatGo) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format("%s %s", Arrays.copyOf(new Object[]{getContainerView().getContext().getResources().getString(R.string.f54892service), restaurant.getDisplayDeliveryChargesForList()}, 2));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            ((TalabatTextView) getContainerView().findViewById(R.id.textView_deliveryCost)).setText(format, TextView.BufferType.SPANNABLE);
        } else {
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
            String format2 = String.format("%s %s", Arrays.copyOf(new Object[]{getContainerView().getContext().getResources().getString(R.string.delivery_amount_place_order), restaurant.getDisplayDeliveryChargesForList()}, 2));
            Intrinsics.checkNotNullExpressionValue(format2, "format(format, *args)");
            ((TalabatTextView) getContainerView().findViewById(R.id.textView_deliveryCost)).setText(format2);
        }
        if (restaurant.getRating() <= 2.7f) {
            ((ImageView) getContainerView().findViewById(R.id.vendorRateAvatar)).setImageResource(R.drawable.ds_rating_okay);
            ((TextView) getContainerView().findViewById(R.id.vendorRateStatus)).setText(R.string.rate_fair);
        } else if (restaurant.getRating() <= 3.7f) {
            ((ImageView) getContainerView().findViewById(R.id.vendorRateAvatar)).setImageResource(R.drawable.ds_rating_good);
            ((TextView) getContainerView().findViewById(R.id.vendorRateStatus)).setText(R.string.rate_okay);
        } else if (restaurant.getRating() <= 4.5f) {
            ((ImageView) getContainerView().findViewById(R.id.vendorRateAvatar)).setImageResource(R.drawable.ds_rating_very_good);
            ((TextView) getContainerView().findViewById(R.id.vendorRateStatus)).setText(R.string.rate_very_good);
        } else {
            View containerView3 = getContainerView();
            int i12 = R.id.vendorRateAvatar;
            ((ImageView) containerView3.findViewById(i12)).setImageResource(R.drawable.ds_rating_very_good_filled);
            ImageViewCompat.setImageTintList((ImageView) getContainerView().findViewById(i12), ColorStateList.valueOf(ContextCompat.getColor(getContainerView().getContext(), R.color.ds_alert_100)));
            ((TextView) getContainerView().findViewById(R.id.vendorRateStatus)).setText(R.string.rate_amazing);
        }
        if (restaurant.getRating() > 0.0f) {
            ((ImageView) getContainerView().findViewById(R.id.vendorRateAvatar)).setVisibility(0);
            ((TextView) getContainerView().findViewById(R.id.vendorRateStatus)).setVisibility(0);
            if (restaurant.isNewRestaurant) {
                ((TextView) getContainerView().findViewById(R.id.imageView_newTag)).setVisibility(0);
            } else {
                ((TextView) getContainerView().findViewById(R.id.imageView_newTag)).setVisibility(8);
            }
        } else if (restaurant.isNewRestaurant) {
            ((TextView) getContainerView().findViewById(R.id.imageView_newTag)).setVisibility(0);
            ((TextView) getContainerView().findViewById(R.id.vendorRateStatus)).setVisibility(8);
            ((ImageView) getContainerView().findViewById(R.id.vendorRateAvatar)).setVisibility(8);
        } else {
            ((ImageView) getContainerView().findViewById(R.id.vendorRateAvatar)).setVisibility(0);
            ((TextView) getContainerView().findViewById(R.id.vendorRateStatus)).setVisibility(0);
            ((TextView) getContainerView().findViewById(R.id.imageView_newTag)).setVisibility(8);
        }
    }

    @NotNull
    public View getContainerView() {
        return this.containerView;
    }
}
