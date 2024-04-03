package com.adyen.checkout.ui.internal.common.util;

import android.content.Context;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.adyen.checkout.core.CheckoutException;
import com.adyen.checkout.core.Observer;
import com.adyen.checkout.core.model.PaymentMethod;
import com.adyen.checkout.core.model.PaymentSession;
import com.adyen.checkout.core.model.SurchargeConfiguration;
import com.adyen.checkout.ui.R;
import com.adyen.checkout.ui.internal.common.model.CheckoutSessionProvider;
import com.adyen.checkout.util.AmountFormat;
import com.adyen.checkout.util.internal.TextFormat;

public final class PayButtonUtil {
    private PayButtonUtil() {
        throw new IllegalStateException("No instances.");
    }

    public static <T extends AppCompatActivity & CheckoutSessionProvider> void setPayButtonText(@NonNull T t11, @NonNull final PaymentMethod paymentMethod, @NonNull final TextView textView, @NonNull final TextView textView2) {
        ((CheckoutSessionProvider) t11).getPaymentHandler().getPaymentSessionObservable().observe(t11, new Observer<PaymentSession>() {
            public void onChanged(@NonNull PaymentSession paymentSession) {
                PayButtonUtil.setPayButtonText(paymentSession, paymentMethod, textView, textView2);
            }
        });
    }

    public static <T extends Fragment & CheckoutSessionProvider> void setPayButtonText(@NonNull final T t11, @NonNull final PaymentMethod paymentMethod, @NonNull final TextView textView, @NonNull final TextView textView2) {
        FragmentActivity activity = t11.getActivity();
        if (activity != null) {
            ((CheckoutSessionProvider) t11).getPaymentHandler().getPaymentSessionObservable().observe(activity, new Observer<PaymentSession>() {
                public void onChanged(@NonNull PaymentSession paymentSession) {
                    if (t11.getContext() != null) {
                        PayButtonUtil.setPayButtonText(paymentSession, paymentMethod, textView, textView2);
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public static void setPayButtonText(@NonNull PaymentSession paymentSession, @NonNull PaymentMethod paymentMethod, @NonNull TextView textView, @NonNull TextView textView2) {
        CharSequence charSequence;
        CharSequence charSequence2;
        Context context = textView.getContext();
        try {
            SurchargeConfiguration surchargeConfiguration = (SurchargeConfiguration) paymentMethod.getConfiguration(SurchargeConfiguration.class);
            String surchargeCurrencyCode = surchargeConfiguration.getSurchargeCurrencyCode();
            charSequence2 = AmountFormat.format(context, surchargeConfiguration.getSurchargeFinalAmount(), surchargeCurrencyCode);
            charSequence = AmountFormat.format(context, surchargeConfiguration.getSurchargeTotalCost(), surchargeCurrencyCode);
        } catch (CheckoutException unused) {
            charSequence2 = AmountFormat.format(context, paymentSession.getPayment().getAmount());
            charSequence = null;
        }
        textView.setText(TextFormat.format(context, R.string.checkout_pay_amount_format, charSequence2));
        if (charSequence != null) {
            textView2.setVisibility(0);
            textView2.setText(TextFormat.format(context, R.string.checkout_surcharge_total_amount_format, charSequence));
            return;
        }
        textView2.setVisibility(8);
        textView2.setText((CharSequence) null);
    }
}
