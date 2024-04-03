package com.google.firebase.remoteconfig.internal;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.adjust.sdk.Constants;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigValue;

public class FirebaseRemoteConfigValueImpl implements FirebaseRemoteConfigValue {
    private static final String ILLEGAL_ARGUMENT_STRING_FORMAT = "[Value: %s] cannot be converted to a %s.";
    private final int source;
    private final String value;

    public FirebaseRemoteConfigValueImpl(String str, int i11) {
        this.value = str;
        this.source = i11;
    }

    private String asTrimmedString() {
        return asString().trim();
    }

    private void throwIfNullValue() {
        if (this.value == null) {
            throw new IllegalArgumentException("Value is null, and cannot be converted to the desired type.");
        }
    }

    public boolean asBoolean() throws IllegalArgumentException {
        if (this.source == 0) {
            return false;
        }
        String asTrimmedString = asTrimmedString();
        if (ConfigGetParameterHandler.TRUE_REGEX.matcher(asTrimmedString).matches()) {
            return true;
        }
        if (ConfigGetParameterHandler.FALSE_REGEX.matcher(asTrimmedString).matches()) {
            return false;
        }
        throw new IllegalArgumentException(String.format(ILLEGAL_ARGUMENT_STRING_FORMAT, new Object[]{asTrimmedString, TypedValues.Custom.S_BOOLEAN}));
    }

    public byte[] asByteArray() {
        if (this.source == 0) {
            return FirebaseRemoteConfig.DEFAULT_VALUE_FOR_BYTE_ARRAY;
        }
        return this.value.getBytes(ConfigGetParameterHandler.FRC_BYTE_ARRAY_ENCODING);
    }

    public double asDouble() {
        if (this.source == 0) {
            return 0.0d;
        }
        String asTrimmedString = asTrimmedString();
        try {
            return Double.valueOf(asTrimmedString).doubleValue();
        } catch (NumberFormatException e11) {
            throw new IllegalArgumentException(String.format(ILLEGAL_ARGUMENT_STRING_FORMAT, new Object[]{asTrimmedString, "double"}), e11);
        }
    }

    public long asLong() {
        if (this.source == 0) {
            return 0;
        }
        String asTrimmedString = asTrimmedString();
        try {
            return Long.valueOf(asTrimmedString).longValue();
        } catch (NumberFormatException e11) {
            throw new IllegalArgumentException(String.format(ILLEGAL_ARGUMENT_STRING_FORMAT, new Object[]{asTrimmedString, Constants.LONG}), e11);
        }
    }

    public String asString() {
        if (this.source == 0) {
            return "";
        }
        throwIfNullValue();
        return this.value;
    }

    public int getSource() {
        return this.source;
    }
}
