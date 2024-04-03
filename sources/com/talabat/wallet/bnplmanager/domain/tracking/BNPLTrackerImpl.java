package com.talabat.wallet.bnplmanager.domain.tracking;

import android.content.Context;
import buisnessmodels.Cart;
import buisnessmodels.Customer;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.core.tracking.domain.TalabatTracker;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.helpers.TalabatUtils;
import com.talabat.helpers.tracking.event.ScreenOpenedEvent;
import com.talabat.helpers.tracking.event.ScreenOpenedEventModel;
import com.talabat.wallet.bnplmanager.domain.entity.BNPLValidationError;
import com.talabat.wallet.bnplmanager.domain.tracking.event.BnplErrorEvent;
import com.talabat.wallet.bnplmanager.domain.tracking.event.BnplFakeTestSubmissionEvent;
import com.talabat.wallet.bnplmanager.domain.tracking.event.BnplOrderPaymentFailureEvent;
import com.talabat.wallet.bnplmanager.domain.tracking.event.BnplValidationErrorEvent;
import com.talabat.wallet.bnplmanager.domain.tracking.event.PaymentMethodChangedEvent;
import com.talabat.wallet.bnplmanager.domain.tracking.event.PlaceFakeOrderEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tracking.AppTracker;
import tracking.IAppTracker;
import tracking.models.pay.BNPLOrderPaymentFailureTrackingModel;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 %2\u00020\u0001:\u0001%B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u0012\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0002J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0012H\u0016J\u0018\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u0010H\u0016J\u0010\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0010\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0018\u0010\u001f\u001a\u00020\u00142\u0006\u0010 \u001a\u00020\u00122\u0006\u0010!\u001a\u00020\u0012H\u0016J\u0010\u0010\"\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010#\u001a\u00020\u0014H\u0016J\u0010\u0010$\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u0012H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/talabat/wallet/bnplmanager/domain/tracking/BNPLTrackerImpl;", "Lcom/talabat/wallet/bnplmanager/domain/tracking/BNPLTracker;", "context", "Landroid/content/Context;", "appTracker", "Ltracking/IAppTracker;", "talabatTracker", "Lcom/talabat/core/tracking/domain/TalabatTracker;", "isTalabatTrackerEnabledForBNPL", "Lcom/talabat/wallet/bnplmanager/domain/tracking/IsTalabatTrackerEnabledForBNPL;", "configurationLocalRepository", "Lcom/talabat/configuration/ConfigurationLocalRepository;", "locationConfigurationRepository", "Lcom/talabat/configuration/location/LocationConfigurationRepository;", "(Landroid/content/Context;Ltracking/IAppTracker;Lcom/talabat/core/tracking/domain/TalabatTracker;Lcom/talabat/wallet/bnplmanager/domain/tracking/IsTalabatTrackerEnabledForBNPL;Lcom/talabat/configuration/ConfigurationLocalRepository;Lcom/talabat/configuration/location/LocationConfigurationRepository;)V", "isScreenViewEventValid", "", "screenName", "", "onBNPLError", "", "bNPLValidationError", "Lcom/talabat/wallet/bnplmanager/domain/entity/BNPLValidationError;", "eventName", "onBNPLFakeTestSubmitted", "isBNPLNotify", "isBNPLFeedback", "onBNPLOrderPaymentFailure", "failureTrackingModel", "Ltracking/models/pay/BNPLOrderPaymentFailureTrackingModel;", "onBNPLPlaceOrderBottomSheetOpen", "onBNPLValidationError", "errorCode", "errorDescription", "onPaymentMethodChanged", "onPlaceFakeOrder", "trackBNPLPlaceOrderBottomSheetOpen", "Companion", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BNPLTrackerImpl implements BNPLTracker {
    @NotNull
    @Deprecated
    public static final String BNPL_PAYMENT_METHOD = "BNPL";
    @NotNull
    @Deprecated
    public static final String BNPL_SCREEN_NAME = "PAY_LATER";
    @NotNull
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private final IAppTracker appTracker;
    @NotNull
    private final ConfigurationLocalRepository configurationLocalRepository;
    @NotNull
    private final Context context;
    @NotNull
    private final IsTalabatTrackerEnabledForBNPL isTalabatTrackerEnabledForBNPL;
    @NotNull
    private final LocationConfigurationRepository locationConfigurationRepository;
    @NotNull
    private final TalabatTracker talabatTracker;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/talabat/wallet/bnplmanager/domain/tracking/BNPLTrackerImpl$Companion;", "", "()V", "BNPL_PAYMENT_METHOD", "", "BNPL_SCREEN_NAME", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public BNPLTrackerImpl(@NotNull Context context2, @NotNull IAppTracker iAppTracker, @NotNull TalabatTracker talabatTracker2, @NotNull IsTalabatTrackerEnabledForBNPL isTalabatTrackerEnabledForBNPL2, @NotNull ConfigurationLocalRepository configurationLocalRepository2, @NotNull LocationConfigurationRepository locationConfigurationRepository2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(iAppTracker, "appTracker");
        Intrinsics.checkNotNullParameter(talabatTracker2, "talabatTracker");
        Intrinsics.checkNotNullParameter(isTalabatTrackerEnabledForBNPL2, "isTalabatTrackerEnabledForBNPL");
        Intrinsics.checkNotNullParameter(configurationLocalRepository2, "configurationLocalRepository");
        Intrinsics.checkNotNullParameter(locationConfigurationRepository2, "locationConfigurationRepository");
        this.context = context2;
        this.appTracker = iAppTracker;
        this.talabatTracker = talabatTracker2;
        this.isTalabatTrackerEnabledForBNPL = isTalabatTrackerEnabledForBNPL2;
        this.configurationLocalRepository = configurationLocalRepository2;
        this.locationConfigurationRepository = locationConfigurationRepository2;
    }

    private final boolean isScreenViewEventValid(String str) {
        boolean z11;
        if (str == null) {
            return false;
        }
        if (str.length() == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            return false;
        }
        if (!Intrinsics.areEqual((Object) str, (Object) "Home Screen") || !GlobalDataModel.isSearchActive) {
            return true;
        }
        return false;
    }

    private final void trackBNPLPlaceOrderBottomSheetOpen(String str) {
        if (!this.isTalabatTrackerEnabledForBNPL.invoke() || !isScreenViewEventValid(str)) {
            AppTracker.onPageOpen(this.context, str, TalabatUtils.getSelectedCountry(this.configurationLocalRepository, this.locationConfigurationRepository), Customer.getInstance().getCustomerInfo());
            return;
        }
        this.talabatTracker.track(new ScreenOpenedEvent(new ScreenOpenedEventModel(str, Customer.getInstance().getCustomerInfo().talabatCredit, String.valueOf(Cart.getInstance().getCartSubTotal()), Cart.getInstance().hasItems(), Customer.getInstance().isLoggedIn())));
    }

    public void onBNPLError(@NotNull BNPLValidationError bNPLValidationError, @NotNull String str) {
        Intrinsics.checkNotNullParameter(bNPLValidationError, "bNPLValidationError");
        Intrinsics.checkNotNullParameter(str, "eventName");
        if (this.isTalabatTrackerEnabledForBNPL.invoke()) {
            this.talabatTracker.track(new BnplErrorEvent(bNPLValidationError.getCode(), bNPLValidationError.getDescription(), str));
        } else {
            this.appTracker.onPushBNPLError(this.context, bNPLValidationError.getCode(), bNPLValidationError.getDescription(), str);
        }
    }

    public void onBNPLFakeTestSubmitted(boolean z11, boolean z12) {
        if (this.isTalabatTrackerEnabledForBNPL.invoke()) {
            this.talabatTracker.track(new BnplFakeTestSubmissionEvent(z11, z12));
        } else {
            this.appTracker.onPushBNPLFakeTestSubmitted(this.context, z11, z12);
        }
    }

    public void onBNPLOrderPaymentFailure(@NotNull BNPLOrderPaymentFailureTrackingModel bNPLOrderPaymentFailureTrackingModel) {
        Intrinsics.checkNotNullParameter(bNPLOrderPaymentFailureTrackingModel, "failureTrackingModel");
        if (this.isTalabatTrackerEnabledForBNPL.invoke()) {
            this.talabatTracker.track(new BnplOrderPaymentFailureEvent(bNPLOrderPaymentFailureTrackingModel));
        } else {
            this.appTracker.onPushBNPLOrderPaymentFailureEvent(this.context, bNPLOrderPaymentFailureTrackingModel);
        }
    }

    public void onBNPLPlaceOrderBottomSheetOpen(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "screenName");
        trackBNPLPlaceOrderBottomSheetOpen(str);
    }

    public void onBNPLValidationError(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "errorCode");
        Intrinsics.checkNotNullParameter(str2, "errorDescription");
        if (this.isTalabatTrackerEnabledForBNPL.invoke()) {
            this.talabatTracker.track(new BnplValidationErrorEvent(str, str2));
        } else {
            this.appTracker.onPushBNPLValidationLoaded(this.context, str, str2);
        }
    }

    public void onPaymentMethodChanged(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "screenName");
        if (this.isTalabatTrackerEnabledForBNPL.invoke()) {
            this.talabatTracker.track(new PaymentMethodChangedEvent(str));
        } else {
            this.appTracker.onPushPaymentMethodChanged(this.context, "BNPL", str);
        }
    }

    public void onPlaceFakeOrder() {
        if (this.isTalabatTrackerEnabledForBNPL.invoke()) {
            this.talabatTracker.track(new PlaceFakeOrderEvent(BNPL_SCREEN_NAME));
        } else {
            this.appTracker.onPushPlaceFakeOrder(this.context, BNPL_SCREEN_NAME);
        }
    }
}
