package com.talabat.growth.ui.loyalty.burn.burnOptionsDetails;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import buisnessmodels.Customer;
import com.designsystem.ds_button_v2.DSPrimaryButton;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.marshmallow.TalabatTag;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.core.tracking.data.events.rewards.RedeemEventParams;
import com.talabat.core.tracking.data.events.rewards.RedeemPointsAttributes;
import com.talabat.core.tracking.data.events.rewards.RedeemPointsClickedTrackingEvent;
import com.talabat.core.tracking.data.events.rewards.RedeemPointsCompletedTrackingEvent;
import com.talabat.core.tracking.data.events.rewards.RedeemPointsFailedTrackingEvent;
import com.talabat.core.tracking.data.events.rewards.RedeemPointsLoadedTrackingEvent;
import com.talabat.core.tracking.domain.TalabatTracker;
import com.talabat.core.ui.di.AndroidComponentsKt;
import com.talabat.growth.R;
import com.talabat.growth.ui.loyalty.burn.burnOptionsDetails.viewModel.BurnOptionsDetailsViewModel;
import com.talabat.growth.ui.loyalty.burn.burnOptionsDetails.viewModel.BurnOptionsDetailsViewModelBuilder;
import com.talabat.growth.ui.loyalty.burn.details.BurnOptionsDetailsDialogFragment;
import com.talabat.growth.ui.loyalty.burn.models.BurnItemDisplayModel;
import com.talabat.growth.ui.util.ExtentionsKt;
import com.talabat.talabatcommon.extentions.SafeLetKt;
import com.talabat.talabatcommon.feature.vouchers.loyalty.data.RedeemTrackData;
import com.talabat.talabatcommon.feature.vouchers.loyalty.tracking.GrowthTrackerConstants;
import com.talabat.talabatcommon.utils.DisplayUtils;
import com.talabat.talabatcommon.views.TalabatImageView;
import com.talabat.talabatcommon.views.statusViews.ActionStatus;
import com.talabat.talabatcommon.views.statusViews.Status;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.RedeemSourceType;
import com.talabat.talabatcommon.views.vouchers.models.ConfirmationDisplayModel;
import com.talabat.talabatcore.BaseFragment;
import com.talabat.talabatcore.exception.Failure;
import com.talabat.talabatcore.extensions.LifecycleKt;
import com.talabat.talabatnavigation.base.NavigatorModel;
import com.talabat.talabatnavigation.growthSquad.GrowthNavigatorActions;
import fr.a;
import fr.b;
import fr.c;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00010B\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0012\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u000e\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u0017H\u0016J\u0010\u0010\u001f\u001a\u00020\u00172\u0006\u0010 \u001a\u00020!H\u0016J\u001a\u0010\"\u001a\u00020\u00172\u0006\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&H\u0017J\u0012\u0010'\u001a\u00020\u00172\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0002J\u0018\u0010(\u001a\u00020\u00172\u0006\u0010)\u001a\u00020\u00132\u0006\u0010*\u001a\u00020\u001dH\u0002J\b\u0010+\u001a\u00020\u0017H\u0002J\u0012\u0010,\u001a\u00020\u00172\b\u0010)\u001a\u0004\u0018\u00010\u0013H\u0002J\u0012\u0010-\u001a\u00020\u00172\b\u0010)\u001a\u0004\u0018\u00010\u0013H\u0002J\u0018\u0010.\u001a\u00020\u00172\u0006\u0010*\u001a\u00020\u001d2\u0006\u0010)\u001a\u00020\u0013H\u0002J\b\u0010/\u001a\u00020\u0002H\u0016R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001b\u0010\n\u001a\u00020\u000b8BX\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\r¨\u00061"}, d2 = {"Lcom/talabat/growth/ui/loyalty/burn/burnOptionsDetails/BurnOptionsDetailsFragment;", "Lcom/talabat/talabatcore/BaseFragment;", "Lcom/talabat/growth/ui/loyalty/burn/burnOptionsDetails/viewModel/BurnOptionsDetailsViewModel;", "()V", "configurationLocalRepository", "Lcom/talabat/configuration/ConfigurationLocalRepository;", "getConfigurationLocalRepository", "()Lcom/talabat/configuration/ConfigurationLocalRepository;", "setConfigurationLocalRepository", "(Lcom/talabat/configuration/ConfigurationLocalRepository;)V", "talabatTracker", "Lcom/talabat/core/tracking/domain/TalabatTracker;", "getTalabatTracker", "()Lcom/talabat/core/tracking/domain/TalabatTracker;", "talabatTracker$delegate", "Lkotlin/Lazy;", "createRedeemConfirmationNavigatorModel", "Lcom/talabat/talabatnavigation/base/NavigatorModel;", "displayModel", "Lcom/talabat/growth/ui/loyalty/burn/models/BurnItemDisplayModel;", "confirmationDisplayModel", "Lcom/talabat/talabatcommon/views/vouchers/models/ConfirmationDisplayModel;", "failureHere", "", "failure", "Lcom/talabat/talabatcore/exception/Failure;", "getViewModelClass", "Ljava/lang/Class;", "layoutId", "", "observatory", "onAttach", "context", "Landroid/content/Context;", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "optionRedeemedSuccess", "populateUi", "burnItemDisplayModel", "totalPoints", "redeemOption", "setupUI", "showAreYouSureDialog", "trackRedeemPointsLoadedTrackingEvent", "viewModelBuilder", "VoucherPosition", "com_talabat_NewArchi_GrowthSquad_GrowthSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BurnOptionsDetailsFragment extends BaseFragment {
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    @Inject
    public ConfigurationLocalRepository configurationLocalRepository;
    @NotNull
    private final Lazy talabatTracker$delegate = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, new BurnOptionsDetailsFragment$talabatTracker$2(this));

    @Parcelize
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B!\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000bJ\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J0\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001¢\u0006\u0002\u0010\u0013J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006 "}, d2 = {"Lcom/talabat/growth/ui/loyalty/burn/burnOptionsDetails/BurnOptionsDetailsFragment$VoucherPosition;", "Landroid/os/Parcelable;", "channelName", "", "channelPosition", "", "voucherPosition", "(Ljava/lang/String;Ljava/lang/Integer;I)V", "getChannelName", "()Ljava/lang/String;", "getChannelPosition", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getVoucherPosition", "()I", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/Integer;I)Lcom/talabat/growth/ui/loyalty/burn/burnOptionsDetails/BurnOptionsDetailsFragment$VoucherPosition;", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "com_talabat_NewArchi_GrowthSquad_GrowthSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class VoucherPosition implements Parcelable {
        @NotNull
        public static final Parcelable.Creator<VoucherPosition> CREATOR = new Creator();
        @Nullable
        private final String channelName;
        @Nullable
        private final Integer channelPosition;
        private final int voucherPosition;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<VoucherPosition> {
            @NotNull
            public final VoucherPosition createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new VoucherPosition(parcel.readString(), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readInt());
            }

            @NotNull
            public final VoucherPosition[] newArray(int i11) {
                return new VoucherPosition[i11];
            }
        }

        public VoucherPosition(@Nullable String str, @Nullable Integer num, int i11) {
            this.channelName = str;
            this.channelPosition = num;
            this.voucherPosition = i11;
        }

        public static /* synthetic */ VoucherPosition copy$default(VoucherPosition voucherPosition2, String str, Integer num, int i11, int i12, Object obj) {
            if ((i12 & 1) != 0) {
                str = voucherPosition2.channelName;
            }
            if ((i12 & 2) != 0) {
                num = voucherPosition2.channelPosition;
            }
            if ((i12 & 4) != 0) {
                i11 = voucherPosition2.voucherPosition;
            }
            return voucherPosition2.copy(str, num, i11);
        }

        @Nullable
        public final String component1() {
            return this.channelName;
        }

        @Nullable
        public final Integer component2() {
            return this.channelPosition;
        }

        public final int component3() {
            return this.voucherPosition;
        }

        @NotNull
        public final VoucherPosition copy(@Nullable String str, @Nullable Integer num, int i11) {
            return new VoucherPosition(str, num, i11);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof VoucherPosition)) {
                return false;
            }
            VoucherPosition voucherPosition2 = (VoucherPosition) obj;
            return Intrinsics.areEqual((Object) this.channelName, (Object) voucherPosition2.channelName) && Intrinsics.areEqual((Object) this.channelPosition, (Object) voucherPosition2.channelPosition) && this.voucherPosition == voucherPosition2.voucherPosition;
        }

        @Nullable
        public final String getChannelName() {
            return this.channelName;
        }

        @Nullable
        public final Integer getChannelPosition() {
            return this.channelPosition;
        }

        public final int getVoucherPosition() {
            return this.voucherPosition;
        }

        public int hashCode() {
            String str = this.channelName;
            int i11 = 0;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            Integer num = this.channelPosition;
            if (num != null) {
                i11 = num.hashCode();
            }
            return ((hashCode + i11) * 31) + this.voucherPosition;
        }

        @NotNull
        public String toString() {
            String str = this.channelName;
            Integer num = this.channelPosition;
            int i11 = this.voucherPosition;
            return "VoucherPosition(channelName=" + str + ", channelPosition=" + num + ", voucherPosition=" + i11 + ")";
        }

        public void writeToParcel(@NotNull Parcel parcel, int i11) {
            int i12;
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeString(this.channelName);
            Integer num = this.channelPosition;
            if (num == null) {
                i12 = 0;
            } else {
                parcel.writeInt(1);
                i12 = num.intValue();
            }
            parcel.writeInt(i12);
            parcel.writeInt(this.voucherPosition);
        }
    }

    public static final /* synthetic */ BurnOptionsDetailsViewModel access$getViewModel(BurnOptionsDetailsFragment burnOptionsDetailsFragment) {
        return (BurnOptionsDetailsViewModel) burnOptionsDetailsFragment.getViewModel();
    }

    /* access modifiers changed from: private */
    public final NavigatorModel createRedeemConfirmationNavigatorModel(BurnItemDisplayModel burnItemDisplayModel, ConfirmationDisplayModel confirmationDisplayModel) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(GrowthNavigatorActions.EXTRA_LOYALTY_Burn_OPTION_DATA, burnItemDisplayModel);
        bundle.putParcelable(GrowthNavigatorActions.EXTRA_LOYALTY_CONFIRMATION_REDEMPTION_DATA, confirmationDisplayModel);
        bundle.putInt(GrowthNavigatorActions.EXTRA_LOYALTY_REMAINING_POINTS, ((BurnOptionsDetailsViewModel) getViewModel()).getRemainingPoints(burnItemDisplayModel.getPointsCost()));
        return new NavigatorModel(GrowthNavigatorActions.OPEN_LOYALTY_BURN_OPTIONS_REDEEM_ACTIVITY, bundle, (Function1) null, 4, (DefaultConstructorMarker) null);
    }

    private final TalabatTracker getTalabatTracker() {
        return (TalabatTracker) this.talabatTracker$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final void optionRedeemedSuccess(ConfirmationDisplayModel confirmationDisplayModel) {
        String str;
        String valueOf = String.valueOf(((BurnOptionsDetailsViewModel) getViewModel()).getTotalPoints());
        String redeemOptionTitle = ((BurnOptionsDetailsViewModel) getViewModel()).getRedeemOptionTitle();
        RedeemEventParams.ScreenType screenType = RedeemEventParams.ScreenType.REWARD;
        if (confirmationDisplayModel != null) {
            str = confirmationDisplayModel.getCustomerVoucherId();
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        getTalabatTracker().track(new RedeemPointsCompletedTrackingEvent(new RedeemEventParams(BurnOptionsDetailsDialogFragment.GA_SCREEN_NAME, valueOf, redeemOptionTitle, screenType, str), Float.valueOf(0.0f), (RedeemPointsAttributes) null, 4, (DefaultConstructorMarker) null));
        hideProgress();
        SafeLetKt.safeLet(getActivity(), ((BurnOptionsDetailsViewModel) getViewModel()).getBurnItemDisplayModelLiveData().getValue(), confirmationDisplayModel, new BurnOptionsDetailsFragment$optionRedeemedSuccess$1(this));
    }

    /* access modifiers changed from: private */
    public final void populateUi(BurnItemDisplayModel burnItemDisplayModel, int i11) {
        boolean z11;
        hideProgress();
        TalabatImageView talabatImageView = (TalabatImageView) _$_findCachedViewById(R.id.burnDetailsImageView);
        Intrinsics.checkNotNullExpressionValue(talabatImageView, "burnDetailsImageView");
        TalabatImageView.setImageResizeUrl$default(talabatImageView, burnItemDisplayModel.getImageURL(), Resources.getSystem().getDisplayMetrics().widthPixels, 0, false, 12, (Object) null);
        TalabatImageView talabatImageView2 = (TalabatImageView) _$_findCachedViewById(R.id.burnDetailsIconImageView);
        Intrinsics.checkNotNullExpressionValue(talabatImageView2, "burnDetailsIconImageView");
        TalabatImageView.setImageResizeUrl$default(talabatImageView2, burnItemDisplayModel.getThumbnailURL(), getResources().getDimensionPixelSize(R.dimen.loyalty_burn_details_icon_width_height), 0, false, 12, (Object) null);
        ((BurnOptionsDetailsViewModel) getViewModel()).setRedeemOptionTitle(burnItemDisplayModel.getTitle());
        ((TextView) _$_findCachedViewById(R.id.burnDetailsTitleTextView)).setText(((BurnOptionsDetailsViewModel) getViewModel()).getRedeemOptionTitle());
        ((TextView) _$_findCachedViewById(R.id.burnDetailsItemPointsTextView)).setText(((BurnOptionsDetailsViewModel) getViewModel()).formattedPoints(Integer.valueOf(burnItemDisplayModel.getPointsCost())));
        TextView textView = (TextView) _$_findCachedViewById(R.id.burnDetailsDetailTextView);
        Intrinsics.checkNotNullExpressionValue(textView, "burnDetailsDetailTextView");
        ExtentionsKt.renderContentAsHtml(textView, burnItemDisplayModel.getDescription());
        if (i11 < burnItemDisplayModel.getPointsCost()) {
            ((DSPrimaryButton) _$_findCachedViewById(R.id.burnDetailsRedeemButton)).setButtonEnabled(false);
            int i12 = R.id.burnDetailsNeededPointsTextView;
            ((TextView) _$_findCachedViewById(i12)).setVisibility(0);
            ((TextView) _$_findCachedViewById(R.id.burnDetailsAvailablePointsTextView)).setVisibility(8);
            ((TextView) _$_findCachedViewById(i12)).setText(getString(com.talabat.localization.R.string.loyalty_points_needed, ((BurnOptionsDetailsViewModel) getViewModel()).formattedNeededPointsToRedeem(burnItemDisplayModel)));
        } else {
            ((DSPrimaryButton) _$_findCachedViewById(R.id.burnDetailsRedeemButton)).setButtonEnabled(true);
            ((TextView) _$_findCachedViewById(R.id.burnDetailsNeededPointsTextView)).setVisibility(8);
            int i13 = R.id.burnDetailsAvailablePointsTextView;
            ((TextView) _$_findCachedViewById(i13)).setVisibility(0);
            ((TextView) _$_findCachedViewById(i13)).setText(getString(com.talabat.localization.R.string.loyalty_current_points, ((BurnOptionsDetailsViewModel) getViewModel()).formattedPoints(Integer.valueOf(i11))));
        }
        String tag = burnItemDisplayModel.getTag();
        if (tag.length() > 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11) {
            tag = null;
        }
        if (tag != null) {
            int i14 = R.id.burnDetailsTagView;
            ((TalabatTag) _$_findCachedViewById(i14)).setTagText(tag);
            ((TalabatTag) _$_findCachedViewById(i14)).setVisibility(0);
        }
        String string = getString(com.talabat.localization.R.string.loyalty_redeem_for_points, ((BurnOptionsDetailsViewModel) getViewModel()).formattedPoints(Integer.valueOf(burnItemDisplayModel.getPointsCost())));
        Intrinsics.checkNotNullExpressionValue(string, "getString(\n             …pointsCost)\n            )");
        ((DSPrimaryButton) _$_findCachedViewById(R.id.burnDetailsRedeemButton)).setTitle(string);
        trackRedeemPointsLoadedTrackingEvent(i11, burnItemDisplayModel);
    }

    private final void redeemOption() {
        BurnItemDisplayModel value = ((BurnOptionsDetailsViewModel) getViewModel()).getBurnItemDisplayModelLiveData().getValue();
        if (value != null) {
            showProgress();
            ((BurnOptionsDetailsViewModel) getViewModel()).redeemBurnOption(value.getId(), value.getBurnOptionType(), RedeemSourceType.MARKET_PLACE, value.getVoucherOptionType(), new RedeemTrackData(value.getId(), Customer.getInstance().getCustomerInfo().f13850id));
        }
    }

    private final void setupUI(BurnItemDisplayModel burnItemDisplayModel) {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            DisplayUtils.Companion.transparentStatus(activity);
        }
        ((ImageButton) _$_findCachedViewById(R.id.burnDetailsBackButton)).setOnClickListener(new c(this));
        ((DSPrimaryButton) _$_findCachedViewById(R.id.burnDetailsRedeemButton)).setOnTap(new BurnOptionsDetailsFragment$setupUI$3(this, burnItemDisplayModel));
    }

    /* access modifiers changed from: private */
    /* renamed from: setupUI$lambda-3  reason: not valid java name */
    public static final void m10599setupUI$lambda3(BurnOptionsDetailsFragment burnOptionsDetailsFragment, View view) {
        Intrinsics.checkNotNullParameter(burnOptionsDetailsFragment, "this$0");
        FragmentActivity activity = burnOptionsDetailsFragment.getActivity();
        if (activity != null) {
            activity.onBackPressed();
        }
    }

    /* access modifiers changed from: private */
    public final void showAreYouSureDialog(BurnItemDisplayModel burnItemDisplayModel) {
        String str;
        String valueOf = String.valueOf(((BurnOptionsDetailsViewModel) getViewModel()).getTotalPoints());
        String redeemOptionTitle = ((BurnOptionsDetailsViewModel) getViewModel()).getRedeemOptionTitle();
        RedeemEventParams.ScreenType screenType = RedeemEventParams.ScreenType.REWARD;
        Integer num = null;
        if (burnItemDisplayModel != null) {
            str = burnItemDisplayModel.getId();
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        getTalabatTracker().track(new RedeemPointsClickedTrackingEvent(new RedeemEventParams(BurnOptionsDetailsDialogFragment.GA_SCREEN_NAME, valueOf, redeemOptionTitle, screenType, str), (RedeemPointsAttributes) null, 2, (DefaultConstructorMarker) null));
        Context context = getContext();
        if (context != null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(context, com.talabat.talabatcommon.R.style.GreenAlertDialog);
            int i11 = com.talabat.localization.R.string.loyalty_redeem_dialog_title_redeem_for_points;
            Object[] objArr = new Object[1];
            BurnOptionsDetailsViewModel burnOptionsDetailsViewModel = (BurnOptionsDetailsViewModel) getViewModel();
            BurnItemDisplayModel value = ((BurnOptionsDetailsViewModel) getViewModel()).getBurnItemDisplayModelLiveData().getValue();
            if (value != null) {
                num = Integer.valueOf(value.getPointsCost());
            }
            objArr[0] = burnOptionsDetailsViewModel.formattedPoints(num);
            builder.setTitle((CharSequence) getString(i11, objArr)).setMessage((CharSequence) getString(com.talabat.localization.R.string.loyalty_redeem_dialog_message, ((BurnOptionsDetailsViewModel) getViewModel()).formattedTotalRemainingPoints())).setPositiveButton(com.talabat.localization.R.string.loyalty_yes, (DialogInterface.OnClickListener) new a(this)).setNegativeButton(com.talabat.localization.R.string.loyalty_cancel, (DialogInterface.OnClickListener) new b(this, burnItemDisplayModel)).show();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: showAreYouSureDialog$lambda-7$lambda-5  reason: not valid java name */
    public static final void m10600showAreYouSureDialog$lambda7$lambda5(BurnOptionsDetailsFragment burnOptionsDetailsFragment, DialogInterface dialogInterface, int i11) {
        Intrinsics.checkNotNullParameter(burnOptionsDetailsFragment, "this$0");
        burnOptionsDetailsFragment.redeemOption();
    }

    /* access modifiers changed from: private */
    /* renamed from: showAreYouSureDialog$lambda-7$lambda-6  reason: not valid java name */
    public static final void m10601showAreYouSureDialog$lambda7$lambda6(BurnOptionsDetailsFragment burnOptionsDetailsFragment, BurnItemDisplayModel burnItemDisplayModel, DialogInterface dialogInterface, int i11) {
        String str;
        Intrinsics.checkNotNullParameter(burnOptionsDetailsFragment, "this$0");
        String valueOf = String.valueOf(((BurnOptionsDetailsViewModel) burnOptionsDetailsFragment.getViewModel()).getTotalPoints());
        String redeemOptionTitle = ((BurnOptionsDetailsViewModel) burnOptionsDetailsFragment.getViewModel()).getRedeemOptionTitle();
        RedeemEventParams.ScreenType screenType = RedeemEventParams.ScreenType.REWARD;
        if (burnItemDisplayModel != null) {
            str = burnItemDisplayModel.getId();
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        burnOptionsDetailsFragment.getTalabatTracker().track(new RedeemPointsFailedTrackingEvent(new RedeemEventParams(BurnOptionsDetailsDialogFragment.GA_SCREEN_NAME, valueOf, redeemOptionTitle, screenType, str), Float.valueOf(0.0f), GrowthTrackerConstants.CANCEL_REDEEM_ACTION_REASON, (RedeemPointsAttributes) null, 8, (DefaultConstructorMarker) null));
    }

    private final void trackRedeemPointsLoadedTrackingEvent(int i11, BurnItemDisplayModel burnItemDisplayModel) {
        VoucherPosition voucherPosition;
        String str;
        Integer num;
        Integer num2;
        RedeemEventParams redeemEventParams = new RedeemEventParams(BurnOptionsDetailsDialogFragment.GA_SCREEN_NAME, String.valueOf(i11), ((BurnOptionsDetailsViewModel) getViewModel()).getRedeemOptionTitle(), RedeemEventParams.ScreenType.REWARD, burnItemDisplayModel.getId());
        Bundle arguments = getArguments();
        if (arguments != null) {
            voucherPosition = (VoucherPosition) arguments.getParcelable(BurnOptionsDetailsActivity.EXTRA_LOYALTY_VOUCHER_POSITION);
        } else {
            voucherPosition = null;
        }
        TalabatTracker talabatTracker = getTalabatTracker();
        String id2 = burnItemDisplayModel.getId();
        if (voucherPosition != null) {
            str = voucherPosition.getChannelName();
        } else {
            str = null;
        }
        if (voucherPosition != null) {
            num = voucherPosition.getChannelPosition();
        } else {
            num = null;
        }
        if (voucherPosition != null) {
            num2 = Integer.valueOf(voucherPosition.getVoucherPosition());
        } else {
            num2 = null;
        }
        talabatTracker.track(new RedeemPointsLoadedTrackingEvent(redeemEventParams, id2, str, num, num2, (RedeemPointsAttributes) null, 32, (DefaultConstructorMarker) null));
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Nullable
    public View _$_findCachedViewById(int i11) {
        View findViewById;
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i11));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null || (findViewById = view2.findViewById(i11)) == null) {
            return null;
        }
        map.put(Integer.valueOf(i11), findViewById);
        return findViewById;
    }

    public void failureHere(@Nullable Failure failure) {
        String str;
        String valueOf = String.valueOf(((BurnOptionsDetailsViewModel) getViewModel()).getTotalPoints());
        String redeemOptionTitle = ((BurnOptionsDetailsViewModel) getViewModel()).getRedeemOptionTitle();
        RedeemEventParams.ScreenType screenType = RedeemEventParams.ScreenType.REWARD;
        BurnItemDisplayModel value = ((BurnOptionsDetailsViewModel) getViewModel()).getBurnItemDisplayModelLiveData().getValue();
        if (value != null) {
            str = value.getId();
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        getTalabatTracker().track(new RedeemPointsFailedTrackingEvent(new RedeemEventParams(BurnOptionsDetailsDialogFragment.GA_SCREEN_NAME, valueOf, redeemOptionTitle, screenType, str), Float.valueOf(0.0f), BurnOptionsDetailsDialogFragment.GA_REASON_API_FAILED, (RedeemPointsAttributes) null, 8, (DefaultConstructorMarker) null));
        hideProgress();
        String string = getResources().getString(com.talabat.localization.R.string.sorry_something_went_wrong);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(com.…rry_something_went_wrong)");
        Status.Companion.notify$default(Status.Companion, getActivity(), (LinearLayout) _$_findCachedViewById(R.id.burnDetailsCurrentPointsLinearLayout), string, (String) null, (BaseTransientBottomBar.BaseCallback) null, (ActionStatus) null, 56, (Object) null);
    }

    @NotNull
    public final ConfigurationLocalRepository getConfigurationLocalRepository() {
        ConfigurationLocalRepository configurationLocalRepository2 = this.configurationLocalRepository;
        if (configurationLocalRepository2 != null) {
            return configurationLocalRepository2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("configurationLocalRepository");
        return null;
    }

    @NotNull
    public Class<BurnOptionsDetailsViewModel> getViewModelClass() {
        return BurnOptionsDetailsViewModel.class;
    }

    public int layoutId() {
        return R.layout.frag_loyalty_burn_options_details;
    }

    public void observatory() {
        LifecycleKt.observe(this, ((BurnOptionsDetailsViewModel) getViewModel()).getRedeemData(), new BurnOptionsDetailsFragment$observatory$1(this));
        LifecycleKt.observe(this, ((BurnOptionsDetailsViewModel) getViewModel()).getBurnItemDisplayModelLiveData(), new BurnOptionsDetailsFragment$observatory$2(this));
    }

    public void onAttach(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        DaggerBurnOptionsDetailsFragmentComponent.factory().create((ConfigurationLocalCoreLibApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(ConfigurationLocalCoreLibApi.class)).inject(this);
        super.onAttach(context);
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    @RequiresApi(20)
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        BurnItemDisplayModel burnItemDisplayModel;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        DisplayUtils.Companion companion = DisplayUtils.Companion;
        Toolbar toolbar = (Toolbar) _$_findCachedViewById(R.id.toolbar);
        Intrinsics.checkNotNullExpressionValue(toolbar, "toolbar");
        companion.setStatusBarHeight(view, toolbar);
        Bundle arguments = getArguments();
        if (arguments != null) {
            burnItemDisplayModel = (BurnItemDisplayModel) arguments.getParcelable(BurnOptionsDetailsActivity.EXTRA_LOYALTY_BURN_DETAILS_ITEM);
        } else {
            burnItemDisplayModel = null;
        }
        setupUI(burnItemDisplayModel);
        if (burnItemDisplayModel != null) {
            ((BurnOptionsDetailsViewModel) getViewModel()).setTotalPoints(requireArguments().getInt("BurnDetailsTotalPoints"));
            showProgress();
            ((BurnOptionsDetailsViewModel) getViewModel()).setBurnOptionItemDetails(burnItemDisplayModel);
        }
    }

    public final void setConfigurationLocalRepository(@NotNull ConfigurationLocalRepository configurationLocalRepository2) {
        Intrinsics.checkNotNullParameter(configurationLocalRepository2, "<set-?>");
        this.configurationLocalRepository = configurationLocalRepository2;
    }

    @NotNull
    public BurnOptionsDetailsViewModel viewModelBuilder() {
        BurnOptionsDetailsViewModelBuilder.Companion companion = BurnOptionsDetailsViewModelBuilder.Companion;
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        return companion.getBurnOptionsDetailsViewModel(requireContext, getTalabatTracker(), getConfigurationLocalRepository(), getCoroutineScope());
    }
}
