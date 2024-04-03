package androidx.paging;

import androidx.paging.PositionalDataSource;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0016¨\u0006\u0006"}, d2 = {"androidx/paging/WrapperPositionalDataSource$loadRange$1", "Landroidx/paging/PositionalDataSource$LoadRangeCallback;", "onResult", "", "data", "", "paging-common"}, k = 1, mv = {1, 4, 2})
public final class WrapperPositionalDataSource$loadRange$1 extends PositionalDataSource.LoadRangeCallback<A> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WrapperPositionalDataSource f37191a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PositionalDataSource.LoadRangeCallback f37192b;

    public WrapperPositionalDataSource$loadRange$1(WrapperPositionalDataSource wrapperPositionalDataSource, PositionalDataSource.LoadRangeCallback loadRangeCallback) {
        this.f37191a = wrapperPositionalDataSource;
        this.f37192b = loadRangeCallback;
    }

    public void onResult(@NotNull List<? extends A> list) {
        Intrinsics.checkNotNullParameter(list, "data");
        this.f37192b.onResult(DataSource.Companion.convert$paging_common(this.f37191a.getListFunction(), list));
    }
}
