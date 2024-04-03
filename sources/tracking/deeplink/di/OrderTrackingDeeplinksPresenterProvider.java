package tracking.deeplink.di;

import android.app.Activity;
import android.app.Application;
import com.talabat.configuration.MutableConfigurationLocalRepository;
import com.talabat.configuration.MutableLocationConfigurationRepository;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.configuration.di.MutableConfigurationLocalCoreLibApi;
import com.talabat.configuration.di.MutableConfigurationRemoteCoreLibApi;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.configuration.payment.PaymentConfigurationRepository;
import com.talabat.core.di.ApiContainer;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.core.observabilityNew.domain.ObservabilityCoreLibApi;
import com.talabat.user.address.di.AddressesDependencyProvider;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import library.talabat.SharedPreferencesManager;
import org.jetbrains.annotations.NotNull;
import tracking.deeplink.DeepLinkPresenter;
import tracking.deeplink.IDeepLinkPresenter;
import tracking.deeplink.OrderTrackingDeeplinksCallback;
import tracking.observability.di.VendorInfoAPIObservabilityProvider;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Ltracking/deeplink/di/OrderTrackingDeeplinksPresenterProvider;", "", "()V", "providesDeeplinkPresenter", "Ltracking/deeplink/IDeepLinkPresenter;", "activity", "Landroid/app/Activity;", "orderTrackingDeeplinksCallback", "Ltracking/deeplink/OrderTrackingDeeplinksCallback;", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OrderTrackingDeeplinksPresenterProvider {
    @NotNull
    public static final OrderTrackingDeeplinksPresenterProvider INSTANCE = new OrderTrackingDeeplinksPresenterProvider();

    private OrderTrackingDeeplinksPresenterProvider() {
    }

    @NotNull
    public final IDeepLinkPresenter providesDeeplinkPresenter(@NotNull Activity activity, @NotNull OrderTrackingDeeplinksCallback orderTrackingDeeplinksCallback) {
        Activity activity2 = activity;
        Intrinsics.checkNotNullParameter(activity2, "activity");
        Intrinsics.checkNotNullParameter(orderTrackingDeeplinksCallback, "orderTrackingDeeplinksCallback");
        Application application = activity.getApplication();
        if (application != null) {
            ApiContainer apiContainer = (ApiContainer) application;
            Class cls = ConfigurationRemoteCoreLibApi.class;
            AppVersionProvider appVersionProvider = ((ConfigurationRemoteCoreLibApi) apiContainer.getFeature(cls)).getAppVersionProvider();
            MutableLocationConfigurationRepository mutableLocationConfigurationRepository = ((MutableConfigurationRemoteCoreLibApi) apiContainer.getFeature(MutableConfigurationRemoteCoreLibApi.class)).getMutableLocationConfigurationRepository();
            MutableConfigurationLocalRepository mutableRepository = ((MutableConfigurationLocalCoreLibApi) apiContainer.getFeature(MutableConfigurationLocalCoreLibApi.class)).getMutableRepository();
            PaymentConfigurationRepository paymentConfigurationRepository = ((ConfigurationRemoteCoreLibApi) apiContainer.getFeature(cls)).getPaymentConfigurationRepository();
            ITalabatFeatureFlag talabatFeatureFlag = ((FeatureFlagCoreLibApi) apiContainer.getFeature(FeatureFlagCoreLibApi.class)).getTalabatFeatureFlag();
            IObservabilityManager observabilityManager = ((ObservabilityCoreLibApi) apiContainer.getFeature(ObservabilityCoreLibApi.class)).getObservabilityManager();
            AddressesDependencyProvider addressesDependencyProvider = AddressesDependencyProvider.INSTANCE;
            return new DeepLinkPresenter(orderTrackingDeeplinksCallback, addressesDependencyProvider.provideCustomerAddressesRepository(talabatFeatureFlag), addressesDependencyProvider.provideCustomerRepository(activity2), mutableLocationConfigurationRepository, SharedPreferencesManager.getInstance(activity), Schedulers.io(), AndroidSchedulers.mainThread(), activity2.getPreferences(0), mutableRepository, paymentConfigurationRepository, talabatFeatureFlag, appVersionProvider, VendorInfoAPIObservabilityProvider.INSTANCE.provideVendorInfoAPIObservability(observabilityManager, appVersionProvider), (IObservabilityManager) null);
        }
        throw new NullPointerException("null cannot be cast to non-null type com.talabat.core.di.ApiContainer");
    }
}
