package org.apache.commons.compress.utils;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class CloseShieldFilterInputStream extends FilterInputStream {
    public CloseShieldFilterInputStream(InputStream inputStream) {
        super(inputStream);
    }

    public void close() throws IOException {
    }
}
