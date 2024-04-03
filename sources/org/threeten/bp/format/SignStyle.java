package org.threeten.bp.format;

public enum SignStyle {
    NORMAL,
    ALWAYS,
    NEVER,
    NOT_NEGATIVE,
    EXCEEDS_PAD;

    public boolean a(boolean z11, boolean z12, boolean z13) {
        int ordinal = ordinal();
        if (ordinal == 0) {
            return !z11 || !z12;
        }
        if (ordinal == 1 || ordinal == 4) {
            return true;
        }
        return !z12 && !z13;
    }
}
