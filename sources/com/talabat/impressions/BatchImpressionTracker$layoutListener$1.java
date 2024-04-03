package com.talabat.impressions;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "T", "Lcom/talabat/impressions/ImpressionsItem;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class BatchImpressionTracker$layoutListener$1 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ BatchImpressionTracker<T> f60981g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BatchImpressionTracker$layoutListener$1(BatchImpressionTracker<T> batchImpressionTracker) {
        super(0);
        this.f60981g = batchImpressionTracker;
    }

    public final void invoke() {
        if (!this.f60981g.firstTrackFlag) {
            BatchImpressionTracker<T> batchImpressionTracker = this.f60981g;
            batchImpressionTracker.analyseView(batchImpressionTracker.mainRecyclerView);
            this.f60981g.firstTrackFlag = true;
        }
    }
}
