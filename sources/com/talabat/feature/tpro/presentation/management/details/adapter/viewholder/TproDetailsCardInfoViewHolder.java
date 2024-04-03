package com.talabat.feature.tpro.presentation.management.details.adapter.viewholder;

import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.talabat.core.experiment.data.TalabatExperiment;
import com.talabat.core.experiment.domain.TalabatExperimentDataSourceStrategy;
import com.talabat.core.fwfprojectskeys.domain.projects.ecosystems.EcosystemsExperimentsKeys;
import com.talabat.feature.tpro.presentation.databinding.ItemSubscriptionDetailsCardInfoBinding;
import com.talabat.talabatcommon.views.wallet.cardViewWidgets.view.DefaultCardView;
import ep.a;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\n*\u0002\u0011\u0014\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\r\u0012\u0006\u0010\u000e\u001a\u00020\n¢\u0006\u0002\u0010\u000fJ\b\u0010\u0016\u001a\u00020\u000bH\u0002J\u0006\u0010\u0017\u001a\u00020\u000bJ\b\u0010\u0018\u001a\u00020\u000bH\u0002J\u0017\u0010\u0019\u001a\u00020\u000b2\b\u0010\u001a\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0002\u0010\u001bJ\b\u0010\u001c\u001a\u00020\nH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0004\n\u0002\u0010\u0012R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0004\n\u0002\u0010\u0015R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\rX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/talabat/feature/tpro/presentation/management/details/adapter/viewholder/TproDetailsCardInfoViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/talabat/feature/tpro/presentation/databinding/ItemSubscriptionDetailsCardInfoBinding;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "childFragmentManager", "Landroidx/fragment/app/FragmentManager;", "onCreditCardsLoaded", "Lkotlin/Function1;", "", "", "onChangePaymentClick", "Lkotlin/Function0;", "canOpenDeeplink", "(Lcom/talabat/feature/tpro/presentation/databinding/ItemSubscriptionDetailsCardInfoBinding;Landroidx/lifecycle/LifecycleOwner;Landroidx/fragment/app/FragmentManager;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Z)V", "cardListInterface", "com/talabat/feature/tpro/presentation/management/details/adapter/viewholder/TproDetailsCardInfoViewHolder$cardListInterface$1", "Lcom/talabat/feature/tpro/presentation/management/details/adapter/viewholder/TproDetailsCardInfoViewHolder$cardListInterface$1;", "defaultCardInterface", "com/talabat/feature/tpro/presentation/management/details/adapter/viewholder/TproDetailsCardInfoViewHolder$defaultCardInterface$1", "Lcom/talabat/feature/tpro/presentation/management/details/adapter/viewholder/TproDetailsCardInfoViewHolder$defaultCardInterface$1;", "addWalletPaymentWidgetObservers", "bind", "bindPaymentWidget", "hideThePaymentWidgetLoading", "isPaymentViewReady", "(Ljava/lang/Boolean;)V", "isFlutterPaymentWidgetExperimentEnabled", "com_talabat_feature_tpro_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TproDetailsCardInfoViewHolder extends RecyclerView.ViewHolder {
    /* access modifiers changed from: private */
    @NotNull
    public final ItemSubscriptionDetailsCardInfoBinding binding;
    /* access modifiers changed from: private */
    public final boolean canOpenDeeplink;
    /* access modifiers changed from: private */
    @NotNull
    public final TproDetailsCardInfoViewHolder$cardListInterface$1 cardListInterface = new TproDetailsCardInfoViewHolder$cardListInterface$1(this);
    /* access modifiers changed from: private */
    @NotNull
    public final FragmentManager childFragmentManager;
    @NotNull
    private final TproDetailsCardInfoViewHolder$defaultCardInterface$1 defaultCardInterface = new TproDetailsCardInfoViewHolder$defaultCardInterface$1(this);
    @NotNull
    private final LifecycleOwner lifecycleOwner;
    /* access modifiers changed from: private */
    @NotNull
    public final Function0<Unit> onChangePaymentClick;
    @NotNull
    private final Function1<Boolean, Unit> onCreditCardsLoaded;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TproDetailsCardInfoViewHolder(@NotNull ItemSubscriptionDetailsCardInfoBinding itemSubscriptionDetailsCardInfoBinding, @NotNull LifecycleOwner lifecycleOwner2, @NotNull FragmentManager fragmentManager, @NotNull Function1<? super Boolean, Unit> function1, @NotNull Function0<Unit> function0, boolean z11) {
        super(itemSubscriptionDetailsCardInfoBinding.getRoot());
        Intrinsics.checkNotNullParameter(itemSubscriptionDetailsCardInfoBinding, "binding");
        Intrinsics.checkNotNullParameter(lifecycleOwner2, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(fragmentManager, "childFragmentManager");
        Intrinsics.checkNotNullParameter(function1, "onCreditCardsLoaded");
        Intrinsics.checkNotNullParameter(function0, "onChangePaymentClick");
        this.binding = itemSubscriptionDetailsCardInfoBinding;
        this.lifecycleOwner = lifecycleOwner2;
        this.childFragmentManager = fragmentManager;
        this.onCreditCardsLoaded = function1;
        this.onChangePaymentClick = function0;
        this.canOpenDeeplink = z11;
    }

    private final void addWalletPaymentWidgetObservers() {
        this.binding.walletPaymentWidget.getCardLoadingStatus().observe(this.lifecycleOwner, new a(this));
    }

    private final void bindPaymentWidget() {
        DefaultCardView defaultCardView = this.binding.walletPaymentWidget;
        Intrinsics.checkNotNullExpressionValue(defaultCardView, "");
        DefaultCardView.setDefaultCardViewFullScreenListener$default(defaultCardView, this.defaultCardInterface, true, false, false, 8, (Object) null);
        defaultCardView.addDefaultCard();
    }

    /* access modifiers changed from: private */
    public final void hideThePaymentWidgetLoading(Boolean bool) {
        boolean z11;
        if (bool != null) {
            if (!bool.booleanValue()) {
                bool = null;
            }
            if (bool != null) {
                bool.booleanValue();
                Function1<Boolean, Unit> function1 = this.onCreditCardsLoaded;
                if (this.binding.walletPaymentWidget.getSelectedCard() != null) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                function1.invoke(Boolean.valueOf(z11));
                this.binding.walletPaymentLoading.setVisibility(8);
                this.binding.walletPaymentWidget.setVisibility(0);
            }
        }
    }

    /* access modifiers changed from: private */
    public final boolean isFlutterPaymentWidgetExperimentEnabled() {
        return Intrinsics.areEqual((Object) TalabatExperiment.INSTANCE.getStringVariant(EcosystemsExperimentsKeys.TPRO_FLUTTER_PAYMENT_WIDGET, "Control", TalabatExperimentDataSourceStrategy.FWF), (Object) "Variation1");
    }

    public final void bind() {
        addWalletPaymentWidgetObservers();
        bindPaymentWidget();
    }
}
