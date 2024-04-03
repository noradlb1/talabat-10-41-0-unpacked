package com.adyen.checkout.ui.internal.common.util;

import androidx.annotation.NonNull;
import com.adyen.checkout.core.internal.model.InputDetailImpl;
import com.adyen.checkout.core.model.InputDetail;
import com.adyen.checkout.core.model.PaymentMethod;
import java.util.List;

public final class PaymentMethodUtil {

    public enum Requirement {
        NONE,
        REQUIRED,
        OPTIONAL;

        /* access modifiers changed from: private */
        public boolean dominates(@NonNull Requirement requirement) {
            return ordinal() > requirement.ordinal();
        }
    }

    private PaymentMethodUtil() {
        throw new IllegalStateException("No instances.");
    }

    @NonNull
    public static Requirement getRequirementForInputDetail(@NonNull String str, @NonNull PaymentMethod paymentMethod) {
        InputDetail findByKey = InputDetailImpl.findByKey(paymentMethod.getInputDetails(), str);
        if (findByKey == null) {
            return Requirement.NONE;
        }
        return findByKey.isOptional() ? Requirement.OPTIONAL : Requirement.REQUIRED;
    }

    @NonNull
    public static Requirement getRequirementForInputDetail(@NonNull String str, @NonNull List<PaymentMethod> list) {
        Requirement requirement = Requirement.NONE;
        if (list != null) {
            for (PaymentMethod requirementForInputDetail : list) {
                Requirement requirementForInputDetail2 = getRequirementForInputDetail(str, requirementForInputDetail);
                if (requirementForInputDetail2.dominates(requirement)) {
                    requirement = requirementForInputDetail2;
                }
            }
        }
        return requirement;
    }
}
