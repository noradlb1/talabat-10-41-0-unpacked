package androidx.compose.material3;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.DecayAnimationSpec;
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

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "androidx.compose.material3.AppBarKt$TwoRowsTopAppBar$appBarDragModifier$2$1", f = "AppBar.kt", i = {}, l = {1152}, m = "invokeSuspend", n = {}, s = {})
public final class AppBarKt$TwoRowsTopAppBar$appBarDragModifier$2$1 extends SuspendLambda implements Function3<CoroutineScope, Float, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f6539h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ float f6540i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ TopAppBarScrollBehavior f6541j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AppBarKt$TwoRowsTopAppBar$appBarDragModifier$2$1(TopAppBarScrollBehavior topAppBarScrollBehavior, Continuation<? super AppBarKt$TwoRowsTopAppBar$appBarDragModifier$2$1> continuation) {
        super(3, continuation);
        this.f6541j = topAppBarScrollBehavior;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((CoroutineScope) obj, ((Number) obj2).floatValue(), (Continuation<? super Unit>) (Continuation) obj3);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, float f11, @Nullable Continuation<? super Unit> continuation) {
        AppBarKt$TwoRowsTopAppBar$appBarDragModifier$2$1 appBarKt$TwoRowsTopAppBar$appBarDragModifier$2$1 = new AppBarKt$TwoRowsTopAppBar$appBarDragModifier$2$1(this.f6541j, continuation);
        appBarKt$TwoRowsTopAppBar$appBarDragModifier$2$1.f6540i = f11;
        return appBarKt$TwoRowsTopAppBar$appBarDragModifier$2$1.invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f6539h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            float f11 = this.f6540i;
            TopAppBarState state = this.f6541j.getState();
            DecayAnimationSpec<Float> flingAnimationSpec = this.f6541j.getFlingAnimationSpec();
            AnimationSpec<Float> snapAnimationSpec = this.f6541j.getSnapAnimationSpec();
            this.f6539h = 1;
            if (AppBarKt.settleAppBar(state, f11, flingAnimationSpec, snapAnimationSpec, this) == coroutine_suspended) {
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
