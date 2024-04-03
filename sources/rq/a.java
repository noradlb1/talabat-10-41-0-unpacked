package rq;

import com.talabat.gem.adapters.presentation.GemFlowTrackerKt;
import io.reactivex.functions.Predicate;
import java.util.List;

public final /* synthetic */ class a implements Predicate {
    public final boolean test(Object obj) {
        return GemFlowTrackerKt.m10534observeOnFlowTracker$lambda0((List) obj);
    }
}
