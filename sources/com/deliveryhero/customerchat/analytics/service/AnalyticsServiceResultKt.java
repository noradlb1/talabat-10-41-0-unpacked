package com.deliveryhero.customerchat.analytics.service;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u001aA\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\"\u0010\u0003\u001a\u001e\b\u0001\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0004H@ø\u0001\u0000¢\u0006\u0002\u0010\b\u0002\u0004\n\u0002\b\u0019¨\u0006\t"}, d2 = {"handleApi", "Lcom/deliveryhero/customerchat/analytics/service/AnalyticsServiceResult;", "T", "execute", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "Lretrofit2/Response;", "", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "customerchat_basicRelease"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class AnalyticsServiceResultKt {
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x004d A[Catch:{ HttpException -> 0x002b, IOException -> 0x0029 }] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0053 A[Catch:{ HttpException -> 0x002b, IOException -> 0x0029 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> java.lang.Object handleApi(@org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super kotlin.coroutines.Continuation<? super retrofit2.Response<T>>, ? extends java.lang.Object> r4, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.deliveryhero.customerchat.analytics.service.AnalyticsServiceResult<? extends T>> r5) {
        /*
            boolean r0 = r5 instanceof com.deliveryhero.customerchat.analytics.service.AnalyticsServiceResultKt$handleApi$1
            if (r0 == 0) goto L_0x0013
            r0 = r5
            com.deliveryhero.customerchat.analytics.service.AnalyticsServiceResultKt$handleApi$1 r0 = (com.deliveryhero.customerchat.analytics.service.AnalyticsServiceResultKt$handleApi$1) r0
            int r1 = r0.f29816i
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f29816i = r1
            goto L_0x0018
        L_0x0013:
            com.deliveryhero.customerchat.analytics.service.AnalyticsServiceResultKt$handleApi$1 r0 = new com.deliveryhero.customerchat.analytics.service.AnalyticsServiceResultKt$handleApi$1
            r0.<init>(r5)
        L_0x0018:
            java.lang.Object r5 = r0.f29815h
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f29816i
            r3 = 1
            if (r2 == 0) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            kotlin.ResultKt.throwOnFailure(r5)     // Catch:{ HttpException -> 0x002b, IOException -> 0x0029 }
            goto L_0x0041
        L_0x0029:
            r4 = move-exception
            goto L_0x006e
        L_0x002b:
            r4 = move-exception
            goto L_0x0074
        L_0x002d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0035:
            kotlin.ResultKt.throwOnFailure(r5)
            r0.f29816i = r3     // Catch:{ HttpException -> 0x002b, IOException -> 0x0029 }
            java.lang.Object r5 = r4.invoke(r0)     // Catch:{ HttpException -> 0x002b, IOException -> 0x0029 }
            if (r5 != r1) goto L_0x0041
            return r1
        L_0x0041:
            retrofit2.Response r5 = (retrofit2.Response) r5     // Catch:{ HttpException -> 0x002b, IOException -> 0x0029 }
            java.lang.Object r4 = r5.body()     // Catch:{ HttpException -> 0x002b, IOException -> 0x0029 }
            boolean r0 = r5.isSuccessful()     // Catch:{ HttpException -> 0x002b, IOException -> 0x0029 }
            if (r0 == 0) goto L_0x0053
            com.deliveryhero.customerchat.analytics.service.AnalyticsServiceResult$Success r5 = new com.deliveryhero.customerchat.analytics.service.AnalyticsServiceResult$Success     // Catch:{ HttpException -> 0x002b, IOException -> 0x0029 }
            r5.<init>(r4)     // Catch:{ HttpException -> 0x002b, IOException -> 0x0029 }
            goto L_0x0081
        L_0x0053:
            com.deliveryhero.customerchat.analytics.service.AnalyticsServiceResult$Failure r4 = new com.deliveryhero.customerchat.analytics.service.AnalyticsServiceResult$Failure     // Catch:{ HttpException -> 0x002b, IOException -> 0x0029 }
            int r0 = r5.code()     // Catch:{ HttpException -> 0x002b, IOException -> 0x0029 }
            okhttp3.ResponseBody r1 = r5.errorBody()     // Catch:{ HttpException -> 0x002b, IOException -> 0x0029 }
            if (r1 == 0) goto L_0x0065
            java.lang.String r1 = r1.string()     // Catch:{ HttpException -> 0x002b, IOException -> 0x0029 }
            if (r1 != 0) goto L_0x0069
        L_0x0065:
            java.lang.String r1 = r5.message()     // Catch:{ HttpException -> 0x002b, IOException -> 0x0029 }
        L_0x0069:
            r4.<init>(r0, r1)     // Catch:{ HttpException -> 0x002b, IOException -> 0x0029 }
            r5 = r4
            goto L_0x0081
        L_0x006e:
            com.deliveryhero.customerchat.analytics.service.AnalyticsServiceResult$Exception r5 = new com.deliveryhero.customerchat.analytics.service.AnalyticsServiceResult$Exception
            r5.<init>(r4)
            goto L_0x0081
        L_0x0074:
            com.deliveryhero.customerchat.analytics.service.AnalyticsServiceResult$Failure r5 = new com.deliveryhero.customerchat.analytics.service.AnalyticsServiceResult$Failure
            int r0 = r4.code()
            java.lang.String r4 = r4.message()
            r5.<init>(r0, r4)
        L_0x0081:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.deliveryhero.customerchat.analytics.service.AnalyticsServiceResultKt.handleApi(kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
