package com.talabat.sdsquad.ui.restaurantssearch.globalsearch.adapters.viewholders;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.talabat.sdsquad.R;
import com.talabat.sdsquad.core.GlideActivityExceptionHandler;
import com.talabat.sdsquad.extentions.ViewExtentionsKt;
import com.talabat.sdsquad.ui.restaurantssearch.globalsearch.displaymodels.DishDisplayModel;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.android.extensions.LayoutContainer;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rH\u0002J\u0010\u0010\u0010\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\rH\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/talabat/sdsquad/ui/restaurantssearch/globalsearch/adapters/viewholders/DishViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lkotlinx/android/extensions/LayoutContainer;", "containerView", "Landroid/view/View;", "(Landroid/view/View;)V", "getContainerView", "()Landroid/view/View;", "bind", "", "dishDisplayModel", "Lcom/talabat/sdsquad/ui/restaurantssearch/globalsearch/displaymodels/DishDisplayModel;", "getDishLogoUrl", "", "baseUrl", "vendorLogo", "setDishLogo", "com_talabat_NewArchi_sdsquad_sdsquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DishViewHolder extends RecyclerView.ViewHolder implements LayoutContainer {
    @NotNull
    private final View containerView;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DishViewHolder(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "containerView");
        this.containerView = view;
    }

    private final String getDishLogoUrl(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return "";
        }
        if (StringsKt__StringsKt.contains$default((CharSequence) str2, (CharSequence) "menuitems/", false, 2, (Object) null)) {
            return str2;
        }
        String encode = Uri.encode(str2);
        return StringsKt__StringsJVMKt.replace$default(str + "menuitems/" + encode, " ", "%20", false, 4, (Object) null);
    }

    private final void setDishLogo(String str) {
        boolean z11;
        if (str.length() > 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11 || !GlideActivityExceptionHandler.INSTANCE.isValidContextForGlide(getContainerView().getContext())) {
            ((ImageView) getContainerView().findViewById(R.id.dishLogo)).setVisibility(8);
            ((ProgressBar) getContainerView().findViewById(R.id.progressBar)).setVisibility(8);
            return;
        }
        View containerView2 = getContainerView();
        int i11 = R.id.dishLogo;
        ((ImageView) containerView2.findViewById(i11)).setVisibility(0);
        ((ProgressBar) getContainerView().findViewById(R.id.progressBar)).setVisibility(0);
        RequestBuilder<Drawable> load = Glide.with(getContainerView().getContext()).load(str);
        View containerView3 = getContainerView();
        int i12 = R.id.dishLogoContainer;
        ((RequestBuilder) load.override(((FrameLayout) containerView3.findViewById(i12)).getWidth(), ((FrameLayout) getContainerView().findViewById(i12)).getHeight())).listener(new DishViewHolder$setDishLogo$1(this)).into((ImageView) getContainerView().findViewById(i11));
    }

    public final void bind(@NotNull DishDisplayModel dishDisplayModel) {
        Intrinsics.checkNotNullParameter(dishDisplayModel, "dishDisplayModel");
        ((TextView) getContainerView().findViewById(R.id.dishName)).setText(dishDisplayModel.getDishName());
        ((TextView) getContainerView().findViewById(R.id.vendorName)).setText(dishDisplayModel.getVendorName());
        ((TextView) getContainerView().findViewById(R.id.dishPrice)).setText(String.valueOf(dishDisplayModel.getPrice()));
        if (dishDisplayModel.getDishCount() > 1) {
            View containerView2 = getContainerView();
            int i11 = R.id.dishCount;
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format("%d %s", Arrays.copyOf(new Object[]{Integer.valueOf(dishDisplayModel.getDishCount()), "similar"}, 2));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            ((TextView) containerView2.findViewById(i11)).setText(format);
            TextView textView = (TextView) getContainerView().findViewById(i11);
            Intrinsics.checkNotNullExpressionValue(textView, "containerView.dishCount");
            ViewExtentionsKt.show$default(textView, true, 0, 2, (Object) null);
        } else {
            TextView textView2 = (TextView) getContainerView().findViewById(R.id.dishCount);
            Intrinsics.checkNotNullExpressionValue(textView2, "containerView.dishCount");
            ViewExtentionsKt.show$default(textView2, false, 0, 2, (Object) null);
        }
        setDishLogo(getDishLogoUrl(dishDisplayModel.getBaseUrl(), dishDisplayModel.getDishImage()));
    }

    @NotNull
    public View getContainerView() {
        return this.containerView;
    }
}
