package com.talabat.splash.domain.usecase;

import com.talabat.splash.core.interactor.InternalUseCaseWithBoolean;
import com.talabat.splash.data.repositories.AppInfoRepository;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/talabat/splash/domain/usecase/SetAppConfigUseCase;", "Lcom/talabat/splash/core/interactor/InternalUseCaseWithBoolean;", "appInfoRepository", "Lcom/talabat/splash/data/repositories/AppInfoRepository;", "(Lcom/talabat/splash/data/repositories/AppInfoRepository;)V", "execute", "", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SetAppConfigUseCase extends InternalUseCaseWithBoolean {
    @NotNull
    private final AppInfoRepository appInfoRepository;

    @Inject
    public SetAppConfigUseCase(@NotNull AppInfoRepository appInfoRepository2) {
        Intrinsics.checkNotNullParameter(appInfoRepository2, "appInfoRepository");
        this.appInfoRepository = appInfoRepository2;
    }

    public boolean execute() {
        return this.appInfoRepository.setInitalAppPreferences();
    }
}
