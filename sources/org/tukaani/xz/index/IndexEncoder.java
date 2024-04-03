package org.tukaani.xz.index;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.zip.CRC32;
import java.util.zip.CheckedOutputStream;
import org.tukaani.xz.XZIOException;
import org.tukaani.xz.common.EncoderUtil;

public class IndexEncoder extends IndexBase {
    private final ArrayList<IndexRecord> records = new ArrayList<>();

    public IndexEncoder() {
        super(new XZIOException("XZ Stream or its Index has grown too big"));
    }

    public void add(long j11, long j12) throws XZIOException {
        super.add(j11, j12);
        this.records.add(new IndexRecord(j11, j12));
    }

    public void encode(OutputStream outputStream) throws IOException {
        CRC32 crc32 = new CRC32();
        CheckedOutputStream checkedOutputStream = new CheckedOutputStream(outputStream, crc32);
        checkedOutputStream.write(0);
        EncoderUtil.encodeVLI(checkedOutputStream, this.f63428d);
        Iterator<IndexRecord> it = this.records.iterator();
        while (it.hasNext()) {
            IndexRecord next = it.next();
            EncoderUtil.encodeVLI(checkedOutputStream, next.f63429a);
            EncoderUtil.encodeVLI(checkedOutputStream, next.f63430b);
        }
        for (int a11 = a(); a11 > 0; a11--) {
            checkedOutputStream.write(0);
        }
        long value = crc32.getValue();
        for (int i11 = 0; i11 < 4; i11++) {
            outputStream.write((byte) ((int) (value >>> (i11 * 8))));
        }
    }

    public /* bridge */ /* synthetic */ long getIndexSize() {
        return super.getIndexSize();
    }

    public /* bridge */ /* synthetic */ long getStreamSize() {
        return super.getStreamSize();
    }
}
