package com.google.common.hash;

import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.Immutable;
import java.io.Serializable;
import java.nio.ByteBuffer;
import javax.annotation.CheckForNull;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

@ElementTypesAreNonnullByDefault
@Immutable
final class SipHashFunction extends AbstractHashFunction implements Serializable {
    static final HashFunction SIP_HASH_24 = new SipHashFunction(2, 4, 506097522914230528L, 1084818905618843912L);
    private static final long serialVersionUID = 0;

    /* renamed from: c  reason: collision with root package name */
    private final int f44664c;

    /* renamed from: d  reason: collision with root package name */
    private final int f44665d;

    /* renamed from: k0  reason: collision with root package name */
    private final long f44666k0;

    /* renamed from: k1  reason: collision with root package name */
    private final long f44667k1;

    public static final class SipHasher extends AbstractStreamingHasher {
        private static final int CHUNK_SIZE = 8;

        /* renamed from: b  reason: collision with root package name */
        private long f44668b = 0;

        /* renamed from: c  reason: collision with root package name */
        private final int f44669c;

        /* renamed from: d  reason: collision with root package name */
        private final int f44670d;
        private long finalM = 0;

        /* renamed from: v0  reason: collision with root package name */
        private long f44671v0;

        /* renamed from: v1  reason: collision with root package name */
        private long f44672v1;

        /* renamed from: v2  reason: collision with root package name */
        private long f44673v2;

        /* renamed from: v3  reason: collision with root package name */
        private long f44674v3;

        public SipHasher(int i11, int i12, long j11, long j12) {
            super(8);
            this.f44669c = i11;
            this.f44670d = i12;
            this.f44671v0 = 8317987319222330741L ^ j11;
            this.f44672v1 = 7237128888997146477L ^ j12;
            this.f44673v2 = 7816392313619706465L ^ j11;
            this.f44674v3 = 8387220255154660723L ^ j12;
        }

        private void processM(long j11) {
            this.f44674v3 ^= j11;
            sipRound(this.f44669c);
            this.f44671v0 = j11 ^ this.f44671v0;
        }

        private void sipRound(int i11) {
            for (int i12 = 0; i12 < i11; i12++) {
                long j11 = this.f44671v0;
                long j12 = this.f44672v1;
                this.f44671v0 = j11 + j12;
                this.f44673v2 += this.f44674v3;
                this.f44672v1 = Long.rotateLeft(j12, 13);
                long rotateLeft = Long.rotateLeft(this.f44674v3, 16);
                long j13 = this.f44672v1;
                long j14 = this.f44671v0;
                this.f44672v1 = j13 ^ j14;
                this.f44674v3 = rotateLeft ^ this.f44673v2;
                long rotateLeft2 = Long.rotateLeft(j14, 32);
                long j15 = this.f44673v2;
                long j16 = this.f44672v1;
                this.f44673v2 = j15 + j16;
                this.f44671v0 = rotateLeft2 + this.f44674v3;
                this.f44672v1 = Long.rotateLeft(j16, 17);
                long rotateLeft3 = Long.rotateLeft(this.f44674v3, 21);
                long j17 = this.f44672v1;
                long j18 = this.f44673v2;
                this.f44672v1 = j17 ^ j18;
                this.f44674v3 = rotateLeft3 ^ this.f44671v0;
                this.f44673v2 = Long.rotateLeft(j18, 32);
            }
        }

        public HashCode makeHash() {
            long j11 = this.finalM ^ (this.f44668b << 56);
            this.finalM = j11;
            processM(j11);
            this.f44673v2 ^= 255;
            sipRound(this.f44670d);
            return HashCode.fromLong(((this.f44671v0 ^ this.f44672v1) ^ this.f44673v2) ^ this.f44674v3);
        }

        public void process(ByteBuffer byteBuffer) {
            this.f44668b += 8;
            processM(byteBuffer.getLong());
        }

        public void processRemaining(ByteBuffer byteBuffer) {
            this.f44668b += (long) byteBuffer.remaining();
            int i11 = 0;
            while (byteBuffer.hasRemaining()) {
                this.finalM ^= (((long) byteBuffer.get()) & 255) << i11;
                i11 += 8;
            }
        }
    }

    public SipHashFunction(int i11, int i12, long j11, long j12) {
        boolean z11;
        boolean z12 = true;
        if (i11 > 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        Preconditions.checkArgument(z11, "The number of SipRound iterations (c=%s) during Compression must be positive.", i11);
        Preconditions.checkArgument(i12 <= 0 ? false : z12, "The number of SipRound iterations (d=%s) during Finalization must be positive.", i12);
        this.f44664c = i11;
        this.f44665d = i12;
        this.f44666k0 = j11;
        this.f44667k1 = j12;
    }

    public int bits() {
        return 64;
    }

    public boolean equals(@CheckForNull Object obj) {
        if (!(obj instanceof SipHashFunction)) {
            return false;
        }
        SipHashFunction sipHashFunction = (SipHashFunction) obj;
        if (this.f44664c == sipHashFunction.f44664c && this.f44665d == sipHashFunction.f44665d && this.f44666k0 == sipHashFunction.f44666k0 && this.f44667k1 == sipHashFunction.f44667k1) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (int) ((((long) ((SipHashFunction.class.hashCode() ^ this.f44664c) ^ this.f44665d)) ^ this.f44666k0) ^ this.f44667k1);
    }

    public Hasher newHasher() {
        return new SipHasher(this.f44664c, this.f44665d, this.f44666k0, this.f44667k1);
    }

    public String toString() {
        return "Hashing.sipHash" + this.f44664c + "" + this.f44665d + "(" + this.f44666k0 + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + this.f44667k1 + ")";
    }
}
