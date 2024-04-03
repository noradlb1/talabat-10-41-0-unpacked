package z7;

import com.google.android.exoplayer2.offline.ProgressiveDownloader;
import com.google.android.exoplayer2.upstream.cache.CacheWriter;

public final /* synthetic */ class l implements CacheWriter.ProgressListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ProgressiveDownloader f35587a;

    public /* synthetic */ l(ProgressiveDownloader progressiveDownloader) {
        this.f35587a = progressiveDownloader;
    }

    public final void onProgress(long j11, long j12, long j13) {
        this.f35587a.onProgress(j11, j12, j13);
    }
}
