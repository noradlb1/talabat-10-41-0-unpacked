package j$.util;

import java.util.Arrays;
import java.util.Objects;

public final class StringJoiner {

    /* renamed from: a  reason: collision with root package name */
    private final String f28579a;

    /* renamed from: b  reason: collision with root package name */
    private final String f28580b;

    /* renamed from: c  reason: collision with root package name */
    private final String f28581c;

    /* renamed from: d  reason: collision with root package name */
    private String[] f28582d;

    /* renamed from: e  reason: collision with root package name */
    private int f28583e;

    /* renamed from: f  reason: collision with root package name */
    private int f28584f;

    public StringJoiner(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3) {
        Objects.requireNonNull(charSequence2, "The prefix must not be null");
        Objects.requireNonNull(charSequence, "The delimiter must not be null");
        Objects.requireNonNull(charSequence3, "The suffix must not be null");
        this.f28579a = charSequence2.toString();
        this.f28580b = charSequence.toString();
        this.f28581c = charSequence3.toString();
    }

    private void a() {
        String[] strArr;
        if (this.f28583e > 1) {
            char[] cArr = new char[this.f28584f];
            int b11 = b(this.f28582d[0], cArr, 0);
            int i11 = 1;
            do {
                int b12 = b11 + b(this.f28580b, cArr, b11);
                b11 = b12 + b(this.f28582d[i11], cArr, b12);
                strArr = this.f28582d;
                strArr[i11] = null;
                i11++;
            } while (i11 < this.f28583e);
            this.f28583e = 1;
            strArr[0] = new String(cArr);
        }
    }

    private static int b(String str, char[] cArr, int i11) {
        int length = str.length();
        str.getChars(0, length, cArr, i11);
        return length;
    }

    public StringJoiner add(CharSequence charSequence) {
        String valueOf = String.valueOf(charSequence);
        String[] strArr = this.f28582d;
        if (strArr == null) {
            this.f28582d = new String[8];
        } else {
            int i11 = this.f28583e;
            if (i11 == strArr.length) {
                this.f28582d = (String[]) Arrays.copyOf(strArr, i11 * 2);
            }
            this.f28584f = this.f28580b.length() + this.f28584f;
        }
        this.f28584f = valueOf.length() + this.f28584f;
        String[] strArr2 = this.f28582d;
        int i12 = this.f28583e;
        this.f28583e = i12 + 1;
        strArr2[i12] = valueOf;
        return this;
    }

    public final StringJoiner c(StringJoiner stringJoiner) {
        Objects.requireNonNull(stringJoiner);
        if (stringJoiner.f28582d == null) {
            return this;
        }
        stringJoiner.a();
        return add(stringJoiner.f28582d[0]);
    }

    public final String toString() {
        String[] strArr = this.f28582d;
        int i11 = this.f28583e;
        String str = this.f28579a;
        int length = str.length();
        String str2 = this.f28581c;
        int length2 = str2.length() + length;
        if (length2 == 0) {
            a();
            return i11 == 0 ? "" : strArr[0];
        }
        char[] cArr = new char[(this.f28584f + length2)];
        int b11 = b(str, cArr, 0);
        if (i11 > 0) {
            b11 += b(strArr[0], cArr, b11);
            for (int i12 = 1; i12 < i11; i12++) {
                int b12 = b11 + b(this.f28580b, cArr, b11);
                b11 = b12 + b(strArr[i12], cArr, b12);
            }
        }
        b(str2, cArr, b11);
        return new String(cArr);
    }
}
