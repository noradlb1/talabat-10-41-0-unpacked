package com.talabat.feature.darkstorescartlist.data.repository;

import com.integration.IntegrationGlobalDataModel;
import com.squareup.moshi.JsonDataException;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.feature.darkstorescartlist.data.local.CartListLocalDataSource;
import com.talabat.feature.darkstorescartlist.data.model.CartInfoListResponse;
import com.talabat.feature.darkstorescartlist.data.model.CartInfoResponse;
import com.talabat.feature.darkstorescartlist.data.remote.CartListApi;
import com.talabat.feature.darkstorescartlist.domain.model.CartInfo;
import com.talabat.feature.darkstorescartlist.domain.repository.DarkstoresCartListRepository;
import com.talabat.mapper.ModelMapper;
import com.talabat.observabilityNew.squads.nfv.NFVEventType;
import com.talabat.observabilityNew.squads.nfv.ObservableAttributesNames;
import im.a;
import im.b;
import im.c;
import im.d;
import im.e;
import io.reactivex.Maybe;
import io.reactivex.Single;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.ResponseBody;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;
import retrofit2.HttpException;
import retrofit2.Response;

@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0000\u0018\u00002\u00020\u0001BE\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\t\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\u0014\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u001b0\u001aH\u0002J\u0014\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u001b0\u001dH\u0016J\u0018\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0013H\u0002J\u0014\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u001b0\u001dH\u0002J\b\u0010#\u001a\u00020$H\u0016J\u0018\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u0013H\u0016J \u0010*\u001a\u00020$2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u00132\u0006\u0010+\u001a\u00020&H\u0016J\u0010\u0010,\u001a\u00020$2\u0006\u0010-\u001a\u00020.H\u0002R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R7\u0010\u0011\u001a\u001e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00130\u0012j\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0013`\u00148BX\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lcom/talabat/feature/darkstorescartlist/data/repository/DarkstoresCartListRepositoryImpl;", "Lcom/talabat/feature/darkstorescartlist/domain/repository/DarkstoresCartListRepository;", "integrationDataModel", "Lcom/integration/IntegrationGlobalDataModel$Companion;", "cartListApi", "Lcom/talabat/feature/darkstorescartlist/data/remote/CartListApi;", "cartListLocalDataSource", "Lcom/talabat/feature/darkstorescartlist/data/local/CartListLocalDataSource;", "cartInfoResponseMapper", "Lcom/talabat/mapper/ModelMapper;", "Lcom/talabat/feature/darkstorescartlist/data/model/CartInfoResponse;", "Lcom/talabat/feature/darkstorescartlist/domain/model/CartInfo;", "observabilityManager", "Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;", "appVersionProvider", "Lcom/talabat/configuration/discovery/AppVersionProvider;", "(Lcom/integration/IntegrationGlobalDataModel$Companion;Lcom/talabat/feature/darkstorescartlist/data/remote/CartListApi;Lcom/talabat/feature/darkstorescartlist/data/local/CartListLocalDataSource;Lcom/talabat/mapper/ModelMapper;Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;Lcom/talabat/configuration/discovery/AppVersionProvider;)V", "commonAttributesForObservability", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getCommonAttributesForObservability", "()Ljava/util/HashMap;", "commonAttributesForObservability$delegate", "Lkotlin/Lazy;", "getCachedCartInfoList", "Lio/reactivex/Maybe;", "", "getCartInfoList", "Lio/reactivex/Single;", "getErrorMessageFromHttpException", "httpException", "Lretrofit2/HttpException;", "apiName", "getRemoteCartInfoList", "invalidateCartInfoListCache", "", "isCartListToastShown", "", "cartCount", "", "variation", "setCartListToastShown", "shown", "trackCartSummaryAPIObservability", "error", "", "com_talabat_feature_darkstores-cart-list_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DarkstoresCartListRepositoryImpl implements DarkstoresCartListRepository {
    /* access modifiers changed from: private */
    @NotNull
    public final AppVersionProvider appVersionProvider;
    @NotNull
    private final ModelMapper<CartInfoResponse, CartInfo> cartInfoResponseMapper;
    @NotNull
    private final CartListApi cartListApi;
    @NotNull
    private final CartListLocalDataSource cartListLocalDataSource;
    @NotNull
    private final Lazy commonAttributesForObservability$delegate = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, new DarkstoresCartListRepositoryImpl$commonAttributesForObservability$2(this));
    /* access modifiers changed from: private */
    @NotNull
    public final IntegrationGlobalDataModel.Companion integrationDataModel;
    @NotNull
    private final IObservabilityManager observabilityManager;

    @Inject
    public DarkstoresCartListRepositoryImpl(@NotNull IntegrationGlobalDataModel.Companion companion, @NotNull CartListApi cartListApi2, @NotNull CartListLocalDataSource cartListLocalDataSource2, @NotNull ModelMapper<CartInfoResponse, CartInfo> modelMapper, @NotNull IObservabilityManager iObservabilityManager, @NotNull AppVersionProvider appVersionProvider2) {
        Intrinsics.checkNotNullParameter(companion, "integrationDataModel");
        Intrinsics.checkNotNullParameter(cartListApi2, "cartListApi");
        Intrinsics.checkNotNullParameter(cartListLocalDataSource2, "cartListLocalDataSource");
        Intrinsics.checkNotNullParameter(modelMapper, "cartInfoResponseMapper");
        Intrinsics.checkNotNullParameter(iObservabilityManager, "observabilityManager");
        Intrinsics.checkNotNullParameter(appVersionProvider2, "appVersionProvider");
        this.integrationDataModel = companion;
        this.cartListApi = cartListApi2;
        this.cartListLocalDataSource = cartListLocalDataSource2;
        this.cartInfoResponseMapper = modelMapper;
        this.observabilityManager = iObservabilityManager;
        this.appVersionProvider = appVersionProvider2;
    }

    private final Maybe<List<CartInfoResponse>> getCachedCartInfoList() {
        Maybe<List<CartInfoResponse>> fromCallable = Maybe.fromCallable(new b(this));
        Intrinsics.checkNotNullExpressionValue(fromCallable, "fromCallable {\n         …Source.cartList\n        }");
        return fromCallable;
    }

    /* access modifiers changed from: private */
    /* renamed from: getCachedCartInfoList$lambda-4  reason: not valid java name */
    public static final List m10183getCachedCartInfoList$lambda4(DarkstoresCartListRepositoryImpl darkstoresCartListRepositoryImpl) {
        Intrinsics.checkNotNullParameter(darkstoresCartListRepositoryImpl, "this$0");
        return darkstoresCartListRepositoryImpl.cartListLocalDataSource.getCartList();
    }

    /* access modifiers changed from: private */
    /* renamed from: getCartInfoList$lambda-0  reason: not valid java name */
    public static final List m10184getCartInfoList$lambda0(DarkstoresCartListRepositoryImpl darkstoresCartListRepositoryImpl, List list) {
        Intrinsics.checkNotNullParameter(darkstoresCartListRepositoryImpl, "this$0");
        Intrinsics.checkNotNullParameter(list, "cartInfoList");
        ModelMapper<CartInfoResponse, CartInfo> modelMapper = darkstoresCartListRepositoryImpl.cartInfoResponseMapper;
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            CartInfo apply = modelMapper.apply((CartInfoResponse) it.next());
            if (apply != null) {
                arrayList.add(apply);
            }
        }
        return arrayList;
    }

    private final HashMap<String, String> getCommonAttributesForObservability() {
        return (HashMap) this.commonAttributesForObservability$delegate.getValue();
    }

    private final String getErrorMessageFromHttpException(HttpException httpException, String str) {
        ResponseBody errorBody;
        String string;
        JSONObject optJSONObject;
        String optString;
        boolean z11;
        Response<?> response = httpException.response();
        if (!(response == null || (errorBody = response.errorBody()) == null || (string = errorBody.string()) == null || (optJSONObject = new JSONObject(string).optJSONObject("data")) == null || (optString = optJSONObject.optString("message")) == null)) {
            if (optString.length() > 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (!z11) {
                optString = null;
            }
            if (optString != null) {
                return optString;
            }
        }
        int code = httpException.code();
        return "HttpException in error " + code + " in " + str;
    }

    private final Single<List<CartInfoResponse>> getRemoteCartInfoList() {
        boolean z11;
        CartListApi cartListApi2 = this.cartListApi;
        String customerID = this.integrationDataModel.customerID();
        if (customerID.length() == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            customerID = null;
        }
        if (customerID == null) {
            customerID = "0";
        }
        Single<R> doOnSuccess = cartListApi2.getCartInfoList(customerID, this.integrationDataModel.selectedLocationLatitude(), this.integrationDataModel.selectedLocationLongitude()).doOnError(new c(this)).map(new d()).doOnSuccess(new e(this));
        Intrinsics.checkNotNullExpressionValue(doOnSuccess, "cartListApi.getCartInfoL… = cartList\n            }");
        return doOnSuccess;
    }

    /* access modifiers changed from: private */
    /* renamed from: getRemoteCartInfoList$lambda-2  reason: not valid java name */
    public static final List m10185getRemoteCartInfoList$lambda2(CartInfoListResponse cartInfoListResponse) {
        Intrinsics.checkNotNullParameter(cartInfoListResponse, "cartInfoListResponse");
        return cartInfoListResponse.getCarts();
    }

    /* access modifiers changed from: private */
    /* renamed from: getRemoteCartInfoList$lambda-3  reason: not valid java name */
    public static final void m10186getRemoteCartInfoList$lambda3(DarkstoresCartListRepositoryImpl darkstoresCartListRepositoryImpl, List list) {
        Intrinsics.checkNotNullParameter(darkstoresCartListRepositoryImpl, "this$0");
        darkstoresCartListRepositoryImpl.cartListLocalDataSource.setCartList(list);
    }

    /* access modifiers changed from: private */
    public final void trackCartSummaryAPIObservability(Throwable th2) {
        String str;
        HashMap hashMap = new HashMap();
        hashMap.putAll(getCommonAttributesForObservability());
        hashMap.put("api_name", "GET_grocery/v1/cart/summary");
        if (th2 instanceof JsonDataException) {
            String message = th2.getMessage();
            if (message == null) {
                message = "Error in api parsing of GET_grocery/v1/cart/summary";
            }
            hashMap.put("error_message", message);
            str = ObservableAttributesNames.ERROR_RESPONSE_PARSING;
        } else {
            if (th2 instanceof HttpException) {
                hashMap.put("error_message", getErrorMessageFromHttpException((HttpException) th2, "GET_grocery/v1/cart/summary"));
            } else if (th2 instanceof SocketTimeoutException) {
                String message2 = th2.getMessage();
                if (message2 == null) {
                    message2 = "Socket error in GET_grocery/v1/cart/summary";
                }
                hashMap.put("error_message", message2);
            } else {
                String message3 = th2.getMessage();
                if (message3 == null) {
                    message3 = "Something went wrong in GET_grocery/v1/cart/summary";
                }
                hashMap.put("error_message", message3);
            }
            str = ObservableAttributesNames.ERROR_API;
        }
        this.observabilityManager.trackEvent(str, NFVEventType.MobileUnexpectedScenariosQC.name(), (Map<String, String>) hashMap);
    }

    @NotNull
    public Single<List<CartInfo>> getCartInfoList() {
        Single<R> map = getCachedCartInfoList().switchIfEmpty(getRemoteCartInfoList()).map(new a(this));
        Intrinsics.checkNotNullExpressionValue(map, "getCachedCartInfoList()\n…per::apply)\n            }");
        return map;
    }

    public void invalidateCartInfoListCache() {
        this.cartListLocalDataSource.setCartList((List<CartInfoResponse>) null);
    }

    public boolean isCartListToastShown(int i11, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "variation");
        return this.cartListLocalDataSource.isCartListToastShown(i11, str);
    }

    public void setCartListToastShown(int i11, @NotNull String str, boolean z11) {
        Intrinsics.checkNotNullParameter(str, "variation");
        this.cartListLocalDataSource.setCartListToastShown(i11, str, z11);
    }
}
