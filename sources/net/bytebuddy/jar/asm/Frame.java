package net.bytebuddy.jar.asm;

import net.bytebuddy.implementation.auxiliary.TypeProxy;
import net.bytebuddy.pool.TypePool;

class Frame {
    private static final int ARRAY_OF = 67108864;
    private static final int BOOLEAN = 4194313;
    private static final int BYTE = 4194314;
    private static final int CHAR = 4194315;
    private static final int CONSTANT_KIND = 4194304;
    private static final int DIM_MASK = -67108864;
    private static final int DIM_SHIFT = 26;
    private static final int DIM_SIZE = 6;
    private static final int DOUBLE = 4194307;
    private static final int ELEMENT_OF = -67108864;
    private static final int FLAGS_SHIFT = 20;
    private static final int FLAGS_SIZE = 2;
    private static final int FLOAT = 4194306;
    private static final int INTEGER = 4194305;
    private static final int ITEM_ASM_BOOLEAN = 9;
    private static final int ITEM_ASM_BYTE = 10;
    private static final int ITEM_ASM_CHAR = 11;
    private static final int ITEM_ASM_SHORT = 12;
    private static final int KIND_MASK = 62914560;
    private static final int KIND_SHIFT = 22;
    private static final int KIND_SIZE = 4;
    private static final int LOCAL_KIND = 16777216;
    private static final int LONG = 4194308;
    private static final int NULL = 4194309;
    private static final int REFERENCE_KIND = 8388608;
    private static final int SHORT = 4194316;
    private static final int STACK_KIND = 20971520;
    private static final int TOP = 4194304;
    private static final int TOP_IF_LONG_OR_DOUBLE_FLAG = 1048576;
    private static final int UNINITIALIZED_KIND = 12582912;
    private static final int UNINITIALIZED_THIS = 4194310;
    private static final int VALUE_MASK = 1048575;
    private static final int VALUE_SIZE = 20;

    /* renamed from: a  reason: collision with root package name */
    public Label f27380a;
    private int initializationCount;
    private int[] initializations;
    private int[] inputLocals;
    private int[] inputStack;
    private int[] outputLocals;
    private int[] outputStack;
    private short outputStackStart;
    private short outputStackTop;

    public Frame(Label label) {
        this.f27380a = label;
    }

    private void addInitializedType(int i11) {
        if (this.initializations == null) {
            this.initializations = new int[2];
        }
        int length = this.initializations.length;
        int i12 = this.initializationCount;
        if (i12 >= length) {
            int[] iArr = new int[Math.max(i12 + 1, length * 2)];
            System.arraycopy(this.initializations, 0, iArr, 0, length);
            this.initializations = iArr;
        }
        int[] iArr2 = this.initializations;
        int i13 = this.initializationCount;
        this.initializationCount = i13 + 1;
        iArr2[i13] = i11;
    }

    public static int d(SymbolTable symbolTable, Object obj) {
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue() | 4194304;
        }
        if (obj instanceof String) {
            return getAbstractTypeFromDescriptor(symbolTable, Type.getObjectType((String) obj).getDescriptor(), 0);
        }
        return symbolTable.u("", ((Label) obj).f27390b) | UNINITIALIZED_KIND;
    }

    public static int e(SymbolTable symbolTable, String str) {
        return symbolTable.t(str) | 8388608;
    }

    private static int getAbstractTypeFromDescriptor(SymbolTable symbolTable, String str, int i11) {
        SymbolTable symbolTable2 = symbolTable;
        String str2 = str;
        char charAt = str.charAt(i11);
        int i12 = FLOAT;
        if (charAt == 'F') {
            return FLOAT;
        }
        if (charAt == 'L') {
            return symbolTable2.t(str2.substring(i11 + 1, str.length() - 1)) | 8388608;
        }
        if (charAt != 'S') {
            if (charAt == 'V') {
                return 0;
            }
            if (charAt != 'I') {
                if (charAt == 'J') {
                    return LONG;
                }
                if (charAt != 'Z') {
                    if (charAt != '[') {
                        switch (charAt) {
                            case 'B':
                            case 'C':
                                break;
                            case 'D':
                                return DOUBLE;
                            default:
                                throw new IllegalArgumentException();
                        }
                    } else {
                        int i13 = i11 + 1;
                        while (str2.charAt(i13) == '[') {
                            i13++;
                        }
                        char charAt2 = str2.charAt(i13);
                        if (charAt2 != 'F') {
                            if (charAt2 == 'L') {
                                i12 = symbolTable2.t(str2.substring(i13 + 1, str.length() - 1)) | 8388608;
                            } else if (charAt2 == 'S') {
                                i12 = SHORT;
                            } else if (charAt2 == 'Z') {
                                i12 = BOOLEAN;
                            } else if (charAt2 == 'I') {
                                i12 = INTEGER;
                            } else if (charAt2 != 'J') {
                                switch (charAt2) {
                                    case 'B':
                                        i12 = BYTE;
                                        break;
                                    case 'C':
                                        i12 = CHAR;
                                        break;
                                    case 'D':
                                        i12 = DOUBLE;
                                        break;
                                    default:
                                        throw new IllegalArgumentException();
                                }
                            } else {
                                i12 = LONG;
                            }
                        }
                        return ((i13 - i11) << 26) | i12;
                    }
                }
            }
        }
        return INTEGER;
    }

    private int getConcreteOutputType(int i11, int i12) {
        int i13 = -67108864 & i11;
        int i14 = KIND_MASK & i11;
        if (i14 == 16777216) {
            int i15 = i13 + this.inputLocals[i11 & VALUE_MASK];
            if ((i11 & 1048576) == 0 || (i15 != LONG && i15 != DOUBLE)) {
                return i15;
            }
            return 4194304;
        } else if (i14 != STACK_KIND) {
            return i11;
        } else {
            int i16 = i13 + this.inputStack[i12 - (i11 & VALUE_MASK)];
            if ((i11 & 1048576) == 0 || (i16 != LONG && i16 != DOUBLE)) {
                return i16;
            }
            return 4194304;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0051 A[LOOP:0: B:5:0x000d->B:21:0x0051, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0037 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int getInitializedType(net.bytebuddy.jar.asm.SymbolTable r9, int r10) {
        /*
            r8 = this;
            r0 = 4194310(0x400006, float:5.87748E-39)
            if (r10 == r0) goto L_0x000c
            r1 = -4194304(0xffffffffffc00000, float:NaN)
            r1 = r1 & r10
            r2 = 12582912(0xc00000, float:1.7632415E-38)
            if (r1 != r2) goto L_0x0054
        L_0x000c:
            r1 = 0
        L_0x000d:
            int r2 = r8.initializationCount
            if (r1 >= r2) goto L_0x0054
            int[] r2 = r8.initializations
            r2 = r2[r1]
            r3 = -67108864(0xfffffffffc000000, float:-2.658456E36)
            r3 = r3 & r2
            r4 = 62914560(0x3c00000, float:1.1284746E-36)
            r4 = r4 & r2
            r5 = 1048575(0xfffff, float:1.469367E-39)
            r6 = r2 & r5
            r7 = 16777216(0x1000000, float:2.3509887E-38)
            if (r4 != r7) goto L_0x002a
            int[] r2 = r8.inputLocals
            r2 = r2[r6]
        L_0x0028:
            int r2 = r2 + r3
            goto L_0x0035
        L_0x002a:
            r7 = 20971520(0x1400000, float:3.526483E-38)
            if (r4 != r7) goto L_0x0035
            int[] r2 = r8.inputStack
            int r4 = r2.length
            int r4 = r4 - r6
            r2 = r2[r4]
            goto L_0x0028
        L_0x0035:
            if (r10 != r2) goto L_0x0051
            r1 = 8388608(0x800000, float:1.17549435E-38)
            if (r10 != r0) goto L_0x0045
            java.lang.String r10 = r9.w()
            int r9 = r9.t(r10)
        L_0x0043:
            r9 = r9 | r1
            return r9
        L_0x0045:
            r10 = r10 & r5
            net.bytebuddy.jar.asm.Symbol r10 = r9.B(r10)
            java.lang.String r10 = r10.f27410e
            int r9 = r9.t(r10)
            goto L_0x0043
        L_0x0051:
            int r1 = r1 + 1
            goto L_0x000d
        L_0x0054:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.jar.asm.Frame.getInitializedType(net.bytebuddy.jar.asm.SymbolTable, int):int");
    }

    private int getLocal(int i11) {
        int[] iArr = this.outputLocals;
        if (iArr == null || i11 >= iArr.length) {
            return i11 | 16777216;
        }
        int i12 = iArr[i11];
        if (i12 != 0) {
            return i12;
        }
        int i13 = i11 | 16777216;
        iArr[i11] = i13;
        return i13;
    }

    public static void h(SymbolTable symbolTable, int i11, ByteVector byteVector) {
        int i12 = (-67108864 & i11) >> 26;
        if (i12 == 0) {
            int i13 = i11 & VALUE_MASK;
            int i14 = i11 & KIND_MASK;
            if (i14 == 4194304) {
                byteVector.putByte(i13);
            } else if (i14 == 8388608) {
                byteVector.putByte(7).putShort(symbolTable.c(symbolTable.B(i13).f27410e).f27406a);
            } else if (i14 == UNINITIALIZED_KIND) {
                byteVector.putByte(8).putShort((int) symbolTable.B(i13).f27411f);
            } else {
                throw new AssertionError();
            }
        } else {
            StringBuilder sb2 = new StringBuilder();
            while (true) {
                int i15 = i12 - 1;
                if (i12 <= 0) {
                    break;
                }
                sb2.append('[');
                i12 = i15;
            }
            if ((i11 & KIND_MASK) == 8388608) {
                sb2.append('L');
                sb2.append(symbolTable.B(i11 & VALUE_MASK).f27410e);
                sb2.append(TypePool.Default.LazyTypeDescription.GenericTypeToken.INDEXED_TYPE_DELIMITER);
            } else {
                int i16 = i11 & VALUE_MASK;
                if (i16 == 1) {
                    sb2.append('I');
                } else if (i16 == 2) {
                    sb2.append('F');
                } else if (i16 == 3) {
                    sb2.append('D');
                } else if (i16 != 4) {
                    switch (i16) {
                        case 9:
                            sb2.append('Z');
                            break;
                        case 10:
                            sb2.append('B');
                            break;
                        case 11:
                            sb2.append('C');
                            break;
                        case 12:
                            sb2.append('S');
                            break;
                        default:
                            throw new AssertionError();
                    }
                } else {
                    sb2.append('J');
                }
            }
            byteVector.putByte(7).putShort(symbolTable.c(sb2.toString()).f27406a);
        }
    }

    private static boolean merge(SymbolTable symbolTable, int i11, int[] iArr, int i12) {
        int min;
        int t11;
        int i13 = iArr[i12];
        if (i13 == i11) {
            return false;
        }
        if ((67108863 & i11) == NULL) {
            if (i13 == NULL) {
                return false;
            }
            i11 = NULL;
        }
        if (i13 == 0) {
            iArr[i12] = i11;
            return true;
        }
        int i14 = i13 & -67108864;
        int i15 = 4194304;
        if (i14 != 0 || (i13 & KIND_MASK) == 8388608) {
            if (i11 == NULL) {
                return false;
            }
            if ((i11 & -4194304) != (-4194304 & i13)) {
                int i16 = i11 & -67108864;
                if (i16 != 0 || (i11 & KIND_MASK) == 8388608) {
                    if (!(i16 == 0 || (i11 & KIND_MASK) == 8388608)) {
                        i16 -= 67108864;
                    }
                    if (!(i14 == 0 || (i13 & KIND_MASK) == 8388608)) {
                        i14 -= 67108864;
                    }
                    min = Math.min(i16, i14) | 8388608;
                    t11 = symbolTable.t(TypeProxy.SilentConstruction.Appender.JAVA_LANG_OBJECT_INTERNAL_NAME);
                }
            } else if ((i13 & KIND_MASK) == 8388608) {
                i15 = (i11 & -67108864) | 8388608 | symbolTable.s(i11 & VALUE_MASK, VALUE_MASK & i13);
            } else {
                min = ((i11 & -67108864) - 67108864) | 8388608;
                t11 = symbolTable.t(TypeProxy.SilentConstruction.Appender.JAVA_LANG_OBJECT_INTERNAL_NAME);
            }
            i15 = min | t11;
        } else if (i13 == NULL) {
            if ((i11 & -67108864) == 0 && (i11 & KIND_MASK) != 8388608) {
                i11 = 4194304;
            }
            i15 = i11;
        }
        if (i15 == i13) {
            return false;
        }
        iArr[i12] = i15;
        return true;
    }

    private int pop() {
        short s11 = this.outputStackTop;
        if (s11 > 0) {
            int[] iArr = this.outputStack;
            short s12 = (short) (s11 - 1);
            this.outputStackTop = s12;
            return iArr[s12];
        }
        short s13 = (short) (this.outputStackStart - 1);
        this.outputStackStart = s13;
        return (-s13) | STACK_KIND;
    }

    private void push(int i11) {
        if (this.outputStack == null) {
            this.outputStack = new int[10];
        }
        int length = this.outputStack.length;
        short s11 = this.outputStackTop;
        if (s11 >= length) {
            int[] iArr = new int[Math.max(s11 + 1, length * 2)];
            System.arraycopy(this.outputStack, 0, iArr, 0, length);
            this.outputStack = iArr;
        }
        int[] iArr2 = this.outputStack;
        short s12 = this.outputStackTop;
        short s13 = (short) (s12 + 1);
        this.outputStackTop = s13;
        iArr2[s12] = i11;
        short s14 = (short) (this.outputStackStart + s13);
        Label label = this.f27380a;
        if (s14 > label.f27393e) {
            label.f27393e = s14;
        }
    }

    private void setLocal(int i11, int i12) {
        if (this.outputLocals == null) {
            this.outputLocals = new int[10];
        }
        int length = this.outputLocals.length;
        if (i11 >= length) {
            int[] iArr = new int[Math.max(i11 + 1, length * 2)];
            System.arraycopy(this.outputLocals, 0, iArr, 0, length);
            this.outputLocals = iArr;
        }
        this.outputLocals[i11] = i12;
    }

    public final void a(MethodWriter methodWriter) {
        int i11;
        int i12;
        int i13;
        int[] iArr = this.inputLocals;
        int i14 = 0;
        int i15 = 0;
        int i16 = 0;
        int i17 = 0;
        while (true) {
            int i18 = 2;
            if (i15 >= iArr.length) {
                break;
            }
            int i19 = iArr[i15];
            if (!(i19 == LONG || i19 == DOUBLE)) {
                i18 = 1;
            }
            i15 += i18;
            if (i19 == 4194304) {
                i17++;
            } else {
                i16 += i17 + 1;
                i17 = 0;
            }
        }
        int[] iArr2 = this.inputStack;
        int i21 = 0;
        int i22 = 0;
        while (i21 < iArr2.length) {
            int i23 = iArr2[i21];
            if (i23 == LONG || i23 == DOUBLE) {
                i13 = 2;
            } else {
                i13 = 1;
            }
            i21 += i13;
            i22++;
        }
        int j11 = methodWriter.j(this.f27380a.f27390b, i16, i22);
        int i24 = 0;
        while (true) {
            int i25 = i16 - 1;
            if (i16 <= 0) {
                break;
            }
            int i26 = iArr[i24];
            if (i26 == LONG || i26 == DOUBLE) {
                i12 = 2;
            } else {
                i12 = 1;
            }
            i24 += i12;
            methodWriter.h(j11, i26);
            i16 = i25;
            j11++;
        }
        while (true) {
            int i27 = i22 - 1;
            if (i22 > 0) {
                int i28 = iArr2[i14];
                if (i28 == LONG || i28 == DOUBLE) {
                    i11 = 2;
                } else {
                    i11 = 1;
                }
                i14 += i11;
                methodWriter.h(j11, i28);
                j11++;
                i22 = i27;
            } else {
                methodWriter.i();
                return;
            }
        }
    }

    public final void b(Frame frame) {
        this.inputLocals = frame.inputLocals;
        this.inputStack = frame.inputStack;
        this.outputStackStart = 0;
        this.outputLocals = frame.outputLocals;
        this.outputStack = frame.outputStack;
        this.outputStackTop = frame.outputStackTop;
        this.initializationCount = frame.initializationCount;
        this.initializations = frame.initializations;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:114:0x0344, code lost:
        push(DOUBLE);
        push(4194304);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x034b, code lost:
        push(FLOAT);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x034f, code lost:
        push(LONG);
        push(4194304);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x0356, code lost:
        push(INTEGER);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:159:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:171:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:172:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:173:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:174:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:185:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:186:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:187:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:188:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x0245, code lost:
        pop(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x02bf, code lost:
        pop(2);
        push(DOUBLE);
        push(4194304);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x02ca, code lost:
        pop(2);
        push(FLOAT);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x02d2, code lost:
        pop(2);
        push(LONG);
        push(4194304);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x02dd, code lost:
        pop(2);
        push(INTEGER);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void c(int r17, int r18, net.bytebuddy.jar.asm.Symbol r19, net.bytebuddy.jar.asm.SymbolTable r20) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r2 = r18
            r3 = r19
            r4 = r20
            r6 = 4194306(0x400002, float:5.877475E-39)
            r7 = 8388608(0x800000, float:1.17549435E-38)
            r8 = 4194305(0x400001, float:5.877473E-39)
            r9 = 4194307(0x400003, float:5.877476E-39)
            r10 = 4194308(0x400004, float:5.877477E-39)
            r11 = 4194304(0x400000, float:5.877472E-39)
            switch(r1) {
                case 0: goto L_0x0360;
                case 1: goto L_0x035a;
                case 2: goto L_0x0356;
                case 3: goto L_0x0356;
                case 4: goto L_0x0356;
                case 5: goto L_0x0356;
                case 6: goto L_0x0356;
                case 7: goto L_0x0356;
                case 8: goto L_0x0356;
                case 9: goto L_0x034f;
                case 10: goto L_0x034f;
                case 11: goto L_0x034b;
                case 12: goto L_0x034b;
                case 13: goto L_0x034b;
                case 14: goto L_0x0344;
                case 15: goto L_0x0344;
                case 16: goto L_0x0356;
                case 17: goto L_0x0356;
                case 18: goto L_0x02ee;
                default: goto L_0x001d;
            }
        L_0x001d:
            switch(r1) {
                case 21: goto L_0x0356;
                case 22: goto L_0x034f;
                case 23: goto L_0x034b;
                case 24: goto L_0x0344;
                case 25: goto L_0x02e5;
                default: goto L_0x0020;
            }
        L_0x0020:
            r12 = 20971520(0x1400000, float:3.526483E-38)
            r14 = 16777216(0x1000000, float:2.3509887E-38)
            r15 = 62914560(0x3c00000, float:1.1284746E-36)
            r13 = 1
            switch(r1) {
                case 46: goto L_0x019c;
                case 47: goto L_0x0147;
                case 48: goto L_0x018e;
                case 49: goto L_0x0152;
                case 50: goto L_0x02aa;
                case 51: goto L_0x019c;
                case 52: goto L_0x019c;
                case 53: goto L_0x019c;
                case 54: goto L_0x0283;
                case 55: goto L_0x0254;
                case 56: goto L_0x0283;
                case 57: goto L_0x0254;
                case 58: goto L_0x0283;
                default: goto L_0x002a;
            }
        L_0x002a:
            r12 = 3
            r14 = 91
            r15 = 0
            r5 = 4
            switch(r1) {
                case 79: goto L_0x024f;
                case 80: goto L_0x024a;
                case 81: goto L_0x024f;
                case 82: goto L_0x024a;
                case 83: goto L_0x024f;
                case 84: goto L_0x024f;
                case 85: goto L_0x024f;
                case 86: goto L_0x024f;
                case 87: goto L_0x0245;
                case 88: goto L_0x023f;
                case 89: goto L_0x0233;
                case 90: goto L_0x0220;
                case 91: goto L_0x0206;
                case 92: goto L_0x01f0;
                case 93: goto L_0x01d3;
                case 94: goto L_0x01af;
                case 95: goto L_0x019f;
                case 96: goto L_0x019c;
                case 97: goto L_0x0191;
                case 98: goto L_0x018e;
                case 99: goto L_0x0183;
                case 100: goto L_0x019c;
                case 101: goto L_0x0191;
                case 102: goto L_0x018e;
                case 103: goto L_0x0183;
                case 104: goto L_0x019c;
                case 105: goto L_0x0191;
                case 106: goto L_0x018e;
                case 107: goto L_0x0183;
                case 108: goto L_0x019c;
                case 109: goto L_0x0191;
                case 110: goto L_0x018e;
                case 111: goto L_0x0183;
                case 112: goto L_0x019c;
                case 113: goto L_0x0191;
                case 114: goto L_0x018e;
                case 115: goto L_0x0183;
                case 116: goto L_0x0360;
                case 117: goto L_0x0360;
                case 118: goto L_0x0360;
                case 119: goto L_0x0360;
                case 120: goto L_0x019c;
                case 121: goto L_0x0178;
                case 122: goto L_0x019c;
                case 123: goto L_0x0178;
                case 124: goto L_0x019c;
                case 125: goto L_0x0178;
                case 126: goto L_0x019c;
                case 127: goto L_0x0191;
                case 128: goto L_0x019c;
                case 129: goto L_0x0191;
                case 130: goto L_0x019c;
                case 131: goto L_0x0191;
                case 132: goto L_0x0173;
                case 133: goto L_0x0168;
                case 134: goto L_0x0160;
                case 135: goto L_0x0155;
                case 136: goto L_0x019c;
                case 137: goto L_0x018e;
                case 138: goto L_0x0152;
                case 139: goto L_0x014a;
                case 140: goto L_0x0168;
                case 141: goto L_0x0155;
                case 142: goto L_0x019c;
                case 143: goto L_0x0147;
                case 144: goto L_0x018e;
                case 145: goto L_0x0360;
                case 146: goto L_0x0360;
                case 147: goto L_0x0360;
                case 148: goto L_0x013f;
                case 149: goto L_0x019c;
                case 150: goto L_0x019c;
                case 151: goto L_0x013f;
                case 152: goto L_0x013f;
                case 153: goto L_0x0245;
                case 154: goto L_0x0245;
                case 155: goto L_0x0245;
                case 156: goto L_0x0245;
                case 157: goto L_0x0245;
                case 158: goto L_0x0245;
                case 159: goto L_0x023f;
                case 160: goto L_0x023f;
                case 161: goto L_0x023f;
                case 162: goto L_0x023f;
                case 163: goto L_0x023f;
                case 164: goto L_0x023f;
                case 165: goto L_0x023f;
                case 166: goto L_0x023f;
                case 167: goto L_0x0360;
                case 168: goto L_0x0137;
                case 169: goto L_0x0137;
                case 170: goto L_0x0245;
                case 171: goto L_0x0245;
                case 172: goto L_0x0245;
                case 173: goto L_0x023f;
                case 174: goto L_0x0245;
                case 175: goto L_0x023f;
                case 176: goto L_0x0245;
                case 177: goto L_0x0360;
                case 178: goto L_0x0130;
                case 179: goto L_0x0129;
                case 180: goto L_0x011f;
                case 181: goto L_0x0115;
                case 182: goto L_0x00f0;
                case 183: goto L_0x00f0;
                case 184: goto L_0x00f0;
                case 185: goto L_0x00f0;
                case 186: goto L_0x00e4;
                case 187: goto L_0x00d6;
                case 188: goto L_0x008a;
                case 189: goto L_0x005f;
                case 190: goto L_0x014a;
                case 191: goto L_0x0245;
                case 192: goto L_0x0045;
                case 193: goto L_0x014a;
                case 194: goto L_0x0245;
                case 195: goto L_0x0245;
                default: goto L_0x0032;
            }
        L_0x0032:
            switch(r1) {
                case 197: goto L_0x003b;
                case 198: goto L_0x0245;
                case 199: goto L_0x0245;
                default: goto L_0x0035;
            }
        L_0x0035:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            r1.<init>()
            throw r1
        L_0x003b:
            r0.pop((int) r2)
            java.lang.String r1 = r3.f27410e
            r0.push(r4, r1)
            goto L_0x0360
        L_0x0045:
            java.lang.String r1 = r3.f27410e
            r16.pop()
            char r2 = r1.charAt(r15)
            if (r2 != r14) goto L_0x0055
            r0.push(r4, r1)
            goto L_0x0360
        L_0x0055:
            int r1 = r4.t(r1)
            r1 = r1 | r7
            r0.push(r1)
            goto L_0x0360
        L_0x005f:
            java.lang.String r1 = r3.f27410e
            r16.pop()
            char r2 = r1.charAt(r15)
            if (r2 != r14) goto L_0x007e
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r14)
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            r0.push(r4, r1)
            goto L_0x0360
        L_0x007e:
            r2 = 75497472(0x4800000, float:3.0092655E-36)
            int r1 = r4.t(r1)
            r1 = r1 | r2
            r0.push(r1)
            goto L_0x0360
        L_0x008a:
            r16.pop()
            switch(r2) {
                case 4: goto L_0x00ce;
                case 5: goto L_0x00c6;
                case 6: goto L_0x00be;
                case 7: goto L_0x00b6;
                case 8: goto L_0x00ae;
                case 9: goto L_0x00a6;
                case 10: goto L_0x009e;
                case 11: goto L_0x0096;
                default: goto L_0x0090;
            }
        L_0x0090:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            r1.<init>()
            throw r1
        L_0x0096:
            r1 = 71303172(0x4400004, float:2.2569499E-36)
            r0.push(r1)
            goto L_0x0360
        L_0x009e:
            r1 = 71303169(0x4400001, float:2.2569493E-36)
            r0.push(r1)
            goto L_0x0360
        L_0x00a6:
            r1 = 71303180(0x440000c, float:2.2569513E-36)
            r0.push(r1)
            goto L_0x0360
        L_0x00ae:
            r1 = 71303178(0x440000a, float:2.256951E-36)
            r0.push(r1)
            goto L_0x0360
        L_0x00b6:
            r1 = 71303171(0x4400003, float:2.2569497E-36)
            r0.push(r1)
            goto L_0x0360
        L_0x00be:
            r1 = 71303170(0x4400002, float:2.2569495E-36)
            r0.push(r1)
            goto L_0x0360
        L_0x00c6:
            r1 = 71303179(0x440000b, float:2.2569511E-36)
            r0.push(r1)
            goto L_0x0360
        L_0x00ce:
            r1 = 71303177(0x4400009, float:2.2569508E-36)
            r0.push(r1)
            goto L_0x0360
        L_0x00d6:
            java.lang.String r1 = r3.f27410e
            int r1 = r4.u(r1, r2)
            r2 = 12582912(0xc00000, float:1.7632415E-38)
            r1 = r1 | r2
            r0.push(r1)
            goto L_0x0360
        L_0x00e4:
            java.lang.String r1 = r3.f27410e
            r0.pop((java.lang.String) r1)
            java.lang.String r1 = r3.f27410e
            r0.push(r4, r1)
            goto L_0x0360
        L_0x00f0:
            java.lang.String r2 = r3.f27410e
            r0.pop((java.lang.String) r2)
            r2 = 184(0xb8, float:2.58E-43)
            if (r1 == r2) goto L_0x010e
            int r2 = r16.pop()
            r5 = 183(0xb7, float:2.56E-43)
            if (r1 != r5) goto L_0x010e
            java.lang.String r1 = r3.f27409d
            char r1 = r1.charAt(r15)
            r5 = 60
            if (r1 != r5) goto L_0x010e
            r0.addInitializedType(r2)
        L_0x010e:
            java.lang.String r1 = r3.f27410e
            r0.push(r4, r1)
            goto L_0x0360
        L_0x0115:
            java.lang.String r1 = r3.f27410e
            r0.pop((java.lang.String) r1)
            r16.pop()
            goto L_0x0360
        L_0x011f:
            r0.pop((int) r13)
            java.lang.String r1 = r3.f27410e
            r0.push(r4, r1)
            goto L_0x0360
        L_0x0129:
            java.lang.String r1 = r3.f27410e
            r0.pop((java.lang.String) r1)
            goto L_0x0360
        L_0x0130:
            java.lang.String r1 = r3.f27410e
            r0.push(r4, r1)
            goto L_0x0360
        L_0x0137:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r2 = "JSR/RET are not supported with computeFrames option"
            r1.<init>(r2)
            throw r1
        L_0x013f:
            r0.pop((int) r5)
            r0.push(r8)
            goto L_0x0360
        L_0x0147:
            r1 = 2
            goto L_0x02d2
        L_0x014a:
            r0.pop((int) r13)
            r0.push(r8)
            goto L_0x0360
        L_0x0152:
            r1 = 2
            goto L_0x02bf
        L_0x0155:
            r0.pop((int) r13)
            r0.push(r9)
            r0.push(r11)
            goto L_0x0360
        L_0x0160:
            r0.pop((int) r13)
            r0.push(r6)
            goto L_0x0360
        L_0x0168:
            r0.pop((int) r13)
            r0.push(r10)
            r0.push(r11)
            goto L_0x0360
        L_0x0173:
            r0.setLocal(r2, r8)
            goto L_0x0360
        L_0x0178:
            r0.pop((int) r12)
            r0.push(r10)
            r0.push(r11)
            goto L_0x0360
        L_0x0183:
            r0.pop((int) r5)
            r0.push(r9)
            r0.push(r11)
            goto L_0x0360
        L_0x018e:
            r1 = 2
            goto L_0x02ca
        L_0x0191:
            r0.pop((int) r5)
            r0.push(r10)
            r0.push(r11)
            goto L_0x0360
        L_0x019c:
            r1 = 2
            goto L_0x02dd
        L_0x019f:
            int r1 = r16.pop()
            int r2 = r16.pop()
            r0.push(r1)
            r0.push(r2)
            goto L_0x0360
        L_0x01af:
            int r1 = r16.pop()
            int r2 = r16.pop()
            int r3 = r16.pop()
            int r4 = r16.pop()
            r0.push(r2)
            r0.push(r1)
            r0.push(r4)
            r0.push(r3)
            r0.push(r2)
            r0.push(r1)
            goto L_0x0360
        L_0x01d3:
            int r1 = r16.pop()
            int r2 = r16.pop()
            int r3 = r16.pop()
            r0.push(r2)
            r0.push(r1)
            r0.push(r3)
            r0.push(r2)
            r0.push(r1)
            goto L_0x0360
        L_0x01f0:
            int r1 = r16.pop()
            int r2 = r16.pop()
            r0.push(r2)
            r0.push(r1)
            r0.push(r2)
            r0.push(r1)
            goto L_0x0360
        L_0x0206:
            int r1 = r16.pop()
            int r2 = r16.pop()
            int r3 = r16.pop()
            r0.push(r1)
            r0.push(r3)
            r0.push(r2)
            r0.push(r1)
            goto L_0x0360
        L_0x0220:
            int r1 = r16.pop()
            int r2 = r16.pop()
            r0.push(r1)
            r0.push(r2)
            r0.push(r1)
            goto L_0x0360
        L_0x0233:
            int r1 = r16.pop()
            r0.push(r1)
            r0.push(r1)
            goto L_0x0360
        L_0x023f:
            r1 = 2
            r0.pop((int) r1)
            goto L_0x0360
        L_0x0245:
            r0.pop((int) r13)
            goto L_0x0360
        L_0x024a:
            r0.pop((int) r5)
            goto L_0x0360
        L_0x024f:
            r0.pop((int) r12)
            goto L_0x0360
        L_0x0254:
            r0.pop((int) r13)
            int r1 = r16.pop()
            r0.setLocal(r2, r1)
            int r1 = r2 + 1
            r0.setLocal(r1, r11)
            if (r2 <= 0) goto L_0x0360
            int r1 = r2 + -1
            int r2 = r0.getLocal(r1)
            if (r2 == r10) goto L_0x027e
            if (r2 != r9) goto L_0x0270
            goto L_0x027e
        L_0x0270:
            r3 = r2 & r15
            if (r3 == r14) goto L_0x0276
            if (r3 != r12) goto L_0x0360
        L_0x0276:
            r3 = 1048576(0x100000, float:1.469368E-39)
            r2 = r2 | r3
            r0.setLocal(r1, r2)
            goto L_0x0360
        L_0x027e:
            r0.setLocal(r1, r11)
            goto L_0x0360
        L_0x0283:
            int r1 = r16.pop()
            r0.setLocal(r2, r1)
            if (r2 <= 0) goto L_0x0360
            int r1 = r2 + -1
            int r2 = r0.getLocal(r1)
            if (r2 == r10) goto L_0x02a5
            if (r2 != r9) goto L_0x0297
            goto L_0x02a5
        L_0x0297:
            r3 = r2 & r15
            if (r3 == r14) goto L_0x029d
            if (r3 != r12) goto L_0x0360
        L_0x029d:
            r3 = 1048576(0x100000, float:1.469368E-39)
            r2 = r2 | r3
            r0.setLocal(r1, r2)
            goto L_0x0360
        L_0x02a5:
            r0.setLocal(r1, r11)
            goto L_0x0360
        L_0x02aa:
            r0.pop((int) r13)
            int r1 = r16.pop()
            r2 = 4194309(0x400005, float:5.877479E-39)
            if (r1 != r2) goto L_0x02b7
            goto L_0x02ba
        L_0x02b7:
            r2 = -67108864(0xfffffffffc000000, float:-2.658456E36)
            int r1 = r1 + r2
        L_0x02ba:
            r0.push(r1)
            goto L_0x0360
        L_0x02bf:
            r0.pop((int) r1)
            r0.push(r9)
            r0.push(r11)
            goto L_0x0360
        L_0x02ca:
            r0.pop((int) r1)
            r0.push(r6)
            goto L_0x0360
        L_0x02d2:
            r0.pop((int) r1)
            r0.push(r10)
            r0.push(r11)
            goto L_0x0360
        L_0x02dd:
            r0.pop((int) r1)
            r0.push(r8)
            goto L_0x0360
        L_0x02e5:
            int r1 = r0.getLocal(r2)
            r0.push(r1)
            goto L_0x0360
        L_0x02ee:
            int r1 = r3.f27407b
            switch(r1) {
                case 3: goto L_0x0340;
                case 4: goto L_0x033c;
                case 5: goto L_0x0335;
                case 6: goto L_0x032e;
                case 7: goto L_0x0323;
                case 8: goto L_0x0318;
                default: goto L_0x02f3;
            }
        L_0x02f3:
            switch(r1) {
                case 15: goto L_0x030d;
                case 16: goto L_0x0302;
                case 17: goto L_0x02fc;
                default: goto L_0x02f6;
            }
        L_0x02f6:
            java.lang.AssertionError r1 = new java.lang.AssertionError
            r1.<init>()
            throw r1
        L_0x02fc:
            java.lang.String r1 = r3.f27410e
            r0.push(r4, r1)
            goto L_0x0360
        L_0x0302:
            java.lang.String r1 = "java/lang/invoke/MethodType"
            int r1 = r4.t(r1)
            r1 = r1 | r7
            r0.push(r1)
            goto L_0x0360
        L_0x030d:
            java.lang.String r1 = "java/lang/invoke/MethodHandle"
            int r1 = r4.t(r1)
            r1 = r1 | r7
            r0.push(r1)
            goto L_0x0360
        L_0x0318:
            java.lang.String r1 = "java/lang/String"
            int r1 = r4.t(r1)
            r1 = r1 | r7
            r0.push(r1)
            goto L_0x0360
        L_0x0323:
            java.lang.String r1 = "java/lang/Class"
            int r1 = r4.t(r1)
            r1 = r1 | r7
            r0.push(r1)
            goto L_0x0360
        L_0x032e:
            r0.push(r9)
            r0.push(r11)
            goto L_0x0360
        L_0x0335:
            r0.push(r10)
            r0.push(r11)
            goto L_0x0360
        L_0x033c:
            r0.push(r6)
            goto L_0x0360
        L_0x0340:
            r0.push(r8)
            goto L_0x0360
        L_0x0344:
            r0.push(r9)
            r0.push(r11)
            goto L_0x0360
        L_0x034b:
            r0.push(r6)
            goto L_0x0360
        L_0x034f:
            r0.push(r10)
            r0.push(r11)
            goto L_0x0360
        L_0x0356:
            r0.push(r8)
            goto L_0x0360
        L_0x035a:
            r1 = 4194309(0x400005, float:5.877479E-39)
            r0.push(r1)
        L_0x0360:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.jar.asm.Frame.c(int, int, net.bytebuddy.jar.asm.Symbol, net.bytebuddy.jar.asm.SymbolTable):void");
    }

    public final int f() {
        return this.inputStack.length;
    }

    public final boolean g(SymbolTable symbolTable, Frame frame, int i11) {
        boolean z11;
        int i12;
        int length = this.inputLocals.length;
        int length2 = this.inputStack.length;
        boolean z12 = true;
        if (frame.inputLocals == null) {
            frame.inputLocals = new int[length];
            z11 = true;
        } else {
            z11 = false;
        }
        for (int i13 = 0; i13 < length; i13++) {
            int[] iArr = this.outputLocals;
            if (iArr == null || i13 >= iArr.length) {
                i12 = this.inputLocals[i13];
            } else {
                int i14 = iArr[i13];
                if (i14 == 0) {
                    i12 = this.inputLocals[i13];
                } else {
                    i12 = getConcreteOutputType(i14, length2);
                }
            }
            if (this.initializations != null) {
                i12 = getInitializedType(symbolTable, i12);
            }
            z11 |= merge(symbolTable, i12, frame.inputLocals, i13);
        }
        if (i11 > 0) {
            for (int i15 = 0; i15 < length; i15++) {
                z11 |= merge(symbolTable, this.inputLocals[i15], frame.inputLocals, i15);
            }
            if (frame.inputStack == null) {
                frame.inputStack = new int[1];
            } else {
                z12 = z11;
            }
            return merge(symbolTable, i11, frame.inputStack, 0) | z12;
        }
        int length3 = this.inputStack.length + this.outputStackStart;
        if (frame.inputStack == null) {
            frame.inputStack = new int[(this.outputStackTop + length3)];
        } else {
            z12 = z11;
        }
        for (int i16 = 0; i16 < length3; i16++) {
            int i17 = this.inputStack[i16];
            if (this.initializations != null) {
                i17 = getInitializedType(symbolTable, i17);
            }
            z12 |= merge(symbolTable, i17, frame.inputStack, i16);
        }
        for (int i18 = 0; i18 < this.outputStackTop; i18++) {
            int concreteOutputType = getConcreteOutputType(this.outputStack[i18], length2);
            if (this.initializations != null) {
                concreteOutputType = getInitializedType(symbolTable, concreteOutputType);
            }
            z12 |= merge(symbolTable, concreteOutputType, frame.inputStack, length3 + i18);
        }
        return z12;
    }

    public final void i(SymbolTable symbolTable, int i11, Object[] objArr, int i12, Object[] objArr2) {
        int i13 = 0;
        for (int i14 = 0; i14 < i11; i14++) {
            int i15 = i13 + 1;
            this.inputLocals[i13] = d(symbolTable, objArr[i14]);
            Integer num = objArr[i14];
            if (num == Opcodes.LONG || num == Opcodes.DOUBLE) {
                this.inputLocals[i15] = 4194304;
                i13 = i15 + 1;
            } else {
                i13 = i15;
            }
        }
        while (true) {
            int[] iArr = this.inputLocals;
            if (i13 >= iArr.length) {
                break;
            }
            iArr[i13] = 4194304;
            i13++;
        }
        int i16 = 0;
        for (int i17 = 0; i17 < i12; i17++) {
            Integer num2 = objArr2[i17];
            if (num2 == Opcodes.LONG || num2 == Opcodes.DOUBLE) {
                i16++;
            }
        }
        this.inputStack = new int[(i16 + i12)];
        int i18 = 0;
        for (int i19 = 0; i19 < i12; i19++) {
            int i21 = i18 + 1;
            this.inputStack[i18] = d(symbolTable, objArr2[i19]);
            Integer num3 = objArr2[i19];
            if (num3 == Opcodes.LONG || num3 == Opcodes.DOUBLE) {
                this.inputStack[i21] = 4194304;
                i18 = i21 + 1;
            } else {
                i18 = i21;
            }
        }
        this.outputStackTop = 0;
        this.initializationCount = 0;
    }

    public final void j(SymbolTable symbolTable, int i11, String str, int i12) {
        int i13;
        int i14;
        int[] iArr = new int[i12];
        this.inputLocals = iArr;
        this.inputStack = new int[0];
        if ((i11 & 8) == 0) {
            i13 = 1;
            if ((i11 & 262144) == 0) {
                iArr[0] = symbolTable.t(symbolTable.w()) | 8388608;
            } else {
                iArr[0] = UNINITIALIZED_THIS;
            }
        } else {
            i13 = 0;
        }
        for (Type descriptor : Type.getArgumentTypes(str)) {
            int abstractTypeFromDescriptor = getAbstractTypeFromDescriptor(symbolTable, descriptor.getDescriptor(), 0);
            int[] iArr2 = this.inputLocals;
            int i15 = i13 + 1;
            iArr2[i13] = abstractTypeFromDescriptor;
            if (abstractTypeFromDescriptor == LONG || abstractTypeFromDescriptor == DOUBLE) {
                i14 = i15 + 1;
                iArr2[i15] = 4194304;
            } else {
                i14 = i15;
            }
        }
        while (i13 < i12) {
            this.inputLocals[i13] = 4194304;
            i13++;
        }
    }

    private void pop(int i11) {
        short s11 = this.outputStackTop;
        if (s11 >= i11) {
            this.outputStackTop = (short) (s11 - i11);
            return;
        }
        this.outputStackStart = (short) (this.outputStackStart - (i11 - s11));
        this.outputStackTop = 0;
    }

    private void pop(String str) {
        char charAt = str.charAt(0);
        if (charAt == '(') {
            pop((Type.getArgumentsAndReturnSizes(str) >> 2) - 1);
        } else if (charAt == 'J' || charAt == 'D') {
            pop(2);
        } else {
            pop(1);
        }
    }

    private void push(SymbolTable symbolTable, String str) {
        int i11 = 0;
        if (str.charAt(0) == '(') {
            i11 = Type.a(str);
        }
        int abstractTypeFromDescriptor = getAbstractTypeFromDescriptor(symbolTable, str, i11);
        if (abstractTypeFromDescriptor != 0) {
            push(abstractTypeFromDescriptor);
            if (abstractTypeFromDescriptor == LONG || abstractTypeFromDescriptor == DOUBLE) {
                push(4194304);
            }
        }
    }
}
