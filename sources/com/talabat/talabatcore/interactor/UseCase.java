package com.talabat.talabatcore.interactor;

import com.talabat.talabatcore.exception.Failure;
import com.talabat.talabatcore.functional.Either;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u0000*\n\b\u0000\u0010\u0001 \u0001*\u00020\u0002*\u0006\b\u0001\u0010\u0003 \u00002\u00020\u0002:\u0001\u0013B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ8\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00028\u00012 \b\u0002\u0010\f\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00028\u00000\u000e\u0012\u0004\u0012\u00020\n0\rH\u0002¢\u0006\u0002\u0010\u0010J%\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00028\u00000\u000e2\u0006\u0010\u000b\u001a\u00028\u0001H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0012R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0014"}, d2 = {"Lcom/talabat/talabatcore/interactor/UseCase;", "Type", "", "Params", "scope", "Lkotlinx/coroutines/CoroutineScope;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lkotlinx/coroutines/CoroutineScope;Lkotlinx/coroutines/CoroutineDispatcher;)V", "invoke", "", "params", "onResult", "Lkotlin/Function1;", "Lcom/talabat/talabatcore/functional/Either;", "Lcom/talabat/talabatcore/exception/Failure;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "run", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "None", "com_talabat_NewArchi_TalabatCore_TalabatCore"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class UseCase<Type, Params> {
    /* access modifiers changed from: private */
    @NotNull
    public final CoroutineDispatcher dispatcher;
    @NotNull
    private final CoroutineScope scope;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/talabatcore/interactor/UseCase$None;", "", "()V", "com_talabat_NewArchi_TalabatCore_TalabatCore"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class None {
    }

    public UseCase(@NotNull CoroutineScope coroutineScope, @NotNull CoroutineDispatcher coroutineDispatcher) {
        Intrinsics.checkNotNullParameter(coroutineScope, "scope");
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "dispatcher");
        this.scope = coroutineScope;
        this.dispatcher = coroutineDispatcher;
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

    public final void invoke(Params params, @NotNull Function1<? super Either<? extends Failure, ? extends Type>, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "onResult");
        Job unused = BuildersKt__Builders_commonKt.launch$default(this.scope, (CoroutineContext) null, (CoroutineStart) null, new UseCase$invoke$2(this, params, function1, (Continuation<? super UseCase$invoke$2>) null), 3, (Object) null);
    }

    @Nullable
    public abstract Object run(Params params, @NotNull Continuation<? super Either<? extends Failure, ? extends Type>> continuation);
}
