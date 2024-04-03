package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlinx.coroutines.ObsoleteCoroutinesApi;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u001a\u001c\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"BroadcastChannel", "Lkotlinx/coroutines/channels/BroadcastChannel;", "E", "capacity", "", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class BroadcastChannelKt {
    @NotNull
    @ObsoleteCoroutinesApi
    public static final <E> BroadcastChannel<E> BroadcastChannel(int i11) {
        if (i11 == -2) {
            return new ArrayBroadcastChannel(Channel.Factory.getCHANNEL_DEFAULT_CAPACITY$kotlinx_coroutines_core());
        }
        if (i11 == -1) {
            return new ConflatedBroadcastChannel();
        }
        if (i11 == 0) {
            throw new IllegalArgumentException("Unsupported 0 capacity for BroadcastChannel");
        } else if (i11 != Integer.MAX_VALUE) {
            return new ArrayBroadcastChannel(i11);
        } else {
            throw new IllegalArgumentException("Unsupported UNLIMITED capacity for BroadcastChannel");
        }
    }
}
