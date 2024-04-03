package com.deliveryhero.contract.model;

import com.huawei.location.lite.common.util.DeviceInfoUtil;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.EnumSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"com/deliveryhero/contract/model/ClientConfig.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/deliveryhero/contract/model/ClientConfig;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
public final class ClientConfig$$serializer implements GeneratedSerializer<ClientConfig> {
    @NotNull
    public static final ClientConfig$$serializer INSTANCE;
    public static final /* synthetic */ SerialDescriptor descriptor;

    static {
        ClientConfig$$serializer clientConfig$$serializer = new ClientConfig$$serializer();
        INSTANCE = clientConfig$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.deliveryhero.contract.model.ClientConfig", clientConfig$$serializer, 5);
        pluginGeneratedSerialDescriptor.addElement("country", false);
        pluginGeneratedSerialDescriptor.addElement("globalEntityID", false);
        pluginGeneratedSerialDescriptor.addElement(DeviceInfoUtil.DeviceProperty.USERTYPE, false);
        pluginGeneratedSerialDescriptor.addElement("pushNotificationsTokenType", false);
        pluginGeneratedSerialDescriptor.addElement("dhEnvironment", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private ClientConfig$$serializer() {
    }

    @NotNull
    public KSerializer<?>[] childSerializers() {
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        return new KSerializer[]{stringSerializer, stringSerializer, new EnumSerializer("com.deliveryhero.contract.model.UserType", UserType.values()), new EnumSerializer("com.deliveryhero.contract.model.TokenType", TokenType.values()), new EnumSerializer("com.deliveryhero.contract.model.DhEnvironment", DhEnvironment.values())};
    }

    /* JADX WARNING: Multi-variable type inference failed */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.deliveryhero.contract.model.ClientConfig deserialize(@org.jetbrains.annotations.NotNull kotlinx.serialization.encoding.Decoder r26) {
        /*
            r25 = this;
            r0 = r26
            java.lang.String r1 = "decoder"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            kotlinx.serialization.descriptors.SerialDescriptor r1 = r25.getDescriptor()
            kotlinx.serialization.encoding.CompositeDecoder r0 = r0.beginStructure(r1)
            boolean r2 = r0.decodeSequentially()
            java.lang.String r3 = "com.deliveryhero.contract.model.DhEnvironment"
            java.lang.String r4 = "com.deliveryhero.contract.model.TokenType"
            java.lang.String r5 = "com.deliveryhero.contract.model.UserType"
            r6 = 3
            r7 = 4
            r8 = 2
            r9 = 1
            r10 = 0
            r11 = 0
            if (r2 == 0) goto L_0x005a
            java.lang.String r2 = r0.decodeStringElement(r1, r10)
            java.lang.String r9 = r0.decodeStringElement(r1, r9)
            kotlinx.serialization.internal.EnumSerializer r10 = new kotlinx.serialization.internal.EnumSerializer
            com.deliveryhero.contract.model.UserType[] r12 = com.deliveryhero.contract.model.UserType.values()
            r10.<init>(r5, r12)
            java.lang.Object r5 = r0.decodeSerializableElement(r1, r8, r10, r11)
            kotlinx.serialization.internal.EnumSerializer r8 = new kotlinx.serialization.internal.EnumSerializer
            com.deliveryhero.contract.model.TokenType[] r10 = com.deliveryhero.contract.model.TokenType.values()
            r8.<init>(r4, r10)
            java.lang.Object r4 = r0.decodeSerializableElement(r1, r6, r8, r11)
            kotlinx.serialization.internal.EnumSerializer r6 = new kotlinx.serialization.internal.EnumSerializer
            com.deliveryhero.contract.model.DhEnvironment[] r8 = com.deliveryhero.contract.model.DhEnvironment.values()
            r6.<init>(r3, r8)
            java.lang.Object r3 = r0.decodeSerializableElement(r1, r7, r6, r11)
            r6 = 31
            r19 = r2
            r18 = r6
            r20 = r9
            goto L_0x00cc
        L_0x005a:
            r16 = r9
            r2 = r10
            r12 = r11
            r13 = r12
            r14 = r13
            r15 = r14
        L_0x0061:
            if (r16 == 0) goto L_0x00c3
            int r10 = r0.decodeElementIndex(r1)
            r7 = -1
            if (r10 == r7) goto L_0x00be
            if (r10 == 0) goto L_0x00b5
            if (r10 == r9) goto L_0x00ac
            r7 = 4
            if (r10 == r8) goto L_0x009b
            if (r10 == r6) goto L_0x008b
            if (r10 != r7) goto L_0x0085
            kotlinx.serialization.internal.EnumSerializer r10 = new kotlinx.serialization.internal.EnumSerializer
            com.deliveryhero.contract.model.DhEnvironment[] r9 = com.deliveryhero.contract.model.DhEnvironment.values()
            r10.<init>(r3, r9)
            java.lang.Object r15 = r0.decodeSerializableElement(r1, r7, r10, r15)
            r2 = r2 | 16
            goto L_0x00aa
        L_0x0085:
            kotlinx.serialization.UnknownFieldException r0 = new kotlinx.serialization.UnknownFieldException
            r0.<init>((int) r10)
            throw r0
        L_0x008b:
            kotlinx.serialization.internal.EnumSerializer r9 = new kotlinx.serialization.internal.EnumSerializer
            com.deliveryhero.contract.model.TokenType[] r10 = com.deliveryhero.contract.model.TokenType.values()
            r9.<init>(r4, r10)
            java.lang.Object r14 = r0.decodeSerializableElement(r1, r6, r9, r14)
            r2 = r2 | 8
            goto L_0x00aa
        L_0x009b:
            kotlinx.serialization.internal.EnumSerializer r9 = new kotlinx.serialization.internal.EnumSerializer
            com.deliveryhero.contract.model.UserType[] r10 = com.deliveryhero.contract.model.UserType.values()
            r9.<init>(r5, r10)
            java.lang.Object r13 = r0.decodeSerializableElement(r1, r8, r9, r13)
            r2 = r2 | 4
        L_0x00aa:
            r9 = 1
            goto L_0x00b3
        L_0x00ac:
            r7 = 4
            java.lang.String r12 = r0.decodeStringElement(r1, r9)
            r2 = r2 | 2
        L_0x00b3:
            r10 = 0
            goto L_0x0061
        L_0x00b5:
            r7 = 4
            r10 = 0
            java.lang.String r11 = r0.decodeStringElement(r1, r10)
            r2 = r2 | 1
            goto L_0x0061
        L_0x00be:
            r10 = 0
            r16 = r10
            r7 = 4
            goto L_0x0061
        L_0x00c3:
            r18 = r2
            r19 = r11
            r20 = r12
            r5 = r13
            r4 = r14
            r3 = r15
        L_0x00cc:
            r0.endStructure(r1)
            com.deliveryhero.contract.model.ClientConfig r0 = new com.deliveryhero.contract.model.ClientConfig
            r21 = r5
            com.deliveryhero.contract.model.UserType r21 = (com.deliveryhero.contract.model.UserType) r21
            r22 = r4
            com.deliveryhero.contract.model.TokenType r22 = (com.deliveryhero.contract.model.TokenType) r22
            r23 = r3
            com.deliveryhero.contract.model.DhEnvironment r23 = (com.deliveryhero.contract.model.DhEnvironment) r23
            r24 = 0
            r17 = r0
            r17.<init>((int) r18, (java.lang.String) r19, (java.lang.String) r20, (com.deliveryhero.contract.model.UserType) r21, (com.deliveryhero.contract.model.TokenType) r22, (com.deliveryhero.contract.model.DhEnvironment) r23, (kotlinx.serialization.internal.SerializationConstructorMarker) r24)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.deliveryhero.contract.model.ClientConfig$$serializer.deserialize(kotlinx.serialization.encoding.Decoder):com.deliveryhero.contract.model.ClientConfig");
    }

    @NotNull
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    public void serialize(@NotNull Encoder encoder, @NotNull ClientConfig clientConfig) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(clientConfig, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder beginStructure = encoder.beginStructure(descriptor2);
        ClientConfig.write$Self(clientConfig, beginStructure, descriptor2);
        beginStructure.endStructure(descriptor2);
    }

    @NotNull
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
