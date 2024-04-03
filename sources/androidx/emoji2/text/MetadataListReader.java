package androidx.emoji2.text;

import android.content.res.AssetManager;
import androidx.annotation.AnyThread;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.emoji2.text.flatbuffer.MetadataList;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import kotlin.UShort;

@RequiresApi(19)
@AnyThread
@RestrictTo({RestrictTo.Scope.LIBRARY})
class MetadataListReader {
    private static final int EMJI_TAG = 1164798569;
    private static final int EMJI_TAG_DEPRECATED = 1701669481;
    private static final int META_TABLE_NAME = 1835365473;

    public static class ByteBufferReader implements OpenTypeReader {
        @NonNull
        private final ByteBuffer mByteBuffer;

        public ByteBufferReader(@NonNull ByteBuffer byteBuffer) {
            this.mByteBuffer = byteBuffer;
            byteBuffer.order(ByteOrder.BIG_ENDIAN);
        }

        public long getPosition() {
            return (long) this.mByteBuffer.position();
        }

        public int readTag() throws IOException {
            return this.mByteBuffer.getInt();
        }

        public long readUnsignedInt() throws IOException {
            return MetadataListReader.d(this.mByteBuffer.getInt());
        }

        public int readUnsignedShort() throws IOException {
            return MetadataListReader.e(this.mByteBuffer.getShort());
        }

        public void skip(int i11) throws IOException {
            ByteBuffer byteBuffer = this.mByteBuffer;
            byteBuffer.position(byteBuffer.position() + i11);
        }
    }

    public static class InputStreamOpenTypeReader implements OpenTypeReader {
        @NonNull
        private final byte[] mByteArray;
        @NonNull
        private final ByteBuffer mByteBuffer;
        @NonNull
        private final InputStream mInputStream;
        private long mPosition = 0;

        public InputStreamOpenTypeReader(@NonNull InputStream inputStream) {
            this.mInputStream = inputStream;
            byte[] bArr = new byte[4];
            this.mByteArray = bArr;
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            this.mByteBuffer = wrap;
            wrap.order(ByteOrder.BIG_ENDIAN);
        }

        private void read(@IntRange(from = 0, to = 4) int i11) throws IOException {
            if (this.mInputStream.read(this.mByteArray, 0, i11) == i11) {
                this.mPosition += (long) i11;
                return;
            }
            throw new IOException("read failed");
        }

        public long getPosition() {
            return this.mPosition;
        }

        public int readTag() throws IOException {
            this.mByteBuffer.position(0);
            read(4);
            return this.mByteBuffer.getInt();
        }

        public long readUnsignedInt() throws IOException {
            this.mByteBuffer.position(0);
            read(4);
            return MetadataListReader.d(this.mByteBuffer.getInt());
        }

        public int readUnsignedShort() throws IOException {
            this.mByteBuffer.position(0);
            read(2);
            return MetadataListReader.e(this.mByteBuffer.getShort());
        }

        public void skip(int i11) throws IOException {
            while (i11 > 0) {
                int skip = (int) this.mInputStream.skip((long) i11);
                if (skip >= 1) {
                    i11 -= skip;
                    this.mPosition += (long) skip;
                } else {
                    throw new IOException("Skip didn't move at least 1 byte forward");
                }
            }
        }
    }

    public static class OffsetInfo {
        private final long mLength;
        private final long mStartOffset;

        public OffsetInfo(long j11, long j12) {
            this.mStartOffset = j11;
            this.mLength = j12;
        }

        public long a() {
            return this.mLength;
        }

        public long b() {
            return this.mStartOffset;
        }
    }

    public interface OpenTypeReader {
        public static final int UINT16_BYTE_COUNT = 2;
        public static final int UINT32_BYTE_COUNT = 4;

        long getPosition();

        int readTag() throws IOException;

        long readUnsignedInt() throws IOException;

        int readUnsignedShort() throws IOException;

        void skip(int i11) throws IOException;
    }

    private MetadataListReader() {
    }

    public static MetadataList a(AssetManager assetManager, String str) throws IOException {
        InputStream open = assetManager.open(str);
        try {
            MetadataList b11 = b(open);
            if (open != null) {
                open.close();
            }
            return b11;
        } catch (Throwable th2) {
            th.addSuppressed(th2);
        }
        throw th;
    }

    public static MetadataList b(InputStream inputStream) throws IOException {
        InputStreamOpenTypeReader inputStreamOpenTypeReader = new InputStreamOpenTypeReader(inputStream);
        OffsetInfo findOffsetInfo = findOffsetInfo(inputStreamOpenTypeReader);
        inputStreamOpenTypeReader.skip((int) (findOffsetInfo.b() - inputStreamOpenTypeReader.getPosition()));
        ByteBuffer allocate = ByteBuffer.allocate((int) findOffsetInfo.a());
        int read = inputStream.read(allocate.array());
        if (((long) read) == findOffsetInfo.a()) {
            return MetadataList.getRootAsMetadataList(allocate);
        }
        throw new IOException("Needed " + findOffsetInfo.a() + " bytes, got " + read);
    }

    public static MetadataList c(ByteBuffer byteBuffer) throws IOException {
        ByteBuffer duplicate = byteBuffer.duplicate();
        duplicate.position((int) findOffsetInfo(new ByteBufferReader(duplicate)).b());
        return MetadataList.getRootAsMetadataList(duplicate);
    }

    public static long d(int i11) {
        return ((long) i11) & 4294967295L;
    }

    public static int e(short s11) {
        return s11 & UShort.MAX_VALUE;
    }

    private static OffsetInfo findOffsetInfo(OpenTypeReader openTypeReader) throws IOException {
        long j11;
        openTypeReader.skip(4);
        int readUnsignedShort = openTypeReader.readUnsignedShort();
        if (readUnsignedShort <= 100) {
            openTypeReader.skip(6);
            int i11 = 0;
            while (true) {
                if (i11 >= readUnsignedShort) {
                    j11 = -1;
                    break;
                }
                int readTag = openTypeReader.readTag();
                openTypeReader.skip(4);
                j11 = openTypeReader.readUnsignedInt();
                openTypeReader.skip(4);
                if (1835365473 == readTag) {
                    break;
                }
                i11++;
            }
            if (j11 != -1) {
                openTypeReader.skip((int) (j11 - openTypeReader.getPosition()));
                openTypeReader.skip(12);
                long readUnsignedInt = openTypeReader.readUnsignedInt();
                for (int i12 = 0; ((long) i12) < readUnsignedInt; i12++) {
                    int readTag2 = openTypeReader.readTag();
                    long readUnsignedInt2 = openTypeReader.readUnsignedInt();
                    long readUnsignedInt3 = openTypeReader.readUnsignedInt();
                    if (EMJI_TAG == readTag2 || EMJI_TAG_DEPRECATED == readTag2) {
                        return new OffsetInfo(readUnsignedInt2 + j11, readUnsignedInt3);
                    }
                }
            }
            throw new IOException("Cannot read metadata.");
        }
        throw new IOException("Cannot read metadata.");
    }
}
