package com.talabat.talabatlife.ui.onBoarding;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentManager;
import com.integration.tLife.IntegrationAppTrackerTLifeSubscriptions;
import com.talabat.core.flutter.channels.domain.MethodChannels;
import com.talabat.fluttercore.presentation.TalabatFlutterFragmentActivity;
import com.talabat.talabatcommon.model.wallet.WalletCardDisplayModel;
import com.talabat.talabatcommon.views.wallet.subscription.model.PaymentInfoDisplayModel;
import com.talabat.talabatcommon.views.wallet.walletPaymentOption.model.BottomSheetPaymentStatusModel;
import com.talabat.talabatcommon.views.wallet.walletPaymentOption.model.PaymentMethod;
import com.talabat.talabatcommon.views.wallet.walletPaymentOption.model.WalletPaymentStatus;
import com.talabat.talabatcommon.views.wallet.walletPaymentOption.view.PaymentBottomSheetInterface;
import com.talabat.talabatcommon.views.wallet.walletPaymentOption.view.PaymentWidgetBottomSheet;
import com.talabat.talabatcore.exception.Failure;
import com.talabat.talabatcore.logger.LogManager;
import com.talabat.talabatlife.flutter.FlutterConstants;
import com.talabat.talabatlife.ui.onBoarding.model.TLifeOnBoardingPlanDisplayModel;
import com.talabat.talabatlife.ui.onBoarding.viewModel.TLifeOnBoardingViewModel;
import com.talabat.talabatlife.ui.onBoarding.viewModel.TLifeOnBoardingViewModelBuilder;
import com.talabat.talabatlife.ui.subscription.model.SubscriptionPaymentDisplayModel;
import com.talabat.talabatnavigation.Navigator;
import com.talabat.talabatnavigation.base.NavigatorModel;
import com.talabat.talabatnavigation.tLife.TLifeNavigationActions;
import com.talabat.talabatremoteconfiguration.RemoteConfiguration;
import gw.a;
import gw.b;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.MethodChannel;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0010H\u0002J\u0010\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\b\u0010\u0017\u001a\u00020\u0016H\u0016J\b\u0010\u0018\u001a\u00020\u0010H\u0002J\b\u0010\u0019\u001a\u00020\u0010H\u0002J\u0012\u0010\u001a\u001a\u00020\u00102\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0014J\u0010\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0016J\u0018\u0010#\u001a\u00020\u00102\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0016H\u0016J\u0010\u0010'\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010(\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0010\u0010)\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0016H\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/talabat/talabatlife/ui/onBoarding/TDineOnboardingFlutterActivity;", "Lcom/talabat/fluttercore/presentation/TalabatFlutterFragmentActivity;", "Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/view/PaymentBottomSheetInterface;", "Lcom/talabat/talabatlife/ui/onBoarding/IPaymentMethodChannel;", "()V", "bottomSheet", "Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/view/PaymentWidgetBottomSheet;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "getCoroutineScope", "()Lkotlinx/coroutines/CoroutineScope;", "paymentInfoDisplayModel", "Lcom/talabat/talabatcommon/views/wallet/subscription/model/PaymentInfoDisplayModel;", "viewModel", "Lcom/talabat/talabatlife/ui/onBoarding/viewModel/TLifeOnBoardingViewModel;", "configureFlutterEngine", "", "flutterEngine", "Lio/flutter/embedding/engine/FlutterEngine;", "fireTackingEventSubscriptionCompleted", "fireTackingEventSubscriptionFailed", "error", "", "getRoute", "navigateToRestaurantList", "navigateToSuccessScreen", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "openPaymentWidget", "sendCardDetailsToParentScreen", "card", "Lcom/talabat/talabatcommon/model/wallet/WalletCardDisplayModel;", "paymentMethod", "Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/model/PaymentMethod;", "sendPaymentWidgetClosedEvent", "paymentStatus", "Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/model/WalletPaymentStatus;", "transactionId", "setUpExtraChannels", "setupPaymentChannel", "showSubscriptionFailed", "com_talabat_NewArchi_TalabatLife_TalabatLife"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TDineOnboardingFlutterActivity extends TalabatFlutterFragmentActivity implements PaymentBottomSheetInterface, IPaymentMethodChannel {
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    @Nullable
    private PaymentWidgetBottomSheet bottomSheet;
    @NotNull
    private final CoroutineScope coroutineScope;
    @Nullable
    private PaymentInfoDisplayModel paymentInfoDisplayModel;
    @NotNull
    private final TLifeOnBoardingViewModel viewModel;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[WalletPaymentStatus.values().length];
            iArr[WalletPaymentStatus.SUCCESS.ordinal()] = 1;
            iArr[WalletPaymentStatus.FAILURE.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public TDineOnboardingFlutterActivity() {
        super((RemoteConfiguration) null, 1, (DefaultConstructorMarker) null);
        TDineOnboardingFlutterActivity$coroutineScope$1 tDineOnboardingFlutterActivity$coroutineScope$1 = new TDineOnboardingFlutterActivity$coroutineScope$1();
        this.coroutineScope = tDineOnboardingFlutterActivity$coroutineScope$1;
        this.viewModel = TLifeOnBoardingViewModelBuilder.Companion.getTLifeOnBoardingViewModel(this, tDineOnboardingFlutterActivity$coroutineScope$1);
    }

    private final void fireTackingEventSubscriptionCompleted() {
        String str;
        IntegrationAppTrackerTLifeSubscriptions integrationAppTrackerTLifeSubscriptions = IntegrationAppTrackerTLifeSubscriptions.INSTANCE;
        TLifeOnBoardingPlanDisplayModel value = this.viewModel.getPlansData().getValue();
        if (value != null) {
            str = value.getPlanTitle();
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        integrationAppTrackerTLifeSubscriptions.onTLifeSubscriptionCompleted(str, "NA", "NA");
    }

    private final void fireTackingEventSubscriptionFailed(String str) {
        this.viewModel.sendSubscriptionFailed(str);
    }

    private final void navigateToRestaurantList() {
        Navigator.Companion.navigate((Context) this, new NavigatorModel(TLifeNavigationActions.OPEN_TALABAT_LIFE_VENDORS_ACTIVITY, (Bundle) null, (Function1) null, 6, (DefaultConstructorMarker) null));
        finish();
    }

    private final void navigateToSuccessScreen() {
        PaymentWidgetBottomSheet paymentWidgetBottomSheet = this.bottomSheet;
        if (paymentWidgetBottomSheet != null) {
            paymentWidgetBottomSheet.updatePaymentStatus(new BottomSheetPaymentStatusModel(WalletPaymentStatus.SUCCESS, (String) null, (String) null, (String) null, (String) null, 30, (DefaultConstructorMarker) null));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreate$lambda-0  reason: not valid java name */
    public static final void m5831onCreate$lambda0(TDineOnboardingFlutterActivity tDineOnboardingFlutterActivity, Failure failure) {
        Intrinsics.checkNotNullParameter(tDineOnboardingFlutterActivity, "this$0");
        PaymentWidgetBottomSheet paymentWidgetBottomSheet = tDineOnboardingFlutterActivity.bottomSheet;
        if (paymentWidgetBottomSheet != null) {
            paymentWidgetBottomSheet.updatePaymentStatus(new BottomSheetPaymentStatusModel(WalletPaymentStatus.FAILURE, (String) null, (String) null, (String) null, (String) null, 30, (DefaultConstructorMarker) null));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreate$lambda-1  reason: not valid java name */
    public static final void m5832onCreate$lambda1(TDineOnboardingFlutterActivity tDineOnboardingFlutterActivity, SubscriptionPaymentDisplayModel subscriptionPaymentDisplayModel) {
        boolean z11;
        Intrinsics.checkNotNullParameter(tDineOnboardingFlutterActivity, "this$0");
        Boolean isSubscribed = subscriptionPaymentDisplayModel.getResult().isSubscribed();
        Boolean bool = Boolean.FALSE;
        if (Intrinsics.areEqual((Object) isSubscribed, (Object) bool)) {
            String redirectURL = subscriptionPaymentDisplayModel.getResult().getRedirectURL();
            boolean z12 = false;
            if (redirectURL != null) {
                if (redirectURL.length() > 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (z11) {
                    z12 = true;
                }
            }
            if (z12) {
                PaymentWidgetBottomSheet paymentWidgetBottomSheet = tDineOnboardingFlutterActivity.bottomSheet;
                if (paymentWidgetBottomSheet != null) {
                    WalletPaymentStatus walletPaymentStatus = WalletPaymentStatus.THREE_DS;
                    String redirectURL2 = subscriptionPaymentDisplayModel.getResult().getRedirectURL();
                    Intrinsics.checkNotNull(redirectURL2);
                    paymentWidgetBottomSheet.updatePaymentStatus(new BottomSheetPaymentStatusModel(walletPaymentStatus, (String) null, (String) null, redirectURL2, (String) null, 22, (DefaultConstructorMarker) null));
                    return;
                }
                return;
            }
        }
        Boolean isSubscribed2 = subscriptionPaymentDisplayModel.getResult().isSubscribed();
        if (Intrinsics.areEqual((Object) isSubscribed2, (Object) Boolean.TRUE)) {
            tDineOnboardingFlutterActivity.navigateToSuccessScreen();
        } else if (Intrinsics.areEqual((Object) isSubscribed2, (Object) bool)) {
            tDineOnboardingFlutterActivity.showSubscriptionFailed(subscriptionPaymentDisplayModel.getError());
        }
    }

    private final void setupPaymentChannel(FlutterEngine flutterEngine) {
        MethodChannel methodChannel = new MethodChannel(flutterEngine.getDartExecutor(), "com.talabat.flutter/tlife");
        PaymentMethodChannel paymentMethodChannel = new PaymentMethodChannel();
        paymentMethodChannel.setPaymentMethodChannelInterface(this);
        methodChannel.setMethodCallHandler(paymentMethodChannel);
    }

    private final void showSubscriptionFailed(String str) {
        fireTackingEventSubscriptionFailed(str);
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

    public void configureFlutterEngine(@NotNull FlutterEngine flutterEngine) {
        Intrinsics.checkNotNullParameter(flutterEngine, "flutterEngine");
        super.configureFlutterEngine(flutterEngine);
        setupPaymentChannel(flutterEngine);
    }

    public void getCardClicked() {
        PaymentBottomSheetInterface.DefaultImpls.getCardClicked(this);
    }

    @NotNull
    public final CoroutineScope getCoroutineScope() {
        return this.coroutineScope;
    }

    @NotNull
    public String getRoute() {
        return FlutterConstants.TDINE_ONBOARDING_ROUTE;
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        this.viewModel.getFailureData().observe(this, new a(this));
        this.viewModel.getSubscriptionPaymentData().observe(this, new b(this));
    }

    public void openPaymentWidget(@NotNull PaymentInfoDisplayModel paymentInfoDisplayModel2) {
        Intrinsics.checkNotNullParameter(paymentInfoDisplayModel2, "paymentInfoDisplayModel");
        this.paymentInfoDisplayModel = paymentInfoDisplayModel2;
        PaymentWidgetBottomSheet paymentWidgetBottomSheet = new PaymentWidgetBottomSheet(paymentInfoDisplayModel2, this);
        this.bottomSheet = paymentWidgetBottomSheet;
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        paymentWidgetBottomSheet.openBottomSheet(supportFragmentManager);
    }

    public void sendCardDetailsToParentScreen(@NotNull WalletCardDisplayModel walletCardDisplayModel, @NotNull PaymentMethod paymentMethod) {
        String str;
        Intrinsics.checkNotNullParameter(walletCardDisplayModel, "card");
        Intrinsics.checkNotNullParameter(paymentMethod, "paymentMethod");
        TLifeOnBoardingViewModel tLifeOnBoardingViewModel = this.viewModel;
        PaymentInfoDisplayModel paymentInfoDisplayModel2 = this.paymentInfoDisplayModel;
        if (paymentInfoDisplayModel2 != null) {
            str = paymentInfoDisplayModel2.getPlanId();
        } else {
            str = null;
        }
        tLifeOnBoardingViewModel.payForSubscription(tLifeOnBoardingViewModel.getSubscriptionPaymentRequestModel(walletCardDisplayModel, str));
    }

    public void sendPaymentWidgetClosedEvent(@NotNull WalletPaymentStatus walletPaymentStatus, @NotNull String str) {
        Intrinsics.checkNotNullParameter(walletPaymentStatus, "paymentStatus");
        Intrinsics.checkNotNullParameter(str, "transactionId");
        int i11 = WhenMappings.$EnumSwitchMapping$0[walletPaymentStatus.ordinal()];
        if (i11 == 1) {
            navigateToRestaurantList();
            fireTackingEventSubscriptionCompleted();
        } else if (i11 != 2) {
            LogManager.debug("unexpected payment status");
        } else {
            showSubscriptionFailed("Authentication failed");
        }
    }

    public void setUpExtraChannels(@NotNull FlutterEngine flutterEngine) {
        Intrinsics.checkNotNullParameter(flutterEngine, "flutterEngine");
        super.setUpExtraChannels(flutterEngine);
        new MethodChannel(flutterEngine.getDartExecutor(), MethodChannels.NAVIGATION_CHANNEL).setMethodCallHandler(new NavigationMethodChannel(this));
    }
}
