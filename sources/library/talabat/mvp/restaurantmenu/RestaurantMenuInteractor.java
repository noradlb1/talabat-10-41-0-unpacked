package library.talabat.mvp.restaurantmenu;

import JsonModels.Request.ParallelBin.ParallelBinRequest;
import JsonModels.Response.BIN.BinTokenResponse;
import JsonModels.Response.BinTokenRM;
import JsonModels.Response.GroceryResponse.GroceryItemsForSectionResponse;
import JsonModels.Response.ParallelBin.ParallelBinRM;
import JsonModels.Response.ParallelBin.ParallelBinResponse;
import JsonModels.Response.PreviousOrderList.PreviousOrderResponse;
import JsonModels.Response.ShopStatus.ShopStatusResponse;
import JsonModels.Response.SplitRestaurantApiResponse.SplitChoiceRM;
import JsonModels.Response.SplitRestaurantApiResponse.SplitMenuRM;
import JsonModels.parser.UniversalGson;
import b20.a;
import buisnessmodels.Customer;
import buisnessmodels.tokenisation.TokenisationCreditCard;
import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.VolleyError;
import com.google.gson.Gson;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.helpers.AppUrls;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.helpers.GsonRequest;
import com.talabat.helpers.TalabatUtils;
import com.talabat.helpers.TalabatVolley;
import datamodels.MenuSection;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import library.talabat.com.talabatlib.CreateApiUrl;
import org.json.JSONException;
import org.json.JSONObject;
import service.ApiHandler;

@Instrumented
public class RestaurantMenuInteractor implements IRestaurantMenuInteractor {
    private final AppVersionProvider appVersionProvider;
    private final ConfigurationLocalRepository configurationLocalRepository;
    private final LocationConfigurationRepository locationConfigurationRepository;
    /* access modifiers changed from: private */
    public RestaurantMenuListener restaurantMenuListener;
    /* access modifiers changed from: private */
    public ArrayList<TokenisationCreditCard> tokenisationCreditCards;

    public RestaurantMenuInteractor(AppVersionProvider appVersionProvider2, ConfigurationLocalRepository configurationLocalRepository2, LocationConfigurationRepository locationConfigurationRepository2, RestaurantMenuListener restaurantMenuListener2) {
        this.appVersionProvider = appVersionProvider2;
        this.configurationLocalRepository = configurationLocalRepository2;
        this.locationConfigurationRepository = locationConfigurationRepository2;
        this.restaurantMenuListener = restaurantMenuListener2;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onAllBinResponse$0(ParallelBinRM parallelBinRM) {
        String str;
        ArrayList arrayList = new ArrayList();
        if (this.restaurantMenuListener == null) {
            return;
        }
        if (!TalabatUtils.isNullOrEmpty(parallelBinRM.result.msg)) {
            GlobalDataModel.PARALLELBIN.notAvailable = false;
            ParallelBinResponse parallelBinResponse = parallelBinRM.result;
            String str2 = parallelBinResponse.msg;
            if (!TalabatUtils.isNullOrEmpty(parallelBinResponse.iconUrl)) {
                str = parallelBinRM.result.iconUrl;
            } else {
                str = "";
            }
            if (parallelBinRM.result.areMoreBinModelsAvailable()) {
                arrayList.addAll(Arrays.asList(parallelBinRM.result.moreBinModels));
            }
            new GlobalDataModel.PARALLELBIN(str2, str, arrayList);
            this.restaurantMenuListener.onParallelBinAvailable();
            return;
        }
        GlobalDataModel.PARALLELBIN.notAvailable = true;
    }

    private Response.ErrorListener onAllBinRequestError() {
        return new Response.ErrorListener() {
            public void onErrorResponse(VolleyError volleyError) {
                GlobalDataModel.PARALLELBIN.notAvailable = true;
            }
        };
    }

    private Response.Listener<ParallelBinRM> onAllBinResponse() {
        return new a(this);
    }

    private Response.Listener<BinTokenRM> onBinTokenResponseReceived() {
        return new Response.Listener<BinTokenRM>() {
            public void onResponse(BinTokenRM binTokenRM) {
                String str = "";
                if (binTokenRM != null) {
                    GlobalDataModel.BIN.handled = true;
                    BinTokenResponse[] binTokenResponseArr = binTokenRM.result;
                    if (binTokenResponseArr != null && binTokenResponseArr.length > 0) {
                        RestaurantMenuInteractor.this.tokenisationCreditCards = Customer.getInstance().getSavedCards();
                        if (RestaurantMenuInteractor.this.tokenisationCreditCards != null && RestaurantMenuInteractor.this.tokenisationCreditCards.size() > 0) {
                            boolean z11 = false;
                            for (BinTokenResponse binTokenResponse : binTokenRM.result) {
                                Iterator it = RestaurantMenuInteractor.this.tokenisationCreditCards.iterator();
                                while (it.hasNext()) {
                                    TokenisationCreditCard tokenisationCreditCard = (TokenisationCreditCard) it.next();
                                    if (tokenisationCreditCard.token.equals(binTokenResponse.token)) {
                                        boolean z12 = binTokenResponse.isBinDiscountValid;
                                        tokenisationCreditCard.isBinDiscountValid = z12;
                                        tokenisationCreditCard.binNumber = binTokenResponse.binNumber;
                                        tokenisationCreditCard.message = binTokenResponse.chkOutMesg;
                                        if (!z11 && z12 && !TalabatUtils.isNullOrEmpty(binTokenResponse.menuMesg)) {
                                            str = binTokenResponse.menuMesg;
                                            z11 = true;
                                        }
                                    }
                                }
                            }
                        }
                        GlobalDataModel.BIN.tokensModified = true;
                        Customer.getInstance().setSavedCreditCards((TokenisationCreditCard[]) RestaurantMenuInteractor.this.tokenisationCreditCards.toArray(new TokenisationCreditCard[RestaurantMenuInteractor.this.tokenisationCreditCards.size()]));
                        ArrayList<TokenisationCreditCard> arrayList = GlobalDataModel.BIN.savedTokens;
                        if (arrayList != null && arrayList.size() > 0) {
                            GlobalDataModel.BIN.savedTokens.clear();
                        }
                        GlobalDataModel.BIN.savedTokens = Customer.getInstance().getSavedCards();
                    }
                }
                if (RestaurantMenuInteractor.this.restaurantMenuListener != null) {
                    RestaurantMenuInteractor.this.restaurantMenuListener.onBinResponseReceived(binTokenRM, str);
                }
            }
        };
    }

    private Response.Listener<SplitChoiceRM> onChoiceReceived() {
        return new Response.Listener<SplitChoiceRM>() {
            public void onResponse(SplitChoiceRM splitChoiceRM) {
                if (RestaurantMenuInteractor.this.restaurantMenuListener == null) {
                    return;
                }
                if (splitChoiceRM.result.items.length > 0) {
                    RestaurantMenuInteractor.this.restaurantMenuListener.onChoiceReceived(splitChoiceRM.result.items[0]);
                } else {
                    RestaurantMenuInteractor.this.restaurantMenuListener.onNoChoiceAvailable();
                }
            }
        };
    }

    private Response.ErrorListener onRequestError() {
        return new Response.ErrorListener() {
            public void onErrorResponse(VolleyError volleyError) {
                if ((volleyError instanceof ServerError) && RestaurantMenuInteractor.this.restaurantMenuListener != null) {
                    RestaurantMenuInteractor.this.restaurantMenuListener.onServerError(volleyError);
                } else if ((volleyError instanceof NetworkError) && RestaurantMenuInteractor.this.restaurantMenuListener != null) {
                    RestaurantMenuInteractor.this.restaurantMenuListener.onNetworkError();
                } else if ((volleyError instanceof AuthFailureError) && RestaurantMenuInteractor.this.restaurantMenuListener != null) {
                    RestaurantMenuInteractor.this.restaurantMenuListener.onDataError();
                }
            }
        };
    }

    public void getAllBinOffers() {
        String str;
        JSONObject jSONObject;
        Gson gson = UniversalGson.INSTANCE.gson;
        ParallelBinRequest parallelBinRequest = new ParallelBinRequest(GlobalDataModel.SELECTED.restaurant.f13872id, GlobalDataModel.SelectedAreaId);
        if (!(gson instanceof Gson)) {
            str = gson.toJson((Object) parallelBinRequest);
        } else {
            str = GsonInstrumentation.toJson(gson, (Object) parallelBinRequest);
        }
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException unused) {
            jSONObject = null;
        }
        TalabatVolley.addToRequestQueue(new GsonRequest.Builder().setMethod(1).setUrl(AppUrls.GET_ALL_BINS).setClazz(ParallelBinRM.class).setRequestBody(jSONObject).setListener(onAllBinResponse()).setErrorListener(onAllBinRequestError()).setAppVersion(this.appVersionProvider.appVersion()).build());
    }

    public void getAllGroceryItems(int i11) {
        ApiHandler.Services callApi = ApiHandler.callApi();
        String str = AppUrls.SPLIT_RESTAURANT_MENU;
        callApi.getGroceryMenuForSearch(str.replace("{branchId}", i11 + "")).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new DisposableObserver<SplitMenuRM>() {
            public void onComplete() {
            }

            public void onError(Throwable th2) {
            }

            public void onNext(SplitMenuRM splitMenuRM) {
                GlobalDataModel.JSON.menuItemsResponseModel.menu = splitMenuRM.result.menu;
                GlobalDataModel.JSON.groceryMenuLoaded.setValue(Boolean.TRUE);
            }
        });
    }

    public void getChoiceSection(int i11) {
        GsonRequest.Builder builder = new GsonRequest.Builder();
        String str = AppUrls.SPLIT_RESTAURANT_CHOICE;
        TalabatVolley.addToRequestQueue(builder.setUrl(CreateApiUrl.createWithParameters(str, new String[]{"{branchId}", GlobalDataModel.SELECTED.restaurant.getBranchId() + "", "{sectionId}", i11 + ""})).setClazz(SplitChoiceRM.class).setListener(onChoiceReceived()).setErrorListener(onRequestError()).setAppVersion(this.appVersionProvider.appVersion()).build());
    }

    public Observable<SplitChoiceRM> getChoicesForMenuItem(String str, String str2) {
        ApiHandler.Services callApi = ApiHandler.callApi();
        String replace = AppUrls.SPLIT_RESTAURANT_CHOICE.replace("{branchId}", str);
        return callApi.getChoiceSectionForMenuItem(replace.replace("{sectionId}", str2 + ""));
    }

    public void getCustomerTokensForBin() {
        GsonRequest.Builder builder = new GsonRequest.Builder();
        String str = AppUrls.GET_BIN_TOKENS;
        TalabatVolley.addToRequestQueue(builder.setUrl(CreateApiUrl.createWithParameters(str, new String[]{"{payProvider}", "" + TalabatUtils.getSelectedCountry(this.configurationLocalRepository, this.locationConfigurationRepository).tokenisationProvider, "{countryId}", "" + GlobalDataModel.SelectedCountryId, "{restaurantId}", "" + GlobalDataModel.SELECTED.restaurant.f13872id, "{branchId}", "" + GlobalDataModel.SELECTED.restaurant.branchId, "{areaId}", GlobalDataModel.SelectedAreaId + ""})).setClazz(BinTokenRM.class).setListener(onBinTokenResponseReceived()).setErrorListener(onRequestError()).setAppVersion(this.appVersionProvider.appVersion()).build());
    }

    public void getGroceryItemsForSection(final int i11, int i12) {
        ApiHandler.Services callApi = ApiHandler.callApi();
        String str = AppUrls.SPLIT_GROCERY_ITEMS_FOR_SECTION;
        String replace = str.replace("{branchId}", i12 + "");
        callApi.getGroceryItemsForSection(replace.replace("{sectionId}", i11 + "").replace("{pageNumber}", "1")).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new DisposableObserver<GroceryItemsForSectionResponse>() {
            public void onComplete() {
            }

            public void onError(Throwable th2) {
                GlobalDataModel.JSON.netWorkErrorOccured.setValue(Boolean.TRUE);
            }

            public void onNext(GroceryItemsForSectionResponse groceryItemsForSectionResponse) {
                MenuSection[] menuSectionArr = GlobalDataModel.JSON.menuItemsResponseModel.menu.menuSection;
                int length = menuSectionArr.length;
                int i11 = 0;
                while (true) {
                    if (i11 >= length) {
                        break;
                    }
                    MenuSection menuSection = menuSectionArr[i11];
                    if (menuSection.f13863id != i11) {
                        i11++;
                    } else if (groceryItemsForSectionResponse.getResult().getMenuSection() != null) {
                        menuSection.groceryItemsForSectionPagingInfo = groceryItemsForSectionResponse.getResult().getPagingInfo();
                        menuSection.items = groceryItemsForSectionResponse.getResult().getMenuSection().items;
                        menuSection.brands = groceryItemsForSectionResponse.getResult().component1().brands;
                        menuSection.groceryTags = groceryItemsForSectionResponse.getResult().component1().groceryTags;
                        menuSection.firstPageLoaded = true;
                    }
                }
                GlobalDataModel.JSON.groceryMenuItemsLoadedForSection.setValue(Boolean.TRUE);
            }
        });
    }

    public Observable<PreviousOrderResponse> getPreviousOrderList(int i11) {
        ApiHandler.Services callApi = ApiHandler.callApi();
        String str = AppUrls.GET_PREVIOUS_ORDER_LIST;
        return callApi.getPreviousOrders(str, i11 + "");
    }

    public Observable<ShopStatusResponse> getShopStatus(String str, String str2, String str3, boolean z11) {
        return ApiHandler.callApi().getShopStatus(AppUrls.GET_SHOP_STATUS, str, str2, str3, z11);
    }

    public void unregister() {
        this.restaurantMenuListener = null;
    }
}
