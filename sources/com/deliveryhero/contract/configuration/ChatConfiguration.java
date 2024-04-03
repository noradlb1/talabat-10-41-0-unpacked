package com.deliveryhero.contract.configuration;

import androidx.annotation.StyleRes;
import com.deliveryhero.contract.model.ClientConfig;
import com.deliveryhero.contract.model.DeliveryInfo;
import com.deliveryhero.contract.model.PhoneCallType;
import com.deliveryhero.contract.model.Translations;
import com.deliveryhero.contract.model.UserInfo;
import com.deliveryhero.contract.util.ExtensionsKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b'\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 e2\u00020\u0001:\u0001eB½\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u000b\u0012\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0017\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u000b\u0012\b\b\u0003\u0010\u001a\u001a\u00020\u001b¢\u0006\u0002\u0010\u001cJ\u000e\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020EJ\u000b\u0010F\u001a\u0004\u0018\u00010\u0003HÂ\u0003J\t\u0010G\u001a\u00020\u000bHÂ\u0003J\t\u0010H\u001a\u00020\u000bHÂ\u0003J\t\u0010I\u001a\u00020\u000bHÂ\u0003J\t\u0010J\u001a\u00020\u0015HÂ\u0003J\t\u0010K\u001a\u00020\u0017HÂ\u0003J\t\u0010L\u001a\u00020\u000bHÂ\u0003J\t\u0010M\u001a\u00020\u000bHÂ\u0003J\t\u0010N\u001a\u00020\u001bHÆ\u0003J\u000b\u0010O\u001a\u0004\u0018\u00010\u0005HÂ\u0003J\u000b\u0010P\u001a\u0004\u0018\u00010\u0007HÂ\u0003J\u000b\u0010Q\u001a\u0004\u0018\u00010\tHÂ\u0003J\t\u0010R\u001a\u00020\u000bHÂ\u0003J\t\u0010S\u001a\u00020\u000bHÂ\u0003J\t\u0010T\u001a\u00020\u000bHÂ\u0003J\u000f\u0010U\u001a\b\u0012\u0004\u0012\u00020\u00070\u000fHÂ\u0003J\t\u0010V\u001a\u00020\u000bHÂ\u0003JÁ\u0001\u0010W\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000b2\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000b2\b\b\u0002\u0010\u0011\u001a\u00020\u000b2\b\b\u0002\u0010\u0012\u001a\u00020\u000b2\b\b\u0002\u0010\u0013\u001a\u00020\u000b2\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u000b2\b\b\u0002\u0010\u0019\u001a\u00020\u000b2\b\b\u0003\u0010\u001a\u001a\u00020\u001bHÆ\u0001J\u0013\u0010X\u001a\u00020\u000b2\b\u0010Y\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u000e\u0010Z\u001a\u00020C2\u0006\u0010[\u001a\u00020\u0000J\b\u0010\\\u001a\u0004\u0018\u00010\u0007J\b\u0010]\u001a\u0004\u0018\u00010\tJ\b\u0010^\u001a\u0004\u0018\u00010\u0003J\t\u0010_\u001a\u00020\u001bHÖ\u0001J\u0010\u0010`\u001a\u00020\u00072\u0006\u0010a\u001a\u00020\u0007H\u0002J\u0006\u0010b\u001a\u00020cJ\t\u0010d\u001a\u00020\u0007HÖ\u0001R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u001d\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010 \u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u0013\u0010#\u001a\u0004\u0018\u00010\u00058F¢\u0006\u0006\u001a\u0004\b$\u0010%R\u0011\u0010&\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b'\u0010(R\u0011\u0010)\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b)\u0010(R\u0011\u0010*\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b*\u0010(R\u0011\u0010+\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b+\u0010(R\u0011\u0010,\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b,\u0010(R\u0011\u0010-\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b-\u0010(R\u0011\u0010.\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b.\u0010(R\u0011\u0010/\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b/\u0010(R\u0011\u00100\u001a\u00020\u00158F¢\u0006\u0006\u001a\u0004\b1\u00102R\u0017\u00103\u001a\b\u0012\u0004\u0012\u00020\u00070\u000f8F¢\u0006\u0006\u001a\u0004\b4\u00105R\u0011\u00106\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b7\u0010(R\u001a\u0010\u001a\u001a\u00020\u001bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u0011\u0010<\u001a\u00020\u00178F¢\u0006\u0006\u001a\u0004\b=\u0010>R\u0011\u0010?\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b@\u0010A¨\u0006f"}, d2 = {"Lcom/deliveryhero/contract/configuration/ChatConfiguration;", "", "_userInfo", "Lcom/deliveryhero/contract/model/UserInfo;", "_deliveryInfo", "Lcom/deliveryhero/contract/model/DeliveryInfo;", "_channelId", "", "_clientConfig", "Lcom/deliveryhero/contract/model/ClientConfig;", "_enableVoipLogging", "", "_stackFromEnd", "_isReplyingMandatory", "_quickReplies", "", "_isPhotoSharingEnabled", "_hideAdminMessages", "_showSenderName", "_isLocationSharingEnabled", "_phoneCallingType", "Lcom/deliveryhero/contract/model/PhoneCallType;", "_translations", "Lcom/deliveryhero/contract/model/Translations;", "_isTrackingEnabled", "_isFWFEnabled", "themeResID", "", "(Lcom/deliveryhero/contract/model/UserInfo;Lcom/deliveryhero/contract/model/DeliveryInfo;Ljava/lang/String;Lcom/deliveryhero/contract/model/ClientConfig;ZZZLjava/util/List;ZZZZLcom/deliveryhero/contract/model/PhoneCallType;Lcom/deliveryhero/contract/model/Translations;ZZI)V", "channelId", "getChannelId", "()Ljava/lang/String;", "clientConfig", "getClientConfig", "()Lcom/deliveryhero/contract/model/ClientConfig;", "deliveryInfo", "getDeliveryInfo", "()Lcom/deliveryhero/contract/model/DeliveryInfo;", "enableVoipLogging", "getEnableVoipLogging", "()Z", "isFWFEnabled", "isHideAdminMessagesEnabled", "isLocationSharingEnabled", "isPhotoSharingEnabled", "isReplyingMandatory", "isShowSenderNameEnabled", "isTrackingEnabled", "phoneCallingType", "getPhoneCallingType", "()Lcom/deliveryhero/contract/model/PhoneCallType;", "quickReplies", "getQuickReplies", "()Ljava/util/List;", "stackFromEnd", "getStackFromEnd", "getThemeResID", "()I", "setThemeResID", "(I)V", "translations", "getTranslations", "()Lcom/deliveryhero/contract/model/Translations;", "userInfo", "getUserInfo", "()Lcom/deliveryhero/contract/model/UserInfo;", "apply", "", "configBuilder", "Lcom/deliveryhero/contract/configuration/CustomerChatConfigurationBuilder;", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "forceApplyConfig", "chatConfiguration", "getChannelIDOrNull", "getClientConfigOrNull", "getUserInfoOrNull", "hashCode", "requiredMessage", "field", "toPersistableChatConfiguration", "Lcom/deliveryhero/contract/configuration/PersistableChatConfiguration;", "toString", "Companion", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ChatConfiguration {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @NotNull
    public static final ChatConfiguration DEFAULT_CHAT_CONFIGURATION = new ChatConfiguration((UserInfo) null, (DeliveryInfo) null, (String) null, (ClientConfig) null, false, false, false, (List) null, false, false, false, false, (PhoneCallType) null, (Translations) null, false, false, 0, 131071, (DefaultConstructorMarker) null);
    @Nullable
    private String _channelId;
    @Nullable
    private ClientConfig _clientConfig;
    @Nullable
    private DeliveryInfo _deliveryInfo;
    private boolean _enableVoipLogging;
    private boolean _hideAdminMessages;
    private boolean _isFWFEnabled;
    private boolean _isLocationSharingEnabled;
    private boolean _isPhotoSharingEnabled;
    private boolean _isReplyingMandatory;
    private boolean _isTrackingEnabled;
    @NotNull
    private PhoneCallType _phoneCallingType;
    @NotNull
    private List<String> _quickReplies;
    private boolean _showSenderName;
    private boolean _stackFromEnd;
    @NotNull
    private Translations _translations;
    @Nullable
    private UserInfo _userInfo;
    private int themeResID;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/deliveryhero/contract/configuration/ChatConfiguration$Companion;", "", "()V", "DEFAULT_CHAT_CONFIGURATION", "Lcom/deliveryhero/contract/configuration/ChatConfiguration;", "getDEFAULT_CHAT_CONFIGURATION$customerchat_basicRelease", "()Lcom/deliveryhero/contract/configuration/ChatConfiguration;", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ChatConfiguration getDEFAULT_CHAT_CONFIGURATION$customerchat_basicRelease() {
            return ChatConfiguration.DEFAULT_CHAT_CONFIGURATION;
        }
    }

    public ChatConfiguration() {
        this((UserInfo) null, (DeliveryInfo) null, (String) null, (ClientConfig) null, false, false, false, (List) null, false, false, false, false, (PhoneCallType) null, (Translations) null, false, false, 0, 131071, (DefaultConstructorMarker) null);
    }

    public ChatConfiguration(@Nullable UserInfo userInfo, @Nullable DeliveryInfo deliveryInfo, @Nullable String str, @Nullable ClientConfig clientConfig, boolean z11, boolean z12, boolean z13, @NotNull List<String> list, boolean z14, boolean z15, boolean z16, boolean z17, @NotNull PhoneCallType phoneCallType, @NotNull Translations translations, boolean z18, boolean z19, @StyleRes int i11) {
        PhoneCallType phoneCallType2 = phoneCallType;
        Translations translations2 = translations;
        Intrinsics.checkNotNullParameter(list, "_quickReplies");
        Intrinsics.checkNotNullParameter(phoneCallType2, "_phoneCallingType");
        Intrinsics.checkNotNullParameter(translations2, "_translations");
        this._userInfo = userInfo;
        this._deliveryInfo = deliveryInfo;
        this._channelId = str;
        this._clientConfig = clientConfig;
        this._enableVoipLogging = z11;
        this._stackFromEnd = z12;
        this._isReplyingMandatory = z13;
        this._quickReplies = list;
        this._isPhotoSharingEnabled = z14;
        this._hideAdminMessages = z15;
        this._showSenderName = z16;
        this._isLocationSharingEnabled = z17;
        this._phoneCallingType = phoneCallType2;
        this._translations = translations2;
        this._isTrackingEnabled = z18;
        this._isFWFEnabled = z19;
        this.themeResID = i11;
    }

    private final UserInfo component1() {
        return this._userInfo;
    }

    private final boolean component10() {
        return this._hideAdminMessages;
    }

    private final boolean component11() {
        return this._showSenderName;
    }

    private final boolean component12() {
        return this._isLocationSharingEnabled;
    }

    private final PhoneCallType component13() {
        return this._phoneCallingType;
    }

    private final Translations component14() {
        return this._translations;
    }

    private final boolean component15() {
        return this._isTrackingEnabled;
    }

    private final boolean component16() {
        return this._isFWFEnabled;
    }

    private final DeliveryInfo component2() {
        return this._deliveryInfo;
    }

    private final String component3() {
        return this._channelId;
    }

    private final ClientConfig component4() {
        return this._clientConfig;
    }

    private final boolean component5() {
        return this._enableVoipLogging;
    }

    private final boolean component6() {
        return this._stackFromEnd;
    }

    private final boolean component7() {
        return this._isReplyingMandatory;
    }

    private final List<String> component8() {
        return this._quickReplies;
    }

    private final boolean component9() {
        return this._isPhotoSharingEnabled;
    }

    public static /* synthetic */ ChatConfiguration copy$default(ChatConfiguration chatConfiguration, UserInfo userInfo, DeliveryInfo deliveryInfo, String str, ClientConfig clientConfig, boolean z11, boolean z12, boolean z13, List list, boolean z14, boolean z15, boolean z16, boolean z17, PhoneCallType phoneCallType, Translations translations, boolean z18, boolean z19, int i11, int i12, Object obj) {
        ChatConfiguration chatConfiguration2 = chatConfiguration;
        int i13 = i12;
        return chatConfiguration.copy((i13 & 1) != 0 ? chatConfiguration2._userInfo : userInfo, (i13 & 2) != 0 ? chatConfiguration2._deliveryInfo : deliveryInfo, (i13 & 4) != 0 ? chatConfiguration2._channelId : str, (i13 & 8) != 0 ? chatConfiguration2._clientConfig : clientConfig, (i13 & 16) != 0 ? chatConfiguration2._enableVoipLogging : z11, (i13 & 32) != 0 ? chatConfiguration2._stackFromEnd : z12, (i13 & 64) != 0 ? chatConfiguration2._isReplyingMandatory : z13, (i13 & 128) != 0 ? chatConfiguration2._quickReplies : list, (i13 & 256) != 0 ? chatConfiguration2._isPhotoSharingEnabled : z14, (i13 & 512) != 0 ? chatConfiguration2._hideAdminMessages : z15, (i13 & 1024) != 0 ? chatConfiguration2._showSenderName : z16, (i13 & 2048) != 0 ? chatConfiguration2._isLocationSharingEnabled : z17, (i13 & 4096) != 0 ? chatConfiguration2._phoneCallingType : phoneCallType, (i13 & 8192) != 0 ? chatConfiguration2._translations : translations, (i13 & 16384) != 0 ? chatConfiguration2._isTrackingEnabled : z18, (i13 & 32768) != 0 ? chatConfiguration2._isFWFEnabled : z19, (i13 & 65536) != 0 ? chatConfiguration2.themeResID : i11);
    }

    /* access modifiers changed from: private */
    public final String requiredMessage(String str) {
        return "Required field \"" + str + "\" was null or empty.";
    }

    public final void apply(@NotNull CustomerChatConfigurationBuilder customerChatConfigurationBuilder) {
        UserInfo userInfo;
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        boolean z15;
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        Intrinsics.checkNotNullParameter(customerChatConfigurationBuilder, "configBuilder");
        UserRegistrationData userRegistrationData = customerChatConfigurationBuilder.getUserRegistrationData();
        if (userRegistrationData == null || (userInfo = userRegistrationData.getUserInfo()) == null) {
            userInfo = this._userInfo;
        }
        this._userInfo = userInfo;
        DeliveryInfo deliveryInfo = customerChatConfigurationBuilder.getDeliveryInfo();
        if (deliveryInfo == null) {
            deliveryInfo = this._deliveryInfo;
        }
        this._deliveryInfo = deliveryInfo;
        String channelId = customerChatConfigurationBuilder.getChannelId();
        if (channelId == null) {
            channelId = this._channelId;
        }
        this._channelId = channelId;
        ClientConfig clientConfig = customerChatConfigurationBuilder.getClientConfig();
        if (clientConfig == null) {
            clientConfig = this._clientConfig;
        }
        this._clientConfig = clientConfig;
        Boolean enableVoipLogging = customerChatConfigurationBuilder.getEnableVoipLogging();
        if (enableVoipLogging != null) {
            z11 = enableVoipLogging.booleanValue();
        } else {
            z11 = getEnableVoipLogging();
        }
        this._enableVoipLogging = z11;
        Boolean stackFromEnd = customerChatConfigurationBuilder.getStackFromEnd();
        if (stackFromEnd != null) {
            z12 = stackFromEnd.booleanValue();
        } else {
            z12 = getStackFromEnd();
        }
        this._stackFromEnd = z12;
        Boolean isReplyingMandatory = customerChatConfigurationBuilder.isReplyingMandatory();
        if (isReplyingMandatory != null) {
            z13 = isReplyingMandatory.booleanValue();
        } else {
            z13 = isReplyingMandatory();
        }
        this._isReplyingMandatory = z13;
        List<String> quickReplies = customerChatConfigurationBuilder.getQuickReplies();
        if (quickReplies == null) {
            quickReplies = getQuickReplies();
        }
        this._quickReplies = quickReplies;
        Boolean isPhotoSharingEnabled = customerChatConfigurationBuilder.isPhotoSharingEnabled();
        if (isPhotoSharingEnabled != null) {
            z14 = isPhotoSharingEnabled.booleanValue();
        } else {
            z14 = isPhotoSharingEnabled();
        }
        this._isPhotoSharingEnabled = z14;
        Boolean hideAdminMessages = customerChatConfigurationBuilder.getHideAdminMessages();
        if (hideAdminMessages != null) {
            z15 = hideAdminMessages.booleanValue();
        } else {
            z15 = isHideAdminMessagesEnabled();
        }
        this._hideAdminMessages = z15;
        Boolean showSenderName = customerChatConfigurationBuilder.getShowSenderName();
        if (showSenderName != null) {
            z16 = showSenderName.booleanValue();
        } else {
            z16 = isShowSenderNameEnabled();
        }
        this._showSenderName = z16;
        Boolean isLocationSharingEnabled = customerChatConfigurationBuilder.isLocationSharingEnabled();
        if (isLocationSharingEnabled != null) {
            z17 = isLocationSharingEnabled.booleanValue();
        } else {
            z17 = isLocationSharingEnabled();
        }
        this._isLocationSharingEnabled = z17;
        PhoneCallType phoneCallingType = customerChatConfigurationBuilder.getPhoneCallingType();
        if (phoneCallingType == null) {
            phoneCallingType = getPhoneCallingType();
        }
        this._phoneCallingType = phoneCallingType;
        Translations translations = customerChatConfigurationBuilder.getTranslations();
        if (translations == null) {
            translations = getTranslations();
        }
        this._translations = translations;
        Boolean isTrackingEnabled = customerChatConfigurationBuilder.isTrackingEnabled();
        if (isTrackingEnabled != null) {
            z18 = isTrackingEnabled.booleanValue();
        } else {
            z18 = isTrackingEnabled();
        }
        this._isTrackingEnabled = z18;
        Boolean isFWFEnabled = customerChatConfigurationBuilder.isFWFEnabled();
        if (isFWFEnabled != null) {
            z19 = isFWFEnabled.booleanValue();
        } else {
            z19 = isFWFEnabled();
        }
        this._isFWFEnabled = z19;
    }

    public final int component17() {
        return this.themeResID;
    }

    @NotNull
    public final ChatConfiguration copy(@Nullable UserInfo userInfo, @Nullable DeliveryInfo deliveryInfo, @Nullable String str, @Nullable ClientConfig clientConfig, boolean z11, boolean z12, boolean z13, @NotNull List<String> list, boolean z14, boolean z15, boolean z16, boolean z17, @NotNull PhoneCallType phoneCallType, @NotNull Translations translations, boolean z18, boolean z19, @StyleRes int i11) {
        UserInfo userInfo2 = userInfo;
        Intrinsics.checkNotNullParameter(list, "_quickReplies");
        Intrinsics.checkNotNullParameter(phoneCallType, "_phoneCallingType");
        Intrinsics.checkNotNullParameter(translations, "_translations");
        return new ChatConfiguration(userInfo, deliveryInfo, str, clientConfig, z11, z12, z13, list, z14, z15, z16, z17, phoneCallType, translations, z18, z19, i11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ChatConfiguration)) {
            return false;
        }
        ChatConfiguration chatConfiguration = (ChatConfiguration) obj;
        return Intrinsics.areEqual((Object) this._userInfo, (Object) chatConfiguration._userInfo) && Intrinsics.areEqual((Object) this._deliveryInfo, (Object) chatConfiguration._deliveryInfo) && Intrinsics.areEqual((Object) this._channelId, (Object) chatConfiguration._channelId) && Intrinsics.areEqual((Object) this._clientConfig, (Object) chatConfiguration._clientConfig) && this._enableVoipLogging == chatConfiguration._enableVoipLogging && this._stackFromEnd == chatConfiguration._stackFromEnd && this._isReplyingMandatory == chatConfiguration._isReplyingMandatory && Intrinsics.areEqual((Object) this._quickReplies, (Object) chatConfiguration._quickReplies) && this._isPhotoSharingEnabled == chatConfiguration._isPhotoSharingEnabled && this._hideAdminMessages == chatConfiguration._hideAdminMessages && this._showSenderName == chatConfiguration._showSenderName && this._isLocationSharingEnabled == chatConfiguration._isLocationSharingEnabled && Intrinsics.areEqual((Object) this._phoneCallingType, (Object) chatConfiguration._phoneCallingType) && Intrinsics.areEqual((Object) this._translations, (Object) chatConfiguration._translations) && this._isTrackingEnabled == chatConfiguration._isTrackingEnabled && this._isFWFEnabled == chatConfiguration._isFWFEnabled && this.themeResID == chatConfiguration.themeResID;
    }

    public final void forceApplyConfig(@NotNull ChatConfiguration chatConfiguration) {
        Intrinsics.checkNotNullParameter(chatConfiguration, "chatConfiguration");
        this._userInfo = chatConfiguration.getUserInfo();
        this._deliveryInfo = chatConfiguration.getDeliveryInfo();
        this._channelId = chatConfiguration.getChannelId();
        this._clientConfig = chatConfiguration.getClientConfig();
        this._enableVoipLogging = chatConfiguration.getEnableVoipLogging();
        this._stackFromEnd = chatConfiguration.getStackFromEnd();
        this._isReplyingMandatory = chatConfiguration.isReplyingMandatory();
        this._quickReplies = chatConfiguration.getQuickReplies();
        this._isPhotoSharingEnabled = chatConfiguration.isPhotoSharingEnabled();
        this._hideAdminMessages = chatConfiguration.isHideAdminMessagesEnabled();
        this._showSenderName = chatConfiguration.isShowSenderNameEnabled();
        this._isLocationSharingEnabled = chatConfiguration.isLocationSharingEnabled();
        this._phoneCallingType = chatConfiguration.getPhoneCallingType();
        this._translations = chatConfiguration.getTranslations();
        this._isTrackingEnabled = chatConfiguration.isTrackingEnabled();
        this._isFWFEnabled = chatConfiguration.isFWFEnabled();
        this.themeResID = chatConfiguration.themeResID;
    }

    @Nullable
    public final String getChannelIDOrNull() {
        return this._channelId;
    }

    @NotNull
    public final String getChannelId() {
        return ExtensionsKt.requireNotNullOrEmpty(this._channelId, new ChatConfiguration$channelId$1(this));
    }

    @NotNull
    public final ClientConfig getClientConfig() {
        ClientConfig clientConfig = this._clientConfig;
        if (clientConfig != null) {
            return clientConfig;
        }
        throw new IllegalArgumentException(requiredMessage("clientConfig").toString());
    }

    @Nullable
    public final ClientConfig getClientConfigOrNull() {
        return this._clientConfig;
    }

    @Nullable
    public final DeliveryInfo getDeliveryInfo() {
        return this._deliveryInfo;
    }

    public final boolean getEnableVoipLogging() {
        return this._enableVoipLogging;
    }

    @NotNull
    public final PhoneCallType getPhoneCallingType() {
        return this._phoneCallingType;
    }

    @NotNull
    public final List<String> getQuickReplies() {
        return this._quickReplies;
    }

    public final boolean getStackFromEnd() {
        return this._stackFromEnd;
    }

    public final int getThemeResID() {
        return this.themeResID;
    }

    @NotNull
    public final Translations getTranslations() {
        return this._translations;
    }

    @NotNull
    public final UserInfo getUserInfo() {
        UserInfo userInfo = this._userInfo;
        if (userInfo != null) {
            return userInfo;
        }
        throw new IllegalArgumentException(requiredMessage("userInfo").toString());
    }

    @Nullable
    public final UserInfo getUserInfoOrNull() {
        return this._userInfo;
    }

    public int hashCode() {
        UserInfo userInfo = this._userInfo;
        int i11 = 0;
        int hashCode = (userInfo == null ? 0 : userInfo.hashCode()) * 31;
        DeliveryInfo deliveryInfo = this._deliveryInfo;
        int hashCode2 = (hashCode + (deliveryInfo == null ? 0 : deliveryInfo.hashCode())) * 31;
        String str = this._channelId;
        int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        ClientConfig clientConfig = this._clientConfig;
        if (clientConfig != null) {
            i11 = clientConfig.hashCode();
        }
        int i12 = (hashCode3 + i11) * 31;
        boolean z11 = this._enableVoipLogging;
        boolean z12 = true;
        if (z11) {
            z11 = true;
        }
        int i13 = (i12 + (z11 ? 1 : 0)) * 31;
        boolean z13 = this._stackFromEnd;
        if (z13) {
            z13 = true;
        }
        int i14 = (i13 + (z13 ? 1 : 0)) * 31;
        boolean z14 = this._isReplyingMandatory;
        if (z14) {
            z14 = true;
        }
        int hashCode4 = (((i14 + (z14 ? 1 : 0)) * 31) + this._quickReplies.hashCode()) * 31;
        boolean z15 = this._isPhotoSharingEnabled;
        if (z15) {
            z15 = true;
        }
        int i15 = (hashCode4 + (z15 ? 1 : 0)) * 31;
        boolean z16 = this._hideAdminMessages;
        if (z16) {
            z16 = true;
        }
        int i16 = (i15 + (z16 ? 1 : 0)) * 31;
        boolean z17 = this._showSenderName;
        if (z17) {
            z17 = true;
        }
        int i17 = (i16 + (z17 ? 1 : 0)) * 31;
        boolean z18 = this._isLocationSharingEnabled;
        if (z18) {
            z18 = true;
        }
        int hashCode5 = (((((i17 + (z18 ? 1 : 0)) * 31) + this._phoneCallingType.hashCode()) * 31) + this._translations.hashCode()) * 31;
        boolean z19 = this._isTrackingEnabled;
        if (z19) {
            z19 = true;
        }
        int i18 = (hashCode5 + (z19 ? 1 : 0)) * 31;
        boolean z21 = this._isFWFEnabled;
        if (!z21) {
            z12 = z21;
        }
        return ((i18 + (z12 ? 1 : 0)) * 31) + this.themeResID;
    }

    public final boolean isFWFEnabled() {
        return this._isFWFEnabled;
    }

    public final boolean isHideAdminMessagesEnabled() {
        return this._hideAdminMessages;
    }

    public final boolean isLocationSharingEnabled() {
        return this._isLocationSharingEnabled;
    }

    public final boolean isPhotoSharingEnabled() {
        return this._isPhotoSharingEnabled;
    }

    public final boolean isReplyingMandatory() {
        return this._isReplyingMandatory;
    }

    public final boolean isShowSenderNameEnabled() {
        return this._showSenderName;
    }

    public final boolean isTrackingEnabled() {
        return this._isTrackingEnabled;
    }

    public final void setThemeResID(int i11) {
        this.themeResID = i11;
    }

    @NotNull
    public final PersistableChatConfiguration toPersistableChatConfiguration() {
        return new PersistableChatConfiguration(this._userInfo, this._deliveryInfo, this._channelId, this._clientConfig, this._enableVoipLogging, this._stackFromEnd, this._isReplyingMandatory, this._quickReplies, this._isPhotoSharingEnabled, this._hideAdminMessages, this._showSenderName, this._isLocationSharingEnabled, this._phoneCallingType, this._translations, this._isTrackingEnabled, this._isFWFEnabled, this.themeResID);
    }

    @NotNull
    public String toString() {
        return "ChatConfiguration(_userInfo=" + this._userInfo + ", _deliveryInfo=" + this._deliveryInfo + ", _channelId=" + this._channelId + ", _clientConfig=" + this._clientConfig + ", _enableVoipLogging=" + this._enableVoipLogging + ", _stackFromEnd=" + this._stackFromEnd + ", _isReplyingMandatory=" + this._isReplyingMandatory + ", _quickReplies=" + this._quickReplies + ", _isPhotoSharingEnabled=" + this._isPhotoSharingEnabled + ", _hideAdminMessages=" + this._hideAdminMessages + ", _showSenderName=" + this._showSenderName + ", _isLocationSharingEnabled=" + this._isLocationSharingEnabled + ", _phoneCallingType=" + this._phoneCallingType + ", _translations=" + this._translations + ", _isTrackingEnabled=" + this._isTrackingEnabled + ", _isFWFEnabled=" + this._isFWFEnabled + ", themeResID=" + this.themeResID + ')';
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ ChatConfiguration(com.deliveryhero.contract.model.UserInfo r19, com.deliveryhero.contract.model.DeliveryInfo r20, java.lang.String r21, com.deliveryhero.contract.model.ClientConfig r22, boolean r23, boolean r24, boolean r25, java.util.List r26, boolean r27, boolean r28, boolean r29, boolean r30, com.deliveryhero.contract.model.PhoneCallType r31, com.deliveryhero.contract.model.Translations r32, boolean r33, boolean r34, int r35, int r36, kotlin.jvm.internal.DefaultConstructorMarker r37) {
        /*
            r18 = this;
            r0 = r36
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r1 = r2
            goto L_0x000b
        L_0x0009:
            r1 = r19
        L_0x000b:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0011
            r3 = r2
            goto L_0x0013
        L_0x0011:
            r3 = r20
        L_0x0013:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x0019
            r4 = r2
            goto L_0x001b
        L_0x0019:
            r4 = r21
        L_0x001b:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x0020
            goto L_0x0022
        L_0x0020:
            r2 = r22
        L_0x0022:
            r5 = r0 & 16
            if (r5 == 0) goto L_0x0028
            r5 = 0
            goto L_0x002a
        L_0x0028:
            r5 = r23
        L_0x002a:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x0030
            r7 = 1
            goto L_0x0032
        L_0x0030:
            r7 = r24
        L_0x0032:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x0038
            r8 = 0
            goto L_0x003a
        L_0x0038:
            r8 = r25
        L_0x003a:
            r9 = r0 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x0043
            java.util.List r9 = kotlin.collections.CollectionsKt__CollectionsKt.emptyList()
            goto L_0x0045
        L_0x0043:
            r9 = r26
        L_0x0045:
            r10 = r0 & 256(0x100, float:3.59E-43)
            if (r10 == 0) goto L_0x004b
            r10 = 0
            goto L_0x004d
        L_0x004b:
            r10 = r27
        L_0x004d:
            r11 = r0 & 512(0x200, float:7.175E-43)
            if (r11 == 0) goto L_0x0053
            r11 = 0
            goto L_0x0055
        L_0x0053:
            r11 = r28
        L_0x0055:
            r12 = r0 & 1024(0x400, float:1.435E-42)
            if (r12 == 0) goto L_0x005b
            r12 = 0
            goto L_0x005d
        L_0x005b:
            r12 = r29
        L_0x005d:
            r13 = r0 & 2048(0x800, float:2.87E-42)
            if (r13 == 0) goto L_0x0063
            r13 = 0
            goto L_0x0065
        L_0x0063:
            r13 = r30
        L_0x0065:
            r14 = r0 & 4096(0x1000, float:5.74E-42)
            if (r14 == 0) goto L_0x006c
            com.deliveryhero.contract.model.PhoneCallType$None r14 = com.deliveryhero.contract.model.PhoneCallType.None.INSTANCE
            goto L_0x006e
        L_0x006c:
            r14 = r31
        L_0x006e:
            r15 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r15 == 0) goto L_0x0075
            com.deliveryhero.contract.model.Translations$DISABLED r15 = com.deliveryhero.contract.model.Translations.DISABLED.INSTANCE
            goto L_0x0077
        L_0x0075:
            r15 = r32
        L_0x0077:
            r6 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r6 == 0) goto L_0x007d
            r6 = 0
            goto L_0x007f
        L_0x007d:
            r6 = r33
        L_0x007f:
            r16 = 32768(0x8000, float:4.5918E-41)
            r16 = r0 & r16
            if (r16 == 0) goto L_0x0089
            r16 = 0
            goto L_0x008b
        L_0x0089:
            r16 = r34
        L_0x008b:
            r17 = 65536(0x10000, float:9.18355E-41)
            r0 = r0 & r17
            if (r0 == 0) goto L_0x0094
            int r0 = com.deliveryhero.customerchat.R.style.CustomerChatActivityTheme
            goto L_0x0096
        L_0x0094:
            r0 = r35
        L_0x0096:
            r19 = r18
            r20 = r1
            r21 = r3
            r22 = r4
            r23 = r2
            r24 = r5
            r25 = r7
            r26 = r8
            r27 = r9
            r28 = r10
            r29 = r11
            r30 = r12
            r31 = r13
            r32 = r14
            r33 = r15
            r34 = r6
            r35 = r16
            r36 = r0
            r19.<init>(r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.deliveryhero.contract.configuration.ChatConfiguration.<init>(com.deliveryhero.contract.model.UserInfo, com.deliveryhero.contract.model.DeliveryInfo, java.lang.String, com.deliveryhero.contract.model.ClientConfig, boolean, boolean, boolean, java.util.List, boolean, boolean, boolean, boolean, com.deliveryhero.contract.model.PhoneCallType, com.deliveryhero.contract.model.Translations, boolean, boolean, int, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
