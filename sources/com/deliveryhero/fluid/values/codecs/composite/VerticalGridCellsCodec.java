package com.deliveryhero.fluid.values.codecs.composite;

import com.deliveryhero.fluid.values.LogicalPixel;
import com.deliveryhero.fluid.values.ValueType;
import com.deliveryhero.fluid.values.codecs.CellCodec;
import com.deliveryhero.fluid.widgets.collections.Cell;
import com.deliveryhero.fluid.widgets.collections.RawCell;
import com.deliveryhero.fluid.widgets.collections.grid.vertical.VerticalGridCell;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u001c\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\tH\u0016J\u001c\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\t2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\tH\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000e"}, d2 = {"Lcom/deliveryhero/fluid/values/codecs/composite/VerticalGridCellsCodec;", "Lcom/deliveryhero/fluid/values/codecs/CellCodec;", "Lcom/deliveryhero/fluid/widgets/collections/grid/vertical/VerticalGridCell;", "()V", "valueType", "Lcom/deliveryhero/fluid/values/ValueType;", "getValueType", "()Lcom/deliveryhero/fluid/values/ValueType;", "decode", "", "encoded", "Lcom/deliveryhero/fluid/widgets/collections/RawCell;", "encode", "decoded", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VerticalGridCellsCodec implements CellCodec<VerticalGridCell> {
    @NotNull
    public static final VerticalGridCellsCodec INSTANCE = new VerticalGridCellsCodec();
    @NotNull
    private static final ValueType valueType = ValueType.VERTICAL_GRID_CELL;

    private VerticalGridCellsCodec() {
    }

    @NotNull
    public ValueType getValueType() {
        return valueType;
    }

    @NotNull
    public List<VerticalGridCell> decode(@NotNull List<RawCell> list) {
        VerticalGridCell verticalGridCell;
        Intrinsics.checkNotNullParameter(list, "encoded");
        ArrayList arrayList = new ArrayList();
        for (RawCell rawCell : list) {
            try {
                Float width = rawCell.getWidth();
                Intrinsics.checkNotNull(width);
                float r32 = Cell.Size.Relative.m8197constructorimpl(width.floatValue());
                Float height = rawCell.getHeight();
                Intrinsics.checkNotNull(height);
                verticalGridCell = new VerticalGridCell(r32, Cell.Size.Absolute.m8190constructorimpl(new LogicalPixel(height.floatValue())), rawCell.getTemplate(), rawCell.getData(), (DefaultConstructorMarker) null);
            } catch (Throwable unused) {
                verticalGridCell = null;
            }
            if (verticalGridCell != null) {
                arrayList.add(verticalGridCell);
            }
        }
        return arrayList;
    }

    @NotNull
    public List<RawCell> encode(@NotNull List<VerticalGridCell> list) {
        Intrinsics.checkNotNullParameter(list, "decoded");
        Iterable<VerticalGridCell> iterable = list;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
        for (VerticalGridCell verticalGridCell : iterable) {
            arrayList.add(new RawCell(verticalGridCell.getTemplate(), verticalGridCell.getData(), Float.valueOf(verticalGridCell.m8207getWidthJfM3bYk()), Float.valueOf(verticalGridCell.m8206getHeightG78lpEE().getValue())));
        }
        return arrayList;
    }
}
