package com.talabat.darkstores.common.lists;

import androidx.recyclerview.widget.DiffUtil;
import com.talabat.feature.darkstorescart.data.model.Product;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J$\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0002H\u0016¨\u0006\u000f"}, d2 = {"Lcom/talabat/darkstores/common/lists/ProductDiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/talabat/feature/darkstorescart/data/model/Product;", "()V", "areContentsTheSame", "", "old", "new", "areItemsTheSame", "getChangePayload", "", "", "", "oldItem", "newItem", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ProductDiffCallback extends DiffUtil.ItemCallback<Product> {
    public boolean areContentsTheSame(@NotNull Product product, @NotNull Product product2) {
        Intrinsics.checkNotNullParameter(product, "old");
        Intrinsics.checkNotNullParameter(product2, "new");
        return Intrinsics.areEqual((Object) product, (Object) product2);
    }

    public boolean areItemsTheSame(@NotNull Product product, @NotNull Product product2) {
        Intrinsics.checkNotNullParameter(product, "old");
        Intrinsics.checkNotNullParameter(product2, "new");
        return Intrinsics.areEqual((Object) product.getId(), (Object) product2.getId());
    }

    @NotNull
    public Map<String, Integer> getChangePayload(@NotNull Product product, @NotNull Product product2) {
        Intrinsics.checkNotNullParameter(product, "oldItem");
        Intrinsics.checkNotNullParameter(product2, "newItem");
        return MapsKt__MapsJVMKt.mapOf(TuplesKt.to("count", Integer.valueOf(product2.getCartCount())));
    }
}
