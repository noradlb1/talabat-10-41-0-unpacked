package com.talabat.userandlocation.appinfo.data.remote.impl;

import com.squareup.moshi.Moshi;
import com.talabat.configuration.MutableConfigurationRemoteRepository;
import com.talabat.userandlocation.appinfo.data.remote.AppInfoRemoteDataSource;
import com.talabat.userandlocation.appinfo.data.remote.api.AppInfoApi;
import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0019\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH@ø\u0001\u0000¢\u0006\u0002\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u000e"}, d2 = {"Lcom/talabat/userandlocation/appinfo/data/remote/impl/AppInfoRemoteDataSourceImpl;", "Lcom/talabat/userandlocation/appinfo/data/remote/AppInfoRemoteDataSource;", "appInfoApi", "Lcom/talabat/userandlocation/appinfo/data/remote/api/AppInfoApi;", "mutableConfigurationRemoteRepository", "Lcom/talabat/configuration/MutableConfigurationRemoteRepository;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/talabat/userandlocation/appinfo/data/remote/api/AppInfoApi;Lcom/talabat/configuration/MutableConfigurationRemoteRepository;Lcom/squareup/moshi/Moshi;)V", "getAppInfo", "LJsonModels/Response/AppInitRM;", "countryId", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
@ExperimentalStdlibApi
public final class AppInfoRemoteDataSourceImpl implements AppInfoRemoteDataSource {
    @NotNull
    private final AppInfoApi appInfoApi;
    @NotNull
    private final Moshi moshi;
    @NotNull
    private final MutableConfigurationRemoteRepository mutableConfigurationRemoteRepository;

    public AppInfoRemoteDataSourceImpl(@NotNull AppInfoApi appInfoApi2, @NotNull MutableConfigurationRemoteRepository mutableConfigurationRemoteRepository2, @NotNull Moshi moshi2) {
        Intrinsics.checkNotNullParameter(appInfoApi2, "appInfoApi");
        Intrinsics.checkNotNullParameter(mutableConfigurationRemoteRepository2, "mutableConfigurationRemoteRepository");
        Intrinsics.checkNotNullParameter(moshi2, "moshi");
        this.appInfoApi = appInfoApi2;
        this.mutableConfigurationRemoteRepository = mutableConfigurationRemoteRepository2;
        this.moshi = moshi2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x008e A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x008f  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object getAppInfo(int r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super JsonModels.Response.AppInitRM> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.talabat.userandlocation.appinfo.data.remote.impl.AppInfoRemoteDataSourceImpl$getAppInfo$1
            if (r0 == 0) goto L_0x0013
            r0 = r6
            com.talabat.userandlocation.appinfo.data.remote.impl.AppInfoRemoteDataSourceImpl$getAppInfo$1 r0 = (com.talabat.userandlocation.appinfo.data.remote.impl.AppInfoRemoteDataSourceImpl$getAppInfo$1) r0
            int r1 = r0.f12201k
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f12201k = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.userandlocation.appinfo.data.remote.impl.AppInfoRemoteDataSourceImpl$getAppInfo$1 r0 = new com.talabat.userandlocation.appinfo.data.remote.impl.AppInfoRemoteDataSourceImpl$getAppInfo$1
            r0.<init>(r4, r6)
        L_0x0018:
            java.lang.Object r6 = r0.f12199i
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f12201k
            r3 = 1
            if (r2 == 0) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            java.lang.Object r5 = r0.f12198h
            com.talabat.userandlocation.appinfo.data.remote.impl.AppInfoRemoteDataSourceImpl r5 = (com.talabat.userandlocation.appinfo.data.remote.impl.AppInfoRemoteDataSourceImpl) r5
            kotlin.ResultKt.throwOnFailure(r6)     // Catch:{ all -> 0x007d }
            goto L_0x0048
        L_0x002d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0035:
            kotlin.ResultKt.throwOnFailure(r6)
            kotlin.Result$Companion r6 = kotlin.Result.Companion     // Catch:{ all -> 0x007d }
            com.talabat.userandlocation.appinfo.data.remote.api.AppInfoApi r6 = r4.appInfoApi     // Catch:{ all -> 0x007d }
            r0.f12198h = r4     // Catch:{ all -> 0x007d }
            r0.f12201k = r3     // Catch:{ all -> 0x007d }
            java.lang.Object r6 = r6.getAppInfo(r5, r0)     // Catch:{ all -> 0x007d }
            if (r6 != r1) goto L_0x0047
            return r1
        L_0x0047:
            r5 = r4
        L_0x0048:
            r0 = r6
            JsonModels.Response.AppInitRM r0 = (JsonModels.Response.AppInitRM) r0     // Catch:{ all -> 0x007d }
            com.squareup.moshi.Moshi r1 = r5.moshi     // Catch:{ all -> 0x007d }
            java.lang.Class<JsonModels.Response.AppInitRM> r2 = JsonModels.Response.AppInitRM.class
            kotlin.reflect.KType r2 = kotlin.jvm.internal.Reflection.typeOf((java.lang.Class) r2)     // Catch:{ all -> 0x007d }
            com.squareup.moshi.JsonAdapter r1 = com.squareup.moshi._MoshiKotlinExtensionsKt.adapter(r1, r2)     // Catch:{ all -> 0x007d }
            java.lang.String r0 = r1.toJson(r0)     // Catch:{ all -> 0x007d }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x007d }
            r1.<init>()     // Catch:{ all -> 0x007d }
            java.lang.String r2 = "{\"appInfoResponse\":"
            r1.append(r2)     // Catch:{ all -> 0x007d }
            r1.append(r0)     // Catch:{ all -> 0x007d }
            java.lang.String r0 = "}"
            r1.append(r0)     // Catch:{ all -> 0x007d }
            java.lang.String r0 = r1.toString()     // Catch:{ all -> 0x007d }
            com.talabat.configuration.MutableConfigurationRemoteRepository r5 = r5.mutableConfigurationRemoteRepository     // Catch:{ all -> 0x007d }
            r5.setCachedAppRemoteConfig(r0)     // Catch:{ all -> 0x007d }
            JsonModels.Response.AppInitRM r6 = (JsonModels.Response.AppInitRM) r6     // Catch:{ all -> 0x007d }
            java.lang.Object r5 = kotlin.Result.m6329constructorimpl(r6)     // Catch:{ all -> 0x007d }
            goto L_0x0088
        L_0x007d:
            r5 = move-exception
            kotlin.Result$Companion r6 = kotlin.Result.Companion
            java.lang.Object r5 = kotlin.ResultKt.createFailure(r5)
            java.lang.Object r5 = kotlin.Result.m6329constructorimpl(r5)
        L_0x0088:
            java.lang.Throwable r6 = kotlin.Result.m6332exceptionOrNullimpl(r5)
            if (r6 != 0) goto L_0x008f
            return r5
        L_0x008f:
            com.talabat.userandlocation.appinfo.data.remote.AppInfoRemoteDataSourceException r5 = new com.talabat.userandlocation.appinfo.data.remote.AppInfoRemoteDataSourceException
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.userandlocation.appinfo.data.remote.impl.AppInfoRemoteDataSourceImpl.getAppInfo(int, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
