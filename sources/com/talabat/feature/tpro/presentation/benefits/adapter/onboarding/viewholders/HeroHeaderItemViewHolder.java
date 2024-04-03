package com.talabat.feature.tpro.presentation.benefits.adapter.onboarding.viewholders;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import colorprovider.DSColorProvider;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.talabat.feature.subscriptions.domain.model.HeroWidgetModel;
import com.talabat.feature.subscriptions.domain.model.TProOnBoardingBannerModel;
import com.talabat.feature.subscriptions.domain.model.TProOnBoardingExpandableWidgetModel;
import com.talabat.feature.subscriptions.domain.model.TProOnBoardingInfoWidgetModel;
import com.talabat.feature.tpro.presentation.constants.GAConstants;
import com.talabat.feature.tpro.presentation.databinding.ItemContentNewHeroHeaderSavingsBinding;
import com.talabat.feature.tpro.presentation.util.CreateGradientDrawableKt;
import com.talabat.feature.tpro.presentation.util.ExtensionsKt;
import com.talabat.talabatcommon.utils.ImageViewExtensionsKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ro.b;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u0012$\u0010\b\u001a \u0012\u0004\u0012\u00020\n\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u000b\u0012\u0004\u0012\u00020\u00070\t¢\u0006\u0002\u0010\fJ\u0010\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\nH\u0002J2\u0010\u0011\u001a\u00020\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00070\u00052\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017J\u0010\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\nH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R,\u0010\b\u001a \u0012\u0004\u0012\u00020\n\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u000b\u0012\u0004\u0012\u00020\u00070\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/talabat/feature/tpro/presentation/benefits/adapter/onboarding/viewholders/HeroHeaderItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/talabat/feature/tpro/presentation/databinding/ItemContentNewHeroHeaderSavingsBinding;", "onBackClick", "Lkotlin/Function1;", "Landroid/view/View;", "", "triggerGaEvent", "Lkotlin/Function2;", "", "Lkotlin/Pair;", "(Lcom/talabat/feature/tpro/presentation/databinding/ItemContentNewHeroHeaderSavingsBinding;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)V", "shouldLogCreationEvent", "", "applyBackGroundGradient", "heroBackgroundColor", "bind", "heroBanner", "Lcom/talabat/feature/subscriptions/domain/model/TProOnBoardingBannerModel;", "notifyItemChanged", "", "preloaderCallback", "Lcom/bumptech/glide/request/RequestListener;", "Landroid/graphics/drawable/Drawable;", "logGaCreationEventIfRequired", "trackingId", "com_talabat_feature_tpro_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class HeroHeaderItemViewHolder extends RecyclerView.ViewHolder {
    @NotNull
    private final ItemContentNewHeroHeaderSavingsBinding binding;
    @NotNull
    private final Function1<View, Unit> onBackClick;
    private boolean shouldLogCreationEvent = true;
    @NotNull
    private final Function2<String, Pair<String, String>, Unit> triggerGaEvent;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HeroHeaderItemViewHolder(@NotNull ItemContentNewHeroHeaderSavingsBinding itemContentNewHeroHeaderSavingsBinding, @NotNull Function1<? super View, Unit> function1, @NotNull Function2<? super String, ? super Pair<String, String>, Unit> function2) {
        super(itemContentNewHeroHeaderSavingsBinding.getRoot());
        Intrinsics.checkNotNullParameter(itemContentNewHeroHeaderSavingsBinding, "binding");
        Intrinsics.checkNotNullParameter(function1, "onBackClick");
        Intrinsics.checkNotNullParameter(function2, "triggerGaEvent");
        this.binding = itemContentNewHeroHeaderSavingsBinding;
        this.onBackClick = function1;
        this.triggerGaEvent = function2;
    }

    private final void applyBackGroundGradient(String str) {
        Integer num = DSColorProvider.INSTANCE.getMarshmallowColorMap().get(str);
        if (num != null) {
            int intValue = num.intValue();
            ImageView imageView = this.binding.ivBackground;
            Context context = imageView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "binding.ivBackground.context");
            imageView.setBackground(CreateGradientDrawableKt.createGradientDrawable(context, intValue));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: bind$lambda-2  reason: not valid java name */
    public static final void m10364bind$lambda2(Function1 function1, View view) {
        Intrinsics.checkNotNullParameter(function1, "$tmp0");
        function1.invoke(view);
    }

    private final void logGaCreationEventIfRequired(String str) {
        if (this.shouldLogCreationEvent) {
            this.triggerGaEvent.invoke(GAConstants.SUBSCRIPTION_BENEFIT_CARD_SHOWN, TuplesKt.to(GAConstants.CARD_CONTENT, str));
        }
        this.shouldLogCreationEvent = false;
    }

    public final void bind(@Nullable TProOnBoardingBannerModel tProOnBoardingBannerModel, @NotNull Function1<? super Integer, Unit> function1, @NotNull RequestListener<Drawable> requestListener) {
        Intrinsics.checkNotNullParameter(function1, "notifyItemChanged");
        Intrinsics.checkNotNullParameter(requestListener, "preloaderCallback");
        requestListener.onResourceReady(null, 0, (Target<Drawable>) null, (DataSource) null, true);
        if (tProOnBoardingBannerModel != null) {
            TextView textView = this.binding.tvOnBoardingHeader;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.tvOnBoardingHeader");
            ExtensionsKt.renderSpannableWithMultiplier(textView, tProOnBoardingBannerModel.getHeroSpannableTitle());
            ImageView imageView = this.binding.ivBackground;
            Intrinsics.checkNotNullExpressionValue(imageView, "binding.ivBackground");
            ImageViewExtensionsKt.loadImage$default(imageView, tProOnBoardingBannerModel.getHeroBackgroundImage(), (Function1) null, 2, (Object) null);
            ConstraintLayout constraintLayout = this.binding.clView;
            Intrinsics.checkNotNullExpressionValue(constraintLayout, "binding.clView");
            ExtensionsKt.applyBgColor(constraintLayout, tProOnBoardingBannerModel.getHeroBackgroundColor());
            applyBackGroundGradient(tProOnBoardingBannerModel.getHeroBackgroundColor());
            HeroWidgetModel heroWidgetModel = (HeroWidgetModel) CollectionsKt___CollectionsKt.firstOrNull(tProOnBoardingBannerModel.getHeroWidget());
            if (heroWidgetModel != null) {
                if (heroWidgetModel instanceof TProOnBoardingInfoWidgetModel) {
                    this.binding.averageCard.buildContent((TProOnBoardingInfoWidgetModel) heroWidgetModel);
                } else if (heroWidgetModel instanceof TProOnBoardingExpandableWidgetModel) {
                    this.binding.expandableCard.buildContent((TProOnBoardingExpandableWidgetModel) heroWidgetModel, new HeroHeaderItemViewHolder$bind$1$1$1(function1, this), this.triggerGaEvent);
                }
                logGaCreationEventIfRequired(heroWidgetModel.getTrackingId());
            }
        }
        this.binding.ivClose.setOnClickListener(new b(this.onBackClick));
    }
}
