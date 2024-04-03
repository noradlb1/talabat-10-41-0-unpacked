package com.google.android.exoplayer2.source;

public class CompositeSequenceableLoader implements SequenceableLoader {
    protected final SequenceableLoader[] loaders;

    public CompositeSequenceableLoader(SequenceableLoader[] sequenceableLoaderArr) {
        this.loaders = sequenceableLoaderArr;
    }

    public boolean continueLoading(long j11) {
        boolean z11;
        long j12 = j11;
        boolean z12 = false;
        while (true) {
            long nextLoadPositionUs = getNextLoadPositionUs();
            if (nextLoadPositionUs != Long.MIN_VALUE) {
                boolean z13 = false;
                for (SequenceableLoader sequenceableLoader : this.loaders) {
                    long nextLoadPositionUs2 = sequenceableLoader.getNextLoadPositionUs();
                    if (nextLoadPositionUs2 == Long.MIN_VALUE || nextLoadPositionUs2 > j12) {
                        z11 = false;
                    } else {
                        z11 = true;
                    }
                    if (nextLoadPositionUs2 == nextLoadPositionUs || z11) {
                        z13 |= sequenceableLoader.continueLoading(j12);
                    }
                }
                z12 |= z13;
                if (!z13) {
                    break;
                }
            } else {
                break;
            }
        }
        return z12;
    }

    public final long getBufferedPositionUs() {
        long j11 = Long.MAX_VALUE;
        for (SequenceableLoader bufferedPositionUs : this.loaders) {
            long bufferedPositionUs2 = bufferedPositionUs.getBufferedPositionUs();
            if (bufferedPositionUs2 != Long.MIN_VALUE) {
                j11 = Math.min(j11, bufferedPositionUs2);
            }
        }
        if (j11 == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        return j11;
    }

    public final long getNextLoadPositionUs() {
        long j11 = Long.MAX_VALUE;
        for (SequenceableLoader nextLoadPositionUs : this.loaders) {
            long nextLoadPositionUs2 = nextLoadPositionUs.getNextLoadPositionUs();
            if (nextLoadPositionUs2 != Long.MIN_VALUE) {
                j11 = Math.min(j11, nextLoadPositionUs2);
            }
        }
        if (j11 == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        return j11;
    }

    public boolean isLoading() {
        for (SequenceableLoader isLoading : this.loaders) {
            if (isLoading.isLoading()) {
                return true;
            }
        }
        return false;
    }

    public final void reevaluateBuffer(long j11) {
        for (SequenceableLoader reevaluateBuffer : this.loaders) {
            reevaluateBuffer.reevaluateBuffer(j11);
        }
    }
}
