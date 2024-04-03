package gl;

import com.talabat.feature.activecarts.domain.usecase.GetCartListUseCaseImpl;
import io.reactivex.functions.Function;
import java.util.List;

public final /* synthetic */ class f implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ GetCartListUseCaseImpl f62089b;

    public /* synthetic */ f(GetCartListUseCaseImpl getCartListUseCaseImpl) {
        this.f62089b = getCartListUseCaseImpl;
    }

    public final Object apply(Object obj) {
        return GetCartListUseCaseImpl.m10130invoke$lambda4(this.f62089b, (List) obj);
    }
}
