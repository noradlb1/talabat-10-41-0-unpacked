package com.squareup.moshi;

import com.instabug.library.encryption.EncryptionManager;
import com.squareup.moshi.JsonReader;
import java.io.EOFException;
import java.io.IOException;
import java.math.BigDecimal;
import javax.annotation.Nullable;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import org.apache.commons.lang3.CharUtils;

final class JsonUtf8Reader extends JsonReader {
    private static final ByteString CLOSING_BLOCK_COMMENT = ByteString.encodeUtf8("*/");
    private static final ByteString DOUBLE_QUOTE_OR_SLASH = ByteString.encodeUtf8("\"\\");
    private static final ByteString LINEFEED_OR_CARRIAGE_RETURN = ByteString.encodeUtf8(EncryptionManager.LINE_FEED);
    private static final long MIN_INCOMPLETE_INTEGER = -922337203685477580L;
    private static final int NUMBER_CHAR_DECIMAL = 3;
    private static final int NUMBER_CHAR_DIGIT = 2;
    private static final int NUMBER_CHAR_EXP_DIGIT = 7;
    private static final int NUMBER_CHAR_EXP_E = 5;
    private static final int NUMBER_CHAR_EXP_SIGN = 6;
    private static final int NUMBER_CHAR_FRACTION_DIGIT = 4;
    private static final int NUMBER_CHAR_NONE = 0;
    private static final int NUMBER_CHAR_SIGN = 1;
    private static final int PEEKED_BEGIN_ARRAY = 3;
    private static final int PEEKED_BEGIN_OBJECT = 1;
    private static final int PEEKED_BUFFERED = 11;
    private static final int PEEKED_BUFFERED_NAME = 15;
    private static final int PEEKED_DOUBLE_QUOTED = 9;
    private static final int PEEKED_DOUBLE_QUOTED_NAME = 13;
    private static final int PEEKED_END_ARRAY = 4;
    private static final int PEEKED_END_OBJECT = 2;
    private static final int PEEKED_EOF = 18;
    private static final int PEEKED_FALSE = 6;
    private static final int PEEKED_LONG = 16;
    private static final int PEEKED_NONE = 0;
    private static final int PEEKED_NULL = 7;
    private static final int PEEKED_NUMBER = 17;
    private static final int PEEKED_SINGLE_QUOTED = 8;
    private static final int PEEKED_SINGLE_QUOTED_NAME = 12;
    private static final int PEEKED_TRUE = 5;
    private static final int PEEKED_UNQUOTED = 10;
    private static final int PEEKED_UNQUOTED_NAME = 14;
    private static final ByteString SINGLE_QUOTE_OR_SLASH = ByteString.encodeUtf8("'\\");
    private static final ByteString UNQUOTED_STRING_TERMINALS = ByteString.encodeUtf8("{}[]:, \n\t\r\f/\\;#=");
    private final Buffer buffer;
    private int peeked = 0;
    private long peekedLong;
    private int peekedNumberLength;
    @Nullable
    private String peekedString;
    private final BufferedSource source;
    @Nullable
    private JsonValueSource valueSource;

    public JsonUtf8Reader(BufferedSource bufferedSource) {
        if (bufferedSource != null) {
            this.source = bufferedSource;
            this.buffer = bufferedSource.getBuffer();
            a(6);
            return;
        }
        throw new NullPointerException("source == null");
    }

    private void checkLenient() throws IOException {
        if (!this.f53259f) {
            throw b("Use JsonReader.setLenient(true) to accept malformed JSON");
        }
    }

    private int doPeek() throws IOException {
        int[] iArr = this.f53256c;
        int i11 = this.f53255b;
        int i12 = iArr[i11 - 1];
        if (i12 == 1) {
            iArr[i11 - 1] = 2;
        } else if (i12 == 2) {
            int nextNonWhitespace = nextNonWhitespace(true);
            this.buffer.readByte();
            if (nextNonWhitespace != 44) {
                if (nextNonWhitespace == 59) {
                    checkLenient();
                } else if (nextNonWhitespace == 93) {
                    this.peeked = 4;
                    return 4;
                } else {
                    throw b("Unterminated array");
                }
            }
        } else if (i12 == 3 || i12 == 5) {
            iArr[i11 - 1] = 4;
            if (i12 == 5) {
                int nextNonWhitespace2 = nextNonWhitespace(true);
                this.buffer.readByte();
                if (nextNonWhitespace2 != 44) {
                    if (nextNonWhitespace2 == 59) {
                        checkLenient();
                    } else if (nextNonWhitespace2 == 125) {
                        this.peeked = 2;
                        return 2;
                    } else {
                        throw b("Unterminated object");
                    }
                }
            }
            int nextNonWhitespace3 = nextNonWhitespace(true);
            if (nextNonWhitespace3 == 34) {
                this.buffer.readByte();
                this.peeked = 13;
                return 13;
            } else if (nextNonWhitespace3 == 39) {
                this.buffer.readByte();
                checkLenient();
                this.peeked = 12;
                return 12;
            } else if (nextNonWhitespace3 != 125) {
                checkLenient();
                if (isLiteral((char) nextNonWhitespace3)) {
                    this.peeked = 14;
                    return 14;
                }
                throw b("Expected name");
            } else if (i12 != 5) {
                this.buffer.readByte();
                this.peeked = 2;
                return 2;
            } else {
                throw b("Expected name");
            }
        } else if (i12 == 4) {
            iArr[i11 - 1] = 5;
            int nextNonWhitespace4 = nextNonWhitespace(true);
            this.buffer.readByte();
            if (nextNonWhitespace4 != 58) {
                if (nextNonWhitespace4 == 61) {
                    checkLenient();
                    if (this.source.request(1) && this.buffer.getByte(0) == 62) {
                        this.buffer.readByte();
                    }
                } else {
                    throw b("Expected ':'");
                }
            }
        } else if (i12 == 6) {
            iArr[i11 - 1] = 7;
        } else if (i12 == 7) {
            if (nextNonWhitespace(false) == -1) {
                this.peeked = 18;
                return 18;
            }
            checkLenient();
        } else if (i12 == 9) {
            this.valueSource.discard();
            this.valueSource = null;
            this.f53255b--;
            return doPeek();
        } else if (i12 == 8) {
            throw new IllegalStateException("JsonReader is closed");
        }
        int nextNonWhitespace5 = nextNonWhitespace(true);
        if (nextNonWhitespace5 == 34) {
            this.buffer.readByte();
            this.peeked = 9;
            return 9;
        } else if (nextNonWhitespace5 != 39) {
            if (!(nextNonWhitespace5 == 44 || nextNonWhitespace5 == 59)) {
                if (nextNonWhitespace5 == 91) {
                    this.buffer.readByte();
                    this.peeked = 3;
                    return 3;
                } else if (nextNonWhitespace5 != 93) {
                    if (nextNonWhitespace5 != 123) {
                        int peekKeyword = peekKeyword();
                        if (peekKeyword != 0) {
                            return peekKeyword;
                        }
                        int peekNumber = peekNumber();
                        if (peekNumber != 0) {
                            return peekNumber;
                        }
                        if (isLiteral(this.buffer.getByte(0))) {
                            checkLenient();
                            this.peeked = 10;
                            return 10;
                        }
                        throw b("Expected value");
                    }
                    this.buffer.readByte();
                    this.peeked = 1;
                    return 1;
                } else if (i12 == 1) {
                    this.buffer.readByte();
                    this.peeked = 4;
                    return 4;
                }
            }
            if (i12 == 1 || i12 == 2) {
                checkLenient();
                this.peeked = 7;
                return 7;
            }
            throw b("Unexpected value");
        } else {
            checkLenient();
            this.buffer.readByte();
            this.peeked = 8;
            return 8;
        }
    }

    private int findName(String str, JsonReader.Options options) {
        int length = options.f53262a.length;
        for (int i11 = 0; i11 < length; i11++) {
            if (str.equals(options.f53262a[i11])) {
                this.peeked = 0;
                this.f53257d[this.f53255b - 1] = str;
                return i11;
            }
        }
        return -1;
    }

    private int findString(String str, JsonReader.Options options) {
        int length = options.f53262a.length;
        for (int i11 = 0; i11 < length; i11++) {
            if (str.equals(options.f53262a[i11])) {
                this.peeked = 0;
                int[] iArr = this.f53258e;
                int i12 = this.f53255b - 1;
                iArr[i12] = iArr[i12] + 1;
                return i11;
            }
        }
        return -1;
    }

    private boolean isLiteral(int i11) throws IOException {
        if (i11 == 9 || i11 == 10 || i11 == 12 || i11 == 13 || i11 == 32) {
            return false;
        }
        if (i11 != 35) {
            if (i11 == 44) {
                return false;
            }
            if (!(i11 == 47 || i11 == 61)) {
                if (i11 == 123 || i11 == 125 || i11 == 58) {
                    return false;
                }
                if (i11 != 59) {
                    switch (i11) {
                        case 91:
                        case 93:
                            return false;
                        case 92:
                            break;
                        default:
                            return true;
                    }
                }
            }
        }
        checkLenient();
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0025, code lost:
        r6.buffer.skip((long) (r3 - 1));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002f, code lost:
        if (r1 != 47) goto L_0x0074;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0039, code lost:
        if (r6.source.request(2) != false) goto L_0x003c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003b, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x003c, code lost:
        checkLenient();
        r3 = r6.buffer.getByte(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0049, code lost:
        if (r3 == 42) goto L_0x005c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x004b, code lost:
        if (r3 == 47) goto L_0x004e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x004d, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x004e, code lost:
        r6.buffer.readByte();
        r6.buffer.readByte();
        skipToEndOfLine();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x005c, code lost:
        r6.buffer.readByte();
        r6.buffer.readByte();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x006a, code lost:
        if (skipToEndOfBlockComment() == false) goto L_0x006d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0073, code lost:
        throw b("Unterminated comment");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0076, code lost:
        if (r1 != 35) goto L_0x007f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0078, code lost:
        checkLenient();
        skipToEndOfLine();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x007f, code lost:
        return r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int nextNonWhitespace(boolean r7) throws java.io.IOException {
        /*
            r6 = this;
            r0 = 0
        L_0x0001:
            r1 = r0
        L_0x0002:
            okio.BufferedSource r2 = r6.source
            int r3 = r1 + 1
            long r4 = (long) r3
            boolean r2 = r2.request(r4)
            if (r2 == 0) goto L_0x0082
            okio.Buffer r2 = r6.buffer
            long r4 = (long) r1
            byte r1 = r2.getByte(r4)
            r2 = 10
            if (r1 == r2) goto L_0x0080
            r2 = 32
            if (r1 == r2) goto L_0x0080
            r2 = 13
            if (r1 == r2) goto L_0x0080
            r2 = 9
            if (r1 != r2) goto L_0x0025
            goto L_0x0080
        L_0x0025:
            okio.Buffer r2 = r6.buffer
            int r3 = r3 + -1
            long r3 = (long) r3
            r2.skip(r3)
            r2 = 47
            if (r1 != r2) goto L_0x0074
            okio.BufferedSource r3 = r6.source
            r4 = 2
            boolean r3 = r3.request(r4)
            if (r3 != 0) goto L_0x003c
            return r1
        L_0x003c:
            r6.checkLenient()
            okio.Buffer r3 = r6.buffer
            r4 = 1
            byte r3 = r3.getByte(r4)
            r4 = 42
            if (r3 == r4) goto L_0x005c
            if (r3 == r2) goto L_0x004e
            return r1
        L_0x004e:
            okio.Buffer r1 = r6.buffer
            r1.readByte()
            okio.Buffer r1 = r6.buffer
            r1.readByte()
            r6.skipToEndOfLine()
            goto L_0x0001
        L_0x005c:
            okio.Buffer r1 = r6.buffer
            r1.readByte()
            okio.Buffer r1 = r6.buffer
            r1.readByte()
            boolean r1 = r6.skipToEndOfBlockComment()
            if (r1 == 0) goto L_0x006d
            goto L_0x0001
        L_0x006d:
            java.lang.String r7 = "Unterminated comment"
            com.squareup.moshi.JsonEncodingException r7 = r6.b(r7)
            throw r7
        L_0x0074:
            r2 = 35
            if (r1 != r2) goto L_0x007f
            r6.checkLenient()
            r6.skipToEndOfLine()
            goto L_0x0001
        L_0x007f:
            return r1
        L_0x0080:
            r1 = r3
            goto L_0x0002
        L_0x0082:
            if (r7 != 0) goto L_0x0086
            r7 = -1
            return r7
        L_0x0086:
            java.io.EOFException r7 = new java.io.EOFException
            java.lang.String r0 = "End of input"
            r7.<init>(r0)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.moshi.JsonUtf8Reader.nextNonWhitespace(boolean):int");
    }

    private String nextQuotedValue(ByteString byteString) throws IOException {
        StringBuilder sb2 = null;
        while (true) {
            long indexOfElement = this.source.indexOfElement(byteString);
            if (indexOfElement == -1) {
                throw b("Unterminated string");
            } else if (this.buffer.getByte(indexOfElement) == 92) {
                if (sb2 == null) {
                    sb2 = new StringBuilder();
                }
                sb2.append(this.buffer.readUtf8(indexOfElement));
                this.buffer.readByte();
                sb2.append(readEscapeCharacter());
            } else if (sb2 == null) {
                String readUtf8 = this.buffer.readUtf8(indexOfElement);
                this.buffer.readByte();
                return readUtf8;
            } else {
                sb2.append(this.buffer.readUtf8(indexOfElement));
                this.buffer.readByte();
                return sb2.toString();
            }
        }
    }

    private String nextUnquotedValue() throws IOException {
        long indexOfElement = this.source.indexOfElement(UNQUOTED_STRING_TERMINALS);
        if (indexOfElement != -1) {
            return this.buffer.readUtf8(indexOfElement);
        }
        return this.buffer.readUtf8();
    }

    private int peekKeyword() throws IOException {
        int i11;
        String str;
        String str2;
        byte b11 = this.buffer.getByte(0);
        if (b11 == 116 || b11 == 84) {
            str2 = "true";
            str = "TRUE";
            i11 = 5;
        } else if (b11 == 102 || b11 == 70) {
            str2 = "false";
            str = "FALSE";
            i11 = 6;
        } else if (b11 != 110 && b11 != 78) {
            return 0;
        } else {
            str2 = "null";
            str = "NULL";
            i11 = 7;
        }
        int length = str2.length();
        int i12 = 1;
        while (i12 < length) {
            int i13 = i12 + 1;
            if (!this.source.request((long) i13)) {
                return 0;
            }
            byte b12 = this.buffer.getByte((long) i12);
            if (b12 != str2.charAt(i12) && b12 != str.charAt(i12)) {
                return 0;
            }
            i12 = i13;
        }
        if (this.source.request((long) (length + 1)) && isLiteral(this.buffer.getByte((long) length))) {
            return 0;
        }
        this.buffer.skip((long) length);
        this.peeked = i11;
        return i11;
    }

    private int peekNumber() throws IOException {
        byte b11;
        char c11;
        boolean z11;
        boolean z12 = true;
        long j11 = 0;
        int i11 = 0;
        char c12 = 0;
        boolean z13 = false;
        boolean z14 = true;
        while (true) {
            int i12 = i11 + 1;
            if (!this.source.request((long) i12)) {
                break;
            }
            b11 = this.buffer.getByte((long) i11);
            if (b11 == 43) {
                c11 = 6;
                if (c12 != 5) {
                    return 0;
                }
            } else if (b11 != 69 && b11 != 101) {
                if (b11 == 45) {
                    c11 = 6;
                    if (c12 == 0) {
                        c12 = 1;
                        z13 = true;
                    } else if (c12 != 5) {
                        return 0;
                    }
                } else if (b11 != 46) {
                    if (b11 >= 48 && b11 <= 57) {
                        if (c12 == z12 || c12 == 0) {
                            j11 = (long) (-(b11 - 48));
                            c12 = 2;
                        } else if (c12 == 2) {
                            if (j11 == 0) {
                                return 0;
                            }
                            long j12 = (10 * j11) - ((long) (b11 - 48));
                            int i13 = (j11 > -922337203685477580L ? 1 : (j11 == -922337203685477580L ? 0 : -1));
                            if (i13 > 0 || (i13 == 0 && j12 < j11)) {
                                z11 = true;
                            } else {
                                z11 = false;
                            }
                            z14 &= z11;
                            j11 = j12;
                        } else if (c12 == 3) {
                            c12 = 4;
                        } else if (c12 == 5 || c12 == 6) {
                            c12 = 7;
                        }
                    }
                } else if (c12 != 2) {
                    return 0;
                } else {
                    c12 = 3;
                }
                i11 = i12;
                z12 = true;
            } else if (c12 != 2 && c12 != 4) {
                return 0;
            } else {
                c12 = 5;
                i11 = i12;
                z12 = true;
            }
            c12 = c11;
            i11 = i12;
            z12 = true;
        }
        if (isLiteral(b11)) {
            return 0;
        }
        if (c12 == 2 && z14 && ((j11 != Long.MIN_VALUE || z13) && (j11 != 0 || !z13))) {
            if (!z13) {
                j11 = -j11;
            }
            this.peekedLong = j11;
            this.buffer.skip((long) i11);
            this.peeked = 16;
            return 16;
        } else if (c12 != 2 && c12 != 4 && c12 != 7) {
            return 0;
        } else {
            this.peekedNumberLength = i11;
            this.peeked = 17;
            return 17;
        }
    }

    private char readEscapeCharacter() throws IOException {
        int i11;
        int i12;
        if (this.source.request(1)) {
            byte readByte = this.buffer.readByte();
            if (readByte == 10 || readByte == 34 || readByte == 39 || readByte == 47 || readByte == 92) {
                return (char) readByte;
            }
            if (readByte == 98) {
                return 8;
            }
            if (readByte == 102) {
                return 12;
            }
            if (readByte == 110) {
                return 10;
            }
            if (readByte == 114) {
                return CharUtils.CR;
            }
            if (readByte == 116) {
                return 9;
            }
            if (readByte != 117) {
                if (this.f53259f) {
                    return (char) readByte;
                }
                throw b("Invalid escape sequence: \\" + ((char) readByte));
            } else if (this.source.request(4)) {
                char c11 = 0;
                for (int i13 = 0; i13 < 4; i13++) {
                    byte b11 = this.buffer.getByte((long) i13);
                    char c12 = (char) (c11 << 4);
                    if (b11 < 48 || b11 > 57) {
                        if (b11 >= 97 && b11 <= 102) {
                            i11 = b11 - 97;
                        } else if (b11 < 65 || b11 > 70) {
                            throw b("\\u" + this.buffer.readUtf8(4));
                        } else {
                            i11 = b11 - 65;
                        }
                        i12 = i11 + 10;
                    } else {
                        i12 = b11 - 48;
                    }
                    c11 = (char) (c12 + i12);
                }
                this.buffer.skip(4);
                return c11;
            } else {
                throw new EOFException("Unterminated escape sequence at path " + getPath());
            }
        } else {
            throw b("Unterminated escape sequence");
        }
    }

    private void skipQuotedValue(ByteString byteString) throws IOException {
        while (true) {
            long indexOfElement = this.source.indexOfElement(byteString);
            if (indexOfElement == -1) {
                throw b("Unterminated string");
            } else if (this.buffer.getByte(indexOfElement) == 92) {
                this.buffer.skip(indexOfElement + 1);
                readEscapeCharacter();
            } else {
                this.buffer.skip(indexOfElement + 1);
                return;
            }
        }
    }

    private boolean skipToEndOfBlockComment() throws IOException {
        boolean z11;
        long j11;
        BufferedSource bufferedSource = this.source;
        ByteString byteString = CLOSING_BLOCK_COMMENT;
        long indexOf = bufferedSource.indexOf(byteString);
        if (indexOf != -1) {
            z11 = true;
        } else {
            z11 = false;
        }
        Buffer buffer2 = this.buffer;
        if (z11) {
            j11 = indexOf + ((long) byteString.size());
        } else {
            j11 = buffer2.size();
        }
        buffer2.skip(j11);
        return z11;
    }

    private void skipToEndOfLine() throws IOException {
        long j11;
        long indexOfElement = this.source.indexOfElement(LINEFEED_OR_CARRIAGE_RETURN);
        Buffer buffer2 = this.buffer;
        if (indexOfElement != -1) {
            j11 = indexOfElement + 1;
        } else {
            j11 = buffer2.size();
        }
        buffer2.skip(j11);
    }

    private void skipUnquotedValue() throws IOException {
        long indexOfElement = this.source.indexOfElement(UNQUOTED_STRING_TERMINALS);
        Buffer buffer2 = this.buffer;
        if (indexOfElement == -1) {
            indexOfElement = buffer2.size();
        }
        buffer2.skip(indexOfElement);
    }

    public void beginArray() throws IOException {
        int i11 = this.peeked;
        if (i11 == 0) {
            i11 = doPeek();
        }
        if (i11 == 3) {
            a(1);
            this.f53258e[this.f53255b - 1] = 0;
            this.peeked = 0;
            return;
        }
        throw new JsonDataException("Expected BEGIN_ARRAY but was " + peek() + " at path " + getPath());
    }

    public void beginObject() throws IOException {
        int i11 = this.peeked;
        if (i11 == 0) {
            i11 = doPeek();
        }
        if (i11 == 1) {
            a(3);
            this.peeked = 0;
            return;
        }
        throw new JsonDataException("Expected BEGIN_OBJECT but was " + peek() + " at path " + getPath());
    }

    public void close() throws IOException {
        this.peeked = 0;
        this.f53256c[0] = 8;
        this.f53255b = 1;
        this.buffer.clear();
        this.source.close();
    }

    public void endArray() throws IOException {
        int i11 = this.peeked;
        if (i11 == 0) {
            i11 = doPeek();
        }
        if (i11 == 4) {
            int i12 = this.f53255b - 1;
            this.f53255b = i12;
            int[] iArr = this.f53258e;
            int i13 = i12 - 1;
            iArr[i13] = iArr[i13] + 1;
            this.peeked = 0;
            return;
        }
        throw new JsonDataException("Expected END_ARRAY but was " + peek() + " at path " + getPath());
    }

    public void endObject() throws IOException {
        int i11 = this.peeked;
        if (i11 == 0) {
            i11 = doPeek();
        }
        if (i11 == 2) {
            int i12 = this.f53255b - 1;
            this.f53255b = i12;
            this.f53257d[i12] = null;
            int[] iArr = this.f53258e;
            int i13 = i12 - 1;
            iArr[i13] = iArr[i13] + 1;
            this.peeked = 0;
            return;
        }
        throw new JsonDataException("Expected END_OBJECT but was " + peek() + " at path " + getPath());
    }

    public boolean hasNext() throws IOException {
        int i11 = this.peeked;
        if (i11 == 0) {
            i11 = doPeek();
        }
        if (i11 == 2 || i11 == 4 || i11 == 18) {
            return false;
        }
        return true;
    }

    public boolean nextBoolean() throws IOException {
        int i11 = this.peeked;
        if (i11 == 0) {
            i11 = doPeek();
        }
        if (i11 == 5) {
            this.peeked = 0;
            int[] iArr = this.f53258e;
            int i12 = this.f53255b - 1;
            iArr[i12] = iArr[i12] + 1;
            return true;
        } else if (i11 == 6) {
            this.peeked = 0;
            int[] iArr2 = this.f53258e;
            int i13 = this.f53255b - 1;
            iArr2[i13] = iArr2[i13] + 1;
            return false;
        } else {
            throw new JsonDataException("Expected a boolean but was " + peek() + " at path " + getPath());
        }
    }

    public double nextDouble() throws IOException {
        int i11 = this.peeked;
        if (i11 == 0) {
            i11 = doPeek();
        }
        if (i11 == 16) {
            this.peeked = 0;
            int[] iArr = this.f53258e;
            int i12 = this.f53255b - 1;
            iArr[i12] = iArr[i12] + 1;
            return (double) this.peekedLong;
        }
        if (i11 == 17) {
            this.peekedString = this.buffer.readUtf8((long) this.peekedNumberLength);
        } else if (i11 == 9) {
            this.peekedString = nextQuotedValue(DOUBLE_QUOTE_OR_SLASH);
        } else if (i11 == 8) {
            this.peekedString = nextQuotedValue(SINGLE_QUOTE_OR_SLASH);
        } else if (i11 == 10) {
            this.peekedString = nextUnquotedValue();
        } else if (i11 != 11) {
            throw new JsonDataException("Expected a double but was " + peek() + " at path " + getPath());
        }
        this.peeked = 11;
        try {
            double parseDouble = Double.parseDouble(this.peekedString);
            if (this.f53259f || (!Double.isNaN(parseDouble) && !Double.isInfinite(parseDouble))) {
                this.peekedString = null;
                this.peeked = 0;
                int[] iArr2 = this.f53258e;
                int i13 = this.f53255b - 1;
                iArr2[i13] = iArr2[i13] + 1;
                return parseDouble;
            }
            throw new JsonEncodingException("JSON forbids NaN and infinities: " + parseDouble + " at path " + getPath());
        } catch (NumberFormatException unused) {
            throw new JsonDataException("Expected a double but was " + this.peekedString + " at path " + getPath());
        }
    }

    public int nextInt() throws IOException {
        String str;
        int i11 = this.peeked;
        if (i11 == 0) {
            i11 = doPeek();
        }
        if (i11 == 16) {
            long j11 = this.peekedLong;
            int i12 = (int) j11;
            if (j11 == ((long) i12)) {
                this.peeked = 0;
                int[] iArr = this.f53258e;
                int i13 = this.f53255b - 1;
                iArr[i13] = iArr[i13] + 1;
                return i12;
            }
            throw new JsonDataException("Expected an int but was " + this.peekedLong + " at path " + getPath());
        }
        if (i11 == 17) {
            this.peekedString = this.buffer.readUtf8((long) this.peekedNumberLength);
        } else if (i11 == 9 || i11 == 8) {
            if (i11 == 9) {
                str = nextQuotedValue(DOUBLE_QUOTE_OR_SLASH);
            } else {
                str = nextQuotedValue(SINGLE_QUOTE_OR_SLASH);
            }
            this.peekedString = str;
            try {
                int parseInt = Integer.parseInt(str);
                this.peeked = 0;
                int[] iArr2 = this.f53258e;
                int i14 = this.f53255b - 1;
                iArr2[i14] = iArr2[i14] + 1;
                return parseInt;
            } catch (NumberFormatException unused) {
            }
        } else if (i11 != 11) {
            throw new JsonDataException("Expected an int but was " + peek() + " at path " + getPath());
        }
        this.peeked = 11;
        try {
            double parseDouble = Double.parseDouble(this.peekedString);
            int i15 = (int) parseDouble;
            if (((double) i15) == parseDouble) {
                this.peekedString = null;
                this.peeked = 0;
                int[] iArr3 = this.f53258e;
                int i16 = this.f53255b - 1;
                iArr3[i16] = iArr3[i16] + 1;
                return i15;
            }
            throw new JsonDataException("Expected an int but was " + this.peekedString + " at path " + getPath());
        } catch (NumberFormatException unused2) {
            throw new JsonDataException("Expected an int but was " + this.peekedString + " at path " + getPath());
        }
    }

    public long nextLong() throws IOException {
        String str;
        int i11 = this.peeked;
        if (i11 == 0) {
            i11 = doPeek();
        }
        if (i11 == 16) {
            this.peeked = 0;
            int[] iArr = this.f53258e;
            int i12 = this.f53255b - 1;
            iArr[i12] = iArr[i12] + 1;
            return this.peekedLong;
        }
        if (i11 == 17) {
            this.peekedString = this.buffer.readUtf8((long) this.peekedNumberLength);
        } else if (i11 == 9 || i11 == 8) {
            if (i11 == 9) {
                str = nextQuotedValue(DOUBLE_QUOTE_OR_SLASH);
            } else {
                str = nextQuotedValue(SINGLE_QUOTE_OR_SLASH);
            }
            this.peekedString = str;
            try {
                long parseLong = Long.parseLong(str);
                this.peeked = 0;
                int[] iArr2 = this.f53258e;
                int i13 = this.f53255b - 1;
                iArr2[i13] = iArr2[i13] + 1;
                return parseLong;
            } catch (NumberFormatException unused) {
            }
        } else if (i11 != 11) {
            throw new JsonDataException("Expected a long but was " + peek() + " at path " + getPath());
        }
        this.peeked = 11;
        try {
            long longValueExact = new BigDecimal(this.peekedString).longValueExact();
            this.peekedString = null;
            this.peeked = 0;
            int[] iArr3 = this.f53258e;
            int i14 = this.f53255b - 1;
            iArr3[i14] = iArr3[i14] + 1;
            return longValueExact;
        } catch (ArithmeticException | NumberFormatException unused2) {
            throw new JsonDataException("Expected a long but was " + this.peekedString + " at path " + getPath());
        }
    }

    public String nextName() throws IOException {
        String str;
        int i11 = this.peeked;
        if (i11 == 0) {
            i11 = doPeek();
        }
        if (i11 == 14) {
            str = nextUnquotedValue();
        } else if (i11 == 13) {
            str = nextQuotedValue(DOUBLE_QUOTE_OR_SLASH);
        } else if (i11 == 12) {
            str = nextQuotedValue(SINGLE_QUOTE_OR_SLASH);
        } else if (i11 == 15) {
            str = this.peekedString;
            this.peekedString = null;
        } else {
            throw new JsonDataException("Expected a name but was " + peek() + " at path " + getPath());
        }
        this.peeked = 0;
        this.f53257d[this.f53255b - 1] = str;
        return str;
    }

    @Nullable
    public <T> T nextNull() throws IOException {
        int i11 = this.peeked;
        if (i11 == 0) {
            i11 = doPeek();
        }
        if (i11 == 7) {
            this.peeked = 0;
            int[] iArr = this.f53258e;
            int i12 = this.f53255b - 1;
            iArr[i12] = iArr[i12] + 1;
            return null;
        }
        throw new JsonDataException("Expected null but was " + peek() + " at path " + getPath());
    }

    /* JADX WARNING: Removed duplicated region for block: B:48:0x00bf  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public okio.BufferedSource nextSource() throws java.io.IOException {
        /*
            r9 = this;
            int r0 = r9.peeked
            if (r0 != 0) goto L_0x0008
            int r0 = r9.doPeek()
        L_0x0008:
            okio.Buffer r1 = new okio.Buffer
            r1.<init>()
            okio.ByteString r2 = com.squareup.moshi.JsonValueSource.f53273g
            r3 = 3
            r4 = 9
            r5 = 0
            r6 = 1
            if (r0 != r3) goto L_0x0020
            java.lang.String r0 = "["
            r1.writeUtf8((java.lang.String) r0)
            okio.ByteString r2 = com.squareup.moshi.JsonValueSource.f53268b
        L_0x001d:
            r0 = r6
            goto L_0x00bb
        L_0x0020:
            if (r0 != r6) goto L_0x002b
            java.lang.String r0 = "{"
            r1.writeUtf8((java.lang.String) r0)
            okio.ByteString r2 = com.squareup.moshi.JsonValueSource.f53268b
            goto L_0x001d
        L_0x002b:
            if (r0 != r4) goto L_0x0037
            java.lang.String r0 = "\""
            r1.writeUtf8((java.lang.String) r0)
            okio.ByteString r2 = com.squareup.moshi.JsonValueSource.f53270d
        L_0x0034:
            r0 = r5
            goto L_0x00bb
        L_0x0037:
            r3 = 8
            if (r0 != r3) goto L_0x0043
            java.lang.String r0 = "'"
            r1.writeUtf8((java.lang.String) r0)
            okio.ByteString r2 = com.squareup.moshi.JsonValueSource.f53269c
            goto L_0x0034
        L_0x0043:
            r3 = 17
            if (r0 == r3) goto L_0x00b2
            r3 = 16
            if (r0 == r3) goto L_0x00b2
            r3 = 10
            if (r0 != r3) goto L_0x0050
            goto L_0x00b2
        L_0x0050:
            r3 = 5
            if (r0 != r3) goto L_0x005a
            java.lang.String r0 = "true"
            r1.writeUtf8((java.lang.String) r0)
            goto L_0x0034
        L_0x005a:
            r3 = 6
            if (r0 != r3) goto L_0x0063
            java.lang.String r0 = "false"
            r1.writeUtf8((java.lang.String) r0)
            goto L_0x0034
        L_0x0063:
            r3 = 7
            if (r0 != r3) goto L_0x006c
            java.lang.String r0 = "null"
            r1.writeUtf8((java.lang.String) r0)
            goto L_0x0034
        L_0x006c:
            r3 = 11
            if (r0 != r3) goto L_0x008b
            java.lang.String r0 = r9.nextString()
            com.squareup.moshi.JsonWriter r3 = com.squareup.moshi.JsonWriter.of(r1)
            r3.value((java.lang.String) r0)     // Catch:{ all -> 0x007f }
            r3.close()
            goto L_0x0034
        L_0x007f:
            r0 = move-exception
            if (r3 == 0) goto L_0x008a
            r3.close()     // Catch:{ all -> 0x0086 }
            goto L_0x008a
        L_0x0086:
            r1 = move-exception
            r0.addSuppressed(r1)
        L_0x008a:
            throw r0
        L_0x008b:
            com.squareup.moshi.JsonDataException r0 = new com.squareup.moshi.JsonDataException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Expected a value but was "
            r1.append(r2)
            com.squareup.moshi.JsonReader$Token r2 = r9.peek()
            r1.append(r2)
            java.lang.String r2 = " at path "
            r1.append(r2)
            java.lang.String r2 = r9.getPath()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>((java.lang.String) r1)
            throw r0
        L_0x00b2:
            java.lang.String r0 = r9.nextString()
            r1.writeUtf8((java.lang.String) r0)
            goto L_0x0034
        L_0x00bb:
            int r3 = r9.peeked
            if (r3 == 0) goto L_0x00cb
            int[] r3 = r9.f53258e
            int r7 = r9.f53255b
            int r7 = r7 - r6
            r8 = r3[r7]
            int r8 = r8 + r6
            r3[r7] = r8
            r9.peeked = r5
        L_0x00cb:
            com.squareup.moshi.JsonValueSource r3 = new com.squareup.moshi.JsonValueSource
            okio.BufferedSource r5 = r9.source
            r3.<init>(r5, r1, r2, r0)
            r9.valueSource = r3
            r9.a(r4)
            com.squareup.moshi.JsonValueSource r0 = r9.valueSource
            okio.BufferedSource r0 = okio.Okio.buffer((okio.Source) r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.moshi.JsonUtf8Reader.nextSource():okio.BufferedSource");
    }

    public String nextString() throws IOException {
        String str;
        int i11 = this.peeked;
        if (i11 == 0) {
            i11 = doPeek();
        }
        if (i11 == 10) {
            str = nextUnquotedValue();
        } else if (i11 == 9) {
            str = nextQuotedValue(DOUBLE_QUOTE_OR_SLASH);
        } else if (i11 == 8) {
            str = nextQuotedValue(SINGLE_QUOTE_OR_SLASH);
        } else if (i11 == 11) {
            str = this.peekedString;
            this.peekedString = null;
        } else if (i11 == 16) {
            str = Long.toString(this.peekedLong);
        } else if (i11 == 17) {
            str = this.buffer.readUtf8((long) this.peekedNumberLength);
        } else {
            throw new JsonDataException("Expected a string but was " + peek() + " at path " + getPath());
        }
        this.peeked = 0;
        int[] iArr = this.f53258e;
        int i12 = this.f53255b - 1;
        iArr[i12] = iArr[i12] + 1;
        return str;
    }

    public JsonReader.Token peek() throws IOException {
        int i11 = this.peeked;
        if (i11 == 0) {
            i11 = doPeek();
        }
        switch (i11) {
            case 1:
                return JsonReader.Token.BEGIN_OBJECT;
            case 2:
                return JsonReader.Token.END_OBJECT;
            case 3:
                return JsonReader.Token.BEGIN_ARRAY;
            case 4:
                return JsonReader.Token.END_ARRAY;
            case 5:
            case 6:
                return JsonReader.Token.BOOLEAN;
            case 7:
                return JsonReader.Token.NULL;
            case 8:
            case 9:
            case 10:
            case 11:
                return JsonReader.Token.STRING;
            case 12:
            case 13:
            case 14:
            case 15:
                return JsonReader.Token.NAME;
            case 16:
            case 17:
                return JsonReader.Token.NUMBER;
            case 18:
                return JsonReader.Token.END_DOCUMENT;
            default:
                throw new AssertionError();
        }
    }

    public JsonReader peekJson() {
        return new JsonUtf8Reader(this);
    }

    public void promoteNameToValue() throws IOException {
        if (hasNext()) {
            this.peekedString = nextName();
            this.peeked = 11;
        }
    }

    public int selectName(JsonReader.Options options) throws IOException {
        int i11 = this.peeked;
        if (i11 == 0) {
            i11 = doPeek();
        }
        if (i11 < 12 || i11 > 15) {
            return -1;
        }
        if (i11 == 15) {
            return findName(this.peekedString, options);
        }
        int select = this.source.select(options.f53263b);
        if (select != -1) {
            this.peeked = 0;
            this.f53257d[this.f53255b - 1] = options.f53262a[select];
            return select;
        }
        String str = this.f53257d[this.f53255b - 1];
        String nextName = nextName();
        int findName = findName(nextName, options);
        if (findName == -1) {
            this.peeked = 15;
            this.peekedString = nextName;
            this.f53257d[this.f53255b - 1] = str;
        }
        return findName;
    }

    public int selectString(JsonReader.Options options) throws IOException {
        int i11 = this.peeked;
        if (i11 == 0) {
            i11 = doPeek();
        }
        if (i11 < 8 || i11 > 11) {
            return -1;
        }
        if (i11 == 11) {
            return findString(this.peekedString, options);
        }
        int select = this.source.select(options.f53263b);
        if (select != -1) {
            this.peeked = 0;
            int[] iArr = this.f53258e;
            int i12 = this.f53255b - 1;
            iArr[i12] = iArr[i12] + 1;
            return select;
        }
        String nextString = nextString();
        int findString = findString(nextString, options);
        if (findString == -1) {
            this.peeked = 11;
            this.peekedString = nextString;
            int[] iArr2 = this.f53258e;
            int i13 = this.f53255b - 1;
            iArr2[i13] = iArr2[i13] - 1;
        }
        return findString;
    }

    public void skipName() throws IOException {
        if (!this.f53260g) {
            int i11 = this.peeked;
            if (i11 == 0) {
                i11 = doPeek();
            }
            if (i11 == 14) {
                skipUnquotedValue();
            } else if (i11 == 13) {
                skipQuotedValue(DOUBLE_QUOTE_OR_SLASH);
            } else if (i11 == 12) {
                skipQuotedValue(SINGLE_QUOTE_OR_SLASH);
            } else if (i11 != 15) {
                throw new JsonDataException("Expected a name but was " + peek() + " at path " + getPath());
            }
            this.peeked = 0;
            this.f53257d[this.f53255b - 1] = "null";
            return;
        }
        JsonReader.Token peek = peek();
        nextName();
        throw new JsonDataException("Cannot skip unexpected " + peek + " at " + getPath());
    }

    public void skipValue() throws IOException {
        if (!this.f53260g) {
            int i11 = 0;
            do {
                int i12 = this.peeked;
                if (i12 == 0) {
                    i12 = doPeek();
                }
                if (i12 == 3) {
                    a(1);
                } else if (i12 == 1) {
                    a(3);
                } else {
                    if (i12 == 4) {
                        i11--;
                        if (i11 >= 0) {
                            this.f53255b--;
                        } else {
                            throw new JsonDataException("Expected a value but was " + peek() + " at path " + getPath());
                        }
                    } else if (i12 == 2) {
                        i11--;
                        if (i11 >= 0) {
                            this.f53255b--;
                        } else {
                            throw new JsonDataException("Expected a value but was " + peek() + " at path " + getPath());
                        }
                    } else if (i12 == 14 || i12 == 10) {
                        skipUnquotedValue();
                    } else if (i12 == 9 || i12 == 13) {
                        skipQuotedValue(DOUBLE_QUOTE_OR_SLASH);
                    } else if (i12 == 8 || i12 == 12) {
                        skipQuotedValue(SINGLE_QUOTE_OR_SLASH);
                    } else if (i12 == 17) {
                        this.buffer.skip((long) this.peekedNumberLength);
                    } else if (i12 == 18) {
                        throw new JsonDataException("Expected a value but was " + peek() + " at path " + getPath());
                    }
                    this.peeked = 0;
                }
                i11++;
                this.peeked = 0;
            } while (i11 != 0);
            int[] iArr = this.f53258e;
            int i13 = this.f53255b;
            int i14 = i13 - 1;
            iArr[i14] = iArr[i14] + 1;
            this.f53257d[i13 - 1] = "null";
            return;
        }
        throw new JsonDataException("Cannot skip unexpected " + peek() + " at " + getPath());
    }

    public String toString() {
        return "JsonReader(" + this.source + ")";
    }

    public JsonUtf8Reader(JsonUtf8Reader jsonUtf8Reader) {
        super(jsonUtf8Reader);
        BufferedSource peek = jsonUtf8Reader.source.peek();
        this.source = peek;
        this.buffer = peek.getBuffer();
        this.peeked = jsonUtf8Reader.peeked;
        this.peekedLong = jsonUtf8Reader.peekedLong;
        this.peekedNumberLength = jsonUtf8Reader.peekedNumberLength;
        this.peekedString = jsonUtf8Reader.peekedString;
        try {
            peek.require(jsonUtf8Reader.buffer.size());
        } catch (IOException unused) {
            throw new AssertionError();
        }
    }
}
