package library.talabat.mvp.rateorder;

import android.text.TextUtils;
import android.util.Log;
import com.android.volley.VolleyError;
import com.talabat.configuration.discovery.AppVersionProvider;
import datamodels.RateOrderReq;
import datamodels.RateTag;
import java.util.ArrayList;
import java.util.Iterator;
import tracking.AppTracker;

public class RateOrderPresenter implements IRateOrderPresenter, RateOrderListener {
    private IRateOderInteractor interactor;
    private int numberOfItems;
    private int rateOrderBranchId;
    private RateOrderReq rateOrderReq = new RateOrderReq();
    public RateOrderView rateOrderView;
    private int transactionId;

    public RateOrderPresenter(AppVersionProvider appVersionProvider, RateOrderView rateOrderView2) {
        this.rateOrderView = rateOrderView2;
        this.interactor = new RateOderInteractor(appVersionProvider, this);
    }

    private boolean isAllItemsRated() {
        for (int i11 = 0; i11 < this.numberOfItems; i11++) {
            if (this.rateOrderView.getRateOrderItemAtIndex(i11).rating <= 0.0f) {
                return false;
            }
        }
        return true;
    }

    private boolean isRatingValid(float f11) {
        return f11 > 0.0f;
    }

    public float getAverageItemRate() {
        float f11 = 0.0f;
        int i11 = 0;
        while (true) {
            int i12 = this.numberOfItems;
            if (i11 >= i12) {
                return f11 / ((float) i12);
            }
            f11 += this.rateOrderView.getRateOrderItemAtIndex(i11).rating;
            i11++;
        }
    }

    public ArrayList<RateTag.Tag> getRateTags(RateOrderReq rateOrderReq2, int i11) {
        return rateOrderReq2.rateTags.get(i11).tags;
    }

    public boolean isAllRated() {
        boolean z11;
        if (this.rateOrderView.getDeliveryRating() == 0.0f) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (this.rateOrderView.getPackageRating() == 0.0f) {
            z11 = false;
        }
        if (this.rateOrderView.getValueRating() == 0.0f) {
            z11 = false;
        }
        if (!isAllItemsRated()) {
            return false;
        }
        return z11;
    }

    public void onDataError() {
        this.rateOrderView.onDataError();
    }

    public void onDestroy() {
        this.rateOrderView = null;
        IRateOderInteractor iRateOderInteractor = this.interactor;
        if (iRateOderInteractor != null) {
            iRateOderInteractor.unregister();
        }
        this.interactor = null;
    }

    public void onNetworkError() {
        this.rateOrderView.onNetworkError();
    }

    public void onOrderRatedSuccussfully(boolean z11, float f11) {
        RateOrderReq rateOrderReq2 = this.rateOrderReq;
        if (rateOrderReq2 != null) {
            rateOrderReq2.totalRating = f11;
        }
        Log.e("branchiddddd", "" + this.transactionId);
        AppTracker.onOrderRated(this.rateOrderView.getContext(), this.rateOrderReq, this.rateOrderView.getOrderId(), this.rateOrderBranchId, this.transactionId, false);
        this.rateOrderView.onRatingSubmited();
        this.rateOrderView.setRated(z11);
    }

    public void onServerError(VolleyError volleyError) {
        this.rateOrderView.onServerError(volleyError);
    }

    public boolean reachedAverage() {
        int i11;
        float deliveryRating = this.rateOrderView.getDeliveryRating() + this.rateOrderView.getPackageRating() + this.rateOrderView.getValueRating();
        float f11 = 0.0f;
        int i12 = 0;
        while (true) {
            i11 = this.numberOfItems;
            if (i12 >= i11) {
                break;
            }
            f11 += this.rateOrderView.getRateOrderItemAtIndex(i12).rating;
            i12++;
        }
        if ((deliveryRating + (f11 / ((float) i11))) / 4.0f >= 2.0f) {
            return true;
        }
        return false;
    }

    public void setUpView(RateOrderReq rateOrderReq2, int i11, int i12) {
        ArrayList<Integer> arrayList;
        this.numberOfItems = rateOrderReq2.items.length;
        this.rateOrderBranchId = i11;
        this.transactionId = i12;
        this.rateOrderView.setDeliveryRating(rateOrderReq2.deliveryRating);
        this.rateOrderView.setPackageRating(rateOrderReq2.packageRating);
        this.rateOrderView.setValueRating(rateOrderReq2.valueRating);
        this.rateOrderView.setRestaurantName(rateOrderReq2.restName);
        this.rateOrderView.setRestaurantLogo(rateOrderReq2.getLogo());
        this.rateOrderView.setReview(rateOrderReq2.review);
        this.rateOrderView.setOrderDetails(rateOrderReq2.orderID, rateOrderReq2.orderStatus, rateOrderReq2.orderPlacedDate);
        this.rateOrderView.setRateOrderItems(rateOrderReq2.items);
        this.rateOrderView.setDriverRating(rateOrderReq2.driverRating);
        if (rateOrderReq2.driverRating > 0.0f && (arrayList = rateOrderReq2.selectedDrivertIds) != null && arrayList.size() > 0) {
            ArrayList arrayList2 = new ArrayList();
            Iterator<Integer> it = rateOrderReq2.selectedDrivertIds.iterator();
            while (it.hasNext()) {
                Integer next = it.next();
                Iterator<RateTag.Tag> it2 = rateOrderReq2.rateTags.get(((int) rateOrderReq2.driverRating) - 1).tags.iterator();
                while (it2.hasNext()) {
                    RateTag.Tag next2 = it2.next();
                    if (next2.getTagId() == next.intValue()) {
                        arrayList2.add(next2);
                    }
                }
            }
            this.rateOrderView.setSelectedTags(arrayList2);
        }
        if (!TextUtils.isEmpty(rateOrderReq2.otherDriverReason)) {
            this.rateOrderView.setDriverOtherReason(rateOrderReq2.otherDriverReason);
        }
        if (rateOrderReq2.ratingSubmitted) {
            this.rateOrderView.setRated(true);
        } else {
            this.rateOrderView.setRated(false);
        }
    }

    public void submitRating() {
        int i11;
        if (this.rateOrderView.getDeliveryRating() == 0.0f) {
            i11 = 1;
        } else {
            i11 = 0;
        }
        if (this.rateOrderView.getPackageRating() == 0.0f) {
            i11++;
        }
        if (this.rateOrderView.getValueRating() == 0.0f) {
            i11++;
        }
        if (this.rateOrderView.getRateOrderReq().isDriverRateEnabled && this.rateOrderView.getRateOrderReq().isDriverRateMandatory && this.rateOrderView.getDriverRating() == 0.0f) {
            i11++;
        }
        if (!isAllItemsRated()) {
            i11++;
        }
        if (i11 > 1) {
            this.rateOrderView.onValidationFailed(0);
        } else if (this.rateOrderView.getDeliveryRating() == 0.0f) {
            this.rateOrderView.onValidationFailed(2);
        } else if (this.rateOrderView.getPackageRating() == 0.0f) {
            this.rateOrderView.onValidationFailed(1);
        } else if (this.rateOrderView.getValueRating() == 0.0f) {
            this.rateOrderView.onValidationFailed(3);
        } else if (!isAllItemsRated()) {
            this.rateOrderView.onValidationFailed(4);
        } else if (this.rateOrderView.getRateOrderReq().isDriverRateEnabled && this.rateOrderView.getRateOrderReq().isDriverRateMandatory && this.rateOrderView.getDriverRating() == 0.0f) {
            this.rateOrderView.onValidationFailed(5);
        } else if (this.rateOrderView.getRateOrderReq().isDriverRateEnabled && ((this.rateOrderView.getRateOrderReq().isDriverRateMandatory && this.rateOrderView.getDriverRating() > 0.0f && this.rateOrderView.getSelectedDriverTagsIds().size() == 0 && !this.rateOrderView.isDriverOtherReviewVisible()) || (!this.rateOrderView.getRateOrderReq().isDriverRateMandatory && this.rateOrderView.getDriverRating() > 0.0f && this.rateOrderView.getSelectedDriverTagsIds().size() == 0 && !this.rateOrderView.isDriverOtherReviewVisible()))) {
            this.rateOrderView.onValidationFailed(6);
        } else if (!this.rateOrderView.getRateOrderReq().isDriverRateEnabled || !this.rateOrderView.isDriverOtherReviewVisible() || !TextUtils.isEmpty(this.rateOrderView.getDriverOtherReason().trim())) {
            RateOrderReq rateOrderReq2 = this.rateOrderView.getRateOrderReq();
            rateOrderReq2.deliveryRating = this.rateOrderView.getDeliveryRating();
            rateOrderReq2.packageRating = this.rateOrderView.getPackageRating();
            rateOrderReq2.valueRating = this.rateOrderView.getValueRating();
            rateOrderReq2.review = this.rateOrderView.getReview();
            for (int i12 = 0; i12 < this.numberOfItems; i12++) {
                rateOrderReq2.items[i12] = this.rateOrderView.getRateOrderItemAtIndex(i12);
            }
            rateOrderReq2.driverRating = this.rateOrderView.getDriverRating();
            rateOrderReq2.otherDriverReason = this.rateOrderView.getDriverOtherReason();
            rateOrderReq2.selectedDrivertIds = this.rateOrderView.getSelectedDriverTagsIds();
            this.rateOrderReq = rateOrderReq2;
            this.interactor.submitRating(rateOrderReq2);
        } else {
            this.rateOrderView.onValidationFailed(7);
        }
    }
}
