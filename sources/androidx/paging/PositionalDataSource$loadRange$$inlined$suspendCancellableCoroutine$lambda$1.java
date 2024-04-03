package androidx.paging;

import androidx.paging.DataSource;
import androidx.paging.PositionalDataSource;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0016¨\u0006\u0006¸\u0006\u0000"}, d2 = {"androidx/paging/PositionalDataSource$loadRange$2$1", "Landroidx/paging/PositionalDataSource$LoadRangeCallback;", "onResult", "", "data", "", "paging-common"}, k = 1, mv = {1, 4, 2})
public final class PositionalDataSource$loadRange$$inlined$suspendCancellableCoroutine$lambda$1 extends PositionalDataSource.LoadRangeCallback<T> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CancellableContinuation f37050a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PositionalDataSource f37051b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ PositionalDataSource.LoadRangeParams f37052c;

    public PositionalDataSource$loadRange$$inlined$suspendCancellableCoroutine$lambda$1(CancellableContinuation cancellableContinuation, PositionalDataSource positionalDataSource, PositionalDataSource.LoadRangeParams loadRangeParams) {
        this.f37050a = cancellableContinuation;
        this.f37051b = positionalDataSource;
        this.f37052c = loadRangeParams;
    }

    public void onResult(@NotNull List<? extends T> list) {
        Integer num;
        Intrinsics.checkNotNullParameter(list, "data");
        int i11 = this.f37052c.startPosition;
        if (i11 == 0) {
            num = null;
        } else {
            num = Integer.valueOf(i11);
        }
        Integer num2 = num;
        if (this.f37051b.isInvalid()) {
            this.f37050a.resumeWith(Result.m6329constructorimpl(DataSource.BaseResult.Companion.empty$paging_common()));
            return;
        }
        this.f37050a.resumeWith(Result.m6329constructorimpl(new DataSource.BaseResult(list, num2, Integer.valueOf(this.f37052c.startPosition + list.size()), 0, 0, 24, (DefaultConstructorMarker) null)));
    }
}
