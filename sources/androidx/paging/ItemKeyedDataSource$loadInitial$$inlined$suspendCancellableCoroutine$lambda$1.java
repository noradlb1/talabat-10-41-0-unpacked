package androidx.paging;

import androidx.paging.DataSource;
import androidx.paging.ItemKeyedDataSource;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0016J&\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016¨\u0006\t¸\u0006\u0000"}, d2 = {"androidx/paging/ItemKeyedDataSource$loadInitial$2$1", "Landroidx/paging/ItemKeyedDataSource$LoadInitialCallback;", "onResult", "", "data", "", "position", "", "totalCount", "paging-common"}, k = 1, mv = {1, 4, 2})
public final class ItemKeyedDataSource$loadInitial$$inlined$suspendCancellableCoroutine$lambda$1 extends ItemKeyedDataSource.LoadInitialCallback<Value> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CancellableContinuation f36603a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ItemKeyedDataSource f36604b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ItemKeyedDataSource.LoadInitialParams f36605c;

    public ItemKeyedDataSource$loadInitial$$inlined$suspendCancellableCoroutine$lambda$1(CancellableContinuation cancellableContinuation, ItemKeyedDataSource itemKeyedDataSource, ItemKeyedDataSource.LoadInitialParams loadInitialParams) {
        this.f36603a = cancellableContinuation;
        this.f36604b = itemKeyedDataSource;
        this.f36605c = loadInitialParams;
    }

    public void onResult(@NotNull List<? extends Value> list, int i11, int i12) {
        Intrinsics.checkNotNullParameter(list, "data");
        this.f36603a.resumeWith(Result.m6329constructorimpl(new DataSource.BaseResult(list, this.f36604b.getPrevKey$paging_common(list), this.f36604b.getNextKey$paging_common(list), i11, (i12 - list.size()) - i11)));
    }

    public void onResult(@NotNull List<? extends Value> list) {
        Intrinsics.checkNotNullParameter(list, "data");
        this.f36603a.resumeWith(Result.m6329constructorimpl(new DataSource.BaseResult(list, this.f36604b.getPrevKey$paging_common(list), this.f36604b.getNextKey$paging_common(list), 0, 0, 24, (DefaultConstructorMarker) null)));
    }
}
