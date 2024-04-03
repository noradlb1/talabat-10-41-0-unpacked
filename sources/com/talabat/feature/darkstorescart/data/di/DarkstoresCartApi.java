package com.talabat.feature.darkstorescart.data.di;

import com.talabat.core.di.Api;
import com.talabat.feature.darkstorescart.data.repository.DarkstoresCartRepository;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/talabat/feature/darkstorescart/data/di/DarkstoresCartApi;", "Lcom/talabat/core/di/Api;", "cartRepository", "Lcom/talabat/feature/darkstorescart/data/repository/DarkstoresCartRepository;", "com_talabat_feature_darkstores-cart_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface DarkstoresCartApi extends Api {
    @NotNull
    DarkstoresCartRepository cartRepository();
}
