package com.talabat.darkstores.feature.search.listener;

import com.talabat.feature.darkstorescart.data.model.Product;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/talabat/darkstores/feature/search/listener/PreSearchSwimlaneListener;", "", "onPreSearchProductClicked", "", "product", "Lcom/talabat/feature/darkstorescart/data/model/Product;", "position", "", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface PreSearchSwimlaneListener {
    void onPreSearchProductClicked(@NotNull Product product, int i11);
}
