package org.apache.commons.compress.compressors.pack200;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

abstract class StreamBridge extends FilterOutputStream {
    private InputStream input;
    private final Object inputLock;

    public StreamBridge(OutputStream outputStream) {
        super(outputStream);
        this.inputLock = new Object();
    }

    public InputStream a() throws IOException {
        synchronized (this.inputLock) {
            if (this.input == null) {
                this.input = b();
            }
        }
        return this.input;
    }

    public abstract InputStream b() throws IOException;

    public void c() throws IOException {
        close();
        synchronized (this.inputLock) {
            InputStream inputStream = this.input;
            if (inputStream != null) {
                inputStream.close();
                this.input = null;
            }
        }
    }

    public StreamBridge() {
        this((OutputStream) null);
    }
}
