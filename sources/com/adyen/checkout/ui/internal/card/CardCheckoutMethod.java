package com.adyen.checkout.ui.internal.card;

import android.app.Application;
import androidx.annotation.NonNull;
import com.adyen.checkout.core.PaymentReference;
import com.adyen.checkout.core.card.Cards;
import com.adyen.checkout.core.internal.model.InputDetailImpl;
import com.adyen.checkout.core.model.Card;
import com.adyen.checkout.core.model.PaymentMethod;
import com.adyen.checkout.ui.R;
import com.adyen.checkout.ui.internal.common.model.CheckoutHandler;
import com.adyen.checkout.ui.internal.common.model.CheckoutMethod;

abstract class CardCheckoutMethod extends CheckoutMethod {

    public static final class Default extends CardCheckoutMethod {
        public Default(@NonNull Application application, @NonNull PaymentMethod paymentMethod) {
            super(application, paymentMethod);
        }

        public void onSelected(@NonNull CheckoutHandler checkoutHandler) {
            checkoutHandler.handleWithPaymentMethodHandler(new CardHandler(checkoutHandler.getPaymentReference(), getPaymentMethod()));
        }
    }

    public static final class OneClick extends CardCheckoutMethod {
        private final Card mCard;

        public OneClick(@NonNull Application application, @NonNull PaymentMethod paymentMethod, @NonNull Card card) {
            super(application, paymentMethod);
            this.mCard = card;
        }

        @NonNull
        public String getPrimaryText() {
            return Cards.FORMATTER.maskNumber(this.mCard.getLastFourDigits());
        }

        @NonNull
        public String getSecondaryText() {
            String formatExpiryDate = Cards.FORMATTER.formatExpiryDate(this.mCard.getExpiryMonth(), this.mCard.getExpiryYear());
            return getApplication().getString(R.string.checkout_card_one_click_expires_format, new Object[]{formatExpiryDate});
        }

        public void onSelected(@NonNull CheckoutHandler checkoutHandler) {
            PaymentReference paymentReference = checkoutHandler.getPaymentReference();
            PaymentMethod paymentMethod = getPaymentMethod();
            if (InputDetailImpl.findByKey(paymentMethod.getInputDetails(), "telephoneNumber") == null) {
                checkoutHandler.presentDetailsFragment(CardOneClickConfirmationFragment.newInstance(paymentReference, paymentMethod));
            } else {
                checkoutHandler.presentDetailsActivity(CupSecurePlusOneClickDetailsActivity.newIntent(getApplication(), paymentReference, paymentMethod));
            }
        }
    }

    private CardCheckoutMethod(@NonNull Application application, @NonNull PaymentMethod paymentMethod) {
        super(application, paymentMethod);
    }
}
