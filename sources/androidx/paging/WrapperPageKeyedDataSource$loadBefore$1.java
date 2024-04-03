package androidx.paging;

import androidx.paging.PageKeyedDataSource;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0001J%\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00018\u0000H\u0016¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"androidx/paging/WrapperPageKeyedDataSource$loadBefore$1", "Landroidx/paging/PageKeyedDataSource$LoadCallback;", "onResult", "", "data", "", "adjacentPageKey", "(Ljava/util/List;Ljava/lang/Object;)V", "paging-common"}, k = 1, mv = {1, 4, 2})
public final class WrapperPageKeyedDataSource$loadBefore$1 extends PageKeyedDataSource.LoadCallback<K, A> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WrapperPageKeyedDataSource f37185a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PageKeyedDataSource.LoadCallback f37186b;

    public WrapperPageKeyedDataSource$loadBefore$1(WrapperPageKeyedDataSource wrapperPageKeyedDataSource, PageKeyedDataSource.LoadCallback loadCallback) {
        this.f37185a = wrapperPageKeyedDataSource;
        this.f37186b = loadCallback;
    }

    public void onResult(@NotNull List<? extends A> list, @Nullable K k11) {
        Intrinsics.checkNotNullParameter(list, "data");
        this.f37186b.onResult(DataSource.Companion.convert$paging_common(this.f37185a.listFunction, list), k11);
    }
}
