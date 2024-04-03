package androidx.paging;

import androidx.paging.PositionalDataSource;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001e\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J&\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016¨\u0006\t"}, d2 = {"androidx/paging/WrapperPositionalDataSource$loadInitial$1", "Landroidx/paging/PositionalDataSource$LoadInitialCallback;", "onResult", "", "data", "", "position", "", "totalCount", "paging-common"}, k = 1, mv = {1, 4, 2})
public final class WrapperPositionalDataSource$loadInitial$1 extends PositionalDataSource.LoadInitialCallback<A> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WrapperPositionalDataSource f37189a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PositionalDataSource.LoadInitialCallback f37190b;

    public WrapperPositionalDataSource$loadInitial$1(WrapperPositionalDataSource wrapperPositionalDataSource, PositionalDataSource.LoadInitialCallback loadInitialCallback) {
        this.f37189a = wrapperPositionalDataSource;
        this.f37190b = loadInitialCallback;
    }

    public void onResult(@NotNull List<? extends A> list, int i11, int i12) {
        Intrinsics.checkNotNullParameter(list, "data");
        this.f37190b.onResult(DataSource.Companion.convert$paging_common(this.f37189a.getListFunction(), list), i11, i12);
    }

    public void onResult(@NotNull List<? extends A> list, int i11) {
        Intrinsics.checkNotNullParameter(list, "data");
        this.f37190b.onResult(DataSource.Companion.convert$paging_common(this.f37189a.getListFunction(), list), i11);
    }
}
