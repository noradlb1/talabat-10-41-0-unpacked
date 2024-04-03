package com.google.common.primitives;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.RandomAccess;
import javax.annotation.CheckForNull;
import kotlin.jvm.internal.CharCompanionObject;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import okhttp3.internal.ws.WebSocketProtocol;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

@GwtCompatible(emulated = true)
@ElementTypesAreNonnullByDefault
public final class Chars {
    public static final int BYTES = 2;

    @GwtCompatible
    public static class CharArrayAsList extends AbstractList<Character> implements RandomAccess, Serializable {
        private static final long serialVersionUID = 0;
        final char[] array;
        final int end;
        final int start;

        public CharArrayAsList(char[] cArr) {
            this(cArr, 0, cArr.length);
        }

        public boolean contains(@CheckForNull Object obj) {
            if (!(obj instanceof Character) || Chars.indexOf(this.array, ((Character) obj).charValue(), this.start, this.end) == -1) {
                return false;
            }
            return true;
        }

        public boolean equals(@CheckForNull Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof CharArrayAsList)) {
                return super.equals(obj);
            }
            CharArrayAsList charArrayAsList = (CharArrayAsList) obj;
            int size = size();
            if (charArrayAsList.size() != size) {
                return false;
            }
            for (int i11 = 0; i11 < size; i11++) {
                if (this.array[this.start + i11] != charArrayAsList.array[charArrayAsList.start + i11]) {
                    return false;
                }
            }
            return true;
        }

        public int hashCode() {
            int i11 = 1;
            for (int i12 = this.start; i12 < this.end; i12++) {
                i11 = (i11 * 31) + Chars.hashCode(this.array[i12]);
            }
            return i11;
        }

        public int indexOf(@CheckForNull Object obj) {
            int access$000;
            if (!(obj instanceof Character) || (access$000 = Chars.indexOf(this.array, ((Character) obj).charValue(), this.start, this.end)) < 0) {
                return -1;
            }
            return access$000 - this.start;
        }

        public boolean isEmpty() {
            return false;
        }

        public int lastIndexOf(@CheckForNull Object obj) {
            int access$100;
            if (!(obj instanceof Character) || (access$100 = Chars.lastIndexOf(this.array, ((Character) obj).charValue(), this.start, this.end)) < 0) {
                return -1;
            }
            return access$100 - this.start;
        }

        public int size() {
            return this.end - this.start;
        }

        public List<Character> subList(int i11, int i12) {
            Preconditions.checkPositionIndexes(i11, i12, size());
            if (i11 == i12) {
                return Collections.emptyList();
            }
            char[] cArr = this.array;
            int i13 = this.start;
            return new CharArrayAsList(cArr, i11 + i13, i13 + i12);
        }

        public char[] toCharArray() {
            return Arrays.copyOfRange(this.array, this.start, this.end);
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder(size() * 3);
            sb2.append('[');
            sb2.append(this.array[this.start]);
            int i11 = this.start;
            while (true) {
                i11++;
                if (i11 < this.end) {
                    sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
                    sb2.append(this.array[i11]);
                } else {
                    sb2.append(AbstractJsonLexerKt.END_LIST);
                    return sb2.toString();
                }
            }
        }

        public CharArrayAsList(char[] cArr, int i11, int i12) {
            this.array = cArr;
            this.start = i11;
            this.end = i12;
        }

        public Character get(int i11) {
            Preconditions.checkElementIndex(i11, size());
            return Character.valueOf(this.array[this.start + i11]);
        }

        public Character set(int i11, Character ch2) {
            Preconditions.checkElementIndex(i11, size());
            char[] cArr = this.array;
            int i12 = this.start;
            char c11 = cArr[i12 + i11];
            cArr[i12 + i11] = ((Character) Preconditions.checkNotNull(ch2)).charValue();
            return Character.valueOf(c11);
        }
    }

    public enum LexicographicalComparator implements Comparator<char[]> {
        INSTANCE;

        public String toString() {
            return "Chars.lexicographicalComparator()";
        }

        public int compare(char[] cArr, char[] cArr2) {
            int min = Math.min(cArr.length, cArr2.length);
            for (int i11 = 0; i11 < min; i11++) {
                int compare = Chars.compare(cArr[i11], cArr2[i11]);
                if (compare != 0) {
                    return compare;
                }
            }
            return cArr.length - cArr2.length;
        }
    }

    private Chars() {
    }

    public static List<Character> asList(char... cArr) {
        if (cArr.length == 0) {
            return Collections.emptyList();
        }
        return new CharArrayAsList(cArr);
    }

    public static char checkedCast(long j11) {
        boolean z11;
        char c11 = (char) ((int) j11);
        if (((long) c11) == j11) {
            z11 = true;
        } else {
            z11 = false;
        }
        Preconditions.checkArgument(z11, "Out of range: %s", j11);
        return c11;
    }

    public static int compare(char c11, char c12) {
        return c11 - c12;
    }

    public static char[] concat(char[]... cArr) {
        int i11 = 0;
        for (char[] length : cArr) {
            i11 += length.length;
        }
        char[] cArr2 = new char[i11];
        int i12 = 0;
        for (char[] cArr3 : cArr) {
            System.arraycopy(cArr3, 0, cArr2, i12, cArr3.length);
            i12 += cArr3.length;
        }
        return cArr2;
    }

    public static char constrainToRange(char c11, char c12, char c13) {
        boolean z11;
        if (c12 <= c13) {
            z11 = true;
        } else {
            z11 = false;
        }
        Preconditions.checkArgument(z11, "min (%s) must be less than or equal to max (%s)", c12, c13);
        if (c11 < c12) {
            return c12;
        }
        if (c11 < c13) {
            return c11;
        }
        return c13;
    }

    public static boolean contains(char[] cArr, char c11) {
        for (char c12 : cArr) {
            if (c12 == c11) {
                return true;
            }
        }
        return false;
    }

    public static char[] ensureCapacity(char[] cArr, int i11, int i12) {
        boolean z11;
        boolean z12 = true;
        if (i11 >= 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        Preconditions.checkArgument(z11, "Invalid minLength: %s", i11);
        if (i12 < 0) {
            z12 = false;
        }
        Preconditions.checkArgument(z12, "Invalid padding: %s", i12);
        if (cArr.length < i11) {
            return Arrays.copyOf(cArr, i11 + i12);
        }
        return cArr;
    }

    @GwtIncompatible
    public static char fromByteArray(byte[] bArr) {
        boolean z11;
        if (bArr.length >= 2) {
            z11 = true;
        } else {
            z11 = false;
        }
        Preconditions.checkArgument(z11, "array too small: %s < %s", bArr.length, 2);
        return fromBytes(bArr[0], bArr[1]);
    }

    @GwtIncompatible
    public static char fromBytes(byte b11, byte b12) {
        return (char) ((b11 << 8) | (b12 & 255));
    }

    public static int hashCode(char c11) {
        return c11;
    }

    public static int indexOf(char[] cArr, char c11) {
        return indexOf(cArr, c11, 0, cArr.length);
    }

    public static String join(String str, char... cArr) {
        Preconditions.checkNotNull(str);
        int length = cArr.length;
        if (length == 0) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder((str.length() * (length - 1)) + length);
        sb2.append(cArr[0]);
        for (int i11 = 1; i11 < length; i11++) {
            sb2.append(str);
            sb2.append(cArr[i11]);
        }
        return sb2.toString();
    }

    public static int lastIndexOf(char[] cArr, char c11) {
        return lastIndexOf(cArr, c11, 0, cArr.length);
    }

    public static Comparator<char[]> lexicographicalComparator() {
        return LexicographicalComparator.INSTANCE;
    }

    public static char max(char... cArr) {
        boolean z11;
        if (cArr.length > 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        Preconditions.checkArgument(z11);
        char c11 = cArr[0];
        for (int i11 = 1; i11 < cArr.length; i11++) {
            char c12 = cArr[i11];
            if (c12 > c11) {
                c11 = c12;
            }
        }
        return c11;
    }

    public static char min(char... cArr) {
        boolean z11;
        if (cArr.length > 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        Preconditions.checkArgument(z11);
        char c11 = cArr[0];
        for (int i11 = 1; i11 < cArr.length; i11++) {
            char c12 = cArr[i11];
            if (c12 < c11) {
                c11 = c12;
            }
        }
        return c11;
    }

    public static void reverse(char[] cArr) {
        Preconditions.checkNotNull(cArr);
        reverse(cArr, 0, cArr.length);
    }

    public static void rotate(char[] cArr, int i11) {
        rotate(cArr, i11, 0, cArr.length);
    }

    public static char saturatedCast(long j11) {
        if (j11 > WebSocketProtocol.PAYLOAD_SHORT_MAX) {
            return CharCompanionObject.MAX_VALUE;
        }
        if (j11 < 0) {
            return 0;
        }
        return (char) ((int) j11);
    }

    public static void sortDescending(char[] cArr) {
        Preconditions.checkNotNull(cArr);
        sortDescending(cArr, 0, cArr.length);
    }

    public static char[] toArray(Collection<Character> collection) {
        if (collection instanceof CharArrayAsList) {
            return ((CharArrayAsList) collection).toCharArray();
        }
        Object[] array = collection.toArray();
        int length = array.length;
        char[] cArr = new char[length];
        for (int i11 = 0; i11 < length; i11++) {
            cArr[i11] = ((Character) Preconditions.checkNotNull(array[i11])).charValue();
        }
        return cArr;
    }

    @GwtIncompatible
    public static byte[] toByteArray(char c11) {
        return new byte[]{(byte) (c11 >> 8), (byte) c11};
    }

    /* access modifiers changed from: private */
    public static int indexOf(char[] cArr, char c11, int i11, int i12) {
        while (i11 < i12) {
            if (cArr[i11] == c11) {
                return i11;
            }
            i11++;
        }
        return -1;
    }

    /* access modifiers changed from: private */
    public static int lastIndexOf(char[] cArr, char c11, int i11, int i12) {
        for (int i13 = i12 - 1; i13 >= i11; i13--) {
            if (cArr[i13] == c11) {
                return i13;
            }
        }
        return -1;
    }

    public static void rotate(char[] cArr, int i11, int i12, int i13) {
        Preconditions.checkNotNull(cArr);
        Preconditions.checkPositionIndexes(i12, i13, cArr.length);
        if (cArr.length > 1) {
            int i14 = i13 - i12;
            int i15 = (-i11) % i14;
            if (i15 < 0) {
                i15 += i14;
            }
            int i16 = i15 + i12;
            if (i16 != i12) {
                reverse(cArr, i12, i16);
                reverse(cArr, i16, i13);
                reverse(cArr, i12, i13);
            }
        }
    }

    public static int indexOf(char[] cArr, char[] cArr2) {
        Preconditions.checkNotNull(cArr, "array");
        Preconditions.checkNotNull(cArr2, "target");
        if (cArr2.length == 0) {
            return 0;
        }
        int i11 = 0;
        while (i11 < (cArr.length - cArr2.length) + 1) {
            int i12 = 0;
            while (i12 < cArr2.length) {
                if (cArr[i11 + i12] != cArr2[i12]) {
                    i11++;
                } else {
                    i12++;
                }
            }
            return i11;
        }
        return -1;
    }

    public static void reverse(char[] cArr, int i11, int i12) {
        Preconditions.checkNotNull(cArr);
        Preconditions.checkPositionIndexes(i11, i12, cArr.length);
        for (int i13 = i12 - 1; i11 < i13; i13--) {
            char c11 = cArr[i11];
            cArr[i11] = cArr[i13];
            cArr[i13] = c11;
            i11++;
        }
    }

    public static void sortDescending(char[] cArr, int i11, int i12) {
        Preconditions.checkNotNull(cArr);
        Preconditions.checkPositionIndexes(i11, i12, cArr.length);
        Arrays.sort(cArr, i11, i12);
        reverse(cArr, i11, i12);
    }
}
