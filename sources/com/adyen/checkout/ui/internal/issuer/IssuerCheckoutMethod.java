package com.adyen.checkout.ui.internal.issuer;

import android.app.Application;
import android.content.pm.ResolveInfo;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.ObjectsCompat;
import com.adyen.checkout.base.LogoApi;
import com.adyen.checkout.core.model.IssuerDetails;
import com.adyen.checkout.core.model.Item;
import com.adyen.checkout.core.model.PaymentMethod;
import com.adyen.checkout.ui.R;
import com.adyen.checkout.ui.internal.common.model.CheckoutHandler;
import com.adyen.checkout.ui.internal.common.model.CheckoutMethod;
import com.adyen.checkout.ui.internal.common.util.RedirectUtil;
import com.adyen.checkout.ui.internal.common.util.image.Rembrandt;
import com.adyen.checkout.ui.internal.common.util.image.RequestArgs;
import java.util.concurrent.Callable;

abstract class IssuerCheckoutMethod extends CheckoutMethod {

    public static final class AppIconCallable implements Callable<Drawable> {
        private final Application mApplication;
        private final ResolveInfo mResolveInfo;

        private AppIconCallable(@NonNull Application application, @NonNull ResolveInfo resolveInfo) {
            this.mApplication = application;
            this.mResolveInfo = resolveInfo;
        }

        public Drawable call() {
            return this.mResolveInfo.loadIcon(this.mApplication.getPackageManager());
        }
    }

    public static final class Default extends IssuerCheckoutMethod {
        public Default(@NonNull Application application, @NonNull PaymentMethod paymentMethod) {
            super(application, paymentMethod);
        }

        public void onSelected(@NonNull CheckoutHandler checkoutHandler) {
            checkoutHandler.handleWithPaymentMethodHandler(new IssuerHandler(checkoutHandler.getPaymentReference(), getPaymentMethod()));
        }
    }

    public static final class InstalledApp extends IssuerCheckoutMethod {
        private final Item mItem;
        private final ResolveInfo mResolveInfo;

        private InstalledApp(@NonNull Application application, @NonNull PaymentMethod paymentMethod, @NonNull ResolveInfo resolveInfo, @NonNull Item item) {
            super(application, paymentMethod);
            this.mResolveInfo = resolveInfo;
            this.mItem = item;
        }

        @Nullable
        public static InstalledApp init(@NonNull Application application, @NonNull PaymentMethod paymentMethod, @NonNull RedirectUtil.ResolveResult resolveResult, @NonNull Item item) {
            ResolveInfo resolveInfo = resolveResult.getResolveInfo();
            if (resolveResult.getResolveType() != RedirectUtil.ResolveType.APPLICATION || resolveInfo == null) {
                return null;
            }
            return new InstalledApp(application, paymentMethod, resolveInfo, item);
        }

        @NonNull
        public RequestArgs buildLogoRequestArgs(@NonNull LogoApi logoApi) {
            Application application = getApplication();
            return Rembrandt.get(application).load(new AppIconCallable(application, this.mResolveInfo)).placeholder(R.drawable.ic_image_24dp).error(R.drawable.ic_broken_image_24dp).build();
        }

        @NonNull
        public String getSecondaryText() {
            Application application = getApplication();
            CharSequence loadLabel = this.mResolveInfo.loadLabel(application.getPackageManager());
            return application.getString(R.string.checkout_issuer_open_with_app_format, new Object[]{loadLabel});
        }

        public void onSelected(@NonNull CheckoutHandler checkoutHandler) {
            checkoutHandler.getPaymentHandler().initiatePayment(getPaymentMethod(), new IssuerDetails.Builder(this.mItem.getId()).build());
        }

        public boolean isSameItem(@NonNull CheckoutMethod checkoutMethod) {
            return super.isSameItem(checkoutMethod) && (checkoutMethod instanceof InstalledApp) && ObjectsCompat.equals(this.mItem, ((InstalledApp) checkoutMethod).mItem);
        }
    }

    private IssuerCheckoutMethod(@NonNull Application application, @NonNull PaymentMethod paymentMethod) {
        super(application, paymentMethod);
    }
}
