package com.talabat.helpcenter.data.repository;

import com.talabat.helpcenter.data.datasources.remote.HelpCenterRemoteDataSource;
import com.talabat.helpcenter.domain.repository.HelpCenterRepository;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004JE\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\bH@ø\u0001\u0000¢\u0006\u0002\u0010\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0010"}, d2 = {"Lcom/talabat/helpcenter/data/repository/HelpCenterRepositoryDefault;", "Lcom/talabat/helpcenter/domain/repository/HelpCenterRepository;", "helpCenterRemoteDataSource", "Lcom/talabat/helpcenter/data/datasources/remote/HelpCenterRemoteDataSource;", "(Lcom/talabat/helpcenter/data/datasources/remote/HelpCenterRemoteDataSource;)V", "getGlobalHelpCenterConfig", "Lcom/talabat/helpcenter/domain/entity/GlobalHelpCenterConfig;", "orderId", "", "caseId", "language", "country", "", "appVersion", "appPlatform", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_NewArchi_TalabatHelpCenter_TalabatHelpCenter"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class HelpCenterRepositoryDefault implements HelpCenterRepository {
    @NotNull
    private final HelpCenterRemoteDataSource helpCenterRemoteDataSource;

    public HelpCenterRepositoryDefault(@NotNull HelpCenterRemoteDataSource helpCenterRemoteDataSource2) {
        Intrinsics.checkNotNullParameter(helpCenterRemoteDataSource2, "helpCenterRemoteDataSource");
        this.helpCenterRemoteDataSource = helpCenterRemoteDataSource2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x006e A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0027  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object getGlobalHelpCenterConfig(@org.jetbrains.annotations.Nullable java.lang.String r12, @org.jetbrains.annotations.Nullable java.lang.String r13, @org.jetbrains.annotations.NotNull java.lang.String r14, int r15, @org.jetbrains.annotations.NotNull java.lang.String r16, @org.jetbrains.annotations.NotNull java.lang.String r17, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.talabat.helpcenter.domain.entity.GlobalHelpCenterConfig> r18) {
        /*
            r11 = this;
            r1 = r11
            r0 = r18
            boolean r2 = r0 instanceof com.talabat.helpcenter.data.repository.HelpCenterRepositoryDefault$getGlobalHelpCenterConfig$1
            if (r2 == 0) goto L_0x0016
            r2 = r0
            com.talabat.helpcenter.data.repository.HelpCenterRepositoryDefault$getGlobalHelpCenterConfig$1 r2 = (com.talabat.helpcenter.data.repository.HelpCenterRepositoryDefault$getGlobalHelpCenterConfig$1) r2
            int r3 = r2.f60738j
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L_0x0016
            int r3 = r3 - r4
            r2.f60738j = r3
            goto L_0x001b
        L_0x0016:
            com.talabat.helpcenter.data.repository.HelpCenterRepositoryDefault$getGlobalHelpCenterConfig$1 r2 = new com.talabat.helpcenter.data.repository.HelpCenterRepositoryDefault$getGlobalHelpCenterConfig$1
            r2.<init>(r11, r0)
        L_0x001b:
            r10 = r2
            java.lang.Object r0 = r10.f60736h
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r10.f60738j
            r4 = 1
            if (r3 == 0) goto L_0x0035
            if (r3 != r4) goto L_0x002d
            kotlin.ResultKt.throwOnFailure(r0)     // Catch:{ all -> 0x005d }
            goto L_0x004d
        L_0x002d:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L_0x0035:
            kotlin.ResultKt.throwOnFailure(r0)
            kotlin.Result$Companion r0 = kotlin.Result.Companion     // Catch:{ all -> 0x005d }
            com.talabat.helpcenter.data.datasources.remote.HelpCenterRemoteDataSource r3 = r1.helpCenterRemoteDataSource     // Catch:{ all -> 0x005d }
            r10.f60738j = r4     // Catch:{ all -> 0x005d }
            r4 = r12
            r5 = r13
            r6 = r14
            r7 = r15
            r8 = r16
            r9 = r17
            java.lang.Object r0 = r3.getGlobalHelpCenterConfig(r4, r5, r6, r7, r8, r9, r10)     // Catch:{ all -> 0x005d }
            if (r0 != r2) goto L_0x004d
            return r2
        L_0x004d:
            com.talabat.helpcenter.data.datasources.remote.dto.GlobalHelpCenterConfigResponse r0 = (com.talabat.helpcenter.data.datasources.remote.dto.GlobalHelpCenterConfigResponse) r0     // Catch:{ all -> 0x005d }
            com.talabat.helpcenter.domain.entity.GlobalHelpCenterConfig r2 = new com.talabat.helpcenter.domain.entity.GlobalHelpCenterConfig     // Catch:{ all -> 0x005d }
            java.lang.String r0 = r0.getHelpCenterUrl()     // Catch:{ all -> 0x005d }
            r2.<init>(r0)     // Catch:{ all -> 0x005d }
            java.lang.Object r0 = kotlin.Result.m6329constructorimpl(r2)     // Catch:{ all -> 0x005d }
            goto L_0x0068
        L_0x005d:
            r0 = move-exception
            kotlin.Result$Companion r2 = kotlin.Result.Companion
            java.lang.Object r0 = kotlin.ResultKt.createFailure(r0)
            java.lang.Object r0 = kotlin.Result.m6329constructorimpl(r0)
        L_0x0068:
            java.lang.Throwable r2 = kotlin.Result.m6332exceptionOrNullimpl(r0)
            if (r2 != 0) goto L_0x006f
            return r0
        L_0x006f:
            com.talabat.helpcenter.domain.exception.UnableToFetchGlobalHelpCenterConfig r0 = new com.talabat.helpcenter.domain.exception.UnableToFetchGlobalHelpCenterConfig
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.helpcenter.data.repository.HelpCenterRepositoryDefault.getGlobalHelpCenterConfig(java.lang.String, java.lang.String, java.lang.String, int, java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
