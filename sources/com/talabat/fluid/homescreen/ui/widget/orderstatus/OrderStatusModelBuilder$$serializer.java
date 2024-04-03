package com.talabat.fluid.homescreen.ui.widget.orderstatus;

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

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"com/talabat/fluid/homescreen/ui/widget/orderstatus/OrderStatusModelBuilder.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/talabat/fluid/homescreen/ui/widget/orderstatus/OrderStatusModelBuilder;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "com_talabat_NewArchi_Homescreen_Homescreen"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
public final class OrderStatusModelBuilder$$serializer implements GeneratedSerializer<OrderStatusModelBuilder> {
    @NotNull
    public static final OrderStatusModelBuilder$$serializer INSTANCE;
    public static final /* synthetic */ SerialDescriptor descriptor;

    static {
        OrderStatusModelBuilder$$serializer orderStatusModelBuilder$$serializer = new OrderStatusModelBuilder$$serializer();
        INSTANCE = orderStatusModelBuilder$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor(OrderStatusDataMapper.KEY_ACTIVE_ORDERS_DATA, orderStatusModelBuilder$$serializer, 38);
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
        pluginGeneratedSerialDescriptor.addElement("item_padding_top", true);
        pluginGeneratedSerialDescriptor.addElement("item_padding_bottom", true);
        pluginGeneratedSerialDescriptor.addElement("item_padding_leading", true);
        pluginGeneratedSerialDescriptor.addElement("item_padding_trailing", true);
        pluginGeneratedSerialDescriptor.addElement("item_spacing", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private OrderStatusModelBuilder$$serializer() {
    }

    @NotNull
    public KSerializer<?>[] childSerializers() {
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        Class<Size> cls = Size.class;
        BooleanSerializer booleanSerializer = BooleanSerializer.INSTANCE;
        IntSerializer intSerializer = IntSerializer.INSTANCE;
        Color$$serializer color$$serializer = Color$$serializer.INSTANCE;
        LogicalPixel$$serializer logicalPixel$$serializer = LogicalPixel$$serializer.INSTANCE;
        return new KSerializer[]{BuiltinSerializersKt.getNullable(stringSerializer), BuiltinSerializersKt.getNullable(stringSerializer), new LinkedHashSetSerializer(PlaceholderSurrogate$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(new ExpressionBuilderSerializer(new PolymorphicSerializer(Reflection.getOrCreateKotlinClass(cls), new Annotation[0]))), BuiltinSerializersKt.getNullable(new ExpressionBuilderSerializer(new PolymorphicSerializer(Reflection.getOrCreateKotlinClass(cls), new Annotation[0]))), BuiltinSerializersKt.getNullable(new ExpressionBuilderSerializer(booleanSerializer)), BuiltinSerializersKt.getNullable(new ExpressionBuilderSerializer(intSerializer)), BuiltinSerializersKt.getNullable(new ExpressionBuilderSerializer(intSerializer)), BuiltinSerializersKt.getNullable(new ArrayListSerializer(new ExpressionBuilderSerializer(color$$serializer))), BuiltinSerializersKt.getNullable(new ExpressionBuilderSerializer(Shape$$serializer.INSTANCE)), BuiltinSerializersKt.getNullable(new ExpressionBuilderSerializer(LinearGradientOrientation$$serializer.INSTANCE)), BuiltinSerializersKt.getNullable(new ExpressionBuilderSerializer(logicalPixel$$serializer)), BuiltinSerializersKt.getNullable(new ExpressionBuilderSerializer(logicalPixel$$serializer)), BuiltinSerializersKt.getNullable(new ExpressionBuilderSerializer(logicalPixel$$serializer)), BuiltinSerializersKt.getNullable(new ExpressionBuilderSerializer(logicalPixel$$serializer)), BuiltinSerializersKt.getNullable(new ExpressionBuilderSerializer(logicalPixel$$serializer)), BuiltinSerializersKt.getNullable(new ExpressionBuilderSerializer(logicalPixel$$serializer)), BuiltinSerializersKt.getNullable(new ExpressionBuilderSerializer(color$$serializer)), BuiltinSerializersKt.getNullable(new ExpressionBuilderSerializer(logicalPixel$$serializer)), BuiltinSerializersKt.getNullable(new ExpressionBuilderSerializer(booleanSerializer)), BuiltinSerializersKt.getNullable(new ExpressionBuilderSerializer(logicalPixel$$serializer)), BuiltinSerializersKt.getNullable(new ExpressionBuilderSerializer(logicalPixel$$serializer)), BuiltinSerializersKt.getNullable(new ExpressionBuilderSerializer(logicalPixel$$serializer)), BuiltinSerializersKt.getNullable(new ExpressionBuilderSerializer(logicalPixel$$serializer)), BuiltinSerializersKt.getNullable(new ExpressionBuilderSerializer(logicalPixel$$serializer)), BuiltinSerializersKt.getNullable(new ExpressionBuilderSerializer(logicalPixel$$serializer)), BuiltinSerializersKt.getNullable(new ExpressionBuilderSerializer(logicalPixel$$serializer)), BuiltinSerializersKt.getNullable(new ExpressionBuilderSerializer(logicalPixel$$serializer)), BuiltinSerializersKt.getNullable(new ExpressionBuilderSerializer(new EnumSerializer("com.deliveryhero.fluid.widgets.containers.HorizontalAlignment", HorizontalAlignment.values()))), BuiltinSerializersKt.getNullable(new ExpressionBuilderSerializer(new EnumSerializer("com.deliveryhero.fluid.widgets.containers.VerticalAlignment", VerticalAlignment.values()))), BuiltinSerializersKt.getNullable(new ExpressionBuilderSerializer(stringSerializer)), BuiltinSerializersKt.getNullable(new ExpressionBuilderSerializer(stringSerializer)), BuiltinSerializersKt.getNullable(new ExpressionBuilderSerializer(stringSerializer)), BuiltinSerializersKt.getNullable(new ExpressionBuilderSerializer(logicalPixel$$serializer)), BuiltinSerializersKt.getNullable(new ExpressionBuilderSerializer(logicalPixel$$serializer)), BuiltinSerializersKt.getNullable(new ExpressionBuilderSerializer(logicalPixel$$serializer)), BuiltinSerializersKt.getNullable(new ExpressionBuilderSerializer(logicalPixel$$serializer)), BuiltinSerializersKt.getNullable(new ExpressionBuilderSerializer(logicalPixel$$serializer))};
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r58v0, resolved type: com.deliveryhero.fluid.expression.ExpressionBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r57v0, resolved type: com.deliveryhero.fluid.expression.ExpressionBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v1, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r39v0, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r40v0, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r57v1, resolved type: com.deliveryhero.fluid.expression.ExpressionBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r58v1, resolved type: com.deliveryhero.fluid.expression.ExpressionBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r59v0, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r60v0, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r61v0, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r61v1, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r60v1, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r59v1, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r58v2, resolved type: com.deliveryhero.fluid.expression.ExpressionBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r57v2, resolved type: com.deliveryhero.fluid.expression.ExpressionBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r40v1, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r39v1, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v2, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: com.deliveryhero.fluid.expression.ExpressionBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r63v1, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r61v2, resolved type: com.deliveryhero.fluid.expression.ExpressionBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r60v2, resolved type: com.deliveryhero.fluid.expression.ExpressionBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r59v2, resolved type: com.deliveryhero.fluid.expression.ExpressionBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r58v3, resolved type: com.deliveryhero.fluid.expression.ExpressionBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r57v3, resolved type: com.deliveryhero.fluid.expression.ExpressionBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r56v2, resolved type: com.deliveryhero.fluid.expression.ExpressionBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v5, resolved type: com.deliveryhero.fluid.expression.ExpressionBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r40v3, resolved type: com.deliveryhero.fluid.expression.ExpressionBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v6, resolved type: com.deliveryhero.fluid.expression.ExpressionBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r40v4, resolved type: com.deliveryhero.fluid.expression.ExpressionBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r64v5, resolved type: com.deliveryhero.fluid.expression.ExpressionBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r39v7, resolved type: com.deliveryhero.fluid.expression.ExpressionBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r38v6, resolved type: java.util.Set} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r39v8, resolved type: com.deliveryhero.fluid.expression.ExpressionBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r40v5, resolved type: com.deliveryhero.fluid.expression.ExpressionBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r58v4, resolved type: com.deliveryhero.fluid.expression.ExpressionBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r57v4, resolved type: com.deliveryhero.fluid.expression.ExpressionBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r58v5, resolved type: com.deliveryhero.fluid.expression.ExpressionBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r57v5, resolved type: com.deliveryhero.fluid.expression.ExpressionBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r58v6, resolved type: com.deliveryhero.fluid.expression.ExpressionBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r57v6, resolved type: com.deliveryhero.fluid.expression.ExpressionBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r64v28, resolved type: com.deliveryhero.fluid.expression.ExpressionBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r61v6, resolved type: com.deliveryhero.fluid.expression.ExpressionBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r60v6, resolved type: com.deliveryhero.fluid.expression.ExpressionBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r59v6, resolved type: com.deliveryhero.fluid.expression.ExpressionBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r58v7, resolved type: com.deliveryhero.fluid.expression.ExpressionBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r57v7, resolved type: com.deliveryhero.fluid.expression.ExpressionBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v76, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r57v8, resolved type: com.deliveryhero.fluid.expression.ExpressionBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v78, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r58v8, resolved type: com.deliveryhero.fluid.expression.ExpressionBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r59v7, resolved type: com.deliveryhero.fluid.expression.ExpressionBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r60v7, resolved type: com.deliveryhero.fluid.expression.ExpressionBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r61v7, resolved type: com.deliveryhero.fluid.expression.ExpressionBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v135, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r28v0, resolved type: com.deliveryhero.fluid.expression.ExpressionBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v137, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r29v0, resolved type: com.deliveryhero.fluid.expression.ExpressionBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r33v37, resolved type: com.deliveryhero.fluid.expression.ExpressionBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r57v9, resolved type: com.deliveryhero.fluid.expression.ExpressionBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r58v9, resolved type: com.deliveryhero.fluid.expression.ExpressionBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r63v2, resolved type: com.deliveryhero.fluid.expression.ExpressionBuilder} */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x034f, code lost:
        r65 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0351, code lost:
        r33 = r42;
        r34 = r43;
        r35 = r44;
        r27 = r46;
        r26 = r47;
        r25 = r48;
        r23 = r49;
        r22 = r50;
        r21 = r51;
        r20 = r52;
        r18 = r53;
        r17 = r55;
        r2 = r63;
        r4 = r64;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x03b4, code lost:
        r33 = r42;
        r34 = r43;
        r35 = r44;
        r27 = r46;
        r26 = r47;
        r25 = r48;
        r23 = r49;
        r22 = r50;
        r21 = r51;
        r20 = r52;
        r18 = r53;
        r17 = r55;
        r2 = r63;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x04fc, code lost:
        r2 = r5;
        r33 = r42;
        r34 = r43;
        r35 = r44;
        r27 = r46;
        r26 = r47;
        r25 = r48;
        r23 = r49;
        r22 = r50;
        r21 = r51;
        r20 = r52;
        r18 = r53;
        r17 = r55;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0515, code lost:
        r4 = r64;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0517, code lost:
        r5 = r66;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0519, code lost:
        r44 = r41;
        r55 = r45;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x07d7, code lost:
        r4 = r64;
        r5 = r66;
        r44 = r41;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x08dd, code lost:
        r4 = r64;
        r5 = r66;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x09f1, code lost:
        r2 = r63;
        r4 = r64;
        r5 = r66;
        r6 = r67;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0a70, code lost:
        r2 = r63;
        r4 = r64;
        r5 = r66;
        r6 = r67;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0a78, code lost:
        r110 = r54;
        r54 = r17;
        r17 = r110;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.talabat.fluid.homescreen.ui.widget.orderstatus.OrderStatusModelBuilder deserialize(@org.jetbrains.annotations.NotNull kotlinx.serialization.encoding.Decoder r112) {
        /*
            r111 = this;
            r0 = r112
            java.lang.String r1 = "decoder"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            kotlinx.serialization.descriptors.SerialDescriptor r1 = r111.getDescriptor()
            kotlinx.serialization.encoding.CompositeDecoder r0 = r0.beginStructure(r1)
            boolean r2 = r0.decodeSequentially()
            r12 = 7
            r13 = 6
            r14 = 5
            r15 = 3
            r3 = 4
            java.lang.Class<com.deliveryhero.fluid.values.Size> r19 = com.deliveryhero.fluid.values.Size.class
            r5 = 2
            r6 = 1
            r7 = 0
            r8 = 0
            if (r2 == 0) goto L_0x024a
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
            java.lang.annotation.Annotation[] r4 = new java.lang.annotation.Annotation[r7]
            r10.<init>(r11, r4)
            r9.<init>(r10)
            java.lang.Object r4 = r0.decodeNullableSerializableElement(r1, r15, r9, r8)
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r9 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            kotlinx.serialization.PolymorphicSerializer r10 = new kotlinx.serialization.PolymorphicSerializer
            kotlin.reflect.KClass r11 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r19)
            java.lang.annotation.Annotation[] r7 = new java.lang.annotation.Annotation[r7]
            r10.<init>(r11, r7)
            r9.<init>(r10)
            java.lang.Object r3 = r0.decodeNullableSerializableElement(r1, r3, r9, r8)
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r7 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            kotlinx.serialization.internal.BooleanSerializer r9 = kotlinx.serialization.internal.BooleanSerializer.INSTANCE
            r7.<init>(r9)
            java.lang.Object r7 = r0.decodeNullableSerializableElement(r1, r14, r7, r8)
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r10 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            kotlinx.serialization.internal.IntSerializer r11 = kotlinx.serialization.internal.IntSerializer.INSTANCE
            r10.<init>(r11)
            java.lang.Object r10 = r0.decodeNullableSerializableElement(r1, r13, r10, r8)
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r13 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            r13.<init>(r11)
            java.lang.Object r11 = r0.decodeNullableSerializableElement(r1, r12, r13, r8)
            kotlinx.serialization.internal.ArrayListSerializer r12 = new kotlinx.serialization.internal.ArrayListSerializer
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r13 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            com.deliveryhero.fluid.values.Color$$serializer r14 = com.deliveryhero.fluid.values.Color$$serializer.INSTANCE
            r13.<init>(r14)
            r12.<init>(r13)
            r13 = 8
            java.lang.Object r12 = r0.decodeNullableSerializableElement(r1, r13, r12, r8)
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r13 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            com.deliveryhero.fluid.values.Shape$$serializer r15 = com.deliveryhero.fluid.values.Shape$$serializer.INSTANCE
            r13.<init>(r15)
            r15 = 9
            java.lang.Object r13 = r0.decodeNullableSerializableElement(r1, r15, r13, r8)
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r15 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            r19 = r3
            com.deliveryhero.fluid.values.LinearGradientOrientation$$serializer r3 = com.deliveryhero.fluid.values.LinearGradientOrientation$$serializer.INSTANCE
            r15.<init>(r3)
            r3 = 10
            java.lang.Object r3 = r0.decodeNullableSerializableElement(r1, r3, r15, r8)
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r15 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            r26 = r3
            com.deliveryhero.fluid.values.LogicalPixel$$serializer r3 = com.deliveryhero.fluid.values.LogicalPixel$$serializer.INSTANCE
            r15.<init>(r3)
            r27 = r4
            r4 = 11
            java.lang.Object r4 = r0.decodeNullableSerializableElement(r1, r4, r15, r8)
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r15 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            r15.<init>(r3)
            r25 = r4
            r4 = 12
            java.lang.Object r4 = r0.decodeNullableSerializableElement(r1, r4, r15, r8)
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r15 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            r15.<init>(r3)
            r23 = r4
            r4 = 13
            java.lang.Object r4 = r0.decodeNullableSerializableElement(r1, r4, r15, r8)
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r15 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            r15.<init>(r3)
            r22 = r4
            r4 = 14
            java.lang.Object r4 = r0.decodeNullableSerializableElement(r1, r4, r15, r8)
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r15 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            r15.<init>(r3)
            r21 = r4
            r4 = 15
            java.lang.Object r4 = r0.decodeNullableSerializableElement(r1, r4, r15, r8)
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r15 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            r15.<init>(r3)
            r20 = r4
            r4 = 16
            java.lang.Object r4 = r0.decodeNullableSerializableElement(r1, r4, r15, r8)
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r15 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            r15.<init>(r14)
            r14 = 17
            java.lang.Object r14 = r0.decodeNullableSerializableElement(r1, r14, r15, r8)
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r15 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            r15.<init>(r3)
            r17 = r4
            r4 = 18
            java.lang.Object r4 = r0.decodeNullableSerializableElement(r1, r4, r15, r8)
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r15 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            r15.<init>(r9)
            r9 = 19
            java.lang.Object r9 = r0.decodeNullableSerializableElement(r1, r9, r15, r8)
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r15 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            r15.<init>(r3)
            r112 = r4
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
            r29 = r4
            r4 = 23
            java.lang.Object r4 = r0.decodeNullableSerializableElement(r1, r4, r15, r8)
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r15 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            r15.<init>(r3)
            r30 = r4
            r4 = 24
            java.lang.Object r4 = r0.decodeNullableSerializableElement(r1, r4, r15, r8)
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r15 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            r15.<init>(r3)
            r31 = r4
            r4 = 25
            java.lang.Object r4 = r0.decodeNullableSerializableElement(r1, r4, r15, r8)
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r15 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            r15.<init>(r3)
            r32 = r4
            r4 = 26
            java.lang.Object r4 = r0.decodeNullableSerializableElement(r1, r4, r15, r8)
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r15 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            r15.<init>(r3)
            r33 = r4
            r4 = 27
            java.lang.Object r4 = r0.decodeNullableSerializableElement(r1, r4, r15, r8)
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r15 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            kotlinx.serialization.internal.EnumSerializer r8 = new kotlinx.serialization.internal.EnumSerializer
            r35 = r4
            java.lang.String r4 = "com.deliveryhero.fluid.widgets.containers.HorizontalAlignment"
            r36 = r5
            com.deliveryhero.fluid.widgets.containers.HorizontalAlignment[] r5 = com.deliveryhero.fluid.widgets.containers.HorizontalAlignment.values()
            r8.<init>(r4, r5)
            r15.<init>(r8)
            r4 = 28
            r8 = 0
            java.lang.Object r4 = r0.decodeNullableSerializableElement(r1, r4, r15, r8)
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r5 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            kotlinx.serialization.internal.EnumSerializer r15 = new kotlinx.serialization.internal.EnumSerializer
            java.lang.String r8 = "com.deliveryhero.fluid.widgets.containers.VerticalAlignment"
            r37 = r4
            com.deliveryhero.fluid.widgets.containers.VerticalAlignment[] r4 = com.deliveryhero.fluid.widgets.containers.VerticalAlignment.values()
            r15.<init>(r8, r4)
            r5.<init>(r15)
            r4 = 29
            r8 = 0
            java.lang.Object r4 = r0.decodeNullableSerializableElement(r1, r4, r5, r8)
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r5 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            r5.<init>(r2)
            r15 = 30
            java.lang.Object r5 = r0.decodeNullableSerializableElement(r1, r15, r5, r8)
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r15 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            r15.<init>(r2)
            r34 = r4
            r4 = 31
            java.lang.Object r4 = r0.decodeNullableSerializableElement(r1, r4, r15, r8)
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r15 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            r15.<init>(r2)
            r2 = 32
            java.lang.Object r2 = r0.decodeNullableSerializableElement(r1, r2, r15, r8)
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r15 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            r15.<init>(r3)
            r16 = r2
            r2 = 33
            java.lang.Object r2 = r0.decodeNullableSerializableElement(r1, r2, r15, r8)
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r15 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            r15.<init>(r3)
            r38 = r2
            r2 = 34
            java.lang.Object r2 = r0.decodeNullableSerializableElement(r1, r2, r15, r8)
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r15 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            r15.<init>(r3)
            r39 = r2
            r2 = 35
            java.lang.Object r2 = r0.decodeNullableSerializableElement(r1, r2, r15, r8)
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r15 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            r15.<init>(r3)
            r40 = r2
            r2 = 36
            java.lang.Object r2 = r0.decodeNullableSerializableElement(r1, r2, r15, r8)
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r15 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            r15.<init>(r3)
            r3 = 37
            java.lang.Object r3 = r0.decodeNullableSerializableElement(r1, r3, r15, r8)
            r8 = 63
            r15 = -1
            r67 = r4
            r44 = r7
            r70 = r8
            r8 = r11
            r55 = r13
            r69 = r15
            r4 = r27
            r57 = r28
            r58 = r29
            r63 = r33
            r64 = r35
            r15 = r38
            r65 = r39
            r7 = r40
            r13 = r3
            r11 = r5
            r3 = r19
            r5 = r112
            r110 = r14
            r14 = r2
            r2 = r16
            r16 = r110
            goto L_0x0b01
        L_0x024a:
            r62 = r6
            r12 = r7
            r2 = r8
            r3 = r2
            r4 = r3
            r5 = r4
            r6 = r5
            r9 = r6
            r10 = r9
            r11 = r10
            r13 = r11
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
            r58 = r57
            r59 = r58
            r60 = r59
            r61 = r60
            r7 = r61
            r8 = r12
        L_0x028f:
            r63 = r2
            if (r62 == 0) goto L_0x0a9e
            int r2 = r0.decodeElementIndex(r1)
            switch(r2) {
                case -1: goto L_0x0a3d;
                case 0: goto L_0x09fc;
                case 1: goto L_0x09b6;
                case 2: goto L_0x0978;
                case 3: goto L_0x092f;
                case 4: goto L_0x08e3;
                case 5: goto L_0x08a1;
                case 6: goto L_0x0864;
                case 7: goto L_0x0825;
                case 8: goto L_0x07e0;
                case 9: goto L_0x079b;
                case 10: goto L_0x075e;
                case 11: goto L_0x0720;
                case 12: goto L_0x06e2;
                case 13: goto L_0x06a4;
                case 14: goto L_0x0666;
                case 15: goto L_0x0626;
                case 16: goto L_0x05e7;
                case 17: goto L_0x05a8;
                case 18: goto L_0x0562;
                case 19: goto L_0x0520;
                case 20: goto L_0x04dc;
                case 21: goto L_0x04bb;
                case 22: goto L_0x049a;
                case 23: goto L_0x0479;
                case 24: goto L_0x0457;
                case 25: goto L_0x0437;
                case 26: goto L_0x0405;
                case 27: goto L_0x03d0;
                case 28: goto L_0x0392;
                case 29: goto L_0x036f;
                case 30: goto L_0x033a;
                case 31: goto L_0x0322;
                case 32: goto L_0x030d;
                case 33: goto L_0x02f8;
                case 34: goto L_0x02e2;
                case 35: goto L_0x02cc;
                case 36: goto L_0x02b6;
                case 37: goto L_0x02a0;
                default: goto L_0x029a;
            }
        L_0x029a:
            kotlinx.serialization.UnknownFieldException r0 = new kotlinx.serialization.UnknownFieldException
            r0.<init>((int) r2)
            throw r0
        L_0x02a0:
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r2 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            r64 = r4
            com.deliveryhero.fluid.values.LogicalPixel$$serializer r4 = com.deliveryhero.fluid.values.LogicalPixel$$serializer.INSTANCE
            r2.<init>(r4)
            r4 = 37
            java.lang.Object r2 = r0.decodeNullableSerializableElement(r1, r4, r2, r13)
            r8 = r8 | 32
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            r13 = r2
            goto L_0x034f
        L_0x02b6:
            r64 = r4
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r2 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            com.deliveryhero.fluid.values.LogicalPixel$$serializer r4 = com.deliveryhero.fluid.values.LogicalPixel$$serializer.INSTANCE
            r2.<init>(r4)
            r4 = 36
            java.lang.Object r2 = r0.decodeNullableSerializableElement(r1, r4, r2, r14)
            r8 = r8 | 16
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            r14 = r2
            goto L_0x034f
        L_0x02cc:
            r64 = r4
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r2 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            com.deliveryhero.fluid.values.LogicalPixel$$serializer r4 = com.deliveryhero.fluid.values.LogicalPixel$$serializer.INSTANCE
            r2.<init>(r4)
            r4 = 35
            java.lang.Object r2 = r0.decodeNullableSerializableElement(r1, r4, r2, r7)
            r8 = r8 | 8
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            r7 = r2
            goto L_0x034f
        L_0x02e2:
            r64 = r4
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r2 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            com.deliveryhero.fluid.values.LogicalPixel$$serializer r4 = com.deliveryhero.fluid.values.LogicalPixel$$serializer.INSTANCE
            r2.<init>(r4)
            r4 = 34
            java.lang.Object r2 = r0.decodeNullableSerializableElement(r1, r4, r2, r3)
            r8 = r8 | 4
            kotlin.Unit r3 = kotlin.Unit.INSTANCE
            r65 = r2
            goto L_0x0351
        L_0x02f8:
            r64 = r4
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r2 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            com.deliveryhero.fluid.values.LogicalPixel$$serializer r4 = com.deliveryhero.fluid.values.LogicalPixel$$serializer.INSTANCE
            r2.<init>(r4)
            r4 = 33
            java.lang.Object r2 = r0.decodeNullableSerializableElement(r1, r4, r2, r15)
            r8 = r8 | 2
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            r15 = r2
            goto L_0x034f
        L_0x030d:
            r64 = r4
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r2 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            kotlinx.serialization.internal.StringSerializer r4 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            r2.<init>(r4)
            r4 = 32
            java.lang.Object r2 = r0.decodeNullableSerializableElement(r1, r4, r2, r5)
            r8 = r8 | 1
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            r5 = r2
            goto L_0x034f
        L_0x0322:
            r64 = r4
            r4 = 32
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r2 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            kotlinx.serialization.internal.StringSerializer r4 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            r2.<init>(r4)
            r4 = 31
            java.lang.Object r2 = r0.decodeNullableSerializableElement(r1, r4, r2, r6)
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r12 = r12 | r4
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            r6 = r2
            goto L_0x034f
        L_0x033a:
            r64 = r4
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r2 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            kotlinx.serialization.internal.StringSerializer r4 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            r2.<init>(r4)
            r4 = 30
            java.lang.Object r2 = r0.decodeNullableSerializableElement(r1, r4, r2, r11)
            r4 = 1073741824(0x40000000, float:2.0)
            r12 = r12 | r4
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            r11 = r2
        L_0x034f:
            r65 = r3
        L_0x0351:
            r33 = r42
            r34 = r43
            r35 = r44
            r27 = r46
            r26 = r47
            r25 = r48
            r23 = r49
            r22 = r50
            r21 = r51
            r20 = r52
            r18 = r53
            r17 = r55
            r2 = r63
            r4 = r64
            goto L_0x0519
        L_0x036f:
            r64 = r4
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r2 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            kotlinx.serialization.internal.EnumSerializer r4 = new kotlinx.serialization.internal.EnumSerializer
            r65 = r3
            java.lang.String r3 = "com.deliveryhero.fluid.widgets.containers.VerticalAlignment"
            r66 = r5
            com.deliveryhero.fluid.widgets.containers.VerticalAlignment[] r5 = com.deliveryhero.fluid.widgets.containers.VerticalAlignment.values()
            r4.<init>(r3, r5)
            r2.<init>(r4)
            r3 = 29
            java.lang.Object r2 = r0.decodeNullableSerializableElement(r1, r3, r2, r10)
            r3 = 536870912(0x20000000, float:1.0842022E-19)
            r12 = r12 | r3
            kotlin.Unit r3 = kotlin.Unit.INSTANCE
            r10 = r2
            goto L_0x03b4
        L_0x0392:
            r65 = r3
            r64 = r4
            r66 = r5
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r2 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            kotlinx.serialization.internal.EnumSerializer r3 = new kotlinx.serialization.internal.EnumSerializer
            java.lang.String r4 = "com.deliveryhero.fluid.widgets.containers.HorizontalAlignment"
            com.deliveryhero.fluid.widgets.containers.HorizontalAlignment[] r5 = com.deliveryhero.fluid.widgets.containers.HorizontalAlignment.values()
            r3.<init>(r4, r5)
            r2.<init>(r3)
            r3 = 28
            java.lang.Object r2 = r0.decodeNullableSerializableElement(r1, r3, r2, r9)
            r3 = 268435456(0x10000000, float:2.5243549E-29)
            r12 = r12 | r3
            kotlin.Unit r3 = kotlin.Unit.INSTANCE
            r9 = r2
        L_0x03b4:
            r33 = r42
            r34 = r43
            r35 = r44
            r27 = r46
            r26 = r47
            r25 = r48
            r23 = r49
            r22 = r50
            r21 = r51
            r20 = r52
            r18 = r53
            r17 = r55
            r2 = r63
            goto L_0x0515
        L_0x03d0:
            r65 = r3
            r64 = r4
            r66 = r5
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r2 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            com.deliveryhero.fluid.values.LogicalPixel$$serializer r3 = com.deliveryhero.fluid.values.LogicalPixel$$serializer.INSTANCE
            r2.<init>(r3)
            r3 = 27
            java.lang.Object r2 = r0.decodeNullableSerializableElement(r1, r3, r2, r4)
            r3 = 134217728(0x8000000, float:3.85186E-34)
            r12 = r12 | r3
            kotlin.Unit r3 = kotlin.Unit.INSTANCE
            r4 = r2
            r33 = r42
            r34 = r43
            r35 = r44
            r27 = r46
            r26 = r47
            r25 = r48
            r23 = r49
            r22 = r50
            r21 = r51
            r20 = r52
            r18 = r53
            r17 = r55
            r2 = r63
            goto L_0x0519
        L_0x0405:
            r65 = r3
            r66 = r5
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r2 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            com.deliveryhero.fluid.values.LogicalPixel$$serializer r3 = com.deliveryhero.fluid.values.LogicalPixel$$serializer.INSTANCE
            r2.<init>(r3)
            r3 = 26
            r5 = r63
            java.lang.Object r2 = r0.decodeNullableSerializableElement(r1, r3, r2, r5)
            r3 = 67108864(0x4000000, float:1.5046328E-36)
            r12 = r12 | r3
            kotlin.Unit r3 = kotlin.Unit.INSTANCE
            r33 = r42
            r34 = r43
            r35 = r44
            r27 = r46
            r26 = r47
            r25 = r48
            r23 = r49
            r22 = r50
            r21 = r51
            r20 = r52
            r18 = r53
            r17 = r55
            goto L_0x0517
        L_0x0437:
            r65 = r3
            r66 = r5
            r5 = r63
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r2 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            com.deliveryhero.fluid.values.LogicalPixel$$serializer r3 = com.deliveryhero.fluid.values.LogicalPixel$$serializer.INSTANCE
            r2.<init>(r3)
            r3 = 25
            r64 = r4
            r4 = r61
            java.lang.Object r2 = r0.decodeNullableSerializableElement(r1, r3, r2, r4)
            r3 = 33554432(0x2000000, float:9.403955E-38)
            r12 = r12 | r3
            kotlin.Unit r3 = kotlin.Unit.INSTANCE
            r61 = r2
            goto L_0x04fc
        L_0x0457:
            r65 = r3
            r64 = r4
            r66 = r5
            r4 = r61
            r5 = r63
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r2 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            com.deliveryhero.fluid.values.LogicalPixel$$serializer r3 = com.deliveryhero.fluid.values.LogicalPixel$$serializer.INSTANCE
            r2.<init>(r3)
            r3 = 24
            r4 = r60
            java.lang.Object r2 = r0.decodeNullableSerializableElement(r1, r3, r2, r4)
            r3 = 16777216(0x1000000, float:2.3509887E-38)
            r12 = r12 | r3
            kotlin.Unit r3 = kotlin.Unit.INSTANCE
            r60 = r2
            goto L_0x04fc
        L_0x0479:
            r65 = r3
            r64 = r4
            r66 = r5
            r4 = r60
            r5 = r63
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r2 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            com.deliveryhero.fluid.values.LogicalPixel$$serializer r3 = com.deliveryhero.fluid.values.LogicalPixel$$serializer.INSTANCE
            r2.<init>(r3)
            r3 = 23
            r4 = r59
            java.lang.Object r2 = r0.decodeNullableSerializableElement(r1, r3, r2, r4)
            r3 = 8388608(0x800000, float:1.17549435E-38)
            r12 = r12 | r3
            kotlin.Unit r3 = kotlin.Unit.INSTANCE
            r59 = r2
            goto L_0x04fc
        L_0x049a:
            r65 = r3
            r64 = r4
            r66 = r5
            r4 = r59
            r5 = r63
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r2 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            com.deliveryhero.fluid.values.LogicalPixel$$serializer r3 = com.deliveryhero.fluid.values.LogicalPixel$$serializer.INSTANCE
            r2.<init>(r3)
            r3 = 22
            r4 = r58
            java.lang.Object r2 = r0.decodeNullableSerializableElement(r1, r3, r2, r4)
            r3 = 4194304(0x400000, float:5.877472E-39)
            r12 = r12 | r3
            kotlin.Unit r3 = kotlin.Unit.INSTANCE
            r58 = r2
            goto L_0x04fc
        L_0x04bb:
            r65 = r3
            r64 = r4
            r66 = r5
            r4 = r58
            r5 = r63
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r2 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            com.deliveryhero.fluid.values.LogicalPixel$$serializer r3 = com.deliveryhero.fluid.values.LogicalPixel$$serializer.INSTANCE
            r2.<init>(r3)
            r3 = 21
            r4 = r57
            java.lang.Object r2 = r0.decodeNullableSerializableElement(r1, r3, r2, r4)
            r3 = 2097152(0x200000, float:2.938736E-39)
            r12 = r12 | r3
            kotlin.Unit r3 = kotlin.Unit.INSTANCE
            r57 = r2
            goto L_0x04fc
        L_0x04dc:
            r65 = r3
            r64 = r4
            r66 = r5
            r4 = r57
            r5 = r63
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r2 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            com.deliveryhero.fluid.values.LogicalPixel$$serializer r3 = com.deliveryhero.fluid.values.LogicalPixel$$serializer.INSTANCE
            r2.<init>(r3)
            r3 = 20
            r4 = r56
            java.lang.Object r2 = r0.decodeNullableSerializableElement(r1, r3, r2, r4)
            r3 = 1048576(0x100000, float:1.469368E-39)
            r12 = r12 | r3
            kotlin.Unit r3 = kotlin.Unit.INSTANCE
            r56 = r2
        L_0x04fc:
            r2 = r5
            r33 = r42
            r34 = r43
            r35 = r44
            r27 = r46
            r26 = r47
            r25 = r48
            r23 = r49
            r22 = r50
            r21 = r51
            r20 = r52
            r18 = r53
            r17 = r55
        L_0x0515:
            r4 = r64
        L_0x0517:
            r5 = r66
        L_0x0519:
            r3 = 0
            r44 = r41
            r55 = r45
            goto L_0x0a7e
        L_0x0520:
            r65 = r3
            r64 = r4
            r66 = r5
            r4 = r56
            r5 = r63
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r2 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            kotlinx.serialization.internal.BooleanSerializer r3 = kotlinx.serialization.internal.BooleanSerializer.INSTANCE
            r2.<init>(r3)
            r3 = 19
            r4 = r55
            java.lang.Object r2 = r0.decodeNullableSerializableElement(r1, r3, r2, r4)
            r3 = 524288(0x80000, float:7.34684E-40)
            r12 = r12 | r3
            kotlin.Unit r3 = kotlin.Unit.INSTANCE
            r17 = r2
            r2 = r5
            r33 = r42
            r34 = r43
            r35 = r44
            r55 = r45
            r27 = r46
            r26 = r47
            r25 = r48
            r23 = r49
            r22 = r50
            r21 = r51
            r20 = r52
            r18 = r53
            r4 = r64
            r5 = r66
            r3 = 0
            r44 = r41
            goto L_0x0a7e
        L_0x0562:
            r65 = r3
            r64 = r4
            r66 = r5
            r4 = r55
            r5 = r63
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r2 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            com.deliveryhero.fluid.values.LogicalPixel$$serializer r3 = com.deliveryhero.fluid.values.LogicalPixel$$serializer.INSTANCE
            r2.<init>(r3)
            r3 = r54
            r54 = r4
            r4 = 18
            java.lang.Object r2 = r0.decodeNullableSerializableElement(r1, r4, r2, r3)
            r3 = 262144(0x40000, float:3.67342E-40)
            r12 = r12 | r3
            kotlin.Unit r3 = kotlin.Unit.INSTANCE
            r33 = r42
            r34 = r43
            r35 = r44
            r55 = r45
            r27 = r46
            r26 = r47
            r25 = r48
            r23 = r49
            r22 = r50
            r21 = r51
            r20 = r52
            r18 = r53
            r17 = r54
            r4 = r64
            r3 = 0
            r54 = r2
            r2 = r5
            r44 = r41
            r5 = r66
            goto L_0x0a7e
        L_0x05a8:
            r65 = r3
            r64 = r4
            r66 = r5
            r3 = r54
            r54 = r55
            r5 = r63
            r4 = 18
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r2 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            com.deliveryhero.fluid.values.Color$$serializer r4 = com.deliveryhero.fluid.values.Color$$serializer.INSTANCE
            r2.<init>(r4)
            r17 = r3
            r4 = r53
            r3 = 17
            java.lang.Object r2 = r0.decodeNullableSerializableElement(r1, r3, r2, r4)
            r4 = 131072(0x20000, float:1.83671E-40)
            r12 = r12 | r4
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            r18 = r2
            r2 = r5
            r33 = r42
            r34 = r43
            r35 = r44
            r55 = r45
            r27 = r46
            r26 = r47
            r25 = r48
            r23 = r49
            r22 = r50
            r21 = r51
            r20 = r52
            goto L_0x07d7
        L_0x05e7:
            r65 = r3
            r64 = r4
            r66 = r5
            r4 = r53
            r17 = r54
            r54 = r55
            r5 = r63
            r3 = 17
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r2 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            com.deliveryhero.fluid.values.LogicalPixel$$serializer r3 = com.deliveryhero.fluid.values.LogicalPixel$$serializer.INSTANCE
            r2.<init>(r3)
            r18 = r4
            r3 = r52
            r4 = 16
            java.lang.Object r2 = r0.decodeNullableSerializableElement(r1, r4, r2, r3)
            r3 = 65536(0x10000, float:9.18355E-41)
            r12 = r12 | r3
            kotlin.Unit r3 = kotlin.Unit.INSTANCE
            r20 = r2
            r2 = r5
            r33 = r42
            r34 = r43
            r35 = r44
            r55 = r45
            r27 = r46
            r26 = r47
            r25 = r48
            r23 = r49
            r22 = r50
            r21 = r51
            goto L_0x07d7
        L_0x0626:
            r65 = r3
            r64 = r4
            r66 = r5
            r3 = r52
            r18 = r53
            r17 = r54
            r54 = r55
            r5 = r63
            r4 = 16
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r2 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            com.deliveryhero.fluid.values.LogicalPixel$$serializer r4 = com.deliveryhero.fluid.values.LogicalPixel$$serializer.INSTANCE
            r2.<init>(r4)
            r20 = r3
            r4 = r51
            r3 = 15
            java.lang.Object r2 = r0.decodeNullableSerializableElement(r1, r3, r2, r4)
            r4 = 32768(0x8000, float:4.5918E-41)
            r12 = r12 | r4
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            r21 = r2
            r2 = r5
            r33 = r42
            r34 = r43
            r35 = r44
            r55 = r45
            r27 = r46
            r26 = r47
            r25 = r48
            r23 = r49
            r22 = r50
            goto L_0x07d7
        L_0x0666:
            r65 = r3
            r64 = r4
            r66 = r5
            r4 = r51
            r20 = r52
            r18 = r53
            r17 = r54
            r54 = r55
            r5 = r63
            r3 = 15
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r2 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            com.deliveryhero.fluid.values.LogicalPixel$$serializer r3 = com.deliveryhero.fluid.values.LogicalPixel$$serializer.INSTANCE
            r2.<init>(r3)
            r21 = r4
            r3 = r50
            r4 = 14
            java.lang.Object r2 = r0.decodeNullableSerializableElement(r1, r4, r2, r3)
            r12 = r12 | 16384(0x4000, float:2.2959E-41)
            kotlin.Unit r3 = kotlin.Unit.INSTANCE
            r22 = r2
            r2 = r5
            r33 = r42
            r34 = r43
            r35 = r44
            r55 = r45
            r27 = r46
            r26 = r47
            r25 = r48
            r23 = r49
            goto L_0x07d7
        L_0x06a4:
            r65 = r3
            r64 = r4
            r66 = r5
            r3 = r50
            r21 = r51
            r20 = r52
            r18 = r53
            r17 = r54
            r54 = r55
            r5 = r63
            r4 = 14
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r2 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            com.deliveryhero.fluid.values.LogicalPixel$$serializer r4 = com.deliveryhero.fluid.values.LogicalPixel$$serializer.INSTANCE
            r2.<init>(r4)
            r22 = r3
            r4 = r49
            r3 = 13
            java.lang.Object r2 = r0.decodeNullableSerializableElement(r1, r3, r2, r4)
            r12 = r12 | 8192(0x2000, float:1.14794E-41)
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            r23 = r2
            r2 = r5
            r33 = r42
            r34 = r43
            r35 = r44
            r55 = r45
            r27 = r46
            r26 = r47
            r25 = r48
            goto L_0x07d7
        L_0x06e2:
            r65 = r3
            r64 = r4
            r66 = r5
            r4 = r49
            r22 = r50
            r21 = r51
            r20 = r52
            r18 = r53
            r17 = r54
            r54 = r55
            r5 = r63
            r3 = 13
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r2 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            com.deliveryhero.fluid.values.LogicalPixel$$serializer r3 = com.deliveryhero.fluid.values.LogicalPixel$$serializer.INSTANCE
            r2.<init>(r3)
            r23 = r4
            r3 = r48
            r4 = 12
            java.lang.Object r2 = r0.decodeNullableSerializableElement(r1, r4, r2, r3)
            r12 = r12 | 4096(0x1000, float:5.74E-42)
            kotlin.Unit r3 = kotlin.Unit.INSTANCE
            r25 = r2
            r2 = r5
            r33 = r42
            r34 = r43
            r35 = r44
            r55 = r45
            r27 = r46
            r26 = r47
            goto L_0x07d7
        L_0x0720:
            r65 = r3
            r64 = r4
            r66 = r5
            r3 = r48
            r23 = r49
            r22 = r50
            r21 = r51
            r20 = r52
            r18 = r53
            r17 = r54
            r54 = r55
            r5 = r63
            r4 = 12
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r2 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            com.deliveryhero.fluid.values.LogicalPixel$$serializer r4 = com.deliveryhero.fluid.values.LogicalPixel$$serializer.INSTANCE
            r2.<init>(r4)
            r25 = r3
            r4 = r47
            r3 = 11
            java.lang.Object r2 = r0.decodeNullableSerializableElement(r1, r3, r2, r4)
            r12 = r12 | 2048(0x800, float:2.87E-42)
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            r26 = r2
            r2 = r5
            r33 = r42
            r34 = r43
            r35 = r44
            r55 = r45
            r27 = r46
            goto L_0x07d7
        L_0x075e:
            r65 = r3
            r64 = r4
            r66 = r5
            r4 = r47
            r25 = r48
            r23 = r49
            r22 = r50
            r21 = r51
            r20 = r52
            r18 = r53
            r17 = r54
            r54 = r55
            r5 = r63
            r3 = 11
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r2 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            com.deliveryhero.fluid.values.LinearGradientOrientation$$serializer r3 = com.deliveryhero.fluid.values.LinearGradientOrientation$$serializer.INSTANCE
            r2.<init>(r3)
            r26 = r4
            r3 = r46
            r4 = 10
            java.lang.Object r2 = r0.decodeNullableSerializableElement(r1, r4, r2, r3)
            r12 = r12 | 1024(0x400, float:1.435E-42)
            kotlin.Unit r3 = kotlin.Unit.INSTANCE
            r27 = r2
            r2 = r5
            r33 = r42
            r34 = r43
            r35 = r44
            r55 = r45
            goto L_0x07d7
        L_0x079b:
            r65 = r3
            r64 = r4
            r66 = r5
            r3 = r46
            r26 = r47
            r25 = r48
            r23 = r49
            r22 = r50
            r21 = r51
            r20 = r52
            r18 = r53
            r17 = r54
            r54 = r55
            r5 = r63
            r4 = 10
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r2 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            com.deliveryhero.fluid.values.Shape$$serializer r4 = com.deliveryhero.fluid.values.Shape$$serializer.INSTANCE
            r2.<init>(r4)
            r27 = r3
            r4 = r45
            r3 = 9
            java.lang.Object r2 = r0.decodeNullableSerializableElement(r1, r3, r2, r4)
            r12 = r12 | 512(0x200, float:7.175E-43)
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            r55 = r2
            r2 = r5
            r33 = r42
            r34 = r43
            r35 = r44
        L_0x07d7:
            r4 = r64
            r5 = r66
            r3 = 0
            r44 = r41
            goto L_0x0a78
        L_0x07e0:
            r65 = r3
            r64 = r4
            r66 = r5
            r4 = r45
            r27 = r46
            r26 = r47
            r25 = r48
            r23 = r49
            r22 = r50
            r21 = r51
            r20 = r52
            r18 = r53
            r17 = r54
            r54 = r55
            r5 = r63
            r3 = 9
            kotlinx.serialization.internal.ArrayListSerializer r2 = new kotlinx.serialization.internal.ArrayListSerializer
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r3 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            r55 = r4
            com.deliveryhero.fluid.values.Color$$serializer r4 = com.deliveryhero.fluid.values.Color$$serializer.INSTANCE
            r3.<init>(r4)
            r2.<init>(r3)
            r3 = r44
            r4 = 8
            java.lang.Object r2 = r0.decodeNullableSerializableElement(r1, r4, r2, r3)
            r12 = r12 | 256(0x100, float:3.59E-43)
            kotlin.Unit r3 = kotlin.Unit.INSTANCE
            r35 = r2
            r2 = r5
            r44 = r41
            r33 = r42
            r34 = r43
            goto L_0x08dd
        L_0x0825:
            r65 = r3
            r64 = r4
            r66 = r5
            r3 = r44
            r27 = r46
            r26 = r47
            r25 = r48
            r23 = r49
            r22 = r50
            r21 = r51
            r20 = r52
            r18 = r53
            r17 = r54
            r54 = r55
            r5 = r63
            r4 = 8
            r55 = r45
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r2 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            kotlinx.serialization.internal.IntSerializer r4 = kotlinx.serialization.internal.IntSerializer.INSTANCE
            r2.<init>(r4)
            r35 = r3
            r4 = r43
            r3 = 7
            java.lang.Object r2 = r0.decodeNullableSerializableElement(r1, r3, r2, r4)
            r12 = r12 | 128(0x80, float:1.794E-43)
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            r34 = r2
            r2 = r5
            r44 = r41
            r33 = r42
            goto L_0x08dd
        L_0x0864:
            r65 = r3
            r64 = r4
            r66 = r5
            r4 = r43
            r35 = r44
            r27 = r46
            r26 = r47
            r25 = r48
            r23 = r49
            r22 = r50
            r21 = r51
            r20 = r52
            r18 = r53
            r17 = r54
            r54 = r55
            r5 = r63
            r3 = 7
            r55 = r45
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r2 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            kotlinx.serialization.internal.IntSerializer r3 = kotlinx.serialization.internal.IntSerializer.INSTANCE
            r2.<init>(r3)
            r34 = r4
            r3 = r42
            r4 = 6
            java.lang.Object r2 = r0.decodeNullableSerializableElement(r1, r4, r2, r3)
            r12 = r12 | 64
            kotlin.Unit r3 = kotlin.Unit.INSTANCE
            r33 = r2
            r2 = r5
            r44 = r41
            goto L_0x08dd
        L_0x08a1:
            r65 = r3
            r64 = r4
            r66 = r5
            r3 = r42
            r34 = r43
            r35 = r44
            r27 = r46
            r26 = r47
            r25 = r48
            r23 = r49
            r22 = r50
            r21 = r51
            r20 = r52
            r18 = r53
            r17 = r54
            r54 = r55
            r5 = r63
            r4 = 6
            r55 = r45
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r2 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            kotlinx.serialization.internal.BooleanSerializer r4 = kotlinx.serialization.internal.BooleanSerializer.INSTANCE
            r2.<init>(r4)
            r33 = r3
            r4 = r41
            r3 = 5
            java.lang.Object r2 = r0.decodeNullableSerializableElement(r1, r3, r2, r4)
            r12 = r12 | 32
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            r44 = r2
            r2 = r5
        L_0x08dd:
            r4 = r64
            r5 = r66
            goto L_0x09f9
        L_0x08e3:
            r65 = r3
            r64 = r4
            r66 = r5
            r4 = r41
            r33 = r42
            r34 = r43
            r35 = r44
            r27 = r46
            r26 = r47
            r25 = r48
            r23 = r49
            r22 = r50
            r21 = r51
            r20 = r52
            r18 = r53
            r17 = r54
            r54 = r55
            r5 = r63
            r3 = 5
            r55 = r45
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r2 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            kotlinx.serialization.PolymorphicSerializer r3 = new kotlinx.serialization.PolymorphicSerializer
            r44 = r4
            kotlin.reflect.KClass r4 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r19)
            r67 = r6
            r5 = 0
            java.lang.annotation.Annotation[] r6 = new java.lang.annotation.Annotation[r5]
            r3.<init>(r4, r6)
            r2.<init>(r3)
            r3 = r40
            r4 = 4
            java.lang.Object r2 = r0.decodeNullableSerializableElement(r1, r4, r2, r3)
            r12 = r12 | 16
            kotlin.Unit r3 = kotlin.Unit.INSTANCE
            r40 = r2
            r3 = r5
            goto L_0x0a70
        L_0x092f:
            r65 = r3
            r64 = r4
            r66 = r5
            r67 = r6
            r3 = r40
            r33 = r42
            r34 = r43
            r35 = r44
            r27 = r46
            r26 = r47
            r25 = r48
            r23 = r49
            r22 = r50
            r21 = r51
            r20 = r52
            r18 = r53
            r17 = r54
            r54 = r55
            r4 = 4
            r5 = 0
            r44 = r41
            r55 = r45
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r2 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            kotlinx.serialization.PolymorphicSerializer r6 = new kotlinx.serialization.PolymorphicSerializer
            kotlin.reflect.KClass r4 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r19)
            java.lang.annotation.Annotation[] r3 = new java.lang.annotation.Annotation[r5]
            r6.<init>(r4, r3)
            r2.<init>(r6)
            r3 = r39
            r4 = 3
            java.lang.Object r2 = r0.decodeNullableSerializableElement(r1, r4, r2, r3)
            r12 = r12 | 8
            kotlin.Unit r3 = kotlin.Unit.INSTANCE
            r39 = r2
            goto L_0x09f1
        L_0x0978:
            r65 = r3
            r64 = r4
            r66 = r5
            r67 = r6
            r3 = r39
            r33 = r42
            r34 = r43
            r35 = r44
            r27 = r46
            r26 = r47
            r25 = r48
            r23 = r49
            r22 = r50
            r21 = r51
            r20 = r52
            r18 = r53
            r17 = r54
            r54 = r55
            r4 = 3
            r44 = r41
            r55 = r45
            kotlinx.serialization.internal.LinkedHashSetSerializer r2 = new kotlinx.serialization.internal.LinkedHashSetSerializer
            com.deliveryhero.fluid.expression.placeholder.PlaceholderSurrogate$$serializer r5 = com.deliveryhero.fluid.expression.placeholder.PlaceholderSurrogate$$serializer.INSTANCE
            r2.<init>(r5)
            r5 = r38
            r6 = 2
            java.lang.Object r2 = r0.decodeSerializableElement(r1, r6, r2, r5)
            r12 = r12 | 4
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            r38 = r2
            goto L_0x09f1
        L_0x09b6:
            r65 = r3
            r64 = r4
            r66 = r5
            r67 = r6
            r5 = r38
            r3 = r39
            r33 = r42
            r34 = r43
            r35 = r44
            r27 = r46
            r26 = r47
            r25 = r48
            r23 = r49
            r22 = r50
            r21 = r51
            r20 = r52
            r18 = r53
            r17 = r54
            r54 = r55
            r4 = 3
            r6 = 2
            r44 = r41
            r55 = r45
            kotlinx.serialization.internal.StringSerializer r2 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            r4 = r37
            r6 = 1
            java.lang.Object r2 = r0.decodeNullableSerializableElement(r1, r6, r2, r4)
            r12 = r12 | 2
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            r37 = r2
        L_0x09f1:
            r2 = r63
            r4 = r64
            r5 = r66
            r6 = r67
        L_0x09f9:
            r3 = 0
            goto L_0x0a78
        L_0x09fc:
            r65 = r3
            r64 = r4
            r66 = r5
            r67 = r6
            r4 = r37
            r5 = r38
            r3 = r39
            r33 = r42
            r34 = r43
            r35 = r44
            r27 = r46
            r26 = r47
            r25 = r48
            r23 = r49
            r22 = r50
            r21 = r51
            r20 = r52
            r18 = r53
            r17 = r54
            r54 = r55
            r6 = 1
            r44 = r41
            r55 = r45
            kotlinx.serialization.internal.StringSerializer r2 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            r32 = r3
            r6 = r36
            r3 = 0
            java.lang.Object r2 = r0.decodeNullableSerializableElement(r1, r3, r2, r6)
            r12 = r12 | 1
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            r36 = r2
            r39 = r32
            goto L_0x0a70
        L_0x0a3d:
            r65 = r3
            r64 = r4
            r66 = r5
            r67 = r6
            r6 = r36
            r4 = r37
            r5 = r38
            r32 = r39
            r33 = r42
            r34 = r43
            r35 = r44
            r27 = r46
            r26 = r47
            r25 = r48
            r23 = r49
            r22 = r50
            r21 = r51
            r20 = r52
            r18 = r53
            r17 = r54
            r54 = r55
            r3 = 0
            r44 = r41
            r55 = r45
            kotlin.Unit r2 = kotlin.Unit.INSTANCE
            r62 = r3
        L_0x0a70:
            r2 = r63
            r4 = r64
            r5 = r66
            r6 = r67
        L_0x0a78:
            r110 = r54
            r54 = r17
            r17 = r110
        L_0x0a7e:
            r53 = r18
            r52 = r20
            r51 = r21
            r50 = r22
            r49 = r23
            r48 = r25
            r47 = r26
            r46 = r27
            r42 = r33
            r43 = r34
            r41 = r44
            r45 = r55
            r3 = r65
            r55 = r17
            r44 = r35
            goto L_0x028f
        L_0x0a9e:
            r65 = r3
            r64 = r4
            r66 = r5
            r67 = r6
            r6 = r36
            r4 = r37
            r5 = r38
            r32 = r39
            r33 = r42
            r34 = r43
            r35 = r44
            r27 = r46
            r26 = r47
            r25 = r48
            r23 = r49
            r22 = r50
            r21 = r51
            r20 = r52
            r18 = r53
            r17 = r54
            r54 = r55
            r44 = r41
            r55 = r45
            r36 = r5
            r24 = r6
            r70 = r8
            r37 = r9
            r69 = r12
            r5 = r17
            r16 = r18
            r17 = r20
            r20 = r21
            r21 = r22
            r22 = r23
            r23 = r25
            r25 = r26
            r26 = r27
            r8 = r34
            r12 = r35
            r3 = r40
            r9 = r54
            r18 = r56
            r30 = r59
            r31 = r60
            r2 = r66
            r6 = r4
            r34 = r10
            r4 = r32
            r10 = r33
            r32 = r61
        L_0x0b01:
            r0.endStructure(r1)
            com.talabat.fluid.homescreen.ui.widget.orderstatus.OrderStatusModelBuilder r0 = new com.talabat.fluid.homescreen.ui.widget.orderstatus.OrderStatusModelBuilder
            r68 = r0
            r71 = r24
            java.lang.String r71 = (java.lang.String) r71
            r72 = r6
            java.lang.String r72 = (java.lang.String) r72
            r73 = r36
            java.util.Set r73 = (java.util.Set) r73
            r74 = r4
            com.deliveryhero.fluid.expression.ExpressionBuilder r74 = (com.deliveryhero.fluid.expression.ExpressionBuilder) r74
            r75 = r3
            com.deliveryhero.fluid.expression.ExpressionBuilder r75 = (com.deliveryhero.fluid.expression.ExpressionBuilder) r75
            r76 = r44
            com.deliveryhero.fluid.expression.ExpressionBuilder r76 = (com.deliveryhero.fluid.expression.ExpressionBuilder) r76
            r77 = r10
            com.deliveryhero.fluid.expression.ExpressionBuilder r77 = (com.deliveryhero.fluid.expression.ExpressionBuilder) r77
            r78 = r8
            com.deliveryhero.fluid.expression.ExpressionBuilder r78 = (com.deliveryhero.fluid.expression.ExpressionBuilder) r78
            r79 = r12
            java.util.List r79 = (java.util.List) r79
            r80 = r55
            com.deliveryhero.fluid.expression.ExpressionBuilder r80 = (com.deliveryhero.fluid.expression.ExpressionBuilder) r80
            r81 = r26
            com.deliveryhero.fluid.expression.ExpressionBuilder r81 = (com.deliveryhero.fluid.expression.ExpressionBuilder) r81
            r82 = r25
            com.deliveryhero.fluid.expression.ExpressionBuilder r82 = (com.deliveryhero.fluid.expression.ExpressionBuilder) r82
            r83 = r23
            com.deliveryhero.fluid.expression.ExpressionBuilder r83 = (com.deliveryhero.fluid.expression.ExpressionBuilder) r83
            r84 = r22
            com.deliveryhero.fluid.expression.ExpressionBuilder r84 = (com.deliveryhero.fluid.expression.ExpressionBuilder) r84
            r85 = r21
            com.deliveryhero.fluid.expression.ExpressionBuilder r85 = (com.deliveryhero.fluid.expression.ExpressionBuilder) r85
            r86 = r20
            com.deliveryhero.fluid.expression.ExpressionBuilder r86 = (com.deliveryhero.fluid.expression.ExpressionBuilder) r86
            r87 = r17
            com.deliveryhero.fluid.expression.ExpressionBuilder r87 = (com.deliveryhero.fluid.expression.ExpressionBuilder) r87
            r88 = r16
            com.deliveryhero.fluid.expression.ExpressionBuilder r88 = (com.deliveryhero.fluid.expression.ExpressionBuilder) r88
            r89 = r5
            com.deliveryhero.fluid.expression.ExpressionBuilder r89 = (com.deliveryhero.fluid.expression.ExpressionBuilder) r89
            r90 = r9
            com.deliveryhero.fluid.expression.ExpressionBuilder r90 = (com.deliveryhero.fluid.expression.ExpressionBuilder) r90
            r91 = r18
            com.deliveryhero.fluid.expression.ExpressionBuilder r91 = (com.deliveryhero.fluid.expression.ExpressionBuilder) r91
            r92 = r57
            com.deliveryhero.fluid.expression.ExpressionBuilder r92 = (com.deliveryhero.fluid.expression.ExpressionBuilder) r92
            r93 = r58
            com.deliveryhero.fluid.expression.ExpressionBuilder r93 = (com.deliveryhero.fluid.expression.ExpressionBuilder) r93
            r94 = r30
            com.deliveryhero.fluid.expression.ExpressionBuilder r94 = (com.deliveryhero.fluid.expression.ExpressionBuilder) r94
            r95 = r31
            com.deliveryhero.fluid.expression.ExpressionBuilder r95 = (com.deliveryhero.fluid.expression.ExpressionBuilder) r95
            r96 = r32
            com.deliveryhero.fluid.expression.ExpressionBuilder r96 = (com.deliveryhero.fluid.expression.ExpressionBuilder) r96
            r97 = r63
            com.deliveryhero.fluid.expression.ExpressionBuilder r97 = (com.deliveryhero.fluid.expression.ExpressionBuilder) r97
            r98 = r64
            com.deliveryhero.fluid.expression.ExpressionBuilder r98 = (com.deliveryhero.fluid.expression.ExpressionBuilder) r98
            r99 = r37
            com.deliveryhero.fluid.expression.ExpressionBuilder r99 = (com.deliveryhero.fluid.expression.ExpressionBuilder) r99
            r100 = r34
            com.deliveryhero.fluid.expression.ExpressionBuilder r100 = (com.deliveryhero.fluid.expression.ExpressionBuilder) r100
            r101 = r11
            com.deliveryhero.fluid.expression.ExpressionBuilder r101 = (com.deliveryhero.fluid.expression.ExpressionBuilder) r101
            r102 = r67
            com.deliveryhero.fluid.expression.ExpressionBuilder r102 = (com.deliveryhero.fluid.expression.ExpressionBuilder) r102
            r103 = r2
            com.deliveryhero.fluid.expression.ExpressionBuilder r103 = (com.deliveryhero.fluid.expression.ExpressionBuilder) r103
            r104 = r15
            com.deliveryhero.fluid.expression.ExpressionBuilder r104 = (com.deliveryhero.fluid.expression.ExpressionBuilder) r104
            r105 = r65
            com.deliveryhero.fluid.expression.ExpressionBuilder r105 = (com.deliveryhero.fluid.expression.ExpressionBuilder) r105
            r106 = r7
            com.deliveryhero.fluid.expression.ExpressionBuilder r106 = (com.deliveryhero.fluid.expression.ExpressionBuilder) r106
            r107 = r14
            com.deliveryhero.fluid.expression.ExpressionBuilder r107 = (com.deliveryhero.fluid.expression.ExpressionBuilder) r107
            r108 = r13
            com.deliveryhero.fluid.expression.ExpressionBuilder r108 = (com.deliveryhero.fluid.expression.ExpressionBuilder) r108
            r109 = 0
            r68.<init>(r69, r70, r71, r72, r73, r74, r75, r76, r77, r78, r79, r80, r81, r82, r83, r84, r85, r86, r87, r88, r89, r90, r91, r92, r93, r94, r95, r96, r97, r98, r99, r100, r101, r102, r103, r104, r105, r106, r107, r108, r109)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.fluid.homescreen.ui.widget.orderstatus.OrderStatusModelBuilder$$serializer.deserialize(kotlinx.serialization.encoding.Decoder):com.talabat.fluid.homescreen.ui.widget.orderstatus.OrderStatusModelBuilder");
    }

    @NotNull
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    public void serialize(@NotNull Encoder encoder, @NotNull OrderStatusModelBuilder orderStatusModelBuilder) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(orderStatusModelBuilder, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder beginStructure = encoder.beginStructure(descriptor2);
        OrderStatusModelBuilder.write$Self(orderStatusModelBuilder, beginStructure, descriptor2);
        beginStructure.endStructure(descriptor2);
    }

    @NotNull
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
