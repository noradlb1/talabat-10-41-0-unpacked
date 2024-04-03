package com.talabat.sdsquad.ui.vendorslist.adapters.viewholders;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
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
import com.talabat.sdsquad.ui.vendorslist.displaymodels.InlineAdDisplayModel;
import jp.wasabeef.glide.transformations.RoundedCornersTransformation;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlinx.android.extensions.LayoutContainer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rH\u0002J\u0010\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\rH\u0002J\u0010\u0010\u0012\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\rH\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/talabat/sdsquad/ui/vendorslist/adapters/viewholders/InlineAdViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lkotlinx/android/extensions/LayoutContainer;", "containerView", "Landroid/view/View;", "(Landroid/view/View;)V", "getContainerView", "()Landroid/view/View;", "bind", "", "inlineAdDisplayModel", "Lcom/talabat/sdsquad/ui/vendorslist/displaymodels/InlineAdDisplayModel;", "getVendorLogoUrl", "", "baseUrl", "vendorLogo", "setInlineAd", "inlineAdImage", "setVendorLogo", "com_talabat_NewArchi_sdsquad_sdsquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class InlineAdViewHolder extends RecyclerView.ViewHolder implements LayoutContainer {
    @NotNull
    private final View containerView;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public InlineAdViewHolder(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "containerView");
        this.containerView = view;
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

    private final void setInlineAd(String str) {
        Resources resources = getContainerView().getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "containerView.resources");
        float applyDimension = TypedValue.applyDimension(1, 8.0f, resources.getDisplayMetrics());
        RequestBuilder<Drawable> load = Glide.with(getContainerView().getContext()).load(str);
        View containerView2 = getContainerView();
        int i11 = R.id.adImage;
        ((RequestBuilder) ((RequestBuilder) load.override(((ImageView) containerView2.findViewById(i11)).getWidth(), ((ImageView) getContainerView().findViewById(i11)).getHeight())).transform((Transformation<Bitmap>) new MultiTransformation((Transformation<T>[]) new Transformation[]{new CenterCrop(), new RoundedCornersTransformation((int) applyDimension, 0)}))).into((ImageView) getContainerView().findViewById(i11));
    }

    private final void setVendorLogo(String str) {
        RequestBuilder<Drawable> load = Glide.with(getContainerView().getContext()).load(str);
        View containerView2 = getContainerView();
        int i11 = R.id.vendorLogo;
        ((RequestBuilder) load.override(((ImageView) containerView2.findViewById(i11)).getWidth(), ((ImageView) getContainerView().findViewById(i11)).getHeight())).into((ImageView) getContainerView().findViewById(i11));
    }

    public final void bind(@Nullable InlineAdDisplayModel inlineAdDisplayModel) {
        if (inlineAdDisplayModel != null) {
            ((TextView) getContainerView().findViewById(R.id.vendorName)).setText(inlineAdDisplayModel.getVendorName());
            ((TextView) getContainerView().findViewById(R.id.vendorCuisines)).setText(inlineAdDisplayModel.getVendorCuisine());
            setVendorLogo(getVendorLogoUrl(inlineAdDisplayModel.getBaseUrl(), inlineAdDisplayModel.getVendorLogo()));
            setInlineAd(inlineAdDisplayModel.getAdsImage());
        }
    }

    @NotNull
    public View getContainerView() {
        return this.containerView;
    }
}
