package com.talabat.location.area.data.impl;

import com.talabat.location.area.data.api.AreaApi;
import com.talabat.location.area.domain.repository.AreaRepository;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J!\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH@ø\u0001\u0000¢\u0006\u0002\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u000b"}, d2 = {"Lcom/talabat/location/area/data/impl/AreaRepositoryImpl;", "Lcom/talabat/location/area/domain/repository/AreaRepository;", "areaApi", "Lcom/talabat/location/area/data/api/AreaApi;", "(Lcom/talabat/location/area/data/api/AreaApi;)V", "getAreaFor", "Lcom/talabat/location/area/domain/repository/Area;", "latitude", "", "longitude", "(DDLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AreaRepositoryImpl implements AreaRepository {
    @NotNull
    private final AreaApi areaApi;

    public AreaRepositoryImpl(@NotNull AreaApi areaApi2) {
        Intrinsics.checkNotNullParameter(areaApi2, "areaApi");
        this.areaApi = areaApi2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00da  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object getAreaFor(double r10, double r12, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.talabat.location.area.domain.repository.Area> r14) {
        /*
            r9 = this;
            boolean r0 = r14 instanceof com.talabat.location.area.data.impl.AreaRepositoryImpl$getAreaFor$1
            if (r0 == 0) goto L_0x0013
            r0 = r14
            com.talabat.location.area.data.impl.AreaRepositoryImpl$getAreaFor$1 r0 = (com.talabat.location.area.data.impl.AreaRepositoryImpl$getAreaFor$1) r0
            int r1 = r0.f61026l
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f61026l = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.location.area.data.impl.AreaRepositoryImpl$getAreaFor$1 r0 = new com.talabat.location.area.data.impl.AreaRepositoryImpl$getAreaFor$1
            r0.<init>(r9, r14)
        L_0x0018:
            r6 = r0
            java.lang.Object r14 = r6.f61024j
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r6.f61026l
            r2 = 1
            if (r1 == 0) goto L_0x0036
            if (r1 != r2) goto L_0x002e
            double r12 = r6.f61023i
            double r10 = r6.f61022h
            kotlin.ResultKt.throwOnFailure(r14)     // Catch:{ all -> 0x0053 }
            goto L_0x004c
        L_0x002e:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L_0x0036:
            kotlin.ResultKt.throwOnFailure(r14)
            kotlin.Result$Companion r14 = kotlin.Result.Companion     // Catch:{ all -> 0x0053 }
            com.talabat.location.area.data.api.AreaApi r1 = r9.areaApi     // Catch:{ all -> 0x0053 }
            r6.f61022h = r10     // Catch:{ all -> 0x0053 }
            r6.f61023i = r12     // Catch:{ all -> 0x0053 }
            r6.f61026l = r2     // Catch:{ all -> 0x0053 }
            r2 = r10
            r4 = r12
            java.lang.Object r14 = r1.getAreaFor(r2, r4, r6)     // Catch:{ all -> 0x0053 }
            if (r14 != r0) goto L_0x004c
            return r0
        L_0x004c:
            com.talabat.location.area.data.api.AreaResponse r14 = (com.talabat.location.area.data.api.AreaResponse) r14     // Catch:{ all -> 0x0053 }
            java.lang.Object r14 = kotlin.Result.m6329constructorimpl(r14)     // Catch:{ all -> 0x0053 }
            goto L_0x005e
        L_0x0053:
            r14 = move-exception
            kotlin.Result$Companion r0 = kotlin.Result.Companion
            java.lang.Object r14 = kotlin.ResultKt.createFailure(r14)
            java.lang.Object r14 = kotlin.Result.m6329constructorimpl(r14)
        L_0x005e:
            boolean r0 = kotlin.Result.m6336isSuccessimpl(r14)
            if (r0 == 0) goto L_0x00da
            boolean r10 = kotlin.Result.m6335isFailureimpl(r14)
            r11 = 0
            if (r10 == 0) goto L_0x006c
            r14 = r11
        L_0x006c:
            com.talabat.location.area.data.api.AreaResponse r14 = (com.talabat.location.area.data.api.AreaResponse) r14
            com.talabat.location.area.domain.repository.Area r10 = new com.talabat.location.area.domain.repository.Area
            r12 = 0
            if (r14 == 0) goto L_0x0086
            com.talabat.location.area.data.api.Result r0 = r14.getResult()
            if (r0 == 0) goto L_0x0086
            java.lang.Long r0 = r0.getAreaId()
            if (r0 == 0) goto L_0x0086
            long r0 = r0.longValue()
            r1 = r0
            goto L_0x0087
        L_0x0086:
            r1 = r12
        L_0x0087:
            if (r14 == 0) goto L_0x0094
            com.talabat.location.area.data.api.Result r0 = r14.getResult()
            if (r0 == 0) goto L_0x0094
            java.lang.String r0 = r0.getAreaName()
            goto L_0x0095
        L_0x0094:
            r0 = r11
        L_0x0095:
            java.lang.String r3 = ""
            if (r0 != 0) goto L_0x009b
            r4 = r3
            goto L_0x009c
        L_0x009b:
            r4 = r0
        L_0x009c:
            if (r14 == 0) goto L_0x00af
            com.talabat.location.area.data.api.Result r0 = r14.getResult()
            if (r0 == 0) goto L_0x00af
            java.lang.Long r0 = r0.getCityId()
            if (r0 == 0) goto L_0x00af
            long r5 = r0.longValue()
            goto L_0x00b0
        L_0x00af:
            r5 = r12
        L_0x00b0:
            if (r14 == 0) goto L_0x00bc
            com.talabat.location.area.data.api.Result r0 = r14.getResult()
            if (r0 == 0) goto L_0x00bc
            java.lang.String r11 = r0.getCityName()
        L_0x00bc:
            if (r11 != 0) goto L_0x00bf
            r11 = r3
        L_0x00bf:
            if (r14 == 0) goto L_0x00d1
            com.talabat.location.area.data.api.Result r14 = r14.getResult()
            if (r14 == 0) goto L_0x00d1
            java.lang.Long r14 = r14.getCountryId()
            if (r14 == 0) goto L_0x00d1
            long r12 = r14.longValue()
        L_0x00d1:
            r7 = r12
            r0 = r10
            r3 = r4
            r4 = r5
            r6 = r11
            r0.<init>(r1, r3, r4, r6, r7)
            return r10
        L_0x00da:
            java.lang.Exception r0 = new java.lang.Exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Error getting area for ("
            r1.append(r2)
            r1.append(r10)
            java.lang.String r10 = ","
            r1.append(r10)
            r1.append(r12)
            java.lang.String r10 = ")"
            r1.append(r10)
            java.lang.String r10 = r1.toString()
            java.lang.Throwable r11 = kotlin.Result.m6332exceptionOrNullimpl(r14)
            r0.<init>(r10, r11)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.location.area.data.impl.AreaRepositoryImpl.getAreaFor(double, double, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
