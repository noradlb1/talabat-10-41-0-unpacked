package com.google.android.exoplayer2.extractor;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.Assertions;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

public interface SeekMap {

    public static final class SeekPoints {
        public final SeekPoint first;
        public final SeekPoint second;

        public SeekPoints(SeekPoint seekPoint) {
            this(seekPoint, seekPoint);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || SeekPoints.class != obj.getClass()) {
                return false;
            }
            SeekPoints seekPoints = (SeekPoints) obj;
            if (!this.first.equals(seekPoints.first) || !this.second.equals(seekPoints.second)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (this.first.hashCode() * 31) + this.second.hashCode();
        }

        public String toString() {
            String str;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("[");
            sb2.append(this.first);
            if (this.first.equals(this.second)) {
                str = "";
            } else {
                str = IndicativeSentencesGeneration.DEFAULT_SEPARATOR + this.second;
            }
            sb2.append(str);
            sb2.append("]");
            return sb2.toString();
        }

        public SeekPoints(SeekPoint seekPoint, SeekPoint seekPoint2) {
            this.first = (SeekPoint) Assertions.checkNotNull(seekPoint);
            this.second = (SeekPoint) Assertions.checkNotNull(seekPoint2);
        }
    }

    public static class Unseekable implements SeekMap {
        private final long durationUs;
        private final SeekPoints startSeekPoints;

        public Unseekable(long j11) {
            this(j11, 0);
        }

        public long getDurationUs() {
            return this.durationUs;
        }

        public SeekPoints getSeekPoints(long j11) {
            return this.startSeekPoints;
        }

        public boolean isSeekable() {
            return false;
        }

        public Unseekable(long j11, long j12) {
            this.durationUs = j11;
            this.startSeekPoints = new SeekPoints(j12 == 0 ? SeekPoint.START : new SeekPoint(0, j12));
        }
    }

    long getDurationUs();

    SeekPoints getSeekPoints(long j11);

    boolean isSeekable();
}
