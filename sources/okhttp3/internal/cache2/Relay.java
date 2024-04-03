package okhttp3.internal.cache2;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.ByteString;
import okio.Source;
import okio.Timeout;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u0000 :2\u00020\u0001:\u0002:;B3\b\u0002\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0002\u0010\u000bJ\u000e\u00102\u001a\u0002032\u0006\u00104\u001a\u00020\u0007J\u0006\u0010\b\u001a\u00020\tJ\b\u00105\u001a\u0004\u0018\u00010\u0005J \u00106\u001a\u0002032\u0006\u00107\u001a\u00020\t2\u0006\u00104\u001a\u00020\u00072\u0006\u00108\u001a\u00020\u0007H\u0002J\u0010\u00109\u001a\u0002032\u0006\u00104\u001a\u00020\u0007H\u0002R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0011\u0010\u001c\u001a\u00020\u00138F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0015R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001d\u001a\u00020\u001eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u0011\u0010'\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u000fR\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0011\"\u0004\b*\u0010+R\u001c\u0010,\u001a\u0004\u0018\u00010-X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101¨\u0006<"}, d2 = {"Lokhttp3/internal/cache2/Relay;", "", "file", "Ljava/io/RandomAccessFile;", "upstream", "Lokio/Source;", "upstreamPos", "", "metadata", "Lokio/ByteString;", "bufferMaxSize", "(Ljava/io/RandomAccessFile;Lokio/Source;JLokio/ByteString;J)V", "buffer", "Lokio/Buffer;", "getBuffer", "()Lokio/Buffer;", "getBufferMaxSize", "()J", "complete", "", "getComplete", "()Z", "setComplete", "(Z)V", "getFile", "()Ljava/io/RandomAccessFile;", "setFile", "(Ljava/io/RandomAccessFile;)V", "isClosed", "sourceCount", "", "getSourceCount", "()I", "setSourceCount", "(I)V", "getUpstream", "()Lokio/Source;", "setUpstream", "(Lokio/Source;)V", "upstreamBuffer", "getUpstreamBuffer", "getUpstreamPos", "setUpstreamPos", "(J)V", "upstreamReader", "Ljava/lang/Thread;", "getUpstreamReader", "()Ljava/lang/Thread;", "setUpstreamReader", "(Ljava/lang/Thread;)V", "commit", "", "upstreamSize", "newSource", "writeHeader", "prefix", "metadataSize", "writeMetadata", "Companion", "RelaySource", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class Relay {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final long FILE_HEADER_SIZE = 32;
    @NotNull
    @JvmField
    public static final ByteString PREFIX_CLEAN;
    @NotNull
    @JvmField
    public static final ByteString PREFIX_DIRTY;
    private static final int SOURCE_FILE = 2;
    private static final int SOURCE_UPSTREAM = 1;
    @NotNull
    private final Buffer buffer;
    private final long bufferMaxSize;
    private boolean complete;
    @Nullable
    private RandomAccessFile file;
    @NotNull
    private final ByteString metadata;
    private int sourceCount;
    @Nullable
    private Source upstream;
    @NotNull
    private final Buffer upstreamBuffer;
    private long upstreamPos;
    @Nullable
    private Thread upstreamReader;

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0004J\u000e\u0010\u0013\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tXT¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lokhttp3/internal/cache2/Relay$Companion;", "", "()V", "FILE_HEADER_SIZE", "", "PREFIX_CLEAN", "Lokio/ByteString;", "PREFIX_DIRTY", "SOURCE_FILE", "", "SOURCE_UPSTREAM", "edit", "Lokhttp3/internal/cache2/Relay;", "file", "Ljava/io/File;", "upstream", "Lokio/Source;", "metadata", "bufferMaxSize", "read", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final Relay edit(@NotNull File file, @NotNull Source source, @NotNull ByteString byteString, long j11) throws IOException {
            Intrinsics.checkNotNullParameter(file, "file");
            Intrinsics.checkNotNullParameter(source, "upstream");
            Intrinsics.checkNotNullParameter(byteString, TtmlNode.TAG_METADATA);
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            Relay relay = new Relay(randomAccessFile, source, 0, byteString, j11, (DefaultConstructorMarker) null);
            randomAccessFile.setLength(0);
            relay.writeHeader(Relay.PREFIX_DIRTY, -1, -1);
            return relay;
        }

        @NotNull
        public final Relay read(@NotNull File file) throws IOException {
            Intrinsics.checkNotNullParameter(file, "file");
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            FileChannel channel = randomAccessFile.getChannel();
            Intrinsics.checkNotNullExpressionValue(channel, "randomAccessFile.channel");
            FileOperator fileOperator = new FileOperator(channel);
            Buffer buffer = new Buffer();
            fileOperator.read(0, buffer, 32);
            ByteString byteString = Relay.PREFIX_CLEAN;
            if (Intrinsics.areEqual((Object) buffer.readByteString((long) byteString.size()), (Object) byteString)) {
                long readLong = buffer.readLong();
                long readLong2 = buffer.readLong();
                Buffer buffer2 = new Buffer();
                fileOperator.read(readLong + 32, buffer2, readLong2);
                return new Relay(randomAccessFile, (Source) null, readLong, buffer2.readByteString(), 0, (DefaultConstructorMarker) null);
            }
            throw new IOException("unreadable cache file");
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lokhttp3/internal/cache2/Relay$RelaySource;", "Lokio/Source;", "(Lokhttp3/internal/cache2/Relay;)V", "fileOperator", "Lokhttp3/internal/cache2/FileOperator;", "sourcePos", "", "timeout", "Lokio/Timeout;", "close", "", "read", "sink", "Lokio/Buffer;", "byteCount", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public final class RelaySource implements Source {
        @Nullable
        private FileOperator fileOperator;
        private long sourcePos;
        final /* synthetic */ Relay this$0;
        @NotNull
        private final Timeout timeout = new Timeout();

        public RelaySource(Relay relay) {
            Intrinsics.checkNotNullParameter(relay, "this$0");
            this.this$0 = relay;
            RandomAccessFile file = relay.getFile();
            Intrinsics.checkNotNull(file);
            FileChannel channel = file.getChannel();
            Intrinsics.checkNotNullExpressionValue(channel, "file!!.channel");
            this.fileOperator = new FileOperator(channel);
        }

        public void close() throws IOException {
            if (this.fileOperator != null) {
                RandomAccessFile randomAccessFile = null;
                this.fileOperator = null;
                Relay relay = this.this$0;
                synchronized (relay) {
                    relay.setSourceCount(relay.getSourceCount() - 1);
                    if (relay.getSourceCount() == 0) {
                        RandomAccessFile file = relay.getFile();
                        relay.setFile((RandomAccessFile) null);
                        randomAccessFile = file;
                    }
                    Unit unit = Unit.INSTANCE;
                }
                if (randomAccessFile != null) {
                    Util.closeQuietly((Closeable) randomAccessFile);
                }
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:28:0x0079, code lost:
            if (r4 != true) goto L_0x009c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x007b, code lost:
            r8 = java.lang.Math.min(r2, r1.this$0.getUpstreamPos() - r1.sourcePos);
            r2 = r1.fileOperator;
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2);
            r2.read(r1.sourcePos + 32, r20, r8);
            r1.sourcePos += r8;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x009b, code lost:
            return r8;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:?, code lost:
            r0 = r1.this$0.getUpstream();
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0);
            r14 = r0.read(r1.this$0.getUpstreamBuffer(), r1.this$0.getBufferMaxSize());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:0x00b8, code lost:
            if (r14 != -1) goto L_0x00d3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:0x00ba, code lost:
            r0 = r1.this$0;
            r0.commit(r0.getUpstreamPos());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:0x00c3, code lost:
            r2 = r1.this$0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:37:0x00c5, code lost:
            monitor-enter(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:39:?, code lost:
            r2.setUpstreamReader((java.lang.Thread) null);
            r2.notifyAll();
            r0 = kotlin.Unit.INSTANCE;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:40:0x00ce, code lost:
            monitor-exit(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:41:0x00cf, code lost:
            return -1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:46:?, code lost:
            r9 = java.lang.Math.min(r14, r2);
            r1.this$0.getUpstreamBuffer().copyTo(r20, 0, r9);
            r1.sourcePos += r9;
            r13 = r1.fileOperator;
            kotlin.jvm.internal.Intrinsics.checkNotNull(r13);
            r4 = r14;
            r13.write(r1.this$0.getUpstreamPos() + 32, r1.this$0.getUpstreamBuffer().clone(), r4);
            r2 = r1.this$0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:47:0x010a, code lost:
            monitor-enter(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:49:?, code lost:
            r2.getBuffer().write(r2.getUpstreamBuffer(), r4);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:50:0x0124, code lost:
            if (r2.getBuffer().size() <= r2.getBufferMaxSize()) goto L_0x013a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:51:0x0126, code lost:
            r2.getBuffer().skip(r2.getBuffer().size() - r2.getBufferMaxSize());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:52:0x013a, code lost:
            r2.setUpstreamPos(r2.getUpstreamPos() + r4);
            r0 = kotlin.Unit.INSTANCE;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:54:?, code lost:
            monitor-exit(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:55:0x0145, code lost:
            r2 = r1.this$0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:56:0x0147, code lost:
            monitor-enter(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:58:?, code lost:
            r2.setUpstreamReader((java.lang.Thread) null);
            r2.notifyAll();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:59:0x014e, code lost:
            monitor-exit(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:60:0x014f, code lost:
            return r9;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:68:0x0156, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:69:0x0157, code lost:
            r2 = r1.this$0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:70:0x0159, code lost:
            monitor-enter(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:72:?, code lost:
            r2.setUpstreamReader((java.lang.Thread) null);
            r2.notifyAll();
            r3 = kotlin.Unit.INSTANCE;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:74:0x0163, code lost:
            throw r0;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public long read(@org.jetbrains.annotations.NotNull okio.Buffer r20, long r21) throws java.io.IOException {
            /*
                r19 = this;
                r1 = r19
                r2 = r21
                java.lang.String r0 = "sink"
                r5 = r20
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
                okhttp3.internal.cache2.FileOperator r0 = r1.fileOperator
                r4 = 1
                if (r0 == 0) goto L_0x0012
                r0 = r4
                goto L_0x0013
            L_0x0012:
                r0 = 0
            L_0x0013:
                if (r0 == 0) goto L_0x016a
                okhttp3.internal.cache2.Relay r8 = r1.this$0
                monitor-enter(r8)
            L_0x0018:
                long r6 = r8.getUpstreamPos()     // Catch:{ all -> 0x0167 }
                long r9 = r1.sourcePos     // Catch:{ all -> 0x0167 }
                int r0 = (r9 > r6 ? 1 : (r9 == r6 ? 0 : -1))
                r6 = 2
                r9 = -1
                if (r0 == 0) goto L_0x005b
                long r11 = r8.getUpstreamPos()     // Catch:{ all -> 0x0167 }
                okio.Buffer r0 = r8.getBuffer()     // Catch:{ all -> 0x0167 }
                long r13 = r0.size()     // Catch:{ all -> 0x0167 }
                long r11 = r11 - r13
                long r13 = r1.sourcePos     // Catch:{ all -> 0x0167 }
                int r0 = (r13 > r11 ? 1 : (r13 == r11 ? 0 : -1))
                if (r0 >= 0) goto L_0x003a
                r4 = r6
                goto L_0x0076
            L_0x003a:
                long r6 = r8.getUpstreamPos()     // Catch:{ all -> 0x0167 }
                long r9 = r1.sourcePos     // Catch:{ all -> 0x0167 }
                long r6 = r6 - r9
                long r9 = java.lang.Math.min(r2, r6)     // Catch:{ all -> 0x0167 }
                okio.Buffer r2 = r8.getBuffer()     // Catch:{ all -> 0x0167 }
                long r3 = r1.sourcePos     // Catch:{ all -> 0x0167 }
                long r6 = r3 - r11
                r3 = r20
                r4 = r6
                r6 = r9
                r2.copyTo((okio.Buffer) r3, (long) r4, (long) r6)     // Catch:{ all -> 0x0167 }
                long r2 = r1.sourcePos     // Catch:{ all -> 0x0167 }
                long r2 = r2 + r9
                r1.sourcePos = r2     // Catch:{ all -> 0x0167 }
                monitor-exit(r8)
                return r9
            L_0x005b:
                boolean r0 = r8.getComplete()     // Catch:{ all -> 0x0167 }
                if (r0 == 0) goto L_0x0063
                monitor-exit(r8)
                return r9
            L_0x0063:
                java.lang.Thread r0 = r8.getUpstreamReader()     // Catch:{ all -> 0x0167 }
                if (r0 == 0) goto L_0x006f
                okio.Timeout r0 = r1.timeout     // Catch:{ all -> 0x0167 }
                r0.waitUntilNotified(r8)     // Catch:{ all -> 0x0167 }
                goto L_0x0018
            L_0x006f:
                java.lang.Thread r0 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0167 }
                r8.setUpstreamReader(r0)     // Catch:{ all -> 0x0167 }
            L_0x0076:
                monitor-exit(r8)
                r11 = 32
                if (r4 != r6) goto L_0x009c
                okhttp3.internal.cache2.Relay r0 = r1.this$0
                long r6 = r0.getUpstreamPos()
                long r8 = r1.sourcePos
                long r6 = r6 - r8
                long r8 = java.lang.Math.min(r2, r6)
                okhttp3.internal.cache2.FileOperator r2 = r1.fileOperator
                kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
                long r3 = r1.sourcePos
                long r3 = r3 + r11
                r5 = r20
                r6 = r8
                r2.read(r3, r5, r6)
                long r2 = r1.sourcePos
                long r2 = r2 + r8
                r1.sourcePos = r2
                return r8
            L_0x009c:
                r8 = 0
                okhttp3.internal.cache2.Relay r0 = r1.this$0     // Catch:{ all -> 0x0156 }
                okio.Source r0 = r0.getUpstream()     // Catch:{ all -> 0x0156 }
                kotlin.jvm.internal.Intrinsics.checkNotNull(r0)     // Catch:{ all -> 0x0156 }
                okhttp3.internal.cache2.Relay r4 = r1.this$0     // Catch:{ all -> 0x0156 }
                okio.Buffer r4 = r4.getUpstreamBuffer()     // Catch:{ all -> 0x0156 }
                okhttp3.internal.cache2.Relay r6 = r1.this$0     // Catch:{ all -> 0x0156 }
                long r6 = r6.getBufferMaxSize()     // Catch:{ all -> 0x0156 }
                long r14 = r0.read(r4, r6)     // Catch:{ all -> 0x0156 }
                int r0 = (r14 > r9 ? 1 : (r14 == r9 ? 0 : -1))
                if (r0 != 0) goto L_0x00d3
                okhttp3.internal.cache2.Relay r0 = r1.this$0     // Catch:{ all -> 0x0156 }
                long r2 = r0.getUpstreamPos()     // Catch:{ all -> 0x0156 }
                r0.commit(r2)     // Catch:{ all -> 0x0156 }
                okhttp3.internal.cache2.Relay r2 = r1.this$0
                monitor-enter(r2)
                r2.setUpstreamReader(r8)     // Catch:{ all -> 0x00d0 }
                r2.notifyAll()     // Catch:{ all -> 0x00d0 }
                kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x00d0 }
                monitor-exit(r2)
                return r9
            L_0x00d0:
                r0 = move-exception
                monitor-exit(r2)
                throw r0
            L_0x00d3:
                long r9 = java.lang.Math.min(r14, r2)     // Catch:{ all -> 0x0156 }
                okhttp3.internal.cache2.Relay r0 = r1.this$0     // Catch:{ all -> 0x0156 }
                okio.Buffer r2 = r0.getUpstreamBuffer()     // Catch:{ all -> 0x0156 }
                r6 = 0
                r3 = r20
                r4 = r6
                r6 = r9
                r2.copyTo((okio.Buffer) r3, (long) r4, (long) r6)     // Catch:{ all -> 0x0156 }
                long r2 = r1.sourcePos     // Catch:{ all -> 0x0156 }
                long r2 = r2 + r9
                r1.sourcePos = r2     // Catch:{ all -> 0x0156 }
                okhttp3.internal.cache2.FileOperator r13 = r1.fileOperator     // Catch:{ all -> 0x0156 }
                kotlin.jvm.internal.Intrinsics.checkNotNull(r13)     // Catch:{ all -> 0x0156 }
                okhttp3.internal.cache2.Relay r0 = r1.this$0     // Catch:{ all -> 0x0156 }
                long r2 = r0.getUpstreamPos()     // Catch:{ all -> 0x0156 }
                long r2 = r2 + r11
                okhttp3.internal.cache2.Relay r0 = r1.this$0     // Catch:{ all -> 0x0156 }
                okio.Buffer r0 = r0.getUpstreamBuffer()     // Catch:{ all -> 0x0156 }
                okio.Buffer r16 = r0.clone()     // Catch:{ all -> 0x0156 }
                r4 = r14
                r14 = r2
                r17 = r4
                r13.write(r14, r16, r17)     // Catch:{ all -> 0x0156 }
                okhttp3.internal.cache2.Relay r2 = r1.this$0     // Catch:{ all -> 0x0156 }
                monitor-enter(r2)     // Catch:{ all -> 0x0156 }
                okio.Buffer r0 = r2.getBuffer()     // Catch:{ all -> 0x0153 }
                okio.Buffer r3 = r2.getUpstreamBuffer()     // Catch:{ all -> 0x0153 }
                r0.write((okio.Buffer) r3, (long) r4)     // Catch:{ all -> 0x0153 }
                okio.Buffer r0 = r2.getBuffer()     // Catch:{ all -> 0x0153 }
                long r6 = r0.size()     // Catch:{ all -> 0x0153 }
                long r11 = r2.getBufferMaxSize()     // Catch:{ all -> 0x0153 }
                int r0 = (r6 > r11 ? 1 : (r6 == r11 ? 0 : -1))
                if (r0 <= 0) goto L_0x013a
                okio.Buffer r0 = r2.getBuffer()     // Catch:{ all -> 0x0153 }
                okio.Buffer r3 = r2.getBuffer()     // Catch:{ all -> 0x0153 }
                long r6 = r3.size()     // Catch:{ all -> 0x0153 }
                long r11 = r2.getBufferMaxSize()     // Catch:{ all -> 0x0153 }
                long r6 = r6 - r11
                r0.skip(r6)     // Catch:{ all -> 0x0153 }
            L_0x013a:
                long r6 = r2.getUpstreamPos()     // Catch:{ all -> 0x0153 }
                long r6 = r6 + r4
                r2.setUpstreamPos(r6)     // Catch:{ all -> 0x0153 }
                kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0153 }
                monitor-exit(r2)     // Catch:{ all -> 0x0156 }
                okhttp3.internal.cache2.Relay r2 = r1.this$0
                monitor-enter(r2)
                r2.setUpstreamReader(r8)     // Catch:{ all -> 0x0150 }
                r2.notifyAll()     // Catch:{ all -> 0x0150 }
                monitor-exit(r2)
                return r9
            L_0x0150:
                r0 = move-exception
                monitor-exit(r2)
                throw r0
            L_0x0153:
                r0 = move-exception
                monitor-exit(r2)     // Catch:{ all -> 0x0156 }
                throw r0     // Catch:{ all -> 0x0156 }
            L_0x0156:
                r0 = move-exception
                okhttp3.internal.cache2.Relay r2 = r1.this$0
                monitor-enter(r2)
                r2.setUpstreamReader(r8)     // Catch:{ all -> 0x0164 }
                r2.notifyAll()     // Catch:{ all -> 0x0164 }
                kotlin.Unit r3 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0164 }
                monitor-exit(r2)
                throw r0
            L_0x0164:
                r0 = move-exception
                monitor-exit(r2)
                throw r0
            L_0x0167:
                r0 = move-exception
                monitor-exit(r8)
                throw r0
            L_0x016a:
                java.lang.String r0 = "Check failed."
                java.lang.IllegalStateException r2 = new java.lang.IllegalStateException
                java.lang.String r0 = r0.toString()
                r2.<init>(r0)
                throw r2
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.cache2.Relay.RelaySource.read(okio.Buffer, long):long");
        }

        @NotNull
        public Timeout timeout() {
            return this.timeout;
        }
    }

    static {
        ByteString.Companion companion = ByteString.Companion;
        PREFIX_CLEAN = companion.encodeUtf8("OkHttp cache v1\n");
        PREFIX_DIRTY = companion.encodeUtf8("OkHttp DIRTY :(\n");
    }

    private Relay(RandomAccessFile randomAccessFile, Source source, long j11, ByteString byteString, long j12) {
        boolean z11;
        this.file = randomAccessFile;
        this.upstream = source;
        this.upstreamPos = j11;
        this.metadata = byteString;
        this.bufferMaxSize = j12;
        this.upstreamBuffer = new Buffer();
        if (this.upstream == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        this.complete = z11;
        this.buffer = new Buffer();
    }

    public /* synthetic */ Relay(RandomAccessFile randomAccessFile, Source source, long j11, ByteString byteString, long j12, DefaultConstructorMarker defaultConstructorMarker) {
        this(randomAccessFile, source, j11, byteString, j12);
    }

    /* access modifiers changed from: private */
    public final void writeHeader(ByteString byteString, long j11, long j12) throws IOException {
        boolean z11;
        Buffer buffer2 = new Buffer();
        buffer2.write(byteString);
        buffer2.writeLong(j11);
        buffer2.writeLong(j12);
        if (buffer2.size() == 32) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            RandomAccessFile randomAccessFile = this.file;
            Intrinsics.checkNotNull(randomAccessFile);
            FileChannel channel = randomAccessFile.getChannel();
            Intrinsics.checkNotNullExpressionValue(channel, "file!!.channel");
            new FileOperator(channel).write(0, buffer2, 32);
            return;
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    private final void writeMetadata(long j11) throws IOException {
        Buffer buffer2 = new Buffer();
        buffer2.write(this.metadata);
        RandomAccessFile randomAccessFile = this.file;
        Intrinsics.checkNotNull(randomAccessFile);
        FileChannel channel = randomAccessFile.getChannel();
        Intrinsics.checkNotNullExpressionValue(channel, "file!!.channel");
        new FileOperator(channel).write(32 + j11, buffer2, (long) this.metadata.size());
    }

    public final void commit(long j11) throws IOException {
        writeMetadata(j11);
        RandomAccessFile randomAccessFile = this.file;
        Intrinsics.checkNotNull(randomAccessFile);
        randomAccessFile.getChannel().force(false);
        writeHeader(PREFIX_CLEAN, j11, (long) this.metadata.size());
        RandomAccessFile randomAccessFile2 = this.file;
        Intrinsics.checkNotNull(randomAccessFile2);
        randomAccessFile2.getChannel().force(false);
        synchronized (this) {
            setComplete(true);
            Unit unit = Unit.INSTANCE;
        }
        Source source = this.upstream;
        if (source != null) {
            Util.closeQuietly((Closeable) source);
        }
        this.upstream = null;
    }

    @NotNull
    public final Buffer getBuffer() {
        return this.buffer;
    }

    public final long getBufferMaxSize() {
        return this.bufferMaxSize;
    }

    public final boolean getComplete() {
        return this.complete;
    }

    @Nullable
    public final RandomAccessFile getFile() {
        return this.file;
    }

    public final int getSourceCount() {
        return this.sourceCount;
    }

    @Nullable
    public final Source getUpstream() {
        return this.upstream;
    }

    @NotNull
    public final Buffer getUpstreamBuffer() {
        return this.upstreamBuffer;
    }

    public final long getUpstreamPos() {
        return this.upstreamPos;
    }

    @Nullable
    public final Thread getUpstreamReader() {
        return this.upstreamReader;
    }

    public final boolean isClosed() {
        return this.file == null;
    }

    @NotNull
    public final ByteString metadata() {
        return this.metadata;
    }

    @Nullable
    public final Source newSource() {
        synchronized (this) {
            if (getFile() == null) {
                return null;
            }
            setSourceCount(getSourceCount() + 1);
            return new RelaySource(this);
        }
    }

    public final void setComplete(boolean z11) {
        this.complete = z11;
    }

    public final void setFile(@Nullable RandomAccessFile randomAccessFile) {
        this.file = randomAccessFile;
    }

    public final void setSourceCount(int i11) {
        this.sourceCount = i11;
    }

    public final void setUpstream(@Nullable Source source) {
        this.upstream = source;
    }

    public final void setUpstreamPos(long j11) {
        this.upstreamPos = j11;
    }

    public final void setUpstreamReader(@Nullable Thread thread) {
        this.upstreamReader = thread;
    }
}
