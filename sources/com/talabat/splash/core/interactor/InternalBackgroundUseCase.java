package com.talabat.splash.core.interactor;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001:\u0001\u0007B\u0005¢\u0006\u0002\u0010\u0002J\t\u0010\u0003\u001a\u00020\u0004H\u0002J\u0011\u0010\u0005\u001a\u00020\u0004H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\b"}, d2 = {"Lcom/talabat/splash/core/interactor/InternalBackgroundUseCase;", "", "()V", "invoke", "", "run", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "None", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class InternalBackgroundUseCase {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/splash/core/interactor/InternalBackgroundUseCase$None;", "", "()V", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class None {
    }

    public final void invoke() {
        GlobalScope globalScope = GlobalScope.INSTANCE;
        Deferred async$default = BuildersKt__Builders_commonKt.async$default(globalScope, globalScope.getCoroutineContext(), (CoroutineStart) null, new InternalBackgroundUseCase$invoke$job$1(this, (Continuation<? super InternalBackgroundUseCase$invoke$job$1>) null), 2, (Object) null);
        Job unused = BuildersKt__Builders_commonKt.launch$default(globalScope, Dispatchers.getIO(), (CoroutineStart) null, new InternalBackgroundUseCase$invoke$1(async$default, (Continuation<? super InternalBackgroundUseCase$invoke$1>) null), 2, (Object) null);
    }

    @Nullable
    public abstract Object run(@NotNull Continuation<? super Unit> continuation);
}
