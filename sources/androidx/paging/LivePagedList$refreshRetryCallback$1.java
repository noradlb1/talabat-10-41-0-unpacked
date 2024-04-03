package androidx.paging;

import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "Key", "", "Value", "run"}, k = 3, mv = {1, 4, 2})
public final class LivePagedList$refreshRetryCallback$1 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LivePagedList f36636b;

    public LivePagedList$refreshRetryCallback$1(LivePagedList livePagedList) {
        this.f36636b = livePagedList;
    }

    public final void run() {
        this.f36636b.invalidate(true);
    }
}
