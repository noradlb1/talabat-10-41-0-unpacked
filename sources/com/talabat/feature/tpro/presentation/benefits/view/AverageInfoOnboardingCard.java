package com.talabat.feature.tpro.presentation.benefits.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import com.talabat.feature.subscriptions.domain.model.TProOnBoardingInfoItemModel;
import com.talabat.feature.subscriptions.domain.model.TProOnBoardingInfoWidgetModel;
import com.talabat.feature.tpro.presentation.databinding.AverageItemCardBinding;
import com.talabat.feature.tpro.presentation.util.ExtensionsKt;
import com.talabat.feature.tpro.presentation.util.FadeAnimationKt;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import so.a;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J\u0010\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0007H\u0002J\u0010\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0011H\u0002R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/talabat/feature/tpro/presentation/benefits/view/AverageInfoOnboardingCard;", "Landroidx/cardview/widget/CardView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/talabat/feature/tpro/presentation/databinding/AverageItemCardBinding;", "getBinding", "()Lcom/talabat/feature/tpro/presentation/databinding/AverageItemCardBinding;", "monthly", "buildContent", "", "tProOnBoardingInfoWidgetModel", "Lcom/talabat/feature/subscriptions/domain/model/TProOnBoardingInfoWidgetModel;", "getListSizeNonZero", "size", "updateText", "banner", "com_talabat_feature_tpro_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AverageInfoOnboardingCard extends CardView {
    @NotNull
    private final AverageItemCardBinding binding;
    private int monthly;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AverageInfoOnboardingCard(@NotNull Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AverageInfoOnboardingCard(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AverageInfoOnboardingCard(Context context, AttributeSet attributeSet, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }

    /* access modifiers changed from: private */
    /* renamed from: buildContent$lambda-1  reason: not valid java name */
    public static final void m10365buildContent$lambda1(AverageInfoOnboardingCard averageInfoOnboardingCard, TProOnBoardingInfoWidgetModel tProOnBoardingInfoWidgetModel, View view) {
        Intrinsics.checkNotNullParameter(averageInfoOnboardingCard, "this$0");
        Intrinsics.checkNotNullParameter(tProOnBoardingInfoWidgetModel, "$tProOnBoardingInfoWidgetModel");
        averageInfoOnboardingCard.monthly++;
        TextView textView = averageInfoOnboardingCard.binding.tvCardHeader;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.tvCardHeader");
        FadeAnimationKt.applyFadeEffect(textView, new AverageInfoOnboardingCard$buildContent$1$1(averageInfoOnboardingCard, tProOnBoardingInfoWidgetModel));
        TextView textView2 = averageInfoOnboardingCard.binding.tvCardContent;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.tvCardContent");
        FadeAnimationKt.applyFadeEffect(textView2, AverageInfoOnboardingCard$buildContent$1$2.INSTANCE);
        TextView textView3 = averageInfoOnboardingCard.binding.tvCardActionText;
        Intrinsics.checkNotNullExpressionValue(textView3, "binding.tvCardActionText");
        FadeAnimationKt.applyFadeEffect(textView3, AverageInfoOnboardingCard$buildContent$1$3.INSTANCE);
    }

    private final int getListSizeNonZero(int i11) {
        if (i11 == 0) {
            return 1;
        }
        return i11;
    }

    /* access modifiers changed from: private */
    public final void updateText(TProOnBoardingInfoWidgetModel tProOnBoardingInfoWidgetModel) {
        TProOnBoardingInfoItemModel tProOnBoardingInfoItemModel = (TProOnBoardingInfoItemModel) CollectionsKt___CollectionsKt.getOrNull(tProOnBoardingInfoWidgetModel.getListItems(), this.monthly % getListSizeNonZero(tProOnBoardingInfoWidgetModel.getListItems().size()));
        if (tProOnBoardingInfoItemModel != null) {
            this.binding.tvCardHeader.setText(tProOnBoardingInfoItemModel.getTitle());
            TextView textView = this.binding.tvCardHeader;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.tvCardHeader");
            ExtensionsKt.applyTextColor(textView, tProOnBoardingInfoItemModel.getTitleColor());
            this.binding.tvCardContent.setText(tProOnBoardingInfoItemModel.getSubtitle());
            TextView textView2 = this.binding.tvCardContent;
            Intrinsics.checkNotNullExpressionValue(textView2, "binding.tvCardContent");
            ExtensionsKt.applyTextColor(textView2, tProOnBoardingInfoItemModel.getSubTitleColor());
            this.binding.tvCardActionText.setText(tProOnBoardingInfoItemModel.getCtaTitle());
            TextView textView3 = this.binding.tvCardActionText;
            Intrinsics.checkNotNullExpressionValue(textView3, "binding.tvCardActionText");
            ExtensionsKt.applyTextColor(textView3, tProOnBoardingInfoItemModel.getCtaColor());
        }
    }

    public final void buildContent(@NotNull TProOnBoardingInfoWidgetModel tProOnBoardingInfoWidgetModel) {
        Intrinsics.checkNotNullParameter(tProOnBoardingInfoWidgetModel, "tProOnBoardingInfoWidgetModel");
        setVisibility(0);
        this.monthly = tProOnBoardingInfoWidgetModel.getSelectedIndex();
        updateText(tProOnBoardingInfoWidgetModel);
        if (tProOnBoardingInfoWidgetModel.getListItems().size() > 1) {
            this.binding.tvCardActionText.setOnClickListener(new a(this, tProOnBoardingInfoWidgetModel));
        }
    }

    @NotNull
    public final AverageItemCardBinding getBinding() {
        return this.binding;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AverageInfoOnboardingCard(@NotNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.checkNotNullParameter(context, "context");
        AverageItemCardBinding inflate = AverageItemCardBinding.inflate(LayoutInflater.from(context), this, true);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(\n            Lay…           true\n        )");
        this.binding = inflate;
        setVisibility(8);
    }
}
