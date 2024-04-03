package androidx.compose.material3;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "androidx.compose.material3.SnackbarHostState", f = "SnackbarHost.kt", i = {0, 0, 0, 1, 1, 1, 1}, l = {464, 467}, m = "showSnackbar", n = {"this", "visuals", "$this$withLock_u24default$iv", "this", "visuals", "$this$withLock_u24default$iv", "$completion$iv"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3"})
public final class SnackbarHostState$showSnackbar$2 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f8250h;

    /* renamed from: i  reason: collision with root package name */
    public Object f8251i;

    /* renamed from: j  reason: collision with root package name */
    public Object f8252j;

    /* renamed from: k  reason: collision with root package name */
    public Object f8253k;

    /* renamed from: l  reason: collision with root package name */
    public /* synthetic */ Object f8254l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ SnackbarHostState f8255m;

    /* renamed from: n  reason: collision with root package name */
    public int f8256n;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SnackbarHostState$showSnackbar$2(SnackbarHostState snackbarHostState, Continuation<? super SnackbarHostState$showSnackbar$2> continuation) {
        super(continuation);
        this.f8255m = snackbarHostState;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f8254l = obj;
        this.f8256n |= Integer.MIN_VALUE;
        return this.f8255m.showSnackbar((SnackbarVisuals) null, this);
    }
}
