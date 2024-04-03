package okio;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.IOException;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016J \u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0003H\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"}, d2 = {"okio/RealBufferedSource$inputStream$1", "Ljava/io/InputStream;", "available", "", "close", "", "read", "data", "", "offset", "byteCount", "toString", "", "okio"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class RealBufferedSource$inputStream$1 extends InputStream {
    final /* synthetic */ RealBufferedSource this$0;

    public RealBufferedSource$inputStream$1(RealBufferedSource realBufferedSource) {
        this.this$0 = realBufferedSource;
    }

    public int available() {
        RealBufferedSource realBufferedSource = this.this$0;
        if (!realBufferedSource.closed) {
            return (int) Math.min(realBufferedSource.bufferField.size(), (long) Integer.MAX_VALUE);
        }
        throw new IOException("closed");
    }

    public void close() {
        this.this$0.close();
    }

    public int read() {
        RealBufferedSource realBufferedSource = this.this$0;
        if (!realBufferedSource.closed) {
            if (realBufferedSource.bufferField.size() == 0) {
                RealBufferedSource realBufferedSource2 = this.this$0;
                if (realBufferedSource2.source.read(realBufferedSource2.bufferField, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                    return -1;
                }
            }
            return this.this$0.bufferField.readByte() & 255;
        }
        throw new IOException("closed");
    }

    @NotNull
    public String toString() {
        return this.this$0 + ".inputStream()";
    }

    public int read(@NotNull byte[] bArr, int i11, int i12) {
        Intrinsics.checkNotNullParameter(bArr, "data");
        if (!this.this$0.closed) {
            _UtilKt.checkOffsetAndCount((long) bArr.length, (long) i11, (long) i12);
            if (this.this$0.bufferField.size() == 0) {
                RealBufferedSource realBufferedSource = this.this$0;
                if (realBufferedSource.source.read(realBufferedSource.bufferField, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                    return -1;
                }
            }
            return this.this$0.bufferField.read(bArr, i11, i12);
        }
        throw new IOException("closed");
    }
}
