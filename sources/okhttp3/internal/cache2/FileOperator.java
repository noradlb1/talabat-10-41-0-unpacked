package okhttp3.internal.cache2;

import java.io.IOException;
import java.nio.channels.FileChannel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\bJ\u001e\u0010\f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lokhttp3/internal/cache2/FileOperator;", "", "fileChannel", "Ljava/nio/channels/FileChannel;", "(Ljava/nio/channels/FileChannel;)V", "read", "", "pos", "", "sink", "Lokio/Buffer;", "byteCount", "write", "source", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FileOperator {
    @NotNull
    private final FileChannel fileChannel;

    public FileOperator(@NotNull FileChannel fileChannel2) {
        Intrinsics.checkNotNullParameter(fileChannel2, "fileChannel");
        this.fileChannel = fileChannel2;
    }

    public final void read(long j11, @NotNull Buffer buffer, long j12) {
        Intrinsics.checkNotNullParameter(buffer, "sink");
        if (j12 >= 0) {
            while (j12 > 0) {
                long transferTo = this.fileChannel.transferTo(j11, j12, buffer);
                j11 += transferTo;
                j12 -= transferTo;
            }
            return;
        }
        throw new IndexOutOfBoundsException();
    }

    public final void write(long j11, @NotNull Buffer buffer, long j12) throws IOException {
        Intrinsics.checkNotNullParameter(buffer, "source");
        if (j12 < 0 || j12 > buffer.size()) {
            throw new IndexOutOfBoundsException();
        }
        while (j12 > 0) {
            long transferFrom = this.fileChannel.transferFrom(buffer, j11, j12);
            j11 += transferFrom;
            j12 -= transferFrom;
        }
    }
}
