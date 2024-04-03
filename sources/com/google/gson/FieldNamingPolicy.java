package com.google.gson;

import java.lang.reflect.Field;
import java.util.Locale;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;

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
            return FieldNamingPolicy.upperCaseFirstLetter(FieldNamingPolicy.separateCamelCase(field.getName(), ' '));
        }
    },
    UPPER_CASE_WITH_UNDERSCORES {
        public String translateName(Field field) {
            return FieldNamingPolicy.separateCamelCase(field.getName(), '_').toUpperCase(Locale.ENGLISH);
        }
    },
    LOWER_CASE_WITH_UNDERSCORES {
        public String translateName(Field field) {
            return FieldNamingPolicy.separateCamelCase(field.getName(), '_').toLowerCase(Locale.ENGLISH);
        }
    },
    LOWER_CASE_WITH_DASHES {
        public String translateName(Field field) {
            return FieldNamingPolicy.separateCamelCase(field.getName(), SignatureVisitor.SUPER).toLowerCase(Locale.ENGLISH);
        }
    },
    LOWER_CASE_WITH_DOTS {
        public String translateName(Field field) {
            return FieldNamingPolicy.separateCamelCase(field.getName(), '.').toLowerCase(Locale.ENGLISH);
        }
    };

    public static String separateCamelCase(String str, char c11) {
        StringBuilder sb2 = new StringBuilder();
        int length = str.length();
        for (int i11 = 0; i11 < length; i11++) {
            char charAt = str.charAt(i11);
            if (Character.isUpperCase(charAt) && sb2.length() != 0) {
                sb2.append(c11);
            }
            sb2.append(charAt);
        }
        return sb2.toString();
    }

    public static String upperCaseFirstLetter(String str) {
        int length = str.length();
        int i11 = 0;
        while (i11 < length) {
            char charAt = str.charAt(i11);
            if (!Character.isLetter(charAt)) {
                i11++;
            } else if (Character.isUpperCase(charAt)) {
                return str;
            } else {
                char upperCase = Character.toUpperCase(charAt);
                if (i11 == 0) {
                    return upperCase + str.substring(1);
                }
                return str.substring(0, i11) + upperCase + str.substring(i11 + 1);
            }
        }
        return str;
    }
}
