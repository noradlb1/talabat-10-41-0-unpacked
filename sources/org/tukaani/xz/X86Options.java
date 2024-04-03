package org.tukaani.xz;

import java.io.InputStream;
import org.tukaani.xz.simple.X86;

public class X86Options extends BCJOptions {
    private static final int ALIGNMENT = 1;

    public X86Options() {
        super(1);
    }

    public FilterEncoder a() {
        return new BCJEncoder(this, 4);
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
        return new SimpleInputStream(inputStream, new X86(false, this.f63396b));
    }

    public FinishableOutputStream getOutputStream(FinishableOutputStream finishableOutputStream, ArrayCache arrayCache) {
        return new SimpleOutputStream(finishableOutputStream, new X86(true, this.f63396b));
    }

    public /* bridge */ /* synthetic */ int getStartOffset() {
        return super.getStartOffset();
    }

    public /* bridge */ /* synthetic */ void setStartOffset(int i11) throws UnsupportedOptionsException {
        super.setStartOffset(i11);
    }
}
