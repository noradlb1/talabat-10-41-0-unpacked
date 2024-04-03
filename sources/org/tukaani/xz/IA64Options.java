package org.tukaani.xz;

import java.io.InputStream;
import org.tukaani.xz.simple.IA64;

public class IA64Options extends BCJOptions {
    private static final int ALIGNMENT = 16;

    public IA64Options() {
        super(16);
    }

    public FilterEncoder a() {
        return new BCJEncoder(this, 6);
    }

    public /* bridge */ /* synthetic */ Object clone() {
        return super.clone();
    }

    public /* bridge */ /* synthetic */ int getDecoderMemoryUsage() {
        return super.getDecoderMemoryUsage();
    }

    public /* bridge */ /* synthetic */ int getEncoderMemoryUsage() {
        return super.getEncoderMemoryUsage();
    }

    public InputStream getInputStream(InputStream inputStream, ArrayCache arrayCache) {
        return new SimpleInputStream(inputStream, new IA64(false, this.f63396b));
    }

    public FinishableOutputStream getOutputStream(FinishableOutputStream finishableOutputStream, ArrayCache arrayCache) {
        return new SimpleOutputStream(finishableOutputStream, new IA64(true, this.f63396b));
    }

    public /* bridge */ /* synthetic */ int getStartOffset() {
        return super.getStartOffset();
    }

    public /* bridge */ /* synthetic */ void setStartOffset(int i11) throws UnsupportedOptionsException {
        super.setStartOffset(i11);
    }
}
