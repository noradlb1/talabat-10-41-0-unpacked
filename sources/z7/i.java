package z7;

import android.os.Handler;
import android.os.Message;
import com.google.android.exoplayer2.offline.DownloadManager;

public final /* synthetic */ class i implements Handler.Callback {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DownloadManager f35585b;

    public /* synthetic */ i(DownloadManager downloadManager) {
        this.f35585b = downloadManager;
    }

    public final boolean handleMessage(Message message) {
        return this.f35585b.handleMainMessage(message);
    }
}
