package androidx.compose.foundation.text.selection;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerInputScope;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Landroidx/compose/ui/input/pointer/PointerInputScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "androidx.compose.foundation.text.selection.SelectionManager$onClearSelectionRequested$1", f = "SelectionManager.kt", i = {}, l = {630}, m = "invokeSuspend", n = {}, s = {})
public final class SelectionManager$onClearSelectionRequested$1 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public int f3724h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ SelectionManager f3725i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f3726j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SelectionManager$onClearSelectionRequested$1(SelectionManager selectionManager, Function0<Unit> function0, Continuation<? super SelectionManager$onClearSelectionRequested$1> continuation) {
        super(2, continuation);
        this.f3725i = selectionManager;
        this.f3726j = function0;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        SelectionManager$onClearSelectionRequested$1 selectionManager$onClearSelectionRequested$1 = new SelectionManager$onClearSelectionRequested$1(this.f3725i, this.f3726j, continuation);
        selectionManager$onClearSelectionRequested$1.L$0 = obj;
        return selectionManager$onClearSelectionRequested$1;
    }

    @Nullable
    public final Object invoke(@NotNull PointerInputScope pointerInputScope, @Nullable Continuation<? super Unit> continuation) {
        return ((SelectionManager$onClearSelectionRequested$1) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f3724h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            SelectionManager selectionManager = this.f3725i;
            final Function0<Unit> function0 = this.f3726j;
            AnonymousClass1 r32 = new Function1<Offset, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    m1020invokek4lQ0M(((Offset) obj).m2686unboximpl());
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke-k-4lQ0M  reason: not valid java name */
                public final void m1020invokek4lQ0M(long j11) {
                    function0.invoke();
                }
            };
            this.f3724h = 1;
            if (selectionManager.detectNonConsumingTap((PointerInputScope) this.L$0, r32, this) == coroutine_suspended) {
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
