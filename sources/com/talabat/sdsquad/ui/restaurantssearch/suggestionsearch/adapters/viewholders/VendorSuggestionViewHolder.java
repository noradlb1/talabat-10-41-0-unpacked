package com.talabat.sdsquad.ui.restaurantssearch.suggestionsearch.adapters.viewholders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.talabat.sdsquad.R;
import com.talabat.sdsquad.core.GlideActivityExceptionHandler;
import com.talabat.sdsquad.ui.vendorslist.displaymodels.VendorDisplayModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlinx.android.extensions.LayoutContainer;
import mu.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0013B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000fH\u0002J\u0010\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u000fH\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/talabat/sdsquad/ui/restaurantssearch/suggestionsearch/adapters/viewholders/VendorSuggestionViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lkotlinx/android/extensions/LayoutContainer;", "containerView", "Landroid/view/View;", "clickListener", "Lcom/talabat/sdsquad/ui/restaurantssearch/suggestionsearch/adapters/viewholders/VendorSuggestionViewHolder$VendorClickListener;", "(Landroid/view/View;Lcom/talabat/sdsquad/ui/restaurantssearch/suggestionsearch/adapters/viewholders/VendorSuggestionViewHolder$VendorClickListener;)V", "getContainerView", "()Landroid/view/View;", "bind", "", "displayModel", "Lcom/talabat/sdsquad/ui/vendorslist/displaymodels/VendorDisplayModel;", "getVendorLogoUrl", "", "baseUrl", "vendorLogo", "setVendorLogo", "VendorClickListener", "com_talabat_NewArchi_sdsquad_sdsquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VendorSuggestionViewHolder extends RecyclerView.ViewHolder implements LayoutContainer {
    @Nullable
    private final VendorClickListener clickListener;
    @NotNull
    private final View containerView;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/talabat/sdsquad/ui/restaurantssearch/suggestionsearch/adapters/viewholders/VendorSuggestionViewHolder$VendorClickListener;", "", "vendorClicked", "", "vendor", "Lcom/talabat/sdsquad/ui/vendorslist/displaymodels/VendorDisplayModel;", "com_talabat_NewArchi_sdsquad_sdsquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface VendorClickListener {
        void vendorClicked(@NotNull VendorDisplayModel vendorDisplayModel);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VendorSuggestionViewHolder(@NotNull View view, @Nullable VendorClickListener vendorClickListener) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "containerView");
        this.containerView = view;
        this.clickListener = vendorClickListener;
    }

    /* access modifiers changed from: private */
    /* renamed from: bind$lambda-0  reason: not valid java name */
    public static final void m10859bind$lambda0(VendorSuggestionViewHolder vendorSuggestionViewHolder, VendorDisplayModel vendorDisplayModel, View view) {
        Intrinsics.checkNotNullParameter(vendorSuggestionViewHolder, "this$0");
        Intrinsics.checkNotNullParameter(vendorDisplayModel, "$displayModel");
        VendorClickListener vendorClickListener = vendorSuggestionViewHolder.clickListener;
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

    private final void setVendorLogo(String str) {
        boolean z11;
        if (str.length() > 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11 || !GlideActivityExceptionHandler.INSTANCE.isValidContextForGlide(getContainerView().getContext())) {
            ((ImageView) getContainerView().findViewById(R.id.vendorLogo)).setVisibility(8);
            return;
        }
        View containerView2 = getContainerView();
        int i11 = R.id.vendorLogo;
        ((ImageView) containerView2.findViewById(i11)).setVisibility(0);
        ((RequestBuilder) Glide.with(getContainerView().getContext()).load(str).override(((ImageView) getContainerView().findViewById(i11)).getWidth(), ((ImageView) getContainerView().findViewById(i11)).getHeight())).listener(new VendorSuggestionViewHolder$setVendorLogo$1(this)).into((ImageView) getContainerView().findViewById(i11));
    }

    public final void bind(@NotNull VendorDisplayModel vendorDisplayModel) {
        Intrinsics.checkNotNullParameter(vendorDisplayModel, "displayModel");
        getContainerView().setOnClickListener(new a(this, vendorDisplayModel));
        ((TextView) getContainerView().findViewById(R.id.vendorName)).setText(vendorDisplayModel.getVendorName());
        setVendorLogo(getVendorLogoUrl(vendorDisplayModel.getBaseUrl(), vendorDisplayModel.getVendorLogo()));
    }

    @NotNull
    public View getContainerView() {
        return this.containerView;
    }
}
