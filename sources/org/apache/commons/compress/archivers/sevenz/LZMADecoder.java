package org.apache.commons.compress.archivers.sevenz;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.commons.compress.MemoryLimitException;
import org.apache.commons.compress.utils.ByteUtils;
import org.apache.commons.compress.utils.FlushShieldFilterOutputStream;
import org.tukaani.xz.LZMA2Options;
import org.tukaani.xz.LZMAInputStream;
import org.tukaani.xz.LZMAOutputStream;

class LZMADecoder extends CoderBase {
    public LZMADecoder() {
        super(LZMA2Options.class, Number.class);
    }

    private int getDictionarySize(Coder coder) throws IllegalArgumentException {
        return (int) ByteUtils.fromLittleEndian(coder.f27611d, 1, 4);
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
        byte[] bArr2 = coder.f27611d;
        if (bArr2 == null) {
            throw new IOException("Missing LZMA properties");
        } else if (bArr2.length >= 1) {
            byte b11 = bArr2[0];
            int dictionarySize = getDictionarySize(coder);
            if (dictionarySize <= 2147483632) {
                int memoryUsage = LZMAInputStream.getMemoryUsage(dictionarySize, b11);
                if (memoryUsage <= i11) {
                    return new LZMAInputStream(inputStream, j11, b11, dictionarySize);
                }
                throw new MemoryLimitException((long) memoryUsage, i11);
            }
            throw new IOException("Dictionary larger than 4GiB maximum size used in " + str);
        } else {
            throw new IOException("LZMA properties too short");
        }
    }

    public OutputStream c(OutputStream outputStream, Object obj) throws IOException {
        return new FlushShieldFilterOutputStream(new LZMAOutputStream(outputStream, getOptions(obj), false));
    }

    public byte[] d(Object obj) throws IOException {
        LZMA2Options options = getOptions(obj);
        int dictSize = options.getDictSize();
        byte[] bArr = new byte[5];
        bArr[0] = (byte) ((((options.getPb() * 5) + options.getLp()) * 9) + options.getLc());
        ByteUtils.toLittleEndian(bArr, (long) dictSize, 1, 4);
        return bArr;
    }

    public Object e(Coder coder, InputStream inputStream) throws IOException {
        byte[] bArr = coder.f27611d;
        if (bArr == null) {
            throw new IOException("Missing LZMA properties");
        } else if (bArr.length >= 1) {
            byte b11 = bArr[0] & 255;
            int i11 = b11 / 45;
            int i12 = b11 - ((i11 * 9) * 5);
            int i13 = i12 / 9;
            LZMA2Options lZMA2Options = new LZMA2Options();
            lZMA2Options.setPb(i11);
            lZMA2Options.setLcLp(i12 - (i13 * 9), i13);
            lZMA2Options.setDictSize(getDictionarySize(coder));
            return lZMA2Options;
        } else {
            throw new IOException("LZMA properties too short");
        }
    }
}
