package androidx.compose.material3;

import androidx.compose.foundation.interaction.FocusInteraction;
import androidx.compose.foundation.interaction.HoverInteraction;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "androidx.compose.material3.FloatingActionButtonElevation$animateElevation$1$1", f = "FloatingActionButton.kt", i = {}, l = {508}, m = "invokeSuspend", n = {}, s = {})
public final class FloatingActionButtonElevation$animateElevation$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f7053h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ InteractionSource f7054i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ SnapshotStateList<Interaction> f7055j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FloatingActionButtonElevation$animateElevation$1$1(InteractionSource interactionSource, SnapshotStateList<Interaction> snapshotStateList, Continuation<? super FloatingActionButtonElevation$animateElevation$1$1> continuation) {
        super(2, continuation);
        this.f7054i = interactionSource;
        this.f7055j = snapshotStateList;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new FloatingActionButtonElevation$animateElevation$1$1(this.f7054i, this.f7055j, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((FloatingActionButtonElevation$animateElevation$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f7053h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            Flow<Interaction> interactions = this.f7054i.getInteractions();
            final SnapshotStateList<Interaction> snapshotStateList = this.f7055j;
            AnonymousClass1 r12 = new FlowCollector<Interaction>() {
                @Nullable
                public final Object emit(@NotNull Interaction interaction, @NotNull Continuation<? super Unit> continuation) {
                    if (interaction instanceof HoverInteraction.Enter) {
                        snapshotStateList.add(interaction);
                    } else if (interaction instanceof HoverInteraction.Exit) {
                        snapshotStateList.remove((Object) ((HoverInteraction.Exit) interaction).getEnter());
                    } else if (interaction instanceof FocusInteraction.Focus) {
                        snapshotStateList.add(interaction);
                    } else if (interaction instanceof FocusInteraction.Unfocus) {
                        snapshotStateList.remove((Object) ((FocusInteraction.Unfocus) interaction).getFocus());
                    } else if (interaction instanceof PressInteraction.Press) {
                        snapshotStateList.add(interaction);
                    } else if (interaction instanceof PressInteraction.Release) {
                        snapshotStateList.remove((Object) ((PressInteraction.Release) interaction).getPress());
                    } else if (interaction instanceof PressInteraction.Cancel) {
                        snapshotStateList.remove((Object) ((PressInteraction.Cancel) interaction).getPress());
                    }
                    return Unit.INSTANCE;
                }
            };
            this.f7053h = 1;
            if (interactions.collect(r12, this) == coroutine_suspended) {
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
