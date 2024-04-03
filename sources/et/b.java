package et;

import com.talabat.restaurants.inlineads.RxAdLoader;
import io.reactivex.functions.Function;
import java.util.List;

public final /* synthetic */ class b implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ RxAdLoader f62002b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f62003c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f62004d;

    public /* synthetic */ b(RxAdLoader rxAdLoader, int i11, String str) {
        this.f62002b = rxAdLoader;
        this.f62003c = i11;
        this.f62004d = str;
    }

    public final Object apply(Object obj) {
        return RxAdLoader.m10720loadAds$lambda2(this.f62002b, this.f62003c, this.f62004d, (List) obj);
    }
}
