package y7;

import com.google.android.exoplayer2.metadata.mp4.SlowMotionData;
import com.google.common.collect.ComparisonChain;
import java.util.Comparator;

public final /* synthetic */ class a implements Comparator {
    public final int compare(Object obj, Object obj2) {
        return ComparisonChain.start().compare(((SlowMotionData.Segment) obj).startTimeMs, ((SlowMotionData.Segment) obj2).startTimeMs).compare(((SlowMotionData.Segment) obj).endTimeMs, ((SlowMotionData.Segment) obj2).endTimeMs).compare(((SlowMotionData.Segment) obj).speedDivisor, ((SlowMotionData.Segment) obj2).speedDivisor).result();
    }
}
