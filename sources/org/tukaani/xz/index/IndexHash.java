package org.tukaani.xz.index;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.zip.CheckedInputStream;
import org.tukaani.xz.CorruptedInputException;
import org.tukaani.xz.XZIOException;
import org.tukaani.xz.check.CRC32;
import org.tukaani.xz.check.Check;
import org.tukaani.xz.check.SHA256;
import org.tukaani.xz.common.DecoderUtil;

public class IndexHash extends IndexBase {
    private Check hash;

    public IndexHash() {
        super(new CorruptedInputException());
        try {
            this.hash = new SHA256();
        } catch (NoSuchAlgorithmException unused) {
            this.hash = new CRC32();
        }
    }

    public void add(long j11, long j12) throws XZIOException {
        super.add(j11, j12);
        ByteBuffer allocate = ByteBuffer.allocate(16);
        allocate.putLong(j11);
        allocate.putLong(j12);
        this.hash.update(allocate.array());
    }

    public /* bridge */ /* synthetic */ long getIndexSize() {
        return super.getIndexSize();
    }

    public /* bridge */ /* synthetic */ long getStreamSize() {
        return super.getStreamSize();
    }

    public void validate(InputStream inputStream) throws IOException {
        java.util.zip.CRC32 crc32 = new java.util.zip.CRC32();
        int i11 = 0;
        crc32.update(0);
        CheckedInputStream checkedInputStream = new CheckedInputStream(inputStream, crc32);
        if (DecoderUtil.decodeVLI(checkedInputStream) == this.f63428d) {
            IndexHash indexHash = new IndexHash();
            long j11 = 0;
            while (j11 < this.f63428d) {
                try {
                    indexHash.add(DecoderUtil.decodeVLI(checkedInputStream), DecoderUtil.decodeVLI(checkedInputStream));
                    if (indexHash.f63425a > this.f63425a || indexHash.f63426b > this.f63426b || indexHash.f63427c > this.f63427c) {
                        throw new CorruptedInputException("XZ Index is corrupt");
                    }
                    j11++;
                } catch (XZIOException unused) {
                    throw new CorruptedInputException("XZ Index is corrupt");
                }
            }
            if (indexHash.f63425a == this.f63425a && indexHash.f63426b == this.f63426b && indexHash.f63427c == this.f63427c && Arrays.equals(indexHash.hash.finish(), this.hash.finish())) {
                DataInputStream dataInputStream = new DataInputStream(checkedInputStream);
                int a11 = a();
                while (a11 > 0) {
                    if (dataInputStream.readUnsignedByte() == 0) {
                        a11--;
                    } else {
                        throw new CorruptedInputException("XZ Index is corrupt");
                    }
                }
                long value = crc32.getValue();
                while (i11 < 4) {
                    if (((value >>> (i11 * 8)) & 255) == ((long) dataInputStream.readUnsignedByte())) {
                        i11++;
                    } else {
                        throw new CorruptedInputException("XZ Index is corrupt");
                    }
                }
                return;
            }
            throw new CorruptedInputException("XZ Index is corrupt");
        }
        throw new CorruptedInputException("XZ Block Header or the start of XZ Index is corrupt");
    }
}
