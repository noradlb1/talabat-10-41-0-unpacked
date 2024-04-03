package org.apache.commons.compress.parallel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.OpenOption;

public class FileBasedScatterGatherBackingStore implements ScatterGatherBackingStore {
    private boolean closed;

    /* renamed from: os  reason: collision with root package name */
    private final OutputStream f27769os;
    private final File target;

    public FileBasedScatterGatherBackingStore(File file) throws FileNotFoundException {
        this.target = file;
        try {
            this.f27769os = Files.newOutputStream(file.toPath(), new OpenOption[0]);
        } catch (FileNotFoundException e11) {
            throw e11;
        } catch (IOException e12) {
            throw new RuntimeException(e12);
        }
    }

    public void close() throws IOException {
        try {
            closeForWriting();
        } finally {
            if (this.target.exists() && !this.target.delete()) {
                this.target.deleteOnExit();
            }
        }
    }

    public void closeForWriting() throws IOException {
        if (!this.closed) {
            this.f27769os.close();
            this.closed = true;
        }
    }

    public InputStream getInputStream() throws IOException {
        return Files.newInputStream(this.target.toPath(), new OpenOption[0]);
    }

    public void writeOut(byte[] bArr, int i11, int i12) throws IOException {
        this.f27769os.write(bArr, i11, i12);
    }
}
