package com.talabat.impressions;

import java.util.Timer;
import java.util.TimerTask;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "T", "Lcom/talabat/impressions/ImpressionsItem;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class RecyclerViewImpressionTracker$layoutListener$1 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ RecyclerViewImpressionTracker<T> f60984g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RecyclerViewImpressionTracker$layoutListener$1(RecyclerViewImpressionTracker<T> recyclerViewImpressionTracker) {
        super(0);
        this.f60984g = recyclerViewImpressionTracker;
    }

    public final void invoke() {
        if (!this.f60984g.firstTrackFlag) {
            this.f60984g.timer = new Timer();
            Timer access$getTimer$p = this.f60984g.timer;
            if (access$getTimer$p != null) {
                final RecyclerViewImpressionTracker<T> recyclerViewImpressionTracker = this.f60984g;
                access$getTimer$p.schedule(new TimerTask() {
                    public void run() {
                        RecyclerViewImpressionTracker<T> recyclerViewImpressionTracker = recyclerViewImpressionTracker;
                        recyclerViewImpressionTracker.analyseView(recyclerViewImpressionTracker.mainRecyclerView);
                        Timer access$getTimer$p = recyclerViewImpressionTracker.timer;
                        if (access$getTimer$p != null) {
                            access$getTimer$p.cancel();
                        }
                    }
                }, 500);
            }
            this.f60984g.firstTrackFlag = true;
        }
    }
}
