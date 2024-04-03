package com.deliveryhero.fluid.values.codecs.composite;

import com.deliveryhero.fluid.template.Template;
import com.deliveryhero.fluid.template.data.TemplateUiData;
import com.deliveryhero.fluid.values.LogicalPixel;
import com.deliveryhero.fluid.values.ValueType;
import com.deliveryhero.fluid.values.codecs.CellCodec;
import com.deliveryhero.fluid.widgets.collections.Cell;
import com.deliveryhero.fluid.widgets.collections.RawCell;
import com.deliveryhero.fluid.widgets.collections.grid.horizontal.HorizontalGridCell;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u001c\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\tH\u0016J\u001c\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\t2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\tH\u0016J\f\u0010\u000e\u001a\u00020\u000f*\u00020\u0010H\u0002R\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/deliveryhero/fluid/values/codecs/composite/HorizontalGridCellsCodec;", "Lcom/deliveryhero/fluid/values/codecs/CellCodec;", "Lcom/deliveryhero/fluid/widgets/collections/grid/horizontal/HorizontalGridCell;", "()V", "valueType", "Lcom/deliveryhero/fluid/values/ValueType;", "getValueType", "()Lcom/deliveryhero/fluid/values/ValueType;", "decode", "", "encoded", "Lcom/deliveryhero/fluid/widgets/collections/RawCell;", "encode", "decoded", "toFloat", "", "Lcom/deliveryhero/fluid/widgets/collections/Cell$Size;", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class HorizontalGridCellsCodec implements CellCodec<HorizontalGridCell> {
    @NotNull
    public static final HorizontalGridCellsCodec INSTANCE = new HorizontalGridCellsCodec();
    @NotNull
    private static final ValueType valueType = ValueType.HORIZONTAL_GRID_CELL;

    private HorizontalGridCellsCodec() {
    }

    private final float toFloat(Cell.Size size) {
        if (size instanceof Cell.Size.Absolute) {
            return ((Cell.Size.Absolute) size).m8195unboximpl().getValue();
        }
        if (size instanceof Cell.Size.Relative) {
            return ((Cell.Size.Relative) size).m8202unboximpl();
        }
        throw new NoWhenBranchMatchedException();
    }

    @NotNull
    public ValueType getValueType() {
        return valueType;
    }

    @NotNull
    public List<HorizontalGridCell> decode(@NotNull List<RawCell> list) {
        HorizontalGridCell horizontalGridCell;
        Intrinsics.checkNotNullParameter(list, "encoded");
        ArrayList arrayList = new ArrayList();
        for (RawCell rawCell : list) {
            try {
                Float width = rawCell.getWidth();
                if (width != null) {
                    float floatValue = width.floatValue();
                    Cell.Size r22 = floatValue <= 1.0f ? Cell.Size.Relative.m8196boximpl(Cell.Size.Relative.m8197constructorimpl(floatValue)) : Cell.Size.Absolute.m8189boximpl(Cell.Size.Absolute.m8190constructorimpl(new LogicalPixel(floatValue)));
                    Float height = rawCell.getHeight();
                    Intrinsics.checkNotNull(height);
                    horizontalGridCell = new HorizontalGridCell(r22, Cell.Size.Relative.m8196boximpl(Cell.Size.Relative.m8197constructorimpl(height.floatValue())), rawCell.getTemplate(), rawCell.getData());
                    if (horizontalGridCell != null) {
                        arrayList.add(horizontalGridCell);
                    }
                } else {
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
            } catch (Throwable unused) {
                horizontalGridCell = null;
            }
        }
        return arrayList;
    }

    @NotNull
    public List<RawCell> encode(@NotNull List<HorizontalGridCell> list) {
        Intrinsics.checkNotNullParameter(list, "decoded");
        Iterable<HorizontalGridCell> iterable = list;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
        for (HorizontalGridCell horizontalGridCell : iterable) {
            Template template = horizontalGridCell.getTemplate();
            TemplateUiData data = horizontalGridCell.getData();
            HorizontalGridCellsCodec horizontalGridCellsCodec = INSTANCE;
            arrayList.add(new RawCell(template, data, Float.valueOf(horizontalGridCellsCodec.toFloat(horizontalGridCell.getWidth())), Float.valueOf(horizontalGridCellsCodec.toFloat(horizontalGridCell.getHeight()))));
        }
        return arrayList;
    }
}
