package androidx.compose.material3;

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

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "androidx.compose.material3.ExposedDropdownMenuKt$expandable$1$1", f = "ExposedDropdownMenu.kt", i = {}, l = {530}, m = "invokeSuspend", n = {}, s = {})
public final class ExposedDropdownMenuKt$expandable$1$1 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public int f7038h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f7039i;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "androidx.compose.material3.ExposedDropdownMenuKt$expandable$1$1$1", f = "ExposedDropdownMenu.kt", i = {}, l = {531}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.compose.material3.ExposedDropdownMenuKt$expandable$1$1$1  reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;

        /* renamed from: h  reason: collision with root package name */
        public int f7040h;

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
            int i11 = this.f7040h;
            if (i11 == 0) {
                ResultKt.throwOnFailure(obj);
                final PointerInputScope pointerInputScope = (PointerInputScope) this.L$0;
                final Function0<Unit> function0 = function0;
                AnonymousClass1 r12 = new Function2<CoroutineScope, Continuation<? super Unit>, Object>((Continuation<? super AnonymousClass1>) null) {

                    /* renamed from: h  reason: collision with root package name */
                    public int f7042h;

                    @NotNull
                    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                        return 

                        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                        public ExposedDropdownMenuKt$expandable$1$1(Function0<Unit> function0, Continuation<? super ExposedDropdownMenuKt$expandable$1$1> continuation) {
                            super(2, continuation);
                            this.f7039i = function0;
                        }

                        @NotNull
                        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                            ExposedDropdownMenuKt$expandable$1$1 exposedDropdownMenuKt$expandable$1$1 = new ExposedDropdownMenuKt$expandable$1$1(this.f7039i, continuation);
                            exposedDropdownMenuKt$expandable$1$1.L$0 = obj;
                            return exposedDropdownMenuKt$expandable$1$1;
                        }

                        @Nullable
                        public final Object invoke(@NotNull PointerInputScope pointerInputScope, @Nullable Continuation<? super Unit> continuation) {
                            return ((ExposedDropdownMenuKt$expandable$1$1) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
                        }

                        @Nullable
                        public final Object invokeSuspend(@NotNull Object obj) {
                            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            int i11 = this.f7038h;
                            if (i11 == 0) {
                                ResultKt.throwOnFailure(obj);
                                final Function0<Unit> function0 = this.f7039i;
                                AnonymousClass1 r12 = new AnonymousClass1((Continuation<? super AnonymousClass1>) null);
                                this.f7038h = 1;
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
