package com.talabat.talabatlife.ui.subscription.model;

import com.talabat.talabatcommon.extentions.BooleanKt;
import com.talabat.talabatlife.features.subscription.model.response.SubscriptionPaymentResponse;
import com.talabat.talabatlife.ui.subscription.model.SubscriptionPaymentDisplayModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/talabat/talabatlife/ui/subscription/model/SubscriptionMapper;", "", "()V", "Companion", "com_talabat_NewArchi_TalabatLife_TalabatLife"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SubscriptionMapper {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006H\u0002¨\u0006\n"}, d2 = {"Lcom/talabat/talabatlife/ui/subscription/model/SubscriptionMapper$Companion;", "", "()V", "mapSubscriptionPayment", "Lcom/talabat/talabatlife/ui/subscription/model/SubscriptionPaymentDisplayModel;", "statusResponse", "Lcom/talabat/talabatlife/features/subscription/model/response/SubscriptionPaymentResponse;", "mapSubscriptionPaymentResult", "Lcom/talabat/talabatlife/ui/subscription/model/SubscriptionPaymentDisplayModel$SubscriptionPaymentResult;", "response", "com_talabat_NewArchi_TalabatLife_TalabatLife"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final SubscriptionPaymentDisplayModel.SubscriptionPaymentResult mapSubscriptionPaymentResult(SubscriptionPaymentResponse subscriptionPaymentResponse) {
            SubscriptionPaymentDisplayModel.SubscriptionPaymentResult subscriptionPaymentResult = new SubscriptionPaymentDisplayModel.SubscriptionPaymentResult((String) null, (Boolean) null, 3, (DefaultConstructorMarker) null);
            SubscriptionPaymentResponse.SubscriptionPaymentResult result = subscriptionPaymentResponse.getResult();
            if (result != null) {
                String redirectURL = result.getRedirectURL();
                if (redirectURL == null) {
                    redirectURL = "";
                }
                subscriptionPaymentResult.setRedirectURL(redirectURL);
                subscriptionPaymentResult.setSubscribed(Boolean.valueOf(BooleanKt.orFalse(result.isSubscribed())));
            }
            return subscriptionPaymentResult;
        }

        @NotNull
        public final SubscriptionPaymentDisplayModel mapSubscriptionPayment(@Nullable SubscriptionPaymentResponse subscriptionPaymentResponse) {
            List<String> errors;
            String str;
            boolean z11;
            Boolean bool = null;
            SubscriptionPaymentDisplayModel subscriptionPaymentDisplayModel = new SubscriptionPaymentDisplayModel((SubscriptionPaymentDisplayModel.SubscriptionPaymentResult) null, (String) null, 3, (DefaultConstructorMarker) null);
            if (subscriptionPaymentResponse != null) {
                subscriptionPaymentDisplayModel.setResult(SubscriptionMapper.Companion.mapSubscriptionPaymentResult(subscriptionPaymentResponse));
                List<String> errors2 = subscriptionPaymentResponse.getErrors();
                if (errors2 != null) {
                    if (errors2.isEmpty()) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    bool = Boolean.valueOf(z11);
                }
                if (!(BooleanKt.orFalse(bool) || (errors = subscriptionPaymentResponse.getErrors()) == null || (str = errors.get(0)) == null)) {
                    subscriptionPaymentDisplayModel.setError(str);
                }
            }
            return subscriptionPaymentDisplayModel;
        }
    }
}
