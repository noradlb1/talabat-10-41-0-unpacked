package com.talabat.feature.tpro.presentation.util;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.Group;
import com.designsystem.marshmallow.R;
import com.talabat.feature.subscriptions.domain.model.TProOnBoardingCardModel;
import com.talabat.feature.tpro.presentation.benefits.view.learnmore.OnBoardingCardLearnMoreView;
import com.talabat.feature.tpro.presentation.constants.GAConstants;
import com.talabat.feature.tpro.presentation.databinding.ProOnboardingButtonBinding;
import com.talabat.talabatcommon.extension.ViewKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import mp.a;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JN\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2$\u0010\r\u001a \u0012\u0004\u0012\u00020\u000f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u0010\u0012\u0004\u0012\u00020\u00040\u000eH\u0002JL\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2$\u0010\r\u001a \u0012\u0004\u0012\u00020\u000f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u0010\u0012\u0004\u0012\u00020\u00040\u000eJ\u0016\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016J>\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0005\u001a\u00020\u00062$\u0010\r\u001a \u0012\u0004\u0012\u00020\u000f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u0010\u0012\u0004\u0012\u00020\u00040\u000eH\u0002¨\u0006\u0019"}, d2 = {"Lcom/talabat/feature/tpro/presentation/util/LearnMoreUtil;", "", "()V", "applyClickListener", "", "onBoardingCardModel", "Lcom/talabat/feature/subscriptions/domain/model/TProOnBoardingCardModel;", "learnMoreView", "Lcom/talabat/feature/tpro/presentation/benefits/view/learnmore/OnBoardingCardLearnMoreView;", "frontGroup", "Landroidx/constraintlayout/widget/Group;", "buttonLayout", "Lcom/talabat/feature/tpro/presentation/databinding/ProOnboardingButtonBinding;", "triggerGaEvent", "Lkotlin/Function2;", "", "Lkotlin/Pair;", "bindLearnMoreViewIfRequired", "changeLearnMoreButton", "visible", "", "imageView", "Landroid/widget/ImageView;", "logGaEvent", "isVisible", "com_talabat_feature_tpro_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LearnMoreUtil {
    @NotNull
    public static final LearnMoreUtil INSTANCE = new LearnMoreUtil();

    private LearnMoreUtil() {
    }

    private final void applyClickListener(TProOnBoardingCardModel tProOnBoardingCardModel, OnBoardingCardLearnMoreView onBoardingCardLearnMoreView, Group group, ProOnboardingButtonBinding proOnboardingButtonBinding, Function2<? super String, ? super Pair<String, String>, Unit> function2) {
        proOnboardingButtonBinding.getRoot().setOnClickListener(new a(onBoardingCardLearnMoreView, tProOnBoardingCardModel, function2, group, proOnboardingButtonBinding));
    }

    /* access modifiers changed from: private */
    /* renamed from: applyClickListener$lambda-0  reason: not valid java name */
    public static final void m10428applyClickListener$lambda0(OnBoardingCardLearnMoreView onBoardingCardLearnMoreView, TProOnBoardingCardModel tProOnBoardingCardModel, Function2 function2, Group group, ProOnboardingButtonBinding proOnboardingButtonBinding, View view) {
        Intrinsics.checkNotNullParameter(onBoardingCardLearnMoreView, "$learnMoreView");
        Intrinsics.checkNotNullParameter(tProOnBoardingCardModel, "$onBoardingCardModel");
        Intrinsics.checkNotNullParameter(function2, "$triggerGaEvent");
        Intrinsics.checkNotNullParameter(group, "$frontGroup");
        Intrinsics.checkNotNullParameter(proOnboardingButtonBinding, "$buttonLayout");
        LearnMoreUtil learnMoreUtil = INSTANCE;
        learnMoreUtil.logGaEvent(!ViewKt.isVisible(onBoardingCardLearnMoreView), tProOnBoardingCardModel, function2);
        onBoardingCardLearnMoreView.toggleVisibility();
        FadeAnimationKt.changeVisibilityWithFade(group, !ViewKt.isVisible(onBoardingCardLearnMoreView));
        TextView textView = proOnboardingButtonBinding.tvButtonText;
        Intrinsics.checkNotNullExpressionValue(textView, "buttonLayout.tvButtonText");
        FadeAnimationKt.changeVisibilityWithFade(textView, !ViewKt.isVisible(onBoardingCardLearnMoreView));
        ImageView imageView = proOnboardingButtonBinding.ivPlus;
        Intrinsics.checkNotNullExpressionValue(imageView, "buttonLayout.ivPlus");
        learnMoreUtil.changeLearnMoreButton(!ViewKt.isVisible(onBoardingCardLearnMoreView), imageView);
    }

    private final void logGaEvent(boolean z11, TProOnBoardingCardModel tProOnBoardingCardModel, Function2<? super String, ? super Pair<String, String>, Unit> function2) {
        if (z11) {
            function2.invoke(GAConstants.SUBSCRIPTION_BENEFIT_CARD_CLICKED, TuplesKt.to(GAConstants.CARD_CONTENT, tProOnBoardingCardModel.getTrackingId()));
        }
    }

    public final void bindLearnMoreViewIfRequired(@NotNull TProOnBoardingCardModel tProOnBoardingCardModel, @NotNull OnBoardingCardLearnMoreView onBoardingCardLearnMoreView, @NotNull Group group, @NotNull ProOnboardingButtonBinding proOnboardingButtonBinding, @NotNull Function2<? super String, ? super Pair<String, String>, Unit> function2) {
        Intrinsics.checkNotNullParameter(tProOnBoardingCardModel, "onBoardingCardModel");
        Intrinsics.checkNotNullParameter(onBoardingCardLearnMoreView, "learnMoreView");
        Intrinsics.checkNotNullParameter(group, "frontGroup");
        Intrinsics.checkNotNullParameter(proOnboardingButtonBinding, "buttonLayout");
        Intrinsics.checkNotNullParameter(function2, "triggerGaEvent");
        if (tProOnBoardingCardModel.getHaveMore()) {
            onBoardingCardLearnMoreView.setOnBoardMoreContentModel(tProOnBoardingCardModel.getMoreContent());
            applyClickListener(tProOnBoardingCardModel, onBoardingCardLearnMoreView, group, proOnboardingButtonBinding, function2);
            return;
        }
        CardView root = proOnboardingButtonBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "buttonLayout.root");
        FadeAnimationKt.changeVisibility(root, false);
    }

    public final void changeLearnMoreButton(boolean z11, @NotNull ImageView imageView) {
        int i11;
        Intrinsics.checkNotNullParameter(imageView, "imageView");
        if (z11) {
            i11 = R.drawable.ds_plus;
        } else {
            i11 = R.drawable.ds_minus;
        }
        imageView.setImageDrawable(imageView.getContext().getDrawable(i11));
    }
}
