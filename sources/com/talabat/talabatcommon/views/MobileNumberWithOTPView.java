package com.talabat.talabatcommon.views;

import android.content.Context;
import android.os.CountDownTimer;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.talabat.talabatcommon.R;
import hv.a;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000k\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u001b\u0018\u0000 =2\u00020\u0001:\u0001=B/\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ\u0006\u0010\"\u001a\u00020#J\u000e\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020&J\u0010\u0010'\u001a\u00020#2\u0006\u0010(\u001a\u00020\u0007H\u0002J\u0010\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020&H\u0002J\u0006\u0010,\u001a\u00020*J\u000e\u0010-\u001a\u00020#2\u0006\u0010.\u001a\u00020\u0007J\u000e\u0010/\u001a\u00020#2\u0006\u00100\u001a\u000201J\u000e\u00102\u001a\u00020#2\u0006\u00103\u001a\u00020\u0007J\u000e\u00104\u001a\u00020#2\u0006\u00105\u001a\u000206J\u0014\u00107\u001a\u00020#2\f\u00108\u001a\b\u0012\u0004\u0012\u00020#09J\u000e\u0010:\u001a\u00020#2\u0006\u0010;\u001a\u000201J\u0010\u0010<\u001a\u00020#2\u0006\u0010%\u001a\u00020&H\u0002R\u001b\u0010\n\u001a\u00020\u00078BX\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u000f\u001a\u00020\u00078BX\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0010\u0010\fR\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R#\u0010\u0014\u001a\n \u0016*\u0004\u0018\u00010\u00150\u00158BX\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u000e\u001a\u0004\b\u0017\u0010\u0018R\u0010\u0010\u001a\u001a\u00020\u001bX\u0004¢\u0006\u0004\n\u0002\u0010\u001cR#\u0010\u001d\u001a\n \u0016*\u0004\u0018\u00010\u001e0\u001e8BX\u0002¢\u0006\f\n\u0004\b!\u0010\u000e\u001a\u0004\b\u001f\u0010 ¨\u0006>"}, d2 = {"Lcom/talabat/talabatcommon/views/MobileNumberWithOTPView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "colorButtonActive", "getColorButtonActive", "()I", "colorButtonActive$delegate", "Lkotlin/Lazy;", "colorButtonDisabled", "getColorButtonDisabled", "colorButtonDisabled$delegate", "countDownTimer", "Landroid/os/CountDownTimer;", "mobileNumberEditText", "Lcom/talabat/talabatcommon/views/MobileNumberEditText;", "kotlin.jvm.PlatformType", "getMobileNumberEditText", "()Lcom/talabat/talabatcommon/views/MobileNumberEditText;", "mobileNumberEditText$delegate", "mobileNumberTextWatcher", "com/talabat/talabatcommon/views/MobileNumberWithOTPView$mobileNumberTextWatcher$1", "Lcom/talabat/talabatcommon/views/MobileNumberWithOTPView$mobileNumberTextWatcher$1;", "txtGetOTP", "Landroid/widget/TextView;", "getTxtGetOTP", "()Landroid/widget/TextView;", "txtGetOTP$delegate", "destroy", "", "disableGetOtpLinkFor", "seconds", "", "enableDisableGetOTPTextView", "mobileNumberLength", "getFormattedTime", "", "millis", "getMobileNumber", "setCountryCode", "countryCode", "setError", "error", "", "setErrorColor", "color", "setGetOTPLinkVisibility", "isVisible", "", "setOTPClickListener", "onClick", "Lkotlin/Function0;", "setText", "text", "startTimerToEnableGetOtpLink", "Companion", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MobileNumberWithOTPView extends ConstraintLayout {
    @NotNull
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @Deprecated
    public static final long ONE_SECOND_IN_MILLIS = 1000;
    @NotNull
    public Map<Integer, View> _$_findViewCache;
    @NotNull
    private final Lazy colorButtonActive$delegate;
    @NotNull
    private final Lazy colorButtonDisabled$delegate;
    @Nullable
    private CountDownTimer countDownTimer;
    @NotNull
    private final Lazy mobileNumberEditText$delegate;
    @NotNull
    private final MobileNumberWithOTPView$mobileNumberTextWatcher$1 mobileNumberTextWatcher;
    @NotNull
    private final Lazy txtGetOTP$delegate;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/talabat/talabatcommon/views/MobileNumberWithOTPView$Companion;", "", "()V", "ONE_SECOND_IN_MILLIS", "", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public MobileNumberWithOTPView(@NotNull Context context) {
        this(context, (AttributeSet) null, 0, 0, 14, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public MobileNumberWithOTPView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public MobileNumberWithOTPView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        this(context, attributeSet, i11, 0, 8, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public MobileNumberWithOTPView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i11, int i12) {
        super(context, attributeSet, i11, i12);
        Intrinsics.checkNotNullParameter(context, "context");
        this._$_findViewCache = new LinkedHashMap();
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        this.txtGetOTP$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, new MobileNumberWithOTPView$txtGetOTP$2(this));
        this.mobileNumberEditText$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, new MobileNumberWithOTPView$mobileNumberEditText$2(this));
        this.colorButtonActive$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, new MobileNumberWithOTPView$colorButtonActive$2(context));
        this.colorButtonDisabled$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, new MobileNumberWithOTPView$colorButtonDisabled$2(context));
        this.mobileNumberTextWatcher = new MobileNumberWithOTPView$mobileNumberTextWatcher$1(this);
        LayoutInflater.from(context).inflate(R.layout.layout_mobile_number_with_otp, this);
        setLayoutDirection(0);
    }

    /* access modifiers changed from: private */
    public final void enableDisableGetOTPTextView(int i11) {
        boolean z11;
        int i12;
        if (i11 > 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        TextView txtGetOTP = getTxtGetOTP();
        if (z11) {
            i12 = getColorButtonActive();
        } else {
            i12 = getColorButtonDisabled();
        }
        txtGetOTP.setTextColor(i12);
        getTxtGetOTP().setEnabled(z11);
    }

    private final int getColorButtonActive() {
        return ((Number) this.colorButtonActive$delegate.getValue()).intValue();
    }

    private final int getColorButtonDisabled() {
        return ((Number) this.colorButtonDisabled$delegate.getValue()).intValue();
    }

    /* access modifiers changed from: private */
    public final String getFormattedTime(long j11) {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        Locale locale = Locale.US;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        String format = String.format(locale, "%02d:%02d", Arrays.copyOf(new Object[]{Long.valueOf(timeUnit.toMinutes(j11)), Long.valueOf(timeUnit.toSeconds(j11))}, 2));
        Intrinsics.checkNotNullExpressionValue(format, "format(locale, format, *args)");
        return format;
    }

    private final MobileNumberEditText getMobileNumberEditText() {
        return (MobileNumberEditText) this.mobileNumberEditText$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final TextView getTxtGetOTP() {
        return (TextView) this.txtGetOTP$delegate.getValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: setOTPClickListener$lambda-0  reason: not valid java name */
    public static final void m5742setOTPClickListener$lambda0(Function0 function0, View view) {
        Intrinsics.checkNotNullParameter(function0, "$onClick");
        function0.invoke();
    }

    private final void startTimerToEnableGetOtpLink(long j11) {
        CountDownTimer countDownTimer2 = this.countDownTimer;
        if (countDownTimer2 != null) {
            countDownTimer2.cancel();
        }
        this.countDownTimer = new MobileNumberWithOTPView$startTimerToEnableGetOtpLink$1(this, TimeUnit.SECONDS.toMillis(j11)).start();
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Nullable
    public View _$_findCachedViewById(int i11) {
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i11));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i11);
        if (findViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i11), findViewById);
        return findViewById;
    }

    public final void destroy() {
        CountDownTimer countDownTimer2 = this.countDownTimer;
        if (countDownTimer2 != null) {
            countDownTimer2.cancel();
        }
    }

    public final void disableGetOtpLinkFor(long j11) {
        getTxtGetOTP().setEnabled(false);
        startTimerToEnableGetOtpLink(j11);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000a, code lost:
        r0 = r0.toString();
     */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String getMobileNumber() {
        /*
            r1 = this;
            com.talabat.talabatcommon.views.MobileNumberEditText r0 = r1.getMobileNumberEditText()
            android.text.Editable r0 = r0.getText()
            if (r0 == 0) goto L_0x0010
            java.lang.String r0 = r0.toString()
            if (r0 != 0) goto L_0x0012
        L_0x0010:
            java.lang.String r0 = ""
        L_0x0012:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.talabatcommon.views.MobileNumberWithOTPView.getMobileNumber():java.lang.String");
    }

    public final void setCountryCode(int i11) {
        getMobileNumberEditText().setCountryCode(i11);
    }

    public final void setError(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "error");
        getMobileNumberEditText().setError(charSequence);
    }

    public final void setErrorColor(int i11) {
        getMobileNumberEditText().setErrorColor(i11);
    }

    public final void setGetOTPLinkVisibility(boolean z11) {
        if (z11) {
            getTxtGetOTP().setVisibility(0);
            getMobileNumberEditText().addTextChangedListener(this.mobileNumberTextWatcher);
            return;
        }
        getTxtGetOTP().setVisibility(8);
        getMobileNumberEditText().removeTextChangedListener(this.mobileNumberTextWatcher);
    }

    public final void setOTPClickListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "onClick");
        getTxtGetOTP().setOnClickListener(new a(function0));
    }

    public final void setText(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "text");
        getMobileNumberEditText().setText(charSequence);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MobileNumberWithOTPView(Context context, AttributeSet attributeSet, int i11, int i12, int i13, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i13 & 2) != 0 ? null : attributeSet, (i13 & 4) != 0 ? 0 : i11, (i13 & 8) != 0 ? 0 : i12);
    }
}
