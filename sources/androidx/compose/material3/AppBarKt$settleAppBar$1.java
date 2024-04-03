package androidx.compose.material3;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.DecayAnimationSpec;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "androidx.compose.material3.AppBarKt", f = "AppBar.kt", i = {0, 0, 0, 1}, l = {1577, 1593}, m = "settleAppBar", n = {"state", "snapAnimationSpec", "remainingVelocity", "remainingVelocity"}, s = {"L$0", "L$1", "L$2", "L$0"})
public final class AppBarKt$settleAppBar$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f6545h;

    /* renamed from: i  reason: collision with root package name */
    public Object f6546i;

    /* renamed from: j  reason: collision with root package name */
    public Object f6547j;

    /* renamed from: k  reason: collision with root package name */
    public /* synthetic */ Object f6548k;

    /* renamed from: l  reason: collision with root package name */
    public int f6549l;

    public AppBarKt$settleAppBar$1(Continuation<? super AppBarKt$settleAppBar$1> continuation) {
        super(continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f6548k = obj;
        this.f6549l |= Integer.MIN_VALUE;
        return AppBarKt.settleAppBar((TopAppBarState) null, 0.0f, (DecayAnimationSpec<Float>) null, (AnimationSpec<Float>) null, this);
    }
}
