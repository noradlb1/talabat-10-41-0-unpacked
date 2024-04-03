package androidx.compose.material;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class ModalBottomSheetKt$ModalBottomSheetLayout$1$1$1 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ ModalBottomSheetState f4712g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ CoroutineScope f4713h;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$1$1$1$1", f = "ModalBottomSheet.kt", i = {}, l = {335}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$1$1$1$1  reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: h  reason: collision with root package name */
        public int f4714h;

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass1(modalBottomSheetState, continuation);
        }

        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i11 = this.f4714h;
            if (i11 == 0) {
                ResultKt.throwOnFailure(obj);
                ModalBottomSheetState modalBottomSheetState = modalBottomSheetState;
                this.f4714h = 1;
                if (modalBottomSheetState.hide(this) == coroutine_suspended) {
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

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ModalBottomSheetKt$ModalBottomSheetLayout$1$1$1(ModalBottomSheetState modalBottomSheetState, CoroutineScope coroutineScope) {
        super(0);
        this.f4712g = modalBottomSheetState;
        this.f4713h = coroutineScope;
    }

    public final void invoke() {
        if (((Boolean) this.f4712g.getConfirmStateChange$material_release().invoke(ModalBottomSheetValue.Hidden)).booleanValue()) {
            CoroutineScope coroutineScope = this.f4713h;
            final ModalBottomSheetState modalBottomSheetState = this.f4712g;
            Job unused = BuildersKt__Builders_commonKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1((Continuation<? super AnonymousClass1>) null), 3, (Object) null);
        }
    }
}
