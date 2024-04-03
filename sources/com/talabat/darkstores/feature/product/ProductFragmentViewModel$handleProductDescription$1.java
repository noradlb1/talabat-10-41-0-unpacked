package com.talabat.darkstores.feature.product;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class ProductFragmentViewModel$handleProductDescription$1 extends Lambda implements Function1<Boolean, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ ProductFragmentViewModel f56500g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ String f56501h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ProductFragmentViewModel$handleProductDescription$1(ProductFragmentViewModel productFragmentViewModel, String str) {
        super(1);
        this.f56500g = productFragmentViewModel;
        this.f56501h = str;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Boolean) obj).booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean z11) {
        this.f56500g.getProductDescriptionExpandState().postValue(new Pair(Boolean.valueOf(z11), this.f56501h));
    }
}
