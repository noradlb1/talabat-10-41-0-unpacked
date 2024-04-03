package g3;

import android.content.Context;
import com.airbnb.lottie.LottieCompositionFactory;
import java.lang.ref.WeakReference;
import java.util.concurrent.Callable;

public final /* synthetic */ class f implements Callable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ WeakReference f44303b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Context f44304c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f44305d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ String f44306e;

    public /* synthetic */ f(WeakReference weakReference, Context context, int i11, String str) {
        this.f44303b = weakReference;
        this.f44304c = context;
        this.f44305d = i11;
        this.f44306e = str;
    }

    public final Object call() {
        return LottieCompositionFactory.lambda$fromRawRes$2(this.f44303b, this.f44304c, this.f44305d, this.f44306e);
    }
}
