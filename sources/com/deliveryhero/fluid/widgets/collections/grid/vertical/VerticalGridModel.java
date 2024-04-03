package com.deliveryhero.fluid.widgets.collections.grid.vertical;

import com.deliveryhero.fluid.expression.Expression;
import com.deliveryhero.fluid.values.LogicalPixel;
import com.deliveryhero.fluid.widgets.WidgetModel;
import com.deliveryhero.fluid.widgets.collections.CollectionModel;
import com.talabat.fluid.homescreen.data.parser.ComponentMapper;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B/\u0012\u0012\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00050\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0015\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00050\u0004HÆ\u0003J\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004HÆ\u0003J\t\u0010\u0012\u001a\u00020\tHÆ\u0003J9\u0010\u0013\u001a\u00020\u00002\u0014\b\u0002\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00050\u00042\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u00042\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0014\u0010\b\u001a\u00020\tX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR \u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00050\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000e¨\u0006\u001c"}, d2 = {"Lcom/deliveryhero/fluid/widgets/collections/grid/vertical/VerticalGridModel;", "Lcom/deliveryhero/fluid/widgets/collections/CollectionModel;", "Lcom/deliveryhero/fluid/widgets/collections/grid/vertical/VerticalGridCell;", "cells", "Lcom/deliveryhero/fluid/expression/Expression;", "", "cellSpacing", "Lcom/deliveryhero/fluid/values/LogicalPixel;", "baseProperties", "Lcom/deliveryhero/fluid/widgets/WidgetModel$BaseProperties;", "(Lcom/deliveryhero/fluid/expression/Expression;Lcom/deliveryhero/fluid/expression/Expression;Lcom/deliveryhero/fluid/widgets/WidgetModel$BaseProperties;)V", "getBaseProperties", "()Lcom/deliveryhero/fluid/widgets/WidgetModel$BaseProperties;", "getCellSpacing", "()Lcom/deliveryhero/fluid/expression/Expression;", "getCells", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VerticalGridModel implements CollectionModel<VerticalGridCell> {
    @NotNull
    private final WidgetModel.BaseProperties baseProperties;
    @NotNull
    private final Expression<LogicalPixel> cellSpacing;
    @NotNull
    private final Expression<List<VerticalGridCell>> cells;

    public VerticalGridModel(@NotNull Expression<List<VerticalGridCell>> expression, @NotNull Expression<LogicalPixel> expression2, @NotNull WidgetModel.BaseProperties baseProperties2) {
        Intrinsics.checkNotNullParameter(expression, ComponentMapper.CELLS);
        Intrinsics.checkNotNullParameter(expression2, "cellSpacing");
        Intrinsics.checkNotNullParameter(baseProperties2, "baseProperties");
        this.cells = expression;
        this.cellSpacing = expression2;
        this.baseProperties = baseProperties2;
    }

    public static /* synthetic */ VerticalGridModel copy$default(VerticalGridModel verticalGridModel, Expression<List<VerticalGridCell>> expression, Expression<LogicalPixel> expression2, WidgetModel.BaseProperties baseProperties2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            expression = verticalGridModel.getCells();
        }
        if ((i11 & 2) != 0) {
            expression2 = verticalGridModel.getCellSpacing();
        }
        if ((i11 & 4) != 0) {
            baseProperties2 = verticalGridModel.getBaseProperties();
        }
        return verticalGridModel.copy(expression, expression2, baseProperties2);
    }

    @NotNull
    public final Expression<List<VerticalGridCell>> component1() {
        return getCells();
    }

    @NotNull
    public final Expression<LogicalPixel> component2() {
        return getCellSpacing();
    }

    @NotNull
    public final WidgetModel.BaseProperties component3() {
        return getBaseProperties();
    }

    @NotNull
    public final VerticalGridModel copy(@NotNull Expression<List<VerticalGridCell>> expression, @NotNull Expression<LogicalPixel> expression2, @NotNull WidgetModel.BaseProperties baseProperties2) {
        Intrinsics.checkNotNullParameter(expression, ComponentMapper.CELLS);
        Intrinsics.checkNotNullParameter(expression2, "cellSpacing");
        Intrinsics.checkNotNullParameter(baseProperties2, "baseProperties");
        return new VerticalGridModel(expression, expression2, baseProperties2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VerticalGridModel)) {
            return false;
        }
        VerticalGridModel verticalGridModel = (VerticalGridModel) obj;
        return Intrinsics.areEqual((Object) getCells(), (Object) verticalGridModel.getCells()) && Intrinsics.areEqual((Object) getCellSpacing(), (Object) verticalGridModel.getCellSpacing()) && Intrinsics.areEqual((Object) getBaseProperties(), (Object) verticalGridModel.getBaseProperties());
    }

    @NotNull
    public WidgetModel.BaseProperties getBaseProperties() {
        return this.baseProperties;
    }

    @NotNull
    public Expression<LogicalPixel> getCellSpacing() {
        return this.cellSpacing;
    }

    @NotNull
    public Expression<List<VerticalGridCell>> getCells() {
        return this.cells;
    }

    public int hashCode() {
        return (((getCells().hashCode() * 31) + getCellSpacing().hashCode()) * 31) + getBaseProperties().hashCode();
    }

    @NotNull
    public String toString() {
        return "VerticalGridModel(cells=" + getCells() + ", cellSpacing=" + getCellSpacing() + ", baseProperties=" + getBaseProperties() + ')';
    }
}
