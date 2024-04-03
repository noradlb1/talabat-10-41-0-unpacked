package androidx.paging;

import androidx.paging.DataSource;
import androidx.paging.PageKeyedDataSource;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0001J%\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00018\u0000H\u0016¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"androidx/paging/PageKeyedDataSource$continuationAsCallback$1", "Landroidx/paging/PageKeyedDataSource$LoadCallback;", "onResult", "", "data", "", "adjacentPageKey", "(Ljava/util/List;Ljava/lang/Object;)V", "paging-common"}, k = 1, mv = {1, 4, 2})
public final class PageKeyedDataSource$continuationAsCallback$1 extends PageKeyedDataSource.LoadCallback<Key, Value> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CancellableContinuation f36844a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ boolean f36845b;

    public PageKeyedDataSource$continuationAsCallback$1(CancellableContinuation cancellableContinuation, boolean z11) {
        this.f36844a = cancellableContinuation;
        this.f36845b = z11;
    }

    public void onResult(@NotNull List<? extends Value> list, @Nullable Key key) {
        Key key2;
        Key key3;
        Intrinsics.checkNotNullParameter(list, "data");
        CancellableContinuation cancellableContinuation = this.f36844a;
        boolean z11 = this.f36845b;
        if (z11) {
            key2 = null;
        } else {
            key2 = key;
        }
        if (z11) {
            key3 = key;
        } else {
            key3 = null;
        }
        cancellableContinuation.resumeWith(Result.m6329constructorimpl(new DataSource.BaseResult(list, key2, key3, 0, 0, 24, (DefaultConstructorMarker) null)));
    }
}
