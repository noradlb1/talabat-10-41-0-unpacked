package androidx.paging;

import androidx.paging.RxPagedListBuilder;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u0003\"\b\b\u0002\u0010\u0002*\u00020\u0003\"\b\b\u0003\u0010\u0004*\u00020\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "Key", "", "Value", "run"}, k = 3, mv = {1, 4, 2})
public final class RxPagedListBuilder$PagingObservableOnSubscribe$refreshRetryCallback$1 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ RxPagedListBuilder.PagingObservableOnSubscribe f37087b;

    public RxPagedListBuilder$PagingObservableOnSubscribe$refreshRetryCallback$1(RxPagedListBuilder.PagingObservableOnSubscribe pagingObservableOnSubscribe) {
        this.f37087b = pagingObservableOnSubscribe;
    }

    public final void run() {
        this.f37087b.invalidate(true);
    }
}
