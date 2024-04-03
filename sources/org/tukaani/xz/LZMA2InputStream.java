package org.tukaani.xz;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.tukaani.xz.lz.LZDecoder;
import org.tukaani.xz.lzma.LZMADecoder;
import org.tukaani.xz.rangecoder.RangeDecoderFromBuffer;

public class LZMA2InputStream extends InputStream {
    private static final int COMPRESSED_SIZE_MAX = 65536;
    public static final int DICT_SIZE_MAX = 2147483632;
    public static final int DICT_SIZE_MIN = 4096;
    private final ArrayCache arrayCache;
    private boolean endReached;
    private IOException exception;

    /* renamed from: in  reason: collision with root package name */
    private DataInputStream f63400in;
    private boolean isLZMAChunk;

    /* renamed from: lz  reason: collision with root package name */
    private LZDecoder f63401lz;
    private LZMADecoder lzma;
    private boolean needDictReset;
    private boolean needProps;

    /* renamed from: rc  reason: collision with root package name */
    private RangeDecoderFromBuffer f63402rc;
    private final byte[] tempBuf;
    private int uncompressedSize;

    public LZMA2InputStream(InputStream inputStream, int i11) {
        this(inputStream, i11, (byte[]) null);
    }

    public LZMA2InputStream(InputStream inputStream, int i11, byte[] bArr) {
        this(inputStream, i11, bArr, ArrayCache.getDefaultCache());
    }

    public LZMA2InputStream(InputStream inputStream, int i11, byte[] bArr, ArrayCache arrayCache2) {
        this.uncompressedSize = 0;
        this.isLZMAChunk = false;
        this.needDictReset = true;
        this.needProps = true;
        this.endReached = false;
        this.exception = null;
        this.tempBuf = new byte[1];
        inputStream.getClass();
        this.arrayCache = arrayCache2;
        this.f63400in = new DataInputStream(inputStream);
        this.f63402rc = new RangeDecoderFromBuffer(65536, arrayCache2);
        this.f63401lz = new LZDecoder(getDictSize(i11), bArr, arrayCache2);
        if (bArr != null && bArr.length > 0) {
            this.needDictReset = false;
        }
    }

    private void decodeChunkHeader() throws IOException {
        int readUnsignedByte = this.f63400in.readUnsignedByte();
        if (readUnsignedByte == 0) {
            this.endReached = true;
            putArraysToCache();
            return;
        }
        if (readUnsignedByte >= 224 || readUnsignedByte == 1) {
            this.needProps = true;
            this.needDictReset = false;
            this.f63401lz.reset();
        } else if (this.needDictReset) {
            throw new CorruptedInputException();
        }
        if (readUnsignedByte >= 128) {
            this.isLZMAChunk = true;
            int i11 = (readUnsignedByte & 31) << 16;
            this.uncompressedSize = i11;
            this.uncompressedSize = i11 + this.f63400in.readUnsignedShort() + 1;
            int readUnsignedShort = this.f63400in.readUnsignedShort() + 1;
            if (readUnsignedByte >= 192) {
                this.needProps = false;
                decodeProps();
            } else if (this.needProps) {
                throw new CorruptedInputException();
            } else if (readUnsignedByte >= 160) {
                this.lzma.reset();
            }
            this.f63402rc.prepareInputBuffer(this.f63400in, readUnsignedShort);
        } else if (readUnsignedByte <= 2) {
            this.isLZMAChunk = false;
            this.uncompressedSize = this.f63400in.readUnsignedShort() + 1;
        } else {
            throw new CorruptedInputException();
        }
    }

    private void decodeProps() throws IOException {
        int readUnsignedByte = this.f63400in.readUnsignedByte();
        if (readUnsignedByte <= 224) {
            int i11 = readUnsignedByte / 45;
            int i12 = readUnsignedByte - ((i11 * 9) * 5);
            int i13 = i12 / 9;
            int i14 = i12 - (i13 * 9);
            if (i14 + i13 <= 4) {
                this.lzma = new LZMADecoder(this.f63401lz, this.f63402rc, i14, i13, i11);
                return;
            }
            throw new CorruptedInputException();
        }
        throw new CorruptedInputException();
    }

    private static int getDictSize(int i11) {
        if (i11 >= 4096 && i11 <= 2147483632) {
            return (i11 + 15) & -16;
        }
        throw new IllegalArgumentException("Unsupported dictionary size " + i11);
    }

    public static int getMemoryUsage(int i11) {
        return (getDictSize(i11) / 1024) + 104;
    }

    private void putArraysToCache() {
        LZDecoder lZDecoder = this.f63401lz;
        if (lZDecoder != null) {
            lZDecoder.putArraysToCache(this.arrayCache);
            this.f63401lz = null;
            this.f63402rc.putArraysToCache(this.arrayCache);
            this.f63402rc = null;
        }
    }

    public int available() throws IOException {
        DataInputStream dataInputStream = this.f63400in;
        if (dataInputStream != null) {
            IOException iOException = this.exception;
            if (iOException == null) {
                return this.isLZMAChunk ? this.uncompressedSize : Math.min(this.uncompressedSize, dataInputStream.available());
            }
            throw iOException;
        }
        throw new XZIOException("Stream closed");
    }

    public void close() throws IOException {
        if (this.f63400in != null) {
            putArraysToCache();
            try {
                this.f63400in.close();
            } finally {
                this.f63400in = null;
            }
        }
    }

    public int read() throws IOException {
        if (read(this.tempBuf, 0, 1) == -1) {
            return -1;
        }
        return this.tempBuf[0] & 255;
    }

    public int read(byte[] bArr, int i11, int i12) throws IOException {
        int i13;
        if (i11 < 0 || i12 < 0 || (i13 = i11 + i12) < 0 || i13 > bArr.length) {
            throw new IndexOutOfBoundsException();
        }
        int i14 = 0;
        if (i12 == 0) {
            return 0;
        }
        if (this.f63400in != null) {
            IOException iOException = this.exception;
            if (iOException != null) {
                throw iOException;
            } else if (this.endReached) {
                return -1;
            } else {
                while (i12 > 0) {
                    try {
                        if (this.uncompressedSize == 0) {
                            decodeChunkHeader();
                            if (this.endReached) {
                                if (i14 == 0) {
                                    return -1;
                                }
                                return i14;
                            }
                        }
                        int min = Math.min(this.uncompressedSize, i12);
                        if (!this.isLZMAChunk) {
                            this.f63401lz.copyUncompressed(this.f63400in, min);
                        } else {
                            this.f63401lz.setLimit(min);
                            this.lzma.decode();
                        }
                        int flush = this.f63401lz.flush(bArr, i11);
                        i11 += flush;
                        i12 -= flush;
                        i14 += flush;
                        int i15 = this.uncompressedSize - flush;
                        this.uncompressedSize = i15;
                        if (i15 == 0) {
                            if (!this.f63402rc.isFinished() || this.f63401lz.hasPending()) {
                                throw new CorruptedInputException();
                            }
                        }
                    } catch (IOException e11) {
                        this.exception = e11;
                        throw e11;
                    }
                }
                return i14;
            }
        } else {
            throw new XZIOException("Stream closed");
        }
    }
}
