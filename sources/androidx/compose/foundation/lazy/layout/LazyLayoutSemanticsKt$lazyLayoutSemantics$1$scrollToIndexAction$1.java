package androidx.compose.foundation.lazy.layout;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class LazyLayoutSemanticsKt$lazyLayoutSemantics$1$scrollToIndexAction$1 extends Lambda implements Function1<Integer, Boolean> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ LazyLayoutItemProvider f3047g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ CoroutineScope f3048h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ LazyLayoutSemanticState f3049i;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.lazy.layout.LazyLayoutSemanticsKt$lazyLayoutSemantics$1$scrollToIndexAction$1$2", f = "LazyLayoutSemantics.kt", i = {}, l = {92}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.compose.foundation.lazy.layout.LazyLayoutSemanticsKt$lazyLayoutSemantics$1$scrollToIndexAction$1$2  reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: h  reason: collision with root package name */
        public int f3050h;

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass2(lazyLayoutSemanticState, i11, continuation);
        }

        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i11 = this.f3050h;
            if (i11 == 0) {
                ResultKt.throwOnFailure(obj);
                LazyLayoutSemanticState lazyLayoutSemanticState = lazyLayoutSemanticState;
                int i12 = i11;
                this.f3050h = 1;
                if (lazyLayoutSemanticState.scrollToItem(i12, this) == coroutine_suspended) {
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

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LazyLayoutSemanticsKt$lazyLayoutSemantics$1$scrollToIndexAction$1(LazyLayoutItemProvider lazyLayoutItemProvider, CoroutineScope coroutineScope, LazyLayoutSemanticState lazyLayoutSemanticState) {
        super(1);
        this.f3047g = lazyLayoutItemProvider;
        this.f3048h = coroutineScope;
        this.f3049i = lazyLayoutSemanticState;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return invoke(((Number) obj).intValue());
    }

    @NotNull
    public final Boolean invoke(final int i11) {
        boolean z11 = i11 >= 0 && i11 < this.f3047g.getItemCount();
        LazyLayoutItemProvider lazyLayoutItemProvider = this.f3047g;
        if (z11) {
            CoroutineScope coroutineScope = this.f3048h;
            final LazyLayoutSemanticState lazyLayoutSemanticState = this.f3049i;
            Job unused = BuildersKt__Builders_commonKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass2((Continuation<? super AnonymousClass2>) null), 3, (Object) null);
            return Boolean.TRUE;
        }
        throw new IllegalArgumentException(("Can't scroll to index " + i11 + ", it is out of bounds [0, " + lazyLayoutItemProvider.getItemCount() + ')').toString());
    }
}
