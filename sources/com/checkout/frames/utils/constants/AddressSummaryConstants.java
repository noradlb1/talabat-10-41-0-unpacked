package com.checkout.frames.utils.constants;

import androidx.compose.runtime.internal.StabilityInferred;
import com.checkout.frames.model.Padding;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\nXD¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/checkout/frames/utils/constants/AddressSummaryConstants;", "", "()V", "addressSummaryTextLineHeight", "", "addressSummaryTextPadding", "Lcom/checkout/frames/model/Padding;", "getAddressSummaryTextPadding", "()Lcom/checkout/frames/model/Padding;", "dividerColor", "", "getDividerColor", "()J", "marginAfterSummarySection", "marginBeforeSummarySection", "frames_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class AddressSummaryConstants {
    public static final int $stable = 0;
    @NotNull
    public static final AddressSummaryConstants INSTANCE = new AddressSummaryConstants();
    public static final int addressSummaryTextLineHeight = 24;
    @NotNull
    private static final Padding addressSummaryTextPadding = new Padding(16, 16, 24, 24);
    private static final long dividerColor = BillingAddressDetailsConstants.buttonDisabledContainerColor;
    public static final int marginAfterSummarySection = 8;
    public static final int marginBeforeSummarySection = 8;

    private AddressSummaryConstants() {
    }

    @NotNull
    public final Padding getAddressSummaryTextPadding() {
        return addressSummaryTextPadding;
    }

    public final long getDividerColor() {
        return dividerColor;
    }
}
