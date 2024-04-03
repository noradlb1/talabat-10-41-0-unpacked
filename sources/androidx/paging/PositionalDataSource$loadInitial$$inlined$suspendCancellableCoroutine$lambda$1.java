package androidx.paging;

import androidx.paging.DataSource;
import androidx.paging.PositionalDataSource;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001e\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J&\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u001e\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\rH\u0002¨\u0006\u000e¸\u0006\u0000"}, d2 = {"androidx/paging/PositionalDataSource$loadInitial$2$1", "Landroidx/paging/PositionalDataSource$LoadInitialCallback;", "onResult", "", "data", "", "position", "", "totalCount", "resume", "params", "Landroidx/paging/PositionalDataSource$LoadInitialParams;", "result", "Landroidx/paging/DataSource$BaseResult;", "paging-common"}, k = 1, mv = {1, 4, 2})
public final class PositionalDataSource$loadInitial$$inlined$suspendCancellableCoroutine$lambda$1 extends PositionalDataSource.LoadInitialCallback<T> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CancellableContinuation f37047a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PositionalDataSource f37048b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ PositionalDataSource.LoadInitialParams f37049c;

    public PositionalDataSource$loadInitial$$inlined$suspendCancellableCoroutine$lambda$1(CancellableContinuation cancellableContinuation, PositionalDataSource positionalDataSource, PositionalDataSource.LoadInitialParams loadInitialParams) {
        this.f37047a = cancellableContinuation;
        this.f37048b = positionalDataSource;
        this.f37049c = loadInitialParams;
    }

    private final void resume(PositionalDataSource.LoadInitialParams loadInitialParams, DataSource.BaseResult<T> baseResult) {
        if (loadInitialParams.placeholdersEnabled) {
            baseResult.validateForInitialTiling$paging_common(loadInitialParams.pageSize);
        }
        this.f37047a.resumeWith(Result.m6329constructorimpl(baseResult));
    }

    public void onResult(@NotNull List<? extends T> list, int i11, int i12) {
        Integer num;
        Integer num2;
        Intrinsics.checkNotNullParameter(list, "data");
        if (this.f37048b.isInvalid()) {
            this.f37047a.resumeWith(Result.m6329constructorimpl(DataSource.BaseResult.Companion.empty$paging_common()));
            return;
        }
        int size = list.size() + i11;
        PositionalDataSource.LoadInitialParams loadInitialParams = this.f37049c;
        if (i11 == 0) {
            num = null;
        } else {
            num = Integer.valueOf(i11);
        }
        if (size == i12) {
            num2 = null;
        } else {
            num2 = Integer.valueOf(size);
        }
        resume(loadInitialParams, new DataSource.BaseResult(list, num, num2, i11, (i12 - list.size()) - i11));
    }

    public void onResult(@NotNull List<? extends T> list, int i11) {
        Integer num;
        Intrinsics.checkNotNullParameter(list, "data");
        if (this.f37048b.isInvalid()) {
            this.f37047a.resumeWith(Result.m6329constructorimpl(DataSource.BaseResult.Companion.empty$paging_common()));
            return;
        }
        PositionalDataSource.LoadInitialParams loadInitialParams = this.f37049c;
        if (i11 == 0) {
            num = null;
        } else {
            num = Integer.valueOf(i11);
        }
        resume(loadInitialParams, new DataSource.BaseResult(list, num, Integer.valueOf(list.size() + i11), i11, Integer.MIN_VALUE));
    }
}
