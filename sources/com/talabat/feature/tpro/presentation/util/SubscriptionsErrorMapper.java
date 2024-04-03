package com.talabat.feature.tpro.presentation.util;

import com.talabat.localization.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/talabat/feature/tpro/presentation/util/SubscriptionsErrorMapper;", "", "()V", "toResId", "", "errorCode", "", "(Ljava/lang/String;)Ljava/lang/Integer;", "com_talabat_feature_tpro_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SubscriptionsErrorMapper {
    @NotNull
    public static final SubscriptionsErrorMapper INSTANCE = new SubscriptionsErrorMapper();

    private SubscriptionsErrorMapper() {
    }

    @Nullable
    public final Integer toResId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "errorCode");
        switch (str.hashCode()) {
            case -1878270873:
                if (str.equals("subscription_code_taken_before")) {
                    return Integer.valueOf(R.string.tpro_subscription_code_taken_before);
                }
                break;
            case -785542777:
                if (str.equals("subscription_code_invalid")) {
                    return Integer.valueOf(R.string.tpro_subscription_code_invalid);
                }
                break;
            case 214896297:
                if (str.equals("customer_has_active_membership")) {
                    return Integer.valueOf(R.string.tpro_customer_has_active_membership);
                }
                break;
            case 240404149:
                if (str.equals("subscription_code_expired")) {
                    return Integer.valueOf(R.string.tpro_subscription_code_expired);
                }
                break;
            case 987634883:
                if (str.equals("subscription_code_is_not_intended_for_email")) {
                    return Integer.valueOf(R.string.tpro_subscription_code_is_not_intended_for_email);
                }
                break;
        }
        return null;
    }
}
