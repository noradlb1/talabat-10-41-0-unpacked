package com.deliveryhero.fluid.content;

import com.braze.models.FeatureFlag;
import com.deliveryhero.fluid.content.serializers.ScalarValuesSerializer;
import com.facebook.AccessToken;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.talabat.fluid.homescreen.data.parser.ComponentMapper;
import java.lang.annotation.Annotation;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.PolymorphicSerializer;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.FloatSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.LinkedHashMapSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.json.JsonNames;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000<\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000*\u0004\b\u0001\u0010\u00012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\u0002B\u0007\b\u0002¢\u0006\u0002\u0010\u0004B\u0015\b\u0017\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0018\u0010\f\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\rHÖ\u0001¢\u0006\u0002\u0010\u000eJ\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\u001f\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003HÖ\u0001J\u0018\u0010\u0017\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\rHÖ\u0001¢\u0006\u0002\u0010\u000eR\u0014\u0010\b\u001a\u00020\t8VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u0018"}, d2 = {"com/deliveryhero/fluid/content/DefaultContentBuilder.$serializer", "TrackingModelT", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/deliveryhero/fluid/content/DefaultContentBuilder;", "()V", "typeSerial0", "Lkotlinx/serialization/KSerializer;", "(Lkotlinx/serialization/KSerializer;)V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "typeParametersSerializers", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
public final class DefaultContentBuilder$$serializer<TrackingModelT> implements GeneratedSerializer<DefaultContentBuilder<TrackingModelT>> {
    public final /* synthetic */ SerialDescriptor descriptor;
    private final /* synthetic */ KSerializer<TrackingModelT> typeSerial0;

    private DefaultContentBuilder$$serializer() {
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("static", this, 12);
        pluginGeneratedSerialDescriptor.addElement("id", false);
        pluginGeneratedSerialDescriptor.addElement("variation_hash", true);
        pluginGeneratedSerialDescriptor.pushAnnotation(new JsonNames.Impl(new String[]{"homescreen_variation_id"}));
        pluginGeneratedSerialDescriptor.addElement("tracking", true);
        pluginGeneratedSerialDescriptor.addElement(AccessToken.EXPIRES_IN_KEY, true);
        pluginGeneratedSerialDescriptor.pushAnnotation(new JsonNames.Impl(new String[]{"expiry"}));
        pluginGeneratedSerialDescriptor.addElement("template_id", false);
        pluginGeneratedSerialDescriptor.addElement("template_hash", false);
        pluginGeneratedSerialDescriptor.addElement(FeatureFlag.PROPERTIES, true);
        pluginGeneratedSerialDescriptor.addElement(TtmlNode.TAG_METADATA, true);
        pluginGeneratedSerialDescriptor.addElement(ComponentMapper.CELLS, true);
        pluginGeneratedSerialDescriptor.pushAnnotation(new JsonNames.Impl(new String[]{"components", FirebaseAnalytics.Param.ITEMS}));
        pluginGeneratedSerialDescriptor.addElement("width", true);
        pluginGeneratedSerialDescriptor.addElement("height", true);
        pluginGeneratedSerialDescriptor.addElement("layout_type", true);
        this.descriptor = pluginGeneratedSerialDescriptor;
    }

    @NotNull
    public KSerializer<?>[] childSerializers() {
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        FloatSerializer floatSerializer = FloatSerializer.INSTANCE;
        return new KSerializer[]{stringSerializer, BuiltinSerializersKt.getNullable(stringSerializer), BuiltinSerializersKt.getNullable(this.typeSerial0), IntSerializer.INSTANCE, stringSerializer, stringSerializer, new ScalarValuesSerializer(), new LinkedHashMapSerializer(stringSerializer, stringSerializer), new ArrayListSerializer(new PolymorphicSerializer(Reflection.getOrCreateKotlinClass(ContentBuilder.class), new Annotation[0])), BuiltinSerializersKt.getNullable(floatSerializer), BuiltinSerializersKt.getNullable(floatSerializer), BuiltinSerializersKt.getNullable(stringSerializer)};
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0189, code lost:
        r5 = r24;
        r7 = r25;
        r9 = r26;
        r15 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x018f, code lost:
        r3 = 11;
        r15 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x01b3, code lost:
        r3 = 11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00a0, code lost:
        r15 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00a0, code lost:
        r15 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00a0, code lost:
        r15 = r15;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.deliveryhero.fluid.content.DefaultContentBuilder<TrackingModelT> deserialize(@org.jetbrains.annotations.NotNull kotlinx.serialization.encoding.Decoder r29) {
        /*
            r28 = this;
            r0 = r28
            r1 = r29
            java.lang.String r2 = "decoder"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r2)
            kotlinx.serialization.descriptors.SerialDescriptor r2 = r28.getDescriptor()
            kotlinx.serialization.encoding.CompositeDecoder r1 = r1.beginStructure(r2)
            boolean r3 = r1.decodeSequentially()
            java.lang.Class<com.deliveryhero.fluid.content.ContentBuilder> r7 = com.deliveryhero.fluid.content.ContentBuilder.class
            r8 = 7
            r9 = 6
            r10 = 5
            r11 = 3
            r13 = 4
            r14 = 2
            r15 = 1
            r4 = 0
            r5 = 0
            if (r3 == 0) goto L_0x008c
            java.lang.String r3 = r1.decodeStringElement(r2, r4)
            kotlinx.serialization.internal.StringSerializer r6 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            java.lang.Object r15 = r1.decodeNullableSerializableElement(r2, r15, r6, r5)
            kotlinx.serialization.KSerializer<TrackingModelT> r12 = r0.typeSerial0
            java.lang.Object r12 = r1.decodeNullableSerializableElement(r2, r14, r12, r5)
            int r11 = r1.decodeIntElement(r2, r11)
            java.lang.String r13 = r1.decodeStringElement(r2, r13)
            java.lang.String r10 = r1.decodeStringElement(r2, r10)
            com.deliveryhero.fluid.content.serializers.ScalarValuesSerializer r14 = new com.deliveryhero.fluid.content.serializers.ScalarValuesSerializer
            r14.<init>()
            java.lang.Object r9 = r1.decodeSerializableElement(r2, r9, r14, r5)
            kotlinx.serialization.internal.LinkedHashMapSerializer r14 = new kotlinx.serialization.internal.LinkedHashMapSerializer
            r14.<init>(r6, r6)
            java.lang.Object r8 = r1.decodeSerializableElement(r2, r8, r14, r5)
            kotlinx.serialization.internal.ArrayListSerializer r14 = new kotlinx.serialization.internal.ArrayListSerializer
            kotlinx.serialization.PolymorphicSerializer r5 = new kotlinx.serialization.PolymorphicSerializer
            kotlin.reflect.KClass r7 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r7)
            java.lang.annotation.Annotation[] r4 = new java.lang.annotation.Annotation[r4]
            r5.<init>(r7, r4)
            r14.<init>(r5)
            r4 = 8
            r5 = 0
            java.lang.Object r4 = r1.decodeSerializableElement(r2, r4, r14, r5)
            kotlinx.serialization.internal.FloatSerializer r7 = kotlinx.serialization.internal.FloatSerializer.INSTANCE
            r14 = 9
            java.lang.Object r14 = r1.decodeNullableSerializableElement(r2, r14, r7, r5)
            r17 = r3
            r3 = 10
            java.lang.Object r3 = r1.decodeNullableSerializableElement(r2, r3, r7, r5)
            r7 = 11
            java.lang.Object r5 = r1.decodeNullableSerializableElement(r2, r7, r6, r5)
            r6 = 4095(0xfff, float:5.738E-42)
            r7 = r17
            r27 = r15
            r15 = r9
            r9 = r12
            r12 = r10
            r10 = r11
            r11 = r13
            r13 = r27
            goto L_0x01cf
        L_0x008c:
            r3 = 11
            r8 = r4
            r22 = r8
            r6 = r5
            r9 = r6
            r10 = r9
            r11 = r10
            r12 = r11
            r13 = r12
            r14 = r13
            r19 = r14
            r20 = r19
            r23 = r15
            r15 = r20
        L_0x00a0:
            if (r23 == 0) goto L_0x01b7
            int r4 = r1.decodeElementIndex(r2)
            switch(r4) {
                case -1: goto L_0x01ab;
                case 0: goto L_0x0194;
                case 1: goto L_0x0176;
                case 2: goto L_0x0162;
                case 3: goto L_0x0150;
                case 4: goto L_0x013d;
                case 5: goto L_0x012b;
                case 6: goto L_0x0110;
                case 7: goto L_0x00f6;
                case 8: goto L_0x00d3;
                case 9: goto L_0x00c5;
                case 10: goto L_0x00b9;
                case 11: goto L_0x00af;
                default: goto L_0x00a9;
            }
        L_0x00a9:
            kotlinx.serialization.UnknownFieldException r1 = new kotlinx.serialization.UnknownFieldException
            r1.<init>((int) r4)
            throw r1
        L_0x00af:
            kotlinx.serialization.internal.StringSerializer r4 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            java.lang.Object r9 = r1.decodeNullableSerializableElement(r2, r3, r4, r9)
            r8 = r8 | 2048(0x800, float:2.87E-42)
            goto L_0x0191
        L_0x00b9:
            kotlinx.serialization.internal.FloatSerializer r4 = kotlinx.serialization.internal.FloatSerializer.INSTANCE
            r3 = 10
            java.lang.Object r10 = r1.decodeNullableSerializableElement(r2, r3, r4, r10)
            r8 = r8 | 1024(0x400, float:1.435E-42)
            goto L_0x018f
        L_0x00c5:
            r3 = 10
            kotlinx.serialization.internal.FloatSerializer r4 = kotlinx.serialization.internal.FloatSerializer.INSTANCE
            r3 = 9
            java.lang.Object r13 = r1.decodeNullableSerializableElement(r2, r3, r4, r13)
            r8 = r8 | 512(0x200, float:7.175E-43)
            goto L_0x018f
        L_0x00d3:
            r3 = 9
            kotlinx.serialization.internal.ArrayListSerializer r4 = new kotlinx.serialization.internal.ArrayListSerializer
            kotlinx.serialization.PolymorphicSerializer r3 = new kotlinx.serialization.PolymorphicSerializer
            r24 = r5
            kotlin.reflect.KClass r5 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r7)
            r25 = r7
            r26 = r9
            r7 = 0
            java.lang.annotation.Annotation[] r9 = new java.lang.annotation.Annotation[r7]
            r3.<init>(r5, r9)
            r4.<init>(r3)
            r3 = 8
            java.lang.Object r11 = r1.decodeSerializableElement(r2, r3, r4, r11)
            r8 = r8 | 256(0x100, float:3.59E-43)
            goto L_0x0189
        L_0x00f6:
            r24 = r5
            r25 = r7
            r26 = r9
            r3 = 8
            kotlinx.serialization.internal.LinkedHashMapSerializer r4 = new kotlinx.serialization.internal.LinkedHashMapSerializer
            kotlinx.serialization.internal.StringSerializer r5 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            r4.<init>(r5, r5)
            r5 = 7
            java.lang.Object r14 = r1.decodeSerializableElement(r2, r5, r4, r14)
            r8 = r8 | 128(0x80, float:1.794E-43)
            r5 = r24
            goto L_0x018f
        L_0x0110:
            r24 = r5
            r25 = r7
            r26 = r9
            r3 = 8
            r5 = 7
            com.deliveryhero.fluid.content.serializers.ScalarValuesSerializer r4 = new com.deliveryhero.fluid.content.serializers.ScalarValuesSerializer
            r4.<init>()
            r7 = 6
            java.lang.Object r15 = r1.decodeSerializableElement(r2, r7, r4, r15)
            r8 = r8 | 64
            r5 = r24
            r7 = r25
            goto L_0x018f
        L_0x012b:
            r24 = r5
            r25 = r7
            r26 = r9
            r3 = 8
            r5 = 7
            r7 = 6
            r9 = 5
            java.lang.String r20 = r1.decodeStringElement(r2, r9)
            r8 = r8 | 32
            goto L_0x0189
        L_0x013d:
            r24 = r5
            r25 = r7
            r26 = r9
            r3 = 8
            r4 = 4
            r5 = 7
            r7 = 6
            r9 = 5
            java.lang.String r19 = r1.decodeStringElement(r2, r4)
            r8 = r8 | 16
            goto L_0x0189
        L_0x0150:
            r24 = r5
            r25 = r7
            r26 = r9
            r3 = 3
            r4 = 4
            r5 = 7
            r7 = 6
            r9 = 5
            int r22 = r1.decodeIntElement(r2, r3)
            r8 = r8 | 8
            goto L_0x0189
        L_0x0162:
            r24 = r5
            r25 = r7
            r26 = r9
            r4 = 4
            r5 = 7
            r7 = 6
            r9 = 5
            kotlinx.serialization.KSerializer<TrackingModelT> r3 = r0.typeSerial0
            r5 = 2
            java.lang.Object r12 = r1.decodeNullableSerializableElement(r2, r5, r3, r12)
            r8 = r8 | 4
            goto L_0x0189
        L_0x0176:
            r24 = r5
            r25 = r7
            r26 = r9
            r4 = 4
            r5 = 2
            r7 = 6
            r9 = 5
            kotlinx.serialization.internal.StringSerializer r3 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            r5 = 1
            java.lang.Object r6 = r1.decodeNullableSerializableElement(r2, r5, r3, r6)
            r8 = r8 | 2
        L_0x0189:
            r5 = r24
            r7 = r25
            r9 = r26
        L_0x018f:
            r3 = 11
        L_0x0191:
            r4 = 0
            goto L_0x00a0
        L_0x0194:
            r25 = r7
            r26 = r9
            r3 = 0
            r4 = 4
            r5 = 1
            r7 = 6
            r9 = 5
            java.lang.String r21 = r1.decodeStringElement(r2, r3)
            r8 = r8 | 1
            r4 = r3
            r5 = r21
            r7 = r25
            r9 = r26
            goto L_0x01b3
        L_0x01ab:
            r24 = r5
            r26 = r9
            r3 = 0
            r4 = r3
            r23 = r4
        L_0x01b3:
            r3 = 11
            goto L_0x00a0
        L_0x01b7:
            r24 = r5
            r26 = r9
            r3 = r10
            r4 = r11
            r9 = r12
            r11 = r19
            r12 = r20
            r10 = r22
            r7 = r24
            r5 = r26
            r27 = r13
            r13 = r6
            r6 = r8
            r8 = r14
            r14 = r27
        L_0x01cf:
            r1.endStructure(r2)
            com.deliveryhero.fluid.content.DefaultContentBuilder r1 = new com.deliveryhero.fluid.content.DefaultContentBuilder
            r2 = r13
            java.lang.String r2 = (java.lang.String) r2
            r13 = r15
            java.util.Map r13 = (java.util.Map) r13
            r15 = r8
            java.util.Map r15 = (java.util.Map) r15
            java.util.List r4 = (java.util.List) r4
            r16 = r14
            java.lang.Float r16 = (java.lang.Float) r16
            r17 = r3
            java.lang.Float r17 = (java.lang.Float) r17
            r18 = r5
            java.lang.String r18 = (java.lang.String) r18
            r19 = 0
            r5 = r1
            r8 = r2
            r14 = r15
            r15 = r4
            r5.<init>(r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.deliveryhero.fluid.content.DefaultContentBuilder$$serializer.deserialize(kotlinx.serialization.encoding.Decoder):com.deliveryhero.fluid.content.DefaultContentBuilder");
    }

    @NotNull
    public SerialDescriptor getDescriptor() {
        return this.descriptor;
    }

    public void serialize(@NotNull Encoder encoder, @NotNull DefaultContentBuilder<TrackingModelT> defaultContentBuilder) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(defaultContentBuilder, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder beginStructure = encoder.beginStructure(descriptor2);
        DefaultContentBuilder.write$Self(defaultContentBuilder, beginStructure, descriptor2, this.typeSerial0);
        beginStructure.endStructure(descriptor2);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: kotlinx.serialization.KSerializer<?>[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public kotlinx.serialization.KSerializer<?>[] typeParametersSerializers() {
        /*
            r3 = this;
            r0 = 1
            kotlinx.serialization.KSerializer[] r0 = new kotlinx.serialization.KSerializer[r0]
            r1 = 0
            kotlinx.serialization.KSerializer<TrackingModelT> r2 = r3.typeSerial0
            r0[r1] = r2
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.deliveryhero.fluid.content.DefaultContentBuilder$$serializer.typeParametersSerializers():kotlinx.serialization.KSerializer[]");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ DefaultContentBuilder$$serializer(KSerializer kSerializer) {
        this();
        Intrinsics.checkNotNullParameter(kSerializer, "typeSerial0");
        this.typeSerial0 = kSerializer;
    }
}
