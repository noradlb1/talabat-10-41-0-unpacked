package org.apache.commons.compress.compressors.lzw;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteOrder;
import org.apache.commons.compress.MemoryLimitException;
import org.apache.commons.compress.compressors.CompressorInputStream;
import org.apache.commons.compress.utils.BitInputStream;
import org.apache.commons.compress.utils.InputStreamStatistics;

public abstract class LZWInputStream extends CompressorInputStream implements InputStreamStatistics {
    protected static final int DEFAULT_CODE_SIZE = 9;
    protected static final int UNUSED_PREFIX = -1;
    private byte[] characters;
    private int clearCode = -1;
    private int codeSize = 9;

    /* renamed from: in  reason: collision with root package name */
    protected final BitInputStream f27718in;
    private final byte[] oneByte = new byte[1];
    private byte[] outputStack;
    private int outputStackLocation;
    private int[] prefixes;
    private int previousCode = -1;
    private byte previousCodeFirstChar;
    private int tableSize;

    public LZWInputStream(InputStream inputStream, ByteOrder byteOrder) {
        this.f27718in = new BitInputStream(inputStream, byteOrder);
    }

    private int readFromStack(byte[] bArr, int i11, int i12) {
        int length = this.outputStack.length - this.outputStackLocation;
        if (length <= 0) {
            return 0;
        }
        int min = Math.min(length, i12);
        System.arraycopy(this.outputStack, this.outputStackLocation, bArr, i11, min);
        this.outputStackLocation += min;
        return min;
    }

    public abstract int addEntry(int i11, byte b11) throws IOException;

    public int addEntry(int i11, byte b11, int i12) {
        int i13 = this.tableSize;
        if (i13 >= i12) {
            return -1;
        }
        this.prefixes[i13] = i11;
        this.characters[i13] = b11;
        this.tableSize = i13 + 1;
        return i13;
    }

    public int addRepeatOfPreviousCode() throws IOException {
        int i11 = this.previousCode;
        if (i11 != -1) {
            return addEntry(i11, this.previousCodeFirstChar);
        }
        throw new IOException("The first code can't be a reference to its preceding code");
    }

    public void close() throws IOException {
        this.f27718in.close();
    }

    public abstract int decompressNextSymbol() throws IOException;

    public int expandCodeToOutputStack(int i11, boolean z11) throws IOException {
        int i12 = i11;
        while (i12 >= 0) {
            byte[] bArr = this.outputStack;
            int i13 = this.outputStackLocation - 1;
            this.outputStackLocation = i13;
            bArr[i13] = this.characters[i12];
            i12 = this.prefixes[i12];
        }
        int i14 = this.previousCode;
        if (i14 != -1 && !z11) {
            addEntry(i14, this.outputStack[this.outputStackLocation]);
        }
        this.previousCode = i11;
        byte[] bArr2 = this.outputStack;
        int i15 = this.outputStackLocation;
        this.previousCodeFirstChar = bArr2[i15];
        return i15;
    }

    public int getClearCode() {
        return this.clearCode;
    }

    public int getCodeSize() {
        return this.codeSize;
    }

    public long getCompressedCount() {
        return this.f27718in.getBytesRead();
    }

    public int getPrefix(int i11) {
        return this.prefixes[i11];
    }

    public int getPrefixesLength() {
        return this.prefixes.length;
    }

    public int getTableSize() {
        return this.tableSize;
    }

    public void incrementCodeSize() {
        this.codeSize++;
    }

    public void initializeTables(int i11, int i12) throws MemoryLimitException {
        if (i11 > 0) {
            if (i12 > -1) {
                long j11 = (((long) (1 << i11)) * 6) >> 10;
                if (j11 > ((long) i12)) {
                    throw new MemoryLimitException(j11, i12);
                }
            }
            initializeTables(i11);
            return;
        }
        throw new IllegalArgumentException("maxCodeSize is " + i11 + ", must be bigger than 0");
    }

    public int read() throws IOException {
        int read = read(this.oneByte);
        if (read < 0) {
            return read;
        }
        return this.oneByte[0] & 255;
    }

    public int readNextCode() throws IOException {
        int i11 = this.codeSize;
        if (i11 <= 31) {
            return (int) this.f27718in.readBits(i11);
        }
        throw new IllegalArgumentException("Code size must not be bigger than 31");
    }

    public void resetCodeSize() {
        setCodeSize(9);
    }

    public void resetPreviousCode() {
        this.previousCode = -1;
    }

    public void setClearCode(int i11) {
        this.clearCode = 1 << (i11 - 1);
    }

    public void setCodeSize(int i11) {
        this.codeSize = i11;
    }

    public void setPrefix(int i11, int i12) {
        this.prefixes[i11] = i12;
    }

    public void setTableSize(int i11) {
        this.tableSize = i11;
    }

    public int read(byte[] bArr, int i11, int i12) throws IOException {
        if (i12 == 0) {
            return 0;
        }
        int readFromStack = readFromStack(bArr, i11, i12);
        while (true) {
            int i13 = i12 - readFromStack;
            if (i13 > 0) {
                int decompressNextSymbol = decompressNextSymbol();
                if (decompressNextSymbol >= 0) {
                    readFromStack += readFromStack(bArr, i11 + readFromStack, i13);
                } else if (readFromStack <= 0) {
                    return decompressNextSymbol;
                } else {
                    count(readFromStack);
                    return readFromStack;
                }
            } else {
                count(readFromStack);
                return readFromStack;
            }
        }
    }

    public void initializeTables(int i11) {
        if (i11 > 0) {
            int i12 = 1 << i11;
            this.prefixes = new int[i12];
            this.characters = new byte[i12];
            this.outputStack = new byte[i12];
            this.outputStackLocation = i12;
            for (int i13 = 0; i13 < 256; i13++) {
                this.prefixes[i13] = -1;
                this.characters[i13] = (byte) i13;
            }
            return;
        }
        throw new IllegalArgumentException("maxCodeSize is " + i11 + ", must be bigger than 0");
    }
}
