package com.talabat.home.useraccount;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.talabat.R;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.country.Country;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.core.deeplink.domain.DeepLinkNavigator;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.observabilityNew.domain.IAppLaunchTrackingManager;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.customer.domain.CustomerRepository;
import com.talabat.feature.subscriptions.domain.ISubscriptionStatusRepository;
import com.talabat.feature.subscriptions.domain.ISubscriptionsFeatureFlagsRepository;
import com.talabat.feature.subscriptions.domain.ISubscriptionsTracker;
import com.talabat.feature.tpro.presentation.savings.account.SideMenuTProSavingsViewHolder;
import com.talabat.feature.tpro.presentation.savings.account.SideMenuTProSavingsViewPresenter;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.sidemenu.SideMenuBannerPaddingViewHolder;
import com.talabat.sidemenu.SideMenuBannerViewHolder;
import com.talabat.sidemenu.SideMenuHeader;
import com.talabat.sidemenu.SideMenuHeaderViewHolder;
import com.talabat.sidemenu.SideMenuItemViewHolder;
import com.talabat.sidemenu.SideMenuRecyclerViewAdapter;
import com.talabat.sidemenu.SideMenuRewardViewHolder;
import com.talabat.sidemenu.SideMenuRewardViewPresenter;
import com.talabat.sidemenu.SideMenuTLifeViewHolder;
import com.talabat.sidemenu.SideMenuTLifeViewPresenter;
import com.talabat.sidemenu.SideMenuUserViewHolder;
import com.talabat.sidemenu.SideMenuViewType;
import com.talabat.sidemenu.bnpl.SideMenuBnplViewHolder;
import com.talabat.sidemenu.tPro.SideMenuTProViewHolder;
import com.talabat.sidemenu.tPro.SideMenuTProViewPresenter;
import com.talabat.sidemenu.vouchers.SideMenuVouchersViewHolder;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000ð\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001BÆ\u0001\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u0012\u0006\u0010U\u001a\u00020T\u0012\f\u0010X\u001a\b\u0012\u0004\u0012\u00020W0V\u0012\u0006\u0010Y\u001a\u00020<\u0012\u0006\u0010!\u001a\u00020 \u0012\u0006\u0010$\u001a\u00020#\u0012\u0006\u0010'\u001a\u00020&\u0012\u0006\u0010*\u001a\u00020)\u0012\u0006\u0010-\u001a\u00020,\u0012\u0006\u00100\u001a\u00020/\u0012\u0006\u00103\u001a\u000202\u0012\u0006\u0010[\u001a\u00020Z\u0012\u0006\u0010]\u001a\u00020\\\u0012\u0006\u0010_\u001a\u00020^\u0012\u0006\u00106\u001a\u000205\u0012\u0006\u00109\u001a\u000208\u0012!\u0010@\u001a\u001d\u0012\u0013\u0012\u00110<¢\u0006\f\b=\u0012\b\b>\u0012\u0004\b\b(?\u0012\u0004\u0012\u00020\t0;\u0012\f\u0010C\u001a\b\u0012\u0004\u0012\u00020\t0B¢\u0006\u0004\b`\u0010aJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\n\u001a\u00020\tH\u0002J\u0018\u0010\r\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0018\u0010\u0010\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000bH\u0016J\u0010\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u0006\u0010\u0014\u001a\u00020\tJ\u0018\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0017H\u0014R\u0014\u0010\u001b\u001a\u00020\u001a8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001e\u001a\u00020\u001d8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010!\u001a\u00020 8\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010$\u001a\u00020#8\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010'\u001a\u00020&8\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010*\u001a\u00020)8\u0002X\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0014\u0010-\u001a\u00020,8\u0002X\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u0014\u00100\u001a\u00020/8\u0002X\u0004¢\u0006\u0006\n\u0004\b0\u00101R\u0014\u00103\u001a\u0002028\u0002X\u0004¢\u0006\u0006\n\u0004\b3\u00104R\u0014\u00106\u001a\u0002058\u0002X\u0004¢\u0006\u0006\n\u0004\b6\u00107R\u0014\u00109\u001a\u0002088\u0002X\u0004¢\u0006\u0006\n\u0004\b9\u0010:R/\u0010@\u001a\u001d\u0012\u0013\u0012\u00110<¢\u0006\f\b=\u0012\b\b>\u0012\u0004\b\b(?\u0012\u0004\u0012\u00020\t0;8\u0002X\u0004¢\u0006\u0006\n\u0004\b@\u0010AR\u001a\u0010C\u001a\b\u0012\u0004\u0012\u00020\t0B8\u0002X\u0004¢\u0006\u0006\n\u0004\bC\u0010DR\u0018\u0010F\u001a\u0004\u0018\u00010E8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bF\u0010GR\u0018\u0010I\u001a\u0004\u0018\u00010H8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bI\u0010JR\u0018\u0010L\u001a\u0004\u0018\u00010K8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bL\u0010MR\u001b\u0010S\u001a\u00020N8BX\u0002¢\u0006\f\n\u0004\bO\u0010P\u001a\u0004\bQ\u0010R¨\u0006b"}, d2 = {"Lcom/talabat/home/useraccount/UserAccountRecyclerViewAdapter;", "Lcom/talabat/sidemenu/SideMenuRecyclerViewAdapter;", "Landroid/view/ViewGroup;", "parent", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "getRewardsViewHolder", "getTLifeViewHolder", "getTProSavingsViewHolder", "getTProViewHolder", "", "updateTProAutoRenewal", "", "viewType", "onCreateViewHolder", "holder", "position", "onBindViewHolder", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "onDetachedFromRecyclerView", "refreshSavingsInfo", "Landroid/widget/ImageView;", "selectedCountryImageView", "Landroid/widget/TextView;", "countryTitleTextView", "f", "Lcom/talabat/configuration/ConfigurationLocalRepository;", "configurationLocalRepository", "Lcom/talabat/configuration/ConfigurationLocalRepository;", "Lcom/talabat/configuration/location/LocationConfigurationRepository;", "locationConfigurationRepository", "Lcom/talabat/configuration/location/LocationConfigurationRepository;", "Lcom/talabat/configuration/country/Country;", "selectedCountry", "Lcom/talabat/configuration/country/Country;", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "featureFlagRepo", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "Lcom/talabat/feature/subscriptions/domain/ISubscriptionsFeatureFlagsRepository;", "subscriptionsFeatureFlag", "Lcom/talabat/feature/subscriptions/domain/ISubscriptionsFeatureFlagsRepository;", "Lcom/talabat/feature/subscriptions/domain/ISubscriptionStatusRepository;", "subscriptionStatusRepository", "Lcom/talabat/feature/subscriptions/domain/ISubscriptionStatusRepository;", "Lcom/talabat/feature/subscriptions/domain/ISubscriptionsTracker;", "subscriptionTracker", "Lcom/talabat/feature/subscriptions/domain/ISubscriptionsTracker;", "Lcom/talabat/core/observabilityNew/domain/IAppLaunchTrackingManager;", "appLaunchTrackingManager", "Lcom/talabat/core/observabilityNew/domain/IAppLaunchTrackingManager;", "Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;", "observabilityManager", "Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;", "Lcom/talabat/customer/domain/CustomerRepository;", "customerRepository", "Lcom/talabat/customer/domain/CustomerRepository;", "Lcom/talabat/core/deeplink/domain/DeepLinkNavigator;", "navigator", "Lcom/talabat/core/deeplink/domain/DeepLinkNavigator;", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "success", "onUpdateRenewalResult", "Lkotlin/jvm/functions/Function1;", "Lkotlin/Function0;", "onTproSavingsClick", "Lkotlin/jvm/functions/Function0;", "Lcom/talabat/sidemenu/SideMenuRewardViewPresenter;", "sideMenuRewardViewPresenter", "Lcom/talabat/sidemenu/SideMenuRewardViewPresenter;", "Lcom/talabat/sidemenu/SideMenuTLifeViewPresenter;", "sideMenuTLifePresenter", "Lcom/talabat/sidemenu/SideMenuTLifeViewPresenter;", "Lcom/talabat/sidemenu/tPro/SideMenuTProViewPresenter;", "sideMenuTProPresenter", "Lcom/talabat/sidemenu/tPro/SideMenuTProViewPresenter;", "Lcom/talabat/feature/tpro/presentation/savings/account/SideMenuTProSavingsViewPresenter;", "sideMenuTProSavingsViewPresenter$delegate", "Lkotlin/Lazy;", "getSideMenuTProSavingsViewPresenter", "()Lcom/talabat/feature/tpro/presentation/savings/account/SideMenuTProSavingsViewPresenter;", "sideMenuTProSavingsViewPresenter", "Lcom/talabat/sidemenu/SideMenuRecyclerViewAdapter$SidemenuClicked;", "sidemenuClicked", "", "Lcom/talabat/sidemenu/SidemenuExpandableListItem;", "sidemenuExpandableListItems", "isTalabatCreditLoading", "Lcom/talabat/feature/subscriptions/domain/usecase/GetSavingsInfoUseCase;", "getSavingsInfo", "Lcom/talabat/feature/subscriptions/domain/usecase/UpdateAutoRenewalUseCase;", "updateAutoRenewalUseCase", "Lcom/talabat/core/dispatcher/domain/CoroutineDispatchersFactory;", "coroutineDispatchersFactory", "<init>", "(Lcom/talabat/configuration/ConfigurationLocalRepository;Lcom/talabat/configuration/location/LocationConfigurationRepository;Lcom/talabat/sidemenu/SideMenuRecyclerViewAdapter$SidemenuClicked;Ljava/util/List;ZLcom/talabat/configuration/country/Country;Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;Lcom/talabat/feature/subscriptions/domain/ISubscriptionsFeatureFlagsRepository;Lcom/talabat/feature/subscriptions/domain/ISubscriptionStatusRepository;Lcom/talabat/feature/subscriptions/domain/ISubscriptionsTracker;Lcom/talabat/core/observabilityNew/domain/IAppLaunchTrackingManager;Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;Lcom/talabat/feature/subscriptions/domain/usecase/GetSavingsInfoUseCase;Lcom/talabat/feature/subscriptions/domain/usecase/UpdateAutoRenewalUseCase;Lcom/talabat/core/dispatcher/domain/CoroutineDispatchersFactory;Lcom/talabat/customer/domain/CustomerRepository;Lcom/talabat/core/deeplink/domain/DeepLinkNavigator;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0})
public final class UserAccountRecyclerViewAdapter extends SideMenuRecyclerViewAdapter {
    @NotNull
    private final IAppLaunchTrackingManager appLaunchTrackingManager;
    @NotNull
    private final ConfigurationLocalRepository configurationLocalRepository;
    @NotNull
    private final CustomerRepository customerRepository;
    @NotNull
    private final ITalabatFeatureFlag featureFlagRepo;
    @NotNull
    private final LocationConfigurationRepository locationConfigurationRepository;
    @NotNull
    private final DeepLinkNavigator navigator;
    @NotNull
    private final IObservabilityManager observabilityManager;
    @NotNull
    private final Function0<Unit> onTproSavingsClick;
    /* access modifiers changed from: private */
    @NotNull
    public final Function1<Boolean, Unit> onUpdateRenewalResult;
    /* access modifiers changed from: private */
    @NotNull
    public final Country selectedCountry;
    @Nullable
    private SideMenuRewardViewPresenter sideMenuRewardViewPresenter;
    @Nullable
    private SideMenuTLifeViewPresenter sideMenuTLifePresenter;
    @Nullable
    private SideMenuTProViewPresenter sideMenuTProPresenter;
    @NotNull
    private final Lazy sideMenuTProSavingsViewPresenter$delegate;
    /* access modifiers changed from: private */
    @NotNull
    public final ISubscriptionStatusRepository subscriptionStatusRepository;
    /* access modifiers changed from: private */
    @NotNull
    public final ISubscriptionsTracker subscriptionTracker;
    @NotNull
    private final ISubscriptionsFeatureFlagsRepository subscriptionsFeatureFlag;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Country.values().length];
            iArr[Country.KUWAIT.ordinal()] = 1;
            iArr[Country.KSA.ordinal()] = 2;
            iArr[Country.BAHRAIN.ordinal()] = 3;
            iArr[Country.OMAN.ordinal()] = 4;
            iArr[Country.QATAR.ordinal()] = 5;
            iArr[Country.UAE.ordinal()] = 6;
            iArr[Country.JORDAN.ordinal()] = 7;
            iArr[Country.EGYPT.ordinal()] = 8;
            iArr[Country.IRAQ.ordinal()] = 9;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public UserAccountRecyclerViewAdapter(@org.jetbrains.annotations.NotNull com.talabat.configuration.ConfigurationLocalRepository r18, @org.jetbrains.annotations.NotNull com.talabat.configuration.location.LocationConfigurationRepository r19, @org.jetbrains.annotations.NotNull com.talabat.sidemenu.SideMenuRecyclerViewAdapter.SidemenuClicked r20, @org.jetbrains.annotations.NotNull java.util.List<? extends com.talabat.sidemenu.SidemenuExpandableListItem> r21, boolean r22, @org.jetbrains.annotations.NotNull com.talabat.configuration.country.Country r23, @org.jetbrains.annotations.NotNull com.talabat.core.featureflag.domain.ITalabatFeatureFlag r24, @org.jetbrains.annotations.NotNull com.talabat.feature.subscriptions.domain.ISubscriptionsFeatureFlagsRepository r25, @org.jetbrains.annotations.NotNull com.talabat.feature.subscriptions.domain.ISubscriptionStatusRepository r26, @org.jetbrains.annotations.NotNull com.talabat.feature.subscriptions.domain.ISubscriptionsTracker r27, @org.jetbrains.annotations.NotNull com.talabat.core.observabilityNew.domain.IAppLaunchTrackingManager r28, @org.jetbrains.annotations.NotNull com.talabat.core.observabilityNew.domain.IObservabilityManager r29, @org.jetbrains.annotations.NotNull com.talabat.feature.subscriptions.domain.usecase.GetSavingsInfoUseCase r30, @org.jetbrains.annotations.NotNull com.talabat.feature.subscriptions.domain.usecase.UpdateAutoRenewalUseCase r31, @org.jetbrains.annotations.NotNull com.talabat.core.dispatcher.domain.CoroutineDispatchersFactory r32, @org.jetbrains.annotations.NotNull com.talabat.customer.domain.CustomerRepository r33, @org.jetbrains.annotations.NotNull com.talabat.core.deeplink.domain.DeepLinkNavigator r34, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> r35, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function0<kotlin.Unit> r36) {
        /*
            r17 = this;
            r11 = r17
            r12 = r18
            r13 = r19
            r14 = r23
            r15 = r24
            r10 = r25
            r9 = r26
            r8 = r27
            r7 = r28
            r6 = r29
            r5 = r30
            r4 = r31
            r3 = r32
            r2 = r33
            r1 = r34
            r0 = r35
            java.lang.String r11 = "configurationLocalRepository"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r11)
            java.lang.String r11 = "locationConfigurationRepository"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r11)
            java.lang.String r11 = "sidemenuClicked"
            r13 = r20
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r11)
            java.lang.String r11 = "sidemenuExpandableListItems"
            r13 = r21
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r11)
            java.lang.String r11 = "selectedCountry"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r11)
            java.lang.String r11 = "featureFlagRepo"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r11)
            java.lang.String r11 = "subscriptionsFeatureFlag"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r11)
            java.lang.String r11 = "subscriptionStatusRepository"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r11)
            java.lang.String r11 = "subscriptionTracker"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r11)
            java.lang.String r11 = "appLaunchTrackingManager"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r11)
            java.lang.String r11 = "observabilityManager"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r11)
            java.lang.String r11 = "getSavingsInfo"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r11)
            java.lang.String r11 = "updateAutoRenewalUseCase"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r11)
            java.lang.String r11 = "coroutineDispatchersFactory"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r11)
            java.lang.String r11 = "customerRepository"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r11)
            java.lang.String r11 = "navigator"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r11)
            java.lang.String r11 = "onUpdateRenewalResult"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r11)
            java.lang.String r11 = "onTproSavingsClick"
            r7 = r36
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r11)
            r11 = 1
            r16 = 1
            r0 = r17
            r1 = r18
            r2 = r19
            r3 = r20
            r4 = r21
            r13 = r5
            r5 = r22
            r13 = r6
            r6 = r11
            r11 = r28
            r7 = r16
            r8 = r23
            r9 = r24
            r13 = r10
            r10 = r29
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            r1 = r36
            r0.configurationLocalRepository = r12
            r0.locationConfigurationRepository = r2
            r0.selectedCountry = r14
            r0.featureFlagRepo = r15
            r0.subscriptionsFeatureFlag = r13
            r2 = r26
            r0.subscriptionStatusRepository = r2
            r2 = r27
            r0.subscriptionTracker = r2
            r0.appLaunchTrackingManager = r11
            r2 = r29
            r0.observabilityManager = r2
            r2 = r33
            r0.customerRepository = r2
            r2 = r34
            r0.navigator = r2
            r2 = r35
            r0.onUpdateRenewalResult = r2
            r0.onTproSavingsClick = r1
            kotlin.LazyThreadSafetyMode r1 = kotlin.LazyThreadSafetyMode.NONE
            com.talabat.home.useraccount.UserAccountRecyclerViewAdapter$sideMenuTProSavingsViewPresenter$2 r2 = new com.talabat.home.useraccount.UserAccountRecyclerViewAdapter$sideMenuTProSavingsViewPresenter$2
            r3 = r30
            r4 = r31
            r5 = r32
            r2.<init>(r5, r3, r4, r0)
            kotlin.Lazy r1 = kotlin.LazyKt__LazyJVMKt.lazy((kotlin.LazyThreadSafetyMode) r1, r2)
            r0.sideMenuTProSavingsViewPresenter$delegate = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.home.useraccount.UserAccountRecyclerViewAdapter.<init>(com.talabat.configuration.ConfigurationLocalRepository, com.talabat.configuration.location.LocationConfigurationRepository, com.talabat.sidemenu.SideMenuRecyclerViewAdapter$SidemenuClicked, java.util.List, boolean, com.talabat.configuration.country.Country, com.talabat.core.featureflag.domain.ITalabatFeatureFlag, com.talabat.feature.subscriptions.domain.ISubscriptionsFeatureFlagsRepository, com.talabat.feature.subscriptions.domain.ISubscriptionStatusRepository, com.talabat.feature.subscriptions.domain.ISubscriptionsTracker, com.talabat.core.observabilityNew.domain.IAppLaunchTrackingManager, com.talabat.core.observabilityNew.domain.IObservabilityManager, com.talabat.feature.subscriptions.domain.usecase.GetSavingsInfoUseCase, com.talabat.feature.subscriptions.domain.usecase.UpdateAutoRenewalUseCase, com.talabat.core.dispatcher.domain.CoroutineDispatchersFactory, com.talabat.customer.domain.CustomerRepository, com.talabat.core.deeplink.domain.DeepLinkNavigator, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function0):void");
    }

    private final RecyclerView.ViewHolder getRewardsViewHolder(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.user_account_rewards, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "view");
        SideMenuRewardViewHolder sideMenuRewardViewHolder = new SideMenuRewardViewHolder(inflate, true);
        if (this.sideMenuRewardViewPresenter == null) {
            Context context = viewGroup.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "parent.context");
            this.sideMenuRewardViewPresenter = new SideMenuRewardViewPresenter(context, this.featureFlagRepo, this.locationConfigurationRepository, this.configurationLocalRepository);
        }
        SideMenuRewardViewPresenter sideMenuRewardViewPresenter2 = this.sideMenuRewardViewPresenter;
        if (sideMenuRewardViewPresenter2 != null) {
            sideMenuRewardViewPresenter2.setView(sideMenuRewardViewHolder);
        }
        return sideMenuRewardViewHolder;
    }

    private final SideMenuTProSavingsViewPresenter getSideMenuTProSavingsViewPresenter() {
        return (SideMenuTProSavingsViewPresenter) this.sideMenuTProSavingsViewPresenter$delegate.getValue();
    }

    private final RecyclerView.ViewHolder getTLifeViewHolder(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.user_account_tlife, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "view");
        SideMenuTLifeViewHolder sideMenuTLifeViewHolder = new SideMenuTLifeViewHolder(inflate);
        if (this.sideMenuTLifePresenter == null) {
            Context context = viewGroup.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "parent.context");
            this.sideMenuTLifePresenter = new SideMenuTLifeViewPresenter(context, this.featureFlagRepo);
        }
        SideMenuTLifeViewPresenter sideMenuTLifeViewPresenter = this.sideMenuTLifePresenter;
        if (sideMenuTLifeViewPresenter != null) {
            sideMenuTLifeViewPresenter.setView(sideMenuTLifeViewHolder, true);
        }
        return sideMenuTLifeViewHolder;
    }

    private final RecyclerView.ViewHolder getTProSavingsViewHolder(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.sidemenu_t_pro_savings, viewGroup, false);
        DeepLinkNavigator deepLinkNavigator = this.navigator;
        ISubscriptionStatusRepository iSubscriptionStatusRepository = this.subscriptionStatusRepository;
        ISubscriptionsFeatureFlagsRepository iSubscriptionsFeatureFlagsRepository = this.subscriptionsFeatureFlag;
        UserAccountRecyclerViewAdapter$getTProSavingsViewHolder$viewHolder$1 userAccountRecyclerViewAdapter$getTProSavingsViewHolder$viewHolder$1 = new UserAccountRecyclerViewAdapter$getTProSavingsViewHolder$viewHolder$1(this);
        ISubscriptionsTracker iSubscriptionsTracker = this.subscriptionTracker;
        Function0<Unit> function0 = this.onTproSavingsClick;
        Intrinsics.checkNotNullExpressionValue(inflate, "view");
        SideMenuTProSavingsViewHolder sideMenuTProSavingsViewHolder = new SideMenuTProSavingsViewHolder(inflate, deepLinkNavigator, iSubscriptionStatusRepository, iSubscriptionsFeatureFlagsRepository, iSubscriptionsTracker, userAccountRecyclerViewAdapter$getTProSavingsViewHolder$viewHolder$1, function0);
        getSideMenuTProSavingsViewPresenter().setView(sideMenuTProSavingsViewHolder);
        getSideMenuTProSavingsViewPresenter().startLoading(this.locationConfigurationRepository);
        return sideMenuTProSavingsViewHolder;
    }

    private final RecyclerView.ViewHolder getTProViewHolder(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.sidemenu_t_pro, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "view");
        SideMenuTProViewHolder sideMenuTProViewHolder = new SideMenuTProViewHolder(inflate);
        if (this.sideMenuTProPresenter == null) {
            Context context = viewGroup.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "parent.context");
            SideMenuTProViewPresenter sideMenuTProViewPresenter = new SideMenuTProViewPresenter(context, Dispatchers.getMain(), this.subscriptionsFeatureFlag, this.customerRepository, this.subscriptionStatusRepository, new UserAccountRecyclerViewAdapter$getTProViewHolder$1(sideMenuTProViewHolder, this));
            this.sideMenuTProPresenter = sideMenuTProViewPresenter;
            sideMenuTProViewPresenter.startLoading();
        }
        SideMenuTProViewPresenter sideMenuTProViewPresenter2 = this.sideMenuTProPresenter;
        if (sideMenuTProViewPresenter2 != null) {
            sideMenuTProViewPresenter2.setView(sideMenuTProViewHolder);
        }
        return sideMenuTProViewHolder;
    }

    /* access modifiers changed from: private */
    public final void updateTProAutoRenewal() {
        getSideMenuTProSavingsViewPresenter().renewSubscription(this.locationConfigurationRepository);
    }

    public void f(@NotNull ImageView imageView, @NotNull TextView textView) {
        Intrinsics.checkNotNullParameter(imageView, "selectedCountryImageView");
        Intrinsics.checkNotNullParameter(textView, "countryTitleTextView");
        switch (WhenMappings.$EnumSwitchMapping$0[this.selectedCountry.ordinal()]) {
            case 1:
                imageView.setImageResource(R.drawable.flag_kwt_country);
                break;
            case 2:
                imageView.setImageResource(R.drawable.flag_ksa_country);
                break;
            case 3:
                imageView.setImageResource(R.drawable.flag_bahrain_country);
                break;
            case 4:
                imageView.setImageResource(R.drawable.flag_oman_country);
                break;
            case 5:
                imageView.setImageResource(R.drawable.flag_qatar_country);
                break;
            case 6:
                imageView.setImageResource(R.drawable.flag_uae_country);
                break;
            case 7:
                imageView.setImageResource(R.drawable.flag_jordan_country);
                break;
            case 8:
                imageView.setImageResource(R.drawable.flag_egypt_country);
                break;
            case 9:
                imageView.setImageResource(R.drawable.flag_iraq_country);
                break;
        }
        textView.setText(GlobalDataModel.SelectedCountryName);
    }

    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder viewHolder, int i11) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        super.onBindViewHolder(viewHolder, i11);
        if (getItemViewType(i11) == 11 && (viewHolder instanceof SideMenuVouchersViewHolder)) {
            Object obj = this.f61367j.get(i11).object;
            if (obj != null) {
                SideMenuHeader sideMenuHeader = (SideMenuHeader) obj;
                ((SideMenuVouchersViewHolder) viewHolder).populate(sideMenuHeader, this.f61368k, new UserAccountRecyclerViewAdapter$onBindViewHolder$1(this, sideMenuHeader));
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type com.talabat.sidemenu.SideMenuHeader");
        }
    }

    @NotNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i11) {
        RecyclerView.ViewHolder sideMenuUserViewHolder;
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        if (i11 == 7) {
            return getTLifeViewHolder(viewGroup);
        }
        if (i11 == SideMenuViewType.REWARD) {
            return getRewardsViewHolder(viewGroup);
        }
        if (i11 == SideMenuViewType.HEADER) {
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.user_account_item, viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "from(parent.context)\n   …ount_item, parent, false)");
            sideMenuUserViewHolder = new SideMenuHeaderViewHolder(inflate);
        } else if (i11 == SideMenuViewType.ITEM) {
            View inflate2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.sidemenu_item, viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate2, "from(parent.context)\n   …menu_item, parent, false)");
            sideMenuUserViewHolder = new SideMenuItemViewHolder(inflate2);
        } else if (i11 == SideMenuViewType.BANNER) {
            View inflate3 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.sidemenu_banner, viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate3, "from(parent.context)\n   …nu_banner, parent, false)");
            sideMenuUserViewHolder = new SideMenuBannerViewHolder(inflate3);
        } else if (i11 == SideMenuViewType.PADDING) {
            View inflate4 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.side_menu_padding_view, viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate4, "from(parent.context)\n   …ding_view, parent, false)");
            sideMenuUserViewHolder = new SideMenuBannerPaddingViewHolder(inflate4);
        } else if (i11 == 8) {
            return getTProViewHolder(viewGroup);
        } else {
            if (i11 == 9) {
                return getTProSavingsViewHolder(viewGroup);
            }
            if (i11 == 10) {
                View inflate5 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.side_menu_bnpl_item_layout, viewGroup, false);
                Intrinsics.checkNotNullExpressionValue(inflate5, "itemView");
                sideMenuUserViewHolder = new SideMenuBnplViewHolder(inflate5);
            } else if (i11 == 11) {
                View inflate6 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.side_menu_vouchers_item_layout, viewGroup, false);
                Intrinsics.checkNotNullExpressionValue(inflate6, "itemView");
                sideMenuUserViewHolder = new SideMenuVouchersViewHolder(inflate6, this.observabilityManager);
            } else {
                View inflate7 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.user_account_header, viewGroup, false);
                Intrinsics.checkNotNullExpressionValue(inflate7, "from(parent.context)\n   …nt_header, parent, false)");
                sideMenuUserViewHolder = new SideMenuUserViewHolder(inflate7);
            }
        }
        return sideMenuUserViewHolder;
    }

    public void onDetachedFromRecyclerView(@NotNull RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.onDetachedFromRecyclerView(recyclerView);
        SideMenuRewardViewPresenter sideMenuRewardViewPresenter2 = this.sideMenuRewardViewPresenter;
        if (sideMenuRewardViewPresenter2 != null) {
            sideMenuRewardViewPresenter2.onDetachedFromRecyclerView();
        }
    }

    public final void refreshSavingsInfo() {
        if (getIndexOf(9) > -1) {
            getSideMenuTProSavingsViewPresenter().refresh(this.locationConfigurationRepository);
            notifyDataSetChanged();
        }
    }
}
