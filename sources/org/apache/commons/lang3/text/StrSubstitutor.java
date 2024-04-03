package org.apache.commons.lang3.text;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import org.apache.commons.lang3.StringUtils;

public class StrSubstitutor {
    public static final char DEFAULT_ESCAPE = '$';
    public static final StrMatcher DEFAULT_PREFIX = StrMatcher.stringMatcher("${");
    public static final StrMatcher DEFAULT_SUFFIX = StrMatcher.stringMatcher("}");
    public static final StrMatcher DEFAULT_VALUE_DELIMITER = StrMatcher.stringMatcher(":-");
    private boolean enableSubstitutionInVariables;
    private char escapeChar;
    private StrMatcher prefixMatcher;
    private StrMatcher suffixMatcher;
    private StrMatcher valueDelimiterMatcher;
    private StrLookup<?> variableResolver;

    public StrSubstitutor() {
        this((StrLookup<?>) null, DEFAULT_PREFIX, DEFAULT_SUFFIX, '$');
    }

    private void checkCyclicSubstitution(String str, List<String> list) {
        if (list.contains(str)) {
            StrBuilder strBuilder = new StrBuilder(256);
            strBuilder.append("Infinite loop in property interpolation of ");
            strBuilder.append(list.remove(0));
            strBuilder.append(": ");
            strBuilder.appendWithSeparators((Iterable<?>) list, "->");
            throw new IllegalStateException(strBuilder.toString());
        }
    }

    public static <V> String replace(Object obj, Map<String, V> map) {
        return new StrSubstitutor(map).replace(obj);
    }

    public static String replaceSystemProperties(Object obj) {
        return new StrSubstitutor((StrLookup<?>) StrLookup.systemPropertiesLookup()).replace(obj);
    }

    public char getEscapeChar() {
        return this.escapeChar;
    }

    public StrMatcher getValueDelimiterMatcher() {
        return this.valueDelimiterMatcher;
    }

    public StrMatcher getVariablePrefixMatcher() {
        return this.prefixMatcher;
    }

    public StrLookup<?> getVariableResolver() {
        return this.variableResolver;
    }

    public StrMatcher getVariableSuffixMatcher() {
        return this.suffixMatcher;
    }

    public boolean isEnableSubstitutionInVariables() {
        return this.enableSubstitutionInVariables;
    }

    public boolean replaceIn(StringBuffer stringBuffer) {
        if (stringBuffer == null) {
            return false;
        }
        return replaceIn(stringBuffer, 0, stringBuffer.length());
    }

    public String resolveVariable(String str, StrBuilder strBuilder, int i11, int i12) {
        StrLookup<?> variableResolver2 = getVariableResolver();
        if (variableResolver2 == null) {
            return null;
        }
        return variableResolver2.lookup(str);
    }

    public void setEnableSubstitutionInVariables(boolean z11) {
        this.enableSubstitutionInVariables = z11;
    }

    public void setEscapeChar(char c11) {
        this.escapeChar = c11;
    }

    public StrSubstitutor setValueDelimiter(char c11) {
        return setValueDelimiterMatcher(StrMatcher.charMatcher(c11));
    }

    public StrSubstitutor setValueDelimiterMatcher(StrMatcher strMatcher) {
        this.valueDelimiterMatcher = strMatcher;
        return this;
    }

    public StrSubstitutor setVariablePrefix(char c11) {
        return setVariablePrefixMatcher(StrMatcher.charMatcher(c11));
    }

    public StrSubstitutor setVariablePrefixMatcher(StrMatcher strMatcher) {
        if (strMatcher != null) {
            this.prefixMatcher = strMatcher;
            return this;
        }
        throw new IllegalArgumentException("Variable prefix matcher must not be null!");
    }

    public void setVariableResolver(StrLookup<?> strLookup) {
        this.variableResolver = strLookup;
    }

    public StrSubstitutor setVariableSuffix(char c11) {
        return setVariableSuffixMatcher(StrMatcher.charMatcher(c11));
    }

    public StrSubstitutor setVariableSuffixMatcher(StrMatcher strMatcher) {
        if (strMatcher != null) {
            this.suffixMatcher = strMatcher;
            return this;
        }
        throw new IllegalArgumentException("Variable suffix matcher must not be null!");
    }

    public boolean substitute(StrBuilder strBuilder, int i11, int i12) {
        return substitute(strBuilder, i11, i12, (List<String>) null) > 0;
    }

    public <V> StrSubstitutor(Map<String, V> map) {
        this((StrLookup<?>) StrLookup.mapLookup(map), DEFAULT_PREFIX, DEFAULT_SUFFIX, '$');
    }

    public static <V> String replace(Object obj, Map<String, V> map, String str, String str2) {
        return new StrSubstitutor(map, str, str2).replace(obj);
    }

    private int substitute(StrBuilder strBuilder, int i11, int i12, List<String> list) {
        StrMatcher strMatcher;
        boolean z11;
        char c11;
        StrMatcher strMatcher2;
        String str;
        int isMatch;
        StrBuilder strBuilder2 = strBuilder;
        int i13 = i11;
        int i14 = i12;
        StrMatcher variablePrefixMatcher = getVariablePrefixMatcher();
        StrMatcher variableSuffixMatcher = getVariableSuffixMatcher();
        char escapeChar2 = getEscapeChar();
        StrMatcher valueDelimiterMatcher2 = getValueDelimiterMatcher();
        boolean isEnableSubstitutionInVariables = isEnableSubstitutionInVariables();
        boolean z12 = list == null;
        int i15 = i13;
        int i16 = i13 + i14;
        int i17 = 0;
        int i18 = 0;
        char[] cArr = strBuilder2.buffer;
        List<String> list2 = list;
        while (i15 < i16) {
            int isMatch2 = variablePrefixMatcher.isMatch(cArr, i15, i13, i16);
            if (isMatch2 != 0) {
                if (i15 > i13) {
                    int i19 = i15 - 1;
                    if (cArr[i19] == escapeChar2) {
                        strBuilder2.deleteCharAt(i19);
                        i17--;
                        i16--;
                        strMatcher = variablePrefixMatcher;
                        strMatcher2 = variableSuffixMatcher;
                        c11 = escapeChar2;
                        cArr = strBuilder2.buffer;
                        z11 = z12;
                        i18 = 1;
                    }
                }
                int i21 = i15 + isMatch2;
                int i22 = i21;
                int i23 = 0;
                while (true) {
                    if (i22 >= i16) {
                        strMatcher = variablePrefixMatcher;
                        strMatcher2 = variableSuffixMatcher;
                        c11 = escapeChar2;
                        z11 = z12;
                        i15 = i22;
                        break;
                    } else if (!isEnableSubstitutionInVariables || (isMatch = variablePrefixMatcher.isMatch(cArr, i22, i13, i16)) == 0) {
                        int isMatch3 = variableSuffixMatcher.isMatch(cArr, i22, i13, i16);
                        if (isMatch3 == 0) {
                            i22++;
                        } else if (i23 == 0) {
                            strMatcher2 = variableSuffixMatcher;
                            c11 = escapeChar2;
                            String str2 = new String(cArr, i21, (i22 - i15) - isMatch2);
                            if (isEnableSubstitutionInVariables) {
                                StrBuilder strBuilder3 = new StrBuilder(str2);
                                substitute(strBuilder3, 0, strBuilder3.length());
                                str2 = strBuilder3.toString();
                            }
                            int i24 = i22 + isMatch3;
                            if (valueDelimiterMatcher2 != null) {
                                char[] charArray = str2.toCharArray();
                                z11 = z12;
                                int i25 = 0;
                                while (i25 < charArray.length && (isEnableSubstitutionInVariables || variablePrefixMatcher.isMatch(charArray, i25, i25, charArray.length) == 0)) {
                                    int isMatch4 = valueDelimiterMatcher2.isMatch(charArray, i25);
                                    if (isMatch4 != 0) {
                                        strMatcher = variablePrefixMatcher;
                                        String substring = str2.substring(0, i25);
                                        str = str2.substring(i25 + isMatch4);
                                        str2 = substring;
                                        break;
                                    }
                                    i25++;
                                    variablePrefixMatcher = variablePrefixMatcher;
                                }
                                strMatcher = variablePrefixMatcher;
                            } else {
                                strMatcher = variablePrefixMatcher;
                                z11 = z12;
                            }
                            str = null;
                            if (list2 == null) {
                                list2 = new ArrayList<>();
                                list2.add(new String(cArr, i13, i14));
                            }
                            checkCyclicSubstitution(str2, list2);
                            list2.add(str2);
                            String resolveVariable = resolveVariable(str2, strBuilder2, i15, i24);
                            if (resolveVariable != null) {
                                str = resolveVariable;
                            }
                            if (str != null) {
                                int length = str.length();
                                strBuilder2.replace(i15, i24, str);
                                int substitute = (substitute(strBuilder2, i15, length, list2) + length) - (i24 - i15);
                                i16 += substitute;
                                i17 += substitute;
                                cArr = strBuilder2.buffer;
                                i15 = i24 + substitute;
                                i18 = 1;
                            } else {
                                i15 = i24;
                            }
                            list2.remove(list2.size() - 1);
                        } else {
                            StrMatcher strMatcher3 = variableSuffixMatcher;
                            boolean z13 = z12;
                            i23--;
                            i22 += isMatch3;
                            escapeChar2 = escapeChar2;
                            variablePrefixMatcher = variablePrefixMatcher;
                        }
                    } else {
                        i23++;
                        i22 += isMatch;
                    }
                }
            } else {
                i15++;
                strMatcher = variablePrefixMatcher;
                strMatcher2 = variableSuffixMatcher;
                c11 = escapeChar2;
                z11 = z12;
            }
            variableSuffixMatcher = strMatcher2;
            escapeChar2 = c11;
            z12 = z11;
            variablePrefixMatcher = strMatcher;
        }
        return z12 ? i18 : i17;
    }

    public boolean replaceIn(StringBuffer stringBuffer, int i11, int i12) {
        if (stringBuffer == null) {
            return false;
        }
        StrBuilder append = new StrBuilder(i12).append(stringBuffer, i11, i12);
        if (!substitute(append, 0, i12)) {
            return false;
        }
        stringBuffer.replace(i11, i12 + i11, append.toString());
        return true;
    }

    public StrSubstitutor setValueDelimiter(String str) {
        if (!StringUtils.isEmpty(str)) {
            return setValueDelimiterMatcher(StrMatcher.stringMatcher(str));
        }
        setValueDelimiterMatcher((StrMatcher) null);
        return this;
    }

    public StrSubstitutor setVariablePrefix(String str) {
        if (str != null) {
            return setVariablePrefixMatcher(StrMatcher.stringMatcher(str));
        }
        throw new IllegalArgumentException("Variable prefix must not be null!");
    }

    public StrSubstitutor setVariableSuffix(String str) {
        if (str != null) {
            return setVariableSuffixMatcher(StrMatcher.stringMatcher(str));
        }
        throw new IllegalArgumentException("Variable suffix must not be null!");
    }

    public <V> StrSubstitutor(Map<String, V> map, String str, String str2) {
        this((StrLookup<?>) StrLookup.mapLookup(map), str, str2, '$');
    }

    public static String replace(Object obj, Properties properties) {
        if (properties == null) {
            return obj.toString();
        }
        HashMap hashMap = new HashMap();
        Enumeration<?> propertyNames = properties.propertyNames();
        while (propertyNames.hasMoreElements()) {
            String str = (String) propertyNames.nextElement();
            hashMap.put(str, properties.getProperty(str));
        }
        return replace(obj, hashMap);
    }

    public <V> StrSubstitutor(Map<String, V> map, String str, String str2, char c11) {
        this((StrLookup<?>) StrLookup.mapLookup(map), str, str2, c11);
    }

    public <V> StrSubstitutor(Map<String, V> map, String str, String str2, char c11, String str3) {
        this((StrLookup<?>) StrLookup.mapLookup(map), str, str2, c11, str3);
    }

    public boolean replaceIn(StringBuilder sb2) {
        if (sb2 == null) {
            return false;
        }
        return replaceIn(sb2, 0, sb2.length());
    }

    public StrSubstitutor(StrLookup<?> strLookup) {
        this(strLookup, DEFAULT_PREFIX, DEFAULT_SUFFIX, '$');
    }

    public boolean replaceIn(StringBuilder sb2, int i11, int i12) {
        if (sb2 == null) {
            return false;
        }
        StrBuilder append = new StrBuilder(i12).append(sb2, i11, i12);
        if (!substitute(append, 0, i12)) {
            return false;
        }
        sb2.replace(i11, i12 + i11, append.toString());
        return true;
    }

    public StrSubstitutor(StrLookup<?> strLookup, String str, String str2, char c11) {
        setVariableResolver(strLookup);
        setVariablePrefix(str);
        setVariableSuffix(str2);
        setEscapeChar(c11);
        setValueDelimiterMatcher(DEFAULT_VALUE_DELIMITER);
    }

    public boolean replaceIn(StrBuilder strBuilder) {
        if (strBuilder == null) {
            return false;
        }
        return substitute(strBuilder, 0, strBuilder.length());
    }

    public boolean replaceIn(StrBuilder strBuilder, int i11, int i12) {
        if (strBuilder == null) {
            return false;
        }
        return substitute(strBuilder, i11, i12);
    }

    public String replace(String str) {
        if (str == null) {
            return null;
        }
        StrBuilder strBuilder = new StrBuilder(str);
        if (!substitute(strBuilder, 0, str.length())) {
            return str;
        }
        return strBuilder.toString();
    }

    public StrSubstitutor(StrLookup<?> strLookup, String str, String str2, char c11, String str3) {
        setVariableResolver(strLookup);
        setVariablePrefix(str);
        setVariableSuffix(str2);
        setEscapeChar(c11);
        setValueDelimiter(str3);
    }

    public String replace(String str, int i11, int i12) {
        if (str == null) {
            return null;
        }
        StrBuilder append = new StrBuilder(i12).append(str, i11, i12);
        if (!substitute(append, 0, i12)) {
            return str.substring(i11, i12 + i11);
        }
        return append.toString();
    }

    public String replace(char[] cArr) {
        if (cArr == null) {
            return null;
        }
        StrBuilder append = new StrBuilder(cArr.length).append(cArr);
        substitute(append, 0, cArr.length);
        return append.toString();
    }

    public StrSubstitutor(StrLookup<?> strLookup, StrMatcher strMatcher, StrMatcher strMatcher2, char c11) {
        this(strLookup, strMatcher, strMatcher2, c11, DEFAULT_VALUE_DELIMITER);
    }

    public StrSubstitutor(StrLookup<?> strLookup, StrMatcher strMatcher, StrMatcher strMatcher2, char c11, StrMatcher strMatcher3) {
        setVariableResolver(strLookup);
        setVariablePrefixMatcher(strMatcher);
        setVariableSuffixMatcher(strMatcher2);
        setEscapeChar(c11);
        setValueDelimiterMatcher(strMatcher3);
    }

    public String replace(char[] cArr, int i11, int i12) {
        if (cArr == null) {
            return null;
        }
        StrBuilder append = new StrBuilder(i12).append(cArr, i11, i12);
        substitute(append, 0, i12);
        return append.toString();
    }

    public String replace(StringBuffer stringBuffer) {
        if (stringBuffer == null) {
            return null;
        }
        StrBuilder append = new StrBuilder(stringBuffer.length()).append(stringBuffer);
        substitute(append, 0, append.length());
        return append.toString();
    }

    public String replace(StringBuffer stringBuffer, int i11, int i12) {
        if (stringBuffer == null) {
            return null;
        }
        StrBuilder append = new StrBuilder(i12).append(stringBuffer, i11, i12);
        substitute(append, 0, i12);
        return append.toString();
    }

    public String replace(CharSequence charSequence) {
        if (charSequence == null) {
            return null;
        }
        return replace(charSequence, 0, charSequence.length());
    }

    public String replace(CharSequence charSequence, int i11, int i12) {
        if (charSequence == null) {
            return null;
        }
        StrBuilder append = new StrBuilder(i12).append(charSequence, i11, i12);
        substitute(append, 0, i12);
        return append.toString();
    }

    public String replace(StrBuilder strBuilder) {
        if (strBuilder == null) {
            return null;
        }
        StrBuilder append = new StrBuilder(strBuilder.length()).append(strBuilder);
        substitute(append, 0, append.length());
        return append.toString();
    }

    public String replace(StrBuilder strBuilder, int i11, int i12) {
        if (strBuilder == null) {
            return null;
        }
        StrBuilder append = new StrBuilder(i12).append(strBuilder, i11, i12);
        substitute(append, 0, i12);
        return append.toString();
    }

    public String replace(Object obj) {
        if (obj == null) {
            return null;
        }
        StrBuilder append = new StrBuilder().append(obj);
        substitute(append, 0, append.length());
        return append.toString();
    }
}
