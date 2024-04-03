package com.talabat.rating.view;

import JsonModels.Response.rateOrders.RateReason;
import JsonModels.Response.rateOrders.RateReasonResponse;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import at.a;
import at.b;
import com.talabat.R;
import com.talabat.feature.rating.domain.EventTracker;
import com.talabat.feature.rating.domain.RatingDataManager;
import com.talabat.feature.rating.domain.RatingDataManagerKt;
import com.talabat.feature.rating.domain.model.RateOrderEventModel;
import com.talabat.feature.rating.presentation.RatingFeedbackActivity;
import com.talabat.helpers.CustomDialog;
import com.talabat.rating.domain.model.OrderRatingDetails;
import com.talabat.talabatcore.logger.LogManager;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0012H\u0016J\b\u0010\u0017\u001a\u00020\u0012H\u0016J\u0012\u0010\u0018\u001a\u00020\u00122\b\u0010\u0019\u001a\u0004\u0018\u00010\u0005H\u0016J \u0010\u001a\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J \u0010 \u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u000b\u001a\u00020\f8BX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/talabat/rating/view/OrderRatingViewImpl;", "Lcom/talabat/rating/view/OrderRatingView;", "activity", "Landroid/app/Activity;", "screenName", "", "ratingEventTracker", "Lcom/talabat/feature/rating/domain/EventTracker;", "(Landroid/app/Activity;Ljava/lang/String;Lcom/talabat/feature/rating/domain/EventTracker;)V", "loadingIndicator", "Lcom/talabat/helpers/CustomDialog;", "ratingReasonsDataManager", "Lcom/talabat/feature/rating/domain/RatingDataManager;", "getRatingReasonsDataManager", "()Lcom/talabat/feature/rating/domain/RatingDataManager;", "ratingReasonsDataManager$delegate", "Lkotlin/Lazy;", "hideLoading", "", "rateOrderClicked", "rateOrderEventModel", "Lcom/talabat/feature/rating/domain/model/RateOrderEventModel;", "showGenericError", "showLoading", "showOrderCannotBeRated", "message", "showRating", "encryptedOrderId", "orderRatingDetails", "Lcom/talabat/rating/domain/model/OrderRatingDetails;", "rateReasonResponse", "LJsonModels/Response/rateOrders/RateReasonResponse;", "showRatingView", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OrderRatingViewImpl implements OrderRatingView {
    /* access modifiers changed from: private */
    @NotNull
    public final Activity activity;
    @Nullable
    private CustomDialog loadingIndicator;
    @NotNull
    private final EventTracker ratingEventTracker;
    @NotNull
    private final Lazy ratingReasonsDataManager$delegate = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, new OrderRatingViewImpl$ratingReasonsDataManager$2(this));
    @NotNull
    private final String screenName;

    public OrderRatingViewImpl(@NotNull Activity activity2, @NotNull String str, @NotNull EventTracker eventTracker) {
        Intrinsics.checkNotNullParameter(activity2, "activity");
        Intrinsics.checkNotNullParameter(str, "screenName");
        Intrinsics.checkNotNullParameter(eventTracker, "ratingEventTracker");
        this.activity = activity2;
        this.screenName = str;
        this.ratingEventTracker = eventTracker;
    }

    private final RatingDataManager getRatingReasonsDataManager() {
        return (RatingDataManager) this.ratingReasonsDataManager$delegate.getValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: showGenericError$lambda-2  reason: not valid java name */
    public static final void m10715showGenericError$lambda2(DialogInterface dialogInterface, int i11) {
        dialogInterface.dismiss();
    }

    /* access modifiers changed from: private */
    /* renamed from: showOrderCannotBeRated$lambda-1  reason: not valid java name */
    public static final void m10716showOrderCannotBeRated$lambda1(DialogInterface dialogInterface, int i11) {
        dialogInterface.dismiss();
    }

    private final void showRating(String str, OrderRatingDetails orderRatingDetails, RateReasonResponse rateReasonResponse) {
        ArrayList arrayList;
        RateReasonResponse.RatingReasons ratingReasons;
        ArrayList<RateReason> deliveryReasons;
        RateReasonResponse.RatingReasons ratingReasons2;
        ArrayList<RateReason> vendorReasons;
        RateReasonResponse.Data result = rateReasonResponse.getResult();
        ArrayList arrayList2 = null;
        if (result == null || (ratingReasons2 = result.getRatingReasons()) == null || (vendorReasons = ratingReasons2.getVendorReasons()) == null) {
            arrayList = null;
        } else {
            arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(vendorReasons, 10));
            for (RateReason rateReason : vendorReasons) {
                int id2 = rateReason.getId();
                String ratingReason = rateReason.getRatingReason();
                Intrinsics.checkNotNullExpressionValue(ratingReason, "it.ratingReason");
                int[] enabledForRatings = rateReason.getEnabledForRatings();
                Intrinsics.checkNotNullExpressionValue(enabledForRatings, "it.enabledForRatings");
                arrayList.add(new com.talabat.feature.rating.domain.model.RateReason(id2, ratingReason, enabledForRatings));
            }
        }
        RateReasonResponse.Data result2 = rateReasonResponse.getResult();
        if (!(result2 == null || (ratingReasons = result2.getRatingReasons()) == null || (deliveryReasons = ratingReasons.getDeliveryReasons()) == null)) {
            arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(deliveryReasons, 10));
            for (RateReason rateReason2 : deliveryReasons) {
                int id3 = rateReason2.getId();
                String ratingReason2 = rateReason2.getRatingReason();
                Intrinsics.checkNotNullExpressionValue(ratingReason2, "it.ratingReason");
                int[] enabledForRatings2 = rateReason2.getEnabledForRatings();
                Intrinsics.checkNotNullExpressionValue(enabledForRatings2, "it.enabledForRatings");
                arrayList2.add(new com.talabat.feature.rating.domain.model.RateReason(id3, ratingReason2, enabledForRatings2));
            }
        }
        Intent intent = new Intent(this.activity, RatingFeedbackActivity.class);
        RatingDataManager ratingReasonsDataManager = getRatingReasonsDataManager();
        int vendorId = orderRatingDetails.getVendorId();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(vendorId);
        int branchId = orderRatingDetails.getBranchId();
        StringBuilder sb3 = new StringBuilder();
        sb3.append(branchId);
        ratingReasonsDataManager.setTrackingData(MapsKt__MapsKt.mapOf(TuplesKt.to(RatingDataManagerKt.RATING_ORDER_ID, orderRatingDetails.getOrderId()), TuplesKt.to(RatingDataManagerKt.RATING_VENDOR_ID, sb2.toString()), TuplesKt.to(RatingDataManagerKt.RATING_BRANCH_ID, sb3.toString()), TuplesKt.to(RatingDataManagerKt.RATING_VENDOR_NAME, orderRatingDetails.getVendorName()), TuplesKt.to(RatingDataManagerKt.RATING_EVENT_ORIGIN, this.screenName)));
        ratingReasonsDataManager.setVendorLogoUrl(orderRatingDetails.getVendorLogoUrl());
        ratingReasonsDataManager.setVendorExperienceRatingTitle(orderRatingDetails.getVendorExperienceRatingTitle());
        ratingReasonsDataManager.setDeliveryExperienceRatingTitle(orderRatingDetails.getDeliveryExperienceRatingTitle());
        ratingReasonsDataManager.setEncryptedOrderId(str);
        if (arrayList != null) {
            ratingReasonsDataManager.setVendorRateReasons(arrayList);
        }
        if (arrayList2 != null) {
            ratingReasonsDataManager.setDeliveryRateReasons(arrayList2);
        }
        this.activity.startActivityForResult(intent, 400);
        this.activity.overridePendingTransition(R.anim.activity_slide_from_bottom, R.anim.nothing);
    }

    public void hideLoading() {
        try {
            CustomDialog customDialog = this.loadingIndicator;
            if (customDialog != null && customDialog.isShowing() && !this.activity.isFinishing() && !this.activity.isDestroyed()) {
                customDialog.dismiss();
            }
        } catch (Exception e11) {
            LogManager.error$default(e11, (String) null, 2, (Object) null);
        }
    }

    public void rateOrderClicked(@NotNull RateOrderEventModel rateOrderEventModel) {
        Intrinsics.checkNotNullParameter(rateOrderEventModel, "rateOrderEventModel");
        this.ratingEventTracker.orderRateClicked(rateOrderEventModel);
    }

    public void showGenericError() {
        if (!this.activity.isFinishing()) {
            new AlertDialog.Builder(this.activity).setMessage(this.activity.getString(R.string.generic_error)).setNeutralButton(R.string.f54881ok, new b()).create().show();
        }
    }

    public void showLoading() {
        CustomDialog customDialog = this.loadingIndicator;
        if (customDialog != null) {
            customDialog.show();
        }
        try {
            if (this.loadingIndicator == null && !this.activity.isFinishing()) {
                this.loadingIndicator = new CustomDialog(this.activity);
            }
            CustomDialog customDialog2 = this.loadingIndicator;
            if (customDialog2 != null) {
                customDialog2.show();
            }
        } catch (Exception e11) {
            LogManager.error$default(e11, (String) null, 2, (Object) null);
        }
    }

    public void showOrderCannotBeRated(@Nullable String str) {
        if (!this.activity.isFinishing()) {
            new AlertDialog.Builder(this.activity).setMessage(str).setNeutralButton(R.string.f54881ok, new a()).create().show();
        }
    }

    public void showRatingView(@NotNull String str, @NotNull OrderRatingDetails orderRatingDetails, @NotNull RateReasonResponse rateReasonResponse) {
        Intrinsics.checkNotNullParameter(str, "encryptedOrderId");
        Intrinsics.checkNotNullParameter(orderRatingDetails, "orderRatingDetails");
        Intrinsics.checkNotNullParameter(rateReasonResponse, "rateReasonResponse");
        showRating(str, orderRatingDetails, rateReasonResponse);
    }
}
