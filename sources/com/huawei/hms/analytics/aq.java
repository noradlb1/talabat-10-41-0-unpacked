package com.huawei.hms.analytics;

import com.visa.checkout.Profile;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

public interface aq {
    public static final List<String> fgh;
    public static final String[] ghi;
    public static final List<String> hij;
    public static final String[] ijk;
    public static final Pattern ikl = Pattern.compile("[a-zA-Z][a-zA-Z0-9_]*|[\\$][a-zA-Z0-9]*");
    public static final Pattern klm = Pattern.compile("[a-zA-Z_][a-zA-Z0-9_]*|[\\$][a-zA-Z0-9]*");
    public static final Pattern lmn = Pattern.compile("^[a-zA-Z0-9_-]+(\\s+[a-zA-Z0-9_-]+)*$");

    static {
        String[] strArr = {Profile.Country.CN, "DE", Profile.Country.SG, "RU"};
        ijk = strArr;
        hij = Collections.unmodifiableList(Arrays.asList(strArr));
        String[] strArr2 = {"AGC_TAG", "Crash_TAG", "AGC_TAG_ABTest", "AGC_TAG_AppLinking", "AGC_TAG_Config", "AGC_TAG_IAM"};
        ghi = strArr2;
        fgh = Collections.unmodifiableList(Arrays.asList(strArr2));
    }
}
