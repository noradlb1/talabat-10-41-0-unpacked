package kj;

import com.talabat.darkstores.feature.product.usecase.ProductSwimlanesUseCase;
import com.talabat.feature.darkstoresvendor.domain.model.Vendor;
import io.reactivex.functions.Function;

public final /* synthetic */ class e implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ boolean f56978b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f56979c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f56980d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ ProductSwimlanesUseCase f56981e;

    public /* synthetic */ e(boolean z11, String str, String str2, ProductSwimlanesUseCase productSwimlanesUseCase) {
        this.f56978b = z11;
        this.f56979c = str;
        this.f56980d = str2;
        this.f56981e = productSwimlanesUseCase;
    }

    public final Object apply(Object obj) {
        return ProductSwimlanesUseCase.m10048getSwimlanes$lambda7(this.f56978b, this.f56979c, this.f56980d, this.f56981e, (Vendor) obj);
    }
}
