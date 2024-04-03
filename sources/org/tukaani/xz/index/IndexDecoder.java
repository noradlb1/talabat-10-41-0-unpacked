package org.tukaani.xz.index;

import org.tukaani.xz.common.StreamFlags;

public class IndexDecoder extends IndexBase {
    private long compressedOffset = 0;
    private long largestBlockSize = 0;
    private final int memoryUsage;
    private int recordOffset = 0;
    private final StreamFlags streamFlags;
    private final long streamPadding;
    private final long[] uncompressed;
    private long uncompressedOffset = 0;
    private final long[] unpadded;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public IndexDecoder(org.tukaani.xz.SeekableInputStream r17, org.tukaani.xz.common.StreamFlags r18, long r19, int r21) throws java.io.IOException {
        /*
            r16 = this;
            r0 = r16
            r1 = r18
            r2 = r21
            org.tukaani.xz.CorruptedInputException r3 = new org.tukaani.xz.CorruptedInputException
            java.lang.String r4 = "XZ Index is corrupt"
            r3.<init>(r4)
            r0.<init>(r3)
            r5 = 0
            r0.largestBlockSize = r5
            r3 = 0
            r0.recordOffset = r3
            r0.compressedOffset = r5
            r0.uncompressedOffset = r5
            r0.streamFlags = r1
            r5 = r19
            r0.streamPadding = r5
            long r5 = r17.position()
            long r7 = r1.backwardSize
            long r5 = r5 + r7
            r7 = 4
            long r5 = r5 - r7
            java.util.zip.CRC32 r7 = new java.util.zip.CRC32
            r7.<init>()
            java.util.zip.CheckedInputStream r8 = new java.util.zip.CheckedInputStream
            r9 = r17
            r8.<init>(r9, r7)
            int r10 = r8.read()
            if (r10 != 0) goto L_0x011a
            long r10 = org.tukaani.xz.common.DecoderUtil.decodeVLI(r8)     // Catch:{ EOFException -> 0x0113 }
            long r12 = r1.backwardSize     // Catch:{ EOFException -> 0x0113 }
            r14 = 2
            long r12 = r12 / r14
            int r1 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r1 >= 0) goto L_0x010c
            r12 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r1 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r1 > 0) goto L_0x0103
            r12 = 16
            long r12 = r12 * r10
            r14 = 1023(0x3ff, double:5.054E-321)
            long r12 = r12 + r14
            r14 = 1024(0x400, double:5.06E-321)
            long r12 = r12 / r14
            int r1 = (int) r12     // Catch:{ EOFException -> 0x0113 }
            int r1 = r1 + 1
            r0.memoryUsage = r1     // Catch:{ EOFException -> 0x0113 }
            if (r2 < 0) goto L_0x006a
            if (r1 > r2) goto L_0x0064
            goto L_0x006a
        L_0x0064:
            org.tukaani.xz.MemoryLimitException r3 = new org.tukaani.xz.MemoryLimitException     // Catch:{ EOFException -> 0x0113 }
            r3.<init>(r1, r2)     // Catch:{ EOFException -> 0x0113 }
            throw r3     // Catch:{ EOFException -> 0x0113 }
        L_0x006a:
            int r1 = (int) r10     // Catch:{ EOFException -> 0x0113 }
            long[] r2 = new long[r1]     // Catch:{ EOFException -> 0x0113 }
            r0.unpadded = r2     // Catch:{ EOFException -> 0x0113 }
            long[] r2 = new long[r1]     // Catch:{ EOFException -> 0x0113 }
            r0.uncompressed = r2     // Catch:{ EOFException -> 0x0113 }
            r2 = r3
        L_0x0074:
            if (r1 <= 0) goto L_0x00ba
            long r10 = org.tukaani.xz.common.DecoderUtil.decodeVLI(r8)     // Catch:{ EOFException -> 0x0113 }
            long r12 = org.tukaani.xz.common.DecoderUtil.decodeVLI(r8)     // Catch:{ EOFException -> 0x0113 }
            long r14 = r17.position()     // Catch:{ EOFException -> 0x0113 }
            int r14 = (r14 > r5 ? 1 : (r14 == r5 ? 0 : -1))
            if (r14 > 0) goto L_0x00ad
            long[] r14 = r0.unpadded     // Catch:{ EOFException -> 0x0113 }
            r15 = r4
            long r3 = r0.f63425a     // Catch:{ EOFException -> 0x00aa }
            long r3 = r3 + r10
            r14[r2] = r3     // Catch:{ EOFException -> 0x00aa }
            long[] r3 = r0.uncompressed     // Catch:{ EOFException -> 0x00aa }
            r18 = r15
            long r14 = r0.f63426b     // Catch:{ EOFException -> 0x00b7 }
            long r14 = r14 + r12
            r3[r2] = r14     // Catch:{ EOFException -> 0x00b7 }
            int r2 = r2 + 1
            super.add(r10, r12)     // Catch:{ EOFException -> 0x00b7 }
            long r3 = r0.largestBlockSize     // Catch:{ EOFException -> 0x00b7 }
            int r3 = (r3 > r12 ? 1 : (r3 == r12 ? 0 : -1))
            if (r3 >= 0) goto L_0x00a4
            r0.largestBlockSize = r12     // Catch:{ EOFException -> 0x00b7 }
        L_0x00a4:
            int r1 = r1 + -1
            r4 = r18
            r3 = 0
            goto L_0x0074
        L_0x00aa:
            r2 = r15
            goto L_0x0114
        L_0x00ad:
            r18 = r4
            org.tukaani.xz.CorruptedInputException r1 = new org.tukaani.xz.CorruptedInputException     // Catch:{ EOFException -> 0x00b7 }
            r2 = r18
            r1.<init>(r2)     // Catch:{ EOFException -> 0x0114 }
            throw r1     // Catch:{ EOFException -> 0x0114 }
        L_0x00b7:
            r2 = r18
            goto L_0x0114
        L_0x00ba:
            r2 = r4
            int r1 = r16.a()
            long r3 = r17.position()
            long r10 = (long) r1
            long r3 = r3 + r10
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r3 != 0) goto L_0x00fd
        L_0x00c9:
            int r3 = r1 + -1
            if (r1 <= 0) goto L_0x00db
            int r1 = r8.read()
            if (r1 != 0) goto L_0x00d5
            r1 = r3
            goto L_0x00c9
        L_0x00d5:
            org.tukaani.xz.CorruptedInputException r1 = new org.tukaani.xz.CorruptedInputException
            r1.<init>(r2)
            throw r1
        L_0x00db:
            long r3 = r7.getValue()
            r1 = 0
        L_0x00e0:
            r5 = 4
            if (r1 >= r5) goto L_0x00fc
            int r5 = r1 * 8
            long r5 = r3 >>> r5
            r7 = 255(0xff, double:1.26E-321)
            long r5 = r5 & r7
            int r7 = r17.read()
            long r7 = (long) r7
            int r5 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r5 != 0) goto L_0x00f6
            int r1 = r1 + 1
            goto L_0x00e0
        L_0x00f6:
            org.tukaani.xz.CorruptedInputException r1 = new org.tukaani.xz.CorruptedInputException
            r1.<init>(r2)
            throw r1
        L_0x00fc:
            return
        L_0x00fd:
            org.tukaani.xz.CorruptedInputException r1 = new org.tukaani.xz.CorruptedInputException
            r1.<init>(r2)
            throw r1
        L_0x0103:
            r2 = r4
            org.tukaani.xz.UnsupportedOptionsException r1 = new org.tukaani.xz.UnsupportedOptionsException     // Catch:{ EOFException -> 0x0114 }
            java.lang.String r3 = "XZ Index has over 2147483647 Records"
            r1.<init>(r3)     // Catch:{ EOFException -> 0x0114 }
            throw r1     // Catch:{ EOFException -> 0x0114 }
        L_0x010c:
            r2 = r4
            org.tukaani.xz.CorruptedInputException r1 = new org.tukaani.xz.CorruptedInputException     // Catch:{ EOFException -> 0x0114 }
            r1.<init>(r2)     // Catch:{ EOFException -> 0x0114 }
            throw r1     // Catch:{ EOFException -> 0x0114 }
        L_0x0113:
            r2 = r4
        L_0x0114:
            org.tukaani.xz.CorruptedInputException r1 = new org.tukaani.xz.CorruptedInputException
            r1.<init>(r2)
            throw r1
        L_0x011a:
            r2 = r4
            org.tukaani.xz.CorruptedInputException r1 = new org.tukaani.xz.CorruptedInputException
            r1.<init>(r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.tukaani.xz.index.IndexDecoder.<init>(org.tukaani.xz.SeekableInputStream, org.tukaani.xz.common.StreamFlags, long, int):void");
    }

    public /* bridge */ /* synthetic */ long getIndexSize() {
        return super.getIndexSize();
    }

    public long getLargestBlockSize() {
        return this.largestBlockSize;
    }

    public int getMemoryUsage() {
        return this.memoryUsage;
    }

    public int getRecordCount() {
        return (int) this.f63428d;
    }

    public StreamFlags getStreamFlags() {
        return this.streamFlags;
    }

    public /* bridge */ /* synthetic */ long getStreamSize() {
        return super.getStreamSize();
    }

    public long getUncompressedSize() {
        return this.f63426b;
    }

    public boolean hasRecord(int i11) {
        int i12 = this.recordOffset;
        return i11 >= i12 && ((long) i11) < ((long) i12) + this.f63428d;
    }

    public boolean hasUncompressedOffset(long j11) {
        long j12 = this.uncompressedOffset;
        return j11 >= j12 && j11 < j12 + this.f63426b;
    }

    public void locateBlock(BlockInfo blockInfo, long j11) {
        long j12 = j11 - this.uncompressedOffset;
        int length = this.unpadded.length - 1;
        int i11 = 0;
        while (i11 < length) {
            int i12 = ((length - i11) / 2) + i11;
            if (this.uncompressed[i12] <= j12) {
                i11 = i12 + 1;
            } else {
                length = i12;
            }
        }
        setBlockInfo(blockInfo, this.recordOffset + i11);
    }

    public void setBlockInfo(BlockInfo blockInfo, int i11) {
        blockInfo.f63424a = this;
        blockInfo.blockNumber = i11;
        int i12 = i11 - this.recordOffset;
        if (i12 == 0) {
            blockInfo.compressedOffset = 0;
            blockInfo.uncompressedOffset = 0;
        } else {
            int i13 = i12 - 1;
            blockInfo.compressedOffset = (this.unpadded[i13] + 3) & -4;
            blockInfo.uncompressedOffset = this.uncompressed[i13];
        }
        long j11 = this.unpadded[i12];
        long j12 = blockInfo.compressedOffset;
        blockInfo.unpaddedSize = j11 - j12;
        long j13 = this.uncompressed[i12];
        long j14 = blockInfo.uncompressedOffset;
        blockInfo.uncompressedSize = j13 - j14;
        blockInfo.compressedOffset = j12 + this.compressedOffset + 12;
        blockInfo.uncompressedOffset = j14 + this.uncompressedOffset;
    }

    public void setOffsets(IndexDecoder indexDecoder) {
        this.recordOffset = indexDecoder.recordOffset + ((int) indexDecoder.f63428d);
        this.compressedOffset = indexDecoder.compressedOffset + indexDecoder.getStreamSize() + indexDecoder.streamPadding;
        this.uncompressedOffset = indexDecoder.uncompressedOffset + indexDecoder.f63426b;
    }
}
