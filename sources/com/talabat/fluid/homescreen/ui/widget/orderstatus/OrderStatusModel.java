package com.talabat.fluid.homescreen.ui.widget.orderstatus;

import com.deliveryhero.fluid.expression.Expression;
import com.deliveryhero.fluid.values.LogicalPixel;
import com.deliveryhero.fluid.widgets.WidgetModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u00002\u00020\u0001BS\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bR\u0014\u0010\t\u001a\u00020\nX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000f¨\u0006\u0014"}, d2 = {"Lcom/talabat/fluid/homescreen/ui/widget/orderstatus/OrderStatusModel;", "Lcom/deliveryhero/fluid/widgets/WidgetModel;", "itemPaddingTop", "Lcom/deliveryhero/fluid/expression/Expression;", "Lcom/deliveryhero/fluid/values/LogicalPixel;", "itemPaddingBottom", "itemPaddingLeading", "itemPaddingTrailing", "itemSpacing", "baseProperties", "Lcom/deliveryhero/fluid/widgets/WidgetModel$BaseProperties;", "(Lcom/deliveryhero/fluid/expression/Expression;Lcom/deliveryhero/fluid/expression/Expression;Lcom/deliveryhero/fluid/expression/Expression;Lcom/deliveryhero/fluid/expression/Expression;Lcom/deliveryhero/fluid/expression/Expression;Lcom/deliveryhero/fluid/widgets/WidgetModel$BaseProperties;)V", "getBaseProperties", "()Lcom/deliveryhero/fluid/widgets/WidgetModel$BaseProperties;", "getItemPaddingBottom", "()Lcom/deliveryhero/fluid/expression/Expression;", "getItemPaddingLeading", "getItemPaddingTop", "getItemPaddingTrailing", "getItemSpacing", "com_talabat_NewArchi_Homescreen_Homescreen"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OrderStatusModel implements WidgetModel {
    @NotNull
    private final WidgetModel.BaseProperties baseProperties;
    @NotNull
    private final Expression<LogicalPixel> itemPaddingBottom;
    @NotNull
    private final Expression<LogicalPixel> itemPaddingLeading;
    @NotNull
    private final Expression<LogicalPixel> itemPaddingTop;
    @NotNull
    private final Expression<LogicalPixel> itemPaddingTrailing;
    @NotNull
    private final Expression<LogicalPixel> itemSpacing;

    public OrderStatusModel(@NotNull Expression<LogicalPixel> expression, @NotNull Expression<LogicalPixel> expression2, @NotNull Expression<LogicalPixel> expression3, @NotNull Expression<LogicalPixel> expression4, @NotNull Expression<LogicalPixel> expression5, @NotNull WidgetModel.BaseProperties baseProperties2) {
        Intrinsics.checkNotNullParameter(expression, "itemPaddingTop");
        Intrinsics.checkNotNullParameter(expression2, "itemPaddingBottom");
        Intrinsics.checkNotNullParameter(expression3, "itemPaddingLeading");
        Intrinsics.checkNotNullParameter(expression4, "itemPaddingTrailing");
        Intrinsics.checkNotNullParameter(expression5, "itemSpacing");
        Intrinsics.checkNotNullParameter(baseProperties2, "baseProperties");
        this.itemPaddingTop = expression;
        this.itemPaddingBottom = expression2;
        this.itemPaddingLeading = expression3;
        this.itemPaddingTrailing = expression4;
        this.itemSpacing = expression5;
        this.baseProperties = baseProperties2;
    }

    @NotNull
    public WidgetModel.BaseProperties getBaseProperties() {
        return this.baseProperties;
    }

    @NotNull
    public final Expression<LogicalPixel> getItemPaddingBottom() {
        return this.itemPaddingBottom;
    }

    @NotNull
    public final Expression<LogicalPixel> getItemPaddingLeading() {
        return this.itemPaddingLeading;
    }

    @NotNull
    public final Expression<LogicalPixel> getItemPaddingTop() {
        return this.itemPaddingTop;
    }

    @NotNull
    public final Expression<LogicalPixel> getItemPaddingTrailing() {
        return this.itemPaddingTrailing;
    }

    @NotNull
    public final Expression<LogicalPixel> getItemSpacing() {
        return this.itemSpacing;
    }
}
