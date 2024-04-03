package com.deliveryhero.contract.configuration;

import com.deliveryhero.contract.ChatLogger;
import com.deliveryhero.contract.location.LocationProvider;
import com.deliveryhero.contract.model.ClientConfig;
import com.deliveryhero.contract.model.DeliveryInfo;
import com.deliveryhero.contract.model.PhoneCallType;
import com.deliveryhero.contract.model.Translations;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\t\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\r\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\fJ\u0010\u0010A\u001a\u00020\u00002\u0006\u0010B\u001a\u00020\u0010H\u0007J\u000e\u0010\u0011\u001a\u00020\u00002\u0006\u0010B\u001a\u00020\u0010J\u0010\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0010H\u0007J\u0010\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0010H\u0007J\u0010\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u0010H\u0007J\u0010\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u0010H\u0007J\u0010\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u0010H\u0007J\u000e\u0010)\u001a\u00020\u00002\u0006\u0010)\u001a\u00020(J\u000e\u0010-\u001a\u00020\u00002\u0006\u0010-\u001a\u00020,J\u0014\u00101\u001a\u00020\u00002\f\u00101\u001a\b\u0012\u0004\u0012\u00020\u000400J\u0010\u0010&\u001a\u00020\u00002\b\u0010\"\u001a\u0004\u0018\u00010#J\u0010\u00104\u001a\u00020\u00002\u0006\u00104\u001a\u00020\u0010H\u0007J\u000e\u00107\u001a\u00020\u00002\u0006\u00107\u001a\u00020\u0010J\u000e\u0010:\u001a\u00020\u00002\u0006\u0010:\u001a\u000209J\u000e\u0010>\u001a\u00020\u00002\u0006\u0010>\u001a\u00020=R\"\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\"\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\b@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\"\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u0003\u001a\u0004\u0018\u00010\f@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0003\u001a\u0004\u0018\u00010\u0010@BX\u000e¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R,\u0010\u0015\u001a\u0004\u0018\u00010\u00102\b\u0010\u0003\u001a\u0004\u0018\u00010\u00108\u0006@BX\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u0012\u0004\b\u0016\u0010\u0002\u001a\u0004\b\u0017\u0010\u0013R,\u0010\u0018\u001a\u0004\u0018\u00010\u00102\b\u0010\u0003\u001a\u0004\u0018\u00010\u00108\u0006@BX\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u0012\u0004\b\u0019\u0010\u0002\u001a\u0004\b\u0018\u0010\u0013R,\u0010\u001a\u001a\u0004\u0018\u00010\u00102\b\u0010\u0003\u001a\u0004\u0018\u00010\u00108\u0006@BX\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u0012\u0004\b\u001b\u0010\u0002\u001a\u0004\b\u001a\u0010\u0013R,\u0010\u001c\u001a\u0004\u0018\u00010\u00102\b\u0010\u0003\u001a\u0004\u0018\u00010\u00108\u0006@BX\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u0012\u0004\b\u001d\u0010\u0002\u001a\u0004\b\u001c\u0010\u0013R,\u0010\u001e\u001a\u0004\u0018\u00010\u00102\b\u0010\u0003\u001a\u0004\u0018\u00010\u00108\u0006@BX\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u0012\u0004\b\u001f\u0010\u0002\u001a\u0004\b\u001e\u0010\u0013R,\u0010 \u001a\u0004\u0018\u00010\u00102\b\u0010\u0003\u001a\u0004\u0018\u00010\u00108\u0006@BX\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u0012\u0004\b!\u0010\u0002\u001a\u0004\b \u0010\u0013R\u001c\u0010\"\u001a\u0004\u0018\u00010#X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\"\u0010)\u001a\u0004\u0018\u00010(2\b\u0010\u0003\u001a\u0004\u0018\u00010(@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\"\u0010-\u001a\u0004\u0018\u00010,2\b\u0010\u0003\u001a\u0004\u0018\u00010,@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R.\u00101\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001002\u000e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u000100@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R,\u00104\u001a\u0004\u0018\u00010\u00102\b\u0010\u0003\u001a\u0004\u0018\u00010\u00108\u0006@BX\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u0012\u0004\b5\u0010\u0002\u001a\u0004\b6\u0010\u0013R$\u00107\u001a\u0004\u0018\u00010\u00102\b\u0010\u0003\u001a\u0004\u0018\u00010\u0010@BX\u000e¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b8\u0010\u0013R\"\u0010:\u001a\u0004\u0018\u0001092\b\u0010\u0003\u001a\u0004\u0018\u000109@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b;\u0010<R\"\u0010>\u001a\u0004\u0018\u00010=2\b\u0010\u0003\u001a\u0004\u0018\u00010=@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b?\u0010@¨\u0006C"}, d2 = {"Lcom/deliveryhero/contract/configuration/CustomerChatConfigurationBuilder;", "", "()V", "<set-?>", "", "channelId", "getChannelId", "()Ljava/lang/String;", "Lcom/deliveryhero/contract/model/ClientConfig;", "clientConfig", "getClientConfig", "()Lcom/deliveryhero/contract/model/ClientConfig;", "Lcom/deliveryhero/contract/model/DeliveryInfo;", "deliveryInfo", "getDeliveryInfo", "()Lcom/deliveryhero/contract/model/DeliveryInfo;", "", "enableVoipLogging", "getEnableVoipLogging", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "hideAdminMessages", "getHideAdminMessages$annotations", "getHideAdminMessages", "isFWFEnabled", "isFWFEnabled$annotations", "isLocationSharingEnabled", "isLocationSharingEnabled$annotations", "isPhotoSharingEnabled", "isPhotoSharingEnabled$annotations", "isReplyingMandatory", "isReplyingMandatory$annotations", "isTrackingEnabled", "isTrackingEnabled$annotations", "locationProvider", "Lcom/deliveryhero/contract/location/LocationProvider;", "getLocationProvider", "()Lcom/deliveryhero/contract/location/LocationProvider;", "setLocationProvider", "(Lcom/deliveryhero/contract/location/LocationProvider;)V", "Lcom/deliveryhero/contract/ChatLogger;", "logger", "getLogger", "()Lcom/deliveryhero/contract/ChatLogger;", "Lcom/deliveryhero/contract/model/PhoneCallType;", "phoneCallingType", "getPhoneCallingType", "()Lcom/deliveryhero/contract/model/PhoneCallType;", "", "quickReplies", "getQuickReplies", "()Ljava/util/List;", "showSenderName", "getShowSenderName$annotations", "getShowSenderName", "stackFromEnd", "getStackFromEnd", "Lcom/deliveryhero/contract/model/Translations;", "translations", "getTranslations", "()Lcom/deliveryhero/contract/model/Translations;", "Lcom/deliveryhero/contract/configuration/UserRegistrationData;", "userRegistrationData", "getUserRegistrationData", "()Lcom/deliveryhero/contract/configuration/UserRegistrationData;", "enableTracking", "enabled", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CustomerChatConfigurationBuilder {
    @Nullable
    private String channelId;
    @Nullable
    private ClientConfig clientConfig;
    @Nullable
    private DeliveryInfo deliveryInfo;
    @Nullable
    private Boolean enableVoipLogging;
    @Nullable
    private Boolean hideAdminMessages;
    @Nullable
    private Boolean isFWFEnabled;
    @Nullable
    private Boolean isLocationSharingEnabled;
    @Nullable
    private Boolean isPhotoSharingEnabled;
    @Nullable
    private Boolean isReplyingMandatory;
    @Nullable
    private Boolean isTrackingEnabled;
    @Nullable
    private LocationProvider locationProvider;
    @Nullable
    private ChatLogger logger;
    @Nullable
    private PhoneCallType phoneCallingType;
    @Nullable
    private List<String> quickReplies;
    @Nullable
    private Boolean showSenderName;
    @Nullable
    private Boolean stackFromEnd;
    @Nullable
    private Translations translations;
    @Nullable
    private UserRegistrationData userRegistrationData;

    @Deprecated(message = "Deprecated since 6.4.0. It will be removed in future releases in lieu of remote feature flags.")
    public static /* synthetic */ void getHideAdminMessages$annotations() {
    }

    @Deprecated(message = "Deprecated since 6.4.0. It will be removed in future releases in lieu of remote feature flags.")
    public static /* synthetic */ void getShowSenderName$annotations() {
    }

    @Deprecated(message = "Deprecated since 6.6.0. It will be removed in future releases in lieu of remote feature flags.")
    public static /* synthetic */ void isFWFEnabled$annotations() {
    }

    @Deprecated(message = "Deprecated since 6.6.0. It will be removed in future releases in lieu of remote feature flags.")
    public static /* synthetic */ void isLocationSharingEnabled$annotations() {
    }

    @Deprecated(message = "Deprecated since 6.6.0. It will be removed in future releases in lieu of remote feature flags.")
    public static /* synthetic */ void isPhotoSharingEnabled$annotations() {
    }

    @Deprecated(message = "Deprecated since 6.2.0. It will be removed in future releases.")
    public static /* synthetic */ void isReplyingMandatory$annotations() {
    }

    @Deprecated(message = "Deprecated since 6.6.0. It will be removed in future releases in lieu of remote feature flags.")
    public static /* synthetic */ void isTrackingEnabled$annotations() {
    }

    @NotNull
    public final CustomerChatConfigurationBuilder channelId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, RemoteMessageConst.Notification.CHANNEL_ID);
        this.channelId = str;
        return this;
    }

    @NotNull
    public final CustomerChatConfigurationBuilder clientConfig(@NotNull ClientConfig clientConfig2) {
        Intrinsics.checkNotNullParameter(clientConfig2, "clientConfig");
        this.clientConfig = clientConfig2;
        return this;
    }

    @NotNull
    public final CustomerChatConfigurationBuilder deliveryInfo(@NotNull DeliveryInfo deliveryInfo2) {
        Intrinsics.checkNotNullParameter(deliveryInfo2, "deliveryInfo");
        this.deliveryInfo = deliveryInfo2;
        return this;
    }

    @NotNull
    @Deprecated(message = "Deprecated since 6.6.0. It will be removed in future releases in lieu of remote feature flags.")
    public final CustomerChatConfigurationBuilder enableTracking(boolean z11) {
        this.isTrackingEnabled = Boolean.valueOf(z11);
        return this;
    }

    @NotNull
    public final CustomerChatConfigurationBuilder enableVoipLogging(boolean z11) {
        this.enableVoipLogging = Boolean.valueOf(z11);
        return this;
    }

    @Nullable
    public final String getChannelId() {
        return this.channelId;
    }

    @Nullable
    public final ClientConfig getClientConfig() {
        return this.clientConfig;
    }

    @Nullable
    public final DeliveryInfo getDeliveryInfo() {
        return this.deliveryInfo;
    }

    @Nullable
    public final Boolean getEnableVoipLogging() {
        return this.enableVoipLogging;
    }

    @Nullable
    public final Boolean getHideAdminMessages() {
        return this.hideAdminMessages;
    }

    @Nullable
    public final LocationProvider getLocationProvider() {
        return this.locationProvider;
    }

    @Nullable
    public final ChatLogger getLogger() {
        return this.logger;
    }

    @Nullable
    public final PhoneCallType getPhoneCallingType() {
        return this.phoneCallingType;
    }

    @Nullable
    public final List<String> getQuickReplies() {
        return this.quickReplies;
    }

    @Nullable
    public final Boolean getShowSenderName() {
        return this.showSenderName;
    }

    @Nullable
    public final Boolean getStackFromEnd() {
        return this.stackFromEnd;
    }

    @Nullable
    public final Translations getTranslations() {
        return this.translations;
    }

    @Nullable
    public final UserRegistrationData getUserRegistrationData() {
        return this.userRegistrationData;
    }

    @NotNull
    @Deprecated(message = "Deprecated since 6.4.0. It will be removed in future releases in lieu of remote feature flags.")
    public final CustomerChatConfigurationBuilder hideAdminMessages(boolean z11) {
        this.hideAdminMessages = Boolean.valueOf(z11);
        return this;
    }

    @Nullable
    public final Boolean isFWFEnabled() {
        return this.isFWFEnabled;
    }

    @Nullable
    public final Boolean isLocationSharingEnabled() {
        return this.isLocationSharingEnabled;
    }

    @Nullable
    public final Boolean isPhotoSharingEnabled() {
        return this.isPhotoSharingEnabled;
    }

    @Nullable
    public final Boolean isReplyingMandatory() {
        return this.isReplyingMandatory;
    }

    @Nullable
    public final Boolean isTrackingEnabled() {
        return this.isTrackingEnabled;
    }

    @NotNull
    public final CustomerChatConfigurationBuilder logger(@NotNull ChatLogger chatLogger) {
        Intrinsics.checkNotNullParameter(chatLogger, "logger");
        this.logger = chatLogger;
        return this;
    }

    @NotNull
    public final CustomerChatConfigurationBuilder phoneCallingType(@NotNull PhoneCallType phoneCallType) {
        Intrinsics.checkNotNullParameter(phoneCallType, "phoneCallingType");
        this.phoneCallingType = phoneCallType;
        return this;
    }

    @NotNull
    public final CustomerChatConfigurationBuilder quickReplies(@NotNull List<String> list) {
        Intrinsics.checkNotNullParameter(list, "quickReplies");
        this.quickReplies = list;
        return this;
    }

    /* renamed from: setLocationProvider  reason: collision with other method in class */
    public final void m8174setLocationProvider(@Nullable LocationProvider locationProvider2) {
        this.locationProvider = locationProvider2;
    }

    @NotNull
    @Deprecated(message = "Deprecated since 6.4.0. It will be removed in future releases in lieu of remote feature flags.")
    public final CustomerChatConfigurationBuilder showSenderName(boolean z11) {
        this.showSenderName = Boolean.valueOf(z11);
        return this;
    }

    @NotNull
    public final CustomerChatConfigurationBuilder stackFromEnd(boolean z11) {
        this.stackFromEnd = Boolean.valueOf(z11);
        return this;
    }

    @NotNull
    public final CustomerChatConfigurationBuilder translations(@NotNull Translations translations2) {
        Intrinsics.checkNotNullParameter(translations2, "translations");
        this.translations = translations2;
        return this;
    }

    @NotNull
    public final CustomerChatConfigurationBuilder userRegistrationData(@NotNull UserRegistrationData userRegistrationData2) {
        Intrinsics.checkNotNullParameter(userRegistrationData2, "userRegistrationData");
        this.userRegistrationData = userRegistrationData2;
        return this;
    }

    @NotNull
    @Deprecated(message = "Deprecated since 6.6.0. It will be removed in future releases and by default will be set to true.")
    public final CustomerChatConfigurationBuilder isFWFEnabled(boolean z11) {
        this.isFWFEnabled = Boolean.valueOf(z11);
        return this;
    }

    @NotNull
    @Deprecated(message = "Deprecated since 6.6.0. It will be removed in future releases in lieu of remote feature flags.")
    public final CustomerChatConfigurationBuilder isLocationSharingEnabled(boolean z11) {
        this.isLocationSharingEnabled = Boolean.valueOf(z11);
        return this;
    }

    @NotNull
    @Deprecated(message = "Deprecated since 6.6.0. It will be removed in future releases in lieu of remote feature flags.")
    public final CustomerChatConfigurationBuilder isPhotoSharingEnabled(boolean z11) {
        this.isPhotoSharingEnabled = Boolean.valueOf(z11);
        return this;
    }

    @NotNull
    @Deprecated(message = "Deprecated since 6.4.0. It will be removed in future releases in lieu of remote feature flags.")
    public final CustomerChatConfigurationBuilder isReplyingMandatory(boolean z11) {
        this.isReplyingMandatory = Boolean.valueOf(z11);
        return this;
    }

    @NotNull
    public final CustomerChatConfigurationBuilder setLocationProvider(@Nullable LocationProvider locationProvider2) {
        this.locationProvider = locationProvider2;
        return this;
    }
}
