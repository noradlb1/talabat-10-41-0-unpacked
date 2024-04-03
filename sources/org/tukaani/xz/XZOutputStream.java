package org.tukaani.xz;

import java.io.IOException;
import java.io.OutputStream;
import org.tukaani.xz.check.Check;
import org.tukaani.xz.common.EncoderUtil;
import org.tukaani.xz.common.StreamFlags;
import org.tukaani.xz.index.IndexEncoder;

public class XZOutputStream extends FinishableOutputStream {
    private final ArrayCache arrayCache;
    private BlockOutputStream blockEncoder;
    private final Check check;
    private IOException exception;
    private FilterEncoder[] filters;
    private boolean filtersSupportFlushing;
    private boolean finished;
    private final IndexEncoder index;
    private OutputStream out;
    private final StreamFlags streamFlags;
    private final byte[] tempBuf;

    public XZOutputStream(OutputStream outputStream, FilterOptions filterOptions) throws IOException {
        this(outputStream, filterOptions, 4);
    }

    public XZOutputStream(OutputStream outputStream, FilterOptions filterOptions, int i11) throws IOException {
        this(outputStream, new FilterOptions[]{filterOptions}, i11);
    }

    public XZOutputStream(OutputStream outputStream, FilterOptions filterOptions, int i11, ArrayCache arrayCache2) throws IOException {
        this(outputStream, new FilterOptions[]{filterOptions}, i11, arrayCache2);
    }

    public XZOutputStream(OutputStream outputStream, FilterOptions filterOptions, ArrayCache arrayCache2) throws IOException {
        this(outputStream, filterOptions, 4, arrayCache2);
    }

    public XZOutputStream(OutputStream outputStream, FilterOptions[] filterOptionsArr) throws IOException {
        this(outputStream, filterOptionsArr, 4);
    }

    public XZOutputStream(OutputStream outputStream, FilterOptions[] filterOptionsArr, int i11) throws IOException {
        this(outputStream, filterOptionsArr, i11, ArrayCache.getDefaultCache());
    }

    public XZOutputStream(OutputStream outputStream, FilterOptions[] filterOptionsArr, int i11, ArrayCache arrayCache2) throws IOException {
        StreamFlags streamFlags2 = new StreamFlags();
        this.streamFlags = streamFlags2;
        this.index = new IndexEncoder();
        this.blockEncoder = null;
        this.exception = null;
        this.finished = false;
        this.tempBuf = new byte[1];
        this.arrayCache = arrayCache2;
        this.out = outputStream;
        updateFilters(filterOptionsArr);
        streamFlags2.checkType = i11;
        this.check = Check.getInstance(i11);
        encodeStreamHeader();
    }

    public XZOutputStream(OutputStream outputStream, FilterOptions[] filterOptionsArr, ArrayCache arrayCache2) throws IOException {
        this(outputStream, filterOptionsArr, 4, arrayCache2);
    }

    private void encodeStreamFlags(byte[] bArr, int i11) {
        bArr[i11] = 0;
        bArr[i11 + 1] = (byte) this.streamFlags.checkType;
    }

    private void encodeStreamFooter() throws IOException {
        byte[] bArr = new byte[6];
        long indexSize = (this.index.getIndexSize() / 4) - 1;
        for (int i11 = 0; i11 < 4; i11++) {
            bArr[i11] = (byte) ((int) (indexSize >>> (i11 * 8)));
        }
        encodeStreamFlags(bArr, 4);
        EncoderUtil.writeCRC32(this.out, bArr);
        this.out.write(bArr);
        this.out.write(XZ.FOOTER_MAGIC);
    }

    private void encodeStreamHeader() throws IOException {
        this.out.write(XZ.HEADER_MAGIC);
        byte[] bArr = new byte[2];
        encodeStreamFlags(bArr, 0);
        this.out.write(bArr);
        EncoderUtil.writeCRC32(this.out, bArr);
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:4:0x0007 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void close() throws java.io.IOException {
        /*
            r2 = this;
            java.io.OutputStream r0 = r2.out
            if (r0 == 0) goto L_0x0017
            r2.finish()     // Catch:{ IOException -> 0x0007 }
        L_0x0007:
            java.io.OutputStream r0 = r2.out     // Catch:{ IOException -> 0x000d }
            r0.close()     // Catch:{ IOException -> 0x000d }
            goto L_0x0014
        L_0x000d:
            r0 = move-exception
            java.io.IOException r1 = r2.exception
            if (r1 != 0) goto L_0x0014
            r2.exception = r0
        L_0x0014:
            r0 = 0
            r2.out = r0
        L_0x0017:
            java.io.IOException r0 = r2.exception
            if (r0 != 0) goto L_0x001c
            return
        L_0x001c:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.tukaani.xz.XZOutputStream.close():void");
    }

    public void endBlock() throws IOException {
        IOException iOException = this.exception;
        if (iOException != null) {
            throw iOException;
        } else if (!this.finished) {
            BlockOutputStream blockOutputStream = this.blockEncoder;
            if (blockOutputStream != null) {
                try {
                    blockOutputStream.finish();
                    this.index.add(this.blockEncoder.getUnpaddedSize(), this.blockEncoder.getUncompressedSize());
                    this.blockEncoder = null;
                } catch (IOException e11) {
                    this.exception = e11;
                    throw e11;
                }
            }
        } else {
            throw new XZIOException("Stream finished or closed");
        }
    }

    public void finish() throws IOException {
        if (!this.finished) {
            endBlock();
            try {
                this.index.encode(this.out);
                encodeStreamFooter();
                this.finished = true;
            } catch (IOException e11) {
                this.exception = e11;
                throw e11;
            }
        }
    }

    public void flush() throws IOException {
        OutputStream outputStream;
        IOException iOException = this.exception;
        if (iOException != null) {
            throw iOException;
        } else if (!this.finished) {
            try {
                BlockOutputStream blockOutputStream = this.blockEncoder;
                if (blockOutputStream == null) {
                    outputStream = this.out;
                } else if (this.filtersSupportFlushing) {
                    blockOutputStream.flush();
                    return;
                } else {
                    endBlock();
                    outputStream = this.out;
                }
                outputStream.flush();
            } catch (IOException e11) {
                this.exception = e11;
                throw e11;
            }
        } else {
            throw new XZIOException("Stream finished or closed");
        }
    }

    public void updateFilters(FilterOptions filterOptions) throws XZIOException {
        updateFilters(new FilterOptions[]{filterOptions});
    }

    public void updateFilters(FilterOptions[] filterOptionsArr) throws XZIOException {
        if (this.blockEncoder != null) {
            throw new UnsupportedOptionsException("Changing filter options in the middle of a XZ Block not implemented");
        } else if (filterOptionsArr.length < 1 || filterOptionsArr.length > 4) {
            throw new UnsupportedOptionsException("XZ filter chain must be 1-4 filters");
        } else {
            this.filtersSupportFlushing = true;
            FilterEncoder[] filterEncoderArr = new FilterEncoder[filterOptionsArr.length];
            for (int i11 = 0; i11 < filterOptionsArr.length; i11++) {
                FilterEncoder a11 = filterOptionsArr[i11].a();
                filterEncoderArr[i11] = a11;
                this.filtersSupportFlushing = a11.supportsFlushing() & this.filtersSupportFlushing;
            }
            RawCoder.a(filterEncoderArr);
            this.filters = filterEncoderArr;
        }
    }

    public void write(int i11) throws IOException {
        byte[] bArr = this.tempBuf;
        bArr[0] = (byte) i11;
        write(bArr, 0, 1);
    }

    public void write(byte[] bArr, int i11, int i12) throws IOException {
        int i13;
        if (i11 < 0 || i12 < 0 || (i13 = i11 + i12) < 0 || i13 > bArr.length) {
            throw new IndexOutOfBoundsException();
        }
        IOException iOException = this.exception;
        if (iOException != null) {
            throw iOException;
        } else if (!this.finished) {
            try {
                if (this.blockEncoder == null) {
                    this.blockEncoder = new BlockOutputStream(this.out, this.filters, this.check, this.arrayCache);
                }
                this.blockEncoder.write(bArr, i11, i12);
            } catch (IOException e11) {
                this.exception = e11;
                throw e11;
            }
        } else {
            throw new XZIOException("Stream finished or closed");
        }
    }
}
