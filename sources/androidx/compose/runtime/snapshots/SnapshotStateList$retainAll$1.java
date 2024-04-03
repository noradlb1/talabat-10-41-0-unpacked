package androidx.compose.runtime.snapshots;

import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "T", "it", "", "invoke", "(Ljava/util/List;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class SnapshotStateList$retainAll$1 extends Lambda implements Function1<List<T>, Boolean> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Collection<T> f9539g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SnapshotStateList$retainAll$1(Collection<? extends T> collection) {
        super(1);
        this.f9539g = collection;
    }

    @NotNull
    public final Boolean invoke(@NotNull List<T> list) {
        Intrinsics.checkNotNullParameter(list, "it");
        return Boolean.valueOf(list.retainAll(this.f9539g));
    }
}
