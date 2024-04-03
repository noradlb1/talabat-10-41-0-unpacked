package androidx.datastore.preferences.protobuf;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.security.PrivilegedExceptionAction;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

final class UnsafeUtil {
    private static final long BOOLEAN_ARRAY_BASE_OFFSET;
    private static final long BOOLEAN_ARRAY_INDEX_SCALE;
    private static final long BUFFER_ADDRESS_OFFSET = fieldOffset(bufferAddressField());
    private static final int BYTE_ARRAY_ALIGNMENT;
    private static final long DOUBLE_ARRAY_BASE_OFFSET;
    private static final long DOUBLE_ARRAY_INDEX_SCALE;
    private static final long FLOAT_ARRAY_BASE_OFFSET;
    private static final long FLOAT_ARRAY_INDEX_SCALE;
    private static final boolean HAS_UNSAFE_ARRAY_OPERATIONS = supportsUnsafeArrayOperations();
    private static final boolean HAS_UNSAFE_BYTEBUFFER_OPERATIONS = supportsUnsafeByteBufferOperations();
    private static final long INT_ARRAY_BASE_OFFSET;
    private static final long INT_ARRAY_INDEX_SCALE;
    private static final boolean IS_ANDROID_32 = determineAndroidSupportByAddressSize(Integer.TYPE);
    private static final boolean IS_ANDROID_64 = determineAndroidSupportByAddressSize(Long.TYPE);
    private static final long LONG_ARRAY_BASE_OFFSET;
    private static final long LONG_ARRAY_INDEX_SCALE;
    private static final MemoryAccessor MEMORY_ACCESSOR = getMemoryAccessor();
    private static final Class<?> MEMORY_CLASS = Android.a();
    private static final long OBJECT_ARRAY_BASE_OFFSET;
    private static final long OBJECT_ARRAY_INDEX_SCALE;
    private static final int STRIDE = 8;
    private static final int STRIDE_ALIGNMENT_MASK = 7;
    private static final Unsafe UNSAFE = v();

    /* renamed from: a  reason: collision with root package name */
    public static final long f35840a;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f35841b;
    private static final Logger logger = Logger.getLogger(UnsafeUtil.class.getName());

    public static final class Android32MemoryAccessor extends MemoryAccessor {
        private static final long SMALL_ADDRESS_MASK = -1;

        public Android32MemoryAccessor(Unsafe unsafe) {
            super(unsafe);
        }

        private static int smallAddress(long j11) {
            return (int) (j11 & -1);
        }

        public void copyMemory(long j11, byte[] bArr, long j12, long j13) {
            throw new UnsupportedOperationException();
        }

        public boolean getBoolean(Object obj, long j11) {
            if (UnsafeUtil.f35841b) {
                return UnsafeUtil.getBooleanBigEndian(obj, j11);
            }
            return UnsafeUtil.getBooleanLittleEndian(obj, j11);
        }

        public byte getByte(long j11) {
            throw new UnsupportedOperationException();
        }

        public double getDouble(Object obj, long j11) {
            return Double.longBitsToDouble(getLong(obj, j11));
        }

        public float getFloat(Object obj, long j11) {
            return Float.intBitsToFloat(getInt(obj, j11));
        }

        public int getInt(long j11) {
            throw new UnsupportedOperationException();
        }

        public long getLong(long j11) {
            throw new UnsupportedOperationException();
        }

        public Object getStaticObject(Field field) {
            try {
                return field.get((Object) null);
            } catch (IllegalAccessException unused) {
                return null;
            }
        }

        public void putBoolean(Object obj, long j11, boolean z11) {
            if (UnsafeUtil.f35841b) {
                UnsafeUtil.putBooleanBigEndian(obj, j11, z11);
            } else {
                UnsafeUtil.putBooleanLittleEndian(obj, j11, z11);
            }
        }

        public void putByte(long j11, byte b11) {
            throw new UnsupportedOperationException();
        }

        public void putDouble(Object obj, long j11, double d11) {
            putLong(obj, j11, Double.doubleToLongBits(d11));
        }

        public void putFloat(Object obj, long j11, float f11) {
            putInt(obj, j11, Float.floatToIntBits(f11));
        }

        public void putInt(long j11, int i11) {
            throw new UnsupportedOperationException();
        }

        public void putLong(long j11, long j12) {
            throw new UnsupportedOperationException();
        }

        public void copyMemory(byte[] bArr, long j11, long j12, long j13) {
            throw new UnsupportedOperationException();
        }

        public byte getByte(Object obj, long j11) {
            if (UnsafeUtil.f35841b) {
                return UnsafeUtil.getByteBigEndian(obj, j11);
            }
            return UnsafeUtil.getByteLittleEndian(obj, j11);
        }

        public void putByte(Object obj, long j11, byte b11) {
            if (UnsafeUtil.f35841b) {
                UnsafeUtil.putByteBigEndian(obj, j11, b11);
            } else {
                UnsafeUtil.putByteLittleEndian(obj, j11, b11);
            }
        }
    }

    public static final class Android64MemoryAccessor extends MemoryAccessor {
        public Android64MemoryAccessor(Unsafe unsafe) {
            super(unsafe);
        }

        public void copyMemory(long j11, byte[] bArr, long j12, long j13) {
            throw new UnsupportedOperationException();
        }

        public boolean getBoolean(Object obj, long j11) {
            if (UnsafeUtil.f35841b) {
                return UnsafeUtil.getBooleanBigEndian(obj, j11);
            }
            return UnsafeUtil.getBooleanLittleEndian(obj, j11);
        }

        public byte getByte(long j11) {
            throw new UnsupportedOperationException();
        }

        public double getDouble(Object obj, long j11) {
            return Double.longBitsToDouble(getLong(obj, j11));
        }

        public float getFloat(Object obj, long j11) {
            return Float.intBitsToFloat(getInt(obj, j11));
        }

        public int getInt(long j11) {
            throw new UnsupportedOperationException();
        }

        public long getLong(long j11) {
            throw new UnsupportedOperationException();
        }

        public Object getStaticObject(Field field) {
            try {
                return field.get((Object) null);
            } catch (IllegalAccessException unused) {
                return null;
            }
        }

        public void putBoolean(Object obj, long j11, boolean z11) {
            if (UnsafeUtil.f35841b) {
                UnsafeUtil.putBooleanBigEndian(obj, j11, z11);
            } else {
                UnsafeUtil.putBooleanLittleEndian(obj, j11, z11);
            }
        }

        public void putByte(long j11, byte b11) {
            throw new UnsupportedOperationException();
        }

        public void putDouble(Object obj, long j11, double d11) {
            putLong(obj, j11, Double.doubleToLongBits(d11));
        }

        public void putFloat(Object obj, long j11, float f11) {
            putInt(obj, j11, Float.floatToIntBits(f11));
        }

        public void putInt(long j11, int i11) {
            throw new UnsupportedOperationException();
        }

        public void putLong(long j11, long j12) {
            throw new UnsupportedOperationException();
        }

        public void copyMemory(byte[] bArr, long j11, long j12, long j13) {
            throw new UnsupportedOperationException();
        }

        public byte getByte(Object obj, long j11) {
            if (UnsafeUtil.f35841b) {
                return UnsafeUtil.getByteBigEndian(obj, j11);
            }
            return UnsafeUtil.getByteLittleEndian(obj, j11);
        }

        public void putByte(Object obj, long j11, byte b11) {
            if (UnsafeUtil.f35841b) {
                UnsafeUtil.putByteBigEndian(obj, j11, b11);
            } else {
                UnsafeUtil.putByteLittleEndian(obj, j11, b11);
            }
        }
    }

    public static final class JvmMemoryAccessor extends MemoryAccessor {
        public JvmMemoryAccessor(Unsafe unsafe) {
            super(unsafe);
        }

        public void copyMemory(long j11, byte[] bArr, long j12, long j13) {
            this.f35842a.copyMemory((Object) null, j11, bArr, UnsafeUtil.f35840a + j12, j13);
        }

        public boolean getBoolean(Object obj, long j11) {
            return this.f35842a.getBoolean(obj, j11);
        }

        public byte getByte(long j11) {
            return this.f35842a.getByte(j11);
        }

        public double getDouble(Object obj, long j11) {
            return this.f35842a.getDouble(obj, j11);
        }

        public float getFloat(Object obj, long j11) {
            return this.f35842a.getFloat(obj, j11);
        }

        public int getInt(long j11) {
            return this.f35842a.getInt(j11);
        }

        public long getLong(long j11) {
            return this.f35842a.getLong(j11);
        }

        public Object getStaticObject(Field field) {
            return getObject(this.f35842a.staticFieldBase(field), this.f35842a.staticFieldOffset(field));
        }

        public void putBoolean(Object obj, long j11, boolean z11) {
            this.f35842a.putBoolean(obj, j11, z11);
        }

        public void putByte(long j11, byte b11) {
            this.f35842a.putByte(j11, b11);
        }

        public void putDouble(Object obj, long j11, double d11) {
            this.f35842a.putDouble(obj, j11, d11);
        }

        public void putFloat(Object obj, long j11, float f11) {
            this.f35842a.putFloat(obj, j11, f11);
        }

        public void putInt(long j11, int i11) {
            this.f35842a.putInt(j11, i11);
        }

        public void putLong(long j11, long j12) {
            this.f35842a.putLong(j11, j12);
        }

        public void copyMemory(byte[] bArr, long j11, long j12, long j13) {
            this.f35842a.copyMemory(bArr, UnsafeUtil.f35840a + j11, (Object) null, j12, j13);
        }

        public byte getByte(Object obj, long j11) {
            return this.f35842a.getByte(obj, j11);
        }

        public void putByte(Object obj, long j11, byte b11) {
            this.f35842a.putByte(obj, j11, b11);
        }
    }

    public static abstract class MemoryAccessor {

        /* renamed from: a  reason: collision with root package name */
        public Unsafe f35842a;

        public MemoryAccessor(Unsafe unsafe) {
            this.f35842a = unsafe;
        }

        public final int arrayBaseOffset(Class<?> cls) {
            return this.f35842a.arrayBaseOffset(cls);
        }

        public final int arrayIndexScale(Class<?> cls) {
            return this.f35842a.arrayIndexScale(cls);
        }

        public abstract void copyMemory(long j11, byte[] bArr, long j12, long j13);

        public abstract void copyMemory(byte[] bArr, long j11, long j12, long j13);

        public abstract boolean getBoolean(Object obj, long j11);

        public abstract byte getByte(long j11);

        public abstract byte getByte(Object obj, long j11);

        public abstract double getDouble(Object obj, long j11);

        public abstract float getFloat(Object obj, long j11);

        public abstract int getInt(long j11);

        public final int getInt(Object obj, long j11) {
            return this.f35842a.getInt(obj, j11);
        }

        public abstract long getLong(long j11);

        public final long getLong(Object obj, long j11) {
            return this.f35842a.getLong(obj, j11);
        }

        public final Object getObject(Object obj, long j11) {
            return this.f35842a.getObject(obj, j11);
        }

        public abstract Object getStaticObject(Field field);

        public final long objectFieldOffset(Field field) {
            return this.f35842a.objectFieldOffset(field);
        }

        public abstract void putBoolean(Object obj, long j11, boolean z11);

        public abstract void putByte(long j11, byte b11);

        public abstract void putByte(Object obj, long j11, byte b11);

        public abstract void putDouble(Object obj, long j11, double d11);

        public abstract void putFloat(Object obj, long j11, float f11);

        public abstract void putInt(long j11, int i11);

        public final void putInt(Object obj, long j11, int i11) {
            this.f35842a.putInt(obj, j11, i11);
        }

        public abstract void putLong(long j11, long j12);

        public final void putLong(Object obj, long j11, long j12) {
            this.f35842a.putLong(obj, j11, j12);
        }

        public final void putObject(Object obj, long j11, Object obj2) {
            this.f35842a.putObject(obj, j11, obj2);
        }
    }

    static {
        boolean z11;
        long arrayBaseOffset = (long) arrayBaseOffset(byte[].class);
        f35840a = arrayBaseOffset;
        Class<boolean[]> cls = boolean[].class;
        BOOLEAN_ARRAY_BASE_OFFSET = (long) arrayBaseOffset(cls);
        BOOLEAN_ARRAY_INDEX_SCALE = (long) arrayIndexScale(cls);
        Class<int[]> cls2 = int[].class;
        INT_ARRAY_BASE_OFFSET = (long) arrayBaseOffset(cls2);
        INT_ARRAY_INDEX_SCALE = (long) arrayIndexScale(cls2);
        Class<long[]> cls3 = long[].class;
        LONG_ARRAY_BASE_OFFSET = (long) arrayBaseOffset(cls3);
        LONG_ARRAY_INDEX_SCALE = (long) arrayIndexScale(cls3);
        Class<float[]> cls4 = float[].class;
        FLOAT_ARRAY_BASE_OFFSET = (long) arrayBaseOffset(cls4);
        FLOAT_ARRAY_INDEX_SCALE = (long) arrayIndexScale(cls4);
        Class<double[]> cls5 = double[].class;
        DOUBLE_ARRAY_BASE_OFFSET = (long) arrayBaseOffset(cls5);
        DOUBLE_ARRAY_INDEX_SCALE = (long) arrayIndexScale(cls5);
        Class<Object[]> cls6 = Object[].class;
        OBJECT_ARRAY_BASE_OFFSET = (long) arrayBaseOffset(cls6);
        OBJECT_ARRAY_INDEX_SCALE = (long) arrayIndexScale(cls6);
        BYTE_ARRAY_ALIGNMENT = (int) (arrayBaseOffset & 7);
        if (ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN) {
            z11 = true;
        } else {
            z11 = false;
        }
        f35841b = z11;
    }

    private UnsafeUtil() {
    }

    public static void A(long j11, byte b11) {
        MEMORY_ACCESSOR.putByte(j11, b11);
    }

    public static void B(byte[] bArr, long j11, byte b11) {
        MEMORY_ACCESSOR.putByte(bArr, f35840a + j11, b11);
    }

    public static void C(Object obj, long j11, double d11) {
        MEMORY_ACCESSOR.putDouble(obj, j11, d11);
    }

    public static void D(Object obj, long j11, float f11) {
        MEMORY_ACCESSOR.putFloat(obj, j11, f11);
    }

    public static void E(Object obj, long j11, int i11) {
        MEMORY_ACCESSOR.putInt(obj, j11, i11);
    }

    public static void F(Object obj, long j11, long j12) {
        MEMORY_ACCESSOR.putLong(obj, j11, j12);
    }

    public static void G(Object obj, long j11, Object obj2) {
        MEMORY_ACCESSOR.putObject(obj, j11, obj2);
    }

    private static int arrayBaseOffset(Class<?> cls) {
        if (HAS_UNSAFE_ARRAY_OPERATIONS) {
            return MEMORY_ACCESSOR.arrayBaseOffset(cls);
        }
        return -1;
    }

    private static int arrayIndexScale(Class<?> cls) {
        if (HAS_UNSAFE_ARRAY_OPERATIONS) {
            return MEMORY_ACCESSOR.arrayIndexScale(cls);
        }
        return -1;
    }

    private static Field bufferAddressField() {
        Field field;
        Class<Buffer> cls = Buffer.class;
        if (Android.b() && (field = field(cls, "effectiveDirectAddress")) != null) {
            return field;
        }
        Field field2 = field(cls, "address");
        if (field2 == null || field2.getType() != Long.TYPE) {
            return null;
        }
        return field2;
    }

    private static boolean determineAndroidSupportByAddressSize(Class<?> cls) {
        Class<byte[]> cls2 = byte[].class;
        if (!Android.b()) {
            return false;
        }
        try {
            Class<?> cls3 = MEMORY_CLASS;
            Class cls4 = Boolean.TYPE;
            cls3.getMethod("peekLong", new Class[]{cls, cls4});
            cls3.getMethod("pokeLong", new Class[]{cls, Long.TYPE, cls4});
            Class cls5 = Integer.TYPE;
            cls3.getMethod("pokeInt", new Class[]{cls, cls5, cls4});
            cls3.getMethod("peekInt", new Class[]{cls, cls4});
            cls3.getMethod("pokeByte", new Class[]{cls, Byte.TYPE});
            cls3.getMethod("peekByte", new Class[]{cls});
            cls3.getMethod("pokeByteArray", new Class[]{cls, cls2, cls5, cls5});
            cls3.getMethod("peekByteArray", new Class[]{cls, cls2, cls5, cls5});
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    private static Field field(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    private static long fieldOffset(Field field) {
        MemoryAccessor memoryAccessor;
        if (field == null || (memoryAccessor = MEMORY_ACCESSOR) == null) {
            return -1;
        }
        return memoryAccessor.objectFieldOffset(field);
    }

    private static int firstDifferingByteIndexNativeEndian(long j11, long j12) {
        int i11;
        if (f35841b) {
            i11 = Long.numberOfLeadingZeros(j11 ^ j12);
        } else {
            i11 = Long.numberOfTrailingZeros(j11 ^ j12);
        }
        return i11 >> 3;
    }

    /* access modifiers changed from: private */
    public static boolean getBooleanBigEndian(Object obj, long j11) {
        return getByteBigEndian(obj, j11) != 0;
    }

    /* access modifiers changed from: private */
    public static boolean getBooleanLittleEndian(Object obj, long j11) {
        return getByteLittleEndian(obj, j11) != 0;
    }

    /* access modifiers changed from: private */
    public static byte getByteBigEndian(Object obj, long j11) {
        return (byte) ((r(obj, -4 & j11) >>> ((int) (((~j11) & 3) << 3))) & 255);
    }

    /* access modifiers changed from: private */
    public static byte getByteLittleEndian(Object obj, long j11) {
        return (byte) ((r(obj, -4 & j11) >>> ((int) ((j11 & 3) << 3))) & 255);
    }

    private static MemoryAccessor getMemoryAccessor() {
        Unsafe unsafe = UNSAFE;
        if (unsafe == null) {
            return null;
        }
        if (!Android.b()) {
            return new JvmMemoryAccessor(unsafe);
        }
        if (IS_ANDROID_64) {
            return new Android64MemoryAccessor(unsafe);
        }
        if (IS_ANDROID_32) {
            return new Android32MemoryAccessor(unsafe);
        }
        return null;
    }

    public static long i(ByteBuffer byteBuffer) {
        return MEMORY_ACCESSOR.getLong(byteBuffer, BUFFER_ADDRESS_OFFSET);
    }

    public static <T> T j(Class<T> cls) {
        try {
            return UNSAFE.allocateInstance(cls);
        } catch (InstantiationException e11) {
            throw new IllegalStateException(e11);
        }
    }

    public static void k(long j11, byte[] bArr, long j12, long j13) {
        MEMORY_ACCESSOR.copyMemory(j11, bArr, j12, j13);
    }

    public static void l(byte[] bArr, long j11, long j12, long j13) {
        MEMORY_ACCESSOR.copyMemory(bArr, j11, j12, j13);
    }

    public static boolean m(Object obj, long j11) {
        return MEMORY_ACCESSOR.getBoolean(obj, j11);
    }

    public static byte n(long j11) {
        return MEMORY_ACCESSOR.getByte(j11);
    }

    public static byte o(byte[] bArr, long j11) {
        return MEMORY_ACCESSOR.getByte(bArr, f35840a + j11);
    }

    public static double p(Object obj, long j11) {
        return MEMORY_ACCESSOR.getDouble(obj, j11);
    }

    /* access modifiers changed from: private */
    public static void putBooleanBigEndian(Object obj, long j11, boolean z11) {
        putByteBigEndian(obj, j11, z11 ? (byte) 1 : 0);
    }

    /* access modifiers changed from: private */
    public static void putBooleanLittleEndian(Object obj, long j11, boolean z11) {
        putByteLittleEndian(obj, j11, z11 ? (byte) 1 : 0);
    }

    /* access modifiers changed from: private */
    public static void putByteBigEndian(Object obj, long j11, byte b11) {
        long j12 = -4 & j11;
        int r11 = r(obj, j12);
        int i11 = ((~((int) j11)) & 3) << 3;
        E(obj, j12, ((255 & b11) << i11) | (r11 & (~(255 << i11))));
    }

    /* access modifiers changed from: private */
    public static void putByteLittleEndian(Object obj, long j11, byte b11) {
        long j12 = -4 & j11;
        int i11 = (((int) j11) & 3) << 3;
        E(obj, j12, ((255 & b11) << i11) | (r(obj, j12) & (~(255 << i11))));
    }

    public static float q(Object obj, long j11) {
        return MEMORY_ACCESSOR.getFloat(obj, j11);
    }

    public static int r(Object obj, long j11) {
        return MEMORY_ACCESSOR.getInt(obj, j11);
    }

    public static long s(long j11) {
        return MEMORY_ACCESSOR.getLong(j11);
    }

    private static boolean supportsUnsafeArrayOperations() {
        Class<Class> cls = Class.class;
        Class<Object> cls2 = Object.class;
        Unsafe unsafe = UNSAFE;
        if (unsafe == null) {
            return false;
        }
        try {
            Class<?> cls3 = unsafe.getClass();
            cls3.getMethod("objectFieldOffset", new Class[]{Field.class});
            cls3.getMethod("arrayBaseOffset", new Class[]{cls});
            cls3.getMethod("arrayIndexScale", new Class[]{cls});
            Class cls4 = Long.TYPE;
            cls3.getMethod("getInt", new Class[]{cls2, cls4});
            cls3.getMethod("putInt", new Class[]{cls2, cls4, Integer.TYPE});
            cls3.getMethod("getLong", new Class[]{cls2, cls4});
            cls3.getMethod("putLong", new Class[]{cls2, cls4, cls4});
            cls3.getMethod("getObject", new Class[]{cls2, cls4});
            cls3.getMethod("putObject", new Class[]{cls2, cls4, cls2});
            if (Android.b()) {
                return true;
            }
            cls3.getMethod("getByte", new Class[]{cls2, cls4});
            cls3.getMethod("putByte", new Class[]{cls2, cls4, Byte.TYPE});
            cls3.getMethod("getBoolean", new Class[]{cls2, cls4});
            cls3.getMethod("putBoolean", new Class[]{cls2, cls4, Boolean.TYPE});
            cls3.getMethod("getFloat", new Class[]{cls2, cls4});
            cls3.getMethod("putFloat", new Class[]{cls2, cls4, Float.TYPE});
            cls3.getMethod("getDouble", new Class[]{cls2, cls4});
            cls3.getMethod("putDouble", new Class[]{cls2, cls4, Double.TYPE});
            return true;
        } catch (Throwable th2) {
            Logger logger2 = logger;
            Level level = Level.WARNING;
            logger2.log(level, "platform method missing - proto runtime falling back to safer methods: " + th2);
            return false;
        }
    }

    private static boolean supportsUnsafeByteBufferOperations() {
        Class<Object> cls = Object.class;
        Unsafe unsafe = UNSAFE;
        if (unsafe == null) {
            return false;
        }
        try {
            Class<?> cls2 = unsafe.getClass();
            cls2.getMethod("objectFieldOffset", new Class[]{Field.class});
            Class cls3 = Long.TYPE;
            cls2.getMethod("getLong", new Class[]{cls, cls3});
            if (bufferAddressField() == null) {
                return false;
            }
            if (Android.b()) {
                return true;
            }
            cls2.getMethod("getByte", new Class[]{cls3});
            cls2.getMethod("putByte", new Class[]{cls3, Byte.TYPE});
            cls2.getMethod("getInt", new Class[]{cls3});
            cls2.getMethod("putInt", new Class[]{cls3, Integer.TYPE});
            cls2.getMethod("getLong", new Class[]{cls3});
            cls2.getMethod("putLong", new Class[]{cls3, cls3});
            cls2.getMethod("copyMemory", new Class[]{cls3, cls3, cls3});
            cls2.getMethod("copyMemory", new Class[]{cls, cls3, cls, cls3, cls3});
            return true;
        } catch (Throwable th2) {
            Logger logger2 = logger;
            Level level = Level.WARNING;
            logger2.log(level, "platform method missing - proto runtime falling back to safer methods: " + th2);
            return false;
        }
    }

    public static long t(Object obj, long j11) {
        return MEMORY_ACCESSOR.getLong(obj, j11);
    }

    public static Object u(Object obj, long j11) {
        return MEMORY_ACCESSOR.getObject(obj, j11);
    }

    public static Unsafe v() {
        try {
            return (Unsafe) AccessController.doPrivileged(new PrivilegedExceptionAction<Unsafe>() {
                public Unsafe run() throws Exception {
                    Class<Unsafe> cls = Unsafe.class;
                    for (Field field : cls.getDeclaredFields()) {
                        field.setAccessible(true);
                        Object obj = field.get((Object) null);
                        if (cls.isInstance(obj)) {
                            return cls.cast(obj);
                        }
                    }
                    return null;
                }
            });
        } catch (Throwable unused) {
            return null;
        }
    }

    public static boolean w() {
        return HAS_UNSAFE_ARRAY_OPERATIONS;
    }

    public static boolean x() {
        return HAS_UNSAFE_BYTEBUFFER_OPERATIONS;
    }

    public static long y(Field field) {
        return MEMORY_ACCESSOR.objectFieldOffset(field);
    }

    public static void z(Object obj, long j11, boolean z11) {
        MEMORY_ACCESSOR.putBoolean(obj, j11, z11);
    }
}
