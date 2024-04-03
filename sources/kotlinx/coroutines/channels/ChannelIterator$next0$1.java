package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.channels.ChannelIterator;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelIterator$DefaultImpls", f = "Channel.kt", i = {0}, l = {584}, m = "next", n = {"this"}, s = {"L$0"})
public final class ChannelIterator$next0$1<E> extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f25164h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f25165i;

    /* renamed from: j  reason: collision with root package name */
    public int f25166j;

    public ChannelIterator$next0$1(Continuation<? super ChannelIterator$next0$1> continuation) {
        super(continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f25165i = obj;
        this.f25166j |= Integer.MIN_VALUE;
        return ChannelIterator.DefaultImpls.next((ChannelIterator) null, this);
    }
}
