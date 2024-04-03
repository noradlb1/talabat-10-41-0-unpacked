package ri;

import com.talabat.darkstores.feature.cart.PostCartUseCase;
import io.reactivex.functions.Function;
import java.util.List;

public final /* synthetic */ class q1 implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ List f57342b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ float f57343c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ float f57344d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ boolean f57345e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ PostCartUseCase f57346f;

    public /* synthetic */ q1(List list, float f11, float f12, boolean z11, PostCartUseCase postCartUseCase) {
        this.f57342b = list;
        this.f57343c = f11;
        this.f57344d = f12;
        this.f57345e = z11;
        this.f57346f = postCartUseCase;
    }

    public final Object apply(Object obj) {
        return PostCartUseCase.m9834invoke$lambda1(this.f57342b, this.f57343c, this.f57344d, this.f57345e, this.f57346f, (Boolean) obj);
    }
}
