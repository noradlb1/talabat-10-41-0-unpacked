package org.tukaani.xz.rangecoder;

import java.io.IOException;
import java.io.OutputStream;

public final class RangeEncoderToStream extends RangeEncoder {
    private final OutputStream out;

    public RangeEncoderToStream(OutputStream outputStream) {
        this.out = outputStream;
        reset();
    }

    public void a(int i11) throws IOException {
        this.out.write(i11);
    }
}
