package com.talabat.growth.ui.loyalty.dashboard;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.integration.IntegrationGlobalDataModel;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.background.ApplicationStateMonitor;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.talabat.core.deeplink.domain.DeepLinkCoreLibApi;
import com.talabat.core.deeplink.domain.DeepLinkNavigator;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.fwfprojectskeys.domain.projects.ecosystems.EcosystemsFeatureFlagsKeys;
import com.talabat.core.ui.di.AndroidComponentsKt;
import com.talabat.growth.ui.loyalty.dashboard.di.DaggerLoyaltyDashboardActivityComponent;
import com.talabat.growth.ui.loyalty.guestUser.LoyaltyGuestUserFragment;
import com.talabat.screenrecorder.ScreenRecorder;
import com.talabat.talabatcore.databinding.ActivityLayoutBinding;
import com.talabat.talabatnavigation.Navigator;
import com.talabat.talabatnavigation.base.NavigatorModel;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Instrumented
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 !2\u00020\u0001:\u0001!B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0002J\b\u0010\u0019\u001a\u00020\u001aH\u0002J\b\u0010\u001b\u001a\u00020\u001aH\u0002J\b\u0010\u001c\u001a\u00020\u001dH\u0002J\b\u0010\u001e\u001a\u00020\u001aH\u0002J\b\u0010\u001f\u001a\u00020\u001aH\u0016J\u0012\u0010 \u001a\u00020\u001a2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u000b\u001a\u00020\f8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\""}, d2 = {"Lcom/talabat/growth/ui/loyalty/dashboard/LoyaltyDashboardActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "binding", "Lcom/talabat/talabatcore/databinding/ActivityLayoutBinding;", "deeplinkNavigator", "Lcom/talabat/core/deeplink/domain/DeepLinkNavigator;", "getDeeplinkNavigator", "()Lcom/talabat/core/deeplink/domain/DeepLinkNavigator;", "setDeeplinkNavigator", "(Lcom/talabat/core/deeplink/domain/DeepLinkNavigator;)V", "talabatFeatureFlag", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "getTalabatFeatureFlag", "()Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "setTalabatFeatureFlag", "(Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;)V", "addFragment", "", "savedInstanceState", "Landroid/os/Bundle;", "getFragment", "Landroidx/fragment/app/Fragment;", "getOrigin", "", "inflate", "", "injectDagger", "isFlutterDashboardEnabled", "", "navigateToFlutterRewardsDashboard", "onBackPressed", "onCreate", "Companion", "com_talabat_NewArchi_GrowthSquad_GrowthSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LoyaltyDashboardActivity extends AppCompatActivity implements TraceFieldInterface {
    @NotNull
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @NotNull
    @Deprecated
    public static final Function1<String, String> FLUTTER_REWARDS_DASHBOARD_DEEPLINK = LoyaltyDashboardActivity$Companion$FLUTTER_REWARDS_DASHBOARD_DEEPLINK$1.INSTANCE;
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    public Trace _nr_trace;
    private ActivityLayoutBinding binding;
    @Inject
    public DeepLinkNavigator deeplinkNavigator;
    @Inject
    public ITalabatFeatureFlag talabatFeatureFlag;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R,\u0010\u0003\u001a\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/talabat/growth/ui/loyalty/dashboard/LoyaltyDashboardActivity$Companion;", "", "()V", "FLUTTER_REWARDS_DASHBOARD_DEEPLINK", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "eventOrigin", "getFLUTTER_REWARDS_DASHBOARD_DEEPLINK", "()Lkotlin/jvm/functions/Function1;", "com_talabat_NewArchi_GrowthSquad_GrowthSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final Function1<String, String> getFLUTTER_REWARDS_DASHBOARD_DEEPLINK() {
            return LoyaltyDashboardActivity.FLUTTER_REWARDS_DASHBOARD_DEEPLINK;
        }
    }

    private final Object addFragment(Bundle bundle) {
        if (bundle != null) {
            return bundle;
        }
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
        Intrinsics.checkNotNullExpressionValue(beginTransaction, "beginTransaction()");
        beginTransaction.setReorderingAllowed(true);
        Fragment fragment = getFragment();
        fragment.setArguments(getIntent().getExtras());
        ActivityLayoutBinding activityLayoutBinding = this.binding;
        if (activityLayoutBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityLayoutBinding = null;
        }
        beginTransaction.add(activityLayoutBinding.fragmentContainer.getId(), fragment);
        beginTransaction.commit();
        return Unit.INSTANCE;
    }

    private final Fragment getFragment() {
        if (IntegrationGlobalDataModel.Companion.isLoggedIn()) {
            return new LoyaltyDashboardFragment();
        }
        return new LoyaltyGuestUserFragment();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v9, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: com.talabat.core.navigation.domain.screen.rewards.LoyaltyDashboardScreen$LoyaltyDashboardData} */
    /* JADX WARNING: type inference failed for: r0v6, types: [android.os.Parcelable] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.String getOrigin() {
        /*
            r4 = this;
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 33
            java.lang.String r2 = "navigatorData"
            r3 = 0
            if (r0 < r1) goto L_0x001f
            android.content.Intent r0 = r4.getIntent()
            if (r0 == 0) goto L_0x0032
            android.os.Bundle r0 = r0.getExtras()
            if (r0 == 0) goto L_0x0032
            java.lang.Class<com.talabat.core.navigation.domain.screen.rewards.LoyaltyDashboardScreen$LoyaltyDashboardData> r1 = com.talabat.core.navigation.domain.screen.rewards.LoyaltyDashboardScreen.LoyaltyDashboardData.class
            java.lang.Object r0 = r0.getParcelable(r2, r1)
            r3 = r0
            com.talabat.core.navigation.domain.screen.rewards.LoyaltyDashboardScreen$LoyaltyDashboardData r3 = (com.talabat.core.navigation.domain.screen.rewards.LoyaltyDashboardScreen.LoyaltyDashboardData) r3
            goto L_0x0032
        L_0x001f:
            android.content.Intent r0 = r4.getIntent()
            if (r0 == 0) goto L_0x0032
            android.os.Bundle r0 = r0.getExtras()
            if (r0 == 0) goto L_0x0032
            android.os.Parcelable r0 = r0.getParcelable(r2)
            r3 = r0
            com.talabat.core.navigation.domain.screen.rewards.LoyaltyDashboardScreen$LoyaltyDashboardData r3 = (com.talabat.core.navigation.domain.screen.rewards.LoyaltyDashboardScreen.LoyaltyDashboardData) r3
        L_0x0032:
            if (r3 == 0) goto L_0x003a
            java.lang.String r0 = r3.getRewardsCatalogueOrigin()
            if (r0 != 0) goto L_0x0040
        L_0x003a:
            com.talabat.core.navigation.domain.screen.rewards.LoyaltyDashboardScreen$RewardsCatalogueOrigin r0 = com.talabat.core.navigation.domain.screen.rewards.LoyaltyDashboardScreen.RewardsCatalogueOrigin.CRM
            java.lang.String r0 = r0.getEventOrigin()
        L_0x0040:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.growth.ui.loyalty.dashboard.LoyaltyDashboardActivity.getOrigin():java.lang.String");
    }

    private final void inflate() {
        ActivityLayoutBinding inflate = ActivityLayoutBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(layoutInflater)");
        this.binding = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inflate = null;
        }
        setContentView((View) inflate.getRoot());
    }

    private final void injectDagger() {
        DaggerLoyaltyDashboardActivityComponent.factory().create((FeatureFlagCoreLibApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(FeatureFlagCoreLibApi.class), (DeepLinkCoreLibApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(DeepLinkCoreLibApi.class)).inject(this);
    }

    private final boolean isFlutterDashboardEnabled() {
        return ITalabatFeatureFlag.DefaultImpls.getFeatureFlag$default(getTalabatFeatureFlag(), EcosystemsFeatureFlagsKeys.IS_FLUTTER_REWARDS_DASHBOARD_ENABLED, false, 2, (Object) null);
    }

    private final void navigateToFlutterRewardsDashboard() {
        String origin = getOrigin();
        DeepLinkNavigator.DefaultImpls.navigateTo$default(getDeeplinkNavigator(), this, FLUTTER_REWARDS_DASHBOARD_DEEPLINK.invoke(origin), (Function0) null, 4, (Object) null);
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
    public final DeepLinkNavigator getDeeplinkNavigator() {
        DeepLinkNavigator deepLinkNavigator = this.deeplinkNavigator;
        if (deepLinkNavigator != null) {
            return deepLinkNavigator;
        }
        Intrinsics.throwUninitializedPropertyAccessException("deeplinkNavigator");
        return null;
    }

    @NotNull
    public final ITalabatFeatureFlag getTalabatFeatureFlag() {
        ITalabatFeatureFlag iTalabatFeatureFlag = this.talabatFeatureFlag;
        if (iTalabatFeatureFlag != null) {
            return iTalabatFeatureFlag;
        }
        Intrinsics.throwUninitializedPropertyAccessException("talabatFeatureFlag");
        return null;
    }

    public void onBackPressed() {
        if (isTaskRoot()) {
            Navigator.Companion.navigate((Context) this, new NavigatorModel("talabat.action.homeScreen", (Bundle) null, (Function1) null, 6, (DefaultConstructorMarker) null));
            return;
        }
        super.onBackPressed();
    }

    public void onCreate(@Nullable Bundle bundle) {
        TraceMachine.startTracing("LoyaltyDashboardActivity");
        try {
            TraceMachine.enterMethod(this._nr_trace, "LoyaltyDashboardActivity#onCreate", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "LoyaltyDashboardActivity#onCreate", (ArrayList<String>) null);
        }
        injectDagger();
        super.onCreate(bundle);
        if (isFlutterDashboardEnabled()) {
            navigateToFlutterRewardsDashboard();
            finish();
        } else {
            ScreenRecorder.INSTANCE.startScreenRecording(this);
            inflate();
            addFragment(bundle);
        }
        TraceMachine.exitMethod();
    }

    public void onStart() {
        super.onStart();
        ApplicationStateMonitor.getInstance().activityStarted();
    }

    public void onStop() {
        super.onStop();
        ApplicationStateMonitor.getInstance().activityStopped();
    }

    public final void setDeeplinkNavigator(@NotNull DeepLinkNavigator deepLinkNavigator) {
        Intrinsics.checkNotNullParameter(deepLinkNavigator, "<set-?>");
        this.deeplinkNavigator = deepLinkNavigator;
    }

    public final void setTalabatFeatureFlag(@NotNull ITalabatFeatureFlag iTalabatFeatureFlag) {
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "<set-?>");
        this.talabatFeatureFlag = iTalabatFeatureFlag;
    }
}
