package androidx.compose.material;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.material.SnackbarHostState", f = "SnackbarHost.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1}, l = {379, 382}, m = "showSnackbar", n = {"this", "message", "actionLabel", "duration", "$this$withLock_u24default$iv", "this", "message", "actionLabel", "duration", "$this$withLock_u24default$iv", "$completion$iv"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5"})
public final class SnackbarHostState$showSnackbar$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f5390h;

    /* renamed from: i  reason: collision with root package name */
    public Object f5391i;

    /* renamed from: j  reason: collision with root package name */
    public Object f5392j;

    /* renamed from: k  reason: collision with root package name */
    public Object f5393k;

    /* renamed from: l  reason: collision with root package name */
    public Object f5394l;

    /* renamed from: m  reason: collision with root package name */
    public Object f5395m;

    /* renamed from: n  reason: collision with root package name */
    public /* synthetic */ Object f5396n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ SnackbarHostState f5397o;

    /* renamed from: p  reason: collision with root package name */
    public int f5398p;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SnackbarHostState$showSnackbar$1(SnackbarHostState snackbarHostState, Continuation<? super SnackbarHostState$showSnackbar$1> continuation) {
        super(continuation);
        this.f5397o = snackbarHostState;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f5396n = obj;
        this.f5398p |= Integer.MIN_VALUE;
        return this.f5397o.showSnackbar((String) null, (String) null, (SnackbarDuration) null, this);
    }
}
