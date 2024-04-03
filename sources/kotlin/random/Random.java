package kotlin.random;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.internal.PlatformImplementationsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\b'\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H&J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016J$\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\u00042\b\b\u0002\u0010\f\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0004H\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0004H\u0016J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0004H\u0016J\u0018\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0004H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0010\u001a\u00020\u0016H\u0016J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0011\u001a\u00020\u00162\u0006\u0010\u0010\u001a\u00020\u0016H\u0016¨\u0006\u0018"}, d2 = {"Lkotlin/random/Random;", "", "()V", "nextBits", "", "bitCount", "nextBoolean", "", "nextBytes", "", "array", "fromIndex", "toIndex", "size", "nextDouble", "", "until", "from", "nextFloat", "", "nextInt", "nextLong", "", "Default", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
@SinceKotlin(version = "1.3")
public abstract class Random {
    @NotNull
    public static final Default Default = new Default((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @NotNull
    public static final Random defaultRandom = PlatformImplementationsKt.IMPLEMENTATIONS.defaultPlatformRandom();

    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u00012\u00060\u0002j\u0002`\u0003:\u0001\u001cB\u0007\b\u0002¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0016J \u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0007H\u0016J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0007H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0007H\u0016J\u0010\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0007H\u0016J\u0018\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0007H\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0013\u001a\u00020\u0019H\u0016J\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0014\u001a\u00020\u00192\u0006\u0010\u0013\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u001bH\u0002R\u000e\u0010\u0005\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lkotlin/random/Random$Default;", "Lkotlin/random/Random;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "()V", "defaultRandom", "nextBits", "", "bitCount", "nextBoolean", "", "nextBytes", "", "array", "fromIndex", "toIndex", "size", "nextDouble", "", "until", "from", "nextFloat", "", "nextInt", "nextLong", "", "writeReplace", "", "Serialized", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Default extends Random implements Serializable {

        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0000\n\u0000\bÂ\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lkotlin/random/Random$Default$Serialized;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "()V", "serialVersionUID", "", "readResolve", "", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class Serialized implements Serializable {
            @NotNull
            public static final Serialized INSTANCE = new Serialized();
            private static final long serialVersionUID = 0;

            private Serialized() {
            }

            private final Object readResolve() {
                return Random.Default;
            }
        }

        private Default() {
        }

        public /* synthetic */ Default(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final Object writeReplace() {
            return Serialized.INSTANCE;
        }

        public int nextBits(int i11) {
            return Random.defaultRandom.nextBits(i11);
        }

        public boolean nextBoolean() {
            return Random.defaultRandom.nextBoolean();
        }

        @NotNull
        public byte[] nextBytes(@NotNull byte[] bArr) {
            Intrinsics.checkNotNullParameter(bArr, "array");
            return Random.defaultRandom.nextBytes(bArr);
        }

        public double nextDouble() {
            return Random.defaultRandom.nextDouble();
        }

        public float nextFloat() {
            return Random.defaultRandom.nextFloat();
        }

        public int nextInt() {
            return Random.defaultRandom.nextInt();
        }

        public long nextLong() {
            return Random.defaultRandom.nextLong();
        }

        @NotNull
        public byte[] nextBytes(int i11) {
            return Random.defaultRandom.nextBytes(i11);
        }

        public double nextDouble(double d11) {
            return Random.defaultRandom.nextDouble(d11);
        }

        public int nextInt(int i11) {
            return Random.defaultRandom.nextInt(i11);
        }

        public long nextLong(long j11) {
            return Random.defaultRandom.nextLong(j11);
        }

        @NotNull
        public byte[] nextBytes(@NotNull byte[] bArr, int i11, int i12) {
            Intrinsics.checkNotNullParameter(bArr, "array");
            return Random.defaultRandom.nextBytes(bArr, i11, i12);
        }

        public double nextDouble(double d11, double d12) {
            return Random.defaultRandom.nextDouble(d11, d12);
        }

        public int nextInt(int i11, int i12) {
            return Random.defaultRandom.nextInt(i11, i12);
        }

        public long nextLong(long j11, long j12) {
            return Random.defaultRandom.nextLong(j11, j12);
        }
    }

    public static /* synthetic */ byte[] nextBytes$default(Random random, byte[] bArr, int i11, int i12, int i13, Object obj) {
        if (obj == null) {
            if ((i13 & 2) != 0) {
                i11 = 0;
            }
            if ((i13 & 4) != 0) {
                i12 = bArr.length;
            }
            return random.nextBytes(bArr, i11, i12);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: nextBytes");
    }

    public abstract int nextBits(int i11);

    public boolean nextBoolean() {
        return nextBits(1) != 0;
    }

    @NotNull
    public byte[] nextBytes(@NotNull byte[] bArr, int i11, int i12) {
        Intrinsics.checkNotNullParameter(bArr, "array");
        boolean z11 = true;
        if (new IntRange(0, bArr.length).contains(i11) && new IntRange(0, bArr.length).contains(i12)) {
            if (i11 > i12) {
                z11 = false;
            }
            if (z11) {
                int i13 = (i12 - i11) / 4;
                for (int i14 = 0; i14 < i13; i14++) {
                    int nextInt = nextInt();
                    bArr[i11] = (byte) nextInt;
                    bArr[i11 + 1] = (byte) (nextInt >>> 8);
                    bArr[i11 + 2] = (byte) (nextInt >>> 16);
                    bArr[i11 + 3] = (byte) (nextInt >>> 24);
                    i11 += 4;
                }
                int i15 = i12 - i11;
                int nextBits = nextBits(i15 * 8);
                for (int i16 = 0; i16 < i15; i16++) {
                    bArr[i11 + i16] = (byte) (nextBits >>> (i16 * 8));
                }
                return bArr;
            }
            throw new IllegalArgumentException(("fromIndex (" + i11 + ") must be not greater than toIndex (" + i12 + ").").toString());
        }
        throw new IllegalArgumentException(("fromIndex (" + i11 + ") or toIndex (" + i12 + ") are out of range: 0.." + bArr.length + '.').toString());
    }

    public double nextDouble() {
        return PlatformRandomKt.doubleFromParts(nextBits(26), nextBits(27));
    }

    public float nextFloat() {
        return ((float) nextBits(24)) / 1.6777216E7f;
    }

    public int nextInt() {
        return nextBits(32);
    }

    public long nextLong() {
        return (((long) nextInt()) << 32) + ((long) nextInt());
    }

    public double nextDouble(double d11) {
        return nextDouble(0.0d, d11);
    }

    public int nextInt(int i11) {
        return nextInt(0, i11);
    }

    public long nextLong(long j11) {
        return nextLong(0, j11);
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0047  */
    /* JADX WARNING: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public double nextDouble(double r7, double r9) {
        /*
            r6 = this;
            kotlin.random.RandomKt.checkRangeBounds((double) r7, (double) r9)
            double r0 = r9 - r7
            boolean r2 = java.lang.Double.isInfinite(r0)
            if (r2 == 0) goto L_0x003d
            boolean r2 = java.lang.Double.isInfinite(r7)
            r3 = 1
            r4 = 0
            if (r2 != 0) goto L_0x001b
            boolean r2 = java.lang.Double.isNaN(r7)
            if (r2 != 0) goto L_0x001b
            r2 = r3
            goto L_0x001c
        L_0x001b:
            r2 = r4
        L_0x001c:
            if (r2 == 0) goto L_0x003d
            boolean r2 = java.lang.Double.isInfinite(r9)
            if (r2 != 0) goto L_0x002b
            boolean r2 = java.lang.Double.isNaN(r9)
            if (r2 != 0) goto L_0x002b
            goto L_0x002c
        L_0x002b:
            r3 = r4
        L_0x002c:
            if (r3 == 0) goto L_0x003d
            double r0 = r6.nextDouble()
            r2 = 2
            double r2 = (double) r2
            double r4 = r9 / r2
            double r2 = r7 / r2
            double r4 = r4 - r2
            double r0 = r0 * r4
            double r7 = r7 + r0
            double r7 = r7 + r0
            goto L_0x0043
        L_0x003d:
            double r2 = r6.nextDouble()
            double r2 = r2 * r0
            double r7 = r7 + r2
        L_0x0043:
            int r0 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r0 < 0) goto L_0x004d
            r7 = -4503599627370496(0xfff0000000000000, double:-Infinity)
            double r7 = java.lang.Math.nextAfter(r9, r7)
        L_0x004d:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.random.Random.nextDouble(double, double):double");
    }

    public int nextInt(int i11, int i12) {
        int i13;
        int nextInt;
        int i14;
        int nextInt2;
        boolean z11;
        RandomKt.checkRangeBounds(i11, i12);
        int i15 = i12 - i11;
        if (i15 > 0 || i15 == Integer.MIN_VALUE) {
            if (((-i15) & i15) == i15) {
                i13 = nextBits(RandomKt.fastLog2(i15));
            } else {
                do {
                    nextInt = nextInt() >>> 1;
                    i14 = nextInt % i15;
                } while ((nextInt - i14) + (i15 - 1) < 0);
                i13 = i14;
            }
            return i11 + i13;
        }
        do {
            nextInt2 = nextInt();
            z11 = false;
            if (i11 <= nextInt2 && nextInt2 < i12) {
                z11 = true;
                continue;
            }
        } while (!z11);
        return nextInt2;
    }

    public long nextLong(long j11, long j12) {
        long nextLong;
        boolean z11;
        long j13;
        long nextLong2;
        long j14;
        int nextInt;
        RandomKt.checkRangeBounds(j11, j12);
        long j15 = j12 - j11;
        if (j15 > 0) {
            if (((-j15) & j15) == j15) {
                int i11 = (int) j15;
                int i12 = (int) (j15 >>> 32);
                if (i11 != 0) {
                    nextInt = nextBits(RandomKt.fastLog2(i11));
                } else if (i12 == 1) {
                    nextInt = nextInt();
                } else {
                    j13 = (((long) nextBits(RandomKt.fastLog2(i12))) << 32) + (((long) nextInt()) & 4294967295L);
                }
                j13 = ((long) nextInt) & 4294967295L;
            } else {
                do {
                    nextLong2 = nextLong() >>> 1;
                    j14 = nextLong2 % j15;
                } while ((nextLong2 - j14) + (j15 - 1) < 0);
                j13 = j14;
            }
            return j11 + j13;
        }
        do {
            nextLong = nextLong();
            z11 = false;
            if (j11 <= nextLong && nextLong < j12) {
                z11 = true;
                continue;
            }
        } while (!z11);
        return nextLong;
    }

    @NotNull
    public byte[] nextBytes(@NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "array");
        return nextBytes(bArr, 0, bArr.length);
    }

    @NotNull
    public byte[] nextBytes(int i11) {
        return nextBytes(new byte[i11]);
    }
}
