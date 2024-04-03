package com.deliveryhero.fluid.widgets.lottie;

import com.deliveryhero.fluid.expression.placeholder.PlaceholderSurrogate$$serializer;
import com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer;
import com.deliveryhero.fluid.values.Color$$serializer;
import com.deliveryhero.fluid.values.LinearGradientOrientation$$serializer;
import com.deliveryhero.fluid.values.LogicalPixel$$serializer;
import com.deliveryhero.fluid.values.Shape$$serializer;
import com.deliveryhero.fluid.values.Size;
import com.deliveryhero.fluid.widgets.containers.HorizontalAlignment;
import com.deliveryhero.fluid.widgets.containers.VerticalAlignment;
import com.facebook.internal.AnalyticsEvents;
import com.huawei.hms.flutter.map.constants.Param;
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
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.EnumSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.LinkedHashSetSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"com/deliveryhero/fluid/widgets/lottie/LottieModelBuilder.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/deliveryhero/fluid/widgets/lottie/LottieModelBuilder;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
public final class LottieModelBuilder$$serializer implements GeneratedSerializer<LottieModelBuilder> {
    @NotNull
    public static final LottieModelBuilder$$serializer INSTANCE;
    public static final /* synthetic */ SerialDescriptor descriptor;

    static {
        LottieModelBuilder$$serializer lottieModelBuilder$$serializer = new LottieModelBuilder$$serializer();
        INSTANCE = lottieModelBuilder$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("lottie_animation", lottieModelBuilder$$serializer, 35);
        pluginGeneratedSerialDescriptor.addElement("id", true);
        pluginGeneratedSerialDescriptor.addElement("hash", true);
        pluginGeneratedSerialDescriptor.addElement("placeholders", true);
        pluginGeneratedSerialDescriptor.addElement("width", true);
        pluginGeneratedSerialDescriptor.addElement("height", true);
        pluginGeneratedSerialDescriptor.addElement("is_visible", true);
        pluginGeneratedSerialDescriptor.addElement("expansion_resistance_priority", true);
        pluginGeneratedSerialDescriptor.addElement("compression_resistance_priority", true);
        pluginGeneratedSerialDescriptor.addElement("background_colors", true);
        pluginGeneratedSerialDescriptor.addElement("background_shape", true);
        pluginGeneratedSerialDescriptor.addElement("background_gradient_orientation", true);
        pluginGeneratedSerialDescriptor.addElement("background_radius_top_left", true);
        pluginGeneratedSerialDescriptor.addElement("background_radius_top_right", true);
        pluginGeneratedSerialDescriptor.addElement("background_radius_bottom_right", true);
        pluginGeneratedSerialDescriptor.addElement("background_radius_bottom_left", true);
        pluginGeneratedSerialDescriptor.addElement("background_radius", true);
        pluginGeneratedSerialDescriptor.addElement("border_width", true);
        pluginGeneratedSerialDescriptor.addElement("border_color", true);
        pluginGeneratedSerialDescriptor.addElement("elevation", true);
        pluginGeneratedSerialDescriptor.addElement("clip_to_bounds", true);
        pluginGeneratedSerialDescriptor.addElement("padding_leading", true);
        pluginGeneratedSerialDescriptor.addElement("padding_top", true);
        pluginGeneratedSerialDescriptor.addElement("padding_trailing", true);
        pluginGeneratedSerialDescriptor.addElement("padding_bottom", true);
        pluginGeneratedSerialDescriptor.addElement("margin_leading", true);
        pluginGeneratedSerialDescriptor.addElement("margin_top", true);
        pluginGeneratedSerialDescriptor.addElement("margin_trailing", true);
        pluginGeneratedSerialDescriptor.addElement("margin_bottom", true);
        pluginGeneratedSerialDescriptor.addElement(AnalyticsEvents.PARAMETER_LIKE_VIEW_HORIZONTAL_ALIGNMENT, true);
        pluginGeneratedSerialDescriptor.addElement("vertical_alignment", true);
        pluginGeneratedSerialDescriptor.addElement("accessibility_tag", true);
        pluginGeneratedSerialDescriptor.addElement("accessibility_label", true);
        pluginGeneratedSerialDescriptor.addElement("on_click", true);
        pluginGeneratedSerialDescriptor.addElement(Param.ANIMATION, true);
        pluginGeneratedSerialDescriptor.addElement("animation_repeat_count", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private LottieModelBuilder$$serializer() {
    }

    @NotNull
    public KSerializer<?>[] childSerializers() {
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        Class<Size> cls = Size.class;
        BooleanSerializer booleanSerializer = BooleanSerializer.INSTANCE;
        IntSerializer intSerializer = IntSerializer.INSTANCE;
        Color$$serializer color$$serializer = Color$$serializer.INSTANCE;
        LogicalPixel$$serializer logicalPixel$$serializer = LogicalPixel$$serializer.INSTANCE;
        return new KSerializer[]{BuiltinSerializersKt.getNullable(stringSerializer), BuiltinSerializersKt.getNullable(stringSerializer), new LinkedHashSetSerializer(PlaceholderSurrogate$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(new ExpressionBuilderSerializer(new PolymorphicSerializer(Reflection.getOrCreateKotlinClass(cls), new Annotation[0]))), BuiltinSerializersKt.getNullable(new ExpressionBuilderSerializer(new PolymorphicSerializer(Reflection.getOrCreateKotlinClass(cls), new Annotation[0]))), BuiltinSerializersKt.getNullable(new ExpressionBuilderSerializer(booleanSerializer)), BuiltinSerializersKt.getNullable(new ExpressionBuilderSerializer(intSerializer)), BuiltinSerializersKt.getNullable(new ExpressionBuilderSerializer(intSerializer)), BuiltinSerializersKt.getNullable(new ArrayListSerializer(new ExpressionBuilderSerializer(color$$serializer))), BuiltinSerializersKt.getNullable(new ExpressionBuilderSerializer(Shape$$serializer.INSTANCE)), BuiltinSerializersKt.getNullable(new ExpressionBuilderSerializer(LinearGradientOrientation$$serializer.INSTANCE)), BuiltinSerializersKt.getNullable(new ExpressionBuilderSerializer(logicalPixel$$serializer)), BuiltinSerializersKt.getNullable(new ExpressionBuilderSerializer(logicalPixel$$serializer)), BuiltinSerializersKt.getNullable(new ExpressionBuilderSerializer(logicalPixel$$serializer)), BuiltinSerializersKt.getNullable(new ExpressionBuilderSerializer(logicalPixel$$serializer)), BuiltinSerializersKt.getNullable(new ExpressionBuilderSerializer(logicalPixel$$serializer)), BuiltinSerializersKt.getNullable(new ExpressionBuilderSerializer(logicalPixel$$serializer)), BuiltinSerializersKt.getNullable(new ExpressionBuilderSerializer(color$$serializer)), BuiltinSerializersKt.getNullable(new ExpressionBuilderSerializer(logicalPixel$$serializer)), BuiltinSerializersKt.getNullable(new ExpressionBuilderSerializer(booleanSerializer)), BuiltinSerializersKt.getNullable(new ExpressionBuilderSerializer(logicalPixel$$serializer)), BuiltinSerializersKt.getNullable(new ExpressionBuilderSerializer(logicalPixel$$serializer)), BuiltinSerializersKt.getNullable(new ExpressionBuilderSerializer(logicalPixel$$serializer)), BuiltinSerializersKt.getNullable(new ExpressionBuilderSerializer(logicalPixel$$serializer)), BuiltinSerializersKt.getNullable(new ExpressionBuilderSerializer(logicalPixel$$serializer)), BuiltinSerializersKt.getNullable(new ExpressionBuilderSerializer(logicalPixel$$serializer)), BuiltinSerializersKt.getNullable(new ExpressionBuilderSerializer(logicalPixel$$serializer)), BuiltinSerializersKt.getNullable(new ExpressionBuilderSerializer(logicalPixel$$serializer)), BuiltinSerializersKt.getNullable(new ExpressionBuilderSerializer(new EnumSerializer("com.deliveryhero.fluid.widgets.containers.HorizontalAlignment", HorizontalAlignment.values()))), BuiltinSerializersKt.getNullable(new ExpressionBuilderSerializer(new EnumSerializer("com.deliveryhero.fluid.widgets.containers.VerticalAlignment", VerticalAlignment.values()))), BuiltinSerializersKt.getNullable(new ExpressionBuilderSerializer(stringSerializer)), BuiltinSerializersKt.getNullable(new ExpressionBuilderSerializer(stringSerializer)), BuiltinSerializersKt.getNullable(new ExpressionBuilderSerializer(stringSerializer)), BuiltinSerializersKt.getNullable(new ExpressionBuilderSerializer(stringSerializer)), BuiltinSerializersKt.getNullable(new ExpressionBuilderSerializer(RepeatCount.Companion.serializer()))};
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r57v0, resolved type: com.deliveryhero.fluid.expression.ExpressionBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r40v0, resolved type: com.deliveryhero.fluid.expression.ExpressionBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r39v0, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r40v1, resolved type: com.deliveryhero.fluid.expression.ExpressionBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r57v1, resolved type: com.deliveryhero.fluid.expression.ExpressionBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v2, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r57v2, resolved type: com.deliveryhero.fluid.expression.ExpressionBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r40v2, resolved type: com.deliveryhero.fluid.expression.ExpressionBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r39v1, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v3, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r57v3, resolved type: com.deliveryhero.fluid.expression.ExpressionBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r56v2, resolved type: com.deliveryhero.fluid.expression.ExpressionBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r40v3, resolved type: com.deliveryhero.fluid.expression.ExpressionBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v6, resolved type: com.deliveryhero.fluid.expression.ExpressionBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r64v3, resolved type: com.deliveryhero.fluid.expression.ExpressionBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r40v4, resolved type: com.deliveryhero.fluid.expression.ExpressionBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r40v5, resolved type: com.deliveryhero.fluid.expression.ExpressionBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v12, resolved type: com.deliveryhero.fluid.expression.ExpressionBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r39v6, resolved type: com.deliveryhero.fluid.expression.ExpressionBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r38v7, resolved type: java.util.Set} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r39v7, resolved type: com.deliveryhero.fluid.expression.ExpressionBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v20, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r40v6, resolved type: com.deliveryhero.fluid.expression.ExpressionBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r57v4, resolved type: com.deliveryhero.fluid.expression.ExpressionBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v57, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r57v5, resolved type: com.deliveryhero.fluid.expression.ExpressionBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v19, resolved type: com.deliveryhero.fluid.expression.ExpressionBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v37, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v104, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r28v0, resolved type: com.deliveryhero.fluid.expression.ExpressionBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r40v7, resolved type: com.deliveryhero.fluid.expression.ExpressionBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r57v6, resolved type: com.deliveryhero.fluid.expression.ExpressionBuilder} */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x02a6, code lost:
        r7 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x02d6, code lost:
        r34 = r42;
        r35 = r43;
        r29 = r44;
        r27 = r46;
        r26 = r47;
        r25 = r48;
        r23 = r49;
        r22 = r50;
        r21 = r51;
        r20 = r52;
        r18 = r53;
        r16 = r55;
        r15 = r60;
        r7 = r62;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0339, code lost:
        r34 = r42;
        r35 = r43;
        r29 = r44;
        r27 = r46;
        r26 = r47;
        r25 = r48;
        r23 = r49;
        r22 = r50;
        r21 = r51;
        r20 = r52;
        r18 = r53;
        r16 = r55;
        r15 = r60;
        r2 = r61;
        r7 = r62;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x03e7, code lost:
        r34 = r42;
        r35 = r43;
        r29 = r44;
        r27 = r46;
        r26 = r47;
        r25 = r48;
        r23 = r49;
        r22 = r50;
        r21 = r51;
        r20 = r52;
        r18 = r53;
        r16 = r55;
        r15 = r60;
        r2 = r61;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0403, code lost:
        r5 = r63;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0405, code lost:
        r60 = r3;
        r44 = r41;
        r55 = r45;
        r62 = r54;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x04ab, code lost:
        r34 = r42;
        r35 = r43;
        r29 = r44;
        r27 = r46;
        r26 = r47;
        r25 = r48;
        r23 = r49;
        r22 = r50;
        r21 = r51;
        r20 = r52;
        r18 = r53;
        r62 = r54;
        r16 = r55;
        r2 = r61;
        r5 = r63;
        r44 = r41;
        r55 = r45;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x07a2, code lost:
        r2 = r61;
        r5 = r63;
        r44 = r41;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x08bc, code lost:
        r2 = r61;
        r5 = r63;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x09e0, code lost:
        r4 = r17;
        r2 = r61;
        r5 = r63;
        r7 = r64;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0a69, code lost:
        r4 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0a6b, code lost:
        r2 = r61;
        r5 = r63;
        r7 = r64;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0a71, code lost:
        r53 = r18;
        r52 = r20;
        r51 = r21;
        r50 = r22;
        r49 = r23;
        r48 = r25;
        r47 = r26;
        r46 = r27;
        r42 = r34;
        r43 = r35;
        r41 = r44;
        r45 = r55;
        r3 = r60;
        r54 = r62;
        r55 = r16;
        r44 = r29;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.deliveryhero.fluid.widgets.lottie.LottieModelBuilder deserialize(@org.jetbrains.annotations.NotNull kotlinx.serialization.encoding.Decoder r102) {
        /*
            r101 = this;
            r0 = r102
            java.lang.String r1 = "decoder"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            kotlinx.serialization.descriptors.SerialDescriptor r1 = r101.getDescriptor()
            kotlinx.serialization.encoding.CompositeDecoder r0 = r0.beginStructure(r1)
            boolean r2 = r0.decodeSequentially()
            r12 = 6
            r13 = 5
            r14 = 3
            r4 = 7
            r15 = 4
            java.lang.Class<com.deliveryhero.fluid.values.Size> r19 = com.deliveryhero.fluid.values.Size.class
            r5 = 2
            r6 = 1
            r7 = 0
            r8 = 0
            if (r2 == 0) goto L_0x0217
            kotlinx.serialization.internal.StringSerializer r2 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            java.lang.Object r24 = r0.decodeNullableSerializableElement(r1, r7, r2, r8)
            java.lang.Object r6 = r0.decodeNullableSerializableElement(r1, r6, r2, r8)
            kotlinx.serialization.internal.LinkedHashSetSerializer r9 = new kotlinx.serialization.internal.LinkedHashSetSerializer
            com.deliveryhero.fluid.expression.placeholder.PlaceholderSurrogate$$serializer r10 = com.deliveryhero.fluid.expression.placeholder.PlaceholderSurrogate$$serializer.INSTANCE
            r9.<init>(r10)
            java.lang.Object r5 = r0.decodeSerializableElement(r1, r5, r9, r8)
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r9 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            kotlinx.serialization.PolymorphicSerializer r10 = new kotlinx.serialization.PolymorphicSerializer
            kotlin.reflect.KClass r11 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r19)
            java.lang.annotation.Annotation[] r3 = new java.lang.annotation.Annotation[r7]
            r10.<init>(r11, r3)
            r9.<init>(r10)
            java.lang.Object r3 = r0.decodeNullableSerializableElement(r1, r14, r9, r8)
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r9 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            kotlinx.serialization.PolymorphicSerializer r10 = new kotlinx.serialization.PolymorphicSerializer
            kotlin.reflect.KClass r11 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r19)
            java.lang.annotation.Annotation[] r7 = new java.lang.annotation.Annotation[r7]
            r10.<init>(r11, r7)
            r9.<init>(r10)
            java.lang.Object r7 = r0.decodeNullableSerializableElement(r1, r15, r9, r8)
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r9 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            kotlinx.serialization.internal.BooleanSerializer r10 = kotlinx.serialization.internal.BooleanSerializer.INSTANCE
            r9.<init>(r10)
            java.lang.Object r9 = r0.decodeNullableSerializableElement(r1, r13, r9, r8)
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r11 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            kotlinx.serialization.internal.IntSerializer r13 = kotlinx.serialization.internal.IntSerializer.INSTANCE
            r11.<init>(r13)
            java.lang.Object r11 = r0.decodeNullableSerializableElement(r1, r12, r11, r8)
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r12 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            r12.<init>(r13)
            java.lang.Object r12 = r0.decodeNullableSerializableElement(r1, r4, r12, r8)
            kotlinx.serialization.internal.ArrayListSerializer r13 = new kotlinx.serialization.internal.ArrayListSerializer
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r14 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            com.deliveryhero.fluid.values.Color$$serializer r15 = com.deliveryhero.fluid.values.Color$$serializer.INSTANCE
            r14.<init>(r15)
            r13.<init>(r14)
            r14 = 8
            java.lang.Object r13 = r0.decodeNullableSerializableElement(r1, r14, r13, r8)
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r14 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            com.deliveryhero.fluid.values.Shape$$serializer r4 = com.deliveryhero.fluid.values.Shape$$serializer.INSTANCE
            r14.<init>(r4)
            r4 = 9
            java.lang.Object r4 = r0.decodeNullableSerializableElement(r1, r4, r14, r8)
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r14 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            r27 = r3
            com.deliveryhero.fluid.values.LinearGradientOrientation$$serializer r3 = com.deliveryhero.fluid.values.LinearGradientOrientation$$serializer.INSTANCE
            r14.<init>(r3)
            r3 = 10
            java.lang.Object r3 = r0.decodeNullableSerializableElement(r1, r3, r14, r8)
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r14 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            r19 = r3
            com.deliveryhero.fluid.values.LogicalPixel$$serializer r3 = com.deliveryhero.fluid.values.LogicalPixel$$serializer.INSTANCE
            r14.<init>(r3)
            r26 = r4
            r4 = 11
            java.lang.Object r4 = r0.decodeNullableSerializableElement(r1, r4, r14, r8)
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r14 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            r14.<init>(r3)
            r25 = r4
            r4 = 12
            java.lang.Object r4 = r0.decodeNullableSerializableElement(r1, r4, r14, r8)
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r14 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            r14.<init>(r3)
            r23 = r4
            r4 = 13
            java.lang.Object r4 = r0.decodeNullableSerializableElement(r1, r4, r14, r8)
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r14 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            r14.<init>(r3)
            r22 = r4
            r4 = 14
            java.lang.Object r4 = r0.decodeNullableSerializableElement(r1, r4, r14, r8)
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r14 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            r14.<init>(r3)
            r21 = r4
            r4 = 15
            java.lang.Object r4 = r0.decodeNullableSerializableElement(r1, r4, r14, r8)
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r14 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            r14.<init>(r3)
            r20 = r4
            r4 = 16
            java.lang.Object r4 = r0.decodeNullableSerializableElement(r1, r4, r14, r8)
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r14 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            r14.<init>(r15)
            r15 = 17
            java.lang.Object r14 = r0.decodeNullableSerializableElement(r1, r15, r14, r8)
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r15 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            r15.<init>(r3)
            r17 = r4
            r4 = 18
            java.lang.Object r4 = r0.decodeNullableSerializableElement(r1, r4, r15, r8)
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r15 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            r15.<init>(r10)
            r10 = 19
            java.lang.Object r10 = r0.decodeNullableSerializableElement(r1, r10, r15, r8)
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r15 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            r15.<init>(r3)
            r16 = r4
            r4 = 20
            java.lang.Object r4 = r0.decodeNullableSerializableElement(r1, r4, r15, r8)
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r15 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            r15.<init>(r3)
            r18 = r4
            r4 = 21
            java.lang.Object r4 = r0.decodeNullableSerializableElement(r1, r4, r15, r8)
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r15 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            r15.<init>(r3)
            r28 = r4
            r4 = 22
            java.lang.Object r4 = r0.decodeNullableSerializableElement(r1, r4, r15, r8)
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r15 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            r15.<init>(r3)
            r30 = r4
            r4 = 23
            java.lang.Object r4 = r0.decodeNullableSerializableElement(r1, r4, r15, r8)
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r15 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            r15.<init>(r3)
            r31 = r4
            r4 = 24
            java.lang.Object r4 = r0.decodeNullableSerializableElement(r1, r4, r15, r8)
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r15 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            r15.<init>(r3)
            r32 = r4
            r4 = 25
            java.lang.Object r4 = r0.decodeNullableSerializableElement(r1, r4, r15, r8)
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r15 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            r15.<init>(r3)
            r33 = r4
            r4 = 26
            java.lang.Object r4 = r0.decodeNullableSerializableElement(r1, r4, r15, r8)
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r15 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            r15.<init>(r3)
            r3 = 27
            java.lang.Object r3 = r0.decodeNullableSerializableElement(r1, r3, r15, r8)
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r15 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            kotlinx.serialization.internal.EnumSerializer r8 = new kotlinx.serialization.internal.EnumSerializer
            r35 = r3
            java.lang.String r3 = "com.deliveryhero.fluid.widgets.containers.HorizontalAlignment"
            r36 = r4
            com.deliveryhero.fluid.widgets.containers.HorizontalAlignment[] r4 = com.deliveryhero.fluid.widgets.containers.HorizontalAlignment.values()
            r8.<init>(r3, r4)
            r15.<init>(r8)
            r3 = 28
            r4 = 0
            java.lang.Object r3 = r0.decodeNullableSerializableElement(r1, r3, r15, r4)
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r8 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            kotlinx.serialization.internal.EnumSerializer r15 = new kotlinx.serialization.internal.EnumSerializer
            java.lang.String r4 = "com.deliveryhero.fluid.widgets.containers.VerticalAlignment"
            r37 = r3
            com.deliveryhero.fluid.widgets.containers.VerticalAlignment[] r3 = com.deliveryhero.fluid.widgets.containers.VerticalAlignment.values()
            r15.<init>(r4, r3)
            r8.<init>(r15)
            r3 = 29
            r4 = 0
            java.lang.Object r3 = r0.decodeNullableSerializableElement(r1, r3, r8, r4)
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r8 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            r8.<init>(r2)
            r15 = 30
            java.lang.Object r8 = r0.decodeNullableSerializableElement(r1, r15, r8, r4)
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r15 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            r15.<init>(r2)
            r34 = r3
            r3 = 31
            java.lang.Object r3 = r0.decodeNullableSerializableElement(r1, r3, r15, r4)
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r15 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            r15.<init>(r2)
            r38 = r3
            r3 = 32
            java.lang.Object r3 = r0.decodeNullableSerializableElement(r1, r3, r15, r4)
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r15 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            r15.<init>(r2)
            r2 = 33
            java.lang.Object r2 = r0.decodeNullableSerializableElement(r1, r2, r15, r4)
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r15 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            com.deliveryhero.fluid.widgets.lottie.RepeatCount$Companion r39 = com.deliveryhero.fluid.widgets.lottie.RepeatCount.Companion
            kotlinx.serialization.KSerializer r4 = r39.serializer()
            r15.<init>(r4)
            r4 = 34
            r102 = r6
            r6 = 0
            java.lang.Object r4 = r0.decodeNullableSerializableElement(r1, r4, r15, r6)
            r6 = -1
            r61 = r3
            r63 = r6
            r40 = r7
            r15 = r14
            r3 = r27
            r57 = r28
            r64 = 7
            r7 = r102
            r14 = r4
            r6 = r5
            r5 = r17
            r4 = r26
            r17 = r37
            goto L_0x0b00
        L_0x0217:
            r2 = r6
            r6 = r8
            r58 = r2
            r2 = r6
            r3 = r2
            r4 = r3
            r5 = r4
            r8 = r5
            r9 = r8
            r10 = r9
            r11 = r10
            r12 = r11
            r13 = r12
            r14 = r13
            r15 = r14
            r36 = r15
            r37 = r36
            r38 = r37
            r39 = r38
            r40 = r39
            r41 = r40
            r42 = r41
            r43 = r42
            r44 = r43
            r45 = r44
            r46 = r45
            r47 = r46
            r48 = r47
            r49 = r48
            r50 = r49
            r51 = r50
            r52 = r51
            r53 = r52
            r54 = r53
            r55 = r54
            r56 = r55
            r57 = r56
            r59 = r7
            r6 = r59
            r7 = r57
        L_0x0259:
            if (r58 == 0) goto L_0x0a93
            r60 = r15
            int r15 = r0.decodeElementIndex(r1)
            switch(r15) {
                case -1: goto L_0x0a32;
                case 0: goto L_0x09eb;
                case 1: goto L_0x09a1;
                case 2: goto L_0x095f;
                case 3: goto L_0x0912;
                case 4: goto L_0x08c2;
                case 5: goto L_0x087b;
                case 6: goto L_0x0839;
                case 7: goto L_0x07f5;
                case 8: goto L_0x07ab;
                case 9: goto L_0x0761;
                case 10: goto L_0x071f;
                case 11: goto L_0x06dc;
                case 12: goto L_0x0699;
                case 13: goto L_0x0656;
                case 14: goto L_0x0613;
                case 15: goto L_0x05ce;
                case 16: goto L_0x058a;
                case 17: goto L_0x0548;
                case 18: goto L_0x050c;
                case 19: goto L_0x04d0;
                case 20: goto L_0x048b;
                case 21: goto L_0x046c;
                case 22: goto L_0x0450;
                case 23: goto L_0x040f;
                case 24: goto L_0x03ce;
                case 25: goto L_0x03b4;
                case 26: goto L_0x039a;
                case 27: goto L_0x0359;
                case 28: goto L_0x0317;
                case 29: goto L_0x02f4;
                case 30: goto L_0x02c1;
                case 31: goto L_0x02a9;
                case 32: goto L_0x0295;
                case 33: goto L_0x0283;
                case 34: goto L_0x026a;
                default: goto L_0x0264;
            }
        L_0x0264:
            kotlinx.serialization.UnknownFieldException r0 = new kotlinx.serialization.UnknownFieldException
            r0.<init>((int) r15)
            throw r0
        L_0x026a:
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r15 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            com.deliveryhero.fluid.widgets.lottie.RepeatCount$Companion r61 = com.deliveryhero.fluid.widgets.lottie.RepeatCount.Companion
            r62 = r7
            kotlinx.serialization.KSerializer r7 = r61.serializer()
            r15.<init>(r7)
            r7 = 34
            java.lang.Object r7 = r0.decodeNullableSerializableElement(r1, r7, r15, r14)
            r59 = r59 | 4
            kotlin.Unit r14 = kotlin.Unit.INSTANCE
            r14 = r7
            goto L_0x02d6
        L_0x0283:
            r62 = r7
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r7 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            kotlinx.serialization.internal.StringSerializer r15 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            r7.<init>(r15)
            r15 = 33
            java.lang.Object r5 = r0.decodeNullableSerializableElement(r1, r15, r7, r5)
            r59 = r59 | 2
            goto L_0x02a6
        L_0x0295:
            r62 = r7
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r7 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            kotlinx.serialization.internal.StringSerializer r15 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            r7.<init>(r15)
            r15 = 32
            java.lang.Object r2 = r0.decodeNullableSerializableElement(r1, r15, r7, r2)
            r59 = r59 | 1
        L_0x02a6:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            goto L_0x02d6
        L_0x02a9:
            r62 = r7
            r15 = 32
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r7 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            kotlinx.serialization.internal.StringSerializer r15 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            r7.<init>(r15)
            r15 = 31
            java.lang.Object r7 = r0.decodeNullableSerializableElement(r1, r15, r7, r11)
            r11 = -2147483648(0xffffffff80000000, float:-0.0)
            r6 = r6 | r11
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            r11 = r7
            goto L_0x02d6
        L_0x02c1:
            r62 = r7
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r7 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            kotlinx.serialization.internal.StringSerializer r15 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            r7.<init>(r15)
            r15 = 30
            java.lang.Object r7 = r0.decodeNullableSerializableElement(r1, r15, r7, r10)
            r10 = 1073741824(0x40000000, float:2.0)
            r6 = r6 | r10
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            r10 = r7
        L_0x02d6:
            r34 = r42
            r35 = r43
            r29 = r44
            r27 = r46
            r26 = r47
            r25 = r48
            r23 = r49
            r22 = r50
            r21 = r51
            r20 = r52
            r18 = r53
            r16 = r55
            r15 = r60
            r7 = r62
            goto L_0x0405
        L_0x02f4:
            r62 = r7
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r7 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            kotlinx.serialization.internal.EnumSerializer r15 = new kotlinx.serialization.internal.EnumSerializer
            r61 = r2
            java.lang.String r2 = "com.deliveryhero.fluid.widgets.containers.VerticalAlignment"
            r63 = r5
            com.deliveryhero.fluid.widgets.containers.VerticalAlignment[] r5 = com.deliveryhero.fluid.widgets.containers.VerticalAlignment.values()
            r15.<init>(r2, r5)
            r7.<init>(r15)
            r2 = 29
            java.lang.Object r2 = r0.decodeNullableSerializableElement(r1, r2, r7, r9)
            r5 = 536870912(0x20000000, float:1.0842022E-19)
            r6 = r6 | r5
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            r9 = r2
            goto L_0x0339
        L_0x0317:
            r61 = r2
            r63 = r5
            r62 = r7
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r2 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            kotlinx.serialization.internal.EnumSerializer r5 = new kotlinx.serialization.internal.EnumSerializer
            java.lang.String r7 = "com.deliveryhero.fluid.widgets.containers.HorizontalAlignment"
            com.deliveryhero.fluid.widgets.containers.HorizontalAlignment[] r15 = com.deliveryhero.fluid.widgets.containers.HorizontalAlignment.values()
            r5.<init>(r7, r15)
            r2.<init>(r5)
            r5 = 28
            java.lang.Object r2 = r0.decodeNullableSerializableElement(r1, r5, r2, r4)
            r4 = 268435456(0x10000000, float:2.5243549E-29)
            r6 = r6 | r4
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            r4 = r2
        L_0x0339:
            r34 = r42
            r35 = r43
            r29 = r44
            r27 = r46
            r26 = r47
            r25 = r48
            r23 = r49
            r22 = r50
            r21 = r51
            r20 = r52
            r18 = r53
            r16 = r55
            r15 = r60
            r2 = r61
            r7 = r62
            goto L_0x0403
        L_0x0359:
            r61 = r2
            r63 = r5
            r62 = r7
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r2 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            com.deliveryhero.fluid.values.LogicalPixel$$serializer r5 = com.deliveryhero.fluid.values.LogicalPixel$$serializer.INSTANCE
            r2.<init>(r5)
            r5 = 27
            java.lang.Object r2 = r0.decodeNullableSerializableElement(r1, r5, r2, r3)
            r3 = 134217728(0x8000000, float:3.85186E-34)
            r6 = r6 | r3
            kotlin.Unit r3 = kotlin.Unit.INSTANCE
            r34 = r42
            r35 = r43
            r29 = r44
            r27 = r46
            r26 = r47
            r25 = r48
            r23 = r49
            r22 = r50
            r21 = r51
            r20 = r52
            r18 = r53
            r16 = r55
            r15 = r60
            r5 = r63
            r3 = 0
            r60 = r2
            r44 = r41
            r55 = r45
            r62 = r54
            r2 = r61
            goto L_0x0a71
        L_0x039a:
            r61 = r2
            r63 = r5
            r62 = r7
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r2 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            com.deliveryhero.fluid.values.LogicalPixel$$serializer r5 = com.deliveryhero.fluid.values.LogicalPixel$$serializer.INSTANCE
            r2.<init>(r5)
            r5 = 26
            java.lang.Object r2 = r0.decodeNullableSerializableElement(r1, r5, r2, r8)
            r5 = 67108864(0x4000000, float:1.5046328E-36)
            r6 = r6 | r5
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            r8 = r2
            goto L_0x03e7
        L_0x03b4:
            r61 = r2
            r63 = r5
            r62 = r7
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r2 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            com.deliveryhero.fluid.values.LogicalPixel$$serializer r5 = com.deliveryhero.fluid.values.LogicalPixel$$serializer.INSTANCE
            r2.<init>(r5)
            r5 = 25
            java.lang.Object r2 = r0.decodeNullableSerializableElement(r1, r5, r2, r12)
            r5 = 33554432(0x2000000, float:9.403955E-38)
            r6 = r6 | r5
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            r12 = r2
            goto L_0x03e7
        L_0x03ce:
            r61 = r2
            r63 = r5
            r62 = r7
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r2 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            com.deliveryhero.fluid.values.LogicalPixel$$serializer r5 = com.deliveryhero.fluid.values.LogicalPixel$$serializer.INSTANCE
            r2.<init>(r5)
            r5 = 24
            java.lang.Object r2 = r0.decodeNullableSerializableElement(r1, r5, r2, r13)
            r5 = 16777216(0x1000000, float:2.3509887E-38)
            r6 = r6 | r5
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            r13 = r2
        L_0x03e7:
            r34 = r42
            r35 = r43
            r29 = r44
            r27 = r46
            r26 = r47
            r25 = r48
            r23 = r49
            r22 = r50
            r21 = r51
            r20 = r52
            r18 = r53
            r16 = r55
            r15 = r60
            r2 = r61
        L_0x0403:
            r5 = r63
        L_0x0405:
            r60 = r3
            r44 = r41
            r55 = r45
            r62 = r54
            goto L_0x09e8
        L_0x040f:
            r61 = r2
            r63 = r5
            r62 = r7
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r2 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            com.deliveryhero.fluid.values.LogicalPixel$$serializer r5 = com.deliveryhero.fluid.values.LogicalPixel$$serializer.INSTANCE
            r2.<init>(r5)
            r5 = 23
            java.lang.Object r2 = r0.decodeNullableSerializableElement(r1, r5, r2, r7)
            r5 = 8388608(0x800000, float:1.17549435E-38)
            r6 = r6 | r5
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            r7 = r2
            r34 = r42
            r35 = r43
            r29 = r44
            r27 = r46
            r26 = r47
            r25 = r48
            r23 = r49
            r22 = r50
            r21 = r51
            r20 = r52
            r18 = r53
            r62 = r54
            r16 = r55
            r15 = r60
            r2 = r61
            r5 = r63
            r60 = r3
            r44 = r41
            r55 = r45
            goto L_0x09e8
        L_0x0450:
            r61 = r2
            r63 = r5
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r2 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            com.deliveryhero.fluid.values.LogicalPixel$$serializer r5 = com.deliveryhero.fluid.values.LogicalPixel$$serializer.INSTANCE
            r2.<init>(r5)
            r5 = 22
            r15 = r60
            java.lang.Object r2 = r0.decodeNullableSerializableElement(r1, r5, r2, r15)
            r5 = 4194304(0x400000, float:5.877472E-39)
            r6 = r6 | r5
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            r15 = r2
            r60 = r3
            goto L_0x04ab
        L_0x046c:
            r61 = r2
            r63 = r5
            r15 = r60
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r2 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            com.deliveryhero.fluid.values.LogicalPixel$$serializer r5 = com.deliveryhero.fluid.values.LogicalPixel$$serializer.INSTANCE
            r2.<init>(r5)
            r5 = 21
            r60 = r3
            r3 = r57
            java.lang.Object r2 = r0.decodeNullableSerializableElement(r1, r5, r2, r3)
            r3 = 2097152(0x200000, float:2.938736E-39)
            r6 = r6 | r3
            kotlin.Unit r3 = kotlin.Unit.INSTANCE
            r57 = r2
            goto L_0x04ab
        L_0x048b:
            r61 = r2
            r63 = r5
            r15 = r60
            r60 = r3
            r3 = r57
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r2 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            com.deliveryhero.fluid.values.LogicalPixel$$serializer r5 = com.deliveryhero.fluid.values.LogicalPixel$$serializer.INSTANCE
            r2.<init>(r5)
            r5 = 20
            r3 = r56
            java.lang.Object r2 = r0.decodeNullableSerializableElement(r1, r5, r2, r3)
            r3 = 1048576(0x100000, float:1.469368E-39)
            r6 = r6 | r3
            kotlin.Unit r3 = kotlin.Unit.INSTANCE
            r56 = r2
        L_0x04ab:
            r34 = r42
            r35 = r43
            r29 = r44
            r27 = r46
            r26 = r47
            r25 = r48
            r23 = r49
            r22 = r50
            r21 = r51
            r20 = r52
            r18 = r53
            r62 = r54
            r16 = r55
            r2 = r61
            r5 = r63
            r3 = 0
            r44 = r41
            r55 = r45
            goto L_0x0a71
        L_0x04d0:
            r61 = r2
            r63 = r5
            r15 = r60
            r60 = r3
            r3 = r56
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r2 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            kotlinx.serialization.internal.BooleanSerializer r5 = kotlinx.serialization.internal.BooleanSerializer.INSTANCE
            r2.<init>(r5)
            r5 = 19
            r3 = r55
            java.lang.Object r2 = r0.decodeNullableSerializableElement(r1, r5, r2, r3)
            r3 = 524288(0x80000, float:7.34684E-40)
            r6 = r6 | r3
            kotlin.Unit r3 = kotlin.Unit.INSTANCE
            r16 = r2
            r34 = r42
            r35 = r43
            r29 = r44
            r55 = r45
            r27 = r46
            r26 = r47
            r25 = r48
            r23 = r49
            r22 = r50
            r21 = r51
            r20 = r52
            r18 = r53
            r62 = r54
            goto L_0x07a2
        L_0x050c:
            r61 = r2
            r63 = r5
            r15 = r60
            r60 = r3
            r3 = r55
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r2 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            com.deliveryhero.fluid.values.LogicalPixel$$serializer r5 = com.deliveryhero.fluid.values.LogicalPixel$$serializer.INSTANCE
            r2.<init>(r5)
            r16 = r3
            r5 = r54
            r3 = 18
            java.lang.Object r2 = r0.decodeNullableSerializableElement(r1, r3, r2, r5)
            r5 = 262144(0x40000, float:3.67342E-40)
            r6 = r6 | r5
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            r62 = r2
            r34 = r42
            r35 = r43
            r29 = r44
            r55 = r45
            r27 = r46
            r26 = r47
            r25 = r48
            r23 = r49
            r22 = r50
            r21 = r51
            r20 = r52
            r18 = r53
            goto L_0x07a2
        L_0x0548:
            r61 = r2
            r63 = r5
            r5 = r54
            r16 = r55
            r15 = r60
            r60 = r3
            r3 = 18
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r2 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            com.deliveryhero.fluid.values.Color$$serializer r3 = com.deliveryhero.fluid.values.Color$$serializer.INSTANCE
            r2.<init>(r3)
            r17 = r4
            r3 = r53
            r4 = 17
            java.lang.Object r2 = r0.decodeNullableSerializableElement(r1, r4, r2, r3)
            r3 = 131072(0x20000, float:1.83671E-40)
            r6 = r6 | r3
            kotlin.Unit r3 = kotlin.Unit.INSTANCE
            r18 = r2
            r62 = r5
            r4 = r17
            r34 = r42
            r35 = r43
            r29 = r44
            r55 = r45
            r27 = r46
            r26 = r47
            r25 = r48
            r23 = r49
            r22 = r50
            r21 = r51
            r20 = r52
            goto L_0x07a2
        L_0x058a:
            r61 = r2
            r17 = r4
            r63 = r5
            r5 = r54
            r16 = r55
            r15 = r60
            r4 = 17
            r60 = r3
            r3 = r53
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r2 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            com.deliveryhero.fluid.values.LogicalPixel$$serializer r4 = com.deliveryhero.fluid.values.LogicalPixel$$serializer.INSTANCE
            r2.<init>(r4)
            r18 = r3
            r4 = r52
            r3 = 16
            java.lang.Object r2 = r0.decodeNullableSerializableElement(r1, r3, r2, r4)
            r4 = 65536(0x10000, float:9.18355E-41)
            r6 = r6 | r4
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            r20 = r2
            r62 = r5
            r4 = r17
            r34 = r42
            r35 = r43
            r29 = r44
            r55 = r45
            r27 = r46
            r26 = r47
            r25 = r48
            r23 = r49
            r22 = r50
            r21 = r51
            goto L_0x07a2
        L_0x05ce:
            r61 = r2
            r17 = r4
            r63 = r5
            r4 = r52
            r18 = r53
            r5 = r54
            r16 = r55
            r15 = r60
            r60 = r3
            r3 = 16
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r2 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            com.deliveryhero.fluid.values.LogicalPixel$$serializer r3 = com.deliveryhero.fluid.values.LogicalPixel$$serializer.INSTANCE
            r2.<init>(r3)
            r20 = r4
            r3 = r51
            r4 = 15
            java.lang.Object r2 = r0.decodeNullableSerializableElement(r1, r4, r2, r3)
            r3 = 32768(0x8000, float:4.5918E-41)
            r6 = r6 | r3
            kotlin.Unit r3 = kotlin.Unit.INSTANCE
            r21 = r2
            r62 = r5
            r4 = r17
            r34 = r42
            r35 = r43
            r29 = r44
            r55 = r45
            r27 = r46
            r26 = r47
            r25 = r48
            r23 = r49
            r22 = r50
            goto L_0x07a2
        L_0x0613:
            r61 = r2
            r17 = r4
            r63 = r5
            r20 = r52
            r18 = r53
            r5 = r54
            r16 = r55
            r15 = r60
            r4 = 15
            r60 = r3
            r3 = r51
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r2 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            com.deliveryhero.fluid.values.LogicalPixel$$serializer r4 = com.deliveryhero.fluid.values.LogicalPixel$$serializer.INSTANCE
            r2.<init>(r4)
            r21 = r3
            r4 = r50
            r3 = 14
            java.lang.Object r2 = r0.decodeNullableSerializableElement(r1, r3, r2, r4)
            r6 = r6 | 16384(0x4000, float:2.2959E-41)
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            r22 = r2
            r62 = r5
            r4 = r17
            r34 = r42
            r35 = r43
            r29 = r44
            r55 = r45
            r27 = r46
            r26 = r47
            r25 = r48
            r23 = r49
            goto L_0x07a2
        L_0x0656:
            r61 = r2
            r17 = r4
            r63 = r5
            r4 = r50
            r21 = r51
            r20 = r52
            r18 = r53
            r5 = r54
            r16 = r55
            r15 = r60
            r60 = r3
            r3 = 14
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r2 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            com.deliveryhero.fluid.values.LogicalPixel$$serializer r3 = com.deliveryhero.fluid.values.LogicalPixel$$serializer.INSTANCE
            r2.<init>(r3)
            r22 = r4
            r3 = r49
            r4 = 13
            java.lang.Object r2 = r0.decodeNullableSerializableElement(r1, r4, r2, r3)
            r6 = r6 | 8192(0x2000, float:1.14794E-41)
            kotlin.Unit r3 = kotlin.Unit.INSTANCE
            r23 = r2
            r62 = r5
            r4 = r17
            r34 = r42
            r35 = r43
            r29 = r44
            r55 = r45
            r27 = r46
            r26 = r47
            r25 = r48
            goto L_0x07a2
        L_0x0699:
            r61 = r2
            r17 = r4
            r63 = r5
            r22 = r50
            r21 = r51
            r20 = r52
            r18 = r53
            r5 = r54
            r16 = r55
            r15 = r60
            r4 = 13
            r60 = r3
            r3 = r49
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r2 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            com.deliveryhero.fluid.values.LogicalPixel$$serializer r4 = com.deliveryhero.fluid.values.LogicalPixel$$serializer.INSTANCE
            r2.<init>(r4)
            r23 = r3
            r4 = r48
            r3 = 12
            java.lang.Object r2 = r0.decodeNullableSerializableElement(r1, r3, r2, r4)
            r6 = r6 | 4096(0x1000, float:5.74E-42)
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            r25 = r2
            r62 = r5
            r4 = r17
            r34 = r42
            r35 = r43
            r29 = r44
            r55 = r45
            r27 = r46
            r26 = r47
            goto L_0x07a2
        L_0x06dc:
            r61 = r2
            r17 = r4
            r63 = r5
            r4 = r48
            r23 = r49
            r22 = r50
            r21 = r51
            r20 = r52
            r18 = r53
            r5 = r54
            r16 = r55
            r15 = r60
            r60 = r3
            r3 = 12
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r2 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            com.deliveryhero.fluid.values.LogicalPixel$$serializer r3 = com.deliveryhero.fluid.values.LogicalPixel$$serializer.INSTANCE
            r2.<init>(r3)
            r25 = r4
            r3 = r47
            r4 = 11
            java.lang.Object r2 = r0.decodeNullableSerializableElement(r1, r4, r2, r3)
            r6 = r6 | 2048(0x800, float:2.87E-42)
            kotlin.Unit r3 = kotlin.Unit.INSTANCE
            r26 = r2
            r62 = r5
            r4 = r17
            r34 = r42
            r35 = r43
            r29 = r44
            r55 = r45
            r27 = r46
            goto L_0x07a2
        L_0x071f:
            r61 = r2
            r17 = r4
            r63 = r5
            r25 = r48
            r23 = r49
            r22 = r50
            r21 = r51
            r20 = r52
            r18 = r53
            r5 = r54
            r16 = r55
            r15 = r60
            r4 = 11
            r60 = r3
            r3 = r47
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r2 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            com.deliveryhero.fluid.values.LinearGradientOrientation$$serializer r4 = com.deliveryhero.fluid.values.LinearGradientOrientation$$serializer.INSTANCE
            r2.<init>(r4)
            r26 = r3
            r4 = r46
            r3 = 10
            java.lang.Object r2 = r0.decodeNullableSerializableElement(r1, r3, r2, r4)
            r6 = r6 | 1024(0x400, float:1.435E-42)
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            r27 = r2
            r62 = r5
            r4 = r17
            r34 = r42
            r35 = r43
            r29 = r44
            r55 = r45
            goto L_0x07a2
        L_0x0761:
            r61 = r2
            r17 = r4
            r63 = r5
            r4 = r46
            r26 = r47
            r25 = r48
            r23 = r49
            r22 = r50
            r21 = r51
            r20 = r52
            r18 = r53
            r5 = r54
            r16 = r55
            r15 = r60
            r60 = r3
            r3 = 10
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r2 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            com.deliveryhero.fluid.values.Shape$$serializer r3 = com.deliveryhero.fluid.values.Shape$$serializer.INSTANCE
            r2.<init>(r3)
            r27 = r4
            r3 = r45
            r4 = 9
            java.lang.Object r2 = r0.decodeNullableSerializableElement(r1, r4, r2, r3)
            r6 = r6 | 512(0x200, float:7.175E-43)
            kotlin.Unit r3 = kotlin.Unit.INSTANCE
            r55 = r2
            r62 = r5
            r4 = r17
            r34 = r42
            r35 = r43
            r29 = r44
        L_0x07a2:
            r2 = r61
            r5 = r63
            r3 = 0
            r44 = r41
            goto L_0x0a71
        L_0x07ab:
            r61 = r2
            r17 = r4
            r63 = r5
            r27 = r46
            r26 = r47
            r25 = r48
            r23 = r49
            r22 = r50
            r21 = r51
            r20 = r52
            r18 = r53
            r5 = r54
            r16 = r55
            r15 = r60
            r4 = 9
            r60 = r3
            r3 = r45
            kotlinx.serialization.internal.ArrayListSerializer r2 = new kotlinx.serialization.internal.ArrayListSerializer
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r4 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            r55 = r3
            com.deliveryhero.fluid.values.Color$$serializer r3 = com.deliveryhero.fluid.values.Color$$serializer.INSTANCE
            r4.<init>(r3)
            r2.<init>(r4)
            r3 = r44
            r4 = 8
            java.lang.Object r2 = r0.decodeNullableSerializableElement(r1, r4, r2, r3)
            r6 = r6 | 256(0x100, float:3.59E-43)
            kotlin.Unit r3 = kotlin.Unit.INSTANCE
            r29 = r2
            r62 = r5
            r4 = r17
            r44 = r41
            r34 = r42
            r35 = r43
            goto L_0x08bc
        L_0x07f5:
            r61 = r2
            r17 = r4
            r63 = r5
            r27 = r46
            r26 = r47
            r25 = r48
            r23 = r49
            r22 = r50
            r21 = r51
            r20 = r52
            r18 = r53
            r5 = r54
            r16 = r55
            r15 = r60
            r4 = 8
            r60 = r3
            r3 = r44
            r55 = r45
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r2 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            kotlinx.serialization.internal.IntSerializer r4 = kotlinx.serialization.internal.IntSerializer.INSTANCE
            r2.<init>(r4)
            r29 = r3
            r4 = r43
            r3 = 7
            java.lang.Object r2 = r0.decodeNullableSerializableElement(r1, r3, r2, r4)
            r6 = r6 | 128(0x80, float:1.794E-43)
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            r35 = r2
            r62 = r5
            r4 = r17
            r44 = r41
            r34 = r42
            goto L_0x08bc
        L_0x0839:
            r61 = r2
            r17 = r4
            r63 = r5
            r4 = r43
            r29 = r44
            r27 = r46
            r26 = r47
            r25 = r48
            r23 = r49
            r22 = r50
            r21 = r51
            r20 = r52
            r18 = r53
            r5 = r54
            r16 = r55
            r15 = r60
            r60 = r3
            r55 = r45
            r3 = 7
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r2 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            kotlinx.serialization.internal.IntSerializer r3 = kotlinx.serialization.internal.IntSerializer.INSTANCE
            r2.<init>(r3)
            r35 = r4
            r3 = r42
            r4 = 6
            java.lang.Object r2 = r0.decodeNullableSerializableElement(r1, r4, r2, r3)
            r6 = r6 | 64
            kotlin.Unit r3 = kotlin.Unit.INSTANCE
            r34 = r2
            r62 = r5
            r4 = r17
            r44 = r41
            goto L_0x08bc
        L_0x087b:
            r61 = r2
            r17 = r4
            r63 = r5
            r35 = r43
            r29 = r44
            r27 = r46
            r26 = r47
            r25 = r48
            r23 = r49
            r22 = r50
            r21 = r51
            r20 = r52
            r18 = r53
            r5 = r54
            r16 = r55
            r15 = r60
            r4 = 6
            r60 = r3
            r3 = r42
            r55 = r45
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r2 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            kotlinx.serialization.internal.BooleanSerializer r4 = kotlinx.serialization.internal.BooleanSerializer.INSTANCE
            r2.<init>(r4)
            r34 = r3
            r4 = r41
            r3 = 5
            java.lang.Object r2 = r0.decodeNullableSerializableElement(r1, r3, r2, r4)
            r6 = r6 | 32
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            r44 = r2
            r62 = r5
            r4 = r17
        L_0x08bc:
            r2 = r61
            r5 = r63
            goto L_0x09e8
        L_0x08c2:
            r61 = r2
            r17 = r4
            r63 = r5
            r4 = r41
            r34 = r42
            r35 = r43
            r29 = r44
            r27 = r46
            r26 = r47
            r25 = r48
            r23 = r49
            r22 = r50
            r21 = r51
            r20 = r52
            r18 = r53
            r5 = r54
            r16 = r55
            r15 = r60
            r60 = r3
            r55 = r45
            r3 = 5
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r2 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            kotlinx.serialization.PolymorphicSerializer r3 = new kotlinx.serialization.PolymorphicSerializer
            r44 = r4
            kotlin.reflect.KClass r4 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r19)
            r62 = r5
            r64 = r7
            r5 = 0
            java.lang.annotation.Annotation[] r7 = new java.lang.annotation.Annotation[r5]
            r3.<init>(r4, r7)
            r2.<init>(r3)
            r3 = r40
            r4 = 4
            java.lang.Object r2 = r0.decodeNullableSerializableElement(r1, r4, r2, r3)
            r6 = r6 | 16
            kotlin.Unit r3 = kotlin.Unit.INSTANCE
            r40 = r2
            r3 = r5
            goto L_0x0a69
        L_0x0912:
            r61 = r2
            r17 = r4
            r63 = r5
            r64 = r7
            r34 = r42
            r35 = r43
            r29 = r44
            r27 = r46
            r26 = r47
            r25 = r48
            r23 = r49
            r22 = r50
            r21 = r51
            r20 = r52
            r18 = r53
            r62 = r54
            r16 = r55
            r15 = r60
            r4 = 4
            r5 = 0
            r60 = r3
            r3 = r40
            r44 = r41
            r55 = r45
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r2 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            kotlinx.serialization.PolymorphicSerializer r7 = new kotlinx.serialization.PolymorphicSerializer
            kotlin.reflect.KClass r4 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r19)
            java.lang.annotation.Annotation[] r3 = new java.lang.annotation.Annotation[r5]
            r7.<init>(r4, r3)
            r2.<init>(r7)
            r3 = r39
            r4 = 3
            java.lang.Object r2 = r0.decodeNullableSerializableElement(r1, r4, r2, r3)
            r6 = r6 | 8
            kotlin.Unit r3 = kotlin.Unit.INSTANCE
            r39 = r2
            goto L_0x09e0
        L_0x095f:
            r61 = r2
            r17 = r4
            r63 = r5
            r64 = r7
            r34 = r42
            r35 = r43
            r29 = r44
            r27 = r46
            r26 = r47
            r25 = r48
            r23 = r49
            r22 = r50
            r21 = r51
            r20 = r52
            r18 = r53
            r62 = r54
            r16 = r55
            r15 = r60
            r4 = 3
            r60 = r3
            r3 = r39
            r44 = r41
            r55 = r45
            kotlinx.serialization.internal.LinkedHashSetSerializer r2 = new kotlinx.serialization.internal.LinkedHashSetSerializer
            com.deliveryhero.fluid.expression.placeholder.PlaceholderSurrogate$$serializer r5 = com.deliveryhero.fluid.expression.placeholder.PlaceholderSurrogate$$serializer.INSTANCE
            r2.<init>(r5)
            r5 = r38
            r7 = 2
            java.lang.Object r2 = r0.decodeSerializableElement(r1, r7, r2, r5)
            r6 = r6 | 4
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            r38 = r2
            goto L_0x09e0
        L_0x09a1:
            r61 = r2
            r17 = r4
            r63 = r5
            r64 = r7
            r5 = r38
            r34 = r42
            r35 = r43
            r29 = r44
            r27 = r46
            r26 = r47
            r25 = r48
            r23 = r49
            r22 = r50
            r21 = r51
            r20 = r52
            r18 = r53
            r62 = r54
            r16 = r55
            r15 = r60
            r4 = 3
            r7 = 2
            r60 = r3
            r3 = r39
            r44 = r41
            r55 = r45
            kotlinx.serialization.internal.StringSerializer r2 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            r4 = r37
            r7 = 1
            java.lang.Object r2 = r0.decodeNullableSerializableElement(r1, r7, r2, r4)
            r6 = r6 | 2
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            r37 = r2
        L_0x09e0:
            r4 = r17
            r2 = r61
            r5 = r63
            r7 = r64
        L_0x09e8:
            r3 = 0
            goto L_0x0a71
        L_0x09eb:
            r61 = r2
            r17 = r4
            r63 = r5
            r64 = r7
            r4 = r37
            r5 = r38
            r34 = r42
            r35 = r43
            r29 = r44
            r27 = r46
            r26 = r47
            r25 = r48
            r23 = r49
            r22 = r50
            r21 = r51
            r20 = r52
            r18 = r53
            r62 = r54
            r16 = r55
            r15 = r60
            r7 = 1
            r60 = r3
            r3 = r39
            r44 = r41
            r55 = r45
            kotlinx.serialization.internal.StringSerializer r2 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            r33 = r3
            r7 = r36
            r3 = 0
            java.lang.Object r2 = r0.decodeNullableSerializableElement(r1, r3, r2, r7)
            r6 = r6 | 1
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            r36 = r2
            r4 = r17
            r39 = r33
            goto L_0x0a6b
        L_0x0a32:
            r61 = r2
            r17 = r4
            r63 = r5
            r64 = r7
            r7 = r36
            r4 = r37
            r5 = r38
            r33 = r39
            r34 = r42
            r35 = r43
            r29 = r44
            r27 = r46
            r26 = r47
            r25 = r48
            r23 = r49
            r22 = r50
            r21 = r51
            r20 = r52
            r18 = r53
            r62 = r54
            r16 = r55
            r15 = r60
            r60 = r3
            r44 = r41
            r55 = r45
            r3 = 0
            kotlin.Unit r2 = kotlin.Unit.INSTANCE
            r58 = r3
        L_0x0a69:
            r4 = r17
        L_0x0a6b:
            r2 = r61
            r5 = r63
            r7 = r64
        L_0x0a71:
            r53 = r18
            r52 = r20
            r51 = r21
            r50 = r22
            r49 = r23
            r48 = r25
            r47 = r26
            r46 = r27
            r42 = r34
            r43 = r35
            r41 = r44
            r45 = r55
            r3 = r60
            r54 = r62
            r55 = r16
            r44 = r29
            goto L_0x0259
        L_0x0a93:
            r61 = r2
            r60 = r3
            r17 = r4
            r63 = r5
            r64 = r7
            r7 = r36
            r4 = r37
            r5 = r38
            r33 = r39
            r34 = r42
            r35 = r43
            r29 = r44
            r27 = r46
            r26 = r47
            r25 = r48
            r23 = r49
            r22 = r50
            r21 = r51
            r20 = r52
            r18 = r53
            r62 = r54
            r16 = r55
            r44 = r41
            r55 = r45
            r24 = r7
            r36 = r8
            r8 = r10
            r38 = r11
            r32 = r13
            r30 = r15
            r10 = r16
            r15 = r18
            r19 = r27
            r13 = r29
            r3 = r33
            r11 = r34
            r18 = r56
            r16 = r62
            r2 = r63
            r31 = r64
            r7 = r4
            r63 = r6
            r34 = r9
            r33 = r12
            r12 = r35
            r9 = r44
            r4 = r55
            r64 = r59
            r35 = r60
            r6 = r5
            r5 = r20
            r20 = r21
            r21 = r22
            r22 = r23
            r23 = r25
            r25 = r26
        L_0x0b00:
            r0.endStructure(r1)
            com.deliveryhero.fluid.widgets.lottie.LottieModelBuilder r0 = new com.deliveryhero.fluid.widgets.lottie.LottieModelBuilder
            r62 = r0
            r65 = r24
            java.lang.String r65 = (java.lang.String) r65
            r66 = r7
            java.lang.String r66 = (java.lang.String) r66
            r67 = r6
            java.util.Set r67 = (java.util.Set) r67
            r68 = r3
            com.deliveryhero.fluid.expression.ExpressionBuilder r68 = (com.deliveryhero.fluid.expression.ExpressionBuilder) r68
            r69 = r40
            com.deliveryhero.fluid.expression.ExpressionBuilder r69 = (com.deliveryhero.fluid.expression.ExpressionBuilder) r69
            r70 = r9
            com.deliveryhero.fluid.expression.ExpressionBuilder r70 = (com.deliveryhero.fluid.expression.ExpressionBuilder) r70
            r71 = r11
            com.deliveryhero.fluid.expression.ExpressionBuilder r71 = (com.deliveryhero.fluid.expression.ExpressionBuilder) r71
            r72 = r12
            com.deliveryhero.fluid.expression.ExpressionBuilder r72 = (com.deliveryhero.fluid.expression.ExpressionBuilder) r72
            r73 = r13
            java.util.List r73 = (java.util.List) r73
            r74 = r4
            com.deliveryhero.fluid.expression.ExpressionBuilder r74 = (com.deliveryhero.fluid.expression.ExpressionBuilder) r74
            r75 = r19
            com.deliveryhero.fluid.expression.ExpressionBuilder r75 = (com.deliveryhero.fluid.expression.ExpressionBuilder) r75
            r76 = r25
            com.deliveryhero.fluid.expression.ExpressionBuilder r76 = (com.deliveryhero.fluid.expression.ExpressionBuilder) r76
            r77 = r23
            com.deliveryhero.fluid.expression.ExpressionBuilder r77 = (com.deliveryhero.fluid.expression.ExpressionBuilder) r77
            r78 = r22
            com.deliveryhero.fluid.expression.ExpressionBuilder r78 = (com.deliveryhero.fluid.expression.ExpressionBuilder) r78
            r79 = r21
            com.deliveryhero.fluid.expression.ExpressionBuilder r79 = (com.deliveryhero.fluid.expression.ExpressionBuilder) r79
            r80 = r20
            com.deliveryhero.fluid.expression.ExpressionBuilder r80 = (com.deliveryhero.fluid.expression.ExpressionBuilder) r80
            r81 = r5
            com.deliveryhero.fluid.expression.ExpressionBuilder r81 = (com.deliveryhero.fluid.expression.ExpressionBuilder) r81
            r82 = r15
            com.deliveryhero.fluid.expression.ExpressionBuilder r82 = (com.deliveryhero.fluid.expression.ExpressionBuilder) r82
            r83 = r16
            com.deliveryhero.fluid.expression.ExpressionBuilder r83 = (com.deliveryhero.fluid.expression.ExpressionBuilder) r83
            r84 = r10
            com.deliveryhero.fluid.expression.ExpressionBuilder r84 = (com.deliveryhero.fluid.expression.ExpressionBuilder) r84
            r85 = r18
            com.deliveryhero.fluid.expression.ExpressionBuilder r85 = (com.deliveryhero.fluid.expression.ExpressionBuilder) r85
            r86 = r57
            com.deliveryhero.fluid.expression.ExpressionBuilder r86 = (com.deliveryhero.fluid.expression.ExpressionBuilder) r86
            r87 = r30
            com.deliveryhero.fluid.expression.ExpressionBuilder r87 = (com.deliveryhero.fluid.expression.ExpressionBuilder) r87
            r88 = r31
            com.deliveryhero.fluid.expression.ExpressionBuilder r88 = (com.deliveryhero.fluid.expression.ExpressionBuilder) r88
            r89 = r32
            com.deliveryhero.fluid.expression.ExpressionBuilder r89 = (com.deliveryhero.fluid.expression.ExpressionBuilder) r89
            r90 = r33
            com.deliveryhero.fluid.expression.ExpressionBuilder r90 = (com.deliveryhero.fluid.expression.ExpressionBuilder) r90
            r91 = r36
            com.deliveryhero.fluid.expression.ExpressionBuilder r91 = (com.deliveryhero.fluid.expression.ExpressionBuilder) r91
            r92 = r35
            com.deliveryhero.fluid.expression.ExpressionBuilder r92 = (com.deliveryhero.fluid.expression.ExpressionBuilder) r92
            r93 = r17
            com.deliveryhero.fluid.expression.ExpressionBuilder r93 = (com.deliveryhero.fluid.expression.ExpressionBuilder) r93
            r94 = r34
            com.deliveryhero.fluid.expression.ExpressionBuilder r94 = (com.deliveryhero.fluid.expression.ExpressionBuilder) r94
            r95 = r8
            com.deliveryhero.fluid.expression.ExpressionBuilder r95 = (com.deliveryhero.fluid.expression.ExpressionBuilder) r95
            r96 = r38
            com.deliveryhero.fluid.expression.ExpressionBuilder r96 = (com.deliveryhero.fluid.expression.ExpressionBuilder) r96
            r97 = r61
            com.deliveryhero.fluid.expression.ExpressionBuilder r97 = (com.deliveryhero.fluid.expression.ExpressionBuilder) r97
            r98 = r2
            com.deliveryhero.fluid.expression.ExpressionBuilder r98 = (com.deliveryhero.fluid.expression.ExpressionBuilder) r98
            r99 = r14
            com.deliveryhero.fluid.expression.ExpressionBuilder r99 = (com.deliveryhero.fluid.expression.ExpressionBuilder) r99
            r100 = 0
            r62.<init>(r63, r64, r65, r66, r67, r68, r69, r70, r71, r72, r73, r74, r75, r76, r77, r78, r79, r80, r81, r82, r83, r84, r85, r86, r87, r88, r89, r90, r91, r92, r93, r94, r95, r96, r97, r98, r99, r100)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.deliveryhero.fluid.widgets.lottie.LottieModelBuilder$$serializer.deserialize(kotlinx.serialization.encoding.Decoder):com.deliveryhero.fluid.widgets.lottie.LottieModelBuilder");
    }

    @NotNull
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    public void serialize(@NotNull Encoder encoder, @NotNull LottieModelBuilder lottieModelBuilder) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(lottieModelBuilder, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder beginStructure = encoder.beginStructure(descriptor2);
        LottieModelBuilder.write$Self(lottieModelBuilder, beginStructure, descriptor2);
        beginStructure.endStructure(descriptor2);
    }

    @NotNull
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
