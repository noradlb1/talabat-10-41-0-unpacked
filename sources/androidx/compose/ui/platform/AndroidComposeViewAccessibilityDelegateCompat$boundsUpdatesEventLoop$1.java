package androidx.compose.ui.platform;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat", f = "AndroidComposeViewAccessibilityDelegateCompat.android.kt", i = {0, 0, 1, 1}, l = {1654, 1683}, m = "boundsUpdatesEventLoop", n = {"this", "subtreeChangedSemanticsNodesIds", "this", "subtreeChangedSemanticsNodesIds"}, s = {"L$0", "L$1", "L$0", "L$1"})
public final class AndroidComposeViewAccessibilityDelegateCompat$boundsUpdatesEventLoop$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f9989h;

    /* renamed from: i  reason: collision with root package name */
    public Object f9990i;

    /* renamed from: j  reason: collision with root package name */
    public Object f9991j;

    /* renamed from: k  reason: collision with root package name */
    public /* synthetic */ Object f9992k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ AndroidComposeViewAccessibilityDelegateCompat f9993l;

    /* renamed from: m  reason: collision with root package name */
    public int f9994m;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AndroidComposeViewAccessibilityDelegateCompat$boundsUpdatesEventLoop$1(AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat, Continuation<? super AndroidComposeViewAccessibilityDelegateCompat$boundsUpdatesEventLoop$1> continuation) {
        super(continuation);
        this.f9993l = androidComposeViewAccessibilityDelegateCompat;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f9992k = obj;
        this.f9994m |= Integer.MIN_VALUE;
        return this.f9993l.boundsUpdatesEventLoop(this);
    }
}
