package com.deliveryhero.fluid.widgets.collections;

import androidx.recyclerview.widget.DiffUtil;
import com.deliveryhero.fluid.widgets.collections.Cell;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u001d\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00028\u00002\u0006\u0010\b\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\tJ\u001d\u0010\n\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00028\u00002\u0006\u0010\b\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/deliveryhero/fluid/widgets/collections/CellDiffer;", "CellT", "Lcom/deliveryhero/fluid/widgets/collections/Cell;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "()V", "areContentsTheSame", "", "oldItem", "newItem", "(Lcom/deliveryhero/fluid/widgets/collections/Cell;Lcom/deliveryhero/fluid/widgets/collections/Cell;)Z", "areItemsTheSame", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CellDiffer<CellT extends Cell> extends DiffUtil.ItemCallback<CellT> {
    public boolean areContentsTheSame(@NotNull CellT cellt, @NotNull CellT cellt2) {
        Intrinsics.checkNotNullParameter(cellt, "oldItem");
        Intrinsics.checkNotNullParameter(cellt2, "newItem");
        return Intrinsics.areEqual((Object) cellt.getData(), (Object) cellt2.getData());
    }

    public boolean areItemsTheSame(@NotNull CellT cellt, @NotNull CellT cellt2) {
        Intrinsics.checkNotNullParameter(cellt, "oldItem");
        Intrinsics.checkNotNullParameter(cellt2, "newItem");
        return Intrinsics.areEqual((Object) cellt.getData().getId(), (Object) cellt2.getData().getId());
    }
}
