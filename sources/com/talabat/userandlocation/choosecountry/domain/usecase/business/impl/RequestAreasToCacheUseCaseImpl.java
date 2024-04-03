package com.talabat.userandlocation.choosecountry.domain.usecase.business.impl;

import com.talabat.configuration.MutableLocationConfigurationRepository;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.userandlocation.choosecountry.domain.usecase.business.RequestAreasToCacheUseCase;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH@ø\u0001\u0000¢\u0006\u0002\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, d2 = {"Lcom/talabat/userandlocation/choosecountry/domain/usecase/business/impl/RequestAreasToCacheUseCaseImpl;", "Lcom/talabat/userandlocation/choosecountry/domain/usecase/business/RequestAreasToCacheUseCase;", "mutableLocationConfigurationRepository", "Lcom/talabat/configuration/MutableLocationConfigurationRepository;", "talabatFeatureFlag", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "(Lcom/talabat/configuration/MutableLocationConfigurationRepository;Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;)V", "requestAreasToCache", "", "countryId", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_NewArchi_UserAndLocation_ChooseCountry_ChooseCountry"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RequestAreasToCacheUseCaseImpl implements RequestAreasToCacheUseCase {
    @NotNull
    private final MutableLocationConfigurationRepository mutableLocationConfigurationRepository;
    @NotNull
    private final ITalabatFeatureFlag talabatFeatureFlag;

    @Inject
    public RequestAreasToCacheUseCaseImpl(@NotNull MutableLocationConfigurationRepository mutableLocationConfigurationRepository2, @NotNull ITalabatFeatureFlag iTalabatFeatureFlag) {
        Intrinsics.checkNotNullParameter(mutableLocationConfigurationRepository2, "mutableLocationConfigurationRepository");
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "talabatFeatureFlag");
        this.mutableLocationConfigurationRepository = mutableLocationConfigurationRepository2;
        this.talabatFeatureFlag = iTalabatFeatureFlag;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002a  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object requestAreasToCache(int r19, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r20) {
        /*
            r18 = this;
            r0 = r18
            r1 = r20
            boolean r2 = r1 instanceof com.talabat.userandlocation.choosecountry.domain.usecase.business.impl.RequestAreasToCacheUseCaseImpl$requestAreasToCache$1
            if (r2 == 0) goto L_0x0017
            r2 = r1
            com.talabat.userandlocation.choosecountry.domain.usecase.business.impl.RequestAreasToCacheUseCaseImpl$requestAreasToCache$1 r2 = (com.talabat.userandlocation.choosecountry.domain.usecase.business.impl.RequestAreasToCacheUseCaseImpl$requestAreasToCache$1) r2
            int r3 = r2.f12221k
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L_0x0017
            int r3 = r3 - r4
            r2.f12221k = r3
            goto L_0x001c
        L_0x0017:
            com.talabat.userandlocation.choosecountry.domain.usecase.business.impl.RequestAreasToCacheUseCaseImpl$requestAreasToCache$1 r2 = new com.talabat.userandlocation.choosecountry.domain.usecase.business.impl.RequestAreasToCacheUseCaseImpl$requestAreasToCache$1
            r2.<init>(r0, r1)
        L_0x001c:
            java.lang.Object r1 = r2.f12219i
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r2.f12221k
            r5 = 2
            r6 = 0
            r7 = 1
            r8 = 0
            if (r4 == 0) goto L_0x003c
            if (r4 != r7) goto L_0x0034
            java.lang.Object r2 = r2.f12218h
            com.talabat.userandlocation.choosecountry.domain.usecase.business.impl.RequestAreasToCacheUseCaseImpl r2 = (com.talabat.userandlocation.choosecountry.domain.usecase.business.impl.RequestAreasToCacheUseCaseImpl) r2
            kotlin.ResultKt.throwOnFailure(r1)
            goto L_0x005c
        L_0x0034:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x003c:
            kotlin.ResultKt.throwOnFailure(r1)
            com.talabat.core.featureflag.domain.ITalabatFeatureFlag r1 = r0.talabatFeatureFlag
            com.talabat.core.fwfprojectskeys.domain.projects.home.HomePageFeatureFlagsKeys r4 = com.talabat.core.fwfprojectskeys.domain.projects.home.HomePageFeatureFlagsKeys.FF_HOMEPAGE_AREAS_UL_ENDPOINT
            boolean r1 = com.talabat.core.featureflag.domain.ITalabatFeatureFlag.DefaultImpls.getFeatureFlag$default(r1, r4, r6, r5, r8)
            if (r1 != 0) goto L_0x004c
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        L_0x004c:
            com.talabat.configuration.MutableLocationConfigurationRepository r1 = r0.mutableLocationConfigurationRepository
            r2.f12218h = r0
            r2.f12221k = r7
            r4 = r19
            java.lang.Object r1 = r1.areas(r4, r2)
            if (r1 != r3) goto L_0x005b
            return r3
        L_0x005b:
            r2 = r0
        L_0x005c:
            java.util.List r1 = (java.util.List) r1
            com.talabat.configuration.MutableLocationConfigurationRepository r3 = r2.mutableLocationConfigurationRepository
            com.talabat.configuration.location.LocationConfig r9 = r3.config()
            com.talabat.configuration.MutableLocationConfigurationRepository r3 = r2.mutableLocationConfigurationRepository
            r10 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 61
            r17 = 0
            r11 = r1
            com.talabat.configuration.location.LocationConfig r4 = com.talabat.configuration.location.LocationConfig.copy$default(r9, r10, r11, r12, r13, r14, r15, r16, r17)
            r3.setConfig(r4)
            com.talabat.core.featureflag.domain.ITalabatFeatureFlag r2 = r2.talabatFeatureFlag
            com.talabat.core.featureflag.domain.flags.location.LocationFeatureFlagConstants r3 = com.talabat.core.featureflag.domain.flags.location.LocationFeatureFlagConstants.LOCATION_REPO_REAL_AREAS
            boolean r2 = com.talabat.core.featureflag.domain.ITalabatFeatureFlag.DefaultImpls.getFeatureFlag$default(r2, r3, r6, r5, r8)
            if (r2 != 0) goto L_0x00d8
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.ArrayList r2 = new java.util.ArrayList
            r3 = 10
            int r3 = kotlin.collections.CollectionsKt__IterablesKt.collectionSizeOrDefault(r1, r3)
            r2.<init>(r3)
            java.util.Iterator r1 = r1.iterator()
        L_0x0092:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x00c9
            java.lang.Object r3 = r1.next()
            com.talabat.configuration.location.Area r3 = (com.talabat.configuration.location.Area) r3
            datamodels.Area r4 = new datamodels.Area
            r4.<init>()
            java.lang.String r5 = r3.getAreaName()
            r4.areaName = r5
            com.talabat.domain.location.GeoCoordinate r5 = r3.getAreaCenterPointCoordinates()
            java.lang.String r5 = com.talabat.domain.location.GeoCoordinate.toConcatenatedString$default(r5, r8, r7, r8)
            r4.areCenterPoint = r5
            int r5 = r3.getCityId()
            r4.cityId = r5
            int r5 = r3.getId()
            r4.f13835id = r5
            boolean r3 = r3.isPolygonServiceEnabled()
            r4.isPolygonServiseEnabled = r3
            r2.add(r4)
            goto L_0x0092
        L_0x00c9:
            datamodels.Area[] r1 = new datamodels.Area[r6]
            java.lang.Object[] r1 = r2.toArray(r1)
            java.lang.String r2 = "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1, r2)
            datamodels.Area[] r1 = (datamodels.Area[]) r1
            com.talabat.helpers.GlobalDataModel.areas = r1
        L_0x00d8:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.userandlocation.choosecountry.domain.usecase.business.impl.RequestAreasToCacheUseCaseImpl.requestAreasToCache(int, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
