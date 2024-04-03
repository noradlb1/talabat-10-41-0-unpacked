package d8;

import com.google.android.exoplayer2.source.dash.BaseUrlExclusionList;
import com.google.android.exoplayer2.source.dash.manifest.BaseUrl;
import java.util.Comparator;

public final /* synthetic */ class a implements Comparator {
    public final int compare(Object obj, Object obj2) {
        return BaseUrlExclusionList.compareBaseUrl((BaseUrl) obj, (BaseUrl) obj2);
    }
}
