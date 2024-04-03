package com.talabat.fluid.homescreen.ui.widget.orderstatus;

import com.braze.ui.actions.brazeactions.steps.StepData;
import com.deliveryhero.fluid.expression.ExpressionBuilder;
import com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer;
import com.deliveryhero.fluid.expression.utils.ExpressionBuilderUtilsKt;
import com.deliveryhero.fluid.values.LogicalPixel;
import com.deliveryhero.fluid.values.LogicalPixel$$serializer;
import com.deliveryhero.fluid.values.codecs.scalar.LogicalPixelCodec;
import com.deliveryhero.fluid.versioning.CoreContract;
import com.deliveryhero.fluid.widgets.WidgetModel;
import com.deliveryhero.fluid.widgets.WidgetModelBuilder;
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
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.Transient;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0017\u0018\u0000 ^2\u00020\u0001:\u0002]^BÇ\u0005\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0010\b\u0001\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\u0010\b\u0001\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f\u0012\u0010\b\u0001\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f\u0012\u0010\b\u0001\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\f\u0012\u0010\b\u0001\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f\u0012\u0010\b\u0001\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f\u0012\u0016\b\u0001\u0010\u0013\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\f\u0018\u00010\u0014\u0012\u0010\b\u0001\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\f\u0012\u0010\b\u0001\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\f\u0012\u0010\b\u0001\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\f\u0012\u0010\b\u0001\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\f\u0012\u0010\b\u0001\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\f\u0012\u0010\b\u0001\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\f\u0012\u0010\b\u0001\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\f\u0012\u0010\b\u0001\u0010 \u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\f\u0012\u0010\b\u0001\u0010!\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\f\u0012\u0010\b\u0001\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\f\u0012\u0010\b\u0001\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\f\u0012\u0010\b\u0001\u0010$\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\f\u0012\u0010\b\u0001\u0010%\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\f\u0012\u0010\b\u0001\u0010&\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\f\u0012\u0010\b\u0001\u0010'\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\f\u0012\u0010\b\u0001\u0010(\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\f\u0012\u0010\b\u0001\u0010)\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\f\u0012\u0010\b\u0001\u0010*\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\f\u0012\u0010\b\u0001\u0010+\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\f\u0012\u0010\b\u0001\u0010,\u001a\n\u0012\u0004\u0012\u00020-\u0018\u00010\f\u0012\u0010\b\u0001\u0010.\u001a\n\u0012\u0004\u0012\u00020/\u0018\u00010\f\u0012\u0010\b\u0001\u00100\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\f\u0012\u0010\b\u0001\u00101\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\f\u0012\u0010\b\u0001\u00102\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\f\u0012\u0010\b\u0001\u00103\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\f\u0012\u0010\b\u0001\u00104\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\f\u0012\u0010\b\u0001\u00105\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\f\u0012\u0010\b\u0001\u00106\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\f\u0012\u0010\b\u0001\u00107\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\f\u0012\b\u00108\u001a\u0004\u0018\u000109¢\u0006\u0002\u0010:B \u0012\u0019\b\u0002\u0010;\u001a\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020=0<¢\u0006\u0002\b>¢\u0006\u0002\u0010?J\u0010\u0010S\u001a\u00020T2\u0006\u0010U\u001a\u00020VH\u0016J!\u0010W\u001a\u00020=2\u0006\u0010X\u001a\u00020\u00002\u0006\u0010Y\u001a\u00020Z2\u0006\u0010[\u001a\u00020\\HÇ\u0001R'\u0010;\u001a\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020=0<¢\u0006\u0002\b>8\u0002X\u0004¢\u0006\b\n\u0000\u0012\u0004\b@\u0010AR,\u00104\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\f8\u0006@\u0006X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bB\u0010A\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR,\u00105\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\f8\u0006@\u0006X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bG\u0010A\u001a\u0004\bH\u0010D\"\u0004\bI\u0010FR,\u00103\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\f8\u0006@\u0006X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bJ\u0010A\u001a\u0004\bK\u0010D\"\u0004\bL\u0010FR,\u00106\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\f8\u0006@\u0006X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bM\u0010A\u001a\u0004\bN\u0010D\"\u0004\bO\u0010FR,\u00107\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\f8\u0006@\u0006X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bP\u0010A\u001a\u0004\bQ\u0010D\"\u0004\bR\u0010F¨\u0006_å\b\u0005å\b\u0007å\b\bå\b\u000bå\b\u000eå\b\u000få\b\u0011å\b\u0012å\b\u0013å\b\u0016å\b\u0018å\b\u001aå\b\u001cå\b\u001då\b\u001eå\b\u001få\b å\b!å\b\"å\b#å\b$å\b%å\b&å\b'å\b(å\b)å\b*å\b+å\b,å\b.å\b0å\b1å\b2å\b3å\b4å\b5å\b6å\b7"}, d2 = {"Lcom/talabat/fluid/homescreen/ui/widget/orderstatus/OrderStatusModelBuilder;", "Lcom/deliveryhero/fluid/widgets/WidgetModelBuilder;", "seen1", "", "seen2", "id", "", "hash", "placeholders", "", "Lcom/deliveryhero/fluid/expression/placeholder/PlaceholderSurrogate;", "width", "Lcom/deliveryhero/fluid/expression/ExpressionBuilder;", "Lcom/deliveryhero/fluid/values/Size;", "height", "isVisible", "", "expansionResistancePriority", "compressionResistancePriority", "backgroundColors", "", "Lcom/deliveryhero/fluid/values/Color;", "backgroundShape", "Lcom/deliveryhero/fluid/values/Shape;", "backgroundLinearGradientOrientation", "Lcom/deliveryhero/fluid/values/LinearGradientOrientation;", "backgroundCornerRadiusTopLeft", "Lcom/deliveryhero/fluid/values/LogicalPixel;", "backgroundCornerRadiusTopRight", "backgroundCornerRadiusBottomRight", "backgroundCornerRadiusBottomLeft", "backgroundRadius", "borderWidth", "borderColor", "elevation", "clipToBounds", "paddingLeading", "paddingTop", "paddingTrailing", "paddingBottom", "marginLeading", "marginTop", "marginTrailing", "marginBottom", "horizontalAlignment", "Lcom/deliveryhero/fluid/widgets/containers/HorizontalAlignment;", "verticalAlignment", "Lcom/deliveryhero/fluid/widgets/containers/VerticalAlignment;", "accessibilityId", "accessibilityLabel", "onClick", "itemPaddingTop", "itemPaddingBottom", "itemPaddingLeading", "itemPaddingTrailing", "itemSpacing", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IILjava/lang/String;Ljava/lang/String;Ljava/util/Set;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Ljava/util/List;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "init", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function1;)V", "getInit$annotations", "()V", "getItemPaddingBottom$annotations", "getItemPaddingBottom", "()Lcom/deliveryhero/fluid/expression/ExpressionBuilder;", "setItemPaddingBottom", "(Lcom/deliveryhero/fluid/expression/ExpressionBuilder;)V", "getItemPaddingLeading$annotations", "getItemPaddingLeading", "setItemPaddingLeading", "getItemPaddingTop$annotations", "getItemPaddingTop", "setItemPaddingTop", "getItemPaddingTrailing$annotations", "getItemPaddingTrailing", "setItemPaddingTrailing", "getItemSpacing$annotations", "getItemSpacing", "setItemSpacing", "build", "Lcom/deliveryhero/fluid/widgets/WidgetModel;", "args", "Lcom/deliveryhero/fluid/expression/ExpressionBuilder$Args;", "write$Self", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "$serializer", "Companion", "com_talabat_NewArchi_Homescreen_Homescreen"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Serializable
@SerialName("active_orders")
public class OrderStatusModelBuilder extends WidgetModelBuilder {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private final Function1<OrderStatusModelBuilder, Unit> init;
    @Nullable
    private ExpressionBuilder<LogicalPixel> itemPaddingBottom;
    @Nullable
    private ExpressionBuilder<LogicalPixel> itemPaddingLeading;
    @Nullable
    private ExpressionBuilder<LogicalPixel> itemPaddingTop;
    @Nullable
    private ExpressionBuilder<LogicalPixel> itemPaddingTrailing;
    @Nullable
    private ExpressionBuilder<LogicalPixel> itemSpacing;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/talabat/fluid/homescreen/ui/widget/orderstatus/OrderStatusModelBuilder$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/talabat/fluid/homescreen/ui/widget/orderstatus/OrderStatusModelBuilder;", "com_talabat_NewArchi_Homescreen_Homescreen"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final KSerializer<OrderStatusModelBuilder> serializer() {
            return OrderStatusModelBuilder$$serializer.INSTANCE;
        }
    }

    public OrderStatusModelBuilder() {
        this((Function1) null, 1, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ OrderStatusModelBuilder(int i11, int i12, @CoreContract.CreatedOn(version = CoreContract.Version.V1) @Deprecated(message = "Move when versioning is supported") @SerialName("id") String str, @CoreContract.CreatedOn(version = CoreContract.Version.V1) @Deprecated(message = "Move when versioning is supported") @SerialName("hash") String str2, @CoreContract.CreatedOn(version = CoreContract.Version.V1) @Deprecated(message = "Move when versioning is supported") @SerialName("placeholders") Set set, @CoreContract.CreatedOn(version = CoreContract.Version.V1) @SerialName("width") ExpressionBuilder expressionBuilder, @CoreContract.CreatedOn(version = CoreContract.Version.V1) @SerialName("height") ExpressionBuilder expressionBuilder2, @CoreContract.CreatedOn(version = CoreContract.Version.V1) @SerialName("is_visible") ExpressionBuilder expressionBuilder3, @CoreContract.CreatedOn(version = CoreContract.Version.V1) @SerialName("expansion_resistance_priority") ExpressionBuilder expressionBuilder4, @CoreContract.CreatedOn(version = CoreContract.Version.V1) @SerialName("compression_resistance_priority") ExpressionBuilder expressionBuilder5, @CoreContract.CreatedOn(version = CoreContract.Version.V1) @SerialName("background_colors") List list, @CoreContract.CreatedOn(version = CoreContract.Version.V1) @SerialName("background_shape") ExpressionBuilder expressionBuilder6, @CoreContract.CreatedOn(version = CoreContract.Version.V1) @SerialName("background_gradient_orientation") ExpressionBuilder expressionBuilder7, @CoreContract.CreatedOn(version = CoreContract.Version.V1) @SerialName("background_radius_top_left") ExpressionBuilder expressionBuilder8, @CoreContract.CreatedOn(version = CoreContract.Version.V1) @SerialName("background_radius_top_right") ExpressionBuilder expressionBuilder9, @CoreContract.CreatedOn(version = CoreContract.Version.V1) @SerialName("background_radius_bottom_right") ExpressionBuilder expressionBuilder10, @CoreContract.CreatedOn(version = CoreContract.Version.V1) @SerialName("background_radius_bottom_left") ExpressionBuilder expressionBuilder11, @CoreContract.CreatedOn(version = CoreContract.Version.V1) @Deprecated(message = "Use backgroundCornerRadiusAll or corner specific background radii instead") @CoreContract.DeprecatedOn(version = CoreContract.Version.V2) @SerialName("background_radius") ExpressionBuilder expressionBuilder12, @CoreContract.CreatedOn(version = CoreContract.Version.V1) @SerialName("border_width") ExpressionBuilder expressionBuilder13, @CoreContract.CreatedOn(version = CoreContract.Version.V1) @SerialName("border_color") ExpressionBuilder expressionBuilder14, @CoreContract.CreatedOn(version = CoreContract.Version.V1) @SerialName("elevation") ExpressionBuilder expressionBuilder15, @CoreContract.CreatedOn(version = CoreContract.Version.V1) @SerialName("clip_to_bounds") ExpressionBuilder expressionBuilder16, @CoreContract.CreatedOn(version = CoreContract.Version.V1) @SerialName("padding_leading") ExpressionBuilder expressionBuilder17, @CoreContract.CreatedOn(version = CoreContract.Version.V1) @SerialName("padding_top") ExpressionBuilder expressionBuilder18, @CoreContract.CreatedOn(version = CoreContract.Version.V1) @SerialName("padding_trailing") ExpressionBuilder expressionBuilder19, @CoreContract.CreatedOn(version = CoreContract.Version.V1) @SerialName("padding_bottom") ExpressionBuilder expressionBuilder20, @CoreContract.CreatedOn(version = CoreContract.Version.V1) @SerialName("margin_leading") ExpressionBuilder expressionBuilder21, @CoreContract.CreatedOn(version = CoreContract.Version.V1) @SerialName("margin_top") ExpressionBuilder expressionBuilder22, @CoreContract.CreatedOn(version = CoreContract.Version.V1) @SerialName("margin_trailing") ExpressionBuilder expressionBuilder23, @CoreContract.CreatedOn(version = CoreContract.Version.V1) @SerialName("margin_bottom") ExpressionBuilder expressionBuilder24, @CoreContract.CreatedOn(version = CoreContract.Version.V1) @SerialName("horizontal_alignment") ExpressionBuilder expressionBuilder25, @CoreContract.CreatedOn(version = CoreContract.Version.V1) @SerialName("vertical_alignment") ExpressionBuilder expressionBuilder26, @CoreContract.CreatedOn(version = CoreContract.Version.V1) @SerialName("accessibility_tag") ExpressionBuilder expressionBuilder27, @CoreContract.CreatedOn(version = CoreContract.Version.V1) @SerialName("accessibility_label") ExpressionBuilder expressionBuilder28, @CoreContract.CreatedOn(version = CoreContract.Version.V1) @SerialName("on_click") ExpressionBuilder expressionBuilder29, @SerialName("item_padding_top") ExpressionBuilder expressionBuilder30, @SerialName("item_padding_bottom") ExpressionBuilder expressionBuilder31, @SerialName("item_padding_leading") ExpressionBuilder expressionBuilder32, @SerialName("item_padding_trailing") ExpressionBuilder expressionBuilder33, @SerialName("item_spacing") ExpressionBuilder expressionBuilder34, SerializationConstructorMarker serializationConstructorMarker) {
        super(i11, i12, str, str2, set, expressionBuilder, expressionBuilder2, expressionBuilder3, expressionBuilder4, expressionBuilder5, list, expressionBuilder6, expressionBuilder7, expressionBuilder8, expressionBuilder9, expressionBuilder10, expressionBuilder11, expressionBuilder12, expressionBuilder13, expressionBuilder14, expressionBuilder15, expressionBuilder16, expressionBuilder17, expressionBuilder18, expressionBuilder19, expressionBuilder20, expressionBuilder21, expressionBuilder22, expressionBuilder23, expressionBuilder24, expressionBuilder25, expressionBuilder26, expressionBuilder27, expressionBuilder28, expressionBuilder29, serializationConstructorMarker);
        if (((i11 & 0) != 0) || ((i12 & 0) != 0)) {
            PluginExceptionsKt.throwArrayMissingFieldException(new int[]{i11, i12}, new int[]{0, 0}, OrderStatusModelBuilder$$serializer.INSTANCE.getDescriptor());
        }
        AnonymousClass2 r02 = AnonymousClass2.INSTANCE;
        this.init = r02;
        if ((i12 & 2) == 0) {
            this.itemPaddingTop = null;
        } else {
            this.itemPaddingTop = expressionBuilder30;
        }
        if ((i12 & 4) == 0) {
            this.itemPaddingBottom = null;
        } else {
            this.itemPaddingBottom = expressionBuilder31;
        }
        if ((i12 & 8) == 0) {
            this.itemPaddingLeading = null;
        } else {
            this.itemPaddingLeading = expressionBuilder32;
        }
        if ((i12 & 16) == 0) {
            this.itemPaddingTrailing = null;
        } else {
            this.itemPaddingTrailing = expressionBuilder33;
        }
        if ((i12 & 32) == 0) {
            this.itemSpacing = null;
        } else {
            this.itemSpacing = expressionBuilder34;
        }
        r02.invoke(this);
    }

    @Transient
    private static /* synthetic */ void getInit$annotations() {
    }

    @SerialName("item_padding_bottom")
    public static /* synthetic */ void getItemPaddingBottom$annotations() {
    }

    @SerialName("item_padding_leading")
    public static /* synthetic */ void getItemPaddingLeading$annotations() {
    }

    @SerialName("item_padding_top")
    public static /* synthetic */ void getItemPaddingTop$annotations() {
    }

    @SerialName("item_padding_trailing")
    public static /* synthetic */ void getItemPaddingTrailing$annotations() {
    }

    @SerialName("item_spacing")
    public static /* synthetic */ void getItemSpacing$annotations() {
    }

    @JvmStatic
    public static final void write$Self(@NotNull OrderStatusModelBuilder orderStatusModelBuilder, @NotNull CompositeEncoder compositeEncoder, @NotNull SerialDescriptor serialDescriptor) {
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        Intrinsics.checkNotNullParameter(orderStatusModelBuilder, "self");
        Intrinsics.checkNotNullParameter(compositeEncoder, "output");
        Intrinsics.checkNotNullParameter(serialDescriptor, "serialDesc");
        WidgetModelBuilder.write$Self(orderStatusModelBuilder, compositeEncoder, serialDescriptor);
        boolean z15 = false;
        if (!compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 33) && orderStatusModelBuilder.itemPaddingTop == null) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (z11) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 33, new ExpressionBuilderSerializer(LogicalPixel$$serializer.INSTANCE), orderStatusModelBuilder.itemPaddingTop);
        }
        if (!compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 34) && orderStatusModelBuilder.itemPaddingBottom == null) {
            z12 = false;
        } else {
            z12 = true;
        }
        if (z12) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 34, new ExpressionBuilderSerializer(LogicalPixel$$serializer.INSTANCE), orderStatusModelBuilder.itemPaddingBottom);
        }
        if (!compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 35) && orderStatusModelBuilder.itemPaddingLeading == null) {
            z13 = false;
        } else {
            z13 = true;
        }
        if (z13) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 35, new ExpressionBuilderSerializer(LogicalPixel$$serializer.INSTANCE), orderStatusModelBuilder.itemPaddingLeading);
        }
        if (!compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 36) && orderStatusModelBuilder.itemPaddingTrailing == null) {
            z14 = false;
        } else {
            z14 = true;
        }
        if (z14) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 36, new ExpressionBuilderSerializer(LogicalPixel$$serializer.INSTANCE), orderStatusModelBuilder.itemPaddingTrailing);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 37) || orderStatusModelBuilder.itemSpacing != null) {
            z15 = true;
        }
        if (z15) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 37, new ExpressionBuilderSerializer(LogicalPixel$$serializer.INSTANCE), orderStatusModelBuilder.itemSpacing);
        }
    }

    @NotNull
    public WidgetModel build(@NotNull ExpressionBuilder.Args args) {
        Intrinsics.checkNotNullParameter(args, StepData.ARGS);
        ExpressionBuilder<LogicalPixel> expressionBuilder = this.itemPaddingTop;
        LogicalPixelCodec logicalPixelCodec = LogicalPixelCodec.INSTANCE;
        Class<LogicalPixel> cls = LogicalPixel.class;
        return new OrderStatusModel(ExpressionBuilderUtilsKt.build(expressionBuilder, Reflection.getOrCreateKotlinClass(cls), logicalPixelCodec, args), ExpressionBuilderUtilsKt.build(this.itemPaddingBottom, Reflection.getOrCreateKotlinClass(cls), logicalPixelCodec, args), ExpressionBuilderUtilsKt.build(this.itemPaddingLeading, Reflection.getOrCreateKotlinClass(cls), logicalPixelCodec, args), ExpressionBuilderUtilsKt.build(this.itemPaddingTrailing, Reflection.getOrCreateKotlinClass(cls), logicalPixelCodec, args), ExpressionBuilderUtilsKt.build(this.itemSpacing, Reflection.getOrCreateKotlinClass(cls), logicalPixelCodec, args), a(args));
    }

    @Nullable
    public final ExpressionBuilder<LogicalPixel> getItemPaddingBottom() {
        return this.itemPaddingBottom;
    }

    @Nullable
    public final ExpressionBuilder<LogicalPixel> getItemPaddingLeading() {
        return this.itemPaddingLeading;
    }

    @Nullable
    public final ExpressionBuilder<LogicalPixel> getItemPaddingTop() {
        return this.itemPaddingTop;
    }

    @Nullable
    public final ExpressionBuilder<LogicalPixel> getItemPaddingTrailing() {
        return this.itemPaddingTrailing;
    }

    @Nullable
    public final ExpressionBuilder<LogicalPixel> getItemSpacing() {
        return this.itemSpacing;
    }

    public final void setItemPaddingBottom(@Nullable ExpressionBuilder<LogicalPixel> expressionBuilder) {
        this.itemPaddingBottom = expressionBuilder;
    }

    public final void setItemPaddingLeading(@Nullable ExpressionBuilder<LogicalPixel> expressionBuilder) {
        this.itemPaddingLeading = expressionBuilder;
    }

    public final void setItemPaddingTop(@Nullable ExpressionBuilder<LogicalPixel> expressionBuilder) {
        this.itemPaddingTop = expressionBuilder;
    }

    public final void setItemPaddingTrailing(@Nullable ExpressionBuilder<LogicalPixel> expressionBuilder) {
        this.itemPaddingTrailing = expressionBuilder;
    }

    public final void setItemSpacing(@Nullable ExpressionBuilder<LogicalPixel> expressionBuilder) {
        this.itemSpacing = expressionBuilder;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ OrderStatusModelBuilder(Function1 function1, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? AnonymousClass1.INSTANCE : function1);
    }

    public OrderStatusModelBuilder(@NotNull Function1<? super OrderStatusModelBuilder, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "init");
        this.init = function1;
        function1.invoke(this);
    }
}
