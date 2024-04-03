package androidx.compose.runtime;

import androidx.compose.runtime.collection.IdentityArraySet;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "androidx.compose.runtime.Recomposer$runRecomposeConcurrentlyAndApplyChanges$2$2$1$1", f = "Recomposer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class Recomposer$runRecomposeConcurrentlyAndApplyChanges$2$2$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f9206h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Recomposer f9207i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ ControlledComposition f9208j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Recomposer$runRecomposeConcurrentlyAndApplyChanges$2$2$1$1(Recomposer recomposer, ControlledComposition controlledComposition, Continuation<? super Recomposer$runRecomposeConcurrentlyAndApplyChanges$2$2$1$1> continuation) {
        super(2, continuation);
        this.f9207i = recomposer;
        this.f9208j = controlledComposition;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new Recomposer$runRecomposeConcurrentlyAndApplyChanges$2$2$1$1(this.f9207i, this.f9208j, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((Recomposer$runRecomposeConcurrentlyAndApplyChanges$2$2$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        CancellableContinuation access$deriveStateLocked;
        Object unused = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.f9206h == 0) {
            ResultKt.throwOnFailure(obj);
            ControlledComposition access$performRecompose = this.f9207i.performRecompose(this.f9208j, (IdentityArraySet<Object>) null);
            Object access$getStateLock$p = this.f9207i.stateLock;
            Recomposer recomposer = this.f9207i;
            synchronized (access$getStateLock$p) {
                if (access$performRecompose != null) {
                    try {
                        recomposer.compositionsAwaitingApply.add(access$performRecompose);
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
                recomposer.concurrentCompositionsOutstanding = recomposer.concurrentCompositionsOutstanding - 1;
                access$deriveStateLocked = recomposer.deriveStateLocked();
            }
            if (access$deriveStateLocked != null) {
                Result.Companion companion = Result.Companion;
                access$deriveStateLocked.resumeWith(Result.m6329constructorimpl(Unit.INSTANCE));
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
