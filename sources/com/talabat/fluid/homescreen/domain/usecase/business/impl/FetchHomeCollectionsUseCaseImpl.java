package com.talabat.fluid.homescreen.domain.usecase.business.impl;

import com.talabat.fluid.homescreen.data.remote.mapper.FluidHomeComponentRequestParamsProvider;
import com.talabat.fluid.homescreen.domain.repository.HomeConfigurationRepository;
import com.talabat.fluid.homescreen.domain.tracking.observability.HomeScreenPerformanceObservability;
import com.talabat.fluid.homescreen.domain.usecase.business.FetchHomeCollectionsUseCase;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0011\u0010\t\u001a\u00020\nH@ø\u0001\u0000¢\u0006\u0002\u0010\u000bJ\u0010\u0010\f\u001a\u0004\u0018\u00010\r*\u0004\u0018\u00010\u000eH\u0002J\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010*\u0004\u0018\u00010\u0011H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"Lcom/talabat/fluid/homescreen/domain/usecase/business/impl/FetchHomeCollectionsUseCaseImpl;", "Lcom/talabat/fluid/homescreen/domain/usecase/business/FetchHomeCollectionsUseCase;", "homeConfigurationRepository", "Lcom/talabat/fluid/homescreen/domain/repository/HomeConfigurationRepository;", "fluidHomeComponentRequestParamsProvider", "Lcom/talabat/fluid/homescreen/data/remote/mapper/FluidHomeComponentRequestParamsProvider;", "homeScreenPerformanceObservability", "Lcom/talabat/fluid/homescreen/domain/tracking/observability/HomeScreenPerformanceObservability;", "(Lcom/talabat/fluid/homescreen/domain/repository/HomeConfigurationRepository;Lcom/talabat/fluid/homescreen/data/remote/mapper/FluidHomeComponentRequestParamsProvider;Lcom/talabat/fluid/homescreen/domain/tracking/observability/HomeScreenPerformanceObservability;)V", "fetchHomeCollections", "Lcom/talabat/fluid/homescreen/domain/usecase/business/FetchHomeCollectionsUseCase$HomeCollectionResult;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toHomeCollectionConfiguration", "Lcom/talabat/fluid/homescreen/domain/usecase/business/FetchHomeCollectionsUseCase$HomeCollectionResult$Configuration;", "Lcom/talabat/fluid/homescreen/domain/repository/HomeConfigurationRepository$Components$Configuration;", "toHomeCollectionMetadata", "Lcom/talabat/fluid/homescreen/domain/usecase/business/FetchHomeCollectionsUseCase$HomeCollectionResult$Metadata;", "Lcom/talabat/fluid/homescreen/domain/repository/HomeConfigurationRepository$Components$Metadata;", "com_talabat_NewArchi_Homescreen_Homescreen"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FetchHomeCollectionsUseCaseImpl implements FetchHomeCollectionsUseCase {
    @NotNull
    private final FluidHomeComponentRequestParamsProvider fluidHomeComponentRequestParamsProvider;
    @NotNull
    private final HomeConfigurationRepository homeConfigurationRepository;
    @NotNull
    private final HomeScreenPerformanceObservability homeScreenPerformanceObservability;

    public FetchHomeCollectionsUseCaseImpl(@NotNull HomeConfigurationRepository homeConfigurationRepository2, @NotNull FluidHomeComponentRequestParamsProvider fluidHomeComponentRequestParamsProvider2, @NotNull HomeScreenPerformanceObservability homeScreenPerformanceObservability2) {
        Intrinsics.checkNotNullParameter(homeConfigurationRepository2, "homeConfigurationRepository");
        Intrinsics.checkNotNullParameter(fluidHomeComponentRequestParamsProvider2, "fluidHomeComponentRequestParamsProvider");
        Intrinsics.checkNotNullParameter(homeScreenPerformanceObservability2, "homeScreenPerformanceObservability");
        this.homeConfigurationRepository = homeConfigurationRepository2;
        this.fluidHomeComponentRequestParamsProvider = fluidHomeComponentRequestParamsProvider2;
        this.homeScreenPerformanceObservability = homeScreenPerformanceObservability2;
    }

    private final FetchHomeCollectionsUseCase.HomeCollectionResult.Configuration toHomeCollectionConfiguration(HomeConfigurationRepository.Components.Configuration configuration) {
        if (configuration != null) {
            return new FetchHomeCollectionsUseCase.HomeCollectionResult.Configuration(configuration.getNavigationBarColor(), configuration.getLocationHintColor(), configuration.getLocationTitleColor(), configuration.getLocationArrowTintColor());
        }
        return null;
    }

    private final FetchHomeCollectionsUseCase.HomeCollectionResult.Metadata toHomeCollectionMetadata(HomeConfigurationRepository.Components.Metadata metadata) {
        if (metadata != null) {
            return new FetchHomeCollectionsUseCase.HomeCollectionResult.Metadata(metadata.getClearVoucherCache());
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object fetchHomeCollections(@org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.talabat.fluid.homescreen.domain.usecase.business.FetchHomeCollectionsUseCase.HomeCollectionResult> r11) {
        /*
            r10 = this;
            boolean r0 = r11 instanceof com.talabat.fluid.homescreen.domain.usecase.business.impl.FetchHomeCollectionsUseCaseImpl$fetchHomeCollections$1
            if (r0 == 0) goto L_0x0013
            r0 = r11
            com.talabat.fluid.homescreen.domain.usecase.business.impl.FetchHomeCollectionsUseCaseImpl$fetchHomeCollections$1 r0 = (com.talabat.fluid.homescreen.domain.usecase.business.impl.FetchHomeCollectionsUseCaseImpl$fetchHomeCollections$1) r0
            int r1 = r0.f59723k
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f59723k = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.fluid.homescreen.domain.usecase.business.impl.FetchHomeCollectionsUseCaseImpl$fetchHomeCollections$1 r0 = new com.talabat.fluid.homescreen.domain.usecase.business.impl.FetchHomeCollectionsUseCaseImpl$fetchHomeCollections$1
            r0.<init>(r10, r11)
        L_0x0018:
            java.lang.Object r11 = r0.f59721i
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f59723k
            r3 = 1
            if (r2 == 0) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            java.lang.Object r0 = r0.f59720h
            com.talabat.fluid.homescreen.domain.usecase.business.impl.FetchHomeCollectionsUseCaseImpl r0 = (com.talabat.fluid.homescreen.domain.usecase.business.impl.FetchHomeCollectionsUseCaseImpl) r0
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x0058
        L_0x002d:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L_0x0035:
            kotlin.ResultKt.throwOnFailure(r11)
            com.talabat.fluid.homescreen.domain.tracking.observability.HomeScreenPerformanceObservability r4 = r10.homeScreenPerformanceObservability
            com.talabat.fluid.homescreen.domain.tracking.observability.HomeScreenPerformanceObservability$Level r5 = com.talabat.fluid.homescreen.domain.tracking.observability.HomeScreenPerformanceObservability.Level.INFO
            java.lang.String r6 = "fetchHomeCollectionsUseCase.fetchHomeCollections"
            r7 = 0
            r8 = 4
            r9 = 0
            com.talabat.fluid.homescreen.domain.tracking.observability.HomeScreenPerformanceObservability.DefaultImpls.traceStart$default(r4, r5, r6, r7, r8, r9)
            com.talabat.fluid.homescreen.domain.repository.HomeConfigurationRepository r11 = r10.homeConfigurationRepository
            com.talabat.fluid.homescreen.data.remote.mapper.FluidHomeComponentRequestParamsProvider r2 = r10.fluidHomeComponentRequestParamsProvider
            com.talabat.fluid.homescreen.data.remote.component.FluidHomeComponentRequestParams r2 = r2.getFluidHomeComponentRequestParams()
            r0.f59720h = r10
            r0.f59723k = r3
            java.lang.Object r11 = r11.fetchComponents(r2, r0)
            if (r11 != r1) goto L_0x0057
            return r1
        L_0x0057:
            r0 = r10
        L_0x0058:
            com.talabat.fluid.homescreen.domain.repository.HomeConfigurationRepository$Components r11 = (com.talabat.fluid.homescreen.domain.repository.HomeConfigurationRepository.Components) r11
            com.talabat.fluid.homescreen.domain.usecase.business.FetchHomeCollectionsUseCase$HomeCollectionResult r1 = new com.talabat.fluid.homescreen.domain.usecase.business.FetchHomeCollectionsUseCase$HomeCollectionResult
            java.util.List r2 = r11.getListCells()
            com.talabat.fluid.homescreen.domain.repository.HomeConfigurationRepository$Components$Configuration r3 = r11.getConfiguration()
            com.talabat.fluid.homescreen.domain.usecase.business.FetchHomeCollectionsUseCase$HomeCollectionResult$Configuration r3 = r0.toHomeCollectionConfiguration(r3)
            com.talabat.fluid.homescreen.domain.repository.HomeConfigurationRepository$Components$Metadata r11 = r11.getMetadata()
            com.talabat.fluid.homescreen.domain.usecase.business.FetchHomeCollectionsUseCase$HomeCollectionResult$Metadata r11 = r0.toHomeCollectionMetadata(r11)
            r1.<init>(r2, r3, r11)
            com.talabat.fluid.homescreen.domain.tracking.observability.HomeScreenPerformanceObservability r4 = r0.homeScreenPerformanceObservability
            com.talabat.fluid.homescreen.domain.tracking.observability.HomeScreenPerformanceObservability$Level r5 = com.talabat.fluid.homescreen.domain.tracking.observability.HomeScreenPerformanceObservability.Level.INFO
            java.lang.String r6 = "fetchHomeCollectionsUseCase.fetchHomeCollections"
            r7 = 0
            r8 = 4
            r9 = 0
            com.talabat.fluid.homescreen.domain.tracking.observability.HomeScreenPerformanceObservability.DefaultImpls.traceEnd$default(r4, r5, r6, r7, r8, r9)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.fluid.homescreen.domain.usecase.business.impl.FetchHomeCollectionsUseCaseImpl.fetchHomeCollections(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
