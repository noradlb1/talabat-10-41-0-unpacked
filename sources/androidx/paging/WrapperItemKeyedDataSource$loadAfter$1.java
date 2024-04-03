package androidx.paging;

import androidx.paging.ItemKeyedDataSource;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0016¨\u0006\u0006"}, d2 = {"androidx/paging/WrapperItemKeyedDataSource$loadAfter$1", "Landroidx/paging/ItemKeyedDataSource$LoadCallback;", "onResult", "", "data", "", "paging-common"}, k = 1, mv = {1, 4, 2})
public final class WrapperItemKeyedDataSource$loadAfter$1 extends ItemKeyedDataSource.LoadCallback<A> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WrapperItemKeyedDataSource f37177a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ItemKeyedDataSource.LoadCallback f37178b;

    public WrapperItemKeyedDataSource$loadAfter$1(WrapperItemKeyedDataSource wrapperItemKeyedDataSource, ItemKeyedDataSource.LoadCallback loadCallback) {
        this.f37177a = wrapperItemKeyedDataSource;
        this.f37178b = loadCallback;
    }

    public void onResult(@NotNull List<? extends A> list) {
        Intrinsics.checkNotNullParameter(list, "data");
        this.f37178b.onResult(this.f37177a.convertWithStashedKeys(list));
    }
}
