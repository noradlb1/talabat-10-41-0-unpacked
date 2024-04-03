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
@DebugMetadata(c = "androidx.compose.foundation.gestures.DefaultScrollableState$scroll$2", f = "ScrollableState.kt", i = {}, l = {147}, m = "invokeSuspend", n = {}, s = {})
public final class DefaultScrollableState$scroll$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f1841h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ DefaultScrollableState f1842i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ MutatePriority f1843j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Function2<ScrollScope, Continuation<? super Unit>, Object> f1844k;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Landroidx/compose/foundation/gestures/ScrollScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "androidx.compose.foundation.gestures.DefaultScrollableState$scroll$2$1", f = "ScrollableState.kt", i = {}, l = {150}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.compose.foundation.gestures.DefaultScrollableState$scroll$2$1  reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<ScrollScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;

        /* renamed from: h  reason: collision with root package name */
        public int f1845h;

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            AnonymousClass1 r02 = new AnonymousClass1(defaultScrollableState, function2, continuation);
            r02.L$0 = obj;
            return r02;
        }

        @Nullable
        public final Object invoke(@NotNull ScrollScope scrollScope, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(scrollScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i11 = this.f1845h;
            if (i11 == 0) {
                ResultKt.throwOnFailure(obj);
                ScrollScope scrollScope = (ScrollScope) this.L$0;
                defaultScrollableState.isScrollingState.setValue(Boxing.boxBoolean(true));
                Function2<ScrollScope, Continuation<? super Unit>, Object> function2 = function2;
                this.f1845h = 1;
                if (function2.invoke(scrollScope, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i11 == 1) {
                try {
                    ResultKt.throwOnFailure(obj);
                } catch (Throwable th2) {
                    defaultScrollableState.isScrollingState.setValue(Boxing.boxBoolean(false));
                    throw th2;
                }
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            defaultScrollableState.isScrollingState.setValue(Boxing.boxBoolean(false));
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DefaultScrollableState$scroll$2(DefaultScrollableState defaultScrollableState, MutatePriority mutatePriority, Function2<? super ScrollScope, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super DefaultScrollableState$scroll$2> continuation) {
        super(2, continuation);
        this.f1842i = defaultScrollableState;
        this.f1843j = mutatePriority;
        this.f1844k = function2;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new DefaultScrollableState$scroll$2(this.f1842i, this.f1843j, this.f1844k, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((DefaultScrollableState$scroll$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f1841h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            MutatorMutex access$getScrollMutex$p = this.f1842i.scrollMutex;
            ScrollScope access$getScrollScope$p = this.f1842i.scrollScope;
            MutatePriority mutatePriority = this.f1843j;
            final DefaultScrollableState defaultScrollableState = this.f1842i;
            final Function2<ScrollScope, Continuation<? super Unit>, Object> function2 = this.f1844k;
            AnonymousClass1 r42 = new AnonymousClass1((Continuation<? super AnonymousClass1>) null);
            this.f1841h = 1;
            if (access$getScrollMutex$p.mutateWith(access$getScrollScope$p, mutatePriority, r42, this) == coroutine_suspended) {
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
