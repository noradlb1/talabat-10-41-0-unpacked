package com.deliveryhero.fluid.widgets.collections.pager.indicators;

import com.deliveryhero.fluid.expression.Expression;
import com.deliveryhero.fluid.values.Color;
import com.deliveryhero.fluid.values.LogicalPixel;
import com.talabat.darkstores.common.bindingAdapters.BindingAdaptersKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001BK\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0003¢\u0006\u0002\u0010\nJ\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\b0\u0003HÆ\u0003J\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\b0\u0003HÆ\u0003JY\u0010\u0016\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00032\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0003HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\f¨\u0006\u001e"}, d2 = {"Lcom/deliveryhero/fluid/widgets/collections/pager/indicators/PagerDotsIndicatorModel;", "", "pagerSpacing", "Lcom/deliveryhero/fluid/expression/Expression;", "Lcom/deliveryhero/fluid/values/LogicalPixel;", "spacing", "size", "activeColor", "Lcom/deliveryhero/fluid/values/Color;", "inActiveColor", "(Lcom/deliveryhero/fluid/expression/Expression;Lcom/deliveryhero/fluid/expression/Expression;Lcom/deliveryhero/fluid/expression/Expression;Lcom/deliveryhero/fluid/expression/Expression;Lcom/deliveryhero/fluid/expression/Expression;)V", "getActiveColor", "()Lcom/deliveryhero/fluid/expression/Expression;", "getInActiveColor", "getPagerSpacing", "getSize", "getSpacing", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PagerDotsIndicatorModel {
    @NotNull
    private final Expression<Color> activeColor;
    @NotNull
    private final Expression<Color> inActiveColor;
    @NotNull
    private final Expression<LogicalPixel> pagerSpacing;
    @NotNull
    private final Expression<LogicalPixel> size;
    @NotNull
    private final Expression<LogicalPixel> spacing;

    public PagerDotsIndicatorModel(@NotNull Expression<LogicalPixel> expression, @NotNull Expression<LogicalPixel> expression2, @NotNull Expression<LogicalPixel> expression3, @NotNull Expression<Color> expression4, @NotNull Expression<Color> expression5) {
        Intrinsics.checkNotNullParameter(expression, "pagerSpacing");
        Intrinsics.checkNotNullParameter(expression2, "spacing");
        Intrinsics.checkNotNullParameter(expression3, BindingAdaptersKt.QUERY_SIZE);
        Intrinsics.checkNotNullParameter(expression4, "activeColor");
        Intrinsics.checkNotNullParameter(expression5, "inActiveColor");
        this.pagerSpacing = expression;
        this.spacing = expression2;
        this.size = expression3;
        this.activeColor = expression4;
        this.inActiveColor = expression5;
    }

    public static /* synthetic */ PagerDotsIndicatorModel copy$default(PagerDotsIndicatorModel pagerDotsIndicatorModel, Expression<LogicalPixel> expression, Expression<LogicalPixel> expression2, Expression<LogicalPixel> expression3, Expression<Color> expression4, Expression<Color> expression5, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            expression = pagerDotsIndicatorModel.pagerSpacing;
        }
        if ((i11 & 2) != 0) {
            expression2 = pagerDotsIndicatorModel.spacing;
        }
        Expression<LogicalPixel> expression6 = expression2;
        if ((i11 & 4) != 0) {
            expression3 = pagerDotsIndicatorModel.size;
        }
        Expression<LogicalPixel> expression7 = expression3;
        if ((i11 & 8) != 0) {
            expression4 = pagerDotsIndicatorModel.activeColor;
        }
        Expression<Color> expression8 = expression4;
        if ((i11 & 16) != 0) {
            expression5 = pagerDotsIndicatorModel.inActiveColor;
        }
        return pagerDotsIndicatorModel.copy(expression, expression6, expression7, expression8, expression5);
    }

    @NotNull
    public final Expression<LogicalPixel> component1() {
        return this.pagerSpacing;
    }

    @NotNull
    public final Expression<LogicalPixel> component2() {
        return this.spacing;
    }

    @NotNull
    public final Expression<LogicalPixel> component3() {
        return this.size;
    }

    @NotNull
    public final Expression<Color> component4() {
        return this.activeColor;
    }

    @NotNull
    public final Expression<Color> component5() {
        return this.inActiveColor;
    }

    @NotNull
    public final PagerDotsIndicatorModel copy(@NotNull Expression<LogicalPixel> expression, @NotNull Expression<LogicalPixel> expression2, @NotNull Expression<LogicalPixel> expression3, @NotNull Expression<Color> expression4, @NotNull Expression<Color> expression5) {
        Intrinsics.checkNotNullParameter(expression, "pagerSpacing");
        Intrinsics.checkNotNullParameter(expression2, "spacing");
        Intrinsics.checkNotNullParameter(expression3, BindingAdaptersKt.QUERY_SIZE);
        Intrinsics.checkNotNullParameter(expression4, "activeColor");
        Intrinsics.checkNotNullParameter(expression5, "inActiveColor");
        return new PagerDotsIndicatorModel(expression, expression2, expression3, expression4, expression5);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PagerDotsIndicatorModel)) {
            return false;
        }
        PagerDotsIndicatorModel pagerDotsIndicatorModel = (PagerDotsIndicatorModel) obj;
        return Intrinsics.areEqual((Object) this.pagerSpacing, (Object) pagerDotsIndicatorModel.pagerSpacing) && Intrinsics.areEqual((Object) this.spacing, (Object) pagerDotsIndicatorModel.spacing) && Intrinsics.areEqual((Object) this.size, (Object) pagerDotsIndicatorModel.size) && Intrinsics.areEqual((Object) this.activeColor, (Object) pagerDotsIndicatorModel.activeColor) && Intrinsics.areEqual((Object) this.inActiveColor, (Object) pagerDotsIndicatorModel.inActiveColor);
    }

    @NotNull
    public final Expression<Color> getActiveColor() {
        return this.activeColor;
    }

    @NotNull
    public final Expression<Color> getInActiveColor() {
        return this.inActiveColor;
    }

    @NotNull
    public final Expression<LogicalPixel> getPagerSpacing() {
        return this.pagerSpacing;
    }

    @NotNull
    public final Expression<LogicalPixel> getSize() {
        return this.size;
    }

    @NotNull
    public final Expression<LogicalPixel> getSpacing() {
        return this.spacing;
    }

    public int hashCode() {
        return (((((((this.pagerSpacing.hashCode() * 31) + this.spacing.hashCode()) * 31) + this.size.hashCode()) * 31) + this.activeColor.hashCode()) * 31) + this.inActiveColor.hashCode();
    }

    @NotNull
    public String toString() {
        return "PagerDotsIndicatorModel(pagerSpacing=" + this.pagerSpacing + ", spacing=" + this.spacing + ", size=" + this.size + ", activeColor=" + this.activeColor + ", inActiveColor=" + this.inActiveColor + ')';
    }
}
