package kj;

import com.talabat.darkstores.feature.product.usecase.ProductSwimlanesUseCase;
import io.reactivex.functions.Function;
import kotlin.Unit;

public final /* synthetic */ class c implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ProductSwimlanesUseCase f56977b;

    public /* synthetic */ c(ProductSwimlanesUseCase productSwimlanesUseCase) {
        this.f56977b = productSwimlanesUseCase;
    }

    public final Object apply(Object obj) {
        return ProductSwimlanesUseCase.m10045campaignTriggersByProduct$lambda3(this.f56977b, (Unit) obj);
    }
}
