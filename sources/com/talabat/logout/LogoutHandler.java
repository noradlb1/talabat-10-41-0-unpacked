package com.talabat.logout;

import android.content.Context;
import buisnessmodels.Cart;
import buisnessmodels.Customer;
import com.talabat.authentication.token.domain.repository.TokenRepository;
import com.talabat.core.buildconfig.BuildConfig;
import com.talabat.core.experiment.data.TalabatExperiment;
import com.talabat.core.experiment.data.squads.TalabatExperimentConstants;
import com.talabat.core.experiment.domain.FWFAttributes;
import com.talabat.core.experiment.domain.TalabatExperimentDataSourceStrategy;
import com.talabat.core.fwf.data.FunWithFlags;
import com.talabat.firebase.TalabatFirebaseMessagingService;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.user.ClearCachedUserDataUseCase;
import com.talabat.user.address.data.local.AddressesLocalDataSourceImp;
import com.talabat.userandlocation.appinfo.data.local.AppInfoLocalDataSource;
import com.talabat.userandlocation.compliance.status.di.module.UserStatusDomainModule;
import com.talabat.userandlocation.customerinfo.data.local.CustomerInfoLocalDataSource;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import library.talabat.mvp.home.domain.impl.EnableShowLocationSelectionInHomeScreenUseCaseImpl;
import library.talabat.mvp.home.domain.repository.ShowLocationSelectionRepository;
import org.jetbrains.annotations.NotNull;
import tracking.AppTracker;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0016\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\b\u0010\u000b\u001a\u00020\u0004H\u0002J\b\u0010\f\u001a\u00020\u0004H\u0002¨\u0006\r"}, d2 = {"Lcom/talabat/logout/LogoutHandler;", "", "()V", "clearData", "", "handleShowLocationSelectionInHome", "onLogout", "context", "Landroid/content/Context;", "tokenRepository", "Lcom/talabat/authentication/token/domain/repository/TokenRepository;", "resetComplianceStatusCheck", "unregisterTokenForChatPushNotifications", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LogoutHandler {
    private final void clearData() {
        GlobalDataModel.DASHBOARDDATA.orderInfo = null;
        GlobalDataModel.DASHBOARDDATA.orderListReceived = false;
        GlobalDataModel.DASHBOARDDATA.serverTime = null;
        GlobalDataModel.APPBOYNOTIFICATION.isNotificationAvail = false;
        TalabatExperiment.INSTANCE.setAttribute(FWFAttributes.PILOT_TARGETING_ID, "", TalabatExperimentDataSourceStrategy.APPTIMIZE);
    }

    private final void handleShowLocationSelectionInHome() {
        TalabatExperiment talabatExperiment = TalabatExperiment.INSTANCE;
        TalabatExperimentConstants talabatExperimentConstants = TalabatExperimentConstants.CAN_SELECT_ADDRESS_ON_HOME;
        Boolean bool = BuildConfig.IS_ALPHA;
        Intrinsics.checkNotNullExpressionValue(bool, "IS_ALPHA");
        if (talabatExperiment.getBooleanVariant(talabatExperimentConstants, bool.booleanValue(), TalabatExperimentDataSourceStrategy.APPTIMIZE)) {
            new EnableShowLocationSelectionInHomeScreenUseCaseImpl((ShowLocationSelectionRepository) null, 1, (DefaultConstructorMarker) null).enableShowLocationSelectionInHomeScreen();
        }
    }

    private final void resetComplianceStatusCheck() {
        UserStatusDomainModule.INSTANCE.provideUserStatusRepository().resetUserStatusAllowedCheck();
    }

    private final void unregisterTokenForChatPushNotifications() {
        TalabatFirebaseMessagingService.Companion.unregisterToken();
    }

    public final void onLogout(@NotNull Context context, @NotNull TokenRepository tokenRepository) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(tokenRepository, "tokenRepository");
        clearData();
        AppTracker.onLogout(context);
        GlobalDataModel.resetUserLoyaltyEligibilityFlag();
        GlobalDataModel.encryptedUserId = "";
        Customer.clearToken(context);
        tokenRepository.clearTokens();
        Customer instance = Customer.getInstance();
        instance.isClearTokenisationCards();
        instance.resetBrandLocalAddress();
        instance.deselectCustomerAddress();
        new ClearCachedUserDataUseCase((CustomerInfoLocalDataSource) null, (AddressesLocalDataSourceImp) null, (AppInfoLocalDataSource) null, 7, (DefaultConstructorMarker) null).inValidateCachedUserData();
        Cart instance2 = Cart.getInstance();
        instance2.clearCart(context);
        if (instance2.hasItems()) {
            instance2.calculateDeliveryCharges();
        }
        unregisterTokenForChatPushNotifications();
        handleShowLocationSelectionInHome();
        resetComplianceStatusCheck();
        FunWithFlags.clearUserData();
    }
}
