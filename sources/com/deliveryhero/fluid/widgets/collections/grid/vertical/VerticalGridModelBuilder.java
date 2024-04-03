package com.deliveryhero.fluid.widgets.collections.grid.vertical;

import com.braze.ui.actions.brazeactions.steps.StepData;
import com.deliveryhero.fluid.expression.ExpressionBuilder;
import com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer;
import com.deliveryhero.fluid.expression.utils.ExpressionBuilderUtilsKt;
import com.deliveryhero.fluid.values.LogicalPixel;
import com.deliveryhero.fluid.values.codecs.composite.VerticalGridCellsCodec;
import com.deliveryhero.fluid.values.codecs.scalar.LogicalPixelCodec;
import com.deliveryhero.fluid.versioning.CoreContract;
import com.deliveryhero.fluid.widgets.collections.CollectionModelBuilder;
import java.util.List;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
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
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0017\u0018\u0000 Q2\u00020\u0001:\u0002PQB\u0005\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0010\b\u0001\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\u0010\b\u0001\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f\u0012\u0010\b\u0001\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f\u0012\u0010\b\u0001\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\f\u0012\u0010\b\u0001\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f\u0012\u0010\b\u0001\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f\u0012\u0016\b\u0001\u0010\u0013\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\f\u0018\u00010\u0014\u0012\u0010\b\u0001\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\f\u0012\u0010\b\u0001\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\f\u0012\u0010\b\u0001\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\f\u0012\u0010\b\u0001\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\f\u0012\u0010\b\u0001\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\f\u0012\u0010\b\u0001\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\f\u0012\u0010\b\u0001\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\f\u0012\u0010\b\u0001\u0010 \u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\f\u0012\u0010\b\u0001\u0010!\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\f\u0012\u0010\b\u0001\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\f\u0012\u0010\b\u0001\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\f\u0012\u0010\b\u0001\u0010$\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\f\u0012\u0010\b\u0001\u0010%\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\f\u0012\u0010\b\u0001\u0010&\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\f\u0012\u0010\b\u0001\u0010'\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\f\u0012\u0010\b\u0001\u0010(\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\f\u0012\u0010\b\u0001\u0010)\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\f\u0012\u0010\b\u0001\u0010*\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\f\u0012\u0010\b\u0001\u0010+\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\f\u0012\u0010\b\u0001\u0010,\u001a\n\u0012\u0004\u0012\u00020-\u0018\u00010\f\u0012\u0010\b\u0001\u0010.\u001a\n\u0012\u0004\u0012\u00020/\u0018\u00010\f\u0012\u0010\b\u0001\u00100\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\f\u0012\u0010\b\u0001\u00101\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\f\u0012\u0010\b\u0001\u00102\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\f\u0012\u0010\b\u0001\u00103\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\f\u0012\u001b\b\u0001\u00104\u001a\u0015\u0012\u000f\u0012\r\u0012\t\u0012\u000705¢\u0006\u0002\b60\u0014\u0018\u00010\f\u0012\b\u00107\u001a\u0004\u0018\u000108¢\u0006\u0002\u00109B \u0012\u0019\b\u0002\u0010:\u001a\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020<0;¢\u0006\u0002\b=¢\u0006\u0002\u0010>J\u0010\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u00020IH\u0016J!\u0010J\u001a\u00020<2\u0006\u0010K\u001a\u00020\u00002\u0006\u0010L\u001a\u00020M2\u0006\u0010N\u001a\u00020OHÇ\u0001R7\u00104\u001a\u0015\u0012\u000f\u0012\r\u0012\t\u0012\u000705¢\u0006\u0002\b60\u0014\u0018\u00010\f8\u0006@\u0006X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b?\u0010@\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR'\u0010:\u001a\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020<0;¢\u0006\u0002\b=8\u0002X\u0004¢\u0006\b\n\u0000\u0012\u0004\bE\u0010@¨\u0006Rå\b\u0005å\b\u0007å\b\bå\b\u000bå\b\u000eå\b\u000få\b\u0011å\b\u0012å\b\u0013å\b\u0016å\b\u0018å\b\u001aå\b\u001cå\b\u001då\b\u001eå\b\u001få\b å\b!å\b\"å\b#å\b$å\b%å\b&å\b'å\b(å\b)å\b*å\b+å\b,å\b.å\b0å\b1å\b2å\b3å\b4"}, d2 = {"Lcom/deliveryhero/fluid/widgets/collections/grid/vertical/VerticalGridModelBuilder;", "Lcom/deliveryhero/fluid/widgets/collections/CollectionModelBuilder;", "seen1", "", "seen2", "id", "", "hash", "placeholders", "", "Lcom/deliveryhero/fluid/expression/placeholder/PlaceholderSurrogate;", "width", "Lcom/deliveryhero/fluid/expression/ExpressionBuilder;", "Lcom/deliveryhero/fluid/values/Size;", "height", "isVisible", "", "expansionResistancePriority", "compressionResistancePriority", "backgroundColors", "", "Lcom/deliveryhero/fluid/values/Color;", "backgroundShape", "Lcom/deliveryhero/fluid/values/Shape;", "backgroundLinearGradientOrientation", "Lcom/deliveryhero/fluid/values/LinearGradientOrientation;", "backgroundCornerRadiusTopLeft", "Lcom/deliveryhero/fluid/values/LogicalPixel;", "backgroundCornerRadiusTopRight", "backgroundCornerRadiusBottomRight", "backgroundCornerRadiusBottomLeft", "backgroundRadius", "borderWidth", "borderColor", "elevation", "clipToBounds", "paddingLeading", "paddingTop", "paddingTrailing", "paddingBottom", "marginLeading", "marginTop", "marginTrailing", "marginBottom", "horizontalAlignment", "Lcom/deliveryhero/fluid/widgets/containers/HorizontalAlignment;", "verticalAlignment", "Lcom/deliveryhero/fluid/widgets/containers/VerticalAlignment;", "accessibilityId", "accessibilityLabel", "onClick", "cellSpacing", "cells", "Lcom/deliveryhero/fluid/widgets/collections/grid/vertical/VerticalGridCell;", "Lkotlinx/serialization/Contextual;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IILjava/lang/String;Ljava/lang/String;Ljava/util/Set;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Ljava/util/List;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "init", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function1;)V", "getCells$annotations", "()V", "getCells", "()Lcom/deliveryhero/fluid/expression/ExpressionBuilder;", "setCells", "(Lcom/deliveryhero/fluid/expression/ExpressionBuilder;)V", "getInit$annotations", "build", "Lcom/deliveryhero/fluid/widgets/collections/grid/vertical/VerticalGridModel;", "args", "Lcom/deliveryhero/fluid/expression/ExpressionBuilder$Args;", "write$Self", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "$serializer", "Companion", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Serializable
@CoreContract.CreatedOn(version = CoreContract.Version.V1)
@SerialName("vertical_grid")
public class VerticalGridModelBuilder extends CollectionModelBuilder {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @Nullable
    private ExpressionBuilder<List<VerticalGridCell>> cells;
    @NotNull
    private final Function1<VerticalGridModelBuilder, Unit> init;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/deliveryhero/fluid/widgets/collections/grid/vertical/VerticalGridModelBuilder$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/deliveryhero/fluid/widgets/collections/grid/vertical/VerticalGridModelBuilder;", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final KSerializer<VerticalGridModelBuilder> serializer() {
            return VerticalGridModelBuilder$$serializer.INSTANCE;
        }
    }

    public VerticalGridModelBuilder() {
        this((Function1) null, 1, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ VerticalGridModelBuilder(int i11, int i12, @CoreContract.CreatedOn(version = CoreContract.Version.V1) @Deprecated(message = "Move when versioning is supported") @SerialName("id") String str, @CoreContract.CreatedOn(version = CoreContract.Version.V1) @Deprecated(message = "Move when versioning is supported") @SerialName("hash") String str2, @CoreContract.CreatedOn(version = CoreContract.Version.V1) @Deprecated(message = "Move when versioning is supported") @SerialName("placeholders") Set set, @CoreContract.CreatedOn(version = CoreContract.Version.V1) @SerialName("width") ExpressionBuilder expressionBuilder, @CoreContract.CreatedOn(version = CoreContract.Version.V1) @SerialName("height") ExpressionBuilder expressionBuilder2, @CoreContract.CreatedOn(version = CoreContract.Version.V1) @SerialName("is_visible") ExpressionBuilder expressionBuilder3, @CoreContract.CreatedOn(version = CoreContract.Version.V1) @SerialName("expansion_resistance_priority") ExpressionBuilder expressionBuilder4, @CoreContract.CreatedOn(version = CoreContract.Version.V1) @SerialName("compression_resistance_priority") ExpressionBuilder expressionBuilder5, @CoreContract.CreatedOn(version = CoreContract.Version.V1) @SerialName("background_colors") List list, @CoreContract.CreatedOn(version = CoreContract.Version.V1) @SerialName("background_shape") ExpressionBuilder expressionBuilder6, @CoreContract.CreatedOn(version = CoreContract.Version.V1) @SerialName("background_gradient_orientation") ExpressionBuilder expressionBuilder7, @CoreContract.CreatedOn(version = CoreContract.Version.V1) @SerialName("background_radius_top_left") ExpressionBuilder expressionBuilder8, @CoreContract.CreatedOn(version = CoreContract.Version.V1) @SerialName("background_radius_top_right") ExpressionBuilder expressionBuilder9, @CoreContract.CreatedOn(version = CoreContract.Version.V1) @SerialName("background_radius_bottom_right") ExpressionBuilder expressionBuilder10, @CoreContract.CreatedOn(version = CoreContract.Version.V1) @SerialName("background_radius_bottom_left") ExpressionBuilder expressionBuilder11, @CoreContract.CreatedOn(version = CoreContract.Version.V1) @Deprecated(message = "Use backgroundCornerRadiusAll or corner specific background radii instead") @CoreContract.DeprecatedOn(version = CoreContract.Version.V2) @SerialName("background_radius") ExpressionBuilder expressionBuilder12, @CoreContract.CreatedOn(version = CoreContract.Version.V1) @SerialName("border_width") ExpressionBuilder expressionBuilder13, @CoreContract.CreatedOn(version = CoreContract.Version.V1) @SerialName("border_color") ExpressionBuilder expressionBuilder14, @CoreContract.CreatedOn(version = CoreContract.Version.V1) @SerialName("elevation") ExpressionBuilder expressionBuilder15, @CoreContract.CreatedOn(version = CoreContract.Version.V1) @SerialName("clip_to_bounds") ExpressionBuilder expressionBuilder16, @CoreContract.CreatedOn(version = CoreContract.Version.V1) @SerialName("padding_leading") ExpressionBuilder expressionBuilder17, @CoreContract.CreatedOn(version = CoreContract.Version.V1) @SerialName("padding_top") ExpressionBuilder expressionBuilder18, @CoreContract.CreatedOn(version = CoreContract.Version.V1) @SerialName("padding_trailing") ExpressionBuilder expressionBuilder19, @CoreContract.CreatedOn(version = CoreContract.Version.V1) @SerialName("padding_bottom") ExpressionBuilder expressionBuilder20, @CoreContract.CreatedOn(version = CoreContract.Version.V1) @SerialName("margin_leading") ExpressionBuilder expressionBuilder21, @CoreContract.CreatedOn(version = CoreContract.Version.V1) @SerialName("margin_top") ExpressionBuilder expressionBuilder22, @CoreContract.CreatedOn(version = CoreContract.Version.V1) @SerialName("margin_trailing") ExpressionBuilder expressionBuilder23, @CoreContract.CreatedOn(version = CoreContract.Version.V1) @SerialName("margin_bottom") ExpressionBuilder expressionBuilder24, @CoreContract.CreatedOn(version = CoreContract.Version.V1) @SerialName("horizontal_alignment") ExpressionBuilder expressionBuilder25, @CoreContract.CreatedOn(version = CoreContract.Version.V1) @SerialName("vertical_alignment") ExpressionBuilder expressionBuilder26, @CoreContract.CreatedOn(version = CoreContract.Version.V1) @SerialName("accessibility_tag") ExpressionBuilder expressionBuilder27, @CoreContract.CreatedOn(version = CoreContract.Version.V1) @SerialName("accessibility_label") ExpressionBuilder expressionBuilder28, @CoreContract.CreatedOn(version = CoreContract.Version.V1) @SerialName("on_click") ExpressionBuilder expressionBuilder29, @CoreContract.CreatedOn(version = CoreContract.Version.V1) @SerialName("item_spacing") ExpressionBuilder expressionBuilder30, @CoreContract.CreatedOn(version = CoreContract.Version.V1) @SerialName("cells") ExpressionBuilder expressionBuilder31, SerializationConstructorMarker serializationConstructorMarker) {
        super(i11, i12, str, str2, set, expressionBuilder, expressionBuilder2, expressionBuilder3, expressionBuilder4, expressionBuilder5, list, expressionBuilder6, expressionBuilder7, expressionBuilder8, expressionBuilder9, expressionBuilder10, expressionBuilder11, expressionBuilder12, expressionBuilder13, expressionBuilder14, expressionBuilder15, expressionBuilder16, expressionBuilder17, expressionBuilder18, expressionBuilder19, expressionBuilder20, expressionBuilder21, expressionBuilder22, expressionBuilder23, expressionBuilder24, expressionBuilder25, expressionBuilder26, expressionBuilder27, expressionBuilder28, expressionBuilder29, expressionBuilder30, serializationConstructorMarker);
        if (((i11 & 0) != 0) || ((i12 & 0) != 0)) {
            PluginExceptionsKt.throwArrayMissingFieldException(new int[]{i11, i12}, new int[]{0, 0}, VerticalGridModelBuilder$$serializer.INSTANCE.getDescriptor());
        }
        AnonymousClass2 r02 = AnonymousClass2.INSTANCE;
        this.init = r02;
        this.cells = (i12 & 4) == 0 ? null : expressionBuilder31;
        r02.invoke(this);
    }

    @CoreContract.CreatedOn(version = CoreContract.Version.V1)
    @SerialName("cells")
    public static /* synthetic */ void getCells$annotations() {
    }

    @Transient
    private static /* synthetic */ void getInit$annotations() {
    }

    @JvmStatic
    public static final void write$Self(@NotNull VerticalGridModelBuilder verticalGridModelBuilder, @NotNull CompositeEncoder compositeEncoder, @NotNull SerialDescriptor serialDescriptor) {
        Intrinsics.checkNotNullParameter(verticalGridModelBuilder, "self");
        Intrinsics.checkNotNullParameter(compositeEncoder, "output");
        Intrinsics.checkNotNullParameter(serialDescriptor, "serialDesc");
        CollectionModelBuilder.write$Self(verticalGridModelBuilder, compositeEncoder, serialDescriptor);
        boolean z11 = true;
        if (!compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 34) && verticalGridModelBuilder.cells == null) {
            z11 = false;
        }
        if (z11) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 34, new ExpressionBuilderSerializer(new ArrayListSerializer(new ContextualSerializer(Reflection.getOrCreateKotlinClass(VerticalGridCell.class), (KSerializer) null, new KSerializer[0]))), verticalGridModelBuilder.cells);
        }
    }

    @Nullable
    public final ExpressionBuilder<List<VerticalGridCell>> getCells() {
        return this.cells;
    }

    public final void setCells(@Nullable ExpressionBuilder<List<VerticalGridCell>> expressionBuilder) {
        this.cells = expressionBuilder;
    }

    @NotNull
    public VerticalGridModel build(@NotNull ExpressionBuilder.Args args) {
        Intrinsics.checkNotNullParameter(args, StepData.ARGS);
        return new VerticalGridModel(ExpressionBuilderUtilsKt.build(this.cells, Reflection.getOrCreateKotlinClass(List.class), VerticalGridCellsCodec.INSTANCE, args), ExpressionBuilderUtilsKt.build(getCellSpacing(), Reflection.getOrCreateKotlinClass(LogicalPixel.class), LogicalPixelCodec.INSTANCE, args), a(args));
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ VerticalGridModelBuilder(Function1 function1, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? AnonymousClass1.INSTANCE : function1);
    }

    public VerticalGridModelBuilder(@NotNull Function1<? super VerticalGridModelBuilder, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "init");
        this.init = function1;
        function1.invoke(this);
    }
}
