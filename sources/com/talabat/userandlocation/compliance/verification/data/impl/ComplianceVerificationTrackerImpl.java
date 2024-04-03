package com.talabat.userandlocation.compliance.verification.data.impl;

import android.content.Context;
import buisnessmodels.Cart;
import buisnessmodels.Customer;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.core.tracking.domain.TalabatTracker;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.helpers.tracking.event.ScreenOpenedEvent;
import com.talabat.helpers.tracking.event.ScreenOpenedEventModel;
import com.talabat.userandlocation.compliance.verification.domain.tracker.ComplianceVerificationTracker;
import datamodels.Country;
import datamodels.CustomerInfo;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tracking.AppTracker;
import tracking.ScreenNames;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001BQ\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0010\b\u0002\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\r\u0012\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\r¢\u0006\u0002\u0010\u0011J\u0012\u0010\u0012\u001a\u00020\u00072\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0016H\u0002J\b\u0010\u0018\u001a\u00020\u0016H\u0016J\b\u0010\u0019\u001a\u00020\u0016H\u0002J\b\u0010\u001a\u001a\u00020\u0016H\u0016J\u0010\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u0014H\u0016R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/talabat/userandlocation/compliance/verification/data/impl/ComplianceVerificationTrackerImpl;", "Lcom/talabat/userandlocation/compliance/verification/domain/tracker/ComplianceVerificationTracker;", "context", "Landroid/content/Context;", "talabatTracker", "Lcom/talabat/core/tracking/domain/TalabatTracker;", "isNewTrackingEnabled", "", "configurationLocalRepository", "Lcom/talabat/configuration/ConfigurationLocalRepository;", "locationConfigurationRepository", "Lcom/talabat/configuration/location/LocationConfigurationRepository;", "selectedCountryProvider", "Lkotlin/Function0;", "Ldatamodels/Country;", "customerInfoProvider", "Ldatamodels/CustomerInfo;", "(Landroid/content/Context;Lcom/talabat/core/tracking/domain/TalabatTracker;ZLcom/talabat/configuration/ConfigurationLocalRepository;Lcom/talabat/configuration/location/LocationConfigurationRepository;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "isScreenViewEventValid", "screenName", "", "trackContinueToCheckout", "", "trackExistingAccountVerification", "trackExistingAccountVerificationScreenOpened", "trackNewAccountVerification", "trackNewAccountVerificationScreenOpened", "trackUserBlocked", "message", "com_talabat_NewArchi_UserAndLocation_Compliance_Compliance"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ComplianceVerificationTrackerImpl implements ComplianceVerificationTracker {
    @NotNull
    private final ConfigurationLocalRepository configurationLocalRepository;
    @NotNull
    private final Context context;
    @NotNull
    private final Function0<CustomerInfo> customerInfoProvider;
    private final boolean isNewTrackingEnabled;
    @NotNull
    private final LocationConfigurationRepository locationConfigurationRepository;
    @NotNull
    private final Function0<Country> selectedCountryProvider;
    @NotNull
    private final TalabatTracker talabatTracker;

    public ComplianceVerificationTrackerImpl(@NotNull Context context2, @NotNull TalabatTracker talabatTracker2, boolean z11, @NotNull ConfigurationLocalRepository configurationLocalRepository2, @NotNull LocationConfigurationRepository locationConfigurationRepository2, @NotNull Function0<? extends Country> function0, @NotNull Function0<? extends CustomerInfo> function02) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(talabatTracker2, "talabatTracker");
        Intrinsics.checkNotNullParameter(configurationLocalRepository2, "configurationLocalRepository");
        Intrinsics.checkNotNullParameter(locationConfigurationRepository2, "locationConfigurationRepository");
        Intrinsics.checkNotNullParameter(function0, "selectedCountryProvider");
        Intrinsics.checkNotNullParameter(function02, "customerInfoProvider");
        this.context = context2;
        this.talabatTracker = talabatTracker2;
        this.isNewTrackingEnabled = z11;
        this.configurationLocalRepository = configurationLocalRepository2;
        this.locationConfigurationRepository = locationConfigurationRepository2;
        this.selectedCountryProvider = function0;
        this.customerInfoProvider = function02;
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

    private final void trackExistingAccountVerification() {
        float f11;
        if (!this.isNewTrackingEnabled || !isScreenViewEventValid(ScreenNames.VERIFY_ACCOUNT_INFO)) {
            AppTracker.onPageOpen(this.context, ScreenNames.VERIFY_ACCOUNT_INFO, this.selectedCountryProvider.invoke(), this.customerInfoProvider.invoke());
            return;
        }
        TalabatTracker talabatTracker2 = this.talabatTracker;
        CustomerInfo customerInfo = Customer.getInstance().getCustomerInfo();
        if (customerInfo != null) {
            f11 = customerInfo.talabatCredit;
        } else {
            f11 = 0.0f;
        }
        talabatTracker2.track(new ScreenOpenedEvent(new ScreenOpenedEventModel(ScreenNames.VERIFY_ACCOUNT_INFO, f11, String.valueOf(Cart.getInstance().getCartSubTotal()), Cart.getInstance().hasItems(), Customer.getInstance().isLoggedIn())));
    }

    private final void trackNewAccountVerification() {
        float f11;
        if (!this.isNewTrackingEnabled || !isScreenViewEventValid(ScreenNames.REGISTRATION)) {
            AppTracker.onPageOpen(this.context, ScreenNames.REGISTRATION, this.selectedCountryProvider.invoke(), this.customerInfoProvider.invoke());
            return;
        }
        TalabatTracker talabatTracker2 = this.talabatTracker;
        CustomerInfo customerInfo = Customer.getInstance().getCustomerInfo();
        if (customerInfo != null) {
            f11 = customerInfo.talabatCredit;
        } else {
            f11 = 0.0f;
        }
        talabatTracker2.track(new ScreenOpenedEvent(new ScreenOpenedEventModel(ScreenNames.REGISTRATION, f11, String.valueOf(Cart.getInstance().getCartSubTotal()), Cart.getInstance().hasItems(), Customer.getInstance().isLoggedIn())));
    }

    public void trackContinueToCheckout() {
        AppTracker.onComplianceContinueToCheckout(this.context);
    }

    public void trackExistingAccountVerificationScreenOpened() {
        trackExistingAccountVerification();
    }

    public void trackNewAccountVerificationScreenOpened() {
        trackNewAccountVerification();
    }

    public void trackUserBlocked(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        AppTracker.onComplianceUserBlocked(this.context, str);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ ComplianceVerificationTrackerImpl(android.content.Context r10, com.talabat.core.tracking.domain.TalabatTracker r11, boolean r12, final com.talabat.configuration.ConfigurationLocalRepository r13, final com.talabat.configuration.location.LocationConfigurationRepository r14, kotlin.jvm.functions.Function0 r15, kotlin.jvm.functions.Function0 r16, int r17, kotlin.jvm.internal.DefaultConstructorMarker r18) {
        /*
            r9 = this;
            r0 = r17 & 32
            if (r0 == 0) goto L_0x000d
            com.talabat.userandlocation.compliance.verification.data.impl.ComplianceVerificationTrackerImpl$1 r0 = new com.talabat.userandlocation.compliance.verification.data.impl.ComplianceVerificationTrackerImpl$1
            r5 = r13
            r6 = r14
            r0.<init>(r13, r14)
            r7 = r0
            goto L_0x0010
        L_0x000d:
            r5 = r13
            r6 = r14
            r7 = r15
        L_0x0010:
            r0 = r17 & 64
            if (r0 == 0) goto L_0x0018
            com.talabat.userandlocation.compliance.verification.data.impl.ComplianceVerificationTrackerImpl$2 r0 = com.talabat.userandlocation.compliance.verification.data.impl.ComplianceVerificationTrackerImpl.AnonymousClass2.INSTANCE
            r8 = r0
            goto L_0x001a
        L_0x0018:
            r8 = r16
        L_0x001a:
            r1 = r9
            r2 = r10
            r3 = r11
            r4 = r12
            r5 = r13
            r6 = r14
            r1.<init>(r2, r3, r4, r5, r6, r7, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.userandlocation.compliance.verification.data.impl.ComplianceVerificationTrackerImpl.<init>(android.content.Context, com.talabat.core.tracking.domain.TalabatTracker, boolean, com.talabat.configuration.ConfigurationLocalRepository, com.talabat.configuration.location.LocationConfigurationRepository, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function0, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
