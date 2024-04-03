package g3;

import com.airbnb.lottie.LottieCompositionFactory;
import java.util.concurrent.Callable;

public final /* synthetic */ class l implements Callable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f44317b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f44318c;

    public /* synthetic */ l(String str, String str2) {
        this.f44317b = str;
        this.f44318c = str2;
    }

    public final Object call() {
        return LottieCompositionFactory.fromJsonStringSync(this.f44317b, this.f44318c);
    }
}
