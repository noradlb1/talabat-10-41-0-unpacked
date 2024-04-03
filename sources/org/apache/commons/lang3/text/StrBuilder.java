package org.apache.commons.lang3.text;

import java.io.Reader;
import java.io.Serializable;
import java.io.Writer;
import java.util.Iterator;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import net.bytebuddy.asm.Advice;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.SystemUtils;
import org.apache.commons.lang3.builder.Builder;

public class StrBuilder implements CharSequence, Appendable, Serializable, Builder<String> {
    static final int CAPACITY = 32;
    private static final long serialVersionUID = 7628716375283629643L;
    protected char[] buffer;
    private String newLine;
    private String nullText;
    protected int size;

    public class StrBuilderTokenizer extends StrTokenizer {
        public StrBuilderTokenizer() {
        }

        public String getContent() {
            String content = super.getContent();
            if (content == null) {
                return StrBuilder.this.toString();
            }
            return content;
        }

        public List<String> tokenize(char[] cArr, int i11, int i12) {
            if (cArr != null) {
                return super.tokenize(cArr, i11, i12);
            }
            StrBuilder strBuilder = StrBuilder.this;
            return super.tokenize(strBuilder.buffer, 0, strBuilder.size());
        }
    }

    public class StrBuilderWriter extends Writer {
        public StrBuilderWriter() {
        }

        public void close() {
        }

        public void flush() {
        }

        public void write(int i11) {
            StrBuilder.this.append((char) i11);
        }

        public void write(char[] cArr) {
            StrBuilder.this.append(cArr);
        }

        public void write(char[] cArr, int i11, int i12) {
            StrBuilder.this.append(cArr, i11, i12);
        }

        public void write(String str) {
            StrBuilder.this.append(str);
        }

        public void write(String str, int i11, int i12) {
            StrBuilder.this.append(str, i11, i12);
        }
    }

    public StrBuilder() {
        this(32);
    }

    private void deleteImpl(int i11, int i12, int i13) {
        char[] cArr = this.buffer;
        System.arraycopy(cArr, i12, cArr, i11, this.size - i12);
        this.size -= i13;
    }

    private void replaceImpl(int i11, int i12, int i13, String str, int i14) {
        int i15 = (this.size - i13) + i14;
        if (i14 != i13) {
            ensureCapacity(i15);
            char[] cArr = this.buffer;
            System.arraycopy(cArr, i12, cArr, i11 + i14, this.size - i12);
            this.size = i15;
        }
        if (i14 > 0) {
            str.getChars(0, i14, this.buffer, i11);
        }
    }

    public <T> StrBuilder appendAll(T... tArr) {
        if (tArr != null && tArr.length > 0) {
            for (T append : tArr) {
                append((Object) append);
            }
        }
        return this;
    }

    public StrBuilder appendFixedWidthPadLeft(Object obj, int i11, char c11) {
        if (i11 > 0) {
            ensureCapacity(this.size + i11);
            String nullText2 = obj == null ? getNullText() : obj.toString();
            if (nullText2 == null) {
                nullText2 = "";
            }
            int length = nullText2.length();
            if (length >= i11) {
                nullText2.getChars(length - i11, length, this.buffer, this.size);
            } else {
                int i12 = i11 - length;
                for (int i13 = 0; i13 < i12; i13++) {
                    this.buffer[this.size + i13] = c11;
                }
                nullText2.getChars(0, length, this.buffer, this.size + i12);
            }
            this.size += i11;
        }
        return this;
    }

    public StrBuilder appendFixedWidthPadRight(Object obj, int i11, char c11) {
        if (i11 > 0) {
            ensureCapacity(this.size + i11);
            String nullText2 = obj == null ? getNullText() : obj.toString();
            if (nullText2 == null) {
                nullText2 = "";
            }
            int length = nullText2.length();
            if (length >= i11) {
                nullText2.getChars(0, i11, this.buffer, this.size);
            } else {
                int i12 = i11 - length;
                nullText2.getChars(0, length, this.buffer, this.size);
                for (int i13 = 0; i13 < i12; i13++) {
                    this.buffer[this.size + length + i13] = c11;
                }
            }
            this.size += i11;
        }
        return this;
    }

    public StrBuilder appendNewLine() {
        String str = this.newLine;
        if (str != null) {
            return append(str);
        }
        append(SystemUtils.LINE_SEPARATOR);
        return this;
    }

    public StrBuilder appendNull() {
        String str = this.nullText;
        if (str == null) {
            return this;
        }
        return append(str);
    }

    public StrBuilder appendPadding(int i11, char c11) {
        if (i11 >= 0) {
            ensureCapacity(this.size + i11);
            for (int i12 = 0; i12 < i11; i12++) {
                char[] cArr = this.buffer;
                int i13 = this.size;
                this.size = i13 + 1;
                cArr[i13] = c11;
            }
        }
        return this;
    }

    public StrBuilder appendSeparator(String str) {
        return appendSeparator(str, (String) null);
    }

    public StrBuilder appendWithSeparators(Object[] objArr, String str) {
        if (objArr != null && objArr.length > 0) {
            String objectUtils = ObjectUtils.toString(str);
            append(objArr[0]);
            for (int i11 = 1; i11 < objArr.length; i11++) {
                append(objectUtils);
                append(objArr[i11]);
            }
        }
        return this;
    }

    public StrBuilder appendln(Object obj) {
        return append(obj).appendNewLine();
    }

    public Reader asReader() {
        return new StrBuilderReader();
    }

    public StrTokenizer asTokenizer() {
        return new StrBuilderTokenizer();
    }

    public Writer asWriter() {
        return new StrBuilderWriter();
    }

    public int capacity() {
        return this.buffer.length;
    }

    public char charAt(int i11) {
        if (i11 >= 0 && i11 < length()) {
            return this.buffer[i11];
        }
        throw new StringIndexOutOfBoundsException(i11);
    }

    public StrBuilder clear() {
        this.size = 0;
        return this;
    }

    public boolean contains(char c11) {
        char[] cArr = this.buffer;
        for (int i11 = 0; i11 < this.size; i11++) {
            if (cArr[i11] == c11) {
                return true;
            }
        }
        return false;
    }

    public StrBuilder delete(int i11, int i12) {
        int validateRange = validateRange(i11, i12);
        int i13 = validateRange - i11;
        if (i13 > 0) {
            deleteImpl(i11, validateRange, i13);
        }
        return this;
    }

    public StrBuilder deleteAll(char c11) {
        int i11 = 0;
        while (i11 < this.size) {
            if (this.buffer[i11] == c11) {
                int i12 = i11;
                do {
                    i12++;
                    if (i12 >= this.size || this.buffer[i12] != c11) {
                        int i13 = i12 - i11;
                        deleteImpl(i11, i12, i13);
                        i11 = i12 - i13;
                    }
                    i12++;
                    break;
                } while (this.buffer[i12] != c11);
                int i132 = i12 - i11;
                deleteImpl(i11, i12, i132);
                i11 = i12 - i132;
            }
            i11++;
        }
        return this;
    }

    public StrBuilder deleteCharAt(int i11) {
        if (i11 < 0 || i11 >= this.size) {
            throw new StringIndexOutOfBoundsException(i11);
        }
        deleteImpl(i11, i11 + 1, 1);
        return this;
    }

    public StrBuilder deleteFirst(char c11) {
        int i11 = 0;
        while (true) {
            if (i11 >= this.size) {
                break;
            } else if (this.buffer[i11] == c11) {
                deleteImpl(i11, i11 + 1, 1);
                break;
            } else {
                i11++;
            }
        }
        return this;
    }

    public boolean endsWith(String str) {
        if (str == null) {
            return false;
        }
        int length = str.length();
        if (length == 0) {
            return true;
        }
        int i11 = this.size;
        if (length > i11) {
            return false;
        }
        int i12 = i11 - length;
        int i13 = 0;
        while (i13 < length) {
            if (this.buffer[i12] != str.charAt(i13)) {
                return false;
            }
            i13++;
            i12++;
        }
        return true;
    }

    public StrBuilder ensureCapacity(int i11) {
        char[] cArr = this.buffer;
        if (i11 > cArr.length) {
            char[] cArr2 = new char[(i11 * 2)];
            this.buffer = cArr2;
            System.arraycopy(cArr, 0, cArr2, 0, this.size);
        }
        return this;
    }

    public boolean equals(StrBuilder strBuilder) {
        if (this == strBuilder) {
            return true;
        }
        int i11 = this.size;
        if (i11 != strBuilder.size) {
            return false;
        }
        char[] cArr = this.buffer;
        char[] cArr2 = strBuilder.buffer;
        for (int i12 = i11 - 1; i12 >= 0; i12--) {
            if (cArr[i12] != cArr2[i12]) {
                return false;
            }
        }
        return true;
    }

    public boolean equalsIgnoreCase(StrBuilder strBuilder) {
        if (this == strBuilder) {
            return true;
        }
        int i11 = this.size;
        if (i11 != strBuilder.size) {
            return false;
        }
        char[] cArr = this.buffer;
        char[] cArr2 = strBuilder.buffer;
        for (int i12 = i11 - 1; i12 >= 0; i12--) {
            char c11 = cArr[i12];
            char c12 = cArr2[i12];
            if (c11 != c12 && Character.toUpperCase(c11) != Character.toUpperCase(c12)) {
                return false;
            }
        }
        return true;
    }

    public char[] getChars(char[] cArr) {
        int length = length();
        if (cArr == null || cArr.length < length) {
            cArr = new char[length];
        }
        System.arraycopy(this.buffer, 0, cArr, 0, length);
        return cArr;
    }

    public String getNewLineText() {
        return this.newLine;
    }

    public String getNullText() {
        return this.nullText;
    }

    public int hashCode() {
        char[] cArr = this.buffer;
        int i11 = 0;
        for (int i12 = this.size - 1; i12 >= 0; i12--) {
            i11 = (i11 * 31) + cArr[i12];
        }
        return i11;
    }

    public int indexOf(char c11) {
        return indexOf(c11, 0);
    }

    public StrBuilder insert(int i11, Object obj) {
        if (obj == null) {
            return insert(i11, this.nullText);
        }
        return insert(i11, obj.toString());
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public int lastIndexOf(char c11) {
        return lastIndexOf(c11, this.size - 1);
    }

    public String leftString(int i11) {
        if (i11 <= 0) {
            return "";
        }
        int i12 = this.size;
        if (i11 >= i12) {
            return new String(this.buffer, 0, i12);
        }
        return new String(this.buffer, 0, i11);
    }

    public int length() {
        return this.size;
    }

    public String midString(int i11, int i12) {
        int i13;
        if (i11 < 0) {
            i11 = 0;
        }
        if (i12 <= 0 || i11 >= (i13 = this.size)) {
            return "";
        }
        if (i13 <= i11 + i12) {
            return new String(this.buffer, i11, i13 - i11);
        }
        return new String(this.buffer, i11, i12);
    }

    public StrBuilder minimizeCapacity() {
        if (this.buffer.length > length()) {
            char[] cArr = this.buffer;
            char[] cArr2 = new char[length()];
            this.buffer = cArr2;
            System.arraycopy(cArr, 0, cArr2, 0, this.size);
        }
        return this;
    }

    public StrBuilder replace(int i11, int i12, String str) {
        int i13;
        int validateRange = validateRange(i11, i12);
        if (str == null) {
            i13 = 0;
        } else {
            i13 = str.length();
        }
        int i14 = i11;
        replaceImpl(i14, validateRange, validateRange - i11, str, i13);
        return this;
    }

    public StrBuilder replaceAll(char c11, char c12) {
        if (c11 != c12) {
            for (int i11 = 0; i11 < this.size; i11++) {
                char[] cArr = this.buffer;
                if (cArr[i11] == c11) {
                    cArr[i11] = c12;
                }
            }
        }
        return this;
    }

    public StrBuilder replaceFirst(char c11, char c12) {
        if (c11 != c12) {
            int i11 = 0;
            while (true) {
                if (i11 >= this.size) {
                    break;
                }
                char[] cArr = this.buffer;
                if (cArr[i11] == c11) {
                    cArr[i11] = c12;
                    break;
                }
                i11++;
            }
        }
        return this;
    }

    public StrBuilder reverse() {
        int i11 = this.size;
        if (i11 == 0) {
            return this;
        }
        int i12 = i11 / 2;
        char[] cArr = this.buffer;
        int i13 = i11 - 1;
        int i14 = 0;
        while (i14 < i12) {
            char c11 = cArr[i14];
            cArr[i14] = cArr[i13];
            cArr[i13] = c11;
            i14++;
            i13--;
        }
        return this;
    }

    public String rightString(int i11) {
        if (i11 <= 0) {
            return "";
        }
        int i12 = this.size;
        if (i11 >= i12) {
            return new String(this.buffer, 0, i12);
        }
        return new String(this.buffer, i12 - i11, i11);
    }

    public StrBuilder setCharAt(int i11, char c11) {
        if (i11 < 0 || i11 >= length()) {
            throw new StringIndexOutOfBoundsException(i11);
        }
        this.buffer[i11] = c11;
        return this;
    }

    public StrBuilder setLength(int i11) {
        if (i11 >= 0) {
            int i12 = this.size;
            if (i11 < i12) {
                this.size = i11;
            } else if (i11 > i12) {
                ensureCapacity(i11);
                this.size = i11;
                for (int i13 = this.size; i13 < i11; i13++) {
                    this.buffer[i13] = 0;
                }
            }
            return this;
        }
        throw new StringIndexOutOfBoundsException(i11);
    }

    public StrBuilder setNewLineText(String str) {
        this.newLine = str;
        return this;
    }

    public StrBuilder setNullText(String str) {
        if (str != null && str.isEmpty()) {
            str = null;
        }
        this.nullText = str;
        return this;
    }

    public int size() {
        return this.size;
    }

    public boolean startsWith(String str) {
        if (str == null) {
            return false;
        }
        int length = str.length();
        if (length == 0) {
            return true;
        }
        if (length > this.size) {
            return false;
        }
        for (int i11 = 0; i11 < length; i11++) {
            if (this.buffer[i11] != str.charAt(i11)) {
                return false;
            }
        }
        return true;
    }

    public CharSequence subSequence(int i11, int i12) {
        if (i11 < 0) {
            throw new StringIndexOutOfBoundsException(i11);
        } else if (i12 > this.size) {
            throw new StringIndexOutOfBoundsException(i12);
        } else if (i11 <= i12) {
            return substring(i11, i12);
        } else {
            throw new StringIndexOutOfBoundsException(i12 - i11);
        }
    }

    public String substring(int i11) {
        return substring(i11, this.size);
    }

    public char[] toCharArray() {
        int i11 = this.size;
        if (i11 == 0) {
            return ArrayUtils.EMPTY_CHAR_ARRAY;
        }
        char[] cArr = new char[i11];
        System.arraycopy(this.buffer, 0, cArr, 0, i11);
        return cArr;
    }

    public String toString() {
        return new String(this.buffer, 0, this.size);
    }

    public StringBuffer toStringBuffer() {
        StringBuffer stringBuffer = new StringBuffer(this.size);
        stringBuffer.append(this.buffer, 0, this.size);
        return stringBuffer;
    }

    public StringBuilder toStringBuilder() {
        StringBuilder sb2 = new StringBuilder(this.size);
        sb2.append(this.buffer, 0, this.size);
        return sb2;
    }

    public StrBuilder trim() {
        int i11 = this.size;
        if (i11 == 0) {
            return this;
        }
        char[] cArr = this.buffer;
        int i12 = 0;
        while (i12 < i11 && cArr[i12] <= ' ') {
            i12++;
        }
        while (i12 < i11 && cArr[i11 - 1] <= ' ') {
            i11--;
        }
        int i13 = this.size;
        if (i11 < i13) {
            delete(i11, i13);
        }
        if (i12 > 0) {
            delete(0, i12);
        }
        return this;
    }

    public void validateIndex(int i11) {
        if (i11 < 0 || i11 > this.size) {
            throw new StringIndexOutOfBoundsException(i11);
        }
    }

    public int validateRange(int i11, int i12) {
        if (i11 >= 0) {
            int i13 = this.size;
            if (i12 > i13) {
                i12 = i13;
            }
            if (i11 <= i12) {
                return i12;
            }
            throw new StringIndexOutOfBoundsException("end < start");
        }
        throw new StringIndexOutOfBoundsException(i11);
    }

    public class StrBuilderReader extends Reader {
        private int mark;
        private int pos;

        public StrBuilderReader() {
        }

        public void close() {
        }

        public void mark(int i11) {
            this.mark = this.pos;
        }

        public boolean markSupported() {
            return true;
        }

        public int read() {
            if (!ready()) {
                return -1;
            }
            StrBuilder strBuilder = StrBuilder.this;
            int i11 = this.pos;
            this.pos = i11 + 1;
            return strBuilder.charAt(i11);
        }

        public boolean ready() {
            return this.pos < StrBuilder.this.size();
        }

        public void reset() {
            this.pos = this.mark;
        }

        public long skip(long j11) {
            if (((long) this.pos) + j11 > ((long) StrBuilder.this.size())) {
                j11 = (long) (StrBuilder.this.size() - this.pos);
            }
            if (j11 < 0) {
                return 0;
            }
            this.pos = (int) (((long) this.pos) + j11);
            return j11;
        }

        public int read(char[] cArr, int i11, int i12) {
            int i13;
            if (i11 < 0 || i12 < 0 || i11 > cArr.length || (i13 = i11 + i12) > cArr.length || i13 < 0) {
                throw new IndexOutOfBoundsException();
            } else if (i12 == 0) {
                return 0;
            } else {
                if (this.pos >= StrBuilder.this.size()) {
                    return -1;
                }
                if (this.pos + i12 > StrBuilder.this.size()) {
                    i12 = StrBuilder.this.size() - this.pos;
                }
                StrBuilder strBuilder = StrBuilder.this;
                int i14 = this.pos;
                strBuilder.getChars(i14, i14 + i12, cArr, i11);
                this.pos += i12;
                return i12;
            }
        }
    }

    public StrBuilder(int i11) {
        this.buffer = new char[(i11 <= 0 ? 32 : i11)];
    }

    public StrBuilder appendSeparator(String str, String str2) {
        if (isEmpty()) {
            str = str2;
        }
        if (str != null) {
            append(str);
        }
        return this;
    }

    public StrBuilder appendln(String str) {
        return append(str).appendNewLine();
    }

    public String build() {
        return toString();
    }

    public int indexOf(char c11, int i11) {
        if (i11 < 0) {
            i11 = 0;
        }
        if (i11 >= this.size) {
            return -1;
        }
        char[] cArr = this.buffer;
        while (i11 < this.size) {
            if (cArr[i11] == c11) {
                return i11;
            }
            i11++;
        }
        return -1;
    }

    public int lastIndexOf(char c11, int i11) {
        int i12 = this.size;
        if (i11 >= i12) {
            i11 = i12 - 1;
        }
        if (i11 < 0) {
            return -1;
        }
        while (i11 >= 0) {
            if (this.buffer[i11] == c11) {
                return i11;
            }
            i11--;
        }
        return -1;
    }

    public String substring(int i11, int i12) {
        return new String(this.buffer, i11, validateRange(i11, i12) - i11);
    }

    public StrBuilder appendln(String str, int i11, int i12) {
        return append(str, i11, i12).appendNewLine();
    }

    public StrBuilder insert(int i11, String str) {
        int length;
        validateIndex(i11);
        if (str == null) {
            str = this.nullText;
        }
        if (str != null && (length = str.length()) > 0) {
            int i12 = this.size + length;
            ensureCapacity(i12);
            char[] cArr = this.buffer;
            System.arraycopy(cArr, i11, cArr, i11 + length, this.size - i11);
            this.size = i12;
            str.getChars(0, length, this.buffer, i11);
        }
        return this;
    }

    public StrBuilder(String str) {
        if (str == null) {
            this.buffer = new char[32];
            return;
        }
        this.buffer = new char[(str.length() + 32)];
        append(str);
    }

    public StrBuilder append(Object obj) {
        if (obj == null) {
            return appendNull();
        }
        return append(obj.toString());
    }

    public StrBuilder appendAll(Iterable<?> iterable) {
        if (iterable != null) {
            for (Object append : iterable) {
                append((Object) append);
            }
        }
        return this;
    }

    public StrBuilder appendSeparator(char c11) {
        if (size() > 0) {
            append(c11);
        }
        return this;
    }

    public StrBuilder appendln(String str, Object... objArr) {
        return append(str, objArr).appendNewLine();
    }

    public boolean contains(String str) {
        return indexOf(str, 0) >= 0;
    }

    public StrBuilder deleteFirst(String str) {
        int indexOf;
        int length = str == null ? 0 : str.length();
        if (length > 0 && (indexOf = indexOf(str, 0)) >= 0) {
            deleteImpl(indexOf, indexOf + length, length);
        }
        return this;
    }

    public int lastIndexOf(String str) {
        return lastIndexOf(str, this.size - 1);
    }

    public StrBuilder replace(StrMatcher strMatcher, String str, int i11, int i12, int i13) {
        return replaceImpl(strMatcher, str, i11, validateRange(i11, i12), i13);
    }

    public StrBuilder replaceAll(String str, String str2) {
        int i11;
        int length = str == null ? 0 : str.length();
        if (length > 0) {
            if (str2 == null) {
                i11 = 0;
            } else {
                i11 = str2.length();
            }
            int indexOf = indexOf(str, 0);
            while (indexOf >= 0) {
                replaceImpl(indexOf, indexOf + length, length, str2, i11);
                indexOf = indexOf(str, indexOf + i11);
            }
        }
        return this;
    }

    public StrBuilder replaceFirst(String str, String str2) {
        int indexOf;
        int i11 = 0;
        int length = str == null ? 0 : str.length();
        if (length > 0 && (indexOf = indexOf(str, 0)) >= 0) {
            if (str2 != null) {
                i11 = str2.length();
            }
            replaceImpl(indexOf, indexOf + length, length, str2, i11);
        }
        return this;
    }

    public StrBuilder appendln(StringBuffer stringBuffer) {
        return append(stringBuffer).appendNewLine();
    }

    public boolean contains(StrMatcher strMatcher) {
        return indexOf(strMatcher, 0) >= 0;
    }

    public boolean equals(Object obj) {
        if (obj instanceof StrBuilder) {
            return equals((StrBuilder) obj);
        }
        return false;
    }

    public void getChars(int i11, int i12, char[] cArr, int i13) {
        if (i11 < 0) {
            throw new StringIndexOutOfBoundsException(i11);
        } else if (i12 < 0 || i12 > length()) {
            throw new StringIndexOutOfBoundsException(i12);
        } else if (i11 <= i12) {
            System.arraycopy(this.buffer, i11, cArr, i13, i12 - i11);
        } else {
            throw new StringIndexOutOfBoundsException("end < start");
        }
    }

    public int lastIndexOf(String str, int i11) {
        int i12 = this.size;
        if (i11 >= i12) {
            i11 = i12 - 1;
        }
        if (str != null && i11 >= 0) {
            int length = str.length();
            if (length <= 0 || length > this.size) {
                if (length == 0) {
                    return i11;
                }
            } else if (length == 1) {
                return lastIndexOf(str.charAt(0), i11);
            } else {
                int i13 = (i11 - length) + 1;
                while (i13 >= 0) {
                    int i14 = 0;
                    while (i14 < length) {
                        if (str.charAt(i14) != this.buffer[i13 + i14]) {
                            i13--;
                        } else {
                            i14++;
                        }
                    }
                    return i13;
                }
            }
        }
        return -1;
    }

    public char[] toCharArray(int i11, int i12) {
        int validateRange = validateRange(i11, i12) - i11;
        if (validateRange == 0) {
            return ArrayUtils.EMPTY_CHAR_ARRAY;
        }
        char[] cArr = new char[validateRange];
        System.arraycopy(this.buffer, i11, cArr, 0, validateRange);
        return cArr;
    }

    private StrBuilder replaceImpl(StrMatcher strMatcher, String str, int i11, int i12, int i13) {
        int i14;
        if (!(strMatcher == null || this.size == 0)) {
            if (str == null) {
                i14 = 0;
            } else {
                i14 = str.length();
            }
            char[] cArr = this.buffer;
            int i15 = i11;
            while (i15 < i12 && i13 != 0) {
                int isMatch = strMatcher.isMatch(cArr, i15, i11, i12);
                if (isMatch > 0) {
                    replaceImpl(i15, i15 + isMatch, isMatch, str, i14);
                    i12 = (i12 - isMatch) + i14;
                    i15 = (i15 + i14) - 1;
                    if (i13 > 0) {
                        i13--;
                    }
                }
                i15++;
            }
        }
        return this;
    }

    public StrBuilder append(CharSequence charSequence) {
        if (charSequence == null) {
            return appendNull();
        }
        return append(charSequence.toString());
    }

    public StrBuilder appendAll(Iterator<?> it) {
        if (it != null) {
            while (it.hasNext()) {
                append((Object) it.next());
            }
        }
        return this;
    }

    public StrBuilder appendSeparator(char c11, char c12) {
        if (size() > 0) {
            append(c11);
        } else {
            append(c12);
        }
        return this;
    }

    public StrBuilder appendln(StringBuilder sb2) {
        return append(sb2).appendNewLine();
    }

    public StrBuilder deleteAll(String str) {
        int length = str == null ? 0 : str.length();
        if (length > 0) {
            int indexOf = indexOf(str, 0);
            while (indexOf >= 0) {
                deleteImpl(indexOf, indexOf + length, length);
                indexOf = indexOf(str, indexOf);
            }
        }
        return this;
    }

    public int indexOf(String str) {
        return indexOf(str, 0);
    }

    public StrBuilder appendWithSeparators(Iterable<?> iterable, String str) {
        if (iterable != null) {
            String objectUtils = ObjectUtils.toString(str);
            Iterator<?> it = iterable.iterator();
            while (it.hasNext()) {
                append((Object) it.next());
                if (it.hasNext()) {
                    append(objectUtils);
                }
            }
        }
        return this;
    }

    public StrBuilder appendln(StringBuilder sb2, int i11, int i12) {
        return append(sb2, i11, i12).appendNewLine();
    }

    public StrBuilder deleteFirst(StrMatcher strMatcher) {
        return replace(strMatcher, (String) null, 0, this.size, 1);
    }

    public int indexOf(String str, int i11) {
        if (i11 < 0) {
            i11 = 0;
        }
        if (str != null && i11 < this.size) {
            int length = str.length();
            if (length == 1) {
                return indexOf(str.charAt(0), i11);
            }
            if (length == 0) {
                return i11;
            }
            int i12 = this.size;
            if (length > i12) {
                return -1;
            }
            char[] cArr = this.buffer;
            int i13 = (i12 - length) + 1;
            while (i11 < i13) {
                int i14 = 0;
                while (i14 < length) {
                    if (str.charAt(i14) != cArr[i11 + i14]) {
                        i11++;
                    } else {
                        i14++;
                    }
                }
                return i11;
            }
        }
        return -1;
    }

    public StrBuilder append(CharSequence charSequence, int i11, int i12) {
        if (charSequence == null) {
            return appendNull();
        }
        return append(charSequence.toString(), i11, i12);
    }

    public StrBuilder appendFixedWidthPadLeft(int i11, int i12, char c11) {
        return appendFixedWidthPadLeft((Object) String.valueOf(i11), i12, c11);
    }

    public StrBuilder appendFixedWidthPadRight(int i11, int i12, char c11) {
        return appendFixedWidthPadRight((Object) String.valueOf(i11), i12, c11);
    }

    public StrBuilder appendln(StringBuffer stringBuffer, int i11, int i12) {
        return append(stringBuffer, i11, i12).appendNewLine();
    }

    public StrBuilder replaceFirst(StrMatcher strMatcher, String str) {
        return replace(strMatcher, str, 0, this.size, 1);
    }

    public StrBuilder appendSeparator(String str, int i11) {
        if (str != null && i11 > 0) {
            append(str);
        }
        return this;
    }

    public StrBuilder appendln(StrBuilder strBuilder) {
        return append(strBuilder).appendNewLine();
    }

    public StrBuilder replaceAll(StrMatcher strMatcher, String str) {
        return replace(strMatcher, str, 0, this.size, -1);
    }

    public StrBuilder append(String str) {
        if (str == null) {
            return appendNull();
        }
        int length = str.length();
        if (length > 0) {
            int length2 = length();
            ensureCapacity(length2 + length);
            str.getChars(0, length, this.buffer, length2);
            this.size += length;
        }
        return this;
    }

    public StrBuilder appendSeparator(char c11, int i11) {
        if (i11 > 0) {
            append(c11);
        }
        return this;
    }

    public StrBuilder appendln(StrBuilder strBuilder, int i11, int i12) {
        return append(strBuilder, i11, i12).appendNewLine();
    }

    public StrBuilder deleteAll(StrMatcher strMatcher) {
        return replace(strMatcher, (String) null, 0, this.size, -1);
    }

    public int lastIndexOf(StrMatcher strMatcher) {
        return lastIndexOf(strMatcher, this.size);
    }

    public StrBuilder appendln(char[] cArr) {
        return append(cArr).appendNewLine();
    }

    public StrBuilder insert(int i11, char[] cArr) {
        validateIndex(i11);
        if (cArr == null) {
            return insert(i11, this.nullText);
        }
        int length = cArr.length;
        if (length > 0) {
            ensureCapacity(this.size + length);
            char[] cArr2 = this.buffer;
            System.arraycopy(cArr2, i11, cArr2, i11 + length, this.size - i11);
            System.arraycopy(cArr, 0, this.buffer, i11, length);
            this.size += length;
        }
        return this;
    }

    public int lastIndexOf(StrMatcher strMatcher, int i11) {
        int i12 = this.size;
        if (i11 >= i12) {
            i11 = i12 - 1;
        }
        if (strMatcher != null && i11 >= 0) {
            char[] cArr = this.buffer;
            int i13 = i11 + 1;
            while (i11 >= 0) {
                if (strMatcher.isMatch(cArr, i11, 0, i13) > 0) {
                    return i11;
                }
                i11--;
            }
        }
        return -1;
    }

    public StrBuilder appendln(char[] cArr, int i11, int i12) {
        return append(cArr, i11, i12).appendNewLine();
    }

    public StrBuilder appendWithSeparators(Iterator<?> it, String str) {
        if (it != null) {
            String objectUtils = ObjectUtils.toString(str);
            while (it.hasNext()) {
                append((Object) it.next());
                if (it.hasNext()) {
                    append(objectUtils);
                }
            }
        }
        return this;
    }

    public StrBuilder appendln(boolean z11) {
        return append(z11).appendNewLine();
    }

    public int indexOf(StrMatcher strMatcher) {
        return indexOf(strMatcher, 0);
    }

    public StrBuilder appendln(char c11) {
        return append(c11).appendNewLine();
    }

    public int indexOf(StrMatcher strMatcher, int i11) {
        int i12;
        if (i11 < 0) {
            i11 = 0;
        }
        if (strMatcher != null && i11 < (i12 = this.size)) {
            char[] cArr = this.buffer;
            for (int i13 = i11; i13 < i12; i13++) {
                if (strMatcher.isMatch(cArr, i13, i11, i12) > 0) {
                    return i13;
                }
            }
        }
        return -1;
    }

    public StrBuilder appendln(int i11) {
        return append(i11).appendNewLine();
    }

    public StrBuilder append(String str, int i11, int i12) {
        int i13;
        if (str == null) {
            return appendNull();
        }
        if (i11 < 0 || i11 > str.length()) {
            throw new StringIndexOutOfBoundsException("startIndex must be valid");
        } else if (i12 < 0 || (i13 = i11 + i12) > str.length()) {
            throw new StringIndexOutOfBoundsException("length must be valid");
        } else {
            if (i12 > 0) {
                int length = length();
                ensureCapacity(length + i12);
                str.getChars(i11, i13, this.buffer, length);
                this.size += i12;
            }
            return this;
        }
    }

    public StrBuilder appendln(long j11) {
        return append(j11).appendNewLine();
    }

    public StrBuilder appendln(float f11) {
        return append(f11).appendNewLine();
    }

    public StrBuilder appendln(double d11) {
        return append(d11).appendNewLine();
    }

    public StrBuilder insert(int i11, char[] cArr, int i12, int i13) {
        validateIndex(i11);
        if (cArr == null) {
            return insert(i11, this.nullText);
        }
        if (i12 < 0 || i12 > cArr.length) {
            throw new StringIndexOutOfBoundsException("Invalid offset: " + i12);
        } else if (i13 < 0 || i12 + i13 > cArr.length) {
            throw new StringIndexOutOfBoundsException("Invalid length: " + i13);
        } else {
            if (i13 > 0) {
                ensureCapacity(this.size + i13);
                char[] cArr2 = this.buffer;
                System.arraycopy(cArr2, i11, cArr2, i11 + i13, this.size - i11);
                System.arraycopy(cArr, i12, this.buffer, i11, i13);
                this.size += i13;
            }
            return this;
        }
    }

    public StrBuilder append(String str, Object... objArr) {
        return append(String.format(str, objArr));
    }

    public StrBuilder append(StringBuffer stringBuffer) {
        if (stringBuffer == null) {
            return appendNull();
        }
        int length = stringBuffer.length();
        if (length > 0) {
            int length2 = length();
            ensureCapacity(length2 + length);
            stringBuffer.getChars(0, length, this.buffer, length2);
            this.size += length;
        }
        return this;
    }

    public StrBuilder insert(int i11, boolean z11) {
        validateIndex(i11);
        if (z11) {
            ensureCapacity(this.size + 4);
            char[] cArr = this.buffer;
            System.arraycopy(cArr, i11, cArr, i11 + 4, this.size - i11);
            char[] cArr2 = this.buffer;
            int i12 = i11 + 1;
            cArr2[i11] = Advice.OffsetMapping.ForOrigin.Renderer.ForTypeName.SYMBOL;
            int i13 = i12 + 1;
            cArr2[i12] = Advice.OffsetMapping.ForOrigin.Renderer.ForReturnTypeName.SYMBOL;
            cArr2[i13] = AbstractJsonLexerKt.UNICODE_ESC;
            cArr2[i13 + 1] = 'e';
            this.size += 4;
        } else {
            ensureCapacity(this.size + 5);
            char[] cArr3 = this.buffer;
            System.arraycopy(cArr3, i11, cArr3, i11 + 5, this.size - i11);
            char[] cArr4 = this.buffer;
            int i14 = i11 + 1;
            cArr4[i11] = 'f';
            int i15 = i14 + 1;
            cArr4[i14] = 'a';
            int i16 = i15 + 1;
            cArr4[i15] = 'l';
            cArr4[i16] = Advice.OffsetMapping.ForOrigin.Renderer.ForJavaSignature.SYMBOL;
            cArr4[i16 + 1] = 'e';
            this.size += 5;
        }
        return this;
    }

    public StrBuilder append(StringBuffer stringBuffer, int i11, int i12) {
        int i13;
        if (stringBuffer == null) {
            return appendNull();
        }
        if (i11 < 0 || i11 > stringBuffer.length()) {
            throw new StringIndexOutOfBoundsException("startIndex must be valid");
        } else if (i12 < 0 || (i13 = i11 + i12) > stringBuffer.length()) {
            throw new StringIndexOutOfBoundsException("length must be valid");
        } else {
            if (i12 > 0) {
                int length = length();
                ensureCapacity(length + i12);
                stringBuffer.getChars(i11, i13, this.buffer, length);
                this.size += i12;
            }
            return this;
        }
    }

    public StrBuilder append(StringBuilder sb2) {
        if (sb2 == null) {
            return appendNull();
        }
        int length = sb2.length();
        if (length > 0) {
            int length2 = length();
            ensureCapacity(length2 + length);
            sb2.getChars(0, length, this.buffer, length2);
            this.size += length;
        }
        return this;
    }

    public StrBuilder insert(int i11, char c11) {
        validateIndex(i11);
        ensureCapacity(this.size + 1);
        char[] cArr = this.buffer;
        System.arraycopy(cArr, i11, cArr, i11 + 1, this.size - i11);
        this.buffer[i11] = c11;
        this.size++;
        return this;
    }

    public StrBuilder append(StringBuilder sb2, int i11, int i12) {
        int i13;
        if (sb2 == null) {
            return appendNull();
        }
        if (i11 < 0 || i11 > sb2.length()) {
            throw new StringIndexOutOfBoundsException("startIndex must be valid");
        } else if (i12 < 0 || (i13 = i11 + i12) > sb2.length()) {
            throw new StringIndexOutOfBoundsException("length must be valid");
        } else {
            if (i12 > 0) {
                int length = length();
                ensureCapacity(length + i12);
                sb2.getChars(i11, i13, this.buffer, length);
                this.size += i12;
            }
            return this;
        }
    }

    public StrBuilder insert(int i11, int i12) {
        return insert(i11, String.valueOf(i12));
    }

    public StrBuilder insert(int i11, long j11) {
        return insert(i11, String.valueOf(j11));
    }

    public StrBuilder insert(int i11, float f11) {
        return insert(i11, String.valueOf(f11));
    }

    public StrBuilder insert(int i11, double d11) {
        return insert(i11, String.valueOf(d11));
    }

    public StrBuilder append(StrBuilder strBuilder) {
        if (strBuilder == null) {
            return appendNull();
        }
        int length = strBuilder.length();
        if (length > 0) {
            int length2 = length();
            ensureCapacity(length2 + length);
            System.arraycopy(strBuilder.buffer, 0, this.buffer, length2, length);
            this.size += length;
        }
        return this;
    }

    public StrBuilder append(StrBuilder strBuilder, int i11, int i12) {
        int i13;
        if (strBuilder == null) {
            return appendNull();
        }
        if (i11 < 0 || i11 > strBuilder.length()) {
            throw new StringIndexOutOfBoundsException("startIndex must be valid");
        } else if (i12 < 0 || (i13 = i11 + i12) > strBuilder.length()) {
            throw new StringIndexOutOfBoundsException("length must be valid");
        } else {
            if (i12 > 0) {
                int length = length();
                ensureCapacity(length + i12);
                strBuilder.getChars(i11, i13, this.buffer, length);
                this.size += i12;
            }
            return this;
        }
    }

    public StrBuilder append(char[] cArr) {
        if (cArr == null) {
            return appendNull();
        }
        int length = cArr.length;
        if (length > 0) {
            int length2 = length();
            ensureCapacity(length2 + length);
            System.arraycopy(cArr, 0, this.buffer, length2, length);
            this.size += length;
        }
        return this;
    }

    public StrBuilder append(char[] cArr, int i11, int i12) {
        if (cArr == null) {
            return appendNull();
        }
        if (i11 < 0 || i11 > cArr.length) {
            throw new StringIndexOutOfBoundsException("Invalid startIndex: " + i12);
        } else if (i12 < 0 || i11 + i12 > cArr.length) {
            throw new StringIndexOutOfBoundsException("Invalid length: " + i12);
        } else {
            if (i12 > 0) {
                int length = length();
                ensureCapacity(length + i12);
                System.arraycopy(cArr, i11, this.buffer, length, i12);
                this.size += i12;
            }
            return this;
        }
    }

    public StrBuilder append(boolean z11) {
        if (z11) {
            ensureCapacity(this.size + 4);
            char[] cArr = this.buffer;
            int i11 = this.size;
            int i12 = i11 + 1;
            cArr[i11] = Advice.OffsetMapping.ForOrigin.Renderer.ForTypeName.SYMBOL;
            int i13 = i12 + 1;
            cArr[i12] = Advice.OffsetMapping.ForOrigin.Renderer.ForReturnTypeName.SYMBOL;
            int i14 = i13 + 1;
            cArr[i13] = AbstractJsonLexerKt.UNICODE_ESC;
            this.size = i14 + 1;
            cArr[i14] = 'e';
        } else {
            ensureCapacity(this.size + 5);
            char[] cArr2 = this.buffer;
            int i15 = this.size;
            int i16 = i15 + 1;
            cArr2[i15] = 'f';
            int i17 = i16 + 1;
            cArr2[i16] = 'a';
            int i18 = i17 + 1;
            cArr2[i17] = 'l';
            int i19 = i18 + 1;
            cArr2[i18] = Advice.OffsetMapping.ForOrigin.Renderer.ForJavaSignature.SYMBOL;
            this.size = i19 + 1;
            cArr2[i19] = 'e';
        }
        return this;
    }

    public StrBuilder append(char c11) {
        ensureCapacity(length() + 1);
        char[] cArr = this.buffer;
        int i11 = this.size;
        this.size = i11 + 1;
        cArr[i11] = c11;
        return this;
    }

    public StrBuilder append(int i11) {
        return append(String.valueOf(i11));
    }

    public StrBuilder append(long j11) {
        return append(String.valueOf(j11));
    }

    public StrBuilder append(float f11) {
        return append(String.valueOf(f11));
    }

    public StrBuilder append(double d11) {
        return append(String.valueOf(d11));
    }
}
