package net.bytebuddy.jar.asm;

import androidx.core.view.InputDeviceCompat;
import com.google.common.base.Ascii;
import java.io.IOException;
import java.io.InputStream;
import net.bytebuddy.description.method.MethodDescription;
import okio.Utf8;
import org.apache.commons.compress.harmony.unpack200.AttributeLayout;

public class ClassReader {
    public static final int EXPAND_FRAMES = 8;
    private static final int INPUT_STREAM_DATA_CHUNK_SIZE = 4096;
    private static final int MAX_BUFFER_SIZE = 1048576;
    public static final int SKIP_CODE = 1;
    public static final int SKIP_DEBUG = 2;
    public static final int SKIP_FRAMES = 4;

    /* renamed from: a  reason: collision with root package name */
    public final byte[] f27351a;
    @Deprecated

    /* renamed from: b  reason: collision with root package name */
    public final byte[] f27352b;
    private final int[] bootstrapMethodOffsets;
    private final ConstantDynamic[] constantDynamicValues;
    private final String[] constantUtf8Values;
    private final int[] cpInfoOffsets;
    public final int header;
    private final int maxStringLength;

    public ClassReader(byte[] bArr) {
        this(bArr, 0, bArr.length);
    }

    private static int calculateBufferSize(InputStream inputStream) throws IOException {
        int available = inputStream.available();
        if (available < 256) {
            return 4096;
        }
        return Math.min(available, 1048576);
    }

    private void computeImplicitFrame(Context context) {
        int i11;
        int i12;
        String str = context.f27361f;
        Object[] objArr = context.f27372q;
        int i13 = 0;
        if ((context.f27359d & 8) == 0) {
            if (MethodDescription.CONSTRUCTOR_INTERNAL_NAME.equals(context.f27360e)) {
                objArr[0] = Opcodes.UNINITIALIZED_THIS;
            } else {
                objArr[0] = readClass(this.header + 2, context.f27358c);
            }
            i13 = 1;
        }
        int i14 = 1;
        while (true) {
            int i15 = i14 + 1;
            char charAt = str.charAt(i14);
            if (charAt == 'F') {
                i12 = i11 + 1;
                objArr[i11] = Opcodes.FLOAT;
            } else if (charAt != 'L') {
                if (!(charAt == 'S' || charAt == 'I')) {
                    if (charAt == 'J') {
                        i12 = i11 + 1;
                        objArr[i11] = Opcodes.LONG;
                    } else if (charAt != 'Z') {
                        if (charAt != '[') {
                            switch (charAt) {
                                case 'B':
                                case 'C':
                                    break;
                                case 'D':
                                    i12 = i11 + 1;
                                    objArr[i11] = Opcodes.DOUBLE;
                                    break;
                                default:
                                    context.f27370o = i11;
                                    return;
                            }
                        } else {
                            while (str.charAt(i15) == '[') {
                                i15++;
                            }
                            if (str.charAt(i15) == 'L') {
                                do {
                                    i15++;
                                } while (str.charAt(i15) != ';');
                            }
                            int i16 = i15 + 1;
                            objArr[i11] = str.substring(i14, i16);
                            i14 = i16;
                            i11++;
                        }
                    }
                }
                i12 = i11 + 1;
                objArr[i11] = Opcodes.INTEGER;
            } else {
                int i17 = i15;
                while (str.charAt(i17) != ';') {
                    i17++;
                }
                objArr[i11] = str.substring(i15, i17);
                i11++;
                i14 = i17 + 1;
            }
            i11 = i12;
            i14 = i15;
        }
    }

    private void createDebugLabel(int i11, Label[] labelArr) {
        if (labelArr[i11] == null) {
            Label b11 = b(i11, labelArr);
            b11.f27389a = (short) (b11.f27389a | 1);
        }
    }

    private Label createLabel(int i11, Label[] labelArr) {
        Label b11 = b(i11, labelArr);
        b11.f27389a = (short) (b11.f27389a & -2);
        return b11;
    }

    private int getTypeAnnotationBytecodeOffset(int[] iArr, int i11) {
        if (iArr == null || i11 >= iArr.length || readByte(iArr[i11]) < 67) {
            return -1;
        }
        return readUnsignedShort(iArr[i11] + 1);
    }

    private Attribute readAttribute(Attribute[] attributeArr, String str, int i11, int i12, char[] cArr, int i13, Label[] labelArr) {
        String str2 = str;
        for (Attribute attribute : attributeArr) {
            if (attribute.type.equals(str)) {
                return attribute.h(this, i11, i12, cArr, i13, labelArr);
            }
        }
        return new Attribute(str).h(this, i11, i12, (char[]) null, -1, (Label[]) null);
    }

    private int[] readBootstrapMethodsAttribute(int i11) {
        char[] cArr = new char[i11];
        int a11 = a();
        for (int readUnsignedShort = readUnsignedShort(a11 - 2); readUnsignedShort > 0; readUnsignedShort--) {
            String readUTF8 = readUTF8(a11, cArr);
            int readInt = readInt(a11 + 2);
            int i12 = a11 + 6;
            if ("BootstrapMethods".equals(readUTF8)) {
                int readUnsignedShort2 = readUnsignedShort(i12);
                int[] iArr = new int[readUnsignedShort2];
                int i13 = i12 + 2;
                for (int i14 = 0; i14 < readUnsignedShort2; i14++) {
                    iArr[i14] = i13;
                    i13 += (readUnsignedShort(i13 + 2) * 2) + 4;
                }
                return iArr;
            }
            a11 = i12 + readInt;
        }
        throw new IllegalArgumentException();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v7, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v0, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r23v0, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r23v1, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v1, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r36v0, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r36v1, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v0, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v1, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v4, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v13, resolved type: int[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v9, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v10, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r35v5, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v32, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v50, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v51, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v15, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v52, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v4, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r24v8, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r22v4, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v57, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r35v7, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v62, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v39, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r35v8, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r35v9, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r35v10, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r35v11, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r35v12, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r35v13, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r35v14, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r35v15, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r35v16, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r35v17, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r35v18, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r35v19, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r35v20, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r35v21, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r35v22, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r35v23, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r35v24, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v100, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v63, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r35v25, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v64, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v102, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r35v26, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v65, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r35v27, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v70, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v113, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r35v28, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v115, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v73, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v74, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v116, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r35v29, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v119, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v76, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v81, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r35v30, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v121, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v85, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v35, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v45, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v38, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v39, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v1, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v2, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r36v32, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r23v8, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v50, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r36v33, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v51, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v52, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r36v34, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r23v10, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v9, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r36v35, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r23v11, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v10, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r23v12, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v11, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r36v36, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r36v37, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r36v38, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v12, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r23v13, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v13, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v119, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v120, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v121, resolved type: boolean} */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:176:0x04c3, code lost:
        r35 = r9;
        r1 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:178:0x04ee, code lost:
        r13 = r2;
        r1 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:184:0x0536, code lost:
        r34 = r3;
        r10 = r4;
        r43 = r6;
        r35 = r9;
        r36 = r13;
        r1 = r22;
        r4 = r29;
        r3 = r0;
        r13 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:185:0x0545, code lost:
        r0 = r18;
        r1 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:217:0x0787, code lost:
        r3 = r15 + 3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:219:0x07a1, code lost:
        r3 = r15 + 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0079, code lost:
        r0 = r0 + 5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:221:0x07b7, code lost:
        r3 = r15 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:222:0x07b9, code lost:
        r0 = r18;
        r1 = r22;
        r4 = r29;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:223:0x07bf, code lost:
        if (r32 == null) goto L_0x07f4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:224:0x07c1, code lost:
        r9 = r32;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:225:0x07c4, code lost:
        if (r1 >= r9.length) goto L_0x07f2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:226:0x07c6, code lost:
        if (r0 > r11) goto L_0x07f2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:227:0x07c8, code lost:
        if (r0 != r11) goto L_0x07e5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:228:0x07ca, code lost:
        r15 = r10;
        r10 = r42;
        r0 = readTypeAnnotationTarget(r10, r9[r1]);
        readElementValues(r14.visitInsnAnnotation(r10.f27363h, r10.f27364i, readUTF8(r0, r13), r15), r0 + 2, r15, r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:229:0x07e5, code lost:
        r15 = r10;
        r10 = r42;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:230:0x07e8, code lost:
        r1 = r1 + 1;
        r0 = getTypeAnnotationBytecodeOffset(r9, r1);
        r32 = r9;
        r10 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:231:0x07f2, code lost:
        r15 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:232:0x07f4, code lost:
        r15 = r10;
        r9 = r32;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:233:0x07f7, code lost:
        r10 = r42;
        r2 = r20;
        r5 = r24;
        r6 = r38;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:234:0x07ff, code lost:
        if (r6 == null) goto L_0x083d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:236:0x0802, code lost:
        if (r5 >= r6.length) goto L_0x083d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:237:0x0804, code lost:
        if (r2 > r11) goto L_0x083d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:238:0x0806, code lost:
        if (r2 != r11) goto L_0x0828;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:239:0x0808, code lost:
        r2 = readTypeAnnotationTarget(r10, r6[r5]);
        r18 = r0;
        r20 = r1;
        r22 = r11;
        readElementValues(r14.visitInsnAnnotation(r10.f27363h, r10.f27364i, readUTF8(r2, r13), false), r2 + 2, true, r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:240:0x0828, code lost:
        r18 = r0;
        r20 = r1;
        r22 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:241:0x082f, code lost:
        r5 = r5 + 1;
        r2 = getTypeAnnotationBytecodeOffset(r6, r5);
        r0 = r18;
        r1 = r20;
        r11 = r22;
        r5 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00da, code lost:
        r0 = r0 + 3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:339:0x07bf, code lost:
        r1 = r1;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void readCode(net.bytebuddy.jar.asm.MethodVisitor r41, net.bytebuddy.jar.asm.Context r42, int r43) {
        /*
            r40 = this;
            r8 = r40
            r9 = r41
            r10 = r42
            r11 = r43
            byte[] r12 = r8.f27351a
            char[] r13 = r10.f27358c
            int r14 = r8.readUnsignedShort(r11)
            int r0 = r11 + 2
            int r15 = r8.readUnsignedShort(r0)
            int r0 = r11 + 4
            int r7 = r8.readInt(r0)
            int r16 = r11 + 8
            byte[] r0 = r8.f27351a
            int r0 = r0.length
            int r0 = r0 - r16
            if (r7 > r0) goto L_0x09c0
            int r6 = r16 + r7
            int r0 = r7 + 1
            net.bytebuddy.jar.asm.Label[] r5 = new net.bytebuddy.jar.asm.Label[r0]
            r10.f27362g = r5
            r0 = r16
        L_0x002f:
            r4 = 132(0x84, float:1.85E-43)
            r2 = 8
            if (r0 >= r6) goto L_0x00e6
            int r1 = r0 - r16
            byte r3 = r12[r0]
            r3 = r3 & 255(0xff, float:3.57E-43)
            switch(r3) {
                case 0: goto L_0x00e2;
                case 1: goto L_0x00e2;
                case 2: goto L_0x00e2;
                case 3: goto L_0x00e2;
                case 4: goto L_0x00e2;
                case 5: goto L_0x00e2;
                case 6: goto L_0x00e2;
                case 7: goto L_0x00e2;
                case 8: goto L_0x00e2;
                case 9: goto L_0x00e2;
                case 10: goto L_0x00e2;
                case 11: goto L_0x00e2;
                case 12: goto L_0x00e2;
                case 13: goto L_0x00e2;
                case 14: goto L_0x00e2;
                case 15: goto L_0x00e2;
                case 16: goto L_0x00de;
                case 17: goto L_0x00da;
                case 18: goto L_0x00de;
                case 19: goto L_0x00da;
                case 20: goto L_0x00da;
                case 21: goto L_0x00de;
                case 22: goto L_0x00de;
                case 23: goto L_0x00de;
                case 24: goto L_0x00de;
                case 25: goto L_0x00de;
                case 26: goto L_0x00e2;
                case 27: goto L_0x00e2;
                case 28: goto L_0x00e2;
                case 29: goto L_0x00e2;
                case 30: goto L_0x00e2;
                case 31: goto L_0x00e2;
                case 32: goto L_0x00e2;
                case 33: goto L_0x00e2;
                case 34: goto L_0x00e2;
                case 35: goto L_0x00e2;
                case 36: goto L_0x00e2;
                case 37: goto L_0x00e2;
                case 38: goto L_0x00e2;
                case 39: goto L_0x00e2;
                case 40: goto L_0x00e2;
                case 41: goto L_0x00e2;
                case 42: goto L_0x00e2;
                case 43: goto L_0x00e2;
                case 44: goto L_0x00e2;
                case 45: goto L_0x00e2;
                case 46: goto L_0x00e2;
                case 47: goto L_0x00e2;
                case 48: goto L_0x00e2;
                case 49: goto L_0x00e2;
                case 50: goto L_0x00e2;
                case 51: goto L_0x00e2;
                case 52: goto L_0x00e2;
                case 53: goto L_0x00e2;
                case 54: goto L_0x00de;
                case 55: goto L_0x00de;
                case 56: goto L_0x00de;
                case 57: goto L_0x00de;
                case 58: goto L_0x00de;
                case 59: goto L_0x00e2;
                case 60: goto L_0x00e2;
                case 61: goto L_0x00e2;
                case 62: goto L_0x00e2;
                case 63: goto L_0x00e2;
                case 64: goto L_0x00e2;
                case 65: goto L_0x00e2;
                case 66: goto L_0x00e2;
                case 67: goto L_0x00e2;
                case 68: goto L_0x00e2;
                case 69: goto L_0x00e2;
                case 70: goto L_0x00e2;
                case 71: goto L_0x00e2;
                case 72: goto L_0x00e2;
                case 73: goto L_0x00e2;
                case 74: goto L_0x00e2;
                case 75: goto L_0x00e2;
                case 76: goto L_0x00e2;
                case 77: goto L_0x00e2;
                case 78: goto L_0x00e2;
                case 79: goto L_0x00e2;
                case 80: goto L_0x00e2;
                case 81: goto L_0x00e2;
                case 82: goto L_0x00e2;
                case 83: goto L_0x00e2;
                case 84: goto L_0x00e2;
                case 85: goto L_0x00e2;
                case 86: goto L_0x00e2;
                case 87: goto L_0x00e2;
                case 88: goto L_0x00e2;
                case 89: goto L_0x00e2;
                case 90: goto L_0x00e2;
                case 91: goto L_0x00e2;
                case 92: goto L_0x00e2;
                case 93: goto L_0x00e2;
                case 94: goto L_0x00e2;
                case 95: goto L_0x00e2;
                case 96: goto L_0x00e2;
                case 97: goto L_0x00e2;
                case 98: goto L_0x00e2;
                case 99: goto L_0x00e2;
                case 100: goto L_0x00e2;
                case 101: goto L_0x00e2;
                case 102: goto L_0x00e2;
                case 103: goto L_0x00e2;
                case 104: goto L_0x00e2;
                case 105: goto L_0x00e2;
                case 106: goto L_0x00e2;
                case 107: goto L_0x00e2;
                case 108: goto L_0x00e2;
                case 109: goto L_0x00e2;
                case 110: goto L_0x00e2;
                case 111: goto L_0x00e2;
                case 112: goto L_0x00e2;
                case 113: goto L_0x00e2;
                case 114: goto L_0x00e2;
                case 115: goto L_0x00e2;
                case 116: goto L_0x00e2;
                case 117: goto L_0x00e2;
                case 118: goto L_0x00e2;
                case 119: goto L_0x00e2;
                case 120: goto L_0x00e2;
                case 121: goto L_0x00e2;
                case 122: goto L_0x00e2;
                case 123: goto L_0x00e2;
                case 124: goto L_0x00e2;
                case 125: goto L_0x00e2;
                case 126: goto L_0x00e2;
                case 127: goto L_0x00e2;
                case 128: goto L_0x00e2;
                case 129: goto L_0x00e2;
                case 130: goto L_0x00e2;
                case 131: goto L_0x00e2;
                case 132: goto L_0x00da;
                case 133: goto L_0x00e2;
                case 134: goto L_0x00e2;
                case 135: goto L_0x00e2;
                case 136: goto L_0x00e2;
                case 137: goto L_0x00e2;
                case 138: goto L_0x00e2;
                case 139: goto L_0x00e2;
                case 140: goto L_0x00e2;
                case 141: goto L_0x00e2;
                case 142: goto L_0x00e2;
                case 143: goto L_0x00e2;
                case 144: goto L_0x00e2;
                case 145: goto L_0x00e2;
                case 146: goto L_0x00e2;
                case 147: goto L_0x00e2;
                case 148: goto L_0x00e2;
                case 149: goto L_0x00e2;
                case 150: goto L_0x00e2;
                case 151: goto L_0x00e2;
                case 152: goto L_0x00e2;
                case 153: goto L_0x00d0;
                case 154: goto L_0x00d0;
                case 155: goto L_0x00d0;
                case 156: goto L_0x00d0;
                case 157: goto L_0x00d0;
                case 158: goto L_0x00d0;
                case 159: goto L_0x00d0;
                case 160: goto L_0x00d0;
                case 161: goto L_0x00d0;
                case 162: goto L_0x00d0;
                case 163: goto L_0x00d0;
                case 164: goto L_0x00d0;
                case 165: goto L_0x00d0;
                case 166: goto L_0x00d0;
                case 167: goto L_0x00d0;
                case 168: goto L_0x00d0;
                case 169: goto L_0x00de;
                case 170: goto L_0x00a2;
                case 171: goto L_0x007c;
                case 172: goto L_0x00e2;
                case 173: goto L_0x00e2;
                case 174: goto L_0x00e2;
                case 175: goto L_0x00e2;
                case 176: goto L_0x00e2;
                case 177: goto L_0x00e2;
                case 178: goto L_0x00da;
                case 179: goto L_0x00da;
                case 180: goto L_0x00da;
                case 181: goto L_0x00da;
                case 182: goto L_0x00da;
                case 183: goto L_0x00da;
                case 184: goto L_0x00da;
                case 185: goto L_0x0079;
                case 186: goto L_0x0079;
                case 187: goto L_0x00da;
                case 188: goto L_0x00de;
                case 189: goto L_0x00da;
                case 190: goto L_0x00e2;
                case 191: goto L_0x00e2;
                case 192: goto L_0x00da;
                case 193: goto L_0x00da;
                case 194: goto L_0x00e2;
                case 195: goto L_0x00e2;
                case 196: goto L_0x005e;
                case 197: goto L_0x005b;
                case 198: goto L_0x00d0;
                case 199: goto L_0x00d0;
                case 200: goto L_0x0050;
                case 201: goto L_0x0050;
                case 202: goto L_0x0044;
                case 203: goto L_0x0044;
                case 204: goto L_0x0044;
                case 205: goto L_0x0044;
                case 206: goto L_0x0044;
                case 207: goto L_0x0044;
                case 208: goto L_0x0044;
                case 209: goto L_0x0044;
                case 210: goto L_0x0044;
                case 211: goto L_0x0044;
                case 212: goto L_0x0044;
                case 213: goto L_0x0044;
                case 214: goto L_0x0044;
                case 215: goto L_0x0044;
                case 216: goto L_0x0044;
                case 217: goto L_0x0044;
                case 218: goto L_0x0044;
                case 219: goto L_0x0044;
                case 220: goto L_0x0050;
                default: goto L_0x003e;
            }
        L_0x003e:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r0.<init>()
            throw r0
        L_0x0044:
            int r2 = r0 + 1
            int r2 = r8.readUnsignedShort(r2)
            int r1 = r1 + r2
            r8.createLabel(r1, r5)
            goto L_0x00da
        L_0x0050:
            int r2 = r0 + 1
            int r2 = r8.readInt(r2)
            int r1 = r1 + r2
            r8.createLabel(r1, r5)
            goto L_0x0079
        L_0x005b:
            int r0 = r0 + 4
            goto L_0x002f
        L_0x005e:
            int r1 = r0 + 1
            byte r1 = r12[r1]
            r1 = r1 & 255(0xff, float:3.57E-43)
            if (r1 == r4) goto L_0x0076
            r2 = 169(0xa9, float:2.37E-43)
            if (r1 == r2) goto L_0x005b
            switch(r1) {
                case 21: goto L_0x005b;
                case 22: goto L_0x005b;
                case 23: goto L_0x005b;
                case 24: goto L_0x005b;
                case 25: goto L_0x005b;
                default: goto L_0x006d;
            }
        L_0x006d:
            switch(r1) {
                case 54: goto L_0x005b;
                case 55: goto L_0x005b;
                case 56: goto L_0x005b;
                case 57: goto L_0x005b;
                case 58: goto L_0x005b;
                default: goto L_0x0070;
            }
        L_0x0070:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r0.<init>()
            throw r0
        L_0x0076:
            int r0 = r0 + 6
            goto L_0x002f
        L_0x0079:
            int r0 = r0 + 5
            goto L_0x002f
        L_0x007c:
            r3 = r1 & 3
            int r3 = 4 - r3
            int r0 = r0 + r3
            int r3 = r8.readInt(r0)
            int r3 = r3 + r1
            r8.createLabel(r3, r5)
            int r3 = r0 + 4
            int r3 = r8.readInt(r3)
            int r0 = r0 + r2
        L_0x0090:
            int r2 = r3 + -1
            if (r3 <= 0) goto L_0x002f
            int r3 = r0 + 4
            int r3 = r8.readInt(r3)
            int r3 = r3 + r1
            r8.createLabel(r3, r5)
            int r0 = r0 + 8
            r3 = r2
            goto L_0x0090
        L_0x00a2:
            r2 = r1 & 3
            int r2 = 4 - r2
            int r0 = r0 + r2
            int r2 = r8.readInt(r0)
            int r2 = r2 + r1
            r8.createLabel(r2, r5)
            int r2 = r0 + 8
            int r2 = r8.readInt(r2)
            int r3 = r0 + 4
            int r3 = r8.readInt(r3)
            int r2 = r2 - r3
            r3 = 1
            int r2 = r2 + r3
            int r0 = r0 + 12
        L_0x00c0:
            int r3 = r2 + -1
            if (r2 <= 0) goto L_0x002f
            int r2 = r8.readInt(r0)
            int r2 = r2 + r1
            r8.createLabel(r2, r5)
            int r0 = r0 + 4
            r2 = r3
            goto L_0x00c0
        L_0x00d0:
            int r2 = r0 + 1
            short r2 = r8.readShort(r2)
            int r1 = r1 + r2
            r8.createLabel(r1, r5)
        L_0x00da:
            int r0 = r0 + 3
            goto L_0x002f
        L_0x00de:
            int r0 = r0 + 2
            goto L_0x002f
        L_0x00e2:
            int r0 = r0 + 1
            goto L_0x002f
        L_0x00e6:
            int r1 = r8.readUnsignedShort(r0)
            int r0 = r0 + 2
        L_0x00ec:
            int r3 = r1 + -1
            if (r1 <= 0) goto L_0x012c
            int r1 = r8.readUnsignedShort(r0)
            net.bytebuddy.jar.asm.Label r1 = r8.createLabel(r1, r5)
            int r2 = r0 + 2
            int r2 = r8.readUnsignedShort(r2)
            net.bytebuddy.jar.asm.Label r2 = r8.createLabel(r2, r5)
            int r4 = r0 + 4
            int r4 = r8.readUnsignedShort(r4)
            net.bytebuddy.jar.asm.Label r4 = r8.createLabel(r4, r5)
            r20 = r3
            int[] r3 = r8.cpInfoOffsets
            r21 = r6
            int r6 = r0 + 6
            int r6 = r8.readUnsignedShort(r6)
            r3 = r3[r6]
            java.lang.String r3 = r8.readUTF8(r3, r13)
            int r0 = r0 + 8
            r9.visitTryCatchBlock(r1, r2, r4, r3)
            r1 = r20
            r6 = r21
            r2 = 8
            r4 = 132(0x84, float:1.85E-43)
            goto L_0x00ec
        L_0x012c:
            r21 = r6
            int r1 = r8.readUnsignedShort(r0)
            int r0 = r0 + 2
            r2 = 0
            r3 = 1
            r20 = 0
            r22 = 0
            r23 = 0
            r24 = 0
            r25 = 0
            r26 = 0
        L_0x0142:
            int r27 = r1 + -1
            if (r1 <= 0) goto L_0x0276
            java.lang.String r1 = r8.readUTF8(r0, r13)
            int r6 = r0 + 2
            int r29 = r8.readInt(r6)
            int r6 = r0 + 6
            java.lang.String r0 = "LocalVariableTable"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x018d
            int r0 = r10.f27357b
            r0 = r0 & 2
            if (r0 != 0) goto L_0x0187
            int r0 = r8.readUnsignedShort(r6)
            int r1 = r6 + 2
        L_0x0166:
            int r25 = r0 + -1
            if (r0 <= 0) goto L_0x0180
            int r0 = r8.readUnsignedShort(r1)
            r8.createDebugLabel(r0, r5)
            int r4 = r1 + 2
            int r4 = r8.readUnsignedShort(r4)
            int r0 = r0 + r4
            r8.createDebugLabel(r0, r5)
            int r1 = r1 + 10
            r0 = r25
            goto L_0x0166
        L_0x0180:
            r17 = r5
            r18 = r6
            r25 = r18
            goto L_0x019b
        L_0x0187:
            r31 = r2
            r2 = 0
            r4 = 1
            goto L_0x0228
        L_0x018d:
            java.lang.String r0 = "LocalVariableTypeTable"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x01a1
            r17 = r5
            r18 = r6
            r26 = r18
        L_0x019b:
            r36 = r7
            r35 = r21
            goto L_0x0232
        L_0x01a1:
            java.lang.String r0 = "LineNumberTable"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x01d3
            int r0 = r10.f27357b
            r0 = r0 & 2
            if (r0 != 0) goto L_0x0187
            int r0 = r8.readUnsignedShort(r6)
            int r1 = r6 + 2
        L_0x01b5:
            int r4 = r0 + -1
            if (r0 <= 0) goto L_0x0187
            int r0 = r8.readUnsignedShort(r1)
            r31 = r2
            int r2 = r1 + 2
            int r2 = r8.readUnsignedShort(r2)
            int r1 = r1 + 4
            r8.createDebugLabel(r0, r5)
            r0 = r5[r0]
            r0.b(r2)
            r0 = r4
            r2 = r31
            goto L_0x01b5
        L_0x01d3:
            r31 = r2
            java.lang.String r0 = "RuntimeVisibleTypeAnnotations"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x01e8
            r4 = 1
            int[] r0 = r8.readTypeAnnotations(r9, r10, r6, r4)
            r2 = r0
            r17 = r5
            r18 = r6
            goto L_0x019b
        L_0x01e8:
            r4 = 1
            java.lang.String r0 = "RuntimeInvisibleTypeAnnotations"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x01f9
            r2 = 0
            int[] r0 = r8.readTypeAnnotations(r9, r10, r6, r2)
            r22 = r0
            goto L_0x0228
        L_0x01f9:
            r2 = 0
            java.lang.String r0 = "StackMapTable"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0211
            int r0 = r10.f27357b
            r0 = r0 & 4
            if (r0 != 0) goto L_0x0228
            int r0 = r6 + 2
            int r1 = r6 + r29
            r20 = r0
            r23 = r1
            goto L_0x0228
        L_0x0211:
            java.lang.String r0 = "StackMap"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0235
            int r0 = r10.f27357b
            r0 = r0 & 4
            if (r0 != 0) goto L_0x0228
            int r0 = r6 + 2
            int r1 = r6 + r29
            r20 = r0
            r23 = r1
            r3 = r2
        L_0x0228:
            r17 = r5
            r18 = r6
            r36 = r7
            r35 = r21
            r2 = r31
        L_0x0232:
            r9 = 8
            goto L_0x0266
        L_0x0235:
            net.bytebuddy.jar.asm.Attribute[] r0 = r10.f27356a
            r17 = r0
            r0 = r40
            r30 = r1
            r1 = r17
            r17 = r2
            r11 = r31
            r9 = 8
            r2 = r30
            r32 = r3
            r3 = r6
            r4 = r29
            r17 = r5
            r5 = r13
            r18 = r6
            r35 = r21
            r6 = r43
            r36 = r7
            r7 = r17
            net.bytebuddy.jar.asm.Attribute r0 = r0.readAttribute(r1, r2, r3, r4, r5, r6, r7)
            r7 = r24
            r0.f27348a = r7
            r24 = r0
            r2 = r11
            r3 = r32
        L_0x0266:
            int r0 = r18 + r29
            r9 = r41
            r11 = r43
            r5 = r17
            r1 = r27
            r21 = r35
            r7 = r36
            goto L_0x0142
        L_0x0276:
            r11 = r2
            r32 = r3
            r17 = r5
            r36 = r7
            r35 = r21
            r7 = r24
            r9 = 8
            int r0 = r10.f27357b
            r0 = r0 & r9
            if (r0 == 0) goto L_0x028a
            r6 = 1
            goto L_0x028b
        L_0x028a:
            r6 = 0
        L_0x028b:
            r5 = -1
            if (r20 == 0) goto L_0x02e3
            r10.f27368m = r5
            r4 = 0
            r10.f27369n = r4
            r10.f27370o = r4
            r10.f27371p = r4
            java.lang.Object[] r0 = new java.lang.Object[r15]
            r10.f27372q = r0
            r10.f27373r = r4
            java.lang.Object[] r0 = new java.lang.Object[r14]
            r10.f27374s = r0
            if (r6 == 0) goto L_0x02a6
            r8.computeImplicitFrame(r10)
        L_0x02a6:
            r0 = r20
        L_0x02a8:
            r3 = r23
            int r1 = r3 + -2
            if (r0 >= r1) goto L_0x02e0
            byte r1 = r12[r0]
            if (r1 != r9) goto L_0x02d1
            int r1 = r0 + 1
            int r1 = r8.readUnsignedShort(r1)
            if (r1 < 0) goto L_0x02d1
            r2 = r36
            if (r1 >= r2) goto L_0x02ce
            int r18 = r16 + r1
            byte r4 = r12[r18]
            r4 = r4 & 255(0xff, float:3.57E-43)
            r5 = 187(0xbb, float:2.62E-43)
            if (r4 != r5) goto L_0x02ce
            r5 = r17
            r8.createLabel(r1, r5)
            goto L_0x02d5
        L_0x02ce:
            r5 = r17
            goto L_0x02d5
        L_0x02d1:
            r5 = r17
            r2 = r36
        L_0x02d5:
            int r0 = r0 + 1
            r36 = r2
            r23 = r3
            r17 = r5
            r4 = 0
            r5 = -1
            goto L_0x02a8
        L_0x02e0:
            r5 = r17
            goto L_0x02e7
        L_0x02e3:
            r5 = r17
            r3 = r23
        L_0x02e7:
            r2 = r36
            if (r6 == 0) goto L_0x030b
            int r0 = r10.f27357b
            r0 = r0 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x030b
            r1 = -1
            r4 = 0
            r17 = 0
            r18 = 0
            r0 = r41
            r19 = r2
            r2 = r15
            r9 = r3
            r3 = r4
            r23 = r7
            r7 = 0
            r4 = r17
            r37 = r5
            r5 = r18
            r0.visitFrame(r1, r2, r3, r4, r5)
            goto L_0x0313
        L_0x030b:
            r19 = r2
            r9 = r3
            r37 = r5
            r23 = r7
            r7 = 0
        L_0x0313:
            int r0 = r8.getTypeAnnotationBytecodeOffset(r11, r7)
            r5 = r22
            int r1 = r8.getTypeAnnotationBytecodeOffset(r5, r7)
            int r2 = r10.f27357b
            r2 = r2 & 256(0x100, float:3.59E-43)
            if (r2 != 0) goto L_0x0328
            r4 = 33
            r17 = r4
            goto L_0x032a
        L_0x0328:
            r17 = r7
        L_0x032a:
            r18 = r0
            r4 = r7
            r22 = r4
            r24 = r22
            r3 = r16
            r0 = r20
            r20 = r1
        L_0x0337:
            r2 = r35
            if (r3 >= r2) goto L_0x085d
            int r1 = r3 - r16
            r43 = r0
            r7 = r37
            r0 = r7[r1]
            r35 = r2
            if (r0 == 0) goto L_0x035a
            int r2 = r10.f27357b
            r2 = r2 & 2
            r21 = r14
            if (r2 != 0) goto L_0x0351
            r2 = 1
            goto L_0x0352
        L_0x0351:
            r2 = 0
        L_0x0352:
            r27 = 8
            r14 = r41
            r0.a(r14, r2)
            goto L_0x0360
        L_0x035a:
            r21 = r14
            r27 = 8
            r14 = r41
        L_0x0360:
            r0 = r4
            r4 = r43
        L_0x0363:
            if (r4 == 0) goto L_0x03f6
            int r2 = r10.f27368m
            r28 = r15
            r15 = -1
            if (r2 == r1) goto L_0x0377
            if (r2 != r15) goto L_0x036f
            goto L_0x0377
        L_0x036f:
            r15 = r3
            r14 = r4
            r38 = r5
            r31 = r35
            goto L_0x03fe
        L_0x0377:
            if (r2 == r15) goto L_0x03c5
            r2 = r32
            if (r2 == 0) goto L_0x03a9
            if (r6 == 0) goto L_0x0380
            goto L_0x03a9
        L_0x0380:
            int r0 = r10.f27369n
            int r15 = r10.f27371p
            r29 = r3
            java.lang.Object[] r3 = r10.f27372q
            r43 = r4
            int r4 = r10.f27373r
            r30 = r5
            java.lang.Object[] r5 = r10.f27374s
            r31 = r0
            r0 = r41
            r32 = r11
            r11 = r1
            r1 = r31
            r31 = r35
            r35 = r13
            r13 = r2
            r2 = r15
            r15 = r29
            r14 = r43
            r38 = r30
            r0.visitFrame(r1, r2, r3, r4, r5)
            goto L_0x03c3
        L_0x03a9:
            r15 = r3
            r14 = r4
            r38 = r5
            r32 = r11
            r31 = r35
            r11 = r1
            r35 = r13
            r13 = r2
            r1 = -1
            int r2 = r10.f27370o
            java.lang.Object[] r3 = r10.f27372q
            int r4 = r10.f27373r
            java.lang.Object[] r5 = r10.f27374s
            r0 = r41
            r0.visitFrame(r1, r2, r3, r4, r5)
        L_0x03c3:
            r0 = 0
            goto L_0x03d2
        L_0x03c5:
            r15 = r3
            r14 = r4
            r38 = r5
            r31 = r35
            r35 = r13
            r13 = r32
            r32 = r11
            r11 = r1
        L_0x03d2:
            if (r14 >= r9) goto L_0x03e3
            int r4 = r8.readStackMapFrame(r14, r13, r6, r10)
            r14 = r41
            r1 = r11
            r3 = r15
            r15 = r28
            r11 = r32
            r5 = r38
            goto L_0x03ee
        L_0x03e3:
            r14 = r41
            r1 = r11
            r3 = r15
            r15 = r28
            r11 = r32
            r5 = r38
            r4 = 0
        L_0x03ee:
            r32 = r13
            r13 = r35
            r35 = r31
            goto L_0x0363
        L_0x03f6:
            r14 = r4
            r38 = r5
            r28 = r15
            r31 = r35
            r15 = r3
        L_0x03fe:
            r35 = r13
            r13 = r32
            r32 = r11
            r11 = r1
            if (r0 == 0) goto L_0x041b
            int r0 = r10.f27357b
            r0 = r0 & 8
            if (r0 == 0) goto L_0x0418
            r1 = 256(0x100, float:3.59E-43)
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            r0 = r41
            r0.visitFrame(r1, r2, r3, r4, r5)
        L_0x0418:
            r29 = 0
            goto L_0x041d
        L_0x041b:
            r29 = r0
        L_0x041d:
            byte r0 = r12[r15]
            r5 = r0 & 255(0xff, float:3.57E-43)
            r0 = 200(0xc8, float:2.8E-43)
            switch(r5) {
                case 0: goto L_0x07a4;
                case 1: goto L_0x07a4;
                case 2: goto L_0x07a4;
                case 3: goto L_0x07a4;
                case 4: goto L_0x07a4;
                case 5: goto L_0x07a4;
                case 6: goto L_0x07a4;
                case 7: goto L_0x07a4;
                case 8: goto L_0x07a4;
                case 9: goto L_0x07a4;
                case 10: goto L_0x07a4;
                case 11: goto L_0x07a4;
                case 12: goto L_0x07a4;
                case 13: goto L_0x07a4;
                case 14: goto L_0x07a4;
                case 15: goto L_0x07a4;
                case 16: goto L_0x078a;
                case 17: goto L_0x076e;
                case 18: goto L_0x0751;
                case 19: goto L_0x0734;
                case 20: goto L_0x0734;
                case 21: goto L_0x0719;
                case 22: goto L_0x0719;
                case 23: goto L_0x0719;
                case 24: goto L_0x0719;
                case 25: goto L_0x0719;
                case 26: goto L_0x06fc;
                case 27: goto L_0x06fc;
                case 28: goto L_0x06fc;
                case 29: goto L_0x06fc;
                case 30: goto L_0x06fc;
                case 31: goto L_0x06fc;
                case 32: goto L_0x06fc;
                case 33: goto L_0x06fc;
                case 34: goto L_0x06fc;
                case 35: goto L_0x06fc;
                case 36: goto L_0x06fc;
                case 37: goto L_0x06fc;
                case 38: goto L_0x06fc;
                case 39: goto L_0x06fc;
                case 40: goto L_0x06fc;
                case 41: goto L_0x06fc;
                case 42: goto L_0x06fc;
                case 43: goto L_0x06fc;
                case 44: goto L_0x06fc;
                case 45: goto L_0x06fc;
                case 46: goto L_0x07a4;
                case 47: goto L_0x07a4;
                case 48: goto L_0x07a4;
                case 49: goto L_0x07a4;
                case 50: goto L_0x07a4;
                case 51: goto L_0x07a4;
                case 52: goto L_0x07a4;
                case 53: goto L_0x07a4;
                case 54: goto L_0x0719;
                case 55: goto L_0x0719;
                case 56: goto L_0x0719;
                case 57: goto L_0x0719;
                case 58: goto L_0x0719;
                case 59: goto L_0x06df;
                case 60: goto L_0x06df;
                case 61: goto L_0x06df;
                case 62: goto L_0x06df;
                case 63: goto L_0x06df;
                case 64: goto L_0x06df;
                case 65: goto L_0x06df;
                case 66: goto L_0x06df;
                case 67: goto L_0x06df;
                case 68: goto L_0x06df;
                case 69: goto L_0x06df;
                case 70: goto L_0x06df;
                case 71: goto L_0x06df;
                case 72: goto L_0x06df;
                case 73: goto L_0x06df;
                case 74: goto L_0x06df;
                case 75: goto L_0x06df;
                case 76: goto L_0x06df;
                case 77: goto L_0x06df;
                case 78: goto L_0x06df;
                case 79: goto L_0x07a4;
                case 80: goto L_0x07a4;
                case 81: goto L_0x07a4;
                case 82: goto L_0x07a4;
                case 83: goto L_0x07a4;
                case 84: goto L_0x07a4;
                case 85: goto L_0x07a4;
                case 86: goto L_0x07a4;
                case 87: goto L_0x07a4;
                case 88: goto L_0x07a4;
                case 89: goto L_0x07a4;
                case 90: goto L_0x07a4;
                case 91: goto L_0x07a4;
                case 92: goto L_0x07a4;
                case 93: goto L_0x07a4;
                case 94: goto L_0x07a4;
                case 95: goto L_0x07a4;
                case 96: goto L_0x07a4;
                case 97: goto L_0x07a4;
                case 98: goto L_0x07a4;
                case 99: goto L_0x07a4;
                case 100: goto L_0x07a4;
                case 101: goto L_0x07a4;
                case 102: goto L_0x07a4;
                case 103: goto L_0x07a4;
                case 104: goto L_0x07a4;
                case 105: goto L_0x07a4;
                case 106: goto L_0x07a4;
                case 107: goto L_0x07a4;
                case 108: goto L_0x07a4;
                case 109: goto L_0x07a4;
                case 110: goto L_0x07a4;
                case 111: goto L_0x07a4;
                case 112: goto L_0x07a4;
                case 113: goto L_0x07a4;
                case 114: goto L_0x07a4;
                case 115: goto L_0x07a4;
                case 116: goto L_0x07a4;
                case 117: goto L_0x07a4;
                case 118: goto L_0x07a4;
                case 119: goto L_0x07a4;
                case 120: goto L_0x07a4;
                case 121: goto L_0x07a4;
                case 122: goto L_0x07a4;
                case 123: goto L_0x07a4;
                case 124: goto L_0x07a4;
                case 125: goto L_0x07a4;
                case 126: goto L_0x07a4;
                case 127: goto L_0x07a4;
                case 128: goto L_0x07a4;
                case 129: goto L_0x07a4;
                case 130: goto L_0x07a4;
                case 131: goto L_0x07a4;
                case 132: goto L_0x06c1;
                case 133: goto L_0x07a4;
                case 134: goto L_0x07a4;
                case 135: goto L_0x07a4;
                case 136: goto L_0x07a4;
                case 137: goto L_0x07a4;
                case 138: goto L_0x07a4;
                case 139: goto L_0x07a4;
                case 140: goto L_0x07a4;
                case 141: goto L_0x07a4;
                case 142: goto L_0x07a4;
                case 143: goto L_0x07a4;
                case 144: goto L_0x07a4;
                case 145: goto L_0x07a4;
                case 146: goto L_0x07a4;
                case 147: goto L_0x07a4;
                case 148: goto L_0x07a4;
                case 149: goto L_0x07a4;
                case 150: goto L_0x07a4;
                case 151: goto L_0x07a4;
                case 152: goto L_0x07a4;
                case 153: goto L_0x06a2;
                case 154: goto L_0x06a2;
                case 155: goto L_0x06a2;
                case 156: goto L_0x06a2;
                case 157: goto L_0x06a2;
                case 158: goto L_0x06a2;
                case 159: goto L_0x06a2;
                case 160: goto L_0x06a2;
                case 161: goto L_0x06a2;
                case 162: goto L_0x06a2;
                case 163: goto L_0x06a2;
                case 164: goto L_0x06a2;
                case 165: goto L_0x06a2;
                case 166: goto L_0x06a2;
                case 167: goto L_0x06a2;
                case 168: goto L_0x06a2;
                case 169: goto L_0x0719;
                case 170: goto L_0x065c;
                case 171: goto L_0x0615;
                case 172: goto L_0x07a4;
                case 173: goto L_0x07a4;
                case 174: goto L_0x07a4;
                case 175: goto L_0x07a4;
                case 176: goto L_0x07a4;
                case 177: goto L_0x07a4;
                case 178: goto L_0x05b6;
                case 179: goto L_0x05b6;
                case 180: goto L_0x05b6;
                case 181: goto L_0x05b6;
                case 182: goto L_0x05b6;
                case 183: goto L_0x05b6;
                case 184: goto L_0x05b6;
                case 185: goto L_0x05b6;
                case 186: goto L_0x0549;
                case 187: goto L_0x0522;
                case 188: goto L_0x078a;
                case 189: goto L_0x0522;
                case 190: goto L_0x07a4;
                case 191: goto L_0x07a4;
                case 192: goto L_0x0522;
                case 193: goto L_0x0522;
                case 194: goto L_0x07a4;
                case 195: goto L_0x07a4;
                case 196: goto L_0x04f3;
                case 197: goto L_0x04c9;
                case 198: goto L_0x06a2;
                case 199: goto L_0x06a2;
                case 200: goto L_0x04a0;
                case 201: goto L_0x04a0;
                case 202: goto L_0x044c;
                case 203: goto L_0x044c;
                case 204: goto L_0x044c;
                case 205: goto L_0x044c;
                case 206: goto L_0x044c;
                case 207: goto L_0x044c;
                case 208: goto L_0x044c;
                case 209: goto L_0x044c;
                case 210: goto L_0x044c;
                case 211: goto L_0x044c;
                case 212: goto L_0x044c;
                case 213: goto L_0x044c;
                case 214: goto L_0x044c;
                case 215: goto L_0x044c;
                case 216: goto L_0x044c;
                case 217: goto L_0x044c;
                case 218: goto L_0x044c;
                case 219: goto L_0x044c;
                case 220: goto L_0x042c;
                default: goto L_0x0426;
            }
        L_0x0426:
            java.lang.AssertionError r0 = new java.lang.AssertionError
            r0.<init>()
            throw r0
        L_0x042c:
            int r3 = r15 + 1
            int r1 = r8.readInt(r3)
            int r1 = r1 + r11
            r1 = r7[r1]
            r30 = r14
            r14 = r41
            r14.visitJumpInsn(r0, r1)
            int r3 = r15 + 5
            r43 = r6
            r36 = r13
            r0 = r18
            r1 = r22
            r13 = r35
            r4 = 1
            r10 = 1
            goto L_0x04c3
        L_0x044c:
            r30 = r14
            r14 = r41
            r1 = 218(0xda, float:3.05E-43)
            if (r5 >= r1) goto L_0x0457
            int r5 = r5 + -49
            goto L_0x0459
        L_0x0457:
            int r5 = r5 + -20
        L_0x0459:
            int r3 = r15 + 1
            int r1 = r8.readUnsignedShort(r3)
            int r1 = r1 + r11
            r1 = r7[r1]
            r2 = 167(0xa7, float:2.34E-43)
            if (r5 == r2) goto L_0x0485
            r3 = 168(0xa8, float:2.35E-43)
            if (r5 != r3) goto L_0x046b
            goto L_0x0485
        L_0x046b:
            if (r5 >= r2) goto L_0x0474
            int r5 = r5 + 1
            r4 = 1
            r2 = r5 ^ 1
            int r2 = r2 - r4
            goto L_0x0477
        L_0x0474:
            r4 = 1
            r2 = r5 ^ 1
        L_0x0477:
            int r3 = r11 + 3
            net.bytebuddy.jar.asm.Label r3 = r8.createLabel(r3, r7)
            r14.visitJumpInsn(r2, r3)
            r14.visitJumpInsn(r0, r1)
            r3 = r4
            goto L_0x048d
        L_0x0485:
            r4 = 1
            int r5 = r5 + 33
            r14.visitJumpInsn(r5, r1)
            r3 = r29
        L_0x048d:
            int r0 = r15 + 3
            r10 = r4
            r43 = r6
            r36 = r13
            r1 = r22
            r13 = r35
            r34 = 132(0x84, float:1.85E-43)
            r4 = r3
            r35 = r9
            r3 = r0
            goto L_0x0545
        L_0x04a0:
            r30 = r14
            r4 = 1
            r14 = r41
            int r5 = r5 - r17
            int r3 = r15 + 1
            int r0 = r8.readInt(r3)
            int r1 = r11 + r0
            r0 = r7[r1]
            r14.visitJumpInsn(r5, r0)
            int r3 = r15 + 5
            r10 = r4
            r43 = r6
            r36 = r13
            r0 = r18
            r1 = r22
            r4 = r29
            r13 = r35
        L_0x04c3:
            r34 = 132(0x84, float:1.85E-43)
            r35 = r9
            goto L_0x07bf
        L_0x04c9:
            r30 = r14
            r4 = 1
            r14 = r41
            int r3 = r15 + 1
            r2 = r35
            java.lang.String r0 = r8.readClass(r3, r2)
            int r3 = r15 + 3
            byte r1 = r12[r3]
            r1 = r1 & 255(0xff, float:3.57E-43)
            r14.visitMultiANewArrayInsn(r0, r1)
            int r3 = r15 + 4
            r10 = r4
            r43 = r6
            r35 = r9
            r36 = r13
            r0 = r18
            r1 = r22
            r4 = r29
        L_0x04ee:
            r34 = 132(0x84, float:1.85E-43)
            r13 = r2
            goto L_0x07bf
        L_0x04f3:
            r30 = r14
            r2 = r35
            r4 = 1
            r14 = r41
            int r3 = r15 + 1
            byte r0 = r12[r3]
            r0 = r0 & 255(0xff, float:3.57E-43)
            r3 = 132(0x84, float:1.85E-43)
            if (r0 != r3) goto L_0x0516
            int r0 = r15 + 2
            int r0 = r8.readUnsignedShort(r0)
            int r1 = r15 + 4
            short r1 = r8.readShort(r1)
            r14.visitIincInsn(r0, r1)
            int r0 = r15 + 6
            goto L_0x0536
        L_0x0516:
            int r1 = r15 + 2
            int r1 = r8.readUnsignedShort(r1)
            r14.visitVarInsn(r0, r1)
            int r0 = r15 + 4
            goto L_0x0536
        L_0x0522:
            r30 = r14
            r2 = r35
            r3 = 132(0x84, float:1.85E-43)
            r4 = 1
            r14 = r41
            int r0 = r15 + 1
            java.lang.String r0 = r8.readClass(r0, r2)
            r14.visitTypeInsn(r5, r0)
            int r0 = r15 + 3
        L_0x0536:
            r34 = r3
            r10 = r4
            r43 = r6
            r35 = r9
            r36 = r13
            r1 = r22
            r4 = r29
            r3 = r0
            r13 = r2
        L_0x0545:
            r0 = r18
            goto L_0x07bf
        L_0x0549:
            r30 = r14
            r2 = r35
            r3 = 132(0x84, float:1.85E-43)
            r4 = 1
            r14 = r41
            int[] r0 = r8.cpInfoOffsets
            int r1 = r15 + 1
            int r1 = r8.readUnsignedShort(r1)
            r0 = r0[r1]
            int[] r1 = r8.cpInfoOffsets
            int r5 = r0 + 2
            int r5 = r8.readUnsignedShort(r5)
            r1 = r1[r5]
            java.lang.String r5 = r8.readUTF8(r1, r2)
            int r1 = r1 + 2
            java.lang.String r1 = r8.readUTF8(r1, r2)
            int[] r3 = r8.bootstrapMethodOffsets
            int r0 = r8.readUnsignedShort(r0)
            r0 = r3[r0]
            int r3 = r8.readUnsignedShort(r0)
            java.lang.Object r3 = r8.readConst(r3, r2)
            net.bytebuddy.jar.asm.Handle r3 = (net.bytebuddy.jar.asm.Handle) r3
            int r4 = r0 + 2
            int r4 = r8.readUnsignedShort(r4)
            r43 = r6
            java.lang.Object[] r6 = new java.lang.Object[r4]
            int r0 = r0 + 4
            r35 = r9
            r9 = 0
        L_0x0591:
            if (r9 >= r4) goto L_0x05a6
            r36 = r4
            int r4 = r8.readUnsignedShort(r0)
            java.lang.Object r4 = r8.readConst(r4, r2)
            r6[r9] = r4
            int r0 = r0 + 2
            int r9 = r9 + 1
            r4 = r36
            goto L_0x0591
        L_0x05a6:
            r14.visitInvokeDynamicInsn(r5, r1, r3, r6)
            int r3 = r15 + 5
            r36 = r13
            r0 = r18
            r1 = r22
            r4 = r29
            r10 = 1
            goto L_0x04ee
        L_0x05b6:
            r43 = r6
            r30 = r14
            r2 = r35
            r14 = r41
            r35 = r9
            int[] r0 = r8.cpInfoOffsets
            int r3 = r15 + 1
            int r1 = r8.readUnsignedShort(r3)
            r0 = r0[r1]
            int[] r1 = r8.cpInfoOffsets
            int r3 = r0 + 2
            int r3 = r8.readUnsignedShort(r3)
            r1 = r1[r3]
            java.lang.String r3 = r8.readClass(r0, r2)
            java.lang.String r4 = r8.readUTF8(r1, r2)
            int r1 = r1 + 2
            java.lang.String r6 = r8.readUTF8(r1, r2)
            r1 = 182(0xb6, float:2.55E-43)
            if (r5 >= r1) goto L_0x05f1
            r14.visitFieldInsn(r5, r3, r4, r6)
            r6 = r5
            r36 = r13
            r10 = 1
            r34 = 132(0x84, float:1.85E-43)
            r13 = r2
            goto L_0x060d
        L_0x05f1:
            int r0 = r0 + -1
            byte r0 = r12[r0]
            r1 = 11
            if (r0 != r1) goto L_0x05fb
            r9 = 1
            goto L_0x05fc
        L_0x05fb:
            r9 = 0
        L_0x05fc:
            r0 = r41
            r1 = r5
            r36 = r13
            r13 = r2
            r2 = r3
            r34 = 132(0x84, float:1.85E-43)
            r3 = r4
            r10 = 1
            r4 = r6
            r6 = r5
            r5 = r9
            r0.visitMethodInsn(r1, r2, r3, r4, r5)
        L_0x060d:
            r0 = 185(0xb9, float:2.59E-43)
            if (r6 != r0) goto L_0x0787
            int r3 = r15 + 5
            goto L_0x07b9
        L_0x0615:
            r43 = r6
            r36 = r13
            r30 = r14
            r13 = r35
            r10 = 1
            r34 = 132(0x84, float:1.85E-43)
            r14 = r41
            r35 = r9
            r0 = r11 & 3
            int r0 = 4 - r0
            int r3 = r15 + r0
            int r0 = r8.readInt(r3)
            int r1 = r11 + r0
            r0 = r7[r1]
            int r1 = r3 + 4
            int r1 = r8.readInt(r1)
            int r3 = r3 + 8
            int[] r2 = new int[r1]
            net.bytebuddy.jar.asm.Label[] r4 = new net.bytebuddy.jar.asm.Label[r1]
            r5 = 0
        L_0x063f:
            if (r5 >= r1) goto L_0x0657
            int r6 = r8.readInt(r3)
            r2[r5] = r6
            int r6 = r3 + 4
            int r6 = r8.readInt(r6)
            int r6 = r6 + r11
            r6 = r7[r6]
            r4[r5] = r6
            int r3 = r3 + 8
            int r5 = r5 + 1
            goto L_0x063f
        L_0x0657:
            r14.visitLookupSwitchInsn(r0, r2, r4)
            goto L_0x07b9
        L_0x065c:
            r43 = r6
            r36 = r13
            r30 = r14
            r13 = r35
            r10 = 1
            r34 = 132(0x84, float:1.85E-43)
            r14 = r41
            r35 = r9
            r0 = r11 & 3
            int r0 = 4 - r0
            int r3 = r15 + r0
            int r0 = r8.readInt(r3)
            int r1 = r11 + r0
            r0 = r7[r1]
            int r1 = r3 + 4
            int r1 = r8.readInt(r1)
            int r2 = r3 + 8
            int r2 = r8.readInt(r2)
            int r3 = r3 + 12
            int r4 = r2 - r1
            int r4 = r4 + r10
            net.bytebuddy.jar.asm.Label[] r5 = new net.bytebuddy.jar.asm.Label[r4]
            r6 = 0
        L_0x068d:
            if (r6 >= r4) goto L_0x069d
            int r9 = r8.readInt(r3)
            int r9 = r9 + r11
            r9 = r7[r9]
            r5[r6] = r9
            int r3 = r3 + 4
            int r6 = r6 + 1
            goto L_0x068d
        L_0x069d:
            r14.visitTableSwitchInsn(r1, r2, r0, r5)
            goto L_0x07b9
        L_0x06a2:
            r43 = r6
            r36 = r13
            r30 = r14
            r13 = r35
            r10 = 1
            r34 = 132(0x84, float:1.85E-43)
            r14 = r41
            r6 = r5
            r35 = r9
            int r3 = r15 + 1
            short r0 = r8.readShort(r3)
            int r1 = r11 + r0
            r0 = r7[r1]
            r14.visitJumpInsn(r6, r0)
            goto L_0x0787
        L_0x06c1:
            r43 = r6
            r36 = r13
            r30 = r14
            r13 = r35
            r10 = 1
            r34 = 132(0x84, float:1.85E-43)
            r14 = r41
            r35 = r9
            int r3 = r15 + 1
            byte r0 = r12[r3]
            r0 = r0 & 255(0xff, float:3.57E-43)
            int r3 = r15 + 2
            byte r1 = r12[r3]
            r14.visitIincInsn(r0, r1)
            goto L_0x0787
        L_0x06df:
            r43 = r6
            r36 = r13
            r30 = r14
            r13 = r35
            r10 = 1
            r34 = 132(0x84, float:1.85E-43)
            r14 = r41
            r6 = r5
            r35 = r9
            int r5 = r6 + -59
            int r0 = r5 >> 2
            int r0 = r0 + 54
            r1 = r5 & 3
            r14.visitVarInsn(r0, r1)
            goto L_0x07b7
        L_0x06fc:
            r43 = r6
            r36 = r13
            r30 = r14
            r13 = r35
            r10 = 1
            r34 = 132(0x84, float:1.85E-43)
            r14 = r41
            r6 = r5
            r35 = r9
            int r5 = r6 + -26
            int r0 = r5 >> 2
            int r0 = r0 + 21
            r1 = r5 & 3
            r14.visitVarInsn(r0, r1)
            goto L_0x07b7
        L_0x0719:
            r43 = r6
            r36 = r13
            r30 = r14
            r13 = r35
            r10 = 1
            r34 = 132(0x84, float:1.85E-43)
            r14 = r41
            r6 = r5
            r35 = r9
            int r3 = r15 + 1
            byte r0 = r12[r3]
            r0 = r0 & 255(0xff, float:3.57E-43)
            r14.visitVarInsn(r6, r0)
            goto L_0x07a1
        L_0x0734:
            r43 = r6
            r36 = r13
            r30 = r14
            r13 = r35
            r10 = 1
            r34 = 132(0x84, float:1.85E-43)
            r14 = r41
            r35 = r9
            int r3 = r15 + 1
            int r0 = r8.readUnsignedShort(r3)
            java.lang.Object r0 = r8.readConst(r0, r13)
            r14.visitLdcInsn(r0)
            goto L_0x0787
        L_0x0751:
            r43 = r6
            r36 = r13
            r30 = r14
            r13 = r35
            r10 = 1
            r34 = 132(0x84, float:1.85E-43)
            r14 = r41
            r35 = r9
            int r3 = r15 + 1
            byte r0 = r12[r3]
            r0 = r0 & 255(0xff, float:3.57E-43)
            java.lang.Object r0 = r8.readConst(r0, r13)
            r14.visitLdcInsn(r0)
            goto L_0x07a1
        L_0x076e:
            r43 = r6
            r36 = r13
            r30 = r14
            r13 = r35
            r10 = 1
            r34 = 132(0x84, float:1.85E-43)
            r14 = r41
            r6 = r5
            r35 = r9
            int r3 = r15 + 1
            short r0 = r8.readShort(r3)
            r14.visitIntInsn(r6, r0)
        L_0x0787:
            int r3 = r15 + 3
            goto L_0x07b9
        L_0x078a:
            r43 = r6
            r36 = r13
            r30 = r14
            r13 = r35
            r10 = 1
            r34 = 132(0x84, float:1.85E-43)
            r14 = r41
            r6 = r5
            r35 = r9
            int r3 = r15 + 1
            byte r0 = r12[r3]
            r14.visitIntInsn(r6, r0)
        L_0x07a1:
            int r3 = r15 + 2
            goto L_0x07b9
        L_0x07a4:
            r43 = r6
            r36 = r13
            r30 = r14
            r13 = r35
            r10 = 1
            r34 = 132(0x84, float:1.85E-43)
            r14 = r41
            r6 = r5
            r35 = r9
            r14.visitInsn(r6)
        L_0x07b7:
            int r3 = r15 + 1
        L_0x07b9:
            r0 = r18
            r1 = r22
            r4 = r29
        L_0x07bf:
            if (r32 == 0) goto L_0x07f4
            r9 = r32
            int r2 = r9.length
            if (r1 >= r2) goto L_0x07f2
            if (r0 > r11) goto L_0x07f2
            if (r0 != r11) goto L_0x07e5
            r0 = r9[r1]
            r15 = r10
            r10 = r42
            int r0 = r8.readTypeAnnotationTarget(r10, r0)
            java.lang.String r2 = r8.readUTF8(r0, r13)
            int r0 = r0 + 2
            int r5 = r10.f27363h
            net.bytebuddy.jar.asm.TypePath r6 = r10.f27364i
            net.bytebuddy.jar.asm.AnnotationVisitor r2 = r14.visitInsnAnnotation(r5, r6, r2, r15)
            r8.readElementValues(r2, r0, r15, r13)
            goto L_0x07e8
        L_0x07e5:
            r15 = r10
            r10 = r42
        L_0x07e8:
            int r1 = r1 + 1
            int r0 = r8.getTypeAnnotationBytecodeOffset(r9, r1)
            r32 = r9
            r10 = r15
            goto L_0x07bf
        L_0x07f2:
            r15 = r10
            goto L_0x07f7
        L_0x07f4:
            r15 = r10
            r9 = r32
        L_0x07f7:
            r10 = r42
            r2 = r20
            r5 = r24
            r6 = r38
        L_0x07ff:
            if (r6 == 0) goto L_0x083d
            int r15 = r6.length
            if (r5 >= r15) goto L_0x083d
            if (r2 > r11) goto L_0x083d
            if (r2 != r11) goto L_0x0828
            r2 = r6[r5]
            int r2 = r8.readTypeAnnotationTarget(r10, r2)
            java.lang.String r15 = r8.readUTF8(r2, r13)
            int r2 = r2 + 2
            r18 = r0
            int r0 = r10.f27363h
            r20 = r1
            net.bytebuddy.jar.asm.TypePath r1 = r10.f27364i
            r22 = r11
            r11 = 0
            net.bytebuddy.jar.asm.AnnotationVisitor r0 = r14.visitInsnAnnotation(r0, r1, r15, r11)
            r1 = 1
            r8.readElementValues(r0, r2, r1, r13)
            goto L_0x082f
        L_0x0828:
            r18 = r0
            r20 = r1
            r22 = r11
            r11 = 0
        L_0x082f:
            int r5 = r5 + 1
            int r2 = r8.getTypeAnnotationBytecodeOffset(r6, r5)
            r0 = r18
            r1 = r20
            r11 = r22
            r15 = 1
            goto L_0x07ff
        L_0x083d:
            r18 = r0
            r20 = r1
            r11 = 0
            r24 = r5
            r5 = r6
            r37 = r7
            r7 = r11
            r22 = r20
            r14 = r21
            r15 = r28
            r0 = r30
            r32 = r36
            r6 = r43
            r20 = r2
            r11 = r9
            r9 = r35
            r35 = r31
            goto L_0x0337
        L_0x085d:
            r6 = r5
            r9 = r11
            r21 = r14
            r28 = r15
            r14 = r41
            r11 = r7
            r7 = r37
            r0 = r7[r19]
            if (r0 == 0) goto L_0x086f
            r14.visitLabel(r0)
        L_0x086f:
            r4 = r25
            if (r4 == 0) goto L_0x090c
            int r0 = r10.f27357b
            r0 = r0 & 2
            if (r0 != 0) goto L_0x090c
            r0 = r26
            if (r0 == 0) goto L_0x08a7
            int r1 = r8.readUnsignedShort(r0)
            int r1 = r1 * 3
            int[] r2 = new int[r1]
            int r26 = r0 + 2
            r0 = r26
        L_0x0889:
            if (r1 <= 0) goto L_0x08a5
            int r1 = r1 + -1
            int r3 = r0 + 6
            r2[r1] = r3
            r3 = -1
            int r1 = r1 + r3
            int r5 = r0 + 8
            int r5 = r8.readUnsignedShort(r5)
            r2[r1] = r5
            int r1 = r1 + r3
            int r5 = r8.readUnsignedShort(r0)
            r2[r1] = r5
            int r0 = r0 + 10
            goto L_0x0889
        L_0x08a5:
            r12 = r2
            goto L_0x08a8
        L_0x08a7:
            r12 = 0
        L_0x08a8:
            int r0 = r8.readUnsignedShort(r4)
            int r25 = r4 + 2
            r1 = r25
        L_0x08b0:
            int r15 = r0 + -1
            if (r0 <= 0) goto L_0x090c
            int r0 = r8.readUnsignedShort(r1)
            int r2 = r1 + 2
            int r2 = r8.readUnsignedShort(r2)
            int r3 = r1 + 4
            java.lang.String r3 = r8.readUTF8(r3, r13)
            int r4 = r1 + 6
            java.lang.String r4 = r8.readUTF8(r4, r13)
            int r5 = r1 + 8
            int r5 = r8.readUnsignedShort(r5)
            int r16 = r1 + 10
            if (r12 == 0) goto L_0x08ef
            r1 = r11
        L_0x08d5:
            int r11 = r12.length
            if (r1 >= r11) goto L_0x08ef
            r11 = r12[r1]
            if (r11 != r0) goto L_0x08ec
            int r11 = r1 + 1
            r11 = r12[r11]
            if (r11 != r5) goto L_0x08ec
            int r1 = r1 + 2
            r1 = r12[r1]
            java.lang.String r1 = r8.readUTF8(r1, r13)
            r11 = r1
            goto L_0x08f0
        L_0x08ec:
            int r1 = r1 + 3
            goto L_0x08d5
        L_0x08ef:
            r11 = 0
        L_0x08f0:
            r17 = r7[r0]
            int r0 = r0 + r2
            r18 = r7[r0]
            r0 = r41
            r1 = r3
            r2 = r4
            r3 = r11
            r4 = r17
            r11 = r5
            r5 = r18
            r39 = r6
            r6 = r11
            r0.visitLocalVariable(r1, r2, r3, r4, r5, r6)
            r0 = r15
            r1 = r16
            r6 = r39
            r11 = 0
            goto L_0x08b0
        L_0x090c:
            r39 = r6
            r11 = 65
            r12 = 64
            if (r9 == 0) goto L_0x095e
            int r15 = r9.length
            r7 = 0
        L_0x0916:
            if (r7 >= r15) goto L_0x095e
            r0 = r9[r7]
            int r1 = r8.readByte(r0)
            if (r1 == r12) goto L_0x092a
            if (r1 != r11) goto L_0x0923
            goto L_0x092a
        L_0x0923:
            r33 = r7
            r24 = r23
            r17 = 0
            goto L_0x0957
        L_0x092a:
            int r0 = r8.readTypeAnnotationTarget(r10, r0)
            java.lang.String r6 = r8.readUTF8(r0, r13)
            int r5 = r0 + 2
            int r1 = r10.f27363h
            net.bytebuddy.jar.asm.TypePath r2 = r10.f27364i
            net.bytebuddy.jar.asm.Label[] r3 = r10.f27365j
            net.bytebuddy.jar.asm.Label[] r4 = r10.f27366k
            int[] r0 = r10.f27367l
            r16 = 1
            r17 = r0
            r0 = r41
            r11 = r5
            r5 = r17
            r33 = r7
            r24 = r23
            r17 = 0
            r7 = r16
            net.bytebuddy.jar.asm.AnnotationVisitor r0 = r0.visitLocalVariableAnnotation(r1, r2, r3, r4, r5, r6, r7)
            r1 = 1
            r8.readElementValues(r0, r11, r1, r13)
        L_0x0957:
            int r7 = r33 + 1
            r23 = r24
            r11 = 65
            goto L_0x0916
        L_0x095e:
            r24 = r23
            r17 = 0
            r9 = r39
            if (r9 == 0) goto L_0x09aa
            int r11 = r9.length
            r15 = r17
        L_0x0969:
            if (r15 >= r11) goto L_0x09aa
            r0 = r9[r15]
            int r1 = r8.readByte(r0)
            r7 = 65
            if (r1 == r12) goto L_0x097c
            if (r1 != r7) goto L_0x0978
            goto L_0x097c
        L_0x0978:
            r17 = r7
            r1 = 1
            goto L_0x09a5
        L_0x097c:
            int r0 = r8.readTypeAnnotationTarget(r10, r0)
            java.lang.String r6 = r8.readUTF8(r0, r13)
            int r5 = r0 + 2
            int r1 = r10.f27363h
            net.bytebuddy.jar.asm.TypePath r2 = r10.f27364i
            net.bytebuddy.jar.asm.Label[] r3 = r10.f27365j
            net.bytebuddy.jar.asm.Label[] r4 = r10.f27366k
            int[] r0 = r10.f27367l
            r16 = 0
            r17 = r0
            r0 = r41
            r12 = r5
            r5 = r17
            r17 = r7
            r7 = r16
            net.bytebuddy.jar.asm.AnnotationVisitor r0 = r0.visitLocalVariableAnnotation(r1, r2, r3, r4, r5, r6, r7)
            r1 = 1
            r8.readElementValues(r0, r12, r1, r13)
        L_0x09a5:
            int r15 = r15 + 1
            r12 = 64
            goto L_0x0969
        L_0x09aa:
            r0 = r24
        L_0x09ac:
            if (r0 == 0) goto L_0x09b8
            net.bytebuddy.jar.asm.Attribute r1 = r0.f27348a
            r2 = 0
            r0.f27348a = r2
            r14.visitAttribute(r0)
            r0 = r1
            goto L_0x09ac
        L_0x09b8:
            r0 = r21
            r1 = r28
            r14.visitMaxs(r0, r1)
            return
        L_0x09c0:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.jar.asm.ClassReader.readCode(net.bytebuddy.jar.asm.MethodVisitor, net.bytebuddy.jar.asm.Context, int):void");
    }

    private ConstantDynamic readConstantDynamic(int i11, char[] cArr) {
        ConstantDynamic constantDynamic = this.constantDynamicValues[i11];
        if (constantDynamic != null) {
            return constantDynamic;
        }
        int[] iArr = this.cpInfoOffsets;
        int i12 = iArr[i11];
        int i13 = iArr[readUnsignedShort(i12 + 2)];
        String readUTF8 = readUTF8(i13, cArr);
        String readUTF82 = readUTF8(i13 + 2, cArr);
        int i14 = this.bootstrapMethodOffsets[readUnsignedShort(i12)];
        Handle handle = (Handle) readConst(readUnsignedShort(i14), cArr);
        int readUnsignedShort = readUnsignedShort(i14 + 2);
        Object[] objArr = new Object[readUnsignedShort];
        int i15 = i14 + 4;
        for (int i16 = 0; i16 < readUnsignedShort; i16++) {
            objArr[i16] = readConst(readUnsignedShort(i15), cArr);
            i15 += 2;
        }
        ConstantDynamic[] constantDynamicArr = this.constantDynamicValues;
        ConstantDynamic constantDynamic2 = new ConstantDynamic(readUTF8, readUTF82, handle, objArr);
        constantDynamicArr[i11] = constantDynamic2;
        return constantDynamic2;
    }

    private int readElementValue(AnnotationVisitor annotationVisitor, int i11, String str, char[] cArr) {
        Boolean bool;
        boolean z11;
        int i12 = 0;
        if (annotationVisitor == null) {
            byte b11 = this.f27351a[i11] & 255;
            if (b11 == 64) {
                return readElementValues((AnnotationVisitor) null, i11 + 3, true, cArr);
            }
            if (b11 == 91) {
                return readElementValues((AnnotationVisitor) null, i11 + 1, false, cArr);
            }
            if (b11 != 101) {
                return i11 + 3;
            }
            return i11 + 5;
        }
        int i13 = i11 + 1;
        byte b12 = this.f27351a[i11] & 255;
        if (b12 == 64) {
            return readElementValues(annotationVisitor.visitAnnotation(str, readUTF8(i13, cArr)), i13 + 2, true, cArr);
        }
        if (b12 != 70) {
            if (b12 == 83) {
                annotationVisitor.visit(str, Short.valueOf((short) readInt(this.cpInfoOffsets[readUnsignedShort(i13)])));
            } else if (b12 == 99) {
                annotationVisitor.visit(str, Type.getType(readUTF8(i13, cArr)));
            } else if (b12 == 101) {
                annotationVisitor.visitEnum(str, readUTF8(i13, cArr), readUTF8(i13 + 2, cArr));
                return i13 + 4;
            } else if (b12 == 115) {
                annotationVisitor.visit(str, readUTF8(i13, cArr));
            } else if (!(b12 == 73 || b12 == 74)) {
                if (b12 == 90) {
                    if (readInt(this.cpInfoOffsets[readUnsignedShort(i13)]) == 0) {
                        bool = Boolean.FALSE;
                    } else {
                        bool = Boolean.TRUE;
                    }
                    annotationVisitor.visit(str, bool);
                } else if (b12 != 91) {
                    switch (b12) {
                        case 66:
                            annotationVisitor.visit(str, Byte.valueOf((byte) readInt(this.cpInfoOffsets[readUnsignedShort(i13)])));
                            break;
                        case 67:
                            annotationVisitor.visit(str, Character.valueOf((char) readInt(this.cpInfoOffsets[readUnsignedShort(i13)])));
                            break;
                        case 68:
                            break;
                        default:
                            throw new IllegalArgumentException();
                    }
                } else {
                    int readUnsignedShort = readUnsignedShort(i13);
                    int i14 = i13 + 2;
                    if (readUnsignedShort == 0) {
                        return readElementValues(annotationVisitor.visitArray(str), i14 - 2, false, cArr);
                    }
                    byte b13 = this.f27351a[i14] & 255;
                    if (b13 == 70) {
                        float[] fArr = new float[readUnsignedShort];
                        while (i12 < readUnsignedShort) {
                            fArr[i12] = Float.intBitsToFloat(readInt(this.cpInfoOffsets[readUnsignedShort(i14 + 1)]));
                            i14 += 3;
                            i12++;
                        }
                        annotationVisitor.visit(str, fArr);
                        return i14;
                    } else if (b13 == 83) {
                        short[] sArr = new short[readUnsignedShort];
                        while (i12 < readUnsignedShort) {
                            sArr[i12] = (short) readInt(this.cpInfoOffsets[readUnsignedShort(i14 + 1)]);
                            i14 += 3;
                            i12++;
                        }
                        annotationVisitor.visit(str, sArr);
                        return i14;
                    } else if (b13 == 90) {
                        boolean[] zArr = new boolean[readUnsignedShort];
                        for (int i15 = 0; i15 < readUnsignedShort; i15++) {
                            if (readInt(this.cpInfoOffsets[readUnsignedShort(i14 + 1)]) != 0) {
                                z11 = true;
                            } else {
                                z11 = false;
                            }
                            zArr[i15] = z11;
                            i14 += 3;
                        }
                        annotationVisitor.visit(str, zArr);
                        return i14;
                    } else if (b13 == 73) {
                        int[] iArr = new int[readUnsignedShort];
                        while (i12 < readUnsignedShort) {
                            iArr[i12] = readInt(this.cpInfoOffsets[readUnsignedShort(i14 + 1)]);
                            i14 += 3;
                            i12++;
                        }
                        annotationVisitor.visit(str, iArr);
                        return i14;
                    } else if (b13 != 74) {
                        switch (b13) {
                            case 66:
                                byte[] bArr = new byte[readUnsignedShort];
                                while (i12 < readUnsignedShort) {
                                    bArr[i12] = (byte) readInt(this.cpInfoOffsets[readUnsignedShort(i14 + 1)]);
                                    i14 += 3;
                                    i12++;
                                }
                                annotationVisitor.visit(str, bArr);
                                return i14;
                            case 67:
                                char[] cArr2 = new char[readUnsignedShort];
                                while (i12 < readUnsignedShort) {
                                    cArr2[i12] = (char) readInt(this.cpInfoOffsets[readUnsignedShort(i14 + 1)]);
                                    i14 += 3;
                                    i12++;
                                }
                                annotationVisitor.visit(str, cArr2);
                                return i14;
                            case 68:
                                double[] dArr = new double[readUnsignedShort];
                                while (i12 < readUnsignedShort) {
                                    dArr[i12] = Double.longBitsToDouble(readLong(this.cpInfoOffsets[readUnsignedShort(i14 + 1)]));
                                    i14 += 3;
                                    i12++;
                                }
                                annotationVisitor.visit(str, dArr);
                                return i14;
                            default:
                                return readElementValues(annotationVisitor.visitArray(str), i14 - 2, false, cArr);
                        }
                    } else {
                        long[] jArr = new long[readUnsignedShort];
                        while (i12 < readUnsignedShort) {
                            jArr[i12] = readLong(this.cpInfoOffsets[readUnsignedShort(i14 + 1)]);
                            i14 += 3;
                            i12++;
                        }
                        annotationVisitor.visit(str, jArr);
                        return i14;
                    }
                }
            }
            return i13 + 2;
        }
        annotationVisitor.visit(str, readConst(readUnsignedShort(i13), cArr));
        return i13 + 2;
    }

    private int readElementValues(AnnotationVisitor annotationVisitor, int i11, boolean z11, char[] cArr) {
        int readUnsignedShort = readUnsignedShort(i11);
        int i12 = i11 + 2;
        if (!z11) {
            while (true) {
                int i13 = readUnsignedShort - 1;
                if (readUnsignedShort <= 0) {
                    break;
                }
                i12 = readElementValue(annotationVisitor, i12, (String) null, cArr);
                readUnsignedShort = i13;
            }
        } else {
            while (true) {
                int i14 = readUnsignedShort - 1;
                if (readUnsignedShort <= 0) {
                    break;
                }
                i12 = readElementValue(annotationVisitor, i12 + 2, readUTF8(i12, cArr), cArr);
                readUnsignedShort = i14;
            }
        }
        if (annotationVisitor != null) {
            annotationVisitor.visitEnd();
        }
        return i12;
    }

    private int readField(ClassVisitor classVisitor, Context context, int i11) {
        int i12;
        int i13;
        Context context2 = context;
        int i14 = i11;
        char[] cArr = context2.f27358c;
        int readUnsignedShort = readUnsignedShort(i14);
        String readUTF8 = readUTF8(i14 + 2, cArr);
        String readUTF82 = readUTF8(i14 + 4, cArr);
        int i15 = i14 + 6;
        int readUnsignedShort2 = readUnsignedShort(i15);
        int i16 = i15 + 2;
        int i17 = readUnsignedShort;
        int i18 = 0;
        int i19 = 0;
        int i21 = 0;
        int i22 = 0;
        Attribute attribute = null;
        String str = null;
        Object obj = null;
        while (true) {
            int i23 = readUnsignedShort2 - 1;
            if (readUnsignedShort2 <= 0) {
                break;
            }
            String readUTF83 = readUTF8(i16, cArr);
            int readInt = readInt(i16 + 2);
            int i24 = i16 + 6;
            if (AttributeLayout.ATTRIBUTE_CONSTANT_VALUE.equals(readUTF83)) {
                int readUnsignedShort3 = readUnsignedShort(i24);
                if (readUnsignedShort3 == 0) {
                    obj = null;
                } else {
                    obj = readConst(readUnsignedShort3, cArr);
                }
            } else if (AttributeLayout.ATTRIBUTE_SIGNATURE.equals(readUTF83)) {
                str = readUTF8(i24, cArr);
            } else {
                if (AttributeLayout.ATTRIBUTE_DEPRECATED.equals(readUTF83)) {
                    i13 = 131072 | i17;
                } else if ("Synthetic".equals(readUTF83)) {
                    i13 = i17 | 4096;
                } else {
                    if (AttributeLayout.ATTRIBUTE_RUNTIME_VISIBLE_ANNOTATIONS.equals(readUTF83)) {
                        i22 = i24;
                        i12 = i22;
                    } else if ("RuntimeVisibleTypeAnnotations".equals(readUTF83)) {
                        i19 = i24;
                        i12 = i19;
                    } else if (AttributeLayout.ATTRIBUTE_RUNTIME_INVISIBLE_ANNOTATIONS.equals(readUTF83)) {
                        i21 = i24;
                        i12 = i21;
                    } else if ("RuntimeInvisibleTypeAnnotations".equals(readUTF83)) {
                        i18 = i24;
                        i12 = i18;
                    } else {
                        i12 = i24;
                        Attribute attribute2 = attribute;
                        attribute = readAttribute(context2.f27356a, readUTF83, i12, readInt, cArr, -1, (Label[]) null);
                        attribute.f27348a = attribute2;
                        i21 = i21;
                        i22 = i22;
                        i18 = i18;
                        i19 = i19;
                    }
                    i16 = i12 + readInt;
                    context2 = context;
                    readUnsignedShort2 = i23;
                }
                i17 = i13;
            }
            i12 = i24;
            i16 = i12 + readInt;
            context2 = context;
            readUnsignedShort2 = i23;
        }
        Attribute attribute3 = attribute;
        int i25 = i18;
        int i26 = i19;
        int i27 = i21;
        int i28 = i22;
        FieldVisitor visitField = classVisitor.visitField(i17, readUTF8, readUTF82, str, obj);
        if (visitField == null) {
            return i16;
        }
        if (i28 != 0) {
            int readUnsignedShort4 = readUnsignedShort(i28);
            int i29 = i28 + 2;
            while (true) {
                int i31 = readUnsignedShort4 - 1;
                if (readUnsignedShort4 <= 0) {
                    break;
                }
                i29 = readElementValues(visitField.visitAnnotation(readUTF8(i29, cArr), true), i29 + 2, true, cArr);
                readUnsignedShort4 = i31;
            }
        }
        if (i27 != 0) {
            int i32 = i27;
            int readUnsignedShort5 = readUnsignedShort(i32);
            int i33 = i32 + 2;
            while (true) {
                int i34 = readUnsignedShort5 - 1;
                if (readUnsignedShort5 <= 0) {
                    break;
                }
                i33 = readElementValues(visitField.visitAnnotation(readUTF8(i33, cArr), false), i33 + 2, true, cArr);
                readUnsignedShort5 = i34;
            }
        }
        int i35 = i26;
        if (i35 != 0) {
            int readUnsignedShort6 = readUnsignedShort(i35);
            int i36 = i35 + 2;
            while (true) {
                int i37 = readUnsignedShort6 - 1;
                if (readUnsignedShort6 <= 0) {
                    break;
                }
                Context context3 = context;
                int readTypeAnnotationTarget = readTypeAnnotationTarget(context3, i36);
                i36 = readElementValues(visitField.visitTypeAnnotation(context3.f27363h, context3.f27364i, readUTF8(readTypeAnnotationTarget, cArr), true), readTypeAnnotationTarget + 2, true, cArr);
                readUnsignedShort6 = i37;
            }
        }
        Context context4 = context;
        int i38 = i25;
        if (i38 != 0) {
            int readUnsignedShort7 = readUnsignedShort(i38);
            int i39 = i38 + 2;
            while (true) {
                int i41 = readUnsignedShort7 - 1;
                if (readUnsignedShort7 <= 0) {
                    break;
                }
                int readTypeAnnotationTarget2 = readTypeAnnotationTarget(context4, i39);
                i39 = readElementValues(visitField.visitTypeAnnotation(context4.f27363h, context4.f27364i, readUTF8(readTypeAnnotationTarget2, cArr), false), readTypeAnnotationTarget2 + 2, true, cArr);
                readUnsignedShort7 = i41;
            }
        }
        while (true) {
            Attribute attribute4 = attribute3;
            if (attribute4 != null) {
                attribute3 = attribute4.f27348a;
                attribute4.f27348a = null;
                visitField.visitAttribute(attribute4);
            } else {
                visitField.visitEnd();
                return i16;
            }
        }
    }

    private int readMethod(ClassVisitor classVisitor, Context context, int i11) {
        String str;
        boolean z11;
        int i12;
        int i13;
        int i14;
        Context context2 = context;
        int i15 = i11;
        char[] cArr = context2.f27358c;
        context2.f27359d = readUnsignedShort(i15);
        context2.f27360e = readUTF8(i15 + 2, cArr);
        int i16 = i15 + 4;
        context2.f27361f = readUTF8(i16, cArr);
        int i17 = i15 + 6;
        int readUnsignedShort = readUnsignedShort(i17);
        int i18 = i17 + 2;
        int i19 = 0;
        int i21 = 0;
        int i22 = 0;
        int i23 = 0;
        int i24 = 0;
        int i25 = 0;
        Attribute attribute = null;
        boolean z12 = false;
        int i26 = 0;
        String[] strArr = null;
        int i27 = 0;
        int i28 = 0;
        int i29 = 0;
        int i31 = 0;
        while (true) {
            int i32 = readUnsignedShort - 1;
            if (readUnsignedShort <= 0) {
                break;
            }
            String readUTF8 = readUTF8(i18, cArr);
            int readInt = readInt(i18 + 2);
            int i33 = i18 + 6;
            int i34 = i19;
            if (!AttributeLayout.ATTRIBUTE_CODE.equals(readUTF8)) {
                if (AttributeLayout.ATTRIBUTE_EXCEPTIONS.equals(readUTF8)) {
                    int readUnsignedShort2 = readUnsignedShort(i33);
                    String[] strArr2 = new String[readUnsignedShort2];
                    int i35 = i21;
                    int i36 = i22;
                    int i37 = i33 + 2;
                    for (int i38 = 0; i38 < readUnsignedShort2; i38++) {
                        strArr2[i38] = readClass(i37, cArr);
                        i37 += 2;
                    }
                    strArr = strArr2;
                    i26 = i33;
                    i19 = i34;
                    i21 = i35;
                    i22 = i36;
                    i12 = i26;
                } else {
                    i14 = i21;
                    i13 = i22;
                    if (AttributeLayout.ATTRIBUTE_SIGNATURE.equals(readUTF8)) {
                        i25 = readUnsignedShort(i33);
                    } else if (AttributeLayout.ATTRIBUTE_DEPRECATED.equals(readUTF8)) {
                        context2.f27359d |= 131072;
                    } else if (AttributeLayout.ATTRIBUTE_RUNTIME_VISIBLE_ANNOTATIONS.equals(readUTF8)) {
                        i22 = i33;
                        i19 = i34;
                        i21 = i14;
                        i12 = i22;
                    } else if ("RuntimeVisibleTypeAnnotations".equals(readUTF8)) {
                        i19 = i33;
                        i12 = i19;
                        i21 = i14;
                        i22 = i13;
                    } else if (AttributeLayout.ATTRIBUTE_ANNOTATION_DEFAULT.equals(readUTF8)) {
                        i23 = i33;
                        i19 = i34;
                        i21 = i14;
                        i22 = i13;
                        i12 = i23;
                    } else if ("Synthetic".equals(readUTF8)) {
                        context2.f27359d |= 4096;
                        i19 = i34;
                        i21 = i14;
                        i22 = i13;
                        z12 = true;
                        i12 = i33;
                    } else if (AttributeLayout.ATTRIBUTE_RUNTIME_INVISIBLE_ANNOTATIONS.equals(readUTF8)) {
                        i21 = i33;
                        i19 = i34;
                        i22 = i13;
                        i12 = i21;
                    } else if ("RuntimeInvisibleTypeAnnotations".equals(readUTF8)) {
                        i27 = i33;
                        i19 = i34;
                        i21 = i14;
                        i22 = i13;
                        i12 = i27;
                    } else if (AttributeLayout.ATTRIBUTE_RUNTIME_VISIBLE_PARAMETER_ANNOTATIONS.equals(readUTF8)) {
                        i28 = i33;
                        i19 = i34;
                        i21 = i14;
                        i22 = i13;
                        i12 = i28;
                    } else if (AttributeLayout.ATTRIBUTE_RUNTIME_INVISIBLE_PARAMETER_ANNOTATIONS.equals(readUTF8)) {
                        i29 = i33;
                        i19 = i34;
                        i21 = i14;
                        i22 = i13;
                        i12 = i29;
                    } else if ("MethodParameters".equals(readUTF8)) {
                        i24 = i33;
                        i19 = i34;
                        i21 = i14;
                        i22 = i13;
                        i12 = i24;
                    } else {
                        int i39 = i34;
                        i12 = i33;
                        Attribute readAttribute = readAttribute(context2.f27356a, readUTF8, i33, readInt, cArr, -1, (Label[]) null);
                        readAttribute.f27348a = attribute;
                        attribute = readAttribute;
                        i25 = i25;
                        i21 = i14;
                        i22 = i13;
                        i19 = i39;
                        i23 = i23;
                        i24 = i24;
                    }
                }
                i18 = i12 + readInt;
                int i41 = i11;
                readUnsignedShort = i32;
            } else if ((context2.f27357b & 1) == 0) {
                i31 = i33;
                i19 = i34;
                i12 = i31;
                i18 = i12 + readInt;
                int i412 = i11;
                readUnsignedShort = i32;
            } else {
                i14 = i21;
                i13 = i22;
            }
            i19 = i34;
            i21 = i14;
            i22 = i13;
            i12 = i33;
            i18 = i12 + readInt;
            int i4122 = i11;
            readUnsignedShort = i32;
        }
        int i42 = i19;
        int i43 = i21;
        int i44 = i22;
        int i45 = i23;
        int i46 = i24;
        int i47 = i25;
        int i48 = context2.f27359d;
        String str2 = context2.f27360e;
        String str3 = context2.f27361f;
        if (i47 == 0) {
            str = null;
        } else {
            str = c(i47, cArr);
        }
        MethodVisitor visitMethod = classVisitor.visitMethod(i48, str2, str3, str, strArr);
        if (visitMethod == null) {
            return i18;
        }
        if (visitMethod instanceof MethodWriter) {
            MethodWriter methodWriter = (MethodWriter) visitMethod;
            if ((context2.f27359d & 131072) != 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            int i49 = i47;
            MethodWriter methodWriter2 = methodWriter;
            if (methodWriter.a(this, z12, z11, readUnsignedShort(i16), i49, i26)) {
                int i50 = i11;
                methodWriter2.g(i50, i18 - i50);
                return i18;
            }
        }
        int i51 = i46;
        if (i51 != 0 && (context2.f27357b & 2) == 0) {
            int readByte = readByte(i51);
            int i52 = i51 + 1;
            while (true) {
                int i53 = readByte - 1;
                if (readByte <= 0) {
                    break;
                }
                visitMethod.visitParameter(readUTF8(i52, cArr), readUnsignedShort(i52 + 2));
                i52 += 4;
                readByte = i53;
            }
        }
        int i54 = i45;
        if (i54 != 0) {
            AnnotationVisitor visitAnnotationDefault = visitMethod.visitAnnotationDefault();
            readElementValue(visitAnnotationDefault, i54, (String) null, cArr);
            if (visitAnnotationDefault != null) {
                visitAnnotationDefault.visitEnd();
            }
        }
        int i55 = i44;
        if (i55 != 0) {
            int readUnsignedShort3 = readUnsignedShort(i55);
            int i56 = i55 + 2;
            while (true) {
                int i57 = readUnsignedShort3 - 1;
                if (readUnsignedShort3 <= 0) {
                    break;
                }
                i56 = readElementValues(visitMethod.visitAnnotation(readUTF8(i56, cArr), true), i56 + 2, true, cArr);
                readUnsignedShort3 = i57;
            }
        }
        int i58 = i43;
        if (i58 != 0) {
            int readUnsignedShort4 = readUnsignedShort(i58);
            int i59 = i58 + 2;
            while (true) {
                int i60 = readUnsignedShort4 - 1;
                if (readUnsignedShort4 <= 0) {
                    break;
                }
                i59 = readElementValues(visitMethod.visitAnnotation(readUTF8(i59, cArr), false), i59 + 2, true, cArr);
                readUnsignedShort4 = i60;
            }
        }
        int i61 = i42;
        if (i61 != 0) {
            int readUnsignedShort5 = readUnsignedShort(i61);
            int i62 = i61 + 2;
            while (true) {
                int i63 = readUnsignedShort5 - 1;
                if (readUnsignedShort5 <= 0) {
                    break;
                }
                int readTypeAnnotationTarget = readTypeAnnotationTarget(context2, i62);
                i62 = readElementValues(visitMethod.visitTypeAnnotation(context2.f27363h, context2.f27364i, readUTF8(readTypeAnnotationTarget, cArr), true), readTypeAnnotationTarget + 2, true, cArr);
                readUnsignedShort5 = i63;
            }
        }
        int i64 = i27;
        if (i64 != 0) {
            int readUnsignedShort6 = readUnsignedShort(i64);
            int i65 = i64 + 2;
            while (true) {
                int i66 = readUnsignedShort6 - 1;
                if (readUnsignedShort6 <= 0) {
                    break;
                }
                int readTypeAnnotationTarget2 = readTypeAnnotationTarget(context2, i65);
                i65 = readElementValues(visitMethod.visitTypeAnnotation(context2.f27363h, context2.f27364i, readUTF8(readTypeAnnotationTarget2, cArr), false), readTypeAnnotationTarget2 + 2, true, cArr);
                readUnsignedShort6 = i66;
            }
        }
        int i67 = i28;
        if (i67 != 0) {
            readParameterAnnotations(visitMethod, context2, i67, true);
        }
        int i68 = i29;
        if (i68 != 0) {
            readParameterAnnotations(visitMethod, context2, i68, false);
        }
        while (attribute != null) {
            Attribute attribute2 = attribute.f27348a;
            attribute.f27348a = null;
            visitMethod.visitAttribute(attribute);
            attribute = attribute2;
        }
        int i69 = i31;
        if (i69 != 0) {
            visitMethod.visitCode();
            readCode(visitMethod, context2, i69);
        }
        visitMethod.visitEnd();
        return i18;
    }

    private void readModuleAttributes(ClassVisitor classVisitor, Context context, int i11, int i12, String str) {
        String[] strArr;
        char[] cArr = context.f27358c;
        int i13 = i11 + 6;
        ModuleVisitor visitModule = classVisitor.visitModule(readModule(i11, cArr), readUnsignedShort(i11 + 2), readUTF8(i11 + 4, cArr));
        if (visitModule != null) {
            if (str != null) {
                visitModule.visitMainClass(str);
            }
            if (i12 != 0) {
                int readUnsignedShort = readUnsignedShort(i12);
                int i14 = i12 + 2;
                while (true) {
                    int i15 = readUnsignedShort - 1;
                    if (readUnsignedShort <= 0) {
                        break;
                    }
                    visitModule.visitPackage(readPackage(i14, cArr));
                    i14 += 2;
                    readUnsignedShort = i15;
                }
            }
            int readUnsignedShort2 = readUnsignedShort(i13);
            int i16 = i13 + 2;
            while (true) {
                int i17 = readUnsignedShort2 - 1;
                if (readUnsignedShort2 <= 0) {
                    break;
                }
                i16 += 6;
                visitModule.visitRequire(readModule(i16, cArr), readUnsignedShort(i16 + 2), readUTF8(i16 + 4, cArr));
                readUnsignedShort2 = i17;
            }
            int readUnsignedShort3 = readUnsignedShort(i16);
            int i18 = i16 + 2;
            while (true) {
                int i19 = readUnsignedShort3 - 1;
                String[] strArr2 = null;
                if (readUnsignedShort3 <= 0) {
                    break;
                }
                String readPackage = readPackage(i18, cArr);
                int readUnsignedShort4 = readUnsignedShort(i18 + 2);
                int readUnsignedShort5 = readUnsignedShort(i18 + 4);
                i18 += 6;
                if (readUnsignedShort5 != 0) {
                    strArr2 = new String[readUnsignedShort5];
                    for (int i21 = 0; i21 < readUnsignedShort5; i21++) {
                        strArr2[i21] = readModule(i18, cArr);
                        i18 += 2;
                    }
                }
                visitModule.visitExport(readPackage, readUnsignedShort4, strArr2);
                readUnsignedShort3 = i19;
            }
            int readUnsignedShort6 = readUnsignedShort(i18);
            int i22 = i18 + 2;
            while (true) {
                int i23 = readUnsignedShort6 - 1;
                if (readUnsignedShort6 <= 0) {
                    break;
                }
                String readPackage2 = readPackage(i22, cArr);
                int readUnsignedShort7 = readUnsignedShort(i22 + 2);
                int readUnsignedShort8 = readUnsignedShort(i22 + 4);
                i22 += 6;
                if (readUnsignedShort8 != 0) {
                    strArr = new String[readUnsignedShort8];
                    for (int i24 = 0; i24 < readUnsignedShort8; i24++) {
                        strArr[i24] = readModule(i22, cArr);
                        i22 += 2;
                    }
                } else {
                    strArr = null;
                }
                visitModule.visitOpen(readPackage2, readUnsignedShort7, strArr);
                readUnsignedShort6 = i23;
            }
            int readUnsignedShort9 = readUnsignedShort(i22);
            int i25 = i22 + 2;
            while (true) {
                int i26 = readUnsignedShort9 - 1;
                if (readUnsignedShort9 <= 0) {
                    break;
                }
                visitModule.visitUse(readClass(i25, cArr));
                i25 += 2;
                readUnsignedShort9 = i26;
            }
            int readUnsignedShort10 = readUnsignedShort(i25);
            int i27 = i25 + 2;
            while (true) {
                int i28 = readUnsignedShort10 - 1;
                if (readUnsignedShort10 > 0) {
                    String readClass = readClass(i27, cArr);
                    int readUnsignedShort11 = readUnsignedShort(i27 + 2);
                    i27 += 4;
                    String[] strArr3 = new String[readUnsignedShort11];
                    for (int i29 = 0; i29 < readUnsignedShort11; i29++) {
                        strArr3[i29] = readClass(i27, cArr);
                        i27 += 2;
                    }
                    visitModule.visitProvide(readClass, strArr3);
                    readUnsignedShort10 = i28;
                } else {
                    visitModule.visitEnd();
                    return;
                }
            }
        }
    }

    private void readParameterAnnotations(MethodVisitor methodVisitor, Context context, int i11, boolean z11) {
        int i12 = i11 + 1;
        byte b11 = this.f27351a[i11] & 255;
        methodVisitor.visitAnnotableParameterCount(b11, z11);
        char[] cArr = context.f27358c;
        for (int i13 = 0; i13 < b11; i13++) {
            int readUnsignedShort = readUnsignedShort(i12);
            i12 += 2;
            while (true) {
                int i14 = readUnsignedShort - 1;
                if (readUnsignedShort <= 0) {
                    break;
                }
                i12 = readElementValues(methodVisitor.visitParameterAnnotation(i13, readUTF8(i12, cArr), z11), i12 + 2, true, cArr);
                readUnsignedShort = i14;
            }
        }
    }

    private int readRecordComponent(ClassVisitor classVisitor, Context context, int i11) {
        int i12;
        Context context2 = context;
        int i13 = i11;
        char[] cArr = context2.f27358c;
        String readUTF8 = readUTF8(i13, cArr);
        String readUTF82 = readUTF8(i13 + 2, cArr);
        int i14 = i13 + 4;
        int readUnsignedShort = readUnsignedShort(i14);
        int i15 = i14 + 2;
        int i16 = 0;
        Attribute attribute = null;
        int i17 = 0;
        int i18 = 0;
        int i19 = 0;
        String str = null;
        while (true) {
            int i21 = readUnsignedShort - 1;
            if (readUnsignedShort <= 0) {
                break;
            }
            String readUTF83 = readUTF8(i15, cArr);
            int readInt = readInt(i15 + 2);
            int i22 = i15 + 6;
            if (AttributeLayout.ATTRIBUTE_SIGNATURE.equals(readUTF83)) {
                str = readUTF8(i22, cArr);
                i12 = i22;
            } else if (AttributeLayout.ATTRIBUTE_RUNTIME_VISIBLE_ANNOTATIONS.equals(readUTF83)) {
                i19 = i22;
                i12 = i19;
            } else if ("RuntimeVisibleTypeAnnotations".equals(readUTF83)) {
                i17 = i22;
                i12 = i17;
            } else if (AttributeLayout.ATTRIBUTE_RUNTIME_INVISIBLE_ANNOTATIONS.equals(readUTF83)) {
                i18 = i22;
                i12 = i18;
            } else if ("RuntimeInvisibleTypeAnnotations".equals(readUTF83)) {
                i16 = i22;
                i12 = i16;
            } else {
                i12 = i22;
                Attribute attribute2 = attribute;
                attribute = readAttribute(context2.f27356a, readUTF83, i12, readInt, cArr, -1, (Label[]) null);
                attribute.f27348a = attribute2;
                i19 = i19;
                i18 = i18;
                i17 = i17;
                i16 = i16;
            }
            i15 = i12 + readInt;
            context2 = context;
            readUnsignedShort = i21;
        }
        int i23 = i16;
        Attribute attribute3 = attribute;
        int i24 = i17;
        int i25 = i18;
        int i26 = i19;
        RecordComponentVisitor visitRecordComponent = classVisitor.visitRecordComponent(readUTF8, readUTF82, str);
        if (visitRecordComponent == null) {
            return i15;
        }
        if (i26 != 0) {
            int readUnsignedShort2 = readUnsignedShort(i26);
            int i27 = i26 + 2;
            while (true) {
                int i28 = readUnsignedShort2 - 1;
                if (readUnsignedShort2 <= 0) {
                    break;
                }
                i27 = readElementValues(visitRecordComponent.visitAnnotation(readUTF8(i27, cArr), true), i27 + 2, true, cArr);
                readUnsignedShort2 = i28;
            }
        }
        if (i25 != 0) {
            int readUnsignedShort3 = readUnsignedShort(i25);
            int i29 = i25 + 2;
            while (true) {
                int i31 = readUnsignedShort3 - 1;
                if (readUnsignedShort3 <= 0) {
                    break;
                }
                i29 = readElementValues(visitRecordComponent.visitAnnotation(readUTF8(i29, cArr), false), i29 + 2, true, cArr);
                readUnsignedShort3 = i31;
            }
        }
        int i32 = i24;
        if (i32 != 0) {
            int readUnsignedShort4 = readUnsignedShort(i32);
            int i33 = i32 + 2;
            while (true) {
                int i34 = readUnsignedShort4 - 1;
                if (readUnsignedShort4 <= 0) {
                    break;
                }
                Context context3 = context;
                int readTypeAnnotationTarget = readTypeAnnotationTarget(context3, i33);
                i33 = readElementValues(visitRecordComponent.visitTypeAnnotation(context3.f27363h, context3.f27364i, readUTF8(readTypeAnnotationTarget, cArr), true), readTypeAnnotationTarget + 2, true, cArr);
                readUnsignedShort4 = i34;
            }
        }
        Context context4 = context;
        if (i23 != 0) {
            int i35 = i23;
            int readUnsignedShort5 = readUnsignedShort(i35);
            int i36 = i35 + 2;
            while (true) {
                int i37 = readUnsignedShort5 - 1;
                if (readUnsignedShort5 <= 0) {
                    break;
                }
                int readTypeAnnotationTarget2 = readTypeAnnotationTarget(context4, i36);
                i36 = readElementValues(visitRecordComponent.visitTypeAnnotation(context4.f27363h, context4.f27364i, readUTF8(readTypeAnnotationTarget2, cArr), false), readTypeAnnotationTarget2 + 2, true, cArr);
                readUnsignedShort5 = i37;
            }
        }
        Attribute attribute4 = attribute3;
        while (attribute4 != null) {
            Attribute attribute5 = attribute4.f27348a;
            attribute4.f27348a = null;
            visitRecordComponent.visitAttribute(attribute4);
            attribute4 = attribute5;
        }
        visitRecordComponent.visitEnd();
        return i15;
    }

    private int readStackMapFrame(int i11, boolean z11, boolean z12, Context context) {
        int i12;
        int i13;
        int i14;
        char[] cArr = context.f27358c;
        Label[] labelArr = context.f27362g;
        if (z11) {
            i13 = i11 + 1;
            i12 = this.f27351a[i11] & 255;
        } else {
            context.f27368m = -1;
            i13 = i11;
            i12 = 255;
        }
        context.f27371p = 0;
        if (i12 < 64) {
            context.f27369n = 3;
            context.f27373r = 0;
        } else if (i12 < 128) {
            i12 -= 64;
            i13 = readVerificationTypeInfo(i13, context.f27374s, 0, cArr, labelArr);
            context.f27369n = 4;
            context.f27373r = 1;
        } else if (i12 >= 247) {
            int readUnsignedShort = readUnsignedShort(i13);
            int i15 = i13 + 2;
            if (i12 == 247) {
                i15 = readVerificationTypeInfo(i15, context.f27374s, 0, cArr, labelArr);
                context.f27369n = 4;
                context.f27373r = 1;
            } else if (i12 >= 248 && i12 < 251) {
                context.f27369n = 2;
                int i16 = 251 - i12;
                context.f27371p = i16;
                context.f27370o -= i16;
                context.f27373r = 0;
            } else if (i12 == 251) {
                context.f27369n = 3;
                context.f27373r = 0;
            } else if (i12 < 255) {
                if (z12) {
                    i14 = context.f27370o;
                } else {
                    i14 = 0;
                }
                int i17 = i12 - 251;
                int i18 = i14;
                int i19 = i17;
                while (i19 > 0) {
                    i15 = readVerificationTypeInfo(i15, context.f27372q, i18, cArr, labelArr);
                    i19--;
                    i18++;
                }
                context.f27369n = 1;
                context.f27371p = i17;
                context.f27370o += i17;
                context.f27373r = 0;
            } else {
                int readUnsignedShort2 = readUnsignedShort(i15);
                int i21 = i15 + 2;
                context.f27369n = 0;
                context.f27371p = readUnsignedShort2;
                context.f27370o = readUnsignedShort2;
                for (int i22 = 0; i22 < readUnsignedShort2; i22++) {
                    i21 = readVerificationTypeInfo(i21, context.f27372q, i22, cArr, labelArr);
                }
                int readUnsignedShort3 = readUnsignedShort(i21);
                i15 = i21 + 2;
                context.f27373r = readUnsignedShort3;
                for (int i23 = 0; i23 < readUnsignedShort3; i23++) {
                    i15 = readVerificationTypeInfo(i15, context.f27374s, i23, cArr, labelArr);
                }
            }
            i12 = readUnsignedShort;
        } else {
            throw new IllegalArgumentException();
        }
        int i24 = context.f27368m + i12 + 1;
        context.f27368m = i24;
        createLabel(i24, labelArr);
        return i13;
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x003c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static byte[] readStream(java.io.InputStream r7, boolean r8) throws java.io.IOException {
        /*
            if (r7 == 0) goto L_0x0044
            int r0 = calculateBufferSize(r7)
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream     // Catch:{ all -> 0x003d }
            r1.<init>()     // Catch:{ all -> 0x003d }
            byte[] r2 = new byte[r0]     // Catch:{ all -> 0x0038 }
            r3 = 0
            r4 = r3
        L_0x000f:
            int r5 = r7.read(r2, r3, r0)     // Catch:{ all -> 0x0038 }
            r6 = -1
            if (r5 == r6) goto L_0x001c
            r1.write(r2, r3, r5)     // Catch:{ all -> 0x0038 }
            int r4 = r4 + 1
            goto L_0x000f
        L_0x001c:
            r1.flush()     // Catch:{ all -> 0x0038 }
            r0 = 1
            if (r4 != r0) goto L_0x002b
            r1.close()     // Catch:{ all -> 0x003d }
            if (r8 == 0) goto L_0x002a
            r7.close()
        L_0x002a:
            return r2
        L_0x002b:
            byte[] r0 = r1.toByteArray()     // Catch:{ all -> 0x0038 }
            r1.close()     // Catch:{ all -> 0x003d }
            if (r8 == 0) goto L_0x0037
            r7.close()
        L_0x0037:
            return r0
        L_0x0038:
            r0 = move-exception
            r1.close()     // Catch:{ all -> 0x003c }
        L_0x003c:
            throw r0     // Catch:{ all -> 0x003d }
        L_0x003d:
            r0 = move-exception
            if (r8 == 0) goto L_0x0043
            r7.close()
        L_0x0043:
            throw r0
        L_0x0044:
            java.io.IOException r7 = new java.io.IOException
            java.lang.String r8 = "Class not found"
            r7.<init>(r8)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.jar.asm.ClassReader.readStream(java.io.InputStream, boolean):byte[]");
    }

    private String readStringish(int i11, char[] cArr) {
        return readUTF8(this.cpInfoOffsets[readUnsignedShort(i11)], cArr);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x006b, code lost:
        r0 = r0 & androidx.core.view.InputDeviceCompat.SOURCE_ANY;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x006d, code lost:
        r11 = r11 + 3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int readTypeAnnotationTarget(net.bytebuddy.jar.asm.Context r10, int r11) {
        /*
            r9 = this;
            int r0 = r9.readInt(r11)
            int r1 = r0 >>> 24
            r2 = 1
            if (r1 == 0) goto L_0x0070
            if (r1 == r2) goto L_0x0070
            r3 = -16777216(0xffffffffff000000, float:-1.7014118E38)
            switch(r1) {
                case 16: goto L_0x006b;
                case 17: goto L_0x006b;
                case 18: goto L_0x006b;
                case 19: goto L_0x0068;
                case 20: goto L_0x0068;
                case 21: goto L_0x0068;
                case 22: goto L_0x0070;
                case 23: goto L_0x006b;
                default: goto L_0x0010;
            }
        L_0x0010:
            switch(r1) {
                case 64: goto L_0x0022;
                case 65: goto L_0x0022;
                case 66: goto L_0x006b;
                case 67: goto L_0x0020;
                case 68: goto L_0x0020;
                case 69: goto L_0x0020;
                case 70: goto L_0x0020;
                case 71: goto L_0x0019;
                case 72: goto L_0x0019;
                case 73: goto L_0x0019;
                case 74: goto L_0x0019;
                case 75: goto L_0x0019;
                default: goto L_0x0013;
            }
        L_0x0013:
            java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException
            r10.<init>()
            throw r10
        L_0x0019:
            r1 = -16776961(0xffffffffff0000ff, float:-1.7014636E38)
            r0 = r0 & r1
            int r11 = r11 + 4
            goto L_0x0075
        L_0x0020:
            r0 = r0 & r3
            goto L_0x006d
        L_0x0022:
            r0 = r0 & r3
            int r1 = r11 + 1
            int r1 = r9.readUnsignedShort(r1)
            int r11 = r11 + 3
            net.bytebuddy.jar.asm.Label[] r3 = new net.bytebuddy.jar.asm.Label[r1]
            r10.f27365j = r3
            net.bytebuddy.jar.asm.Label[] r3 = new net.bytebuddy.jar.asm.Label[r1]
            r10.f27366k = r3
            int[] r3 = new int[r1]
            r10.f27367l = r3
            r3 = 0
        L_0x0038:
            if (r3 >= r1) goto L_0x0075
            int r4 = r9.readUnsignedShort(r11)
            int r5 = r11 + 2
            int r5 = r9.readUnsignedShort(r5)
            int r6 = r11 + 4
            int r6 = r9.readUnsignedShort(r6)
            int r11 = r11 + 6
            net.bytebuddy.jar.asm.Label[] r7 = r10.f27365j
            net.bytebuddy.jar.asm.Label[] r8 = r10.f27362g
            net.bytebuddy.jar.asm.Label r8 = r9.createLabel(r4, r8)
            r7[r3] = r8
            net.bytebuddy.jar.asm.Label[] r7 = r10.f27366k
            int r4 = r4 + r5
            net.bytebuddy.jar.asm.Label[] r5 = r10.f27362g
            net.bytebuddy.jar.asm.Label r4 = r9.createLabel(r4, r5)
            r7[r3] = r4
            int[] r4 = r10.f27367l
            r4[r3] = r6
            int r3 = r3 + 1
            goto L_0x0038
        L_0x0068:
            r0 = r0 & r3
            int r11 = r11 + r2
            goto L_0x0075
        L_0x006b:
            r0 = r0 & -256(0xffffffffffffff00, float:NaN)
        L_0x006d:
            int r11 = r11 + 3
            goto L_0x0075
        L_0x0070:
            r1 = -65536(0xffffffffffff0000, float:NaN)
            r0 = r0 & r1
            int r11 = r11 + 2
        L_0x0075:
            r10.f27363h = r0
            int r0 = r9.readByte(r11)
            if (r0 != 0) goto L_0x007f
            r1 = 0
            goto L_0x0086
        L_0x007f:
            net.bytebuddy.jar.asm.TypePath r1 = new net.bytebuddy.jar.asm.TypePath
            byte[] r3 = r9.f27351a
            r1.<init>(r3, r11)
        L_0x0086:
            r10.f27364i = r1
            int r11 = r11 + r2
            int r0 = r0 * 2
            int r11 = r11 + r0
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.jar.asm.ClassReader.readTypeAnnotationTarget(net.bytebuddy.jar.asm.Context, int):int");
    }

    private int[] readTypeAnnotations(MethodVisitor methodVisitor, Context context, int i11, boolean z11) {
        int i12;
        char[] cArr = context.f27358c;
        int readUnsignedShort = readUnsignedShort(i11);
        int[] iArr = new int[readUnsignedShort];
        int i13 = i11 + 2;
        for (int i14 = 0; i14 < readUnsignedShort; i14++) {
            iArr[i14] = i13;
            int readInt = readInt(i13);
            int i15 = readInt >>> 24;
            if (i15 != 23) {
                switch (i15) {
                    case 16:
                    case 17:
                    case 18:
                        break;
                    default:
                        switch (i15) {
                            case 64:
                            case 65:
                                int readUnsignedShort2 = readUnsignedShort(i13 + 1);
                                i12 = i13 + 3;
                                while (true) {
                                    int i16 = readUnsignedShort2 - 1;
                                    if (readUnsignedShort2 <= 0) {
                                        break;
                                    } else {
                                        int readUnsignedShort3 = readUnsignedShort(i12);
                                        int readUnsignedShort4 = readUnsignedShort(i12 + 2);
                                        i12 += 6;
                                        createLabel(readUnsignedShort3, context.f27362g);
                                        createLabel(readUnsignedShort3 + readUnsignedShort4, context.f27362g);
                                        readUnsignedShort2 = i16;
                                    }
                                }
                            case 66:
                            case 67:
                            case 68:
                            case 69:
                            case 70:
                                break;
                            case 71:
                            case 72:
                            case 73:
                            case 74:
                            case 75:
                                i12 = i13 + 4;
                                break;
                            default:
                                throw new IllegalArgumentException();
                        }
                        break;
                }
            }
            i12 = i13 + 3;
            int readByte = readByte(i12);
            TypePath typePath = null;
            if (i15 == 66) {
                if (readByte != 0) {
                    typePath = new TypePath(this.f27351a, i12);
                }
                int i17 = i12 + (readByte * 2) + 1;
                i13 = readElementValues(methodVisitor.visitTryCatchAnnotation(readInt & InputDeviceCompat.SOURCE_ANY, typePath, readUTF8(i17, cArr), z11), i17 + 2, true, cArr);
            } else {
                i13 = readElementValues((AnnotationVisitor) null, i12 + (readByte * 2) + 3, true, cArr);
            }
        }
        return iArr;
    }

    private String readUtf(int i11, int i12, char[] cArr) {
        int i13;
        int i14 = i12 + i11;
        byte[] bArr = this.f27351a;
        int i15 = 0;
        while (i11 < i14) {
            int i16 = i11 + 1;
            byte b11 = bArr[i11];
            if ((b11 & 128) == 0) {
                i13 = i15 + 1;
                cArr[i15] = (char) (b11 & Byte.MAX_VALUE);
            } else if ((b11 & 224) == 192) {
                cArr[i15] = (char) (((b11 & Ascii.US) << 6) + (bArr[i16] & Utf8.REPLACEMENT_BYTE));
                i15++;
                i11 = i16 + 1;
            } else {
                i13 = i15 + 1;
                int i17 = i16 + 1;
                int i18 = ((b11 & Ascii.SI) << 12) + ((bArr[i16] & Utf8.REPLACEMENT_BYTE) << 6);
                i16 = i17 + 1;
                cArr[i15] = (char) (i18 + (bArr[i17] & Utf8.REPLACEMENT_BYTE));
            }
            i11 = i16;
            i15 = i13;
        }
        return new String(cArr, 0, i15);
    }

    private int readVerificationTypeInfo(int i11, Object[] objArr, int i12, char[] cArr, Label[] labelArr) {
        int i13 = i11 + 1;
        switch (this.f27351a[i11] & 255) {
            case 0:
                objArr[i12] = Opcodes.TOP;
                return i13;
            case 1:
                objArr[i12] = Opcodes.INTEGER;
                return i13;
            case 2:
                objArr[i12] = Opcodes.FLOAT;
                return i13;
            case 3:
                objArr[i12] = Opcodes.DOUBLE;
                return i13;
            case 4:
                objArr[i12] = Opcodes.LONG;
                return i13;
            case 5:
                objArr[i12] = Opcodes.NULL;
                return i13;
            case 6:
                objArr[i12] = Opcodes.UNINITIALIZED_THIS;
                return i13;
            case 7:
                objArr[i12] = readClass(i13, cArr);
                break;
            case 8:
                objArr[i12] = createLabel(readUnsignedShort(i13), labelArr);
                break;
            default:
                throw new IllegalArgumentException();
        }
        return i13 + 2;
    }

    public final int a() {
        int i11 = this.header;
        int readUnsignedShort = i11 + 8 + (readUnsignedShort(i11 + 6) * 2);
        int readUnsignedShort2 = readUnsignedShort(readUnsignedShort);
        int i12 = readUnsignedShort + 2;
        while (true) {
            int i13 = readUnsignedShort2 - 1;
            if (readUnsignedShort2 <= 0) {
                break;
            }
            int readUnsignedShort3 = readUnsignedShort(i12 + 6);
            i12 += 8;
            while (true) {
                int i14 = readUnsignedShort3 - 1;
                if (readUnsignedShort3 <= 0) {
                    break;
                }
                i12 += readInt(i12 + 2) + 6;
                readUnsignedShort3 = i14;
            }
            readUnsignedShort2 = i13;
        }
        int readUnsignedShort4 = readUnsignedShort(i12);
        int i15 = i12 + 2;
        while (true) {
            int i16 = readUnsignedShort4 - 1;
            if (readUnsignedShort4 <= 0) {
                return i15 + 2;
            }
            int readUnsignedShort5 = readUnsignedShort(i15 + 6);
            i15 += 8;
            while (true) {
                int i17 = readUnsignedShort5 - 1;
                if (readUnsignedShort5 <= 0) {
                    break;
                }
                i15 += readInt(i15 + 2) + 6;
                readUnsignedShort5 = i17;
            }
            readUnsignedShort4 = i16;
        }
    }

    public void accept(ClassVisitor classVisitor, int i11) {
        accept(classVisitor, new Attribute[0], i11);
    }

    public Label b(int i11, Label[] labelArr) {
        if (labelArr[i11] == null) {
            labelArr[i11] = new Label();
        }
        return labelArr[i11];
    }

    public final String c(int i11, char[] cArr) {
        String[] strArr = this.constantUtf8Values;
        String str = strArr[i11];
        if (str != null) {
            return str;
        }
        int i12 = this.cpInfoOffsets[i11];
        String readUtf = readUtf(i12 + 2, readUnsignedShort(i12), cArr);
        strArr[i11] = readUtf;
        return readUtf;
    }

    public int getAccess() {
        return readUnsignedShort(this.header);
    }

    public String getClassName() {
        return readClass(this.header + 2, new char[this.maxStringLength]);
    }

    public String[] getInterfaces() {
        int i11 = this.header + 6;
        int readUnsignedShort = readUnsignedShort(i11);
        String[] strArr = new String[readUnsignedShort];
        if (readUnsignedShort > 0) {
            char[] cArr = new char[this.maxStringLength];
            for (int i12 = 0; i12 < readUnsignedShort; i12++) {
                i11 += 2;
                strArr[i12] = readClass(i11, cArr);
            }
        }
        return strArr;
    }

    public int getItem(int i11) {
        return this.cpInfoOffsets[i11];
    }

    public int getItemCount() {
        return this.cpInfoOffsets.length;
    }

    public int getMaxStringLength() {
        return this.maxStringLength;
    }

    public String getSuperName() {
        return readClass(this.header + 4, new char[this.maxStringLength]);
    }

    public int readByte(int i11) {
        return this.f27351a[i11] & 255;
    }

    public String readClass(int i11, char[] cArr) {
        return readStringish(i11, cArr);
    }

    public Object readConst(int i11, char[] cArr) {
        boolean z11;
        int i12 = this.cpInfoOffsets[i11];
        byte b11 = this.f27351a[i12 - 1];
        switch (b11) {
            case 3:
                return Integer.valueOf(readInt(i12));
            case 4:
                return Float.valueOf(Float.intBitsToFloat(readInt(i12)));
            case 5:
                return Long.valueOf(readLong(i12));
            case 6:
                return Double.valueOf(Double.longBitsToDouble(readLong(i12)));
            case 7:
                return Type.getObjectType(readUTF8(i12, cArr));
            case 8:
                return readUTF8(i12, cArr);
            default:
                switch (b11) {
                    case 15:
                        int readByte = readByte(i12);
                        int i13 = this.cpInfoOffsets[readUnsignedShort(i12 + 1)];
                        int i14 = this.cpInfoOffsets[readUnsignedShort(i13 + 2)];
                        String readClass = readClass(i13, cArr);
                        String readUTF8 = readUTF8(i14, cArr);
                        String readUTF82 = readUTF8(i14 + 2, cArr);
                        if (this.f27351a[i13 - 1] == 11) {
                            z11 = true;
                        } else {
                            z11 = false;
                        }
                        return new Handle(readByte, readClass, readUTF8, readUTF82, z11);
                    case 16:
                        return Type.getMethodType(readUTF8(i12, cArr));
                    case 17:
                        return readConstantDynamic(i11, cArr);
                    default:
                        throw new IllegalArgumentException();
                }
        }
    }

    public int readInt(int i11) {
        byte[] bArr = this.f27351a;
        return (bArr[i11 + 3] & 255) | ((bArr[i11] & 255) << Ascii.CAN) | ((bArr[i11 + 1] & 255) << Ascii.DLE) | ((bArr[i11 + 2] & 255) << 8);
    }

    public long readLong(int i11) {
        return (((long) readInt(i11)) << 32) | (((long) readInt(i11 + 4)) & 4294967295L);
    }

    public String readModule(int i11, char[] cArr) {
        return readStringish(i11, cArr);
    }

    public String readPackage(int i11, char[] cArr) {
        return readStringish(i11, cArr);
    }

    public short readShort(int i11) {
        byte[] bArr = this.f27351a;
        return (short) ((bArr[i11 + 1] & 255) | ((bArr[i11] & 255) << 8));
    }

    public String readUTF8(int i11, char[] cArr) {
        int readUnsignedShort = readUnsignedShort(i11);
        if (i11 == 0 || readUnsignedShort == 0) {
            return null;
        }
        return c(readUnsignedShort, cArr);
    }

    public int readUnsignedShort(int i11) {
        byte[] bArr = this.f27351a;
        return (bArr[i11 + 1] & 255) | ((bArr[i11] & 255) << 8);
    }

    public ClassReader(byte[] bArr, int i11, int i12) {
        this(bArr, i11, true);
    }

    public void accept(ClassVisitor classVisitor, Attribute[] attributeArr, int i11) {
        String str;
        String str2;
        int i12;
        int i13;
        String[] strArr;
        int i14;
        ClassVisitor classVisitor2 = classVisitor;
        int i15 = i11;
        Context context = new Context();
        context.f27356a = attributeArr;
        context.f27357b = i15;
        char[] cArr = new char[this.maxStringLength];
        context.f27358c = cArr;
        int i16 = this.header;
        int readUnsignedShort = readUnsignedShort(i16);
        String readClass = readClass(i16 + 2, cArr);
        String readClass2 = readClass(i16 + 4, cArr);
        int readUnsignedShort2 = readUnsignedShort(i16 + 6);
        String[] strArr2 = new String[readUnsignedShort2];
        int i17 = i16 + 8;
        for (int i18 = 0; i18 < readUnsignedShort2; i18++) {
            strArr2[i18] = readClass(i17, cArr);
            i17 += 2;
        }
        int a11 = a();
        int i19 = readUnsignedShort;
        int readUnsignedShort3 = readUnsignedShort(a11 - 2);
        String str3 = null;
        String str4 = null;
        int i21 = 0;
        String str5 = null;
        int i22 = 0;
        String str6 = null;
        String str7 = null;
        int i23 = 0;
        int i24 = 0;
        int i25 = 0;
        int i26 = 0;
        int i27 = 0;
        int i28 = 0;
        Attribute attribute = null;
        int i29 = 0;
        int i31 = 0;
        int i32 = 0;
        while (readUnsignedShort3 > 0) {
            String readUTF8 = readUTF8(a11, cArr);
            int readInt = readInt(a11 + 2);
            int i33 = a11 + 6;
            String str8 = str3;
            if (AttributeLayout.ATTRIBUTE_SOURCE_FILE.equals(readUTF8)) {
                i13 = i33;
                str4 = readUTF8(i33, cArr);
            } else if (AttributeLayout.ATTRIBUTE_INNER_CLASSES.equals(readUTF8)) {
                i31 = i33;
                i13 = i31;
            } else if (AttributeLayout.ATTRIBUTE_ENCLOSING_METHOD.equals(readUTF8)) {
                i23 = i33;
                i13 = i23;
            } else if ("NestHost".equals(readUTF8)) {
                i13 = i33;
                str7 = readClass(i33, cArr);
            } else if ("NestMembers".equals(readUTF8)) {
                i28 = i33;
                i13 = i28;
            } else if ("PermittedSubclasses".equals(readUTF8)) {
                i29 = i33;
                i13 = i29;
            } else {
                if (AttributeLayout.ATTRIBUTE_SIGNATURE.equals(readUTF8)) {
                    str5 = readUTF8(i33, cArr);
                } else if (AttributeLayout.ATTRIBUTE_RUNTIME_VISIBLE_ANNOTATIONS.equals(readUTF8)) {
                    i24 = i33;
                    i13 = i24;
                } else if ("RuntimeVisibleTypeAnnotations".equals(readUTF8)) {
                    i26 = i33;
                    i13 = i26;
                } else if (AttributeLayout.ATTRIBUTE_DEPRECATED.equals(readUTF8)) {
                    i19 |= 131072;
                } else if ("Synthetic".equals(readUTF8)) {
                    i19 |= 4096;
                } else if ("SourceDebugExtension".equals(readUTF8)) {
                    if (readInt <= this.f27351a.length - i33) {
                        str3 = readUtf(i33, readInt, new char[readInt]);
                        i13 = i33;
                        i12 = i17;
                        i14 = readInt;
                        strArr = strArr2;
                        a11 = i13 + i14;
                        readUnsignedShort3--;
                        Attribute[] attributeArr2 = attributeArr;
                        strArr2 = strArr;
                        i17 = i12;
                    } else {
                        throw new IllegalArgumentException();
                    }
                } else if (AttributeLayout.ATTRIBUTE_RUNTIME_INVISIBLE_ANNOTATIONS.equals(readUTF8)) {
                    i25 = i33;
                    i13 = i25;
                } else if ("RuntimeInvisibleTypeAnnotations".equals(readUTF8)) {
                    i27 = i33;
                    i13 = i27;
                } else if ("Record".equals(readUTF8)) {
                    i19 |= 65536;
                    i32 = i33;
                    i13 = i32;
                } else if ("Module".equals(readUTF8)) {
                    i21 = i33;
                    i13 = i21;
                } else if ("ModuleMainClass".equals(readUTF8)) {
                    str6 = readClass(i33, cArr);
                } else if ("ModulePackages".equals(readUTF8)) {
                    i22 = i33;
                    i13 = i22;
                } else {
                    if (!"BootstrapMethods".equals(readUTF8)) {
                        i13 = i33;
                        i12 = i17;
                        i14 = readInt;
                        strArr = strArr2;
                        Attribute readAttribute = readAttribute(attributeArr, readUTF8, i13, readInt, cArr, -1, (Label[]) null);
                        readAttribute.f27348a = attribute;
                        attribute = readAttribute;
                        i19 = i19;
                        str3 = str8;
                        str4 = str4;
                    } else {
                        i13 = i33;
                        String str9 = str4;
                        i12 = i17;
                        i14 = readInt;
                        strArr = strArr2;
                        Attribute attribute2 = attribute;
                        String str10 = str8;
                        int i34 = i19;
                        str3 = str10;
                    }
                    a11 = i13 + i14;
                    readUnsignedShort3--;
                    Attribute[] attributeArr22 = attributeArr;
                    strArr2 = strArr;
                    i17 = i12;
                }
                i13 = i33;
            }
            i12 = i17;
            i14 = readInt;
            strArr = strArr2;
            str3 = str8;
            a11 = i13 + i14;
            readUnsignedShort3--;
            Attribute[] attributeArr222 = attributeArr;
            strArr2 = strArr;
            i17 = i12;
        }
        String str11 = str3;
        String str12 = str4;
        int i35 = i17;
        String[] strArr3 = strArr2;
        Attribute attribute3 = attribute;
        classVisitor.visit(readInt(this.cpInfoOffsets[1] - 7), i19, readClass, str5, readClass2, strArr3);
        if ((i15 & 2) == 0) {
            String str13 = str12;
            String str14 = str11;
            if (!(str13 == null && str14 == null)) {
                classVisitor2.visitSource(str13, str14);
            }
        }
        if (i21 != 0) {
            readModuleAttributes(classVisitor, context, i21, i22, str6);
        }
        String str15 = str7;
        if (str15 != null) {
            classVisitor2.visitNestHost(str15);
        }
        int i36 = i23;
        if (i36 != 0) {
            String readClass3 = readClass(i36, cArr);
            int readUnsignedShort4 = readUnsignedShort(i36 + 2);
            if (readUnsignedShort4 == 0) {
                str = null;
            } else {
                str = readUTF8(this.cpInfoOffsets[readUnsignedShort4], cArr);
            }
            if (readUnsignedShort4 == 0) {
                str2 = null;
            } else {
                str2 = readUTF8(this.cpInfoOffsets[readUnsignedShort4] + 2, cArr);
            }
            classVisitor2.visitOuterClass(readClass3, str, str2);
        }
        int i37 = i24;
        if (i37 != 0) {
            int readUnsignedShort5 = readUnsignedShort(i37);
            int i38 = i37 + 2;
            while (true) {
                int i39 = readUnsignedShort5 - 1;
                if (readUnsignedShort5 <= 0) {
                    break;
                }
                i38 = readElementValues(classVisitor2.visitAnnotation(readUTF8(i38, cArr), true), i38 + 2, true, cArr);
                readUnsignedShort5 = i39;
            }
        }
        int i41 = i25;
        if (i41 != 0) {
            int readUnsignedShort6 = readUnsignedShort(i41);
            int i42 = i41 + 2;
            while (true) {
                int i43 = readUnsignedShort6 - 1;
                if (readUnsignedShort6 <= 0) {
                    break;
                }
                i42 = readElementValues(classVisitor2.visitAnnotation(readUTF8(i42, cArr), false), i42 + 2, true, cArr);
                readUnsignedShort6 = i43;
            }
        }
        int i44 = i26;
        if (i44 != 0) {
            int readUnsignedShort7 = readUnsignedShort(i44);
            int i45 = i44 + 2;
            while (true) {
                int i46 = readUnsignedShort7 - 1;
                if (readUnsignedShort7 <= 0) {
                    break;
                }
                int readTypeAnnotationTarget = readTypeAnnotationTarget(context, i45);
                i45 = readElementValues(classVisitor2.visitTypeAnnotation(context.f27363h, context.f27364i, readUTF8(readTypeAnnotationTarget, cArr), true), readTypeAnnotationTarget + 2, true, cArr);
                readUnsignedShort7 = i46;
            }
        }
        int i47 = i27;
        if (i47 != 0) {
            int readUnsignedShort8 = readUnsignedShort(i47);
            int i48 = i47 + 2;
            while (true) {
                int i49 = readUnsignedShort8 - 1;
                if (readUnsignedShort8 <= 0) {
                    break;
                }
                int readTypeAnnotationTarget2 = readTypeAnnotationTarget(context, i48);
                i48 = readElementValues(classVisitor2.visitTypeAnnotation(context.f27363h, context.f27364i, readUTF8(readTypeAnnotationTarget2, cArr), false), readTypeAnnotationTarget2 + 2, true, cArr);
                readUnsignedShort8 = i49;
            }
        }
        while (attribute3 != null) {
            Attribute attribute4 = attribute3.f27348a;
            attribute3.f27348a = null;
            classVisitor2.visitAttribute(attribute3);
            attribute3 = attribute4;
        }
        int i50 = i28;
        if (i50 != 0) {
            int readUnsignedShort9 = readUnsignedShort(i50);
            int i51 = i50 + 2;
            while (true) {
                int i52 = readUnsignedShort9 - 1;
                if (readUnsignedShort9 <= 0) {
                    break;
                }
                classVisitor2.visitNestMember(readClass(i51, cArr));
                i51 += 2;
                readUnsignedShort9 = i52;
            }
        }
        int i53 = i29;
        if (i53 != 0) {
            int readUnsignedShort10 = readUnsignedShort(i53);
            int i54 = i53 + 2;
            while (true) {
                int i55 = readUnsignedShort10 - 1;
                if (readUnsignedShort10 <= 0) {
                    break;
                }
                classVisitor2.visitPermittedSubclass(readClass(i54, cArr));
                i54 += 2;
                readUnsignedShort10 = i55;
            }
        }
        int i56 = i31;
        if (i56 != 0) {
            int readUnsignedShort11 = readUnsignedShort(i56);
            int i57 = i56 + 2;
            while (true) {
                int i58 = readUnsignedShort11 - 1;
                if (readUnsignedShort11 <= 0) {
                    break;
                }
                classVisitor2.visitInnerClass(readClass(i57, cArr), readClass(i57 + 2, cArr), readUTF8(i57 + 4, cArr), readUnsignedShort(i57 + 6));
                i57 += 8;
                readUnsignedShort11 = i58;
            }
        }
        int i59 = i32;
        if (i59 != 0) {
            int readUnsignedShort12 = readUnsignedShort(i59);
            int i60 = i59 + 2;
            while (true) {
                int i61 = readUnsignedShort12 - 1;
                if (readUnsignedShort12 <= 0) {
                    break;
                }
                i60 = readRecordComponent(classVisitor2, context, i60);
                readUnsignedShort12 = i61;
            }
        }
        int i62 = i35;
        int readUnsignedShort13 = readUnsignedShort(i62);
        int i63 = i62 + 2;
        while (true) {
            int i64 = readUnsignedShort13 - 1;
            if (readUnsignedShort13 <= 0) {
                break;
            }
            i63 = readField(classVisitor2, context, i63);
            readUnsignedShort13 = i64;
        }
        int readUnsignedShort14 = readUnsignedShort(i63);
        int i65 = i63 + 2;
        while (true) {
            int i66 = readUnsignedShort14 - 1;
            if (readUnsignedShort14 > 0) {
                i65 = readMethod(classVisitor2, context, i65);
                readUnsignedShort14 = i66;
            } else {
                classVisitor.visitEnd();
                return;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0067, code lost:
        r4 = r6;
        r5 = 5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0072, code lost:
        r4 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0073, code lost:
        r11 = r11 + r5;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ClassReader(byte[] r10, int r11, boolean r12) {
        /*
            r9 = this;
            r9.<init>()
            r9.f27351a = r10
            r9.f27352b = r10
            if (r12 == 0) goto L_0x002f
            int r12 = r11 + 6
            short r0 = r9.readShort(r12)
            r1 = 62
            if (r0 > r1) goto L_0x0014
            goto L_0x002f
        L_0x0014:
            java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r0 = "Unsupported class file major version "
            r11.append(r0)
            short r12 = r9.readShort(r12)
            r11.append(r12)
            java.lang.String r11 = r11.toString()
            r10.<init>(r11)
            throw r10
        L_0x002f:
            int r12 = r11 + 8
            int r12 = r9.readUnsignedShort(r12)
            int[] r0 = new int[r12]
            r9.cpInfoOffsets = r0
            java.lang.String[] r0 = new java.lang.String[r12]
            r9.constantUtf8Values = r0
            int r11 = r11 + 10
            r0 = 0
            r1 = 1
            r2 = r0
            r3 = r2
            r4 = r1
        L_0x0044:
            if (r4 >= r12) goto L_0x0075
            int[] r5 = r9.cpInfoOffsets
            int r6 = r4 + 1
            int r7 = r11 + 1
            r5[r4] = r7
            byte r4 = r10[r11]
            r5 = 3
            r8 = 5
            switch(r4) {
                case 1: goto L_0x006a;
                case 2: goto L_0x0055;
                case 3: goto L_0x0067;
                case 4: goto L_0x0067;
                case 5: goto L_0x0062;
                case 6: goto L_0x0062;
                case 7: goto L_0x0072;
                case 8: goto L_0x0072;
                case 9: goto L_0x0067;
                case 10: goto L_0x0067;
                case 11: goto L_0x0067;
                case 12: goto L_0x0067;
                case 13: goto L_0x0055;
                case 14: goto L_0x0055;
                case 15: goto L_0x0060;
                case 16: goto L_0x0072;
                case 17: goto L_0x005d;
                case 18: goto L_0x005b;
                case 19: goto L_0x0072;
                case 20: goto L_0x0072;
                default: goto L_0x0055;
            }
        L_0x0055:
            java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException
            r10.<init>()
            throw r10
        L_0x005b:
            r3 = r1
            goto L_0x0067
        L_0x005d:
            r2 = r1
            r3 = r2
            goto L_0x0067
        L_0x0060:
            r5 = 4
            goto L_0x0072
        L_0x0062:
            int r6 = r6 + 1
            r5 = 9
            goto L_0x0072
        L_0x0067:
            r4 = r6
            r5 = r8
            goto L_0x0073
        L_0x006a:
            int r4 = r9.readUnsignedShort(r7)
            int r5 = r5 + r4
            if (r5 <= r0) goto L_0x0072
            r0 = r5
        L_0x0072:
            r4 = r6
        L_0x0073:
            int r11 = r11 + r5
            goto L_0x0044
        L_0x0075:
            r9.maxStringLength = r0
            r9.header = r11
            r10 = 0
            if (r2 == 0) goto L_0x007f
            net.bytebuddy.jar.asm.ConstantDynamic[] r11 = new net.bytebuddy.jar.asm.ConstantDynamic[r12]
            goto L_0x0080
        L_0x007f:
            r11 = r10
        L_0x0080:
            r9.constantDynamicValues = r11
            if (r3 == 0) goto L_0x0088
            int[] r10 = r9.readBootstrapMethodsAttribute(r0)
        L_0x0088:
            r9.bootstrapMethodOffsets = r10
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.jar.asm.ClassReader.<init>(byte[], int, boolean):void");
    }

    public ClassReader(InputStream inputStream) throws IOException {
        this(readStream(inputStream, false));
    }

    public ClassReader(String str) throws IOException {
        this(readStream(ClassLoader.getSystemResourceAsStream(str.replace('.', '/') + ".class"), true));
    }
}
