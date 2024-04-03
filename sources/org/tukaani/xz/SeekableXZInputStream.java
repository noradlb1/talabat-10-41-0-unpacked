package org.tukaani.xz;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import org.tukaani.xz.check.Check;
import org.tukaani.xz.common.DecoderUtil;
import org.tukaani.xz.common.StreamFlags;
import org.tukaani.xz.index.BlockInfo;
import org.tukaani.xz.index.IndexDecoder;

public class SeekableXZInputStream extends SeekableInputStream {
    private final ArrayCache arrayCache;
    private int blockCount;
    private BlockInputStream blockDecoder;
    private Check check;
    private int checkTypes;
    private final BlockInfo curBlockInfo;
    private long curPos;
    private boolean endReached;
    private IOException exception;

    /* renamed from: in  reason: collision with root package name */
    private SeekableInputStream f63415in;
    private int indexMemoryUsage;
    private long largestBlockSize;
    private final int memoryLimit;
    private final BlockInfo queriedBlockInfo;
    private boolean seekNeeded;
    private long seekPos;
    private final ArrayList<IndexDecoder> streams;
    private final byte[] tempBuf;
    private long uncompressedSize;
    private final boolean verifyCheck;

    public SeekableXZInputStream(SeekableInputStream seekableInputStream) throws IOException {
        this(seekableInputStream, -1);
    }

    public SeekableXZInputStream(SeekableInputStream seekableInputStream, int i11) throws IOException {
        this(seekableInputStream, i11, true);
    }

    public SeekableXZInputStream(SeekableInputStream seekableInputStream, int i11, ArrayCache arrayCache2) throws IOException {
        this(seekableInputStream, i11, true, arrayCache2);
    }

    public SeekableXZInputStream(SeekableInputStream seekableInputStream, int i11, boolean z11) throws IOException {
        this(seekableInputStream, i11, z11, ArrayCache.getDefaultCache());
    }

    public SeekableXZInputStream(SeekableInputStream seekableInputStream, int i11, boolean z11, ArrayCache arrayCache2) throws IOException {
        SeekableInputStream seekableInputStream2 = seekableInputStream;
        this.indexMemoryUsage = 0;
        this.streams = new ArrayList<>();
        this.checkTypes = 0;
        long j11 = 0;
        this.uncompressedSize = 0;
        this.largestBlockSize = 0;
        this.blockCount = 0;
        this.blockDecoder = null;
        this.curPos = 0;
        this.seekNeeded = false;
        this.endReached = false;
        this.exception = null;
        int i12 = 1;
        this.tempBuf = new byte[1];
        this.arrayCache = arrayCache2;
        this.verifyCheck = z11;
        this.f63415in = seekableInputStream2;
        DataInputStream dataInputStream = new DataInputStream(seekableInputStream2);
        seekableInputStream2.seek(0);
        byte[] bArr = XZ.HEADER_MAGIC;
        byte[] bArr2 = new byte[bArr.length];
        dataInputStream.readFully(bArr2);
        if (Arrays.equals(bArr2, bArr)) {
            long length = seekableInputStream.length();
            if ((3 & length) == 0) {
                byte[] bArr3 = new byte[12];
                int i13 = i11;
                while (true) {
                    long j12 = j11;
                    while (length > j11) {
                        if (length >= 12) {
                            long j13 = length - 12;
                            seekableInputStream2.seek(j13);
                            dataInputStream.readFully(bArr3);
                            if (bArr3[8] == 0 && bArr3[9] == 0 && bArr3[10] == 0 && bArr3[11] == 0) {
                                j12 += 4;
                                length -= 4;
                                j11 = 0;
                            } else {
                                StreamFlags decodeStreamFooter = DecoderUtil.decodeStreamFooter(bArr3);
                                if (decodeStreamFooter.backwardSize < j13) {
                                    this.check = Check.getInstance(decodeStreamFooter.checkType);
                                    this.checkTypes |= i12 << decodeStreamFooter.checkType;
                                    seekableInputStream2.seek(j13 - decodeStreamFooter.backwardSize);
                                    try {
                                        IndexDecoder indexDecoder = r2;
                                        StreamFlags streamFlags = decodeStreamFooter;
                                        IndexDecoder indexDecoder2 = new IndexDecoder(seekableInputStream, decodeStreamFooter, j12, i13);
                                        this.indexMemoryUsage += indexDecoder.getMemoryUsage();
                                        i13 = i13 >= 0 ? i13 - indexDecoder.getMemoryUsage() : i13;
                                        if (this.largestBlockSize < indexDecoder.getLargestBlockSize()) {
                                            this.largestBlockSize = indexDecoder.getLargestBlockSize();
                                        }
                                        long streamSize = indexDecoder.getStreamSize() - 12;
                                        if (j13 >= streamSize) {
                                            length = j13 - streamSize;
                                            seekableInputStream2.seek(length);
                                            dataInputStream.readFully(bArr3);
                                            if (DecoderUtil.areStreamFlagsEqual(DecoderUtil.decodeStreamHeader(bArr3), streamFlags)) {
                                                long uncompressedSize2 = this.uncompressedSize + indexDecoder.getUncompressedSize();
                                                this.uncompressedSize = uncompressedSize2;
                                                if (uncompressedSize2 >= 0) {
                                                    int recordCount = this.blockCount + indexDecoder.getRecordCount();
                                                    this.blockCount = recordCount;
                                                    if (recordCount >= 0) {
                                                        this.streams.add(indexDecoder);
                                                        j11 = 0;
                                                        i12 = 1;
                                                    } else {
                                                        throw new UnsupportedOptionsException("XZ file has over 2147483647 Blocks");
                                                    }
                                                } else {
                                                    throw new UnsupportedOptionsException("XZ file is too big");
                                                }
                                            } else {
                                                throw new CorruptedInputException("XZ Stream Footer does not match Stream Header");
                                            }
                                        } else {
                                            throw new CorruptedInputException("XZ Index indicates too big compressed size for the XZ Stream");
                                        }
                                    } catch (MemoryLimitException e11) {
                                        int memoryNeeded = e11.getMemoryNeeded();
                                        int i14 = this.indexMemoryUsage;
                                        throw new MemoryLimitException(memoryNeeded + i14, i13 + i14);
                                    }
                                } else {
                                    throw new CorruptedInputException("Backward Size in XZ Stream Footer is too big");
                                }
                            }
                        } else {
                            throw new CorruptedInputException();
                        }
                    }
                    this.memoryLimit = i13;
                    ArrayList<IndexDecoder> arrayList = this.streams;
                    IndexDecoder indexDecoder3 = arrayList.get(arrayList.size() - 1);
                    int size = this.streams.size() - 2;
                    while (size >= 0) {
                        IndexDecoder indexDecoder4 = this.streams.get(size);
                        indexDecoder4.setOffsets(indexDecoder3);
                        size--;
                        indexDecoder3 = indexDecoder4;
                    }
                    ArrayList<IndexDecoder> arrayList2 = this.streams;
                    IndexDecoder indexDecoder5 = arrayList2.get(arrayList2.size() - 1);
                    this.curBlockInfo = new BlockInfo(indexDecoder5);
                    this.queriedBlockInfo = new BlockInfo(indexDecoder5);
                    return;
                }
            }
            throw new CorruptedInputException("XZ file size is not a multiple of 4 bytes");
        }
        throw new XZFormatException();
    }

    public SeekableXZInputStream(SeekableInputStream seekableInputStream, ArrayCache arrayCache2) throws IOException {
        this(seekableInputStream, -1, arrayCache2);
    }

    private void initBlockDecoder() throws IOException {
        try {
            BlockInputStream blockInputStream = this.blockDecoder;
            if (blockInputStream != null) {
                blockInputStream.close();
                this.blockDecoder = null;
            }
            SeekableInputStream seekableInputStream = this.f63415in;
            Check check2 = this.check;
            boolean z11 = this.verifyCheck;
            int i11 = this.memoryLimit;
            BlockInfo blockInfo = this.curBlockInfo;
            this.blockDecoder = new BlockInputStream(seekableInputStream, check2, z11, i11, blockInfo.unpaddedSize, blockInfo.uncompressedSize, this.arrayCache);
        } catch (MemoryLimitException e11) {
            int memoryNeeded = e11.getMemoryNeeded();
            int i12 = this.indexMemoryUsage;
            throw new MemoryLimitException(memoryNeeded + i12, this.memoryLimit + i12);
        } catch (IndexIndicatorException unused) {
            throw new CorruptedInputException();
        }
    }

    private void locateBlockByNumber(BlockInfo blockInfo, int i11) {
        if (i11 < 0 || i11 >= this.blockCount) {
            throw new IndexOutOfBoundsException("Invalid XZ Block number: " + i11);
        } else if (blockInfo.blockNumber != i11) {
            int i12 = 0;
            while (true) {
                IndexDecoder indexDecoder = this.streams.get(i12);
                if (indexDecoder.hasRecord(i11)) {
                    indexDecoder.setBlockInfo(blockInfo, i11);
                    return;
                }
                i12++;
            }
        }
    }

    private void locateBlockByPos(BlockInfo blockInfo, long j11) {
        if (j11 < 0 || j11 >= this.uncompressedSize) {
            throw new IndexOutOfBoundsException("Invalid uncompressed position: " + j11);
        }
        int i11 = 0;
        while (true) {
            IndexDecoder indexDecoder = this.streams.get(i11);
            if (indexDecoder.hasUncompressedOffset(j11)) {
                indexDecoder.locateBlock(blockInfo, j11);
                return;
            }
            i11++;
        }
    }

    private void seek() throws IOException {
        if (!this.seekNeeded) {
            if (this.curBlockInfo.hasNext()) {
                this.curBlockInfo.setNext();
                initBlockDecoder();
                return;
            }
            this.seekPos = this.curPos;
        }
        this.seekNeeded = false;
        long j11 = this.seekPos;
        if (j11 >= this.uncompressedSize) {
            this.curPos = j11;
            BlockInputStream blockInputStream = this.blockDecoder;
            if (blockInputStream != null) {
                blockInputStream.close();
                this.blockDecoder = null;
            }
            this.endReached = true;
            return;
        }
        this.endReached = false;
        locateBlockByPos(this.curBlockInfo, j11);
        long j12 = this.curPos;
        BlockInfo blockInfo = this.curBlockInfo;
        if (j12 <= blockInfo.uncompressedOffset || j12 > this.seekPos) {
            this.f63415in.seek(blockInfo.compressedOffset);
            this.check = Check.getInstance(this.curBlockInfo.getCheckType());
            initBlockDecoder();
            this.curPos = this.curBlockInfo.uncompressedOffset;
        }
        long j13 = this.seekPos;
        long j14 = this.curPos;
        if (j13 > j14) {
            long j15 = j13 - j14;
            if (this.blockDecoder.skip(j15) == j15) {
                this.curPos = this.seekPos;
                return;
            }
            throw new CorruptedInputException();
        }
    }

    public int available() throws IOException {
        BlockInputStream blockInputStream;
        if (this.f63415in != null) {
            IOException iOException = this.exception;
            if (iOException != null) {
                throw iOException;
            } else if (this.endReached || this.seekNeeded || (blockInputStream = this.blockDecoder) == null) {
                return 0;
            } else {
                return blockInputStream.available();
            }
        } else {
            throw new XZIOException("Stream closed");
        }
    }

    public void close() throws IOException {
        close(true);
    }

    public void close(boolean z11) throws IOException {
        if (this.f63415in != null) {
            BlockInputStream blockInputStream = this.blockDecoder;
            if (blockInputStream != null) {
                blockInputStream.close();
                this.blockDecoder = null;
            }
            if (z11) {
                try {
                    this.f63415in.close();
                } catch (Throwable th2) {
                    this.f63415in = null;
                    throw th2;
                }
            }
            this.f63415in = null;
        }
    }

    public int getBlockCheckType(int i11) {
        locateBlockByNumber(this.queriedBlockInfo, i11);
        return this.queriedBlockInfo.getCheckType();
    }

    public long getBlockCompPos(int i11) {
        locateBlockByNumber(this.queriedBlockInfo, i11);
        return this.queriedBlockInfo.compressedOffset;
    }

    public long getBlockCompSize(int i11) {
        locateBlockByNumber(this.queriedBlockInfo, i11);
        return (this.queriedBlockInfo.unpaddedSize + 3) & -4;
    }

    public int getBlockCount() {
        return this.blockCount;
    }

    public int getBlockNumber(long j11) {
        locateBlockByPos(this.queriedBlockInfo, j11);
        return this.queriedBlockInfo.blockNumber;
    }

    public long getBlockPos(int i11) {
        locateBlockByNumber(this.queriedBlockInfo, i11);
        return this.queriedBlockInfo.uncompressedOffset;
    }

    public long getBlockSize(int i11) {
        locateBlockByNumber(this.queriedBlockInfo, i11);
        return this.queriedBlockInfo.uncompressedSize;
    }

    public int getCheckTypes() {
        return this.checkTypes;
    }

    public int getIndexMemoryUsage() {
        return this.indexMemoryUsage;
    }

    public long getLargestBlockSize() {
        return this.largestBlockSize;
    }

    public int getStreamCount() {
        return this.streams.size();
    }

    public long length() {
        return this.uncompressedSize;
    }

    public long position() throws IOException {
        if (this.f63415in != null) {
            return this.seekNeeded ? this.seekPos : this.curPos;
        }
        throw new XZIOException("Stream closed");
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
        if (this.f63415in != null) {
            IOException iOException = this.exception;
            if (iOException == null) {
                try {
                    if (this.seekNeeded) {
                        seek();
                    }
                    if (this.endReached) {
                        return -1;
                    }
                    while (true) {
                        if (i12 <= 0) {
                            break;
                        }
                        if (this.blockDecoder == null) {
                            seek();
                            if (this.endReached) {
                                break;
                            }
                        }
                        int read = this.blockDecoder.read(bArr, i11, i12);
                        if (read > 0) {
                            this.curPos += (long) read;
                            i14 += read;
                            i11 += read;
                            i12 -= read;
                        } else if (read == -1) {
                            this.blockDecoder = null;
                        }
                    }
                    return i14;
                } catch (IOException e11) {
                    e = e11;
                    if (e instanceof EOFException) {
                        e = new CorruptedInputException();
                    }
                    this.exception = e;
                    if (0 == 0) {
                        throw e;
                    }
                }
            } else {
                throw iOException;
            }
        } else {
            throw new XZIOException("Stream closed");
        }
    }

    public void seek(long j11) throws IOException {
        if (this.f63415in == null) {
            throw new XZIOException("Stream closed");
        } else if (j11 >= 0) {
            this.seekPos = j11;
            this.seekNeeded = true;
        } else {
            throw new XZIOException("Negative seek position: " + j11);
        }
    }

    public void seekToBlock(int i11) throws IOException {
        if (this.f63415in == null) {
            throw new XZIOException("Stream closed");
        } else if (i11 < 0 || i11 >= this.blockCount) {
            throw new XZIOException("Invalid XZ Block number: " + i11);
        } else {
            this.seekPos = getBlockPos(i11);
            this.seekNeeded = true;
        }
    }
}
