package z7;

import com.google.android.exoplayer2.offline.DownloadHelper;

public final /* synthetic */ class h implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DownloadHelper f35583b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ DownloadHelper.Callback f35584c;

    public /* synthetic */ h(DownloadHelper downloadHelper, DownloadHelper.Callback callback) {
        this.f35583b = downloadHelper;
        this.f35584c = callback;
    }

    public final void run() {
        this.f35583b.lambda$prepare$3(this.f35584c);
    }
}
