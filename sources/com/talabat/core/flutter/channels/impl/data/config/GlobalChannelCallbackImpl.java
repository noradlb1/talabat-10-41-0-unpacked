package com.talabat.core.flutter.channels.impl.data.config;

import android.app.Activity;
import com.talabat.application.device.id.domain.DeviceIdProvider;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.configuration.payment.PaymentConfigurationRepository;
import com.talabat.configuration.tcs.TermsAndConditionsConfigurationRepository;
import com.talabat.core.flutter.channels.domain.config.GlobalChannelCallback;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.data.googleclientid.GoogleClientIdProvider;
import com.talabat.fluttercore.domain.entities.FlutterConfigKt;
import com.talabat.location.FlutterUserLocationMapperKt;
import com.talabat.location.SelectedLocationProvider;
import com.talabat.location.UserLocation;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tracking.gtm.datalayerLogger.DatalayerModel;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001BO\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013¢\u0006\u0002\u0010\u0014J\u0012\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u0016\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u001b\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u001aH\u0016J\u0016\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001aH\u0016J\b\u0010\u001e\u001a\u00020\u001bH\u0016J\"\u0010\u001f\u001a\u00020\u00162\u0006\u0010 \u001a\u00020\u001b2\b\u0010!\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\"\u001a\u00020#H\u0002J\u001a\u0010$\u001a\u00020\u00162\b\u0010!\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\"\u001a\u00020#H\u0016J\u001a\u0010%\u001a\u00020\u00162\b\u0010!\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\"\u001a\u00020#H\u0016J\u0012\u0010&\u001a\u00020\u00162\b\u0010'\u001a\u0004\u0018\u00010\u001cH\u0016J\u0012\u0010(\u001a\u00020\u00162\b\u0010'\u001a\u0004\u0018\u00010\u001cH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/talabat/core/flutter/channels/impl/data/config/GlobalChannelCallbackImpl;", "Lcom/talabat/core/flutter/channels/domain/config/GlobalChannelCallback;", "appVersionProvider", "Lcom/talabat/configuration/discovery/AppVersionProvider;", "configurationLocalRepository", "Lcom/talabat/configuration/ConfigurationLocalRepository;", "locationConfigurationRepository", "Lcom/talabat/configuration/location/LocationConfigurationRepository;", "selectedLocationProvider", "Lcom/talabat/location/SelectedLocationProvider;", "deviceIdProvider", "Lcom/talabat/application/device/id/domain/DeviceIdProvider;", "googleClientIdProvider", "Lcom/talabat/data/googleclientid/GoogleClientIdProvider;", "paymentConfigurationRepository", "Lcom/talabat/configuration/payment/PaymentConfigurationRepository;", "termsAndConditionsConfigurationRepository", "Lcom/talabat/configuration/tcs/TermsAndConditionsConfigurationRepository;", "observabilityManager", "Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;", "(Lcom/talabat/configuration/discovery/AppVersionProvider;Lcom/talabat/configuration/ConfigurationLocalRepository;Lcom/talabat/configuration/location/LocationConfigurationRepository;Lcom/talabat/location/SelectedLocationProvider;Lcom/talabat/application/device/id/domain/DeviceIdProvider;Lcom/talabat/data/googleclientid/GoogleClientIdProvider;Lcom/talabat/configuration/payment/PaymentConfigurationRepository;Lcom/talabat/configuration/tcs/TermsAndConditionsConfigurationRepository;Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;)V", "backNavigation", "", "activity", "Landroid/app/Activity;", "configs", "", "", "", "currentAddress", "environment", "observeChannelBehaviour", "explanation", "activityName", "channelIdentity", "", "onAttach", "onDetach", "setCustomerInfo", "args", "setPaymentCards", "com_talabat_core_flutter-channels-impl_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GlobalChannelCallbackImpl implements GlobalChannelCallback {
    @NotNull
    private final AppVersionProvider appVersionProvider;
    @NotNull
    private final ConfigurationLocalRepository configurationLocalRepository;
    @NotNull
    private final DeviceIdProvider deviceIdProvider;
    @NotNull
    private final GoogleClientIdProvider googleClientIdProvider;
    @NotNull
    private final LocationConfigurationRepository locationConfigurationRepository;
    @NotNull
    private final IObservabilityManager observabilityManager;
    @NotNull
    private final PaymentConfigurationRepository paymentConfigurationRepository;
    @NotNull
    private final SelectedLocationProvider selectedLocationProvider;
    @NotNull
    private final TermsAndConditionsConfigurationRepository termsAndConditionsConfigurationRepository;

    @Inject
    public GlobalChannelCallbackImpl(@NotNull AppVersionProvider appVersionProvider2, @NotNull ConfigurationLocalRepository configurationLocalRepository2, @NotNull LocationConfigurationRepository locationConfigurationRepository2, @NotNull SelectedLocationProvider selectedLocationProvider2, @NotNull DeviceIdProvider deviceIdProvider2, @NotNull GoogleClientIdProvider googleClientIdProvider2, @NotNull PaymentConfigurationRepository paymentConfigurationRepository2, @NotNull TermsAndConditionsConfigurationRepository termsAndConditionsConfigurationRepository2, @NotNull IObservabilityManager iObservabilityManager) {
        Intrinsics.checkNotNullParameter(appVersionProvider2, "appVersionProvider");
        Intrinsics.checkNotNullParameter(configurationLocalRepository2, "configurationLocalRepository");
        Intrinsics.checkNotNullParameter(locationConfigurationRepository2, "locationConfigurationRepository");
        Intrinsics.checkNotNullParameter(selectedLocationProvider2, "selectedLocationProvider");
        Intrinsics.checkNotNullParameter(deviceIdProvider2, "deviceIdProvider");
        Intrinsics.checkNotNullParameter(googleClientIdProvider2, "googleClientIdProvider");
        Intrinsics.checkNotNullParameter(paymentConfigurationRepository2, "paymentConfigurationRepository");
        Intrinsics.checkNotNullParameter(termsAndConditionsConfigurationRepository2, "termsAndConditionsConfigurationRepository");
        Intrinsics.checkNotNullParameter(iObservabilityManager, "observabilityManager");
        this.appVersionProvider = appVersionProvider2;
        this.configurationLocalRepository = configurationLocalRepository2;
        this.locationConfigurationRepository = locationConfigurationRepository2;
        this.selectedLocationProvider = selectedLocationProvider2;
        this.deviceIdProvider = deviceIdProvider2;
        this.googleClientIdProvider = googleClientIdProvider2;
        this.paymentConfigurationRepository = paymentConfigurationRepository2;
        this.termsAndConditionsConfigurationRepository = termsAndConditionsConfigurationRepository2;
        this.observabilityManager = iObservabilityManager;
    }

    private final void observeChannelBehaviour(String str, String str2, int i11) {
        IObservabilityManager iObservabilityManager = this.observabilityManager;
        Pair[] pairArr = new Pair[2];
        if (str2 == null) {
            str2 = "N/A";
        }
        pairArr[0] = TuplesKt.to("activity_name", str2);
        pairArr[1] = TuplesKt.to("instance_id", String.valueOf(i11));
        iObservabilityManager.trackUnExpectedScenario(str, MapsKt__MapsKt.mapOf(pairArr));
    }

    public void backNavigation(@Nullable Activity activity) {
        if (activity != null) {
            activity.onBackPressed();
        }
    }

    @NotNull
    public Map<String, Object> configs() {
        return FlutterConfigKt.toMap(FlutterConfigKt.getFlutterConfig(this.appVersionProvider, this.configurationLocalRepository, this.locationConfigurationRepository, this.deviceIdProvider, this.googleClientIdProvider, this.paymentConfigurationRepository.walletConfig(), this.termsAndConditionsConfigurationRepository.config(), this.observabilityManager, DatalayerModel.INSTANCE));
    }

    @Nullable
    public Map<String, Object> currentAddress() {
        UserLocation selectedUserLocation = this.selectedLocationProvider.getSelectedUserLocation();
        if (selectedUserLocation != null) {
            return FlutterUserLocationMapperKt.toFlutterMap(selectedUserLocation);
        }
        return null;
    }

    @NotNull
    public String environment() {
        return FlutterConfigKt.getEnvironment();
    }

    public void onAttach(@Nullable String str, int i11) {
        observeChannelBehaviour("global_method_channel_attached", str, i11);
    }

    public void onDetach(@Nullable String str, int i11) {
        observeChannelBehaviour("global_method_channel_detached", str, i11);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v3, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: java.lang.Boolean} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setCustomerInfo(@org.jetbrains.annotations.Nullable java.lang.Object r11) {
        /*
            r10 = this;
            if (r11 == 0) goto L_0x01e8
            java.util.Map r11 = (java.util.Map) r11
            java.lang.String r0 = "lastOrdersDetails"
            java.lang.Object r0 = r11.get(r0)
            boolean r1 = r0 instanceof java.util.List
            r2 = 0
            if (r1 == 0) goto L_0x0012
            java.util.List r0 = (java.util.List) r0
            goto L_0x0013
        L_0x0012:
            r0 = r2
        L_0x0013:
            if (r0 != 0) goto L_0x0019
            java.util.List r0 = kotlin.collections.CollectionsKt__CollectionsKt.emptyList()
        L_0x0019:
            java.lang.String r1 = "registrationType"
            java.lang.Object r1 = r11.get(r1)
            datamodels.CustomerInfo r3 = new datamodels.CustomerInfo
            r3.<init>()
            java.lang.String r4 = "firstName"
            java.lang.Object r4 = r11.get(r4)
            boolean r5 = r4 instanceof java.lang.String
            if (r5 == 0) goto L_0x0031
            java.lang.String r4 = (java.lang.String) r4
            goto L_0x0032
        L_0x0031:
            r4 = r2
        L_0x0032:
            java.lang.String r5 = ""
            if (r4 != 0) goto L_0x0037
            r4 = r5
        L_0x0037:
            r3.firstName = r4
            java.lang.String r4 = "lastName"
            java.lang.Object r4 = r11.get(r4)
            boolean r6 = r4 instanceof java.lang.String
            if (r6 == 0) goto L_0x0046
            java.lang.String r4 = (java.lang.String) r4
            goto L_0x0047
        L_0x0046:
            r4 = r2
        L_0x0047:
            if (r4 != 0) goto L_0x004a
            r4 = r5
        L_0x004a:
            r3.lastName = r4
            java.lang.String r4 = "mobile"
            java.lang.Object r4 = r11.get(r4)
            boolean r6 = r4 instanceof java.lang.String
            if (r6 == 0) goto L_0x0059
            java.lang.String r4 = (java.lang.String) r4
            goto L_0x005a
        L_0x0059:
            r4 = r2
        L_0x005a:
            if (r4 != 0) goto L_0x005d
            r4 = r5
        L_0x005d:
            r3.mobile = r4
            java.lang.String r4 = "gender"
            java.lang.Object r4 = r11.get(r4)
            boolean r6 = r4 instanceof java.lang.Boolean
            if (r6 == 0) goto L_0x006c
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            goto L_0x006d
        L_0x006c:
            r4 = r2
        L_0x006d:
            r6 = 0
            if (r4 == 0) goto L_0x0075
            boolean r4 = r4.booleanValue()
            goto L_0x0076
        L_0x0075:
            r4 = r6
        L_0x0076:
            r3.setGender(r4)
            java.lang.String r4 = "id"
            java.lang.Object r4 = r11.get(r4)
            boolean r7 = r4 instanceof java.lang.Integer
            if (r7 == 0) goto L_0x0086
            java.lang.Integer r4 = (java.lang.Integer) r4
            goto L_0x0087
        L_0x0086:
            r4 = r2
        L_0x0087:
            if (r4 == 0) goto L_0x008e
            int r4 = r4.intValue()
            goto L_0x008f
        L_0x008e:
            r4 = r6
        L_0x008f:
            r3.f13850id = r4
            java.lang.String r4 = "birthday"
            java.lang.Object r4 = r11.get(r4)
            boolean r7 = r4 instanceof java.lang.String
            if (r7 == 0) goto L_0x009e
            java.lang.String r4 = (java.lang.String) r4
            goto L_0x009f
        L_0x009e:
            r4 = r2
        L_0x009f:
            if (r4 != 0) goto L_0x00a2
            r4 = r5
        L_0x00a2:
            r3.birthday = r4
            java.lang.String r4 = "email"
            java.lang.Object r4 = r11.get(r4)
            boolean r7 = r4 instanceof java.lang.String
            if (r7 == 0) goto L_0x00b1
            java.lang.String r4 = (java.lang.String) r4
            goto L_0x00b2
        L_0x00b1:
            r4 = r2
        L_0x00b2:
            if (r4 != 0) goto L_0x00b5
            r4 = r5
        L_0x00b5:
            r3.email = r4
            java.lang.String r4 = "subscribedToNewsletter"
            java.lang.Object r4 = r11.get(r4)
            boolean r7 = r4 instanceof java.lang.Boolean
            if (r7 == 0) goto L_0x00c5
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            goto L_0x00c6
        L_0x00c5:
            r4 = r2
        L_0x00c6:
            if (r4 == 0) goto L_0x00cd
            boolean r4 = r4.booleanValue()
            goto L_0x00ce
        L_0x00cd:
            r4 = r6
        L_0x00ce:
            r3.subscribedToNewsletter = r4
            java.lang.String r4 = "subscribedToSMS"
            java.lang.Object r4 = r11.get(r4)
            boolean r7 = r4 instanceof java.lang.Boolean
            if (r7 == 0) goto L_0x00de
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            goto L_0x00df
        L_0x00de:
            r4 = r2
        L_0x00df:
            if (r4 == 0) goto L_0x00e6
            boolean r4 = r4.booleanValue()
            goto L_0x00e7
        L_0x00e6:
            r4 = r6
        L_0x00e7:
            r3.subscribedToSMS = r4
            java.lang.String r4 = "talabatCredit"
            java.lang.Object r4 = r11.get(r4)
            java.lang.String r4 = java.lang.String.valueOf(r4)
            java.lang.Float r4 = kotlin.text.StringsKt__StringNumberConversionsJVMKt.toFloatOrNull(r4)
            if (r4 == 0) goto L_0x00ff
            float r4 = r4.floatValue()
            goto L_0x0100
        L_0x00ff:
            r4 = 0
        L_0x0100:
            r3.talabatCredit = r4
            java.lang.String r4 = "encgid"
            java.lang.Object r4 = r11.get(r4)
            boolean r7 = r4 instanceof java.lang.String
            if (r7 == 0) goto L_0x010f
            java.lang.String r4 = (java.lang.String) r4
            goto L_0x0110
        L_0x010f:
            r4 = r2
        L_0x0110:
            if (r4 != 0) goto L_0x0113
            r4 = r5
        L_0x0113:
            r3.encgid = r4
            java.lang.String r1 = java.lang.String.valueOf(r1)
            java.lang.String r4 = "0"
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r4)
            if (r4 == 0) goto L_0x0124
            datamodels.RegistrationType r1 = datamodels.RegistrationType.EMAIL
            goto L_0x0131
        L_0x0124:
            java.lang.String r4 = "1"
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r4)
            if (r1 == 0) goto L_0x012f
            datamodels.RegistrationType r1 = datamodels.RegistrationType.MOBILE_NUMBER
            goto L_0x0131
        L_0x012f:
            datamodels.RegistrationType r1 = datamodels.RegistrationType.UNDEFINED
        L_0x0131:
            r3.registrationType = r1
            java.lang.String r1 = "mobileNumber"
            java.lang.Object r1 = r11.get(r1)
            boolean r4 = r1 instanceof java.lang.String
            if (r4 == 0) goto L_0x0140
            java.lang.String r1 = (java.lang.String) r1
            goto L_0x0141
        L_0x0140:
            r1 = r2
        L_0x0141:
            if (r1 != 0) goto L_0x0144
            r1 = r5
        L_0x0144:
            r3.mobileNumber = r1
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.ArrayList r1 = new java.util.ArrayList
            r4 = 10
            int r4 = kotlin.collections.CollectionsKt__IterablesKt.collectionSizeOrDefault(r0, r4)
            r1.<init>(r4)
            java.util.Iterator r0 = r0.iterator()
        L_0x0157:
            boolean r4 = r0.hasNext()
            if (r4 == 0) goto L_0x01bb
            java.lang.Object r4 = r0.next()
            boolean r7 = r4 instanceof java.util.Map
            if (r7 == 0) goto L_0x0168
            java.util.Map r4 = (java.util.Map) r4
            goto L_0x0169
        L_0x0168:
            r4 = r2
        L_0x0169:
            if (r4 != 0) goto L_0x016f
            java.util.Map r4 = kotlin.collections.MapsKt__MapsKt.emptyMap()
        L_0x016f:
            datamodels.LastOrdersDetails r7 = new datamodels.LastOrdersDetails
            r7.<init>()
            java.lang.String r8 = "lastOrderId"
            java.lang.Object r8 = r4.get(r8)
            boolean r9 = r8 instanceof java.lang.Integer
            if (r9 == 0) goto L_0x0181
            java.lang.Integer r8 = (java.lang.Integer) r8
            goto L_0x0182
        L_0x0181:
            r8 = r2
        L_0x0182:
            if (r8 == 0) goto L_0x0189
            int r8 = r8.intValue()
            goto L_0x018a
        L_0x0189:
            r8 = r6
        L_0x018a:
            r7.lastOrderId = r8
            java.lang.String r8 = "lastOrderRestId"
            java.lang.Object r8 = r4.get(r8)
            boolean r9 = r8 instanceof java.lang.Integer
            if (r9 == 0) goto L_0x0199
            java.lang.Integer r8 = (java.lang.Integer) r8
            goto L_0x019a
        L_0x0199:
            r8 = r2
        L_0x019a:
            if (r8 == 0) goto L_0x01a1
            int r8 = r8.intValue()
            goto L_0x01a2
        L_0x01a1:
            r8 = r6
        L_0x01a2:
            r7.lastOrderRestId = r8
            java.lang.String r8 = "lastOrderRestName"
            java.lang.Object r4 = r4.get(r8)
            boolean r8 = r4 instanceof java.lang.String
            if (r8 == 0) goto L_0x01b1
            java.lang.String r4 = (java.lang.String) r4
            goto L_0x01b2
        L_0x01b1:
            r4 = r2
        L_0x01b2:
            if (r4 != 0) goto L_0x01b5
            r4 = r5
        L_0x01b5:
            r7.lastOrderRestName = r4
            r1.add(r7)
            goto L_0x0157
        L_0x01bb:
            datamodels.LastOrdersDetails[] r0 = new datamodels.LastOrdersDetails[r6]
            java.lang.Object[] r0 = r1.toArray(r0)
            java.lang.String r1 = "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0, r1)
            datamodels.LastOrdersDetails[] r0 = (datamodels.LastOrdersDetails[]) r0
            r3.lastOrdersDetails = r0
            java.lang.String r0 = "isANewCustomer"
            java.lang.Object r11 = r11.get(r0)
            boolean r0 = r11 instanceof java.lang.Boolean
            if (r0 == 0) goto L_0x01d7
            r2 = r11
            java.lang.Boolean r2 = (java.lang.Boolean) r2
        L_0x01d7:
            if (r2 == 0) goto L_0x01dd
            boolean r6 = r2.booleanValue()
        L_0x01dd:
            r3.setIsANewCustomer(r6)
            buisnessmodels.Customer r11 = buisnessmodels.Customer.getInstance()
            r11.setCustomerInfo(r3)
            return
        L_0x01e8:
            java.lang.NullPointerException r11 = new java.lang.NullPointerException
            java.lang.String r0 = "null cannot be cast to non-null type kotlin.collections.Map<*, *>"
            r11.<init>(r0)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.core.flutter.channels.impl.data.config.GlobalChannelCallbackImpl.setCustomerInfo(java.lang.Object):void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v2, resolved type: java.lang.Boolean} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setPaymentCards(@org.jetbrains.annotations.Nullable java.lang.Object r9) {
        /*
            r8 = this;
            java.util.List r9 = (java.util.List) r9
            if (r9 != 0) goto L_0x0008
            java.util.List r9 = kotlin.collections.CollectionsKt__CollectionsKt.emptyList()
        L_0x0008:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.Iterator r9 = r9.iterator()
        L_0x0011:
            boolean r1 = r9.hasNext()
            r2 = 0
            if (r1 == 0) goto L_0x0134
            java.lang.Object r1 = r9.next()
            boolean r3 = r1 instanceof java.util.Map
            r4 = 0
            if (r3 == 0) goto L_0x0024
            java.util.Map r1 = (java.util.Map) r1
            goto L_0x0025
        L_0x0024:
            r1 = r4
        L_0x0025:
            if (r1 != 0) goto L_0x002b
            java.util.Map r1 = kotlin.collections.MapsKt__MapsKt.emptyMap()
        L_0x002b:
            buisnessmodels.tokenisation.TokenisationCreditCard r3 = new buisnessmodels.tokenisation.TokenisationCreditCard
            r3.<init>()
            java.lang.String r5 = "token"
            java.lang.Object r5 = r1.get(r5)
            boolean r6 = r5 instanceof java.lang.String
            if (r6 == 0) goto L_0x003e
            java.lang.String r5 = (java.lang.String) r5
            goto L_0x003f
        L_0x003e:
            r5 = r4
        L_0x003f:
            java.lang.String r6 = ""
            if (r5 != 0) goto L_0x0044
            r5 = r6
        L_0x0044:
            r3.token = r5
            java.lang.String r5 = "holdername"
            java.lang.Object r5 = r1.get(r5)
            boolean r7 = r5 instanceof java.lang.String
            if (r7 == 0) goto L_0x0053
            java.lang.String r5 = (java.lang.String) r5
            goto L_0x0054
        L_0x0053:
            r5 = r4
        L_0x0054:
            if (r5 != 0) goto L_0x0057
            r5 = r6
        L_0x0057:
            r3.holdername = r5
            java.lang.String r5 = "cardnumber"
            java.lang.Object r5 = r1.get(r5)
            boolean r7 = r5 instanceof java.lang.String
            if (r7 == 0) goto L_0x0066
            java.lang.String r5 = (java.lang.String) r5
            goto L_0x0067
        L_0x0066:
            r5 = r4
        L_0x0067:
            if (r5 != 0) goto L_0x006a
            r5 = r6
        L_0x006a:
            r3.cardnumber = r5
            java.lang.String r5 = "cardtype"
            java.lang.Object r5 = r1.get(r5)
            boolean r7 = r5 instanceof java.lang.String
            if (r7 == 0) goto L_0x0079
            java.lang.String r5 = (java.lang.String) r5
            goto L_0x007a
        L_0x0079:
            r5 = r4
        L_0x007a:
            if (r5 != 0) goto L_0x007d
            r5 = r6
        L_0x007d:
            r3.cardtype = r5
            java.lang.String r5 = "expiredate"
            java.lang.Object r5 = r1.get(r5)
            boolean r7 = r5 instanceof java.lang.String
            if (r7 == 0) goto L_0x008c
            java.lang.String r5 = (java.lang.String) r5
            goto L_0x008d
        L_0x008c:
            r5 = r4
        L_0x008d:
            if (r5 != 0) goto L_0x0090
            r5 = r6
        L_0x0090:
            r3.expiredate = r5
            java.lang.String r5 = "expireyear"
            java.lang.Object r5 = r1.get(r5)
            boolean r7 = r5 instanceof java.lang.Integer
            if (r7 == 0) goto L_0x009f
            java.lang.Integer r5 = (java.lang.Integer) r5
            goto L_0x00a0
        L_0x009f:
            r5 = r4
        L_0x00a0:
            if (r5 == 0) goto L_0x00a7
            int r5 = r5.intValue()
            goto L_0x00a8
        L_0x00a7:
            r5 = r2
        L_0x00a8:
            r3.expireyear = r5
            java.lang.String r5 = "expiremonth"
            java.lang.Object r5 = r1.get(r5)
            boolean r7 = r5 instanceof java.lang.Integer
            if (r7 == 0) goto L_0x00b7
            java.lang.Integer r5 = (java.lang.Integer) r5
            goto L_0x00b8
        L_0x00b7:
            r5 = r4
        L_0x00b8:
            if (r5 == 0) goto L_0x00bf
            int r5 = r5.intValue()
            goto L_0x00c0
        L_0x00bf:
            r5 = r2
        L_0x00c0:
            r3.expiremonth = r5
            java.lang.String r5 = "isValidCard"
            java.lang.Object r5 = r1.get(r5)
            boolean r7 = r5 instanceof java.lang.Boolean
            if (r7 == 0) goto L_0x00cf
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            goto L_0x00d0
        L_0x00cf:
            r5 = r4
        L_0x00d0:
            if (r5 == 0) goto L_0x00d7
            boolean r5 = r5.booleanValue()
            goto L_0x00d8
        L_0x00d7:
            r5 = r2
        L_0x00d8:
            r3.isValidCard = r5
            java.lang.String r5 = "tokenId"
            java.lang.Object r5 = r1.get(r5)
            boolean r7 = r5 instanceof java.lang.String
            if (r7 == 0) goto L_0x00e8
            java.lang.String r5 = (java.lang.String) r5
            goto L_0x00e9
        L_0x00e8:
            r5 = r4
        L_0x00e9:
            if (r5 != 0) goto L_0x00ec
            r5 = r6
        L_0x00ec:
            r3.tokenId = r5
            java.lang.String r5 = "isBinDiscountValid"
            java.lang.Object r5 = r1.get(r5)
            boolean r7 = r5 instanceof java.lang.Boolean
            if (r7 == 0) goto L_0x00fb
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            goto L_0x00fc
        L_0x00fb:
            r5 = r4
        L_0x00fc:
            if (r5 == 0) goto L_0x0103
            boolean r5 = r5.booleanValue()
            goto L_0x0104
        L_0x0103:
            r5 = r2
        L_0x0104:
            r3.isBinDiscountValid = r5
            java.lang.String r5 = "binNumber"
            java.lang.Object r5 = r1.get(r5)
            boolean r7 = r5 instanceof java.lang.String
            if (r7 == 0) goto L_0x0113
            java.lang.String r5 = (java.lang.String) r5
            goto L_0x0114
        L_0x0113:
            r5 = r4
        L_0x0114:
            if (r5 != 0) goto L_0x0117
            goto L_0x0118
        L_0x0117:
            r6 = r5
        L_0x0118:
            r3.binNumber = r6
            java.lang.String r5 = "isForceCvv"
            java.lang.Object r1 = r1.get(r5)
            boolean r5 = r1 instanceof java.lang.Boolean
            if (r5 == 0) goto L_0x0127
            r4 = r1
            java.lang.Boolean r4 = (java.lang.Boolean) r4
        L_0x0127:
            if (r4 == 0) goto L_0x012d
            boolean r2 = r4.booleanValue()
        L_0x012d:
            r3.isForceCvv = r2
            r0.add(r3)
            goto L_0x0011
        L_0x0134:
            buisnessmodels.Customer r9 = buisnessmodels.Customer.getInstance()
            buisnessmodels.tokenisation.TokenisationCreditCard[] r1 = new buisnessmodels.tokenisation.TokenisationCreditCard[r2]
            java.lang.Object[] r0 = r0.toArray(r1)
            java.lang.String r1 = "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0, r1)
            buisnessmodels.tokenisation.TokenisationCreditCard[] r0 = (buisnessmodels.tokenisation.TokenisationCreditCard[]) r0
            r9.setSavedCreditCards(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.core.flutter.channels.impl.data.config.GlobalChannelCallbackImpl.setPaymentCards(java.lang.Object):void");
    }
}
