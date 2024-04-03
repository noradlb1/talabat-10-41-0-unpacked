package com.deliveryhero.customerchat.eventTracking.data;

import com.deliveryhero.contract.model.UserType;
import com.deliveryhero.customerchat.eventTracking.constants.UserPropertyKeys;
import java.util.Locale;
import java.util.Map;
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
import kotlinx.serialization.internal.StringSerializer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 82\u00020\u0001:\u000278B}\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0002\u0010\u0012By\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u0013J\u000b\u0010 \u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010\"\u001a\u00020\u0007HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010&\u001a\u00020\u0007HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0007HÆ\u0003J}\u0010*\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\u000b\u001a\u00020\u00072\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010.\u001a\u00020\u0003HÖ\u0001J\t\u0010/\u001a\u00020\u0007HÖ\u0001J!\u00100\u001a\u0002012\u0006\u00102\u001a\u00020\u00002\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u000206HÇ\u0001R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0015R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0015R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0015R\u0011\u0010\u000b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0015R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0015R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f¨\u00069"}, d2 = {"Lcom/deliveryhero/customerchat/eventTracking/data/UserProperties;", "", "seen1", "", "userType", "Lcom/deliveryhero/contract/model/UserType;", "deviceType", "", "deviceName", "deviceManufacturer", "osVersion", "sdkType", "sdkVersion", "hostApp", "appVersion", "sdkConsumerVersion", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/deliveryhero/contract/model/UserType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Lcom/deliveryhero/contract/model/UserType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAppVersion", "()Ljava/lang/String;", "getDeviceManufacturer", "getDeviceName", "getDeviceType", "getHostApp", "getOsVersion", "getSdkConsumerVersion", "getSdkType", "getSdkVersion", "getUserType", "()Lcom/deliveryhero/contract/model/UserType;", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "$serializer", "Companion", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Serializable
public final class UserProperties {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @Nullable
    private final String appVersion;
    @Nullable
    private final String deviceManufacturer;
    @Nullable
    private final String deviceName;
    @NotNull
    private final String deviceType;
    @Nullable
    private final String hostApp;
    @Nullable
    private final String osVersion;
    @Nullable
    private final String sdkConsumerVersion;
    @NotNull
    private final String sdkType;
    @Nullable
    private final String sdkVersion;
    @Nullable
    private final UserType userType;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001J\u0018\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007*\u00020\u0005¨\u0006\t"}, d2 = {"Lcom/deliveryhero/customerchat/eventTracking/data/UserProperties$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/deliveryhero/customerchat/eventTracking/data/UserProperties;", "toMap", "", "", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final KSerializer<UserProperties> serializer() {
            return UserProperties$$serializer.INSTANCE;
        }

        @NotNull
        public final Map<String, String> toMap(@NotNull UserProperties userProperties) {
            String str;
            String name2;
            Intrinsics.checkNotNullParameter(userProperties, "<this>");
            Map createMapBuilder = MapsKt__MapsJVMKt.createMapBuilder();
            UserType userType = userProperties.getUserType();
            if (userType == null || (name2 = userType.name()) == null) {
                str = null;
            } else {
                str = name2.toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(str, "this as java.lang.String).toLowerCase(Locale.ROOT)");
            }
            createMapBuilder.put(UserPropertyKeys.USER_TYPE, str);
            createMapBuilder.put(UserPropertyKeys.DEVICE_TYPE, userProperties.getDeviceType());
            createMapBuilder.put(UserPropertyKeys.DEVICE_NAME, userProperties.getDeviceName());
            createMapBuilder.put(UserPropertyKeys.DEVICE_MANUFACTURER, userProperties.getDeviceManufacturer());
            createMapBuilder.put(UserPropertyKeys.OS_VERSION, userProperties.getOsVersion());
            createMapBuilder.put("sdk_type", userProperties.getSdkType());
            createMapBuilder.put("sdk_version", userProperties.getSdkVersion());
            createMapBuilder.put(UserPropertyKeys.HOST_APP, userProperties.getHostApp());
            createMapBuilder.put("app_version", userProperties.getAppVersion());
            createMapBuilder.put(UserPropertyKeys.SDK_CONSUMER_VERSION, String.valueOf(userProperties.getSdkConsumerVersion()));
            return MapsKt__MapsJVMKt.build(createMapBuilder);
        }
    }

    public UserProperties() {
        this((UserType) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 1023, (DefaultConstructorMarker) null);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ UserProperties(int i11, UserType userType2, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i11 & 0) != 0) {
            PluginExceptionsKt.throwMissingFieldException(i11, 0, UserProperties$$serializer.INSTANCE.getDescriptor());
        }
        if ((i11 & 1) == 0) {
            this.userType = null;
        } else {
            this.userType = userType2;
        }
        if ((i11 & 2) == 0) {
            this.deviceType = "mobile";
        } else {
            this.deviceType = str;
        }
        if ((i11 & 4) == 0) {
            this.deviceName = null;
        } else {
            this.deviceName = str2;
        }
        if ((i11 & 8) == 0) {
            this.deviceManufacturer = null;
        } else {
            this.deviceManufacturer = str3;
        }
        if ((i11 & 16) == 0) {
            this.osVersion = null;
        } else {
            this.osVersion = str4;
        }
        if ((i11 & 32) == 0) {
            this.sdkType = "android";
        } else {
            this.sdkType = str5;
        }
        if ((i11 & 64) == 0) {
            this.sdkVersion = null;
        } else {
            this.sdkVersion = str6;
        }
        if ((i11 & 128) == 0) {
            this.hostApp = null;
        } else {
            this.hostApp = str7;
        }
        if ((i11 & 256) == 0) {
            this.appVersion = null;
        } else {
            this.appVersion = str8;
        }
        if ((i11 & 512) == 0) {
            this.sdkConsumerVersion = null;
        } else {
            this.sdkConsumerVersion = str9;
        }
    }

    public static /* synthetic */ UserProperties copy$default(UserProperties userProperties, UserType userType2, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, int i11, Object obj) {
        UserProperties userProperties2 = userProperties;
        int i12 = i11;
        return userProperties.copy((i12 & 1) != 0 ? userProperties2.userType : userType2, (i12 & 2) != 0 ? userProperties2.deviceType : str, (i12 & 4) != 0 ? userProperties2.deviceName : str2, (i12 & 8) != 0 ? userProperties2.deviceManufacturer : str3, (i12 & 16) != 0 ? userProperties2.osVersion : str4, (i12 & 32) != 0 ? userProperties2.sdkType : str5, (i12 & 64) != 0 ? userProperties2.sdkVersion : str6, (i12 & 128) != 0 ? userProperties2.hostApp : str7, (i12 & 256) != 0 ? userProperties2.appVersion : str8, (i12 & 512) != 0 ? userProperties2.sdkConsumerVersion : str9);
    }

    @JvmStatic
    public static final void write$Self(@NotNull UserProperties userProperties, @NotNull CompositeEncoder compositeEncoder, @NotNull SerialDescriptor serialDescriptor) {
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        boolean z15;
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        Intrinsics.checkNotNullParameter(userProperties, "self");
        Intrinsics.checkNotNullParameter(compositeEncoder, "output");
        Intrinsics.checkNotNullParameter(serialDescriptor, "serialDesc");
        boolean z21 = false;
        if (!compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 0) && userProperties.userType == null) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (z11) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 0, new EnumSerializer("com.deliveryhero.contract.model.UserType", UserType.values()), userProperties.userType);
        }
        if (!compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 1) && Intrinsics.areEqual((Object) userProperties.deviceType, (Object) "mobile")) {
            z12 = false;
        } else {
            z12 = true;
        }
        if (z12) {
            compositeEncoder.encodeStringElement(serialDescriptor, 1, userProperties.deviceType);
        }
        if (!compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 2) && userProperties.deviceName == null) {
            z13 = false;
        } else {
            z13 = true;
        }
        if (z13) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 2, StringSerializer.INSTANCE, userProperties.deviceName);
        }
        if (!compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 3) && userProperties.deviceManufacturer == null) {
            z14 = false;
        } else {
            z14 = true;
        }
        if (z14) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 3, StringSerializer.INSTANCE, userProperties.deviceManufacturer);
        }
        if (!compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 4) && userProperties.osVersion == null) {
            z15 = false;
        } else {
            z15 = true;
        }
        if (z15) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 4, StringSerializer.INSTANCE, userProperties.osVersion);
        }
        if (!compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 5) && Intrinsics.areEqual((Object) userProperties.sdkType, (Object) "android")) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            compositeEncoder.encodeStringElement(serialDescriptor, 5, userProperties.sdkType);
        }
        if (!compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 6) && userProperties.sdkVersion == null) {
            z17 = false;
        } else {
            z17 = true;
        }
        if (z17) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 6, StringSerializer.INSTANCE, userProperties.sdkVersion);
        }
        if (!compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 7) && userProperties.hostApp == null) {
            z18 = false;
        } else {
            z18 = true;
        }
        if (z18) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 7, StringSerializer.INSTANCE, userProperties.hostApp);
        }
        if (!compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 8) && userProperties.appVersion == null) {
            z19 = false;
        } else {
            z19 = true;
        }
        if (z19) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 8, StringSerializer.INSTANCE, userProperties.appVersion);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 9) || userProperties.sdkConsumerVersion != null) {
            z21 = true;
        }
        if (z21) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 9, StringSerializer.INSTANCE, userProperties.sdkConsumerVersion);
        }
    }

    @Nullable
    public final UserType component1() {
        return this.userType;
    }

    @Nullable
    public final String component10() {
        return this.sdkConsumerVersion;
    }

    @NotNull
    public final String component2() {
        return this.deviceType;
    }

    @Nullable
    public final String component3() {
        return this.deviceName;
    }

    @Nullable
    public final String component4() {
        return this.deviceManufacturer;
    }

    @Nullable
    public final String component5() {
        return this.osVersion;
    }

    @NotNull
    public final String component6() {
        return this.sdkType;
    }

    @Nullable
    public final String component7() {
        return this.sdkVersion;
    }

    @Nullable
    public final String component8() {
        return this.hostApp;
    }

    @Nullable
    public final String component9() {
        return this.appVersion;
    }

    @NotNull
    public final UserProperties copy(@Nullable UserType userType2, @NotNull String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @NotNull String str5, @Nullable String str6, @Nullable String str7, @Nullable String str8, @Nullable String str9) {
        Intrinsics.checkNotNullParameter(str, "deviceType");
        String str10 = str5;
        Intrinsics.checkNotNullParameter(str10, "sdkType");
        return new UserProperties(userType2, str, str2, str3, str4, str10, str6, str7, str8, str9);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UserProperties)) {
            return false;
        }
        UserProperties userProperties = (UserProperties) obj;
        return this.userType == userProperties.userType && Intrinsics.areEqual((Object) this.deviceType, (Object) userProperties.deviceType) && Intrinsics.areEqual((Object) this.deviceName, (Object) userProperties.deviceName) && Intrinsics.areEqual((Object) this.deviceManufacturer, (Object) userProperties.deviceManufacturer) && Intrinsics.areEqual((Object) this.osVersion, (Object) userProperties.osVersion) && Intrinsics.areEqual((Object) this.sdkType, (Object) userProperties.sdkType) && Intrinsics.areEqual((Object) this.sdkVersion, (Object) userProperties.sdkVersion) && Intrinsics.areEqual((Object) this.hostApp, (Object) userProperties.hostApp) && Intrinsics.areEqual((Object) this.appVersion, (Object) userProperties.appVersion) && Intrinsics.areEqual((Object) this.sdkConsumerVersion, (Object) userProperties.sdkConsumerVersion);
    }

    @Nullable
    public final String getAppVersion() {
        return this.appVersion;
    }

    @Nullable
    public final String getDeviceManufacturer() {
        return this.deviceManufacturer;
    }

    @Nullable
    public final String getDeviceName() {
        return this.deviceName;
    }

    @NotNull
    public final String getDeviceType() {
        return this.deviceType;
    }

    @Nullable
    public final String getHostApp() {
        return this.hostApp;
    }

    @Nullable
    public final String getOsVersion() {
        return this.osVersion;
    }

    @Nullable
    public final String getSdkConsumerVersion() {
        return this.sdkConsumerVersion;
    }

    @NotNull
    public final String getSdkType() {
        return this.sdkType;
    }

    @Nullable
    public final String getSdkVersion() {
        return this.sdkVersion;
    }

    @Nullable
    public final UserType getUserType() {
        return this.userType;
    }

    public int hashCode() {
        UserType userType2 = this.userType;
        int i11 = 0;
        int hashCode = (((userType2 == null ? 0 : userType2.hashCode()) * 31) + this.deviceType.hashCode()) * 31;
        String str = this.deviceName;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.deviceManufacturer;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.osVersion;
        int hashCode4 = (((hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31) + this.sdkType.hashCode()) * 31;
        String str4 = this.sdkVersion;
        int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.hostApp;
        int hashCode6 = (hashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.appVersion;
        int hashCode7 = (hashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.sdkConsumerVersion;
        if (str7 != null) {
            i11 = str7.hashCode();
        }
        return hashCode7 + i11;
    }

    @NotNull
    public String toString() {
        return "UserProperties(userType=" + this.userType + ", deviceType=" + this.deviceType + ", deviceName=" + this.deviceName + ", deviceManufacturer=" + this.deviceManufacturer + ", osVersion=" + this.osVersion + ", sdkType=" + this.sdkType + ", sdkVersion=" + this.sdkVersion + ", hostApp=" + this.hostApp + ", appVersion=" + this.appVersion + ", sdkConsumerVersion=" + this.sdkConsumerVersion + ')';
    }

    public UserProperties(@Nullable UserType userType2, @NotNull String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @NotNull String str5, @Nullable String str6, @Nullable String str7, @Nullable String str8, @Nullable String str9) {
        Intrinsics.checkNotNullParameter(str, "deviceType");
        Intrinsics.checkNotNullParameter(str5, "sdkType");
        this.userType = userType2;
        this.deviceType = str;
        this.deviceName = str2;
        this.deviceManufacturer = str3;
        this.osVersion = str4;
        this.sdkType = str5;
        this.sdkVersion = str6;
        this.hostApp = str7;
        this.appVersion = str8;
        this.sdkConsumerVersion = str9;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ UserProperties(com.deliveryhero.contract.model.UserType r12, java.lang.String r13, java.lang.String r14, java.lang.String r15, java.lang.String r16, java.lang.String r17, java.lang.String r18, java.lang.String r19, java.lang.String r20, java.lang.String r21, int r22, kotlin.jvm.internal.DefaultConstructorMarker r23) {
        /*
            r11 = this;
            r0 = r22
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r1 = r2
            goto L_0x000a
        L_0x0009:
            r1 = r12
        L_0x000a:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0011
            java.lang.String r3 = "mobile"
            goto L_0x0012
        L_0x0011:
            r3 = r13
        L_0x0012:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x0018
            r4 = r2
            goto L_0x0019
        L_0x0018:
            r4 = r14
        L_0x0019:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x001f
            r5 = r2
            goto L_0x0020
        L_0x001f:
            r5 = r15
        L_0x0020:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0026
            r6 = r2
            goto L_0x0028
        L_0x0026:
            r6 = r16
        L_0x0028:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x002f
            java.lang.String r7 = "android"
            goto L_0x0031
        L_0x002f:
            r7 = r17
        L_0x0031:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x0037
            r8 = r2
            goto L_0x0039
        L_0x0037:
            r8 = r18
        L_0x0039:
            r9 = r0 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x003f
            r9 = r2
            goto L_0x0041
        L_0x003f:
            r9 = r19
        L_0x0041:
            r10 = r0 & 256(0x100, float:3.59E-43)
            if (r10 == 0) goto L_0x0047
            r10 = r2
            goto L_0x0049
        L_0x0047:
            r10 = r20
        L_0x0049:
            r0 = r0 & 512(0x200, float:7.175E-43)
            if (r0 == 0) goto L_0x004e
            goto L_0x0050
        L_0x004e:
            r2 = r21
        L_0x0050:
            r12 = r11
            r13 = r1
            r14 = r3
            r15 = r4
            r16 = r5
            r17 = r6
            r18 = r7
            r19 = r8
            r20 = r9
            r21 = r10
            r22 = r2
            r12.<init>(r13, r14, r15, r16, r17, r18, r19, r20, r21, r22)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.deliveryhero.customerchat.eventTracking.data.UserProperties.<init>(com.deliveryhero.contract.model.UserType, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
