package v6;

import android.graphics.Bitmap;
import com.facebook.internal.ImageDownloader;
import com.facebook.internal.ImageRequest;

public final /* synthetic */ class l implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ImageRequest f34756b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Exception f34757c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ boolean f34758d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Bitmap f34759e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ ImageRequest.Callback f34760f;

    public /* synthetic */ l(ImageRequest imageRequest, Exception exc, boolean z11, Bitmap bitmap, ImageRequest.Callback callback) {
        this.f34756b = imageRequest;
        this.f34757c = exc;
        this.f34758d = z11;
        this.f34759e = bitmap;
        this.f34760f = callback;
    }

    public final void run() {
        ImageDownloader.m8959issueResponse$lambda4(this.f34756b, this.f34757c, this.f34758d, this.f34759e, this.f34760f);
    }
}
