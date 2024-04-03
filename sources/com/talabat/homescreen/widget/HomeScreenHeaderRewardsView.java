package com.talabat.homescreen.widget;

import android.content.Context;
import android.content.ContextWrapper;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelLazy;
import buisnessmodels.Customer;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.core.dispatcher.domain.CoroutineDispatchersFactory;
import com.talabat.core.dispatcher.domain.DispatcherCoreLibApi;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.navigation.domain.screen.rewards.LoyaltyDashboardScreen;
import com.talabat.core.tracking.domain.TalabatTracker;
import com.talabat.core.ui.di.AndroidComponentsKt;
import com.talabat.fluid.homescreen.data.impl.HomeScreenTrackerImpl;
import com.talabat.fluid.homescreen.domain.tracking.LocationDataFactory;
import com.talabat.fluid.homescreen.domain.usecase.business.impl.TrackRewordsClickedUseCaseImpl;
import com.talabat.growth.ui.loyalty.HomeScreenHeaderRewardsViewModel;
import com.talabat.homescreen.R;
import com.talabat.homescreen.widget.di.DaggerHomeScreenHeaderRewardsComponent;
import com.talabat.talabatcore.extensions.LifecycleKt;
import com.talabat.talabatnavigation.growthSquad.GrowthNavigatorActions;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import js.a;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tracking.gtm.TalabatFirebase;

@Metadata(d1 = {"\u0000g\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0016\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010&\u001a\u00020'H\u0002J\u0017\u0010(\u001a\u00020'2\b\u0010)\u001a\u0004\u0018\u00010*H\u0002¢\u0006\u0002\u0010+J\b\u0010,\u001a\u00020'H\u0014J\u0017\u0010-\u001a\u00020'2\b\u0010.\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0002\u0010/J\u0012\u00100\u001a\u00020'2\b\u00101\u001a\u0004\u0018\u000102H\u0002J\f\u00103\u001a\u000204*\u00020\u0003H\u0002R\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0010\u0010\u0015\u001a\u00020\u0016X\u0004¢\u0006\u0004\n\u0002\u0010\u0017R\u001e\u0010\u0018\u001a\u00020\u00198\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u000e\u0010\u001e\u001a\u00020\u001fX\u0004¢\u0006\u0002\n\u0000R\u001b\u0010 \u001a\u00020!8BX\u0002¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b\"\u0010#¨\u00065"}, d2 = {"Lcom/talabat/homescreen/widget/HomeScreenHeaderRewardsView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "configurationLocalRepository", "Lcom/talabat/configuration/ConfigurationLocalRepository;", "getConfigurationLocalRepository", "()Lcom/talabat/configuration/ConfigurationLocalRepository;", "setConfigurationLocalRepository", "(Lcom/talabat/configuration/ConfigurationLocalRepository;)V", "coroutineDispatchersFactory", "Lcom/talabat/core/dispatcher/domain/CoroutineDispatchersFactory;", "getCoroutineDispatchersFactory", "()Lcom/talabat/core/dispatcher/domain/CoroutineDispatchersFactory;", "setCoroutineDispatchersFactory", "(Lcom/talabat/core/dispatcher/domain/CoroutineDispatchersFactory;)V", "coroutineScope", "com/talabat/homescreen/widget/HomeScreenHeaderRewardsView$coroutineScope$1", "Lcom/talabat/homescreen/widget/HomeScreenHeaderRewardsView$coroutineScope$1;", "featureFlagRepo", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "getFeatureFlagRepo", "()Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "setFeatureFlagRepo", "(Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;)V", "trackRewordsClickedUseCaseImpl", "Lcom/talabat/fluid/homescreen/domain/usecase/business/impl/TrackRewordsClickedUseCaseImpl;", "viewModel", "Lcom/talabat/growth/ui/loyalty/HomeScreenHeaderRewardsViewModel;", "getViewModel", "()Lcom/talabat/growth/ui/loyalty/HomeScreenHeaderRewardsViewModel;", "viewModel$delegate", "Landroidx/lifecycle/ViewModelLazy;", "bindWithViewModel", "", "handleUserEligible", "showRewardsBanner", "", "(Ljava/lang/Boolean;)V", "onAttachedToWindow", "showPoints", "points", "(Ljava/lang/Integer;)V", "showRewardsText", "text", "", "getLifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "com_talabat_NewArchi_Homescreen_Homescreen"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class HomeScreenHeaderRewardsView extends RelativeLayout {
    @NotNull
    public Map<Integer, View> _$_findViewCache;
    @Inject
    public ConfigurationLocalRepository configurationLocalRepository;
    @Inject
    public CoroutineDispatchersFactory coroutineDispatchersFactory;
    /* access modifiers changed from: private */
    @NotNull
    public final HomeScreenHeaderRewardsView$coroutineScope$1 coroutineScope;
    @Inject
    public ITalabatFeatureFlag featureFlagRepo;
    @NotNull
    private final TrackRewordsClickedUseCaseImpl trackRewordsClickedUseCaseImpl;
    @NotNull
    private final ViewModelLazy viewModel$delegate;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public HomeScreenHeaderRewardsView(@NotNull Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public HomeScreenHeaderRewardsView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public HomeScreenHeaderRewardsView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.checkNotNullParameter(context, "context");
        this._$_findViewCache = new LinkedHashMap();
        this.trackRewordsClickedUseCaseImpl = new TrackRewordsClickedUseCaseImpl(new HomeScreenTrackerImpl(context, new TalabatFirebase(), (TalabatTracker) null, 4, (DefaultConstructorMarker) null), HomeScreenHeaderRewardsView$trackRewordsClickedUseCaseImpl$1.INSTANCE, new LocationDataFactory((Function0) null, (Function0) null, (Function0) null, (Function0) null, 15, (DefaultConstructorMarker) null));
        this.coroutineScope = new HomeScreenHeaderRewardsView$coroutineScope$1(this);
        HomeScreenHeaderRewardsView$viewModel$2 homeScreenHeaderRewardsView$viewModel$2 = new HomeScreenHeaderRewardsView$viewModel$2(context, this);
        this.viewModel$delegate = new ViewModelLazy(Reflection.getOrCreateKotlinClass(HomeScreenHeaderRewardsViewModel.class), new HomeScreenHeaderRewardsView$special$$inlined$viewModels$1(this), homeScreenHeaderRewardsView$viewModel$2);
        DaggerHomeScreenHeaderRewardsComponent.factory().create((ConfigurationLocalCoreLibApi) AndroidComponentsKt.apiContainer((View) this).getFeature(ConfigurationLocalCoreLibApi.class), (FeatureFlagCoreLibApi) AndroidComponentsKt.apiContainer((View) this).getFeature(FeatureFlagCoreLibApi.class), (DispatcherCoreLibApi) AndroidComponentsKt.apiContainer((View) this).getFeature(DispatcherCoreLibApi.class)).inject(this);
        View.inflate(context, R.layout.home_header_rewards, this);
    }

    private final void bindWithViewModel() {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        LifecycleKt.observe(getLifecycleOwner(context), getViewModel().getShowRewardsBanner(), new HomeScreenHeaderRewardsView$bindWithViewModel$1(this));
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        LifecycleKt.observe(getLifecycleOwner(context2), getViewModel().getShowRewardsBannerPoints(), new HomeScreenHeaderRewardsView$bindWithViewModel$2(this));
        Context context3 = getContext();
        Intrinsics.checkNotNullExpressionValue(context3, "context");
        LifecycleKt.observe(getLifecycleOwner(context3), getViewModel().getShowRewardsBannerText(), new HomeScreenHeaderRewardsView$bindWithViewModel$3(this));
        if (Customer.getInstance().isLoggedIn(getContext())) {
            getViewModel().isRewardsPointsBannerVisible();
            getViewModel().checkUserIsEnabled();
        }
        ((RelativeLayout) _$_findCachedViewById(R.id.rewards_container)).setOnClickListener(new a(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: bindWithViewModel$lambda-0  reason: not valid java name */
    public static final void m10656bindWithViewModel$lambda0(HomeScreenHeaderRewardsView homeScreenHeaderRewardsView, View view) {
        Intrinsics.checkNotNullParameter(homeScreenHeaderRewardsView, "this$0");
        homeScreenHeaderRewardsView.trackRewordsClickedUseCaseImpl.trackRewordsClicked();
        LoyaltyDashboardScreen.RewardsCatalogueOrigin rewardsCatalogueOrigin = LoyaltyDashboardScreen.RewardsCatalogueOrigin.HOME;
        GrowthNavigatorActions.Companion companion = GrowthNavigatorActions.Companion;
        Context context = homeScreenHeaderRewardsView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        GrowthNavigatorActions.Companion.startLoyaltyDashboardActivity$default(companion, context, rewardsCatalogueOrigin, (Function1) null, 4, (Object) null);
    }

    private final LifecycleOwner getLifecycleOwner(Context context) {
        try {
            return (LifecycleOwner) context;
        } catch (ClassCastException unused) {
            Context baseContext = ((ContextWrapper) context).getBaseContext();
            if (baseContext != null) {
                return (LifecycleOwner) baseContext;
            }
            throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
        }
    }

    private final HomeScreenHeaderRewardsViewModel getViewModel() {
        return (HomeScreenHeaderRewardsViewModel) this.viewModel$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final void handleUserEligible(Boolean bool) {
        int i11;
        RelativeLayout relativeLayout = (RelativeLayout) _$_findCachedViewById(R.id.rewards_container);
        Intrinsics.checkNotNullExpressionValue(relativeLayout, "rewards_container");
        if (Intrinsics.areEqual((Object) bool, (Object) Boolean.TRUE)) {
            i11 = 0;
        } else {
            i11 = 8;
        }
        relativeLayout.setVisibility(i11);
    }

    /* access modifiers changed from: private */
    public final void showPoints(Integer num) {
        String num2;
        if (num != null && (num2 = num.toString()) != null) {
            ((AppCompatTextView) _$_findCachedViewById(R.id.reward_header_title)).setText(getContext().getString(com.talabat.localization.R.string.reward_points_suffix, new Object[]{num2}));
        }
    }

    /* access modifiers changed from: private */
    public final void showRewardsText(String str) {
        AppCompatTextView appCompatTextView = (AppCompatTextView) _$_findCachedViewById(R.id.reward_header_title);
        if (str == null) {
            str = "";
        }
        appCompatTextView.setText(str);
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Nullable
    public View _$_findCachedViewById(int i11) {
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i11));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i11);
        if (findViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i11), findViewById);
        return findViewById;
    }

    @NotNull
    public final ConfigurationLocalRepository getConfigurationLocalRepository() {
        ConfigurationLocalRepository configurationLocalRepository2 = this.configurationLocalRepository;
        if (configurationLocalRepository2 != null) {
            return configurationLocalRepository2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("configurationLocalRepository");
        return null;
    }

    @NotNull
    public final CoroutineDispatchersFactory getCoroutineDispatchersFactory() {
        CoroutineDispatchersFactory coroutineDispatchersFactory2 = this.coroutineDispatchersFactory;
        if (coroutineDispatchersFactory2 != null) {
            return coroutineDispatchersFactory2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("coroutineDispatchersFactory");
        return null;
    }

    @NotNull
    public final ITalabatFeatureFlag getFeatureFlagRepo() {
        ITalabatFeatureFlag iTalabatFeatureFlag = this.featureFlagRepo;
        if (iTalabatFeatureFlag != null) {
            return iTalabatFeatureFlag;
        }
        Intrinsics.throwUninitializedPropertyAccessException("featureFlagRepo");
        return null;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        bindWithViewModel();
    }

    public final void setConfigurationLocalRepository(@NotNull ConfigurationLocalRepository configurationLocalRepository2) {
        Intrinsics.checkNotNullParameter(configurationLocalRepository2, "<set-?>");
        this.configurationLocalRepository = configurationLocalRepository2;
    }

    public final void setCoroutineDispatchersFactory(@NotNull CoroutineDispatchersFactory coroutineDispatchersFactory2) {
        Intrinsics.checkNotNullParameter(coroutineDispatchersFactory2, "<set-?>");
        this.coroutineDispatchersFactory = coroutineDispatchersFactory2;
    }

    public final void setFeatureFlagRepo(@NotNull ITalabatFeatureFlag iTalabatFeatureFlag) {
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "<set-?>");
        this.featureFlagRepo = iTalabatFeatureFlag;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ HomeScreenHeaderRewardsView(Context context, AttributeSet attributeSet, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }
}
