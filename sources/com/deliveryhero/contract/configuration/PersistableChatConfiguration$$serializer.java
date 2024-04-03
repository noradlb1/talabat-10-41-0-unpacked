package com.deliveryhero.contract.configuration;

import com.huawei.hms.push.constant.RemoteMessageConst;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"com/deliveryhero/contract/configuration/PersistableChatConfiguration.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/deliveryhero/contract/configuration/PersistableChatConfiguration;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
public final class PersistableChatConfiguration$$serializer implements GeneratedSerializer<PersistableChatConfiguration> {
    @NotNull
    public static final PersistableChatConfiguration$$serializer INSTANCE;
    public static final /* synthetic */ SerialDescriptor descriptor;

    static {
        PersistableChatConfiguration$$serializer persistableChatConfiguration$$serializer = new PersistableChatConfiguration$$serializer();
        INSTANCE = persistableChatConfiguration$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.deliveryhero.contract.configuration.PersistableChatConfiguration", persistableChatConfiguration$$serializer, 17);
        pluginGeneratedSerialDescriptor.addElement("userInfo", true);
        pluginGeneratedSerialDescriptor.addElement("deliveryInfo", true);
        pluginGeneratedSerialDescriptor.addElement(RemoteMessageConst.Notification.CHANNEL_ID, true);
        pluginGeneratedSerialDescriptor.addElement("clientConfig", true);
        pluginGeneratedSerialDescriptor.addElement("enableVoipLogging", true);
        pluginGeneratedSerialDescriptor.addElement("stackFromEnd", true);
        pluginGeneratedSerialDescriptor.addElement("isReplyingMandatory", true);
        pluginGeneratedSerialDescriptor.addElement("quickReplies", true);
        pluginGeneratedSerialDescriptor.addElement("isPhotoSharingEnabled", true);
        pluginGeneratedSerialDescriptor.addElement("hideAdminMessages", true);
        pluginGeneratedSerialDescriptor.addElement("showSenderName", true);
        pluginGeneratedSerialDescriptor.addElement("isLocationSharingEnabled", true);
        pluginGeneratedSerialDescriptor.addElement("phoneCallingType", true);
        pluginGeneratedSerialDescriptor.addElement("translations", true);
        pluginGeneratedSerialDescriptor.addElement("isTrackingEnabled", true);
        pluginGeneratedSerialDescriptor.addElement("isFWFEnabled", true);
        pluginGeneratedSerialDescriptor.addElement("themeResID", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private PersistableChatConfiguration$$serializer() {
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: kotlinx.serialization.KSerializer<?>[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public kotlinx.serialization.KSerializer<?>[] childSerializers() {
        /*
            r4 = this;
            r0 = 17
            kotlinx.serialization.KSerializer[] r0 = new kotlinx.serialization.KSerializer[r0]
            com.deliveryhero.contract.model.UserInfo$$serializer r1 = com.deliveryhero.contract.model.UserInfo$$serializer.INSTANCE
            kotlinx.serialization.KSerializer r1 = kotlinx.serialization.builtins.BuiltinSerializersKt.getNullable(r1)
            r2 = 0
            r0[r2] = r1
            com.deliveryhero.contract.model.DeliveryInfo$$serializer r1 = com.deliveryhero.contract.model.DeliveryInfo$$serializer.INSTANCE
            kotlinx.serialization.KSerializer r1 = kotlinx.serialization.builtins.BuiltinSerializersKt.getNullable(r1)
            r2 = 1
            r0[r2] = r1
            kotlinx.serialization.internal.StringSerializer r1 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            kotlinx.serialization.KSerializer r2 = kotlinx.serialization.builtins.BuiltinSerializersKt.getNullable(r1)
            r3 = 2
            r0[r3] = r2
            com.deliveryhero.contract.model.ClientConfig$$serializer r2 = com.deliveryhero.contract.model.ClientConfig$$serializer.INSTANCE
            kotlinx.serialization.KSerializer r2 = kotlinx.serialization.builtins.BuiltinSerializersKt.getNullable(r2)
            r3 = 3
            r0[r3] = r2
            kotlinx.serialization.internal.BooleanSerializer r2 = kotlinx.serialization.internal.BooleanSerializer.INSTANCE
            r3 = 4
            r0[r3] = r2
            r3 = 5
            r0[r3] = r2
            r3 = 6
            r0[r3] = r2
            kotlinx.serialization.internal.ArrayListSerializer r3 = new kotlinx.serialization.internal.ArrayListSerializer
            r3.<init>(r1)
            r1 = 7
            r0[r1] = r3
            r1 = 8
            r0[r1] = r2
            r1 = 9
            r0[r1] = r2
            r1 = 10
            r0[r1] = r2
            r1 = 11
            r0[r1] = r2
            com.deliveryhero.contract.model.PhoneCallType$Companion r1 = com.deliveryhero.contract.model.PhoneCallType.Companion
            kotlinx.serialization.KSerializer r1 = r1.serializer()
            r3 = 12
            r0[r3] = r1
            com.deliveryhero.contract.model.Translations$Companion r1 = com.deliveryhero.contract.model.Translations.Companion
            kotlinx.serialization.KSerializer r1 = r1.serializer()
            r3 = 13
            r0[r3] = r1
            r1 = 14
            r0[r1] = r2
            r1 = 15
            r0[r1] = r2
            r1 = 16
            kotlinx.serialization.internal.IntSerializer r2 = kotlinx.serialization.internal.IntSerializer.INSTANCE
            r0[r1] = r2
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.deliveryhero.contract.configuration.PersistableChatConfiguration$$serializer.childSerializers():kotlinx.serialization.KSerializer[]");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0151, code lost:
        r5 = 16;
        r14 = r14;
        r12 = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0161, code lost:
        r5 = 16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x019f, code lost:
        r10 = r8;
        r5 = 16;
        r8 = 10;
        r14 = r14;
        r12 = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x01e0, code lost:
        r5 = 16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x01ea, code lost:
        r8 = 10;
        r14 = r14;
        r12 = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x01ec, code lost:
        r14 = r14;
        r12 = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x01ed, code lost:
        r15 = 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00d6, code lost:
        r14 = r14;
        r12 = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00d6, code lost:
        r14 = r14;
        r12 = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00d6, code lost:
        r14 = r14;
        r12 = r12;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.deliveryhero.contract.configuration.PersistableChatConfiguration deserialize(@org.jetbrains.annotations.NotNull kotlinx.serialization.encoding.Decoder r38) {
        /*
            r37 = this;
            r0 = r38
            java.lang.String r1 = "decoder"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            kotlinx.serialization.descriptors.SerialDescriptor r1 = r37.getDescriptor()
            kotlinx.serialization.encoding.CompositeDecoder r0 = r0.beginStructure(r1)
            boolean r2 = r0.decodeSequentially()
            r8 = 10
            r9 = 9
            r10 = 7
            r11 = 6
            r12 = 5
            r13 = 3
            r15 = 8
            r14 = 4
            r3 = 2
            r4 = 1
            r5 = 0
            r6 = 0
            if (r2 == 0) goto L_0x00b5
            com.deliveryhero.contract.model.UserInfo$$serializer r2 = com.deliveryhero.contract.model.UserInfo$$serializer.INSTANCE
            java.lang.Object r2 = r0.decodeNullableSerializableElement(r1, r5, r2, r6)
            com.deliveryhero.contract.model.DeliveryInfo$$serializer r5 = com.deliveryhero.contract.model.DeliveryInfo$$serializer.INSTANCE
            java.lang.Object r4 = r0.decodeNullableSerializableElement(r1, r4, r5, r6)
            kotlinx.serialization.internal.StringSerializer r5 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            java.lang.Object r3 = r0.decodeNullableSerializableElement(r1, r3, r5, r6)
            com.deliveryhero.contract.model.ClientConfig$$serializer r7 = com.deliveryhero.contract.model.ClientConfig$$serializer.INSTANCE
            java.lang.Object r7 = r0.decodeNullableSerializableElement(r1, r13, r7, r6)
            boolean r13 = r0.decodeBooleanElement(r1, r14)
            boolean r12 = r0.decodeBooleanElement(r1, r12)
            boolean r11 = r0.decodeBooleanElement(r1, r11)
            kotlinx.serialization.internal.ArrayListSerializer r14 = new kotlinx.serialization.internal.ArrayListSerializer
            r14.<init>(r5)
            java.lang.Object r5 = r0.decodeSerializableElement(r1, r10, r14, r6)
            boolean r10 = r0.decodeBooleanElement(r1, r15)
            boolean r9 = r0.decodeBooleanElement(r1, r9)
            boolean r8 = r0.decodeBooleanElement(r1, r8)
            r14 = 11
            boolean r14 = r0.decodeBooleanElement(r1, r14)
            com.deliveryhero.contract.model.PhoneCallType$Companion r15 = com.deliveryhero.contract.model.PhoneCallType.Companion
            kotlinx.serialization.KSerializer r15 = r15.serializer()
            r20 = r2
            r2 = 12
            java.lang.Object r2 = r0.decodeSerializableElement(r1, r2, r15, r6)
            com.deliveryhero.contract.model.Translations$Companion r15 = com.deliveryhero.contract.model.Translations.Companion
            kotlinx.serialization.KSerializer r15 = r15.serializer()
            r19 = r2
            r2 = 13
            java.lang.Object r2 = r0.decodeSerializableElement(r1, r2, r15, r6)
            r6 = 14
            boolean r6 = r0.decodeBooleanElement(r1, r6)
            r15 = 15
            boolean r15 = r0.decodeBooleanElement(r1, r15)
            r16 = r5
            r5 = 16
            int r5 = r0.decodeIntElement(r1, r5)
            r17 = 131071(0x1ffff, float:1.8367E-40)
            r33 = r5
            r31 = r6
            r27 = r8
            r26 = r9
            r25 = r10
            r23 = r11
            r22 = r12
            r21 = r13
            r28 = r14
            r32 = r15
            r5 = r16
            r16 = r17
            r14 = r19
            r12 = r2
            r2 = r20
            goto L_0x020d
        L_0x00b5:
            r2 = r5
            r5 = 16
            r11 = r2
            r26 = r11
            r27 = r26
            r28 = r27
            r29 = r28
            r30 = r29
            r31 = r30
            r32 = r31
            r33 = r32
            r34 = r33
            r35 = r4
            r3 = r6
            r4 = r3
            r7 = r4
            r12 = r7
            r13 = r12
            r14 = r13
            r2 = r14
            r6 = r34
        L_0x00d6:
            if (r35 == 0) goto L_0x01f1
            int r10 = r0.decodeElementIndex(r1)
            switch(r10) {
                case -1: goto L_0x01e3;
                case 0: goto L_0x01d2;
                case 1: goto L_0x01c3;
                case 2: goto L_0x01b4;
                case 3: goto L_0x01a5;
                case 4: goto L_0x0193;
                case 5: goto L_0x0186;
                case 6: goto L_0x0179;
                case 7: goto L_0x0166;
                case 8: goto L_0x0155;
                case 9: goto L_0x0145;
                case 10: goto L_0x0138;
                case 11: goto L_0x012b;
                case 12: goto L_0x0118;
                case 13: goto L_0x0105;
                case 14: goto L_0x00fa;
                case 15: goto L_0x00ee;
                case 16: goto L_0x00e5;
                default: goto L_0x00df;
            }
        L_0x00df:
            kotlinx.serialization.UnknownFieldException r0 = new kotlinx.serialization.UnknownFieldException
            r0.<init>((int) r10)
            throw r0
        L_0x00e5:
            int r6 = r0.decodeIntElement(r1, r5)
            r10 = 65536(0x10000, float:9.18355E-41)
            r11 = r11 | r10
            goto L_0x0163
        L_0x00ee:
            r10 = 15
            boolean r34 = r0.decodeBooleanElement(r1, r10)
            r16 = 32768(0x8000, float:4.5918E-41)
            r11 = r11 | r16
            goto L_0x0163
        L_0x00fa:
            r5 = 14
            r10 = 15
            boolean r26 = r0.decodeBooleanElement(r1, r5)
            r11 = r11 | 16384(0x4000, float:2.2959E-41)
            goto L_0x0161
        L_0x0105:
            r5 = 14
            r10 = 15
            com.deliveryhero.contract.model.Translations$Companion r17 = com.deliveryhero.contract.model.Translations.Companion
            kotlinx.serialization.KSerializer r5 = r17.serializer()
            r15 = 13
            java.lang.Object r12 = r0.decodeSerializableElement(r1, r15, r5, r12)
            r11 = r11 | 8192(0x2000, float:1.14794E-41)
            goto L_0x0151
        L_0x0118:
            r10 = 15
            r15 = 13
            com.deliveryhero.contract.model.PhoneCallType$Companion r5 = com.deliveryhero.contract.model.PhoneCallType.Companion
            kotlinx.serialization.KSerializer r5 = r5.serializer()
            r15 = 12
            java.lang.Object r14 = r0.decodeSerializableElement(r1, r15, r5, r14)
            r11 = r11 | 4096(0x1000, float:5.74E-42)
            goto L_0x0151
        L_0x012b:
            r5 = 11
            r10 = 15
            r15 = 12
            boolean r33 = r0.decodeBooleanElement(r1, r5)
            r11 = r11 | 2048(0x800, float:2.87E-42)
            goto L_0x0151
        L_0x0138:
            r5 = 11
            r10 = 15
            r15 = 12
            boolean r27 = r0.decodeBooleanElement(r1, r8)
            r11 = r11 | 1024(0x400, float:1.435E-42)
            goto L_0x0151
        L_0x0145:
            r5 = 11
            r10 = 15
            r15 = 12
            boolean r28 = r0.decodeBooleanElement(r1, r9)
            r11 = r11 | 512(0x200, float:7.175E-43)
        L_0x0151:
            r5 = 16
            goto L_0x01ec
        L_0x0155:
            r5 = r15
            r10 = 15
            r15 = 12
            boolean r29 = r0.decodeBooleanElement(r1, r5)
            r11 = r11 | 256(0x100, float:3.59E-43)
            r15 = r5
        L_0x0161:
            r5 = 16
        L_0x0163:
            r10 = 7
            goto L_0x00d6
        L_0x0166:
            r10 = 15
            r15 = 12
            kotlinx.serialization.internal.ArrayListSerializer r5 = new kotlinx.serialization.internal.ArrayListSerializer
            kotlinx.serialization.internal.StringSerializer r8 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            r5.<init>(r8)
            r8 = 7
            java.lang.Object r13 = r0.decodeSerializableElement(r1, r8, r5, r13)
            r11 = r11 | 128(0x80, float:1.794E-43)
            goto L_0x019f
        L_0x0179:
            r5 = 6
            r8 = 7
            r10 = 15
            r15 = 12
            boolean r30 = r0.decodeBooleanElement(r1, r5)
            r11 = r11 | 64
            goto L_0x019f
        L_0x0186:
            r5 = 5
            r8 = 7
            r10 = 15
            r15 = 12
            boolean r31 = r0.decodeBooleanElement(r1, r5)
            r11 = r11 | 32
            goto L_0x019f
        L_0x0193:
            r5 = 4
            r8 = 7
            r10 = 15
            r15 = 12
            boolean r32 = r0.decodeBooleanElement(r1, r5)
            r11 = r11 | 16
        L_0x019f:
            r10 = r8
            r5 = 16
            r8 = 10
            goto L_0x01ed
        L_0x01a5:
            r8 = 7
            r10 = 15
            r15 = 12
            com.deliveryhero.contract.model.ClientConfig$$serializer r5 = com.deliveryhero.contract.model.ClientConfig$$serializer.INSTANCE
            r8 = 3
            java.lang.Object r3 = r0.decodeNullableSerializableElement(r1, r8, r5, r3)
            r11 = r11 | 8
            goto L_0x01e0
        L_0x01b4:
            r8 = 3
            r10 = 15
            r15 = 12
            kotlinx.serialization.internal.StringSerializer r5 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            r8 = 2
            java.lang.Object r4 = r0.decodeNullableSerializableElement(r1, r8, r5, r4)
            r11 = r11 | 4
            goto L_0x01e0
        L_0x01c3:
            r8 = 2
            r10 = 15
            r15 = 12
            com.deliveryhero.contract.model.DeliveryInfo$$serializer r5 = com.deliveryhero.contract.model.DeliveryInfo$$serializer.INSTANCE
            r8 = 1
            java.lang.Object r2 = r0.decodeNullableSerializableElement(r1, r8, r5, r2)
            r11 = r11 | 2
            goto L_0x01e0
        L_0x01d2:
            r8 = 1
            r10 = 15
            r15 = 12
            com.deliveryhero.contract.model.UserInfo$$serializer r5 = com.deliveryhero.contract.model.UserInfo$$serializer.INSTANCE
            r8 = 0
            java.lang.Object r7 = r0.decodeNullableSerializableElement(r1, r8, r5, r7)
            r11 = r11 | 1
        L_0x01e0:
            r5 = 16
            goto L_0x01ea
        L_0x01e3:
            r8 = 0
            r10 = 15
            r15 = 12
            r35 = r8
        L_0x01ea:
            r8 = 10
        L_0x01ec:
            r10 = 7
        L_0x01ed:
            r15 = 8
            goto L_0x00d6
        L_0x01f1:
            r16 = r11
            r5 = r13
            r25 = r29
            r23 = r30
            r22 = r31
            r21 = r32
            r32 = r34
            r31 = r26
            r26 = r28
            r28 = r33
            r33 = r6
            r36 = r4
            r4 = r2
            r2 = r7
            r7 = r3
            r3 = r36
        L_0x020d:
            r0.endStructure(r1)
            com.deliveryhero.contract.configuration.PersistableChatConfiguration r0 = new com.deliveryhero.contract.configuration.PersistableChatConfiguration
            r15 = r0
            r17 = r2
            com.deliveryhero.contract.model.UserInfo r17 = (com.deliveryhero.contract.model.UserInfo) r17
            r18 = r4
            com.deliveryhero.contract.model.DeliveryInfo r18 = (com.deliveryhero.contract.model.DeliveryInfo) r18
            r19 = r3
            java.lang.String r19 = (java.lang.String) r19
            r20 = r7
            com.deliveryhero.contract.model.ClientConfig r20 = (com.deliveryhero.contract.model.ClientConfig) r20
            r24 = r5
            java.util.List r24 = (java.util.List) r24
            r29 = r14
            com.deliveryhero.contract.model.PhoneCallType r29 = (com.deliveryhero.contract.model.PhoneCallType) r29
            r30 = r12
            com.deliveryhero.contract.model.Translations r30 = (com.deliveryhero.contract.model.Translations) r30
            r34 = 0
            r15.<init>((int) r16, (com.deliveryhero.contract.model.UserInfo) r17, (com.deliveryhero.contract.model.DeliveryInfo) r18, (java.lang.String) r19, (com.deliveryhero.contract.model.ClientConfig) r20, (boolean) r21, (boolean) r22, (boolean) r23, (java.util.List) r24, (boolean) r25, (boolean) r26, (boolean) r27, (boolean) r28, (com.deliveryhero.contract.model.PhoneCallType) r29, (com.deliveryhero.contract.model.Translations) r30, (boolean) r31, (boolean) r32, (int) r33, (kotlinx.serialization.internal.SerializationConstructorMarker) r34)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.deliveryhero.contract.configuration.PersistableChatConfiguration$$serializer.deserialize(kotlinx.serialization.encoding.Decoder):com.deliveryhero.contract.configuration.PersistableChatConfiguration");
    }

    @NotNull
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    public void serialize(@NotNull Encoder encoder, @NotNull PersistableChatConfiguration persistableChatConfiguration) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(persistableChatConfiguration, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder beginStructure = encoder.beginStructure(descriptor2);
        PersistableChatConfiguration.write$Self(persistableChatConfiguration, beginStructure, descriptor2);
        beginStructure.endStructure(descriptor2);
    }

    @NotNull
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
