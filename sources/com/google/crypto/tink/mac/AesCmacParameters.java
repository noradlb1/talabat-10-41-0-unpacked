package com.google.crypto.tink.mac;

import com.google.errorprone.annotations.Immutable;
import java.security.GeneralSecurityException;
import java.util.Objects;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

public final class AesCmacParameters extends MacParameters {
    private final int tagSizeBytes;
    private final Variant variant;

    @Immutable
    public static final class Variant {
        public static final Variant CRUNCHY = new Variant("CRUNCHY");
        public static final Variant LEGACY = new Variant("LEGACY");
        public static final Variant NO_PREFIX = new Variant("NO_PREFIX");
        public static final Variant TINK = new Variant("TINK");

        /* renamed from: name  reason: collision with root package name */
        private final String f47302name;

        private Variant(String str) {
            this.f47302name = str;
        }

        public String toString() {
            return this.f47302name;
        }
    }

    private AesCmacParameters(int i11, Variant variant2) {
        this.tagSizeBytes = i11;
        this.variant = variant2;
    }

    public static AesCmacParameters create(int i11) throws GeneralSecurityException {
        return createForKeysetWithCryptographicTagSize(i11, Variant.NO_PREFIX);
    }

    public static AesCmacParameters createForKeysetWithCryptographicTagSize(int i11, Variant variant2) throws GeneralSecurityException {
        if (i11 >= 10 && 16 >= i11) {
            return new AesCmacParameters(i11, variant2);
        }
        throw new GeneralSecurityException("Invalid tag size for AesCmacParameters: " + i11);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof AesCmacParameters)) {
            return false;
        }
        AesCmacParameters aesCmacParameters = (AesCmacParameters) obj;
        if (aesCmacParameters.getTotalTagSizeBytes() == getTotalTagSizeBytes() && aesCmacParameters.getVariant() == getVariant()) {
            return true;
        }
        return false;
    }

    public int getCryptographicTagSizeBytes() {
        return this.tagSizeBytes;
    }

    public int getTotalTagSizeBytes() {
        int cryptographicTagSizeBytes;
        Variant variant2 = this.variant;
        if (variant2 == Variant.NO_PREFIX) {
            return getCryptographicTagSizeBytes();
        }
        if (variant2 == Variant.TINK) {
            cryptographicTagSizeBytes = getCryptographicTagSizeBytes();
        } else if (variant2 == Variant.CRUNCHY) {
            cryptographicTagSizeBytes = getCryptographicTagSizeBytes();
        } else if (variant2 == Variant.LEGACY) {
            cryptographicTagSizeBytes = getCryptographicTagSizeBytes();
        } else {
            throw new IllegalStateException("Unknown variant");
        }
        return cryptographicTagSizeBytes + 5;
    }

    public Variant getVariant() {
        return this.variant;
    }

    public boolean hasIdRequirement() {
        return this.variant != Variant.NO_PREFIX;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{Integer.valueOf(this.tagSizeBytes), this.variant});
    }

    public String toString() {
        return "AES-CMAC Parameters (variant: " + this.variant + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + this.tagSizeBytes + "-byte tags)";
    }
}
