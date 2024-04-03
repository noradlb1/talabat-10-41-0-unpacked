package com.talabat.growth.ui.vouchers.list;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.background.ApplicationStateMonitor;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.talabat.core.deeplink.domain.DeepLinkCoreLibApi;
import com.talabat.core.deeplink.domain.DeepLinkNavigator;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.fwfprojectskeys.domain.projects.home.HomePageFeatureFlagsKeys;
import com.talabat.core.navigation.domain.NavigationCoreLibApi;
import com.talabat.core.navigation.domain.Navigator;
import com.talabat.core.navigation.domain.screen.voucherlist.VoucherListNativeScreen;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.core.observabilityNew.domain.ObservabilityCoreLibApi;
import com.talabat.core.ui.di.AndroidComponentsKt;
import com.talabat.growth.ui.vouchers.list.di.DaggerVouchersListBridgeActivityComponent;
import com.talabat.talabatnavigation.growthSquad.VouchersNavigationActions;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Instrumented
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0002J\b\u0010\u001d\u001a\u00020\u001eH\u0002J\b\u0010\u001f\u001a\u00020 H\u0002J\b\u0010!\u001a\u00020\u001eH\u0002J\b\u0010\"\u001a\u00020\u001eH\u0002J\u0012\u0010#\u001a\u00020\u001e2\b\u0010$\u001a\u0004\u0018\u00010%H\u0014R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0015\u001a\u00020\u00168\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006&"}, d2 = {"Lcom/talabat/growth/ui/vouchers/list/VouchersListBridgeActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "deepLinkNavigator", "Lcom/talabat/core/deeplink/domain/DeepLinkNavigator;", "getDeepLinkNavigator", "()Lcom/talabat/core/deeplink/domain/DeepLinkNavigator;", "setDeepLinkNavigator", "(Lcom/talabat/core/deeplink/domain/DeepLinkNavigator;)V", "navigator", "Lcom/talabat/core/navigation/domain/Navigator;", "getNavigator", "()Lcom/talabat/core/navigation/domain/Navigator;", "setNavigator", "(Lcom/talabat/core/navigation/domain/Navigator;)V", "observabilityManager", "Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;", "getObservabilityManager", "()Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;", "setObservabilityManager", "(Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;)V", "talabatFeatureFlag", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "getTalabatFeatureFlag", "()Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "setTalabatFeatureFlag", "(Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;)V", "getQueryParametersString", "", "injectDagger", "", "isFlutterVouchersListEnabled", "", "navigateToFlutterVouchersList", "navigateToNativeVouchersList", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "com_talabat_NewArchi_GrowthSquad_GrowthSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VouchersListBridgeActivity extends AppCompatActivity implements TraceFieldInterface {
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    public Trace _nr_trace;
    @Inject
    public DeepLinkNavigator deepLinkNavigator;
    @Inject
    public Navigator navigator;
    @Inject
    public IObservabilityManager observabilityManager;
    @Inject
    public ITalabatFeatureFlag talabatFeatureFlag;

    private final String getQueryParametersString() {
        String str;
        String str2;
        boolean z11;
        Bundle extras = getIntent().getExtras();
        String str3 = null;
        if (extras != null) {
            str = extras.getString("VOUCHER_DEEPLINK_CODE");
        } else {
            str = null;
        }
        Bundle extras2 = getIntent().getExtras();
        if (extras2 != null) {
            str2 = extras2.getString("VOUCHER_DEEPLINK_MEDIA_SRC");
        } else {
            str2 = null;
        }
        Bundle extras3 = getIntent().getExtras();
        if (extras3 != null) {
            str3 = extras3.getString("VOUCHER_DEEPLINK_BRAND_ID");
        }
        Bundle extras4 = getIntent().getExtras();
        boolean z12 = false;
        if (extras4 != null) {
            z11 = extras4.getBoolean(VouchersNavigationActions.IS_OPEN_BOTTOM_SHEET);
        } else {
            z11 = false;
        }
        Bundle extras5 = getIntent().getExtras();
        if (extras5 != null) {
            z12 = extras5.getBoolean(VouchersNavigationActions.VOUCHER_DISABLE_OPENING_HOME_FOR_BACK_BUTTON);
        }
        StringBuilder sb2 = new StringBuilder();
        if (str != null) {
            sb2.append("&campaign=" + str);
        }
        if (str2 != null) {
            sb2.append("&src=" + str2);
        }
        if (str3 != null) {
            sb2.append("&brandId=" + str3);
        }
        sb2.append("&open_bottomsheet=" + z11);
        sb2.append("&open_home=" + (z12 ^ true));
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "queryParamBuilder.toString()");
        return sb3;
    }

    private final void injectDagger() {
        DaggerVouchersListBridgeActivityComponent.factory().create((FeatureFlagCoreLibApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(FeatureFlagCoreLibApi.class), (NavigationCoreLibApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(NavigationCoreLibApi.class), (DeepLinkCoreLibApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(DeepLinkCoreLibApi.class), (ObservabilityCoreLibApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(ObservabilityCoreLibApi.class)).inject(this);
    }

    private final boolean isFlutterVouchersListEnabled() {
        return ITalabatFeatureFlag.DefaultImpls.getFeatureFlag$default(getTalabatFeatureFlag(), HomePageFeatureFlagsKeys.VOUCHER_LIST_FLUTTER, false, 2, (Object) null);
    }

    private final void navigateToFlutterVouchersList() {
        String queryParametersString = getQueryParametersString();
        Job unused = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), (CoroutineContext) null, (CoroutineStart) null, new VouchersListBridgeActivity$navigateToFlutterVouchersList$1(this, "talabat://?s=vouchers-list" + queryParametersString, (Continuation<? super VouchersListBridgeActivity$navigateToFlutterVouchersList$1>) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public final void navigateToNativeVouchersList() {
        getNavigator().navigateTo(this, new VoucherListNativeScreen((Void) null, 1, (DefaultConstructorMarker) null), new VouchersListBridgeActivity$navigateToNativeVouchersList$1(this));
        finish();
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
    public final DeepLinkNavigator getDeepLinkNavigator() {
        DeepLinkNavigator deepLinkNavigator2 = this.deepLinkNavigator;
        if (deepLinkNavigator2 != null) {
            return deepLinkNavigator2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("deepLinkNavigator");
        return null;
    }

    @NotNull
    public final Navigator getNavigator() {
        Navigator navigator2 = this.navigator;
        if (navigator2 != null) {
            return navigator2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("navigator");
        return null;
    }

    @NotNull
    public final IObservabilityManager getObservabilityManager() {
        IObservabilityManager iObservabilityManager = this.observabilityManager;
        if (iObservabilityManager != null) {
            return iObservabilityManager;
        }
        Intrinsics.throwUninitializedPropertyAccessException("observabilityManager");
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

    public void onCreate(@Nullable Bundle bundle) {
        TraceMachine.startTracing("VouchersListBridgeActivity");
        try {
            TraceMachine.enterMethod(this._nr_trace, "VouchersListBridgeActivity#onCreate", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "VouchersListBridgeActivity#onCreate", (ArrayList<String>) null);
        }
        super.onCreate(bundle);
        injectDagger();
        if (isFlutterVouchersListEnabled()) {
            navigateToFlutterVouchersList();
        } else {
            navigateToNativeVouchersList();
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

    public final void setDeepLinkNavigator(@NotNull DeepLinkNavigator deepLinkNavigator2) {
        Intrinsics.checkNotNullParameter(deepLinkNavigator2, "<set-?>");
        this.deepLinkNavigator = deepLinkNavigator2;
    }

    public final void setNavigator(@NotNull Navigator navigator2) {
        Intrinsics.checkNotNullParameter(navigator2, "<set-?>");
        this.navigator = navigator2;
    }

    public final void setObservabilityManager(@NotNull IObservabilityManager iObservabilityManager) {
        Intrinsics.checkNotNullParameter(iObservabilityManager, "<set-?>");
        this.observabilityManager = iObservabilityManager;
    }

    public final void setTalabatFeatureFlag(@NotNull ITalabatFeatureFlag iTalabatFeatureFlag) {
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "<set-?>");
        this.talabatFeatureFlag = iTalabatFeatureFlag;
    }
}
