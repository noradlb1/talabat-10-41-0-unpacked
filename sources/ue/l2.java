package ue;

import com.talabat.CheckOutScreen;
import com.talabat.feature.subscriptions.domain.model.TProOrderStatus;
import java.util.Map;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class l2 implements Function1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CheckOutScreen f57625b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Map f57626c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Boolean f57627d;

    public /* synthetic */ l2(CheckOutScreen checkOutScreen, Map map, Boolean bool) {
        this.f57625b = checkOutScreen;
        this.f57626c = map;
        this.f57627d = bool;
    }

    public final Object invoke(Object obj) {
        return this.f57625b.lambda$hideTProSubscriptionBanner$42(this.f57626c, this.f57627d, (TProOrderStatus) obj);
    }
}
