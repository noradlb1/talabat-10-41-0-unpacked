package androidx.compose.runtime;

import androidx.compose.runtime.collection.IdentityArrayMap;
import androidx.compose.runtime.snapshots.StateObject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "T", "it", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class DerivedSnapshotState$currentRecord$result$1$result$1 extends Lambda implements Function1<Object, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ DerivedSnapshotState<T> f9114g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ IdentityArrayMap<StateObject, Integer> f9115h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ int f9116i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DerivedSnapshotState$currentRecord$result$1$result$1(DerivedSnapshotState<T> derivedSnapshotState, IdentityArrayMap<StateObject, Integer> identityArrayMap, int i11) {
        super(1);
        this.f9114g = derivedSnapshotState;
        this.f9115h = identityArrayMap;
        this.f9116i = i11;
    }

    public final void invoke(@NotNull Object obj) {
        Intrinsics.checkNotNullParameter(obj, "it");
        if (obj == this.f9114g) {
            throw new IllegalStateException("A derived state calculation cannot read itself".toString());
        } else if (obj instanceof StateObject) {
            Object obj2 = SnapshotStateKt__DerivedStateKt.calculationBlockNestedLevel.get();
            Intrinsics.checkNotNull(obj2);
            int intValue = ((Number) obj2).intValue();
            IdentityArrayMap<StateObject, Integer> identityArrayMap = this.f9115h;
            int i11 = intValue - this.f9116i;
            Integer num = identityArrayMap.get(obj);
            identityArrayMap.set(obj, Integer.valueOf(Math.min(i11, num != null ? num.intValue() : Integer.MAX_VALUE)));
        }
    }
}
