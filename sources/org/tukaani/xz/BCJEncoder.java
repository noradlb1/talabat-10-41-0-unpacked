package org.tukaani.xz;

class BCJEncoder extends BCJCoder implements FilterEncoder {
    private final long filterID;
    private final BCJOptions options;
    private final byte[] props;

    public BCJEncoder(BCJOptions bCJOptions, long j11) {
        int startOffset = bCJOptions.getStartOffset();
        if (startOffset == 0) {
            this.props = new byte[0];
        } else {
            this.props = new byte[4];
            for (int i11 = 0; i11 < 4; i11++) {
                this.props[i11] = (byte) (startOffset >>> (i11 * 8));
            }
        }
        this.filterID = j11;
        this.options = (BCJOptions) bCJOptions.clone();
    }

    public long getFilterID() {
        return this.filterID;
    }

    public byte[] getFilterProps() {
        return this.props;
    }

    public FinishableOutputStream getOutputStream(FinishableOutputStream finishableOutputStream, ArrayCache arrayCache) {
        return this.options.getOutputStream(finishableOutputStream, arrayCache);
    }

    public boolean supportsFlushing() {
        return false;
    }
}
