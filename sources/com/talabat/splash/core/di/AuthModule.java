package com.talabat.splash.core.di;

import com.talabat.authentication.token.domain.repository.ClearOwinStartupUseCase;
import com.talabat.authentication.token.domain.repository.ClearOwinUseCase;
import com.talabat.splash.domain.usecase.ClearOwinStartupUseCaseImpl;
import com.talabat.userandlocation.token.ClearOwinUseCaseImpl;
import dagger.Binds;
import dagger.Module;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\bH'¨\u0006\t"}, d2 = {"Lcom/talabat/splash/core/di/AuthModule;", "", "clearOwinStartupUseCase", "Lcom/talabat/authentication/token/domain/repository/ClearOwinStartupUseCase;", "impl", "Lcom/talabat/splash/domain/usecase/ClearOwinStartupUseCaseImpl;", "clearOwinUseCase", "Lcom/talabat/authentication/token/domain/repository/ClearOwinUseCase;", "Lcom/talabat/userandlocation/token/ClearOwinUseCaseImpl;", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
public interface AuthModule {
    @NotNull
    @Binds
    ClearOwinStartupUseCase clearOwinStartupUseCase(@NotNull ClearOwinStartupUseCaseImpl clearOwinStartupUseCaseImpl);

    @NotNull
    @Binds
    ClearOwinUseCase clearOwinUseCase(@NotNull ClearOwinUseCaseImpl clearOwinUseCaseImpl);
}
