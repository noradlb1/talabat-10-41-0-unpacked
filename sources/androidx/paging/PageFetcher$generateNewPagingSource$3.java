package androidx.paging;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u0003¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "Key", "", "Value", "invoke"}, k = 3, mv = {1, 4, 2})
public final /* synthetic */ class PageFetcher$generateNewPagingSource$3 extends FunctionReferenceImpl implements Function0<Unit> {
    public PageFetcher$generateNewPagingSource$3(PageFetcher pageFetcher) {
        super(0, pageFetcher, PageFetcher.class, "invalidate", "invalidate()V", 0);
    }

    public final void invoke() {
        ((PageFetcher) this.receiver).invalidate();
    }
}
