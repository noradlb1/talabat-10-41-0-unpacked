package androidx.compose.foundation.gestures;

import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.MutatorMutex;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "androidx.compose.foundation.gestures.DefaultTransformableState$transform$2", f = "TransformableState.kt", i = {}, l = {249}, m = "invokeSuspend", n = {}, s = {})
public final class DefaultTransformableState$transform$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f1849h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ DefaultTransformableState f1850i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ MutatePriority f1851j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Function2<TransformScope, Continuation<? super Unit>, Object> f1852k;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Landroidx/compose/foundation/gestures/TransformScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "androidx.compose.foundation.gestures.DefaultTransformableState$transform$2$1", f = "TransformableState.kt", i = {}, l = {252}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.compose.foundation.gestures.DefaultTransformableState$transform$2$1  reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<TransformScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;

        /* renamed from: h  reason: collision with root package name */
        public int f1853h;

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            AnonymousClass1 r02 = new AnonymousClass1(defaultTransformableState, function2, continuation);
            r02.L$0 = obj;
            return r02;
        }

        @Nullable
        public final Object invoke(@NotNull TransformScope transformScope, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(transformScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i11 = this.f1853h;
            if (i11 == 0) {
                ResultKt.throwOnFailure(obj);
                TransformScope transformScope = (TransformScope) this.L$0;
                defaultTransformableState.isTransformingState.setValue(Boxing.boxBoolean(true));
                Function2<TransformScope, Continuation<? super Unit>, Object> function2 = function2;
                this.f1853h = 1;
                if (function2.invoke(transformScope, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i11 == 1) {
                try {
                    ResultKt.throwOnFailure(obj);
                } catch (Throwable th2) {
                    defaultTransformableState.isTransformingState.setValue(Boxing.boxBoolean(false));
                    throw th2;
                }
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            defaultTransformableState.isTransformingState.setValue(Boxing.boxBoolean(false));
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DefaultTransformableState$transform$2(DefaultTransformableState defaultTransformableState, MutatePriority mutatePriority, Function2<? super TransformScope, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super DefaultTransformableState$transform$2> continuation) {
        super(2, continuation);
        this.f1850i = defaultTransformableState;
        this.f1851j = mutatePriority;
        this.f1852k = function2;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new DefaultTransformableState$transform$2(this.f1850i, this.f1851j, this.f1852k, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((DefaultTransformableState$transform$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f1849h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            MutatorMutex access$getTransformMutex$p = this.f1850i.transformMutex;
            TransformScope access$getTransformScope$p = this.f1850i.transformScope;
            MutatePriority mutatePriority = this.f1851j;
            final DefaultTransformableState defaultTransformableState = this.f1850i;
            final Function2<TransformScope, Continuation<? super Unit>, Object> function2 = this.f1852k;
            AnonymousClass1 r42 = new AnonymousClass1((Continuation<? super AnonymousClass1>) null);
            this.f1849h = 1;
            if (access$getTransformMutex$p.mutateWith(access$getTransformScope$p, mutatePriority, r42, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
