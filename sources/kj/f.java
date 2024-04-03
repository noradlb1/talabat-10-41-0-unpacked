package kj;

import com.talabat.darkstores.feature.product.usecase.ProductSwimlanesUseCase;
import com.talabat.feature.darkstores.swimlanes.domain.model.SwimlanesData;
import io.reactivex.functions.Function3;
import java.util.Map;

public final /* synthetic */ class f implements Function3 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ProductSwimlanesUseCase f56982a;

    public /* synthetic */ f(ProductSwimlanesUseCase productSwimlanesUseCase) {
        this.f56982a = productSwimlanesUseCase;
    }

    public final Object apply(Object obj, Object obj2, Object obj3) {
        return ProductSwimlanesUseCase.m10049getSwimlanes$lambda7$lambda6(this.f56982a, (SwimlanesData) obj, (Map) obj2, (Map) obj3);
    }
}
