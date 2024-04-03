package androidx.compose.material3;

import androidx.compose.ui.platform.AccessibilityManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "androidx.compose.material3.SnackbarHostKt$SnackbarHost$1", f = "SnackbarHost.kt", i = {}, l = {232}, m = "invokeSuspend", n = {}, s = {})
public final class SnackbarHostKt$SnackbarHost$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f8233h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ SnackbarData f8234i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ AccessibilityManager f8235j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SnackbarHostKt$SnackbarHost$1(SnackbarData snackbarData, AccessibilityManager accessibilityManager, Continuation<? super SnackbarHostKt$SnackbarHost$1> continuation) {
        super(2, continuation);
        this.f8234i = snackbarData;
        this.f8235j = accessibilityManager;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new SnackbarHostKt$SnackbarHost$1(this.f8234i, this.f8235j, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((SnackbarHostKt$SnackbarHost$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        boolean z11;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f8233h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            SnackbarData snackbarData = this.f8234i;
            if (snackbarData != null) {
                SnackbarDuration duration = snackbarData.getVisuals().getDuration();
                if (this.f8234i.getVisuals().getActionLabel() != null) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                long millis = SnackbarHostKt.toMillis(duration, z11, this.f8235j);
                this.f8233h = 1;
                if (DelayKt.delay(millis, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        } else if (i11 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this.f8234i.dismiss();
        return Unit.INSTANCE;
    }
}
