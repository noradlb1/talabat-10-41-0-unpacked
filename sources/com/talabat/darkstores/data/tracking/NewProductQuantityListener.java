package com.talabat.darkstores.data.tracking;

import com.talabat.feature.darkstorescart.data.model.Product;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b`\u0018\u00002\u00020\u0001J'\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0002\u0010\tJ'\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0002\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/talabat/darkstores/data/tracking/NewProductQuantityListener;", "", "onProductAdded", "", "product", "Lcom/talabat/feature/darkstorescart/data/model/Product;", "quantity", "", "listPosition", "(Lcom/talabat/feature/darkstorescart/data/model/Product;ILjava/lang/Integer;)V", "onProductRemoved", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface NewProductQuantityListener {
    void onProductAdded(@NotNull Product product, int i11, @Nullable Integer num);

    void onProductRemoved(@NotNull Product product, int i11, @Nullable Integer num);
}
