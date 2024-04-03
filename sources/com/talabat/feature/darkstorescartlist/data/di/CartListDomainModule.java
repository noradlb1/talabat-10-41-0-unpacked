package com.talabat.feature.darkstorescartlist.data.di;

import com.talabat.feature.darkstorescartlist.domain.usecase.GetCartListToastUseCase;
import com.talabat.feature.darkstorescartlist.domain.usecase.GetCartListToastUseCaseImpl;
import com.talabat.feature.darkstorescartlist.domain.usecase.InvalidateCartListCacheUseCase;
import com.talabat.feature.darkstorescartlist.domain.usecase.InvalidateCartListCacheUseCaseImpl;
import com.talabat.feature.darkstorescartlist.domain.usecase.IsMultiBasketCommunicationExperimentEnabledUseCase;
import com.talabat.feature.darkstorescartlist.domain.usecase.IsMultiBasketCommunicationExperimentEnabledUseCaseImpl;
import com.talabat.feature.darkstorescartlist.domain.usecase.IsMultiBasketEnabledUseCase;
import com.talabat.feature.darkstorescartlist.domain.usecase.IsMultiBasketEnabledUseCaseImpl;
import dagger.Binds;
import dagger.Module;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\bH'J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u000bH'J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u000eH'¨\u0006\u000f"}, d2 = {"Lcom/talabat/feature/darkstorescartlist/data/di/CartListDomainModule;", "", "bindGetCartListToastUseCase", "Lcom/talabat/feature/darkstorescartlist/domain/usecase/GetCartListToastUseCase;", "impl", "Lcom/talabat/feature/darkstorescartlist/domain/usecase/GetCartListToastUseCaseImpl;", "bindInvalidateCartListCacheUseCase", "Lcom/talabat/feature/darkstorescartlist/domain/usecase/InvalidateCartListCacheUseCase;", "Lcom/talabat/feature/darkstorescartlist/domain/usecase/InvalidateCartListCacheUseCaseImpl;", "bindIsMultiBasketCommunicationExperimentEnabledUseCase", "Lcom/talabat/feature/darkstorescartlist/domain/usecase/IsMultiBasketCommunicationExperimentEnabledUseCase;", "Lcom/talabat/feature/darkstorescartlist/domain/usecase/IsMultiBasketCommunicationExperimentEnabledUseCaseImpl;", "bindIsMultiBasketEnabledUseCase", "Lcom/talabat/feature/darkstorescartlist/domain/usecase/IsMultiBasketEnabledUseCase;", "Lcom/talabat/feature/darkstorescartlist/domain/usecase/IsMultiBasketEnabledUseCaseImpl;", "com_talabat_feature_darkstores-cart-list_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
public interface CartListDomainModule {
    @NotNull
    @Binds
    GetCartListToastUseCase bindGetCartListToastUseCase(@NotNull GetCartListToastUseCaseImpl getCartListToastUseCaseImpl);

    @NotNull
    @Binds
    InvalidateCartListCacheUseCase bindInvalidateCartListCacheUseCase(@NotNull InvalidateCartListCacheUseCaseImpl invalidateCartListCacheUseCaseImpl);

    @NotNull
    @Binds
    IsMultiBasketCommunicationExperimentEnabledUseCase bindIsMultiBasketCommunicationExperimentEnabledUseCase(@NotNull IsMultiBasketCommunicationExperimentEnabledUseCaseImpl isMultiBasketCommunicationExperimentEnabledUseCaseImpl);

    @NotNull
    @Binds
    IsMultiBasketEnabledUseCase bindIsMultiBasketEnabledUseCase(@NotNull IsMultiBasketEnabledUseCaseImpl isMultiBasketEnabledUseCaseImpl);
}
