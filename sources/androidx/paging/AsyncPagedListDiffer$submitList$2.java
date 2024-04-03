package androidx.paging;

import androidx.recyclerview.widget.DiffUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "T", "", "run"}, k = 3, mv = {1, 4, 2})
public final class AsyncPagedListDiffer$submitList$2 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AsyncPagedListDiffer f36452b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ PagedList f36453c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ PagedList f36454d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ int f36455e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ PagedList f36456f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ RecordingCallback f36457g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Runnable f36458h;

    public AsyncPagedListDiffer$submitList$2(AsyncPagedListDiffer asyncPagedListDiffer, PagedList pagedList, PagedList pagedList2, int i11, PagedList pagedList3, RecordingCallback recordingCallback, Runnable runnable) {
        this.f36452b = asyncPagedListDiffer;
        this.f36453c = pagedList;
        this.f36454d = pagedList2;
        this.f36455e = i11;
        this.f36456f = pagedList3;
        this.f36457g = recordingCallback;
        this.f36458h = runnable;
    }

    public final void run() {
        NullPaddedList nullPaddedList = this.f36453c.getNullPaddedList();
        NullPaddedList nullPaddedList2 = this.f36454d.getNullPaddedList();
        DiffUtil.ItemCallback diffCallback = this.f36452b.getConfig$paging_runtime_release().getDiffCallback();
        Intrinsics.checkNotNullExpressionValue(diffCallback, "config.diffCallback");
        final NullPaddedDiffResult computeDiff = NullPaddedListDiffHelperKt.computeDiff(nullPaddedList, nullPaddedList2, diffCallback);
        this.f36452b.getMainThreadExecutor$paging_runtime_release().execute(new Runnable(this) {

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ AsyncPagedListDiffer$submitList$2 f36459b;

            {
                this.f36459b = r1;
            }

            public final void run() {
                int maxScheduledGeneration$paging_runtime_release = this.f36459b.f36452b.getMaxScheduledGeneration$paging_runtime_release();
                AsyncPagedListDiffer$submitList$2 asyncPagedListDiffer$submitList$2 = this.f36459b;
                if (maxScheduledGeneration$paging_runtime_release == asyncPagedListDiffer$submitList$2.f36455e) {
                    asyncPagedListDiffer$submitList$2.f36452b.latchPagedList$paging_runtime_release(asyncPagedListDiffer$submitList$2.f36456f, asyncPagedListDiffer$submitList$2.f36454d, computeDiff, asyncPagedListDiffer$submitList$2.f36457g, asyncPagedListDiffer$submitList$2.f36453c.lastLoad(), this.f36459b.f36458h);
                }
            }
        });
    }
}
