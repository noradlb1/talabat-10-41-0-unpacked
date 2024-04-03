package com.talabat.feature.tpro.presentation.benefits.view.learnmore;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.talabat.feature.subscriptions.domain.model.TProOnBoardingMoreContentModel;
import com.talabat.feature.tpro.presentation.benefits.adapter.onboarding.OnBoardingLearnMoreContentAdapter;
import com.talabat.feature.tpro.presentation.databinding.OnBoardingCardLearnMoreBinding;
import com.talabat.feature.tpro.presentation.util.ExtensionsKt;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\fH\u0002J\u0006\u0010\u0015\u001a\u00020\u0013R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R(\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\f@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0016"}, d2 = {"Lcom/talabat/feature/tpro/presentation/benefits/view/learnmore/OnBoardingCardLearnMoreView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/talabat/feature/tpro/presentation/databinding/OnBoardingCardLearnMoreBinding;", "value", "Lcom/talabat/feature/subscriptions/domain/model/TProOnBoardingMoreContentModel;", "onBoardMoreContentModel", "getOnBoardMoreContentModel", "()Lcom/talabat/feature/subscriptions/domain/model/TProOnBoardingMoreContentModel;", "setOnBoardMoreContentModel", "(Lcom/talabat/feature/subscriptions/domain/model/TProOnBoardingMoreContentModel;)V", "buildContent", "", "moreContentModel", "toggleVisibility", "com_talabat_feature_tpro_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OnBoardingCardLearnMoreView extends RelativeLayout {
    @NotNull
    private final OnBoardingCardLearnMoreBinding binding;
    @Nullable
    private TProOnBoardingMoreContentModel onBoardMoreContentModel;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public OnBoardingCardLearnMoreView(@NotNull Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public OnBoardingCardLearnMoreView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ OnBoardingCardLearnMoreView(Context context, AttributeSet attributeSet, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }

    private final void buildContent(TProOnBoardingMoreContentModel tProOnBoardingMoreContentModel) {
        this.binding.tvTitle.setText(tProOnBoardingMoreContentModel.getTitle());
        FrameLayout frameLayout = this.binding.learnMoreCardContainer;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.learnMoreCardContainer");
        ExtensionsKt.applyBgColor(frameLayout, tProOnBoardingMoreContentModel.getContentBackgroundColor());
        OnBoardingLearnMoreContentAdapter onBoardingLearnMoreContentAdapter = new OnBoardingLearnMoreContentAdapter(tProOnBoardingMoreContentModel.getItems());
        OnBoardingCardLearnMoreBinding onBoardingCardLearnMoreBinding = this.binding;
        onBoardingCardLearnMoreBinding.rvLearnMoreContent.setLayoutManager(new LinearLayoutManager(onBoardingCardLearnMoreBinding.learnMoreCardContainer.getContext(), 1, false));
        this.binding.rvLearnMoreContent.setAdapter(onBoardingLearnMoreContentAdapter);
    }

    @Nullable
    public final TProOnBoardingMoreContentModel getOnBoardMoreContentModel() {
        return this.onBoardMoreContentModel;
    }

    public final void setOnBoardMoreContentModel(@Nullable TProOnBoardingMoreContentModel tProOnBoardingMoreContentModel) {
        this.onBoardMoreContentModel = tProOnBoardingMoreContentModel;
        if (tProOnBoardingMoreContentModel != null) {
            buildContent(tProOnBoardingMoreContentModel);
        }
    }

    public final void toggleVisibility() {
        int i11 = 8;
        if (getVisibility() == 8) {
            i11 = 0;
        }
        setVisibility(i11);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public OnBoardingCardLearnMoreView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.checkNotNullParameter(context, "context");
        OnBoardingCardLearnMoreBinding inflate = OnBoardingCardLearnMoreBinding.inflate(LayoutInflater.from(context), this, true);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(\n            Lay…           true\n        )");
        this.binding = inflate;
        setVisibility(8);
    }
}
