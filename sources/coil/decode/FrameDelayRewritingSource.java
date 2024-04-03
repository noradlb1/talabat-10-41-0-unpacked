package coil.decode;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.bytebuddy.implementation.MethodDelegation;
import okio.Buffer;
import okio.ByteString;
import okio.ForwardingSource;
import okio.Source;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0018\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\bH\u0016J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\bH\u0002J\u0018\u0010\u0010\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\bH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcoil/decode/FrameDelayRewritingSource;", "Lokio/ForwardingSource;", "delegate", "Lokio/Source;", "(Lokio/Source;)V", "buffer", "Lokio/Buffer;", "indexOf", "", "bytes", "Lokio/ByteString;", "read", "sink", "byteCount", "request", "", "write", "Companion", "coil-gif_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class FrameDelayRewritingSource extends ForwardingSource {
    @NotNull
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @Deprecated
    private static final int DEFAULT_FRAME_DELAY = 10;
    @NotNull
    @Deprecated
    private static final ByteString FRAME_DELAY_START_MARKER = ByteString.Companion.decodeHex("0021F904");
    @Deprecated
    private static final int FRAME_DELAY_START_MARKER_SIZE = 4;
    @Deprecated
    private static final int MINIMUM_FRAME_DELAY = 2;
    @NotNull
    private final Buffer buffer = new Buffer();

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcoil/decode/FrameDelayRewritingSource$Companion;", "", "()V", "DEFAULT_FRAME_DELAY", "", "FRAME_DELAY_START_MARKER", "Lokio/ByteString;", "FRAME_DELAY_START_MARKER_SIZE", "MINIMUM_FRAME_DELAY", "coil-gif_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FrameDelayRewritingSource(@NotNull Source source) {
        super(source);
        Intrinsics.checkNotNullParameter(source, MethodDelegation.ImplementationDelegate.FIELD_NAME_PREFIX);
    }

    private final long indexOf(ByteString byteString) {
        long j11 = -1;
        while (true) {
            j11 = this.buffer.indexOf(byteString.getByte(0), j11 + 1);
            if (j11 != -1 && (!request((long) byteString.size()) || !this.buffer.rangeEquals(j11, byteString))) {
            }
        }
        return j11;
    }

    private final boolean request(long j11) {
        if (this.buffer.size() >= j11) {
            return true;
        }
        long size = j11 - this.buffer.size();
        if (super.read(this.buffer, size) == size) {
            return true;
        }
        return false;
    }

    private final long write(Buffer buffer2, long j11) {
        return RangesKt___RangesKt.coerceAtLeast(this.buffer.read(buffer2, j11), 0);
    }

    public long read(@NotNull Buffer buffer2, long j11) {
        Intrinsics.checkNotNullParameter(buffer2, "sink");
        request(j11);
        if (this.buffer.size() != 0) {
            long j12 = 0;
            while (true) {
                long indexOf = indexOf(FRAME_DELAY_START_MARKER);
                if (indexOf == -1) {
                    break;
                }
                j12 += write(buffer2, indexOf + ((long) 4));
                if (request(5) && this.buffer.getByte(4) == 0 && this.buffer.getByte(1) < 2) {
                    buffer2.writeByte((int) this.buffer.getByte(0));
                    buffer2.writeByte(10);
                    buffer2.writeByte(0);
                    this.buffer.skip(3);
                }
            }
            if (j12 < j11) {
                j12 += write(buffer2, j11 - j12);
            }
            if (j12 == 0) {
                return -1;
            }
            return j12;
        } else if (j11 == 0) {
            return 0;
        } else {
            return -1;
        }
    }
}
