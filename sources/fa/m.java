package fa;

import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.messaging.ImageDownload;

public final /* synthetic */ class m implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ImageDownload f50633b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f50634c;

    public /* synthetic */ m(ImageDownload imageDownload, TaskCompletionSource taskCompletionSource) {
        this.f50633b = imageDownload;
        this.f50634c = taskCompletionSource;
    }

    public final void run() {
        this.f50633b.lambda$start$0(this.f50634c);
    }
}
