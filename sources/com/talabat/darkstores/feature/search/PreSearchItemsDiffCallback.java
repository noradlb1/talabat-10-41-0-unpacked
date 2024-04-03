package com.talabat.darkstores.feature.search;

import androidx.annotation.VisibleForTesting;
import androidx.recyclerview.widget.DiffUtil;
import com.talabat.darkstores.feature.model.PreSearchItem;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¨\u0006\t"}, d2 = {"Lcom/talabat/darkstores/feature/search/PreSearchItemsDiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/talabat/darkstores/feature/model/PreSearchItem;", "()V", "areContentsTheSame", "", "oldItem", "newItem", "areItemsTheSame", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
@VisibleForTesting
public final class PreSearchItemsDiffCallback extends DiffUtil.ItemCallback<PreSearchItem> {
    public boolean areItemsTheSame(@NotNull PreSearchItem preSearchItem, @NotNull PreSearchItem preSearchItem2) {
        Intrinsics.checkNotNullParameter(preSearchItem, "oldItem");
        Intrinsics.checkNotNullParameter(preSearchItem2, "newItem");
        return preSearchItem == preSearchItem2;
    }

    public boolean areContentsTheSame(@NotNull PreSearchItem preSearchItem, @NotNull PreSearchItem preSearchItem2) {
        Intrinsics.checkNotNullParameter(preSearchItem, "oldItem");
        Intrinsics.checkNotNullParameter(preSearchItem2, "newItem");
        return Intrinsics.areEqual((Object) preSearchItem, (Object) preSearchItem2);
    }
}
