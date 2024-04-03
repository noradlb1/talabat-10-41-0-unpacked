package androidx.compose.foundation.lazy.layout;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class LazyLayoutSemanticsKt$lazyLayoutSemantics$1$scrollByAction$1 extends Lambda implements Function2<Float, Float, Boolean> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ boolean f3041g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ CoroutineScope f3042h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ LazyLayoutSemanticState f3043i;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.lazy.layout.LazyLayoutSemanticsKt$lazyLayoutSemantics$1$scrollByAction$1$1", f = "LazyLayoutSemantics.kt", i = {}, l = {76}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.compose.foundation.lazy.layout.LazyLayoutSemanticsKt$lazyLayoutSemantics$1$scrollByAction$1$1  reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: h  reason: collision with root package name */
        public int f3044h;

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass1(lazyLayoutSemanticState, f11, continuation);
        }

        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i11 = this.f3044h;
            if (i11 == 0) {
                ResultKt.throwOnFailure(obj);
                LazyLayoutSemanticState lazyLayoutSemanticState = lazyLayoutSemanticState;
                float f11 = f11;
                this.f3044h = 1;
                if (lazyLayoutSemanticState.animateScrollBy(f11, this) == coroutine_suspended) {
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
    public LazyLayoutSemanticsKt$lazyLayoutSemantics$1$scrollByAction$1(boolean z11, CoroutineScope coroutineScope, LazyLayoutSemanticState lazyLayoutSemanticState) {
        super(2);
        this.f3041g = z11;
        this.f3042h = coroutineScope;
        this.f3043i = lazyLayoutSemanticState;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return invoke(((Number) obj).floatValue(), ((Number) obj2).floatValue());
    }

    @NotNull
    public final Boolean invoke(final float f11, float f12) {
        if (this.f3041g) {
            f11 = f12;
        }
        CoroutineScope coroutineScope = this.f3042h;
        final LazyLayoutSemanticState lazyLayoutSemanticState = this.f3043i;
        Job unused = BuildersKt__Builders_commonKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1((Continuation<? super AnonymousClass1>) null), 3, (Object) null);
        return Boolean.TRUE;
    }
}
