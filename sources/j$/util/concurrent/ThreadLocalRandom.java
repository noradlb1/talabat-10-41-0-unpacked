package j$.util.concurrent;

import j$.util.stream.C0270p0;
import j$.util.stream.H;
import j$.util.stream.IntStream;
import j$.util.stream.StreamSupport;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamField;
import java.security.AccessController;
import java.security.SecureRandom;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class ThreadLocalRandom extends Random {

    /* renamed from: d  reason: collision with root package name */
    private static final ThreadLocal f28675d = new ThreadLocal();

    /* renamed from: e  reason: collision with root package name */
    private static final AtomicInteger f28676e = new AtomicInteger();

    /* renamed from: f  reason: collision with root package name */
    private static final ThreadLocal f28677f = new T();

    /* renamed from: g  reason: collision with root package name */
    private static final AtomicLong f28678g = new AtomicLong(h(System.currentTimeMillis()) ^ h(System.nanoTime()));
    private static final ObjectStreamField[] serialPersistentFields = {new ObjectStreamField("rnd", Long.TYPE), new ObjectStreamField("initialized", Boolean.TYPE)};
    private static final long serialVersionUID = -5851777807851030925L;

    /* renamed from: a  reason: collision with root package name */
    long f28679a;

    /* renamed from: b  reason: collision with root package name */
    int f28680b;

    /* renamed from: c  reason: collision with root package name */
    boolean f28681c;

    static {
        if (((Boolean) AccessController.doPrivileged(new U())).booleanValue()) {
            byte[] seed = SecureRandom.getSeed(8);
            long j11 = ((long) seed[0]) & 255;
            for (int i11 = 1; i11 < 8; i11++) {
                j11 = (j11 << 8) | (((long) seed[i11]) & 255);
            }
            f28678g.set(j11);
        }
    }

    private ThreadLocalRandom() {
        this.f28681c = true;
    }

    /* synthetic */ ThreadLocalRandom(int i11) {
        this();
    }

    static final int a(int i11) {
        int i12 = i11 ^ (i11 << 13);
        int i13 = i12 ^ (i12 >>> 17);
        int i14 = i13 ^ (i13 << 5);
        ((ThreadLocalRandom) f28677f.get()).f28680b = i14;
        return i14;
    }

    static final int b() {
        return ((ThreadLocalRandom) f28677f.get()).f28680b;
    }

    public static ThreadLocalRandom current() {
        ThreadLocalRandom threadLocalRandom = (ThreadLocalRandom) f28677f.get();
        if (threadLocalRandom.f28680b == 0) {
            f();
        }
        return threadLocalRandom;
    }

    static final void f() {
        int addAndGet = f28676e.addAndGet(-1640531527);
        if (addAndGet == 0) {
            addAndGet = 1;
        }
        long h11 = h(f28678g.getAndAdd(-4942790177534073029L));
        ThreadLocalRandom threadLocalRandom = (ThreadLocalRandom) f28677f.get();
        threadLocalRandom.f28679a = h11;
        threadLocalRandom.f28680b = addAndGet;
    }

    private static int g(long j11) {
        long j12 = (j11 ^ (j11 >>> 33)) * -49064778989728563L;
        return (int) (((j12 ^ (j12 >>> 33)) * -4265267296055464877L) >>> 32);
    }

    private static long h(long j11) {
        long j12 = (j11 ^ (j11 >>> 33)) * -49064778989728563L;
        long j13 = (j12 ^ (j12 >>> 33)) * -4265267296055464877L;
        return j13 ^ (j13 >>> 33);
    }

    private Object readResolve() {
        return current();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        ObjectOutputStream.PutField putFields = objectOutputStream.putFields();
        putFields.put("rnd", this.f28679a);
        putFields.put("initialized", true);
        objectOutputStream.writeFields();
    }

    /* access modifiers changed from: package-private */
    public final double c(double d11, double d12) {
        double nextLong = ((double) (nextLong() >>> 11)) * 1.1102230246251565E-16d;
        if (d11 >= d12) {
            return nextLong;
        }
        double d13 = ((d12 - d11) * nextLong) + d11;
        return d13 >= d12 ? Double.longBitsToDouble(Double.doubleToLongBits(d12) - 1) : d13;
    }

    /* access modifiers changed from: package-private */
    public final int d(int i11, int i12) {
        int i13;
        int g11 = g(i());
        if (i11 >= i12) {
            return g11;
        }
        int i14 = i12 - i11;
        int i15 = i14 - 1;
        if ((i14 & i15) == 0) {
            i13 = g11 & i15;
        } else if (i14 > 0) {
            int i16 = g11 >>> 1;
            while (true) {
                int i17 = i16 + i15;
                i13 = i16 % i14;
                if (i17 - i13 >= 0) {
                    break;
                }
                i16 = g(i()) >>> 1;
            }
        } else {
            while (true) {
                if (g11 >= i11 && g11 < i12) {
                    return g11;
                }
                g11 = g(i());
            }
        }
        return i13 + i11;
    }

    public final DoubleStream doubles() {
        return H.v(StreamSupport.a(new V(0, Long.MAX_VALUE, Double.MAX_VALUE, 0.0d)));
    }

    public final DoubleStream doubles(double d11, double d12) {
        if (d11 < d12) {
            return H.v(StreamSupport.a(new V(0, Long.MAX_VALUE, d11, d12)));
        }
        throw new IllegalArgumentException("bound must be greater than origin");
    }

    public final DoubleStream doubles(long j11) {
        if (j11 >= 0) {
            return H.v(StreamSupport.a(new V(0, j11, Double.MAX_VALUE, 0.0d)));
        }
        throw new IllegalArgumentException("size must be non-negative");
    }

    public final DoubleStream doubles(long j11, double d11, double d12) {
        if (j11 < 0) {
            throw new IllegalArgumentException("size must be non-negative");
        } else if (d11 < d12) {
            return H.v(StreamSupport.a(new V(0, j11, d11, d12)));
        } else {
            throw new IllegalArgumentException("bound must be greater than origin");
        }
    }

    /* access modifiers changed from: package-private */
    public final long e(long j11, long j12) {
        long h11 = h(i());
        if (j11 >= j12) {
            return h11;
        }
        long j13 = j12 - j11;
        long j14 = j13 - 1;
        if ((j13 & j14) == 0) {
            return (h11 & j14) + j11;
        }
        if (j13 > 0) {
            while (true) {
                long j15 = h11 >>> 1;
                long j16 = j15 + j14;
                long j17 = j15 % j13;
                if (j16 - j17 >= 0) {
                    return j17 + j11;
                }
                h11 = h(i());
            }
        } else {
            while (true) {
                if (h11 >= j11 && h11 < j12) {
                    return h11;
                }
                h11 = h(i());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final long i() {
        long j11 = this.f28679a - 7046029254386353131L;
        this.f28679a = j11;
        return j11;
    }

    public final IntStream ints() {
        return IntStream.Wrapper.convert(StreamSupport.b(new W(0, Long.MAX_VALUE, Integer.MAX_VALUE, 0)));
    }

    public final java.util.stream.IntStream ints(int i11, int i12) {
        if (i11 < i12) {
            return IntStream.Wrapper.convert(StreamSupport.b(new W(0, Long.MAX_VALUE, i11, i12)));
        }
        throw new IllegalArgumentException("bound must be greater than origin");
    }

    public final java.util.stream.IntStream ints(long j11) {
        if (j11 >= 0) {
            return IntStream.Wrapper.convert(StreamSupport.b(new W(0, j11, Integer.MAX_VALUE, 0)));
        }
        throw new IllegalArgumentException("size must be non-negative");
    }

    public final java.util.stream.IntStream ints(long j11, int i11, int i12) {
        if (j11 < 0) {
            throw new IllegalArgumentException("size must be non-negative");
        } else if (i11 < i12) {
            return IntStream.Wrapper.convert(StreamSupport.b(new W(0, j11, i11, i12)));
        } else {
            throw new IllegalArgumentException("bound must be greater than origin");
        }
    }

    public final LongStream longs() {
        return C0270p0.v(StreamSupport.c(new X(0, Long.MAX_VALUE, Long.MAX_VALUE, 0)));
    }

    public final LongStream longs(long j11) {
        if (j11 >= 0) {
            return C0270p0.v(StreamSupport.c(new X(0, j11, Long.MAX_VALUE, 0)));
        }
        throw new IllegalArgumentException("size must be non-negative");
    }

    public final LongStream longs(long j11, long j12) {
        if (j11 < j12) {
            return C0270p0.v(StreamSupport.c(new X(0, Long.MAX_VALUE, j11, j12)));
        }
        throw new IllegalArgumentException("bound must be greater than origin");
    }

    public final LongStream longs(long j11, long j12, long j13) {
        if (j11 < 0) {
            throw new IllegalArgumentException("size must be non-negative");
        } else if (j12 < j13) {
            return C0270p0.v(StreamSupport.c(new X(0, j11, j12, j13)));
        } else {
            throw new IllegalArgumentException("bound must be greater than origin");
        }
    }

    /* access modifiers changed from: protected */
    public final int next(int i11) {
        return nextInt() >>> (32 - i11);
    }

    public final boolean nextBoolean() {
        return g(i()) < 0;
    }

    public final double nextDouble() {
        return ((double) (h(i()) >>> 11)) * 1.1102230246251565E-16d;
    }

    public double nextDouble(double d11) {
        if (d11 > 0.0d) {
            double h11 = ((double) (h(i()) >>> 11)) * 1.1102230246251565E-16d * d11;
            return h11 < d11 ? h11 : Double.longBitsToDouble(Double.doubleToLongBits(d11) - 1);
        }
        throw new IllegalArgumentException("bound must be positive");
    }

    public final float nextFloat() {
        return ((float) (g(i()) >>> 8)) * 5.9604645E-8f;
    }

    public final double nextGaussian() {
        ThreadLocal threadLocal = f28675d;
        Double d11 = (Double) threadLocal.get();
        if (d11 != null) {
            threadLocal.set((Object) null);
            return d11.doubleValue();
        }
        while (true) {
            double nextDouble = (nextDouble() * 2.0d) - 1.0d;
            double nextDouble2 = (nextDouble() * 2.0d) - 1.0d;
            double d12 = (nextDouble2 * nextDouble2) + (nextDouble * nextDouble);
            if (d12 < 1.0d && d12 != 0.0d) {
                double sqrt = StrictMath.sqrt((StrictMath.log(d12) * -2.0d) / d12);
                threadLocal.set(Double.valueOf(nextDouble2 * sqrt));
                return nextDouble * sqrt;
            }
        }
    }

    public int nextInt() {
        return g(i());
    }

    public final int nextInt(int i11) {
        if (i11 > 0) {
            int g11 = g(i());
            int i12 = i11 - 1;
            if ((i11 & i12) == 0) {
                return g11 & i12;
            }
            while (true) {
                int i13 = g11 >>> 1;
                int i14 = i13 + i12;
                int i15 = i13 % i11;
                if (i14 - i15 >= 0) {
                    return i15;
                }
                g11 = g(i());
            }
        } else {
            throw new IllegalArgumentException("bound must be positive");
        }
    }

    public int nextInt(int i11, int i12) {
        if (i11 < i12) {
            return d(i11, i12);
        }
        throw new IllegalArgumentException("bound must be greater than origin");
    }

    public final long nextLong() {
        return h(i());
    }

    public long nextLong(long j11) {
        if (j11 > 0) {
            long h11 = h(i());
            long j12 = j11 - 1;
            if ((j11 & j12) == 0) {
                return h11 & j12;
            }
            while (true) {
                long j13 = h11 >>> 1;
                long j14 = j13 + j12;
                long j15 = j13 % j11;
                if (j14 - j15 >= 0) {
                    return j15;
                }
                h11 = h(i());
            }
        } else {
            throw new IllegalArgumentException("bound must be positive");
        }
    }

    public long nextLong(long j11, long j12) {
        if (j11 < j12) {
            return e(j11, j12);
        }
        throw new IllegalArgumentException("bound must be greater than origin");
    }

    public final void setSeed(long j11) {
        if (this.f28681c) {
            throw new UnsupportedOperationException();
        }
    }
}
