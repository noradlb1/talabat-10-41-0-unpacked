package com.google.common.io;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.concurrent.GuardedBy;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Objects;
import javax.annotation.CheckForNull;

@GwtIncompatible
@ElementTypesAreNonnullByDefault
@Beta
@J2ktIncompatible
public final class FileBackedOutputStream extends OutputStream {
    @CheckForNull
    @GuardedBy("this")
    private File file;
    private final int fileThreshold;
    @CheckForNull
    @GuardedBy("this")
    private MemoryOutput memory;
    @GuardedBy("this")
    private OutputStream out;
    private final boolean resetOnFinalize;
    private final ByteSource source;

    public static class MemoryOutput extends ByteArrayOutputStream {
        private MemoryOutput() {
        }

        public byte[] getBuffer() {
            return this.buf;
        }

        public int getCount() {
            return this.count;
        }
    }

    public FileBackedOutputStream(int i11) {
        this(i11, false);
    }

    /* access modifiers changed from: private */
    public synchronized InputStream openInputStream() throws IOException {
        if (this.file != null) {
            return new FileInputStream(this.file);
        }
        Objects.requireNonNull(this.memory);
        return new ByteArrayInputStream(this.memory.getBuffer(), 0, this.memory.getCount());
    }

    @GuardedBy("this")
    private void update(int i11) throws IOException {
        MemoryOutput memoryOutput = this.memory;
        if (memoryOutput != null && memoryOutput.getCount() + i11 > this.fileThreshold) {
            File createTempFile = TempFileCreator.INSTANCE.createTempFile("FileBackedOutputStream");
            if (this.resetOnFinalize) {
                createTempFile.deleteOnExit();
            }
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(createTempFile);
                fileOutputStream.write(this.memory.getBuffer(), 0, this.memory.getCount());
                fileOutputStream.flush();
                this.out = fileOutputStream;
                this.file = createTempFile;
                this.memory = null;
            } catch (IOException e11) {
                createTempFile.delete();
                throw e11;
            }
        }
    }

    public ByteSource asByteSource() {
        return this.source;
    }

    public synchronized void close() throws IOException {
        this.out.close();
    }

    public synchronized void flush() throws IOException {
        this.out.flush();
    }

    @CheckForNull
    @VisibleForTesting
    public synchronized File getFile() {
        return this.file;
    }

    public synchronized void reset() throws IOException {
        try {
            close();
            MemoryOutput memoryOutput = this.memory;
            if (memoryOutput == null) {
                this.memory = new MemoryOutput();
            } else {
                memoryOutput.reset();
            }
            this.out = this.memory;
            File file2 = this.file;
            if (file2 != null) {
                this.file = null;
                if (!file2.delete()) {
                    throw new IOException("Could not delete: " + file2);
                }
            }
        } catch (Throwable th2) {
            if (this.memory == null) {
                this.memory = new MemoryOutput();
            } else {
                this.memory.reset();
            }
            this.out = this.memory;
            File file3 = this.file;
            if (file3 != null) {
                this.file = null;
                if (!file3.delete()) {
                    throw new IOException("Could not delete: " + file3);
                }
            }
            throw th2;
        }
    }

    public synchronized void write(int i11) throws IOException {
        update(1);
        this.out.write(i11);
    }

    public FileBackedOutputStream(int i11, boolean z11) {
        Preconditions.checkArgument(i11 >= 0, "fileThreshold must be non-negative, but was %s", i11);
        this.fileThreshold = i11;
        this.resetOnFinalize = z11;
        MemoryOutput memoryOutput = new MemoryOutput();
        this.memory = memoryOutput;
        this.out = memoryOutput;
        if (z11) {
            this.source = new ByteSource() {
                public void finalize() {
                    try {
                        FileBackedOutputStream.this.reset();
                    } catch (Throwable th2) {
                        th2.printStackTrace(System.err);
                    }
                }

                public InputStream openStream() throws IOException {
                    return FileBackedOutputStream.this.openInputStream();
                }
            };
        } else {
            this.source = new ByteSource() {
                public InputStream openStream() throws IOException {
                    return FileBackedOutputStream.this.openInputStream();
                }
            };
        }
    }

    public synchronized void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    public synchronized void write(byte[] bArr, int i11, int i12) throws IOException {
        update(i12);
        this.out.write(bArr, i11, i12);
    }
}
