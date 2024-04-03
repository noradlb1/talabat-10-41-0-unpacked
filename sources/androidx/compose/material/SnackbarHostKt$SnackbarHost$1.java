package androidx.compose.material;

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

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.material.SnackbarHostKt$SnackbarHost$1", f = "SnackbarHost.kt", i = {}, l = {164}, m = "invokeSuspend", n = {}, s = {})
public final class SnackbarHostKt$SnackbarHost$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f5373h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ SnackbarData f5374i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ AccessibilityManager f5375j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SnackbarHostKt$SnackbarHost$1(SnackbarData snackbarData, AccessibilityManager accessibilityManager, Continuation<? super SnackbarHostKt$SnackbarHost$1> continuation) {
        super(2, continuation);
        this.f5374i = snackbarData;
        this.f5375j = accessibilityManager;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new SnackbarHostKt$SnackbarHost$1(this.f5374i, this.f5375j, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((SnackbarHostKt$SnackbarHost$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        boolean z11;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f5373h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            SnackbarData snackbarData = this.f5374i;
            if (snackbarData != null) {
                SnackbarDuration duration = snackbarData.getDuration();
                if (this.f5374i.getActionLabel() != null) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                long millis = SnackbarHostKt.toMillis(duration, z11, this.f5375j);
                this.f5373h = 1;
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
        this.f5374i.dismiss();
        return Unit.INSTANCE;
    }
}
