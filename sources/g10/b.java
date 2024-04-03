package g10;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import library.talabat.mvp.grocerydetails.GroceryDetailsInteractor;

public final /* synthetic */ class b implements Response.ErrorListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ GroceryDetailsInteractor f24325b;

    public /* synthetic */ b(GroceryDetailsInteractor groceryDetailsInteractor) {
        this.f24325b = groceryDetailsInteractor;
    }

    public final void onErrorResponse(VolleyError volleyError) {
        GroceryDetailsInteractor.m7879onRequestError$lambda0(this.f24325b, volleyError);
    }
}
