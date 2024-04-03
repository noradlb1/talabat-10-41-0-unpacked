package kotlinx.coroutines.rx2;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.rx2.RxObservableCoroutine", f = "RxObservable.kt", i = {0, 0}, l = {85}, m = "send", n = {"this", "element"}, s = {"L$0", "L$1"})
public final class RxObservableCoroutine$send$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f26329h;

    /* renamed from: i  reason: collision with root package name */
    public Object f26330i;

    /* renamed from: j  reason: collision with root package name */
    public /* synthetic */ Object f26331j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ RxObservableCoroutine<T> f26332k;

    /* renamed from: l  reason: collision with root package name */
    public int f26333l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RxObservableCoroutine$send$1(RxObservableCoroutine<T> rxObservableCoroutine, Continuation<? super RxObservableCoroutine$send$1> continuation) {
        super(continuation);
        this.f26332k = rxObservableCoroutine;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f26331j = obj;
        this.f26333l |= Integer.MIN_VALUE;
        return this.f26332k.send(null, this);
    }
}
