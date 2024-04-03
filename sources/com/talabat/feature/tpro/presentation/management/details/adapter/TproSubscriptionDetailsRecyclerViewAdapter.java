package com.talabat.feature.tpro.presentation.management.details.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.designsystem.marshmallow.R;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.core.experiment.data.TalabatExperiment;
import com.talabat.core.experiment.domain.TalabatExperimentDataSourceStrategy;
import com.talabat.core.fwfprojectskeys.domain.projects.ecosystems.EcosystemsFeatureFlagsKeys;
import com.talabat.feature.subscriptions.domain.model.Subscription;
import com.talabat.feature.subscriptions.domain.model.SubscriptionPlanCategory;
import com.talabat.feature.subscriptions.domain.model.SubscriptionProduct;
import com.talabat.feature.subscriptions.domain.model.SubscriptionRenewType;
import com.talabat.feature.subscriptions.domain.model.SubscriptionSavingsInfo;
import com.talabat.feature.subscriptions.domain.model.SubscriptionType;
import com.talabat.feature.tpro.presentation.benefits.adapter.onboarding.ProductItemViewHolder;
import com.talabat.feature.tpro.presentation.databinding.ItemLifetimeSavingsBinding;
import com.talabat.feature.tpro.presentation.databinding.ItemSubscriptionDetailsCardInfoBinding;
import com.talabat.feature.tpro.presentation.databinding.ItemSubscriptionDetailsHeaderBinding;
import com.talabat.feature.tpro.presentation.databinding.ItemSubscriptionDetailsInfoBinding;
import com.talabat.feature.tpro.presentation.databinding.ItemSubscriptionDetailsManageBinding;
import com.talabat.feature.tpro.presentation.databinding.ItemTproProductBinding;
import com.talabat.feature.tpro.presentation.databinding.ViewHolderEmptyBinding;
import com.talabat.feature.tpro.presentation.management.details.adapter.viewholder.EmptyViewHolder;
import com.talabat.feature.tpro.presentation.management.details.adapter.viewholder.TproDetailsCardInfoViewHolder;
import com.talabat.feature.tpro.presentation.management.details.adapter.viewholder.TproDetailsHeaderItemViewHolder;
import com.talabat.feature.tpro.presentation.management.details.adapter.viewholder.TproDetailsManageSubscriptionViewHolder;
import com.talabat.feature.tpro.presentation.management.details.adapter.viewholder.TproDetailsSubscriptionInfoItemViewHolder;
import com.talabat.feature.tpro.presentation.management.details.adapter.viewholder.TproLifetimeSavingsItemViewHolder;
import com.talabat.feature.tpro.presentation.model.TProProductDisplayModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 52\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00015BÁ\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\n\u0012\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\b0\u0006\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u0012\u0006\u0010\u0015\u001a\u00020\f\u0012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\b0\n\u0012\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\b0\n\u0012\u0006\u0010\u0018\u001a\u00020\f\u0012\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\b0\n\u0012\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\b0\n\u0012\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\b0\n\u0012\u0006\u0010\u001c\u001a\u00020\f¢\u0006\u0002\u0010\u001dJ\u0010\u0010&\u001a\u00020\u00022\u0006\u0010'\u001a\u00020(H\u0002J\b\u0010)\u001a\u00020*H\u0016J\u0010\u0010+\u001a\u00020*2\u0006\u0010,\u001a\u00020*H\u0016J\u0010\u0010-\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0018\u0010.\u001a\u00020\b2\u0006\u0010/\u001a\u00020\u00022\u0006\u0010,\u001a\u00020*H\u0016J\u0018\u00100\u001a\u00020\u00022\u0006\u0010'\u001a\u00020(2\u0006\u00101\u001a\u00020*H\u0016J\u0010\u00102\u001a\u0002032\u0006\u00104\u001a\u00020\"H\u0002R\u000e\u0010\u001c\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\b0\nX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\b0\nX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\b0\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\nX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\b0\nX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\b0\nX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\b0\nX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010 \u001a\b\u0012\u0004\u0012\u00020\"0!8BX\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$R\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000¨\u00066"}, d2 = {"Lcom/talabat/feature/tpro/presentation/management/details/adapter/TproSubscriptionDetailsRecyclerViewAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "locationRepository", "Lcom/talabat/configuration/location/LocationConfigurationRepository;", "onBackClick", "Lkotlin/Function1;", "Landroid/view/View;", "", "onEndMembershipClick", "Lkotlin/Function0;", "onCreditCardsLoaded", "", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "childFragmentManager", "Landroidx/fragment/app/FragmentManager;", "subscription", "Lcom/talabat/feature/subscriptions/domain/model/Subscription;", "savingsInfo", "Lcom/talabat/feature/subscriptions/domain/model/SubscriptionSavingsInfo;", "isSavingsEnabled", "onCancelAutoRenewalClicked", "onInitiateUpgradeClicked", "isTproSubscriptionUpgradeEnabled", "onManageAutoUpgradeClick", "onLearnMoreClick", "onChangePaymentClick", "canOpenDeeplink", "(Lcom/talabat/configuration/location/LocationConfigurationRepository;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Landroidx/lifecycle/LifecycleOwner;Landroidx/fragment/app/FragmentManager;Lcom/talabat/feature/subscriptions/domain/model/Subscription;Lcom/talabat/feature/subscriptions/domain/model/SubscriptionSavingsInfo;ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Z)V", "context", "Landroid/content/Context;", "products", "", "Lcom/talabat/feature/subscriptions/domain/model/SubscriptionProduct;", "getProducts", "()Ljava/util/List;", "showCancelAutoRenewalBanner", "arrangeViewHolderForCardInfo", "parent", "Landroid/view/ViewGroup;", "getItemCount", "", "getItemViewType", "position", "getShahidPlanActive", "onBindViewHolder", "holder", "onCreateViewHolder", "viewType", "productToDisplayModel", "Lcom/talabat/feature/tpro/presentation/model/TProProductDisplayModel;", "product", "Companion", "com_talabat_feature_tpro_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TproSubscriptionDetailsRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int CARD_INFO = 4;
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int HEADER_ITEM = 0;
    private static final int LIFETIME_SAVINGS = 1;
    private static final int PRODUCTS_ITEMS = 2;
    private static final int SUBSCRIPTION_INFO_ITEM = 3;
    private static final int SUBSCRIPTION_MANAGE = 5;
    private final boolean canOpenDeeplink;
    @NotNull
    private final FragmentManager childFragmentManager;
    @Nullable
    private Context context;
    private final boolean isSavingsEnabled;
    private final boolean isTproSubscriptionUpgradeEnabled;
    @NotNull
    private final LifecycleOwner lifecycleOwner;
    @NotNull
    private final LocationConfigurationRepository locationRepository;
    @NotNull
    private final Function1<View, Unit> onBackClick;
    @NotNull
    private final Function0<Unit> onCancelAutoRenewalClicked;
    @NotNull
    private final Function0<Unit> onChangePaymentClick;
    @NotNull
    private final Function1<Boolean, Unit> onCreditCardsLoaded;
    @NotNull
    private final Function0<Unit> onEndMembershipClick;
    @NotNull
    private final Function0<Unit> onInitiateUpgradeClicked;
    @NotNull
    private final Function0<Unit> onLearnMoreClick;
    @NotNull
    private final Function0<Unit> onManageAutoUpgradeClick;
    @NotNull
    private final SubscriptionSavingsInfo savingsInfo;
    private final boolean showCancelAutoRenewalBanner;
    @NotNull
    private final Subscription subscription;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/talabat/feature/tpro/presentation/management/details/adapter/TproSubscriptionDetailsRecyclerViewAdapter$Companion;", "", "()V", "CARD_INFO", "", "HEADER_ITEM", "LIFETIME_SAVINGS", "PRODUCTS_ITEMS", "SUBSCRIPTION_INFO_ITEM", "SUBSCRIPTION_MANAGE", "com_talabat_feature_tpro_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public TproSubscriptionDetailsRecyclerViewAdapter(@NotNull LocationConfigurationRepository locationConfigurationRepository, @NotNull Function1<? super View, Unit> function1, @NotNull Function0<Unit> function0, @NotNull Function1<? super Boolean, Unit> function12, @NotNull LifecycleOwner lifecycleOwner2, @NotNull FragmentManager fragmentManager, @NotNull Subscription subscription2, @NotNull SubscriptionSavingsInfo subscriptionSavingsInfo, boolean z11, @NotNull Function0<Unit> function02, @NotNull Function0<Unit> function03, boolean z12, @NotNull Function0<Unit> function04, @NotNull Function0<Unit> function05, @NotNull Function0<Unit> function06, boolean z13) {
        boolean z14;
        LocationConfigurationRepository locationConfigurationRepository2 = locationConfigurationRepository;
        Function1<? super View, Unit> function13 = function1;
        Function0<Unit> function07 = function0;
        Function1<? super Boolean, Unit> function14 = function12;
        LifecycleOwner lifecycleOwner3 = lifecycleOwner2;
        FragmentManager fragmentManager2 = fragmentManager;
        Subscription subscription3 = subscription2;
        SubscriptionSavingsInfo subscriptionSavingsInfo2 = subscriptionSavingsInfo;
        Function0<Unit> function08 = function02;
        Function0<Unit> function09 = function03;
        Function0<Unit> function010 = function04;
        Function0<Unit> function011 = function05;
        Function0<Unit> function012 = function06;
        Intrinsics.checkNotNullParameter(locationConfigurationRepository2, "locationRepository");
        Intrinsics.checkNotNullParameter(function13, "onBackClick");
        Intrinsics.checkNotNullParameter(function07, "onEndMembershipClick");
        Intrinsics.checkNotNullParameter(function14, "onCreditCardsLoaded");
        Intrinsics.checkNotNullParameter(lifecycleOwner3, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(fragmentManager2, "childFragmentManager");
        Intrinsics.checkNotNullParameter(subscription3, "subscription");
        Intrinsics.checkNotNullParameter(subscriptionSavingsInfo2, "savingsInfo");
        Intrinsics.checkNotNullParameter(function08, "onCancelAutoRenewalClicked");
        Intrinsics.checkNotNullParameter(function09, "onInitiateUpgradeClicked");
        Intrinsics.checkNotNullParameter(function010, "onManageAutoUpgradeClick");
        Intrinsics.checkNotNullParameter(function011, "onLearnMoreClick");
        Intrinsics.checkNotNullParameter(function012, "onChangePaymentClick");
        this.locationRepository = locationConfigurationRepository2;
        this.onBackClick = function13;
        this.onEndMembershipClick = function07;
        this.onCreditCardsLoaded = function14;
        this.lifecycleOwner = lifecycleOwner3;
        this.childFragmentManager = fragmentManager2;
        this.subscription = subscription3;
        this.savingsInfo = subscriptionSavingsInfo2;
        this.isSavingsEnabled = z11;
        this.onCancelAutoRenewalClicked = function08;
        this.onInitiateUpgradeClicked = function09;
        this.isTproSubscriptionUpgradeEnabled = z12;
        this.onManageAutoUpgradeClick = function010;
        this.onLearnMoreClick = function011;
        this.onChangePaymentClick = function012;
        this.canOpenDeeplink = z13;
        if (subscription2.getType() != SubscriptionType.BillingRetryPeriod || !subscription2.isAutorenewable()) {
            z14 = false;
        } else {
            z14 = true;
        }
        this.showCancelAutoRenewalBanner = z14;
    }

    private final RecyclerView.ViewHolder arrangeViewHolderForCardInfo(ViewGroup viewGroup) {
        if (this.subscription.getPlan().getCategory() != SubscriptionPlanCategory.B2B || getShahidPlanActive(this.subscription)) {
            ItemSubscriptionDetailsCardInfoBinding inflate = ItemSubscriptionDetailsCardInfoBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "inflate(\n               …  false\n                )");
            return new TproDetailsCardInfoViewHolder(inflate, this.lifecycleOwner, this.childFragmentManager, this.onCreditCardsLoaded, this.onChangePaymentClick, this.canOpenDeeplink);
        }
        ViewHolderEmptyBinding inflate2 = ViewHolderEmptyBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate2, "inflate(\n               …  false\n                )");
        return new EmptyViewHolder(inflate2);
    }

    private final List<SubscriptionProduct> getProducts() {
        return this.subscription.getPlan().getProducts();
    }

    private final boolean getShahidPlanActive(Subscription subscription2) {
        boolean z11;
        boolean z12;
        boolean booleanVariant = TalabatExperiment.INSTANCE.getBooleanVariant(EcosystemsFeatureFlagsKeys.IS_TPRO_SHAHID_B2B_RENEWABLE_PLAN_MODE_ENABLED, false, TalabatExperimentDataSourceStrategy.FWF);
        if (subscription2.getPlan().getCategory() == SubscriptionPlanCategory.B2B) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (subscription2.getPlan().getRenewType() == SubscriptionRenewType.Renewable) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (!z11 || !z12 || !booleanVariant) {
            return false;
        }
        return true;
    }

    private final TProProductDisplayModel productToDisplayModel(SubscriptionProduct subscriptionProduct) {
        return new TProProductDisplayModel(subscriptionProduct.getTitle(), subscriptionProduct.getId(), subscriptionProduct.getDescription(), subscriptionProduct.getIcon());
    }

    public int getItemCount() {
        if (this.isSavingsEnabled) {
            return getProducts().size() + 5;
        }
        return getProducts().size() + 4;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x002e, code lost:
        if (r6 != false) goto L_0x0077;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0075, code lost:
        if (r0 != false) goto L_0x0077;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:?, code lost:
        return 2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int getItemViewType(int r8) {
        /*
            r7 = this;
            boolean r0 = r7.isSavingsEnabled
            r1 = 5
            r2 = 4
            r3 = 3
            r4 = 2
            r5 = 0
            r6 = 1
            if (r0 == 0) goto L_0x0055
            if (r8 != 0) goto L_0x000d
            goto L_0x0057
        L_0x000d:
            if (r8 != r6) goto L_0x0012
            r1 = r6
            goto L_0x009e
        L_0x0012:
            java.util.List r0 = r7.getProducts()
            java.util.Collection r0 = (java.util.Collection) r0
            boolean r0 = r0.isEmpty()
            r0 = r0 ^ r6
            if (r0 == 0) goto L_0x0031
            if (r4 > r8) goto L_0x002d
            java.util.List r0 = r7.getProducts()
            int r0 = r0.size()
            int r0 = r0 + r6
            if (r8 > r0) goto L_0x002d
            goto L_0x002e
        L_0x002d:
            r6 = r5
        L_0x002e:
            if (r6 == 0) goto L_0x0031
            goto L_0x0077
        L_0x0031:
            java.util.List r0 = r7.getProducts()
            int r0 = r0.size()
            int r0 = r0 + r4
            if (r8 != r0) goto L_0x003d
            goto L_0x0084
        L_0x003d:
            java.util.List r0 = r7.getProducts()
            int r0 = r0.size()
            int r0 = r0 + r3
            if (r8 != r0) goto L_0x0049
            goto L_0x0091
        L_0x0049:
            java.util.List r0 = r7.getProducts()
            int r0 = r0.size()
            int r0 = r0 + r2
            if (r8 != r0) goto L_0x0057
            goto L_0x009e
        L_0x0055:
            if (r8 != 0) goto L_0x0059
        L_0x0057:
            r1 = r5
            goto L_0x009e
        L_0x0059:
            java.util.List r0 = r7.getProducts()
            java.util.Collection r0 = (java.util.Collection) r0
            boolean r0 = r0.isEmpty()
            r0 = r0 ^ r6
            if (r0 == 0) goto L_0x0079
            if (r6 > r8) goto L_0x0074
            java.util.List r0 = r7.getProducts()
            int r0 = r0.size()
            if (r8 > r0) goto L_0x0074
            r0 = r6
            goto L_0x0075
        L_0x0074:
            r0 = r5
        L_0x0075:
            if (r0 == 0) goto L_0x0079
        L_0x0077:
            r1 = r4
            goto L_0x009e
        L_0x0079:
            java.util.List r0 = r7.getProducts()
            int r0 = r0.size()
            int r0 = r0 + r6
            if (r8 != r0) goto L_0x0086
        L_0x0084:
            r1 = r3
            goto L_0x009e
        L_0x0086:
            java.util.List r0 = r7.getProducts()
            int r0 = r0.size()
            int r0 = r0 + r4
            if (r8 != r0) goto L_0x0093
        L_0x0091:
            r1 = r2
            goto L_0x009e
        L_0x0093:
            java.util.List r0 = r7.getProducts()
            int r0 = r0.size()
            int r0 = r0 + r3
            if (r8 != r0) goto L_0x0057
        L_0x009e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.tpro.presentation.management.details.adapter.TproSubscriptionDetailsRecyclerViewAdapter.getItemViewType(int):int");
    }

    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder viewHolder, int i11) {
        int i12;
        String str;
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        if (viewHolder instanceof TproDetailsHeaderItemViewHolder) {
            ((TproDetailsHeaderItemViewHolder) viewHolder).bind(this.subscription);
        } else if (viewHolder instanceof TproLifetimeSavingsItemViewHolder) {
            ((TproLifetimeSavingsItemViewHolder) viewHolder).bind();
        } else if (viewHolder instanceof ProductItemViewHolder) {
            if (this.isSavingsEnabled) {
                i12 = i11 - 2;
            } else {
                i12 = i11 - 1;
            }
            int i13 = i12;
            if (!getProducts().isEmpty()) {
                ProductItemViewHolder productItemViewHolder = (ProductItemViewHolder) viewHolder;
                TProProductDisplayModel productToDisplayModel = productToDisplayModel(getProducts().get(i13));
                int i14 = R.drawable.ds_delivery_bike_filled;
                String string = viewHolder.itemView.getContext().getString(com.talabat.localization.R.string.tpro_on_boarding_benefits_title);
                Intrinsics.checkNotNullExpressionValue(string, "holder.itemView.context.…                        )");
                if (i13 != getProducts().size() - 1 || !getShahidPlanActive(this.subscription)) {
                    str = "";
                } else {
                    Context context2 = this.context;
                    Intrinsics.checkNotNull(context2);
                    str = context2.getString(com.talabat.localization.R.string.learn_more_about_pro);
                }
                String str2 = str;
                Intrinsics.checkNotNullExpressionValue(str2, "if ((index == products.s…                ) else \"\"");
                productItemViewHolder.bind(productToDisplayModel, i14, i13, string, str2);
            }
        } else if (viewHolder instanceof TproDetailsSubscriptionInfoItemViewHolder) {
            ((TproDetailsSubscriptionInfoItemViewHolder) viewHolder).bind(this.subscription, this.onCancelAutoRenewalClicked, this.onInitiateUpgradeClicked);
        } else if (viewHolder instanceof TproDetailsCardInfoViewHolder) {
            ((TproDetailsCardInfoViewHolder) viewHolder).bind();
        } else if (viewHolder instanceof TproDetailsManageSubscriptionViewHolder) {
            ((TproDetailsManageSubscriptionViewHolder) viewHolder).bind(this.subscription, this.onEndMembershipClick, this.onManageAutoUpgradeClick);
        }
    }

    @NotNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i11) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        this.context = viewGroup.getContext();
        if (i11 == 0) {
            ItemSubscriptionDetailsHeaderBinding inflate = ItemSubscriptionDetailsHeaderBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "inflate(\n               …  false\n                )");
            return new TproDetailsHeaderItemViewHolder(inflate, this.onBackClick);
        } else if (i11 == 1) {
            ItemLifetimeSavingsBinding inflate2 = ItemLifetimeSavingsBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate2, "inflate(\n               …  false\n                )");
            return new TproLifetimeSavingsItemViewHolder(inflate2, this.savingsInfo, this.locationRepository);
        } else if (i11 == 2) {
            ItemTproProductBinding inflate3 = ItemTproProductBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate3, "inflate(\n               …  false\n                )");
            return new ProductItemViewHolder(inflate3, this.onLearnMoreClick);
        } else if (i11 == 3) {
            ItemSubscriptionDetailsInfoBinding inflate4 = ItemSubscriptionDetailsInfoBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate4, "inflate(\n               …  false\n                )");
            return new TproDetailsSubscriptionInfoItemViewHolder(inflate4, this.showCancelAutoRenewalBanner, this.isTproSubscriptionUpgradeEnabled);
        } else if (i11 == 4) {
            return arrangeViewHolderForCardInfo(viewGroup);
        } else {
            if (i11 != 5) {
                ItemSubscriptionDetailsHeaderBinding inflate5 = ItemSubscriptionDetailsHeaderBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
                Intrinsics.checkNotNullExpressionValue(inflate5, "inflate(\n               …  false\n                )");
                return new TproDetailsHeaderItemViewHolder(inflate5, this.onBackClick);
            }
            ItemSubscriptionDetailsManageBinding inflate6 = ItemSubscriptionDetailsManageBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate6, "inflate(\n               …  false\n                )");
            return new TproDetailsManageSubscriptionViewHolder(inflate6);
        }
    }
}
