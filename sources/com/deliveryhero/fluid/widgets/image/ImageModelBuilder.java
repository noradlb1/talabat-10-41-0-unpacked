package com.deliveryhero.fluid.widgets.image;

import com.braze.ui.actions.brazeactions.steps.StepData;
import com.deliveryhero.fluid.expression.Expression;
import com.deliveryhero.fluid.expression.ExpressionBuilder;
import com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer;
import com.deliveryhero.fluid.expression.utils.ExpressionBuilderUtilsKt;
import com.deliveryhero.fluid.values.LogicalPixel;
import com.deliveryhero.fluid.values.LogicalPixel$$serializer;
import com.deliveryhero.fluid.values.Shape;
import com.deliveryhero.fluid.values.Shape$$serializer;
import com.deliveryhero.fluid.values.codecs.scalar.ImageContentModeCodec;
import com.deliveryhero.fluid.values.codecs.scalar.ImageLocatorCodec;
import com.deliveryhero.fluid.values.codecs.scalar.LocalImageLocatorCodec;
import com.deliveryhero.fluid.values.codecs.scalar.LogicalPixelCodec;
import com.deliveryhero.fluid.versioning.CoreContract;
import com.deliveryhero.fluid.widgets.WidgetModelBuilder;
import com.deliveryhero.fluid.widgets.image.ImageLocator;
import com.deliveryhero.fluid.widgets.utils.WidgetModelBuilderDelegates;
import java.lang.annotation.Annotation;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KMutableProperty0;
import kotlin.reflect.KProperty;
import kotlinx.serialization.ContextualSerializer;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.PolymorphicSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.Transient;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.EnumSerializer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000°\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b)\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0017\u0018\u0000 {2\u00020\u0001:\u0002z{B«\u0006\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0010\b\u0001\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\u0010\b\u0001\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f\u0012\u0010\b\u0001\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f\u0012\u0010\b\u0001\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\f\u0012\u0010\b\u0001\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f\u0012\u0010\b\u0001\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f\u0012\u0016\b\u0001\u0010\u0013\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\f\u0018\u00010\u0014\u0012\u0010\b\u0001\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\f\u0012\u0010\b\u0001\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\f\u0012\u0010\b\u0001\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\f\u0012\u0010\b\u0001\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\f\u0012\u0010\b\u0001\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\f\u0012\u0010\b\u0001\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\f\u0012\u0010\b\u0001\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\f\u0012\u0010\b\u0001\u0010 \u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\f\u0012\u0010\b\u0001\u0010!\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\f\u0012\u0010\b\u0001\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\f\u0012\u0010\b\u0001\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\f\u0012\u0010\b\u0001\u0010$\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\f\u0012\u0010\b\u0001\u0010%\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\f\u0012\u0010\b\u0001\u0010&\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\f\u0012\u0010\b\u0001\u0010'\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\f\u0012\u0010\b\u0001\u0010(\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\f\u0012\u0010\b\u0001\u0010)\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\f\u0012\u0010\b\u0001\u0010*\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\f\u0012\u0010\b\u0001\u0010+\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\f\u0012\u0010\b\u0001\u0010,\u001a\n\u0012\u0004\u0012\u00020-\u0018\u00010\f\u0012\u0010\b\u0001\u0010.\u001a\n\u0012\u0004\u0012\u00020/\u0018\u00010\f\u0012\u0010\b\u0001\u00100\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\f\u0012\u0010\b\u0001\u00101\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\f\u0012\u0010\b\u0001\u00102\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\f\u0012\u0010\b\u0001\u00103\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\f\u0012\u0010\b\u0001\u00104\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\f\u0012\u0010\b\u0001\u00105\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\f\u0012\u0010\b\u0001\u00106\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\f\u0012\u0010\b\u0001\u00107\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\f\u0012\u0010\b\u0001\u00108\u001a\n\u0012\u0004\u0012\u000209\u0018\u00010\f\u0012\u0010\b\u0001\u0010:\u001a\n\u0012\u0004\u0012\u00020;\u0018\u00010\f\u0012\u0015\b\u0001\u0010<\u001a\u000f\u0012\t\u0012\u00070=¢\u0006\u0002\b>\u0018\u00010\f\u0012\u0015\b\u0001\u0010?\u001a\u000f\u0012\t\u0012\u00070=¢\u0006\u0002\b>\u0018\u00010\f\u0012\u0010\b\u0001\u0010@\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\f\u0012\b\u0010A\u001a\u0004\u0018\u00010B¢\u0006\u0002\u0010CB \u0012\u0019\b\u0002\u0010D\u001a\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020F0E¢\u0006\u0002\bG¢\u0006\u0002\u0010HJ\u0010\u0010p\u001a\u00020q2\u0006\u0010r\u001a\u00020sH\u0016J!\u0010t\u001a\u00020F2\u0006\u0010u\u001a\u00020\u00002\u0006\u0010v\u001a\u00020w2\u0006\u0010x\u001a\u00020yHÇ\u0001R,\u00108\u001a\n\u0012\u0004\u0012\u000209\u0018\u00010\f8\u0006@\u0006X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bI\u0010J\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR \u00107\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\f8\u0002@\u0002X\u000e¢\u0006\b\n\u0000\u0012\u0004\bO\u0010JRA\u0010Q\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\f2\u000e\u0010P\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\f8F@FX\u0002¢\u0006\u0018\n\u0004\bU\u0010V\u0012\u0004\bR\u0010J\u001a\u0004\bS\u0010L\"\u0004\bT\u0010NR,\u00106\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\f8\u0006@\u0006X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bW\u0010J\u001a\u0004\bX\u0010L\"\u0004\bY\u0010NR,\u00105\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\f8\u0006@\u0006X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bZ\u0010J\u001a\u0004\b[\u0010L\"\u0004\b\\\u0010NR,\u00103\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\f8\u0006@\u0006X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b]\u0010J\u001a\u0004\b^\u0010L\"\u0004\b_\u0010NR,\u00104\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\f8\u0006@\u0006X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b`\u0010J\u001a\u0004\ba\u0010L\"\u0004\bb\u0010NR1\u0010?\u001a\u000f\u0012\t\u0012\u00070=¢\u0006\u0002\b>\u0018\u00010\f8\u0006@\u0006X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bc\u0010J\u001a\u0004\bd\u0010L\"\u0004\be\u0010NR,\u0010:\u001a\n\u0012\u0004\u0012\u00020;\u0018\u00010\f8\u0006@\u0006X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bf\u0010J\u001a\u0004\bg\u0010L\"\u0004\bh\u0010NR'\u0010D\u001a\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020F0E¢\u0006\u0002\bG8\u0002X\u0004¢\u0006\b\n\u0000\u0012\u0004\bi\u0010JR1\u0010<\u001a\u000f\u0012\t\u0012\u00070=¢\u0006\u0002\b>\u0018\u00010\f8\u0006@\u0006X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bj\u0010J\u001a\u0004\bk\u0010L\"\u0004\bl\u0010NR,\u0010@\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\f8\u0006@\u0006X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bm\u0010J\u001a\u0004\bn\u0010L\"\u0004\bo\u0010N¨\u0006|å\b\u0005å\b\u0007å\b\bå\b\u000bå\b\u000eå\b\u000få\b\u0011å\b\u0012å\b\u0013å\b\u0016å\b\u0018å\b\u001aå\b\u001cå\b\u001då\b\u001eå\b\u001få\b å\b!å\b\"å\b#å\b$å\b%å\b&å\b'å\b(å\b)å\b*å\b+å\b,å\b.å\b0å\b1å\b2å\b3å\b4å\b5å\b6å\b7å\b8å\b:å\b<å\b?å\b@"}, d2 = {"Lcom/deliveryhero/fluid/widgets/image/ImageModelBuilder;", "Lcom/deliveryhero/fluid/widgets/WidgetModelBuilder;", "seen1", "", "seen2", "id", "", "hash", "placeholders", "", "Lcom/deliveryhero/fluid/expression/placeholder/PlaceholderSurrogate;", "width", "Lcom/deliveryhero/fluid/expression/ExpressionBuilder;", "Lcom/deliveryhero/fluid/values/Size;", "height", "isVisible", "", "expansionResistancePriority", "compressionResistancePriority", "backgroundColors", "", "Lcom/deliveryhero/fluid/values/Color;", "backgroundShape", "Lcom/deliveryhero/fluid/values/Shape;", "backgroundLinearGradientOrientation", "Lcom/deliveryhero/fluid/values/LinearGradientOrientation;", "backgroundCornerRadiusTopLeft", "Lcom/deliveryhero/fluid/values/LogicalPixel;", "backgroundCornerRadiusTopRight", "backgroundCornerRadiusBottomRight", "backgroundCornerRadiusBottomLeft", "backgroundRadius", "borderWidth", "borderColor", "elevation", "clipToBounds", "paddingLeading", "paddingTop", "paddingTrailing", "paddingBottom", "marginLeading", "marginTop", "marginTrailing", "marginBottom", "horizontalAlignment", "Lcom/deliveryhero/fluid/widgets/containers/HorizontalAlignment;", "verticalAlignment", "Lcom/deliveryhero/fluid/widgets/containers/VerticalAlignment;", "accessibilityId", "accessibilityLabel", "onClick", "cornerRadiusTopLeft", "cornerRadiusTopRight", "cornerRadiusBottomRight", "cornerRadiusBottomLeft", "cornerRadius", "contentMode", "Lcom/deliveryhero/fluid/widgets/image/ImageContentMode;", "image", "Lcom/deliveryhero/fluid/widgets/image/ImageLocator;", "loadingPlaceholder", "Lcom/deliveryhero/fluid/widgets/image/ImageLocator$Local;", "Lkotlinx/serialization/Contextual;", "errorPlaceholder", "shape", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IILjava/lang/String;Ljava/lang/String;Ljava/util/Set;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Ljava/util/List;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "init", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function1;)V", "getContentMode$annotations", "()V", "getContentMode", "()Lcom/deliveryhero/fluid/expression/ExpressionBuilder;", "setContentMode", "(Lcom/deliveryhero/fluid/expression/ExpressionBuilder;)V", "getCornerRadius$annotations", "<set-?>", "cornerRadiusAll", "getCornerRadiusAll$annotations", "getCornerRadiusAll", "setCornerRadiusAll", "cornerRadiusAll$delegate", "Lcom/deliveryhero/fluid/widgets/utils/WidgetModelBuilderDelegates$PropertyGroup;", "getCornerRadiusBottomLeft$annotations", "getCornerRadiusBottomLeft", "setCornerRadiusBottomLeft", "getCornerRadiusBottomRight$annotations", "getCornerRadiusBottomRight", "setCornerRadiusBottomRight", "getCornerRadiusTopLeft$annotations", "getCornerRadiusTopLeft", "setCornerRadiusTopLeft", "getCornerRadiusTopRight$annotations", "getCornerRadiusTopRight", "setCornerRadiusTopRight", "getErrorPlaceholder$annotations", "getErrorPlaceholder", "setErrorPlaceholder", "getImage$annotations", "getImage", "setImage", "getInit$annotations", "getLoadingPlaceholder$annotations", "getLoadingPlaceholder", "setLoadingPlaceholder", "getShape$annotations", "getShape", "setShape", "build", "Lcom/deliveryhero/fluid/widgets/image/ImageModel;", "args", "Lcom/deliveryhero/fluid/expression/ExpressionBuilder$Args;", "write$Self", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "$serializer", "Companion", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Serializable
@CoreContract.CreatedOn(version = CoreContract.Version.V1)
@SerialName("image")
public class ImageModelBuilder extends WidgetModelBuilder {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ KProperty<Object>[] f30275b = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(ImageModelBuilder.class, "cornerRadiusAll", "getCornerRadiusAll()Lcom/deliveryhero/fluid/expression/ExpressionBuilder;", 0))};
    @Nullable
    private ExpressionBuilder<ImageContentMode> contentMode;
    /* access modifiers changed from: private */
    @Nullable
    public ExpressionBuilder<LogicalPixel> cornerRadius;
    @NotNull
    private final WidgetModelBuilderDelegates.PropertyGroup cornerRadiusAll$delegate;
    @Nullable
    private ExpressionBuilder<LogicalPixel> cornerRadiusBottomLeft;
    @Nullable
    private ExpressionBuilder<LogicalPixel> cornerRadiusBottomRight;
    @Nullable
    private ExpressionBuilder<LogicalPixel> cornerRadiusTopLeft;
    @Nullable
    private ExpressionBuilder<LogicalPixel> cornerRadiusTopRight;
    @Nullable
    private ExpressionBuilder<ImageLocator.Local> errorPlaceholder;
    @Nullable
    private ExpressionBuilder<ImageLocator> image;
    @NotNull
    private final Function1<ImageModelBuilder, Unit> init;
    @Nullable
    private ExpressionBuilder<ImageLocator.Local> loadingPlaceholder;
    @Nullable
    private ExpressionBuilder<Shape> shape;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/deliveryhero/fluid/widgets/image/ImageModelBuilder$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/deliveryhero/fluid/widgets/image/ImageModelBuilder;", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final KSerializer<ImageModelBuilder> serializer() {
            return ImageModelBuilder$$serializer.INSTANCE;
        }
    }

    public ImageModelBuilder() {
        this((Function1) null, 1, (DefaultConstructorMarker) null);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @kotlin.ReplaceWith(expression = "", imports = {}))
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ ImageModelBuilder(int r41, int r42, @com.deliveryhero.fluid.versioning.CoreContract.CreatedOn(version = com.deliveryhero.fluid.versioning.CoreContract.Version.V1) @kotlin.Deprecated(message = "Move when versioning is supported") @kotlinx.serialization.SerialName("id") java.lang.String r43, @com.deliveryhero.fluid.versioning.CoreContract.CreatedOn(version = com.deliveryhero.fluid.versioning.CoreContract.Version.V1) @kotlin.Deprecated(message = "Move when versioning is supported") @kotlinx.serialization.SerialName("hash") java.lang.String r44, @com.deliveryhero.fluid.versioning.CoreContract.CreatedOn(version = com.deliveryhero.fluid.versioning.CoreContract.Version.V1) @kotlin.Deprecated(message = "Move when versioning is supported") @kotlinx.serialization.SerialName("placeholders") java.util.Set r45, @com.deliveryhero.fluid.versioning.CoreContract.CreatedOn(version = com.deliveryhero.fluid.versioning.CoreContract.Version.V1) @kotlinx.serialization.SerialName("width") com.deliveryhero.fluid.expression.ExpressionBuilder r46, @com.deliveryhero.fluid.versioning.CoreContract.CreatedOn(version = com.deliveryhero.fluid.versioning.CoreContract.Version.V1) @kotlinx.serialization.SerialName("height") com.deliveryhero.fluid.expression.ExpressionBuilder r47, @com.deliveryhero.fluid.versioning.CoreContract.CreatedOn(version = com.deliveryhero.fluid.versioning.CoreContract.Version.V1) @kotlinx.serialization.SerialName("is_visible") com.deliveryhero.fluid.expression.ExpressionBuilder r48, @com.deliveryhero.fluid.versioning.CoreContract.CreatedOn(version = com.deliveryhero.fluid.versioning.CoreContract.Version.V1) @kotlinx.serialization.SerialName("expansion_resistance_priority") com.deliveryhero.fluid.expression.ExpressionBuilder r49, @com.deliveryhero.fluid.versioning.CoreContract.CreatedOn(version = com.deliveryhero.fluid.versioning.CoreContract.Version.V1) @kotlinx.serialization.SerialName("compression_resistance_priority") com.deliveryhero.fluid.expression.ExpressionBuilder r50, @com.deliveryhero.fluid.versioning.CoreContract.CreatedOn(version = com.deliveryhero.fluid.versioning.CoreContract.Version.V1) @kotlinx.serialization.SerialName("background_colors") java.util.List r51, @com.deliveryhero.fluid.versioning.CoreContract.CreatedOn(version = com.deliveryhero.fluid.versioning.CoreContract.Version.V1) @kotlinx.serialization.SerialName("background_shape") com.deliveryhero.fluid.expression.ExpressionBuilder r52, @com.deliveryhero.fluid.versioning.CoreContract.CreatedOn(version = com.deliveryhero.fluid.versioning.CoreContract.Version.V1) @kotlinx.serialization.SerialName("background_gradient_orientation") com.deliveryhero.fluid.expression.ExpressionBuilder r53, @com.deliveryhero.fluid.versioning.CoreContract.CreatedOn(version = com.deliveryhero.fluid.versioning.CoreContract.Version.V1) @kotlinx.serialization.SerialName("background_radius_top_left") com.deliveryhero.fluid.expression.ExpressionBuilder r54, @com.deliveryhero.fluid.versioning.CoreContract.CreatedOn(version = com.deliveryhero.fluid.versioning.CoreContract.Version.V1) @kotlinx.serialization.SerialName("background_radius_top_right") com.deliveryhero.fluid.expression.ExpressionBuilder r55, @com.deliveryhero.fluid.versioning.CoreContract.CreatedOn(version = com.deliveryhero.fluid.versioning.CoreContract.Version.V1) @kotlinx.serialization.SerialName("background_radius_bottom_right") com.deliveryhero.fluid.expression.ExpressionBuilder r56, @com.deliveryhero.fluid.versioning.CoreContract.CreatedOn(version = com.deliveryhero.fluid.versioning.CoreContract.Version.V1) @kotlinx.serialization.SerialName("background_radius_bottom_left") com.deliveryhero.fluid.expression.ExpressionBuilder r57, @com.deliveryhero.fluid.versioning.CoreContract.CreatedOn(version = com.deliveryhero.fluid.versioning.CoreContract.Version.V1) @kotlin.Deprecated(message = "Use backgroundCornerRadiusAll or corner specific background radii instead") @com.deliveryhero.fluid.versioning.CoreContract.DeprecatedOn(version = com.deliveryhero.fluid.versioning.CoreContract.Version.V2) @kotlinx.serialization.SerialName("background_radius") com.deliveryhero.fluid.expression.ExpressionBuilder r58, @com.deliveryhero.fluid.versioning.CoreContract.CreatedOn(version = com.deliveryhero.fluid.versioning.CoreContract.Version.V1) @kotlinx.serialization.SerialName("border_width") com.deliveryhero.fluid.expression.ExpressionBuilder r59, @com.deliveryhero.fluid.versioning.CoreContract.CreatedOn(version = com.deliveryhero.fluid.versioning.CoreContract.Version.V1) @kotlinx.serialization.SerialName("border_color") com.deliveryhero.fluid.expression.ExpressionBuilder r60, @com.deliveryhero.fluid.versioning.CoreContract.CreatedOn(version = com.deliveryhero.fluid.versioning.CoreContract.Version.V1) @kotlinx.serialization.SerialName("elevation") com.deliveryhero.fluid.expression.ExpressionBuilder r61, @com.deliveryhero.fluid.versioning.CoreContract.CreatedOn(version = com.deliveryhero.fluid.versioning.CoreContract.Version.V1) @kotlinx.serialization.SerialName("clip_to_bounds") com.deliveryhero.fluid.expression.ExpressionBuilder r62, @com.deliveryhero.fluid.versioning.CoreContract.CreatedOn(version = com.deliveryhero.fluid.versioning.CoreContract.Version.V1) @kotlinx.serialization.SerialName("padding_leading") com.deliveryhero.fluid.expression.ExpressionBuilder r63, @com.deliveryhero.fluid.versioning.CoreContract.CreatedOn(version = com.deliveryhero.fluid.versioning.CoreContract.Version.V1) @kotlinx.serialization.SerialName("padding_top") com.deliveryhero.fluid.expression.ExpressionBuilder r64, @com.deliveryhero.fluid.versioning.CoreContract.CreatedOn(version = com.deliveryhero.fluid.versioning.CoreContract.Version.V1) @kotlinx.serialization.SerialName("padding_trailing") com.deliveryhero.fluid.expression.ExpressionBuilder r65, @com.deliveryhero.fluid.versioning.CoreContract.CreatedOn(version = com.deliveryhero.fluid.versioning.CoreContract.Version.V1) @kotlinx.serialization.SerialName("padding_bottom") com.deliveryhero.fluid.expression.ExpressionBuilder r66, @com.deliveryhero.fluid.versioning.CoreContract.CreatedOn(version = com.deliveryhero.fluid.versioning.CoreContract.Version.V1) @kotlinx.serialization.SerialName("margin_leading") com.deliveryhero.fluid.expression.ExpressionBuilder r67, @com.deliveryhero.fluid.versioning.CoreContract.CreatedOn(version = com.deliveryhero.fluid.versioning.CoreContract.Version.V1) @kotlinx.serialization.SerialName("margin_top") com.deliveryhero.fluid.expression.ExpressionBuilder r68, @com.deliveryhero.fluid.versioning.CoreContract.CreatedOn(version = com.deliveryhero.fluid.versioning.CoreContract.Version.V1) @kotlinx.serialization.SerialName("margin_trailing") com.deliveryhero.fluid.expression.ExpressionBuilder r69, @com.deliveryhero.fluid.versioning.CoreContract.CreatedOn(version = com.deliveryhero.fluid.versioning.CoreContract.Version.V1) @kotlinx.serialization.SerialName("margin_bottom") com.deliveryhero.fluid.expression.ExpressionBuilder r70, @com.deliveryhero.fluid.versioning.CoreContract.CreatedOn(version = com.deliveryhero.fluid.versioning.CoreContract.Version.V1) @kotlinx.serialization.SerialName("horizontal_alignment") com.deliveryhero.fluid.expression.ExpressionBuilder r71, @com.deliveryhero.fluid.versioning.CoreContract.CreatedOn(version = com.deliveryhero.fluid.versioning.CoreContract.Version.V1) @kotlinx.serialization.SerialName("vertical_alignment") com.deliveryhero.fluid.expression.ExpressionBuilder r72, @com.deliveryhero.fluid.versioning.CoreContract.CreatedOn(version = com.deliveryhero.fluid.versioning.CoreContract.Version.V1) @kotlinx.serialization.SerialName("accessibility_tag") com.deliveryhero.fluid.expression.ExpressionBuilder r73, @com.deliveryhero.fluid.versioning.CoreContract.CreatedOn(version = com.deliveryhero.fluid.versioning.CoreContract.Version.V1) @kotlinx.serialization.SerialName("accessibility_label") com.deliveryhero.fluid.expression.ExpressionBuilder r74, @com.deliveryhero.fluid.versioning.CoreContract.CreatedOn(version = com.deliveryhero.fluid.versioning.CoreContract.Version.V1) @kotlinx.serialization.SerialName("on_click") com.deliveryhero.fluid.expression.ExpressionBuilder r75, @com.deliveryhero.fluid.versioning.CoreContract.CreatedOn(version = com.deliveryhero.fluid.versioning.CoreContract.Version.V1) @kotlinx.serialization.SerialName("corner_radius_top_left") com.deliveryhero.fluid.expression.ExpressionBuilder r76, @com.deliveryhero.fluid.versioning.CoreContract.CreatedOn(version = com.deliveryhero.fluid.versioning.CoreContract.Version.V1) @kotlinx.serialization.SerialName("corner_radius_top_right") com.deliveryhero.fluid.expression.ExpressionBuilder r77, @com.deliveryhero.fluid.versioning.CoreContract.CreatedOn(version = com.deliveryhero.fluid.versioning.CoreContract.Version.V1) @kotlinx.serialization.SerialName("corner_radius_bottom_right") com.deliveryhero.fluid.expression.ExpressionBuilder r78, @com.deliveryhero.fluid.versioning.CoreContract.CreatedOn(version = com.deliveryhero.fluid.versioning.CoreContract.Version.V1) @kotlinx.serialization.SerialName("corner_radius_bottom_left") com.deliveryhero.fluid.expression.ExpressionBuilder r79, @com.deliveryhero.fluid.versioning.CoreContract.CreatedOn(version = com.deliveryhero.fluid.versioning.CoreContract.Version.V1) @kotlin.Deprecated(message = "Use cornerRadiusAll or corner specific radius instead", replaceWith = @kotlin.ReplaceWith(expression = "cornerRadiusAll", imports = {})) @com.deliveryhero.fluid.versioning.CoreContract.DeprecatedOn(version = com.deliveryhero.fluid.versioning.CoreContract.Version.V2) @kotlinx.serialization.SerialName("corner_radius") com.deliveryhero.fluid.expression.ExpressionBuilder r80, @com.deliveryhero.fluid.versioning.CoreContract.CreatedOn(version = com.deliveryhero.fluid.versioning.CoreContract.Version.V1) @kotlinx.serialization.SerialName("content_mode") com.deliveryhero.fluid.expression.ExpressionBuilder r81, @com.deliveryhero.fluid.versioning.CoreContract.CreatedOn(version = com.deliveryhero.fluid.versioning.CoreContract.Version.V1) @kotlinx.serialization.SerialName("image") com.deliveryhero.fluid.expression.ExpressionBuilder r82, @com.deliveryhero.fluid.versioning.CoreContract.CreatedOn(version = com.deliveryhero.fluid.versioning.CoreContract.Version.V1) @kotlinx.serialization.SerialName("loading_placeholder") com.deliveryhero.fluid.expression.ExpressionBuilder r83, @com.deliveryhero.fluid.versioning.CoreContract.CreatedOn(version = com.deliveryhero.fluid.versioning.CoreContract.Version.V1) @kotlinx.serialization.SerialName("error_placeholder") com.deliveryhero.fluid.expression.ExpressionBuilder r84, @com.deliveryhero.fluid.versioning.CoreContract.CreatedOn(version = com.deliveryhero.fluid.versioning.CoreContract.Version.V1) @kotlinx.serialization.SerialName("shape") com.deliveryhero.fluid.expression.ExpressionBuilder r85, kotlinx.serialization.internal.SerializationConstructorMarker r86) {
        /*
            r40 = this;
            r15 = r40
            r14 = r42
            r0 = r41 & 0
            r37 = 1
            r38 = 0
            if (r0 == 0) goto L_0x000f
            r0 = r37
            goto L_0x0011
        L_0x000f:
            r0 = r38
        L_0x0011:
            r1 = r14 & 0
            if (r1 == 0) goto L_0x0018
            r1 = r37
            goto L_0x001a
        L_0x0018:
            r1 = r38
        L_0x001a:
            r0 = r0 | r1
            r13 = 2
            if (r0 == 0) goto L_0x0032
            int[] r0 = new int[r13]
            r0[r38] = r41
            r0[r37] = r14
            int[] r1 = new int[r13]
            r1 = {0, 0} // fill-array
            com.deliveryhero.fluid.widgets.image.ImageModelBuilder$$serializer r2 = com.deliveryhero.fluid.widgets.image.ImageModelBuilder$$serializer.INSTANCE
            kotlinx.serialization.descriptors.SerialDescriptor r2 = r2.getDescriptor()
            kotlinx.serialization.internal.PluginExceptionsKt.throwArrayMissingFieldException(r0, r1, r2)
        L_0x0032:
            r0 = r40
            r1 = r41
            r2 = r42
            r3 = r43
            r4 = r44
            r5 = r45
            r6 = r46
            r7 = r47
            r8 = r48
            r9 = r49
            r10 = r50
            r11 = r51
            r12 = r52
            r39 = r13
            r13 = r53
            r14 = r54
            r15 = r55
            r16 = r56
            r17 = r57
            r18 = r58
            r19 = r59
            r20 = r60
            r21 = r61
            r22 = r62
            r23 = r63
            r24 = r64
            r25 = r65
            r26 = r66
            r27 = r67
            r28 = r68
            r29 = r69
            r30 = r70
            r31 = r71
            r32 = r72
            r33 = r73
            r34 = r74
            r35 = r75
            r36 = r86
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36)
            com.deliveryhero.fluid.widgets.image.ImageModelBuilder$2 r0 = com.deliveryhero.fluid.widgets.image.ImageModelBuilder.AnonymousClass2.INSTANCE
            r1 = r40
            r1.init = r0
            r3 = r2 & 2
            r4 = 0
            if (r3 != 0) goto L_0x008f
            r1.cornerRadiusTopLeft = r4
            goto L_0x0093
        L_0x008f:
            r3 = r76
            r1.cornerRadiusTopLeft = r3
        L_0x0093:
            r3 = r2 & 4
            if (r3 != 0) goto L_0x009a
            r1.cornerRadiusTopRight = r4
            goto L_0x009e
        L_0x009a:
            r3 = r77
            r1.cornerRadiusTopRight = r3
        L_0x009e:
            r3 = r2 & 8
            if (r3 != 0) goto L_0x00a5
            r1.cornerRadiusBottomRight = r4
            goto L_0x00a9
        L_0x00a5:
            r3 = r78
            r1.cornerRadiusBottomRight = r3
        L_0x00a9:
            r3 = r2 & 16
            if (r3 != 0) goto L_0x00b0
            r1.cornerRadiusBottomLeft = r4
            goto L_0x00b4
        L_0x00b0:
            r3 = r79
            r1.cornerRadiusBottomLeft = r3
        L_0x00b4:
            r3 = r2 & 32
            if (r3 != 0) goto L_0x00bb
            r1.cornerRadius = r4
            goto L_0x00bf
        L_0x00bb:
            r3 = r80
            r1.cornerRadius = r3
        L_0x00bf:
            com.deliveryhero.fluid.widgets.utils.WidgetModelBuilderDelegates$PropertyGroup r3 = new com.deliveryhero.fluid.widgets.utils.WidgetModelBuilderDelegates$PropertyGroup
            r5 = 5
            kotlin.reflect.KMutableProperty0[] r5 = new kotlin.reflect.KMutableProperty0[r5]
            com.deliveryhero.fluid.widgets.image.ImageModelBuilder$3 r6 = new com.deliveryhero.fluid.widgets.image.ImageModelBuilder$3
            r6.<init>(r1)
            r5[r38] = r6
            com.deliveryhero.fluid.widgets.image.ImageModelBuilder$4 r6 = new com.deliveryhero.fluid.widgets.image.ImageModelBuilder$4
            r6.<init>(r1)
            r5[r37] = r6
            com.deliveryhero.fluid.widgets.image.ImageModelBuilder$5 r6 = new com.deliveryhero.fluid.widgets.image.ImageModelBuilder$5
            r6.<init>(r1)
            r5[r39] = r6
            com.deliveryhero.fluid.widgets.image.ImageModelBuilder$6 r6 = new com.deliveryhero.fluid.widgets.image.ImageModelBuilder$6
            r6.<init>(r1)
            r7 = 3
            r5[r7] = r6
            com.deliveryhero.fluid.widgets.image.ImageModelBuilder$7 r6 = new com.deliveryhero.fluid.widgets.image.ImageModelBuilder$7
            r6.<init>(r1)
            r7 = 4
            r5[r7] = r6
            com.deliveryhero.fluid.widgets.image.ImageModelBuilder$8 r6 = new com.deliveryhero.fluid.widgets.image.ImageModelBuilder$8
            r6.<init>(r1)
            r3.<init>(r5, r6)
            r1.cornerRadiusAll$delegate = r3
            r3 = r2 & 64
            if (r3 != 0) goto L_0x00fa
            r1.contentMode = r4
            goto L_0x00fe
        L_0x00fa:
            r3 = r81
            r1.contentMode = r3
        L_0x00fe:
            r3 = r2 & 128(0x80, float:1.794E-43)
            if (r3 != 0) goto L_0x0105
            r1.image = r4
            goto L_0x0109
        L_0x0105:
            r3 = r82
            r1.image = r3
        L_0x0109:
            r3 = r2 & 256(0x100, float:3.59E-43)
            if (r3 != 0) goto L_0x0110
            r1.loadingPlaceholder = r4
            goto L_0x0114
        L_0x0110:
            r3 = r83
            r1.loadingPlaceholder = r3
        L_0x0114:
            r3 = r2 & 512(0x200, float:7.175E-43)
            if (r3 != 0) goto L_0x011b
            r1.errorPlaceholder = r4
            goto L_0x011f
        L_0x011b:
            r3 = r84
            r1.errorPlaceholder = r3
        L_0x011f:
            r2 = r2 & 1024(0x400, float:1.435E-42)
            if (r2 != 0) goto L_0x0126
            r1.shape = r4
            goto L_0x012a
        L_0x0126:
            r2 = r85
            r1.shape = r2
        L_0x012a:
            r0.invoke(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.deliveryhero.fluid.widgets.image.ImageModelBuilder.<init>(int, int, java.lang.String, java.lang.String, java.util.Set, com.deliveryhero.fluid.expression.ExpressionBuilder, com.deliveryhero.fluid.expression.ExpressionBuilder, com.deliveryhero.fluid.expression.ExpressionBuilder, com.deliveryhero.fluid.expression.ExpressionBuilder, com.deliveryhero.fluid.expression.ExpressionBuilder, java.util.List, com.deliveryhero.fluid.expression.ExpressionBuilder, com.deliveryhero.fluid.expression.ExpressionBuilder, com.deliveryhero.fluid.expression.ExpressionBuilder, com.deliveryhero.fluid.expression.ExpressionBuilder, com.deliveryhero.fluid.expression.ExpressionBuilder, com.deliveryhero.fluid.expression.ExpressionBuilder, com.deliveryhero.fluid.expression.ExpressionBuilder, com.deliveryhero.fluid.expression.ExpressionBuilder, com.deliveryhero.fluid.expression.ExpressionBuilder, com.deliveryhero.fluid.expression.ExpressionBuilder, com.deliveryhero.fluid.expression.ExpressionBuilder, com.deliveryhero.fluid.expression.ExpressionBuilder, com.deliveryhero.fluid.expression.ExpressionBuilder, com.deliveryhero.fluid.expression.ExpressionBuilder, com.deliveryhero.fluid.expression.ExpressionBuilder, com.deliveryhero.fluid.expression.ExpressionBuilder, com.deliveryhero.fluid.expression.ExpressionBuilder, com.deliveryhero.fluid.expression.ExpressionBuilder, com.deliveryhero.fluid.expression.ExpressionBuilder, com.deliveryhero.fluid.expression.ExpressionBuilder, com.deliveryhero.fluid.expression.ExpressionBuilder, com.deliveryhero.fluid.expression.ExpressionBuilder, com.deliveryhero.fluid.expression.ExpressionBuilder, com.deliveryhero.fluid.expression.ExpressionBuilder, com.deliveryhero.fluid.expression.ExpressionBuilder, com.deliveryhero.fluid.expression.ExpressionBuilder, com.deliveryhero.fluid.expression.ExpressionBuilder, com.deliveryhero.fluid.expression.ExpressionBuilder, com.deliveryhero.fluid.expression.ExpressionBuilder, com.deliveryhero.fluid.expression.ExpressionBuilder, com.deliveryhero.fluid.expression.ExpressionBuilder, com.deliveryhero.fluid.expression.ExpressionBuilder, com.deliveryhero.fluid.expression.ExpressionBuilder, com.deliveryhero.fluid.expression.ExpressionBuilder, kotlinx.serialization.internal.SerializationConstructorMarker):void");
    }

    @CoreContract.CreatedOn(version = CoreContract.Version.V1)
    @SerialName("content_mode")
    public static /* synthetic */ void getContentMode$annotations() {
    }

    @CoreContract.CreatedOn(version = CoreContract.Version.V1)
    @Deprecated(message = "Use cornerRadiusAll or corner specific radius instead", replaceWith = @ReplaceWith(expression = "cornerRadiusAll", imports = {}))
    @CoreContract.DeprecatedOn(version = CoreContract.Version.V2)
    @SerialName("corner_radius")
    private static /* synthetic */ void getCornerRadius$annotations() {
    }

    @Transient
    public static /* synthetic */ void getCornerRadiusAll$annotations() {
    }

    @CoreContract.CreatedOn(version = CoreContract.Version.V1)
    @SerialName("corner_radius_bottom_left")
    public static /* synthetic */ void getCornerRadiusBottomLeft$annotations() {
    }

    @CoreContract.CreatedOn(version = CoreContract.Version.V1)
    @SerialName("corner_radius_bottom_right")
    public static /* synthetic */ void getCornerRadiusBottomRight$annotations() {
    }

    @CoreContract.CreatedOn(version = CoreContract.Version.V1)
    @SerialName("corner_radius_top_left")
    public static /* synthetic */ void getCornerRadiusTopLeft$annotations() {
    }

    @CoreContract.CreatedOn(version = CoreContract.Version.V1)
    @SerialName("corner_radius_top_right")
    public static /* synthetic */ void getCornerRadiusTopRight$annotations() {
    }

    @CoreContract.CreatedOn(version = CoreContract.Version.V1)
    @SerialName("error_placeholder")
    public static /* synthetic */ void getErrorPlaceholder$annotations() {
    }

    @CoreContract.CreatedOn(version = CoreContract.Version.V1)
    @SerialName("image")
    public static /* synthetic */ void getImage$annotations() {
    }

    @Transient
    private static /* synthetic */ void getInit$annotations() {
    }

    @CoreContract.CreatedOn(version = CoreContract.Version.V1)
    @SerialName("loading_placeholder")
    public static /* synthetic */ void getLoadingPlaceholder$annotations() {
    }

    @CoreContract.CreatedOn(version = CoreContract.Version.V1)
    @SerialName("shape")
    public static /* synthetic */ void getShape$annotations() {
    }

    @JvmStatic
    public static final void write$Self(@NotNull ImageModelBuilder imageModelBuilder, @NotNull CompositeEncoder compositeEncoder, @NotNull SerialDescriptor serialDescriptor) {
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        boolean z15;
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        Intrinsics.checkNotNullParameter(imageModelBuilder, "self");
        Intrinsics.checkNotNullParameter(compositeEncoder, "output");
        Intrinsics.checkNotNullParameter(serialDescriptor, "serialDesc");
        WidgetModelBuilder.write$Self(imageModelBuilder, compositeEncoder, serialDescriptor);
        boolean z21 = false;
        if (!compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 33) && imageModelBuilder.cornerRadiusTopLeft == null) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (z11) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 33, new ExpressionBuilderSerializer(LogicalPixel$$serializer.INSTANCE), imageModelBuilder.cornerRadiusTopLeft);
        }
        if (!compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 34) && imageModelBuilder.cornerRadiusTopRight == null) {
            z12 = false;
        } else {
            z12 = true;
        }
        if (z12) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 34, new ExpressionBuilderSerializer(LogicalPixel$$serializer.INSTANCE), imageModelBuilder.cornerRadiusTopRight);
        }
        if (!compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 35) && imageModelBuilder.cornerRadiusBottomRight == null) {
            z13 = false;
        } else {
            z13 = true;
        }
        if (z13) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 35, new ExpressionBuilderSerializer(LogicalPixel$$serializer.INSTANCE), imageModelBuilder.cornerRadiusBottomRight);
        }
        if (!compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 36) && imageModelBuilder.cornerRadiusBottomLeft == null) {
            z14 = false;
        } else {
            z14 = true;
        }
        if (z14) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 36, new ExpressionBuilderSerializer(LogicalPixel$$serializer.INSTANCE), imageModelBuilder.cornerRadiusBottomLeft);
        }
        if (!compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 37) && imageModelBuilder.cornerRadius == null) {
            z15 = false;
        } else {
            z15 = true;
        }
        if (z15) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 37, new ExpressionBuilderSerializer(LogicalPixel$$serializer.INSTANCE), imageModelBuilder.cornerRadius);
        }
        if (!compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 38) && imageModelBuilder.contentMode == null) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 38, new ExpressionBuilderSerializer(new EnumSerializer("com.deliveryhero.fluid.widgets.image.ImageContentMode", ImageContentMode.values())), imageModelBuilder.contentMode);
        }
        if (!compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 39) && imageModelBuilder.image == null) {
            z17 = false;
        } else {
            z17 = true;
        }
        if (z17) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 39, new ExpressionBuilderSerializer(new PolymorphicSerializer(Reflection.getOrCreateKotlinClass(ImageLocator.class), new Annotation[0])), imageModelBuilder.image);
        }
        if (!compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 40) && imageModelBuilder.loadingPlaceholder == null) {
            z18 = false;
        } else {
            z18 = true;
        }
        Class<ImageLocator.Local> cls = ImageLocator.Local.class;
        if (z18) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 40, new ExpressionBuilderSerializer(new ContextualSerializer(Reflection.getOrCreateKotlinClass(cls), (KSerializer) null, new KSerializer[0])), imageModelBuilder.loadingPlaceholder);
        }
        if (!compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 41) && imageModelBuilder.errorPlaceholder == null) {
            z19 = false;
        } else {
            z19 = true;
        }
        if (z19) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 41, new ExpressionBuilderSerializer(new ContextualSerializer(Reflection.getOrCreateKotlinClass(cls), (KSerializer) null, new KSerializer[0])), imageModelBuilder.errorPlaceholder);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 42) || imageModelBuilder.shape != null) {
            z21 = true;
        }
        if (z21) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 42, new ExpressionBuilderSerializer(Shape$$serializer.INSTANCE), imageModelBuilder.shape);
        }
    }

    @Nullable
    public final ExpressionBuilder<ImageContentMode> getContentMode() {
        return this.contentMode;
    }

    @Nullable
    public final ExpressionBuilder<LogicalPixel> getCornerRadiusAll() {
        return this.cornerRadiusAll$delegate.getValue(this, f30275b[0]);
    }

    @Nullable
    public final ExpressionBuilder<LogicalPixel> getCornerRadiusBottomLeft() {
        return this.cornerRadiusBottomLeft;
    }

    @Nullable
    public final ExpressionBuilder<LogicalPixel> getCornerRadiusBottomRight() {
        return this.cornerRadiusBottomRight;
    }

    @Nullable
    public final ExpressionBuilder<LogicalPixel> getCornerRadiusTopLeft() {
        return this.cornerRadiusTopLeft;
    }

    @Nullable
    public final ExpressionBuilder<LogicalPixel> getCornerRadiusTopRight() {
        return this.cornerRadiusTopRight;
    }

    @Nullable
    public final ExpressionBuilder<ImageLocator.Local> getErrorPlaceholder() {
        return this.errorPlaceholder;
    }

    @Nullable
    public final ExpressionBuilder<ImageLocator> getImage() {
        return this.image;
    }

    @Nullable
    public final ExpressionBuilder<ImageLocator.Local> getLoadingPlaceholder() {
        return this.loadingPlaceholder;
    }

    @Nullable
    public final ExpressionBuilder<Shape> getShape() {
        return this.shape;
    }

    public final void setContentMode(@Nullable ExpressionBuilder<ImageContentMode> expressionBuilder) {
        this.contentMode = expressionBuilder;
    }

    public final void setCornerRadiusAll(@Nullable ExpressionBuilder<LogicalPixel> expressionBuilder) {
        this.cornerRadiusAll$delegate.setValue(this, f30275b[0], expressionBuilder);
    }

    public final void setCornerRadiusBottomLeft(@Nullable ExpressionBuilder<LogicalPixel> expressionBuilder) {
        this.cornerRadiusBottomLeft = expressionBuilder;
    }

    public final void setCornerRadiusBottomRight(@Nullable ExpressionBuilder<LogicalPixel> expressionBuilder) {
        this.cornerRadiusBottomRight = expressionBuilder;
    }

    public final void setCornerRadiusTopLeft(@Nullable ExpressionBuilder<LogicalPixel> expressionBuilder) {
        this.cornerRadiusTopLeft = expressionBuilder;
    }

    public final void setCornerRadiusTopRight(@Nullable ExpressionBuilder<LogicalPixel> expressionBuilder) {
        this.cornerRadiusTopRight = expressionBuilder;
    }

    public final void setErrorPlaceholder(@Nullable ExpressionBuilder<ImageLocator.Local> expressionBuilder) {
        this.errorPlaceholder = expressionBuilder;
    }

    public final void setImage(@Nullable ExpressionBuilder<ImageLocator> expressionBuilder) {
        this.image = expressionBuilder;
    }

    public final void setLoadingPlaceholder(@Nullable ExpressionBuilder<ImageLocator.Local> expressionBuilder) {
        this.loadingPlaceholder = expressionBuilder;
    }

    public final void setShape(@Nullable ExpressionBuilder<Shape> expressionBuilder) {
        this.shape = expressionBuilder;
    }

    @NotNull
    public ImageModel build(@NotNull ExpressionBuilder.Args args) {
        Intrinsics.checkNotNullParameter(args, StepData.ARGS);
        Expression<DecodedT> build = ExpressionBuilderUtilsKt.build(this.image, Reflection.getOrCreateKotlinClass(ImageLocator.class), ImageLocatorCodec.INSTANCE, args);
        ExpressionBuilder<ImageLocator.Local> expressionBuilder = this.loadingPlaceholder;
        LocalImageLocatorCodec localImageLocatorCodec = LocalImageLocatorCodec.INSTANCE;
        Class<ImageLocator.Local> cls = ImageLocator.Local.class;
        Expression<DecodedT> build2 = ExpressionBuilderUtilsKt.build(expressionBuilder, Reflection.getOrCreateKotlinClass(cls), localImageLocatorCodec, args);
        Expression<DecodedT> build3 = ExpressionBuilderUtilsKt.build(this.errorPlaceholder, Reflection.getOrCreateKotlinClass(cls), localImageLocatorCodec, args);
        Expression<DecodedT> build4 = ExpressionBuilderUtilsKt.build(this.contentMode, Reflection.getOrCreateKotlinClass(ImageContentMode.class), ImageContentModeCodec.INSTANCE, args);
        ExpressionBuilder<LogicalPixel> expressionBuilder2 = this.cornerRadiusTopLeft;
        LogicalPixelCodec logicalPixelCodec = LogicalPixelCodec.INSTANCE;
        Class<LogicalPixel> cls2 = LogicalPixel.class;
        return new ImageModel(build, build2, build3, build4, ExpressionBuilderUtilsKt.build(expressionBuilder2, Reflection.getOrCreateKotlinClass(cls2), logicalPixelCodec, args), ExpressionBuilderUtilsKt.build(this.cornerRadiusTopRight, Reflection.getOrCreateKotlinClass(cls2), logicalPixelCodec, args), ExpressionBuilderUtilsKt.build(this.cornerRadiusBottomRight, Reflection.getOrCreateKotlinClass(cls2), logicalPixelCodec, args), ExpressionBuilderUtilsKt.build(this.cornerRadiusBottomLeft, Reflection.getOrCreateKotlinClass(cls2), logicalPixelCodec, args), a(args));
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ImageModelBuilder(Function1 function1, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? AnonymousClass1.INSTANCE : function1);
    }

    public ImageModelBuilder(@NotNull Function1<? super ImageModelBuilder, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "init");
        this.init = function1;
        this.cornerRadiusAll$delegate = new WidgetModelBuilderDelegates.PropertyGroup(new KMutableProperty0[]{new MutablePropertyReference0Impl(this) {
            @Nullable
            public Object get() {
                return ((ImageModelBuilder) this.receiver).cornerRadius;
            }

            public void set(@Nullable Object obj) {
                ((ImageModelBuilder) this.receiver).cornerRadius = (ExpressionBuilder) obj;
            }
        }, new MutablePropertyReference0Impl(this) {
            @Nullable
            public Object get() {
                return ((ImageModelBuilder) this.receiver).getCornerRadiusTopLeft();
            }

            public void set(@Nullable Object obj) {
                ((ImageModelBuilder) this.receiver).setCornerRadiusTopLeft((ExpressionBuilder) obj);
            }
        }, new MutablePropertyReference0Impl(this) {
            @Nullable
            public Object get() {
                return ((ImageModelBuilder) this.receiver).getCornerRadiusTopRight();
            }

            public void set(@Nullable Object obj) {
                ((ImageModelBuilder) this.receiver).setCornerRadiusTopRight((ExpressionBuilder) obj);
            }
        }, new MutablePropertyReference0Impl(this) {
            @Nullable
            public Object get() {
                return ((ImageModelBuilder) this.receiver).getCornerRadiusBottomRight();
            }

            public void set(@Nullable Object obj) {
                ((ImageModelBuilder) this.receiver).setCornerRadiusBottomRight((ExpressionBuilder) obj);
            }
        }, new MutablePropertyReference0Impl(this) {
            @Nullable
            public Object get() {
                return ((ImageModelBuilder) this.receiver).getCornerRadiusBottomLeft();
            }

            public void set(@Nullable Object obj) {
                ((ImageModelBuilder) this.receiver).setCornerRadiusBottomLeft((ExpressionBuilder) obj);
            }
        }}, new ImageModelBuilder$cornerRadiusAll$7(this));
        function1.invoke(this);
    }
}
