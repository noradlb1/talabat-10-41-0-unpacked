package j8;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.trackselection.BaseTrackSelection;
import java.util.Comparator;

public final /* synthetic */ class a implements Comparator {
    public final int compare(Object obj, Object obj2) {
        return BaseTrackSelection.lambda$new$0((Format) obj, (Format) obj2);
    }
}
