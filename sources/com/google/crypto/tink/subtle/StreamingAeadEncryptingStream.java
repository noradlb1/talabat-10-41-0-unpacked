package com.google.crypto.tink.subtle;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;

class StreamingAeadEncryptingStream extends FilterOutputStream {
    ByteBuffer ctBuffer;
    private StreamSegmentEncrypter encrypter;
    boolean open = true;
    private int plaintextSegmentSize;
    ByteBuffer ptBuffer;

    public StreamingAeadEncryptingStream(NonceBasedStreamingAead nonceBasedStreamingAead, OutputStream outputStream, byte[] bArr) throws GeneralSecurityException, IOException {
        super(outputStream);
        this.encrypter = nonceBasedStreamingAead.newStreamSegmentEncrypter(bArr);
        int plaintextSegmentSize2 = nonceBasedStreamingAead.getPlaintextSegmentSize();
        this.plaintextSegmentSize = plaintextSegmentSize2;
        this.ptBuffer = ByteBuffer.allocate(plaintextSegmentSize2);
        this.ctBuffer = ByteBuffer.allocate(nonceBasedStreamingAead.getCiphertextSegmentSize());
        this.ptBuffer.limit(this.plaintextSegmentSize - nonceBasedStreamingAead.getCiphertextOffset());
        ByteBuffer header = this.encrypter.getHeader();
        byte[] bArr2 = new byte[header.remaining()];
        header.get(bArr2);
        this.out.write(bArr2);
    }

    public synchronized void close() throws IOException {
        if (this.open) {
            try {
                this.ptBuffer.flip();
                this.ctBuffer.clear();
                this.encrypter.encryptSegment(this.ptBuffer, true, this.ctBuffer);
                this.ctBuffer.flip();
                this.out.write(this.ctBuffer.array(), this.ctBuffer.position(), this.ctBuffer.remaining());
                this.open = false;
                super.close();
            } catch (GeneralSecurityException e11) {
                throw new IOException("ptBuffer.remaining():" + this.ptBuffer.remaining() + " ctBuffer.remaining():" + this.ctBuffer.remaining(), e11);
            }
        }
    }

    public void write(int i11) throws IOException {
        write(new byte[]{(byte) i11});
    }

    public void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    public synchronized void write(byte[] bArr, int i11, int i12) throws IOException {
        if (this.open) {
            while (i12 > this.ptBuffer.remaining()) {
                int remaining = this.ptBuffer.remaining();
                ByteBuffer wrap = ByteBuffer.wrap(bArr, i11, remaining);
                i11 += remaining;
                i12 -= remaining;
                try {
                    this.ptBuffer.flip();
                    this.ctBuffer.clear();
                    this.encrypter.encryptSegment(this.ptBuffer, wrap, false, this.ctBuffer);
                    this.ctBuffer.flip();
                    this.out.write(this.ctBuffer.array(), this.ctBuffer.position(), this.ctBuffer.remaining());
                    this.ptBuffer.clear();
                    this.ptBuffer.limit(this.plaintextSegmentSize);
                } catch (GeneralSecurityException e11) {
                    throw new IOException(e11);
                }
            }
            this.ptBuffer.put(bArr, i11, i12);
        } else {
            throw new IOException("Trying to write to closed stream");
        }
    }
}
