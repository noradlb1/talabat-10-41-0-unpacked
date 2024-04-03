package com.talabat.feature.darkstorescartlist.domain.di;

import com.talabat.core.di.Api;
import com.talabat.feature.darkstorescartlist.domain.repository.DarkstoresCartListRepository;
import com.talabat.feature.darkstorescartlist.domain.usecase.GetCartListToastUseCase;
import com.talabat.feature.darkstorescartlist.domain.usecase.InvalidateCartListCacheUseCase;
import com.talabat.feature.darkstorescartlist.domain.usecase.IsMultiBasketEnabledUseCase;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\tH&¨\u0006\n"}, d2 = {"Lcom/talabat/feature/darkstorescartlist/domain/di/DarkstoresCartListApi;", "Lcom/talabat/core/di/Api;", "cartListRepository", "Lcom/talabat/feature/darkstorescartlist/domain/repository/DarkstoresCartListRepository;", "getCartListToastUseCase", "Lcom/talabat/feature/darkstorescartlist/domain/usecase/GetCartListToastUseCase;", "invalidateCartListCacheUseCase", "Lcom/talabat/feature/darkstorescartlist/domain/usecase/InvalidateCartListCacheUseCase;", "isMultiBasketEnabledUseCase", "Lcom/talabat/feature/darkstorescartlist/domain/usecase/IsMultiBasketEnabledUseCase;", "com_talabat_feature_darkstores-cart-list_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface DarkstoresCartListApi extends Api {
    @NotNull
    DarkstoresCartListRepository cartListRepository();

    @NotNull
    GetCartListToastUseCase getCartListToastUseCase();

    @NotNull
    InvalidateCartListCacheUseCase invalidateCartListCacheUseCase();

    @NotNull
    IsMultiBasketEnabledUseCase isMultiBasketEnabledUseCase();
}
