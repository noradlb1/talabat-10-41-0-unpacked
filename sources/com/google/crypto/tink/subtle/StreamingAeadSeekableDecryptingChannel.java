package com.google.crypto.tink.subtle;

import androidx.annotation.RequiresApi;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.NonWritableChannelException;
import java.nio.channels.SeekableByteChannel;
import java.security.GeneralSecurityException;
import java.util.Arrays;

@RequiresApi(24)
class StreamingAeadSeekableDecryptingChannel implements SeekableByteChannel {
    private static final int PLAINTEXT_SEGMENT_EXTRA_SIZE = 16;
    private final byte[] aad;
    private final SeekableByteChannel ciphertextChannel;
    private final long ciphertextChannelSize;
    private final int ciphertextOffset;
    private final ByteBuffer ciphertextSegment;
    private final int ciphertextSegmentSize;
    private int currentSegmentNr = -1;
    private final StreamSegmentDecrypter decrypter;
    private final int firstSegmentOffset;
    private final ByteBuffer header;
    private boolean headerRead = false;
    private boolean isCurrentSegmentDecrypted = false;
    private boolean isopen;
    private final int lastCiphertextSegmentSize;
    private final int numberOfSegments;
    private long plaintextPosition = 0;
    private final ByteBuffer plaintextSegment;
    private final int plaintextSegmentSize;
    private long plaintextSize;

    public StreamingAeadSeekableDecryptingChannel(NonceBasedStreamingAead nonceBasedStreamingAead, SeekableByteChannel seekableByteChannel, byte[] bArr) throws IOException, GeneralSecurityException {
        this.decrypter = nonceBasedStreamingAead.newStreamSegmentDecrypter();
        this.ciphertextChannel = seekableByteChannel;
        this.header = ByteBuffer.allocate(nonceBasedStreamingAead.getHeaderLength());
        int ciphertextSegmentSize2 = nonceBasedStreamingAead.getCiphertextSegmentSize();
        this.ciphertextSegmentSize = ciphertextSegmentSize2;
        this.ciphertextSegment = ByteBuffer.allocate(ciphertextSegmentSize2);
        int plaintextSegmentSize2 = nonceBasedStreamingAead.getPlaintextSegmentSize();
        this.plaintextSegmentSize = plaintextSegmentSize2;
        this.plaintextSegment = ByteBuffer.allocate(plaintextSegmentSize2 + 16);
        long a11 = seekableByteChannel.size();
        this.ciphertextChannelSize = a11;
        this.aad = Arrays.copyOf(bArr, bArr.length);
        this.isopen = seekableByteChannel.isOpen();
        int i11 = (int) (a11 / ((long) ciphertextSegmentSize2));
        int i12 = (int) (a11 % ((long) ciphertextSegmentSize2));
        int ciphertextOverhead = nonceBasedStreamingAead.getCiphertextOverhead();
        if (i12 > 0) {
            this.numberOfSegments = i11 + 1;
            if (i12 >= ciphertextOverhead) {
                this.lastCiphertextSegmentSize = i12;
            } else {
                throw new IOException("Invalid ciphertext size");
            }
        } else {
            this.numberOfSegments = i11;
            this.lastCiphertextSegmentSize = ciphertextSegmentSize2;
        }
        int ciphertextOffset2 = nonceBasedStreamingAead.getCiphertextOffset();
        this.ciphertextOffset = ciphertextOffset2;
        int headerLength = ciphertextOffset2 - nonceBasedStreamingAead.getHeaderLength();
        this.firstSegmentOffset = headerLength;
        if (headerLength >= 0) {
            long j11 = (((long) this.numberOfSegments) * ((long) ciphertextOverhead)) + ((long) ciphertextOffset2);
            if (j11 <= a11) {
                this.plaintextSize = a11 - j11;
                return;
            }
            throw new IOException("Ciphertext is too short");
        }
        throw new IOException("Invalid ciphertext offset or header length");
    }

    private int getSegmentNr(long j11) {
        return (int) ((j11 + ((long) this.ciphertextOffset)) / ((long) this.plaintextSegmentSize));
    }

    private boolean reachedEnd() {
        if (this.isCurrentSegmentDecrypted && this.currentSegmentNr == this.numberOfSegments - 1 && this.plaintextSegment.remaining() == 0) {
            return true;
        }
        return false;
    }

    private boolean tryLoadSegment(int i11) throws IOException {
        int i12;
        boolean z11;
        if (i11 < 0 || i11 >= (i12 = this.numberOfSegments)) {
            throw new IOException("Invalid position");
        }
        if (i11 == i12 - 1) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (i11 != this.currentSegmentNr) {
            int i13 = this.ciphertextSegmentSize;
            long j11 = ((long) i11) * ((long) i13);
            if (z11) {
                i13 = this.lastCiphertextSegmentSize;
            }
            if (i11 == 0) {
                int i14 = this.ciphertextOffset;
                i13 -= i14;
                j11 = (long) i14;
            }
            SeekableByteChannel unused = this.ciphertextChannel.position(j11);
            this.ciphertextSegment.clear();
            this.ciphertextSegment.limit(i13);
            this.currentSegmentNr = i11;
            this.isCurrentSegmentDecrypted = false;
        } else if (this.isCurrentSegmentDecrypted) {
            return true;
        }
        if (this.ciphertextSegment.remaining() > 0) {
            int unused2 = this.ciphertextChannel.read(this.ciphertextSegment);
        }
        if (this.ciphertextSegment.remaining() > 0) {
            return false;
        }
        this.ciphertextSegment.flip();
        this.plaintextSegment.clear();
        try {
            this.decrypter.decryptSegment(this.ciphertextSegment, i11, z11, this.plaintextSegment);
            this.plaintextSegment.flip();
            this.isCurrentSegmentDecrypted = true;
            return true;
        } catch (GeneralSecurityException e11) {
            this.currentSegmentNr = -1;
            throw new IOException("Failed to decrypt", e11);
        }
    }

    private boolean tryReadHeader() throws IOException {
        SeekableByteChannel unused = this.ciphertextChannel.position((long) (this.header.position() + this.firstSegmentOffset));
        int unused2 = this.ciphertextChannel.read(this.header);
        if (this.header.remaining() > 0) {
            return false;
        }
        this.header.flip();
        try {
            this.decrypter.init(this.header, this.aad);
            this.headerRead = true;
            return true;
        } catch (GeneralSecurityException e11) {
            throw new IOException(e11);
        }
    }

    public synchronized void close() throws IOException {
        this.ciphertextChannel.close();
        this.isopen = false;
    }

    public synchronized boolean isOpen() {
        return this.isopen;
    }

    public synchronized long position() {
        return this.plaintextPosition;
    }

    public synchronized int read(ByteBuffer byteBuffer, long j11) throws IOException {
        long position = position();
        try {
            position(j11);
        } finally {
            position(position);
        }
        return read(byteBuffer);
    }

    public long size() {
        return this.plaintextSize;
    }

    public synchronized String toString() {
        StringBuilder sb2;
        String str;
        sb2 = new StringBuilder();
        try {
            str = "position:" + this.ciphertextChannel.position();
        } catch (IOException unused) {
            str = "position: n/a";
        }
        sb2.append("StreamingAeadSeekableDecryptingChannel");
        sb2.append("\nciphertextChannel");
        sb2.append(str);
        sb2.append("\nciphertextChannelSize:");
        sb2.append(this.ciphertextChannelSize);
        sb2.append("\nplaintextSize:");
        sb2.append(this.plaintextSize);
        sb2.append("\nciphertextSegmentSize:");
        sb2.append(this.ciphertextSegmentSize);
        sb2.append("\nnumberOfSegments:");
        sb2.append(this.numberOfSegments);
        sb2.append("\nheaderRead:");
        sb2.append(this.headerRead);
        sb2.append("\nplaintextPosition:");
        sb2.append(this.plaintextPosition);
        sb2.append("\nHeader");
        sb2.append(" position:");
        sb2.append(this.header.position());
        sb2.append(" limit:");
        sb2.append(this.header.position());
        sb2.append("\ncurrentSegmentNr:");
        sb2.append(this.currentSegmentNr);
        sb2.append("\nciphertextSgement");
        sb2.append(" position:");
        sb2.append(this.ciphertextSegment.position());
        sb2.append(" limit:");
        sb2.append(this.ciphertextSegment.limit());
        sb2.append("\nisCurrentSegmentDecrypted:");
        sb2.append(this.isCurrentSegmentDecrypted);
        sb2.append("\nplaintextSegment");
        sb2.append(" position:");
        sb2.append(this.plaintextSegment.position());
        sb2.append(" limit:");
        sb2.append(this.plaintextSegment.limit());
        return sb2.toString();
    }

    public SeekableByteChannel truncate(long j11) throws NonWritableChannelException {
        throw new NonWritableChannelException();
    }

    public synchronized long verifiedSize() throws IOException {
        if (tryLoadSegment(this.numberOfSegments - 1)) {
        } else {
            throw new IOException("could not verify the size");
        }
        return this.plaintextSize;
    }

    public int write(ByteBuffer byteBuffer) throws NonWritableChannelException {
        throw new NonWritableChannelException();
    }

    public synchronized SeekableByteChannel position(long j11) {
        this.plaintextPosition = j11;
        return this;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0099, code lost:
        return r7;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized int read(java.nio.ByteBuffer r7) throws java.io.IOException {
        /*
            r6 = this;
            monitor-enter(r6)
            boolean r0 = r6.isopen     // Catch:{ all -> 0x00a0 }
            if (r0 == 0) goto L_0x009a
            boolean r0 = r6.headerRead     // Catch:{ all -> 0x00a0 }
            if (r0 != 0) goto L_0x0012
            boolean r0 = r6.tryReadHeader()     // Catch:{ all -> 0x00a0 }
            if (r0 != 0) goto L_0x0012
            monitor-exit(r6)
            r7 = 0
            return r7
        L_0x0012:
            int r0 = r7.position()     // Catch:{ all -> 0x00a0 }
        L_0x0016:
            int r1 = r7.remaining()     // Catch:{ all -> 0x00a0 }
            if (r1 <= 0) goto L_0x0088
            long r1 = r6.plaintextPosition     // Catch:{ all -> 0x00a0 }
            long r3 = r6.plaintextSize     // Catch:{ all -> 0x00a0 }
            int r3 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r3 >= 0) goto L_0x0088
            int r1 = r6.getSegmentNr(r1)     // Catch:{ all -> 0x00a0 }
            if (r1 != 0) goto L_0x002e
            long r2 = r6.plaintextPosition     // Catch:{ all -> 0x00a0 }
        L_0x002c:
            int r2 = (int) r2     // Catch:{ all -> 0x00a0 }
            goto L_0x0039
        L_0x002e:
            long r2 = r6.plaintextPosition     // Catch:{ all -> 0x00a0 }
            int r4 = r6.ciphertextOffset     // Catch:{ all -> 0x00a0 }
            long r4 = (long) r4     // Catch:{ all -> 0x00a0 }
            long r2 = r2 + r4
            int r4 = r6.plaintextSegmentSize     // Catch:{ all -> 0x00a0 }
            long r4 = (long) r4     // Catch:{ all -> 0x00a0 }
            long r2 = r2 % r4
            goto L_0x002c
        L_0x0039:
            boolean r1 = r6.tryLoadSegment(r1)     // Catch:{ all -> 0x00a0 }
            if (r1 == 0) goto L_0x0088
            java.nio.ByteBuffer r1 = r6.plaintextSegment     // Catch:{ all -> 0x00a0 }
            r1.position(r2)     // Catch:{ all -> 0x00a0 }
            java.nio.ByteBuffer r1 = r6.plaintextSegment     // Catch:{ all -> 0x00a0 }
            int r1 = r1.remaining()     // Catch:{ all -> 0x00a0 }
            int r2 = r7.remaining()     // Catch:{ all -> 0x00a0 }
            if (r1 > r2) goto L_0x0062
            long r1 = r6.plaintextPosition     // Catch:{ all -> 0x00a0 }
            java.nio.ByteBuffer r3 = r6.plaintextSegment     // Catch:{ all -> 0x00a0 }
            int r3 = r3.remaining()     // Catch:{ all -> 0x00a0 }
            long r3 = (long) r3     // Catch:{ all -> 0x00a0 }
            long r1 = r1 + r3
            r6.plaintextPosition = r1     // Catch:{ all -> 0x00a0 }
            java.nio.ByteBuffer r1 = r6.plaintextSegment     // Catch:{ all -> 0x00a0 }
            r7.put(r1)     // Catch:{ all -> 0x00a0 }
            goto L_0x0016
        L_0x0062:
            int r1 = r7.remaining()     // Catch:{ all -> 0x00a0 }
            java.nio.ByteBuffer r2 = r6.plaintextSegment     // Catch:{ all -> 0x00a0 }
            java.nio.ByteBuffer r2 = r2.duplicate()     // Catch:{ all -> 0x00a0 }
            int r3 = r2.position()     // Catch:{ all -> 0x00a0 }
            int r3 = r3 + r1
            r2.limit(r3)     // Catch:{ all -> 0x00a0 }
            r7.put(r2)     // Catch:{ all -> 0x00a0 }
            long r2 = r6.plaintextPosition     // Catch:{ all -> 0x00a0 }
            long r4 = (long) r1     // Catch:{ all -> 0x00a0 }
            long r2 = r2 + r4
            r6.plaintextPosition = r2     // Catch:{ all -> 0x00a0 }
            java.nio.ByteBuffer r2 = r6.plaintextSegment     // Catch:{ all -> 0x00a0 }
            int r3 = r2.position()     // Catch:{ all -> 0x00a0 }
            int r3 = r3 + r1
            r2.position(r3)     // Catch:{ all -> 0x00a0 }
            goto L_0x0016
        L_0x0088:
            int r7 = r7.position()     // Catch:{ all -> 0x00a0 }
            int r7 = r7 - r0
            if (r7 != 0) goto L_0x0098
            boolean r0 = r6.reachedEnd()     // Catch:{ all -> 0x00a0 }
            if (r0 == 0) goto L_0x0098
            monitor-exit(r6)
            r7 = -1
            return r7
        L_0x0098:
            monitor-exit(r6)
            return r7
        L_0x009a:
            java.nio.channels.ClosedChannelException r7 = new java.nio.channels.ClosedChannelException     // Catch:{ all -> 0x00a0 }
            r7.<init>()     // Catch:{ all -> 0x00a0 }
            throw r7     // Catch:{ all -> 0x00a0 }
        L_0x00a0:
            r7 = move-exception
            monitor-exit(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.subtle.StreamingAeadSeekableDecryptingChannel.read(java.nio.ByteBuffer):int");
    }
}
