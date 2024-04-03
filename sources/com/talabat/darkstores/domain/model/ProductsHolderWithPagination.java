package com.talabat.darkstores.domain.model;

import com.talabat.darkstores.data.SearchCategory;
import com.talabat.darkstores.domain.model.ProductsHolder;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b`\u0018\u0000*\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0002R\u001a\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0012\u0010\b\u001a\u00020\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\nR\u0012\u0010\u000b\u001a\u00020\fX¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/talabat/darkstores/domain/model/ProductsHolderWithPagination;", "T", "Lcom/talabat/darkstores/domain/model/ProductsHolder;", "categories", "", "Lcom/talabat/darkstores/data/SearchCategory;", "getCategories", "()Ljava/util/List;", "isLast", "", "()Z", "pageNumber", "", "getPageNumber", "()I", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface ProductsHolderWithPagination<T extends ProductsHolder<T>> extends ProductsHolder<T> {
    @Nullable
    List<SearchCategory> getCategories();

    int getPageNumber();

    boolean isLast();
}
