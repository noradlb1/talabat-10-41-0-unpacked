package com.talabat.talabatlife.ui.onBoarding.viewModel;

import android.content.Context;
import buisnessmodels.Customer;
import com.talabat.core.network.network.TalabatAPIBuilder;
import com.talabat.talabatcore.platform.NetworkHandler;
import com.talabat.talabatlife.features.subscription.GetSubscriptionPaymentUseCase;
import com.talabat.talabatlife.features.subscription.GetTLifeOnBoardingPlans;
import com.talabat.talabatlife.features.subscription.network.SubscriptionService;
import com.talabat.talabatlife.features.subscription.repository.SubscriptionRepositoryImpl;
import com.talabat.talabatlife.features.vendors.GetVendorsList;
import com.talabat.talabatlife.features.vendors.network.VendorsService;
import com.talabat.talabatlife.features.waitList.GetUserWaitListState;
import com.talabat.talabatlife.features.waitList.JoinWaitList;
import com.talabat.talabatlife.features.waitList.network.WaitListService;
import com.talabat.talabatlife.tracking.LifeOnBoardingLoadedUseCase;
import com.talabat.talabatlife.tracking.SubscribeClickedUseCase;
import com.talabat.talabatlife.tracking.SubscriptionAttemptedUseCase;
import com.talabat.talabatlife.tracking.SubscriptionCompletedUseCase;
import com.talabat.talabatlife.tracking.SubscriptionFailedUseCase;
import com.tracking.Tracker;
import com.tracking.impl.FirebaseTracker;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/talabat/talabatlife/ui/onBoarding/viewModel/TLifeOnBoardingViewModelBuilder;", "", "()V", "Companion", "com_talabat_NewArchi_TalabatLife_TalabatLife"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TLifeOnBoardingViewModelBuilder {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0014\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nH\u0002J\b\u0010\r\u001a\u00020\u000eH\u0002¨\u0006\u000f"}, d2 = {"Lcom/talabat/talabatlife/ui/onBoarding/viewModel/TLifeOnBoardingViewModelBuilder$Companion;", "", "()V", "getTLifeOnBoardingViewModel", "Lcom/talabat/talabatlife/ui/onBoarding/viewModel/TLifeOnBoardingViewModel;", "context", "Landroid/content/Context;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "provideCurrencyFormatter", "Lkotlin/Function1;", "", "", "provideTracker", "Lcom/tracking/Tracker;", "com_talabat_NewArchi_TalabatLife_TalabatLife"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final Function1<Float, String> provideCurrencyFormatter() {
            return TLifeOnBoardingViewModelBuilder$Companion$provideCurrencyFormatter$1.INSTANCE;
        }

        private final Tracker provideTracker() {
            return new FirebaseTracker();
        }

        @NotNull
        public final TLifeOnBoardingViewModel getTLifeOnBoardingViewModel(@NotNull Context context, @NotNull CoroutineScope coroutineScope) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
            GetVendorsList getVendorsList = new GetVendorsList(new NetworkHandler(context), new VendorsService(new TalabatAPIBuilder()), coroutineScope, Dispatchers.getMain());
            GetTLifeOnBoardingPlans getTLifeOnBoardingPlans = new GetTLifeOnBoardingPlans(new SubscriptionRepositoryImpl(new NetworkHandler(context), new SubscriptionService(new TalabatAPIBuilder())), coroutineScope, Dispatchers.getMain());
            GetUserWaitListState getUserWaitListState = new GetUserWaitListState(new NetworkHandler(context), new WaitListService(new TalabatAPIBuilder()), coroutineScope, Dispatchers.getMain());
            JoinWaitList joinWaitList = new JoinWaitList(new NetworkHandler(context), new WaitListService(new TalabatAPIBuilder()), coroutineScope, Dispatchers.getMain());
            GetSubscriptionPaymentUseCase getSubscriptionPaymentUseCase = new GetSubscriptionPaymentUseCase(new SubscriptionRepositoryImpl(new NetworkHandler(context), new SubscriptionService(new TalabatAPIBuilder())), coroutineScope, Dispatchers.getMain());
            CoroutineDispatcher io2 = Dispatchers.getIO();
            Customer instance = Customer.getInstance();
            Intrinsics.checkNotNullExpressionValue(instance, "getInstance()");
            return new TLifeOnBoardingViewModelImpl(getVendorsList, getTLifeOnBoardingPlans, getUserWaitListState, joinWaitList, getSubscriptionPaymentUseCase, new LifeOnBoardingLoadedUseCase(coroutineScope, io2, instance), new SubscribeClickedUseCase(coroutineScope, Dispatchers.getIO(), provideTracker(), provideCurrencyFormatter()), new SubscriptionAttemptedUseCase(coroutineScope, Dispatchers.getIO(), provideTracker(), provideCurrencyFormatter()), new SubscriptionCompletedUseCase(coroutineScope, Dispatchers.getIO(), provideTracker(), provideCurrencyFormatter()), new SubscriptionFailedUseCase(coroutineScope, Dispatchers.getIO(), provideTracker(), provideCurrencyFormatter()));
        }
    }
}
