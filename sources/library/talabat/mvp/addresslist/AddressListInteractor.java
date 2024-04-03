package library.talabat.mvp.addresslist;

import JsonModels.AddAddressResult;
import JsonModels.DeliverableAddressRM;
import JsonModels.Request.DeliverAddressRequest;
import JsonModels.Request.McdBlockMapGrlUpdateRequest;
import JsonModels.Request.McdBranchRequest;
import JsonModels.Response.AddressDeleteRM;
import JsonModels.Response.McdBlockAddressGrlUpdateRM;
import JsonModels.Response.McdStoresRM;
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
import com.talabat.helpers.TalabatVolley;
import com.talabat.observability.ObservabilityManager;
import com.talabat.talabatcore.logger.LogManager;
import com.talabat.user.address.domain.repository.CustomerAddressesRepository;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import java.util.HashMap;
import library.talabat.com.talabatlib.CreateApiUrl;
import org.json.JSONException;
import org.json.JSONObject;
import service.ApiHandler;
import y00.a;
import y00.b;

@Instrumented
public class AddressListInteractor implements IAddressListInteractor {
    /* access modifiers changed from: private */
    public AddressListListener addressListListener;
    private final AppVersionProvider appVersionProvider;
    private final CustomerAddressesRepository customerAddressesRepository;
    private final CompositeDisposable disposables = new CompositeDisposable();
    private final Scheduler ioScheduler;
    private final Scheduler mainScheduler;
    /* access modifiers changed from: private */
    public String selectedId;

    public AddressListInteractor(AppVersionProvider appVersionProvider2, CustomerAddressesRepository customerAddressesRepository2, Scheduler scheduler, Scheduler scheduler2) {
        this.appVersionProvider = appVersionProvider2;
        this.customerAddressesRepository = customerAddressesRepository2;
        this.ioScheduler = scheduler;
        this.mainScheduler = scheduler2;
    }

    /* access modifiers changed from: private */
    public void observe(Throwable th2) {
        HashMap hashMap = new HashMap();
        String message = th2.getMessage();
        if (message == null) {
            message = "";
        }
        hashMap.put("errorMessage", message);
        ObservabilityManager.trackUnExpectedScenario("AddressListInteractorErrors", hashMap);
    }

    private Response.Listener<AddressDeleteRM> onAddressDelete() {
        return new Response.Listener<AddressDeleteRM>() {
            public void onResponse(AddressDeleteRM addressDeleteRM) {
                if (addressDeleteRM.result.statusCode == 0) {
                    if (AddressListInteractor.this.addressListListener != null) {
                        AddressListInteractor.this.addressListListener.onAddressDeleted(AddressListInteractor.this.selectedId);
                    }
                } else if (AddressListInteractor.this.addressListListener != null) {
                    AddressListListener b11 = AddressListInteractor.this.addressListListener;
                    AddAddressResult addAddressResult = addressDeleteRM.result;
                    b11.onAddressDeleteFailed(addAddressResult.statusCode, addAddressResult.msg);
                }
            }
        };
    }

    private Response.Listener<McdBlockAddressGrlUpdateRM> onGrlUpdatedinAddress() {
        return new Response.Listener<McdBlockAddressGrlUpdateRM>() {
            public void onResponse(McdBlockAddressGrlUpdateRM mcdBlockAddressGrlUpdateRM) {
            }
        };
    }

    private Response.Listener<McdStoresRM> onMcdStoresReceived() {
        return new Response.Listener<McdStoresRM>() {
            public void onResponse(McdStoresRM mcdStoresRM) {
                if (AddressListInteractor.this.addressListListener == null) {
                    return;
                }
                if (mcdStoresRM == null) {
                    AddressListInteractor.this.addressListListener.mcdBranchFailed();
                } else if (mcdStoresRM.result != null) {
                    AddressListInteractor.this.addressListListener.mcdBranchReceived(mcdStoresRM.result);
                } else {
                    AddressListInteractor.this.addressListListener.mcdBranchFailed();
                }
            }
        };
    }

    public void d(CustomerAddressesRepository.Result result) {
        if (result instanceof CustomerAddressesRepository.Result.Success) {
            LogManager.info("Update GRL success");
        } else if (result instanceof CustomerAddressesRepository.Result.Failed) {
            CustomerAddressesRepository.Result.Failed failed = (CustomerAddressesRepository.Result.Failed) result;
            LogManager.error((Throwable) null, "Update GRL failed - resultCode: " + failed.getResultCode() + " reason: " + failed.getMessage());
        }
    }

    public void deleteAddress(String str) {
        this.selectedId = str;
        GsonRequest.Builder method = new GsonRequest.Builder().setMethod(1);
        String str2 = AppUrls.DELETE_ADDRESS;
        TalabatVolley.addToRequestQueue(method.setUrl(CreateApiUrl.createWithParameters(str2, new String[]{"{cityId}", "" + GlobalDataModel.SelectedCityId, "{AddressId}", "" + str})).setClazz(AddressDeleteRM.class).setListener(onAddressDelete()).setErrorListener(onRequestError()).setAppVersion(this.appVersionProvider.appVersion()).build());
    }

    public void getAddressBasedDeliveryArea(DeliverAddressRequest deliverAddressRequest) {
        ApiHandler.callApi().getResDeliverableAddress(AppUrls.GET_ADDRESS_BASED_DELIVERY_AREA, deliverAddressRequest).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new DisposableObserver<DeliverableAddressRM>() {
            public void onComplete() {
            }

            public void onError(Throwable th2) {
                if (AddressListInteractor.this.addressListListener != null) {
                    AddressListInteractor.this.addressListListener.onResponseError();
                }
            }

            public void onNext(DeliverableAddressRM deliverableAddressRM) {
                Address[] addressArr;
                if (deliverableAddressRM != null && deliverableAddressRM.result != null && AddressListInteractor.this.addressListListener != null && (addressArr = deliverableAddressRM.result.addresses) != null && addressArr.length > 0) {
                    Customer.getInstance().setCustomerDeliverableAddressBasedRes(deliverableAddressRM.result.addresses);
                    AddressListInteractor.this.addressListListener.loadResBasedDeliverableAddress(deliverableAddressRM.result.addresses);
                }
            }
        });
    }

    public void getMcdLatLngStoresCheck(McdBranchRequest mcdBranchRequest) {
        String str;
        String str2;
        try {
            if (GlobalDataModel.SelectedCountryId == Country.KSA.getCountryId()) {
                str = AppUrls.MCD_KSA_GET_BRANCH_ID;
            } else if (GlobalDataModel.SelectedCountryId == Country.JORDAN.getCountryId()) {
                str = AppUrls.MCD_JORDAN_GET_BRANCH_ID;
            } else {
                str = "";
            }
            Gson gson = UniversalGson.INSTANCE.gson;
            if (!(gson instanceof Gson)) {
                str2 = gson.toJson((Object) mcdBranchRequest);
            } else {
                str2 = GsonInstrumentation.toJson(gson, (Object) mcdBranchRequest);
            }
            JSONObject jSONObject = new JSONObject(str2);
            GsonRequest.Builder method = new GsonRequest.Builder().setMethod(1);
            TalabatVolley.addToRequestQueue(method.setUrl(CreateApiUrl.createWithParameters(str, new String[]{"{countryId}", "" + GlobalDataModel.SelectedCountryId})).setClazz(McdStoresRM.class).setRequestBody(jSONObject).setListener(onMcdStoresReceived()).setErrorListener(onMcdStoreCheckRequestError()).setAppVersion(this.appVersionProvider.appVersion()).build());
        } catch (JSONException unused) {
        }
    }

    public Response.ErrorListener onMcdStoreCheckRequestError() {
        return new Response.ErrorListener() {
            public void onErrorResponse(VolleyError volleyError) {
                if (((volleyError instanceof ServerError) || (volleyError instanceof NetworkError) || (volleyError instanceof AuthFailureError)) && AddressListInteractor.this.addressListListener != null) {
                    AddressListInteractor.this.addressListListener.mcdBranchFailed();
                }
            }
        };
    }

    public Response.ErrorListener onRequestError() {
        return new Response.ErrorListener() {
            public void onErrorResponse(VolleyError volleyError) {
                if ((volleyError instanceof ServerError) && AddressListInteractor.this.addressListListener != null) {
                    AddressListInteractor.this.addressListListener.onServerError(volleyError);
                } else if ((volleyError instanceof NetworkError) && AddressListInteractor.this.addressListListener != null) {
                    AddressListInteractor.this.addressListListener.onNetworkError();
                } else if ((volleyError instanceof AuthFailureError) && AddressListInteractor.this.addressListListener != null) {
                    AddressListInteractor.this.addressListListener.onDataError();
                }
            }
        };
    }

    public void setAddressListListener(AddressListListener addressListListener2) {
        this.addressListListener = addressListListener2;
    }

    public void unregister() {
        this.addressListListener = null;
        this.disposables.dispose();
    }

    public void updateAddress(Address address) {
        this.disposables.add(this.customerAddressesRepository.updateAddress(address).doOnError(new a(this)).subscribeOn(this.ioScheduler).observeOn(this.mainScheduler).subscribe(new b(this), new xq.a()));
    }

    public void updateSelectedAddressGrl(McdBlockMapGrlUpdateRequest mcdBlockMapGrlUpdateRequest) {
        String str;
        try {
            Gson gson = UniversalGson.INSTANCE.gson;
            if (!(gson instanceof Gson)) {
                str = gson.toJson((Object) mcdBlockMapGrlUpdateRequest);
            } else {
                str = GsonInstrumentation.toJson(gson, (Object) mcdBlockMapGrlUpdateRequest);
            }
            TalabatVolley.addToRequestQueue(new GsonRequest.Builder().setMethod(1).setUrl(AppUrls.MCD_BAHRAIN_ADDRESS_GRL_UPDATE).setClazz(McdBlockAddressGrlUpdateRM.class).setRequestBody(new JSONObject(str)).setListener(onGrlUpdatedinAddress()).setErrorListener(onRequestError()).setAppVersion(this.appVersionProvider.appVersion()).build());
        } catch (JSONException unused) {
        }
    }
}
