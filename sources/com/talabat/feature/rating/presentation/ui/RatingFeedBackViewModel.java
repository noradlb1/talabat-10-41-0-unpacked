package com.talabat.feature.rating.presentation.ui;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.talabat.feature.rating.domain.EventTracker;
import com.talabat.feature.rating.domain.RatingDataManager;
import com.talabat.feature.rating.domain.model.RateOrderEventModel;
import com.talabat.feature.rating.domain.model.RateOrderRequest;
import com.talabat.feature.rating.domain.model.RatingReasonsData;
import com.talabat.feature.rating.domain.repo.RatingDataRepository;
import com.talabat.feature.rating.domain.repo.SubmitFeedBackRepository;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.viewModel.SingleLiveEvent;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001B/\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0006\u0010\u0016\u001a\u00020\u0017J\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\u0006\u0010\u001b\u001a\u00020\u001cJ\u0006\u0010\u001d\u001a\u00020\u0017J\u000e\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u001cJ\u000e\u0010\u001f\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u001cJ\u0006\u0010 \u001a\u00020\u001cJ\u0006\u0010!\u001a\u00020\u001cJ\b\u0010\"\u001a\u0004\u0018\u00010\u0017J\u0014\u0010#\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\u0006\u0010\u001b\u001a\u00020\u001cJ\u0006\u0010$\u001a\u00020\u0017J\u000e\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u0017J\u000e\u0010(\u001a\u00020&2\u0006\u0010'\u001a\u00020\u0017J\u000e\u0010)\u001a\u00020&2\u0006\u0010'\u001a\u00020\u0017J\u000e\u0010*\u001a\u00020&2\u0006\u0010'\u001a\u00020\u0017J\u000e\u0010+\u001a\u00020&2\u0006\u0010,\u001a\u00020\u0017J\u000e\u0010-\u001a\u00020&2\u0006\u0010\u001b\u001a\u00020\u001cJ\u000e\u0010.\u001a\u00020&2\u0006\u0010\u001b\u001a\u00020\u001cJ\u0006\u0010/\u001a\u00020&J\u000e\u00100\u001a\u00020&2\u0006\u00101\u001a\u00020\u001aJ\u000e\u00102\u001a\u00020&2\u0006\u00101\u001a\u00020\u001aR\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0011X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0014R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u00063"}, d2 = {"Lcom/talabat/feature/rating/presentation/ui/RatingFeedBackViewModel;", "Landroidx/lifecycle/ViewModel;", "submitFeedBackRepository", "Lcom/talabat/feature/rating/domain/repo/SubmitFeedBackRepository;", "ratingDataRepository", "Lcom/talabat/feature/rating/domain/repo/RatingDataRepository;", "ratingResourceProvider", "Lcom/talabat/feature/rating/presentation/ui/RatingResourceProvider;", "ratingDataManager", "Lcom/talabat/feature/rating/domain/RatingDataManager;", "ratingEventTracker", "Lcom/talabat/feature/rating/domain/EventTracker;", "(Lcom/talabat/feature/rating/domain/repo/SubmitFeedBackRepository;Lcom/talabat/feature/rating/domain/repo/RatingDataRepository;Lcom/talabat/feature/rating/presentation/ui/RatingResourceProvider;Lcom/talabat/feature/rating/domain/RatingDataManager;Lcom/talabat/feature/rating/domain/EventTracker;)V", "_isRatingError", "Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/viewModel/SingleLiveEvent;", "", "_isRatingSuccess", "Landroidx/lifecycle/MutableLiveData;", "isRatingError", "Landroidx/lifecycle/LiveData;", "()Landroidx/lifecycle/LiveData;", "isRatingSuccess", "getDeliveryExperienceTitle", "", "getDeliveryReasonList", "", "Lcom/talabat/feature/rating/domain/model/RatingReasonsData;", "rating", "", "getRatingComment", "getRatingReasonMessage", "getRatingReasonTitle", "getSelectedDeliveryRating", "getSelectedFoodRating", "getVendorLogoUrl", "getVendorReasonList", "getVendorTitle", "onRatingClose", "", "screenName", "onRatingLoaded", "onRatingSubmitError", "onRatingSubmitted", "setRatingComment", "changedText", "setSelectedDeliveryRating", "setSelectedFoodRating", "submitRating", "updateDeliveryReasonsInRateOrderRequest", "ratingReasonsData", "updateVendorReasonsInRateOrderRequest", "com_talabat_feature_rating_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RatingFeedBackViewModel extends ViewModel {
    /* access modifiers changed from: private */
    @NotNull
    public final SingleLiveEvent<Boolean> _isRatingError;
    /* access modifiers changed from: private */
    @NotNull
    public final MutableLiveData<Boolean> _isRatingSuccess;
    @NotNull
    private final LiveData<Boolean> isRatingError;
    @NotNull
    private final LiveData<Boolean> isRatingSuccess;
    /* access modifiers changed from: private */
    @NotNull
    public final RatingDataManager ratingDataManager;
    @NotNull
    private final RatingDataRepository ratingDataRepository;
    @NotNull
    private final EventTracker ratingEventTracker;
    @NotNull
    private final RatingResourceProvider ratingResourceProvider;
    /* access modifiers changed from: private */
    @NotNull
    public final SubmitFeedBackRepository submitFeedBackRepository;

    @Inject
    public RatingFeedBackViewModel(@NotNull SubmitFeedBackRepository submitFeedBackRepository2, @NotNull RatingDataRepository ratingDataRepository2, @NotNull RatingResourceProvider ratingResourceProvider2, @NotNull RatingDataManager ratingDataManager2, @NotNull EventTracker eventTracker) {
        Intrinsics.checkNotNullParameter(submitFeedBackRepository2, "submitFeedBackRepository");
        Intrinsics.checkNotNullParameter(ratingDataRepository2, "ratingDataRepository");
        Intrinsics.checkNotNullParameter(ratingResourceProvider2, "ratingResourceProvider");
        Intrinsics.checkNotNullParameter(ratingDataManager2, "ratingDataManager");
        Intrinsics.checkNotNullParameter(eventTracker, "ratingEventTracker");
        this.submitFeedBackRepository = submitFeedBackRepository2;
        this.ratingDataRepository = ratingDataRepository2;
        this.ratingResourceProvider = ratingResourceProvider2;
        this.ratingDataManager = ratingDataManager2;
        this.ratingEventTracker = eventTracker;
        MutableLiveData<Boolean> mutableLiveData = new MutableLiveData<>();
        this._isRatingSuccess = mutableLiveData;
        this.isRatingSuccess = mutableLiveData;
        SingleLiveEvent<Boolean> singleLiveEvent = new SingleLiveEvent<>();
        this._isRatingError = singleLiveEvent;
        this.isRatingError = singleLiveEvent;
    }

    @NotNull
    public final String getDeliveryExperienceTitle() {
        return this.ratingDataRepository.getDeliveryExperienceTitle();
    }

    @NotNull
    public final List<RatingReasonsData> getDeliveryReasonList(int i11) {
        ArrayList arrayList = new ArrayList();
        for (Object next : this.ratingDataRepository.getDeliveryReasonList()) {
            if (ArraysKt___ArraysKt.contains(((RatingReasonsData) next).getEnableForRating(), i11)) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    @NotNull
    public final String getRatingComment() {
        return this.ratingDataManager.getRatingComment();
    }

    @NotNull
    public final String getRatingReasonMessage(int i11) {
        return this.ratingResourceProvider.getRatingReasonMessage(i11);
    }

    @NotNull
    public final String getRatingReasonTitle(int i11) {
        return this.ratingResourceProvider.getRatingReasonTitle(i11);
    }

    public final int getSelectedDeliveryRating() {
        return this.ratingDataManager.getSelectedDeliveryRating();
    }

    public final int getSelectedFoodRating() {
        return this.ratingDataManager.getSelectedFoodRating();
    }

    @Nullable
    public final String getVendorLogoUrl() {
        return this.ratingDataRepository.getVendorLogoUrl();
    }

    @NotNull
    public final List<RatingReasonsData> getVendorReasonList(int i11) {
        ArrayList arrayList = new ArrayList();
        for (Object next : this.ratingDataRepository.getVendorReasonList()) {
            if (ArraysKt___ArraysKt.contains(((RatingReasonsData) next).getEnableForRating(), i11)) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    @NotNull
    public final String getVendorTitle() {
        return this.ratingDataRepository.getVendorTitle();
    }

    @NotNull
    public final LiveData<Boolean> isRatingError() {
        return this.isRatingError;
    }

    @NotNull
    public final LiveData<Boolean> isRatingSuccess() {
        return this.isRatingSuccess;
    }

    public final void onRatingClose(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "screenName");
        this.ratingEventTracker.orderRateClosed(RateOrderEventModel.copy$default(this.ratingDataManager.getTrackingData(), (String) null, (String) null, (String) null, (String) null, str, (String) null, (String) null, 111, (Object) null));
    }

    public final void onRatingLoaded(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "screenName");
        this.ratingEventTracker.orderRateLoaded(RateOrderEventModel.copy$default(this.ratingDataManager.getTrackingData(), (String) null, (String) null, (String) null, (String) null, str, (String) null, (String) null, 111, (Object) null));
    }

    public final void onRatingSubmitError(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "screenName");
        this.ratingEventTracker.orderRateSubmitError(RateOrderEventModel.copy$default(this.ratingDataManager.getTrackingData(), (String) null, (String) null, (String) null, (String) null, str, (String) null, (String) null, 111, (Object) null));
    }

    public final void onRatingSubmitted(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "screenName");
        this.ratingEventTracker.orderRateSubmitted(RateOrderEventModel.copy$default(this.ratingDataManager.getTrackingData(), (String) null, (String) null, (String) null, (String) null, str, (String) null, (String) null, 111, (Object) null));
    }

    public final void setRatingComment(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "changedText");
        RateOrderRequest rateOrderRequest = this.ratingDataManager.getRateOrderRequest();
        if (rateOrderRequest != null) {
            rateOrderRequest.setReview(str);
        }
        this.ratingDataManager.setRatingComment(str);
    }

    public final void setSelectedDeliveryRating(int i11) {
        this.ratingDataManager.setSelectedDeliveryRating(i11);
        RateOrderRequest rateOrderRequest = this.ratingDataManager.getRateOrderRequest();
        if (rateOrderRequest != null) {
            rateOrderRequest.setDeliveryRating(String.valueOf(i11));
        }
    }

    public final void setSelectedFoodRating(int i11) {
        this.ratingDataManager.setSelectedFoodRating(i11);
        RateOrderRequest rateOrderRequest = this.ratingDataManager.getRateOrderRequest();
        if (rateOrderRequest != null) {
            rateOrderRequest.setVendorRating(String.valueOf(i11));
        }
    }

    public final void submitRating() {
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new RatingFeedBackViewModel$submitRating$1(this, (Continuation<? super RatingFeedBackViewModel$submitRating$1>) null), 3, (Object) null);
    }

    public final void updateDeliveryReasonsInRateOrderRequest(@NotNull RatingReasonsData ratingReasonsData) {
        ArrayList<String> arrayList;
        Intrinsics.checkNotNullParameter(ratingReasonsData, "ratingReasonsData");
        RateOrderRequest rateOrderRequest = this.ratingDataManager.getRateOrderRequest();
        if (rateOrderRequest != null) {
            arrayList = rateOrderRequest.getDeliveryReasons();
        } else {
            arrayList = null;
        }
        if (arrayList != null && arrayList.contains(String.valueOf(ratingReasonsData.getId()))) {
            arrayList.remove(String.valueOf(ratingReasonsData.getId()));
        } else if (arrayList != null) {
            arrayList.add(String.valueOf(ratingReasonsData.getId()));
        }
    }

    public final void updateVendorReasonsInRateOrderRequest(@NotNull RatingReasonsData ratingReasonsData) {
        ArrayList<String> arrayList;
        Intrinsics.checkNotNullParameter(ratingReasonsData, "ratingReasonsData");
        RateOrderRequest rateOrderRequest = this.ratingDataManager.getRateOrderRequest();
        if (rateOrderRequest != null) {
            arrayList = rateOrderRequest.getVendorReasons();
        } else {
            arrayList = null;
        }
        if (arrayList != null && arrayList.contains(String.valueOf(ratingReasonsData.getId()))) {
            arrayList.remove(String.valueOf(ratingReasonsData.getId()));
        } else if (arrayList != null) {
            arrayList.add(String.valueOf(ratingReasonsData.getId()));
        }
    }
}
