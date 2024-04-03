package com.talabat.feature.bnplcheckout.presentation.channel;

import com.talabat.feature.bnplcheckout.presentation.CardInfo;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&¨\u0006\n"}, d2 = {"Lcom/talabat/feature/bnplcheckout/presentation/channel/BNPLCheckoutChannelCallback;", "", "closeBottomSheet", "", "isChangeCardClicked", "", "openTermsAndConditionsScreen", "placeOrder", "cardInfo", "Lcom/talabat/feature/bnplcheckout/presentation/CardInfo;", "com_talabat_feature_bnpl-checkout_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface BNPLCheckoutChannelCallback {
    void closeBottomSheet();

    boolean isChangeCardClicked();

    void openTermsAndConditionsScreen();

    void placeOrder(@NotNull CardInfo cardInfo);
}
