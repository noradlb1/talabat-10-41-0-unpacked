package com.checkout.frames.utils.constants;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\f\n\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"EXPIRY_DATE_DIGITS_PATTERN", "", "EXPIRY_DATE_MAXIMUM_LENGTH_FOUR", "", "EXPIRY_DATE_MAXIMUM_LENGTH_THREE", "EXPIRY_DATE_PREFIX_ZERO", "EXPIRY_DATE_ZERO_POSITION_CHECK", "", "frames_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class ExpiryDateConstantsKt {
    @NotNull
    public static final String EXPIRY_DATE_DIGITS_PATTERN = "[^0-9]";
    public static final int EXPIRY_DATE_MAXIMUM_LENGTH_FOUR = 4;
    public static final int EXPIRY_DATE_MAXIMUM_LENGTH_THREE = 3;
    @NotNull
    public static final String EXPIRY_DATE_PREFIX_ZERO = "0";
    public static final char EXPIRY_DATE_ZERO_POSITION_CHECK = '1';
}
