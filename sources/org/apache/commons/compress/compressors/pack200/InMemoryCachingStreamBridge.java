package org.apache.commons.compress.compressors.pack200;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

class InMemoryCachingStreamBridge extends StreamBridge {
    public InMemoryCachingStreamBridge() {
        super(new ByteArrayOutputStream());
    }

    public InputStream b() throws IOException {
        return new ByteArrayInputStream(((ByteArrayOutputStream) this.out).toByteArray());
    }
}
