package pt;

import com.talabat.restaurants.v2.data.vendors.AreaParams;
import com.talabat.restaurants.v2.domain.vendors.GetInlineAdsUseCase;
import io.reactivex.functions.Function;
import java.util.List;

public final /* synthetic */ class e implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ GetInlineAdsUseCase f62813b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ AreaParams f62814c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ double f62815d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ String f62816e;

    public /* synthetic */ e(GetInlineAdsUseCase getInlineAdsUseCase, AreaParams areaParams, double d11, String str) {
        this.f62813b = getInlineAdsUseCase;
        this.f62814c = areaParams;
        this.f62815d = d11;
        this.f62816e = str;
    }

    public final Object apply(Object obj) {
        return GetInlineAdsUseCase.m10744invoke$lambda8(this.f62813b, this.f62814c, this.f62815d, this.f62816e, (List) obj);
    }
}
