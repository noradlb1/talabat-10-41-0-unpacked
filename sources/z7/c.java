package z7;

import com.google.android.exoplayer2.offline.DownloadHelper;
import java.io.IOException;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DownloadHelper f35580b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ IOException f35581c;

    public /* synthetic */ c(DownloadHelper downloadHelper, IOException iOException) {
        this.f35580b = downloadHelper;
        this.f35581c = iOException;
    }

    public final void run() {
        this.f35580b.lambda$onMediaPreparationFailed$5(this.f35581c);
    }
}
