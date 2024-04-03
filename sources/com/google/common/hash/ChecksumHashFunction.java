package com.google.common.hash;

import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.Immutable;
import java.io.Serializable;
import java.util.zip.Checksum;

@ElementTypesAreNonnullByDefault
@Immutable
final class ChecksumHashFunction extends AbstractHashFunction implements Serializable {
    private static final long serialVersionUID = 0;
    /* access modifiers changed from: private */
    public final int bits;
    private final ImmutableSupplier<? extends Checksum> checksumSupplier;
    private final String toString;

    public final class ChecksumHasher extends AbstractByteHasher {
        private final Checksum checksum;

        public HashCode hash() {
            long value = this.checksum.getValue();
            if (ChecksumHashFunction.this.bits == 32) {
                return HashCode.fromInt((int) value);
            }
            return HashCode.fromLong(value);
        }

        public void update(byte b11) {
            this.checksum.update(b11);
        }

        private ChecksumHasher(Checksum checksum2) {
            this.checksum = (Checksum) Preconditions.checkNotNull(checksum2);
        }

        public void update(byte[] bArr, int i11, int i12) {
            this.checksum.update(bArr, i11, i12);
        }
    }

    public ChecksumHashFunction(ImmutableSupplier<? extends Checksum> immutableSupplier, int i11, String str) {
        boolean z11;
        this.checksumSupplier = (ImmutableSupplier) Preconditions.checkNotNull(immutableSupplier);
        if (i11 == 32 || i11 == 64) {
            z11 = true;
        } else {
            z11 = false;
        }
        Preconditions.checkArgument(z11, "bits (%s) must be either 32 or 64", i11);
        this.bits = i11;
        this.toString = (String) Preconditions.checkNotNull(str);
    }

    public int bits() {
        return this.bits;
    }

    public Hasher newHasher() {
        return new ChecksumHasher((Checksum) this.checksumSupplier.get());
    }

    public String toString() {
        return this.toString;
    }
}
