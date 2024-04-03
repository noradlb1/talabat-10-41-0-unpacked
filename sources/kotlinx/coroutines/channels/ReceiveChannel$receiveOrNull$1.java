package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.channels.ReceiveChannel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.channels.ReceiveChannel$DefaultImpls", f = "Channel.kt", i = {}, l = {354}, m = "receiveOrNull", n = {}, s = {})
public final class ReceiveChannel$receiveOrNull$1<E> extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public /* synthetic */ Object f25377h;

    /* renamed from: i  reason: collision with root package name */
    public int f25378i;

    public ReceiveChannel$receiveOrNull$1(Continuation<? super ReceiveChannel$receiveOrNull$1> continuation) {
        super(continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f25377h = obj;
        this.f25378i |= Integer.MIN_VALUE;
        return ReceiveChannel.DefaultImpls.receiveOrNull((ReceiveChannel) null, this);
    }
}
