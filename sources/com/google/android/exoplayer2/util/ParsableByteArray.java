package com.google.android.exoplayer2.util;

import androidx.annotation.Nullable;
import com.google.common.base.Ascii;
import com.google.common.base.Charsets;
import com.google.common.collect.ImmutableSet;
import com.google.common.primitives.Chars;
import com.google.common.primitives.UnsignedBytes;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Arrays;
import okio.Utf8;
import org.apache.commons.lang3.CharUtils;

public final class ParsableByteArray {
    private static final char[] CR_AND_LF = {CharUtils.CR, 10};
    private static final char[] LF = {10};
    private static final ImmutableSet<Charset> SUPPORTED_CHARSETS_FOR_READLINE = ImmutableSet.of(Charsets.US_ASCII, Charsets.UTF_8, Charsets.UTF_16, Charsets.UTF_16BE, Charsets.UTF_16LE);
    private byte[] data;
    private int limit;
    private int position;

    public ParsableByteArray() {
        this.data = Util.EMPTY_BYTE_ARRAY;
    }

    private int findNextLineTerminator(Charset charset) {
        int i11;
        if (charset.equals(Charsets.UTF_8) || charset.equals(Charsets.US_ASCII)) {
            i11 = 1;
        } else if (charset.equals(Charsets.UTF_16) || charset.equals(Charsets.UTF_16LE) || charset.equals(Charsets.UTF_16BE)) {
            i11 = 2;
        } else {
            throw new IllegalArgumentException("Unsupported charset: " + charset);
        }
        int i12 = this.position;
        while (true) {
            int i13 = this.limit;
            if (i12 >= i13 - (i11 - 1)) {
                return i13;
            }
            if ((charset.equals(Charsets.UTF_8) || charset.equals(Charsets.US_ASCII)) && Util.isLinebreak(this.data[i12])) {
                return i12;
            }
            if (charset.equals(Charsets.UTF_16) || charset.equals(Charsets.UTF_16BE)) {
                byte[] bArr = this.data;
                if (bArr[i12] == 0 && Util.isLinebreak(bArr[i12 + 1])) {
                    return i12;
                }
            }
            if (charset.equals(Charsets.UTF_16LE)) {
                byte[] bArr2 = this.data;
                if (bArr2[i12 + 1] == 0 && Util.isLinebreak(bArr2[i12])) {
                    return i12;
                }
            }
            i12 += i11;
        }
    }

    private int peekCharacterAndSize(Charset charset) {
        byte b11;
        char fromBytes;
        int i11 = 1;
        if ((charset.equals(Charsets.UTF_8) || charset.equals(Charsets.US_ASCII)) && bytesLeft() >= 1) {
            b11 = (byte) Chars.checkedCast((long) UnsignedBytes.toInt(this.data[this.position]));
        } else {
            if ((charset.equals(Charsets.UTF_16) || charset.equals(Charsets.UTF_16BE)) && bytesLeft() >= 2) {
                byte[] bArr = this.data;
                int i12 = this.position;
                fromBytes = Chars.fromBytes(bArr[i12], bArr[i12 + 1]);
            } else if (!charset.equals(Charsets.UTF_16LE) || bytesLeft() < 2) {
                return 0;
            } else {
                byte[] bArr2 = this.data;
                int i13 = this.position;
                fromBytes = Chars.fromBytes(bArr2[i13 + 1], bArr2[i13]);
            }
            b11 = (byte) fromBytes;
            i11 = 2;
        }
        return (Chars.checkedCast((long) b11) << 16) + i11;
    }

    private char readCharacterIfInList(Charset charset, char[] cArr) {
        int peekCharacterAndSize = peekCharacterAndSize(charset);
        if (peekCharacterAndSize == 0) {
            return 0;
        }
        char c11 = (char) (peekCharacterAndSize >> 16);
        if (!Chars.contains(cArr, c11)) {
            return 0;
        }
        this.position += peekCharacterAndSize & 65535;
        return c11;
    }

    private void skipLineTerminator(Charset charset) {
        if (readCharacterIfInList(charset, CR_AND_LF) == 13) {
            readCharacterIfInList(charset, LF);
        }
    }

    public int bytesLeft() {
        return this.limit - this.position;
    }

    public int capacity() {
        return this.data.length;
    }

    public void ensureCapacity(int i11) {
        if (i11 > capacity()) {
            this.data = Arrays.copyOf(this.data, i11);
        }
    }

    public byte[] getData() {
        return this.data;
    }

    public int getPosition() {
        return this.position;
    }

    public int limit() {
        return this.limit;
    }

    public char peekChar() {
        byte[] bArr = this.data;
        int i11 = this.position;
        return (char) ((bArr[i11 + 1] & 255) | ((bArr[i11] & 255) << 8));
    }

    public int peekUnsignedByte() {
        return this.data[this.position] & 255;
    }

    public void readBytes(ParsableBitArray parsableBitArray, int i11) {
        readBytes(parsableBitArray.data, 0, i11);
        parsableBitArray.setPosition(0);
    }

    @Nullable
    public String readDelimiterTerminatedString(char c11) {
        if (bytesLeft() == 0) {
            return null;
        }
        int i11 = this.position;
        while (i11 < this.limit && this.data[i11] != c11) {
            i11++;
        }
        byte[] bArr = this.data;
        int i12 = this.position;
        String fromUtf8Bytes = Util.fromUtf8Bytes(bArr, i12, i11 - i12);
        this.position = i11;
        if (i11 < this.limit) {
            this.position = i11 + 1;
        }
        return fromUtf8Bytes;
    }

    public double readDouble() {
        return Double.longBitsToDouble(readLong());
    }

    public float readFloat() {
        return Float.intBitsToFloat(readInt());
    }

    public int readInt() {
        byte[] bArr = this.data;
        int i11 = this.position;
        int i12 = i11 + 1;
        int i13 = i12 + 1;
        byte b11 = ((bArr[i11] & 255) << Ascii.CAN) | ((bArr[i12] & 255) << Ascii.DLE);
        int i14 = i13 + 1;
        byte b12 = b11 | ((bArr[i13] & 255) << 8);
        this.position = i14 + 1;
        return (bArr[i14] & 255) | b12;
    }

    public int readInt24() {
        byte[] bArr = this.data;
        int i11 = this.position;
        int i12 = i11 + 1;
        int i13 = i12 + 1;
        byte b11 = (((bArr[i11] & 255) << Ascii.CAN) >> 8) | ((bArr[i12] & 255) << 8);
        this.position = i13 + 1;
        return (bArr[i13] & 255) | b11;
    }

    @Nullable
    public String readLine() {
        return readLine(Charsets.UTF_8);
    }

    public int readLittleEndianInt() {
        byte[] bArr = this.data;
        int i11 = this.position;
        int i12 = i11 + 1;
        int i13 = i12 + 1;
        byte b11 = (bArr[i11] & 255) | ((bArr[i12] & 255) << 8);
        int i14 = i13 + 1;
        byte b12 = b11 | ((bArr[i13] & 255) << Ascii.DLE);
        this.position = i14 + 1;
        return ((bArr[i14] & 255) << Ascii.CAN) | b12;
    }

    public int readLittleEndianInt24() {
        byte[] bArr = this.data;
        int i11 = this.position;
        int i12 = i11 + 1;
        int i13 = i12 + 1;
        byte b11 = (bArr[i11] & 255) | ((bArr[i12] & 255) << 8);
        this.position = i13 + 1;
        return ((bArr[i13] & 255) << Ascii.DLE) | b11;
    }

    public long readLittleEndianLong() {
        byte[] bArr = this.data;
        int i11 = this.position;
        int i12 = i11 + 1;
        int i13 = i12 + 1;
        int i14 = i13 + 1;
        int i15 = i14 + 1;
        int i16 = i15 + 1;
        int i17 = i16 + 1;
        int i18 = i17 + 1;
        this.position = i18 + 1;
        return (((long) bArr[i11]) & 255) | ((((long) bArr[i12]) & 255) << 8) | ((((long) bArr[i13]) & 255) << 16) | ((((long) bArr[i14]) & 255) << 24) | ((((long) bArr[i15]) & 255) << 32) | ((((long) bArr[i16]) & 255) << 40) | ((((long) bArr[i17]) & 255) << 48) | ((((long) bArr[i18]) & 255) << 56);
    }

    public short readLittleEndianShort() {
        byte[] bArr = this.data;
        int i11 = this.position;
        int i12 = i11 + 1;
        this.position = i12 + 1;
        return (short) (((bArr[i12] & 255) << 8) | (bArr[i11] & 255));
    }

    public long readLittleEndianUnsignedInt() {
        byte[] bArr = this.data;
        int i11 = this.position;
        int i12 = i11 + 1;
        int i13 = i12 + 1;
        int i14 = i13 + 1;
        this.position = i14 + 1;
        return (((long) bArr[i11]) & 255) | ((((long) bArr[i12]) & 255) << 8) | ((((long) bArr[i13]) & 255) << 16) | ((((long) bArr[i14]) & 255) << 24);
    }

    public int readLittleEndianUnsignedInt24() {
        byte[] bArr = this.data;
        int i11 = this.position;
        int i12 = i11 + 1;
        int i13 = i12 + 1;
        byte b11 = (bArr[i11] & 255) | ((bArr[i12] & 255) << 8);
        this.position = i13 + 1;
        return ((bArr[i13] & 255) << Ascii.DLE) | b11;
    }

    public int readLittleEndianUnsignedIntToInt() {
        int readLittleEndianInt = readLittleEndianInt();
        if (readLittleEndianInt >= 0) {
            return readLittleEndianInt;
        }
        throw new IllegalStateException("Top bit not zero: " + readLittleEndianInt);
    }

    public int readLittleEndianUnsignedShort() {
        byte[] bArr = this.data;
        int i11 = this.position;
        int i12 = i11 + 1;
        this.position = i12 + 1;
        return ((bArr[i12] & 255) << 8) | (bArr[i11] & 255);
    }

    public long readLong() {
        byte[] bArr = this.data;
        int i11 = this.position;
        int i12 = i11 + 1;
        int i13 = i12 + 1;
        int i14 = i13 + 1;
        int i15 = i14 + 1;
        int i16 = i15 + 1;
        int i17 = i16 + 1;
        int i18 = i17 + 1;
        this.position = i18 + 1;
        return ((((long) bArr[i11]) & 255) << 56) | ((((long) bArr[i12]) & 255) << 48) | ((((long) bArr[i13]) & 255) << 40) | ((((long) bArr[i14]) & 255) << 32) | ((((long) bArr[i15]) & 255) << 24) | ((((long) bArr[i16]) & 255) << 16) | ((((long) bArr[i17]) & 255) << 8) | (((long) bArr[i18]) & 255);
    }

    public String readNullTerminatedString(int i11) {
        if (i11 == 0) {
            return "";
        }
        int i12 = this.position;
        int i13 = (i12 + i11) - 1;
        String fromUtf8Bytes = Util.fromUtf8Bytes(this.data, i12, (i13 >= this.limit || this.data[i13] != 0) ? i11 : i11 - 1);
        this.position += i11;
        return fromUtf8Bytes;
    }

    public short readShort() {
        byte[] bArr = this.data;
        int i11 = this.position;
        int i12 = i11 + 1;
        this.position = i12 + 1;
        return (short) ((bArr[i12] & 255) | ((bArr[i11] & 255) << 8));
    }

    public String readString(int i11) {
        return readString(i11, Charsets.UTF_8);
    }

    public int readSynchSafeInt() {
        return (readUnsignedByte() << 21) | (readUnsignedByte() << 14) | (readUnsignedByte() << 7) | readUnsignedByte();
    }

    public int readUnsignedByte() {
        byte[] bArr = this.data;
        int i11 = this.position;
        this.position = i11 + 1;
        return bArr[i11] & 255;
    }

    public int readUnsignedFixedPoint1616() {
        byte[] bArr = this.data;
        int i11 = this.position;
        int i12 = i11 + 1;
        byte b11 = (bArr[i12] & 255) | ((bArr[i11] & 255) << 8);
        this.position = i12 + 1 + 2;
        return b11;
    }

    public long readUnsignedInt() {
        byte[] bArr = this.data;
        int i11 = this.position;
        int i12 = i11 + 1;
        int i13 = i12 + 1;
        int i14 = i13 + 1;
        this.position = i14 + 1;
        return ((((long) bArr[i11]) & 255) << 24) | ((((long) bArr[i12]) & 255) << 16) | ((((long) bArr[i13]) & 255) << 8) | (((long) bArr[i14]) & 255);
    }

    public int readUnsignedInt24() {
        byte[] bArr = this.data;
        int i11 = this.position;
        int i12 = i11 + 1;
        int i13 = i12 + 1;
        byte b11 = ((bArr[i11] & 255) << Ascii.DLE) | ((bArr[i12] & 255) << 8);
        this.position = i13 + 1;
        return (bArr[i13] & 255) | b11;
    }

    public int readUnsignedIntToInt() {
        int readInt = readInt();
        if (readInt >= 0) {
            return readInt;
        }
        throw new IllegalStateException("Top bit not zero: " + readInt);
    }

    public long readUnsignedLongToLong() {
        long readLong = readLong();
        if (readLong >= 0) {
            return readLong;
        }
        throw new IllegalStateException("Top bit not zero: " + readLong);
    }

    public int readUnsignedShort() {
        byte[] bArr = this.data;
        int i11 = this.position;
        int i12 = i11 + 1;
        this.position = i12 + 1;
        return (bArr[i12] & 255) | ((bArr[i11] & 255) << 8);
    }

    public long readUtf8EncodedLong() {
        int i11;
        int i12;
        long j11 = (long) this.data[this.position];
        int i13 = 7;
        while (true) {
            i11 = 1;
            if (i13 < 0) {
                break;
            }
            int i14 = 1 << i13;
            if ((((long) i14) & j11) != 0) {
                i13--;
            } else if (i13 < 6) {
                j11 &= (long) (i14 - 1);
                i12 = 7 - i13;
            } else if (i13 == 7) {
                i12 = 1;
            }
        }
        i12 = 0;
        if (i12 != 0) {
            while (i11 < i12) {
                byte b11 = this.data[this.position + i11];
                if ((b11 & 192) == 128) {
                    j11 = (j11 << 6) | ((long) (b11 & Utf8.REPLACEMENT_BYTE));
                    i11++;
                } else {
                    throw new NumberFormatException("Invalid UTF-8 sequence continuation byte: " + j11);
                }
            }
            this.position += i12;
            return j11;
        }
        throw new NumberFormatException("Invalid UTF-8 sequence first byte: " + j11);
    }

    @Nullable
    public Charset readUtfCharsetFromBom() {
        if (bytesLeft() >= 3) {
            byte[] bArr = this.data;
            int i11 = this.position;
            if (bArr[i11] == -17 && bArr[i11 + 1] == -69 && bArr[i11 + 2] == -65) {
                this.position = i11 + 3;
                return Charsets.UTF_8;
            }
        }
        if (bytesLeft() < 2) {
            return null;
        }
        byte[] bArr2 = this.data;
        int i12 = this.position;
        byte b11 = bArr2[i12];
        if (b11 == -2 && bArr2[i12 + 1] == -1) {
            this.position = i12 + 2;
            return Charsets.UTF_16BE;
        } else if (b11 != -1 || bArr2[i12 + 1] != -2) {
            return null;
        } else {
            this.position = i12 + 2;
            return Charsets.UTF_16LE;
        }
    }

    public void reset(int i11) {
        reset(capacity() < i11 ? new byte[i11] : this.data, i11);
    }

    public void setLimit(int i11) {
        boolean z11;
        if (i11 < 0 || i11 > this.data.length) {
            z11 = false;
        } else {
            z11 = true;
        }
        Assertions.checkArgument(z11);
        this.limit = i11;
    }

    public void setPosition(int i11) {
        boolean z11;
        if (i11 < 0 || i11 > this.limit) {
            z11 = false;
        } else {
            z11 = true;
        }
        Assertions.checkArgument(z11);
        this.position = i11;
    }

    public void skipBytes(int i11) {
        setPosition(this.position + i11);
    }

    public char peekChar(Charset charset) {
        boolean contains = SUPPORTED_CHARSETS_FOR_READLINE.contains(charset);
        Assertions.checkArgument(contains, "Unsupported charset: " + charset);
        return (char) (peekCharacterAndSize(charset) >> 16);
    }

    @Nullable
    public String readLine(Charset charset) {
        boolean contains = SUPPORTED_CHARSETS_FOR_READLINE.contains(charset);
        Assertions.checkArgument(contains, "Unsupported charset: " + charset);
        if (bytesLeft() == 0) {
            return null;
        }
        if (!charset.equals(Charsets.US_ASCII)) {
            readUtfCharsetFromBom();
        }
        String readString = readString(findNextLineTerminator(charset) - this.position, charset);
        if (this.position == this.limit) {
            return readString;
        }
        skipLineTerminator(charset);
        return readString;
    }

    public String readString(int i11, Charset charset) {
        String str = new String(this.data, this.position, i11, charset);
        this.position += i11;
        return str;
    }

    public void reset(byte[] bArr) {
        reset(bArr, bArr.length);
    }

    public ParsableByteArray(int i11) {
        this.data = new byte[i11];
        this.limit = i11;
    }

    public void readBytes(byte[] bArr, int i11, int i12) {
        System.arraycopy(this.data, this.position, bArr, i11, i12);
        this.position += i12;
    }

    public void reset(byte[] bArr, int i11) {
        this.data = bArr;
        this.limit = i11;
        this.position = 0;
    }

    public void readBytes(ByteBuffer byteBuffer, int i11) {
        byteBuffer.put(this.data, this.position, i11);
        this.position += i11;
    }

    @Nullable
    public String readNullTerminatedString() {
        return readDelimiterTerminatedString(0);
    }

    public ParsableByteArray(byte[] bArr) {
        this.data = bArr;
        this.limit = bArr.length;
    }

    public ParsableByteArray(byte[] bArr, int i11) {
        this.data = bArr;
        this.limit = i11;
    }
}
