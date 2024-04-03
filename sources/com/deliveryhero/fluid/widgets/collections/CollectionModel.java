package com.deliveryhero.fluid.widgets.collections;

import com.deliveryhero.fluid.expression.Expression;
import com.deliveryhero.fluid.values.LogicalPixel;
import com.deliveryhero.fluid.widgets.WidgetModel;
import com.deliveryhero.fluid.widgets.collections.Cell;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003R\u0018\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\n0\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\b¨\u0006\f"}, d2 = {"Lcom/deliveryhero/fluid/widgets/collections/CollectionModel;", "CellT", "Lcom/deliveryhero/fluid/widgets/collections/Cell;", "Lcom/deliveryhero/fluid/widgets/WidgetModel;", "cellSpacing", "Lcom/deliveryhero/fluid/expression/Expression;", "Lcom/deliveryhero/fluid/values/LogicalPixel;", "getCellSpacing", "()Lcom/deliveryhero/fluid/expression/Expression;", "cells", "", "getCells", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface CollectionModel<CellT extends Cell> extends WidgetModel {
    @NotNull
    Expression<LogicalPixel> getCellSpacing();

    @NotNull
    Expression<List<CellT>> getCells();
}
