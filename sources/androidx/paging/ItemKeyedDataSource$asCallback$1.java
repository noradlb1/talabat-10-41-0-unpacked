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

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0016¨\u0006\u0006"}, d2 = {"androidx/paging/ItemKeyedDataSource$asCallback$1", "Landroidx/paging/ItemKeyedDataSource$LoadCallback;", "onResult", "", "data", "", "paging-common"}, k = 1, mv = {1, 4, 2})
public final class ItemKeyedDataSource$asCallback$1 extends ItemKeyedDataSource.LoadCallback<Value> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ItemKeyedDataSource f36606a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CancellableContinuation f36607b;

    public ItemKeyedDataSource$asCallback$1(ItemKeyedDataSource itemKeyedDataSource, CancellableContinuation<? super DataSource.BaseResult<Value>> cancellableContinuation) {
        this.f36606a = itemKeyedDataSource;
        this.f36607b = cancellableContinuation;
    }

    public void onResult(@NotNull List<? extends Value> list) {
        Intrinsics.checkNotNullParameter(list, "data");
        this.f36607b.resumeWith(Result.m6329constructorimpl(new DataSource.BaseResult(list, this.f36606a.getPrevKey$paging_common(list), this.f36606a.getNextKey$paging_common(list), 0, 0, 24, (DefaultConstructorMarker) null)));
    }
}
