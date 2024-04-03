package g10;

import JsonModels.Response.SplitRestaurantApiResponse.SplitChoiceRM;
import com.android.volley.Response;
import library.talabat.mvp.grocerydetails.GroceryDetailsInteractor;

public final /* synthetic */ class a implements Response.Listener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ GroceryDetailsInteractor f24324b;

    public /* synthetic */ a(GroceryDetailsInteractor groceryDetailsInteractor) {
        this.f24324b = groceryDetailsInteractor;
    }

    public final void onResponse(Object obj) {
        GroceryDetailsInteractor.m7878onChoiceReceived$lambda2(this.f24324b, (SplitChoiceRM) obj);
    }
}
