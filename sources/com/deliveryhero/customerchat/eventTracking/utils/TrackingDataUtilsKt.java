package com.deliveryhero.customerchat.eventTracking.utils;

import com.deliveryhero.contract.configuration.ChatConfiguration;
import com.deliveryhero.contract.model.UserType;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¨\u0006\u0004"}, d2 = {"getReceiverType", "", "chatConfiguration", "Lcom/deliveryhero/contract/configuration/ChatConfiguration;", "customerchat_basicRelease"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class TrackingDataUtilsKt {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[UserType.values().length];
            iArr[UserType.CUSTOMER.ordinal()] = 1;
            iArr[UserType.RIDER.ordinal()] = 2;
            iArr[UserType.SENDER.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @NotNull
    public static final String getReceiverType(@NotNull ChatConfiguration chatConfiguration) {
        Intrinsics.checkNotNullParameter(chatConfiguration, "chatConfiguration");
        int i11 = WhenMappings.$EnumSwitchMapping$0[chatConfiguration.getClientConfig().getUserType().ordinal()];
        if (i11 == 1) {
            String lowerCase = UserType.RIDER.name().toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
            return lowerCase;
        } else if (i11 == 2 || i11 == 3) {
            String lowerCase2 = UserType.CUSTOMER.name().toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase2, "this as java.lang.String).toLowerCase(Locale.ROOT)");
            return lowerCase2;
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }
}
