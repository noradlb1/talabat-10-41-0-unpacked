package kotlinx.coroutines.sync;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 176)
@DebugMetadata(c = "kotlinx.coroutines.sync.MutexKt", f = "Mutex.kt", i = {0, 0, 0}, l = {112}, m = "withLock", n = {"$this$withLock", "owner", "action"}, s = {"L$0", "L$1", "L$2"})
public final class MutexKt$withLock$1<T> extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f26376h;

    /* renamed from: i  reason: collision with root package name */
    public Object f26377i;

    /* renamed from: j  reason: collision with root package name */
    public Object f26378j;

    /* renamed from: k  reason: collision with root package name */
    public /* synthetic */ Object f26379k;

    /* renamed from: l  reason: collision with root package name */
    public int f26380l;

    public MutexKt$withLock$1(Continuation<? super MutexKt$withLock$1> continuation) {
        super(continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f26379k = obj;
        this.f26380l |= Integer.MIN_VALUE;
        return MutexKt.withLock((Mutex) null, (Object) null, (Function0) null, this);
    }
}
