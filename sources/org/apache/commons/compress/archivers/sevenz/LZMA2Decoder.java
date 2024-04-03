package org.apache.commons.compress.archivers.sevenz;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.commons.compress.MemoryLimitException;
import org.tukaani.xz.FinishableWrapperOutputStream;
import org.tukaani.xz.LZMA2InputStream;
import org.tukaani.xz.LZMA2Options;

class LZMA2Decoder extends CoderBase {
    public LZMA2Decoder() {
        super(LZMA2Options.class, Number.class);
    }

    private int getDictSize(Object obj) {
        if (obj instanceof LZMA2Options) {
            return ((LZMA2Options) obj).getDictSize();
        }
        return numberOptionOrDefault(obj);
    }

    private int getDictionarySize(Coder coder) throws IOException {
        byte[] bArr = coder.f27611d;
        if (bArr == null) {
            throw new IOException("Missing LZMA2 properties");
        } else if (bArr.length >= 1) {
            byte b11 = bArr[0] & 255;
            if ((b11 & -64) != 0) {
                throw new IOException("Unsupported LZMA2 property bits");
            } else if (b11 > 40) {
                throw new IOException("Dictionary larger than 4GiB maximum size");
            } else if (b11 == 40) {
                return -1;
            } else {
                return ((b11 & 1) | 2) << ((b11 / 2) + 11);
            }
        } else {
            throw new IOException("LZMA2 properties too short");
        }
    }

    private LZMA2Options getOptions(Object obj) throws IOException {
        if (obj instanceof LZMA2Options) {
            return (LZMA2Options) obj;
        }
        LZMA2Options lZMA2Options = new LZMA2Options();
        lZMA2Options.setDictSize(numberOptionOrDefault(obj));
        return lZMA2Options;
    }

    private int numberOptionOrDefault(Object obj) {
        return CoderBase.f(obj, 8388608);
    }

    public InputStream b(String str, InputStream inputStream, long j11, Coder coder, byte[] bArr, int i11) throws IOException {
        try {
            int dictionarySize = getDictionarySize(coder);
            int memoryUsage = LZMA2InputStream.getMemoryUsage(dictionarySize);
            if (memoryUsage <= i11) {
                return new LZMA2InputStream(inputStream, dictionarySize);
            }
            throw new MemoryLimitException((long) memoryUsage, i11);
        } catch (IllegalArgumentException e11) {
            throw new IOException(e11.getMessage());
        }
    }

    public OutputStream c(OutputStream outputStream, Object obj) throws IOException {
        return getOptions(obj).getOutputStream(new FinishableWrapperOutputStream(outputStream));
    }

    public byte[] d(Object obj) {
        int dictSize = getDictSize(obj);
        int numberOfLeadingZeros = Integer.numberOfLeadingZeros(dictSize);
        return new byte[]{(byte) (((19 - numberOfLeadingZeros) * 2) + ((dictSize >>> (30 - numberOfLeadingZeros)) - 2))};
    }

    public Object e(Coder coder, InputStream inputStream) throws IOException {
        return Integer.valueOf(getDictionarySize(coder));
    }
}
