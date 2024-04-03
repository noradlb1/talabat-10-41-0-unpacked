package com.adyen.checkout.ui.internal.openinvoice.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.adyen.checkout.ui.R;

public class InputErrorFeedbackLayout extends LinearLayout {
    private ImageView mErrorImage;
    private TextView mErrorText;

    /* renamed from: com.adyen.checkout.ui.internal.openinvoice.view.InputErrorFeedbackLayout$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f40316a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.adyen.checkout.ui.internal.openinvoice.view.InputErrorFeedbackLayout$ErrorFeedbackState[] r0 = com.adyen.checkout.ui.internal.openinvoice.view.InputErrorFeedbackLayout.ErrorFeedbackState.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f40316a = r0
                com.adyen.checkout.ui.internal.openinvoice.view.InputErrorFeedbackLayout$ErrorFeedbackState r1 = com.adyen.checkout.ui.internal.openinvoice.view.InputErrorFeedbackLayout.ErrorFeedbackState.NONE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f40316a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.adyen.checkout.ui.internal.openinvoice.view.InputErrorFeedbackLayout$ErrorFeedbackState r1 = com.adyen.checkout.ui.internal.openinvoice.view.InputErrorFeedbackLayout.ErrorFeedbackState.FIELD_EMPTY     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f40316a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.adyen.checkout.ui.internal.openinvoice.view.InputErrorFeedbackLayout$ErrorFeedbackState r1 = com.adyen.checkout.ui.internal.openinvoice.view.InputErrorFeedbackLayout.ErrorFeedbackState.INCORRECT_FORMAT     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f40316a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.adyen.checkout.ui.internal.openinvoice.view.InputErrorFeedbackLayout$ErrorFeedbackState r1 = com.adyen.checkout.ui.internal.openinvoice.view.InputErrorFeedbackLayout.ErrorFeedbackState.CUSTOM_ERROR     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.adyen.checkout.ui.internal.openinvoice.view.InputErrorFeedbackLayout.AnonymousClass1.<clinit>():void");
        }
    }

    public interface CustomInputErrorDelegate {
        void setupIcon(@NonNull ImageView imageView);

        void setupText(@NonNull TextView textView);
    }

    public enum ErrorFeedbackState {
        NONE,
        FIELD_EMPTY,
        INCORRECT_FORMAT,
        CUSTOM_ERROR
    }

    public InputErrorFeedbackLayout(@NonNull Context context) {
        super(context);
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        this.mErrorText = (TextView) findViewById(R.id.textView_error_message);
        this.mErrorImage = (ImageView) findViewById(R.id.imageView_error_icon);
    }

    public void setErrorState(@NonNull ErrorFeedbackState errorFeedbackState) {
        setErrorState(errorFeedbackState, (CustomInputErrorDelegate) null);
    }

    public InputErrorFeedbackLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setErrorState(@NonNull ErrorFeedbackState errorFeedbackState, @Nullable CustomInputErrorDelegate customInputErrorDelegate) {
        int i11 = AnonymousClass1.f40316a[errorFeedbackState.ordinal()];
        if (i11 == 1) {
            setVisibility(8);
        } else if (i11 == 2) {
            setVisibility(0);
            this.mErrorText.setText(R.string.checkout_input_error_empty_field);
        } else if (i11 == 3) {
            setVisibility(0);
            this.mErrorText.setText(R.string.checkout_input_error_incorrect_format);
        } else if (i11 != 4) {
            setVisibility(8);
        } else if (customInputErrorDelegate != null) {
            setVisibility(0);
            customInputErrorDelegate.setupText(this.mErrorText);
            customInputErrorDelegate.setupIcon(this.mErrorImage);
        }
    }

    public InputErrorFeedbackLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
    }
}
