package ue;

import com.talabat.CheckOutScreen;
import com.talabat.feature.subscriptions.domain.model.TProOrderStatus;
import java.util.Map;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class i2 implements Function1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CheckOutScreen f57571b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Map f57572c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Boolean f57573d;

    public /* synthetic */ i2(CheckOutScreen checkOutScreen, Map map, Boolean bool) {
        this.f57571b = checkOutScreen;
        this.f57572c = map;
        this.f57573d = bool;
    }

    public final Object invoke(Object obj) {
        return this.f57571b.lambda$setVisibilityOfSubscriptionOnCheckoutBanner$37(this.f57572c, this.f57573d, (TProOrderStatus) obj);
    }
}
