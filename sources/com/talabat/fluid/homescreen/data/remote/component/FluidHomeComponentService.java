package com.talabat.fluid.homescreen.data.remote.component;

import com.talabat.core.network.endpoint.HomeContentEndPointProvider;
import com.talabat.core.network.network.TalabatAPIBuilder;
import com.talabat.fluid.homescreen.domain.tracking.observability.HomeScreenPerformanceObservability;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005JY\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0013H@ø\u0001\u0000¢\u0006\u0002\u0010\u0014R\u000e\u0010\u0002\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0015"}, d2 = {"Lcom/talabat/fluid/homescreen/data/remote/component/FluidHomeComponentService;", "Lcom/talabat/fluid/homescreen/data/remote/component/FluidHomeComponentApi;", "api", "homeScreenPerformanceObservability", "Lcom/talabat/fluid/homescreen/domain/tracking/observability/HomeScreenPerformanceObservability;", "(Lcom/talabat/fluid/homescreen/data/remote/component/FluidHomeComponentApi;Lcom/talabat/fluid/homescreen/domain/tracking/observability/HomeScreenPerformanceObservability;)V", "fetchFluidHomeComponent", "Lcom/talabat/fluid/homescreen/data/remote/component/ContentApiResponse;", "externalUserId", "", "voucher", "campaignName", "externalExperiments", "deviceWidthInDP", "countryCode", "latitude", "", "longitude", "areaId", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;DDILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_NewArchi_Homescreen_Homescreen"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FluidHomeComponentService implements FluidHomeComponentApi {
    @NotNull
    private final FluidHomeComponentApi api;
    @NotNull
    private final HomeScreenPerformanceObservability homeScreenPerformanceObservability;

    public FluidHomeComponentService(@NotNull FluidHomeComponentApi fluidHomeComponentApi, @NotNull HomeScreenPerformanceObservability homeScreenPerformanceObservability2) {
        Intrinsics.checkNotNullParameter(fluidHomeComponentApi, "api");
        Intrinsics.checkNotNullParameter(homeScreenPerformanceObservability2, "homeScreenPerformanceObservability");
        this.api = fluidHomeComponentApi;
        this.homeScreenPerformanceObservability = homeScreenPerformanceObservability2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0028  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object fetchFluidHomeComponent(@org.jetbrains.annotations.NotNull java.lang.String r17, @org.jetbrains.annotations.NotNull java.lang.String r18, @org.jetbrains.annotations.NotNull java.lang.String r19, @org.jetbrains.annotations.NotNull java.lang.String r20, @org.jetbrains.annotations.NotNull java.lang.String r21, @org.jetbrains.annotations.NotNull java.lang.String r22, double r23, double r25, int r27, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.talabat.fluid.homescreen.data.remote.component.ContentApiResponse> r28) {
        /*
            r16 = this;
            r0 = r16
            r1 = r28
            boolean r2 = r1 instanceof com.talabat.fluid.homescreen.data.remote.component.FluidHomeComponentService$fetchFluidHomeComponent$1
            if (r2 == 0) goto L_0x0017
            r2 = r1
            com.talabat.fluid.homescreen.data.remote.component.FluidHomeComponentService$fetchFluidHomeComponent$1 r2 = (com.talabat.fluid.homescreen.data.remote.component.FluidHomeComponentService$fetchFluidHomeComponent$1) r2
            int r3 = r2.f59701k
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L_0x0017
            int r3 = r3 - r4
            r2.f59701k = r3
            goto L_0x001c
        L_0x0017:
            com.talabat.fluid.homescreen.data.remote.component.FluidHomeComponentService$fetchFluidHomeComponent$1 r2 = new com.talabat.fluid.homescreen.data.remote.component.FluidHomeComponentService$fetchFluidHomeComponent$1
            r2.<init>(r0, r1)
        L_0x001c:
            r15 = r2
            java.lang.Object r1 = r15.f59699i
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r15.f59701k
            r4 = 1
            if (r3 == 0) goto L_0x003a
            if (r3 != r4) goto L_0x0032
            java.lang.Object r2 = r15.f59698h
            com.talabat.fluid.homescreen.data.remote.component.FluidHomeComponentService r2 = (com.talabat.fluid.homescreen.data.remote.component.FluidHomeComponentService) r2
            kotlin.ResultKt.throwOnFailure(r1)
            goto L_0x0069
        L_0x0032:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x003a:
            kotlin.ResultKt.throwOnFailure(r1)
            com.talabat.fluid.homescreen.domain.tracking.observability.HomeScreenPerformanceObservability r5 = r0.homeScreenPerformanceObservability
            com.talabat.fluid.homescreen.domain.tracking.observability.HomeScreenPerformanceObservability$Level r6 = com.talabat.fluid.homescreen.domain.tracking.observability.HomeScreenPerformanceObservability.Level.INFO
            java.lang.String r7 = "fluidHomeComponentApi.fetchFluidHomeComponent"
            r8 = 0
            r9 = 4
            r10 = 0
            com.talabat.fluid.homescreen.domain.tracking.observability.HomeScreenPerformanceObservability.DefaultImpls.traceStart$default(r5, r6, r7, r8, r9, r10)
            com.talabat.fluid.homescreen.data.remote.component.FluidHomeComponentApi r3 = r0.api
            r15.f59698h = r0
            r15.f59701k = r4
            r4 = r17
            r5 = r18
            r6 = r19
            r7 = r20
            r8 = r21
            r9 = r22
            r10 = r23
            r12 = r25
            r14 = r27
            java.lang.Object r1 = r3.fetchFluidHomeComponent(r4, r5, r6, r7, r8, r9, r10, r12, r14, r15)
            if (r1 != r2) goto L_0x0068
            return r2
        L_0x0068:
            r2 = r0
        L_0x0069:
            r3 = r1
            com.talabat.fluid.homescreen.data.remote.component.ContentApiResponse r3 = (com.talabat.fluid.homescreen.data.remote.component.ContentApiResponse) r3
            com.talabat.fluid.homescreen.domain.tracking.observability.HomeScreenPerformanceObservability r2 = r2.homeScreenPerformanceObservability
            com.talabat.fluid.homescreen.domain.tracking.observability.HomeScreenPerformanceObservability$Level r3 = com.talabat.fluid.homescreen.domain.tracking.observability.HomeScreenPerformanceObservability.Level.INFO
            java.lang.String r4 = "fluidHomeComponentApi.fetchFluidHomeComponent"
            r5 = 0
            r6 = 4
            r7 = 0
            r17 = r2
            r18 = r3
            r19 = r4
            r20 = r5
            r21 = r6
            r22 = r7
            com.talabat.fluid.homescreen.domain.tracking.observability.HomeScreenPerformanceObservability.DefaultImpls.traceEnd$default(r17, r18, r19, r20, r21, r22)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.fluid.homescreen.data.remote.component.FluidHomeComponentService.fetchFluidHomeComponent(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, double, double, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FluidHomeComponentService(FluidHomeComponentApi fluidHomeComponentApi, HomeScreenPerformanceObservability homeScreenPerformanceObservability2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? (FluidHomeComponentApi) new TalabatAPIBuilder().createApi(new HomeContentEndPointProvider((String) null, 1, (DefaultConstructorMarker) null).getBaseUrl(), FluidHomeComponentApi.class) : fluidHomeComponentApi, homeScreenPerformanceObservability2);
    }
}
