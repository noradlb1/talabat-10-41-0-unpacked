package com.talabat.feature.tpro.presentation.benefits.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.talabat.feature.subscriptions.domain.model.TProOnBoardingExpandableItemModel;
import com.talabat.feature.subscriptions.domain.model.TProOnBoardingExpandableWidgetModel;
import com.talabat.feature.tpro.presentation.benefits.adapter.expandablelist.HeroItemExpandableAdapter;
import com.talabat.feature.tpro.presentation.constants.GAConstants;
import com.talabat.feature.tpro.presentation.databinding.ExpandableItemCardBinding;
import com.talabat.feature.tpro.presentation.util.ExtensionsKt;
import com.talabat.feature.tpro.presentation.util.FadeAnimationKt;
import com.talabat.talabatcommon.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import so.b;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJB\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00150\u00192$\u0010\u001a\u001a \u0012\u0004\u0012\u00020\u001c\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001c0\u001d\u0012\u0004\u0012\u00020\u00150\u001bJD\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00150\u00192$\u0010\u001a\u001a \u0012\u0004\u0012\u00020\u001c\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001c0\u001d\u0012\u0004\u0012\u00020\u00150\u001bH\u0002J6\u0010\u001f\u001a\u00020\u00152\u0006\u0010 \u001a\u00020\u001c2$\u0010\u001a\u001a \u0012\u0004\u0012\u00020\u001c\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001c0\u001d\u0012\u0004\u0012\u00020\u00150\u001bH\u0002J\u0016\u0010!\u001a\u00020\u00152\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020$0#H\u0002R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006%"}, d2 = {"Lcom/talabat/feature/tpro/presentation/benefits/view/ExpandableOnboardingCard;", "Landroidx/cardview/widget/CardView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/talabat/feature/tpro/presentation/databinding/ExpandableItemCardBinding;", "getBinding", "()Lcom/talabat/feature/tpro/presentation/databinding/ExpandableItemCardBinding;", "heroItemAdapter", "Lcom/talabat/feature/tpro/presentation/benefits/adapter/expandablelist/HeroItemExpandableAdapter;", "isExpanded", "", "()Z", "setExpanded", "(Z)V", "buildContent", "", "tProOnBoardingExpandableWidgetModel", "Lcom/talabat/feature/subscriptions/domain/model/TProOnBoardingExpandableWidgetModel;", "notifyItemChanged", "Lkotlin/Function0;", "triggerGaEvent", "Lkotlin/Function2;", "", "Lkotlin/Pair;", "handleExpandableList", "logGaEventIfRequired", "trackingId", "setUpTextInExpandableCards", "listOfExpandableItems", "", "Lcom/talabat/feature/subscriptions/domain/model/TProOnBoardingExpandableItemModel;", "com_talabat_feature_tpro_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ExpandableOnboardingCard extends CardView {
    @NotNull
    private final ExpandableItemCardBinding binding;
    @Nullable
    private HeroItemExpandableAdapter heroItemAdapter;
    private boolean isExpanded;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ExpandableOnboardingCard(@NotNull Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ExpandableOnboardingCard(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ExpandableOnboardingCard(Context context, AttributeSet attributeSet, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }

    private final void handleExpandableList(TProOnBoardingExpandableWidgetModel tProOnBoardingExpandableWidgetModel, Function0<Unit> function0, Function2<? super String, ? super Pair<String, String>, Unit> function2) {
        int i11;
        setUpTextInExpandableCards(tProOnBoardingExpandableWidgetModel.getListItems());
        TextView textView = this.binding.tvCardSeeHow;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.tvCardSeeHow");
        FadeAnimationKt.changeVisibility(textView, !this.isExpanded);
        if (this.isExpanded) {
            i11 = R.drawable.ic_m_choice_chevron_up;
        } else {
            i11 = R.drawable.ic_m_choice_chevron_down;
        }
        ImageView imageView = this.binding.ivSeeHow;
        imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), i11));
        this.binding.containerSeeHow.setOnClickListener(new b(this, tProOnBoardingExpandableWidgetModel, function2, function0));
    }

    /* access modifiers changed from: private */
    /* renamed from: handleExpandableList$lambda-1  reason: not valid java name */
    public static final void m10366handleExpandableList$lambda1(ExpandableOnboardingCard expandableOnboardingCard, TProOnBoardingExpandableWidgetModel tProOnBoardingExpandableWidgetModel, Function2 function2, Function0 function0, View view) {
        Intrinsics.checkNotNullParameter(expandableOnboardingCard, "this$0");
        Intrinsics.checkNotNullParameter(tProOnBoardingExpandableWidgetModel, "$tProOnBoardingExpandableWidgetModel");
        Intrinsics.checkNotNullParameter(function2, "$triggerGaEvent");
        Intrinsics.checkNotNullParameter(function0, "$notifyItemChanged");
        expandableOnboardingCard.logGaEventIfRequired(tProOnBoardingExpandableWidgetModel.getTrackingId(), function2);
        expandableOnboardingCard.isExpanded = !expandableOnboardingCard.isExpanded;
        RecyclerView recyclerView = expandableOnboardingCard.binding.expandableListItems;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.expandableListItems");
        FadeAnimationKt.changeVisibilityWithFade(recyclerView, expandableOnboardingCard.isExpanded);
        function0.invoke();
    }

    private final void logGaEventIfRequired(String str, Function2<? super String, ? super Pair<String, String>, Unit> function2) {
        if (!this.isExpanded) {
            function2.invoke(GAConstants.SUBSCRIPTION_BENEFIT_CARD_CLICKED, TuplesKt.to(GAConstants.CARD_CONTENT, str));
        }
    }

    private final void setUpTextInExpandableCards(List<TProOnBoardingExpandableItemModel> list) {
        if (this.heroItemAdapter == null) {
            HeroItemExpandableAdapter heroItemExpandableAdapter = new HeroItemExpandableAdapter(list);
            this.heroItemAdapter = heroItemExpandableAdapter;
            this.binding.expandableListItems.setAdapter(heroItemExpandableAdapter);
            ExpandableItemCardBinding expandableItemCardBinding = this.binding;
            expandableItemCardBinding.expandableListItems.setLayoutManager(new LinearLayoutManager(expandableItemCardBinding.tvCardContent.getContext(), 1, false));
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void buildContent(@NotNull TProOnBoardingExpandableWidgetModel tProOnBoardingExpandableWidgetModel, @NotNull Function0<Unit> function0, @NotNull Function2<? super String, ? super Pair<String, String>, Unit> function2) {
        Intrinsics.checkNotNullParameter(tProOnBoardingExpandableWidgetModel, "tProOnBoardingExpandableWidgetModel");
        Intrinsics.checkNotNullParameter(function0, "notifyItemChanged");
        Intrinsics.checkNotNullParameter(function2, "triggerGaEvent");
        setVisibility(0);
        this.binding.tvCardHeaderName.setText(tProOnBoardingExpandableWidgetModel.getHeaderTitle());
        TextView textView = this.binding.tvCardHeaderName;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.tvCardHeaderName");
        ExtensionsKt.applyTextColor(textView, tProOnBoardingExpandableWidgetModel.getHeaderTitleColor());
        this.binding.tvCardHeader.setText(tProOnBoardingExpandableWidgetModel.getTitle());
        TextView textView2 = this.binding.tvCardHeader;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.tvCardHeader");
        ExtensionsKt.applyTextColor(textView2, tProOnBoardingExpandableWidgetModel.getTitleColor());
        this.binding.tvCardContent.setText(tProOnBoardingExpandableWidgetModel.getSubtitle());
        TextView textView3 = this.binding.tvCardContent;
        Intrinsics.checkNotNullExpressionValue(textView3, "binding.tvCardContent");
        ExtensionsKt.applyTextColor(textView3, tProOnBoardingExpandableWidgetModel.getSubTitleColor());
        this.binding.tvCardSeeHow.setText(tProOnBoardingExpandableWidgetModel.getExpandWidgetTitle());
        if (!tProOnBoardingExpandableWidgetModel.getListItems().isEmpty()) {
            handleExpandableList(tProOnBoardingExpandableWidgetModel, function0, function2);
            return;
        }
        LinearLayout linearLayout = this.binding.containerSeeHow;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.containerSeeHow");
        FadeAnimationKt.changeVisibility(linearLayout, false);
    }

    @NotNull
    public final ExpandableItemCardBinding getBinding() {
        return this.binding;
    }

    public final boolean isExpanded() {
        return this.isExpanded;
    }

    public final void setExpanded(boolean z11) {
        this.isExpanded = z11;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ExpandableOnboardingCard(@NotNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.checkNotNullParameter(context, "context");
        ExpandableItemCardBinding inflate = ExpandableItemCardBinding.inflate(LayoutInflater.from(context), this, true);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(\n            Lay…           true\n        )");
        this.binding = inflate;
        setVisibility(8);
    }
}
