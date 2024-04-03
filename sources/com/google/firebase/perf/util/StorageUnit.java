package com.google.firebase.perf.util;

import android.support.v4.media.session.PlaybackStateCompat;

public enum StorageUnit {
    TERABYTES(1099511627776L) {
        public long convert(long j11, StorageUnit storageUnit) {
            return storageUnit.toTerabytes(j11);
        }
    },
    GIGABYTES(1073741824) {
        public long convert(long j11, StorageUnit storageUnit) {
            return storageUnit.toGigabytes(j11);
        }
    },
    MEGABYTES(PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) {
        public long convert(long j11, StorageUnit storageUnit) {
            return storageUnit.toMegabytes(j11);
        }
    },
    KILOBYTES(1024) {
        public long convert(long j11, StorageUnit storageUnit) {
            return storageUnit.toKilobytes(j11);
        }
    },
    BYTES(1) {
        public long convert(long j11, StorageUnit storageUnit) {
            return storageUnit.toBytes(j11);
        }
    };
    
    long numBytes;

    public abstract long convert(long j11, StorageUnit storageUnit);

    public long toBytes(long j11) {
        return j11 * this.numBytes;
    }

    public long toGigabytes(long j11) {
        return (j11 * this.numBytes) / GIGABYTES.numBytes;
    }

    public long toKilobytes(long j11) {
        return (j11 * this.numBytes) / KILOBYTES.numBytes;
    }

    public long toMegabytes(long j11) {
        return (j11 * this.numBytes) / MEGABYTES.numBytes;
    }

    public long toTerabytes(long j11) {
        return (j11 * this.numBytes) / TERABYTES.numBytes;
    }

    private StorageUnit(long j11) {
        this.numBytes = j11;
    }
}
