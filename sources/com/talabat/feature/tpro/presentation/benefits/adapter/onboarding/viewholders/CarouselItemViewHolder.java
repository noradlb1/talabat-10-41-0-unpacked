package com.talabat.feature.tpro.presentation.benefits.adapter.onboarding.viewholders;

import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.recyclerview.widget.RecyclerView;
import com.designsystem.marshmallow.R;
import com.talabat.feature.subscriptions.domain.model.TProOnBoardingCardModel;
import com.talabat.feature.subscriptions.domain.model.TProOnBoardingCarouselCardModel;
import com.talabat.feature.subscriptions.domain.model.TProOnBoardingCarouselContentModel;
import com.talabat.feature.subscriptions.domain.model.TProOnBoardingMoreContentModel;
import com.talabat.feature.tpro.presentation.benefits.adapter.carousel.adapter.CarouselAdapter;
import com.talabat.feature.tpro.presentation.benefits.adapter.carousel.autorecylerview.AutoScrollRecyclerView;
import com.talabat.feature.tpro.presentation.benefits.adapter.carousel.itemdecorator.SpacesItemDecoration;
import com.talabat.feature.tpro.presentation.benefits.view.learnmore.OnBoardingCardLearnMoreView;
import com.talabat.feature.tpro.presentation.constants.GAConstants;
import com.talabat.feature.tpro.presentation.databinding.ItemCarouselBenefitCardBinding;
import com.talabat.feature.tpro.presentation.databinding.ProOnboardingButtonBinding;
import com.talabat.feature.tpro.presentation.util.ExtensionsKt;
import com.talabat.feature.tpro.presentation.util.FadeAnimationKt;
import com.talabat.feature.tpro.presentation.util.LearnMoreUtil;
import com.talabat.talabatcommon.extentions.IntKt;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012$\u0010\u0004\u001a \u0012\u0004\u0012\u00020\u0006\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0007\u0012\u0004\u0012\u00020\b0\u0005¢\u0006\u0002\u0010\tJ\u000e\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0014J\u0010\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0010\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u0017H\u0002J\u0006\u0010\u001a\u001a\u00020\bR\u001b\u0010\n\u001a\u00020\u000b8BX\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R,\u0010\u0004\u001a \u0012\u0004\u0012\u00020\u0006\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0007\u0012\u0004\u0012\u00020\b0\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/talabat/feature/tpro/presentation/benefits/adapter/onboarding/viewholders/CarouselItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/talabat/feature/tpro/presentation/databinding/ItemCarouselBenefitCardBinding;", "triggerGaEvent", "Lkotlin/Function2;", "", "Lkotlin/Pair;", "", "(Lcom/talabat/feature/tpro/presentation/databinding/ItemCarouselBenefitCardBinding;Lkotlin/jvm/functions/Function2;)V", "adapter", "Lcom/talabat/feature/tpro/presentation/benefits/adapter/carousel/adapter/CarouselAdapter;", "getAdapter", "()Lcom/talabat/feature/tpro/presentation/benefits/adapter/carousel/adapter/CarouselAdapter;", "adapter$delegate", "Lkotlin/Lazy;", "shouldLogCreationEvent", "", "bind", "carouselCardModel", "Lcom/talabat/feature/subscriptions/domain/model/TProOnBoardingCarouselCardModel;", "bindLearnMoreView", "onBoardingCardModel", "Lcom/talabat/feature/subscriptions/domain/model/TProOnBoardingCardModel;", "logGaCreationEventIfRequired", "tProOnBoardingCardModel", "startCarouselIfRequired", "com_talabat_feature_tpro_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CarouselItemViewHolder extends RecyclerView.ViewHolder {
    @NotNull
    private final Lazy adapter$delegate = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, CarouselItemViewHolder$adapter$2.INSTANCE);
    @NotNull
    private final ItemCarouselBenefitCardBinding binding;
    private boolean shouldLogCreationEvent = true;
    @NotNull
    private final Function2<String, Pair<String, String>, Unit> triggerGaEvent;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CarouselItemViewHolder(@NotNull ItemCarouselBenefitCardBinding itemCarouselBenefitCardBinding, @NotNull Function2<? super String, ? super Pair<String, String>, Unit> function2) {
        super(itemCarouselBenefitCardBinding.getRoot());
        Intrinsics.checkNotNullParameter(itemCarouselBenefitCardBinding, "binding");
        Intrinsics.checkNotNullParameter(function2, "triggerGaEvent");
        this.binding = itemCarouselBenefitCardBinding;
        this.triggerGaEvent = function2;
    }

    private final void bindLearnMoreView(TProOnBoardingCardModel tProOnBoardingCardModel) {
        LearnMoreUtil learnMoreUtil = LearnMoreUtil.INSTANCE;
        OnBoardingCardLearnMoreView onBoardingCardLearnMoreView = this.binding.learnMoreView;
        Intrinsics.checkNotNullExpressionValue(onBoardingCardLearnMoreView, "binding.learnMoreView");
        Group group = this.binding.frontGroup;
        Intrinsics.checkNotNullExpressionValue(group, "binding.frontGroup");
        ProOnboardingButtonBinding proOnboardingButtonBinding = this.binding.buttonLayout;
        Intrinsics.checkNotNullExpressionValue(proOnboardingButtonBinding, "binding.buttonLayout");
        learnMoreUtil.bindLearnMoreViewIfRequired(tProOnBoardingCardModel, onBoardingCardLearnMoreView, group, proOnboardingButtonBinding, this.triggerGaEvent);
    }

    private final CarouselAdapter getAdapter() {
        return (CarouselAdapter) this.adapter$delegate.getValue();
    }

    private final void logGaCreationEventIfRequired(TProOnBoardingCardModel tProOnBoardingCardModel) {
        if (this.shouldLogCreationEvent) {
            this.triggerGaEvent.invoke(GAConstants.SUBSCRIPTION_BENEFIT_CARD_SHOWN, TuplesKt.to(GAConstants.CARD_CONTENT, tProOnBoardingCardModel.getTrackingId()));
        }
        this.shouldLogCreationEvent = false;
    }

    public final void bind(@NotNull TProOnBoardingCarouselCardModel tProOnBoardingCarouselCardModel) {
        boolean z11;
        String str;
        String str2;
        String str3;
        String str4;
        boolean z12;
        Intrinsics.checkNotNullParameter(tProOnBoardingCarouselCardModel, "carouselCardModel");
        bindLearnMoreView(tProOnBoardingCarouselCardModel);
        String topImage = tProOnBoardingCarouselCardModel.getTopImage();
        boolean z13 = true;
        if (topImage == null || topImage.length() == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            ImageView imageView = this.binding.ivTop;
            Intrinsics.checkNotNullExpressionValue(imageView, "binding.ivTop");
            String topImage2 = tProOnBoardingCarouselCardModel.getTopImage();
            if (topImage2 == null || topImage2.length() == 0) {
                z12 = true;
            } else {
                z12 = false;
            }
            FadeAnimationKt.changeVisibility(imageView, !z12);
        } else {
            String topImage3 = tProOnBoardingCarouselCardModel.getTopImage();
            if (topImage3 != null) {
                ImageView imageView2 = this.binding.ivTop;
                Intrinsics.checkNotNullExpressionValue(imageView2, "binding.ivTop");
                ExtensionsKt.loadImage$default(imageView2, topImage3, (Function1) null, 2, (Object) null);
            }
        }
        Iterable<TProOnBoardingCarouselContentModel> content = tProOnBoardingCarouselCardModel.getContent();
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(content, 10));
        for (TProOnBoardingCarouselContentModel url : content) {
            arrayList.add(url.getUrl());
        }
        if (this.binding.rvContentCarousel.getItemDecorationCount() == 0) {
            ItemCarouselBenefitCardBinding itemCarouselBenefitCardBinding = this.binding;
            itemCarouselBenefitCardBinding.rvContentCarousel.addItemDecoration(new SpacesItemDecoration((int) itemCarouselBenefitCardBinding.getRoot().getContext().getResources().getDimension(R.dimen.f33294m)));
        }
        getAdapter().updateData(arrayList);
        AutoScrollRecyclerView autoScrollRecyclerView = this.binding.rvContentCarousel;
        Intrinsics.checkNotNullExpressionValue(autoScrollRecyclerView, "binding.rvContentCarousel");
        AutoScrollRecyclerView.openAutoScroll$default(autoScrollRecyclerView, 0, false, 3, (Object) null);
        this.binding.rvContentCarousel.setAdapter(getAdapter());
        TextView textView = this.binding.tvCarouselBanner;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.tvCarouselBanner");
        ExtensionsKt.renderSpannableWithMultiplier(textView, tProOnBoardingCarouselCardModel.getTitleSpanning());
        TextView textView2 = this.binding.buttonLayout.tvButtonText;
        TProOnBoardingMoreContentModel moreContent = tProOnBoardingCarouselCardModel.getMoreContent();
        if (moreContent == null || (str = moreContent.getCtaTitle()) == null) {
            str = "";
        }
        textView2.setText(str);
        TextView textView3 = this.binding.buttonLayout.tvButtonText;
        Intrinsics.checkNotNullExpressionValue(textView3, "binding.buttonLayout.tvButtonText");
        TProOnBoardingMoreContentModel moreContent2 = tProOnBoardingCarouselCardModel.getMoreContent();
        if (moreContent2 != null) {
            str2 = moreContent2.getCtaTitleColor();
        } else {
            str2 = null;
        }
        ExtensionsKt.applyTextColor(textView3, str2);
        CardView cardView = this.binding.buttonLayout.cardLayout;
        Intrinsics.checkNotNullExpressionValue(cardView, "binding.buttonLayout.cardLayout");
        TProOnBoardingMoreContentModel moreContent3 = tProOnBoardingCarouselCardModel.getMoreContent();
        if (moreContent3 != null) {
            str3 = moreContent3.getCtaBackgroundColor();
        } else {
            str3 = null;
        }
        ExtensionsKt.applyCardBgColor(cardView, str3);
        ImageView imageView3 = this.binding.buttonLayout.ivPlus;
        Intrinsics.checkNotNullExpressionValue(imageView3, "binding.buttonLayout.ivPlus");
        TProOnBoardingMoreContentModel moreContent4 = tProOnBoardingCarouselCardModel.getMoreContent();
        if (moreContent4 != null) {
            str4 = moreContent4.getCtaTitleColor();
        } else {
            str4 = null;
        }
        ExtensionsKt.applyColorFilter(imageView3, str4);
        ConstraintLayout constraintLayout = this.binding.clView;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "binding.clView");
        ExtensionsKt.applyBgColor(constraintLayout, tProOnBoardingCarouselCardModel.getCardBackgroundColor());
        String cardBackgroundImage = tProOnBoardingCarouselCardModel.getCardBackgroundImage();
        if (cardBackgroundImage != null) {
            if (cardBackgroundImage.length() <= 0) {
                z13 = false;
            }
            if (z13) {
                ImageView imageView4 = this.binding.ivBackgroundImage;
                Intrinsics.checkNotNullExpressionValue(imageView4, "binding.ivBackgroundImage");
                ExtensionsKt.loadImage$default(imageView4, cardBackgroundImage, (Function1) null, 2, (Object) null);
            }
        }
        logGaCreationEventIfRequired(tProOnBoardingCarouselCardModel);
    }

    public final void startCarouselIfRequired() {
        if (!IntKt.isZero(Integer.valueOf(getAdapter().getItemCount()))) {
            AutoScrollRecyclerView autoScrollRecyclerView = this.binding.rvContentCarousel;
            Intrinsics.checkNotNullExpressionValue(autoScrollRecyclerView, "binding.rvContentCarousel");
            AutoScrollRecyclerView.openAutoScroll$default(autoScrollRecyclerView, 0, false, 3, (Object) null);
        }
    }
}
