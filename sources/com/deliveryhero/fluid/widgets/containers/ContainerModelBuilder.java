package com.deliveryhero.fluid.widgets.containers;

import com.deliveryhero.fluid.expression.ExpressionBuilder;
import com.deliveryhero.fluid.versioning.CoreContract;
import com.deliveryhero.fluid.widgets.WidgetModelBuilder;
import java.util.List;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b'\u0018\u0000 D2\u00020\u0001:\u0001DBÿ\u0004\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0010\b\u0001\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\u0010\b\u0001\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f\u0012\u0010\b\u0001\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f\u0012\u0010\b\u0001\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\f\u0012\u0010\b\u0001\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f\u0012\u0010\b\u0001\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f\u0012\u0016\b\u0001\u0010\u0013\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\f\u0018\u00010\u0014\u0012\u0010\b\u0001\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\f\u0012\u0010\b\u0001\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\f\u0012\u0010\b\u0001\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\f\u0012\u0010\b\u0001\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\f\u0012\u0010\b\u0001\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\f\u0012\u0010\b\u0001\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\f\u0012\u0010\b\u0001\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\f\u0012\u0010\b\u0001\u0010 \u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\f\u0012\u0010\b\u0001\u0010!\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\f\u0012\u0010\b\u0001\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\f\u0012\u0010\b\u0001\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\f\u0012\u0010\b\u0001\u0010$\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\f\u0012\u0010\b\u0001\u0010%\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\f\u0012\u0010\b\u0001\u0010&\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\f\u0012\u0010\b\u0001\u0010'\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\f\u0012\u0010\b\u0001\u0010(\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\f\u0012\u0010\b\u0001\u0010)\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\f\u0012\u0010\b\u0001\u0010*\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\f\u0012\u0010\b\u0001\u0010+\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\f\u0012\u0010\b\u0001\u0010,\u001a\n\u0012\u0004\u0012\u00020-\u0018\u00010\f\u0012\u0010\b\u0001\u0010.\u001a\n\u0012\u0004\u0012\u00020/\u0018\u00010\f\u0012\u0010\b\u0001\u00100\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\f\u0012\u0010\b\u0001\u00101\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\f\u0012\u0010\b\u0001\u00102\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\f\u0012\u0010\b\u0001\u00103\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0014\u0012\b\u00104\u001a\u0004\u0018\u000105¢\u0006\u0002\u00106B\u0005¢\u0006\u0002\u00107J!\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020\u00002\u0006\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020CHÇ\u0001R*\u00103\u001a\b\u0012\u0004\u0012\u00020\u00010\u00148\u0006@\u0006X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b8\u00107\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<¨\u0006Eå\b\u0005å\b\u0007å\b\bå\b\u000bå\b\u000eå\b\u000få\b\u0011å\b\u0012å\b\u0013å\b\u0016å\b\u0018å\b\u001aå\b\u001cå\b\u001då\b\u001eå\b\u001få\b å\b!å\b\"å\b#å\b$å\b%å\b&å\b'å\b(å\b)å\b*å\b+å\b,å\b.å\b0å\b1å\b2å\b3"}, d2 = {"Lcom/deliveryhero/fluid/widgets/containers/ContainerModelBuilder;", "Lcom/deliveryhero/fluid/widgets/WidgetModelBuilder;", "seen1", "", "seen2", "id", "", "hash", "placeholders", "", "Lcom/deliveryhero/fluid/expression/placeholder/PlaceholderSurrogate;", "width", "Lcom/deliveryhero/fluid/expression/ExpressionBuilder;", "Lcom/deliveryhero/fluid/values/Size;", "height", "isVisible", "", "expansionResistancePriority", "compressionResistancePriority", "backgroundColors", "", "Lcom/deliveryhero/fluid/values/Color;", "backgroundShape", "Lcom/deliveryhero/fluid/values/Shape;", "backgroundLinearGradientOrientation", "Lcom/deliveryhero/fluid/values/LinearGradientOrientation;", "backgroundCornerRadiusTopLeft", "Lcom/deliveryhero/fluid/values/LogicalPixel;", "backgroundCornerRadiusTopRight", "backgroundCornerRadiusBottomRight", "backgroundCornerRadiusBottomLeft", "backgroundRadius", "borderWidth", "borderColor", "elevation", "clipToBounds", "paddingLeading", "paddingTop", "paddingTrailing", "paddingBottom", "marginLeading", "marginTop", "marginTrailing", "marginBottom", "horizontalAlignment", "Lcom/deliveryhero/fluid/widgets/containers/HorizontalAlignment;", "verticalAlignment", "Lcom/deliveryhero/fluid/widgets/containers/VerticalAlignment;", "accessibilityId", "accessibilityLabel", "onClick", "children", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IILjava/lang/String;Ljava/lang/String;Ljava/util/Set;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Ljava/util/List;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "()V", "getChildren$annotations", "getChildren", "()Ljava/util/List;", "setChildren", "(Ljava/util/List;)V", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "Companion", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Serializable
public abstract class ContainerModelBuilder extends WidgetModelBuilder {
    /* access modifiers changed from: private */
    @NotNull
    public static final Lazy<KSerializer<Object>> $cachedSerializer$delegate = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.PUBLICATION, ContainerModelBuilder$Companion$$cachedSerializer$delegate$1.INSTANCE);
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private List<? extends WidgetModelBuilder> children;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/deliveryhero/fluid/widgets/containers/ContainerModelBuilder$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/deliveryhero/fluid/widgets/containers/ContainerModelBuilder;", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final /* synthetic */ Lazy get$cachedSerializer$delegate() {
            return ContainerModelBuilder.$cachedSerializer$delegate;
        }

        @NotNull
        public final KSerializer<ContainerModelBuilder> serializer() {
            return (KSerializer) get$cachedSerializer$delegate().getValue();
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ ContainerModelBuilder(int i11, int i12, @CoreContract.CreatedOn(version = CoreContract.Version.V1) @Deprecated(message = "Move when versioning is supported") @SerialName("id") String str, @CoreContract.CreatedOn(version = CoreContract.Version.V1) @Deprecated(message = "Move when versioning is supported") @SerialName("hash") String str2, @CoreContract.CreatedOn(version = CoreContract.Version.V1) @Deprecated(message = "Move when versioning is supported") @SerialName("placeholders") Set set, @CoreContract.CreatedOn(version = CoreContract.Version.V1) @SerialName("width") ExpressionBuilder expressionBuilder, @CoreContract.CreatedOn(version = CoreContract.Version.V1) @SerialName("height") ExpressionBuilder expressionBuilder2, @CoreContract.CreatedOn(version = CoreContract.Version.V1) @SerialName("is_visible") ExpressionBuilder expressionBuilder3, @CoreContract.CreatedOn(version = CoreContract.Version.V1) @SerialName("expansion_resistance_priority") ExpressionBuilder expressionBuilder4, @CoreContract.CreatedOn(version = CoreContract.Version.V1) @SerialName("compression_resistance_priority") ExpressionBuilder expressionBuilder5, @CoreContract.CreatedOn(version = CoreContract.Version.V1) @SerialName("background_colors") List list, @CoreContract.CreatedOn(version = CoreContract.Version.V1) @SerialName("background_shape") ExpressionBuilder expressionBuilder6, @CoreContract.CreatedOn(version = CoreContract.Version.V1) @SerialName("background_gradient_orientation") ExpressionBuilder expressionBuilder7, @CoreContract.CreatedOn(version = CoreContract.Version.V1) @SerialName("background_radius_top_left") ExpressionBuilder expressionBuilder8, @CoreContract.CreatedOn(version = CoreContract.Version.V1) @SerialName("background_radius_top_right") ExpressionBuilder expressionBuilder9, @CoreContract.CreatedOn(version = CoreContract.Version.V1) @SerialName("background_radius_bottom_right") ExpressionBuilder expressionBuilder10, @CoreContract.CreatedOn(version = CoreContract.Version.V1) @SerialName("background_radius_bottom_left") ExpressionBuilder expressionBuilder11, @CoreContract.CreatedOn(version = CoreContract.Version.V1) @Deprecated(message = "Use backgroundCornerRadiusAll or corner specific background radii instead") @CoreContract.DeprecatedOn(version = CoreContract.Version.V2) @SerialName("background_radius") ExpressionBuilder expressionBuilder12, @CoreContract.CreatedOn(version = CoreContract.Version.V1) @SerialName("border_width") ExpressionBuilder expressionBuilder13, @CoreContract.CreatedOn(version = CoreContract.Version.V1) @SerialName("border_color") ExpressionBuilder expressionBuilder14, @CoreContract.CreatedOn(version = CoreContract.Version.V1) @SerialName("elevation") ExpressionBuilder expressionBuilder15, @CoreContract.CreatedOn(version = CoreContract.Version.V1) @SerialName("clip_to_bounds") ExpressionBuilder expressionBuilder16, @CoreContract.CreatedOn(version = CoreContract.Version.V1) @SerialName("padding_leading") ExpressionBuilder expressionBuilder17, @CoreContract.CreatedOn(version = CoreContract.Version.V1) @SerialName("padding_top") ExpressionBuilder expressionBuilder18, @CoreContract.CreatedOn(version = CoreContract.Version.V1) @SerialName("padding_trailing") ExpressionBuilder expressionBuilder19, @CoreContract.CreatedOn(version = CoreContract.Version.V1) @SerialName("padding_bottom") ExpressionBuilder expressionBuilder20, @CoreContract.CreatedOn(version = CoreContract.Version.V1) @SerialName("margin_leading") ExpressionBuilder expressionBuilder21, @CoreContract.CreatedOn(version = CoreContract.Version.V1) @SerialName("margin_top") ExpressionBuilder expressionBuilder22, @CoreContract.CreatedOn(version = CoreContract.Version.V1) @SerialName("margin_trailing") ExpressionBuilder expressionBuilder23, @CoreContract.CreatedOn(version = CoreContract.Version.V1) @SerialName("margin_bottom") ExpressionBuilder expressionBuilder24, @CoreContract.CreatedOn(version = CoreContract.Version.V1) @SerialName("horizontal_alignment") ExpressionBuilder expressionBuilder25, @CoreContract.CreatedOn(version = CoreContract.Version.V1) @SerialName("vertical_alignment") ExpressionBuilder expressionBuilder26, @CoreContract.CreatedOn(version = CoreContract.Version.V1) @SerialName("accessibility_tag") ExpressionBuilder expressionBuilder27, @CoreContract.CreatedOn(version = CoreContract.Version.V1) @SerialName("accessibility_label") ExpressionBuilder expressionBuilder28, @CoreContract.CreatedOn(version = CoreContract.Version.V1) @SerialName("on_click") ExpressionBuilder expressionBuilder29, @CoreContract.CreatedOn(version = CoreContract.Version.V1) @SerialName("children") List list2, SerializationConstructorMarker serializationConstructorMarker) {
        super(i11, i12, str, str2, set, expressionBuilder, expressionBuilder2, expressionBuilder3, expressionBuilder4, expressionBuilder5, list, expressionBuilder6, expressionBuilder7, expressionBuilder8, expressionBuilder9, expressionBuilder10, expressionBuilder11, expressionBuilder12, expressionBuilder13, expressionBuilder14, expressionBuilder15, expressionBuilder16, expressionBuilder17, expressionBuilder18, expressionBuilder19, expressionBuilder20, expressionBuilder21, expressionBuilder22, expressionBuilder23, expressionBuilder24, expressionBuilder25, expressionBuilder26, expressionBuilder27, expressionBuilder28, expressionBuilder29, serializationConstructorMarker);
        ContainerModelBuilder containerModelBuilder;
        List list3;
        if ((i12 & 2) == 0) {
            list3 = CollectionsKt__CollectionsKt.emptyList();
            containerModelBuilder = this;
        } else {
            containerModelBuilder = this;
            list3 = list2;
        }
        containerModelBuilder.children = list3;
    }

    @CoreContract.CreatedOn(version = CoreContract.Version.V1)
    @SerialName("children")
    public static /* synthetic */ void getChildren$annotations() {
    }

    @JvmStatic
    public static final void write$Self(@NotNull ContainerModelBuilder containerModelBuilder, @NotNull CompositeEncoder compositeEncoder, @NotNull SerialDescriptor serialDescriptor) {
        Intrinsics.checkNotNullParameter(containerModelBuilder, "self");
        Intrinsics.checkNotNullParameter(compositeEncoder, "output");
        Intrinsics.checkNotNullParameter(serialDescriptor, "serialDesc");
        WidgetModelBuilder.write$Self(containerModelBuilder, compositeEncoder, serialDescriptor);
        boolean z11 = true;
        if (!compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 33) && Intrinsics.areEqual((Object) containerModelBuilder.children, (Object) CollectionsKt__CollectionsKt.emptyList())) {
            z11 = false;
        }
        if (z11) {
            compositeEncoder.encodeSerializableElement(serialDescriptor, 33, new ArrayListSerializer(WidgetModelBuilder.Companion.serializer()), containerModelBuilder.children);
        }
    }

    @NotNull
    public final List<WidgetModelBuilder> getChildren() {
        return this.children;
    }

    public final void setChildren(@NotNull List<? extends WidgetModelBuilder> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.children = list;
    }

    public ContainerModelBuilder() {
        this.children = CollectionsKt__CollectionsKt.emptyList();
    }
}
