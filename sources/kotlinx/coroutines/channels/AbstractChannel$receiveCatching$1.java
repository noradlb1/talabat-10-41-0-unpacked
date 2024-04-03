package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.channels.AbstractChannel", f = "AbstractChannel.kt", i = {}, l = {633}, m = "receiveCatching-JP2dKIU", n = {}, s = {})
public final class AbstractChannel$receiveCatching$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public /* synthetic */ Object f25153h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ AbstractChannel<E> f25154i;

    /* renamed from: j  reason: collision with root package name */
    public int f25155j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AbstractChannel$receiveCatching$1(AbstractChannel<E> abstractChannel, Continuation<? super AbstractChannel$receiveCatching$1> continuation) {
        super(continuation);
        this.f25154i = abstractChannel;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f25153h = obj;
        this.f25155j |= Integer.MIN_VALUE;
        Object r22 = this.f25154i.m7788receiveCatchingJP2dKIU(this);
        return r22 == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? r22 : ChannelResult.m7799boximpl(r22);
    }
}
