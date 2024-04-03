package g3;

import android.content.Context;
import com.airbnb.lottie.LottieCompositionFactory;
import java.util.concurrent.Callable;

public final /* synthetic */ class o implements Callable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Context f44323b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f44324c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f44325d;

    public /* synthetic */ o(Context context, String str, String str2) {
        this.f44323b = context;
        this.f44324c = str;
        this.f44325d = str2;
    }

    public final Object call() {
        return LottieCompositionFactory.fromAssetSync(this.f44323b, this.f44324c, this.f44325d);
    }
}
