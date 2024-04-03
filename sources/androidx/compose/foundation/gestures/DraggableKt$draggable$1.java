package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Offset;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Landroidx/compose/ui/geometry/Offset;", "it", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "androidx.compose.foundation.gestures.DraggableKt$draggable$1", f = "Draggable.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class DraggableKt$draggable$1 extends SuspendLambda implements Function3<CoroutineScope, Offset, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f2064h;

    public DraggableKt$draggable$1(Continuation<? super DraggableKt$draggable$1> continuation) {
        super(3, continuation);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return m306invoked4ec7I((CoroutineScope) obj, ((Offset) obj2).m2686unboximpl(), (Continuation) obj3);
    }

    @Nullable
    /* renamed from: invoke-d-4ec7I  reason: not valid java name */
    public final Object m306invoked4ec7I(@NotNull CoroutineScope coroutineScope, long j11, @Nullable Continuation<? super Unit> continuation) {
        return new DraggableKt$draggable$1(continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object unused = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.f2064h == 0) {
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
