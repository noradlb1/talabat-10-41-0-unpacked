package com.talabat.chat.api.impl;

import android.app.Application;
import android.content.Context;
import androidx.annotation.VisibleForTesting;
import com.deliveryhero.contract.configuration.CustomerChatConfigurationBuilder;
import com.deliveryhero.contract.configuration.UserRegistrationData;
import com.deliveryhero.contract.model.ClientConfig;
import com.deliveryhero.contract.model.DeliveryInfo;
import com.deliveryhero.contract.model.DhEnvironment;
import com.deliveryhero.contract.model.TokenType;
import com.deliveryhero.contract.model.Translations;
import com.deliveryhero.contract.model.UserInfo;
import com.deliveryhero.contract.model.UserType;
import com.deliveryhero.customerchat.CustomerChatModule;
import com.google.android.exoplayer2.util.MimeTypes;
import com.talabat.authentication.token.data.local.impl.LegacyTokenLocalDataSourceImpl;
import com.talabat.chat.api.ChatApi;
import com.talabat.chat.domain.ChatDeliveryInfo;
import com.talabat.chat.domain.ChatException;
import com.talabat.chat.domain.ChatPushData;
import com.talabat.chat.domain.ChatUser;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.country.Country;
import com.talabat.core.buildconfig.TalabatEnvironment;
import com.talabat.observability.ObservabilityManager;
import com.talabat.observability.common.BackgroundAction;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.compress.archivers.ArchiveStreamFactory;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0007\u0018\u0000 ?2\u00020\u0001:\u0001?B/\b\u0002\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJH\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\t2\u0016\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\t0\u001aj\b\u0012\u0004\u0012\u00020\t`\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\b\u001a\u00020\tH\u0002J\u0010\u0010 \u001a\u00020!2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0018\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\t2\u0006\u0010%\u001a\u00020\tH\u0002J\u0014\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0'H\u0002J\b\u0010(\u001a\u00020\tH\u0002J\u0010\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,H\u0002J\b\u0010-\u001a\u00020\u0001H\u0016J\b\u0010.\u001a\u00020\u001dH\u0002J\u001e\u0010/\u001a\u00020\u001d2\u0014\u00100\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010'H\u0016J\u001c\u00101\u001a\u0002022\u0012\u00100\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0'H\u0016J\b\u00103\u001a\u00020\rH\u0002J2\u00104\u001a\u00020\r2\u0006\u00105\u001a\u00020\t2\f\u00106\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0012\u00107\u001a\u000e\u0012\u0004\u0012\u000209\u0012\u0004\u0012\u00020\r08H\u0016J\u0018\u0010:\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\tH\u0016J\u0016\u0010;\u001a\u00020\r2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0016J\u0016\u0010<\u001a\u00020\r2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0016J\b\u0010=\u001a\u00020\rH\u0002J*\u0010>\u001a\u00020\r2\f\u00106\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0012\u00107\u001a\u000e\u0012\u0004\u0012\u000209\u0012\u0004\u0012\u00020\r08H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\fX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\fX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006@"}, d2 = {"Lcom/talabat/chat/api/impl/RiderChatApi;", "Lcom/talabat/chat/api/ChatApi;", "application", "Landroid/app/Application;", "riderChatModule", "Lcom/deliveryhero/customerchat/CustomerChatModule;", "configurationLocalRepository", "Lcom/talabat/configuration/ConfigurationLocalRepository;", "globalEntityID", "", "(Landroid/app/Application;Lcom/deliveryhero/customerchat/CustomerChatModule;Lcom/talabat/configuration/ConfigurationLocalRepository;Ljava/lang/String;)V", "callEventHandler", "Lkotlin/Function0;", "", "chatClosedEventHandler", "chatOpenedEventHandler", "observabilityContextAttributes", "", "configureChat", "chatUser", "Lcom/talabat/chat/domain/ChatUser;", "chatDeliveryInfo", "Lcom/talabat/chat/domain/ChatDeliveryInfo;", "chatChannel", "preferredLanguage", "supportedTranslations", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "enableTranslation", "", "getClientConfig", "Lcom/deliveryhero/contract/model/ClientConfig;", "getDeliveryInfo", "Lcom/deliveryhero/contract/model/DeliveryInfo;", "getEnvironment", "Lcom/deliveryhero/contract/model/DhEnvironment;", "instrumentalTestingServer", "buildType", "getObservabilityContextAttributes", "", "getSelectedCountryCodeName", "getUserRegistrationData", "Lcom/deliveryhero/contract/configuration/UserRegistrationData;", "userInfo", "Lcom/deliveryhero/contract/model/UserInfo;", "init", "isAvailableForCountry", "isChatMessage", "data", "parseChatMessage", "Lcom/talabat/chat/domain/ChatPushData;", "prepareEventsSubscription", "registerToken", "token", "onSuccess", "onError", "Lkotlin/Function1;", "", "startChat", "subscribeCallEvent", "subscribeChatOpenedEvent", "trackStartChat", "unregisterToken", "Companion", "com_talabat_core_chat_chat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RiderChatApi implements ChatApi {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @NotNull
    public static final Lazy<RiderChatApi> instance$delegate = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, RiderChatApi$Companion$instance$2.INSTANCE);
    @NotNull
    private final Application application;
    /* access modifiers changed from: private */
    @NotNull
    public Function0<Unit> callEventHandler;
    /* access modifiers changed from: private */
    @NotNull
    public Function0<Unit> chatClosedEventHandler;
    /* access modifiers changed from: private */
    @NotNull
    public Function0<Unit> chatOpenedEventHandler;
    @NotNull
    private final ConfigurationLocalRepository configurationLocalRepository;
    @NotNull
    private final String globalEntityID;
    @NotNull
    private final Map<String, String> observabilityContextAttributes;
    @NotNull
    private final CustomerChatModule riderChatModule;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J(\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007R\u001b\u0010\u0003\u001a\u00020\u00048FX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/talabat/chat/api/impl/RiderChatApi$Companion;", "", "()V", "instance", "Lcom/talabat/chat/api/impl/RiderChatApi;", "getInstance", "()Lcom/talabat/chat/api/impl/RiderChatApi;", "instance$delegate", "Lkotlin/Lazy;", "application", "Landroid/app/Application;", "riderChatModule", "Lcom/deliveryhero/customerchat/CustomerChatModule;", "configurationLocalRepository", "Lcom/talabat/configuration/ConfigurationLocalRepository;", "globalEntityID", "", "com_talabat_core_chat_chat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final RiderChatApi getInstance() {
            return (RiderChatApi) RiderChatApi.instance$delegate.getValue();
        }

        @NotNull
        @VisibleForTesting
        public final RiderChatApi getInstance(@NotNull Application application, @NotNull CustomerChatModule customerChatModule, @NotNull ConfigurationLocalRepository configurationLocalRepository, @NotNull String str) {
            Intrinsics.checkNotNullParameter(application, MimeTypes.BASE_TYPE_APPLICATION);
            Intrinsics.checkNotNullParameter(customerChatModule, "riderChatModule");
            Intrinsics.checkNotNullParameter(configurationLocalRepository, "configurationLocalRepository");
            Intrinsics.checkNotNullParameter(str, "globalEntityID");
            return new RiderChatApi(application, customerChatModule, configurationLocalRepository, str, (DefaultConstructorMarker) null);
        }
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Country.values().length];
            iArr[Country.KUWAIT.ordinal()] = 1;
            iArr[Country.BAHRAIN.ordinal()] = 2;
            iArr[Country.UAE.ordinal()] = 3;
            iArr[Country.OMAN.ordinal()] = 4;
            iArr[Country.QATAR.ordinal()] = 5;
            iArr[Country.JORDAN.ordinal()] = 6;
            iArr[Country.EGYPT.ordinal()] = 7;
            iArr[Country.IRAQ.ordinal()] = 8;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private RiderChatApi(Application application2, CustomerChatModule customerChatModule, ConfigurationLocalRepository configurationLocalRepository2, String str) {
        this.application = application2;
        this.riderChatModule = customerChatModule;
        this.configurationLocalRepository = configurationLocalRepository2;
        this.globalEntityID = str;
        this.callEventHandler = RiderChatApi$callEventHandler$1.INSTANCE;
        this.chatOpenedEventHandler = RiderChatApi$chatOpenedEventHandler$1.INSTANCE;
        this.chatClosedEventHandler = RiderChatApi$chatClosedEventHandler$1.INSTANCE;
        this.observabilityContextAttributes = new LinkedHashMap();
    }

    public /* synthetic */ RiderChatApi(Application application2, CustomerChatModule customerChatModule, ConfigurationLocalRepository configurationLocalRepository2, String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(application2, customerChatModule, configurationLocalRepository2, str);
    }

    private final ClientConfig getClientConfig(String str) {
        return new ClientConfig(getSelectedCountryCodeName(), str, UserType.CUSTOMER, TokenType.GOOGLE, getEnvironment(TalabatEnvironment.INSTANCE.getEnvironment(), "release"));
    }

    private final DeliveryInfo getDeliveryInfo(ChatDeliveryInfo chatDeliveryInfo) {
        return new DeliveryInfo(1234, chatDeliveryInfo.getCode(), chatDeliveryInfo.getAmount(), chatDeliveryInfo.getAddress(), chatDeliveryInfo.getComments(), chatDeliveryInfo.getCustomer(), chatDeliveryInfo.getPhoneNumber());
    }

    private final DhEnvironment getEnvironment(String str, String str2) {
        if (Intrinsics.areEqual((Object) str, (Object) "prod") || Intrinsics.areEqual((Object) str2, (Object) "release")) {
            return DhEnvironment.PRODUCTION;
        }
        if (Intrinsics.areEqual((Object) str, (Object) "mock")) {
            return DhEnvironment.TESTING;
        }
        return DhEnvironment.STAGING;
    }

    private final Map<String, String> getObservabilityContextAttributes() {
        this.observabilityContextAttributes.putAll(MapsKt__MapsJVMKt.mapOf(TuplesKt.to("country", this.configurationLocalRepository.selectedCountry().getTwoLetterCode())));
        return this.observabilityContextAttributes;
    }

    private final String getSelectedCountryCodeName() {
        return this.configurationLocalRepository.selectedCountry().getTwoLetterCode();
    }

    private final UserRegistrationData getUserRegistrationData(UserInfo userInfo) {
        return new UserRegistrationData(userInfo, RiderChatApi$getUserRegistrationData$1.INSTANCE, RiderChatApi$getUserRegistrationData$2.INSTANCE);
    }

    private final boolean isAvailableForCountry() {
        switch (WhenMappings.$EnumSwitchMapping$0[this.configurationLocalRepository.selectedCountry().ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                return true;
            default:
                return false;
        }
    }

    private final void prepareEventsSubscription() {
        if (isAvailableForCountry()) {
            this.riderChatModule.registerEvents(new RiderChatApi$prepareEventsSubscription$1(this));
        }
    }

    private final void trackStartChat() {
        ObservabilityManager.trackEvent(BackgroundAction.START_SEND_BIRD_CHAT, getObservabilityContextAttributes());
    }

    public void configureChat(@NotNull ChatUser chatUser, @NotNull ChatDeliveryInfo chatDeliveryInfo, @NotNull String str, @NotNull String str2, @NotNull ArrayList<String> arrayList, boolean z11) {
        Intrinsics.checkNotNullParameter(chatUser, "chatUser");
        Intrinsics.checkNotNullParameter(chatDeliveryInfo, "chatDeliveryInfo");
        Intrinsics.checkNotNullParameter(str, "chatChannel");
        Intrinsics.checkNotNullParameter(str2, "preferredLanguage");
        Intrinsics.checkNotNullParameter(arrayList, "supportedTranslations");
        UserRegistrationData userRegistrationData = getUserRegistrationData(new UserInfo(chatUser.getId(), chatUser.getDhAuthToken()));
        if (!this.riderChatModule.isChatOpen() && isAvailableForCountry()) {
            this.riderChatModule.setConfiguration(new CustomerChatConfigurationBuilder().channelId(str).userRegistrationData(userRegistrationData).clientConfig(getClientConfig(this.globalEntityID)).deliveryInfo(getDeliveryInfo(chatDeliveryInfo)).stackFromEnd(true).translations(new Translations.ENABLED(CollectionsKt__CollectionsKt.listOf(ArchiveStreamFactory.AR, "en"), "en", true)));
        }
    }

    @NotNull
    public ChatApi init() {
        prepareEventsSubscription();
        return this;
    }

    public boolean isChatMessage(@Nullable Map<String, String> map) {
        return this.riderChatModule.isChatModuleMessage(map);
    }

    @NotNull
    public ChatPushData parseChatMessage(@NotNull Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, "data");
        com.deliveryhero.contract.model.ChatPushData parseMessage = this.riderChatModule.parseMessage(map);
        String senderName = parseMessage.getSenderName();
        String pushAlert = parseMessage.getPushAlert();
        if (pushAlert == null) {
            pushAlert = "";
        }
        return new ChatPushData(senderName, pushAlert, parseMessage.getMessage());
    }

    public void registerToken(@NotNull String str, @NotNull Function0<Unit> function0, @NotNull Function1<? super Throwable, Unit> function1) {
        Intrinsics.checkNotNullParameter(str, LegacyTokenLocalDataSourceImpl.KEY);
        Intrinsics.checkNotNullParameter(function0, "onSuccess");
        Intrinsics.checkNotNullParameter(function1, "onError");
        if (!this.riderChatModule.isChatOpen() && isAvailableForCountry()) {
            this.riderChatModule.setConfiguration(new CustomerChatConfigurationBuilder().clientConfig(getClientConfig(this.globalEntityID)));
            this.riderChatModule.registerToken(str, function0, function1);
        }
    }

    public void startChat(@NotNull ChatDeliveryInfo chatDeliveryInfo, @NotNull String str) {
        Intrinsics.checkNotNullParameter(chatDeliveryInfo, "chatDeliveryInfo");
        Intrinsics.checkNotNullParameter(str, "chatChannel");
        try {
            trackStartChat();
            CustomerChatModule customerChatModule = this.riderChatModule;
            Context applicationContext = this.application.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "application.applicationContext");
            CustomerChatModule.startChat$default(customerChatModule, applicationContext, str, getDeliveryInfo(chatDeliveryInfo), (Function1) null, 8, (Object) null);
        } catch (ChatException e11) {
            String str2 = "Failed to startChat due to " + e11.getMessage();
            ObservabilityManager.trackUnExpectedScenario(str2, getObservabilityContextAttributes());
            throw new ChatException(str2);
        }
    }

    public void subscribeCallEvent(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "callEventHandler");
        this.callEventHandler = function0;
    }

    public void subscribeChatOpenedEvent(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "chatOpenedEventHandler");
        this.chatOpenedEventHandler = function0;
    }

    public void unregisterToken(@NotNull Function0<Unit> function0, @NotNull Function1<? super Throwable, Unit> function1) {
        Intrinsics.checkNotNullParameter(function0, "onSuccess");
        Intrinsics.checkNotNullParameter(function1, "onError");
        this.riderChatModule.unregisterPush(function0, function1);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ RiderChatApi(android.app.Application r1, com.deliveryhero.customerchat.CustomerChatModule r2, com.talabat.configuration.ConfigurationLocalRepository r3, java.lang.String r4, int r5, kotlin.jvm.internal.DefaultConstructorMarker r6) {
        /*
            r0 = this;
            r6 = r5 & 1
            if (r6 == 0) goto L_0x000a
            com.talabat.talabatcore.application.BaseApplication$Companion r1 = com.talabat.talabatcore.application.BaseApplication.Companion
            com.talabat.talabatcore.application.BaseApplication r1 = r1.getInstance()
        L_0x000a:
            r6 = r5 & 2
            if (r6 == 0) goto L_0x0014
            com.deliveryhero.customerchat.CustomerChatModule$Companion r2 = com.deliveryhero.customerchat.CustomerChatModule.Companion
            com.deliveryhero.customerchat.CustomerChatModule r2 = r2.getInstance(r1)
        L_0x0014:
            r6 = r5 & 4
            if (r6 == 0) goto L_0x001d
            com.talabat.configuration.LegacyConfigurationLocalRepository r3 = new com.talabat.configuration.LegacyConfigurationLocalRepository
            r3.<init>()
        L_0x001d:
            r5 = r5 & 8
            if (r5 == 0) goto L_0x0032
            tracking.GoogleAdvertisingIdClientHelper r4 = tracking.GoogleAdvertisingIdClientHelper.getInstance()
            android.content.Context r5 = r1.getApplicationContext()
            java.lang.String r4 = r4.googleAdvertId(r5)
            java.lang.String r5 = "getInstance().googleAdve…ation.applicationContext)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)
        L_0x0032:
            r0.<init>(r1, r2, r3, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.chat.api.impl.RiderChatApi.<init>(android.app.Application, com.deliveryhero.customerchat.CustomerChatModule, com.talabat.configuration.ConfigurationLocalRepository, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
