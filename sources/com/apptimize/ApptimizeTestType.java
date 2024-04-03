package com.apptimize;

public enum ApptimizeTestType {
    CODE_BLOCK("code-block"),
    FEATURE_FLAG("feature-flag"),
    DYNAMIC_VARIABLES("variables"),
    VISUAL("wysiwyg"),
    UNKNOWN((String) null),
    FEATURE_VARIABLES("feature-config");
    

    /* renamed from: a  reason: collision with root package name */
    private String f40997a;

    private ApptimizeTestType(String str) {
        this.f40997a = str;
    }

    public static ApptimizeTestType ParseName(String str) {
        if (str == null) {
            return UNKNOWN;
        }
        char c11 = 65535;
        switch (str.hashCode()) {
            case -2025873235:
                if (str.equals("code-block")) {
                    c11 = 0;
                    break;
                }
                break;
            case -1097052653:
                if (str.equals("int-value")) {
                    c11 = 1;
                    break;
                }
                break;
            case -1005718347:
                if (str.equals("string-value")) {
                    c11 = 2;
                    break;
                }
                break;
            case -82477705:
                if (str.equals("variables")) {
                    c11 = 3;
                    break;
                }
                break;
            case -40091531:
                if (str.equals("double-value")) {
                    c11 = 4;
                    break;
                }
                break;
            case 496587257:
                if (str.equals("feature-config")) {
                    c11 = 5;
                    break;
                }
                break;
            case 1162612707:
                if (str.equals("feature-flag")) {
                    c11 = 6;
                    break;
                }
                break;
            case 1812334093:
                if (str.equals("wysiwyg")) {
                    c11 = 7;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                return CODE_BLOCK;
            case 1:
                return DYNAMIC_VARIABLES;
            case 2:
                return DYNAMIC_VARIABLES;
            case 3:
                return DYNAMIC_VARIABLES;
            case 4:
                return DYNAMIC_VARIABLES;
            case 5:
                return FEATURE_VARIABLES;
            case 6:
                return FEATURE_FLAG;
            case 7:
                return VISUAL;
            default:
                return UNKNOWN;
        }
    }

    public String getTypeName() {
        return this.f40997a;
    }
}
