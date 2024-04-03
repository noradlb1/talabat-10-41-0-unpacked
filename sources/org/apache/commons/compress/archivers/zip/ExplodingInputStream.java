package org.apache.commons.compress.archivers.zip;

import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.compress.utils.InputStreamStatistics;

class ExplodingInputStream extends InputStream implements InputStreamStatistics {
    private BitStream bits;
    private final CircularBuffer buffer = new CircularBuffer(32768);
    private final int dictionarySize;
    private BinaryTree distanceTree;

    /* renamed from: in  reason: collision with root package name */
    private final InputStream f27644in;
    private BinaryTree lengthTree;
    private BinaryTree literalTree;
    private final int minimumMatchLength;
    private final int numberOfTrees;
    private long treeSizes;
    private long uncompressedCount;

    public ExplodingInputStream(int i11, int i12, InputStream inputStream) {
        if (i11 != 4096 && i11 != 8192) {
            throw new IllegalArgumentException("The dictionary size must be 4096 or 8192");
        } else if (i12 == 2 || i12 == 3) {
            this.dictionarySize = i11;
            this.numberOfTrees = i12;
            this.minimumMatchLength = i12;
            this.f27644in = inputStream;
        } else {
            throw new IllegalArgumentException("The number of trees must be 2 or 3");
        }
    }

    private void fillBuffer() throws IOException {
        int i11;
        int i12;
        init();
        int a11 = this.bits.a();
        if (a11 != -1) {
            if (a11 == 1) {
                BinaryTree binaryTree = this.literalTree;
                if (binaryTree != null) {
                    i12 = binaryTree.read(this.bits);
                } else {
                    i12 = this.bits.c();
                }
                if (i12 != -1) {
                    this.buffer.put(i12);
                    return;
                }
                return;
            }
            if (this.dictionarySize == 4096) {
                i11 = 6;
            } else {
                i11 = 7;
            }
            int b11 = (int) this.bits.b(i11);
            int read = this.distanceTree.read(this.bits);
            if (read != -1 || b11 > 0) {
                int i13 = (read << i11) | b11;
                int read2 = this.lengthTree.read(this.bits);
                if (read2 == 63) {
                    long b12 = this.bits.b(8);
                    if (b12 != -1) {
                        read2 = (int) (((long) read2) + b12);
                    } else {
                        return;
                    }
                }
                this.buffer.copy(i13 + 1, read2 + this.minimumMatchLength);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0043, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0048, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0049, code lost:
        r1.addSuppressed(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x004c, code lost:
        throw r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void init() throws java.io.IOException {
        /*
            r5 = this;
            org.apache.commons.compress.archivers.zip.BitStream r0 = r5.bits
            if (r0 != 0) goto L_0x004d
            org.apache.commons.compress.utils.CountingInputStream r0 = new org.apache.commons.compress.utils.CountingInputStream
            org.apache.commons.compress.utils.CloseShieldFilterInputStream r1 = new org.apache.commons.compress.utils.CloseShieldFilterInputStream
            java.io.InputStream r2 = r5.f27644in
            r1.<init>(r2)
            r0.<init>(r1)
            int r1 = r5.numberOfTrees     // Catch:{ all -> 0x0041 }
            r2 = 3
            if (r1 != r2) goto L_0x001d
            r1 = 256(0x100, float:3.59E-43)
            org.apache.commons.compress.archivers.zip.BinaryTree r1 = org.apache.commons.compress.archivers.zip.BinaryTree.a(r0, r1)     // Catch:{ all -> 0x0041 }
            r5.literalTree = r1     // Catch:{ all -> 0x0041 }
        L_0x001d:
            r1 = 64
            org.apache.commons.compress.archivers.zip.BinaryTree r2 = org.apache.commons.compress.archivers.zip.BinaryTree.a(r0, r1)     // Catch:{ all -> 0x0041 }
            r5.lengthTree = r2     // Catch:{ all -> 0x0041 }
            org.apache.commons.compress.archivers.zip.BinaryTree r1 = org.apache.commons.compress.archivers.zip.BinaryTree.a(r0, r1)     // Catch:{ all -> 0x0041 }
            r5.distanceTree = r1     // Catch:{ all -> 0x0041 }
            long r1 = r5.treeSizes     // Catch:{ all -> 0x0041 }
            long r3 = r0.getBytesRead()     // Catch:{ all -> 0x0041 }
            long r1 = r1 + r3
            r5.treeSizes = r1     // Catch:{ all -> 0x0041 }
            r0.close()
            org.apache.commons.compress.archivers.zip.BitStream r0 = new org.apache.commons.compress.archivers.zip.BitStream
            java.io.InputStream r1 = r5.f27644in
            r0.<init>(r1)
            r5.bits = r0
            goto L_0x004d
        L_0x0041:
            r1 = move-exception
            throw r1     // Catch:{ all -> 0x0043 }
        L_0x0043:
            r2 = move-exception
            r0.close()     // Catch:{ all -> 0x0048 }
            goto L_0x004c
        L_0x0048:
            r0 = move-exception
            r1.addSuppressed(r0)
        L_0x004c:
            throw r2
        L_0x004d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.compress.archivers.zip.ExplodingInputStream.init():void");
    }

    public void close() throws IOException {
        this.f27644in.close();
    }

    public long getCompressedCount() {
        return this.bits.getBytesRead() + this.treeSizes;
    }

    public long getUncompressedCount() {
        return this.uncompressedCount;
    }

    public int read() throws IOException {
        if (!this.buffer.available()) {
            try {
                fillBuffer();
            } catch (IllegalArgumentException e11) {
                throw new IOException("bad IMPLODE stream", e11);
            }
        }
        int i11 = this.buffer.get();
        if (i11 > -1) {
            this.uncompressedCount++;
        }
        return i11;
    }
}
