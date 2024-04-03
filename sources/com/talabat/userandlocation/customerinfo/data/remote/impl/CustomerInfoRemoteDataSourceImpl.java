package com.talabat.userandlocation.customerinfo.data.remote.impl;

import com.talabat.userandlocation.customerinfo.data.remote.CustomerInfoRemoteDataSource;
import com.talabat.userandlocation.customerinfo.data.remote.api.CustomerInfoApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH@ø\u0001\u0000¢\u0006\u0002\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\n"}, d2 = {"Lcom/talabat/userandlocation/customerinfo/data/remote/impl/CustomerInfoRemoteDataSourceImpl;", "Lcom/talabat/userandlocation/customerinfo/data/remote/CustomerInfoRemoteDataSource;", "customerInfoApi", "Lcom/talabat/userandlocation/customerinfo/data/remote/api/CustomerInfoApi;", "(Lcom/talabat/userandlocation/customerinfo/data/remote/api/CustomerInfoApi;)V", "getCustomerInfo", "Ldatamodels/CustomerInfo;", "countryId", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CustomerInfoRemoteDataSourceImpl implements CustomerInfoRemoteDataSource {
    @NotNull
    private final CustomerInfoApi customerInfoApi;

    public CustomerInfoRemoteDataSourceImpl(@NotNull CustomerInfoApi customerInfoApi2) {
        Intrinsics.checkNotNullParameter(customerInfoApi2, "customerInfoApi");
        this.customerInfoApi = customerInfoApi2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x005e A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object getCustomerInfo(int r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super datamodels.CustomerInfo> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.talabat.userandlocation.customerinfo.data.remote.impl.CustomerInfoRemoteDataSourceImpl$getCustomerInfo$1
            if (r0 == 0) goto L_0x0013
            r0 = r6
            com.talabat.userandlocation.customerinfo.data.remote.impl.CustomerInfoRemoteDataSourceImpl$getCustomerInfo$1 r0 = (com.talabat.userandlocation.customerinfo.data.remote.impl.CustomerInfoRemoteDataSourceImpl$getCustomerInfo$1) r0
            int r1 = r0.f12334j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f12334j = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.userandlocation.customerinfo.data.remote.impl.CustomerInfoRemoteDataSourceImpl$getCustomerInfo$1 r0 = new com.talabat.userandlocation.customerinfo.data.remote.impl.CustomerInfoRemoteDataSourceImpl$getCustomerInfo$1
            r0.<init>(r4, r6)
        L_0x0018:
            java.lang.Object r6 = r0.f12332h
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f12334j
            r3 = 1
            if (r2 == 0) goto L_0x0031
            if (r2 != r3) goto L_0x0029
            kotlin.ResultKt.throwOnFailure(r6)     // Catch:{ all -> 0x0048 }
            goto L_0x0041
        L_0x0029:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0031:
            kotlin.ResultKt.throwOnFailure(r6)
            kotlin.Result$Companion r6 = kotlin.Result.Companion     // Catch:{ all -> 0x0048 }
            com.talabat.userandlocation.customerinfo.data.remote.api.CustomerInfoApi r6 = r4.customerInfoApi     // Catch:{ all -> 0x0048 }
            r0.f12334j = r3     // Catch:{ all -> 0x0048 }
            java.lang.Object r6 = r6.getCustomerInfo(r5, r0)     // Catch:{ all -> 0x0048 }
            if (r6 != r1) goto L_0x0041
            return r1
        L_0x0041:
            com.talabat.userandlocation.customerinfo.data.remote.api.CustomerInfoResponse r6 = (com.talabat.userandlocation.customerinfo.data.remote.api.CustomerInfoResponse) r6     // Catch:{ all -> 0x0048 }
            java.lang.Object r5 = kotlin.Result.m6329constructorimpl(r6)     // Catch:{ all -> 0x0048 }
            goto L_0x0053
        L_0x0048:
            r5 = move-exception
            kotlin.Result$Companion r6 = kotlin.Result.Companion
            java.lang.Object r5 = kotlin.ResultKt.createFailure(r5)
            java.lang.Object r5 = kotlin.Result.m6329constructorimpl(r5)
        L_0x0053:
            kotlin.ResultKt.throwOnFailure(r5)
            com.talabat.userandlocation.customerinfo.data.remote.api.CustomerInfoResponse r5 = (com.talabat.userandlocation.customerinfo.data.remote.api.CustomerInfoResponse) r5
            datamodels.CustomerInfo r5 = r5.getResult()
            if (r5 == 0) goto L_0x005f
            return r5
        L_0x005f:
            com.talabat.userandlocation.customerinfo.data.remote.CustomerInfoRemoteDataSource$ApiReturnedNullCustomerInfoException r5 = new com.talabat.userandlocation.customerinfo.data.remote.CustomerInfoRemoteDataSource$ApiReturnedNullCustomerInfoException
            r5.<init>()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.userandlocation.customerinfo.data.remote.impl.CustomerInfoRemoteDataSourceImpl.getCustomerInfo(int, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
