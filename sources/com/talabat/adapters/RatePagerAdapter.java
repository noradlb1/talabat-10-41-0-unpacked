package com.talabat.adapters;

import JsonModels.Response.rateOrders.RateReason;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.talabat.NewRateActivity;
import com.talabat.designhelpers.WrappingFragmentStatePagerAdapter;
import com.talabat.fragments.RateCompleteFragment;
import com.talabat.fragments.RateDeliveryFragment;
import com.talabat.fragments.RateFeedbackFragment;
import com.talabat.fragments.RateRestaurantFragment;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001(Bw\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0016\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\rj\b\u0012\u0004\u0012\u00020\u000e`\u000f\u0012\u0016\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\rj\b\u0012\u0004\u0012\u00020\u000e`\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u0007\u0012\u0006\u0010\u0012\u001a\u00020\u0007\u0012\u0006\u0010\u0013\u001a\u00020\u0014¢\u0006\u0002\u0010\u0015J\b\u0010\u001f\u001a\u00020\tH\u0016J\u0006\u0010 \u001a\u00020\u0007J\u0016\u0010!\u001a\u0012\u0012\u0004\u0012\u00020\u00070\rj\b\u0012\u0004\u0012\u00020\u0007`\u000fJ\u0010\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\tH\u0016J\u001a\u0010%\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\rj\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\u000fJ\u0006\u0010&\u001a\u00020\u0007J\u0006\u0010'\u001a\u00020\u0007R\u0016\u0010\u0016\u001a\n \u0018*\u0004\u0018\u00010\u00170\u0017X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\rj\b\u0012\u0004\u0012\u00020\u000e`\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\rj\b\u0012\u0004\u0012\u00020\u000e`\u000fX\u0004¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/talabat/adapters/RatePagerAdapter;", "Lcom/talabat/designhelpers/WrappingFragmentStatePagerAdapter;", "ratingFragmentCallbacksListener", "Lcom/talabat/adapters/RatePagerAdapter$RatingFragmentCallbacksListener;", "fm", "Landroidx/fragment/app/FragmentManager;", "restaurantName", "", "restaurantId", "", "rate", "", "vendorRateReasons", "Ljava/util/ArrayList;", "LJsonModels/Response/rateOrders/RateReason;", "Lkotlin/collections/ArrayList;", "deliveryRateReasons", "vendorExperienceRatingTitle", "deliveryExperienceRatingTitle", "showReasons", "", "(Lcom/talabat/adapters/RatePagerAdapter$RatingFragmentCallbacksListener;Landroidx/fragment/app/FragmentManager;Ljava/lang/String;IFLjava/util/ArrayList;Ljava/util/ArrayList;Ljava/lang/String;Ljava/lang/String;Z)V", "completeFragment", "Lcom/talabat/fragments/RateCompleteFragment;", "kotlin.jvm.PlatformType", "deliveryFragment", "Lcom/talabat/fragments/RateDeliveryFragment;", "feedbackFragment", "Lcom/talabat/fragments/RateFeedbackFragment;", "restaurantFragment", "Lcom/talabat/fragments/RateRestaurantFragment;", "getCount", "getDeliveryRate", "getDeliveryReason", "getItem", "Landroidx/fragment/app/Fragment;", "position", "getRestaurantsReasons", "getReview", "getVendorRating", "RatingFragmentCallbacksListener", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RatePagerAdapter extends WrappingFragmentStatePagerAdapter {
    private final RateCompleteFragment completeFragment = RateCompleteFragment.getInstance();
    @NotNull
    private final String deliveryExperienceRatingTitle;
    @NotNull
    private final RateDeliveryFragment deliveryFragment;
    @NotNull
    private final ArrayList<RateReason> deliveryRateReasons;
    @NotNull
    private final RateFeedbackFragment feedbackFragment;
    private final float rate;
    @NotNull
    private final RateRestaurantFragment restaurantFragment;
    private final int restaurantId;
    @NotNull
    private final String restaurantName;
    private final boolean showReasons;
    @NotNull
    private final String vendorExperienceRatingTitle;
    @NotNull
    private final ArrayList<RateReason> vendorRateReasons;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\u0003H&J\b\u0010\b\u001a\u00020\u0003H&¨\u0006\t"}, d2 = {"Lcom/talabat/adapters/RatePagerAdapter$RatingFragmentCallbacksListener;", "", "disableContinueButton", "", "enableContinueButton", "hideContinueContainer", "onBackClicked", "onCloseClicked", "showContinueContainer", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface RatingFragmentCallbacksListener {
        void disableContinueButton();

        void enableContinueButton();

        void hideContinueContainer();

        void onBackClicked();

        void onCloseClicked();

        void showContinueContainer();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RatePagerAdapter(@NotNull RatingFragmentCallbacksListener ratingFragmentCallbacksListener, @Nullable FragmentManager fragmentManager, @NotNull String str, int i11, float f11, @NotNull ArrayList<RateReason> arrayList, @NotNull ArrayList<RateReason> arrayList2, @NotNull String str2, @NotNull String str3, boolean z11) {
        super(fragmentManager);
        RatingFragmentCallbacksListener ratingFragmentCallbacksListener2 = ratingFragmentCallbacksListener;
        String str4 = str;
        ArrayList<RateReason> arrayList3 = arrayList;
        ArrayList<RateReason> arrayList4 = arrayList2;
        String str5 = str2;
        String str6 = str3;
        boolean z12 = z11;
        Intrinsics.checkNotNullParameter(ratingFragmentCallbacksListener, "ratingFragmentCallbacksListener");
        Intrinsics.checkNotNullParameter(str, "restaurantName");
        Intrinsics.checkNotNullParameter(arrayList3, "vendorRateReasons");
        Intrinsics.checkNotNullParameter(arrayList4, "deliveryRateReasons");
        Intrinsics.checkNotNullParameter(str5, NewRateActivity.VENDOR_EXPERIENCE_RATING_TITLE);
        Intrinsics.checkNotNullParameter(str6, NewRateActivity.DELIVERY_EXPERIENCE_RATING_TITLE);
        FragmentManager fragmentManager2 = fragmentManager;
        this.restaurantName = str4;
        int i12 = i11;
        this.restaurantId = i12;
        float f12 = f11;
        this.rate = f12;
        this.vendorRateReasons = arrayList3;
        this.deliveryRateReasons = arrayList4;
        this.vendorExperienceRatingTitle = str5;
        this.deliveryExperienceRatingTitle = str6;
        this.showReasons = z12;
        RateRestaurantFragment instance = RateRestaurantFragment.Companion.getInstance(str4, i12, f12, arrayList3, str5, z11);
        this.restaurantFragment = instance;
        RateDeliveryFragment instance2 = RateDeliveryFragment.Companion.getInstance(arrayList4, str6, z12);
        this.deliveryFragment = instance2;
        RateFeedbackFragment instance3 = RateFeedbackFragment.Companion.getInstance();
        this.feedbackFragment = instance3;
        instance.setCallbackListener(ratingFragmentCallbacksListener);
        instance2.setCallbackListener(ratingFragmentCallbacksListener);
        instance3.setCallbackListener(ratingFragmentCallbacksListener);
    }

    public int getCount() {
        return 4;
    }

    @NotNull
    public final String getDeliveryRate() {
        return String.valueOf(this.deliveryFragment.getRate());
    }

    @NotNull
    public final ArrayList<String> getDeliveryReason() {
        if (this.deliveryFragment.getSelectedReasons() == null) {
            return new ArrayList<>();
        }
        ArrayList<String> arrayList = new ArrayList<>();
        Iterator<RateReason> it = this.deliveryFragment.getSelectedReasons().iterator();
        while (it.hasNext()) {
            arrayList.add(String.valueOf(it.next().getId()));
        }
        return arrayList;
    }

    @NotNull
    public Fragment getItem(int i11) {
        if (i11 == 0) {
            return this.restaurantFragment;
        }
        if (i11 == 1) {
            return this.deliveryFragment;
        }
        if (i11 == 2) {
            return this.feedbackFragment;
        }
        RateCompleteFragment rateCompleteFragment = this.completeFragment;
        Intrinsics.checkNotNullExpressionValue(rateCompleteFragment, "completeFragment");
        return rateCompleteFragment;
    }

    @Nullable
    public final ArrayList<String> getRestaurantsReasons() {
        if (this.restaurantFragment.getSelectedReasons() == null) {
            return new ArrayList<>();
        }
        ArrayList<String> arrayList = new ArrayList<>();
        Iterator<RateReason> it = this.restaurantFragment.getSelectedReasons().iterator();
        while (it.hasNext()) {
            arrayList.add(String.valueOf(it.next().getId()));
        }
        return arrayList;
    }

    @NotNull
    public final String getReview() {
        return this.feedbackFragment.getReview();
    }

    @NotNull
    public final String getVendorRating() {
        return String.valueOf(this.restaurantFragment.getRating());
    }
}
