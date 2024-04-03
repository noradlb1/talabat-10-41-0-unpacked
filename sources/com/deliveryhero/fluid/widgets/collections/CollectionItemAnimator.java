package com.deliveryhero.fluid.widgets.collections;

import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016¨\u0006\n"}, d2 = {"Lcom/deliveryhero/fluid/widgets/collections/CollectionItemAnimator;", "Landroidx/recyclerview/widget/DefaultItemAnimator;", "()V", "canReuseUpdatedViewHolder", "", "viewHolder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "payloads", "", "", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CollectionItemAnimator extends DefaultItemAnimator {
    public boolean canReuseUpdatedViewHolder(@NotNull RecyclerView.ViewHolder viewHolder, @NotNull List<Object> list) {
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        Intrinsics.checkNotNullParameter(list, "payloads");
        return true;
    }
}
