package ma;

import com.google.android.datatransport.Transformer;
import com.google.firebase.perf.v1.PerfMetric;

public final /* synthetic */ class a implements Transformer {
    public final Object apply(Object obj) {
        return ((PerfMetric) obj).toByteArray();
    }
}
