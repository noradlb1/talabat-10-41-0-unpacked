package androidx.compose.foundation.text.selection;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerInputScope;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Landroidx/compose/ui/input/pointer/PointerInputScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "androidx.compose.foundation.text.selection.SelectionManager$detectNonConsumingTap$2", f = "SelectionManager.kt", i = {}, l = {619}, m = "invokeSuspend", n = {}, s = {})
public final class SelectionManager$detectNonConsumingTap$2 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public int f3711h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function1<Offset, Unit> f3712i;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "androidx.compose.foundation.text.selection.SelectionManager$detectNonConsumingTap$2$1", f = "SelectionManager.kt", i = {}, l = {620}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.compose.foundation.text.selection.SelectionManager$detectNonConsumingTap$2$1  reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: h  reason: collision with root package name */
        public int f3713h;

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass1(pointerInputScope, function1, continuation);
        }

        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i11 = this.f3713h;
            if (i11 == 0) {
                ResultKt.throwOnFailure(obj);
                PointerInputScope pointerInputScope = pointerInputScope;
                final Function1<Offset, Unit> function1 = function1;
                AnonymousClass1 r12 = new Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object>((Continuation<? super AnonymousClass1>) null) {
                    private /* synthetic */ Object L$0;

                    /* renamed from: h  reason: collision with root package name */
                    public int f3716h;

                    @NotNull
                    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                        AnonymousClass1 r02 = 

                        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                        public SelectionManager$detectNonConsumingTap$2(Function1<? super Offset, Unit> function1, Continuation<? super SelectionManager$detectNonConsumingTap$2> continuation) {
                            super(2, continuation);
                            this.f3712i = function1;
                        }

                        @NotNull
                        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                            SelectionManager$detectNonConsumingTap$2 selectionManager$detectNonConsumingTap$2 = new SelectionManager$detectNonConsumingTap$2(this.f3712i, continuation);
                            selectionManager$detectNonConsumingTap$2.L$0 = obj;
                            return selectionManager$detectNonConsumingTap$2;
                        }

                        @Nullable
                        public final Object invoke(@NotNull PointerInputScope pointerInputScope, @Nullable Continuation<? super Unit> continuation) {
                            return ((SelectionManager$detectNonConsumingTap$2) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
                        }

                        @Nullable
                        public final Object invokeSuspend(@NotNull Object obj) {
                            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            int i11 = this.f3711h;
                            if (i11 == 0) {
                                ResultKt.throwOnFailure(obj);
                                final PointerInputScope pointerInputScope = (PointerInputScope) this.L$0;
                                final Function1<Offset, Unit> function1 = this.f3712i;
                                AnonymousClass1 r12 = new AnonymousClass1((Continuation<? super AnonymousClass1>) null);
                                this.f3711h = 1;
                                if (CoroutineScopeKt.coroutineScope(r12, this) == coroutine_suspended) {
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
