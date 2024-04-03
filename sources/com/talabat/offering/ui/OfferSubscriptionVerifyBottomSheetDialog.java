package com.talabat.offering.ui;

import android.os.CountDownTimer;
import android.text.Editable;
import android.text.InputFilter;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.app.AppCompatActivity;
import com.designsystem.ds_bottom_sheet.DSBottomSheet;
import com.designsystem.ds_button.DSPrimaryButton;
import com.materialedittext.MaterialEditText;
import com.talabat.offering.R;
import com.talabat.offering.presentation.displaymodel.OTPDisplayModel;
import java.util.Arrays;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vs.o;
import vs.p;
import vs.q;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 42\u00020\u0001:\u00014BS\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000b\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\u000b\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\u000b¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u001e\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020 H\u0007J\u0012\u0010!\u001a\u00020\t2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\u001a\u0010$\u001a\u00020\t2\u0006\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010(H\u0007J\u0018\u0010)\u001a\u00020\t2\u0006\u0010*\u001a\u00020 2\u0006\u0010+\u001a\u00020&H\u0007J\b\u0010,\u001a\u00020\tH\u0007J\u0006\u0010-\u001a\u00020\u0012J\u0006\u0010.\u001a\u00020\tJ\u0010\u0010/\u001a\u00020\t2\u0006\u00100\u001a\u00020\bH\u0007J\u000e\u00101\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0005J\u0012\u00102\u001a\u00020\t*\u00020&2\u0006\u00103\u001a\u00020 R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\u000bX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\u000bX\u0004¢\u0006\u0002\n\u0000R$\u0010\u0011\u001a\u00020\u00128\u0006@\u0006X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000bX\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0018\u001a\u00020\u00198BX\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0004¢\u0006\u0002\n\u0000¨\u00065"}, d2 = {"Lcom/talabat/offering/ui/OfferSubscriptionVerifyBottomSheetDialog;", "Lcom/designsystem/ds_bottom_sheet/DSBottomSheet$FragmentListener;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "otpDisplayModel", "Lcom/talabat/offering/presentation/displaymodel/OTPDisplayModel$OTPData;", "verifyFunction", "Lkotlin/Function1;", "", "", "resendFunction", "Lkotlin/Function0;", "closeFunction", "expiredFunction", "(Landroidx/appcompat/app/AppCompatActivity;Lcom/talabat/offering/presentation/displaymodel/OTPDisplayModel$OTPData;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "countDownTimer", "Landroid/os/CountDownTimer;", "isExpired", "", "isExpired$annotations", "()V", "()Z", "setExpired", "(Z)V", "subscriptionBottomSheet", "Lcom/designsystem/ds_bottom_sheet/DSBottomSheet;", "getSubscriptionBottomSheet", "()Lcom/designsystem/ds_bottom_sheet/DSBottomSheet;", "subscriptionBottomSheet$delegate", "Lkotlin/Lazy;", "formattedTime", "millis", "", "getView", "view", "Landroid/view/View;", "handleTimerFinish", "timerTextView", "Landroid/widget/TextView;", "bottomSheetButton", "Lcom/designsystem/ds_button/DSPrimaryButton;", "handleTimerTicks", "millisUntilFinished", "textView", "hide", "isShown", "show", "showError", "errorMsg", "updateResendOTP", "startTimer", "duration", "Companion", "com_talabat_NewArchi_Offering_Offering"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OfferSubscriptionVerifyBottomSheetDialog implements DSBottomSheet.FragmentListener {
    public static final long COUNT_DOWN_INTERVAL = 1000;
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final long DEFAULT_COUNT_DOWN_TIME = 300000;
    public static final int DEFAULT_MAX_LENGTH = 4;
    @NotNull
    public static final String TAG = "OfferSubscriptionVerify";
    @NotNull
    private final AppCompatActivity activity;
    @NotNull
    private final Function0<Unit> closeFunction;
    @Nullable
    private CountDownTimer countDownTimer;
    @NotNull
    private final Function0<Unit> expiredFunction;
    private boolean isExpired;
    @NotNull
    private OTPDisplayModel.OTPData otpDisplayModel;
    @NotNull
    private final Function0<Unit> resendFunction;
    @NotNull
    private final Lazy subscriptionBottomSheet$delegate = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, new OfferSubscriptionVerifyBottomSheetDialog$subscriptionBottomSheet$2(this));
    @NotNull
    private final Function1<String, Unit> verifyFunction;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tXT¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/talabat/offering/ui/OfferSubscriptionVerifyBottomSheetDialog$Companion;", "", "()V", "COUNT_DOWN_INTERVAL", "", "DEFAULT_COUNT_DOWN_TIME", "DEFAULT_MAX_LENGTH", "", "TAG", "", "com_talabat_NewArchi_Offering_Offering"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public OfferSubscriptionVerifyBottomSheetDialog(@NotNull AppCompatActivity appCompatActivity, @NotNull OTPDisplayModel.OTPData oTPData, @NotNull Function1<? super String, Unit> function1, @NotNull Function0<Unit> function0, @NotNull Function0<Unit> function02, @NotNull Function0<Unit> function03) {
        Intrinsics.checkNotNullParameter(appCompatActivity, "activity");
        Intrinsics.checkNotNullParameter(oTPData, "otpDisplayModel");
        Intrinsics.checkNotNullParameter(function1, "verifyFunction");
        Intrinsics.checkNotNullParameter(function0, "resendFunction");
        Intrinsics.checkNotNullParameter(function02, "closeFunction");
        Intrinsics.checkNotNullParameter(function03, "expiredFunction");
        this.activity = appCompatActivity;
        this.otpDisplayModel = oTPData;
        this.verifyFunction = function1;
        this.resendFunction = function0;
        this.closeFunction = function02;
        this.expiredFunction = function03;
    }

    /* access modifiers changed from: private */
    public final DSBottomSheet getSubscriptionBottomSheet() {
        return (DSBottomSheet) this.subscriptionBottomSheet$delegate.getValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: getView$lambda-3$lambda-2  reason: not valid java name */
    public static final void m10697getView$lambda3$lambda2(OfferSubscriptionVerifyBottomSheetDialog offerSubscriptionVerifyBottomSheetDialog, View view) {
        Intrinsics.checkNotNullParameter(offerSubscriptionVerifyBottomSheetDialog, "this$0");
        offerSubscriptionVerifyBottomSheetDialog.getSubscriptionBottomSheet().dismiss();
    }

    @VisibleForTesting
    public static /* synthetic */ void isExpired$annotations() {
    }

    /* access modifiers changed from: private */
    /* renamed from: show$lambda-0  reason: not valid java name */
    public static final void m10698show$lambda0(OfferSubscriptionVerifyBottomSheetDialog offerSubscriptionVerifyBottomSheetDialog, View view) {
        Editable editable;
        MaterialEditText materialEditText;
        Intrinsics.checkNotNullParameter(offerSubscriptionVerifyBottomSheetDialog, "this$0");
        if (offerSubscriptionVerifyBottomSheetDialog.isExpired) {
            offerSubscriptionVerifyBottomSheetDialog.resendFunction.invoke();
            return;
        }
        Function1<String, Unit> function1 = offerSubscriptionVerifyBottomSheetDialog.verifyFunction;
        View view2 = offerSubscriptionVerifyBottomSheetDialog.getSubscriptionBottomSheet().getView();
        if (view2 == null || (materialEditText = (MaterialEditText) view2.findViewById(R.id.etOTPInput)) == null) {
            editable = null;
        } else {
            editable = materialEditText.getText();
        }
        function1.invoke(String.valueOf(editable));
    }

    /* access modifiers changed from: private */
    /* renamed from: show$lambda-1  reason: not valid java name */
    public static final void m10699show$lambda1(OfferSubscriptionVerifyBottomSheetDialog offerSubscriptionVerifyBottomSheetDialog, View view) {
        Intrinsics.checkNotNullParameter(offerSubscriptionVerifyBottomSheetDialog, "this$0");
        CountDownTimer countDownTimer2 = offerSubscriptionVerifyBottomSheetDialog.countDownTimer;
        if (countDownTimer2 != null) {
            countDownTimer2.cancel();
        }
        offerSubscriptionVerifyBottomSheetDialog.closeFunction.invoke();
        offerSubscriptionVerifyBottomSheetDialog.getSubscriptionBottomSheet().dismiss();
    }

    @NotNull
    @VisibleForTesting
    public final String formattedTime(long j11) {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        Locale locale = Locale.US;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        String format = String.format(locale, "%02d:%02d", Arrays.copyOf(new Object[]{Long.valueOf(timeUnit.toMinutes(j11)), Long.valueOf(timeUnit.toSeconds(j11) - TimeUnit.MINUTES.toSeconds(timeUnit.toMinutes(j11)))}, 2));
        Intrinsics.checkNotNullExpressionValue(format, "format(locale, format, *args)");
        return format;
    }

    public void getView(@Nullable View view) {
        int i11;
        long j11;
        if (view != null) {
            MaterialEditText materialEditText = (MaterialEditText) view.findViewById(R.id.etOTPInput);
            TextView textView = (TextView) view.findViewById(R.id.tvCodeExpiry);
            TextView textView2 = (TextView) view.findViewById(R.id.tvTapToChange);
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String string = this.activity.getString(com.talabat.localization.R.string.sent_verification_code_to);
            Intrinsics.checkNotNullExpressionValue(string, "activity.getString(com.t…ent_verification_code_to)");
            String format = String.format(string, Arrays.copyOf(new Object[]{this.otpDisplayModel.getMobileNumber()}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            ((TextView) view.findViewById(com.designsystem.marshmallow.R.id.bs_title)).setText(format);
            InputFilter.LengthFilter[] lengthFilterArr = new InputFilter.LengthFilter[1];
            Integer otpLength = this.otpDisplayModel.getOtpLength();
            if (otpLength != null) {
                i11 = otpLength.intValue();
            } else {
                i11 = 4;
            }
            lengthFilterArr[0] = new InputFilter.LengthFilter(i11);
            materialEditText.setFilters((InputFilter[]) lengthFilterArr);
            Intrinsics.checkNotNullExpressionValue(textView, "bottomSheetCountDown");
            Long duration = this.otpDisplayModel.getDuration();
            if (duration != null) {
                j11 = duration.longValue();
            } else {
                j11 = 300000;
            }
            startTimer(textView, j11);
            textView2.setOnClickListener(new q(this));
        }
    }

    @VisibleForTesting
    public final void handleTimerFinish(@NotNull TextView textView, @Nullable DSPrimaryButton dSPrimaryButton) {
        Intrinsics.checkNotNullParameter(textView, "timerTextView");
        this.isExpired = true;
        textView.setText(this.activity.getString(com.talabat.localization.R.string.code_expired));
        if (dSPrimaryButton != null) {
            dSPrimaryButton.setCenterText(this.activity.getText(com.talabat.localization.R.string.resend_code).toString());
        }
        this.expiredFunction.invoke();
    }

    @VisibleForTesting
    public final void handleTimerTicks(long j11, @NotNull TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "textView");
        this.isExpired = false;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String string = this.activity.getString(com.talabat.localization.R.string.code_expiring_in);
        Intrinsics.checkNotNullExpressionValue(string, "activity.getString(com.t….string.code_expiring_in)");
        String format = String.format(string, Arrays.copyOf(new Object[]{formattedTime(j11)}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        textView.setText(format);
    }

    @VisibleForTesting
    public final void hide() {
        getSubscriptionBottomSheet().dismiss();
    }

    public final boolean isExpired() {
        return this.isExpired;
    }

    public final boolean isShown() {
        return getSubscriptionBottomSheet().isVisible();
    }

    public final void setExpired(boolean z11) {
        this.isExpired = z11;
    }

    public final void show() {
        getSubscriptionBottomSheet().setButtonOnClickListener(new o(this));
        getSubscriptionBottomSheet().setHeaderStartIconOnClickListener(new p(this));
        getSubscriptionBottomSheet().show(this.activity.getSupportFragmentManager(), TAG);
    }

    @VisibleForTesting
    public final void showError(@NotNull String str) {
        TextView textView;
        Intrinsics.checkNotNullParameter(str, "errorMsg");
        CountDownTimer countDownTimer2 = this.countDownTimer;
        if (countDownTimer2 != null) {
            countDownTimer2.cancel();
        }
        View view = getSubscriptionBottomSheet().getView();
        if (view != null) {
            textView = (TextView) view.findViewById(R.id.tvCodeExpiry);
        } else {
            textView = null;
        }
        if (textView != null) {
            textView.setText(str);
        }
    }

    public final void startTimer(@NotNull TextView textView, long j11) {
        Intrinsics.checkNotNullParameter(textView, "<this>");
        CountDownTimer countDownTimer2 = this.countDownTimer;
        if (countDownTimer2 != null) {
            countDownTimer2.cancel();
        }
        this.countDownTimer = new OfferSubscriptionVerifyBottomSheetDialog$startTimer$1(j11, this, textView).start();
    }

    public final void updateResendOTP(@NotNull OTPDisplayModel.OTPData oTPData) {
        DSPrimaryButton dSPrimaryButton;
        Intrinsics.checkNotNullParameter(oTPData, "otpDisplayModel");
        this.otpDisplayModel = oTPData;
        View view = getSubscriptionBottomSheet().getView();
        if (view != null) {
            dSPrimaryButton = (DSPrimaryButton) view.findViewById(com.designsystem.marshmallow.R.id.bs_button_primary);
        } else {
            dSPrimaryButton = null;
        }
        if (dSPrimaryButton != null) {
            String string = this.activity.getString(com.talabat.localization.R.string.get_otp);
            Intrinsics.checkNotNullExpressionValue(string, "activity.getString(com.t…ization.R.string.get_otp)");
            dSPrimaryButton.setCenterText(string);
        }
        getView(getSubscriptionBottomSheet().getView());
    }
}
