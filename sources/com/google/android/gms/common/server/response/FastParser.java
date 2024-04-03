package com.google.android.gms.common.server.response;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.C;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.common.util.JsonUtils;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import net.bytebuddy.asm.Advice;
import okio.internal._BufferKt;

@ShowFirstParty
@KeepForSdk
public class FastParser<T extends FastJsonResponse> {
    private static final char[] zaa = {AbstractJsonLexerKt.UNICODE_ESC, 'l', 'l'};
    private static final char[] zab = {Advice.OffsetMapping.ForOrigin.Renderer.ForReturnTypeName.SYMBOL, AbstractJsonLexerKt.UNICODE_ESC, 'e'};
    private static final char[] zac = {Advice.OffsetMapping.ForOrigin.Renderer.ForReturnTypeName.SYMBOL, AbstractJsonLexerKt.UNICODE_ESC, 'e', '\"'};
    private static final char[] zad = {'a', 'l', Advice.OffsetMapping.ForOrigin.Renderer.ForJavaSignature.SYMBOL, 'e'};
    private static final char[] zae = {'a', 'l', Advice.OffsetMapping.ForOrigin.Renderer.ForJavaSignature.SYMBOL, 'e', '\"'};
    private static final char[] zaf = {10};
    private static final zai zag = new zaa();
    private static final zai zah = new zab();
    private static final zai zai = new zac();
    private static final zai zaj = new zad();
    private static final zai zak = new zae();
    private static final zai zal = new zaf();
    private static final zai zam = new zag();
    private static final zai zan = new zah();
    private final char[] zao = new char[1];
    private final char[] zap = new char[32];
    private final char[] zaq = new char[1024];
    private final StringBuilder zar = new StringBuilder(32);
    private final StringBuilder zas = new StringBuilder(1024);
    private final Stack zat = new Stack();

    @ShowFirstParty
    @KeepForSdk
    public static class ParseException extends Exception {
        public ParseException(@NonNull String str) {
            super(str);
        }

        public ParseException(@NonNull String str, @NonNull Throwable th2) {
            super("Error instantiating inner object", th2);
        }

        public ParseException(@NonNull Throwable th2) {
            super(th2);
        }
    }

    private static final String zaA(BufferedReader bufferedReader, char[] cArr, StringBuilder sb2, @Nullable char[] cArr2) throws ParseException, IOException {
        sb2.setLength(0);
        bufferedReader.mark(cArr.length);
        boolean z11 = false;
        boolean z12 = false;
        loop0:
        while (true) {
            int read = bufferedReader.read(cArr);
            if (read != -1) {
                for (int i11 = 0; i11 < read; i11++) {
                    char c11 = cArr[i11];
                    if (Character.isISOControl(c11)) {
                        if (cArr2 == null) {
                            break loop0;
                        }
                        int i12 = 0;
                        while (i12 <= 0) {
                            if (cArr2[i12] != c11) {
                                i12++;
                            }
                        }
                        break loop0;
                    }
                    if (c11 == '\"') {
                        if (!z11) {
                            sb2.append(cArr, 0, i11);
                            bufferedReader.reset();
                            bufferedReader.skip((long) (i11 + 1));
                            if (z12) {
                                return JsonUtils.unescapeString(sb2.toString());
                            }
                            return sb2.toString();
                        }
                    } else if (c11 == '\\') {
                        z11 = !z11;
                        z12 = true;
                    }
                    z11 = false;
                }
                sb2.append(cArr, 0, read);
                bufferedReader.mark(cArr.length);
            } else {
                throw new ParseException("Unexpected EOF while parsing string");
            }
        }
        throw new ParseException("Unexpected control character while reading string");
    }

    private final char zai(BufferedReader bufferedReader) throws ParseException, IOException {
        if (bufferedReader.read(this.zao) == -1) {
            return 0;
        }
        while (Character.isWhitespace(this.zao[0])) {
            if (bufferedReader.read(this.zao) == -1) {
                return 0;
            }
        }
        return this.zao[0];
    }

    /* access modifiers changed from: private */
    public final double zaj(BufferedReader bufferedReader) throws ParseException, IOException {
        int zam2 = zam(bufferedReader, this.zaq);
        if (zam2 == 0) {
            return 0.0d;
        }
        return Double.parseDouble(new String(this.zaq, 0, zam2));
    }

    /* access modifiers changed from: private */
    public final float zak(BufferedReader bufferedReader) throws ParseException, IOException {
        int zam2 = zam(bufferedReader, this.zaq);
        if (zam2 == 0) {
            return 0.0f;
        }
        return Float.parseFloat(new String(this.zaq, 0, zam2));
    }

    /* access modifiers changed from: private */
    public final int zal(BufferedReader bufferedReader) throws ParseException, IOException {
        int i11;
        int i12;
        int i13;
        int i14;
        int zam2 = zam(bufferedReader, this.zaq);
        if (zam2 == 0) {
            return 0;
        }
        char[] cArr = this.zaq;
        if (zam2 > 0) {
            char c11 = cArr[0];
            if (c11 == '-') {
                i11 = Integer.MIN_VALUE;
            } else {
                i11 = C.RATE_UNSET_INT;
            }
            if (c11 == '-') {
                i12 = 1;
            } else {
                i12 = 0;
            }
            if (i12 < zam2) {
                i14 = i12 + 1;
                int digit = Character.digit(cArr[i12], 10);
                if (digit >= 0) {
                    i13 = -digit;
                } else {
                    throw new ParseException("Unexpected non-digit character");
                }
            } else {
                i13 = 0;
                i14 = i12;
            }
            while (i14 < zam2) {
                int i15 = i14 + 1;
                int digit2 = Character.digit(cArr[i14], 10);
                if (digit2 < 0) {
                    throw new ParseException("Unexpected non-digit character");
                } else if (i13 >= -214748364) {
                    int i16 = i13 * 10;
                    if (i16 >= i11 + digit2) {
                        i13 = i16 - digit2;
                        i14 = i15;
                    } else {
                        throw new ParseException("Number too large");
                    }
                } else {
                    throw new ParseException("Number too large");
                }
            }
            if (i12 == 0) {
                return -i13;
            }
            if (i14 > 1) {
                return i13;
            }
            throw new ParseException("No digits to parse");
        }
        throw new ParseException("No number to parse");
    }

    @ResultIgnorabilityUnspecified
    private final int zam(BufferedReader bufferedReader, char[] cArr) throws ParseException, IOException {
        int i11;
        char zai2 = zai(bufferedReader);
        if (zai2 == 0) {
            throw new ParseException("Unexpected EOF");
        } else if (zai2 == ',') {
            throw new ParseException("Missing value");
        } else if (zai2 == 'n') {
            zax(bufferedReader, zaa);
            return 0;
        } else {
            bufferedReader.mark(1024);
            if (zai2 == '\"') {
                i11 = 0;
                boolean z11 = false;
                while (i11 < 1024 && bufferedReader.read(cArr, i11, 1) != -1) {
                    char c11 = cArr[i11];
                    if (!Character.isISOControl(c11)) {
                        if (c11 == '\"') {
                            if (!z11) {
                                bufferedReader.reset();
                                bufferedReader.skip((long) (i11 + 1));
                                return i11;
                            }
                        } else if (c11 == '\\') {
                            z11 = !z11;
                            i11++;
                        }
                        z11 = false;
                        i11++;
                    } else {
                        throw new ParseException("Unexpected control character while reading string");
                    }
                }
            } else {
                cArr[0] = zai2;
                int i12 = 1;
                while (i11 < 1024 && bufferedReader.read(cArr, i11, 1) != -1) {
                    char c12 = cArr[i11];
                    if (c12 == '}' || c12 == ',' || Character.isWhitespace(c12) || cArr[i11] == ']') {
                        bufferedReader.reset();
                        bufferedReader.skip((long) (i11 - 1));
                        cArr[i11] = 0;
                        return i11;
                    }
                    i12 = i11 + 1;
                }
            }
            if (i11 == 1024) {
                throw new ParseException("Absurdly long value");
            }
            throw new ParseException("Unexpected EOF");
        }
    }

    /* access modifiers changed from: private */
    public final long zan(BufferedReader bufferedReader) throws ParseException, IOException {
        long j11;
        long j12;
        int i11;
        int zam2 = zam(bufferedReader, this.zaq);
        if (zam2 == 0) {
            return 0;
        }
        char[] cArr = this.zaq;
        if (zam2 > 0) {
            int i12 = 0;
            char c11 = cArr[0];
            if (c11 == '-') {
                j11 = Long.MIN_VALUE;
            } else {
                j11 = C.TIME_UNSET;
            }
            if (c11 == '-') {
                i12 = 1;
            }
            if (i12 < zam2) {
                i11 = i12 + 1;
                int digit = Character.digit(cArr[i12], 10);
                if (digit >= 0) {
                    j12 = (long) (-digit);
                } else {
                    throw new ParseException("Unexpected non-digit character");
                }
            } else {
                j12 = 0;
                i11 = i12;
            }
            while (i11 < zam2) {
                int i13 = i11 + 1;
                int digit2 = Character.digit(cArr[i11], 10);
                if (digit2 < 0) {
                    throw new ParseException("Unexpected non-digit character");
                } else if (j12 >= _BufferKt.OVERFLOW_ZONE) {
                    long j13 = j12 * 10;
                    int i14 = zam2;
                    long j14 = (long) digit2;
                    if (j13 >= j11 + j14) {
                        j12 = j13 - j14;
                        zam2 = i14;
                        i11 = i13;
                    } else {
                        throw new ParseException("Number too large");
                    }
                } else {
                    throw new ParseException("Number too large");
                }
            }
            if (i12 == 0) {
                return -j12;
            }
            if (i11 > 1) {
                return j12;
            }
            throw new ParseException("No digits to parse");
        }
        throw new ParseException("No number to parse");
    }

    /* access modifiers changed from: private */
    @Nullable
    public final String zao(BufferedReader bufferedReader) throws ParseException, IOException {
        return zap(bufferedReader, this.zap, this.zar, (char[]) null);
    }

    @Nullable
    private final String zap(BufferedReader bufferedReader, char[] cArr, StringBuilder sb2, @Nullable char[] cArr2) throws ParseException, IOException {
        char zai2 = zai(bufferedReader);
        if (zai2 == '\"') {
            return zaA(bufferedReader, cArr, sb2, cArr2);
        }
        if (zai2 == 'n') {
            zax(bufferedReader, zaa);
            return null;
        }
        throw new ParseException("Expected string");
    }

    @ResultIgnorabilityUnspecified
    @Nullable
    private final String zaq(BufferedReader bufferedReader) throws ParseException, IOException {
        this.zat.push(2);
        char zai2 = zai(bufferedReader);
        if (zai2 == '\"') {
            this.zat.push(3);
            String zaA = zaA(bufferedReader, this.zap, this.zar, (char[]) null);
            zaw(3);
            if (zai(bufferedReader) == ':') {
                return zaA;
            }
            throw new ParseException("Expected key/value separator");
        } else if (zai2 == ']') {
            zaw(2);
            zaw(1);
            zaw(5);
            return null;
        } else if (zai2 == '}') {
            zaw(2);
            return null;
        } else {
            throw new ParseException("Unexpected token: " + zai2);
        }
    }

    @Nullable
    private final String zar(BufferedReader bufferedReader) throws ParseException, IOException {
        bufferedReader.mark(1024);
        char zai2 = zai(bufferedReader);
        int i11 = 1;
        if (zai2 != '\"') {
            if (zai2 == ',') {
                throw new ParseException("Missing value");
            } else if (zai2 == '[') {
                this.zat.push(5);
                bufferedReader.mark(32);
                if (zai(bufferedReader) == ']') {
                    zaw(5);
                } else {
                    bufferedReader.reset();
                    boolean z11 = false;
                    boolean z12 = false;
                    while (i11 > 0) {
                        char zai3 = zai(bufferedReader);
                        if (zai3 == 0) {
                            throw new ParseException("Unexpected EOF while parsing array");
                        } else if (!Character.isISOControl(zai3)) {
                            if (zai3 == '\"') {
                                if (!z12) {
                                    z11 = !z11;
                                }
                                zai3 = '\"';
                            }
                            if (zai3 == '[') {
                                if (!z11) {
                                    i11++;
                                }
                                zai3 = '[';
                            }
                            if (zai3 == ']' && !z11) {
                                i11--;
                            }
                            if (zai3 != '\\' || !z11) {
                                z12 = false;
                            } else {
                                z12 = !z12;
                            }
                        } else {
                            throw new ParseException("Unexpected control character while reading array");
                        }
                    }
                    zaw(5);
                }
            } else if (zai2 != '{') {
                bufferedReader.reset();
                zam(bufferedReader, this.zaq);
            } else {
                this.zat.push(1);
                bufferedReader.mark(32);
                char zai4 = zai(bufferedReader);
                if (zai4 == '}') {
                    zaw(1);
                } else if (zai4 == '\"') {
                    bufferedReader.reset();
                    zaq(bufferedReader);
                    do {
                    } while (zar(bufferedReader) != null);
                    zaw(1);
                } else {
                    throw new ParseException("Unexpected token " + zai4);
                }
            }
        } else if (bufferedReader.read(this.zao) != -1) {
            char c11 = this.zao[0];
            boolean z13 = false;
            do {
                if (c11 == '\"') {
                    if (z13) {
                        c11 = '\"';
                        z13 = true;
                    }
                }
                if (c11 == '\\') {
                    z13 = !z13;
                } else {
                    z13 = false;
                }
                if (bufferedReader.read(this.zao) != -1) {
                    c11 = this.zao[0];
                } else {
                    throw new ParseException("Unexpected EOF while parsing string");
                }
            } while (!Character.isISOControl(c11));
            throw new ParseException("Unexpected control character while reading string");
        } else {
            throw new ParseException("Unexpected EOF while parsing string");
        }
        char zai5 = zai(bufferedReader);
        if (zai5 == ',') {
            zaw(2);
            return zaq(bufferedReader);
        } else if (zai5 == '}') {
            zaw(2);
            return null;
        } else {
            throw new ParseException("Unexpected token " + zai5);
        }
    }

    /* access modifiers changed from: private */
    @Nullable
    public final BigDecimal zas(BufferedReader bufferedReader) throws ParseException, IOException {
        int zam2 = zam(bufferedReader, this.zaq);
        if (zam2 == 0) {
            return null;
        }
        return new BigDecimal(new String(this.zaq, 0, zam2));
    }

    /* access modifiers changed from: private */
    @Nullable
    public final BigInteger zat(BufferedReader bufferedReader) throws ParseException, IOException {
        int zam2 = zam(bufferedReader, this.zaq);
        if (zam2 == 0) {
            return null;
        }
        return new BigInteger(new String(this.zaq, 0, zam2));
    }

    @Nullable
    private final ArrayList zau(BufferedReader bufferedReader, zai zai2) throws ParseException, IOException {
        char zai3 = zai(bufferedReader);
        if (zai3 == 'n') {
            zax(bufferedReader, zaa);
            return null;
        } else if (zai3 == '[') {
            this.zat.push(5);
            ArrayList arrayList = new ArrayList();
            while (true) {
                bufferedReader.mark(1024);
                char zai4 = zai(bufferedReader);
                if (zai4 == 0) {
                    throw new ParseException("Unexpected EOF");
                } else if (zai4 != ',') {
                    if (zai4 != ']') {
                        bufferedReader.reset();
                        arrayList.add(zai2.zaa(this, bufferedReader));
                    } else {
                        zaw(5);
                        return arrayList;
                    }
                }
            }
        } else {
            throw new ParseException("Expected start of array");
        }
    }

    @Nullable
    private final ArrayList zav(BufferedReader bufferedReader, FastJsonResponse.Field field) throws ParseException, IOException {
        ArrayList arrayList = new ArrayList();
        char zai2 = zai(bufferedReader);
        if (zai2 == ']') {
            zaw(5);
            return arrayList;
        } else if (zai2 == 'n') {
            zax(bufferedReader, zaa);
            zaw(5);
            return null;
        } else if (zai2 == '{') {
            this.zat.push(1);
            while (true) {
                try {
                    FastJsonResponse zad2 = field.zad();
                    if (!zaz(bufferedReader, zad2)) {
                        return arrayList;
                    }
                    arrayList.add(zad2);
                    char zai3 = zai(bufferedReader);
                    if (zai3 != ',') {
                        if (zai3 == ']') {
                            zaw(5);
                            return arrayList;
                        }
                        throw new ParseException("Unexpected token: " + zai3);
                    } else if (zai(bufferedReader) == '{') {
                        this.zat.push(1);
                    } else {
                        throw new ParseException("Expected start of next object in array");
                    }
                } catch (InstantiationException e11) {
                    throw new ParseException("Error instantiating inner object", e11);
                } catch (IllegalAccessException e12) {
                    throw new ParseException("Error instantiating inner object", e12);
                }
            }
        } else {
            throw new ParseException("Unexpected token: " + zai2);
        }
    }

    private final void zaw(int i11) throws ParseException {
        if (!this.zat.isEmpty()) {
            int intValue = ((Integer) this.zat.pop()).intValue();
            if (intValue != i11) {
                throw new ParseException("Expected state " + i11 + " but had " + intValue);
            }
            return;
        }
        throw new ParseException("Expected state " + i11 + " but had empty stack");
    }

    private final void zax(BufferedReader bufferedReader, char[] cArr) throws ParseException, IOException {
        int i11 = 0;
        while (true) {
            int length = cArr.length;
            if (i11 < length) {
                int read = bufferedReader.read(this.zap, 0, length - i11);
                if (read != -1) {
                    int i12 = 0;
                    while (i12 < read) {
                        if (cArr[i12 + i11] == this.zap[i12]) {
                            i12++;
                        } else {
                            throw new ParseException("Unexpected character");
                        }
                    }
                    i11 += read;
                } else {
                    throw new ParseException("Unexpected EOF");
                }
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: private */
    public final boolean zay(BufferedReader bufferedReader, boolean z11) throws ParseException, IOException {
        char[] cArr;
        char[] cArr2;
        char zai2 = zai(bufferedReader);
        if (zai2 != '\"') {
            if (zai2 == 'f') {
                if (z11) {
                    cArr = zae;
                } else {
                    cArr = zad;
                }
                zax(bufferedReader, cArr);
                return false;
            } else if (zai2 == 'n') {
                zax(bufferedReader, zaa);
                return false;
            } else if (zai2 == 't') {
                if (z11) {
                    cArr2 = zac;
                } else {
                    cArr2 = zab;
                }
                zax(bufferedReader, cArr2);
                return true;
            } else {
                throw new ParseException("Unexpected token: " + zai2);
            }
        } else if (!z11) {
            return zay(bufferedReader, true);
        } else {
            throw new ParseException("No boolean value found in string");
        }
    }

    @ResultIgnorabilityUnspecified
    private final boolean zaz(BufferedReader bufferedReader, FastJsonResponse fastJsonResponse) throws ParseException, IOException {
        int i11;
        HashMap hashMap;
        BufferedReader bufferedReader2 = bufferedReader;
        FastJsonResponse fastJsonResponse2 = fastJsonResponse;
        Map<String, FastJsonResponse.Field<?, ?>> fieldMappings = fastJsonResponse.getFieldMappings();
        String zaq2 = zaq(bufferedReader);
        if (zaq2 != null) {
            while (zaq2 != null) {
                FastJsonResponse.Field field = fieldMappings.get(zaq2);
                if (field == null) {
                    zaq2 = zar(bufferedReader);
                } else {
                    this.zat.push(4);
                    int i12 = field.zaa;
                    switch (i12) {
                        case 0:
                            if (!field.zab) {
                                fastJsonResponse2.zau(field, zal(bufferedReader));
                                break;
                            } else {
                                fastJsonResponse2.zav(field, zau(bufferedReader2, zag));
                                break;
                            }
                        case 1:
                            if (!field.zab) {
                                fastJsonResponse2.zae(field, zat(bufferedReader));
                                break;
                            } else {
                                fastJsonResponse2.zag(field, zau(bufferedReader2, zam));
                                break;
                            }
                        case 2:
                            if (!field.zab) {
                                fastJsonResponse2.zax(field, zan(bufferedReader));
                                break;
                            } else {
                                fastJsonResponse2.zay(field, zau(bufferedReader2, zah));
                                break;
                            }
                        case 3:
                            if (!field.zab) {
                                fastJsonResponse2.zaq(field, zak(bufferedReader));
                                break;
                            } else {
                                fastJsonResponse2.zas(field, zau(bufferedReader2, zai));
                                break;
                            }
                        case 4:
                            if (!field.zab) {
                                fastJsonResponse2.zam(field, zaj(bufferedReader));
                                break;
                            } else {
                                fastJsonResponse2.zao(field, zau(bufferedReader2, zaj));
                                break;
                            }
                        case 5:
                            if (!field.zab) {
                                fastJsonResponse2.zaa(field, zas(bufferedReader));
                                break;
                            } else {
                                fastJsonResponse2.zac(field, zau(bufferedReader2, zan));
                                break;
                            }
                        case 6:
                            if (!field.zab) {
                                fastJsonResponse2.zai(field, zay(bufferedReader2, false));
                                break;
                            } else {
                                fastJsonResponse2.zaj(field, zau(bufferedReader2, zak));
                                break;
                            }
                        case 7:
                            if (!field.zab) {
                                fastJsonResponse2.zaA(field, zao(bufferedReader));
                                break;
                            } else {
                                fastJsonResponse2.zaC(field, zau(bufferedReader2, zal));
                                break;
                            }
                        case 8:
                            fastJsonResponse2.zal(field, Base64Utils.decode(zap(bufferedReader2, this.zaq, this.zas, zaf)));
                            break;
                        case 9:
                            fastJsonResponse2.zal(field, Base64Utils.decodeUrlSafe(zap(bufferedReader2, this.zaq, this.zas, zaf)));
                            break;
                        case 10:
                            char zai2 = zai(bufferedReader);
                            if (zai2 == 'n') {
                                zax(bufferedReader2, zaa);
                                hashMap = null;
                            } else if (zai2 == '{') {
                                this.zat.push(1);
                                hashMap = new HashMap();
                                while (true) {
                                    char zai3 = zai(bufferedReader);
                                    if (zai3 == 0) {
                                        throw new ParseException("Unexpected EOF");
                                    } else if (zai3 == '\"') {
                                        String zaA = zaA(bufferedReader2, this.zap, this.zar, (char[]) null);
                                        if (zai(bufferedReader) != ':') {
                                            throw new ParseException("No map value found for key ".concat(String.valueOf(zaA)));
                                        } else if (zai(bufferedReader) == '\"') {
                                            hashMap.put(zaA, zaA(bufferedReader2, this.zap, this.zar, (char[]) null));
                                            char zai4 = zai(bufferedReader);
                                            if (zai4 != ',') {
                                                if (zai4 == '}') {
                                                    zaw(1);
                                                } else {
                                                    throw new ParseException("Unexpected character while parsing string map: " + zai4);
                                                }
                                            }
                                        } else {
                                            throw new ParseException("Expected String value for key ".concat(String.valueOf(zaA)));
                                        }
                                    } else if (zai3 == '}') {
                                        zaw(1);
                                    }
                                }
                            } else {
                                throw new ParseException("Expected start of a map object");
                            }
                            fastJsonResponse2.zaB(field, hashMap);
                            break;
                        case 11:
                            if (field.zab) {
                                char zai5 = zai(bufferedReader);
                                if (zai5 == 'n') {
                                    zax(bufferedReader2, zaa);
                                    fastJsonResponse2.addConcreteTypeArrayInternal(field, field.zae, (ArrayList) null);
                                } else {
                                    this.zat.push(5);
                                    if (zai5 == '[') {
                                        fastJsonResponse2.addConcreteTypeArrayInternal(field, field.zae, zav(bufferedReader2, field));
                                    } else {
                                        throw new ParseException("Expected array start");
                                    }
                                }
                            } else {
                                char zai6 = zai(bufferedReader);
                                if (zai6 == 'n') {
                                    zax(bufferedReader2, zaa);
                                    fastJsonResponse2.addConcreteTypeInternal(field, field.zae, null);
                                } else {
                                    this.zat.push(1);
                                    if (zai6 == '{') {
                                        try {
                                            FastJsonResponse zad2 = field.zad();
                                            zaz(bufferedReader2, zad2);
                                            fastJsonResponse2.addConcreteTypeInternal(field, field.zae, zad2);
                                        } catch (InstantiationException e11) {
                                            throw new ParseException("Error instantiating inner object", e11);
                                        } catch (IllegalAccessException e12) {
                                            throw new ParseException("Error instantiating inner object", e12);
                                        }
                                    } else {
                                        throw new ParseException("Expected start of object");
                                    }
                                }
                            }
                            i11 = 4;
                            break;
                        default:
                            throw new ParseException("Invalid field type " + i12);
                    }
                    i11 = 4;
                    zaw(i11);
                    zaw(2);
                    char zai7 = zai(bufferedReader);
                    if (zai7 == ',') {
                        zaq2 = zaq(bufferedReader);
                    } else if (zai7 == '}') {
                        zaq2 = null;
                    } else {
                        throw new ParseException("Expected end of object or field separator, but found: " + zai7);
                    }
                }
            }
            zaw(1);
            return true;
        }
        zaw(1);
        return false;
    }

    @KeepForSdk
    public void parse(@NonNull InputStream inputStream, @NonNull T t11) throws ParseException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream), 1024);
        try {
            this.zat.push(0);
            char zai2 = zai(bufferedReader);
            if (zai2 != 0) {
                if (zai2 == '[') {
                    this.zat.push(5);
                    Map<String, FastJsonResponse.Field<?, ?>> fieldMappings = t11.getFieldMappings();
                    if (fieldMappings.size() == 1) {
                        FastJsonResponse.Field field = (FastJsonResponse.Field) fieldMappings.entrySet().iterator().next().getValue();
                        t11.addConcreteTypeArrayInternal(field, field.zae, zav(bufferedReader, field));
                    } else {
                        throw new ParseException("Object array response class must have a single Field");
                    }
                } else if (zai2 == '{') {
                    this.zat.push(1);
                    zaz(bufferedReader, t11);
                } else {
                    throw new ParseException("Unexpected token: " + zai2);
                }
                zaw(0);
                try {
                    bufferedReader.close();
                } catch (IOException unused) {
                    Log.w("FastParser", "Failed to close reader while parsing.");
                }
            } else {
                throw new ParseException("No data to parse");
            }
        } catch (IOException e11) {
            throw new ParseException((Throwable) e11);
        } catch (Throwable th2) {
            try {
                bufferedReader.close();
            } catch (IOException unused2) {
                Log.w("FastParser", "Failed to close reader while parsing.");
            }
            throw th2;
        }
    }
}
