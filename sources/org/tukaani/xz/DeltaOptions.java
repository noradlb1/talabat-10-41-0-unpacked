package org.tukaani.xz;

import java.io.InputStream;

public class DeltaOptions extends FilterOptions {
    public static final int DISTANCE_MAX = 256;
    public static final int DISTANCE_MIN = 1;
    private int distance = 1;

    public DeltaOptions() {
    }

    public DeltaOptions(int i11) throws UnsupportedOptionsException {
        setDistance(i11);
    }

    public FilterEncoder a() {
        return new DeltaEncoder(this);
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            throw new RuntimeException();
        }
    }

    public int getDecoderMemoryUsage() {
        return 1;
    }

    public int getDistance() {
        return this.distance;
    }

    public int getEncoderMemoryUsage() {
        return DeltaOutputStream.a();
    }

    public InputStream getInputStream(InputStream inputStream, ArrayCache arrayCache) {
        return new DeltaInputStream(inputStream, this.distance);
    }

    public FinishableOutputStream getOutputStream(FinishableOutputStream finishableOutputStream, ArrayCache arrayCache) {
        return new DeltaOutputStream(finishableOutputStream, this);
    }

    public void setDistance(int i11) throws UnsupportedOptionsException {
        if (i11 < 1 || i11 > 256) {
            throw new UnsupportedOptionsException("Delta distance must be in the range [1, 256]: " + i11);
        }
        this.distance = i11;
    }
}
