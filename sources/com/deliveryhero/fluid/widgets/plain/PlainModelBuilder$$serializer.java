package com.deliveryhero.fluid.widgets.plain;

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

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"com/deliveryhero/fluid/widgets/plain/PlainModelBuilder.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/deliveryhero/fluid/widgets/plain/PlainModelBuilder;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
public final class PlainModelBuilder$$serializer implements GeneratedSerializer<PlainModelBuilder> {
    @NotNull
    public static final PlainModelBuilder$$serializer INSTANCE;
    public static final /* synthetic */ SerialDescriptor descriptor;

    static {
        PlainModelBuilder$$serializer plainModelBuilder$$serializer = new PlainModelBuilder$$serializer();
        INSTANCE = plainModelBuilder$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("plain", plainModelBuilder$$serializer, 33);
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
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private PlainModelBuilder$$serializer() {
    }

    @NotNull
    public KSerializer<?>[] childSerializers() {
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        Class<Size> cls = Size.class;
        BooleanSerializer booleanSerializer = BooleanSerializer.INSTANCE;
        IntSerializer intSerializer = IntSerializer.INSTANCE;
        Color$$serializer color$$serializer = Color$$serializer.INSTANCE;
        LogicalPixel$$serializer logicalPixel$$serializer = LogicalPixel$$serializer.INSTANCE;
        return new KSerializer[]{BuiltinSerializersKt.getNullable(stringSerializer), BuiltinSerializersKt.getNullable(stringSerializer), new LinkedHashSetSerializer(PlaceholderSurrogate$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(new ExpressionBuilderSerializer(new PolymorphicSerializer(Reflection.getOrCreateKotlinClass(cls), new Annotation[0]))), BuiltinSerializersKt.getNullable(new ExpressionBuilderSerializer(new PolymorphicSerializer(Reflection.getOrCreateKotlinClass(cls), new Annotation[0]))), BuiltinSerializersKt.getNullable(new ExpressionBuilderSerializer(booleanSerializer)), BuiltinSerializersKt.getNullable(new ExpressionBuilderSerializer(intSerializer)), BuiltinSerializersKt.getNullable(new ExpressionBuilderSerializer(intSerializer)), BuiltinSerializersKt.getNullable(new ArrayListSerializer(new ExpressionBuilderSerializer(color$$serializer))), BuiltinSerializersKt.getNullable(new ExpressionBuilderSerializer(Shape$$serializer.INSTANCE)), BuiltinSerializersKt.getNullable(new ExpressionBuilderSerializer(LinearGradientOrientation$$serializer.INSTANCE)), BuiltinSerializersKt.getNullable(new ExpressionBuilderSerializer(logicalPixel$$serializer)), BuiltinSerializersKt.getNullable(new ExpressionBuilderSerializer(logicalPixel$$serializer)), BuiltinSerializersKt.getNullable(new ExpressionBuilderSerializer(logicalPixel$$serializer)), BuiltinSerializersKt.getNullable(new ExpressionBuilderSerializer(logicalPixel$$serializer)), BuiltinSerializersKt.getNullable(new ExpressionBuilderSerializer(logicalPixel$$serializer)), BuiltinSerializersKt.getNullable(new ExpressionBuilderSerializer(logicalPixel$$serializer)), BuiltinSerializersKt.getNullable(new ExpressionBuilderSerializer(color$$serializer)), BuiltinSerializersKt.getNullable(new ExpressionBuilderSerializer(logicalPixel$$serializer)), BuiltinSerializersKt.getNullable(new ExpressionBuilderSerializer(booleanSerializer)), BuiltinSerializersKt.getNullable(new ExpressionBuilderSerializer(logicalPixel$$serializer)), BuiltinSerializersKt.getNullable(new ExpressionBuilderSerializer(logicalPixel$$serializer)), BuiltinSerializersKt.getNullable(new ExpressionBuilderSerializer(logicalPixel$$serializer)), BuiltinSerializersKt.getNullable(new ExpressionBuilderSerializer(logicalPixel$$serializer)), BuiltinSerializersKt.getNullable(new ExpressionBuilderSerializer(logicalPixel$$serializer)), BuiltinSerializersKt.getNullable(new ExpressionBuilderSerializer(logicalPixel$$serializer)), BuiltinSerializersKt.getNullable(new ExpressionBuilderSerializer(logicalPixel$$serializer)), BuiltinSerializersKt.getNullable(new ExpressionBuilderSerializer(logicalPixel$$serializer)), BuiltinSerializersKt.getNullable(new ExpressionBuilderSerializer(new EnumSerializer("com.deliveryhero.fluid.widgets.containers.HorizontalAlignment", HorizontalAlignment.values()))), BuiltinSerializersKt.getNullable(new ExpressionBuilderSerializer(new EnumSerializer("com.deliveryhero.fluid.widgets.containers.VerticalAlignment", VerticalAlignment.values()))), BuiltinSerializersKt.getNullable(new ExpressionBuilderSerializer(stringSerializer)), BuiltinSerializersKt.getNullable(new ExpressionBuilderSerializer(stringSerializer)), BuiltinSerializersKt.getNullable(new ExpressionBuilderSerializer(stringSerializer))};
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r55v0, resolved type: com.deliveryhero.fluid.expression.ExpressionBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r54v0, resolved type: com.deliveryhero.fluid.expression.ExpressionBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r50v0, resolved type: com.deliveryhero.fluid.expression.ExpressionBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r45v0, resolved type: com.deliveryhero.fluid.expression.ExpressionBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r44v0, resolved type: com.deliveryhero.fluid.expression.ExpressionBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r44v1, resolved type: com.deliveryhero.fluid.expression.ExpressionBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r45v1, resolved type: com.deliveryhero.fluid.expression.ExpressionBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r46v0, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r47v0, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r48v0, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r49v0, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r50v1, resolved type: com.deliveryhero.fluid.expression.ExpressionBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r53v0, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r54v1, resolved type: com.deliveryhero.fluid.expression.ExpressionBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r55v1, resolved type: com.deliveryhero.fluid.expression.ExpressionBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r55v2, resolved type: com.deliveryhero.fluid.expression.ExpressionBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r54v2, resolved type: com.deliveryhero.fluid.expression.ExpressionBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r53v1, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r50v2, resolved type: com.deliveryhero.fluid.expression.ExpressionBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r49v1, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r48v1, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r47v1, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r46v1, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r45v2, resolved type: com.deliveryhero.fluid.expression.ExpressionBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r44v2, resolved type: com.deliveryhero.fluid.expression.ExpressionBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r55v3, resolved type: com.deliveryhero.fluid.expression.ExpressionBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r54v3, resolved type: com.deliveryhero.fluid.expression.ExpressionBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r53v2, resolved type: com.deliveryhero.fluid.expression.ExpressionBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r52v3, resolved type: com.deliveryhero.fluid.expression.ExpressionBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r50v3, resolved type: com.deliveryhero.fluid.expression.ExpressionBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r49v2, resolved type: com.deliveryhero.fluid.expression.ExpressionBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r48v2, resolved type: com.deliveryhero.fluid.expression.ExpressionBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r47v2, resolved type: com.deliveryhero.fluid.expression.ExpressionBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r46v2, resolved type: com.deliveryhero.fluid.expression.ExpressionBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r45v3, resolved type: com.deliveryhero.fluid.expression.ExpressionBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r44v3, resolved type: com.deliveryhero.fluid.expression.ExpressionBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r52v4, resolved type: com.deliveryhero.fluid.expression.ExpressionBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r51v6, resolved type: com.deliveryhero.fluid.expression.ExpressionBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r51v8, resolved type: com.deliveryhero.fluid.expression.ExpressionBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r50v4, resolved type: com.deliveryhero.fluid.expression.ExpressionBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r45v4, resolved type: com.deliveryhero.fluid.expression.ExpressionBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r44v4, resolved type: com.deliveryhero.fluid.expression.ExpressionBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r52v13, resolved type: com.deliveryhero.fluid.expression.ExpressionBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r51v16, resolved type: com.deliveryhero.fluid.expression.ExpressionBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r50v5, resolved type: com.deliveryhero.fluid.expression.ExpressionBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r45v5, resolved type: com.deliveryhero.fluid.expression.ExpressionBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r44v5, resolved type: com.deliveryhero.fluid.expression.ExpressionBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r50v6, resolved type: com.deliveryhero.fluid.expression.ExpressionBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r45v6, resolved type: com.deliveryhero.fluid.expression.ExpressionBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r44v6, resolved type: com.deliveryhero.fluid.expression.ExpressionBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r49v6, resolved type: com.deliveryhero.fluid.expression.ExpressionBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r48v6, resolved type: com.deliveryhero.fluid.expression.ExpressionBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r47v6, resolved type: com.deliveryhero.fluid.expression.ExpressionBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r46v6, resolved type: com.deliveryhero.fluid.expression.ExpressionBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r45v7, resolved type: com.deliveryhero.fluid.expression.ExpressionBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r44v7, resolved type: com.deliveryhero.fluid.expression.ExpressionBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v48, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r44v8, resolved type: com.deliveryhero.fluid.expression.ExpressionBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v50, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r45v8, resolved type: com.deliveryhero.fluid.expression.ExpressionBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r46v7, resolved type: com.deliveryhero.fluid.expression.ExpressionBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r47v7, resolved type: com.deliveryhero.fluid.expression.ExpressionBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r48v7, resolved type: com.deliveryhero.fluid.expression.ExpressionBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r49v7, resolved type: com.deliveryhero.fluid.expression.ExpressionBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v60, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r50v7, resolved type: com.deliveryhero.fluid.expression.ExpressionBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r55v4, resolved type: com.deliveryhero.fluid.expression.ExpressionBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r54v4, resolved type: com.deliveryhero.fluid.expression.ExpressionBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r53v4, resolved type: com.deliveryhero.fluid.expression.ExpressionBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r52v22, resolved type: com.deliveryhero.fluid.expression.ExpressionBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r53v5, resolved type: com.deliveryhero.fluid.expression.ExpressionBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r55v5, resolved type: com.deliveryhero.fluid.expression.ExpressionBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r54v5, resolved type: com.deliveryhero.fluid.expression.ExpressionBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v68, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r54v6, resolved type: com.deliveryhero.fluid.expression.ExpressionBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v70, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r55v6, resolved type: com.deliveryhero.fluid.expression.ExpressionBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v59, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v38, resolved type: com.deliveryhero.fluid.expression.ExpressionBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v61, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r27v0, resolved type: com.deliveryhero.fluid.expression.ExpressionBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v71, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r34v7, resolved type: com.deliveryhero.fluid.expression.ExpressionBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v75, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v41, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r55v7, resolved type: com.deliveryhero.fluid.expression.ExpressionBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r54v7, resolved type: com.deliveryhero.fluid.expression.ExpressionBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r44v9, resolved type: com.deliveryhero.fluid.expression.ExpressionBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r45v9, resolved type: com.deliveryhero.fluid.expression.ExpressionBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r50v8, resolved type: com.deliveryhero.fluid.expression.ExpressionBuilder} */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0295, code lost:
        r59 = r36;
        r22 = r37;
        r21 = r38;
        r20 = r39;
        r18 = r40;
        r17 = r41;
        r9 = r56;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0313, code lost:
        r59 = r36;
        r22 = r37;
        r21 = r38;
        r20 = r39;
        r18 = r40;
        r17 = r41;
        r9 = r56;
        r10 = r58;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0450, code lost:
        r59 = r36;
        r22 = r37;
        r21 = r38;
        r20 = r39;
        r18 = r40;
        r17 = r41;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x045c, code lost:
        r9 = r56;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0495, code lost:
        r51 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x065c, code lost:
        r59 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x065e, code lost:
        r9 = r56;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x072b, code lost:
        r59 = r6;
        r4 = r43;
        r9 = r56;
        r51 = r10;
        r43 = r42;
        r10 = r58;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x07c0, code lost:
        r43 = r42;
        r52 = r51;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x07c4, code lost:
        r51 = r10;
        r42 = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x07c8, code lost:
        r10 = r58;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x088b, code lost:
        r3 = r52;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x088d, code lost:
        r52 = r51;
        r51 = r10;
        r10 = r4;
        r4 = r43;
        r43 = r42;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0896, code lost:
        r42 = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0898, code lost:
        r41 = r17;
        r40 = r18;
        r39 = r20;
        r38 = r21;
        r37 = r22;
        r6 = r57;
        r36 = r59;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.deliveryhero.fluid.widgets.plain.PlainModelBuilder deserialize(@org.jetbrains.annotations.NotNull kotlinx.serialization.encoding.Decoder r99) {
        /*
            r98 = this;
            r0 = r99
            java.lang.String r1 = "decoder"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            kotlinx.serialization.descriptors.SerialDescriptor r1 = r98.getDescriptor()
            kotlinx.serialization.encoding.CompositeDecoder r0 = r0.beginStructure(r1)
            boolean r2 = r0.decodeSequentially()
            r12 = 7
            r13 = 6
            r14 = 5
            r15 = 3
            r4 = 8
            r3 = 4
            r5 = 2
            java.lang.Class<com.deliveryhero.fluid.values.Size> r19 = com.deliveryhero.fluid.values.Size.class
            r6 = 1
            r7 = 0
            r8 = 0
            if (r2 == 0) goto L_0x01f8
            kotlinx.serialization.internal.StringSerializer r2 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            java.lang.Object r23 = r0.decodeNullableSerializableElement(r1, r7, r2, r8)
            java.lang.Object r24 = r0.decodeNullableSerializableElement(r1, r6, r2, r8)
            kotlinx.serialization.internal.LinkedHashSetSerializer r6 = new kotlinx.serialization.internal.LinkedHashSetSerializer
            com.deliveryhero.fluid.expression.placeholder.PlaceholderSurrogate$$serializer r9 = com.deliveryhero.fluid.expression.placeholder.PlaceholderSurrogate$$serializer.INSTANCE
            r6.<init>(r9)
            java.lang.Object r5 = r0.decodeSerializableElement(r1, r5, r6, r8)
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r6 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            kotlinx.serialization.PolymorphicSerializer r9 = new kotlinx.serialization.PolymorphicSerializer
            kotlin.reflect.KClass r10 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r19)
            java.lang.annotation.Annotation[] r11 = new java.lang.annotation.Annotation[r7]
            r9.<init>(r10, r11)
            r6.<init>(r9)
            java.lang.Object r6 = r0.decodeNullableSerializableElement(r1, r15, r6, r8)
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
            java.lang.Object r4 = r0.decodeNullableSerializableElement(r1, r4, r12, r8)
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r12 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            com.deliveryhero.fluid.values.Shape$$serializer r13 = com.deliveryhero.fluid.values.Shape$$serializer.INSTANCE
            r12.<init>(r13)
            r13 = 9
            java.lang.Object r12 = r0.decodeNullableSerializableElement(r1, r13, r12, r8)
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r13 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            com.deliveryhero.fluid.values.LinearGradientOrientation$$serializer r15 = com.deliveryhero.fluid.values.LinearGradientOrientation$$serializer.INSTANCE
            r13.<init>(r15)
            r15 = 10
            java.lang.Object r13 = r0.decodeNullableSerializableElement(r1, r15, r13, r8)
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r15 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            r19 = r3
            com.deliveryhero.fluid.values.LogicalPixel$$serializer r3 = com.deliveryhero.fluid.values.LogicalPixel$$serializer.INSTANCE
            r15.<init>(r3)
            r26 = r4
            r4 = 11
            java.lang.Object r4 = r0.decodeNullableSerializableElement(r1, r4, r15, r8)
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r15 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            r15.<init>(r3)
            r25 = r4
            r4 = 12
            java.lang.Object r4 = r0.decodeNullableSerializableElement(r1, r4, r15, r8)
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r15 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            r15.<init>(r3)
            r22 = r4
            r4 = 13
            java.lang.Object r4 = r0.decodeNullableSerializableElement(r1, r4, r15, r8)
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r15 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            r15.<init>(r3)
            r21 = r4
            r4 = 14
            java.lang.Object r4 = r0.decodeNullableSerializableElement(r1, r4, r15, r8)
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r15 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            r15.<init>(r3)
            r20 = r4
            r4 = 15
            java.lang.Object r4 = r0.decodeNullableSerializableElement(r1, r4, r15, r8)
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r15 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            r15.<init>(r3)
            r18 = r4
            r4 = 16
            java.lang.Object r4 = r0.decodeNullableSerializableElement(r1, r4, r15, r8)
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r15 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            r15.<init>(r14)
            r14 = 17
            java.lang.Object r14 = r0.decodeNullableSerializableElement(r1, r14, r15, r8)
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r15 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            r15.<init>(r3)
            r16 = r4
            r4 = 18
            java.lang.Object r4 = r0.decodeNullableSerializableElement(r1, r4, r15, r8)
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r15 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            r15.<init>(r9)
            r9 = 19
            java.lang.Object r9 = r0.decodeNullableSerializableElement(r1, r9, r15, r8)
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r15 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            r15.<init>(r3)
            r99 = r4
            r4 = 20
            java.lang.Object r4 = r0.decodeNullableSerializableElement(r1, r4, r15, r8)
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r15 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            r15.<init>(r3)
            r17 = r4
            r4 = 21
            java.lang.Object r4 = r0.decodeNullableSerializableElement(r1, r4, r15, r8)
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r15 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            r15.<init>(r3)
            r27 = r4
            r4 = 22
            java.lang.Object r4 = r0.decodeNullableSerializableElement(r1, r4, r15, r8)
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r15 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            r15.<init>(r3)
            r28 = r4
            r4 = 23
            java.lang.Object r4 = r0.decodeNullableSerializableElement(r1, r4, r15, r8)
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r15 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            r15.<init>(r3)
            r29 = r4
            r4 = 24
            java.lang.Object r4 = r0.decodeNullableSerializableElement(r1, r4, r15, r8)
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r15 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            r15.<init>(r3)
            r30 = r4
            r4 = 25
            java.lang.Object r4 = r0.decodeNullableSerializableElement(r1, r4, r15, r8)
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r15 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            r15.<init>(r3)
            r31 = r4
            r4 = 26
            java.lang.Object r4 = r0.decodeNullableSerializableElement(r1, r4, r15, r8)
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r15 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            r15.<init>(r3)
            r3 = 27
            java.lang.Object r3 = r0.decodeNullableSerializableElement(r1, r3, r15, r8)
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r15 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            kotlinx.serialization.internal.EnumSerializer r8 = new kotlinx.serialization.internal.EnumSerializer
            r33 = r3
            java.lang.String r3 = "com.deliveryhero.fluid.widgets.containers.HorizontalAlignment"
            r34 = r4
            com.deliveryhero.fluid.widgets.containers.HorizontalAlignment[] r4 = com.deliveryhero.fluid.widgets.containers.HorizontalAlignment.values()
            r8.<init>(r3, r4)
            r15.<init>(r8)
            r3 = 28
            r8 = 0
            java.lang.Object r3 = r0.decodeNullableSerializableElement(r1, r3, r15, r8)
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r4 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            kotlinx.serialization.internal.EnumSerializer r15 = new kotlinx.serialization.internal.EnumSerializer
            java.lang.String r8 = "com.deliveryhero.fluid.widgets.containers.VerticalAlignment"
            r35 = r3
            com.deliveryhero.fluid.widgets.containers.VerticalAlignment[] r3 = com.deliveryhero.fluid.widgets.containers.VerticalAlignment.values()
            r15.<init>(r8, r3)
            r4.<init>(r15)
            r3 = 29
            r8 = 0
            java.lang.Object r3 = r0.decodeNullableSerializableElement(r1, r3, r4, r8)
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r4 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            r4.<init>(r2)
            r15 = 30
            java.lang.Object r4 = r0.decodeNullableSerializableElement(r1, r15, r4, r8)
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r15 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            r15.<init>(r2)
            r32 = r3
            r3 = 31
            java.lang.Object r3 = r0.decodeNullableSerializableElement(r1, r3, r15, r8)
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r15 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            r15.<init>(r2)
            r2 = 32
            java.lang.Object r2 = r0.decodeNullableSerializableElement(r1, r2, r15, r8)
            r8 = -1
            r55 = r3
            r54 = r4
            r61 = r8
            r8 = r11
            r44 = r17
            r3 = r19
            r59 = r22
            r4 = r26
            r45 = r27
            r50 = r34
            r51 = r35
            r62 = 1
            r11 = r6
            r6 = r5
            r5 = r99
            goto L_0x08f9
        L_0x01f8:
            r2 = 32
            r35 = r7
            r3 = r8
            r4 = r3
            r5 = r4
            r6 = r5
            r9 = r6
            r10 = r9
            r11 = r10
            r12 = r11
            r13 = r12
            r14 = r13
            r15 = r14
            r33 = r15
            r36 = r33
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
            r34 = 1
            r7 = r55
            r8 = r35
        L_0x0237:
            if (r34 == 0) goto L_0x08aa
            int r2 = r0.decodeElementIndex(r1)
            switch(r2) {
                case -1: goto L_0x0869;
                case 0: goto L_0x083c;
                case 1: goto L_0x080d;
                case 2: goto L_0x07cc;
                case 3: goto L_0x077f;
                case 4: goto L_0x073a;
                case 5: goto L_0x06fc;
                case 6: goto L_0x06cb;
                case 7: goto L_0x069a;
                case 8: goto L_0x0663;
                case 9: goto L_0x062e;
                case 10: goto L_0x05ff;
                case 11: goto L_0x05cf;
                case 12: goto L_0x059c;
                case 13: goto L_0x0569;
                case 14: goto L_0x0536;
                case 15: goto L_0x0501;
                case 16: goto L_0x04cd;
                case 17: goto L_0x0499;
                case 18: goto L_0x0460;
                case 19: goto L_0x042e;
                case 20: goto L_0x040b;
                case 21: goto L_0x03e8;
                case 22: goto L_0x03c4;
                case 23: goto L_0x03a0;
                case 24: goto L_0x037c;
                case 25: goto L_0x0358;
                case 26: goto L_0x0326;
                case 27: goto L_0x02f5;
                case 28: goto L_0x02cd;
                case 29: goto L_0x02a5;
                case 30: goto L_0x0279;
                case 31: goto L_0x025c;
                case 32: goto L_0x0246;
                default: goto L_0x0240;
            }
        L_0x0240:
            kotlinx.serialization.UnknownFieldException r0 = new kotlinx.serialization.UnknownFieldException
            r0.<init>((int) r2)
            throw r0
        L_0x0246:
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r2 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            r56 = r9
            kotlinx.serialization.internal.StringSerializer r9 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            r2.<init>(r9)
            r9 = 32
            java.lang.Object r2 = r0.decodeNullableSerializableElement(r1, r9, r2, r6)
            r35 = r35 | 1
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            r57 = r2
            goto L_0x0295
        L_0x025c:
            r56 = r9
            r9 = 32
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r2 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            kotlinx.serialization.internal.StringSerializer r9 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            r2.<init>(r9)
            r9 = 31
            r57 = r6
            r6 = r55
            java.lang.Object r2 = r0.decodeNullableSerializableElement(r1, r9, r2, r6)
            r6 = -2147483648(0xffffffff80000000, float:-0.0)
            r8 = r8 | r6
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            r55 = r2
            goto L_0x0295
        L_0x0279:
            r57 = r6
            r56 = r9
            r6 = r55
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r2 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            kotlinx.serialization.internal.StringSerializer r9 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            r2.<init>(r9)
            r9 = 30
            r6 = r54
            java.lang.Object r2 = r0.decodeNullableSerializableElement(r1, r9, r2, r6)
            r6 = 1073741824(0x40000000, float:2.0)
            r8 = r8 | r6
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            r54 = r2
        L_0x0295:
            r59 = r36
            r22 = r37
            r21 = r38
            r20 = r39
            r18 = r40
            r17 = r41
            r9 = r56
            goto L_0x0323
        L_0x02a5:
            r57 = r6
            r56 = r9
            r6 = r54
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r2 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            kotlinx.serialization.internal.EnumSerializer r9 = new kotlinx.serialization.internal.EnumSerializer
            java.lang.String r6 = "com.deliveryhero.fluid.widgets.containers.VerticalAlignment"
            r58 = r10
            com.deliveryhero.fluid.widgets.containers.VerticalAlignment[] r10 = com.deliveryhero.fluid.widgets.containers.VerticalAlignment.values()
            r9.<init>(r6, r10)
            r2.<init>(r9)
            r6 = 29
            r9 = r53
            java.lang.Object r2 = r0.decodeNullableSerializableElement(r1, r6, r2, r9)
            r6 = 536870912(0x20000000, float:1.0842022E-19)
            r8 = r8 | r6
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            r53 = r2
            goto L_0x0313
        L_0x02cd:
            r57 = r6
            r56 = r9
            r58 = r10
            r9 = r53
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r2 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            kotlinx.serialization.internal.EnumSerializer r6 = new kotlinx.serialization.internal.EnumSerializer
            java.lang.String r10 = "com.deliveryhero.fluid.widgets.containers.HorizontalAlignment"
            com.deliveryhero.fluid.widgets.containers.HorizontalAlignment[] r9 = com.deliveryhero.fluid.widgets.containers.HorizontalAlignment.values()
            r6.<init>(r10, r9)
            r2.<init>(r6)
            r6 = 28
            r9 = r52
            java.lang.Object r2 = r0.decodeNullableSerializableElement(r1, r6, r2, r9)
            r6 = 268435456(0x10000000, float:2.5243549E-29)
            r8 = r8 | r6
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            r52 = r2
            goto L_0x0313
        L_0x02f5:
            r57 = r6
            r56 = r9
            r58 = r10
            r9 = r52
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r2 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            com.deliveryhero.fluid.values.LogicalPixel$$serializer r6 = com.deliveryhero.fluid.values.LogicalPixel$$serializer.INSTANCE
            r2.<init>(r6)
            r6 = 27
            r10 = r51
            java.lang.Object r2 = r0.decodeNullableSerializableElement(r1, r6, r2, r10)
            r6 = 134217728(0x8000000, float:3.85186E-34)
            r8 = r8 | r6
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            r51 = r2
        L_0x0313:
            r59 = r36
            r22 = r37
            r21 = r38
            r20 = r39
            r18 = r40
            r17 = r41
            r9 = r56
            r10 = r58
        L_0x0323:
            r6 = 0
            goto L_0x0898
        L_0x0326:
            r57 = r6
            r56 = r9
            r58 = r10
            r10 = r51
            r9 = r52
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r2 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            com.deliveryhero.fluid.values.LogicalPixel$$serializer r6 = com.deliveryhero.fluid.values.LogicalPixel$$serializer.INSTANCE
            r2.<init>(r6)
            r6 = 26
            r51 = r9
            r9 = r50
            java.lang.Object r2 = r0.decodeNullableSerializableElement(r1, r6, r2, r9)
            r6 = 67108864(0x4000000, float:1.5046328E-36)
            r8 = r8 | r6
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            r50 = r2
            r59 = r36
            r22 = r37
            r21 = r38
            r20 = r39
            r18 = r40
            r17 = r41
            r52 = r51
            goto L_0x045c
        L_0x0358:
            r57 = r6
            r56 = r9
            r58 = r10
            r9 = r50
            r10 = r51
            r51 = r52
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r2 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            com.deliveryhero.fluid.values.LogicalPixel$$serializer r6 = com.deliveryhero.fluid.values.LogicalPixel$$serializer.INSTANCE
            r2.<init>(r6)
            r6 = 25
            r9 = r49
            java.lang.Object r2 = r0.decodeNullableSerializableElement(r1, r6, r2, r9)
            r6 = 33554432(0x2000000, float:9.403955E-38)
            r8 = r8 | r6
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            r49 = r2
            goto L_0x0450
        L_0x037c:
            r57 = r6
            r56 = r9
            r58 = r10
            r9 = r49
            r10 = r51
            r51 = r52
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r2 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            com.deliveryhero.fluid.values.LogicalPixel$$serializer r6 = com.deliveryhero.fluid.values.LogicalPixel$$serializer.INSTANCE
            r2.<init>(r6)
            r6 = 24
            r9 = r48
            java.lang.Object r2 = r0.decodeNullableSerializableElement(r1, r6, r2, r9)
            r6 = 16777216(0x1000000, float:2.3509887E-38)
            r8 = r8 | r6
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            r48 = r2
            goto L_0x0450
        L_0x03a0:
            r57 = r6
            r56 = r9
            r58 = r10
            r9 = r48
            r10 = r51
            r51 = r52
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r2 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            com.deliveryhero.fluid.values.LogicalPixel$$serializer r6 = com.deliveryhero.fluid.values.LogicalPixel$$serializer.INSTANCE
            r2.<init>(r6)
            r6 = 23
            r9 = r47
            java.lang.Object r2 = r0.decodeNullableSerializableElement(r1, r6, r2, r9)
            r6 = 8388608(0x800000, float:1.17549435E-38)
            r8 = r8 | r6
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            r47 = r2
            goto L_0x0450
        L_0x03c4:
            r57 = r6
            r56 = r9
            r58 = r10
            r9 = r47
            r10 = r51
            r51 = r52
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r2 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            com.deliveryhero.fluid.values.LogicalPixel$$serializer r6 = com.deliveryhero.fluid.values.LogicalPixel$$serializer.INSTANCE
            r2.<init>(r6)
            r6 = 22
            r9 = r46
            java.lang.Object r2 = r0.decodeNullableSerializableElement(r1, r6, r2, r9)
            r6 = 4194304(0x400000, float:5.877472E-39)
            r8 = r8 | r6
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            r46 = r2
            goto L_0x0450
        L_0x03e8:
            r57 = r6
            r56 = r9
            r58 = r10
            r9 = r46
            r10 = r51
            r51 = r52
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r2 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            com.deliveryhero.fluid.values.LogicalPixel$$serializer r6 = com.deliveryhero.fluid.values.LogicalPixel$$serializer.INSTANCE
            r2.<init>(r6)
            r6 = 21
            r9 = r45
            java.lang.Object r2 = r0.decodeNullableSerializableElement(r1, r6, r2, r9)
            r6 = 2097152(0x200000, float:2.938736E-39)
            r8 = r8 | r6
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            r45 = r2
            goto L_0x0450
        L_0x040b:
            r57 = r6
            r56 = r9
            r58 = r10
            r9 = r45
            r10 = r51
            r51 = r52
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r2 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            com.deliveryhero.fluid.values.LogicalPixel$$serializer r6 = com.deliveryhero.fluid.values.LogicalPixel$$serializer.INSTANCE
            r2.<init>(r6)
            r6 = 20
            r9 = r44
            java.lang.Object r2 = r0.decodeNullableSerializableElement(r1, r6, r2, r9)
            r6 = 1048576(0x100000, float:1.469368E-39)
            r8 = r8 | r6
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            r44 = r2
            goto L_0x0450
        L_0x042e:
            r57 = r6
            r56 = r9
            r58 = r10
            r9 = r44
            r10 = r51
            r51 = r52
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r2 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            kotlinx.serialization.internal.BooleanSerializer r6 = kotlinx.serialization.internal.BooleanSerializer.INSTANCE
            r2.<init>(r6)
            r6 = 19
            r9 = r43
            java.lang.Object r2 = r0.decodeNullableSerializableElement(r1, r6, r2, r9)
            r6 = 524288(0x80000, float:7.34684E-40)
            r8 = r8 | r6
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            r43 = r2
        L_0x0450:
            r59 = r36
            r22 = r37
            r21 = r38
            r20 = r39
            r18 = r40
            r17 = r41
        L_0x045c:
            r9 = r56
            r6 = 0
            goto L_0x0495
        L_0x0460:
            r57 = r6
            r56 = r9
            r58 = r10
            r9 = r43
            r10 = r51
            r51 = r52
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r2 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            com.deliveryhero.fluid.values.LogicalPixel$$serializer r6 = com.deliveryhero.fluid.values.LogicalPixel$$serializer.INSTANCE
            r2.<init>(r6)
            r6 = r42
            r42 = r9
            r9 = 18
            java.lang.Object r2 = r0.decodeNullableSerializableElement(r1, r9, r2, r6)
            r6 = 262144(0x40000, float:3.67342E-40)
            r8 = r8 | r6
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            r59 = r36
            r22 = r37
            r21 = r38
            r20 = r39
            r18 = r40
            r17 = r41
            r43 = r42
            r9 = r56
            r6 = 0
            r42 = r2
        L_0x0495:
            r51 = r10
            goto L_0x07c8
        L_0x0499:
            r57 = r6
            r56 = r9
            r58 = r10
            r6 = r42
            r42 = r43
            r10 = r51
            r51 = r52
            r9 = 18
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r2 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            com.deliveryhero.fluid.values.Color$$serializer r9 = com.deliveryhero.fluid.values.Color$$serializer.INSTANCE
            r2.<init>(r9)
            r16 = r6
            r9 = r41
            r6 = 17
            java.lang.Object r2 = r0.decodeNullableSerializableElement(r1, r6, r2, r9)
            r9 = 131072(0x20000, float:1.83671E-40)
            r8 = r8 | r9
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            r17 = r2
            r59 = r36
            r22 = r37
            r21 = r38
            r20 = r39
            r18 = r40
            goto L_0x065e
        L_0x04cd:
            r57 = r6
            r56 = r9
            r58 = r10
            r9 = r41
            r16 = r42
            r42 = r43
            r10 = r51
            r51 = r52
            r6 = 17
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r2 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            com.deliveryhero.fluid.values.LogicalPixel$$serializer r6 = com.deliveryhero.fluid.values.LogicalPixel$$serializer.INSTANCE
            r2.<init>(r6)
            r17 = r9
            r6 = r40
            r9 = 16
            java.lang.Object r2 = r0.decodeNullableSerializableElement(r1, r9, r2, r6)
            r6 = 65536(0x10000, float:9.18355E-41)
            r8 = r8 | r6
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            r18 = r2
            r59 = r36
            r22 = r37
            r21 = r38
            r20 = r39
            goto L_0x065e
        L_0x0501:
            r57 = r6
            r56 = r9
            r58 = r10
            r6 = r40
            r17 = r41
            r16 = r42
            r42 = r43
            r10 = r51
            r51 = r52
            r9 = 16
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r2 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            com.deliveryhero.fluid.values.LogicalPixel$$serializer r9 = com.deliveryhero.fluid.values.LogicalPixel$$serializer.INSTANCE
            r2.<init>(r9)
            r18 = r6
            r9 = r39
            r6 = 15
            java.lang.Object r2 = r0.decodeNullableSerializableElement(r1, r6, r2, r9)
            r9 = 32768(0x8000, float:4.5918E-41)
            r8 = r8 | r9
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            r20 = r2
            r59 = r36
            r22 = r37
            r21 = r38
            goto L_0x065e
        L_0x0536:
            r57 = r6
            r56 = r9
            r58 = r10
            r9 = r39
            r18 = r40
            r17 = r41
            r16 = r42
            r42 = r43
            r10 = r51
            r51 = r52
            r6 = 15
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r2 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            com.deliveryhero.fluid.values.LogicalPixel$$serializer r6 = com.deliveryhero.fluid.values.LogicalPixel$$serializer.INSTANCE
            r2.<init>(r6)
            r20 = r9
            r6 = r38
            r9 = 14
            java.lang.Object r2 = r0.decodeNullableSerializableElement(r1, r9, r2, r6)
            r8 = r8 | 16384(0x4000, float:2.2959E-41)
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            r21 = r2
            r59 = r36
            r22 = r37
            goto L_0x065e
        L_0x0569:
            r57 = r6
            r56 = r9
            r58 = r10
            r6 = r38
            r20 = r39
            r18 = r40
            r17 = r41
            r16 = r42
            r42 = r43
            r10 = r51
            r51 = r52
            r9 = 14
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r2 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            com.deliveryhero.fluid.values.LogicalPixel$$serializer r9 = com.deliveryhero.fluid.values.LogicalPixel$$serializer.INSTANCE
            r2.<init>(r9)
            r21 = r6
            r9 = r37
            r6 = 13
            java.lang.Object r2 = r0.decodeNullableSerializableElement(r1, r6, r2, r9)
            r8 = r8 | 8192(0x2000, float:1.14794E-41)
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            r22 = r2
            r59 = r36
            goto L_0x065e
        L_0x059c:
            r57 = r6
            r56 = r9
            r58 = r10
            r9 = r37
            r21 = r38
            r20 = r39
            r18 = r40
            r17 = r41
            r16 = r42
            r42 = r43
            r10 = r51
            r51 = r52
            r6 = 13
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r2 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            com.deliveryhero.fluid.values.LogicalPixel$$serializer r6 = com.deliveryhero.fluid.values.LogicalPixel$$serializer.INSTANCE
            r2.<init>(r6)
            r22 = r9
            r6 = r36
            r9 = 12
            java.lang.Object r2 = r0.decodeNullableSerializableElement(r1, r9, r2, r6)
            r8 = r8 | 4096(0x1000, float:5.74E-42)
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            r59 = r2
            goto L_0x065e
        L_0x05cf:
            r57 = r6
            r56 = r9
            r58 = r10
            r6 = r36
            r22 = r37
            r21 = r38
            r20 = r39
            r18 = r40
            r17 = r41
            r16 = r42
            r42 = r43
            r10 = r51
            r51 = r52
            r9 = 12
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r2 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            com.deliveryhero.fluid.values.LogicalPixel$$serializer r9 = com.deliveryhero.fluid.values.LogicalPixel$$serializer.INSTANCE
            r2.<init>(r9)
            r9 = 11
            java.lang.Object r2 = r0.decodeNullableSerializableElement(r1, r9, r2, r4)
            r8 = r8 | 2048(0x800, float:2.87E-42)
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            r4 = r2
            goto L_0x065c
        L_0x05ff:
            r57 = r6
            r56 = r9
            r58 = r10
            r6 = r36
            r22 = r37
            r21 = r38
            r20 = r39
            r18 = r40
            r17 = r41
            r16 = r42
            r42 = r43
            r10 = r51
            r51 = r52
            r9 = 11
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r2 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            com.deliveryhero.fluid.values.LinearGradientOrientation$$serializer r9 = com.deliveryhero.fluid.values.LinearGradientOrientation$$serializer.INSTANCE
            r2.<init>(r9)
            r9 = 10
            java.lang.Object r2 = r0.decodeNullableSerializableElement(r1, r9, r2, r12)
            r8 = r8 | 1024(0x400, float:1.435E-42)
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            r12 = r2
            goto L_0x065c
        L_0x062e:
            r57 = r6
            r56 = r9
            r58 = r10
            r6 = r36
            r22 = r37
            r21 = r38
            r20 = r39
            r18 = r40
            r17 = r41
            r16 = r42
            r42 = r43
            r10 = r51
            r51 = r52
            r9 = 10
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r2 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            com.deliveryhero.fluid.values.Shape$$serializer r9 = com.deliveryhero.fluid.values.Shape$$serializer.INSTANCE
            r2.<init>(r9)
            r9 = 9
            java.lang.Object r2 = r0.decodeNullableSerializableElement(r1, r9, r2, r13)
            r8 = r8 | 512(0x200, float:7.175E-43)
            kotlin.Unit r13 = kotlin.Unit.INSTANCE
            r13 = r2
        L_0x065c:
            r59 = r6
        L_0x065e:
            r9 = r56
            r6 = 0
            goto L_0x07c4
        L_0x0663:
            r57 = r6
            r56 = r9
            r58 = r10
            r6 = r36
            r22 = r37
            r21 = r38
            r20 = r39
            r18 = r40
            r17 = r41
            r16 = r42
            r42 = r43
            r10 = r51
            r51 = r52
            r9 = 9
            kotlinx.serialization.internal.ArrayListSerializer r2 = new kotlinx.serialization.internal.ArrayListSerializer
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r9 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            r43 = r4
            com.deliveryhero.fluid.values.Color$$serializer r4 = com.deliveryhero.fluid.values.Color$$serializer.INSTANCE
            r9.<init>(r4)
            r2.<init>(r9)
            r4 = 8
            java.lang.Object r2 = r0.decodeNullableSerializableElement(r1, r4, r2, r14)
            r8 = r8 | 256(0x100, float:3.59E-43)
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            r14 = r2
            goto L_0x072b
        L_0x069a:
            r57 = r6
            r56 = r9
            r58 = r10
            r6 = r36
            r22 = r37
            r21 = r38
            r20 = r39
            r18 = r40
            r17 = r41
            r16 = r42
            r42 = r43
            r10 = r51
            r51 = r52
            r43 = r4
            r4 = 8
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r2 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            kotlinx.serialization.internal.IntSerializer r9 = kotlinx.serialization.internal.IntSerializer.INSTANCE
            r2.<init>(r9)
            r9 = 7
            java.lang.Object r2 = r0.decodeNullableSerializableElement(r1, r9, r2, r7)
            r8 = r8 | 128(0x80, float:1.794E-43)
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            r7 = r2
            goto L_0x072b
        L_0x06cb:
            r57 = r6
            r56 = r9
            r58 = r10
            r6 = r36
            r22 = r37
            r21 = r38
            r20 = r39
            r18 = r40
            r17 = r41
            r16 = r42
            r42 = r43
            r10 = r51
            r51 = r52
            r9 = 7
            r43 = r4
            r4 = 8
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r2 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            kotlinx.serialization.internal.IntSerializer r4 = kotlinx.serialization.internal.IntSerializer.INSTANCE
            r2.<init>(r4)
            r4 = 6
            java.lang.Object r2 = r0.decodeNullableSerializableElement(r1, r4, r2, r3)
            r8 = r8 | 64
            kotlin.Unit r3 = kotlin.Unit.INSTANCE
            r3 = r2
            goto L_0x072b
        L_0x06fc:
            r57 = r6
            r56 = r9
            r58 = r10
            r6 = r36
            r22 = r37
            r21 = r38
            r20 = r39
            r18 = r40
            r17 = r41
            r16 = r42
            r42 = r43
            r10 = r51
            r51 = r52
            r9 = 7
            r43 = r4
            r4 = 6
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r2 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            kotlinx.serialization.internal.BooleanSerializer r4 = kotlinx.serialization.internal.BooleanSerializer.INSTANCE
            r2.<init>(r4)
            r4 = 5
            java.lang.Object r2 = r0.decodeNullableSerializableElement(r1, r4, r2, r15)
            r8 = r8 | 32
            kotlin.Unit r15 = kotlin.Unit.INSTANCE
            r15 = r2
        L_0x072b:
            r59 = r6
            r4 = r43
            r9 = r56
            r6 = 0
            r51 = r10
            r43 = r42
            r10 = r58
            goto L_0x0896
        L_0x073a:
            r57 = r6
            r56 = r9
            r58 = r10
            r6 = r36
            r22 = r37
            r21 = r38
            r20 = r39
            r18 = r40
            r17 = r41
            r16 = r42
            r42 = r43
            r10 = r51
            r51 = r52
            r9 = 7
            r43 = r4
            r4 = 5
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r2 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            kotlinx.serialization.PolymorphicSerializer r4 = new kotlinx.serialization.PolymorphicSerializer
            kotlin.reflect.KClass r9 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r19)
            r52 = r3
            r59 = r6
            r3 = 0
            java.lang.annotation.Annotation[] r6 = new java.lang.annotation.Annotation[r3]
            r4.<init>(r9, r6)
            r2.<init>(r4)
            r4 = 4
            java.lang.Object r2 = r0.decodeNullableSerializableElement(r1, r4, r2, r5)
            r8 = r8 | 16
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            r5 = r2
            r6 = r3
            r4 = r43
            r3 = r52
            r9 = r56
            goto L_0x07c0
        L_0x077f:
            r57 = r6
            r56 = r9
            r58 = r10
            r59 = r36
            r22 = r37
            r21 = r38
            r20 = r39
            r18 = r40
            r17 = r41
            r16 = r42
            r42 = r43
            r10 = r51
            r51 = r52
            r52 = r3
            r43 = r4
            r3 = 0
            r4 = 4
            com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer r2 = new com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer
            kotlinx.serialization.PolymorphicSerializer r6 = new kotlinx.serialization.PolymorphicSerializer
            kotlin.reflect.KClass r9 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r19)
            java.lang.annotation.Annotation[] r4 = new java.lang.annotation.Annotation[r3]
            r6.<init>(r9, r4)
            r2.<init>(r6)
            r3 = 3
            java.lang.Object r2 = r0.decodeNullableSerializableElement(r1, r3, r2, r11)
            r8 = r8 | 8
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            r11 = r2
            r4 = r43
            r3 = r52
            r9 = r56
            r6 = 0
        L_0x07c0:
            r43 = r42
            r52 = r51
        L_0x07c4:
            r51 = r10
            r42 = r16
        L_0x07c8:
            r10 = r58
            goto L_0x0898
        L_0x07cc:
            r57 = r6
            r56 = r9
            r58 = r10
            r59 = r36
            r22 = r37
            r21 = r38
            r20 = r39
            r18 = r40
            r17 = r41
            r16 = r42
            r42 = r43
            r10 = r51
            r51 = r52
            r52 = r3
            r43 = r4
            r3 = 3
            kotlinx.serialization.internal.LinkedHashSetSerializer r2 = new kotlinx.serialization.internal.LinkedHashSetSerializer
            com.deliveryhero.fluid.expression.placeholder.PlaceholderSurrogate$$serializer r4 = com.deliveryhero.fluid.expression.placeholder.PlaceholderSurrogate$$serializer.INSTANCE
            r2.<init>(r4)
            r4 = r58
            r6 = 2
            java.lang.Object r2 = r0.decodeSerializableElement(r1, r6, r2, r4)
            r8 = r8 | 4
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            r4 = r43
            r3 = r52
            r6 = 0
            r43 = r42
            r52 = r51
            r51 = r10
            r42 = r16
            r10 = r2
            goto L_0x0898
        L_0x080d:
            r57 = r6
            r56 = r9
            r59 = r36
            r22 = r37
            r21 = r38
            r20 = r39
            r18 = r40
            r17 = r41
            r16 = r42
            r42 = r43
            r6 = 2
            r43 = r4
            r4 = r10
            r10 = r51
            r51 = r52
            r52 = r3
            r3 = 3
            kotlinx.serialization.internal.StringSerializer r2 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            r3 = 1
            java.lang.Object r2 = r0.decodeNullableSerializableElement(r1, r3, r2, r9)
            r8 = r8 | 2
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            r9 = r2
            r3 = r52
            r6 = 0
            goto L_0x088d
        L_0x083c:
            r57 = r6
            r59 = r36
            r22 = r37
            r21 = r38
            r20 = r39
            r18 = r40
            r17 = r41
            r16 = r42
            r42 = r43
            r6 = 2
            r43 = r4
            r4 = r10
            r10 = r51
            r51 = r52
            r52 = r3
            r3 = 1
            kotlinx.serialization.internal.StringSerializer r2 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            r3 = r33
            r6 = 0
            java.lang.Object r2 = r0.decodeNullableSerializableElement(r1, r6, r2, r3)
            r8 = r8 | 1
            kotlin.Unit r3 = kotlin.Unit.INSTANCE
            r33 = r2
            goto L_0x088b
        L_0x0869:
            r57 = r6
            r59 = r36
            r22 = r37
            r21 = r38
            r20 = r39
            r18 = r40
            r17 = r41
            r16 = r42
            r42 = r43
            r6 = 0
            r43 = r4
            r4 = r10
            r10 = r51
            r51 = r52
            r52 = r3
            r3 = r33
            kotlin.Unit r2 = kotlin.Unit.INSTANCE
            r34 = r6
        L_0x088b:
            r3 = r52
        L_0x088d:
            r52 = r51
            r51 = r10
            r10 = r4
            r4 = r43
            r43 = r42
        L_0x0896:
            r42 = r16
        L_0x0898:
            r41 = r17
            r40 = r18
            r39 = r20
            r38 = r21
            r37 = r22
            r6 = r57
            r36 = r59
            r2 = 32
            goto L_0x0237
        L_0x08aa:
            r57 = r6
            r59 = r36
            r22 = r37
            r21 = r38
            r20 = r39
            r18 = r40
            r17 = r41
            r16 = r42
            r42 = r43
            r43 = r4
            r4 = r10
            r10 = r51
            r51 = r52
            r52 = r3
            r3 = r33
            r23 = r3
            r6 = r4
            r3 = r5
            r61 = r8
            r24 = r9
            r33 = r10
            r4 = r14
            r5 = r16
            r14 = r17
            r16 = r18
            r18 = r20
            r20 = r21
            r21 = r22
            r62 = r35
            r9 = r42
            r25 = r43
            r28 = r46
            r29 = r47
            r30 = r48
            r31 = r49
            r10 = r52
            r32 = r53
            r2 = r57
            r8 = r7
            r7 = r15
            r97 = r13
            r13 = r12
            r12 = r97
        L_0x08f9:
            r0.endStructure(r1)
            com.deliveryhero.fluid.widgets.plain.PlainModelBuilder r0 = new com.deliveryhero.fluid.widgets.plain.PlainModelBuilder
            r60 = r0
            r63 = r23
            java.lang.String r63 = (java.lang.String) r63
            r64 = r24
            java.lang.String r64 = (java.lang.String) r64
            r65 = r6
            java.util.Set r65 = (java.util.Set) r65
            r66 = r11
            com.deliveryhero.fluid.expression.ExpressionBuilder r66 = (com.deliveryhero.fluid.expression.ExpressionBuilder) r66
            r67 = r3
            com.deliveryhero.fluid.expression.ExpressionBuilder r67 = (com.deliveryhero.fluid.expression.ExpressionBuilder) r67
            r68 = r7
            com.deliveryhero.fluid.expression.ExpressionBuilder r68 = (com.deliveryhero.fluid.expression.ExpressionBuilder) r68
            r69 = r10
            com.deliveryhero.fluid.expression.ExpressionBuilder r69 = (com.deliveryhero.fluid.expression.ExpressionBuilder) r69
            r70 = r8
            com.deliveryhero.fluid.expression.ExpressionBuilder r70 = (com.deliveryhero.fluid.expression.ExpressionBuilder) r70
            r71 = r4
            java.util.List r71 = (java.util.List) r71
            r72 = r12
            com.deliveryhero.fluid.expression.ExpressionBuilder r72 = (com.deliveryhero.fluid.expression.ExpressionBuilder) r72
            r73 = r13
            com.deliveryhero.fluid.expression.ExpressionBuilder r73 = (com.deliveryhero.fluid.expression.ExpressionBuilder) r73
            r74 = r25
            com.deliveryhero.fluid.expression.ExpressionBuilder r74 = (com.deliveryhero.fluid.expression.ExpressionBuilder) r74
            r75 = r59
            com.deliveryhero.fluid.expression.ExpressionBuilder r75 = (com.deliveryhero.fluid.expression.ExpressionBuilder) r75
            r76 = r21
            com.deliveryhero.fluid.expression.ExpressionBuilder r76 = (com.deliveryhero.fluid.expression.ExpressionBuilder) r76
            r77 = r20
            com.deliveryhero.fluid.expression.ExpressionBuilder r77 = (com.deliveryhero.fluid.expression.ExpressionBuilder) r77
            r78 = r18
            com.deliveryhero.fluid.expression.ExpressionBuilder r78 = (com.deliveryhero.fluid.expression.ExpressionBuilder) r78
            r79 = r16
            com.deliveryhero.fluid.expression.ExpressionBuilder r79 = (com.deliveryhero.fluid.expression.ExpressionBuilder) r79
            r80 = r14
            com.deliveryhero.fluid.expression.ExpressionBuilder r80 = (com.deliveryhero.fluid.expression.ExpressionBuilder) r80
            r81 = r5
            com.deliveryhero.fluid.expression.ExpressionBuilder r81 = (com.deliveryhero.fluid.expression.ExpressionBuilder) r81
            r82 = r9
            com.deliveryhero.fluid.expression.ExpressionBuilder r82 = (com.deliveryhero.fluid.expression.ExpressionBuilder) r82
            r83 = r44
            com.deliveryhero.fluid.expression.ExpressionBuilder r83 = (com.deliveryhero.fluid.expression.ExpressionBuilder) r83
            r84 = r45
            com.deliveryhero.fluid.expression.ExpressionBuilder r84 = (com.deliveryhero.fluid.expression.ExpressionBuilder) r84
            r85 = r28
            com.deliveryhero.fluid.expression.ExpressionBuilder r85 = (com.deliveryhero.fluid.expression.ExpressionBuilder) r85
            r86 = r29
            com.deliveryhero.fluid.expression.ExpressionBuilder r86 = (com.deliveryhero.fluid.expression.ExpressionBuilder) r86
            r87 = r30
            com.deliveryhero.fluid.expression.ExpressionBuilder r87 = (com.deliveryhero.fluid.expression.ExpressionBuilder) r87
            r88 = r31
            com.deliveryhero.fluid.expression.ExpressionBuilder r88 = (com.deliveryhero.fluid.expression.ExpressionBuilder) r88
            r89 = r50
            com.deliveryhero.fluid.expression.ExpressionBuilder r89 = (com.deliveryhero.fluid.expression.ExpressionBuilder) r89
            r90 = r33
            com.deliveryhero.fluid.expression.ExpressionBuilder r90 = (com.deliveryhero.fluid.expression.ExpressionBuilder) r90
            r91 = r51
            com.deliveryhero.fluid.expression.ExpressionBuilder r91 = (com.deliveryhero.fluid.expression.ExpressionBuilder) r91
            r92 = r32
            com.deliveryhero.fluid.expression.ExpressionBuilder r92 = (com.deliveryhero.fluid.expression.ExpressionBuilder) r92
            r93 = r54
            com.deliveryhero.fluid.expression.ExpressionBuilder r93 = (com.deliveryhero.fluid.expression.ExpressionBuilder) r93
            r94 = r55
            com.deliveryhero.fluid.expression.ExpressionBuilder r94 = (com.deliveryhero.fluid.expression.ExpressionBuilder) r94
            r95 = r2
            com.deliveryhero.fluid.expression.ExpressionBuilder r95 = (com.deliveryhero.fluid.expression.ExpressionBuilder) r95
            r96 = 0
            r60.<init>(r61, r62, r63, r64, r65, r66, r67, r68, r69, r70, r71, r72, r73, r74, r75, r76, r77, r78, r79, r80, r81, r82, r83, r84, r85, r86, r87, r88, r89, r90, r91, r92, r93, r94, r95, r96)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.deliveryhero.fluid.widgets.plain.PlainModelBuilder$$serializer.deserialize(kotlinx.serialization.encoding.Decoder):com.deliveryhero.fluid.widgets.plain.PlainModelBuilder");
    }

    @NotNull
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    public void serialize(@NotNull Encoder encoder, @NotNull PlainModelBuilder plainModelBuilder) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(plainModelBuilder, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder beginStructure = encoder.beginStructure(descriptor2);
        PlainModelBuilder.write$Self(plainModelBuilder, beginStructure, descriptor2);
        beginStructure.endStructure(descriptor2);
    }

    @NotNull
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
