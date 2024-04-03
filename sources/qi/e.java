package qi;

import com.talabat.darkstores.domain.common.ApplyDiscountsAndCampaignsUseCaseImpl;
import com.talabat.darkstores.domain.model.ProductsHolder;
import io.reactivex.functions.BiFunction;
import java.util.Map;

public final /* synthetic */ class e implements BiFunction {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ProductsHolder f57199b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ApplyDiscountsAndCampaignsUseCaseImpl f57200c;

    public /* synthetic */ e(ProductsHolder productsHolder, ApplyDiscountsAndCampaignsUseCaseImpl applyDiscountsAndCampaignsUseCaseImpl) {
        this.f57199b = productsHolder;
        this.f57200c = applyDiscountsAndCampaignsUseCaseImpl;
    }

    public final Object apply(Object obj, Object obj2) {
        return ApplyDiscountsAndCampaignsUseCaseImpl.m9748invoke$lambda6(this.f57199b, this.f57200c, (Map) obj, (Map) obj2);
    }
}
