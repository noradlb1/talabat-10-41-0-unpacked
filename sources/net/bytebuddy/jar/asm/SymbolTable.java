package net.bytebuddy.jar.asm;

final class SymbolTable {

    /* renamed from: a  reason: collision with root package name */
    public final ClassWriter f27413a;
    private int bootstrapMethodCount;
    private ByteVector bootstrapMethods;
    private String className;
    private ByteVector constantPool;
    private int constantPoolCount;
    private Entry[] entries;
    private int entryCount;
    private int majorVersion;
    private final ClassReader sourceClassReader;
    private int typeCount;
    private Entry[] typeTable;

    public SymbolTable(ClassWriter classWriter) {
        this.f27413a = classWriter;
        this.sourceClassReader = null;
        this.entries = new Entry[256];
        this.constantPoolCount = 1;
        this.constantPool = new ByteVector();
    }

    private void add(Entry entry) {
        this.entryCount++;
        int i11 = entry.f27414h;
        Entry[] entryArr = this.entries;
        int length = i11 % entryArr.length;
        entry.f27415i = entryArr[length];
        entryArr[length] = entry;
    }

    private Symbol addBootstrapMethod(int i11, int i12, int i13) {
        byte[] bArr = this.bootstrapMethods.f27349a;
        for (Entry entry = get(i13); entry != null; entry = entry.f27415i) {
            if (entry.f27407b == 64 && entry.f27414h == i13) {
                int i14 = (int) entry.f27411f;
                boolean z11 = false;
                int i15 = 0;
                while (true) {
                    if (i15 >= i12) {
                        z11 = true;
                        break;
                    } else if (bArr[i11 + i15] != bArr[i14 + i15]) {
                        break;
                    } else {
                        i15++;
                    }
                }
                if (z11) {
                    this.bootstrapMethods.f27350b = i11;
                    return entry;
                }
            }
        }
        int i16 = this.bootstrapMethodCount;
        this.bootstrapMethodCount = i16 + 1;
        return put(new Entry(i16, 64, (long) i11, i13));
    }

    private Symbol addConstantDynamicOrInvokeDynamicReference(int i11, String str, String str2, int i12) {
        int hash = hash(i11, str, str2, i12);
        for (Entry entry = get(hash); entry != null; entry = entry.f27415i) {
            if (entry.f27407b == i11 && entry.f27414h == hash && entry.f27411f == ((long) i12) && entry.f27409d.equals(str) && entry.f27410e.equals(str2)) {
                return entry;
            }
        }
        this.constantPool.e(i11, i12, o(str, str2));
        int i13 = this.constantPoolCount;
        this.constantPoolCount = i13 + 1;
        return put(new Entry(i13, i11, (String) null, str, str2, (long) i12, hash));
    }

    private Symbol addConstantIntegerOrFloat(int i11, int i12) {
        int hash = hash(i11, i12);
        for (Entry entry = get(hash); entry != null; entry = entry.f27415i) {
            if (entry.f27407b == i11 && entry.f27414h == hash && entry.f27411f == ((long) i12)) {
                return entry;
            }
        }
        this.constantPool.putByte(i11).putInt(i12);
        int i13 = this.constantPoolCount;
        this.constantPoolCount = i13 + 1;
        return put(new Entry(i13, i11, (long) i12, hash));
    }

    private Symbol addConstantLongOrDouble(int i11, long j11) {
        int hash = hash(i11, j11);
        for (Entry entry = get(hash); entry != null; entry = entry.f27415i) {
            if (entry.f27407b == i11 && entry.f27414h == hash && entry.f27411f == j11) {
                return entry;
            }
        }
        int i12 = this.constantPoolCount;
        this.constantPool.putByte(i11).putLong(j11);
        this.constantPoolCount += 2;
        return put(new Entry(i12, i11, j11, hash));
    }

    private Entry addConstantMemberReference(int i11, String str, String str2, String str3) {
        int hash = hash(i11, str, str2, str3);
        for (Entry entry = get(hash); entry != null; entry = entry.f27415i) {
            if (entry.f27407b == i11 && entry.f27414h == hash && entry.f27408c.equals(str) && entry.f27409d.equals(str2) && entry.f27410e.equals(str3)) {
                return entry;
            }
        }
        this.constantPool.e(i11, c(str).f27406a, o(str2, str3));
        int i12 = this.constantPoolCount;
        this.constantPoolCount = i12 + 1;
        return put(new Entry(i12, i11, str, str2, str3, 0, hash));
    }

    private void addConstantMethodHandle(int i11, int i12, String str, String str2, String str3) {
        int i13 = i11;
        String str4 = str;
        String str5 = str2;
        String str6 = str3;
        add(new Entry(i13, 15, str4, str5, str6, (long) i12, hash(15, str, str2, str3, i12)));
    }

    private void addConstantNameAndType(int i11, String str, String str2) {
        add(new Entry(i11, 12, str, str2, hash(12, str, str2)));
    }

    private void addConstantUtf8(int i11, String str) {
        add(new Entry(i11, 1, str, hash(1, str)));
    }

    private Symbol addConstantUtf8Reference(int i11, String str) {
        int hash = hash(i11, str);
        for (Entry entry = get(hash); entry != null; entry = entry.f27415i) {
            if (entry.f27407b == i11 && entry.f27414h == hash && entry.f27410e.equals(str)) {
                return entry;
            }
        }
        this.constantPool.d(i11, r(str));
        int i12 = this.constantPoolCount;
        this.constantPoolCount = i12 + 1;
        return put(new Entry(i12, i11, str, hash));
    }

    private int addTypeInternal(Entry entry) {
        if (this.typeTable == null) {
            this.typeTable = new Entry[16];
        }
        int i11 = this.typeCount;
        Entry[] entryArr = this.typeTable;
        if (i11 == entryArr.length) {
            Entry[] entryArr2 = new Entry[(entryArr.length * 2)];
            System.arraycopy(entryArr, 0, entryArr2, 0, entryArr.length);
            this.typeTable = entryArr2;
        }
        Entry[] entryArr3 = this.typeTable;
        int i12 = this.typeCount;
        this.typeCount = i12 + 1;
        entryArr3[i12] = entry;
        return put(entry).f27406a;
    }

    private void copyBootstrapMethods(ClassReader classReader, char[] cArr) {
        byte[] bArr = classReader.f27351a;
        int a11 = classReader.a();
        int readUnsignedShort = classReader.readUnsignedShort(a11 - 2);
        while (true) {
            if (readUnsignedShort <= 0) {
                break;
            } else if ("BootstrapMethods".equals(classReader.readUTF8(a11, cArr))) {
                this.bootstrapMethodCount = classReader.readUnsignedShort(a11 + 6);
                break;
            } else {
                a11 += classReader.readInt(a11 + 2) + 6;
                readUnsignedShort--;
            }
        }
        if (this.bootstrapMethodCount > 0) {
            int i11 = a11 + 8;
            int readInt = classReader.readInt(a11 + 2) - 2;
            ByteVector byteVector = new ByteVector(readInt);
            this.bootstrapMethods = byteVector;
            byteVector.putByteArray(bArr, i11, readInt);
            int i12 = i11;
            for (int i13 = 0; i13 < this.bootstrapMethodCount; i13++) {
                int i14 = i12 - i11;
                int readUnsignedShort2 = classReader.readUnsignedShort(i12);
                int i15 = i12 + 2;
                int readUnsignedShort3 = classReader.readUnsignedShort(i15);
                i12 = i15 + 2;
                int hashCode = classReader.readConst(readUnsignedShort2, cArr).hashCode();
                while (true) {
                    int i16 = readUnsignedShort3 - 1;
                    if (readUnsignedShort3 <= 0) {
                        break;
                    }
                    int readUnsignedShort4 = classReader.readUnsignedShort(i12);
                    i12 += 2;
                    hashCode ^= classReader.readConst(readUnsignedShort4, cArr).hashCode();
                    readUnsignedShort3 = i16;
                }
                add(new Entry(i13, 64, (long) i14, hashCode & Integer.MAX_VALUE));
            }
        }
    }

    private Entry get(int i11) {
        Entry[] entryArr = this.entries;
        return entryArr[i11 % entryArr.length];
    }

    private static int hash(int i11, int i12) {
        return (i11 + i12) & Integer.MAX_VALUE;
    }

    private static int hash(int i11, long j11) {
        return (i11 + ((int) j11) + ((int) (j11 >>> 32))) & Integer.MAX_VALUE;
    }

    private static int hash(int i11, String str) {
        return (i11 + str.hashCode()) & Integer.MAX_VALUE;
    }

    private Entry put(Entry entry) {
        int i11 = this.entryCount;
        Entry[] entryArr = this.entries;
        if (i11 > (entryArr.length * 3) / 4) {
            int length = entryArr.length;
            int i12 = (length * 2) + 1;
            Entry[] entryArr2 = new Entry[i12];
            for (int i13 = length - 1; i13 >= 0; i13--) {
                Entry entry2 = this.entries[i13];
                while (entry2 != null) {
                    int i14 = entry2.f27414h % i12;
                    Entry entry3 = entry2.f27415i;
                    entry2.f27415i = entryArr2[i14];
                    entryArr2[i14] = entry2;
                    entry2 = entry3;
                }
            }
            this.entries = entryArr2;
        }
        this.entryCount++;
        int i15 = entry.f27414h;
        Entry[] entryArr3 = this.entries;
        int length2 = i15 % entryArr3.length;
        entry.f27415i = entryArr3[length2];
        entryArr3[length2] = entry;
        return entry;
    }

    public ClassReader A() {
        return this.sourceClassReader;
    }

    public Symbol B(int i11) {
        return this.typeTable[i11];
    }

    public void C(ByteVector byteVector) {
        if (this.bootstrapMethods != null) {
            ByteVector putShort = byteVector.putShort(r("BootstrapMethods")).putInt(this.bootstrapMethods.f27350b + 2).putShort(this.bootstrapMethodCount);
            ByteVector byteVector2 = this.bootstrapMethods;
            putShort.putByteArray(byteVector2.f27349a, 0, byteVector2.f27350b);
        }
    }

    public void D(ByteVector byteVector) {
        ByteVector putShort = byteVector.putShort(this.constantPoolCount);
        ByteVector byteVector2 = this.constantPool;
        putShort.putByteArray(byteVector2.f27349a, 0, byteVector2.f27350b);
    }

    public int E(int i11, String str) {
        this.majorVersion = i11;
        this.className = str;
        return c(str).f27406a;
    }

    public Symbol a(Handle handle, Object... objArr) {
        ByteVector byteVector = this.bootstrapMethods;
        if (byteVector == null) {
            byteVector = new ByteVector();
            this.bootstrapMethods = byteVector;
        }
        int length = objArr.length;
        int[] iArr = new int[length];
        for (int i11 = 0; i11 < length; i11++) {
            iArr[i11] = b(objArr[i11]).f27406a;
        }
        int i12 = byteVector.f27350b;
        byteVector.putShort(k(handle.getTag(), handle.getOwner(), handle.getName(), handle.getDesc(), handle.isInterface()).f27406a);
        byteVector.putShort(length);
        for (int i13 = 0; i13 < length; i13++) {
            byteVector.putShort(iArr[i13]);
        }
        int i14 = byteVector.f27350b - i12;
        int hashCode = handle.hashCode();
        for (Object hashCode2 : objArr) {
            hashCode ^= hashCode2.hashCode();
        }
        return addBootstrapMethod(i12, i14, hashCode & Integer.MAX_VALUE);
    }

    public Symbol b(Object obj) {
        if (obj instanceof Integer) {
            return h(((Integer) obj).intValue());
        }
        if (obj instanceof Byte) {
            return h(((Byte) obj).intValue());
        }
        if (obj instanceof Character) {
            return h(((Character) obj).charValue());
        }
        if (obj instanceof Short) {
            return h(((Short) obj).intValue());
        }
        if (obj instanceof Boolean) {
            return h(((Boolean) obj).booleanValue() ? 1 : 0);
        }
        if (obj instanceof Float) {
            return g(((Float) obj).floatValue());
        }
        if (obj instanceof Long) {
            return j(((Long) obj).longValue());
        }
        if (obj instanceof Double) {
            return d(((Double) obj).doubleValue());
        }
        if (obj instanceof String) {
            return q((String) obj);
        }
        if (obj instanceof Type) {
            Type type = (Type) obj;
            int sort = type.getSort();
            if (sort == 10) {
                return c(type.getInternalName());
            }
            if (sort == 11) {
                return l(type.getDescriptor());
            }
            return c(type.getDescriptor());
        } else if (obj instanceof Handle) {
            Handle handle = (Handle) obj;
            return k(handle.getTag(), handle.getOwner(), handle.getName(), handle.getDesc(), handle.isInterface());
        } else if (obj instanceof ConstantDynamic) {
            ConstantDynamic constantDynamic = (ConstantDynamic) obj;
            return e(constantDynamic.getName(), constantDynamic.getDescriptor(), constantDynamic.getBootstrapMethod(), constantDynamic.a());
        } else {
            throw new IllegalArgumentException("value " + obj);
        }
    }

    public Symbol c(String str) {
        return addConstantUtf8Reference(7, str);
    }

    public Symbol d(double d11) {
        return addConstantLongOrDouble(6, Double.doubleToRawLongBits(d11));
    }

    public Symbol e(String str, String str2, Handle handle, Object... objArr) {
        return addConstantDynamicOrInvokeDynamicReference(17, str, str2, a(handle, objArr).f27406a);
    }

    public Symbol f(String str, String str2, String str3) {
        return addConstantMemberReference(9, str, str2, str3);
    }

    public Symbol g(float f11) {
        return addConstantIntegerOrFloat(4, Float.floatToRawIntBits(f11));
    }

    public Symbol h(int i11) {
        return addConstantIntegerOrFloat(3, i11);
    }

    public Symbol i(String str, String str2, Handle handle, Object... objArr) {
        return addConstantDynamicOrInvokeDynamicReference(18, str, str2, a(handle, objArr).f27406a);
    }

    public Symbol j(long j11) {
        return addConstantLongOrDouble(5, j11);
    }

    public Symbol k(int i11, String str, String str2, String str3, boolean z11) {
        int hash = hash(15, str, str2, str3, i11);
        for (Entry entry = get(hash); entry != null; entry = entry.f27415i) {
            if (entry.f27407b == 15 && entry.f27414h == hash && entry.f27411f == ((long) i11) && entry.f27408c.equals(str) && entry.f27409d.equals(str2) && entry.f27410e.equals(str3)) {
                return entry;
            }
        }
        if (i11 <= 4) {
            this.constantPool.c(15, i11, f(str, str2, str3).f27406a);
        } else {
            this.constantPool.c(15, i11, m(str, str2, str3, z11).f27406a);
        }
        int i12 = this.constantPoolCount;
        this.constantPoolCount = i12 + 1;
        return put(new Entry(i12, 15, str, str2, str3, (long) i11, hash));
    }

    public Symbol l(String str) {
        return addConstantUtf8Reference(16, str);
    }

    public Symbol m(String str, String str2, String str3, boolean z11) {
        return addConstantMemberReference(z11 ? 11 : 10, str, str2, str3);
    }

    public Symbol n(String str) {
        return addConstantUtf8Reference(19, str);
    }

    public int o(String str, String str2) {
        int hash = hash(12, str, str2);
        for (Entry entry = get(hash); entry != null; entry = entry.f27415i) {
            if (entry.f27407b == 12 && entry.f27414h == hash && entry.f27409d.equals(str) && entry.f27410e.equals(str2)) {
                return entry.f27406a;
            }
        }
        this.constantPool.e(12, r(str), r(str2));
        int i11 = this.constantPoolCount;
        this.constantPoolCount = i11 + 1;
        return put(new Entry(i11, 12, str, str2, hash)).f27406a;
    }

    public Symbol p(String str) {
        return addConstantUtf8Reference(20, str);
    }

    public Symbol q(String str) {
        return addConstantUtf8Reference(8, str);
    }

    public int r(String str) {
        int hash = hash(1, str);
        for (Entry entry = get(hash); entry != null; entry = entry.f27415i) {
            if (entry.f27407b == 1 && entry.f27414h == hash && entry.f27410e.equals(str)) {
                return entry.f27406a;
            }
        }
        this.constantPool.putByte(1).putUTF8(str);
        int i11 = this.constantPoolCount;
        this.constantPoolCount = i11 + 1;
        return put(new Entry(i11, 1, str, hash)).f27406a;
    }

    public int s(int i11, int i12) {
        long j11;
        long j12;
        if (i11 < i12) {
            j12 = (long) i11;
            j11 = (long) i12;
        } else {
            j12 = (long) i12;
            j11 = (long) i11;
        }
        long j13 = j12 | (j11 << 32);
        int hash = hash(130, i11 + i12);
        for (Entry entry = get(hash); entry != null; entry = entry.f27415i) {
            if (entry.f27407b == 130 && entry.f27414h == hash && entry.f27411f == j13) {
                return entry.f27412g;
            }
        }
        Entry[] entryArr = this.typeTable;
        int t11 = t(this.f27413a.b(entryArr[i11].f27410e, entryArr[i12].f27410e));
        put(new Entry(this.typeCount, 130, j13, hash)).f27412g = t11;
        return t11;
    }

    public int t(String str) {
        int hash = hash(128, str);
        for (Entry entry = get(hash); entry != null; entry = entry.f27415i) {
            if (entry.f27407b == 128 && entry.f27414h == hash && entry.f27410e.equals(str)) {
                return entry.f27406a;
            }
        }
        return addTypeInternal(new Entry(this.typeCount, 128, str, hash));
    }

    public int u(String str, int i11) {
        int hash = hash(129, str, i11);
        for (Entry entry = get(hash); entry != null; entry = entry.f27415i) {
            if (entry.f27407b == 129 && entry.f27414h == hash && entry.f27411f == ((long) i11) && entry.f27410e.equals(str)) {
                return entry.f27406a;
            }
        }
        return addTypeInternal(new Entry(this.typeCount, 129, str, (long) i11, hash));
    }

    public int v() {
        if (this.bootstrapMethods == null) {
            return 0;
        }
        r("BootstrapMethods");
        return this.bootstrapMethods.f27350b + 8;
    }

    public String w() {
        return this.className;
    }

    public int x() {
        return this.constantPoolCount;
    }

    public int y() {
        return this.constantPool.f27350b;
    }

    public int z() {
        return this.majorVersion;
    }

    public static class Entry extends Symbol {

        /* renamed from: h  reason: collision with root package name */
        public final int f27414h;

        /* renamed from: i  reason: collision with root package name */
        public Entry f27415i;

        public Entry(int i11, int i12, String str, String str2, String str3, long j11, int i13) {
            super(i11, i12, str, str2, str3, j11);
            this.f27414h = i13;
        }

        public Entry(int i11, int i12, String str, int i13) {
            super(i11, i12, (String) null, (String) null, str, 0);
            this.f27414h = i13;
        }

        public Entry(int i11, int i12, String str, long j11, int i13) {
            super(i11, i12, (String) null, (String) null, str, j11);
            this.f27414h = i13;
        }

        public Entry(int i11, int i12, String str, String str2, int i13) {
            super(i11, i12, (String) null, str, str2, 0);
            this.f27414h = i13;
        }

        public Entry(int i11, int i12, long j11, int i13) {
            super(i11, i12, (String) null, (String) null, (String) null, j11);
            this.f27414h = i13;
        }
    }

    private static int hash(int i11, String str, int i12) {
        return (i11 + str.hashCode() + i12) & Integer.MAX_VALUE;
    }

    private static int hash(int i11, String str, String str2) {
        return (i11 + (str.hashCode() * str2.hashCode())) & Integer.MAX_VALUE;
    }

    private static int hash(int i11, String str, String str2, int i12) {
        return (i11 + (str.hashCode() * str2.hashCode() * (i12 + 1))) & Integer.MAX_VALUE;
    }

    private static int hash(int i11, String str, String str2, String str3) {
        return (i11 + (str.hashCode() * str2.hashCode() * str3.hashCode())) & Integer.MAX_VALUE;
    }

    private static int hash(int i11, String str, String str2, String str3, int i12) {
        return (i11 + (str.hashCode() * str2.hashCode() * str3.hashCode() * i12)) & Integer.MAX_VALUE;
    }

    public SymbolTable(ClassWriter classWriter, ClassReader classReader) {
        this.f27413a = classWriter;
        this.sourceClassReader = classReader;
        byte[] bArr = classReader.f27351a;
        int item = classReader.getItem(1) - 1;
        int i11 = classReader.header - item;
        this.constantPoolCount = classReader.getItemCount();
        ByteVector byteVector = new ByteVector(i11);
        this.constantPool = byteVector;
        byteVector.putByteArray(bArr, item, i11);
        this.entries = new Entry[(this.constantPoolCount * 2)];
        char[] cArr = new char[classReader.getMaxStringLength()];
        boolean z11 = false;
        int i12 = 1;
        while (i12 < this.constantPoolCount) {
            int item2 = classReader.getItem(i12);
            byte b11 = bArr[item2 - 1];
            switch (b11) {
                case 1:
                    addConstantUtf8(i12, classReader.c(i12, cArr));
                    break;
                case 3:
                case 4:
                    addConstantIntegerOrFloat(i12, b11, classReader.readInt(item2));
                    break;
                case 5:
                case 6:
                    addConstantLongOrDouble(i12, b11, classReader.readLong(item2));
                    break;
                case 7:
                case 8:
                case 16:
                case 19:
                case 20:
                    addConstantUtf8Reference(i12, b11, classReader.readUTF8(item2, cArr));
                    break;
                case 9:
                case 10:
                case 11:
                    int item3 = classReader.getItem(classReader.readUnsignedShort(item2 + 2));
                    addConstantMemberReference(i12, b11, classReader.readClass(item2, cArr), classReader.readUTF8(item3, cArr), classReader.readUTF8(item3 + 2, cArr));
                    break;
                case 12:
                    addConstantNameAndType(i12, classReader.readUTF8(item2, cArr), classReader.readUTF8(item2 + 2, cArr));
                    break;
                case 15:
                    int item4 = classReader.getItem(classReader.readUnsignedShort(item2 + 1));
                    int item5 = classReader.getItem(classReader.readUnsignedShort(item4 + 2));
                    addConstantMethodHandle(i12, classReader.readByte(item2), classReader.readClass(item4, cArr), classReader.readUTF8(item5, cArr), classReader.readUTF8(item5 + 2, cArr));
                    break;
                case 17:
                case 18:
                    int item6 = classReader.getItem(classReader.readUnsignedShort(item2 + 2));
                    addConstantDynamicOrInvokeDynamicReference(b11, i12, classReader.readUTF8(item6, cArr), classReader.readUTF8(item6 + 2, cArr), classReader.readUnsignedShort(item2));
                    z11 = true;
                    break;
                default:
                    throw new IllegalArgumentException();
            }
            i12 += (b11 == 5 || b11 == 6) ? 2 : 1;
        }
        if (z11) {
            copyBootstrapMethods(classReader, cArr);
        }
    }

    private void addConstantIntegerOrFloat(int i11, int i12, int i13) {
        add(new Entry(i11, i12, (long) i13, hash(i12, i13)));
    }

    private void addConstantUtf8Reference(int i11, int i12, String str) {
        add(new Entry(i11, i12, str, hash(i12, str)));
    }

    private void addConstantDynamicOrInvokeDynamicReference(int i11, int i12, String str, String str2, int i13) {
        int i14 = i12;
        int i15 = i11;
        String str3 = str;
        String str4 = str2;
        add(new Entry(i14, i15, (String) null, str3, str4, (long) i13, hash(i11, str, str2, i13)));
    }

    private void addConstantLongOrDouble(int i11, int i12, long j11) {
        add(new Entry(i11, i12, j11, hash(i12, j11)));
    }

    private void addConstantMemberReference(int i11, int i12, String str, String str2, String str3) {
        add(new Entry(i11, i12, str, str2, str3, 0, hash(i12, str, str2, str3)));
    }
}
