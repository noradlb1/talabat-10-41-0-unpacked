package ls;

import com.talabat.impressions.RecyclerViewImpressionTracker;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class d implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ RecyclerViewImpressionTracker f62274b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f62275c;

    public /* synthetic */ d(RecyclerViewImpressionTracker recyclerViewImpressionTracker, int i11) {
        this.f62274b = recyclerViewImpressionTracker;
        this.f62275c = i11;
    }

    public final void accept(Object obj) {
        RecyclerViewImpressionTracker.m10662onStartTimer$lambda2(this.f62274b, this.f62275c, (Throwable) obj);
    }
}
