package com.adyen.checkout.core;

import android.app.Application;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.adyen.checkout.core.internal.GiroPayIssuerSearchHandler;
import com.adyen.checkout.core.internal.SsnLookupSearchHandler;
import com.adyen.checkout.core.model.GiroPayIssuer;
import com.adyen.checkout.core.model.KlarnaConfiguration;
import com.adyen.checkout.core.model.KlarnaSsnLookupResponse;
import com.adyen.checkout.core.model.PaymentMethod;
import com.adyen.checkout.core.model.PaymentSession;
import java.util.List;

public interface SearchHandler<R> {

    public static final class Factory {
        private Factory() {
            throw new IllegalStateException("No instances.");
        }

        @NonNull
        public static SearchHandler<List<GiroPayIssuer>> createGiroPayIssuerSearchHandler(@NonNull Application application, @NonNull PaymentMethod paymentMethod) {
            return new GiroPayIssuerSearchHandler(application, paymentMethod);
        }

        @Nullable
        public static SearchHandler<KlarnaSsnLookupResponse> createKlarnaSsnLookupSearchHandler(@NonNull Application application, @NonNull PaymentSession paymentSession, @NonNull PaymentMethod paymentMethod) {
            try {
                String shopperInfoSsnLookupUrl = ((KlarnaConfiguration) paymentMethod.getConfiguration(KlarnaConfiguration.class)).getShopperInfoSsnLookupUrl();
                if (TextUtils.isEmpty(shopperInfoSsnLookupUrl)) {
                    return null;
                }
                return new SsnLookupSearchHandler(application, paymentMethod, paymentSession, shopperInfoSsnLookupUrl);
            } catch (CheckoutException unused) {
                return null;
            }
        }
    }

    @NonNull
    Observable<CheckoutException> getErrorObservable();

    @NonNull
    Observable<NetworkingState> getNetworkInfoObservable();

    @NonNull
    Observable<R> getSearchResultsObservable();

    void setSearchString(@NonNull String str);
}
