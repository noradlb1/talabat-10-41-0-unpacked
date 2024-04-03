package androidx.compose.material;

import androidx.compose.foundation.gestures.ForEachGestureKt;
import androidx.compose.ui.input.pointer.PointerInputScope;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Landroidx/compose/ui/input/pointer/PointerInputScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "androidx.compose.material.ExposedDropdownMenuKt$expandable$1", f = "ExposedDropdownMenu.kt", i = {}, l = {516}, m = "invokeSuspend", n = {}, s = {})
public final class ExposedDropdownMenuKt$expandable$1 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public int f4562h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f4563i;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Landroidx/compose/ui/input/pointer/PointerInputScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
    @DebugMetadata(c = "androidx.compose.material.ExposedDropdownMenuKt$expandable$1$1", f = "ExposedDropdownMenu.kt", i = {}, l = {517}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.compose.material.ExposedDropdownMenuKt$expandable$1$1  reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;

        /* renamed from: h  reason: collision with root package name */
        public int f4564h;

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            AnonymousClass1 r02 = new AnonymousClass1(function0, continuation);
            r02.L$0 = obj;
            return r02;
        }

        @Nullable
        public final Object invoke(@NotNull PointerInputScope pointerInputScope, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i11 = this.f4564h;
            if (i11 == 0) {
                ResultKt.throwOnFailure(obj);
                final PointerInputScope pointerInputScope = (PointerInputScope) this.L$0;
                final Function0<Unit> function0 = function0;
                AnonymousClass1 r12 = new Function2<CoroutineScope, Continuation<? super Unit>, Object>((Continuation<? super AnonymousClass1>) null) {

                    /* renamed from: h  reason: collision with root package name */
                    public int f4566h;

                    @NotNull
                    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                        return 

                        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                        public ExposedDropdownMenuKt$expandable$1(Function0<Unit> function0, Continuation<? super ExposedDropdownMenuKt$expandable$1> continuation) {
                            super(2, continuation);
                            this.f4563i = function0;
                        }

                        @NotNull
                        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                            ExposedDropdownMenuKt$expandable$1 exposedDropdownMenuKt$expandable$1 = new ExposedDropdownMenuKt$expandable$1(this.f4563i, continuation);
                            exposedDropdownMenuKt$expandable$1.L$0 = obj;
                            return exposedDropdownMenuKt$expandable$1;
                        }

                        @Nullable
                        public final Object invoke(@NotNull PointerInputScope pointerInputScope, @Nullable Continuation<? super Unit> continuation) {
                            return ((ExposedDropdownMenuKt$expandable$1) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
                        }

                        @Nullable
                        public final Object invokeSuspend(@NotNull Object obj) {
                            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            int i11 = this.f4562h;
                            if (i11 == 0) {
                                ResultKt.throwOnFailure(obj);
                                final Function0<Unit> function0 = this.f4563i;
                                AnonymousClass1 r12 = new AnonymousClass1((Continuation<? super AnonymousClass1>) null);
                                this.f4562h = 1;
                                if (ForEachGestureKt.forEachGesture((PointerInputScope) this.L$0, r12, this) == coroutine_suspended) {
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
