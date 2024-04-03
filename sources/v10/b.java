package v10;

import JsonModels.Response.GroceryBuyAgainResponse;
import com.android.volley.Response;
import library.talabat.mvp.orderlistscreen.OrderListScreenInteractor;

public final /* synthetic */ class b implements Response.Listener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ OrderListScreenInteractor f28214b;

    public /* synthetic */ b(OrderListScreenInteractor orderListScreenInteractor) {
        this.f28214b = orderListScreenInteractor;
    }

    public final void onResponse(Object obj) {
        this.f28214b.lambda$onGroceryBuyAgainSwimlaneInfoReceived$0((GroceryBuyAgainResponse) obj);
    }
}
