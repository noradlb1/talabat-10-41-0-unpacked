package com.talabat.authentication.natives;

import com.talabat.authentication.JwtTokenManager;
import com.talabat.authentication.JwtTokenRepository;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH@ø\u0001\u0000¢\u0006\u0002\u0010\tJ\u001b\u0010\n\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0007\u001a\u00020\bH@ø\u0001\u0000¢\u0006\u0002\u0010\tJ\u001b\u0010\u000b\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0007\u001a\u00020\bH@ø\u0001\u0000¢\u0006\u0002\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, d2 = {"Lcom/talabat/authentication/natives/JwtTokenRepositoryImpl;", "Lcom/talabat/authentication/JwtTokenRepository;", "manager", "Lcom/talabat/authentication/JwtTokenManager;", "(Lcom/talabat/authentication/JwtTokenManager;)V", "JWTFeatureEnable", "", "path", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getJwt", "refreshJwt", "com_talabat_Authentication_Authentication"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class JwtTokenRepositoryImpl implements JwtTokenRepository {
    @NotNull
    private final JwtTokenManager manager;

    @Inject
    public JwtTokenRepositoryImpl(@NotNull JwtTokenManager jwtTokenManager) {
        Intrinsics.checkNotNullParameter(jwtTokenManager, "manager");
        this.manager = jwtTokenManager;
    }

    @Nullable
    public Object JWTFeatureEnable(@NotNull String str, @NotNull Continuation<? super Boolean> continuation) {
        return Boxing.boxBoolean(true);
    }

    @Nullable
    public Object getJwt(@NotNull String str, @NotNull Continuation<? super String> continuation) {
        return this.manager.getValidToken(str, continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object refreshJwt(@org.jetbrains.annotations.NotNull java.lang.String r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.lang.String> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.talabat.authentication.natives.JwtTokenRepositoryImpl$refreshJwt$1
            if (r0 == 0) goto L_0x0013
            r0 = r6
            com.talabat.authentication.natives.JwtTokenRepositoryImpl$refreshJwt$1 r0 = (com.talabat.authentication.natives.JwtTokenRepositoryImpl$refreshJwt$1) r0
            int r1 = r0.f55506j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f55506j = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.authentication.natives.JwtTokenRepositoryImpl$refreshJwt$1 r0 = new com.talabat.authentication.natives.JwtTokenRepositoryImpl$refreshJwt$1
            r0.<init>(r4, r6)
        L_0x0018:
            java.lang.Object r6 = r0.f55504h
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f55506j
            r3 = 1
            if (r2 == 0) goto L_0x0031
            if (r2 != r3) goto L_0x0029
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x003f
        L_0x0029:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0031:
            kotlin.ResultKt.throwOnFailure(r6)
            com.talabat.authentication.JwtTokenManager r6 = r4.manager
            r0.f55506j = r3
            java.lang.Object r6 = r6.refreshToken(r5, r0)
            if (r6 != r1) goto L_0x003f
            return r1
        L_0x003f:
            com.talabat.authentication.token.domain.model.Token r6 = (com.talabat.authentication.token.domain.model.Token) r6
            java.lang.String r5 = r6.getAccessToken()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.authentication.natives.JwtTokenRepositoryImpl.refreshJwt(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
