package fx;

import JsonModels.Response.AccountInfoRM;
import com.android.volley.Response;
import com.talabat.userandlocation.customerinfo.CustomerInfoUpdateDelegateImpl;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

public final /* synthetic */ class a implements Response.Listener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CustomerInfoUpdateDelegateImpl f14060b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Function0 f14061c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Function2 f14062d;

    public /* synthetic */ a(CustomerInfoUpdateDelegateImpl customerInfoUpdateDelegateImpl, Function0 function0, Function2 function2) {
        this.f14060b = customerInfoUpdateDelegateImpl;
        this.f14061c = function0;
        this.f14062d = function2;
    }

    public final void onResponse(Object obj) {
        CustomerInfoUpdateDelegateImpl.m5918callApi$lambda0(this.f14060b, this.f14061c, this.f14062d, (AccountInfoRM) obj);
    }
}
