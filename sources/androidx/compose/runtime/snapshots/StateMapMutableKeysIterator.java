package androidx.compose.runtime.snapshots;

import com.huawei.hms.flutter.map.constants.Param;
import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableIterator;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0002\u0010&\n\u0002\b\u0004\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00032\b\u0012\u0004\u0012\u0002H\u00010\u0004B3\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006\u0012\u0018\u0010\u0007\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\t0\b¢\u0006\u0002\u0010\nJ\u000e\u0010\u000b\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"Landroidx/compose/runtime/snapshots/StateMapMutableKeysIterator;", "K", "V", "Landroidx/compose/runtime/snapshots/StateMapMutableIterator;", "", "map", "Landroidx/compose/runtime/snapshots/SnapshotStateMap;", "iterator", "", "", "(Landroidx/compose/runtime/snapshots/SnapshotStateMap;Ljava/util/Iterator;)V", "next", "()Ljava/lang/Object;", "runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
final class StateMapMutableKeysIterator<K, V> extends StateMapMutableIterator<K, V> implements Iterator<K>, KMutableIterator, j$.util.Iterator {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StateMapMutableKeysIterator(@NotNull SnapshotStateMap<K, V> snapshotStateMap, @NotNull Iterator<? extends Map.Entry<? extends K, ? extends V>> it) {
        super(snapshotStateMap, it);
        Intrinsics.checkNotNullParameter(snapshotStateMap, Param.MAP);
        Intrinsics.checkNotNullParameter(it, "iterator");
    }

    public /* synthetic */ void forEachRemaining(Consumer consumer) {
        Iterator.CC.$default$forEachRemaining(this, consumer);
    }

    public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
        forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
    }

    public K next() {
        Map.Entry c11 = c();
        if (c11 != null) {
            a();
            return c11.getKey();
        }
        throw new IllegalStateException();
    }
}
