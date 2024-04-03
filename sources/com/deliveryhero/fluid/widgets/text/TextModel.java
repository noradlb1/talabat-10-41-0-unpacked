package com.deliveryhero.fluid.widgets.text;

import com.deliveryhero.fluid.expression.Expression;
import com.deliveryhero.fluid.values.Color;
import com.deliveryhero.fluid.values.LogicalPixel;
import com.deliveryhero.fluid.values.ScalableLogicalPixel;
import com.deliveryhero.fluid.widgets.WidgetModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0016\u0018\u00002\u00020\u0001B§\u0001\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0003\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0003\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0003\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0003\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0003\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u0003\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u0003\u0012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0003\u0012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u0003\u0012\u0006\u0010\u0017\u001a\u00020\u0018¢\u0006\u0002\u0010\u0019R\u0014\u0010\u0017\u001a\u00020\u0018X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001dR\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001dR\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001dR\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001dR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001dR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001dR\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001dR\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001dR\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001dR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001d¨\u0006("}, d2 = {"Lcom/deliveryhero/fluid/widgets/text/TextModel;", "Lcom/deliveryhero/fluid/widgets/WidgetModel;", "plainText", "Lcom/deliveryhero/fluid/expression/Expression;", "", "richText", "textStyle", "Lcom/deliveryhero/fluid/widgets/text/TextStyle;", "textColor", "Lcom/deliveryhero/fluid/values/Color;", "textSize", "Lcom/deliveryhero/fluid/values/ScalableLogicalPixel;", "textAlignment", "Lcom/deliveryhero/fluid/widgets/text/TextAlignment;", "lineSpacingExtra", "Lcom/deliveryhero/fluid/values/LogicalPixel;", "lineSpacingMultiplier", "", "maxLines", "", "minLines", "lineBreakMode", "Lcom/deliveryhero/fluid/widgets/text/LineBreakMode;", "baseProperties", "Lcom/deliveryhero/fluid/widgets/WidgetModel$BaseProperties;", "(Lcom/deliveryhero/fluid/expression/Expression;Lcom/deliveryhero/fluid/expression/Expression;Lcom/deliveryhero/fluid/expression/Expression;Lcom/deliveryhero/fluid/expression/Expression;Lcom/deliveryhero/fluid/expression/Expression;Lcom/deliveryhero/fluid/expression/Expression;Lcom/deliveryhero/fluid/expression/Expression;Lcom/deliveryhero/fluid/expression/Expression;Lcom/deliveryhero/fluid/expression/Expression;Lcom/deliveryhero/fluid/expression/Expression;Lcom/deliveryhero/fluid/expression/Expression;Lcom/deliveryhero/fluid/widgets/WidgetModel$BaseProperties;)V", "getBaseProperties", "()Lcom/deliveryhero/fluid/widgets/WidgetModel$BaseProperties;", "getLineBreakMode", "()Lcom/deliveryhero/fluid/expression/Expression;", "getLineSpacingExtra", "getLineSpacingMultiplier", "getMaxLines", "getMinLines", "getPlainText", "getRichText", "getTextAlignment", "getTextColor", "getTextSize", "getTextStyle", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class TextModel implements WidgetModel {
    @NotNull
    private final WidgetModel.BaseProperties baseProperties;
    @NotNull
    private final Expression<LineBreakMode> lineBreakMode;
    @NotNull
    private final Expression<LogicalPixel> lineSpacingExtra;
    @NotNull
    private final Expression<Float> lineSpacingMultiplier;
    @NotNull
    private final Expression<Integer> maxLines;
    @NotNull
    private final Expression<Integer> minLines;
    @NotNull
    private final Expression<String> plainText;
    @NotNull
    private final Expression<String> richText;
    @NotNull
    private final Expression<TextAlignment> textAlignment;
    @NotNull
    private final Expression<Color> textColor;
    @NotNull
    private final Expression<ScalableLogicalPixel> textSize;
    @NotNull
    private final Expression<TextStyle> textStyle;

    public TextModel(@NotNull Expression<String> expression, @NotNull Expression<String> expression2, @NotNull Expression<TextStyle> expression3, @NotNull Expression<Color> expression4, @NotNull Expression<ScalableLogicalPixel> expression5, @NotNull Expression<TextAlignment> expression6, @NotNull Expression<LogicalPixel> expression7, @NotNull Expression<Float> expression8, @NotNull Expression<Integer> expression9, @NotNull Expression<Integer> expression10, @NotNull Expression<LineBreakMode> expression11, @NotNull WidgetModel.BaseProperties baseProperties2) {
        Intrinsics.checkNotNullParameter(expression, "plainText");
        Intrinsics.checkNotNullParameter(expression2, "richText");
        Intrinsics.checkNotNullParameter(expression3, "textStyle");
        Intrinsics.checkNotNullParameter(expression4, "textColor");
        Intrinsics.checkNotNullParameter(expression5, "textSize");
        Intrinsics.checkNotNullParameter(expression6, "textAlignment");
        Intrinsics.checkNotNullParameter(expression7, "lineSpacingExtra");
        Intrinsics.checkNotNullParameter(expression8, "lineSpacingMultiplier");
        Intrinsics.checkNotNullParameter(expression9, "maxLines");
        Intrinsics.checkNotNullParameter(expression10, "minLines");
        Intrinsics.checkNotNullParameter(expression11, "lineBreakMode");
        Intrinsics.checkNotNullParameter(baseProperties2, "baseProperties");
        this.plainText = expression;
        this.richText = expression2;
        this.textStyle = expression3;
        this.textColor = expression4;
        this.textSize = expression5;
        this.textAlignment = expression6;
        this.lineSpacingExtra = expression7;
        this.lineSpacingMultiplier = expression8;
        this.maxLines = expression9;
        this.minLines = expression10;
        this.lineBreakMode = expression11;
        this.baseProperties = baseProperties2;
    }

    @NotNull
    public WidgetModel.BaseProperties getBaseProperties() {
        return this.baseProperties;
    }

    @NotNull
    public final Expression<LineBreakMode> getLineBreakMode() {
        return this.lineBreakMode;
    }

    @NotNull
    public final Expression<LogicalPixel> getLineSpacingExtra() {
        return this.lineSpacingExtra;
    }

    @NotNull
    public final Expression<Float> getLineSpacingMultiplier() {
        return this.lineSpacingMultiplier;
    }

    @NotNull
    public final Expression<Integer> getMaxLines() {
        return this.maxLines;
    }

    @NotNull
    public final Expression<Integer> getMinLines() {
        return this.minLines;
    }

    @NotNull
    public final Expression<String> getPlainText() {
        return this.plainText;
    }

    @NotNull
    public final Expression<String> getRichText() {
        return this.richText;
    }

    @NotNull
    public final Expression<TextAlignment> getTextAlignment() {
        return this.textAlignment;
    }

    @NotNull
    public final Expression<Color> getTextColor() {
        return this.textColor;
    }

    @NotNull
    public final Expression<ScalableLogicalPixel> getTextSize() {
        return this.textSize;
    }

    @NotNull
    public final Expression<TextStyle> getTextStyle() {
        return this.textStyle;
    }
}
