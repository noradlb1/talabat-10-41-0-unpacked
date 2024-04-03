package com.deliveryhero.contract.configuration;

import androidx.annotation.StyleRes;
import com.deliveryhero.contract.model.ClientConfig;
import com.deliveryhero.contract.model.ClientConfig$$serializer;
import com.deliveryhero.contract.model.DeliveryInfo;
import com.deliveryhero.contract.model.DeliveryInfo$$serializer;
import com.deliveryhero.contract.model.PhoneCallType;
import com.deliveryhero.contract.model.Translations;
import com.deliveryhero.contract.model.UserInfo;
import com.deliveryhero.contract.model.UserInfo$$serializer;
import com.deliveryhero.customerchat.R;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.json.Json;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b.\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 W2\u00020\u0001:\u0002VWBµ\u0001\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u000f\u001a\u00020\r\u0012\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0011\u0012\u0006\u0010\u0012\u001a\u00020\r\u0012\u0006\u0010\u0013\u001a\u00020\r\u0012\u0006\u0010\u0014\u001a\u00020\r\u0012\u0006\u0010\u0015\u001a\u00020\r\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u0012\u0006\u0010\u001a\u001a\u00020\r\u0012\u0006\u0010\u001b\u001a\u00020\r\u0012\u0006\u0010\u001c\u001a\u00020\u0003\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e¢\u0006\u0002\u0010\u001fB½\u0001\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r\u0012\b\b\u0002\u0010\u000f\u001a\u00020\r\u0012\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\r\u0012\b\b\u0002\u0010\u0013\u001a\u00020\r\u0012\b\b\u0002\u0010\u0014\u001a\u00020\r\u0012\b\b\u0002\u0010\u0015\u001a\u00020\r\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0017\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0019\u0012\b\b\u0002\u0010\u001a\u001a\u00020\r\u0012\b\b\u0002\u0010\u001b\u001a\u00020\r\u0012\b\b\u0003\u0010\u001c\u001a\u00020\u0003¢\u0006\u0002\u0010 J\u000b\u00106\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u00107\u001a\u00020\rHÆ\u0003J\t\u00108\u001a\u00020\rHÆ\u0003J\t\u00109\u001a\u00020\rHÆ\u0003J\t\u0010:\u001a\u00020\u0017HÆ\u0003J\t\u0010;\u001a\u00020\u0019HÆ\u0003J\t\u0010<\u001a\u00020\rHÆ\u0003J\t\u0010=\u001a\u00020\rHÆ\u0003J\t\u0010>\u001a\u00020\u0003HÆ\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010@\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\t\u0010B\u001a\u00020\rHÆ\u0003J\t\u0010C\u001a\u00020\rHÆ\u0003J\t\u0010D\u001a\u00020\rHÆ\u0003J\u000f\u0010E\u001a\b\u0012\u0004\u0012\u00020\t0\u0011HÆ\u0003J\t\u0010F\u001a\u00020\rHÆ\u0003JÁ\u0001\u0010G\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\r2\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\u00112\b\b\u0002\u0010\u0012\u001a\u00020\r2\b\b\u0002\u0010\u0013\u001a\u00020\r2\b\b\u0002\u0010\u0014\u001a\u00020\r2\b\b\u0002\u0010\u0015\u001a\u00020\r2\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\r2\b\b\u0002\u0010\u001b\u001a\u00020\r2\b\b\u0003\u0010\u001c\u001a\u00020\u0003HÆ\u0001J\u0006\u0010H\u001a\u00020\tJ\u0013\u0010I\u001a\u00020\r2\b\u0010J\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010K\u001a\u00020\u0003HÖ\u0001J\u0006\u0010L\u001a\u00020MJ\t\u0010N\u001a\u00020\tHÖ\u0001J!\u0010O\u001a\u00020P2\u0006\u0010Q\u001a\u00020\u00002\u0006\u0010R\u001a\u00020S2\u0006\u0010T\u001a\u00020UHÇ\u0001R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0011\u0010\u0013\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b)\u0010(R\u0011\u0010\u001b\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010(R\u0011\u0010\u0015\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010(R\u0011\u0010\u0012\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010(R\u0011\u0010\u000f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010(R\u0011\u0010\u001a\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010(R\u0011\u0010\u0016\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\u0011¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0011\u0010\u0014\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b.\u0010(R\u0011\u0010\u000e\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b/\u0010(R\u0011\u0010\u001c\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u0011\u0010\u0018\u001a\u00020\u0019¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b4\u00105¨\u0006X"}, d2 = {"Lcom/deliveryhero/contract/configuration/PersistableChatConfiguration;", "", "seen1", "", "userInfo", "Lcom/deliveryhero/contract/model/UserInfo;", "deliveryInfo", "Lcom/deliveryhero/contract/model/DeliveryInfo;", "channelId", "", "clientConfig", "Lcom/deliveryhero/contract/model/ClientConfig;", "enableVoipLogging", "", "stackFromEnd", "isReplyingMandatory", "quickReplies", "", "isPhotoSharingEnabled", "hideAdminMessages", "showSenderName", "isLocationSharingEnabled", "phoneCallingType", "Lcom/deliveryhero/contract/model/PhoneCallType;", "translations", "Lcom/deliveryhero/contract/model/Translations;", "isTrackingEnabled", "isFWFEnabled", "themeResID", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/deliveryhero/contract/model/UserInfo;Lcom/deliveryhero/contract/model/DeliveryInfo;Ljava/lang/String;Lcom/deliveryhero/contract/model/ClientConfig;ZZZLjava/util/List;ZZZZLcom/deliveryhero/contract/model/PhoneCallType;Lcom/deliveryhero/contract/model/Translations;ZZILkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Lcom/deliveryhero/contract/model/UserInfo;Lcom/deliveryhero/contract/model/DeliveryInfo;Ljava/lang/String;Lcom/deliveryhero/contract/model/ClientConfig;ZZZLjava/util/List;ZZZZLcom/deliveryhero/contract/model/PhoneCallType;Lcom/deliveryhero/contract/model/Translations;ZZI)V", "getChannelId", "()Ljava/lang/String;", "getClientConfig", "()Lcom/deliveryhero/contract/model/ClientConfig;", "getDeliveryInfo", "()Lcom/deliveryhero/contract/model/DeliveryInfo;", "getEnableVoipLogging", "()Z", "getHideAdminMessages", "getPhoneCallingType", "()Lcom/deliveryhero/contract/model/PhoneCallType;", "getQuickReplies", "()Ljava/util/List;", "getShowSenderName", "getStackFromEnd", "getThemeResID", "()I", "getTranslations", "()Lcom/deliveryhero/contract/model/Translations;", "getUserInfo", "()Lcom/deliveryhero/contract/model/UserInfo;", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "encode", "equals", "other", "hashCode", "toChatConfiguration", "Lcom/deliveryhero/contract/configuration/ChatConfiguration;", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "$serializer", "Companion", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Serializable
public final class PersistableChatConfiguration {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @Nullable
    private final String channelId;
    @Nullable
    private final ClientConfig clientConfig;
    @Nullable
    private final DeliveryInfo deliveryInfo;
    private final boolean enableVoipLogging;
    private final boolean hideAdminMessages;
    private final boolean isFWFEnabled;
    private final boolean isLocationSharingEnabled;
    private final boolean isPhotoSharingEnabled;
    private final boolean isReplyingMandatory;
    private final boolean isTrackingEnabled;
    @NotNull
    private final PhoneCallType phoneCallingType;
    @NotNull
    private final List<String> quickReplies;
    private final boolean showSenderName;
    private final boolean stackFromEnd;
    private final int themeResID;
    @NotNull
    private final Translations translations;
    @Nullable
    private final UserInfo userInfo;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\bHÆ\u0001¨\u0006\t"}, d2 = {"Lcom/deliveryhero/contract/configuration/PersistableChatConfiguration$Companion;", "", "()V", "decode", "Lcom/deliveryhero/contract/configuration/PersistableChatConfiguration;", "chatConfiguration", "", "serializer", "Lkotlinx/serialization/KSerializer;", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Nullable
        public final PersistableChatConfiguration decode(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "chatConfiguration");
            try {
                return (PersistableChatConfiguration) Json.Default.decodeFromString(serializer(), str);
            } catch (IllegalArgumentException | SerializationException unused) {
                return null;
            }
        }

        @NotNull
        public final KSerializer<PersistableChatConfiguration> serializer() {
            return PersistableChatConfiguration$$serializer.INSTANCE;
        }
    }

    public PersistableChatConfiguration() {
        this((UserInfo) null, (DeliveryInfo) null, (String) null, (ClientConfig) null, false, false, false, (List) null, false, false, false, false, (PhoneCallType) null, (Translations) null, false, false, 0, 131071, (DefaultConstructorMarker) null);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ PersistableChatConfiguration(int i11, UserInfo userInfo2, DeliveryInfo deliveryInfo2, String str, ClientConfig clientConfig2, boolean z11, boolean z12, boolean z13, List list, boolean z14, boolean z15, boolean z16, boolean z17, PhoneCallType phoneCallType, Translations translations2, boolean z18, boolean z19, int i12, SerializationConstructorMarker serializationConstructorMarker) {
        int i13 = i11;
        if ((i13 & 0) != 0) {
            PluginExceptionsKt.throwMissingFieldException(i11, 0, PersistableChatConfiguration$$serializer.INSTANCE.getDescriptor());
        }
        if ((i13 & 1) == 0) {
            this.userInfo = null;
        } else {
            this.userInfo = userInfo2;
        }
        if ((i13 & 2) == 0) {
            this.deliveryInfo = null;
        } else {
            this.deliveryInfo = deliveryInfo2;
        }
        if ((i13 & 4) == 0) {
            this.channelId = null;
        } else {
            this.channelId = str;
        }
        if ((i13 & 8) == 0) {
            this.clientConfig = null;
        } else {
            this.clientConfig = clientConfig2;
        }
        if ((i13 & 16) == 0) {
            this.enableVoipLogging = false;
        } else {
            this.enableVoipLogging = z11;
        }
        this.stackFromEnd = (i13 & 32) == 0 ? true : z12;
        if ((i13 & 64) == 0) {
            this.isReplyingMandatory = false;
        } else {
            this.isReplyingMandatory = z13;
        }
        this.quickReplies = (i13 & 128) == 0 ? CollectionsKt__CollectionsKt.emptyList() : list;
        if ((i13 & 256) == 0) {
            this.isPhotoSharingEnabled = false;
        } else {
            this.isPhotoSharingEnabled = z14;
        }
        if ((i13 & 512) == 0) {
            this.hideAdminMessages = false;
        } else {
            this.hideAdminMessages = z15;
        }
        if ((i13 & 1024) == 0) {
            this.showSenderName = false;
        } else {
            this.showSenderName = z16;
        }
        if ((i13 & 2048) == 0) {
            this.isLocationSharingEnabled = false;
        } else {
            this.isLocationSharingEnabled = z17;
        }
        this.phoneCallingType = (i13 & 4096) == 0 ? PhoneCallType.None.INSTANCE : phoneCallType;
        this.translations = (i13 & 8192) == 0 ? Translations.DISABLED.INSTANCE : translations2;
        if ((i13 & 16384) == 0) {
            this.isTrackingEnabled = false;
        } else {
            this.isTrackingEnabled = z18;
        }
        if ((32768 & i13) == 0) {
            this.isFWFEnabled = false;
        } else {
            this.isFWFEnabled = z19;
        }
        this.themeResID = (i13 & 65536) == 0 ? R.style.CustomerChatActivityTheme : i12;
    }

    public static /* synthetic */ PersistableChatConfiguration copy$default(PersistableChatConfiguration persistableChatConfiguration, UserInfo userInfo2, DeliveryInfo deliveryInfo2, String str, ClientConfig clientConfig2, boolean z11, boolean z12, boolean z13, List list, boolean z14, boolean z15, boolean z16, boolean z17, PhoneCallType phoneCallType, Translations translations2, boolean z18, boolean z19, int i11, int i12, Object obj) {
        PersistableChatConfiguration persistableChatConfiguration2 = persistableChatConfiguration;
        int i13 = i12;
        return persistableChatConfiguration.copy((i13 & 1) != 0 ? persistableChatConfiguration2.userInfo : userInfo2, (i13 & 2) != 0 ? persistableChatConfiguration2.deliveryInfo : deliveryInfo2, (i13 & 4) != 0 ? persistableChatConfiguration2.channelId : str, (i13 & 8) != 0 ? persistableChatConfiguration2.clientConfig : clientConfig2, (i13 & 16) != 0 ? persistableChatConfiguration2.enableVoipLogging : z11, (i13 & 32) != 0 ? persistableChatConfiguration2.stackFromEnd : z12, (i13 & 64) != 0 ? persistableChatConfiguration2.isReplyingMandatory : z13, (i13 & 128) != 0 ? persistableChatConfiguration2.quickReplies : list, (i13 & 256) != 0 ? persistableChatConfiguration2.isPhotoSharingEnabled : z14, (i13 & 512) != 0 ? persistableChatConfiguration2.hideAdminMessages : z15, (i13 & 1024) != 0 ? persistableChatConfiguration2.showSenderName : z16, (i13 & 2048) != 0 ? persistableChatConfiguration2.isLocationSharingEnabled : z17, (i13 & 4096) != 0 ? persistableChatConfiguration2.phoneCallingType : phoneCallType, (i13 & 8192) != 0 ? persistableChatConfiguration2.translations : translations2, (i13 & 16384) != 0 ? persistableChatConfiguration2.isTrackingEnabled : z18, (i13 & 32768) != 0 ? persistableChatConfiguration2.isFWFEnabled : z19, (i13 & 65536) != 0 ? persistableChatConfiguration2.themeResID : i11);
    }

    @JvmStatic
    public static final void write$Self(@NotNull PersistableChatConfiguration persistableChatConfiguration, @NotNull CompositeEncoder compositeEncoder, @NotNull SerialDescriptor serialDescriptor) {
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        boolean z15;
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        boolean z21;
        boolean z22;
        boolean z23;
        boolean z24;
        boolean z25;
        boolean z26;
        boolean z27;
        Intrinsics.checkNotNullParameter(persistableChatConfiguration, "self");
        Intrinsics.checkNotNullParameter(compositeEncoder, "output");
        Intrinsics.checkNotNullParameter(serialDescriptor, "serialDesc");
        boolean z28 = false;
        if (!compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 0) && persistableChatConfiguration.userInfo == null) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (z11) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 0, UserInfo$$serializer.INSTANCE, persistableChatConfiguration.userInfo);
        }
        if (!compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 1) && persistableChatConfiguration.deliveryInfo == null) {
            z12 = false;
        } else {
            z12 = true;
        }
        if (z12) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 1, DeliveryInfo$$serializer.INSTANCE, persistableChatConfiguration.deliveryInfo);
        }
        if (!compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 2) && persistableChatConfiguration.channelId == null) {
            z13 = false;
        } else {
            z13 = true;
        }
        if (z13) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 2, StringSerializer.INSTANCE, persistableChatConfiguration.channelId);
        }
        if (!compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 3) && persistableChatConfiguration.clientConfig == null) {
            z14 = false;
        } else {
            z14 = true;
        }
        if (z14) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 3, ClientConfig$$serializer.INSTANCE, persistableChatConfiguration.clientConfig);
        }
        if (!compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 4) && !persistableChatConfiguration.enableVoipLogging) {
            z15 = false;
        } else {
            z15 = true;
        }
        if (z15) {
            compositeEncoder.encodeBooleanElement(serialDescriptor, 4, persistableChatConfiguration.enableVoipLogging);
        }
        if (!compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 5) && persistableChatConfiguration.stackFromEnd) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            compositeEncoder.encodeBooleanElement(serialDescriptor, 5, persistableChatConfiguration.stackFromEnd);
        }
        if (!compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 6) && !persistableChatConfiguration.isReplyingMandatory) {
            z17 = false;
        } else {
            z17 = true;
        }
        if (z17) {
            compositeEncoder.encodeBooleanElement(serialDescriptor, 6, persistableChatConfiguration.isReplyingMandatory);
        }
        if (!compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 7) && Intrinsics.areEqual((Object) persistableChatConfiguration.quickReplies, (Object) CollectionsKt__CollectionsKt.emptyList())) {
            z18 = false;
        } else {
            z18 = true;
        }
        if (z18) {
            compositeEncoder.encodeSerializableElement(serialDescriptor, 7, new ArrayListSerializer(StringSerializer.INSTANCE), persistableChatConfiguration.quickReplies);
        }
        if (!compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 8) && !persistableChatConfiguration.isPhotoSharingEnabled) {
            z19 = false;
        } else {
            z19 = true;
        }
        if (z19) {
            compositeEncoder.encodeBooleanElement(serialDescriptor, 8, persistableChatConfiguration.isPhotoSharingEnabled);
        }
        if (!compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 9) && !persistableChatConfiguration.hideAdminMessages) {
            z21 = false;
        } else {
            z21 = true;
        }
        if (z21) {
            compositeEncoder.encodeBooleanElement(serialDescriptor, 9, persistableChatConfiguration.hideAdminMessages);
        }
        if (!compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 10) && !persistableChatConfiguration.showSenderName) {
            z22 = false;
        } else {
            z22 = true;
        }
        if (z22) {
            compositeEncoder.encodeBooleanElement(serialDescriptor, 10, persistableChatConfiguration.showSenderName);
        }
        if (!compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 11) && !persistableChatConfiguration.isLocationSharingEnabled) {
            z23 = false;
        } else {
            z23 = true;
        }
        if (z23) {
            compositeEncoder.encodeBooleanElement(serialDescriptor, 11, persistableChatConfiguration.isLocationSharingEnabled);
        }
        if (!compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 12) && Intrinsics.areEqual((Object) persistableChatConfiguration.phoneCallingType, (Object) PhoneCallType.None.INSTANCE)) {
            z24 = false;
        } else {
            z24 = true;
        }
        if (z24) {
            compositeEncoder.encodeSerializableElement(serialDescriptor, 12, PhoneCallType.Companion.serializer(), persistableChatConfiguration.phoneCallingType);
        }
        if (!compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 13) && Intrinsics.areEqual((Object) persistableChatConfiguration.translations, (Object) Translations.DISABLED.INSTANCE)) {
            z25 = false;
        } else {
            z25 = true;
        }
        if (z25) {
            compositeEncoder.encodeSerializableElement(serialDescriptor, 13, Translations.Companion.serializer(), persistableChatConfiguration.translations);
        }
        if (!compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 14) && !persistableChatConfiguration.isTrackingEnabled) {
            z26 = false;
        } else {
            z26 = true;
        }
        if (z26) {
            compositeEncoder.encodeBooleanElement(serialDescriptor, 14, persistableChatConfiguration.isTrackingEnabled);
        }
        if (!compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 15) && !persistableChatConfiguration.isFWFEnabled) {
            z27 = false;
        } else {
            z27 = true;
        }
        if (z27) {
            compositeEncoder.encodeBooleanElement(serialDescriptor, 15, persistableChatConfiguration.isFWFEnabled);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 16) || persistableChatConfiguration.themeResID != R.style.CustomerChatActivityTheme) {
            z28 = true;
        }
        if (z28) {
            compositeEncoder.encodeIntElement(serialDescriptor, 16, persistableChatConfiguration.themeResID);
        }
    }

    @Nullable
    public final UserInfo component1() {
        return this.userInfo;
    }

    public final boolean component10() {
        return this.hideAdminMessages;
    }

    public final boolean component11() {
        return this.showSenderName;
    }

    public final boolean component12() {
        return this.isLocationSharingEnabled;
    }

    @NotNull
    public final PhoneCallType component13() {
        return this.phoneCallingType;
    }

    @NotNull
    public final Translations component14() {
        return this.translations;
    }

    public final boolean component15() {
        return this.isTrackingEnabled;
    }

    public final boolean component16() {
        return this.isFWFEnabled;
    }

    public final int component17() {
        return this.themeResID;
    }

    @Nullable
    public final DeliveryInfo component2() {
        return this.deliveryInfo;
    }

    @Nullable
    public final String component3() {
        return this.channelId;
    }

    @Nullable
    public final ClientConfig component4() {
        return this.clientConfig;
    }

    public final boolean component5() {
        return this.enableVoipLogging;
    }

    public final boolean component6() {
        return this.stackFromEnd;
    }

    public final boolean component7() {
        return this.isReplyingMandatory;
    }

    @NotNull
    public final List<String> component8() {
        return this.quickReplies;
    }

    public final boolean component9() {
        return this.isPhotoSharingEnabled;
    }

    @NotNull
    public final PersistableChatConfiguration copy(@Nullable UserInfo userInfo2, @Nullable DeliveryInfo deliveryInfo2, @Nullable String str, @Nullable ClientConfig clientConfig2, boolean z11, boolean z12, boolean z13, @NotNull List<String> list, boolean z14, boolean z15, boolean z16, boolean z17, @NotNull PhoneCallType phoneCallType, @NotNull Translations translations2, boolean z18, boolean z19, @StyleRes int i11) {
        UserInfo userInfo3 = userInfo2;
        Intrinsics.checkNotNullParameter(list, "quickReplies");
        Intrinsics.checkNotNullParameter(phoneCallType, "phoneCallingType");
        Intrinsics.checkNotNullParameter(translations2, "translations");
        return new PersistableChatConfiguration(userInfo2, deliveryInfo2, str, clientConfig2, z11, z12, z13, list, z14, z15, z16, z17, phoneCallType, translations2, z18, z19, i11);
    }

    @NotNull
    public final String encode() {
        return Json.Default.encodeToString(Companion.serializer(), this);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PersistableChatConfiguration)) {
            return false;
        }
        PersistableChatConfiguration persistableChatConfiguration = (PersistableChatConfiguration) obj;
        return Intrinsics.areEqual((Object) this.userInfo, (Object) persistableChatConfiguration.userInfo) && Intrinsics.areEqual((Object) this.deliveryInfo, (Object) persistableChatConfiguration.deliveryInfo) && Intrinsics.areEqual((Object) this.channelId, (Object) persistableChatConfiguration.channelId) && Intrinsics.areEqual((Object) this.clientConfig, (Object) persistableChatConfiguration.clientConfig) && this.enableVoipLogging == persistableChatConfiguration.enableVoipLogging && this.stackFromEnd == persistableChatConfiguration.stackFromEnd && this.isReplyingMandatory == persistableChatConfiguration.isReplyingMandatory && Intrinsics.areEqual((Object) this.quickReplies, (Object) persistableChatConfiguration.quickReplies) && this.isPhotoSharingEnabled == persistableChatConfiguration.isPhotoSharingEnabled && this.hideAdminMessages == persistableChatConfiguration.hideAdminMessages && this.showSenderName == persistableChatConfiguration.showSenderName && this.isLocationSharingEnabled == persistableChatConfiguration.isLocationSharingEnabled && Intrinsics.areEqual((Object) this.phoneCallingType, (Object) persistableChatConfiguration.phoneCallingType) && Intrinsics.areEqual((Object) this.translations, (Object) persistableChatConfiguration.translations) && this.isTrackingEnabled == persistableChatConfiguration.isTrackingEnabled && this.isFWFEnabled == persistableChatConfiguration.isFWFEnabled && this.themeResID == persistableChatConfiguration.themeResID;
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

    public final boolean getEnableVoipLogging() {
        return this.enableVoipLogging;
    }

    public final boolean getHideAdminMessages() {
        return this.hideAdminMessages;
    }

    @NotNull
    public final PhoneCallType getPhoneCallingType() {
        return this.phoneCallingType;
    }

    @NotNull
    public final List<String> getQuickReplies() {
        return this.quickReplies;
    }

    public final boolean getShowSenderName() {
        return this.showSenderName;
    }

    public final boolean getStackFromEnd() {
        return this.stackFromEnd;
    }

    public final int getThemeResID() {
        return this.themeResID;
    }

    @NotNull
    public final Translations getTranslations() {
        return this.translations;
    }

    @Nullable
    public final UserInfo getUserInfo() {
        return this.userInfo;
    }

    public int hashCode() {
        UserInfo userInfo2 = this.userInfo;
        int i11 = 0;
        int hashCode = (userInfo2 == null ? 0 : userInfo2.hashCode()) * 31;
        DeliveryInfo deliveryInfo2 = this.deliveryInfo;
        int hashCode2 = (hashCode + (deliveryInfo2 == null ? 0 : deliveryInfo2.hashCode())) * 31;
        String str = this.channelId;
        int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        ClientConfig clientConfig2 = this.clientConfig;
        if (clientConfig2 != null) {
            i11 = clientConfig2.hashCode();
        }
        int i12 = (hashCode3 + i11) * 31;
        boolean z11 = this.enableVoipLogging;
        boolean z12 = true;
        if (z11) {
            z11 = true;
        }
        int i13 = (i12 + (z11 ? 1 : 0)) * 31;
        boolean z13 = this.stackFromEnd;
        if (z13) {
            z13 = true;
        }
        int i14 = (i13 + (z13 ? 1 : 0)) * 31;
        boolean z14 = this.isReplyingMandatory;
        if (z14) {
            z14 = true;
        }
        int hashCode4 = (((i14 + (z14 ? 1 : 0)) * 31) + this.quickReplies.hashCode()) * 31;
        boolean z15 = this.isPhotoSharingEnabled;
        if (z15) {
            z15 = true;
        }
        int i15 = (hashCode4 + (z15 ? 1 : 0)) * 31;
        boolean z16 = this.hideAdminMessages;
        if (z16) {
            z16 = true;
        }
        int i16 = (i15 + (z16 ? 1 : 0)) * 31;
        boolean z17 = this.showSenderName;
        if (z17) {
            z17 = true;
        }
        int i17 = (i16 + (z17 ? 1 : 0)) * 31;
        boolean z18 = this.isLocationSharingEnabled;
        if (z18) {
            z18 = true;
        }
        int hashCode5 = (((((i17 + (z18 ? 1 : 0)) * 31) + this.phoneCallingType.hashCode()) * 31) + this.translations.hashCode()) * 31;
        boolean z19 = this.isTrackingEnabled;
        if (z19) {
            z19 = true;
        }
        int i18 = (hashCode5 + (z19 ? 1 : 0)) * 31;
        boolean z21 = this.isFWFEnabled;
        if (!z21) {
            z12 = z21;
        }
        return ((i18 + (z12 ? 1 : 0)) * 31) + this.themeResID;
    }

    public final boolean isFWFEnabled() {
        return this.isFWFEnabled;
    }

    public final boolean isLocationSharingEnabled() {
        return this.isLocationSharingEnabled;
    }

    public final boolean isPhotoSharingEnabled() {
        return this.isPhotoSharingEnabled;
    }

    public final boolean isReplyingMandatory() {
        return this.isReplyingMandatory;
    }

    public final boolean isTrackingEnabled() {
        return this.isTrackingEnabled;
    }

    @NotNull
    public final ChatConfiguration toChatConfiguration() {
        return new ChatConfiguration(this.userInfo, this.deliveryInfo, this.channelId, this.clientConfig, this.enableVoipLogging, this.stackFromEnd, this.isReplyingMandatory, this.quickReplies, this.isPhotoSharingEnabled, this.hideAdminMessages, this.showSenderName, this.isLocationSharingEnabled, this.phoneCallingType, this.translations, this.isTrackingEnabled, this.isFWFEnabled, this.themeResID);
    }

    @NotNull
    public String toString() {
        return "PersistableChatConfiguration(userInfo=" + this.userInfo + ", deliveryInfo=" + this.deliveryInfo + ", channelId=" + this.channelId + ", clientConfig=" + this.clientConfig + ", enableVoipLogging=" + this.enableVoipLogging + ", stackFromEnd=" + this.stackFromEnd + ", isReplyingMandatory=" + this.isReplyingMandatory + ", quickReplies=" + this.quickReplies + ", isPhotoSharingEnabled=" + this.isPhotoSharingEnabled + ", hideAdminMessages=" + this.hideAdminMessages + ", showSenderName=" + this.showSenderName + ", isLocationSharingEnabled=" + this.isLocationSharingEnabled + ", phoneCallingType=" + this.phoneCallingType + ", translations=" + this.translations + ", isTrackingEnabled=" + this.isTrackingEnabled + ", isFWFEnabled=" + this.isFWFEnabled + ", themeResID=" + this.themeResID + ')';
    }

    public PersistableChatConfiguration(@Nullable UserInfo userInfo2, @Nullable DeliveryInfo deliveryInfo2, @Nullable String str, @Nullable ClientConfig clientConfig2, boolean z11, boolean z12, boolean z13, @NotNull List<String> list, boolean z14, boolean z15, boolean z16, boolean z17, @NotNull PhoneCallType phoneCallType, @NotNull Translations translations2, boolean z18, boolean z19, @StyleRes int i11) {
        PhoneCallType phoneCallType2 = phoneCallType;
        Translations translations3 = translations2;
        Intrinsics.checkNotNullParameter(list, "quickReplies");
        Intrinsics.checkNotNullParameter(phoneCallType2, "phoneCallingType");
        Intrinsics.checkNotNullParameter(translations3, "translations");
        this.userInfo = userInfo2;
        this.deliveryInfo = deliveryInfo2;
        this.channelId = str;
        this.clientConfig = clientConfig2;
        this.enableVoipLogging = z11;
        this.stackFromEnd = z12;
        this.isReplyingMandatory = z13;
        this.quickReplies = list;
        this.isPhotoSharingEnabled = z14;
        this.hideAdminMessages = z15;
        this.showSenderName = z16;
        this.isLocationSharingEnabled = z17;
        this.phoneCallingType = phoneCallType2;
        this.translations = translations3;
        this.isTrackingEnabled = z18;
        this.isFWFEnabled = z19;
        this.themeResID = i11;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ PersistableChatConfiguration(com.deliveryhero.contract.model.UserInfo r19, com.deliveryhero.contract.model.DeliveryInfo r20, java.lang.String r21, com.deliveryhero.contract.model.ClientConfig r22, boolean r23, boolean r24, boolean r25, java.util.List r26, boolean r27, boolean r28, boolean r29, boolean r30, com.deliveryhero.contract.model.PhoneCallType r31, com.deliveryhero.contract.model.Translations r32, boolean r33, boolean r34, int r35, int r36, kotlin.jvm.internal.DefaultConstructorMarker r37) {
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
        throw new UnsupportedOperationException("Method not decompiled: com.deliveryhero.contract.configuration.PersistableChatConfiguration.<init>(com.deliveryhero.contract.model.UserInfo, com.deliveryhero.contract.model.DeliveryInfo, java.lang.String, com.deliveryhero.contract.model.ClientConfig, boolean, boolean, boolean, java.util.List, boolean, boolean, boolean, boolean, com.deliveryhero.contract.model.PhoneCallType, com.deliveryhero.contract.model.Translations, boolean, boolean, int, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
