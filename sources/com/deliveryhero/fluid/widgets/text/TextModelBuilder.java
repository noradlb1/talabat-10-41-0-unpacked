package com.deliveryhero.fluid.widgets.text;

import com.braze.ui.actions.brazeactions.steps.StepData;
import com.deliveryhero.fluid.expression.Expression;
import com.deliveryhero.fluid.expression.ExpressionBuilder;
import com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer;
import com.deliveryhero.fluid.expression.utils.ExpressionBuilderUtilsKt;
import com.deliveryhero.fluid.values.Color;
import com.deliveryhero.fluid.values.Color$$serializer;
import com.deliveryhero.fluid.values.LogicalPixel;
import com.deliveryhero.fluid.values.LogicalPixel$$serializer;
import com.deliveryhero.fluid.values.ScalableLogicalPixel;
import com.deliveryhero.fluid.values.ScalableLogicalPixel$$serializer;
import com.deliveryhero.fluid.values.codecs.scalar.ColorCodec;
import com.deliveryhero.fluid.values.codecs.scalar.FloatCodec;
import com.deliveryhero.fluid.values.codecs.scalar.IntegerCodec;
import com.deliveryhero.fluid.values.codecs.scalar.LineBreakModeCodec;
import com.deliveryhero.fluid.values.codecs.scalar.LogicalPixelCodec;
import com.deliveryhero.fluid.values.codecs.scalar.ScalableLogicalPixelCodec;
import com.deliveryhero.fluid.values.codecs.scalar.StringCodec;
import com.deliveryhero.fluid.values.codecs.scalar.TextAlignmentCodec;
import com.deliveryhero.fluid.values.codecs.scalar.TextStyleCodec;
import com.deliveryhero.fluid.versioning.CoreContract;
import com.deliveryhero.fluid.widgets.WidgetModelBuilder;
import java.lang.annotation.Annotation;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.ContextualSerializer;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.PolymorphicSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.Transient;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.EnumSerializer;
import kotlinx.serialization.internal.FloatSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.StringSerializer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000Ä\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b'\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0017\u0018\u0000 |2\u00020\u0001:\u0002{|B½\u0006\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0010\b\u0001\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\u0010\b\u0001\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f\u0012\u0010\b\u0001\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f\u0012\u0010\b\u0001\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\f\u0012\u0010\b\u0001\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f\u0012\u0010\b\u0001\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f\u0012\u0016\b\u0001\u0010\u0013\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\f\u0018\u00010\u0014\u0012\u0010\b\u0001\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\f\u0012\u0010\b\u0001\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\f\u0012\u0010\b\u0001\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\f\u0012\u0010\b\u0001\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\f\u0012\u0010\b\u0001\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\f\u0012\u0010\b\u0001\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\f\u0012\u0010\b\u0001\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\f\u0012\u0010\b\u0001\u0010 \u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\f\u0012\u0010\b\u0001\u0010!\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\f\u0012\u0010\b\u0001\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\f\u0012\u0010\b\u0001\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\f\u0012\u0010\b\u0001\u0010$\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\f\u0012\u0010\b\u0001\u0010%\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\f\u0012\u0010\b\u0001\u0010&\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\f\u0012\u0010\b\u0001\u0010'\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\f\u0012\u0010\b\u0001\u0010(\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\f\u0012\u0010\b\u0001\u0010)\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\f\u0012\u0010\b\u0001\u0010*\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\f\u0012\u0010\b\u0001\u0010+\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\f\u0012\u0010\b\u0001\u0010,\u001a\n\u0012\u0004\u0012\u00020-\u0018\u00010\f\u0012\u0010\b\u0001\u0010.\u001a\n\u0012\u0004\u0012\u00020/\u0018\u00010\f\u0012\u0010\b\u0001\u00100\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\f\u0012\u0010\b\u0001\u00101\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\f\u0012\u0010\b\u0001\u00102\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\f\u0012\u0015\b\u0001\u00103\u001a\u000f\u0012\t\u0012\u00070\u0006¢\u0006\u0002\b4\u0018\u00010\f\u0012\u0010\b\u0001\u00105\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\f\u0012\u0010\b\u0001\u00106\u001a\n\u0012\u0004\u0012\u000207\u0018\u00010\f\u0012\u0010\b\u0001\u00108\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\f\u0012\u0010\b\u0001\u00109\u001a\n\u0012\u0004\u0012\u00020:\u0018\u00010\f\u0012\u0015\b\u0001\u0010;\u001a\u000f\u0012\t\u0012\u00070<¢\u0006\u0002\b4\u0018\u00010\f\u0012\u0010\b\u0001\u0010=\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\f\u0012\u0010\b\u0001\u0010>\u001a\n\u0012\u0004\u0012\u00020?\u0018\u00010\f\u0012\u0010\b\u0001\u0010@\u001a\n\u0012\u0004\u0012\u00020A\u0018\u00010\f\u0012\u0010\b\u0001\u0010B\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f\u0012\u0010\b\u0001\u0010C\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f\u0012\b\u0010D\u001a\u0004\u0018\u00010E¢\u0006\u0002\u0010FB \u0012\u0019\b\u0002\u0010G\u001a\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020I0H¢\u0006\u0002\bJ¢\u0006\u0002\u0010KJ\u0010\u0010q\u001a\u00020r2\u0006\u0010s\u001a\u00020tH\u0016J!\u0010u\u001a\u00020I2\u0006\u0010v\u001a\u00020\u00002\u0006\u0010w\u001a\u00020x2\u0006\u0010y\u001a\u00020zHÇ\u0001R'\u0010G\u001a\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020I0H¢\u0006\u0002\bJ8\u0002X\u0004¢\u0006\b\n\u0000\u0012\u0004\bL\u0010MR,\u0010@\u001a\n\u0012\u0004\u0012\u00020A\u0018\u00010\f8\u0006@\u0006X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bN\u0010M\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010RR,\u0010=\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\f8\u0006@\u0006X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bS\u0010M\u001a\u0004\bT\u0010P\"\u0004\bU\u0010RR,\u0010>\u001a\n\u0012\u0004\u0012\u00020?\u0018\u00010\f8\u0006@\u0006X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bV\u0010M\u001a\u0004\bW\u0010P\"\u0004\bX\u0010RR,\u0010B\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f8\u0006@\u0006X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bY\u0010M\u001a\u0004\bZ\u0010P\"\u0004\b[\u0010RR,\u0010C\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f8\u0006@\u0006X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\\\u0010M\u001a\u0004\b]\u0010P\"\u0004\b^\u0010RR,\u00105\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\f8\u0006@\u0006X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b_\u0010M\u001a\u0004\b`\u0010P\"\u0004\ba\u0010RR1\u00103\u001a\u000f\u0012\t\u0012\u00070\u0006¢\u0006\u0002\b4\u0018\u00010\f8\u0006@\u0006X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bb\u0010M\u001a\u0004\bc\u0010P\"\u0004\bd\u0010RR,\u00106\u001a\n\u0012\u0004\u0012\u000207\u0018\u00010\f8\u0006@\u0006X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\be\u0010M\u001a\u0004\bf\u0010P\"\u0004\bg\u0010RR,\u00108\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\f8\u0006@\u0006X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bh\u0010M\u001a\u0004\bi\u0010P\"\u0004\bj\u0010RR,\u00109\u001a\n\u0012\u0004\u0012\u00020:\u0018\u00010\f8\u0006@\u0006X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bk\u0010M\u001a\u0004\bl\u0010P\"\u0004\bm\u0010RR1\u0010;\u001a\u000f\u0012\t\u0012\u00070<¢\u0006\u0002\b4\u0018\u00010\f8\u0006@\u0006X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bn\u0010M\u001a\u0004\bo\u0010P\"\u0004\bp\u0010R¨\u0006}å\b\u0005å\b\u0007å\b\bå\b\u000bå\b\u000eå\b\u000få\b\u0011å\b\u0012å\b\u0013å\b\u0016å\b\u0018å\b\u001aå\b\u001cå\b\u001då\b\u001eå\b\u001få\b å\b!å\b\"å\b#å\b$å\b%å\b&å\b'å\b(å\b)å\b*å\b+å\b,å\b.å\b0å\b1å\b2å\b3å\b5å\b6å\b8å\b9å\b;å\b=å\b>å\b@å\bBå\bC"}, d2 = {"Lcom/deliveryhero/fluid/widgets/text/TextModelBuilder;", "Lcom/deliveryhero/fluid/widgets/WidgetModelBuilder;", "seen1", "", "seen2", "id", "", "hash", "placeholders", "", "Lcom/deliveryhero/fluid/expression/placeholder/PlaceholderSurrogate;", "width", "Lcom/deliveryhero/fluid/expression/ExpressionBuilder;", "Lcom/deliveryhero/fluid/values/Size;", "height", "isVisible", "", "expansionResistancePriority", "compressionResistancePriority", "backgroundColors", "", "Lcom/deliveryhero/fluid/values/Color;", "backgroundShape", "Lcom/deliveryhero/fluid/values/Shape;", "backgroundLinearGradientOrientation", "Lcom/deliveryhero/fluid/values/LinearGradientOrientation;", "backgroundCornerRadiusTopLeft", "Lcom/deliveryhero/fluid/values/LogicalPixel;", "backgroundCornerRadiusTopRight", "backgroundCornerRadiusBottomRight", "backgroundCornerRadiusBottomLeft", "backgroundRadius", "borderWidth", "borderColor", "elevation", "clipToBounds", "paddingLeading", "paddingTop", "paddingTrailing", "paddingBottom", "marginLeading", "marginTop", "marginTrailing", "marginBottom", "horizontalAlignment", "Lcom/deliveryhero/fluid/widgets/containers/HorizontalAlignment;", "verticalAlignment", "Lcom/deliveryhero/fluid/widgets/containers/VerticalAlignment;", "accessibilityId", "accessibilityLabel", "onClick", "richText", "Lkotlinx/serialization/Contextual;", "plainText", "textAlignment", "Lcom/deliveryhero/fluid/widgets/text/TextAlignment;", "textColor", "textSize", "Lcom/deliveryhero/fluid/values/ScalableLogicalPixel;", "textStyle", "Lcom/deliveryhero/fluid/widgets/text/TextStyle;", "lineSpacingExtra", "lineSpacingMultiplier", "", "lineBreakMode", "Lcom/deliveryhero/fluid/widgets/text/LineBreakMode;", "maxLines", "minLines", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IILjava/lang/String;Ljava/lang/String;Ljava/util/Set;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Ljava/util/List;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "init", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function1;)V", "getInit$annotations", "()V", "getLineBreakMode$annotations", "getLineBreakMode", "()Lcom/deliveryhero/fluid/expression/ExpressionBuilder;", "setLineBreakMode", "(Lcom/deliveryhero/fluid/expression/ExpressionBuilder;)V", "getLineSpacingExtra$annotations", "getLineSpacingExtra", "setLineSpacingExtra", "getLineSpacingMultiplier$annotations", "getLineSpacingMultiplier", "setLineSpacingMultiplier", "getMaxLines$annotations", "getMaxLines", "setMaxLines", "getMinLines$annotations", "getMinLines", "setMinLines", "getPlainText$annotations", "getPlainText", "setPlainText", "getRichText$annotations", "getRichText", "setRichText", "getTextAlignment$annotations", "getTextAlignment", "setTextAlignment", "getTextColor$annotations", "getTextColor", "setTextColor", "getTextSize$annotations", "getTextSize", "setTextSize", "getTextStyle$annotations", "getTextStyle", "setTextStyle", "build", "Lcom/deliveryhero/fluid/widgets/text/TextModel;", "args", "Lcom/deliveryhero/fluid/expression/ExpressionBuilder$Args;", "write$Self", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "$serializer", "Companion", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Serializable
@CoreContract.CreatedOn(version = CoreContract.Version.V1)
@SerialName("text")
public class TextModelBuilder extends WidgetModelBuilder {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private final Function1<TextModelBuilder, Unit> init;
    @Nullable
    private ExpressionBuilder<LineBreakMode> lineBreakMode;
    @Nullable
    private ExpressionBuilder<LogicalPixel> lineSpacingExtra;
    @Nullable
    private ExpressionBuilder<Float> lineSpacingMultiplier;
    @Nullable
    private ExpressionBuilder<Integer> maxLines;
    @Nullable
    private ExpressionBuilder<Integer> minLines;
    @Nullable
    private ExpressionBuilder<String> plainText;
    @Nullable
    private ExpressionBuilder<String> richText;
    @Nullable
    private ExpressionBuilder<TextAlignment> textAlignment;
    @Nullable
    private ExpressionBuilder<Color> textColor;
    @Nullable
    private ExpressionBuilder<ScalableLogicalPixel> textSize;
    @Nullable
    private ExpressionBuilder<TextStyle> textStyle;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/deliveryhero/fluid/widgets/text/TextModelBuilder$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/deliveryhero/fluid/widgets/text/TextModelBuilder;", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final KSerializer<TextModelBuilder> serializer() {
            return TextModelBuilder$$serializer.INSTANCE;
        }
    }

    public TextModelBuilder() {
        this((Function1) null, 1, (DefaultConstructorMarker) null);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @kotlin.ReplaceWith(expression = "", imports = {}))
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ TextModelBuilder(int r38, int r39, @com.deliveryhero.fluid.versioning.CoreContract.CreatedOn(version = com.deliveryhero.fluid.versioning.CoreContract.Version.V1) @kotlin.Deprecated(message = "Move when versioning is supported") @kotlinx.serialization.SerialName("id") java.lang.String r40, @com.deliveryhero.fluid.versioning.CoreContract.CreatedOn(version = com.deliveryhero.fluid.versioning.CoreContract.Version.V1) @kotlin.Deprecated(message = "Move when versioning is supported") @kotlinx.serialization.SerialName("hash") java.lang.String r41, @com.deliveryhero.fluid.versioning.CoreContract.CreatedOn(version = com.deliveryhero.fluid.versioning.CoreContract.Version.V1) @kotlin.Deprecated(message = "Move when versioning is supported") @kotlinx.serialization.SerialName("placeholders") java.util.Set r42, @com.deliveryhero.fluid.versioning.CoreContract.CreatedOn(version = com.deliveryhero.fluid.versioning.CoreContract.Version.V1) @kotlinx.serialization.SerialName("width") com.deliveryhero.fluid.expression.ExpressionBuilder r43, @com.deliveryhero.fluid.versioning.CoreContract.CreatedOn(version = com.deliveryhero.fluid.versioning.CoreContract.Version.V1) @kotlinx.serialization.SerialName("height") com.deliveryhero.fluid.expression.ExpressionBuilder r44, @com.deliveryhero.fluid.versioning.CoreContract.CreatedOn(version = com.deliveryhero.fluid.versioning.CoreContract.Version.V1) @kotlinx.serialization.SerialName("is_visible") com.deliveryhero.fluid.expression.ExpressionBuilder r45, @com.deliveryhero.fluid.versioning.CoreContract.CreatedOn(version = com.deliveryhero.fluid.versioning.CoreContract.Version.V1) @kotlinx.serialization.SerialName("expansion_resistance_priority") com.deliveryhero.fluid.expression.ExpressionBuilder r46, @com.deliveryhero.fluid.versioning.CoreContract.CreatedOn(version = com.deliveryhero.fluid.versioning.CoreContract.Version.V1) @kotlinx.serialization.SerialName("compression_resistance_priority") com.deliveryhero.fluid.expression.ExpressionBuilder r47, @com.deliveryhero.fluid.versioning.CoreContract.CreatedOn(version = com.deliveryhero.fluid.versioning.CoreContract.Version.V1) @kotlinx.serialization.SerialName("background_colors") java.util.List r48, @com.deliveryhero.fluid.versioning.CoreContract.CreatedOn(version = com.deliveryhero.fluid.versioning.CoreContract.Version.V1) @kotlinx.serialization.SerialName("background_shape") com.deliveryhero.fluid.expression.ExpressionBuilder r49, @com.deliveryhero.fluid.versioning.CoreContract.CreatedOn(version = com.deliveryhero.fluid.versioning.CoreContract.Version.V1) @kotlinx.serialization.SerialName("background_gradient_orientation") com.deliveryhero.fluid.expression.ExpressionBuilder r50, @com.deliveryhero.fluid.versioning.CoreContract.CreatedOn(version = com.deliveryhero.fluid.versioning.CoreContract.Version.V1) @kotlinx.serialization.SerialName("background_radius_top_left") com.deliveryhero.fluid.expression.ExpressionBuilder r51, @com.deliveryhero.fluid.versioning.CoreContract.CreatedOn(version = com.deliveryhero.fluid.versioning.CoreContract.Version.V1) @kotlinx.serialization.SerialName("background_radius_top_right") com.deliveryhero.fluid.expression.ExpressionBuilder r52, @com.deliveryhero.fluid.versioning.CoreContract.CreatedOn(version = com.deliveryhero.fluid.versioning.CoreContract.Version.V1) @kotlinx.serialization.SerialName("background_radius_bottom_right") com.deliveryhero.fluid.expression.ExpressionBuilder r53, @com.deliveryhero.fluid.versioning.CoreContract.CreatedOn(version = com.deliveryhero.fluid.versioning.CoreContract.Version.V1) @kotlinx.serialization.SerialName("background_radius_bottom_left") com.deliveryhero.fluid.expression.ExpressionBuilder r54, @com.deliveryhero.fluid.versioning.CoreContract.CreatedOn(version = com.deliveryhero.fluid.versioning.CoreContract.Version.V1) @kotlin.Deprecated(message = "Use backgroundCornerRadiusAll or corner specific background radii instead") @com.deliveryhero.fluid.versioning.CoreContract.DeprecatedOn(version = com.deliveryhero.fluid.versioning.CoreContract.Version.V2) @kotlinx.serialization.SerialName("background_radius") com.deliveryhero.fluid.expression.ExpressionBuilder r55, @com.deliveryhero.fluid.versioning.CoreContract.CreatedOn(version = com.deliveryhero.fluid.versioning.CoreContract.Version.V1) @kotlinx.serialization.SerialName("border_width") com.deliveryhero.fluid.expression.ExpressionBuilder r56, @com.deliveryhero.fluid.versioning.CoreContract.CreatedOn(version = com.deliveryhero.fluid.versioning.CoreContract.Version.V1) @kotlinx.serialization.SerialName("border_color") com.deliveryhero.fluid.expression.ExpressionBuilder r57, @com.deliveryhero.fluid.versioning.CoreContract.CreatedOn(version = com.deliveryhero.fluid.versioning.CoreContract.Version.V1) @kotlinx.serialization.SerialName("elevation") com.deliveryhero.fluid.expression.ExpressionBuilder r58, @com.deliveryhero.fluid.versioning.CoreContract.CreatedOn(version = com.deliveryhero.fluid.versioning.CoreContract.Version.V1) @kotlinx.serialization.SerialName("clip_to_bounds") com.deliveryhero.fluid.expression.ExpressionBuilder r59, @com.deliveryhero.fluid.versioning.CoreContract.CreatedOn(version = com.deliveryhero.fluid.versioning.CoreContract.Version.V1) @kotlinx.serialization.SerialName("padding_leading") com.deliveryhero.fluid.expression.ExpressionBuilder r60, @com.deliveryhero.fluid.versioning.CoreContract.CreatedOn(version = com.deliveryhero.fluid.versioning.CoreContract.Version.V1) @kotlinx.serialization.SerialName("padding_top") com.deliveryhero.fluid.expression.ExpressionBuilder r61, @com.deliveryhero.fluid.versioning.CoreContract.CreatedOn(version = com.deliveryhero.fluid.versioning.CoreContract.Version.V1) @kotlinx.serialization.SerialName("padding_trailing") com.deliveryhero.fluid.expression.ExpressionBuilder r62, @com.deliveryhero.fluid.versioning.CoreContract.CreatedOn(version = com.deliveryhero.fluid.versioning.CoreContract.Version.V1) @kotlinx.serialization.SerialName("padding_bottom") com.deliveryhero.fluid.expression.ExpressionBuilder r63, @com.deliveryhero.fluid.versioning.CoreContract.CreatedOn(version = com.deliveryhero.fluid.versioning.CoreContract.Version.V1) @kotlinx.serialization.SerialName("margin_leading") com.deliveryhero.fluid.expression.ExpressionBuilder r64, @com.deliveryhero.fluid.versioning.CoreContract.CreatedOn(version = com.deliveryhero.fluid.versioning.CoreContract.Version.V1) @kotlinx.serialization.SerialName("margin_top") com.deliveryhero.fluid.expression.ExpressionBuilder r65, @com.deliveryhero.fluid.versioning.CoreContract.CreatedOn(version = com.deliveryhero.fluid.versioning.CoreContract.Version.V1) @kotlinx.serialization.SerialName("margin_trailing") com.deliveryhero.fluid.expression.ExpressionBuilder r66, @com.deliveryhero.fluid.versioning.CoreContract.CreatedOn(version = com.deliveryhero.fluid.versioning.CoreContract.Version.V1) @kotlinx.serialization.SerialName("margin_bottom") com.deliveryhero.fluid.expression.ExpressionBuilder r67, @com.deliveryhero.fluid.versioning.CoreContract.CreatedOn(version = com.deliveryhero.fluid.versioning.CoreContract.Version.V1) @kotlinx.serialization.SerialName("horizontal_alignment") com.deliveryhero.fluid.expression.ExpressionBuilder r68, @com.deliveryhero.fluid.versioning.CoreContract.CreatedOn(version = com.deliveryhero.fluid.versioning.CoreContract.Version.V1) @kotlinx.serialization.SerialName("vertical_alignment") com.deliveryhero.fluid.expression.ExpressionBuilder r69, @com.deliveryhero.fluid.versioning.CoreContract.CreatedOn(version = com.deliveryhero.fluid.versioning.CoreContract.Version.V1) @kotlinx.serialization.SerialName("accessibility_tag") com.deliveryhero.fluid.expression.ExpressionBuilder r70, @com.deliveryhero.fluid.versioning.CoreContract.CreatedOn(version = com.deliveryhero.fluid.versioning.CoreContract.Version.V1) @kotlinx.serialization.SerialName("accessibility_label") com.deliveryhero.fluid.expression.ExpressionBuilder r71, @com.deliveryhero.fluid.versioning.CoreContract.CreatedOn(version = com.deliveryhero.fluid.versioning.CoreContract.Version.V1) @kotlinx.serialization.SerialName("on_click") com.deliveryhero.fluid.expression.ExpressionBuilder r72, @com.deliveryhero.fluid.versioning.CoreContract.CreatedOn(version = com.deliveryhero.fluid.versioning.CoreContract.Version.V1) @kotlinx.serialization.SerialName("rich_text") com.deliveryhero.fluid.expression.ExpressionBuilder r73, @com.deliveryhero.fluid.versioning.CoreContract.CreatedOn(version = com.deliveryhero.fluid.versioning.CoreContract.Version.V1) @kotlinx.serialization.SerialName("text") com.deliveryhero.fluid.expression.ExpressionBuilder r74, @com.deliveryhero.fluid.versioning.CoreContract.CreatedOn(version = com.deliveryhero.fluid.versioning.CoreContract.Version.V1) @kotlinx.serialization.SerialName("text_alignment") com.deliveryhero.fluid.expression.ExpressionBuilder r75, @com.deliveryhero.fluid.versioning.CoreContract.CreatedOn(version = com.deliveryhero.fluid.versioning.CoreContract.Version.V1) @kotlinx.serialization.SerialName("text_color") com.deliveryhero.fluid.expression.ExpressionBuilder r76, @com.deliveryhero.fluid.versioning.CoreContract.CreatedOn(version = com.deliveryhero.fluid.versioning.CoreContract.Version.V1) @kotlinx.serialization.SerialName("text_size") com.deliveryhero.fluid.expression.ExpressionBuilder r77, @com.deliveryhero.fluid.versioning.CoreContract.CreatedOn(version = com.deliveryhero.fluid.versioning.CoreContract.Version.V1) @kotlinx.serialization.SerialName("text_style") com.deliveryhero.fluid.expression.ExpressionBuilder r78, @com.deliveryhero.fluid.versioning.CoreContract.CreatedOn(version = com.deliveryhero.fluid.versioning.CoreContract.Version.V1) @kotlinx.serialization.SerialName("line_spacing_extra") com.deliveryhero.fluid.expression.ExpressionBuilder r79, @com.deliveryhero.fluid.versioning.CoreContract.CreatedOn(version = com.deliveryhero.fluid.versioning.CoreContract.Version.V1) @kotlinx.serialization.SerialName("line_spacing_multiplier") com.deliveryhero.fluid.expression.ExpressionBuilder r80, @com.deliveryhero.fluid.versioning.CoreContract.CreatedOn(version = com.deliveryhero.fluid.versioning.CoreContract.Version.V1) @kotlinx.serialization.SerialName("line_break_mode") com.deliveryhero.fluid.expression.ExpressionBuilder r81, @com.deliveryhero.fluid.versioning.CoreContract.CreatedOn(version = com.deliveryhero.fluid.versioning.CoreContract.Version.V1) @kotlinx.serialization.SerialName("max_lines") com.deliveryhero.fluid.expression.ExpressionBuilder r82, @com.deliveryhero.fluid.versioning.CoreContract.CreatedOn(version = com.deliveryhero.fluid.versioning.CoreContract.Version.V1) @kotlinx.serialization.SerialName("min_lines") com.deliveryhero.fluid.expression.ExpressionBuilder r83, kotlinx.serialization.internal.SerializationConstructorMarker r84) {
        /*
            r37 = this;
            r15 = r37
            r14 = r39
            r0 = r38 & 0
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x000c
            r0 = r1
            goto L_0x000d
        L_0x000c:
            r0 = r2
        L_0x000d:
            r3 = r14 & 0
            if (r3 == 0) goto L_0x0013
            r3 = r1
            goto L_0x0014
        L_0x0013:
            r3 = r2
        L_0x0014:
            r0 = r0 | r3
            if (r0 == 0) goto L_0x002c
            r0 = 2
            int[] r3 = new int[r0]
            r3[r2] = r38
            r3[r1] = r14
            int[] r0 = new int[r0]
            r0 = {0, 0} // fill-array
            com.deliveryhero.fluid.widgets.text.TextModelBuilder$$serializer r1 = com.deliveryhero.fluid.widgets.text.TextModelBuilder$$serializer.INSTANCE
            kotlinx.serialization.descriptors.SerialDescriptor r1 = r1.getDescriptor()
            kotlinx.serialization.internal.PluginExceptionsKt.throwArrayMissingFieldException(r3, r0, r1)
        L_0x002c:
            r0 = r37
            r1 = r38
            r2 = r39
            r3 = r40
            r4 = r41
            r5 = r42
            r6 = r43
            r7 = r44
            r8 = r45
            r9 = r46
            r10 = r47
            r11 = r48
            r12 = r49
            r13 = r50
            r14 = r51
            r15 = r52
            r16 = r53
            r17 = r54
            r18 = r55
            r19 = r56
            r20 = r57
            r21 = r58
            r22 = r59
            r23 = r60
            r24 = r61
            r25 = r62
            r26 = r63
            r27 = r64
            r28 = r65
            r29 = r66
            r30 = r67
            r31 = r68
            r32 = r69
            r33 = r70
            r34 = r71
            r35 = r72
            r36 = r84
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36)
            com.deliveryhero.fluid.widgets.text.TextModelBuilder$2 r0 = com.deliveryhero.fluid.widgets.text.TextModelBuilder.AnonymousClass2.INSTANCE
            r1 = r37
            r1.init = r0
            r3 = r2 & 2
            r4 = 0
            if (r3 != 0) goto L_0x0087
            r1.richText = r4
            goto L_0x008b
        L_0x0087:
            r3 = r73
            r1.richText = r3
        L_0x008b:
            r3 = r2 & 4
            if (r3 != 0) goto L_0x0092
            r1.plainText = r4
            goto L_0x0096
        L_0x0092:
            r3 = r74
            r1.plainText = r3
        L_0x0096:
            r3 = r2 & 8
            if (r3 != 0) goto L_0x009d
            r1.textAlignment = r4
            goto L_0x00a1
        L_0x009d:
            r3 = r75
            r1.textAlignment = r3
        L_0x00a1:
            r3 = r2 & 16
            if (r3 != 0) goto L_0x00a8
            r1.textColor = r4
            goto L_0x00ac
        L_0x00a8:
            r3 = r76
            r1.textColor = r3
        L_0x00ac:
            r3 = r2 & 32
            if (r3 != 0) goto L_0x00b3
            r1.textSize = r4
            goto L_0x00b7
        L_0x00b3:
            r3 = r77
            r1.textSize = r3
        L_0x00b7:
            r3 = r2 & 64
            if (r3 != 0) goto L_0x00be
            r1.textStyle = r4
            goto L_0x00c2
        L_0x00be:
            r3 = r78
            r1.textStyle = r3
        L_0x00c2:
            r3 = r2 & 128(0x80, float:1.794E-43)
            if (r3 != 0) goto L_0x00c9
            r1.lineSpacingExtra = r4
            goto L_0x00cd
        L_0x00c9:
            r3 = r79
            r1.lineSpacingExtra = r3
        L_0x00cd:
            r3 = r2 & 256(0x100, float:3.59E-43)
            if (r3 != 0) goto L_0x00d4
            r1.lineSpacingMultiplier = r4
            goto L_0x00d8
        L_0x00d4:
            r3 = r80
            r1.lineSpacingMultiplier = r3
        L_0x00d8:
            r3 = r2 & 512(0x200, float:7.175E-43)
            if (r3 != 0) goto L_0x00df
            r1.lineBreakMode = r4
            goto L_0x00e3
        L_0x00df:
            r3 = r81
            r1.lineBreakMode = r3
        L_0x00e3:
            r3 = r2 & 1024(0x400, float:1.435E-42)
            if (r3 != 0) goto L_0x00ea
            r1.maxLines = r4
            goto L_0x00ee
        L_0x00ea:
            r3 = r82
            r1.maxLines = r3
        L_0x00ee:
            r2 = r2 & 2048(0x800, float:2.87E-42)
            if (r2 != 0) goto L_0x00f5
            r1.minLines = r4
            goto L_0x00f9
        L_0x00f5:
            r2 = r83
            r1.minLines = r2
        L_0x00f9:
            r0.invoke(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.deliveryhero.fluid.widgets.text.TextModelBuilder.<init>(int, int, java.lang.String, java.lang.String, java.util.Set, com.deliveryhero.fluid.expression.ExpressionBuilder, com.deliveryhero.fluid.expression.ExpressionBuilder, com.deliveryhero.fluid.expression.ExpressionBuilder, com.deliveryhero.fluid.expression.ExpressionBuilder, com.deliveryhero.fluid.expression.ExpressionBuilder, java.util.List, com.deliveryhero.fluid.expression.ExpressionBuilder, com.deliveryhero.fluid.expression.ExpressionBuilder, com.deliveryhero.fluid.expression.ExpressionBuilder, com.deliveryhero.fluid.expression.ExpressionBuilder, com.deliveryhero.fluid.expression.ExpressionBuilder, com.deliveryhero.fluid.expression.ExpressionBuilder, com.deliveryhero.fluid.expression.ExpressionBuilder, com.deliveryhero.fluid.expression.ExpressionBuilder, com.deliveryhero.fluid.expression.ExpressionBuilder, com.deliveryhero.fluid.expression.ExpressionBuilder, com.deliveryhero.fluid.expression.ExpressionBuilder, com.deliveryhero.fluid.expression.ExpressionBuilder, com.deliveryhero.fluid.expression.ExpressionBuilder, com.deliveryhero.fluid.expression.ExpressionBuilder, com.deliveryhero.fluid.expression.ExpressionBuilder, com.deliveryhero.fluid.expression.ExpressionBuilder, com.deliveryhero.fluid.expression.ExpressionBuilder, com.deliveryhero.fluid.expression.ExpressionBuilder, com.deliveryhero.fluid.expression.ExpressionBuilder, com.deliveryhero.fluid.expression.ExpressionBuilder, com.deliveryhero.fluid.expression.ExpressionBuilder, com.deliveryhero.fluid.expression.ExpressionBuilder, com.deliveryhero.fluid.expression.ExpressionBuilder, com.deliveryhero.fluid.expression.ExpressionBuilder, com.deliveryhero.fluid.expression.ExpressionBuilder, com.deliveryhero.fluid.expression.ExpressionBuilder, com.deliveryhero.fluid.expression.ExpressionBuilder, com.deliveryhero.fluid.expression.ExpressionBuilder, com.deliveryhero.fluid.expression.ExpressionBuilder, com.deliveryhero.fluid.expression.ExpressionBuilder, com.deliveryhero.fluid.expression.ExpressionBuilder, com.deliveryhero.fluid.expression.ExpressionBuilder, com.deliveryhero.fluid.expression.ExpressionBuilder, com.deliveryhero.fluid.expression.ExpressionBuilder, com.deliveryhero.fluid.expression.ExpressionBuilder, kotlinx.serialization.internal.SerializationConstructorMarker):void");
    }

    @Transient
    private static /* synthetic */ void getInit$annotations() {
    }

    @CoreContract.CreatedOn(version = CoreContract.Version.V1)
    @SerialName("line_break_mode")
    public static /* synthetic */ void getLineBreakMode$annotations() {
    }

    @CoreContract.CreatedOn(version = CoreContract.Version.V1)
    @SerialName("line_spacing_extra")
    public static /* synthetic */ void getLineSpacingExtra$annotations() {
    }

    @CoreContract.CreatedOn(version = CoreContract.Version.V1)
    @SerialName("line_spacing_multiplier")
    public static /* synthetic */ void getLineSpacingMultiplier$annotations() {
    }

    @CoreContract.CreatedOn(version = CoreContract.Version.V1)
    @SerialName("max_lines")
    public static /* synthetic */ void getMaxLines$annotations() {
    }

    @CoreContract.CreatedOn(version = CoreContract.Version.V1)
    @SerialName("min_lines")
    public static /* synthetic */ void getMinLines$annotations() {
    }

    @CoreContract.CreatedOn(version = CoreContract.Version.V1)
    @SerialName("text")
    public static /* synthetic */ void getPlainText$annotations() {
    }

    @CoreContract.CreatedOn(version = CoreContract.Version.V1)
    @SerialName("rich_text")
    public static /* synthetic */ void getRichText$annotations() {
    }

    @CoreContract.CreatedOn(version = CoreContract.Version.V1)
    @SerialName("text_alignment")
    public static /* synthetic */ void getTextAlignment$annotations() {
    }

    @CoreContract.CreatedOn(version = CoreContract.Version.V1)
    @SerialName("text_color")
    public static /* synthetic */ void getTextColor$annotations() {
    }

    @CoreContract.CreatedOn(version = CoreContract.Version.V1)
    @SerialName("text_size")
    public static /* synthetic */ void getTextSize$annotations() {
    }

    @CoreContract.CreatedOn(version = CoreContract.Version.V1)
    @SerialName("text_style")
    public static /* synthetic */ void getTextStyle$annotations() {
    }

    @JvmStatic
    public static final void write$Self(@NotNull TextModelBuilder textModelBuilder, @NotNull CompositeEncoder compositeEncoder, @NotNull SerialDescriptor serialDescriptor) {
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        boolean z15;
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        boolean z21;
        Intrinsics.checkNotNullParameter(textModelBuilder, "self");
        Intrinsics.checkNotNullParameter(compositeEncoder, "output");
        Intrinsics.checkNotNullParameter(serialDescriptor, "serialDesc");
        WidgetModelBuilder.write$Self(textModelBuilder, compositeEncoder, serialDescriptor);
        boolean z22 = false;
        if (!compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 33) && textModelBuilder.richText == null) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (z11) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 33, new ExpressionBuilderSerializer(new ContextualSerializer(Reflection.getOrCreateKotlinClass(String.class), StringSerializer.INSTANCE, new KSerializer[0])), textModelBuilder.richText);
        }
        if (!compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 34) && textModelBuilder.plainText == null) {
            z12 = false;
        } else {
            z12 = true;
        }
        if (z12) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 34, new ExpressionBuilderSerializer(StringSerializer.INSTANCE), textModelBuilder.plainText);
        }
        if (!compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 35) && textModelBuilder.textAlignment == null) {
            z13 = false;
        } else {
            z13 = true;
        }
        if (z13) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 35, new ExpressionBuilderSerializer(new EnumSerializer("com.deliveryhero.fluid.widgets.text.TextAlignment", TextAlignment.values())), textModelBuilder.textAlignment);
        }
        if (!compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 36) && textModelBuilder.textColor == null) {
            z14 = false;
        } else {
            z14 = true;
        }
        if (z14) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 36, new ExpressionBuilderSerializer(Color$$serializer.INSTANCE), textModelBuilder.textColor);
        }
        if (!compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 37) && textModelBuilder.textSize == null) {
            z15 = false;
        } else {
            z15 = true;
        }
        if (z15) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 37, new ExpressionBuilderSerializer(ScalableLogicalPixel$$serializer.INSTANCE), textModelBuilder.textSize);
        }
        if (!compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 38) && textModelBuilder.textStyle == null) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            Class<TextStyle> cls = TextStyle.class;
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 38, new ExpressionBuilderSerializer(new ContextualSerializer(Reflection.getOrCreateKotlinClass(cls), new PolymorphicSerializer(Reflection.getOrCreateKotlinClass(cls), new Annotation[0]), new KSerializer[0])), textModelBuilder.textStyle);
        }
        if (!compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 39) && textModelBuilder.lineSpacingExtra == null) {
            z17 = false;
        } else {
            z17 = true;
        }
        if (z17) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 39, new ExpressionBuilderSerializer(LogicalPixel$$serializer.INSTANCE), textModelBuilder.lineSpacingExtra);
        }
        if (!compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 40) && textModelBuilder.lineSpacingMultiplier == null) {
            z18 = false;
        } else {
            z18 = true;
        }
        if (z18) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 40, new ExpressionBuilderSerializer(FloatSerializer.INSTANCE), textModelBuilder.lineSpacingMultiplier);
        }
        if (!compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 41) && textModelBuilder.lineBreakMode == null) {
            z19 = false;
        } else {
            z19 = true;
        }
        if (z19) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 41, new ExpressionBuilderSerializer(new EnumSerializer("com.deliveryhero.fluid.widgets.text.LineBreakMode", LineBreakMode.values())), textModelBuilder.lineBreakMode);
        }
        if (!compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 42) && textModelBuilder.maxLines == null) {
            z21 = false;
        } else {
            z21 = true;
        }
        if (z21) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 42, new ExpressionBuilderSerializer(IntSerializer.INSTANCE), textModelBuilder.maxLines);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 43) || textModelBuilder.minLines != null) {
            z22 = true;
        }
        if (z22) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 43, new ExpressionBuilderSerializer(IntSerializer.INSTANCE), textModelBuilder.minLines);
        }
    }

    @Nullable
    public final ExpressionBuilder<LineBreakMode> getLineBreakMode() {
        return this.lineBreakMode;
    }

    @Nullable
    public final ExpressionBuilder<LogicalPixel> getLineSpacingExtra() {
        return this.lineSpacingExtra;
    }

    @Nullable
    public final ExpressionBuilder<Float> getLineSpacingMultiplier() {
        return this.lineSpacingMultiplier;
    }

    @Nullable
    public final ExpressionBuilder<Integer> getMaxLines() {
        return this.maxLines;
    }

    @Nullable
    public final ExpressionBuilder<Integer> getMinLines() {
        return this.minLines;
    }

    @Nullable
    public final ExpressionBuilder<String> getPlainText() {
        return this.plainText;
    }

    @Nullable
    public final ExpressionBuilder<String> getRichText() {
        return this.richText;
    }

    @Nullable
    public final ExpressionBuilder<TextAlignment> getTextAlignment() {
        return this.textAlignment;
    }

    @Nullable
    public final ExpressionBuilder<Color> getTextColor() {
        return this.textColor;
    }

    @Nullable
    public final ExpressionBuilder<ScalableLogicalPixel> getTextSize() {
        return this.textSize;
    }

    @Nullable
    public final ExpressionBuilder<TextStyle> getTextStyle() {
        return this.textStyle;
    }

    public final void setLineBreakMode(@Nullable ExpressionBuilder<LineBreakMode> expressionBuilder) {
        this.lineBreakMode = expressionBuilder;
    }

    public final void setLineSpacingExtra(@Nullable ExpressionBuilder<LogicalPixel> expressionBuilder) {
        this.lineSpacingExtra = expressionBuilder;
    }

    public final void setLineSpacingMultiplier(@Nullable ExpressionBuilder<Float> expressionBuilder) {
        this.lineSpacingMultiplier = expressionBuilder;
    }

    public final void setMaxLines(@Nullable ExpressionBuilder<Integer> expressionBuilder) {
        this.maxLines = expressionBuilder;
    }

    public final void setMinLines(@Nullable ExpressionBuilder<Integer> expressionBuilder) {
        this.minLines = expressionBuilder;
    }

    public final void setPlainText(@Nullable ExpressionBuilder<String> expressionBuilder) {
        this.plainText = expressionBuilder;
    }

    public final void setRichText(@Nullable ExpressionBuilder<String> expressionBuilder) {
        this.richText = expressionBuilder;
    }

    public final void setTextAlignment(@Nullable ExpressionBuilder<TextAlignment> expressionBuilder) {
        this.textAlignment = expressionBuilder;
    }

    public final void setTextColor(@Nullable ExpressionBuilder<Color> expressionBuilder) {
        this.textColor = expressionBuilder;
    }

    public final void setTextSize(@Nullable ExpressionBuilder<ScalableLogicalPixel> expressionBuilder) {
        this.textSize = expressionBuilder;
    }

    public final void setTextStyle(@Nullable ExpressionBuilder<TextStyle> expressionBuilder) {
        this.textStyle = expressionBuilder;
    }

    @NotNull
    public TextModel build(@NotNull ExpressionBuilder.Args args) {
        ExpressionBuilder.Args args2 = args;
        Intrinsics.checkNotNullParameter(args2, StepData.ARGS);
        ExpressionBuilder<String> expressionBuilder = this.plainText;
        StringCodec stringCodec = StringCodec.INSTANCE;
        Class<String> cls = String.class;
        Expression<DecodedT> build = ExpressionBuilderUtilsKt.build(expressionBuilder, Reflection.getOrCreateKotlinClass(cls), stringCodec, args2);
        Expression<DecodedT> build2 = ExpressionBuilderUtilsKt.build(this.richText, Reflection.getOrCreateKotlinClass(cls), stringCodec, args2);
        Expression<DecodedT> build3 = ExpressionBuilderUtilsKt.build(this.textAlignment, Reflection.getOrCreateKotlinClass(TextAlignment.class), TextAlignmentCodec.INSTANCE, args2);
        Expression<DecodedT> build4 = ExpressionBuilderUtilsKt.build(this.textColor, Reflection.getOrCreateKotlinClass(Color.class), ColorCodec.INSTANCE, args2);
        Expression<DecodedT> build5 = ExpressionBuilderUtilsKt.build(this.textSize, Reflection.getOrCreateKotlinClass(ScalableLogicalPixel.class), ScalableLogicalPixelCodec.INSTANCE, args2);
        Expression<DecodedT> build6 = ExpressionBuilderUtilsKt.build(this.textStyle, Reflection.getOrCreateKotlinClass(TextStyle.class), TextStyleCodec.INSTANCE, args2);
        Expression<DecodedT> build7 = ExpressionBuilderUtilsKt.build(this.lineSpacingExtra, Reflection.getOrCreateKotlinClass(LogicalPixel.class), LogicalPixelCodec.INSTANCE, args2);
        Expression<DecodedT> build8 = ExpressionBuilderUtilsKt.build(this.lineSpacingMultiplier, Reflection.getOrCreateKotlinClass(Float.class), FloatCodec.INSTANCE, args2);
        Expression<DecodedT> build9 = ExpressionBuilderUtilsKt.build(this.lineBreakMode, Reflection.getOrCreateKotlinClass(LineBreakMode.class), LineBreakModeCodec.INSTANCE, args2);
        ExpressionBuilder<Integer> expressionBuilder2 = this.maxLines;
        IntegerCodec integerCodec = IntegerCodec.INSTANCE;
        Class<Integer> cls2 = Integer.class;
        return new TextModel(build, build2, build6, build4, build5, build3, build7, build8, ExpressionBuilderUtilsKt.build(expressionBuilder2, Reflection.getOrCreateKotlinClass(cls2), integerCodec, args2), ExpressionBuilderUtilsKt.build(this.minLines, Reflection.getOrCreateKotlinClass(cls2), integerCodec, args2), build9, a(args));
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TextModelBuilder(Function1 function1, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? AnonymousClass1.INSTANCE : function1);
    }

    public TextModelBuilder(@NotNull Function1<? super TextModelBuilder, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "init");
        this.init = function1;
        function1.invoke(this);
    }
}
