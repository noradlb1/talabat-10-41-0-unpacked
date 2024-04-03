package com.talabat.feature.tpro.presentation.benefits.adapter.onboarding.viewholders;

import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.talabat.feature.subscriptions.domain.model.TProOnBoardingCardModel;
import com.talabat.feature.subscriptions.domain.model.TProOnBoardingGridCardModel;
import com.talabat.feature.subscriptions.domain.model.TProOnBoardingGridContentModel;
import com.talabat.feature.subscriptions.domain.model.TProOnBoardingMoreContentModel;
import com.talabat.feature.tpro.presentation.benefits.adapter.onboarding.adapter.grid.GridAdapter;
import com.talabat.feature.tpro.presentation.benefits.view.learnmore.OnBoardingCardLearnMoreView;
import com.talabat.feature.tpro.presentation.constants.GAConstants;
import com.talabat.feature.tpro.presentation.databinding.ItemGridBenefitCardBinding;
import com.talabat.feature.tpro.presentation.databinding.ProOnboardingButtonBinding;
import com.talabat.feature.tpro.presentation.util.ExtensionsKt;
import com.talabat.feature.tpro.presentation.util.FadeAnimationKt;
import com.talabat.feature.tpro.presentation.util.LearnMoreUtil;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ro.a;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012$\u0010\u0004\u001a \u0012\u0004\u0012\u00020\u0006\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0007\u0012\u0004\u0012\u00020\b0\u0005¢\u0006\u0002\u0010\tJ\u000e\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000eJ\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0010\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0011H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R,\u0010\u0004\u001a \u0012\u0004\u0012\u00020\u0006\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0007\u0012\u0004\u0012\u00020\b0\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/talabat/feature/tpro/presentation/benefits/adapter/onboarding/viewholders/GridItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/talabat/feature/tpro/presentation/databinding/ItemGridBenefitCardBinding;", "triggerGaEvent", "Lkotlin/Function2;", "", "Lkotlin/Pair;", "", "(Lcom/talabat/feature/tpro/presentation/databinding/ItemGridBenefitCardBinding;Lkotlin/jvm/functions/Function2;)V", "shouldLogCreationEvent", "", "bind", "gridContentModel", "Lcom/talabat/feature/subscriptions/domain/model/TProOnBoardingGridCardModel;", "bindLearnMoreView", "onBoardingCardModel", "Lcom/talabat/feature/subscriptions/domain/model/TProOnBoardingCardModel;", "logGaCreationEventIfRequired", "tProOnBoardingCardModel", "com_talabat_feature_tpro_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GridItemViewHolder extends RecyclerView.ViewHolder {
    @NotNull
    private final ItemGridBenefitCardBinding binding;
    private boolean shouldLogCreationEvent = true;
    @NotNull
    private final Function2<String, Pair<String, String>, Unit> triggerGaEvent;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GridItemViewHolder(@NotNull ItemGridBenefitCardBinding itemGridBenefitCardBinding, @NotNull Function2<? super String, ? super Pair<String, String>, Unit> function2) {
        super(itemGridBenefitCardBinding.getRoot());
        Intrinsics.checkNotNullParameter(itemGridBenefitCardBinding, "binding");
        Intrinsics.checkNotNullParameter(function2, "triggerGaEvent");
        this.binding = itemGridBenefitCardBinding;
        this.triggerGaEvent = function2;
    }

    /* access modifiers changed from: private */
    /* renamed from: bind$lambda-4$lambda-3  reason: not valid java name */
    public static final void m10363bind$lambda4$lambda3(List list, GridItemViewHolder gridItemViewHolder) {
        Intrinsics.checkNotNullParameter(list, "$this_apply");
        Intrinsics.checkNotNullParameter(gridItemViewHolder, "this$0");
        GridAdapter gridAdapter = new GridAdapter(list);
        gridItemViewHolder.binding.gridView.setLayoutManager(new GridLayoutManager(gridItemViewHolder.binding.getRoot().getContext(), 3));
        gridItemViewHolder.binding.gridView.setHasFixedSize(true);
        gridItemViewHolder.binding.gridView.setAdapter(gridAdapter);
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

    private final void logGaCreationEventIfRequired(TProOnBoardingCardModel tProOnBoardingCardModel) {
        if (this.shouldLogCreationEvent) {
            this.triggerGaEvent.invoke(GAConstants.SUBSCRIPTION_BENEFIT_CARD_SHOWN, TuplesKt.to(GAConstants.CARD_CONTENT, tProOnBoardingCardModel.getTrackingId()));
        }
        this.shouldLogCreationEvent = false;
    }

    public final void bind(@NotNull TProOnBoardingGridCardModel tProOnBoardingGridCardModel) {
        boolean z11;
        String str;
        String str2;
        String str3;
        String str4;
        Intrinsics.checkNotNullParameter(tProOnBoardingGridCardModel, "gridContentModel");
        bindLearnMoreView(tProOnBoardingGridCardModel);
        TextView textView = this.binding.tvCardTitle;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.tvCardTitle");
        ExtensionsKt.renderSpannableWithMultiplier(textView, tProOnBoardingGridCardModel.getTitleSpanning());
        String topImage = tProOnBoardingGridCardModel.getTopImage();
        boolean z12 = false;
        if (topImage == null || topImage.length() == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            ImageView imageView = this.binding.ivTop;
            Intrinsics.checkNotNullExpressionValue(imageView, "binding.ivTop");
            String topImage2 = tProOnBoardingGridCardModel.getTopImage();
            if (topImage2 == null || topImage2.length() == 0) {
                z12 = true;
            }
            FadeAnimationKt.changeVisibility(imageView, !z12);
        } else {
            String topImage3 = tProOnBoardingGridCardModel.getTopImage();
            if (topImage3 != null) {
                ImageView imageView2 = this.binding.ivTop;
                Intrinsics.checkNotNullExpressionValue(imageView2, "binding.ivTop");
                ExtensionsKt.loadImage$default(imageView2, topImage3, (Function1) null, 2, (Object) null);
            }
        }
        TextView textView2 = this.binding.buttonLayout.tvButtonText;
        TProOnBoardingMoreContentModel moreContent = tProOnBoardingGridCardModel.getMoreContent();
        if (moreContent == null || (str = moreContent.getCtaTitle()) == null) {
            str = "";
        }
        textView2.setText(str);
        TextView textView3 = this.binding.buttonLayout.tvButtonText;
        Intrinsics.checkNotNullExpressionValue(textView3, "binding.buttonLayout.tvButtonText");
        TProOnBoardingMoreContentModel moreContent2 = tProOnBoardingGridCardModel.getMoreContent();
        if (moreContent2 != null) {
            str2 = moreContent2.getCtaTitleColor();
        } else {
            str2 = null;
        }
        ExtensionsKt.applyTextColor(textView3, str2);
        CardView cardView = this.binding.buttonLayout.cardLayout;
        Intrinsics.checkNotNullExpressionValue(cardView, "binding.buttonLayout.cardLayout");
        TProOnBoardingMoreContentModel moreContent3 = tProOnBoardingGridCardModel.getMoreContent();
        if (moreContent3 != null) {
            str3 = moreContent3.getCtaBackgroundColor();
        } else {
            str3 = null;
        }
        ExtensionsKt.applyCardBgColor(cardView, str3);
        ImageView imageView3 = this.binding.buttonLayout.ivPlus;
        Intrinsics.checkNotNullExpressionValue(imageView3, "binding.buttonLayout.ivPlus");
        TProOnBoardingMoreContentModel moreContent4 = tProOnBoardingGridCardModel.getMoreContent();
        if (moreContent4 != null) {
            str4 = moreContent4.getCtaTitleColor();
        } else {
            str4 = null;
        }
        ExtensionsKt.applyColorFilter(imageView3, str4);
        ConstraintLayout constraintLayout = this.binding.clView;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "binding.clView");
        ExtensionsKt.applyBgColor(constraintLayout, tProOnBoardingGridCardModel.getCardBackgroundColor());
        String cardBackgroundImage = tProOnBoardingGridCardModel.getCardBackgroundImage();
        if (cardBackgroundImage != null) {
            ImageView imageView4 = this.binding.ivBackgroundImage;
            Intrinsics.checkNotNullExpressionValue(imageView4, "binding.ivBackgroundImage");
            ExtensionsKt.loadImage$default(imageView4, cardBackgroundImage, (Function1) null, 2, (Object) null);
        }
        Iterable<TProOnBoardingGridContentModel> content = tProOnBoardingGridCardModel.getContent();
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(content, 10));
        for (TProOnBoardingGridContentModel url : content) {
            arrayList.add(url.getUrl());
        }
        this.binding.gridView.post(new a(arrayList, this));
        logGaCreationEventIfRequired(tProOnBoardingGridCardModel);
    }
}
