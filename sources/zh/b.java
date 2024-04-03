package zh;

import com.bumptech.glide.RequestBuilder;
import com.talabat.darkstores.common.bindingAdapters.BindingAdaptersKt$retryOnFailureAndReportToObservabilityIfRetryFails$1;
import java.lang.ref.WeakReference;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ WeakReference f58065b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ RequestBuilder f58066c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f58067d;

    public /* synthetic */ b(WeakReference weakReference, RequestBuilder requestBuilder, String str) {
        this.f58065b = weakReference;
        this.f58066c = requestBuilder;
        this.f58067d = str;
    }

    public final void run() {
        BindingAdaptersKt$retryOnFailureAndReportToObservabilityIfRetryFails$1.m9634onLoadFailed$lambda1(this.f58065b, this.f58066c, this.f58067d);
    }
}
