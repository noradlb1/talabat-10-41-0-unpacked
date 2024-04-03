package g3;

import com.airbnb.lottie.LottieCompositionFactory;
import java.util.concurrent.Callable;
import org.json.JSONObject;

public final /* synthetic */ class h implements Callable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ JSONObject f44310b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f44311c;

    public /* synthetic */ h(JSONObject jSONObject, String str) {
        this.f44310b = jSONObject;
        this.f44311c = str;
    }

    public final Object call() {
        return LottieCompositionFactory.fromJsonSync(this.f44310b, this.f44311c);
    }
}
