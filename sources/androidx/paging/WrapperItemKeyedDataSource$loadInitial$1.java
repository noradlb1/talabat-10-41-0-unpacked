package androidx.paging;

import androidx.paging.ItemKeyedDataSource;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0016J&\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016¨\u0006\t"}, d2 = {"androidx/paging/WrapperItemKeyedDataSource$loadInitial$1", "Landroidx/paging/ItemKeyedDataSource$LoadInitialCallback;", "onResult", "", "data", "", "position", "", "totalCount", "paging-common"}, k = 1, mv = {1, 4, 2})
public final class WrapperItemKeyedDataSource$loadInitial$1 extends ItemKeyedDataSource.LoadInitialCallback<A> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WrapperItemKeyedDataSource f37181a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ItemKeyedDataSource.LoadInitialCallback f37182b;

    public WrapperItemKeyedDataSource$loadInitial$1(WrapperItemKeyedDataSource wrapperItemKeyedDataSource, ItemKeyedDataSource.LoadInitialCallback loadInitialCallback) {
        this.f37181a = wrapperItemKeyedDataSource;
        this.f37182b = loadInitialCallback;
    }

    public void onResult(@NotNull List<? extends A> list, int i11, int i12) {
        Intrinsics.checkNotNullParameter(list, "data");
        this.f37182b.onResult(this.f37181a.convertWithStashedKeys(list), i11, i12);
    }

    public void onResult(@NotNull List<? extends A> list) {
        Intrinsics.checkNotNullParameter(list, "data");
        this.f37182b.onResult(this.f37181a.convertWithStashedKeys(list));
    }
}
