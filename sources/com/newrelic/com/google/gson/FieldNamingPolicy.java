package com.newrelic.com.google.gson;

import com.talabat.configuration.discovery.RealDiscoveryConfigurationRepository;
import com.talabat.sidemenu.SideMenuRewardViewHolder;
import java.lang.reflect.Field;
import java.util.Locale;
import net.bytebuddy.utility.JavaConstant;

public enum FieldNamingPolicy implements FieldNamingStrategy {
    IDENTITY {
        public String translateName(Field field) {
            return field.getName();
        }
    },
    UPPER_CAMEL_CASE {
        public String translateName(Field field) {
            return FieldNamingPolicy.upperCaseFirstLetter(field.getName());
        }
    },
    UPPER_CAMEL_CASE_WITH_SPACES {
        public String translateName(Field field) {
            return FieldNamingPolicy.upperCaseFirstLetter(FieldNamingPolicy.separateCamelCase(field.getName(), " "));
        }
    },
    LOWER_CASE_WITH_UNDERSCORES {
        public String translateName(Field field) {
            return FieldNamingPolicy.separateCamelCase(field.getName(), JavaConstant.Dynamic.DEFAULT_NAME).toLowerCase(Locale.ENGLISH);
        }
    },
    LOWER_CASE_WITH_DASHES {
        public String translateName(Field field) {
            return FieldNamingPolicy.separateCamelCase(field.getName(), SideMenuRewardViewHolder.DEFAULT_LOGGED_IN_USER_POINTS_VALUE).toLowerCase(Locale.ENGLISH);
        }
    },
    LOWER_CASE_WITH_DOTS {
        public String translateName(Field field) {
            return FieldNamingPolicy.separateCamelCase(field.getName(), RealDiscoveryConfigurationRepository.VERSION_DELIMETER).toLowerCase(Locale.ENGLISH);
        }
    };

    public static String separateCamelCase(String str, String str2) {
        StringBuilder sb2 = new StringBuilder();
        int length = str.length();
        for (int i11 = 0; i11 < length; i11++) {
            char charAt = str.charAt(i11);
            if (Character.isUpperCase(charAt) && sb2.length() != 0) {
                sb2.append(str2);
            }
            sb2.append(charAt);
        }
        return sb2.toString();
    }

    public static String upperCaseFirstLetter(String str) {
        int length = str.length() - 1;
        int i11 = 0;
        while (!Character.isLetter(str.charAt(i11)) && i11 < length) {
            i11++;
        }
        char charAt = str.charAt(i11);
        if (Character.isUpperCase(charAt)) {
            return str;
        }
        char upperCase = Character.toUpperCase(charAt);
        if (i11 == 0) {
            return upperCase + str.substring(1);
        }
        return str.substring(0, i11) + upperCase + str.substring(i11 + 1);
    }
}
