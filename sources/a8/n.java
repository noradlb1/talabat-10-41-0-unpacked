package a8;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.analytics.PlayerId;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.upstream.TransferListener;

public final /* synthetic */ class n {
    @Nullable
    public static Timeline a(MediaSource mediaSource) {
        return null;
    }

    public static boolean b(MediaSource mediaSource) {
        return true;
    }

    @Deprecated
    public static void c(MediaSource mediaSource, MediaSource.MediaSourceCaller mediaSourceCaller, @Nullable TransferListener transferListener) {
        mediaSource.prepareSource(mediaSourceCaller, transferListener, PlayerId.UNSET);
    }
}
