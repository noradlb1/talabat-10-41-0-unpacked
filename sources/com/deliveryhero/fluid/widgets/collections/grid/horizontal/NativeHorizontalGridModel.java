package com.deliveryhero.fluid.widgets.collections.grid.horizontal;

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

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B=\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0012\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00070\u0004\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0003J\u0015\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00070\u0004HÆ\u0003J\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\t0\u0004HÆ\u0003J\t\u0010\u0016\u001a\u00020\u000bHÆ\u0003JI\u0010\u0017\u001a\u00020\u00002\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00070\u00042\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00042\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\u0014\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R \u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00070\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010¨\u0006\u001f"}, d2 = {"Lcom/deliveryhero/fluid/widgets/collections/grid/horizontal/NativeHorizontalGridModel;", "Lcom/deliveryhero/fluid/widgets/collections/CollectionModel;", "Lcom/deliveryhero/fluid/widgets/collections/grid/horizontal/NativeHorizontalGridCell;", "rowsCount", "Lcom/deliveryhero/fluid/expression/Expression;", "", "cells", "", "cellSpacing", "Lcom/deliveryhero/fluid/values/LogicalPixel;", "baseProperties", "Lcom/deliveryhero/fluid/widgets/WidgetModel$BaseProperties;", "(Lcom/deliveryhero/fluid/expression/Expression;Lcom/deliveryhero/fluid/expression/Expression;Lcom/deliveryhero/fluid/expression/Expression;Lcom/deliveryhero/fluid/widgets/WidgetModel$BaseProperties;)V", "getBaseProperties", "()Lcom/deliveryhero/fluid/widgets/WidgetModel$BaseProperties;", "getCellSpacing", "()Lcom/deliveryhero/fluid/expression/Expression;", "getCells", "getRowsCount", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "toString", "", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class NativeHorizontalGridModel implements CollectionModel<NativeHorizontalGridCell> {
    @NotNull
    private final WidgetModel.BaseProperties baseProperties;
    @NotNull
    private final Expression<LogicalPixel> cellSpacing;
    @NotNull
    private final Expression<List<NativeHorizontalGridCell>> cells;
    @NotNull
    private final Expression<Integer> rowsCount;

    public NativeHorizontalGridModel(@NotNull Expression<Integer> expression, @NotNull Expression<List<NativeHorizontalGridCell>> expression2, @NotNull Expression<LogicalPixel> expression3, @NotNull WidgetModel.BaseProperties baseProperties2) {
        Intrinsics.checkNotNullParameter(expression, "rowsCount");
        Intrinsics.checkNotNullParameter(expression2, ComponentMapper.CELLS);
        Intrinsics.checkNotNullParameter(expression3, "cellSpacing");
        Intrinsics.checkNotNullParameter(baseProperties2, "baseProperties");
        this.rowsCount = expression;
        this.cells = expression2;
        this.cellSpacing = expression3;
        this.baseProperties = baseProperties2;
    }

    public static /* synthetic */ NativeHorizontalGridModel copy$default(NativeHorizontalGridModel nativeHorizontalGridModel, Expression<Integer> expression, Expression<List<NativeHorizontalGridCell>> expression2, Expression<LogicalPixel> expression3, WidgetModel.BaseProperties baseProperties2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            expression = nativeHorizontalGridModel.rowsCount;
        }
        if ((i11 & 2) != 0) {
            expression2 = nativeHorizontalGridModel.getCells();
        }
        if ((i11 & 4) != 0) {
            expression3 = nativeHorizontalGridModel.getCellSpacing();
        }
        if ((i11 & 8) != 0) {
            baseProperties2 = nativeHorizontalGridModel.getBaseProperties();
        }
        return nativeHorizontalGridModel.copy(expression, expression2, expression3, baseProperties2);
    }

    @NotNull
    public final Expression<Integer> component1() {
        return this.rowsCount;
    }

    @NotNull
    public final Expression<List<NativeHorizontalGridCell>> component2() {
        return getCells();
    }

    @NotNull
    public final Expression<LogicalPixel> component3() {
        return getCellSpacing();
    }

    @NotNull
    public final WidgetModel.BaseProperties component4() {
        return getBaseProperties();
    }

    @NotNull
    public final NativeHorizontalGridModel copy(@NotNull Expression<Integer> expression, @NotNull Expression<List<NativeHorizontalGridCell>> expression2, @NotNull Expression<LogicalPixel> expression3, @NotNull WidgetModel.BaseProperties baseProperties2) {
        Intrinsics.checkNotNullParameter(expression, "rowsCount");
        Intrinsics.checkNotNullParameter(expression2, ComponentMapper.CELLS);
        Intrinsics.checkNotNullParameter(expression3, "cellSpacing");
        Intrinsics.checkNotNullParameter(baseProperties2, "baseProperties");
        return new NativeHorizontalGridModel(expression, expression2, expression3, baseProperties2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NativeHorizontalGridModel)) {
            return false;
        }
        NativeHorizontalGridModel nativeHorizontalGridModel = (NativeHorizontalGridModel) obj;
        return Intrinsics.areEqual((Object) this.rowsCount, (Object) nativeHorizontalGridModel.rowsCount) && Intrinsics.areEqual((Object) getCells(), (Object) nativeHorizontalGridModel.getCells()) && Intrinsics.areEqual((Object) getCellSpacing(), (Object) nativeHorizontalGridModel.getCellSpacing()) && Intrinsics.areEqual((Object) getBaseProperties(), (Object) nativeHorizontalGridModel.getBaseProperties());
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
    public Expression<List<NativeHorizontalGridCell>> getCells() {
        return this.cells;
    }

    @NotNull
    public final Expression<Integer> getRowsCount() {
        return this.rowsCount;
    }

    public int hashCode() {
        return (((((this.rowsCount.hashCode() * 31) + getCells().hashCode()) * 31) + getCellSpacing().hashCode()) * 31) + getBaseProperties().hashCode();
    }

    @NotNull
    public String toString() {
        return "NativeHorizontalGridModel(rowsCount=" + this.rowsCount + ", cells=" + getCells() + ", cellSpacing=" + getCellSpacing() + ", baseProperties=" + getBaseProperties() + ')';
    }
}
