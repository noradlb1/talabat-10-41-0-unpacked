package org.tukaani.xz;

import java.io.IOException;
import java.io.InputStream;

public abstract class FilterOptions implements Cloneable {
    public static int getDecoderMemoryUsage(FilterOptions[] filterOptionsArr) {
        int i11 = 0;
        for (FilterOptions decoderMemoryUsage : filterOptionsArr) {
            i11 += decoderMemoryUsage.getDecoderMemoryUsage();
        }
        return i11;
    }

    public static int getEncoderMemoryUsage(FilterOptions[] filterOptionsArr) {
        int i11 = 0;
        for (FilterOptions encoderMemoryUsage : filterOptionsArr) {
            i11 += encoderMemoryUsage.getEncoderMemoryUsage();
        }
        return i11;
    }

    public abstract FilterEncoder a();

    public abstract int getDecoderMemoryUsage();

    public abstract int getEncoderMemoryUsage();

    public InputStream getInputStream(InputStream inputStream) throws IOException {
        return getInputStream(inputStream, ArrayCache.getDefaultCache());
    }

    public abstract InputStream getInputStream(InputStream inputStream, ArrayCache arrayCache) throws IOException;

    public FinishableOutputStream getOutputStream(FinishableOutputStream finishableOutputStream) {
        return getOutputStream(finishableOutputStream, ArrayCache.getDefaultCache());
    }

    public abstract FinishableOutputStream getOutputStream(FinishableOutputStream finishableOutputStream, ArrayCache arrayCache);
}
