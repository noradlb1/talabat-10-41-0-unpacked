package g3;

import android.content.Context;
import com.airbnb.lottie.LottieCompositionFactory;
import java.util.concurrent.Callable;

public final /* synthetic */ class g implements Callable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Context f44307b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f44308c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f44309d;

    public /* synthetic */ g(Context context, String str, String str2) {
        this.f44307b = context;
        this.f44308c = str;
        this.f44309d = str2;
    }

    public final Object call() {
        return LottieCompositionFactory.lambda$fromUrl$0(this.f44307b, this.f44308c, this.f44309d);
    }
}
