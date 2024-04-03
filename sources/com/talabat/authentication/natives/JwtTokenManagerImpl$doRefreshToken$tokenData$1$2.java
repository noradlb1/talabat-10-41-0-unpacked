package com.talabat.authentication.natives;

import com.talabat.authentication.token.data.model.TokenData;
import com.talabat.authentication.token.domain.model.Token;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H@"}, d2 = {"Lcom/talabat/authentication/token/data/model/TokenData$Valid;", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.authentication.natives.JwtTokenManagerImpl$doRefreshToken$tokenData$1$2", f = "JwtTokenManagerImpl.kt", i = {}, l = {377}, m = "invokeSuspend", n = {}, s = {})
public final class JwtTokenManagerImpl$doRefreshToken$tokenData$1$2 extends SuspendLambda implements Function1<Continuation<? super TokenData.Valid>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f55471h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Token f55472i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Throwable f55473j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ JwtTokenManagerImpl f55474k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public JwtTokenManagerImpl$doRefreshToken$tokenData$1$2(Token token, Throwable th2, JwtTokenManagerImpl jwtTokenManagerImpl, Continuation<? super JwtTokenManagerImpl$doRefreshToken$tokenData$1$2> continuation) {
        super(1, continuation);
        this.f55472i = token;
        this.f55473j = th2;
        this.f55474k = jwtTokenManagerImpl;
    }

    @NotNull
    public final Continuation<Unit> create(@NotNull Continuation<?> continuation) {
        return new JwtTokenManagerImpl$doRefreshToken$tokenData$1$2(this.f55472i, this.f55473j, this.f55474k, continuation);
    }

    @Nullable
    public final Object invoke(@Nullable Continuation<? super TokenData.Valid> continuation) {
        return ((JwtTokenManagerImpl$doRefreshToken$tokenData$1$2) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        String str;
        String refreshToken;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f55471h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            Token token = this.f55472i;
            if (token == null || (refreshToken = token.getRefreshToken()) == null) {
                Throwable th2 = this.f55473j;
                String str2 = null;
                if (th2 != null) {
                    str = th2.getClass().getCanonicalName();
                } else {
                    str = null;
                }
                Throwable th3 = this.f55473j;
                if (th3 != null) {
                    str2 = th3.getMessage();
                }
                throw new IllegalStateException("Missing token to be refreshed, use fallback scenario :: " + str + ": " + str2, this.f55473j);
            }
            JwtTokenManagerImpl jwtTokenManagerImpl = this.f55474k;
            this.f55471h = 1;
            obj = JwtTokenManagerImpl.doRefreshToken$refreshTokenRemote(jwtTokenManagerImpl, refreshToken, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        TokenData.Valid valid = (TokenData.Valid) obj;
        this.f55474k.tokenRepository.saveToken(valid.getToken(), valid.getDeviceToken());
        return obj;
    }
}
