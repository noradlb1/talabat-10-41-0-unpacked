package com.adyen.checkout.core.internal;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.adyen.checkout.core.CheckoutException;
import com.adyen.checkout.core.NetworkingState;
import com.adyen.checkout.core.Observable;
import com.adyen.checkout.core.SearchHandler;
import com.adyen.checkout.core.internal.model.GiroPayIssuerImpl;
import com.adyen.checkout.core.internal.model.GiroPayIssuersResponse;
import com.adyen.checkout.core.model.GiroPayIssuer;
import com.adyen.checkout.core.model.PaymentMethod;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GiroPayIssuerSearchHandler implements SearchHandler<List<GiroPayIssuer>> {
    private static final Handler MAIN_HANDLER = new Handler(Looper.getMainLooper());
    private static final int MINIMUM_SEARCH_STRING_LENGTH = 4;
    private final Application mApplication;
    /* access modifiers changed from: private */
    public Map.Entry<String, GiroPayIssuersResponse> mCurrentSearch;
    /* access modifiers changed from: private */
    public List<GiroPayIssuer> mCurrentSearchResults;
    /* access modifiers changed from: private */
    public final ObservableImpl<CheckoutException> mErrorObservable;
    private final ExecutorService mExecutorService = Executors.newSingleThreadExecutor();
    /* access modifiers changed from: private */
    public final NetworkingStateImpl mNetworkingState;
    /* access modifiers changed from: private */
    public final ObservableImpl<NetworkingState> mNetworkingStateObservable;
    private final PaymentMethod mPaymentMethod;
    /* access modifiers changed from: private */
    public final ObservableImpl<List<GiroPayIssuer>> mSearchResultsObservable;

    public GiroPayIssuerSearchHandler(@NonNull Application application, @NonNull PaymentMethod paymentMethod) {
        NetworkingStateImpl networkingStateImpl = new NetworkingStateImpl();
        this.mNetworkingState = networkingStateImpl;
        this.mNetworkingStateObservable = new ObservableImpl<>(networkingStateImpl);
        this.mErrorObservable = new ObservableImpl<>(null);
        this.mSearchResultsObservable = new ObservableImpl<>(null);
        this.mApplication = application;
        this.mPaymentMethod = paymentMethod;
    }

    private boolean checkShouldExecuteSearch(@NonNull String str) {
        if (str.length() < 4 || this.mNetworkingState.isExecutingRequests()) {
            return false;
        }
        Map.Entry<String, GiroPayIssuersResponse> entry = this.mCurrentSearch;
        if (entry != null && !newSearchStringRequiresSearch(entry.getKey(), str)) {
            return false;
        }
        this.mCurrentSearch = new AbstractMap.SimpleEntry(str, (Object) null);
        executeSearch(str);
        return true;
    }

    private void executeSearch(@NonNull final String str) {
        final Callable<GiroPayIssuersResponse> giroPayIssuers = CheckoutApi.getInstance(this.mApplication).getGiroPayIssuers(this.mPaymentMethod, str);
        this.mExecutorService.submit(new Runnable() {
            public void run() {
                AnonymousClass4 r12;
                GiroPayIssuerSearchHandler giroPayIssuerSearchHandler;
                final CheckoutException checkoutException;
                try {
                    GiroPayIssuerSearchHandler.this.runOnUiThread(new Runnable() {
                        public void run() {
                            GiroPayIssuerSearchHandler.this.mNetworkingState.onRequestStarted();
                            GiroPayIssuerSearchHandler.this.mNetworkingStateObservable.setValue(GiroPayIssuerSearchHandler.this.mNetworkingState);
                        }
                    });
                    final GiroPayIssuersResponse giroPayIssuersResponse = (GiroPayIssuersResponse) giroPayIssuers.call();
                    GiroPayIssuerSearchHandler.this.runOnUiThread(new Runnable() {
                        public void run() {
                            if (((String) GiroPayIssuerSearchHandler.this.mCurrentSearch.getKey()).startsWith(str)) {
                                GiroPayIssuerSearchHandler.this.mCurrentSearch.setValue(giroPayIssuersResponse);
                                List unused = GiroPayIssuerSearchHandler.this.mCurrentSearchResults = new ArrayList(giroPayIssuersResponse.getGiroPayIssuers());
                                GiroPayIssuerSearchHandler.this.mSearchResultsObservable.setValue(GiroPayIssuerSearchHandler.this.mCurrentSearchResults);
                                return;
                            }
                            Map.Entry unused2 = GiroPayIssuerSearchHandler.this.mCurrentSearch = null;
                        }
                    });
                    giroPayIssuerSearchHandler = GiroPayIssuerSearchHandler.this;
                    r12 = new Runnable() {
                        public void run() {
                            GiroPayIssuerSearchHandler.this.mNetworkingState.onRequestFinished();
                            GiroPayIssuerSearchHandler.this.mNetworkingStateObservable.setValue(GiroPayIssuerSearchHandler.this.mNetworkingState);
                        }
                    };
                } catch (Exception e11) {
                    if (e11 instanceof CheckoutException) {
                        checkoutException = (CheckoutException) e11;
                    } else {
                        checkoutException = new CheckoutException.Builder("An error occured while searching for GiroPayIssuers.", e11).build();
                    }
                    GiroPayIssuerSearchHandler.this.runOnUiThread(new Runnable() {
                        public void run() {
                            Map.Entry unused = GiroPayIssuerSearchHandler.this.mCurrentSearch = null;
                            GiroPayIssuerSearchHandler.this.mErrorObservable.setValue(checkoutException);
                        }
                    });
                    giroPayIssuerSearchHandler = GiroPayIssuerSearchHandler.this;
                    r12 = new Runnable() {
                        public void run() {
                            GiroPayIssuerSearchHandler.this.mNetworkingState.onRequestFinished();
                            GiroPayIssuerSearchHandler.this.mNetworkingStateObservable.setValue(GiroPayIssuerSearchHandler.this.mNetworkingState);
                        }
                    };
                } catch (Throwable th2) {
                    GiroPayIssuerSearchHandler.this.runOnUiThread(new Runnable() {
                        public void run() {
                            GiroPayIssuerSearchHandler.this.mNetworkingState.onRequestFinished();
                            GiroPayIssuerSearchHandler.this.mNetworkingStateObservable.setValue(GiroPayIssuerSearchHandler.this.mNetworkingState);
                        }
                    });
                    throw th2;
                }
                giroPayIssuerSearchHandler.runOnUiThread(r12);
            }
        });
    }

    private boolean newSearchStringRequiresSearch(@NonNull String str, @NonNull String str2) {
        int length = str.length();
        int length2 = str2.length();
        if (length2 >= length && (length2 != length || str2.equalsIgnoreCase(str))) {
            Locale locale = Locale.US;
            if (!str2.toLowerCase(locale).startsWith(str.toLowerCase(locale))) {
                return true;
            }
            return false;
        }
        return true;
    }

    private void performFiltering(@NonNull String str) {
        GiroPayIssuersResponse value;
        Map.Entry<String, GiroPayIssuersResponse> entry = this.mCurrentSearch;
        if (entry != null && (value = entry.getValue()) != null) {
            ArrayList arrayList = new ArrayList();
            for (GiroPayIssuerImpl next : value.getGiroPayIssuers()) {
                if (SearchUtil.anyMatches(str, next.getBankName(), next.getBic(), next.getBlz())) {
                    arrayList.add(next);
                }
            }
            if (!arrayList.equals(this.mCurrentSearchResults)) {
                this.mCurrentSearchResults = arrayList;
                this.mSearchResultsObservable.setValue(arrayList);
            }
        }
    }

    /* access modifiers changed from: private */
    public void runOnUiThread(@NonNull Runnable runnable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
        } else {
            MAIN_HANDLER.post(runnable);
        }
    }

    @NonNull
    public Observable<CheckoutException> getErrorObservable() {
        return this.mErrorObservable;
    }

    @NonNull
    public Observable<NetworkingState> getNetworkInfoObservable() {
        return this.mNetworkingStateObservable;
    }

    @NonNull
    public Observable<List<GiroPayIssuer>> getSearchResultsObservable() {
        return this.mSearchResultsObservable;
    }

    public void setSearchString(@NonNull String str) {
        String trim = str.trim();
        if (!checkShouldExecuteSearch(trim)) {
            performFiltering(trim);
        }
    }
}
