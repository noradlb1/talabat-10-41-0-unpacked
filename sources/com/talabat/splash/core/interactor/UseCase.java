package com.talabat.splash.core.interactor;

import com.talabat.splash.core.exception.Failure;
import com.talabat.splash.core.functional.Either;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000*\n\b\u0000\u0010\u0001 \u0001*\u00020\u0002*\u0006\b\u0001\u0010\u0003 \u00002\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0002J8\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00028\u00012 \b\u0002\u0010\n\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00020\f\u0012\u0004\u0012\u00020\b0\u000bH\u0002¢\u0006\u0002\u0010\u000eJ%\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00020\f2\u0006\u0010\t\u001a\u00028\u0001H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0010\u0002\u0004\n\u0002\b\u0019¨\u0006\u0011"}, d2 = {"Lcom/talabat/splash/core/interactor/UseCase;", "Type", "", "Params", "()V", "coroutineExceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "invoke", "", "params", "onResult", "Lkotlin/Function1;", "Lcom/talabat/splash/core/functional/Either;", "Lcom/talabat/splash/core/exception/Failure;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "run", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class UseCase<Type, Params> {
    private final CoroutineExceptionHandler coroutineExceptionHandler() {
        return new UseCase$coroutineExceptionHandler$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.Key);
    }

    public static /* synthetic */ void invoke$default(UseCase useCase, Object obj, Function1 function1, int i11, Object obj2) {
        if (obj2 == null) {
            if ((i11 & 2) != 0) {
                function1 = UseCase$invoke$1.INSTANCE;
            }
            useCase.invoke(obj, function1);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: invoke");
    }

    public final void invoke(Params params, @NotNull Function1<? super Either<? extends Failure, ? extends Object>, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "onResult");
        CoroutineContext plus = Dispatchers.getIO().plus(coroutineExceptionHandler());
        GlobalScope globalScope = GlobalScope.INSTANCE;
        Job unused = BuildersKt__Builders_commonKt.launch$default(globalScope, plus, (CoroutineStart) null, new UseCase$invoke$2(function1, BuildersKt__Builders_commonKt.async$default(globalScope, globalScope.getCoroutineContext(), (CoroutineStart) null, new UseCase$invoke$job$1(this, params, (Continuation<? super UseCase$invoke$job$1>) null), 2, (Object) null), (Continuation<? super UseCase$invoke$2>) null), 2, (Object) null);
    }

    @Nullable
    public abstract Object run(Params params, @NotNull Continuation<? super Either<? extends Failure, ? extends Object>> continuation);
}
