package com.deliveryhero.fluid.values.codecs.composite;

import com.deliveryhero.fluid.values.LogicalPixel;
import com.deliveryhero.fluid.values.ValueType;
import com.deliveryhero.fluid.values.codecs.CellCodec;
import com.deliveryhero.fluid.widgets.collections.Cell;
import com.deliveryhero.fluid.widgets.collections.RawCell;
import com.deliveryhero.fluid.widgets.collections.pager.PagerCell;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u001c\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\tH\u0016J\u001c\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\t2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\tH\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000e"}, d2 = {"Lcom/deliveryhero/fluid/values/codecs/composite/PagerCellsCodec;", "Lcom/deliveryhero/fluid/values/codecs/CellCodec;", "Lcom/deliveryhero/fluid/widgets/collections/pager/PagerCell;", "()V", "valueType", "Lcom/deliveryhero/fluid/values/ValueType;", "getValueType", "()Lcom/deliveryhero/fluid/values/ValueType;", "decode", "", "encoded", "Lcom/deliveryhero/fluid/widgets/collections/RawCell;", "encode", "decoded", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PagerCellsCodec implements CellCodec<PagerCell> {
    @NotNull
    public static final PagerCellsCodec INSTANCE = new PagerCellsCodec();
    @NotNull
    private static final ValueType valueType = ValueType.PAGER_CELL;

    private PagerCellsCodec() {
    }

    @NotNull
    public ValueType getValueType() {
        return valueType;
    }

    @NotNull
    public List<PagerCell> decode(@NotNull List<RawCell> list) {
        Intrinsics.checkNotNullParameter(list, "encoded");
        ArrayList arrayList = new ArrayList();
        for (RawCell rawCell : list) {
            PagerCell pagerCell = null;
            try {
                Float height = rawCell.getHeight();
                pagerCell = new PagerCell(Cell.Size.Absolute.m8190constructorimpl(new LogicalPixel(height != null ? height.floatValue() : 0.0f)), rawCell.getTemplate(), rawCell.getData(), (DefaultConstructorMarker) null);
            } catch (Throwable unused) {
            }
            if (pagerCell != null) {
                arrayList.add(pagerCell);
            }
        }
        return arrayList;
    }

    @NotNull
    public List<RawCell> encode(@NotNull List<PagerCell> list) {
        Intrinsics.checkNotNullParameter(list, "decoded");
        Iterable<PagerCell> iterable = list;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
        for (PagerCell pagerCell : iterable) {
            arrayList.add(new RawCell(pagerCell.getTemplate(), pagerCell.getData(), (Float) null, (Float) null, 12, (DefaultConstructorMarker) null));
        }
        return arrayList;
    }
}
