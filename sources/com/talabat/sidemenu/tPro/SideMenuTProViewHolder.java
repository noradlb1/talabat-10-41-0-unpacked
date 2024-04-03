package com.talabat.sidemenu.tPro;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.load.Transformation;
import com.talabat.R;
import com.talabat.TalabatTextView;
import com.talabat.darkstores.common.bindingAdapters.BindingAdaptersKt;
import com.talabat.darkstores.common.bindingAdapters.ResizeStrategy;
import com.talabat.darkstores.common.extensions.TextViewExtensionsKt;
import com.talabat.homescreen.OnFragmentInteractionListener;
import com.talabat.talabatcommon.feature.promotionWidget.model.response.WidgetInfo;
import io.supercharge.shimmerlayout.ShimmerLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.a;
import ru.b;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0013\u001a\u00020\u0014H\u0002J\u0006\u0010\u0015\u001a\u00020\u0014R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\nR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/talabat/sidemenu/tPro/SideMenuTProViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "enabled", "", "getEnabled", "()Z", "setEnabled", "(Z)V", "isNewBrand", "setNewBrand", "model", "Lcom/talabat/talabatcommon/feature/promotionWidget/model/response/WidgetInfo;", "getModel", "()Lcom/talabat/talabatcommon/feature/promotionWidget/model/response/WidgetInfo;", "setModel", "(Lcom/talabat/talabatcommon/feature/promotionWidget/model/response/WidgetInfo;)V", "applyBrandUpdate", "", "populate", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SideMenuTProViewHolder extends RecyclerView.ViewHolder {
    private boolean enabled = true;
    private boolean isNewBrand;
    @Nullable
    private WidgetInfo model;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SideMenuTProViewHolder(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
    }

    private final void applyBrandUpdate() {
        if (this.isNewBrand) {
            View view = this.itemView;
            ((CardView) view.findViewById(R.id.cv_tpro_banner_container)).setCardBackgroundColor(ContextCompat.getColor(this.itemView.getContext(), R.color.new_brand_blue));
            View findViewById = view.findViewById(R.id.sidemenu_title);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById<TalabatTextView>(R.id.sidemenu_title)");
            TextViewExtensionsKt.setTextColorRes((TextView) findViewById, R.color.ds_white);
            View findViewById2 = view.findViewById(R.id.sidemenu_description);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById<TalabatText….id.sidemenu_description)");
            TextViewExtensionsKt.setTextColorRes((TextView) findViewById2, R.color.ds_white);
            ((ImageView) view.findViewById(R.id.sidemenu_tpro_logo)).setImageResource(R.drawable.ic_pro_logo_blue_framed);
            return;
        }
        View view2 = this.itemView;
        ((CardView) view2.findViewById(R.id.cv_tpro_banner_container)).setCardBackgroundColor(ContextCompat.getColor(this.itemView.getContext(), R.color.ds_primary_10));
        View findViewById3 = view2.findViewById(R.id.sidemenu_title);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById<TalabatTextView>(R.id.sidemenu_title)");
        TextViewExtensionsKt.setTextColorRes((TextView) findViewById3, R.color.textColorPrimary);
        View findViewById4 = view2.findViewById(R.id.sidemenu_description);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById<TalabatText….id.sidemenu_description)");
        TextViewExtensionsKt.setTextColorRes((TextView) findViewById4, R.color.ds_neutral_70);
        ((ImageView) view2.findViewById(R.id.sidemenu_tpro_logo)).setImageResource(R.drawable.ic_tpro_logo_framed);
    }

    /* access modifiers changed from: private */
    /* renamed from: populate$lambda-2  reason: not valid java name */
    public static final void m10903populate$lambda2(View view) {
    }

    /* access modifiers changed from: private */
    /* renamed from: populate$lambda-6  reason: not valid java name */
    public static final void m10904populate$lambda6(SideMenuTProViewHolder sideMenuTProViewHolder, View view) {
        Intrinsics.checkNotNullParameter(sideMenuTProViewHolder, "this$0");
        if (sideMenuTProViewHolder.itemView.getContext() instanceof OnFragmentInteractionListener) {
            Context context = sideMenuTProViewHolder.itemView.getContext();
            if (context != null) {
                OnFragmentInteractionListener onFragmentInteractionListener = (OnFragmentInteractionListener) context;
                WidgetInfo widgetInfo = sideMenuTProViewHolder.model;
                if (widgetInfo != null) {
                    onFragmentInteractionListener.onPromotionsWidgetClicked(widgetInfo.getCampaignId(), widgetInfo.getDeeplink(), "tPro");
                    return;
                }
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type com.talabat.homescreen.OnFragmentInteractionListener");
        }
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    @Nullable
    public final WidgetInfo getModel() {
        return this.model;
    }

    public final boolean isNewBrand() {
        return this.isNewBrand;
    }

    public final void populate() {
        String str;
        String str2;
        if (this.enabled) {
            this.itemView.getLayoutParams().height = -2;
            this.itemView.setVisibility(0);
            if (this.model == null) {
                this.itemView.setOnClickListener(new a());
                ShimmerLayout shimmerLayout = (ShimmerLayout) this.itemView.findViewById(R.id.sidemenu_shimmer);
                shimmerLayout.startShimmerAnimation();
                shimmerLayout.setVisibility(0);
                return;
            }
            applyBrandUpdate();
            TalabatTextView talabatTextView = (TalabatTextView) this.itemView.findViewById(R.id.sidemenu_title);
            WidgetInfo widgetInfo = this.model;
            String str3 = null;
            if (widgetInfo != null) {
                str = widgetInfo.getHeadline();
            } else {
                str = null;
            }
            talabatTextView.setText(str);
            TalabatTextView talabatTextView2 = (TalabatTextView) this.itemView.findViewById(R.id.sidemenu_description);
            WidgetInfo widgetInfo2 = this.model;
            if (widgetInfo2 != null) {
                str2 = widgetInfo2.getTagLine();
            } else {
                str2 = null;
            }
            talabatTextView2.setText(str2);
            View findViewById = this.itemView.findViewById(R.id.sidemenu_promo);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById<Im…iew>(R.id.sidemenu_promo)");
            ImageView imageView = (ImageView) findViewById;
            WidgetInfo widgetInfo3 = this.model;
            if (widgetInfo3 != null) {
                str3 = widgetInfo3.getImgUrl();
            }
            BindingAdaptersKt.loadImageWithGlide$default(imageView, str3, (Integer) null, (ResizeStrategy) null, (Transformation) null, (Integer) null, 28, (Object) null);
            ShimmerLayout shimmerLayout2 = (ShimmerLayout) this.itemView.findViewById(R.id.sidemenu_shimmer);
            shimmerLayout2.stopShimmerAnimation();
            shimmerLayout2.setVisibility(8);
            this.itemView.setOnClickListener(new b(this));
            return;
        }
        this.itemView.getLayoutParams().height = 0;
        this.itemView.setVisibility(8);
    }

    public final void setEnabled(boolean z11) {
        this.enabled = z11;
    }

    public final void setModel(@Nullable WidgetInfo widgetInfo) {
        this.model = widgetInfo;
    }

    public final void setNewBrand(boolean z11) {
        this.isNewBrand = z11;
    }
}
