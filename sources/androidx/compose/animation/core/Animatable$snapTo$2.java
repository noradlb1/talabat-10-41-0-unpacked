package androidx.compose.animation.core;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\b\b\u0001\u0010\u0002*\u00020\u0001H@"}, d2 = {"T", "Landroidx/compose/animation/core/AnimationVector;", "V", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "androidx.compose.animation.core.Animatable$snapTo$2", f = "Animatable.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class Animatable$snapTo$2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f1291h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Animatable<T, V> f1292i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ T f1293j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Animatable$snapTo$2(Animatable<T, V> animatable, T t11, Continuation<? super Animatable$snapTo$2> continuation) {
        super(1, continuation);
        this.f1292i = animatable;
        this.f1293j = t11;
    }

    @NotNull
    public final Continuation<Unit> create(@NotNull Continuation<?> continuation) {
        return new Animatable$snapTo$2(this.f1292i, this.f1293j, continuation);
    }

    @Nullable
    public final Object invoke(@Nullable Continuation<? super Unit> continuation) {
        return ((Animatable$snapTo$2) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object unused = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.f1291h == 0) {
            ResultKt.throwOnFailure(obj);
            this.f1292i.endAnimation();
            Object access$clampToBounds = this.f1292i.clampToBounds(this.f1293j);
            this.f1292i.getInternalState$animation_core_release().setValue$animation_core_release(access$clampToBounds);
            this.f1292i.setTargetValue(access$clampToBounds);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
