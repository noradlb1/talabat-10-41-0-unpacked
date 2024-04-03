package fx;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.talabat.userandlocation.customerinfo.CustomerInfoUpdateDelegateImpl;
import kotlin.jvm.functions.Function2;

public final /* synthetic */ class b implements Response.ErrorListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Function2 f14063b;

    public /* synthetic */ b(Function2 function2) {
        this.f14063b = function2;
    }

    public final void onErrorResponse(VolleyError volleyError) {
        CustomerInfoUpdateDelegateImpl.m5919callApi$lambda1(this.f14063b, volleyError);
    }
}
