package com.talabat.feature.activecarts.data.di;

import com.talabat.feature.activecarts.domain.channel.ActiveCartsMethodCallHandler;
import com.talabat.feature.activecarts.domain.channel.ActiveCartsMethodCallHandlerImpl;
import com.talabat.feature.activecarts.domain.usecase.GetActiveCartInfoUseCaseImpl;
import com.talabat.feature.activecarts.domain.usecase.GetCartListUseCase;
import com.talabat.feature.activecarts.domain.usecase.GetCartListUseCaseImpl;
import com.talabat.feature.activecarts.domain.usecase.GetFoodCartUseCase;
import com.talabat.feature.activecarts.domain.usecase.GetFoodCartUseCaseImpl;
import com.talabat.feature.activecarts.domain.usecase.GetQCommerceCartListUseCase;
import com.talabat.feature.activecarts.domain.usecase.GetQCommerceCartListUseCaseImpl;
import com.talabat.feature.activecarts.domain.usecase.TrackCartLoadedEventUseCase;
import com.talabat.feature.activecarts.domain.usecase.TrackCartLoadedEventUseCaseImpl;
import dagger.Binds;
import dagger.Module;
import kotlin.Metadata;
import library.talabat.mvp.home.domain.GetActiveCartInfoUseCase;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\bH'J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u000bH'J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u000eH'J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0004\u001a\u00020\u0011H'J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0004\u001a\u00020\u0014H'¨\u0006\u0015"}, d2 = {"Lcom/talabat/feature/activecarts/data/di/ActiveCartsDomainModule;", "", "bindGetActiveCartInfoUseCase", "Llibrary/talabat/mvp/home/domain/GetActiveCartInfoUseCase;", "impl", "Lcom/talabat/feature/activecarts/domain/usecase/GetActiveCartInfoUseCaseImpl;", "bindGetCartListUseCase", "Lcom/talabat/feature/activecarts/domain/usecase/GetCartListUseCase;", "Lcom/talabat/feature/activecarts/domain/usecase/GetCartListUseCaseImpl;", "bindGetFoodCartUseCase", "Lcom/talabat/feature/activecarts/domain/usecase/GetFoodCartUseCase;", "Lcom/talabat/feature/activecarts/domain/usecase/GetFoodCartUseCaseImpl;", "bindGetQCommerceCartListUseCase", "Lcom/talabat/feature/activecarts/domain/usecase/GetQCommerceCartListUseCase;", "Lcom/talabat/feature/activecarts/domain/usecase/GetQCommerceCartListUseCaseImpl;", "bindTrackCartLoadedEventUseCase", "Lcom/talabat/feature/activecarts/domain/usecase/TrackCartLoadedEventUseCase;", "Lcom/talabat/feature/activecarts/domain/usecase/TrackCartLoadedEventUseCaseImpl;", "provideActiveCartsMethodCallHandler", "Lcom/talabat/feature/activecarts/domain/channel/ActiveCartsMethodCallHandler;", "Lcom/talabat/feature/activecarts/domain/channel/ActiveCartsMethodCallHandlerImpl;", "com_talabat_feature_active-carts_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
public interface ActiveCartsDomainModule {
    @NotNull
    @Binds
    GetActiveCartInfoUseCase bindGetActiveCartInfoUseCase(@NotNull GetActiveCartInfoUseCaseImpl getActiveCartInfoUseCaseImpl);

    @NotNull
    @Binds
    GetCartListUseCase bindGetCartListUseCase(@NotNull GetCartListUseCaseImpl getCartListUseCaseImpl);

    @NotNull
    @Binds
    GetFoodCartUseCase bindGetFoodCartUseCase(@NotNull GetFoodCartUseCaseImpl getFoodCartUseCaseImpl);

    @NotNull
    @Binds
    GetQCommerceCartListUseCase bindGetQCommerceCartListUseCase(@NotNull GetQCommerceCartListUseCaseImpl getQCommerceCartListUseCaseImpl);

    @NotNull
    @Binds
    TrackCartLoadedEventUseCase bindTrackCartLoadedEventUseCase(@NotNull TrackCartLoadedEventUseCaseImpl trackCartLoadedEventUseCaseImpl);

    @NotNull
    @Binds
    ActiveCartsMethodCallHandler provideActiveCartsMethodCallHandler(@NotNull ActiveCartsMethodCallHandlerImpl activeCartsMethodCallHandlerImpl);
}
