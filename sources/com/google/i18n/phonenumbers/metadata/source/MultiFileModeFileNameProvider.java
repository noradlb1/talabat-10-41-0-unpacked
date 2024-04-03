package com.google.i18n.phonenumbers.metadata.source;

import java.util.regex.Pattern;
import net.bytebuddy.utility.JavaConstant;

public final class MultiFileModeFileNameProvider implements PhoneMetadataFileNameProvider {
    private static final Pattern ALPHANUMERIC = Pattern.compile("^[\\p{L}\\p{N}]+$");
    private final String phoneMetadataFileNamePrefix;

    public MultiFileModeFileNameProvider(String str) {
        this.phoneMetadataFileNamePrefix = str + JavaConstant.Dynamic.DEFAULT_NAME;
    }

    public String getFor(Object obj) {
        String obj2 = obj.toString();
        if (ALPHANUMERIC.matcher(obj2).matches()) {
            return this.phoneMetadataFileNamePrefix + obj;
        }
        throw new IllegalArgumentException("Invalid key: " + obj2);
    }
}
