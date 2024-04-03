package com.talabat.adapters.previousorders;

import JsonModels.Response.PreviousOrderList.PreviousOrder;
import androidx.recyclerview.widget.DiffUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¨\u0006\t"}, d2 = {"Lcom/talabat/adapters/previousorders/PreviousOrderDiffUtil;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "LJsonModels/Response/PreviousOrderList/PreviousOrder;", "()V", "areContentsTheSame", "", "oldItem", "newItem", "areItemsTheSame", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PreviousOrderDiffUtil extends DiffUtil.ItemCallback<PreviousOrder> {
    public boolean areContentsTheSame(@NotNull PreviousOrder previousOrder, @NotNull PreviousOrder previousOrder2) {
        Intrinsics.checkNotNullParameter(previousOrder, "oldItem");
        Intrinsics.checkNotNullParameter(previousOrder2, "newItem");
        return Intrinsics.areEqual((Object) previousOrder, (Object) previousOrder2);
    }

    public boolean areItemsTheSame(@NotNull PreviousOrder previousOrder, @NotNull PreviousOrder previousOrder2) {
        Intrinsics.checkNotNullParameter(previousOrder, "oldItem");
        Intrinsics.checkNotNullParameter(previousOrder2, "newItem");
        return Intrinsics.areEqual((Object) previousOrder.items, (Object) previousOrder2.items);
    }
}
