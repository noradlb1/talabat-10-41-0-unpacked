package pt;

import com.talabat.restaurants.v2.domain.vendors.GetInlineAdsUseCase;
import io.reactivex.functions.Function;
import java.util.List;

public final /* synthetic */ class b implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ List f62812b;

    public /* synthetic */ b(List list) {
        this.f62812b = list;
    }

    public final Object apply(Object obj) {
        return GetInlineAdsUseCase.m10745invoke$lambda8$lambda5(this.f62812b, (List) obj);
    }
}
