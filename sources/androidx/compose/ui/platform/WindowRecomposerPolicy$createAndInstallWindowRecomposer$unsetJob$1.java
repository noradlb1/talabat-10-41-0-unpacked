package androidx.compose.ui.platform;

import android.view.View;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.Recomposer;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "androidx.compose.ui.platform.WindowRecomposerPolicy$createAndInstallWindowRecomposer$unsetJob$1", f = "WindowRecomposer.android.kt", i = {}, l = {233}, m = "invokeSuspend", n = {}, s = {})
public final class WindowRecomposerPolicy$createAndInstallWindowRecomposer$unsetJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f10073h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Recomposer f10074i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ View f10075j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WindowRecomposerPolicy$createAndInstallWindowRecomposer$unsetJob$1(Recomposer recomposer, View view, Continuation<? super WindowRecomposerPolicy$createAndInstallWindowRecomposer$unsetJob$1> continuation) {
        super(2, continuation);
        this.f10074i = recomposer;
        this.f10075j = view;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new WindowRecomposerPolicy$createAndInstallWindowRecomposer$unsetJob$1(this.f10074i, this.f10075j, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((WindowRecomposerPolicy$createAndInstallWindowRecomposer$unsetJob$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f10073h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            Recomposer recomposer = this.f10074i;
            this.f10073h = 1;
            if (recomposer.join(this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 == 1) {
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Throwable th2) {
                if (WindowRecomposer_androidKt.getCompositionContext(this.f10075j) == this.f10074i) {
                    WindowRecomposer_androidKt.setCompositionContext(this.f10075j, (CompositionContext) null);
                }
                throw th2;
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        if (WindowRecomposer_androidKt.getCompositionContext(this.f10075j) == this.f10074i) {
            WindowRecomposer_androidKt.setCompositionContext(this.f10075j, (CompositionContext) null);
        }
        return Unit.INSTANCE;
    }
}
