package com.talabat.darkstores.data.search;

import com.talabat.darkstores.data.search.model.QCommerceSearchResultsResponse;
import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1Impl;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public /* synthetic */ class SearchRepository$searchProductsQCommerce$1$1 extends PropertyReference1Impl {
    public static final SearchRepository$searchProductsQCommerce$1$1 INSTANCE = new SearchRepository$searchProductsQCommerce$1$1();

    public SearchRepository$searchProductsQCommerce$1$1() {
        super(QCommerceSearchResultsResponse.class, "result", "getResult()Lcom/talabat/darkstores/data/search/model/SearchResultsResponse;", 0);
    }

    @Nullable
    public Object get(@Nullable Object obj) {
        return ((QCommerceSearchResultsResponse) obj).getResult();
    }
}
