package com.deliveryhero.contract.model;

import com.huawei.location.lite.common.util.DeviceInfoUtil;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.EnumSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 -2\u00020\u0001:\u0002,-BK\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u000fB/\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\u0010J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\bHÆ\u0003J\t\u0010\u001d\u001a\u00020\nHÆ\u0003J\t\u0010\u001e\u001a\u00020\fHÆ\u0003J;\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\fHÆ\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020\u0003HÖ\u0001J\t\u0010$\u001a\u00020\u0005HÖ\u0001J!\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u00002\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+HÇ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006."}, d2 = {"Lcom/deliveryhero/contract/model/ClientConfig;", "", "seen1", "", "country", "", "globalEntityID", "userType", "Lcom/deliveryhero/contract/model/UserType;", "pushNotificationsTokenType", "Lcom/deliveryhero/contract/model/TokenType;", "dhEnvironment", "Lcom/deliveryhero/contract/model/DhEnvironment;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Lcom/deliveryhero/contract/model/UserType;Lcom/deliveryhero/contract/model/TokenType;Lcom/deliveryhero/contract/model/DhEnvironment;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;Ljava/lang/String;Lcom/deliveryhero/contract/model/UserType;Lcom/deliveryhero/contract/model/TokenType;Lcom/deliveryhero/contract/model/DhEnvironment;)V", "getCountry", "()Ljava/lang/String;", "getDhEnvironment", "()Lcom/deliveryhero/contract/model/DhEnvironment;", "getGlobalEntityID", "getPushNotificationsTokenType", "()Lcom/deliveryhero/contract/model/TokenType;", "getUserType", "()Lcom/deliveryhero/contract/model/UserType;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "$serializer", "Companion", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Serializable
public final class ClientConfig {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private final String country;
    @NotNull
    private final DhEnvironment dhEnvironment;
    @NotNull
    private final String globalEntityID;
    @NotNull
    private final TokenType pushNotificationsTokenType;
    @NotNull
    private final UserType userType;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/deliveryhero/contract/model/ClientConfig$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/deliveryhero/contract/model/ClientConfig;", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final KSerializer<ClientConfig> serializer() {
            return ClientConfig$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ ClientConfig(int i11, String str, String str2, UserType userType2, TokenType tokenType, DhEnvironment dhEnvironment2, SerializationConstructorMarker serializationConstructorMarker) {
        if (15 != (i11 & 15)) {
            PluginExceptionsKt.throwMissingFieldException(i11, 15, ClientConfig$$serializer.INSTANCE.getDescriptor());
        }
        this.country = str;
        this.globalEntityID = str2;
        this.userType = userType2;
        this.pushNotificationsTokenType = tokenType;
        if ((i11 & 16) == 0) {
            this.dhEnvironment = DhEnvironment.PRODUCTION;
        } else {
            this.dhEnvironment = dhEnvironment2;
        }
    }

    public static /* synthetic */ ClientConfig copy$default(ClientConfig clientConfig, String str, String str2, UserType userType2, TokenType tokenType, DhEnvironment dhEnvironment2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = clientConfig.country;
        }
        if ((i11 & 2) != 0) {
            str2 = clientConfig.globalEntityID;
        }
        String str3 = str2;
        if ((i11 & 4) != 0) {
            userType2 = clientConfig.userType;
        }
        UserType userType3 = userType2;
        if ((i11 & 8) != 0) {
            tokenType = clientConfig.pushNotificationsTokenType;
        }
        TokenType tokenType2 = tokenType;
        if ((i11 & 16) != 0) {
            dhEnvironment2 = clientConfig.dhEnvironment;
        }
        return clientConfig.copy(str, str3, userType3, tokenType2, dhEnvironment2);
    }

    @JvmStatic
    public static final void write$Self(@NotNull ClientConfig clientConfig, @NotNull CompositeEncoder compositeEncoder, @NotNull SerialDescriptor serialDescriptor) {
        Intrinsics.checkNotNullParameter(clientConfig, "self");
        Intrinsics.checkNotNullParameter(compositeEncoder, "output");
        Intrinsics.checkNotNullParameter(serialDescriptor, "serialDesc");
        boolean z11 = false;
        compositeEncoder.encodeStringElement(serialDescriptor, 0, clientConfig.country);
        compositeEncoder.encodeStringElement(serialDescriptor, 1, clientConfig.globalEntityID);
        compositeEncoder.encodeSerializableElement(serialDescriptor, 2, new EnumSerializer("com.deliveryhero.contract.model.UserType", UserType.values()), clientConfig.userType);
        compositeEncoder.encodeSerializableElement(serialDescriptor, 3, new EnumSerializer("com.deliveryhero.contract.model.TokenType", TokenType.values()), clientConfig.pushNotificationsTokenType);
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 4) || clientConfig.dhEnvironment != DhEnvironment.PRODUCTION) {
            z11 = true;
        }
        if (z11) {
            compositeEncoder.encodeSerializableElement(serialDescriptor, 4, new EnumSerializer("com.deliveryhero.contract.model.DhEnvironment", DhEnvironment.values()), clientConfig.dhEnvironment);
        }
    }

    @NotNull
    public final String component1() {
        return this.country;
    }

    @NotNull
    public final String component2() {
        return this.globalEntityID;
    }

    @NotNull
    public final UserType component3() {
        return this.userType;
    }

    @NotNull
    public final TokenType component4() {
        return this.pushNotificationsTokenType;
    }

    @NotNull
    public final DhEnvironment component5() {
        return this.dhEnvironment;
    }

    @NotNull
    public final ClientConfig copy(@NotNull String str, @NotNull String str2, @NotNull UserType userType2, @NotNull TokenType tokenType, @NotNull DhEnvironment dhEnvironment2) {
        Intrinsics.checkNotNullParameter(str, "country");
        Intrinsics.checkNotNullParameter(str2, "globalEntityID");
        Intrinsics.checkNotNullParameter(userType2, DeviceInfoUtil.DeviceProperty.USERTYPE);
        Intrinsics.checkNotNullParameter(tokenType, "pushNotificationsTokenType");
        Intrinsics.checkNotNullParameter(dhEnvironment2, "dhEnvironment");
        return new ClientConfig(str, str2, userType2, tokenType, dhEnvironment2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ClientConfig)) {
            return false;
        }
        ClientConfig clientConfig = (ClientConfig) obj;
        return Intrinsics.areEqual((Object) this.country, (Object) clientConfig.country) && Intrinsics.areEqual((Object) this.globalEntityID, (Object) clientConfig.globalEntityID) && this.userType == clientConfig.userType && this.pushNotificationsTokenType == clientConfig.pushNotificationsTokenType && this.dhEnvironment == clientConfig.dhEnvironment;
    }

    @NotNull
    public final String getCountry() {
        return this.country;
    }

    @NotNull
    public final DhEnvironment getDhEnvironment() {
        return this.dhEnvironment;
    }

    @NotNull
    public final String getGlobalEntityID() {
        return this.globalEntityID;
    }

    @NotNull
    public final TokenType getPushNotificationsTokenType() {
        return this.pushNotificationsTokenType;
    }

    @NotNull
    public final UserType getUserType() {
        return this.userType;
    }

    public int hashCode() {
        return (((((((this.country.hashCode() * 31) + this.globalEntityID.hashCode()) * 31) + this.userType.hashCode()) * 31) + this.pushNotificationsTokenType.hashCode()) * 31) + this.dhEnvironment.hashCode();
    }

    @NotNull
    public String toString() {
        return "ClientConfig(country=" + this.country + ", globalEntityID=" + this.globalEntityID + ", userType=" + this.userType + ", pushNotificationsTokenType=" + this.pushNotificationsTokenType + ", dhEnvironment=" + this.dhEnvironment + ')';
    }

    public ClientConfig(@NotNull String str, @NotNull String str2, @NotNull UserType userType2, @NotNull TokenType tokenType, @NotNull DhEnvironment dhEnvironment2) {
        Intrinsics.checkNotNullParameter(str, "country");
        Intrinsics.checkNotNullParameter(str2, "globalEntityID");
        Intrinsics.checkNotNullParameter(userType2, DeviceInfoUtil.DeviceProperty.USERTYPE);
        Intrinsics.checkNotNullParameter(tokenType, "pushNotificationsTokenType");
        Intrinsics.checkNotNullParameter(dhEnvironment2, "dhEnvironment");
        this.country = str;
        this.globalEntityID = str2;
        this.userType = userType2;
        this.pushNotificationsTokenType = tokenType;
        this.dhEnvironment = dhEnvironment2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ClientConfig(String str, String str2, UserType userType2, TokenType tokenType, DhEnvironment dhEnvironment2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, userType2, tokenType, (i11 & 16) != 0 ? DhEnvironment.PRODUCTION : dhEnvironment2);
    }
}
