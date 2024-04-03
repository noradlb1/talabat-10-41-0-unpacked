package okio.internal;

import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.bytebuddy.implementation.MethodDelegation;
import okio.Buffer;
import okio.ForwardingSource;
import okio.Source;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0018\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0005H\u0016J\u0014\u0010\u000e\u001a\u00020\u000f*\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0005H\u0002R\u000e\u0010\t\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lokio/internal/FixedLengthSource;", "Lokio/ForwardingSource;", "delegate", "Lokio/Source;", "size", "", "truncate", "", "(Lokio/Source;JZ)V", "bytesReceived", "read", "sink", "Lokio/Buffer;", "byteCount", "truncateToSize", "", "newSize", "okio"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class FixedLengthSource extends ForwardingSource {
    private long bytesReceived;
    private final long size;
    private final boolean truncate;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FixedLengthSource(@NotNull Source source, long j11, boolean z11) {
        super(source);
        Intrinsics.checkNotNullParameter(source, MethodDelegation.ImplementationDelegate.FIELD_NAME_PREFIX);
        this.size = j11;
        this.truncate = z11;
    }

    private final void truncateToSize(Buffer buffer, long j11) {
        Buffer buffer2 = new Buffer();
        buffer2.writeAll(buffer);
        buffer.write(buffer2, j11);
        buffer2.clear();
    }

    public long read(@NotNull Buffer buffer, long j11) {
        Intrinsics.checkNotNullParameter(buffer, "sink");
        long j12 = this.bytesReceived;
        long j13 = this.size;
        if (j12 > j13) {
            j11 = 0;
        } else if (this.truncate) {
            long j14 = j13 - j12;
            if (j14 == 0) {
                return -1;
            }
            j11 = Math.min(j11, j14);
        }
        long read = super.read(buffer, j11);
        int i11 = (read > -1 ? 1 : (read == -1 ? 0 : -1));
        if (i11 != 0) {
            this.bytesReceived += read;
        }
        long j15 = this.bytesReceived;
        long j16 = this.size;
        if ((j15 >= j16 || i11 != 0) && j15 <= j16) {
            return read;
        }
        if (read > 0 && j15 > j16) {
            truncateToSize(buffer, buffer.size() - (this.bytesReceived - this.size));
        }
        throw new IOException("expected " + this.size + " bytes but got " + this.bytesReceived);
    }
}
