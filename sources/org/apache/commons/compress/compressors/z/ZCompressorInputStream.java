package org.apache.commons.compress.compressors.z;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteOrder;
import org.apache.commons.compress.compressors.lzw.LZWInputStream;

public class ZCompressorInputStream extends LZWInputStream {
    private static final int BLOCK_MODE_MASK = 128;
    private static final int MAGIC_1 = 31;
    private static final int MAGIC_2 = 157;
    private static final int MAX_CODE_SIZE_MASK = 31;
    private final boolean blockMode;
    private final int maxCodeSize;
    private long totalCodesRead;

    public ZCompressorInputStream(InputStream inputStream, int i11) throws IOException {
        super(inputStream, ByteOrder.LITTLE_ENDIAN);
        int readBits = (int) this.f27718in.readBits(8);
        int readBits2 = (int) this.f27718in.readBits(8);
        int readBits3 = (int) this.f27718in.readBits(8);
        if (readBits == 31 && readBits2 == 157 && readBits3 >= 0) {
            boolean z11 = (readBits3 & 128) != 0;
            this.blockMode = z11;
            int i12 = readBits3 & 31;
            this.maxCodeSize = i12;
            if (z11) {
                setClearCode(9);
            }
            initializeTables(i12, i11);
            clearEntries();
            return;
        }
        throw new IOException("Input is not in .Z format");
    }

    private void clearEntries() {
        setTableSize((this.blockMode ? 1 : 0) + true);
    }

    public static boolean matches(byte[] bArr, int i11) {
        return i11 > 3 && bArr[0] == 31 && bArr[1] == -99;
    }

    private void reAlignReading() throws IOException {
        long j11 = 8 - (this.totalCodesRead % 8);
        if (j11 == 8) {
            j11 = 0;
        }
        for (long j12 = 0; j12 < j11; j12++) {
            readNextCode();
        }
        this.f27718in.clearBitCache();
    }

    public int addEntry(int i11, byte b11) throws IOException {
        int codeSize = 1 << getCodeSize();
        int addEntry = addEntry(i11, b11, codeSize);
        if (getTableSize() == codeSize && getCodeSize() < this.maxCodeSize) {
            reAlignReading();
            incrementCodeSize();
        }
        return addEntry;
    }

    public int decompressNextSymbol() throws IOException {
        int readNextCode = readNextCode();
        if (readNextCode < 0) {
            return -1;
        }
        boolean z11 = false;
        if (!this.blockMode || readNextCode != getClearCode()) {
            if (readNextCode == getTableSize()) {
                addRepeatOfPreviousCode();
                z11 = true;
            } else if (readNextCode > getTableSize()) {
                throw new IOException(String.format("Invalid %d bit code 0x%x", new Object[]{Integer.valueOf(getCodeSize()), Integer.valueOf(readNextCode)}));
            }
            return expandCodeToOutputStack(readNextCode, z11);
        }
        clearEntries();
        reAlignReading();
        resetCodeSize();
        resetPreviousCode();
        return 0;
    }

    public int readNextCode() throws IOException {
        int readNextCode = super.readNextCode();
        if (readNextCode >= 0) {
            this.totalCodesRead++;
        }
        return readNextCode;
    }

    public ZCompressorInputStream(InputStream inputStream) throws IOException {
        this(inputStream, -1);
    }
}
