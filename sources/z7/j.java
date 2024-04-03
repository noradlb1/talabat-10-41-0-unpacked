package z7;

import com.google.android.exoplayer2.offline.DownloadManager;
import com.google.android.exoplayer2.scheduler.RequirementsWatcher;

public final /* synthetic */ class j implements RequirementsWatcher.Listener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DownloadManager f35586a;

    public /* synthetic */ j(DownloadManager downloadManager) {
        this.f35586a = downloadManager;
    }

    public final void onRequirementsStateChanged(RequirementsWatcher requirementsWatcher, int i11) {
        this.f35586a.onRequirementsStateChanged(requirementsWatcher, i11);
    }
}
