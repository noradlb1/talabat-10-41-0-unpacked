package library.talabat.mvp.orderlistscreen;

import JsonModels.DeliverableAddressRM;
import JsonModels.OrderDetailsRM;
import JsonModels.OrderListPagingResponse;
import JsonModels.ReorderAreasResponse;
import JsonModels.ReorderWithBranchIdRequestModel;
import JsonModels.Request.DeliverAddressRequest;
import JsonModels.Request.InforMapRequest;
import JsonModels.Request.McdBranchRequest;
import JsonModels.Request.ReorderRequestWithLocation.ReorderWithLocationRequestModel;
import JsonModels.Response.GroceryBuyAgainResponse;
import JsonModels.Response.InforMapAddressRM;
import JsonModels.Response.McdStoresRM;
import JsonModels.Response.OrderListPagingRM;
import JsonModels.Response.ReorderRM;
import JsonModels.Response.RestaurantDetailsWithDelAreasRM;
import JsonModels.parser.UniversalGson;
import buisnessmodels.Customer;
import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.VolleyError;
import com.google.gson.Gson;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.talabat.configuration.country.Country;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.domain.address.Address;
import com.talabat.helpers.AppUrls;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.helpers.GsonRequest;
import com.talabat.helpers.TalabatUtils;
import com.talabat.helpers.TalabatVolley;
import com.talabat.userandlocation.tracking.InforMapTracker;
import datamodels.OrderInfoPaging;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import library.talabat.com.talabatlib.CreateApiUrl;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;
import service.ApiHandler;
import tracking.ScreenNames;
import v10.a;
import v10.b;

@Instrumented
public class OrderListScreenInteractor implements IOrderListScreenInteractor {
    private final AppVersionProvider appVersionProvider;
    /* access modifiers changed from: private */
    public int mcdBlockSelectedAreaId;
    /* access modifiers changed from: private */
    public OrderListScreenListener orderListScreenListener;

    public OrderListScreenInteractor(AppVersionProvider appVersionProvider2, OrderListScreenListener orderListScreenListener2) {
        this.appVersionProvider = appVersionProvider2;
        this.orderListScreenListener = orderListScreenListener2;
    }

    @Nullable
    private String getCurrentCountryCode() {
        return Country.Companion.from(GlobalDataModel.SelectedCountryId).getTwoLetterCode();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onGetBranchIdForReorderCartRequestError$1(InforMapRequest inforMapRequest, VolleyError volleyError) {
        InforMapTracker.trackInformapStoreApiError(ScreenNames.ORDERS_LIST, inforMapRequest, volleyError);
        onRequestError().onErrorResponse(volleyError);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onGroceryBuyAgainSwimlaneInfoReceived$0(GroceryBuyAgainResponse groceryBuyAgainResponse) {
        GroceryBuyAgainResponse.GroceryBuyAgainResult groceryBuyAgainResult;
        OrderListScreenListener orderListScreenListener2 = this.orderListScreenListener;
        if (orderListScreenListener2 != null && groceryBuyAgainResponse != null && (groceryBuyAgainResult = groceryBuyAgainResponse.result) != null) {
            orderListScreenListener2.onGroceryOrderAgainInfoReceived(groceryBuyAgainResult.vendorId, groceryBuyAgainResult.swimlaneId, groceryBuyAgainResult.headline);
        }
    }

    private Response.Listener<ReorderRM> onCartRecieved() {
        return new Response.Listener<ReorderRM>() {
            public void onResponse(ReorderRM reorderRM) {
                if (OrderListScreenInteractor.this.orderListScreenListener != null) {
                    GlobalDataModel.JSON.tgoFreeDeliveryResponse = reorderRM.result.tgoFreeDeliveryResponse;
                    OrderListScreenInteractor.this.orderListScreenListener.onReorderItemRecieved(reorderRM.result);
                }
            }
        };
    }

    private Response.Listener<GroceryBuyAgainResponse> onGroceryBuyAgainSwimlaneInfoReceived() {
        return new b(this);
    }

    private Response.Listener<InforMapAddressRM> onInforReOrderBrachIdReceived() {
        return new Response.Listener<InforMapAddressRM>() {
            public void onResponse(InforMapAddressRM inforMapAddressRM) {
                if (inforMapAddressRM != null) {
                    if (OrderListScreenInteractor.this.orderListScreenListener != null) {
                        OrderListScreenInteractor.this.orderListScreenListener.grlBranchIdReceived(inforMapAddressRM.result);
                    }
                } else if (OrderListScreenInteractor.this.orderListScreenListener != null) {
                    OrderListScreenInteractor.this.orderListScreenListener.grlBranchIdfailed();
                }
            }
        };
    }

    private Response.Listener<McdStoresRM> onMcdBranchReceived() {
        return new Response.Listener<McdStoresRM>() {
            public void onResponse(McdStoresRM mcdStoresRM) {
                if (mcdStoresRM == null) {
                    OrderListScreenInteractor.this.orderListScreenListener.mcdBhBranchFailed();
                } else if (mcdStoresRM.result != null) {
                    OrderListScreenInteractor.this.orderListScreenListener.mcdBranchReceived(OrderListScreenInteractor.this.mcdBlockSelectedAreaId, mcdStoresRM.result);
                } else {
                    OrderListScreenInteractor.this.orderListScreenListener.mcdBhBranchFailed();
                }
            }
        };
    }

    private Response.Listener<OrderDetailsRM> onOrderDetailsResultRecieved() {
        return new Response.Listener<OrderDetailsRM>() {
            public void onResponse(OrderDetailsRM orderDetailsRM) {
                if (OrderListScreenInteractor.this.orderListScreenListener == null) {
                    return;
                }
                if (orderDetailsRM.result != null) {
                    OrderListScreenInteractor.this.orderListScreenListener.onOrderDetailsRecieved(orderDetailsRM.result);
                } else {
                    OrderListScreenInteractor.this.onRequestError();
                }
            }
        };
    }

    private Response.Listener<OrderListPagingRM> onOrderListRecieved() {
        return new Response.Listener<OrderListPagingRM>() {
            public void onResponse(OrderListPagingRM orderListPagingRM) {
                OrderListPagingResponse orderListPagingResponse;
                OrderInfoPaging[] orderInfoPagingArr;
                if (OrderListScreenInteractor.this.orderListScreenListener == null) {
                    return;
                }
                if (orderListPagingRM == null || (orderListPagingResponse = orderListPagingRM.result) == null || (orderInfoPagingArr = orderListPagingResponse.orders) == null) {
                    OrderListScreenInteractor.this.orderListScreenListener.noOrdersFound();
                } else if (orderInfoPagingArr.length <= 0) {
                    OrderListScreenInteractor.this.orderListScreenListener.noOrdersFound();
                } else {
                    OrderListScreenInteractor.this.orderListScreenListener.onOrdersListRecieved(orderListPagingRM);
                }
            }
        };
    }

    private Response.Listener<ReorderAreasResponse> onReorderAreasRecieved() {
        return new Response.Listener<ReorderAreasResponse>() {
            public void onResponse(ReorderAreasResponse reorderAreasResponse) {
                if (OrderListScreenInteractor.this.orderListScreenListener != null) {
                    OrderListScreenInteractor.this.orderListScreenListener.onReorderAreasRecieved(reorderAreasResponse.result);
                }
            }
        };
    }

    private Response.Listener<RestaurantDetailsWithDelAreasRM> onRestaurantInfoRecieved() {
        return new Response.Listener<RestaurantDetailsWithDelAreasRM>() {
            public void onResponse(RestaurantDetailsWithDelAreasRM restaurantDetailsWithDelAreasRM) {
                OrderListScreenListener unused = OrderListScreenInteractor.this.orderListScreenListener;
            }
        };
    }

    public void getAddressBasedDeliveryArea(DeliverAddressRequest deliverAddressRequest) {
        ApiHandler.callApi().getResDeliverableAddress(AppUrls.GET_ADDRESS_BASED_DELIVERY_AREA, deliverAddressRequest).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new DisposableObserver<DeliverableAddressRM>() {
            public void onComplete() {
            }

            public void onError(Throwable th2) {
                OrderListScreenInteractor.this.orderListScreenListener.onResponseError();
            }

            public void onNext(DeliverableAddressRM deliverableAddressRM) {
                if (deliverableAddressRM != null && deliverableAddressRM.result != null && OrderListScreenInteractor.this.orderListScreenListener != null) {
                    Address[] addressArr = deliverableAddressRM.result.addresses;
                    if (addressArr != null && addressArr.length > 0) {
                        Customer.getInstance().setCustomerDeliverableAddressBasedRes(deliverableAddressRM.result.addresses);
                        if (OrderListScreenInteractor.this.orderListScreenListener != null) {
                            OrderListScreenInteractor.this.orderListScreenListener.onResBasedDeliverAddressLoaded(deliverableAddressRM.result.addresses);
                        }
                    }
                    OrderListScreenInteractor.this.orderListScreenListener.onResCompleted();
                }
            }
        });
    }

    public void getBranchIdForReorderCart(InforMapRequest inforMapRequest) {
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject(inforMapRequest.getJson());
        } catch (JSONException unused) {
            jSONObject = null;
        }
        TalabatVolley.addToRequestQueue(new GsonRequest.Builder().setMethod(1).setUrl(AppUrls.INFORMAP_ADDRESS_CONVERT_BRANCH_ID).setClazz(InforMapAddressRM.class).setRequestBody(jSONObject).setListener(onInforReOrderBrachIdReceived()).setErrorListener(onGetBranchIdForReorderCartRequestError(inforMapRequest)).setAppVersion(this.appVersionProvider.appVersion()).build());
    }

    public void getBranchIdGrl(McdBranchRequest mcdBranchRequest) {
        String str;
        String str2;
        this.mcdBlockSelectedAreaId = mcdBranchRequest.address.areaId;
        if (TalabatUtils.isMcdBlockMenuEnabledCountry()) {
            str = AppUrls.MCD_BAHRAIN_GET_BRANCH_ID;
        } else {
            if (TalabatUtils.isMcdLatLngEnabledCountry()) {
                if (GlobalDataModel.SelectedCountryId == Country.KSA.getCountryId()) {
                    str = AppUrls.MCD_KSA_GET_BRANCH_ID;
                } else if (GlobalDataModel.SelectedCountryId == Country.JORDAN.getCountryId()) {
                    str = AppUrls.MCD_JORDAN_GET_BRANCH_ID;
                }
            }
            str = "";
        }
        try {
            Gson gson = UniversalGson.INSTANCE.gson;
            if (!(gson instanceof Gson)) {
                str2 = gson.toJson((Object) mcdBranchRequest);
            } else {
                str2 = GsonInstrumentation.toJson(gson, (Object) mcdBranchRequest);
            }
            JSONObject jSONObject = new JSONObject(str2);
            GsonRequest.Builder method = new GsonRequest.Builder().setMethod(1);
            TalabatVolley.addToRequestQueue(method.setUrl(CreateApiUrl.createWithParameters(str, new String[]{"{countryId}", "" + GlobalDataModel.SelectedCountryId})).setClazz(McdStoresRM.class).setRequestBody(jSONObject).setListener(onMcdBranchReceived()).setErrorListener(onRequestError()).setAppVersion(this.appVersionProvider.appVersion()).build());
        } catch (JSONException unused) {
        }
    }

    public void getGrlReorderCart(String str, int i11, int i12) {
        String str2;
        JSONObject jSONObject;
        Gson gson = UniversalGson.INSTANCE.gson;
        ReorderWithBranchIdRequestModel reorderWithBranchIdRequestModel = new ReorderWithBranchIdRequestModel("" + i12, "" + i11, "" + GlobalDataModel.SelectedCountryId);
        if (!(gson instanceof Gson)) {
            str2 = gson.toJson((Object) reorderWithBranchIdRequestModel);
        } else {
            str2 = GsonInstrumentation.toJson(gson, (Object) reorderWithBranchIdRequestModel);
        }
        try {
            jSONObject = new JSONObject(str2);
        } catch (JSONException unused) {
            jSONObject = null;
        }
        TalabatVolley.addToRequestQueue(new GsonRequest.Builder().setMethod(1).setUrl(CreateApiUrl.createWithParameters(AppUrls.REORDER_ITEMS_WITH_LOCATION, new String[]{"{orderid}", str})).setClazz(ReorderRM.class).setRequestBody(jSONObject).setListener(onCartRecieved()).setErrorListener(onRequestError()).setAppVersion(this.appVersionProvider.appVersion()).build());
    }

    public void getGroceryBuyAgainSwimlaneInfo(boolean z11, int i11) {
        String currentCountryCode = getCurrentCountryCode();
        GsonRequest.Builder method = new GsonRequest.Builder().setMethod(0);
        String str = AppUrls.GET_QC_PREVIOUS_ORDER_SWIMLANE;
        TalabatVolley.addToRequestQueue(method.setUrl(CreateApiUrl.createWithParameters(str, new String[]{"{countryCode}", "" + currentCountryCode, "{talabatBranchId}", "" + i11, "{isDarkstore}", "" + z11})).setClazz(GroceryBuyAgainResponse.class).setListener(onGroceryBuyAgainSwimlaneInfoReceived()).setErrorListener(onRequestError()).setAppVersion(this.appVersionProvider.appVersion()).build());
    }

    public void getOrderDetails(String str) {
        TalabatVolley.addToRequestQueue(new GsonRequest.Builder().setUrl(CreateApiUrl.createWithParameters(AppUrls.ORDERDETAILSTALABAT, new String[]{"{transactionId}", str})).setClazz(OrderDetailsRM.class).setListener(onOrderDetailsResultRecieved()).setErrorListener(onRequestError()).setAppVersion(this.appVersionProvider.appVersion()).build());
    }

    public void getOrderList(int i11) {
        GsonRequest.Builder builder = new GsonRequest.Builder();
        String str = AppUrls.ORDERLIST_COUNTRYID_PAGE;
        TalabatVolley.addToRequestQueue(builder.setUrl(CreateApiUrl.createWithParameters(str, new String[]{"{countryid}", "" + GlobalDataModel.SelectedCountryId, "{pageNumber}", "" + i11})).setClazz(OrderListPagingRM.class).setListener(onOrderListRecieved()).setErrorListener(onRequestError()).setAppVersion(this.appVersionProvider.appVersion()).build());
    }

    public void getReorderAreas(String str) {
        TalabatVolley.addToRequestQueue(new GsonRequest.Builder().setUrl(CreateApiUrl.createWithParameters(AppUrls.REORDERARES, new String[]{"{orderid}", str})).setClazz(ReorderAreasResponse.class).setListener(onReorderAreasRecieved()).setErrorListener(onRequestError()).setAppVersion(this.appVersionProvider.appVersion()).build());
    }

    public void getReorderCart(String str, int i11) {
        String str2;
        String str3;
        JSONObject jSONObject;
        Gson gson = UniversalGson.INSTANCE.gson;
        if (Customer.getInstance().getSelectedCustomerAddress() != null) {
            str2 = Customer.getInstance().getSelectedCustomerAddress().f58343id;
        } else {
            str2 = "";
        }
        ReorderWithLocationRequestModel reorderWithLocationRequestModel = new ReorderWithLocationRequestModel(str2, "" + GlobalDataModel.SelectedAreaId, GlobalDataModel.LATLONGFORAPI.getLatitude(), GlobalDataModel.LATLONGFORAPI.getLongitude(), GlobalDataModel.SelectedCountryId + "");
        if (!(gson instanceof Gson)) {
            str3 = gson.toJson((Object) reorderWithLocationRequestModel);
        } else {
            str3 = GsonInstrumentation.toJson(gson, (Object) reorderWithLocationRequestModel);
        }
        try {
            jSONObject = new JSONObject(str3);
        } catch (JSONException unused) {
            jSONObject = null;
        }
        TalabatVolley.addToRequestQueue(new GsonRequest.Builder().setMethod(1).setUrl(CreateApiUrl.createWithParameters(AppUrls.REORDER_ITEMS_WITH_LOCATION, new String[]{"{orderid}", str})).setClazz(ReorderRM.class).setRequestBody(jSONObject).setListener(onCartRecieved()).setErrorListener(onRequestError()).setAppVersion(this.appVersionProvider.appVersion()).build());
    }

    public Response.ErrorListener onGetBranchIdForReorderCartRequestError(InforMapRequest inforMapRequest) {
        return new a(this, inforMapRequest);
    }

    public Response.ErrorListener onRequestError() {
        return new Response.ErrorListener() {
            public void onErrorResponse(VolleyError volleyError) {
                if ((volleyError instanceof ServerError) && OrderListScreenInteractor.this.orderListScreenListener != null) {
                    OrderListScreenInteractor.this.orderListScreenListener.onServerError(volleyError);
                } else if ((volleyError instanceof NetworkError) && OrderListScreenInteractor.this.orderListScreenListener != null) {
                    OrderListScreenInteractor.this.orderListScreenListener.onNetworkError();
                } else if ((volleyError instanceof AuthFailureError) && OrderListScreenInteractor.this.orderListScreenListener != null) {
                    OrderListScreenInteractor.this.orderListScreenListener.onDataError();
                }
            }
        };
    }

    public void unregister() {
        this.orderListScreenListener = null;
    }
}
