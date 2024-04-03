package org.tukaani.xz;

abstract class BCJOptions extends FilterOptions {
    private final int alignment;

    /* renamed from: b  reason: collision with root package name */
    public int f63396b = 0;

    public BCJOptions(int i11) {
        this.alignment = i11;
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            throw new RuntimeException();
        }
    }

    public int getDecoderMemoryUsage() {
        return SimpleInputStream.a();
    }

    public int getEncoderMemoryUsage() {
        return SimpleOutputStream.a();
    }

    public int getStartOffset() {
        return this.f63396b;
    }

    public void setStartOffset(int i11) throws UnsupportedOptionsException {
        if (((this.alignment - 1) & i11) == 0) {
            this.f63396b = i11;
            return;
        }
        throw new UnsupportedOptionsException("Start offset must be a multiple of " + this.alignment);
    }
}
