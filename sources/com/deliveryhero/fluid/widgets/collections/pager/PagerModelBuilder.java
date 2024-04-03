package com.deliveryhero.fluid.widgets.collections.pager;

import com.braze.ui.actions.brazeactions.steps.StepData;
import com.deliveryhero.fluid.expression.Expression;
import com.deliveryhero.fluid.expression.ExpressionBuilder;
import com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer;
import com.deliveryhero.fluid.expression.utils.ExpressionBuilderUtilsKt;
import com.deliveryhero.fluid.values.Color;
import com.deliveryhero.fluid.values.Color$$serializer;
import com.deliveryhero.fluid.values.LogicalPixel;
import com.deliveryhero.fluid.values.LogicalPixel$$serializer;
import com.deliveryhero.fluid.values.codecs.composite.PagerCellsCodec;
import com.deliveryhero.fluid.values.codecs.scalar.BooleanCodec;
import com.deliveryhero.fluid.values.codecs.scalar.ColorCodec;
import com.deliveryhero.fluid.values.codecs.scalar.IntegerCodec;
import com.deliveryhero.fluid.values.codecs.scalar.LogicalPixelCodec;
import com.deliveryhero.fluid.versioning.CoreContract;
import com.deliveryhero.fluid.widgets.collections.CollectionModelBuilder;
import com.deliveryhero.fluid.widgets.collections.pager.indicators.PagerDotsIndicatorModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.ContextualSerializer;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.Transient;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.IntSerializer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0017\u0018\u0000 m2\u00020\u0001:\u0002lmB\u0006\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0010\b\u0001\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\u0010\b\u0001\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f\u0012\u0010\b\u0001\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f\u0012\u0010\b\u0001\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\f\u0012\u0010\b\u0001\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f\u0012\u0010\b\u0001\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f\u0012\u0016\b\u0001\u0010\u0013\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\f\u0018\u00010\u0014\u0012\u0010\b\u0001\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\f\u0012\u0010\b\u0001\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\f\u0012\u0010\b\u0001\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\f\u0012\u0010\b\u0001\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\f\u0012\u0010\b\u0001\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\f\u0012\u0010\b\u0001\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\f\u0012\u0010\b\u0001\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\f\u0012\u0010\b\u0001\u0010 \u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\f\u0012\u0010\b\u0001\u0010!\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\f\u0012\u0010\b\u0001\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\f\u0012\u0010\b\u0001\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\f\u0012\u0010\b\u0001\u0010$\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\f\u0012\u0010\b\u0001\u0010%\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\f\u0012\u0010\b\u0001\u0010&\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\f\u0012\u0010\b\u0001\u0010'\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\f\u0012\u0010\b\u0001\u0010(\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\f\u0012\u0010\b\u0001\u0010)\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\f\u0012\u0010\b\u0001\u0010*\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\f\u0012\u0010\b\u0001\u0010+\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\f\u0012\u0010\b\u0001\u0010,\u001a\n\u0012\u0004\u0012\u00020-\u0018\u00010\f\u0012\u0010\b\u0001\u0010.\u001a\n\u0012\u0004\u0012\u00020/\u0018\u00010\f\u0012\u0010\b\u0001\u00100\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\f\u0012\u0010\b\u0001\u00101\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\f\u0012\u0010\b\u0001\u00102\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\f\u0012\u0010\b\u0001\u00103\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\f\u0012\u001b\b\u0001\u00104\u001a\u0015\u0012\u000f\u0012\r\u0012\t\u0012\u000705¢\u0006\u0002\b60\u0014\u0018\u00010\f\u0012\u0010\b\u0001\u00107\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\f\u0012\u0010\b\u0001\u00108\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\f\u0012\u0010\b\u0001\u00109\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\f\u0012\u0010\b\u0001\u0010:\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\f\u0012\u0010\b\u0001\u0010;\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\f\u0012\u0010\b\u0001\u0010<\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\f\u0012\u0010\b\u0001\u0010=\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f\u0012\b\u0010>\u001a\u0004\u0018\u00010?¢\u0006\u0002\u0010@B \u0012\u0019\b\u0002\u0010A\u001a\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020C0B¢\u0006\u0002\bD¢\u0006\u0002\u0010EJ\u0010\u0010b\u001a\u00020c2\u0006\u0010d\u001a\u00020eH\u0016J!\u0010f\u001a\u00020C2\u0006\u0010g\u001a\u00020\u00002\u0006\u0010h\u001a\u00020i2\u0006\u0010j\u001a\u00020kHÇ\u0001R,\u0010=\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f8\u0006@\u0006X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bF\u0010G\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR,\u0010<\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\f8\u0006@\u0006X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bL\u0010G\u001a\u0004\bM\u0010I\"\u0004\bN\u0010KR7\u00104\u001a\u0015\u0012\u000f\u0012\r\u0012\t\u0012\u000705¢\u0006\u0002\b60\u0014\u0018\u00010\f8\u0006@\u0006X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bO\u0010G\u001a\u0004\bP\u0010I\"\u0004\bQ\u0010KR,\u00107\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\f8\u0006@\u0006X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bR\u0010G\u001a\u0004\bS\u0010I\"\u0004\bT\u0010KR,\u00108\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\f8\u0006@\u0006X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bU\u0010G\u001a\u0004\bV\u0010I\"\u0004\bW\u0010KR,\u00109\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\f8\u0006@\u0006X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bX\u0010G\u001a\u0004\bY\u0010I\"\u0004\bZ\u0010KR,\u0010:\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\f8\u0006@\u0006X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b[\u0010G\u001a\u0004\b\\\u0010I\"\u0004\b]\u0010KR,\u0010;\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\f8\u0006@\u0006X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b^\u0010G\u001a\u0004\b_\u0010I\"\u0004\b`\u0010KR'\u0010A\u001a\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020C0B¢\u0006\u0002\bD8\u0002X\u0004¢\u0006\b\n\u0000\u0012\u0004\ba\u0010G¨\u0006nå\b\u0005å\b\u0007å\b\bå\b\u000bå\b\u000eå\b\u000få\b\u0011å\b\u0012å\b\u0013å\b\u0016å\b\u0018å\b\u001aå\b\u001cå\b\u001då\b\u001eå\b\u001få\b å\b!å\b\"å\b#å\b$å\b%å\b&å\b'å\b(å\b)å\b*å\b+å\b,å\b.å\b0å\b1å\b2å\b3å\b4å\b7å\b8å\b9å\b:å\b;å\b<å\b="}, d2 = {"Lcom/deliveryhero/fluid/widgets/collections/pager/PagerModelBuilder;", "Lcom/deliveryhero/fluid/widgets/collections/CollectionModelBuilder;", "seen1", "", "seen2", "id", "", "hash", "placeholders", "", "Lcom/deliveryhero/fluid/expression/placeholder/PlaceholderSurrogate;", "width", "Lcom/deliveryhero/fluid/expression/ExpressionBuilder;", "Lcom/deliveryhero/fluid/values/Size;", "height", "isVisible", "", "expansionResistancePriority", "compressionResistancePriority", "backgroundColors", "", "Lcom/deliveryhero/fluid/values/Color;", "backgroundShape", "Lcom/deliveryhero/fluid/values/Shape;", "backgroundLinearGradientOrientation", "Lcom/deliveryhero/fluid/values/LinearGradientOrientation;", "backgroundCornerRadiusTopLeft", "Lcom/deliveryhero/fluid/values/LogicalPixel;", "backgroundCornerRadiusTopRight", "backgroundCornerRadiusBottomRight", "backgroundCornerRadiusBottomLeft", "backgroundRadius", "borderWidth", "borderColor", "elevation", "clipToBounds", "paddingLeading", "paddingTop", "paddingTrailing", "paddingBottom", "marginLeading", "marginTop", "marginTrailing", "marginBottom", "horizontalAlignment", "Lcom/deliveryhero/fluid/widgets/containers/HorizontalAlignment;", "verticalAlignment", "Lcom/deliveryhero/fluid/widgets/containers/VerticalAlignment;", "accessibilityId", "accessibilityLabel", "onClick", "cellSpacing", "cells", "Lcom/deliveryhero/fluid/widgets/collections/pager/PagerCell;", "Lkotlinx/serialization/Contextual;", "indicatorActiveColor", "indicatorInactiveColor", "indicatorPagerSpacing", "indicatorSize", "indicatorSpacing", "autoScrollEnabled", "autoScrollDelayInMillis", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IILjava/lang/String;Ljava/lang/String;Ljava/util/Set;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Ljava/util/List;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "init", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function1;)V", "getAutoScrollDelayInMillis$annotations", "()V", "getAutoScrollDelayInMillis", "()Lcom/deliveryhero/fluid/expression/ExpressionBuilder;", "setAutoScrollDelayInMillis", "(Lcom/deliveryhero/fluid/expression/ExpressionBuilder;)V", "getAutoScrollEnabled$annotations", "getAutoScrollEnabled", "setAutoScrollEnabled", "getCells$annotations", "getCells", "setCells", "getIndicatorActiveColor$annotations", "getIndicatorActiveColor", "setIndicatorActiveColor", "getIndicatorInactiveColor$annotations", "getIndicatorInactiveColor", "setIndicatorInactiveColor", "getIndicatorPagerSpacing$annotations", "getIndicatorPagerSpacing", "setIndicatorPagerSpacing", "getIndicatorSize$annotations", "getIndicatorSize", "setIndicatorSize", "getIndicatorSpacing$annotations", "getIndicatorSpacing", "setIndicatorSpacing", "getInit$annotations", "build", "Lcom/deliveryhero/fluid/widgets/collections/pager/PagerModel;", "args", "Lcom/deliveryhero/fluid/expression/ExpressionBuilder$Args;", "write$Self", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "$serializer", "Companion", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Serializable
@CoreContract.CreatedOn(version = CoreContract.Version.V1)
@SerialName("pager")
public class PagerModelBuilder extends CollectionModelBuilder {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @Nullable
    private ExpressionBuilder<Integer> autoScrollDelayInMillis;
    @Nullable
    private ExpressionBuilder<Boolean> autoScrollEnabled;
    @Nullable
    private ExpressionBuilder<List<PagerCell>> cells;
    @Nullable
    private ExpressionBuilder<Color> indicatorActiveColor;
    @Nullable
    private ExpressionBuilder<Color> indicatorInactiveColor;
    @Nullable
    private ExpressionBuilder<LogicalPixel> indicatorPagerSpacing;
    @Nullable
    private ExpressionBuilder<LogicalPixel> indicatorSize;
    @Nullable
    private ExpressionBuilder<LogicalPixel> indicatorSpacing;
    @NotNull
    private final Function1<PagerModelBuilder, Unit> init;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/deliveryhero/fluid/widgets/collections/pager/PagerModelBuilder$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/deliveryhero/fluid/widgets/collections/pager/PagerModelBuilder;", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final KSerializer<PagerModelBuilder> serializer() {
            return PagerModelBuilder$$serializer.INSTANCE;
        }
    }

    public PagerModelBuilder() {
        this((Function1) null, 1, (DefaultConstructorMarker) null);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @kotlin.ReplaceWith(expression = "", imports = {}))
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ PagerModelBuilder(int r39, int r40, @com.deliveryhero.fluid.versioning.CoreContract.CreatedOn(version = com.deliveryhero.fluid.versioning.CoreContract.Version.V1) @kotlin.Deprecated(message = "Move when versioning is supported") @kotlinx.serialization.SerialName("id") java.lang.String r41, @com.deliveryhero.fluid.versioning.CoreContract.CreatedOn(version = com.deliveryhero.fluid.versioning.CoreContract.Version.V1) @kotlin.Deprecated(message = "Move when versioning is supported") @kotlinx.serialization.SerialName("hash") java.lang.String r42, @com.deliveryhero.fluid.versioning.CoreContract.CreatedOn(version = com.deliveryhero.fluid.versioning.CoreContract.Version.V1) @kotlin.Deprecated(message = "Move when versioning is supported") @kotlinx.serialization.SerialName("placeholders") java.util.Set r43, @com.deliveryhero.fluid.versioning.CoreContract.CreatedOn(version = com.deliveryhero.fluid.versioning.CoreContract.Version.V1) @kotlinx.serialization.SerialName("width") com.deliveryhero.fluid.expression.ExpressionBuilder r44, @com.deliveryhero.fluid.versioning.CoreContract.CreatedOn(version = com.deliveryhero.fluid.versioning.CoreContract.Version.V1) @kotlinx.serialization.SerialName("height") com.deliveryhero.fluid.expression.ExpressionBuilder r45, @com.deliveryhero.fluid.versioning.CoreContract.CreatedOn(version = com.deliveryhero.fluid.versioning.CoreContract.Version.V1) @kotlinx.serialization.SerialName("is_visible") com.deliveryhero.fluid.expression.ExpressionBuilder r46, @com.deliveryhero.fluid.versioning.CoreContract.CreatedOn(version = com.deliveryhero.fluid.versioning.CoreContract.Version.V1) @kotlinx.serialization.SerialName("expansion_resistance_priority") com.deliveryhero.fluid.expression.ExpressionBuilder r47, @com.deliveryhero.fluid.versioning.CoreContract.CreatedOn(version = com.deliveryhero.fluid.versioning.CoreContract.Version.V1) @kotlinx.serialization.SerialName("compression_resistance_priority") com.deliveryhero.fluid.expression.ExpressionBuilder r48, @com.deliveryhero.fluid.versioning.CoreContract.CreatedOn(version = com.deliveryhero.fluid.versioning.CoreContract.Version.V1) @kotlinx.serialization.SerialName("background_colors") java.util.List r49, @com.deliveryhero.fluid.versioning.CoreContract.CreatedOn(version = com.deliveryhero.fluid.versioning.CoreContract.Version.V1) @kotlinx.serialization.SerialName("background_shape") com.deliveryhero.fluid.expression.ExpressionBuilder r50, @com.deliveryhero.fluid.versioning.CoreContract.CreatedOn(version = com.deliveryhero.fluid.versioning.CoreContract.Version.V1) @kotlinx.serialization.SerialName("background_gradient_orientation") com.deliveryhero.fluid.expression.ExpressionBuilder r51, @com.deliveryhero.fluid.versioning.CoreContract.CreatedOn(version = com.deliveryhero.fluid.versioning.CoreContract.Version.V1) @kotlinx.serialization.SerialName("background_radius_top_left") com.deliveryhero.fluid.expression.ExpressionBuilder r52, @com.deliveryhero.fluid.versioning.CoreContract.CreatedOn(version = com.deliveryhero.fluid.versioning.CoreContract.Version.V1) @kotlinx.serialization.SerialName("background_radius_top_right") com.deliveryhero.fluid.expression.ExpressionBuilder r53, @com.deliveryhero.fluid.versioning.CoreContract.CreatedOn(version = com.deliveryhero.fluid.versioning.CoreContract.Version.V1) @kotlinx.serialization.SerialName("background_radius_bottom_right") com.deliveryhero.fluid.expression.ExpressionBuilder r54, @com.deliveryhero.fluid.versioning.CoreContract.CreatedOn(version = com.deliveryhero.fluid.versioning.CoreContract.Version.V1) @kotlinx.serialization.SerialName("background_radius_bottom_left") com.deliveryhero.fluid.expression.ExpressionBuilder r55, @com.deliveryhero.fluid.versioning.CoreContract.CreatedOn(version = com.deliveryhero.fluid.versioning.CoreContract.Version.V1) @kotlin.Deprecated(message = "Use backgroundCornerRadiusAll or corner specific background radii instead") @com.deliveryhero.fluid.versioning.CoreContract.DeprecatedOn(version = com.deliveryhero.fluid.versioning.CoreContract.Version.V2) @kotlinx.serialization.SerialName("background_radius") com.deliveryhero.fluid.expression.ExpressionBuilder r56, @com.deliveryhero.fluid.versioning.CoreContract.CreatedOn(version = com.deliveryhero.fluid.versioning.CoreContract.Version.V1) @kotlinx.serialization.SerialName("border_width") com.deliveryhero.fluid.expression.ExpressionBuilder r57, @com.deliveryhero.fluid.versioning.CoreContract.CreatedOn(version = com.deliveryhero.fluid.versioning.CoreContract.Version.V1) @kotlinx.serialization.SerialName("border_color") com.deliveryhero.fluid.expression.ExpressionBuilder r58, @com.deliveryhero.fluid.versioning.CoreContract.CreatedOn(version = com.deliveryhero.fluid.versioning.CoreContract.Version.V1) @kotlinx.serialization.SerialName("elevation") com.deliveryhero.fluid.expression.ExpressionBuilder r59, @com.deliveryhero.fluid.versioning.CoreContract.CreatedOn(version = com.deliveryhero.fluid.versioning.CoreContract.Version.V1) @kotlinx.serialization.SerialName("clip_to_bounds") com.deliveryhero.fluid.expression.ExpressionBuilder r60, @com.deliveryhero.fluid.versioning.CoreContract.CreatedOn(version = com.deliveryhero.fluid.versioning.CoreContract.Version.V1) @kotlinx.serialization.SerialName("padding_leading") com.deliveryhero.fluid.expression.ExpressionBuilder r61, @com.deliveryhero.fluid.versioning.CoreContract.CreatedOn(version = com.deliveryhero.fluid.versioning.CoreContract.Version.V1) @kotlinx.serialization.SerialName("padding_top") com.deliveryhero.fluid.expression.ExpressionBuilder r62, @com.deliveryhero.fluid.versioning.CoreContract.CreatedOn(version = com.deliveryhero.fluid.versioning.CoreContract.Version.V1) @kotlinx.serialization.SerialName("padding_trailing") com.deliveryhero.fluid.expression.ExpressionBuilder r63, @com.deliveryhero.fluid.versioning.CoreContract.CreatedOn(version = com.deliveryhero.fluid.versioning.CoreContract.Version.V1) @kotlinx.serialization.SerialName("padding_bottom") com.deliveryhero.fluid.expression.ExpressionBuilder r64, @com.deliveryhero.fluid.versioning.CoreContract.CreatedOn(version = com.deliveryhero.fluid.versioning.CoreContract.Version.V1) @kotlinx.serialization.SerialName("margin_leading") com.deliveryhero.fluid.expression.ExpressionBuilder r65, @com.deliveryhero.fluid.versioning.CoreContract.CreatedOn(version = com.deliveryhero.fluid.versioning.CoreContract.Version.V1) @kotlinx.serialization.SerialName("margin_top") com.deliveryhero.fluid.expression.ExpressionBuilder r66, @com.deliveryhero.fluid.versioning.CoreContract.CreatedOn(version = com.deliveryhero.fluid.versioning.CoreContract.Version.V1) @kotlinx.serialization.SerialName("margin_trailing") com.deliveryhero.fluid.expression.ExpressionBuilder r67, @com.deliveryhero.fluid.versioning.CoreContract.CreatedOn(version = com.deliveryhero.fluid.versioning.CoreContract.Version.V1) @kotlinx.serialization.SerialName("margin_bottom") com.deliveryhero.fluid.expression.ExpressionBuilder r68, @com.deliveryhero.fluid.versioning.CoreContract.CreatedOn(version = com.deliveryhero.fluid.versioning.CoreContract.Version.V1) @kotlinx.serialization.SerialName("horizontal_alignment") com.deliveryhero.fluid.expression.ExpressionBuilder r69, @com.deliveryhero.fluid.versioning.CoreContract.CreatedOn(version = com.deliveryhero.fluid.versioning.CoreContract.Version.V1) @kotlinx.serialization.SerialName("vertical_alignment") com.deliveryhero.fluid.expression.ExpressionBuilder r70, @com.deliveryhero.fluid.versioning.CoreContract.CreatedOn(version = com.deliveryhero.fluid.versioning.CoreContract.Version.V1) @kotlinx.serialization.SerialName("accessibility_tag") com.deliveryhero.fluid.expression.ExpressionBuilder r71, @com.deliveryhero.fluid.versioning.CoreContract.CreatedOn(version = com.deliveryhero.fluid.versioning.CoreContract.Version.V1) @kotlinx.serialization.SerialName("accessibility_label") com.deliveryhero.fluid.expression.ExpressionBuilder r72, @com.deliveryhero.fluid.versioning.CoreContract.CreatedOn(version = com.deliveryhero.fluid.versioning.CoreContract.Version.V1) @kotlinx.serialization.SerialName("on_click") com.deliveryhero.fluid.expression.ExpressionBuilder r73, @com.deliveryhero.fluid.versioning.CoreContract.CreatedOn(version = com.deliveryhero.fluid.versioning.CoreContract.Version.V1) @kotlinx.serialization.SerialName("item_spacing") com.deliveryhero.fluid.expression.ExpressionBuilder r74, @com.deliveryhero.fluid.versioning.CoreContract.CreatedOn(version = com.deliveryhero.fluid.versioning.CoreContract.Version.V1) @kotlinx.serialization.SerialName("cells") com.deliveryhero.fluid.expression.ExpressionBuilder r75, @com.deliveryhero.fluid.versioning.CoreContract.CreatedOn(version = com.deliveryhero.fluid.versioning.CoreContract.Version.V1) @kotlinx.serialization.SerialName("indicator_active_color") com.deliveryhero.fluid.expression.ExpressionBuilder r76, @com.deliveryhero.fluid.versioning.CoreContract.CreatedOn(version = com.deliveryhero.fluid.versioning.CoreContract.Version.V1) @kotlinx.serialization.SerialName("indicator_inactive_color") com.deliveryhero.fluid.expression.ExpressionBuilder r77, @com.deliveryhero.fluid.versioning.CoreContract.CreatedOn(version = com.deliveryhero.fluid.versioning.CoreContract.Version.V1) @kotlinx.serialization.SerialName("indicator_pager_spacing") com.deliveryhero.fluid.expression.ExpressionBuilder r78, @com.deliveryhero.fluid.versioning.CoreContract.CreatedOn(version = com.deliveryhero.fluid.versioning.CoreContract.Version.V1) @kotlinx.serialization.SerialName("indicator_size") com.deliveryhero.fluid.expression.ExpressionBuilder r79, @com.deliveryhero.fluid.versioning.CoreContract.CreatedOn(version = com.deliveryhero.fluid.versioning.CoreContract.Version.V1) @kotlinx.serialization.SerialName("indicator_spacing") com.deliveryhero.fluid.expression.ExpressionBuilder r80, @com.deliveryhero.fluid.versioning.CoreContract.CreatedOn(version = com.deliveryhero.fluid.versioning.CoreContract.Version.V1) @kotlinx.serialization.SerialName("auto_scroll_enabled") com.deliveryhero.fluid.expression.ExpressionBuilder r81, @com.deliveryhero.fluid.versioning.CoreContract.CreatedOn(version = com.deliveryhero.fluid.versioning.CoreContract.Version.V1) @kotlinx.serialization.SerialName("auto_scroll_delay_millis") com.deliveryhero.fluid.expression.ExpressionBuilder r82, kotlinx.serialization.internal.SerializationConstructorMarker r83) {
        /*
            r38 = this;
            r15 = r38
            r14 = r40
            r0 = r39 & 0
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
            r3[r2] = r39
            r3[r1] = r14
            int[] r0 = new int[r0]
            r0 = {0, 0} // fill-array
            com.deliveryhero.fluid.widgets.collections.pager.PagerModelBuilder$$serializer r1 = com.deliveryhero.fluid.widgets.collections.pager.PagerModelBuilder$$serializer.INSTANCE
            kotlinx.serialization.descriptors.SerialDescriptor r1 = r1.getDescriptor()
            kotlinx.serialization.internal.PluginExceptionsKt.throwArrayMissingFieldException(r3, r0, r1)
        L_0x002c:
            r0 = r38
            r1 = r39
            r2 = r40
            r3 = r41
            r4 = r42
            r5 = r43
            r6 = r44
            r7 = r45
            r8 = r46
            r9 = r47
            r10 = r48
            r11 = r49
            r12 = r50
            r13 = r51
            r14 = r52
            r15 = r53
            r16 = r54
            r17 = r55
            r18 = r56
            r19 = r57
            r20 = r58
            r21 = r59
            r22 = r60
            r23 = r61
            r24 = r62
            r25 = r63
            r26 = r64
            r27 = r65
            r28 = r66
            r29 = r67
            r30 = r68
            r31 = r69
            r32 = r70
            r33 = r71
            r34 = r72
            r35 = r73
            r36 = r74
            r37 = r83
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37)
            com.deliveryhero.fluid.widgets.collections.pager.PagerModelBuilder$2 r0 = com.deliveryhero.fluid.widgets.collections.pager.PagerModelBuilder.AnonymousClass2.INSTANCE
            r1 = r38
            r1.init = r0
            r3 = r2 & 4
            r4 = 0
            if (r3 != 0) goto L_0x0089
            r1.cells = r4
            goto L_0x008d
        L_0x0089:
            r3 = r75
            r1.cells = r3
        L_0x008d:
            r3 = r2 & 8
            if (r3 != 0) goto L_0x0094
            r1.indicatorActiveColor = r4
            goto L_0x0098
        L_0x0094:
            r3 = r76
            r1.indicatorActiveColor = r3
        L_0x0098:
            r3 = r2 & 16
            if (r3 != 0) goto L_0x009f
            r1.indicatorInactiveColor = r4
            goto L_0x00a3
        L_0x009f:
            r3 = r77
            r1.indicatorInactiveColor = r3
        L_0x00a3:
            r3 = r2 & 32
            if (r3 != 0) goto L_0x00aa
            r1.indicatorPagerSpacing = r4
            goto L_0x00ae
        L_0x00aa:
            r3 = r78
            r1.indicatorPagerSpacing = r3
        L_0x00ae:
            r3 = r2 & 64
            if (r3 != 0) goto L_0x00b5
            r1.indicatorSize = r4
            goto L_0x00b9
        L_0x00b5:
            r3 = r79
            r1.indicatorSize = r3
        L_0x00b9:
            r3 = r2 & 128(0x80, float:1.794E-43)
            if (r3 != 0) goto L_0x00c0
            r1.indicatorSpacing = r4
            goto L_0x00c4
        L_0x00c0:
            r3 = r80
            r1.indicatorSpacing = r3
        L_0x00c4:
            r3 = r2 & 256(0x100, float:3.59E-43)
            if (r3 != 0) goto L_0x00cb
            r1.autoScrollEnabled = r4
            goto L_0x00cf
        L_0x00cb:
            r3 = r81
            r1.autoScrollEnabled = r3
        L_0x00cf:
            r2 = r2 & 512(0x200, float:7.175E-43)
            if (r2 != 0) goto L_0x00d6
            r1.autoScrollDelayInMillis = r4
            goto L_0x00da
        L_0x00d6:
            r2 = r82
            r1.autoScrollDelayInMillis = r2
        L_0x00da:
            r0.invoke(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.deliveryhero.fluid.widgets.collections.pager.PagerModelBuilder.<init>(int, int, java.lang.String, java.lang.String, java.util.Set, com.deliveryhero.fluid.expression.ExpressionBuilder, com.deliveryhero.fluid.expression.ExpressionBuilder, com.deliveryhero.fluid.expression.ExpressionBuilder, com.deliveryhero.fluid.expression.ExpressionBuilder, com.deliveryhero.fluid.expression.ExpressionBuilder, java.util.List, com.deliveryhero.fluid.expression.ExpressionBuilder, com.deliveryhero.fluid.expression.ExpressionBuilder, com.deliveryhero.fluid.expression.ExpressionBuilder, com.deliveryhero.fluid.expression.ExpressionBuilder, com.deliveryhero.fluid.expression.ExpressionBuilder, com.deliveryhero.fluid.expression.ExpressionBuilder, com.deliveryhero.fluid.expression.ExpressionBuilder, com.deliveryhero.fluid.expression.ExpressionBuilder, com.deliveryhero.fluid.expression.ExpressionBuilder, com.deliveryhero.fluid.expression.ExpressionBuilder, com.deliveryhero.fluid.expression.ExpressionBuilder, com.deliveryhero.fluid.expression.ExpressionBuilder, com.deliveryhero.fluid.expression.ExpressionBuilder, com.deliveryhero.fluid.expression.ExpressionBuilder, com.deliveryhero.fluid.expression.ExpressionBuilder, com.deliveryhero.fluid.expression.ExpressionBuilder, com.deliveryhero.fluid.expression.ExpressionBuilder, com.deliveryhero.fluid.expression.ExpressionBuilder, com.deliveryhero.fluid.expression.ExpressionBuilder, com.deliveryhero.fluid.expression.ExpressionBuilder, com.deliveryhero.fluid.expression.ExpressionBuilder, com.deliveryhero.fluid.expression.ExpressionBuilder, com.deliveryhero.fluid.expression.ExpressionBuilder, com.deliveryhero.fluid.expression.ExpressionBuilder, com.deliveryhero.fluid.expression.ExpressionBuilder, com.deliveryhero.fluid.expression.ExpressionBuilder, com.deliveryhero.fluid.expression.ExpressionBuilder, com.deliveryhero.fluid.expression.ExpressionBuilder, com.deliveryhero.fluid.expression.ExpressionBuilder, com.deliveryhero.fluid.expression.ExpressionBuilder, com.deliveryhero.fluid.expression.ExpressionBuilder, com.deliveryhero.fluid.expression.ExpressionBuilder, com.deliveryhero.fluid.expression.ExpressionBuilder, kotlinx.serialization.internal.SerializationConstructorMarker):void");
    }

    @CoreContract.CreatedOn(version = CoreContract.Version.V1)
    @SerialName("auto_scroll_delay_millis")
    public static /* synthetic */ void getAutoScrollDelayInMillis$annotations() {
    }

    @CoreContract.CreatedOn(version = CoreContract.Version.V1)
    @SerialName("auto_scroll_enabled")
    public static /* synthetic */ void getAutoScrollEnabled$annotations() {
    }

    @CoreContract.CreatedOn(version = CoreContract.Version.V1)
    @SerialName("cells")
    public static /* synthetic */ void getCells$annotations() {
    }

    @CoreContract.CreatedOn(version = CoreContract.Version.V1)
    @SerialName("indicator_active_color")
    public static /* synthetic */ void getIndicatorActiveColor$annotations() {
    }

    @CoreContract.CreatedOn(version = CoreContract.Version.V1)
    @SerialName("indicator_inactive_color")
    public static /* synthetic */ void getIndicatorInactiveColor$annotations() {
    }

    @CoreContract.CreatedOn(version = CoreContract.Version.V1)
    @SerialName("indicator_pager_spacing")
    public static /* synthetic */ void getIndicatorPagerSpacing$annotations() {
    }

    @CoreContract.CreatedOn(version = CoreContract.Version.V1)
    @SerialName("indicator_size")
    public static /* synthetic */ void getIndicatorSize$annotations() {
    }

    @CoreContract.CreatedOn(version = CoreContract.Version.V1)
    @SerialName("indicator_spacing")
    public static /* synthetic */ void getIndicatorSpacing$annotations() {
    }

    @Transient
    private static /* synthetic */ void getInit$annotations() {
    }

    @JvmStatic
    public static final void write$Self(@NotNull PagerModelBuilder pagerModelBuilder, @NotNull CompositeEncoder compositeEncoder, @NotNull SerialDescriptor serialDescriptor) {
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        boolean z15;
        boolean z16;
        boolean z17;
        Intrinsics.checkNotNullParameter(pagerModelBuilder, "self");
        Intrinsics.checkNotNullParameter(compositeEncoder, "output");
        Intrinsics.checkNotNullParameter(serialDescriptor, "serialDesc");
        CollectionModelBuilder.write$Self(pagerModelBuilder, compositeEncoder, serialDescriptor);
        boolean z18 = false;
        if (!compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 34) && pagerModelBuilder.cells == null) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (z11) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 34, new ExpressionBuilderSerializer(new ArrayListSerializer(new ContextualSerializer(Reflection.getOrCreateKotlinClass(PagerCell.class), (KSerializer) null, new KSerializer[0]))), pagerModelBuilder.cells);
        }
        if (!compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 35) && pagerModelBuilder.indicatorActiveColor == null) {
            z12 = false;
        } else {
            z12 = true;
        }
        if (z12) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 35, new ExpressionBuilderSerializer(Color$$serializer.INSTANCE), pagerModelBuilder.indicatorActiveColor);
        }
        if (!compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 36) && pagerModelBuilder.indicatorInactiveColor == null) {
            z13 = false;
        } else {
            z13 = true;
        }
        if (z13) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 36, new ExpressionBuilderSerializer(Color$$serializer.INSTANCE), pagerModelBuilder.indicatorInactiveColor);
        }
        if (!compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 37) && pagerModelBuilder.indicatorPagerSpacing == null) {
            z14 = false;
        } else {
            z14 = true;
        }
        if (z14) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 37, new ExpressionBuilderSerializer(LogicalPixel$$serializer.INSTANCE), pagerModelBuilder.indicatorPagerSpacing);
        }
        if (!compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 38) && pagerModelBuilder.indicatorSize == null) {
            z15 = false;
        } else {
            z15 = true;
        }
        if (z15) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 38, new ExpressionBuilderSerializer(LogicalPixel$$serializer.INSTANCE), pagerModelBuilder.indicatorSize);
        }
        if (!compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 39) && pagerModelBuilder.indicatorSpacing == null) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 39, new ExpressionBuilderSerializer(LogicalPixel$$serializer.INSTANCE), pagerModelBuilder.indicatorSpacing);
        }
        if (!compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 40) && pagerModelBuilder.autoScrollEnabled == null) {
            z17 = false;
        } else {
            z17 = true;
        }
        if (z17) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 40, new ExpressionBuilderSerializer(BooleanSerializer.INSTANCE), pagerModelBuilder.autoScrollEnabled);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 41) || pagerModelBuilder.autoScrollDelayInMillis != null) {
            z18 = true;
        }
        if (z18) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 41, new ExpressionBuilderSerializer(IntSerializer.INSTANCE), pagerModelBuilder.autoScrollDelayInMillis);
        }
    }

    @Nullable
    public final ExpressionBuilder<Integer> getAutoScrollDelayInMillis() {
        return this.autoScrollDelayInMillis;
    }

    @Nullable
    public final ExpressionBuilder<Boolean> getAutoScrollEnabled() {
        return this.autoScrollEnabled;
    }

    @Nullable
    public final ExpressionBuilder<List<PagerCell>> getCells() {
        return this.cells;
    }

    @Nullable
    public final ExpressionBuilder<Color> getIndicatorActiveColor() {
        return this.indicatorActiveColor;
    }

    @Nullable
    public final ExpressionBuilder<Color> getIndicatorInactiveColor() {
        return this.indicatorInactiveColor;
    }

    @Nullable
    public final ExpressionBuilder<LogicalPixel> getIndicatorPagerSpacing() {
        return this.indicatorPagerSpacing;
    }

    @Nullable
    public final ExpressionBuilder<LogicalPixel> getIndicatorSize() {
        return this.indicatorSize;
    }

    @Nullable
    public final ExpressionBuilder<LogicalPixel> getIndicatorSpacing() {
        return this.indicatorSpacing;
    }

    public final void setAutoScrollDelayInMillis(@Nullable ExpressionBuilder<Integer> expressionBuilder) {
        this.autoScrollDelayInMillis = expressionBuilder;
    }

    public final void setAutoScrollEnabled(@Nullable ExpressionBuilder<Boolean> expressionBuilder) {
        this.autoScrollEnabled = expressionBuilder;
    }

    public final void setCells(@Nullable ExpressionBuilder<List<PagerCell>> expressionBuilder) {
        this.cells = expressionBuilder;
    }

    public final void setIndicatorActiveColor(@Nullable ExpressionBuilder<Color> expressionBuilder) {
        this.indicatorActiveColor = expressionBuilder;
    }

    public final void setIndicatorInactiveColor(@Nullable ExpressionBuilder<Color> expressionBuilder) {
        this.indicatorInactiveColor = expressionBuilder;
    }

    public final void setIndicatorPagerSpacing(@Nullable ExpressionBuilder<LogicalPixel> expressionBuilder) {
        this.indicatorPagerSpacing = expressionBuilder;
    }

    public final void setIndicatorSize(@Nullable ExpressionBuilder<LogicalPixel> expressionBuilder) {
        this.indicatorSize = expressionBuilder;
    }

    public final void setIndicatorSpacing(@Nullable ExpressionBuilder<LogicalPixel> expressionBuilder) {
        this.indicatorSpacing = expressionBuilder;
    }

    @NotNull
    public PagerModel build(@NotNull ExpressionBuilder.Args args) {
        ExpressionBuilder.Args args2 = args;
        Intrinsics.checkNotNullParameter(args2, StepData.ARGS);
        Expression<DecodedT> build = ExpressionBuilderUtilsKt.build(this.autoScrollEnabled, Reflection.getOrCreateKotlinClass(Boolean.class), BooleanCodec.INSTANCE, args2);
        Expression<DecodedT> build2 = ExpressionBuilderUtilsKt.build(this.autoScrollDelayInMillis, Reflection.getOrCreateKotlinClass(Integer.class), IntegerCodec.INSTANCE, args2);
        Expression<DecodedT> build3 = ExpressionBuilderUtilsKt.build(this.cells, Reflection.getOrCreateKotlinClass(List.class), PagerCellsCodec.INSTANCE, args2);
        ExpressionBuilder<LogicalPixel> cellSpacing = getCellSpacing();
        LogicalPixelCodec logicalPixelCodec = LogicalPixelCodec.INSTANCE;
        Class<LogicalPixel> cls = LogicalPixel.class;
        Expression<DecodedT> build4 = ExpressionBuilderUtilsKt.build(cellSpacing, Reflection.getOrCreateKotlinClass(cls), logicalPixelCodec, args2);
        ExpressionBuilder<Color> expressionBuilder = this.indicatorActiveColor;
        ColorCodec colorCodec = ColorCodec.INSTANCE;
        Class<Color> cls2 = Color.class;
        Expression<DecodedT> build5 = ExpressionBuilderUtilsKt.build(expressionBuilder, Reflection.getOrCreateKotlinClass(cls2), colorCodec, args2);
        Expression<DecodedT> build6 = ExpressionBuilderUtilsKt.build(this.indicatorInactiveColor, Reflection.getOrCreateKotlinClass(cls2), colorCodec, args2);
        Expression<DecodedT> build7 = ExpressionBuilderUtilsKt.build(this.indicatorPagerSpacing, Reflection.getOrCreateKotlinClass(cls), logicalPixelCodec, args2);
        Expression<DecodedT> build8 = ExpressionBuilderUtilsKt.build(this.indicatorSize, Reflection.getOrCreateKotlinClass(cls), logicalPixelCodec, args2);
        return new PagerModel(build, build2, build3, build4, new PagerDotsIndicatorModel(build7, ExpressionBuilderUtilsKt.build(this.indicatorSpacing, Reflection.getOrCreateKotlinClass(cls), logicalPixelCodec, args2), build8, build5, build6), a(args));
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PagerModelBuilder(Function1 function1, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? AnonymousClass1.INSTANCE : function1);
    }

    public PagerModelBuilder(@NotNull Function1<? super PagerModelBuilder, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "init");
        this.init = function1;
        function1.invoke(this);
    }
}
