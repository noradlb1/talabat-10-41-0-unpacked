package com.deliveryhero.contract.model;

import androidx.autofill.HintConstants;
import com.tekartik.sqflite.Constant;
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
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"com/deliveryhero/contract/model/DeliveryInfo.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/deliveryhero/contract/model/DeliveryInfo;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
public final class DeliveryInfo$$serializer implements GeneratedSerializer<DeliveryInfo> {
    @NotNull
    public static final DeliveryInfo$$serializer INSTANCE;
    public static final /* synthetic */ SerialDescriptor descriptor;

    static {
        DeliveryInfo$$serializer deliveryInfo$$serializer = new DeliveryInfo$$serializer();
        INSTANCE = deliveryInfo$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.deliveryhero.contract.model.DeliveryInfo", deliveryInfo$$serializer, 7);
        pluginGeneratedSerialDescriptor.addElement("id", false);
        pluginGeneratedSerialDescriptor.addElement(Constant.PARAM_ERROR_CODE, false);
        pluginGeneratedSerialDescriptor.addElement("amount", false);
        pluginGeneratedSerialDescriptor.addElement("address", false);
        pluginGeneratedSerialDescriptor.addElement("comments", false);
        pluginGeneratedSerialDescriptor.addElement("customer", false);
        pluginGeneratedSerialDescriptor.addElement(HintConstants.AUTOFILL_HINT_PHONE_NUMBER, false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private DeliveryInfo$$serializer() {
    }

    @NotNull
    public KSerializer<?>[] childSerializers() {
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        return new KSerializer[]{LongSerializer.INSTANCE, BuiltinSerializersKt.getNullable(stringSerializer), BuiltinSerializersKt.getNullable(stringSerializer), BuiltinSerializersKt.getNullable(stringSerializer), BuiltinSerializersKt.getNullable(stringSerializer), BuiltinSerializersKt.getNullable(stringSerializer), BuiltinSerializersKt.getNullable(stringSerializer)};
    }

    /* JADX WARNING: Multi-variable type inference failed */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.deliveryhero.contract.model.DeliveryInfo deserialize(@org.jetbrains.annotations.NotNull kotlinx.serialization.encoding.Decoder r22) {
        /*
            r21 = this;
            r0 = r22
            java.lang.String r1 = "decoder"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            kotlinx.serialization.descriptors.SerialDescriptor r1 = r21.getDescriptor()
            kotlinx.serialization.encoding.CompositeDecoder r0 = r0.beginStructure(r1)
            boolean r2 = r0.decodeSequentially()
            r3 = 6
            r4 = 5
            r5 = 3
            r6 = 4
            r7 = 2
            r8 = 1
            r9 = 0
            r10 = 0
            if (r2 == 0) goto L_0x0047
            long r11 = r0.decodeLongElement(r1, r9)
            kotlinx.serialization.internal.StringSerializer r2 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            java.lang.Object r8 = r0.decodeNullableSerializableElement(r1, r8, r2, r10)
            java.lang.Object r7 = r0.decodeNullableSerializableElement(r1, r7, r2, r10)
            java.lang.Object r5 = r0.decodeNullableSerializableElement(r1, r5, r2, r10)
            java.lang.Object r6 = r0.decodeNullableSerializableElement(r1, r6, r2, r10)
            java.lang.Object r4 = r0.decodeNullableSerializableElement(r1, r4, r2, r10)
            java.lang.Object r2 = r0.decodeNullableSerializableElement(r1, r3, r2, r10)
            r3 = 127(0x7f, float:1.78E-43)
            r14 = r4
            r13 = r6
            r4 = r3
            r19 = r11
            r12 = r5
            r5 = r19
            goto L_0x00ab
        L_0x0047:
            r11 = 0
            r18 = r8
            r2 = r9
            r13 = r10
            r14 = r13
            r15 = r14
            r16 = r11
            r11 = r15
            r12 = r11
        L_0x0053:
            if (r18 == 0) goto L_0x00a5
            int r9 = r0.decodeElementIndex(r1)
            switch(r9) {
                case -1: goto L_0x00a1;
                case 0: goto L_0x0099;
                case 1: goto L_0x008f;
                case 2: goto L_0x0086;
                case 3: goto L_0x007d;
                case 4: goto L_0x0074;
                case 5: goto L_0x006b;
                case 6: goto L_0x0062;
                default: goto L_0x005c;
            }
        L_0x005c:
            kotlinx.serialization.UnknownFieldException r0 = new kotlinx.serialization.UnknownFieldException
            r0.<init>((int) r9)
            throw r0
        L_0x0062:
            kotlinx.serialization.internal.StringSerializer r9 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            java.lang.Object r15 = r0.decodeNullableSerializableElement(r1, r3, r9, r15)
            r2 = r2 | 64
            goto L_0x0097
        L_0x006b:
            kotlinx.serialization.internal.StringSerializer r9 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            java.lang.Object r14 = r0.decodeNullableSerializableElement(r1, r4, r9, r14)
            r2 = r2 | 32
            goto L_0x0097
        L_0x0074:
            kotlinx.serialization.internal.StringSerializer r9 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            java.lang.Object r13 = r0.decodeNullableSerializableElement(r1, r6, r9, r13)
            r2 = r2 | 16
            goto L_0x0097
        L_0x007d:
            kotlinx.serialization.internal.StringSerializer r9 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            java.lang.Object r12 = r0.decodeNullableSerializableElement(r1, r5, r9, r12)
            r2 = r2 | 8
            goto L_0x0097
        L_0x0086:
            kotlinx.serialization.internal.StringSerializer r9 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            java.lang.Object r11 = r0.decodeNullableSerializableElement(r1, r7, r9, r11)
            r2 = r2 | 4
            goto L_0x0097
        L_0x008f:
            kotlinx.serialization.internal.StringSerializer r9 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            java.lang.Object r10 = r0.decodeNullableSerializableElement(r1, r8, r9, r10)
            r2 = r2 | 2
        L_0x0097:
            r9 = 0
            goto L_0x0053
        L_0x0099:
            r9 = 0
            long r16 = r0.decodeLongElement(r1, r9)
            r2 = r2 | 1
            goto L_0x0053
        L_0x00a1:
            r9 = 0
            r18 = r9
            goto L_0x0053
        L_0x00a5:
            r4 = r2
            r8 = r10
            r7 = r11
            r2 = r15
            r5 = r16
        L_0x00ab:
            r0.endStructure(r1)
            com.deliveryhero.contract.model.DeliveryInfo r0 = new com.deliveryhero.contract.model.DeliveryInfo
            r1 = r8
            java.lang.String r1 = (java.lang.String) r1
            r8 = r7
            java.lang.String r8 = (java.lang.String) r8
            r9 = r12
            java.lang.String r9 = (java.lang.String) r9
            r10 = r13
            java.lang.String r10 = (java.lang.String) r10
            r11 = r14
            java.lang.String r11 = (java.lang.String) r11
            r12 = r2
            java.lang.String r12 = (java.lang.String) r12
            r13 = 0
            r3 = r0
            r7 = r1
            r3.<init>(r4, r5, r7, r8, r9, r10, r11, r12, r13)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.deliveryhero.contract.model.DeliveryInfo$$serializer.deserialize(kotlinx.serialization.encoding.Decoder):com.deliveryhero.contract.model.DeliveryInfo");
    }

    @NotNull
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    public void serialize(@NotNull Encoder encoder, @NotNull DeliveryInfo deliveryInfo) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(deliveryInfo, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder beginStructure = encoder.beginStructure(descriptor2);
        DeliveryInfo.write$Self(deliveryInfo, beginStructure, descriptor2);
        beginStructure.endStructure(descriptor2);
    }

    @NotNull
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
