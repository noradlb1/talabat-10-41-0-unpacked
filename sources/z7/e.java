package z7;

import com.google.android.exoplayer2.offline.DownloadHelper;
import com.google.android.exoplayer2.text.CueGroup;
import com.google.android.exoplayer2.text.TextOutput;
import i8.c;
import java.util.List;

public final /* synthetic */ class e implements TextOutput {
    public final void onCues(CueGroup cueGroup) {
        DownloadHelper.lambda$getRendererCapabilities$0(cueGroup);
    }

    public /* synthetic */ void onCues(List list) {
        c.a(this, list);
    }
}
