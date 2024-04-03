package com.talabat.feature.bnplcore.data.di;

import com.talabat.feature.bnplcore.data.repository.BnplRepositoryImpl;
import com.talabat.feature.bnplcore.domain.repository.BnplRepository;
import com.talabat.feature.bnplcore.domain.usecase.GetOverdueNotificationAcknowledgeUseCase;
import com.talabat.feature.bnplcore.domain.usecase.GetOverdueUseCase;
import com.talabat.feature.bnplcore.domain.usecase.SendNavigationOptionLoadedEventUseCase;
import com.talabat.feature.bnplcore.domain.usecase.UpdateOverdueAcknowledgeStateUseCase;
import com.talabat.feature.bnplcore.domain.usecase.impl.GetOverdueNotificationAcknowledgeUseCaseImpl;
import com.talabat.feature.bnplcore.domain.usecase.impl.GetOverdueUseCaseImpl;
import com.talabat.feature.bnplcore.domain.usecase.impl.SendNavigationOptionLoadedEventUseCaseImpl;
import com.talabat.feature.bnplcore.domain.usecase.impl.UpdateOverdueAcknowledgeStateUseCaseImpl;
import dagger.Binds;
import dagger.Module;
import dagger.Reusable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b'\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H'J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH'J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH'J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H'J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H'¨\u0006\u0017"}, d2 = {"Lcom/talabat/feature/bnplcore/data/di/BnplModule;", "", "()V", "provideBNPLRepository", "Lcom/talabat/feature/bnplcore/domain/repository/BnplRepository;", "bnplRepositoryImpl", "Lcom/talabat/feature/bnplcore/data/repository/BnplRepositoryImpl;", "provideGetOverdueUseCase", "Lcom/talabat/feature/bnplcore/domain/usecase/GetOverdueUseCase;", "getOverdueUseCaseImpl", "Lcom/talabat/feature/bnplcore/domain/usecase/impl/GetOverdueUseCaseImpl;", "provideIsOverdueNotificationAcknowledgeUseCase", "Lcom/talabat/feature/bnplcore/domain/usecase/GetOverdueNotificationAcknowledgeUseCase;", "isOverdueNotificationAcknowledgeUseCaseImpl", "Lcom/talabat/feature/bnplcore/domain/usecase/impl/GetOverdueNotificationAcknowledgeUseCaseImpl;", "provideSendNavigationOptionLoadedEventUseCase", "Lcom/talabat/feature/bnplcore/domain/usecase/SendNavigationOptionLoadedEventUseCase;", "sendNavigationOptionLoadedEventUseCaseImpl", "Lcom/talabat/feature/bnplcore/domain/usecase/impl/SendNavigationOptionLoadedEventUseCaseImpl;", "provideUpdateOverdueAcknowledgeStateUseCase", "Lcom/talabat/feature/bnplcore/domain/usecase/UpdateOverdueAcknowledgeStateUseCase;", "updateOverdueAcknowledgeStateUseCaseImpl", "Lcom/talabat/feature/bnplcore/domain/usecase/impl/UpdateOverdueAcknowledgeStateUseCaseImpl;", "com_talabat_feature_bnpl-core_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module(includes = {BnplNetworkModule.class})
public abstract class BnplModule {
    @NotNull
    @Binds
    @Reusable
    public abstract BnplRepository provideBNPLRepository(@NotNull BnplRepositoryImpl bnplRepositoryImpl);

    @NotNull
    @Binds
    @Reusable
    public abstract GetOverdueUseCase provideGetOverdueUseCase(@NotNull GetOverdueUseCaseImpl getOverdueUseCaseImpl);

    @NotNull
    @Binds
    @Reusable
    public abstract GetOverdueNotificationAcknowledgeUseCase provideIsOverdueNotificationAcknowledgeUseCase(@NotNull GetOverdueNotificationAcknowledgeUseCaseImpl getOverdueNotificationAcknowledgeUseCaseImpl);

    @NotNull
    @Binds
    @Reusable
    public abstract SendNavigationOptionLoadedEventUseCase provideSendNavigationOptionLoadedEventUseCase(@NotNull SendNavigationOptionLoadedEventUseCaseImpl sendNavigationOptionLoadedEventUseCaseImpl);

    @NotNull
    @Binds
    @Reusable
    public abstract UpdateOverdueAcknowledgeStateUseCase provideUpdateOverdueAcknowledgeStateUseCase(@NotNull UpdateOverdueAcknowledgeStateUseCaseImpl updateOverdueAcknowledgeStateUseCaseImpl);
}
