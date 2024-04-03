package androidx.paging.multicast;

import androidx.paging.multicast.Buffer;
import androidx.paging.multicast.ChannelManager;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0016\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0016R \u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00060\u00058VX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Landroidx/paging/multicast/NoBuffer;", "T", "Landroidx/paging/multicast/Buffer;", "()V", "items", "", "Landroidx/paging/multicast/ChannelManager$Message$Dispatch$Value;", "getItems", "()Ljava/util/Collection;", "add", "", "item", "paging-common"}, k = 1, mv = {1, 4, 2})
final class NoBuffer<T> implements Buffer<T> {
    public void add(@NotNull ChannelManager.Message.Dispatch.Value<T> value) {
        Intrinsics.checkNotNullParameter(value, "item");
    }

    @NotNull
    public Collection<ChannelManager.Message.Dispatch.Value<T>> getItems() {
        List emptyList = Collections.emptyList();
        Intrinsics.checkNotNullExpressionValue(emptyList, "Collections.emptyList()");
        return emptyList;
    }

    public boolean isEmpty() {
        return Buffer.DefaultImpls.isEmpty(this);
    }
}
