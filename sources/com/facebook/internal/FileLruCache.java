package com.facebook.internal;

import com.facebook.FacebookSdk;
import com.facebook.LoggingBehavior;
import com.facebook.internal.Logger;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.InvalidParameterException;
import java.util.Date;
import java.util.PriorityQueue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
import v6.j;
import v6.k;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u000b\u0018\u0000 )2\u00020\u0001:\b'()*+,-.B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u0016\u001a\u00020\u0017J\u001f\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u00032\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0003H\u0002J\u0016\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u0019J\u001c\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u001a\u001a\u00020\u00032\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0003H\u0007J\b\u0010 \u001a\u00020\u0017H\u0002J\u0018\u0010!\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020\u000bH\u0002J\u0006\u0010#\u001a\u00020$J\b\u0010%\u001a\u00020\u0003H\u0016J\b\u0010&\u001a\u00020\u0017H\u0002R\u0016\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0011\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lcom/facebook/internal/FileLruCache;", "", "tag", "", "limits", "Lcom/facebook/internal/FileLruCache$Limits;", "(Ljava/lang/String;Lcom/facebook/internal/FileLruCache$Limits;)V", "condition", "Ljava/util/concurrent/locks/Condition;", "kotlin.jvm.PlatformType", "directory", "Ljava/io/File;", "isTrimInProgress", "", "isTrimPending", "lastClearCacheTime", "Ljava/util/concurrent/atomic/AtomicLong;", "location", "getLocation", "()Ljava/lang/String;", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "clearCache", "", "get", "Ljava/io/InputStream;", "key", "contentTag", "interceptAndPut", "input", "openPutStream", "Ljava/io/OutputStream;", "postTrim", "renameToTargetAndTrim", "buffer", "sizeInBytesForTest", "", "toString", "trim", "BufferFile", "CloseCallbackOutputStream", "Companion", "CopyingInputStream", "Limits", "ModifiedFile", "StreamCloseCallback", "StreamHeader", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class FileLruCache {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String HEADER_CACHEKEY_KEY = "key";
    @NotNull
    private static final String HEADER_CACHE_CONTENT_TAG_KEY = "tag";
    /* access modifiers changed from: private */
    public static final String TAG = FileLruCache.class.getSimpleName();
    /* access modifiers changed from: private */
    @NotNull
    public static final AtomicLong bufferIndex = new AtomicLong();
    private final Condition condition;
    @NotNull
    private final File directory;
    private boolean isTrimInProgress;
    private boolean isTrimPending;
    /* access modifiers changed from: private */
    @NotNull
    public final AtomicLong lastClearCacheTime = new AtomicLong(0);
    @NotNull
    private final Limits limits;
    @NotNull
    private final ReentrantLock lock;
    @NotNull
    private final String tag;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u0006\u0010\f\u001a\u00020\u0006J\u0006\u0010\r\u001a\u00020\u0006J\u0010\u0010\u000e\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u000bR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/facebook/internal/FileLruCache$BufferFile;", "", "()V", "FILE_NAME_PREFIX", "", "filterExcludeBufferFiles", "Ljava/io/FilenameFilter;", "filterExcludeNonBufferFiles", "deleteAll", "", "root", "Ljava/io/File;", "excludeBufferFiles", "excludeNonBufferFiles", "newFile", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class BufferFile {
        @NotNull
        private static final String FILE_NAME_PREFIX = "buffer";
        @NotNull
        public static final BufferFile INSTANCE = new BufferFile();
        @NotNull
        private static final FilenameFilter filterExcludeBufferFiles = new a();
        @NotNull
        private static final FilenameFilter filterExcludeNonBufferFiles = new b();

        private BufferFile() {
        }

        /* access modifiers changed from: private */
        /* renamed from: filterExcludeBufferFiles$lambda-0  reason: not valid java name */
        public static final boolean m8957filterExcludeBufferFiles$lambda0(File file, String str) {
            Intrinsics.checkNotNullExpressionValue(str, "filename");
            return !StringsKt__StringsJVMKt.startsWith$default(str, FILE_NAME_PREFIX, false, 2, (Object) null);
        }

        /* access modifiers changed from: private */
        /* renamed from: filterExcludeNonBufferFiles$lambda-1  reason: not valid java name */
        public static final boolean m8958filterExcludeNonBufferFiles$lambda1(File file, String str) {
            Intrinsics.checkNotNullExpressionValue(str, "filename");
            return StringsKt__StringsJVMKt.startsWith$default(str, FILE_NAME_PREFIX, false, 2, (Object) null);
        }

        public final void deleteAll(@NotNull File file) {
            Intrinsics.checkNotNullParameter(file, "root");
            File[] listFiles = file.listFiles(excludeNonBufferFiles());
            if (listFiles != null) {
                int length = listFiles.length;
                int i11 = 0;
                while (i11 < length) {
                    File file2 = listFiles[i11];
                    i11++;
                    file2.delete();
                }
            }
        }

        @NotNull
        public final FilenameFilter excludeBufferFiles() {
            return filterExcludeBufferFiles;
        }

        @NotNull
        public final FilenameFilter excludeNonBufferFiles() {
            return filterExcludeNonBufferFiles;
        }

        @NotNull
        public final File newFile(@Nullable File file) {
            return new File(file, Intrinsics.stringPlus(FILE_NAME_PREFIX, Long.valueOf(FileLruCache.bufferIndex.incrementAndGet())));
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J \u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u0010\u0010\r\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0011H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/facebook/internal/FileLruCache$CloseCallbackOutputStream;", "Ljava/io/OutputStream;", "innerStream", "callback", "Lcom/facebook/internal/FileLruCache$StreamCloseCallback;", "(Ljava/io/OutputStream;Lcom/facebook/internal/FileLruCache$StreamCloseCallback;)V", "getCallback", "()Lcom/facebook/internal/FileLruCache$StreamCloseCallback;", "getInnerStream", "()Ljava/io/OutputStream;", "close", "", "flush", "write", "buffer", "", "offset", "", "count", "oneByte", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class CloseCallbackOutputStream extends OutputStream {
        @NotNull
        private final StreamCloseCallback callback;
        @NotNull
        private final OutputStream innerStream;

        public CloseCallbackOutputStream(@NotNull OutputStream outputStream, @NotNull StreamCloseCallback streamCloseCallback) {
            Intrinsics.checkNotNullParameter(outputStream, "innerStream");
            Intrinsics.checkNotNullParameter(streamCloseCallback, "callback");
            this.innerStream = outputStream;
            this.callback = streamCloseCallback;
        }

        public void close() throws IOException {
            try {
                this.innerStream.close();
            } finally {
                this.callback.onClose();
            }
        }

        public void flush() throws IOException {
            this.innerStream.flush();
        }

        @NotNull
        public final StreamCloseCallback getCallback() {
            return this.callback;
        }

        @NotNull
        public final OutputStream getInnerStream() {
            return this.innerStream;
        }

        public void write(@NotNull byte[] bArr, int i11, int i12) throws IOException {
            Intrinsics.checkNotNullParameter(bArr, "buffer");
            this.innerStream.write(bArr, i11, i12);
        }

        public void write(@NotNull byte[] bArr) throws IOException {
            Intrinsics.checkNotNullParameter(bArr, "buffer");
            this.innerStream.write(bArr);
        }

        public void write(int i11) throws IOException {
            this.innerStream.write(i11);
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0019\u0010\u0006\u001a\n \u0007*\u0004\u0018\u00010\u00040\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/facebook/internal/FileLruCache$Companion;", "", "()V", "HEADER_CACHEKEY_KEY", "", "HEADER_CACHE_CONTENT_TAG_KEY", "TAG", "kotlin.jvm.PlatformType", "getTAG", "()Ljava/lang/String;", "bufferIndex", "Ljava/util/concurrent/atomic/AtomicLong;", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String getTAG() {
            return FileLruCache.TAG;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R$\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\t¨\u0006\r"}, d2 = {"Lcom/facebook/internal/FileLruCache$Limits;", "", "()V", "value", "", "byteCount", "getByteCount", "()I", "setByteCount", "(I)V", "fileCount", "getFileCount", "setFileCount", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Limits {
        private int byteCount = 1048576;
        private int fileCount = 1024;

        public final int getByteCount() {
            return this.byteCount;
        }

        public final int getFileCount() {
            return this.fileCount;
        }

        public final void setByteCount(int i11) {
            if (i11 >= 0) {
                this.byteCount = i11;
                return;
            }
            throw new InvalidParameterException("Cache byte-count limit must be >= 0");
        }

        public final void setFileCount(int i11) {
            if (i11 >= 0) {
                this.fileCount = i11;
                return;
            }
            throw new InvalidParameterException("Cache file count limit must be >= 0");
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0002\u0018\u0000 \u00122\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0012B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0011\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0000H\u0002J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\r\u001a\u0004\u0018\u00010\u0010H\u0002J\b\u0010\u0011\u001a\u00020\fH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, d2 = {"Lcom/facebook/internal/FileLruCache$ModifiedFile;", "", "file", "Ljava/io/File;", "(Ljava/io/File;)V", "getFile", "()Ljava/io/File;", "modified", "", "getModified", "()J", "compareTo", "", "another", "equals", "", "", "hashCode", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class ModifiedFile implements Comparable<ModifiedFile> {
        @NotNull
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private static final int HASH_MULTIPLIER = 37;
        private static final int HASH_SEED = 29;
        @NotNull
        private final File file;
        private final long modified;

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/facebook/internal/FileLruCache$ModifiedFile$Companion;", "", "()V", "HASH_MULTIPLIER", "", "HASH_SEED", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public ModifiedFile(@NotNull File file2) {
            Intrinsics.checkNotNullParameter(file2, "file");
            this.file = file2;
            this.modified = file2.lastModified();
        }

        public boolean equals(@Nullable Object obj) {
            return (obj instanceof ModifiedFile) && compareTo((ModifiedFile) obj) == 0;
        }

        @NotNull
        public final File getFile() {
            return this.file;
        }

        public final long getModified() {
            return this.modified;
        }

        public int hashCode() {
            return ((1073 + this.file.hashCode()) * 37) + ((int) (this.modified % ((long) Integer.MAX_VALUE)));
        }

        public int compareTo(@NotNull ModifiedFile modifiedFile) {
            Intrinsics.checkNotNullParameter(modifiedFile, "another");
            long j11 = this.modified;
            long j12 = modifiedFile.modified;
            if (j11 < j12) {
                return -1;
            }
            if (j11 > j12) {
                return 1;
            }
            return this.file.compareTo(modifiedFile.file);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bâ\u0001\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/facebook/internal/FileLruCache$StreamCloseCallback;", "", "onClose", "", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public interface StreamCloseCallback {
        void onClose();
    }

    @Instrumented
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/facebook/internal/FileLruCache$StreamHeader;", "", "()V", "HEADER_VERSION", "", "readHeader", "Lorg/json/JSONObject;", "stream", "Ljava/io/InputStream;", "writeHeader", "", "Ljava/io/OutputStream;", "header", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class StreamHeader {
        private static final int HEADER_VERSION = 0;
        @NotNull
        public static final StreamHeader INSTANCE = new StreamHeader();

        private StreamHeader() {
        }

        @Nullable
        public final JSONObject readHeader(@NotNull InputStream inputStream) throws IOException {
            Intrinsics.checkNotNullParameter(inputStream, "stream");
            if (inputStream.read() != 0) {
                return null;
            }
            int i11 = 0;
            int i12 = 0;
            for (int i13 = 0; i13 < 3; i13++) {
                int read = inputStream.read();
                if (read == -1) {
                    Logger.Companion companion = Logger.Companion;
                    LoggingBehavior loggingBehavior = LoggingBehavior.CACHE;
                    String tag = FileLruCache.Companion.getTAG();
                    Intrinsics.checkNotNullExpressionValue(tag, "TAG");
                    companion.log(loggingBehavior, tag, "readHeader: stream.read returned -1 while reading header size");
                    return null;
                }
                i12 = (i12 << 8) + (read & 255);
            }
            byte[] bArr = new byte[i12];
            while (i11 < i12) {
                int read2 = inputStream.read(bArr, i11, i12 - i11);
                if (read2 < 1) {
                    Logger.Companion companion2 = Logger.Companion;
                    LoggingBehavior loggingBehavior2 = LoggingBehavior.CACHE;
                    String tag2 = FileLruCache.Companion.getTAG();
                    Intrinsics.checkNotNullExpressionValue(tag2, "TAG");
                    companion2.log(loggingBehavior2, tag2, "readHeader: stream.read stopped at " + Integer.valueOf(i11) + " when expected " + i12);
                    return null;
                }
                i11 += read2;
            }
            try {
                Object nextValue = new JSONTokener(new String(bArr, Charsets.UTF_8)).nextValue();
                if (nextValue instanceof JSONObject) {
                    return (JSONObject) nextValue;
                }
                Logger.Companion companion3 = Logger.Companion;
                LoggingBehavior loggingBehavior3 = LoggingBehavior.CACHE;
                String tag3 = FileLruCache.Companion.getTAG();
                Intrinsics.checkNotNullExpressionValue(tag3, "TAG");
                companion3.log(loggingBehavior3, tag3, Intrinsics.stringPlus("readHeader: expected JSONObject, got ", nextValue.getClass().getCanonicalName()));
                return null;
            } catch (JSONException e11) {
                throw new IOException(e11.getMessage());
            }
        }

        public final void writeHeader(@NotNull OutputStream outputStream, @NotNull JSONObject jSONObject) throws IOException {
            String str;
            Intrinsics.checkNotNullParameter(outputStream, "stream");
            Intrinsics.checkNotNullParameter(jSONObject, "header");
            if (!(jSONObject instanceof JSONObject)) {
                str = jSONObject.toString();
            } else {
                str = JSONObjectInstrumentation.toString(jSONObject);
            }
            Intrinsics.checkNotNullExpressionValue(str, "header.toString()");
            byte[] bytes = str.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
            outputStream.write(0);
            outputStream.write((bytes.length >> 16) & 255);
            outputStream.write((bytes.length >> 8) & 255);
            outputStream.write((bytes.length >> 0) & 255);
            outputStream.write(bytes);
        }
    }

    public FileLruCache(@NotNull String str, @NotNull Limits limits2) {
        Intrinsics.checkNotNullParameter(str, "tag");
        Intrinsics.checkNotNullParameter(limits2, "limits");
        this.tag = str;
        this.limits = limits2;
        File file = new File(FacebookSdk.getCacheDir(), str);
        this.directory = file;
        ReentrantLock reentrantLock = new ReentrantLock();
        this.lock = reentrantLock;
        this.condition = reentrantLock.newCondition();
        if (file.mkdirs() || file.isDirectory()) {
            BufferFile.INSTANCE.deleteAll(file);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: clearCache$lambda-1  reason: not valid java name */
    public static final void m8955clearCache$lambda1(File[] fileArr) {
        Intrinsics.checkNotNullExpressionValue(fileArr, "filesToDelete");
        int length = fileArr.length;
        int i11 = 0;
        while (i11 < length) {
            File file = fileArr[i11];
            i11++;
            file.delete();
        }
    }

    public static /* synthetic */ InputStream get$default(FileLruCache fileLruCache, String str, String str2, int i11, Object obj) throws IOException {
        if ((i11 & 2) != 0) {
            str2 = null;
        }
        return fileLruCache.get(str, str2);
    }

    public static /* synthetic */ OutputStream openPutStream$default(FileLruCache fileLruCache, String str, String str2, int i11, Object obj) throws IOException {
        if ((i11 & 2) != 0) {
            str2 = null;
        }
        return fileLruCache.openPutStream(str, str2);
    }

    private final void postTrim() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            if (!this.isTrimPending) {
                this.isTrimPending = true;
                FacebookSdk.getExecutor().execute(new j(this));
            }
            Unit unit = Unit.INSTANCE;
        } finally {
            reentrantLock.unlock();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: postTrim$lambda-3$lambda-2  reason: not valid java name */
    public static final void m8956postTrim$lambda3$lambda2(FileLruCache fileLruCache) {
        Intrinsics.checkNotNullParameter(fileLruCache, "this$0");
        fileLruCache.trim();
    }

    /* access modifiers changed from: private */
    public final void renameToTargetAndTrim(String str, File file) {
        if (!file.renameTo(new File(this.directory, Utility.md5hash(str)))) {
            file.delete();
        }
        postTrim();
    }

    private final void trim() {
        ReentrantLock reentrantLock;
        long j11;
        ReentrantLock reentrantLock2 = this.lock;
        reentrantLock2.lock();
        try {
            this.isTrimPending = false;
            this.isTrimInProgress = true;
            Unit unit = Unit.INSTANCE;
            try {
                Logger.Companion companion = Logger.Companion;
                LoggingBehavior loggingBehavior = LoggingBehavior.CACHE;
                String str = TAG;
                Intrinsics.checkNotNullExpressionValue(str, "TAG");
                companion.log(loggingBehavior, str, "trim started");
                PriorityQueue priorityQueue = new PriorityQueue();
                File[] listFiles = this.directory.listFiles(BufferFile.INSTANCE.excludeBufferFiles());
                long j12 = 0;
                if (listFiles != null) {
                    int length = listFiles.length;
                    int i11 = 0;
                    j11 = 0;
                    while (i11 < length) {
                        File file = listFiles[i11];
                        i11++;
                        Intrinsics.checkNotNullExpressionValue(file, "file");
                        ModifiedFile modifiedFile = new ModifiedFile(file);
                        priorityQueue.add(modifiedFile);
                        Logger.Companion companion2 = Logger.Companion;
                        LoggingBehavior loggingBehavior2 = LoggingBehavior.CACHE;
                        String str2 = TAG;
                        Intrinsics.checkNotNullExpressionValue(str2, "TAG");
                        companion2.log(loggingBehavior2, str2, "  trim considering time=" + Long.valueOf(modifiedFile.getModified()) + " name=" + modifiedFile.getFile().getName());
                        j12 += file.length();
                        j11++;
                        listFiles = listFiles;
                    }
                } else {
                    j11 = 0;
                }
                while (true) {
                    if (j12 > ((long) this.limits.getByteCount()) || j11 > ((long) this.limits.getFileCount())) {
                        File file2 = ((ModifiedFile) priorityQueue.remove()).getFile();
                        Logger.Companion companion3 = Logger.Companion;
                        LoggingBehavior loggingBehavior3 = LoggingBehavior.CACHE;
                        String str3 = TAG;
                        Intrinsics.checkNotNullExpressionValue(str3, "TAG");
                        companion3.log(loggingBehavior3, str3, Intrinsics.stringPlus("  trim removing ", file2.getName()));
                        j12 -= file2.length();
                        j11--;
                        file2.delete();
                    } else {
                        reentrantLock = this.lock;
                        reentrantLock.lock();
                        try {
                            this.isTrimInProgress = false;
                            this.condition.signalAll();
                            Unit unit2 = Unit.INSTANCE;
                            return;
                        } finally {
                            reentrantLock.unlock();
                        }
                    }
                }
            } catch (Throwable th2) {
                reentrantLock = this.lock;
                reentrantLock.lock();
                this.isTrimInProgress = false;
                this.condition.signalAll();
                Unit unit3 = Unit.INSTANCE;
                throw th2;
            } finally {
                reentrantLock.unlock();
            }
        } finally {
            reentrantLock2.unlock();
        }
    }

    public final void clearCache() {
        File[] listFiles = this.directory.listFiles(BufferFile.INSTANCE.excludeBufferFiles());
        this.lastClearCacheTime.set(System.currentTimeMillis());
        if (listFiles != null) {
            FacebookSdk.getExecutor().execute(new k(listFiles));
        }
    }

    @Nullable
    @JvmOverloads
    public final InputStream get(@NotNull String str) throws IOException {
        Intrinsics.checkNotNullParameter(str, "key");
        return get$default(this, str, (String) null, 2, (Object) null);
    }

    @Nullable
    @JvmOverloads
    public final InputStream get(@NotNull String str, @Nullable String str2) throws IOException {
        Intrinsics.checkNotNullParameter(str, "key");
        File file = new File(this.directory, Utility.md5hash(str));
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file), 8192);
            try {
                JSONObject readHeader = StreamHeader.INSTANCE.readHeader(bufferedInputStream);
                if (readHeader == null) {
                    return null;
                }
                if (!Intrinsics.areEqual((Object) readHeader.optString("key"), (Object) str)) {
                    bufferedInputStream.close();
                    return null;
                }
                String optString = readHeader.optString("tag", (String) null);
                if (str2 != null || Intrinsics.areEqual((Object) str2, (Object) optString)) {
                    long time = new Date().getTime();
                    Logger.Companion companion = Logger.Companion;
                    LoggingBehavior loggingBehavior = LoggingBehavior.CACHE;
                    String str3 = TAG;
                    Intrinsics.checkNotNullExpressionValue(str3, "TAG");
                    companion.log(loggingBehavior, str3, "Setting lastModified to " + Long.valueOf(time) + " for " + file.getName());
                    file.setLastModified(time);
                    return bufferedInputStream;
                }
                bufferedInputStream.close();
                return null;
            } finally {
                bufferedInputStream.close();
            }
        } catch (IOException unused) {
            return null;
        }
    }

    @NotNull
    public final String getLocation() {
        String path = this.directory.getPath();
        Intrinsics.checkNotNullExpressionValue(path, "directory.path");
        return path;
    }

    @NotNull
    public final InputStream interceptAndPut(@NotNull String str, @NotNull InputStream inputStream) throws IOException {
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(inputStream, "input");
        return new CopyingInputStream(inputStream, openPutStream$default(this, str, (String) null, 2, (Object) null));
    }

    @NotNull
    @JvmOverloads
    public final OutputStream openPutStream(@NotNull String str) throws IOException {
        Intrinsics.checkNotNullParameter(str, "key");
        return openPutStream$default(this, str, (String) null, 2, (Object) null);
    }

    @NotNull
    @JvmOverloads
    public final OutputStream openPutStream(@NotNull String str, @Nullable String str2) throws IOException {
        Intrinsics.checkNotNullParameter(str, "key");
        File newFile = BufferFile.INSTANCE.newFile(this.directory);
        newFile.delete();
        if (newFile.createNewFile()) {
            try {
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new CloseCallbackOutputStream(new FileOutputStream(newFile), new FileLruCache$openPutStream$renameToTargetCallback$1(System.currentTimeMillis(), this, newFile, str)), 8192);
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("key", (Object) str);
                    if (!Utility.isNullOrEmpty(str2)) {
                        jSONObject.put("tag", (Object) str2);
                    }
                    StreamHeader.INSTANCE.writeHeader(bufferedOutputStream, jSONObject);
                    return bufferedOutputStream;
                } catch (JSONException e11) {
                    Logger.Companion companion = Logger.Companion;
                    LoggingBehavior loggingBehavior = LoggingBehavior.CACHE;
                    String str3 = TAG;
                    Intrinsics.checkNotNullExpressionValue(str3, "TAG");
                    companion.log(loggingBehavior, 5, str3, Intrinsics.stringPlus("Error creating JSON header for cache file: ", e11));
                    throw new IOException(e11.getMessage());
                } catch (Throwable th2) {
                    bufferedOutputStream.close();
                    throw th2;
                }
            } catch (FileNotFoundException e12) {
                Logger.Companion companion2 = Logger.Companion;
                LoggingBehavior loggingBehavior2 = LoggingBehavior.CACHE;
                String str4 = TAG;
                Intrinsics.checkNotNullExpressionValue(str4, "TAG");
                companion2.log(loggingBehavior2, 5, str4, Intrinsics.stringPlus("Error creating buffer output stream: ", e12));
                throw new IOException(e12.getMessage());
            }
        } else {
            throw new IOException(Intrinsics.stringPlus("Could not create file at ", newFile.getAbsolutePath()));
        }
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Can't wrap try/catch for region: R(7:1|2|(2:4|(1:6)(1:20))|14|15|21|19) */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0032, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0033, code lost:
        r0.unlock();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0036, code lost:
        throw r1;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:1:0x0005 */
    /* JADX WARNING: Removed duplicated region for block: B:1:0x0005 A[LOOP:0: B:1:0x0005->B:19:0x0005, LOOP_START, SYNTHETIC, Splitter:B:1:0x0005] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long sizeInBytesForTest() {
        /*
            r7 = this;
            java.util.concurrent.locks.ReentrantLock r0 = r7.lock
            r0.lock()
        L_0x0005:
            boolean r1 = r7.isTrimPending     // Catch:{ all -> 0x0032 }
            if (r1 != 0) goto L_0x002c
            boolean r1 = r7.isTrimInProgress     // Catch:{ all -> 0x0032 }
            if (r1 == 0) goto L_0x000e
            goto L_0x002c
        L_0x000e:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0032 }
            r0.unlock()
            java.io.File r0 = r7.directory
            java.io.File[] r0 = r0.listFiles()
            r1 = 0
            if (r0 == 0) goto L_0x002b
            int r3 = r0.length
            r4 = 0
        L_0x001f:
            if (r4 >= r3) goto L_0x002b
            r5 = r0[r4]
            int r4 = r4 + 1
            long r5 = r5.length()
            long r1 = r1 + r5
            goto L_0x001f
        L_0x002b:
            return r1
        L_0x002c:
            java.util.concurrent.locks.Condition r1 = r7.condition     // Catch:{ InterruptedException -> 0x0005 }
            r1.await()     // Catch:{ InterruptedException -> 0x0005 }
            goto L_0x0005
        L_0x0032:
            r1 = move-exception
            r0.unlock()
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.FileLruCache.sizeInBytesForTest():long");
    }

    @NotNull
    public String toString() {
        return "{FileLruCache: tag:" + this.tag + " file:" + this.directory.getName() + AbstractJsonLexerKt.END_OBJ;
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u000bH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u000bH\u0016J\u0010\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J \u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u000bH\u0016J\b\u0010\u0017\u001a\u00020\rH\u0016J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0019H\u0016R\u0011\u0010\u0002\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u001b"}, d2 = {"Lcom/facebook/internal/FileLruCache$CopyingInputStream;", "Ljava/io/InputStream;", "input", "output", "Ljava/io/OutputStream;", "(Ljava/io/InputStream;Ljava/io/OutputStream;)V", "getInput", "()Ljava/io/InputStream;", "getOutput", "()Ljava/io/OutputStream;", "available", "", "close", "", "mark", "readlimit", "markSupported", "", "read", "buffer", "", "offset", "length", "reset", "skip", "", "byteCount", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class CopyingInputStream extends InputStream {
        @NotNull
        private final InputStream input;
        @NotNull
        private final OutputStream output;

        public CopyingInputStream(@NotNull InputStream inputStream, @NotNull OutputStream outputStream) {
            Intrinsics.checkNotNullParameter(inputStream, "input");
            Intrinsics.checkNotNullParameter(outputStream, "output");
            this.input = inputStream;
            this.output = outputStream;
        }

        public int available() throws IOException {
            return this.input.available();
        }

        public void close() throws IOException {
            try {
                this.input.close();
            } finally {
                this.output.close();
            }
        }

        @NotNull
        public final InputStream getInput() {
            return this.input;
        }

        @NotNull
        public final OutputStream getOutput() {
            return this.output;
        }

        public void mark(int i11) {
            throw new UnsupportedOperationException();
        }

        public boolean markSupported() {
            return false;
        }

        public int read(@NotNull byte[] bArr) throws IOException {
            Intrinsics.checkNotNullParameter(bArr, "buffer");
            int read = this.input.read(bArr);
            if (read > 0) {
                this.output.write(bArr, 0, read);
            }
            return read;
        }

        public synchronized void reset() {
            throw new UnsupportedOperationException();
        }

        public long skip(long j11) throws IOException {
            int read;
            byte[] bArr = new byte[1024];
            long j12 = 0;
            while (j12 < j11 && (read = read(bArr, 0, (int) Math.min(j11 - j12, (long) 1024))) >= 0) {
                j12 += (long) read;
            }
            return j12;
        }

        public int read() throws IOException {
            int read = this.input.read();
            if (read >= 0) {
                this.output.write(read);
            }
            return read;
        }

        public int read(@NotNull byte[] bArr, int i11, int i12) throws IOException {
            Intrinsics.checkNotNullParameter(bArr, "buffer");
            int read = this.input.read(bArr, i11, i12);
            if (read > 0) {
                this.output.write(bArr, i11, read);
            }
            return read;
        }
    }
}
