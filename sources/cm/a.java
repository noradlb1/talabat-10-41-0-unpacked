package cm;

import com.talabat.feature.darkstorescarrierbag.domain.usecase.SendDarkstoresCarrierBagEventImpl;
import java.util.concurrent.Callable;

public final /* synthetic */ class a implements Callable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SendDarkstoresCarrierBagEventImpl f58212b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f58213c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f58214d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ String f58215e;

    public /* synthetic */ a(SendDarkstoresCarrierBagEventImpl sendDarkstoresCarrierBagEventImpl, String str, String str2, String str3) {
        this.f58212b = sendDarkstoresCarrierBagEventImpl;
        this.f58213c = str;
        this.f58214d = str2;
        this.f58215e = str3;
    }

    public final Object call() {
        return SendDarkstoresCarrierBagEventImpl.m10155invoke$lambda0(this.f58212b, this.f58213c, this.f58214d, this.f58215e);
    }
}
