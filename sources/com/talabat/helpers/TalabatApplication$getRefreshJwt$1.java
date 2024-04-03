package com.talabat.helpers;

import com.talabat.authentication.JwtTokenRepository;
import com.talabat.talabatcore.logger.impl.TimberLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.helpers.TalabatApplication$getRefreshJwt$1", f = "TalabatApplication.kt", i = {}, l = {508}, m = "invokeSuspend", n = {}, s = {})
public final class TalabatApplication$getRefreshJwt$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    final /* synthetic */ Function0<JwtTokenRepository> $jwtTokenRepository;
    final /* synthetic */ String $value;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TalabatApplication$getRefreshJwt$1(Function0<? extends JwtTokenRepository> function0, String str, Continuation<? super TalabatApplication$getRefreshJwt$1> continuation) {
        super(2, continuation);
        this.$jwtTokenRepository = function0;
        this.$value = str;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new TalabatApplication$getRefreshJwt$1(this.$jwtTokenRepository, this.$value, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super String> continuation) {
        return ((TalabatApplication$getRefreshJwt$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            String str = this.$value;
            this.label = 1;
            obj = this.$jwtTokenRepository.invoke().refreshJwt(str, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 == 1) {
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Throwable th2) {
                TimberLogger timberLogger = TimberLogger.INSTANCE;
                timberLogger.error(th2, "JwtTokenManager:: refresh failed: " + th2);
                return "";
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return (String) obj;
    }
}
