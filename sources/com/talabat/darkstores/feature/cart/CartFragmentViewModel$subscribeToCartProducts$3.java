package com.talabat.darkstores.feature.cart;

import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012&\u0010\u0002\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005 \u0006*\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "it", "", "", "", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class CartFragmentViewModel$subscribeToCartProducts$3 extends Lambda implements Function1<Map<String, ? extends Integer>, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ CartFragmentViewModel f56274g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CartFragmentViewModel$subscribeToCartProducts$3(CartFragmentViewModel cartFragmentViewModel) {
        super(1);
        this.f56274g = cartFragmentViewModel;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Map<String, Integer>) (Map) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Map<String, Integer> map) {
        this.f56274g._cartMapLiveData.postValue(map);
    }
}
