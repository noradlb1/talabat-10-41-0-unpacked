package androidx.compose.animation.core;

import androidx.compose.runtime.State;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.Channel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.animation.core.AnimateAsStateKt$animateValueAsState$3", f = "AnimateAsState.kt", i = {0}, l = {368}, m = "invokeSuspend", n = {"$this$LaunchedEffect"}, s = {"L$0"})
public final class AnimateAsStateKt$animateValueAsState$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public Object f1298h;

    /* renamed from: i  reason: collision with root package name */
    public int f1299i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Channel<T> f1300j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Animatable<T, V> f1301k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ State<AnimationSpec<T>> f1302l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ State<Function1<T, Unit>> f1303m;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AnimateAsStateKt$animateValueAsState$3(Channel<T> channel, Animatable<T, V> animatable, State<? extends AnimationSpec<T>> state, State<? extends Function1<? super T, Unit>> state2, Continuation<? super AnimateAsStateKt$animateValueAsState$3> continuation) {
        super(2, continuation);
        this.f1300j = channel;
        this.f1301k = animatable;
        this.f1302l = state;
        this.f1303m = state2;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        AnimateAsStateKt$animateValueAsState$3 animateAsStateKt$animateValueAsState$3 = new AnimateAsStateKt$animateValueAsState$3(this.f1300j, this.f1301k, this.f1302l, this.f1303m, continuation);
        animateAsStateKt$animateValueAsState$3.L$0 = obj;
        return animateAsStateKt$animateValueAsState$3;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((AnimateAsStateKt$animateValueAsState$3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x004c  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r18) {
        /*
            r17 = this;
            r0 = r17
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f1299i
            r3 = 1
            if (r2 == 0) goto L_0x0024
            if (r2 != r3) goto L_0x001c
            java.lang.Object r2 = r0.f1298h
            kotlinx.coroutines.channels.ChannelIterator r2 = (kotlinx.coroutines.channels.ChannelIterator) r2
            java.lang.Object r4 = r0.L$0
            kotlinx.coroutines.CoroutineScope r4 = (kotlinx.coroutines.CoroutineScope) r4
            kotlin.ResultKt.throwOnFailure(r18)
            r6 = r18
            r5 = r0
            goto L_0x0044
        L_0x001c:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0024:
            kotlin.ResultKt.throwOnFailure(r18)
            java.lang.Object r2 = r0.L$0
            kotlinx.coroutines.CoroutineScope r2 = (kotlinx.coroutines.CoroutineScope) r2
            kotlinx.coroutines.channels.Channel<T> r4 = r0.f1300j
            kotlinx.coroutines.channels.ChannelIterator r4 = r4.iterator()
            r5 = r0
            r16 = r4
            r4 = r2
            r2 = r16
        L_0x0037:
            r5.L$0 = r4
            r5.f1298h = r2
            r5.f1299i = r3
            java.lang.Object r6 = r2.hasNext(r5)
            if (r6 != r1) goto L_0x0044
            return r1
        L_0x0044:
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r6 = r6.booleanValue()
            if (r6 == 0) goto L_0x0078
            java.lang.Object r6 = r2.next()
            kotlinx.coroutines.channels.Channel<T> r7 = r5.f1300j
            java.lang.Object r7 = r7.m7818tryReceivePtdJZtk()
            java.lang.Object r7 = kotlinx.coroutines.channels.ChannelResult.m7804getOrNullimpl(r7)
            if (r7 != 0) goto L_0x005e
            r9 = r6
            goto L_0x005f
        L_0x005e:
            r9 = r7
        L_0x005f:
            r6 = 0
            r14 = 0
            androidx.compose.animation.core.AnimateAsStateKt$animateValueAsState$3$1 r15 = new androidx.compose.animation.core.AnimateAsStateKt$animateValueAsState$3$1
            androidx.compose.animation.core.Animatable<T, V> r10 = r5.f1301k
            androidx.compose.runtime.State<androidx.compose.animation.core.AnimationSpec<T>> r11 = r5.f1302l
            androidx.compose.runtime.State<kotlin.jvm.functions.Function1<T, kotlin.Unit>> r12 = r5.f1303m
            r13 = 0
            r8 = r15
            r8.<init>(r9, r10, r11, r12, r13)
            r11 = 3
            r12 = 0
            r7 = r4
            r8 = r6
            r9 = r14
            r10 = r15
            kotlinx.coroutines.Job unused = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r7, r8, r9, r10, r11, r12)
            goto L_0x0037
        L_0x0078:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.core.AnimateAsStateKt$animateValueAsState$3.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
