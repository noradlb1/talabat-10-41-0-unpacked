package com.talabat.offering.ui;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import com.designsystem.ds_bottom_sheet.DSBottomSheet;
import com.designsystem.ds_button.DSPrimaryButton;
import com.designsystem.marshmallow.R;
import com.materialedittext.MaterialEditText;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.offering.presentation.displaymodel.PopupDisplayModel;
import com.talabat.talabatcommon.extension.ViewKt;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vs.m;
import vs.n;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\r¢\u0006\u0002\u0010\u000eJ\u0012\u0010\u001c\u001a\u00020\u000b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010\u001e\u001a\u00020\u000bH\u0007J\b\u0010\u001f\u001a\u00020\u000bH\u0007J\u0006\u0010 \u001a\u00020\u000bJ\u0010\u0010!\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\nH\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u00020\u0010X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0016\u001a\u00020\u00178BX\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0018\u0010\u0019¨\u0006#"}, d2 = {"Lcom/talabat/offering/ui/OfferSubscriptionBottomSheetDialog;", "Lcom/designsystem/ds_bottom_sheet/DSBottomSheet$FragmentListener;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "popupData", "Lcom/talabat/offering/presentation/displaymodel/PopupDisplayModel;", "configurationLocalRepository", "Lcom/talabat/configuration/ConfigurationLocalRepository;", "function", "Lkotlin/Function1;", "", "", "closeFunction", "Lkotlin/Function0;", "(Landroidx/appcompat/app/AppCompatActivity;Lcom/talabat/offering/presentation/displaymodel/PopupDisplayModel;Lcom/talabat/configuration/ConfigurationLocalRepository;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "bottomSheetView", "Landroid/view/View;", "getBottomSheetView", "()Landroid/view/View;", "setBottomSheetView", "(Landroid/view/View;)V", "mobileNumber", "subscriptionBottomSheet", "Lcom/designsystem/ds_bottom_sheet/DSBottomSheet;", "getSubscriptionBottomSheet", "()Lcom/designsystem/ds_bottom_sheet/DSBottomSheet;", "subscriptionBottomSheet$delegate", "Lkotlin/Lazy;", "getView", "view", "hide", "hideError", "show", "showError", "errorMsg", "com_talabat_NewArchi_Offering_Offering"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OfferSubscriptionBottomSheetDialog implements DSBottomSheet.FragmentListener {
    @NotNull
    private final AppCompatActivity activity;
    public View bottomSheetView;
    @NotNull
    private final Function0<Unit> closeFunction;
    @NotNull
    private final ConfigurationLocalRepository configurationLocalRepository;
    @NotNull
    private final Function1<String, Unit> function;
    /* access modifiers changed from: private */
    @NotNull
    public String mobileNumber;
    @Nullable
    private final PopupDisplayModel popupData;
    @NotNull
    private final Lazy subscriptionBottomSheet$delegate;

    public OfferSubscriptionBottomSheetDialog(@NotNull AppCompatActivity appCompatActivity, @Nullable PopupDisplayModel popupDisplayModel, @NotNull ConfigurationLocalRepository configurationLocalRepository2, @NotNull Function1<? super String, Unit> function1, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(appCompatActivity, "activity");
        Intrinsics.checkNotNullParameter(configurationLocalRepository2, "configurationLocalRepository");
        Intrinsics.checkNotNullParameter(function1, "function");
        Intrinsics.checkNotNullParameter(function0, "closeFunction");
        this.activity = appCompatActivity;
        this.popupData = popupDisplayModel;
        this.configurationLocalRepository = configurationLocalRepository2;
        this.function = function1;
        this.closeFunction = function0;
        this.subscriptionBottomSheet$delegate = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, new OfferSubscriptionBottomSheetDialog$subscriptionBottomSheet$2(this));
        this.mobileNumber = "";
    }

    private final DSBottomSheet getSubscriptionBottomSheet() {
        return (DSBottomSheet) this.subscriptionBottomSheet$delegate.getValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: show$lambda-0  reason: not valid java name */
    public static final void m10695show$lambda0(OfferSubscriptionBottomSheetDialog offerSubscriptionBottomSheetDialog, View view) {
        Intrinsics.checkNotNullParameter(offerSubscriptionBottomSheetDialog, "this$0");
        offerSubscriptionBottomSheetDialog.function.invoke(offerSubscriptionBottomSheetDialog.mobileNumber);
    }

    /* access modifiers changed from: private */
    /* renamed from: show$lambda-1  reason: not valid java name */
    public static final void m10696show$lambda1(OfferSubscriptionBottomSheetDialog offerSubscriptionBottomSheetDialog, View view) {
        Intrinsics.checkNotNullParameter(offerSubscriptionBottomSheetDialog, "this$0");
        offerSubscriptionBottomSheetDialog.closeFunction.invoke();
        offerSubscriptionBottomSheetDialog.getSubscriptionBottomSheet().dismiss();
    }

    @NotNull
    public final View getBottomSheetView() {
        View view = this.bottomSheetView;
        if (view != null) {
            return view;
        }
        Intrinsics.throwUninitializedPropertyAccessException("bottomSheetView");
        return null;
    }

    public void getView(@Nullable View view) {
        String str;
        if (view != null) {
            setBottomSheetView(view);
            DSPrimaryButton dSPrimaryButton = (DSPrimaryButton) view.findViewById(R.id.bs_button_primary);
            TextView textView = (TextView) view.findViewById(R.id.bs_title);
            TextView textView2 = (TextView) view.findViewById(R.id.bs_details);
            TextView textView3 = (TextView) view.findViewById(com.talabat.offering.R.id.etCountryCode);
            MaterialEditText materialEditText = (MaterialEditText) view.findViewById(com.talabat.offering.R.id.etMobileNumber);
            PopupDisplayModel popupDisplayModel = this.popupData;
            String str2 = null;
            if (popupDisplayModel != null) {
                str = popupDisplayModel.getPopupTitle();
            } else {
                str = null;
            }
            textView.setText(str);
            PopupDisplayModel popupDisplayModel2 = this.popupData;
            if (popupDisplayModel2 != null) {
                str2 = popupDisplayModel2.getPopupDesc();
            }
            textView2.setText(str2);
            textView3.setText(this.configurationLocalRepository.selectedCountry().getPhoneCode());
            textView3.setFocusableInTouchMode(false);
            dSPrimaryButton.setDsIsEnabled(false);
            Intrinsics.checkNotNullExpressionValue(materialEditText, "bottomSheetMobileNumber");
            materialEditText.addTextChangedListener(new OfferSubscriptionBottomSheetDialog$getView$lambda3$$inlined$addTextChangedListener$default$1(this, dSPrimaryButton));
        }
    }

    @VisibleForTesting
    public final void hide() {
        getSubscriptionBottomSheet().dismiss();
    }

    @VisibleForTesting
    public final void hideError() {
        getBottomSheetView();
        TextView textView = (TextView) getBottomSheetView().findViewById(com.talabat.offering.R.id.tvErrorMsg);
        ImageView imageView = (ImageView) getBottomSheetView().findViewById(com.talabat.offering.R.id.ivErrorIcon);
        MaterialEditText materialEditText = (MaterialEditText) getBottomSheetView().findViewById(com.talabat.offering.R.id.etMobileNumber);
        if (textView != null) {
            ViewKt.invisible(textView);
        }
        if (imageView != null) {
            ViewKt.invisible(imageView);
        }
        if (textView != null) {
            textView.setText((CharSequence) null);
        }
        if (materialEditText != null) {
            materialEditText.setUnderlineColor(ContextCompat.getColor(this.activity, com.talabat.talabatcommon.R.color.neutral_35));
        }
    }

    public final void setBottomSheetView(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "<set-?>");
        this.bottomSheetView = view;
    }

    public final void show() {
        getSubscriptionBottomSheet().setButtonOnClickListener(new m(this));
        getSubscriptionBottomSheet().setHeaderStartIconOnClickListener(new n(this));
        getSubscriptionBottomSheet().show(this.activity.getSupportFragmentManager(), DSBottomSheet.TAG);
    }

    @VisibleForTesting
    public final void showError(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "errorMsg");
        getBottomSheetView();
        TextView textView = (TextView) getBottomSheetView().findViewById(com.talabat.offering.R.id.tvErrorMsg);
        ImageView imageView = (ImageView) getBottomSheetView().findViewById(com.talabat.offering.R.id.ivErrorIcon);
        MaterialEditText materialEditText = (MaterialEditText) getBottomSheetView().findViewById(com.talabat.offering.R.id.etMobileNumber);
        if (textView != null) {
            ViewKt.visible(textView);
        }
        if (imageView != null) {
            ViewKt.visible(imageView);
        }
        if (textView != null) {
            textView.setText(str);
        }
        if (materialEditText != null) {
            materialEditText.setUnderlineColor(ContextCompat.getColor(this.activity, R.color.ds_danger_100));
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ OfferSubscriptionBottomSheetDialog(AppCompatActivity appCompatActivity, PopupDisplayModel popupDisplayModel, ConfigurationLocalRepository configurationLocalRepository2, Function1 function1, Function0 function0, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(appCompatActivity, (i11 & 2) != 0 ? null : popupDisplayModel, configurationLocalRepository2, function1, function0);
    }
}
