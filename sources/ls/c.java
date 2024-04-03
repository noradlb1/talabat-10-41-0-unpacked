package ls;

import com.talabat.impressions.RecyclerViewImpressionTracker;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class c implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ RecyclerViewImpressionTracker f62272b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f62273c;

    public /* synthetic */ c(RecyclerViewImpressionTracker recyclerViewImpressionTracker, int i11) {
        this.f62272b = recyclerViewImpressionTracker;
        this.f62273c = i11;
    }

    public final void accept(Object obj) {
        RecyclerViewImpressionTracker.m10661onStartTimer$lambda1(this.f62272b, this.f62273c, (Long) obj);
    }
}
