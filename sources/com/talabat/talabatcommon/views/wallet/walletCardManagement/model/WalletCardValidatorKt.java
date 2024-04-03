package com.talabat.talabatcommon.views.wallet.walletCardManagement.model;

import java.util.regex.Pattern;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\"\u0016\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000\"\u0016\u0010\b\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001X\u0004¢\u0006\u0002\n\u0000\"\u0016\u0010\t\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001X\u0004¢\u0006\u0002\n\u0000\"\u0016\u0010\n\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001X\u0004¢\u0006\u0002\n\u0000\"\u0016\u0010\u000b\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"AMEX_PATTERN", "Ljava/util/regex/Pattern;", "kotlin.jvm.PlatformType", "CARD_HOLDER_NAME", "", "EXPIRY_DATE_LENGTH", "", "LENGTH_TO_DETERMINE_CARD_TYPE", "MASTERCARD_PATTERN", "MEEZA_CARD_PATTERN", "VISA_ELECTRON_PATTERN", "VISA_PATTERN", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class WalletCardValidatorKt {
    /* access modifiers changed from: private */
    public static final Pattern AMEX_PATTERN = Pattern.compile("^3[47]\\d*");
    @NotNull
    public static final String CARD_HOLDER_NAME = "Talabat";
    private static final int EXPIRY_DATE_LENGTH = 5;
    private static final int LENGTH_TO_DETERMINE_CARD_TYPE = 4;
    /* access modifiers changed from: private */
    public static final Pattern MASTERCARD_PATTERN = Pattern.compile("^(5[1-5]|222[1-9]|22[3-9]|2[3-6]|27[0-1]|2720)\\d*");
    /* access modifiers changed from: private */
    public static final Pattern MEEZA_CARD_PATTERN = Pattern.compile("^5078\\d*");
    /* access modifiers changed from: private */
    public static final Pattern VISA_ELECTRON_PATTERN = Pattern.compile("^4(026|17500|405|508|844|91[37])");
    /* access modifiers changed from: private */
    public static final Pattern VISA_PATTERN = Pattern.compile("^4\\d*");
}
