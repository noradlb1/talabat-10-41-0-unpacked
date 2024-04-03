package com.talabat.userandlocation.choosecountry.di.module;

import com.talabat.userandlocation.choosecountry.domain.usecase.business.RequestAreasToCacheUseCase;
import com.talabat.userandlocation.choosecountry.domain.usecase.business.impl.RequestAreasToCacheUseCaseImpl;
import dagger.Binds;
import dagger.Module;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'¨\u0006\u0006"}, d2 = {"Lcom/talabat/userandlocation/choosecountry/di/module/AreasModule;", "", "requestAreaUseCase", "Lcom/talabat/userandlocation/choosecountry/domain/usecase/business/RequestAreasToCacheUseCase;", "real", "Lcom/talabat/userandlocation/choosecountry/domain/usecase/business/impl/RequestAreasToCacheUseCaseImpl;", "com_talabat_NewArchi_UserAndLocation_ChooseCountry_ChooseCountry"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
public interface AreasModule {
    @NotNull
    @Binds
    RequestAreasToCacheUseCase requestAreaUseCase(@NotNull RequestAreasToCacheUseCaseImpl requestAreasToCacheUseCaseImpl);
}
