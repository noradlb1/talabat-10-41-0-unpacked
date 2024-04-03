package org.tukaani.xz;

import java.io.InputStream;
import org.tukaani.xz.simple.ARM;

public class ARMOptions extends BCJOptions {
    private static final int ALIGNMENT = 4;

    public ARMOptions() {
        super(4);
    }

    public FilterEncoder a() {
        return new BCJEncoder(this, 7);
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
        return new SimpleInputStream(inputStream, new ARM(false, this.f63396b));
    }

    public FinishableOutputStream getOutputStream(FinishableOutputStream finishableOutputStream, ArrayCache arrayCache) {
        return new SimpleOutputStream(finishableOutputStream, new ARM(true, this.f63396b));
    }

    public /* bridge */ /* synthetic */ int getStartOffset() {
        return super.getStartOffset();
    }

    public /* bridge */ /* synthetic */ void setStartOffset(int i11) throws UnsupportedOptionsException {
        super.setStartOffset(i11);
    }
}
