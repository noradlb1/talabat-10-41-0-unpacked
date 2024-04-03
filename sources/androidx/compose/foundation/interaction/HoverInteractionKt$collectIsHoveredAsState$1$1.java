package androidx.compose.foundation.interaction;

import androidx.compose.foundation.interaction.HoverInteraction;
import androidx.compose.runtime.MutableState;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.interaction.HoverInteractionKt$collectIsHoveredAsState$1$1", f = "HoverInteraction.kt", i = {}, l = {69}, m = "invokeSuspend", n = {}, s = {})
public final class HoverInteractionKt$collectIsHoveredAsState$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f2414h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ InteractionSource f2415i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ MutableState<Boolean> f2416j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HoverInteractionKt$collectIsHoveredAsState$1$1(InteractionSource interactionSource, MutableState<Boolean> mutableState, Continuation<? super HoverInteractionKt$collectIsHoveredAsState$1$1> continuation) {
        super(2, continuation);
        this.f2415i = interactionSource;
        this.f2416j = mutableState;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new HoverInteractionKt$collectIsHoveredAsState$1$1(this.f2415i, this.f2416j, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((HoverInteractionKt$collectIsHoveredAsState$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f2414h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            final ArrayList arrayList = new ArrayList();
            Flow<Interaction> interactions = this.f2415i.getInteractions();
            final MutableState<Boolean> mutableState = this.f2416j;
            AnonymousClass1 r32 = new FlowCollector<Interaction>() {
                @Nullable
                public final Object emit(@NotNull Interaction interaction, @NotNull Continuation<? super Unit> continuation) {
                    if (interaction instanceof HoverInteraction.Enter) {
                        arrayList.add(interaction);
                    } else if (interaction instanceof HoverInteraction.Exit) {
                        arrayList.remove(((HoverInteraction.Exit) interaction).getEnter());
                    }
                    mutableState.setValue(Boxing.boxBoolean(!arrayList.isEmpty()));
                    return Unit.INSTANCE;
                }
            };
            this.f2414h = 1;
            if (interactions.collect(r32, this) == coroutine_suspended) {
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
