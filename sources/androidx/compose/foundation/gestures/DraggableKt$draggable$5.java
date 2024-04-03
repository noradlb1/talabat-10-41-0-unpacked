package androidx.compose.foundation.gestures;

import androidx.compose.ui.unit.Velocity;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Landroidx/compose/ui/unit/Velocity;", "velocity", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "androidx.compose.foundation.gestures.DraggableKt$draggable$5", f = "Draggable.kt", i = {}, l = {190}, m = "invokeSuspend", n = {}, s = {})
public final class DraggableKt$draggable$5 extends SuspendLambda implements Function3<CoroutineScope, Velocity, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public int f2067h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ long f2068i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function3<CoroutineScope, Float, Continuation<? super Unit>, Object> f2069j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Orientation f2070k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DraggableKt$draggable$5(Function3<? super CoroutineScope, ? super Float, ? super Continuation<? super Unit>, ? extends Object> function3, Orientation orientation, Continuation<? super DraggableKt$draggable$5> continuation) {
        super(3, continuation);
        this.f2069j = function3;
        this.f2070k = orientation;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return m307invokeLuvzFrg((CoroutineScope) obj, ((Velocity) obj2).m5712unboximpl(), (Continuation) obj3);
    }

    @Nullable
    /* renamed from: invoke-LuvzFrg  reason: not valid java name */
    public final Object m307invokeLuvzFrg(@NotNull CoroutineScope coroutineScope, long j11, @Nullable Continuation<? super Unit> continuation) {
        DraggableKt$draggable$5 draggableKt$draggable$5 = new DraggableKt$draggable$5(this.f2069j, this.f2070k, continuation);
        draggableKt$draggable$5.L$0 = coroutineScope;
        draggableKt$draggable$5.f2068i = j11;
        return draggableKt$draggable$5.invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f2067h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            long j11 = this.f2068i;
            Function3<CoroutineScope, Float, Continuation<? super Unit>, Object> function3 = this.f2069j;
            Float boxFloat = Boxing.boxFloat(DraggableKt.m304toFloatsFctU(j11, this.f2070k));
            this.f2067h = 1;
            if (function3.invoke((CoroutineScope) this.L$0, boxFloat, this) == coroutine_suspended) {
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
