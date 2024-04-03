package androidx.paging;

import androidx.paging.PageKeyedDataSource;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0001J/\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00018\u00002\b\u0010\u0007\u001a\u0004\u0018\u00018\u0000H\u0016¢\u0006\u0002\u0010\bJ?\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\u0006\u001a\u0004\u0018\u00018\u00002\b\u0010\u0007\u001a\u0004\u0018\u00018\u0000H\u0016¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"androidx/paging/WrapperPageKeyedDataSource$loadInitial$1", "Landroidx/paging/PageKeyedDataSource$LoadInitialCallback;", "onResult", "", "data", "", "previousPageKey", "nextPageKey", "(Ljava/util/List;Ljava/lang/Object;Ljava/lang/Object;)V", "position", "", "totalCount", "(Ljava/util/List;IILjava/lang/Object;Ljava/lang/Object;)V", "paging-common"}, k = 1, mv = {1, 4, 2})
public final class WrapperPageKeyedDataSource$loadInitial$1 extends PageKeyedDataSource.LoadInitialCallback<K, A> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WrapperPageKeyedDataSource f37187a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PageKeyedDataSource.LoadInitialCallback f37188b;

    public WrapperPageKeyedDataSource$loadInitial$1(WrapperPageKeyedDataSource wrapperPageKeyedDataSource, PageKeyedDataSource.LoadInitialCallback loadInitialCallback) {
        this.f37187a = wrapperPageKeyedDataSource;
        this.f37188b = loadInitialCallback;
    }

    public void onResult(@NotNull List<? extends A> list, int i11, int i12, @Nullable K k11, @Nullable K k12) {
        Intrinsics.checkNotNullParameter(list, "data");
        this.f37188b.onResult(DataSource.Companion.convert$paging_common(this.f37187a.listFunction, list), i11, i12, k11, k12);
    }

    public void onResult(@NotNull List<? extends A> list, @Nullable K k11, @Nullable K k12) {
        Intrinsics.checkNotNullParameter(list, "data");
        this.f37188b.onResult(DataSource.Companion.convert$paging_common(this.f37187a.listFunction, list), k11, k12);
    }
}
