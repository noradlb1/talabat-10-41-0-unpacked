package androidx.compose.foundation;

import androidx.compose.foundation.gestures.PressGestureScope;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "androidx.compose.foundation.ClickableKt$handlePressInteraction$2", f = "Clickable.kt", i = {0, 1, 2}, l = {445, 447, 454, 455, 464}, m = "invokeSuspend", n = {"delayJob", "success", "releaseInteraction"}, s = {"L$0", "Z$0", "L$0"})
public final class ClickableKt$handlePressInteraction$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public boolean f1615h;

    /* renamed from: i  reason: collision with root package name */
    public int f1616i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ PressGestureScope f1617j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ long f1618k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ MutableInteractionSource f1619l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ MutableState<PressInteraction.Press> f1620m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ State<Function0<Boolean>> f1621n;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ClickableKt$handlePressInteraction$2(PressGestureScope pressGestureScope, long j11, MutableInteractionSource mutableInteractionSource, MutableState<PressInteraction.Press> mutableState, State<? extends Function0<Boolean>> state, Continuation<? super ClickableKt$handlePressInteraction$2> continuation) {
        super(2, continuation);
        this.f1617j = pressGestureScope;
        this.f1618k = j11;
        this.f1619l = mutableInteractionSource;
        this.f1620m = mutableState;
        this.f1621n = state;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        ClickableKt$handlePressInteraction$2 clickableKt$handlePressInteraction$2 = new ClickableKt$handlePressInteraction$2(this.f1617j, this.f1618k, this.f1619l, this.f1620m, this.f1621n, continuation);
        clickableKt$handlePressInteraction$2.L$0 = obj;
        return clickableKt$handlePressInteraction$2;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((ClickableKt$handlePressInteraction$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00b4 A[RETURN] */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r20) {
        /*
            r19 = this;
            r0 = r19
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f1616i
            r3 = 5
            r4 = 4
            r5 = 3
            r6 = 2
            r7 = 1
            r8 = 0
            if (r2 == 0) goto L_0x0041
            if (r2 == r7) goto L_0x0037
            if (r2 == r6) goto L_0x0031
            if (r2 == r5) goto L_0x0028
            if (r2 == r4) goto L_0x0023
            if (r2 != r3) goto L_0x001b
            goto L_0x0023
        L_0x001b:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0023:
            kotlin.ResultKt.throwOnFailure(r20)
            goto L_0x00da
        L_0x0028:
            java.lang.Object r2 = r0.L$0
            androidx.compose.foundation.interaction.PressInteraction$Release r2 = (androidx.compose.foundation.interaction.PressInteraction.Release) r2
            kotlin.ResultKt.throwOnFailure(r20)
            goto L_0x00a8
        L_0x0031:
            boolean r2 = r0.f1615h
            kotlin.ResultKt.throwOnFailure(r20)
            goto L_0x008c
        L_0x0037:
            java.lang.Object r2 = r0.L$0
            kotlinx.coroutines.Job r2 = (kotlinx.coroutines.Job) r2
            kotlin.ResultKt.throwOnFailure(r20)
            r3 = r20
            goto L_0x0072
        L_0x0041:
            kotlin.ResultKt.throwOnFailure(r20)
            java.lang.Object r2 = r0.L$0
            r9 = r2
            kotlinx.coroutines.CoroutineScope r9 = (kotlinx.coroutines.CoroutineScope) r9
            r10 = 0
            r11 = 0
            androidx.compose.foundation.ClickableKt$handlePressInteraction$2$delayJob$1 r2 = new androidx.compose.foundation.ClickableKt$handlePressInteraction$2$delayJob$1
            androidx.compose.runtime.State<kotlin.jvm.functions.Function0<java.lang.Boolean>> r13 = r0.f1621n
            long r14 = r0.f1618k
            androidx.compose.foundation.interaction.MutableInteractionSource r12 = r0.f1619l
            androidx.compose.runtime.MutableState<androidx.compose.foundation.interaction.PressInteraction$Press> r3 = r0.f1620m
            r18 = 0
            r16 = r12
            r12 = r2
            r17 = r3
            r12.<init>(r13, r14, r16, r17, r18)
            r13 = 3
            r14 = 0
            kotlinx.coroutines.Job r2 = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r9, r10, r11, r12, r13, r14)
            androidx.compose.foundation.gestures.PressGestureScope r3 = r0.f1617j
            r0.L$0 = r2
            r0.f1616i = r7
            java.lang.Object r3 = r3.tryAwaitRelease(r0)
            if (r3 != r1) goto L_0x0072
            return r1
        L_0x0072:
            java.lang.Boolean r3 = (java.lang.Boolean) r3
            boolean r3 = r3.booleanValue()
            boolean r7 = r2.isActive()
            if (r7 == 0) goto L_0x00b5
            r0.L$0 = r8
            r0.f1615h = r3
            r0.f1616i = r6
            java.lang.Object r2 = kotlinx.coroutines.JobKt.cancelAndJoin(r2, r0)
            if (r2 != r1) goto L_0x008b
            return r1
        L_0x008b:
            r2 = r3
        L_0x008c:
            if (r2 == 0) goto L_0x00da
            androidx.compose.foundation.interaction.PressInteraction$Press r2 = new androidx.compose.foundation.interaction.PressInteraction$Press
            long r6 = r0.f1618k
            r2.<init>(r6, r8)
            androidx.compose.foundation.interaction.PressInteraction$Release r3 = new androidx.compose.foundation.interaction.PressInteraction$Release
            r3.<init>(r2)
            androidx.compose.foundation.interaction.MutableInteractionSource r6 = r0.f1619l
            r0.L$0 = r3
            r0.f1616i = r5
            java.lang.Object r2 = r6.emit(r2, r0)
            if (r2 != r1) goto L_0x00a7
            return r1
        L_0x00a7:
            r2 = r3
        L_0x00a8:
            androidx.compose.foundation.interaction.MutableInteractionSource r3 = r0.f1619l
            r0.L$0 = r8
            r0.f1616i = r4
            java.lang.Object r2 = r3.emit(r2, r0)
            if (r2 != r1) goto L_0x00da
            return r1
        L_0x00b5:
            androidx.compose.runtime.MutableState<androidx.compose.foundation.interaction.PressInteraction$Press> r2 = r0.f1620m
            java.lang.Object r2 = r2.getValue()
            androidx.compose.foundation.interaction.PressInteraction$Press r2 = (androidx.compose.foundation.interaction.PressInteraction.Press) r2
            if (r2 == 0) goto L_0x00da
            androidx.compose.foundation.interaction.MutableInteractionSource r4 = r0.f1619l
            if (r3 == 0) goto L_0x00c9
            androidx.compose.foundation.interaction.PressInteraction$Release r3 = new androidx.compose.foundation.interaction.PressInteraction$Release
            r3.<init>(r2)
            goto L_0x00ce
        L_0x00c9:
            androidx.compose.foundation.interaction.PressInteraction$Cancel r3 = new androidx.compose.foundation.interaction.PressInteraction$Cancel
            r3.<init>(r2)
        L_0x00ce:
            r0.L$0 = r8
            r2 = 5
            r0.f1616i = r2
            java.lang.Object r2 = r4.emit(r3, r0)
            if (r2 != r1) goto L_0x00da
            return r1
        L_0x00da:
            androidx.compose.runtime.MutableState<androidx.compose.foundation.interaction.PressInteraction$Press> r1 = r0.f1620m
            r1.setValue(r8)
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.ClickableKt$handlePressInteraction$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
