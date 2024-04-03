package m10;

import JsonModels.Request.InforMapRequest;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import library.talabat.mvp.informap.InforMapInetractor;

public final /* synthetic */ class a implements Response.ErrorListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ InforMapInetractor f26875b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ InforMapRequest f26876c;

    public /* synthetic */ a(InforMapInetractor inforMapInetractor, InforMapRequest inforMapRequest) {
        this.f26875b = inforMapInetractor;
        this.f26876c = inforMapRequest;
    }

    public final void onErrorResponse(VolleyError volleyError) {
        this.f26875b.lambda$onRequestError$0(this.f26876c, volleyError);
    }
}
