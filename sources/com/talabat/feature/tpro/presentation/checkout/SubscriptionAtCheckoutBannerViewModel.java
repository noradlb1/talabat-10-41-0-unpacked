package com.talabat.feature.tpro.presentation.checkout;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import buisnessmodels.Cart;
import buisnessmodels.Customer;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.feature.subscriptions.domain.ISubscriptionStatusRepository;
import com.talabat.feature.subscriptions.domain.ISubscriptionsTracker;
import com.talabat.feature.subscriptions.domain.model.Subscription;
import com.talabat.feature.subscriptions.domain.model.SubscriptionMultiPlan;
import com.talabat.feature.tpro.presentation.benefits.viewmodel.MultiPlanParams;
import com.talabat.feature.tpro.presentation.model.SubscriptionsErrorDisplayModel;
import datamodels.Restaurant;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \"2\u00020\u0001:\u0001\"B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u000e\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u0011J\u0018\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\b\u0010 \u001a\u00020\u0011H\u0002J\u0006\u0010\u0018\u001a\u00020!R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\f¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u000fR\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/talabat/feature/tpro/presentation/checkout/SubscriptionAtCheckoutBannerViewModel;", "Landroidx/lifecycle/ViewModel;", "multiPlanParams", "Lcom/talabat/feature/tpro/presentation/benefits/viewmodel/MultiPlanParams;", "configurationLocalRepository", "Lcom/talabat/configuration/ConfigurationLocalRepository;", "subscriptionStatusRepository", "Lcom/talabat/feature/subscriptions/domain/ISubscriptionStatusRepository;", "subscriptionsTracker", "Lcom/talabat/feature/subscriptions/domain/ISubscriptionsTracker;", "(Lcom/talabat/feature/tpro/presentation/benefits/viewmodel/MultiPlanParams;Lcom/talabat/configuration/ConfigurationLocalRepository;Lcom/talabat/feature/subscriptions/domain/ISubscriptionStatusRepository;Lcom/talabat/feature/subscriptions/domain/ISubscriptionsTracker;)V", "displayError", "Landroidx/lifecycle/MutableLiveData;", "Lcom/talabat/feature/tpro/presentation/model/SubscriptionsErrorDisplayModel;", "getDisplayError", "()Landroidx/lifecycle/MutableLiveData;", "showBanner", "", "getShowBanner", "()Z", "setShowBanner", "(Z)V", "subscriptionMultiPlan", "Lcom/talabat/feature/subscriptions/domain/model/SubscriptionMultiPlan;", "getSubscriptionMultiPlan", "arrangeBannerVisibility", "doesMyBasketMeetsMOV", "checkDeliveryValue", "restaurant", "Ldatamodels/Restaurant;", "cart", "Lbuisnessmodels/Cart;", "checkIfUserNotTriedProBefore", "", "Companion", "com_talabat_feature_tpro_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SubscriptionAtCheckoutBannerViewModel extends ViewModel {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String REQUESTING_PAGE_NAME = "subscription-checkout";
    @NotNull
    public static final String TPRO_CHECKOUT_SCREEN_NAME = "Checkout";
    @NotNull
    public static final String TPRO_CHECKOUT_SCREEN_TYPE = "checkout";
    /* access modifiers changed from: private */
    @NotNull
    public final ConfigurationLocalRepository configurationLocalRepository;
    @NotNull
    private final MutableLiveData<SubscriptionsErrorDisplayModel> displayError = new MutableLiveData<>();
    /* access modifiers changed from: private */
    @NotNull
    public final MultiPlanParams multiPlanParams;
    private boolean showBanner;
    @NotNull
    private final MutableLiveData<SubscriptionMultiPlan> subscriptionMultiPlan = new MutableLiveData<>();
    @NotNull
    private final ISubscriptionStatusRepository subscriptionStatusRepository;
    /* access modifiers changed from: private */
    @NotNull
    public final ISubscriptionsTracker subscriptionsTracker;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/talabat/feature/tpro/presentation/checkout/SubscriptionAtCheckoutBannerViewModel$Companion;", "", "()V", "REQUESTING_PAGE_NAME", "", "TPRO_CHECKOUT_SCREEN_NAME", "TPRO_CHECKOUT_SCREEN_TYPE", "com_talabat_feature_tpro_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Inject
    public SubscriptionAtCheckoutBannerViewModel(@NotNull MultiPlanParams multiPlanParams2, @NotNull ConfigurationLocalRepository configurationLocalRepository2, @NotNull ISubscriptionStatusRepository iSubscriptionStatusRepository, @NotNull ISubscriptionsTracker iSubscriptionsTracker) {
        Intrinsics.checkNotNullParameter(multiPlanParams2, "multiPlanParams");
        Intrinsics.checkNotNullParameter(configurationLocalRepository2, "configurationLocalRepository");
        Intrinsics.checkNotNullParameter(iSubscriptionStatusRepository, "subscriptionStatusRepository");
        Intrinsics.checkNotNullParameter(iSubscriptionsTracker, "subscriptionsTracker");
        this.multiPlanParams = multiPlanParams2;
        this.configurationLocalRepository = configurationLocalRepository2;
        this.subscriptionStatusRepository = iSubscriptionStatusRepository;
        this.subscriptionsTracker = iSubscriptionsTracker;
    }

    private final boolean checkDeliveryValue(Restaurant restaurant, Cart cart) {
        return restaurant.deliveryCharges > 0.0f || cart.getDeliveryCharges() > 0.0f;
    }

    private final boolean checkIfUserNotTriedProBefore() {
        boolean z11;
        List<Subscription> subscriptionsList = this.subscriptionStatusRepository.getSubscriptionsList();
        if (subscriptionsList == null) {
            subscriptionsList = CollectionsKt__CollectionsKt.emptyList();
        }
        if (subscriptionsList.isEmpty()) {
            return true;
        }
        if (subscriptionsList.size() == 1) {
            if (subscriptionsList.get(0).getMembershipId().length() == 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                return true;
            }
        }
        return false;
    }

    public final boolean arrangeBannerVisibility(boolean z11) {
        boolean z12;
        boolean checkIfUserNotTriedProBefore = checkIfUserNotTriedProBefore();
        Cart instance = Cart.getInstance();
        Customer instance2 = Customer.getInstance();
        Restaurant restaurant = instance.getRestaurant();
        Intrinsics.checkNotNullExpressionValue(restaurant, "cart.restaurant");
        Intrinsics.checkNotNullExpressionValue(instance, "cart");
        boolean checkDeliveryValue = checkDeliveryValue(restaurant, instance);
        if (!instance2.isLoggedIn() || instance2.isTPro().booleanValue() || !checkIfUserNotTriedProBefore || instance2.getSavedCards() == null || instance2.getSavedCards().size() <= 0 || instance.getOrderDeliveryMode() != 0 || !checkDeliveryValue || !instance.getRestaurant().isProRestaurant || !instance.getRestaurant().acceptsCredit || !z11) {
            z12 = false;
        } else {
            z12 = true;
        }
        this.showBanner = z12;
        return z12;
    }

    @NotNull
    public final MutableLiveData<SubscriptionsErrorDisplayModel> getDisplayError() {
        return this.displayError;
    }

    public final boolean getShowBanner() {
        return this.showBanner;
    }

    @NotNull
    public final MutableLiveData<SubscriptionMultiPlan> getSubscriptionMultiPlan() {
        return this.subscriptionMultiPlan;
    }

    public final void setShowBanner(boolean z11) {
        this.showBanner = z11;
    }

    /* renamed from: getSubscriptionMultiPlan  reason: collision with other method in class */
    public final void m10376getSubscriptionMultiPlan() {
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new SubscriptionAtCheckoutBannerViewModel$getSubscriptionMultiPlan$1(this, (Continuation<? super SubscriptionAtCheckoutBannerViewModel$getSubscriptionMultiPlan$1>) null), 3, (Object) null);
    }
}
