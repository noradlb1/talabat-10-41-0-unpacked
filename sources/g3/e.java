package g3;

import com.airbnb.lottie.LottieCompositionFactory;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.util.concurrent.Callable;

public final /* synthetic */ class e implements Callable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ JsonReader f44301b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f44302c;

    public /* synthetic */ e(JsonReader jsonReader, String str) {
        this.f44301b = jsonReader;
        this.f44302c = str;
    }

    public final Object call() {
        return LottieCompositionFactory.fromJsonReaderSync(this.f44301b, this.f44302c);
    }
}
