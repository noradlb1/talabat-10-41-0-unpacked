package com.designsystem.ds_button_v2.composables;

import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.runtime.MutableState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
@DebugMetadata(c = "com.designsystem.ds_button_v2.composables.DSAnimatedShrinkButtonKt$DSAnimatedShrinkButton$1$1", f = "DSAnimatedShrinkButton.kt", i = {}, l = {105}, m = "invokeSuspend", n = {}, s = {})
public final class DSAnimatedShrinkButtonKt$DSAnimatedShrinkButton$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f30836h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ MutableInteractionSource f30837i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ MutableState<Boolean> f30838j;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.designsystem.ds_button_v2.composables.DSAnimatedShrinkButtonKt$DSAnimatedShrinkButton$1$1$1", f = "DSAnimatedShrinkButton.kt", i = {}, l = {38}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.designsystem.ds_button_v2.composables.DSAnimatedShrinkButtonKt$DSAnimatedShrinkButton$1$1$1  reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<Interaction, Continuation<? super Unit>, Object> {

        /* renamed from: h  reason: collision with root package name */
        public int f30839h;

        /* renamed from: i  reason: collision with root package name */
        public /* synthetic */ Object f30840i;

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            AnonymousClass1 r02 = new AnonymousClass1(continuation);
            r02.f30840i = obj;
            return r02;
        }

        @Nullable
        public final Object invoke(@NotNull Interaction interaction, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(interaction, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i11 = this.f30839h;
            if (i11 == 0) {
                ResultKt.throwOnFailure(obj);
                Interaction interaction = (Interaction) this.f30840i;
                if ((interaction instanceof PressInteraction.Release) || (interaction instanceof PressInteraction.Cancel)) {
                    this.f30839h = 1;
                    if (DelayKt.delay(50, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
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
    public DSAnimatedShrinkButtonKt$DSAnimatedShrinkButton$1$1(MutableInteractionSource mutableInteractionSource, MutableState<Boolean> mutableState, Continuation<? super DSAnimatedShrinkButtonKt$DSAnimatedShrinkButton$1$1> continuation) {
        super(2, continuation);
        this.f30837i = mutableInteractionSource;
        this.f30838j = mutableState;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new DSAnimatedShrinkButtonKt$DSAnimatedShrinkButton$1$1(this.f30837i, this.f30838j, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((DSAnimatedShrinkButtonKt$DSAnimatedShrinkButton$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f30836h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            Flow<Interaction> onEach = FlowKt.onEach(this.f30837i.getInteractions(), new AnonymousClass1((Continuation<? super AnonymousClass1>) null));
            DSAnimatedShrinkButtonKt$DSAnimatedShrinkButton$1$1$invokeSuspend$$inlined$collect$1 dSAnimatedShrinkButtonKt$DSAnimatedShrinkButton$1$1$invokeSuspend$$inlined$collect$1 = new DSAnimatedShrinkButtonKt$DSAnimatedShrinkButton$1$1$invokeSuspend$$inlined$collect$1(this.f30838j);
            this.f30836h = 1;
            if (onEach.collect(dSAnimatedShrinkButtonKt$DSAnimatedShrinkButton$1$1$invokeSuspend$$inlined$collect$1, this) == coroutine_suspended) {
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
