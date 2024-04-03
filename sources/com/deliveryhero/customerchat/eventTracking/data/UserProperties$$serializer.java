package com.deliveryhero.customerchat.eventTracking.data;

import com.deliveryhero.contract.model.UserType;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.huawei.location.lite.common.util.DeviceInfoUtil;
import com.newrelic.agent.android.analytics.AnalyticsAttribute;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.EnumSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"com/deliveryhero/customerchat/eventTracking/data/UserProperties.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/deliveryhero/customerchat/eventTracking/data/UserProperties;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
public final class UserProperties$$serializer implements GeneratedSerializer<UserProperties> {
    @NotNull
    public static final UserProperties$$serializer INSTANCE;
    public static final /* synthetic */ SerialDescriptor descriptor;

    static {
        UserProperties$$serializer userProperties$$serializer = new UserProperties$$serializer();
        INSTANCE = userProperties$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.deliveryhero.customerchat.eventTracking.data.UserProperties", userProperties$$serializer, 10);
        pluginGeneratedSerialDescriptor.addElement(DeviceInfoUtil.DeviceProperty.USERTYPE, true);
        pluginGeneratedSerialDescriptor.addElement("deviceType", true);
        pluginGeneratedSerialDescriptor.addElement("deviceName", true);
        pluginGeneratedSerialDescriptor.addElement(AnalyticsAttribute.DEVICE_MANUFACTURER_ATTRIBUTE, true);
        pluginGeneratedSerialDescriptor.addElement(AnalyticsAttribute.OS_VERSION_ATTRIBUTE, true);
        pluginGeneratedSerialDescriptor.addElement("sdkType", true);
        pluginGeneratedSerialDescriptor.addElement(RemoteConfigConstants.RequestFieldKey.SDK_VERSION, true);
        pluginGeneratedSerialDescriptor.addElement("hostApp", true);
        pluginGeneratedSerialDescriptor.addElement("appVersion", true);
        pluginGeneratedSerialDescriptor.addElement("sdkConsumerVersion", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private UserProperties$$serializer() {
    }

    @NotNull
    public KSerializer<?>[] childSerializers() {
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        return new KSerializer[]{BuiltinSerializersKt.getNullable(new EnumSerializer("com.deliveryhero.contract.model.UserType", UserType.values())), stringSerializer, BuiltinSerializersKt.getNullable(stringSerializer), BuiltinSerializersKt.getNullable(stringSerializer), BuiltinSerializersKt.getNullable(stringSerializer), stringSerializer, BuiltinSerializersKt.getNullable(stringSerializer), BuiltinSerializersKt.getNullable(stringSerializer), BuiltinSerializersKt.getNullable(stringSerializer), BuiltinSerializersKt.getNullable(stringSerializer)};
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x00b1, code lost:
        r3 = 9;
        r6 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x00f4, code lost:
        r3 = 9;
        r12 = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x00fb, code lost:
        r9 = 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0070, code lost:
        r12 = r12;
        r6 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0070, code lost:
        r12 = r12;
        r6 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0070, code lost:
        r6 = r6;
        r12 = r12;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.deliveryhero.customerchat.eventTracking.data.UserProperties deserialize(@org.jetbrains.annotations.NotNull kotlinx.serialization.encoding.Decoder r22) {
        /*
            r21 = this;
            r0 = r22
            java.lang.String r1 = "decoder"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            kotlinx.serialization.descriptors.SerialDescriptor r1 = r21.getDescriptor()
            kotlinx.serialization.encoding.CompositeDecoder r0 = r0.beginStructure(r1)
            boolean r2 = r0.decodeSequentially()
            r3 = 9
            r4 = 7
            r5 = 6
            r6 = 5
            r7 = 3
            java.lang.String r8 = "com.deliveryhero.contract.model.UserType"
            r9 = 8
            r10 = 4
            r11 = 2
            r12 = 1
            r13 = 0
            r14 = 0
            if (r2 == 0) goto L_0x0063
            kotlinx.serialization.internal.EnumSerializer r2 = new kotlinx.serialization.internal.EnumSerializer
            com.deliveryhero.contract.model.UserType[] r15 = com.deliveryhero.contract.model.UserType.values()
            r2.<init>(r8, r15)
            java.lang.Object r2 = r0.decodeNullableSerializableElement(r1, r13, r2, r14)
            java.lang.String r8 = r0.decodeStringElement(r1, r12)
            kotlinx.serialization.internal.StringSerializer r12 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            java.lang.Object r11 = r0.decodeNullableSerializableElement(r1, r11, r12, r14)
            java.lang.Object r7 = r0.decodeNullableSerializableElement(r1, r7, r12, r14)
            java.lang.Object r10 = r0.decodeNullableSerializableElement(r1, r10, r12, r14)
            java.lang.String r6 = r0.decodeStringElement(r1, r6)
            java.lang.Object r5 = r0.decodeNullableSerializableElement(r1, r5, r12, r14)
            java.lang.Object r4 = r0.decodeNullableSerializableElement(r1, r4, r12, r14)
            java.lang.Object r9 = r0.decodeNullableSerializableElement(r1, r9, r12, r14)
            java.lang.Object r3 = r0.decodeNullableSerializableElement(r1, r3, r12, r14)
            r12 = 1023(0x3ff, float:1.434E-42)
            r13 = r6
            r6 = r9
            r9 = r8
            r20 = r12
            r12 = r7
            r7 = r20
            goto L_0x010a
        L_0x0063:
            r19 = r12
            r2 = r13
            r5 = r14
            r6 = r5
            r7 = r6
            r10 = r7
            r11 = r10
            r12 = r11
            r13 = r12
            r15 = r13
            r18 = r15
        L_0x0070:
            if (r19 == 0) goto L_0x0100
            int r4 = r0.decodeElementIndex(r1)
            switch(r4) {
                case -1: goto L_0x00f7;
                case 0: goto L_0x00e2;
                case 1: goto L_0x00d8;
                case 2: goto L_0x00cc;
                case 3: goto L_0x00c0;
                case 4: goto L_0x00b5;
                case 5: goto L_0x00a9;
                case 6: goto L_0x009e;
                case 7: goto L_0x0091;
                case 8: goto L_0x0088;
                case 9: goto L_0x007f;
                default: goto L_0x0079;
            }
        L_0x0079:
            kotlinx.serialization.UnknownFieldException r0 = new kotlinx.serialization.UnknownFieldException
            r0.<init>((int) r4)
            throw r0
        L_0x007f:
            kotlinx.serialization.internal.StringSerializer r4 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            java.lang.Object r5 = r0.decodeNullableSerializableElement(r1, r3, r4, r5)
            r2 = r2 | 512(0x200, float:7.175E-43)
            goto L_0x00b3
        L_0x0088:
            kotlinx.serialization.internal.StringSerializer r4 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            java.lang.Object r6 = r0.decodeNullableSerializableElement(r1, r9, r4, r6)
            r2 = r2 | 256(0x100, float:3.59E-43)
            goto L_0x00b3
        L_0x0091:
            kotlinx.serialization.internal.StringSerializer r4 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            r3 = 7
            java.lang.Object r10 = r0.decodeNullableSerializableElement(r1, r3, r4, r10)
            r2 = r2 | 128(0x80, float:1.794E-43)
            r4 = r3
            r3 = 9
            goto L_0x0070
        L_0x009e:
            r3 = 7
            kotlinx.serialization.internal.StringSerializer r4 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            r3 = 6
            java.lang.Object r7 = r0.decodeNullableSerializableElement(r1, r3, r4, r7)
            r2 = r2 | 64
            goto L_0x00b1
        L_0x00a9:
            r3 = 6
            r4 = 5
            java.lang.String r18 = r0.decodeStringElement(r1, r4)
            r2 = r2 | 32
        L_0x00b1:
            r3 = 9
        L_0x00b3:
            r4 = 7
            goto L_0x0070
        L_0x00b5:
            r4 = 5
            kotlinx.serialization.internal.StringSerializer r3 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            r9 = 4
            java.lang.Object r11 = r0.decodeNullableSerializableElement(r1, r9, r3, r11)
            r2 = r2 | 16
            goto L_0x00f4
        L_0x00c0:
            r4 = 5
            r9 = 4
            kotlinx.serialization.internal.StringSerializer r3 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            r9 = 3
            java.lang.Object r12 = r0.decodeNullableSerializableElement(r1, r9, r3, r12)
            r2 = r2 | 8
            goto L_0x00f4
        L_0x00cc:
            r4 = 5
            r9 = 3
            kotlinx.serialization.internal.StringSerializer r3 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            r9 = 2
            java.lang.Object r13 = r0.decodeNullableSerializableElement(r1, r9, r3, r13)
            r2 = r2 | 4
            goto L_0x00f4
        L_0x00d8:
            r3 = 1
            r4 = 5
            r9 = 2
            java.lang.String r15 = r0.decodeStringElement(r1, r3)
            r2 = r2 | 2
            goto L_0x00f4
        L_0x00e2:
            r4 = 5
            r9 = 2
            kotlinx.serialization.internal.EnumSerializer r3 = new kotlinx.serialization.internal.EnumSerializer
            com.deliveryhero.contract.model.UserType[] r4 = com.deliveryhero.contract.model.UserType.values()
            r3.<init>(r8, r4)
            r4 = 0
            java.lang.Object r14 = r0.decodeNullableSerializableElement(r1, r4, r3, r14)
            r2 = r2 | 1
        L_0x00f4:
            r3 = 9
            goto L_0x00fb
        L_0x00f7:
            r4 = 0
            r9 = 2
            r19 = r4
        L_0x00fb:
            r4 = 7
            r9 = 8
            goto L_0x0070
        L_0x0100:
            r3 = r5
            r5 = r7
            r4 = r10
            r10 = r11
            r11 = r13
            r9 = r15
            r13 = r18
            r7 = r2
            r2 = r14
        L_0x010a:
            r0.endStructure(r1)
            com.deliveryhero.customerchat.eventTracking.data.UserProperties r0 = new com.deliveryhero.customerchat.eventTracking.data.UserProperties
            r8 = r2
            com.deliveryhero.contract.model.UserType r8 = (com.deliveryhero.contract.model.UserType) r8
            r1 = r11
            java.lang.String r1 = (java.lang.String) r1
            r11 = r12
            java.lang.String r11 = (java.lang.String) r11
            r12 = r10
            java.lang.String r12 = (java.lang.String) r12
            r14 = r5
            java.lang.String r14 = (java.lang.String) r14
            r15 = r4
            java.lang.String r15 = (java.lang.String) r15
            r16 = r6
            java.lang.String r16 = (java.lang.String) r16
            r17 = r3
            java.lang.String r17 = (java.lang.String) r17
            r18 = 0
            r6 = r0
            r10 = r1
            r6.<init>((int) r7, (com.deliveryhero.contract.model.UserType) r8, (java.lang.String) r9, (java.lang.String) r10, (java.lang.String) r11, (java.lang.String) r12, (java.lang.String) r13, (java.lang.String) r14, (java.lang.String) r15, (java.lang.String) r16, (java.lang.String) r17, (kotlinx.serialization.internal.SerializationConstructorMarker) r18)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.deliveryhero.customerchat.eventTracking.data.UserProperties$$serializer.deserialize(kotlinx.serialization.encoding.Decoder):com.deliveryhero.customerchat.eventTracking.data.UserProperties");
    }

    @NotNull
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    public void serialize(@NotNull Encoder encoder, @NotNull UserProperties userProperties) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(userProperties, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder beginStructure = encoder.beginStructure(descriptor2);
        UserProperties.write$Self(userProperties, beginStructure, descriptor2);
        beginStructure.endStructure(descriptor2);
    }

    @NotNull
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
