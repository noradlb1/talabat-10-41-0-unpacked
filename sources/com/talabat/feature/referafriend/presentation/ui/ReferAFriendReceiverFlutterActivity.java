package com.talabat.feature.referafriend.presentation.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.lifecycle.ViewModelLazy;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.core.context.domain.ContextCoreLibApi;
import com.talabat.core.dispatcher.domain.DispatcherCoreLibApi;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.tracking.domain.TrackingCoreLibApi;
import com.talabat.core.ui.di.AndroidComponentsKt;
import com.talabat.feature.referafriend.domain.di.ReferAFriendFeatureApi;
import com.talabat.feature.referafriend.presentation.channel.ReferAFriendMethodChannel;
import com.talabat.feature.referafriend.presentation.channel.ReferAFriendMethodChannelCallback;
import com.talabat.feature.referafriend.presentation.di.DaggerReferAFriendFlutterActivityComponent;
import com.talabat.feature.referafriend.presentation.viewmodel.ReferAFriendViewModel;
import com.talabat.feature.referafriend.presentation.viewmodel.ReferAFriendViewModelFactory;
import com.talabat.fluttercore.data.TalabatFlutterEntryPoints;
import com.talabat.fluttercore.presentation.TalabatFlutterFragmentActivity;
import com.talabat.fluttercore.presentation.utils.FlutterRoutes;
import com.talabat.talabatnavigation.Navigator;
import com.talabat.talabatnavigation.base.NavigatorModel;
import com.talabat.talabatremoteconfiguration.RemoteConfiguration;
import com.visa.checkout.PurchaseInfo;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.MethodChannel;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \"2\u00020\u00012\u00020\u0002:\u0001\"B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u0012\u0010\u0016\u001a\u00020\u00152\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0014J\b\u0010\u0019\u001a\u00020\u0015H\u0016J\u0018\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u0015H\u0002J\u0010\u0010\u001f\u001a\u00020\u00152\u0006\u0010 \u001a\u00020!H\u0016R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001b\u0010\n\u001a\u00020\u000b8BX\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\r¨\u0006#"}, d2 = {"Lcom/talabat/feature/referafriend/presentation/ui/ReferAFriendReceiverFlutterActivity;", "Lcom/talabat/fluttercore/presentation/TalabatFlutterFragmentActivity;", "Lcom/talabat/feature/referafriend/presentation/channel/ReferAFriendMethodChannelCallback;", "()V", "factory", "Lcom/talabat/feature/referafriend/presentation/viewmodel/ReferAFriendViewModelFactory;", "getFactory", "()Lcom/talabat/feature/referafriend/presentation/viewmodel/ReferAFriendViewModelFactory;", "setFactory", "(Lcom/talabat/feature/referafriend/presentation/viewmodel/ReferAFriendViewModelFactory;)V", "viewModel", "Lcom/talabat/feature/referafriend/presentation/viewmodel/ReferAFriendViewModel;", "getViewModel", "()Lcom/talabat/feature/referafriend/presentation/viewmodel/ReferAFriendViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "getEntryPoint", "Lcom/talabat/fluttercore/data/TalabatFlutterEntryPoints;", "getRoute", "", "onBackPressedFromFlutter", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "placeOrder", "redeemVoucher", "promoCode", "result", "Lio/flutter/plugin/common/MethodChannel$Result;", "setResultAndFinish", "setUpExtraChannels", "flutterEngine", "Lio/flutter/embedding/engine/FlutterEngine;", "Companion", "com_talabat_feature_refer-a-friend_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ReferAFriendReceiverFlutterActivity extends TalabatFlutterFragmentActivity implements ReferAFriendMethodChannelCallback {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String EXTRA_BACKGROUND_MODE = "background_mode";
    public static final int RAF_REQUEST_CODE = 499;
    @NotNull
    public static final String REDEEMED_SUCCESS_RESULT_KEY = "redeemed_success";
    @NotNull
    private static final String REFER_A_FRIEND_CHANNEL = "com.talabat.flutter/referafriend";
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    @Inject
    public ReferAFriendViewModelFactory factory;
    @NotNull
    private final Lazy viewModel$delegate;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/talabat/feature/referafriend/presentation/ui/ReferAFriendReceiverFlutterActivity$Companion;", "", "()V", "EXTRA_BACKGROUND_MODE", "", "RAF_REQUEST_CODE", "", "REDEEMED_SUCCESS_RESULT_KEY", "REFER_A_FRIEND_CHANNEL", "openActivity", "", "context", "Landroid/app/Activity;", "com_talabat_feature_refer-a-friend_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void openActivity(@Nullable Activity activity) {
            if (activity != null) {
                Intent intent = new Intent(activity, ReferAFriendReceiverFlutterActivity.class);
                intent.putExtra("background_mode", FlutterActivityLaunchConfigs.BackgroundMode.transparent.name());
                activity.startActivityForResult(intent, ReferAFriendReceiverFlutterActivity.RAF_REQUEST_CODE);
            }
        }
    }

    public ReferAFriendReceiverFlutterActivity() {
        super((RemoteConfiguration) null, 1, (DefaultConstructorMarker) null);
        this.viewModel$delegate = new ViewModelLazy(Reflection.getOrCreateKotlinClass(ReferAFriendViewModel.class), new ReferAFriendReceiverFlutterActivity$special$$inlined$viewModels$default$2(this), new ReferAFriendReceiverFlutterActivity$viewModel$2(this), new ReferAFriendReceiverFlutterActivity$special$$inlined$viewModels$default$3((Function0) null, this));
    }

    private final ReferAFriendViewModel getViewModel() {
        return (ReferAFriendViewModel) this.viewModel$delegate.getValue();
    }

    private final void setResultAndFinish() {
        Intent intent = new Intent();
        intent.putExtra(REDEEMED_SUCCESS_RESULT_KEY, getViewModel().getSuccessRedeemPromo().getValue());
        Unit unit = Unit.INSTANCE;
        setResult(-1, intent);
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
    public TalabatFlutterEntryPoints getEntryPoint() {
        return TalabatFlutterEntryPoints.REFER_A_FRIEND_BOTTOM_SHEET;
    }

    @NotNull
    public final ReferAFriendViewModelFactory getFactory() {
        ReferAFriendViewModelFactory referAFriendViewModelFactory = this.factory;
        if (referAFriendViewModelFactory != null) {
            return referAFriendViewModelFactory;
        }
        Intrinsics.throwUninitializedPropertyAccessException("factory");
        return null;
    }

    @NotNull
    public String getRoute() {
        return FlutterRoutes.REFER_A_FRIEND_BOTTOMSHEET;
    }

    public void onBackPressedFromFlutter() {
        setResultAndFinish();
    }

    public void onCreate(@Nullable Bundle bundle) {
        DaggerReferAFriendFlutterActivityComponent.factory().create((ContextCoreLibApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(ContextCoreLibApi.class), (FeatureFlagCoreLibApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(FeatureFlagCoreLibApi.class), (TrackingCoreLibApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(TrackingCoreLibApi.class), (ConfigurationLocalCoreLibApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(ConfigurationLocalCoreLibApi.class), (DispatcherCoreLibApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(DispatcherCoreLibApi.class), (ReferAFriendFeatureApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(ReferAFriendFeatureApi.class)).inject(this);
        super.onCreate(bundle);
    }

    public void placeOrder() {
        Navigator.Companion.navigate((Context) this, new NavigatorModel("talabat.action.homeScreen", (Bundle) null, (Function1) null, 6, (DefaultConstructorMarker) null));
        setResultAndFinish();
        getViewModel().trackObservability("Place Order");
    }

    public void redeemVoucher(@NotNull String str, @NotNull MethodChannel.Result result) {
        Intrinsics.checkNotNullParameter(str, PurchaseInfo.PROMO_CODE);
        Intrinsics.checkNotNullParameter(result, "result");
        getViewModel().redeemPromoCode(str, result);
    }

    public final void setFactory(@NotNull ReferAFriendViewModelFactory referAFriendViewModelFactory) {
        Intrinsics.checkNotNullParameter(referAFriendViewModelFactory, "<set-?>");
        this.factory = referAFriendViewModelFactory;
    }

    public void setUpExtraChannels(@NotNull FlutterEngine flutterEngine) {
        Intrinsics.checkNotNullParameter(flutterEngine, "flutterEngine");
        new MethodChannel(flutterEngine.getDartExecutor(), REFER_A_FRIEND_CHANNEL).setMethodCallHandler(new ReferAFriendMethodChannel(this));
    }
}
