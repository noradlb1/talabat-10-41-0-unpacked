package com.talabat.wallet.bnplmanager.presentation.viewmodel;

import JsonModels.PlaceOrderResponse;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import buisnessmodels.Cart;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.talabatcommon.extentions.FloatKt;
import com.talabat.talabatcommon.extentions.StringUtils;
import com.talabat.talabatcommon.utils.CurrencyFormatter;
import com.talabat.talabatcommon.utils.DateConstants;
import com.talabat.talabatcommon.utils.DateUtils;
import com.talabat.talabatnavigation.tLife.TLifeNavigationActions;
import com.talabat.wallet.bnplmanager.data.remote.dto.request.BNPLOrderPaymentRequestDto;
import com.talabat.wallet.bnplmanager.domain.business.usecase.GetBNPLInstallmentsUseCase;
import com.talabat.wallet.bnplmanager.domain.business.usecase.GetPayOrderWithBNPLUseCase;
import com.talabat.wallet.bnplmanager.domain.business.usecase.IsUserEligibleForBNPLPaymentFallbackUseCase;
import com.talabat.wallet.bnplmanager.domain.business.usecase.SetIsUserSeenBNPLPaymentFallbackOptionUseCase;
import com.talabat.wallet.bnplmanager.domain.entity.BNPLFakeDoorTestAttemptedState;
import com.talabat.wallet.bnplmanager.domain.entity.BNPLInstallmentToggleStatus;
import com.talabat.wallet.bnplmanager.domain.entity.BNPLPaymentDetailsDisplayModel;
import com.talabat.wallet.bnplmanager.domain.entity.BNPLPaymentFallbackEligibleStatus;
import com.talabat.wallet.bnplmanager.domain.entity.BNPLPlan;
import com.talabat.wallet.bnplmanager.domain.entity.BNPLTrackingStatus;
import com.talabat.wallet.bnplmanager.domain.entity.BNPLValidationError;
import com.talabat.wallet.bnplmanager.domain.entity.InstallmentDetail;
import com.talabat.wallet.bnplmanager.domain.tracking.BNPLTracker;
import com.talabat.wallet.bnplmanager.presentation.displaymodel.BNPLOrderPaymentState;
import com.talabat.wallet.bnplmanager.presentation.displaymodel.BNPLPaymentDetailsState;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tracking.models.pay.BNPLOrderPaymentFailureTrackingModel;

@Metadata(d1 = {"\u0000Ô\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 d2\u00020\u0001:\u0001dB9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000eJ5\u00103\u001a\b\u0012\u0004\u0012\u000205042\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020;2\b\u0010<\u001a\u0004\u0018\u00010=H\u0002¢\u0006\u0002\u0010>J\u000e\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020@J\u0018\u0010B\u001a\u00020@2\u0006\u0010C\u001a\u0002092\u0006\u0010D\u001a\u000209H\u0002J\u0016\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020@J\u000e\u0010J\u001a\u00020F2\u0006\u0010K\u001a\u00020@J\u0016\u0010L\u001a\u00020F2\u0006\u0010M\u001a\u00020)2\u0006\u0010N\u001a\u00020)J\u000e\u0010O\u001a\u00020F2\u0006\u0010P\u001a\u00020QJ\u0006\u0010R\u001a\u00020FJ\u0006\u0010S\u001a\u00020FJ\u0016\u0010T\u001a\u00020F2\u0006\u0010U\u001a\u00020=2\u0006\u0010V\u001a\u00020WJ\"\u0010X\u001a\u00020F2\b\u0010Y\u001a\u0004\u0018\u00010Z2\u0006\u00106\u001a\u0002072\b\u0010[\u001a\u0004\u0018\u00010\\J\u000e\u0010]\u001a\u00020F2\u0006\u0010K\u001a\u00020@J\u0006\u0010^\u001a\u00020FJ\u000e\u0010_\u001a\u00020F2\u0006\u0010`\u001a\u00020;J\u000e\u0010a\u001a\u00020F2\u0006\u0010b\u001a\u00020cR\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0013R\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0013R\u001a\u0010\u001d\u001a\u00020\u001eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u0017\u0010#\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0010¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0013R\u0017\u0010%\u001a\b\u0012\u0004\u0012\u00020&0\u0010¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0013R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010(\u001a\u00020)X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010*\"\u0004\b+\u0010,R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u001c\u0010-\u001a\u0004\u0018\u00010.X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0004¢\u0006\u0002\n\u0000¨\u0006e"}, d2 = {"Lcom/talabat/wallet/bnplmanager/presentation/viewmodel/BNPLManagerViewModel;", "Landroidx/lifecycle/ViewModel;", "bnplTracker", "Lcom/talabat/wallet/bnplmanager/domain/tracking/BNPLTracker;", "getBNPLInstallmentsUseCase", "Lcom/talabat/wallet/bnplmanager/domain/business/usecase/GetBNPLInstallmentsUseCase;", "getPayOrderWithBNPLUseCase", "Lcom/talabat/wallet/bnplmanager/domain/business/usecase/GetPayOrderWithBNPLUseCase;", "locationConfigurationRepository", "Lcom/talabat/configuration/location/LocationConfigurationRepository;", "isUserEligibleForBNPLPaymentFallbackUseCase", "Lcom/talabat/wallet/bnplmanager/domain/business/usecase/IsUserEligibleForBNPLPaymentFallbackUseCase;", "setIsUserSeenBNPLPaymentFallbackOptionUseCase", "Lcom/talabat/wallet/bnplmanager/domain/business/usecase/SetIsUserSeenBNPLPaymentFallbackOptionUseCase;", "(Lcom/talabat/wallet/bnplmanager/domain/tracking/BNPLTracker;Lcom/talabat/wallet/bnplmanager/domain/business/usecase/GetBNPLInstallmentsUseCase;Lcom/talabat/wallet/bnplmanager/domain/business/usecase/GetPayOrderWithBNPLUseCase;Lcom/talabat/configuration/location/LocationConfigurationRepository;Lcom/talabat/wallet/bnplmanager/domain/business/usecase/IsUserEligibleForBNPLPaymentFallbackUseCase;Lcom/talabat/wallet/bnplmanager/domain/business/usecase/SetIsUserSeenBNPLPaymentFallbackOptionUseCase;)V", "bNPLOrderPaymentData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/talabat/wallet/bnplmanager/presentation/displaymodel/BNPLOrderPaymentState;", "getBNPLOrderPaymentData", "()Landroidx/lifecycle/MutableLiveData;", "bNPLPaymentDetailsStateData", "Lcom/talabat/wallet/bnplmanager/presentation/displaymodel/BNPLPaymentDetailsState;", "getBNPLPaymentDetailsStateData", "bNPLPaymentFallbackEligibleStateData", "Lcom/talabat/wallet/bnplmanager/domain/entity/BNPLPaymentFallbackEligibleStatus;", "getBNPLPaymentFallbackEligibleStateData", "bnplFakeTestAttemptedData", "Lcom/talabat/wallet/bnplmanager/domain/entity/BNPLFakeDoorTestAttemptedState;", "getBnplFakeTestAttemptedData", "bnplInstallmentToggleStatus", "Lcom/talabat/wallet/bnplmanager/domain/entity/BNPLInstallmentToggleStatus;", "getBnplInstallmentToggleStatus", "()Lcom/talabat/wallet/bnplmanager/domain/entity/BNPLInstallmentToggleStatus;", "setBnplInstallmentToggleStatus", "(Lcom/talabat/wallet/bnplmanager/domain/entity/BNPLInstallmentToggleStatus;)V", "bnplInstallmentToggleStatusData", "getBnplInstallmentToggleStatusData", "bnplPaymentDetailsDisplayModelData", "Lcom/talabat/wallet/bnplmanager/domain/entity/BNPLPaymentDetailsDisplayModel;", "getBnplPaymentDetailsDisplayModelData", "isBNPLPlaceOrderClicked", "", "()Z", "setBNPLPlaceOrderClicked", "(Z)V", "orderResponse", "LJsonModels/PlaceOrderResponse;", "getOrderResponse", "()LJsonModels/PlaceOrderResponse;", "setOrderResponse", "(LJsonModels/PlaceOrderResponse;)V", "getBNPLInstallmentDetails", "", "Lcom/talabat/wallet/bnplmanager/domain/entity/InstallmentDetail;", "currentDate", "Ljava/util/Date;", "dueDateInterval", "", "numberOfInstallment", "", "orderInstallmentAmount", "", "(Ljava/util/Date;JILjava/lang/Float;)Ljava/util/List;", "getBNPLTermsAndConditionUrl", "", "url", "getDisplayDueDate", "currentTime", "dueDateDuration", "onBNPLErrorEventLoaded", "", "bNPLValidationError", "Lcom/talabat/wallet/bnplmanager/domain/entity/BNPLValidationError;", "eventName", "onBNPLFakeTestBottomSheetOpen", "screenName", "onBNPLFakeTestSubmitted", "isBNPLNotify", "isBNPLFeedback", "onBNPLOrderPaymentError", "bNPLOrderPaymentFailureTrackingModel", "Ltracking/models/pay/BNPLOrderPaymentFailureTrackingModel;", "onBnplFallbackOptionShown", "onBnplToggleClicked", "onFetchBNPLPaymentDetails", "amount", "plan", "Lcom/talabat/wallet/bnplmanager/domain/entity/BNPLPlan;", "onLoadPaymentDetailLoaded", "status", "Lcom/talabat/wallet/bnplmanager/domain/entity/BNPLTrackingStatus;", "cart", "Lbuisnessmodels/Cart;", "onPaymentMethodChanged", "onPlaceFakeOrder", "onPlaceOrderFailedWithPaymentMethodError", "selectedPaymentMethod", "payOrderWithBNPL", "bNPLOrderPaymentRequestDto", "Lcom/talabat/wallet/bnplmanager/data/remote/dto/request/BNPLOrderPaymentRequestDto;", "Companion", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BNPLManagerViewModel extends ViewModel {
    @NotNull
    @Deprecated
    public static final String BNPL_ADDITIONAL_PAYMENT_METHOD = "{pm}";
    @NotNull
    @Deprecated
    public static final String BNPL_PAYMENT_METHOD = "{type}";
    @Deprecated
    public static final int BNPL_TERMS_AND_CONDITION_QUERY_VALUE = 5;
    @NotNull
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    @Deprecated
    public static final String DUE_DATE_DISPLAY_FORMAT = "dd LLLL yyyy";
    @Deprecated
    public static final long ONE_DAY_IN_MILLI_SECONDS = 86400000;
    @NotNull
    private final MutableLiveData<BNPLOrderPaymentState> bNPLOrderPaymentData = new MutableLiveData<>();
    @NotNull
    private final MutableLiveData<BNPLPaymentDetailsState> bNPLPaymentDetailsStateData = new MutableLiveData<>();
    @NotNull
    private final MutableLiveData<BNPLPaymentFallbackEligibleStatus> bNPLPaymentFallbackEligibleStateData = new MutableLiveData<>();
    @NotNull
    private final MutableLiveData<BNPLFakeDoorTestAttemptedState> bnplFakeTestAttemptedData = new MutableLiveData<>();
    @NotNull
    private BNPLInstallmentToggleStatus bnplInstallmentToggleStatus = BNPLInstallmentToggleStatus.CLOSE_INSTALLMENT;
    @NotNull
    private final MutableLiveData<BNPLInstallmentToggleStatus> bnplInstallmentToggleStatusData = new MutableLiveData<>();
    @NotNull
    private final MutableLiveData<BNPLPaymentDetailsDisplayModel> bnplPaymentDetailsDisplayModelData = new MutableLiveData<>();
    @NotNull
    private final BNPLTracker bnplTracker;
    /* access modifiers changed from: private */
    @NotNull
    public final GetBNPLInstallmentsUseCase getBNPLInstallmentsUseCase;
    /* access modifiers changed from: private */
    @NotNull
    public final GetPayOrderWithBNPLUseCase getPayOrderWithBNPLUseCase;
    private boolean isBNPLPlaceOrderClicked;
    /* access modifiers changed from: private */
    @Nullable
    public final IsUserEligibleForBNPLPaymentFallbackUseCase isUserEligibleForBNPLPaymentFallbackUseCase;
    /* access modifiers changed from: private */
    @NotNull
    public final LocationConfigurationRepository locationConfigurationRepository;
    @Nullable
    private PlaceOrderResponse orderResponse;
    /* access modifiers changed from: private */
    @Nullable
    public final SetIsUserSeenBNPLPaymentFallbackOptionUseCase setIsUserSeenBNPLPaymentFallbackOptionUseCase;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nXT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/talabat/wallet/bnplmanager/presentation/viewmodel/BNPLManagerViewModel$Companion;", "", "()V", "BNPL_ADDITIONAL_PAYMENT_METHOD", "", "BNPL_PAYMENT_METHOD", "BNPL_TERMS_AND_CONDITION_QUERY_VALUE", "", "DUE_DATE_DISPLAY_FORMAT", "ONE_DAY_IN_MILLI_SECONDS", "", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public BNPLManagerViewModel(@NotNull BNPLTracker bNPLTracker, @NotNull GetBNPLInstallmentsUseCase getBNPLInstallmentsUseCase2, @NotNull GetPayOrderWithBNPLUseCase getPayOrderWithBNPLUseCase2, @NotNull LocationConfigurationRepository locationConfigurationRepository2, @Nullable IsUserEligibleForBNPLPaymentFallbackUseCase isUserEligibleForBNPLPaymentFallbackUseCase2, @Nullable SetIsUserSeenBNPLPaymentFallbackOptionUseCase setIsUserSeenBNPLPaymentFallbackOptionUseCase2) {
        Intrinsics.checkNotNullParameter(bNPLTracker, "bnplTracker");
        Intrinsics.checkNotNullParameter(getBNPLInstallmentsUseCase2, "getBNPLInstallmentsUseCase");
        Intrinsics.checkNotNullParameter(getPayOrderWithBNPLUseCase2, "getPayOrderWithBNPLUseCase");
        Intrinsics.checkNotNullParameter(locationConfigurationRepository2, "locationConfigurationRepository");
        this.bnplTracker = bNPLTracker;
        this.getBNPLInstallmentsUseCase = getBNPLInstallmentsUseCase2;
        this.getPayOrderWithBNPLUseCase = getPayOrderWithBNPLUseCase2;
        this.locationConfigurationRepository = locationConfigurationRepository2;
        this.isUserEligibleForBNPLPaymentFallbackUseCase = isUserEligibleForBNPLPaymentFallbackUseCase2;
        this.setIsUserSeenBNPLPaymentFallbackOptionUseCase = setIsUserSeenBNPLPaymentFallbackOptionUseCase2;
    }

    private final List<InstallmentDetail> getBNPLInstallmentDetails(Date date, long j11, int i11, Float f11) {
        ArrayList arrayList = new ArrayList();
        long time = date.getTime();
        for (int i12 = 0; i12 < i11; i12++) {
            InstallmentDetail installmentDetail = new InstallmentDetail();
            if (f11 != null) {
                installmentDetail.setAmount(f11.floatValue());
            }
            installmentDetail.setPaymentDate(getDisplayDueDate(time, j11));
            Unit unit = Unit.INSTANCE;
            arrayList.add(i12, installmentDetail);
            time += j11;
        }
        return arrayList;
    }

    private final String getDisplayDueDate(long j11, long j12) {
        return DateUtils.Companion.convertFromDateToString(new Date(j11 + j12), DateConstants.DEFAULT_UTC_FORMAT);
    }

    @NotNull
    public final MutableLiveData<BNPLOrderPaymentState> getBNPLOrderPaymentData() {
        return this.bNPLOrderPaymentData;
    }

    @NotNull
    public final MutableLiveData<BNPLPaymentDetailsState> getBNPLPaymentDetailsStateData() {
        return this.bNPLPaymentDetailsStateData;
    }

    @NotNull
    public final MutableLiveData<BNPLPaymentFallbackEligibleStatus> getBNPLPaymentFallbackEligibleStateData() {
        return this.bNPLPaymentFallbackEligibleStateData;
    }

    @NotNull
    public final String getBNPLTermsAndConditionUrl(@NotNull String str) {
        Object obj;
        Intrinsics.checkNotNullParameter(str, "url");
        try {
            Result.Companion companion = Result.Companion;
            obj = Result.m6329constructorimpl(StringsKt__StringsJVMKt.replace$default(StringsKt__StringsJVMKt.replace$default(str, BNPL_PAYMENT_METHOD, "5", false, 4, (Object) null), BNPL_ADDITIONAL_PAYMENT_METHOD, ExifInterface.GPS_MEASUREMENT_2D, false, 4, (Object) null));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m6329constructorimpl(ResultKt.createFailure(th2));
        }
        if (Result.m6332exceptionOrNullimpl(obj) != null) {
            obj = StringUtils.empty(StringCompanionObject.INSTANCE);
        }
        return (String) obj;
    }

    @NotNull
    public final MutableLiveData<BNPLFakeDoorTestAttemptedState> getBnplFakeTestAttemptedData() {
        return this.bnplFakeTestAttemptedData;
    }

    @NotNull
    public final BNPLInstallmentToggleStatus getBnplInstallmentToggleStatus() {
        return this.bnplInstallmentToggleStatus;
    }

    @NotNull
    public final MutableLiveData<BNPLInstallmentToggleStatus> getBnplInstallmentToggleStatusData() {
        return this.bnplInstallmentToggleStatusData;
    }

    @NotNull
    public final MutableLiveData<BNPLPaymentDetailsDisplayModel> getBnplPaymentDetailsDisplayModelData() {
        return this.bnplPaymentDetailsDisplayModelData;
    }

    @Nullable
    public final PlaceOrderResponse getOrderResponse() {
        return this.orderResponse;
    }

    public final boolean isBNPLPlaceOrderClicked() {
        return this.isBNPLPlaceOrderClicked;
    }

    public final void onBNPLErrorEventLoaded(@NotNull BNPLValidationError bNPLValidationError, @NotNull String str) {
        Intrinsics.checkNotNullParameter(bNPLValidationError, "bNPLValidationError");
        Intrinsics.checkNotNullParameter(str, "eventName");
        this.bnplTracker.onBNPLError(bNPLValidationError, str);
    }

    public final void onBNPLFakeTestBottomSheetOpen(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "screenName");
        this.bnplTracker.onBNPLPlaceOrderBottomSheetOpen(str);
    }

    public final void onBNPLFakeTestSubmitted(boolean z11, boolean z12) {
        this.bnplTracker.onBNPLFakeTestSubmitted(z11, z12);
    }

    public final void onBNPLOrderPaymentError(@NotNull BNPLOrderPaymentFailureTrackingModel bNPLOrderPaymentFailureTrackingModel) {
        Intrinsics.checkNotNullParameter(bNPLOrderPaymentFailureTrackingModel, "bNPLOrderPaymentFailureTrackingModel");
        this.bnplTracker.onBNPLOrderPaymentFailure(bNPLOrderPaymentFailureTrackingModel);
    }

    public final void onBnplFallbackOptionShown() {
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new BNPLManagerViewModel$onBnplFallbackOptionShown$1(this, (Continuation<? super BNPLManagerViewModel$onBnplFallbackOptionShown$1>) null), 3, (Object) null);
    }

    public final void onBnplToggleClicked() {
        BNPLInstallmentToggleStatus bNPLInstallmentToggleStatus = this.bnplInstallmentToggleStatus;
        BNPLInstallmentToggleStatus bNPLInstallmentToggleStatus2 = BNPLInstallmentToggleStatus.CLOSE_INSTALLMENT;
        if (bNPLInstallmentToggleStatus == bNPLInstallmentToggleStatus2) {
            MutableLiveData<BNPLInstallmentToggleStatus> mutableLiveData = this.bnplInstallmentToggleStatusData;
            bNPLInstallmentToggleStatus2 = BNPLInstallmentToggleStatus.OPEN_INSTALLMENT;
            mutableLiveData.postValue(bNPLInstallmentToggleStatus2);
        } else {
            this.bnplInstallmentToggleStatusData.postValue(bNPLInstallmentToggleStatus2);
        }
        this.bnplInstallmentToggleStatus = bNPLInstallmentToggleStatus2;
    }

    public final void onFetchBNPLPaymentDetails(float f11, @NotNull BNPLPlan bNPLPlan) {
        Intrinsics.checkNotNullParameter(bNPLPlan, TLifeNavigationActions.EXTRA_PLAN);
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new BNPLManagerViewModel$onFetchBNPLPaymentDetails$1(this, bNPLPlan, f11, (Continuation<? super BNPLManagerViewModel$onFetchBNPLPaymentDetails$1>) null), 3, (Object) null);
    }

    public final void onLoadPaymentDetailLoaded(@Nullable BNPLTrackingStatus bNPLTrackingStatus, @NotNull Date date, @Nullable Cart cart) {
        Float f11;
        Intrinsics.checkNotNullParameter(date, "currentDate");
        if (bNPLTrackingStatus != null) {
            Float f12 = null;
            if (cart != null) {
                f11 = Float.valueOf(cart.getCartTotalPrice() / ((float) bNPLTrackingStatus.getNumberOfPayments()));
            } else {
                f11 = null;
            }
            String displayDueDate = getDisplayDueDate(date.getTime(), ((long) (bNPLTrackingStatus.getIntervals() * bNPLTrackingStatus.getNumberOfPayments())) * 86400000);
            MutableLiveData<BNPLPaymentDetailsDisplayModel> mutableLiveData = this.bnplPaymentDetailsDisplayModelData;
            BNPLPaymentDetailsDisplayModel bNPLPaymentDetailsDisplayModel = new BNPLPaymentDetailsDisplayModel();
            CurrencyFormatter.Companion companion = CurrencyFormatter.Companion;
            LocationConfigurationRepository locationConfigurationRepository2 = this.locationConfigurationRepository;
            if (cart != null) {
                f12 = Float.valueOf(cart.getCartTotalPrice());
            }
            bNPLPaymentDetailsDisplayModel.setOrderAmount(companion.formatAmount(locationConfigurationRepository2, FloatKt.orZero(f12), true));
            bNPLPaymentDetailsDisplayModel.setDueToday(companion.formatAmount(this.locationConfigurationRepository, 0.0f, true));
            bNPLPaymentDetailsDisplayModel.setDueDate(DateUtils.Companion.getLocalizedFormattedDateString(displayDueDate, "dd LLLL yyyy"));
            bNPLPaymentDetailsDisplayModel.setInstallmentDetailList(getBNPLInstallmentDetails(date, ((long) bNPLTrackingStatus.getIntervals()) * 86400000, bNPLTrackingStatus.getNumberOfPayments(), f11));
            if (f11 != null) {
                bNPLPaymentDetailsDisplayModel.setInstallmentAmount(companion.formatAmount(this.locationConfigurationRepository, f11.floatValue(), true));
            }
            mutableLiveData.postValue(bNPLPaymentDetailsDisplayModel);
        }
    }

    public final void onPaymentMethodChanged(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "screenName");
        this.bnplTracker.onPaymentMethodChanged(str);
    }

    public final void onPlaceFakeOrder() {
        this.bnplTracker.onPlaceFakeOrder();
    }

    public final void onPlaceOrderFailedWithPaymentMethodError(int i11) {
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new BNPLManagerViewModel$onPlaceOrderFailedWithPaymentMethodError$1(this, i11, (Continuation<? super BNPLManagerViewModel$onPlaceOrderFailedWithPaymentMethodError$1>) null), 3, (Object) null);
    }

    public final void payOrderWithBNPL(@NotNull BNPLOrderPaymentRequestDto bNPLOrderPaymentRequestDto) {
        Intrinsics.checkNotNullParameter(bNPLOrderPaymentRequestDto, "bNPLOrderPaymentRequestDto");
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new BNPLManagerViewModel$payOrderWithBNPL$1(this, bNPLOrderPaymentRequestDto, (Continuation<? super BNPLManagerViewModel$payOrderWithBNPL$1>) null), 3, (Object) null);
    }

    public final void setBNPLPlaceOrderClicked(boolean z11) {
        this.isBNPLPlaceOrderClicked = z11;
    }

    public final void setBnplInstallmentToggleStatus(@NotNull BNPLInstallmentToggleStatus bNPLInstallmentToggleStatus) {
        Intrinsics.checkNotNullParameter(bNPLInstallmentToggleStatus, "<set-?>");
        this.bnplInstallmentToggleStatus = bNPLInstallmentToggleStatus;
    }

    public final void setOrderResponse(@Nullable PlaceOrderResponse placeOrderResponse) {
        this.orderResponse = placeOrderResponse;
    }
}
