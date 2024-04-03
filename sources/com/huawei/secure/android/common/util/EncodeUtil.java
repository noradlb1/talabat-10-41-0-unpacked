package com.huawei.secure.android.common.util;

import android.text.TextUtils;
import android.util.Log;
import java.util.Locale;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;
import org.apache.commons.compress.archivers.tar.TarConstants;
import org.apache.commons.lang3.CharUtils;

public class EncodeUtil {

    /* renamed from: a  reason: collision with root package name */
    private static final String f33977a = "EncodeUtil";

    /* renamed from: b  reason: collision with root package name */
    private static final char[] f33978b = {AbstractJsonLexerKt.COMMA, '.', SignatureVisitor.SUPER, '_'};

    /* renamed from: c  reason: collision with root package name */
    private static final String[] f33979c = new String[256];

    static {
        for (char c11 = 0; c11 < 255; c11 = (char) (c11 + 1)) {
            if ((c11 < '0' || c11 > '9') && ((c11 < 'A' || c11 > 'Z') && (c11 < 'a' || c11 > 'z'))) {
                f33979c[c11] = b(c11).intern();
            } else {
                f33979c[c11] = null;
            }
        }
    }

    private static String a(char[] cArr, String str) {
        StringBuilder sb2 = new StringBuilder();
        for (int i11 = 0; i11 < str.length(); i11++) {
            sb2.append(a(cArr, Character.valueOf(str.charAt(i11))));
        }
        return sb2.toString();
    }

    private static String b(char c11) {
        return Integer.toHexString(c11);
    }

    public static String decodeForJavaScript(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            StringBuilder sb2 = new StringBuilder();
            a aVar = new a(str);
            while (aVar.a()) {
                Character a11 = a(aVar);
                if (a11 != null) {
                    sb2.append(a11);
                } else {
                    sb2.append(aVar.d());
                }
            }
            return sb2.toString();
        } catch (Exception e11) {
            String str2 = f33977a;
            Log.e(str2, "decode js: " + e11.getMessage());
            return "";
        }
    }

    public static String encodeForJavaScript(String str) {
        return encodeForJavaScript(str, f33978b);
    }

    public static String encodeForJavaScript(String str, char[] cArr) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return a(cArr, str);
        } catch (Exception e11) {
            String str2 = f33977a;
            Log.e(str2, "encode js: " + e11.getMessage());
            return "";
        }
    }

    private static String a(char[] cArr, Character ch2) {
        if (a(ch2.charValue(), cArr)) {
            return "" + ch2;
        } else if (a(ch2.charValue()) == null) {
            return "" + ch2;
        } else {
            String hexString = Integer.toHexString(ch2.charValue());
            if (ch2.charValue() < 256) {
                return "\\x" + TarConstants.VERSION_POSIX.substring(hexString.length()) + hexString.toUpperCase(Locale.ENGLISH);
            }
            return "\\u" + "0000".substring(hexString.length()) + hexString.toUpperCase(Locale.ENGLISH);
        }
    }

    private static boolean a(char c11, char[] cArr) {
        for (char c12 : cArr) {
            if (c11 == c12) {
                return true;
            }
        }
        return false;
    }

    private static String a(char c11) {
        if (c11 < 255) {
            return f33979c[c11];
        }
        return b(c11);
    }

    private static Character a(a aVar) {
        aVar.c();
        Character d11 = aVar.d();
        if (d11 == null) {
            aVar.i();
            return null;
        } else if (d11.charValue() != '\\') {
            aVar.i();
            return null;
        } else {
            Character d12 = aVar.d();
            if (d12 == null) {
                aVar.i();
                return null;
            } else if (d12.charValue() == 'b') {
                return 8;
            } else {
                if (d12.charValue() == 't') {
                    return 9;
                }
                if (d12.charValue() == 'n') {
                    return 10;
                }
                if (d12.charValue() == 'v') {
                    return 11;
                }
                if (d12.charValue() == 'f') {
                    return 12;
                }
                if (d12.charValue() == 'r') {
                    return Character.valueOf(CharUtils.CR);
                }
                if (d12.charValue() == '\"') {
                    return '\"';
                }
                if (d12.charValue() == '\'') {
                    return '\'';
                }
                if (d12.charValue() == '\\') {
                    return '\\';
                }
                int i11 = 0;
                if (Character.toLowerCase(d12.charValue()) == 'x') {
                    StringBuilder sb2 = new StringBuilder();
                    while (i11 < 2) {
                        Character e11 = aVar.e();
                        if (e11 != null) {
                            sb2.append(e11);
                            i11++;
                        } else {
                            aVar.i();
                            return null;
                        }
                    }
                    try {
                        int parseInt = Integer.parseInt(sb2.toString(), 16);
                        if (Character.isValidCodePoint(parseInt)) {
                            return Character.valueOf((char) parseInt);
                        }
                    } catch (NumberFormatException unused) {
                        aVar.i();
                        return null;
                    }
                } else if (Character.toLowerCase(d12.charValue()) == 'u') {
                    StringBuilder sb3 = new StringBuilder();
                    while (i11 < 4) {
                        Character e12 = aVar.e();
                        if (e12 != null) {
                            sb3.append(e12);
                            i11++;
                        } else {
                            aVar.i();
                            return null;
                        }
                    }
                    try {
                        int parseInt2 = Integer.parseInt(sb3.toString(), 16);
                        if (Character.isValidCodePoint(parseInt2)) {
                            return Character.valueOf((char) parseInt2);
                        }
                    } catch (NumberFormatException unused2) {
                        aVar.i();
                        return null;
                    }
                } else if (a.c(d12)) {
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append(d12);
                    Character d13 = aVar.d();
                    if (!a.c(d13)) {
                        aVar.a(d13);
                    } else {
                        sb4.append(d13);
                        Character d14 = aVar.d();
                        if (!a.c(d14)) {
                            aVar.a(d14);
                        } else {
                            sb4.append(d14);
                        }
                    }
                    try {
                        int parseInt3 = Integer.parseInt(sb4.toString(), 8);
                        if (Character.isValidCodePoint(parseInt3)) {
                            return Character.valueOf((char) parseInt3);
                        }
                    } catch (NumberFormatException unused3) {
                        aVar.i();
                        return null;
                    }
                }
                return d12;
            }
        }
    }
}
