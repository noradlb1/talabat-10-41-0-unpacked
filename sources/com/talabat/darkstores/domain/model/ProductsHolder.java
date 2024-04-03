package com.talabat.darkstores.domain.model;

import com.talabat.darkstores.domain.model.ProductsHolder;
import com.talabat.feature.darkstorescart.data.model.Product;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u0000*\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00002\u00020\u0002J\u001b\u0010\b\u001a\u00028\u00002\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H&¢\u0006\u0002\u0010\nR\u0018\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/talabat/darkstores/domain/model/ProductsHolder;", "T", "", "products", "", "Lcom/talabat/feature/darkstorescart/data/model/Product;", "getProducts", "()Ljava/util/List;", "withProducts", "newProducts", "(Ljava/util/List;)Lcom/talabat/darkstores/domain/model/ProductsHolder;", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface ProductsHolder<T extends ProductsHolder<T>> {
    @NotNull
    List<Product> getProducts();

    @NotNull
    T withProducts(@NotNull List<Product> list);
}
