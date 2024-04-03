package com.adyen.checkout.core.internal;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.adyen.checkout.core.CheckoutException;
import com.adyen.checkout.core.NetworkingState;
import com.adyen.checkout.core.Observable;
import com.adyen.checkout.core.SearchHandler;
import com.adyen.checkout.core.internal.model.AddressAndNameResponse;
import com.adyen.checkout.core.model.KlarnaSsnLookupResponse;
import com.adyen.checkout.core.model.PaymentMethod;
import com.adyen.checkout.core.model.PaymentSession;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SsnLookupSearchHandler implements SearchHandler<KlarnaSsnLookupResponse> {
    private static final int SSN_NUMBER_OF_DIGITS = 10;
    private final Application mApplication;
    /* access modifiers changed from: private */
    public KlarnaSsnLookupResponse mCachedSsnResponse;
    /* access modifiers changed from: private */
    public String mCachedSsnSearch;
    private final String mCallUrl;
    /* access modifiers changed from: private */
    public final ObservableImpl<CheckoutException> mErrorObservable;
    private final ExecutorService mExecutorService = Executors.newSingleThreadExecutor();
    private final Handler mMainHandler = new Handler(Looper.getMainLooper());
    /* access modifiers changed from: private */
    public final NetworkingStateImpl mNetworkingState;
    /* access modifiers changed from: private */
    public final ObservableImpl<NetworkingState> mNetworkingStateObservable;
    private final PaymentMethod mPaymentMethod;
    private final PaymentSession mPaymentSession;
    /* access modifiers changed from: private */
    public final ObservableImpl<KlarnaSsnLookupResponse> mSearchResultsObservable;

    public SsnLookupSearchHandler(@NonNull Application application, @NonNull PaymentMethod paymentMethod, @NonNull PaymentSession paymentSession, @NonNull String str) {
        NetworkingStateImpl networkingStateImpl = new NetworkingStateImpl();
        this.mNetworkingState = networkingStateImpl;
        this.mNetworkingStateObservable = new ObservableImpl<>(networkingStateImpl);
        this.mErrorObservable = new ObservableImpl<>(null);
        this.mSearchResultsObservable = new ObservableImpl<>(null);
        this.mApplication = application;
        this.mPaymentMethod = paymentMethod;
        this.mPaymentSession = paymentSession;
        this.mCallUrl = str;
    }

    private void executeSearch(@NonNull final String str) {
        final Callable<AddressAndNameResponse> ssnLookup = CheckoutApi.getInstance(this.mApplication).getSsnLookup(this.mPaymentMethod, this.mPaymentSession, this.mCallUrl, str);
        this.mExecutorService.submit(new Runnable() {
            public void run() {
                AnonymousClass5 r12;
                SsnLookupSearchHandler ssnLookupSearchHandler;
                final CheckoutException checkoutException;
                try {
                    SsnLookupSearchHandler.this.runOnUiThread(new Runnable() {
                        public void run() {
                            SsnLookupSearchHandler.this.mNetworkingState.onRequestStarted();
                            SsnLookupSearchHandler.this.mNetworkingStateObservable.setValue(SsnLookupSearchHandler.this.mNetworkingState);
                        }
                    });
                    final AddressAndNameResponse addressAndNameResponse = (AddressAndNameResponse) ssnLookup.call();
                    if (addressAndNameResponse == null || addressAndNameResponse.getAddressAndNameWrappers().size() <= 0) {
                        SsnLookupSearchHandler.this.runOnUiThread(new Runnable() {
                            public void run() {
                                SsnLookupSearchHandler.this.mErrorObservable.setValue(new CheckoutException.Builder("SsnLookup returned with an empty or invalid result.", (Throwable) null).setFatal(false).build());
                            }
                        });
                    } else {
                        SsnLookupSearchHandler.this.runOnUiThread(new Runnable() {
                            public void run() {
                                KlarnaSsnLookupResponse unused = SsnLookupSearchHandler.this.mCachedSsnResponse = addressAndNameResponse.getAddressAndNameWrappers().get(0).getAddressAndName();
                                AnonymousClass1 r02 = AnonymousClass1.this;
                                String unused2 = SsnLookupSearchHandler.this.mCachedSsnSearch = str;
                                SsnLookupSearchHandler.this.mSearchResultsObservable.setValue(SsnLookupSearchHandler.this.mCachedSsnResponse);
                            }
                        });
                    }
                    ssnLookupSearchHandler = SsnLookupSearchHandler.this;
                    r12 = new Runnable() {
                        public void run() {
                            SsnLookupSearchHandler.this.mNetworkingState.onRequestFinished();
                            SsnLookupSearchHandler.this.mNetworkingStateObservable.setValue(SsnLookupSearchHandler.this.mNetworkingState);
                        }
                    };
                } catch (Exception e11) {
                    if (e11 instanceof CheckoutException) {
                        checkoutException = (CheckoutException) e11;
                    } else {
                        checkoutException = new CheckoutException.Builder("An error occured while doing SSN Lookup.", e11).build();
                    }
                    SsnLookupSearchHandler.this.runOnUiThread(new Runnable() {
                        public void run() {
                            SsnLookupSearchHandler.this.mErrorObservable.setValue(checkoutException);
                        }
                    });
                    ssnLookupSearchHandler = SsnLookupSearchHandler.this;
                    r12 = new Runnable() {
                        public void run() {
                            SsnLookupSearchHandler.this.mNetworkingState.onRequestFinished();
                            SsnLookupSearchHandler.this.mNetworkingStateObservable.setValue(SsnLookupSearchHandler.this.mNetworkingState);
                        }
                    };
                } catch (Throwable th2) {
                    SsnLookupSearchHandler.this.runOnUiThread(new Runnable() {
                        public void run() {
                            SsnLookupSearchHandler.this.mNetworkingState.onRequestFinished();
                            SsnLookupSearchHandler.this.mNetworkingStateObservable.setValue(SsnLookupSearchHandler.this.mNetworkingState);
                        }
                    });
                    throw th2;
                }
                ssnLookupSearchHandler.runOnUiThread(r12);
            }
        });
    }

    private boolean isSsnValueValid(String str) {
        String replace = str.replace(" ", "");
        if (str.length() != 10) {
            return false;
        }
        try {
            Long.parseLong(replace);
            return true;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    /* access modifiers changed from: private */
    public void runOnUiThread(@NonNull Runnable runnable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
        } else {
            this.mMainHandler.post(runnable);
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
    public Observable<KlarnaSsnLookupResponse> getSearchResultsObservable() {
        return this.mSearchResultsObservable;
    }

    public void setSearchString(@NonNull String str) {
        if (str.equals(this.mCachedSsnSearch)) {
            this.mSearchResultsObservable.setValue(this.mCachedSsnResponse);
        } else if (isSsnValueValid(str)) {
            executeSearch(str);
        } else {
            this.mErrorObservable.setValue(new CheckoutException.Builder("SSN format is not valid.", (Throwable) null).build());
        }
    }
}
