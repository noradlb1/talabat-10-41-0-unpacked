package com.deliveryhero.fluid.widgets;

import com.deliveryhero.fluid.expression.Expression;
import com.deliveryhero.fluid.values.Color;
import com.deliveryhero.fluid.values.LinearGradientOrientation;
import com.deliveryhero.fluid.values.LogicalPixel;
import com.deliveryhero.fluid.values.Shape;
import com.deliveryhero.fluid.values.Size;
import com.deliveryhero.fluid.widgets.containers.HorizontalAlignment;
import com.deliveryhero.fluid.widgets.containers.VerticalAlignment;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\u0006R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/deliveryhero/fluid/widgets/WidgetModel;", "", "baseProperties", "Lcom/deliveryhero/fluid/widgets/WidgetModel$BaseProperties;", "getBaseProperties", "()Lcom/deliveryhero/fluid/widgets/WidgetModel$BaseProperties;", "BaseProperties", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface WidgetModel {

    @Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\"\u0018\u00002\u00020\u0001B¡\u0003\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0003\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0003\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u0003\u0012\u0012\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00030\f\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0003\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u0003\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u0003\u0012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0003\u0012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00130\u0003\u0012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00130\u0003\u0012\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00130\u0003\u0012\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\r0\u0003\u0012\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00130\u0003\u0012\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00070\u0003\u0012\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00130\u0003\u0012\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00130\u0003\u0012\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00130\u0003\u0012\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00130\u0003\u0012\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00130\u0003\u0012\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00130\u0003\u0012\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00130\u0003\u0012\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00130\u0003\u0012\f\u0010#\u001a\b\u0012\u0004\u0012\u00020$0\u0003\u0012\f\u0010%\u001a\b\u0012\u0004\u0012\u00020&0\u0003\u0012\f\u0010'\u001a\b\u0012\u0004\u0012\u00020(0\u0003\u0012\f\u0010)\u001a\b\u0012\u0004\u0012\u00020(0\u0003\u0012\f\u0010*\u001a\b\u0012\u0004\u0012\u00020(0\u0003¢\u0006\u0002\u0010+R\u0017\u0010)\u001a\b\u0012\u0004\u0012\u00020(0\u0003¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0017\u0010*\u001a\b\u0012\u0004\u0012\u00020(0\u0003¢\u0006\b\n\u0000\u001a\u0004\b.\u0010-R\u001d\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00030\f¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00130\u0003¢\u0006\b\n\u0000\u001a\u0004\b1\u0010-R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00130\u0003¢\u0006\b\n\u0000\u001a\u0004\b2\u0010-R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u0003¢\u0006\b\n\u0000\u001a\u0004\b3\u0010-R\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0003¢\u0006\b\n\u0000\u001a\u0004\b4\u0010-R\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u0003¢\u0006\b\n\u0000\u001a\u0004\b5\u0010-R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0003¢\u0006\b\n\u0000\u001a\u0004\b6\u0010-R\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\r0\u0003¢\u0006\b\n\u0000\u001a\u0004\b7\u0010-R\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00130\u0003¢\u0006\b\n\u0000\u001a\u0004\b8\u0010-R\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00070\u0003¢\u0006\b\n\u0000\u001a\u0004\b9\u0010-R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u0003¢\u0006\b\n\u0000\u001a\u0004\b:\u0010-R\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00130\u0003¢\u0006\b\n\u0000\u001a\u0004\b;\u0010-R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0003¢\u0006\b\n\u0000\u001a\u0004\b<\u0010-R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b=\u0010-R\u0017\u0010#\u001a\b\u0012\u0004\u0012\u00020$0\u0003¢\u0006\b\n\u0000\u001a\u0004\b>\u0010-R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010-R\u0017\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00130\u0003¢\u0006\b\n\u0000\u001a\u0004\b?\u0010-R\u0017\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00130\u0003¢\u0006\b\n\u0000\u001a\u0004\b@\u0010-R\u0017\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00130\u0003¢\u0006\b\n\u0000\u001a\u0004\bA\u0010-R\u0017\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00130\u0003¢\u0006\b\n\u0000\u001a\u0004\bB\u0010-R\u0017\u0010'\u001a\b\u0012\u0004\u0012\u00020(0\u0003¢\u0006\b\n\u0000\u001a\u0004\bC\u0010-R\u0017\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00130\u0003¢\u0006\b\n\u0000\u001a\u0004\bD\u0010-R\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00130\u0003¢\u0006\b\n\u0000\u001a\u0004\bE\u0010-R\u0017\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00130\u0003¢\u0006\b\n\u0000\u001a\u0004\bF\u0010-R\u0017\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00130\u0003¢\u0006\b\n\u0000\u001a\u0004\bG\u0010-R\u0017\u0010%\u001a\b\u0012\u0004\u0012\u00020&0\u0003¢\u0006\b\n\u0000\u001a\u0004\bH\u0010-R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\bI\u0010-¨\u0006J"}, d2 = {"Lcom/deliveryhero/fluid/widgets/WidgetModel$BaseProperties;", "", "width", "Lcom/deliveryhero/fluid/expression/Expression;", "Lcom/deliveryhero/fluid/values/Size;", "height", "isVisible", "", "expansionResistancePriority", "", "compressionResistancePriority", "backgroundColors", "", "Lcom/deliveryhero/fluid/values/Color;", "backgroundShape", "Lcom/deliveryhero/fluid/values/Shape;", "backgroundLinearGradientOrientation", "Lcom/deliveryhero/fluid/values/LinearGradientOrientation;", "backgroundCornerRadiusTopLeft", "Lcom/deliveryhero/fluid/values/LogicalPixel;", "backgroundCornerRadiusTopRight", "backgroundCornerRadiusBottomRight", "backgroundCornerRadiusBottomLeft", "borderWidth", "borderColor", "elevation", "clipToBounds", "paddingLeading", "paddingTop", "paddingTrailing", "paddingBottom", "marginLeading", "marginTop", "marginTrailing", "marginBottom", "horizontalAlignment", "Lcom/deliveryhero/fluid/widgets/containers/HorizontalAlignment;", "verticalAlignment", "Lcom/deliveryhero/fluid/widgets/containers/VerticalAlignment;", "onClick", "", "accessibilityId", "accessibilityLabel", "(Lcom/deliveryhero/fluid/expression/Expression;Lcom/deliveryhero/fluid/expression/Expression;Lcom/deliveryhero/fluid/expression/Expression;Lcom/deliveryhero/fluid/expression/Expression;Lcom/deliveryhero/fluid/expression/Expression;Ljava/util/List;Lcom/deliveryhero/fluid/expression/Expression;Lcom/deliveryhero/fluid/expression/Expression;Lcom/deliveryhero/fluid/expression/Expression;Lcom/deliveryhero/fluid/expression/Expression;Lcom/deliveryhero/fluid/expression/Expression;Lcom/deliveryhero/fluid/expression/Expression;Lcom/deliveryhero/fluid/expression/Expression;Lcom/deliveryhero/fluid/expression/Expression;Lcom/deliveryhero/fluid/expression/Expression;Lcom/deliveryhero/fluid/expression/Expression;Lcom/deliveryhero/fluid/expression/Expression;Lcom/deliveryhero/fluid/expression/Expression;Lcom/deliveryhero/fluid/expression/Expression;Lcom/deliveryhero/fluid/expression/Expression;Lcom/deliveryhero/fluid/expression/Expression;Lcom/deliveryhero/fluid/expression/Expression;Lcom/deliveryhero/fluid/expression/Expression;Lcom/deliveryhero/fluid/expression/Expression;Lcom/deliveryhero/fluid/expression/Expression;Lcom/deliveryhero/fluid/expression/Expression;Lcom/deliveryhero/fluid/expression/Expression;Lcom/deliveryhero/fluid/expression/Expression;Lcom/deliveryhero/fluid/expression/Expression;)V", "getAccessibilityId", "()Lcom/deliveryhero/fluid/expression/Expression;", "getAccessibilityLabel", "getBackgroundColors", "()Ljava/util/List;", "getBackgroundCornerRadiusBottomLeft", "getBackgroundCornerRadiusBottomRight", "getBackgroundCornerRadiusTopLeft", "getBackgroundCornerRadiusTopRight", "getBackgroundLinearGradientOrientation", "getBackgroundShape", "getBorderColor", "getBorderWidth", "getClipToBounds", "getCompressionResistancePriority", "getElevation", "getExpansionResistancePriority", "getHeight", "getHorizontalAlignment", "getMarginBottom", "getMarginLeading", "getMarginTop", "getMarginTrailing", "getOnClick", "getPaddingBottom", "getPaddingLeading", "getPaddingTop", "getPaddingTrailing", "getVerticalAlignment", "getWidth", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class BaseProperties {
        @NotNull
        private final Expression<String> accessibilityId;
        @NotNull
        private final Expression<String> accessibilityLabel;
        @NotNull
        private final List<Expression<Color>> backgroundColors;
        @NotNull
        private final Expression<LogicalPixel> backgroundCornerRadiusBottomLeft;
        @NotNull
        private final Expression<LogicalPixel> backgroundCornerRadiusBottomRight;
        @NotNull
        private final Expression<LogicalPixel> backgroundCornerRadiusTopLeft;
        @NotNull
        private final Expression<LogicalPixel> backgroundCornerRadiusTopRight;
        @NotNull
        private final Expression<LinearGradientOrientation> backgroundLinearGradientOrientation;
        @NotNull
        private final Expression<Shape> backgroundShape;
        @NotNull
        private final Expression<Color> borderColor;
        @NotNull
        private final Expression<LogicalPixel> borderWidth;
        @NotNull
        private final Expression<Boolean> clipToBounds;
        @NotNull
        private final Expression<Integer> compressionResistancePriority;
        @NotNull
        private final Expression<LogicalPixel> elevation;
        @NotNull
        private final Expression<Integer> expansionResistancePriority;
        @NotNull
        private final Expression<Size> height;
        @NotNull
        private final Expression<HorizontalAlignment> horizontalAlignment;
        @NotNull
        private final Expression<Boolean> isVisible;
        @NotNull
        private final Expression<LogicalPixel> marginBottom;
        @NotNull
        private final Expression<LogicalPixel> marginLeading;
        @NotNull
        private final Expression<LogicalPixel> marginTop;
        @NotNull
        private final Expression<LogicalPixel> marginTrailing;
        @NotNull
        private final Expression<String> onClick;
        @NotNull
        private final Expression<LogicalPixel> paddingBottom;
        @NotNull
        private final Expression<LogicalPixel> paddingLeading;
        @NotNull
        private final Expression<LogicalPixel> paddingTop;
        @NotNull
        private final Expression<LogicalPixel> paddingTrailing;
        @NotNull
        private final Expression<VerticalAlignment> verticalAlignment;
        @NotNull
        private final Expression<Size> width;

        public BaseProperties(@NotNull Expression<Size> expression, @NotNull Expression<Size> expression2, @NotNull Expression<Boolean> expression3, @NotNull Expression<Integer> expression4, @NotNull Expression<Integer> expression5, @NotNull List<? extends Expression<Color>> list, @NotNull Expression<Shape> expression6, @NotNull Expression<LinearGradientOrientation> expression7, @NotNull Expression<LogicalPixel> expression8, @NotNull Expression<LogicalPixel> expression9, @NotNull Expression<LogicalPixel> expression10, @NotNull Expression<LogicalPixel> expression11, @NotNull Expression<LogicalPixel> expression12, @NotNull Expression<Color> expression13, @NotNull Expression<LogicalPixel> expression14, @NotNull Expression<Boolean> expression15, @NotNull Expression<LogicalPixel> expression16, @NotNull Expression<LogicalPixel> expression17, @NotNull Expression<LogicalPixel> expression18, @NotNull Expression<LogicalPixel> expression19, @NotNull Expression<LogicalPixel> expression20, @NotNull Expression<LogicalPixel> expression21, @NotNull Expression<LogicalPixel> expression22, @NotNull Expression<LogicalPixel> expression23, @NotNull Expression<HorizontalAlignment> expression24, @NotNull Expression<VerticalAlignment> expression25, @NotNull Expression<String> expression26, @NotNull Expression<String> expression27, @NotNull Expression<String> expression28) {
            Expression<Size> expression29 = expression;
            Expression<Size> expression30 = expression2;
            Expression<Boolean> expression31 = expression3;
            Expression<Integer> expression32 = expression4;
            Expression<Integer> expression33 = expression5;
            List<? extends Expression<Color>> list2 = list;
            Expression<Shape> expression34 = expression6;
            Expression<LinearGradientOrientation> expression35 = expression7;
            Expression<LogicalPixel> expression36 = expression8;
            Expression<LogicalPixel> expression37 = expression9;
            Expression<LogicalPixel> expression38 = expression10;
            Expression<LogicalPixel> expression39 = expression11;
            Expression<LogicalPixel> expression40 = expression12;
            Expression<Color> expression41 = expression13;
            Expression<Boolean> expression42 = expression15;
            Intrinsics.checkNotNullParameter(expression29, "width");
            Intrinsics.checkNotNullParameter(expression30, "height");
            Intrinsics.checkNotNullParameter(expression31, "isVisible");
            Intrinsics.checkNotNullParameter(expression32, "expansionResistancePriority");
            Intrinsics.checkNotNullParameter(expression33, "compressionResistancePriority");
            Intrinsics.checkNotNullParameter(list2, "backgroundColors");
            Intrinsics.checkNotNullParameter(expression34, "backgroundShape");
            Intrinsics.checkNotNullParameter(expression35, "backgroundLinearGradientOrientation");
            Intrinsics.checkNotNullParameter(expression36, "backgroundCornerRadiusTopLeft");
            Intrinsics.checkNotNullParameter(expression37, "backgroundCornerRadiusTopRight");
            Intrinsics.checkNotNullParameter(expression38, "backgroundCornerRadiusBottomRight");
            Intrinsics.checkNotNullParameter(expression39, "backgroundCornerRadiusBottomLeft");
            Intrinsics.checkNotNullParameter(expression40, "borderWidth");
            Intrinsics.checkNotNullParameter(expression41, "borderColor");
            Intrinsics.checkNotNullParameter(expression14, "elevation");
            Intrinsics.checkNotNullParameter(expression15, "clipToBounds");
            Intrinsics.checkNotNullParameter(expression16, "paddingLeading");
            Intrinsics.checkNotNullParameter(expression17, "paddingTop");
            Intrinsics.checkNotNullParameter(expression18, "paddingTrailing");
            Intrinsics.checkNotNullParameter(expression19, "paddingBottom");
            Intrinsics.checkNotNullParameter(expression20, "marginLeading");
            Intrinsics.checkNotNullParameter(expression21, "marginTop");
            Intrinsics.checkNotNullParameter(expression22, "marginTrailing");
            Intrinsics.checkNotNullParameter(expression23, "marginBottom");
            Intrinsics.checkNotNullParameter(expression24, "horizontalAlignment");
            Intrinsics.checkNotNullParameter(expression25, "verticalAlignment");
            Intrinsics.checkNotNullParameter(expression26, "onClick");
            Intrinsics.checkNotNullParameter(expression27, "accessibilityId");
            Intrinsics.checkNotNullParameter(expression28, "accessibilityLabel");
            this.width = expression29;
            this.height = expression30;
            this.isVisible = expression31;
            this.expansionResistancePriority = expression32;
            this.compressionResistancePriority = expression33;
            this.backgroundColors = list2;
            this.backgroundShape = expression34;
            this.backgroundLinearGradientOrientation = expression35;
            this.backgroundCornerRadiusTopLeft = expression36;
            this.backgroundCornerRadiusTopRight = expression37;
            this.backgroundCornerRadiusBottomRight = expression38;
            this.backgroundCornerRadiusBottomLeft = expression39;
            this.borderWidth = expression40;
            this.borderColor = expression41;
            this.elevation = expression14;
            this.clipToBounds = expression15;
            this.paddingLeading = expression16;
            this.paddingTop = expression17;
            this.paddingTrailing = expression18;
            this.paddingBottom = expression19;
            this.marginLeading = expression20;
            this.marginTop = expression21;
            this.marginTrailing = expression22;
            this.marginBottom = expression23;
            this.horizontalAlignment = expression24;
            this.verticalAlignment = expression25;
            this.onClick = expression26;
            this.accessibilityId = expression27;
            this.accessibilityLabel = expression28;
        }

        @NotNull
        public final Expression<String> getAccessibilityId() {
            return this.accessibilityId;
        }

        @NotNull
        public final Expression<String> getAccessibilityLabel() {
            return this.accessibilityLabel;
        }

        @NotNull
        public final List<Expression<Color>> getBackgroundColors() {
            return this.backgroundColors;
        }

        @NotNull
        public final Expression<LogicalPixel> getBackgroundCornerRadiusBottomLeft() {
            return this.backgroundCornerRadiusBottomLeft;
        }

        @NotNull
        public final Expression<LogicalPixel> getBackgroundCornerRadiusBottomRight() {
            return this.backgroundCornerRadiusBottomRight;
        }

        @NotNull
        public final Expression<LogicalPixel> getBackgroundCornerRadiusTopLeft() {
            return this.backgroundCornerRadiusTopLeft;
        }

        @NotNull
        public final Expression<LogicalPixel> getBackgroundCornerRadiusTopRight() {
            return this.backgroundCornerRadiusTopRight;
        }

        @NotNull
        public final Expression<LinearGradientOrientation> getBackgroundLinearGradientOrientation() {
            return this.backgroundLinearGradientOrientation;
        }

        @NotNull
        public final Expression<Shape> getBackgroundShape() {
            return this.backgroundShape;
        }

        @NotNull
        public final Expression<Color> getBorderColor() {
            return this.borderColor;
        }

        @NotNull
        public final Expression<LogicalPixel> getBorderWidth() {
            return this.borderWidth;
        }

        @NotNull
        public final Expression<Boolean> getClipToBounds() {
            return this.clipToBounds;
        }

        @NotNull
        public final Expression<Integer> getCompressionResistancePriority() {
            return this.compressionResistancePriority;
        }

        @NotNull
        public final Expression<LogicalPixel> getElevation() {
            return this.elevation;
        }

        @NotNull
        public final Expression<Integer> getExpansionResistancePriority() {
            return this.expansionResistancePriority;
        }

        @NotNull
        public final Expression<Size> getHeight() {
            return this.height;
        }

        @NotNull
        public final Expression<HorizontalAlignment> getHorizontalAlignment() {
            return this.horizontalAlignment;
        }

        @NotNull
        public final Expression<LogicalPixel> getMarginBottom() {
            return this.marginBottom;
        }

        @NotNull
        public final Expression<LogicalPixel> getMarginLeading() {
            return this.marginLeading;
        }

        @NotNull
        public final Expression<LogicalPixel> getMarginTop() {
            return this.marginTop;
        }

        @NotNull
        public final Expression<LogicalPixel> getMarginTrailing() {
            return this.marginTrailing;
        }

        @NotNull
        public final Expression<String> getOnClick() {
            return this.onClick;
        }

        @NotNull
        public final Expression<LogicalPixel> getPaddingBottom() {
            return this.paddingBottom;
        }

        @NotNull
        public final Expression<LogicalPixel> getPaddingLeading() {
            return this.paddingLeading;
        }

        @NotNull
        public final Expression<LogicalPixel> getPaddingTop() {
            return this.paddingTop;
        }

        @NotNull
        public final Expression<LogicalPixel> getPaddingTrailing() {
            return this.paddingTrailing;
        }

        @NotNull
        public final Expression<VerticalAlignment> getVerticalAlignment() {
            return this.verticalAlignment;
        }

        @NotNull
        public final Expression<Size> getWidth() {
            return this.width;
        }

        @NotNull
        public final Expression<Boolean> isVisible() {
            return this.isVisible;
        }
    }

    @NotNull
    BaseProperties getBaseProperties();
}
