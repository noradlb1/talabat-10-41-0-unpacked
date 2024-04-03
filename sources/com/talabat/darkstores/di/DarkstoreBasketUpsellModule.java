package com.talabat.darkstores.di;

import com.talabat.darkstores.data.basket.BasketUpsellRepositoryImpl;
import com.talabat.darkstores.data.basket.local.BasketUpsellLocalDataSource;
import com.talabat.darkstores.data.basket.local.BasketUpsellLocalDataSourceImpl;
import com.talabat.darkstores.domain.basket.BasketUpsellRepository;
import com.talabat.darkstores.domain.basket.IsBasketUpsellBottomSheetShownUseCase;
import com.talabat.darkstores.domain.basket.IsBasketUpsellBottomSheetShownUseCaseImpl;
import com.talabat.darkstores.domain.basket.IsBasketUpsellExperimentEnabledUseCase;
import com.talabat.darkstores.domain.basket.IsBasketUpsellExperimentEnabledUseCaseImpl;
import com.talabat.darkstores.domain.basket.SaveBasketUpsellBottomSheetShownUseCase;
import com.talabat.darkstores.domain.basket.SaveBasketUpsellBottomSheetShownUseCaseImpl;
import com.talabat.darkstores.domain.common.BuildBasketUpsellActionUseCase;
import com.talabat.darkstores.domain.common.BuildBasketUpsellActionUseCaseImpl;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u000bH\u0007J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u000eH\u0007J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\u0011H\u0007J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0007\u001a\u00020\u0014H\u0007¨\u0006\u0015"}, d2 = {"Lcom/talabat/darkstores/di/DarkstoreBasketUpsellModule;", "", "()V", "providesBasketUpsellLocalDataSource", "Lcom/talabat/darkstores/data/basket/local/BasketUpsellLocalDataSource;", "providesBasketUpsellRepository", "Lcom/talabat/darkstores/domain/basket/BasketUpsellRepository;", "impl", "Lcom/talabat/darkstores/data/basket/BasketUpsellRepositoryImpl;", "providesBuildBasketUpsellActionUseCaseImpl", "Lcom/talabat/darkstores/domain/common/BuildBasketUpsellActionUseCase;", "Lcom/talabat/darkstores/domain/common/BuildBasketUpsellActionUseCaseImpl;", "providesIsBasketUpsellBottomSheetShownUseCase", "Lcom/talabat/darkstores/domain/basket/IsBasketUpsellBottomSheetShownUseCase;", "Lcom/talabat/darkstores/domain/basket/IsBasketUpsellBottomSheetShownUseCaseImpl;", "providesIsBasketUpsellExperimentEnabledUseCaseImpl", "Lcom/talabat/darkstores/domain/basket/IsBasketUpsellExperimentEnabledUseCase;", "Lcom/talabat/darkstores/domain/basket/IsBasketUpsellExperimentEnabledUseCaseImpl;", "providesSaveBasketUpsellBottomSheetShownUseCase", "Lcom/talabat/darkstores/domain/basket/SaveBasketUpsellBottomSheetShownUseCase;", "Lcom/talabat/darkstores/domain/basket/SaveBasketUpsellBottomSheetShownUseCaseImpl;", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
public final class DarkstoreBasketUpsellModule {
    @NotNull
    public static final DarkstoreBasketUpsellModule INSTANCE = new DarkstoreBasketUpsellModule();

    private DarkstoreBasketUpsellModule() {
    }

    @NotNull
    @Provides
    public final BasketUpsellLocalDataSource providesBasketUpsellLocalDataSource() {
        return BasketUpsellLocalDataSourceImpl.INSTANCE;
    }

    @NotNull
    @Provides
    public final BasketUpsellRepository providesBasketUpsellRepository(@NotNull BasketUpsellRepositoryImpl basketUpsellRepositoryImpl) {
        Intrinsics.checkNotNullParameter(basketUpsellRepositoryImpl, "impl");
        return basketUpsellRepositoryImpl;
    }

    @NotNull
    @Provides
    public final BuildBasketUpsellActionUseCase providesBuildBasketUpsellActionUseCaseImpl(@NotNull BuildBasketUpsellActionUseCaseImpl buildBasketUpsellActionUseCaseImpl) {
        Intrinsics.checkNotNullParameter(buildBasketUpsellActionUseCaseImpl, "impl");
        return buildBasketUpsellActionUseCaseImpl;
    }

    @NotNull
    @Provides
    public final IsBasketUpsellBottomSheetShownUseCase providesIsBasketUpsellBottomSheetShownUseCase(@NotNull IsBasketUpsellBottomSheetShownUseCaseImpl isBasketUpsellBottomSheetShownUseCaseImpl) {
        Intrinsics.checkNotNullParameter(isBasketUpsellBottomSheetShownUseCaseImpl, "impl");
        return isBasketUpsellBottomSheetShownUseCaseImpl;
    }

    @NotNull
    @Provides
    public final IsBasketUpsellExperimentEnabledUseCase providesIsBasketUpsellExperimentEnabledUseCaseImpl(@NotNull IsBasketUpsellExperimentEnabledUseCaseImpl isBasketUpsellExperimentEnabledUseCaseImpl) {
        Intrinsics.checkNotNullParameter(isBasketUpsellExperimentEnabledUseCaseImpl, "impl");
        return isBasketUpsellExperimentEnabledUseCaseImpl;
    }

    @NotNull
    @Provides
    public final SaveBasketUpsellBottomSheetShownUseCase providesSaveBasketUpsellBottomSheetShownUseCase(@NotNull SaveBasketUpsellBottomSheetShownUseCaseImpl saveBasketUpsellBottomSheetShownUseCaseImpl) {
        Intrinsics.checkNotNullParameter(saveBasketUpsellBottomSheetShownUseCaseImpl, "impl");
        return saveBasketUpsellBottomSheetShownUseCaseImpl;
    }
}
