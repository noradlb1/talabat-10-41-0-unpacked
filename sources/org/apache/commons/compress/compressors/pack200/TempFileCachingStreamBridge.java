package org.apache.commons.compress.compressors.pack200;

import java.io.File;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.OpenOption;

class TempFileCachingStreamBridge extends StreamBridge {
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final File f27719f;

    public TempFileCachingStreamBridge() throws IOException {
        File createTempFile = File.createTempFile("commons-compress", "packtemp");
        this.f27719f = createTempFile;
        createTempFile.deleteOnExit();
        this.out = Files.newOutputStream(createTempFile.toPath(), new OpenOption[0]);
    }

    public InputStream b() throws IOException {
        this.out.close();
        return new FilterInputStream(Files.newInputStream(this.f27719f.toPath(), new OpenOption[0])) {
            public void close() throws IOException {
                try {
                    super.close();
                } finally {
                    TempFileCachingStreamBridge.this.f27719f.delete();
                }
            }
        };
    }
}
