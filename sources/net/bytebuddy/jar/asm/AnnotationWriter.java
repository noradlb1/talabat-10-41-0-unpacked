package net.bytebuddy.jar.asm;

import org.apache.commons.compress.harmony.unpack200.AttributeLayout;

final class AnnotationWriter extends AnnotationVisitor {
    private final ByteVector annotation;
    private AnnotationWriter nextAnnotation;
    private int numElementValuePairs;
    private final int numElementValuePairsOffset;
    private final AnnotationWriter previousAnnotation;
    private final SymbolTable symbolTable;
    private final boolean useNamedValues;

    public AnnotationWriter(SymbolTable symbolTable2, boolean z11, ByteVector byteVector, AnnotationWriter annotationWriter) {
        super(Opcodes.ASM9);
        int i11;
        this.symbolTable = symbolTable2;
        this.useNamedValues = z11;
        this.annotation = byteVector;
        int i12 = byteVector.f27350b;
        if (i12 == 0) {
            i11 = -1;
        } else {
            i11 = i12 - 2;
        }
        this.numElementValuePairsOffset = i11;
        this.previousAnnotation = annotationWriter;
        if (annotationWriter != null) {
            annotationWriter.nextAnnotation = this;
        }
    }

    public static int b(AnnotationWriter annotationWriter, AnnotationWriter annotationWriter2, AnnotationWriter annotationWriter3, AnnotationWriter annotationWriter4) {
        int i11 = 0;
        if (annotationWriter != null) {
            i11 = 0 + annotationWriter.a(AttributeLayout.ATTRIBUTE_RUNTIME_VISIBLE_ANNOTATIONS);
        }
        if (annotationWriter2 != null) {
            i11 += annotationWriter2.a(AttributeLayout.ATTRIBUTE_RUNTIME_INVISIBLE_ANNOTATIONS);
        }
        if (annotationWriter3 != null) {
            i11 += annotationWriter3.a("RuntimeVisibleTypeAnnotations");
        }
        if (annotationWriter4 != null) {
            return i11 + annotationWriter4.a("RuntimeInvisibleTypeAnnotations");
        }
        return i11;
    }

    public static int c(String str, AnnotationWriter[] annotationWriterArr, int i11) {
        int i12;
        int i13 = (i11 * 2) + 7;
        for (int i14 = 0; i14 < i11; i14++) {
            AnnotationWriter annotationWriter = annotationWriterArr[i14];
            if (annotationWriter == null) {
                i12 = 0;
            } else {
                i12 = annotationWriter.a(str) - 8;
            }
            i13 += i12;
        }
        return i13;
    }

    public static AnnotationWriter d(SymbolTable symbolTable2, int i11, TypePath typePath, String str, AnnotationWriter annotationWriter) {
        ByteVector byteVector = new ByteVector();
        TypeReference.a(i11, byteVector);
        TypePath.a(typePath, byteVector);
        byteVector.putShort(symbolTable2.r(str)).putShort(0);
        return new AnnotationWriter(symbolTable2, true, byteVector, annotationWriter);
    }

    public static AnnotationWriter e(SymbolTable symbolTable2, String str, AnnotationWriter annotationWriter) {
        ByteVector byteVector = new ByteVector();
        byteVector.putShort(symbolTable2.r(str)).putShort(0);
        return new AnnotationWriter(symbolTable2, true, byteVector, annotationWriter);
    }

    public static void g(SymbolTable symbolTable2, AnnotationWriter annotationWriter, AnnotationWriter annotationWriter2, AnnotationWriter annotationWriter3, AnnotationWriter annotationWriter4, ByteVector byteVector) {
        if (annotationWriter != null) {
            annotationWriter.f(symbolTable2.r(AttributeLayout.ATTRIBUTE_RUNTIME_VISIBLE_ANNOTATIONS), byteVector);
        }
        if (annotationWriter2 != null) {
            annotationWriter2.f(symbolTable2.r(AttributeLayout.ATTRIBUTE_RUNTIME_INVISIBLE_ANNOTATIONS), byteVector);
        }
        if (annotationWriter3 != null) {
            annotationWriter3.f(symbolTable2.r("RuntimeVisibleTypeAnnotations"), byteVector);
        }
        if (annotationWriter4 != null) {
            annotationWriter4.f(symbolTable2.r("RuntimeInvisibleTypeAnnotations"), byteVector);
        }
    }

    public static void h(int i11, AnnotationWriter[] annotationWriterArr, int i12, ByteVector byteVector) {
        int i13;
        int i14 = (i12 * 2) + 1;
        for (int i15 = 0; i15 < i12; i15++) {
            AnnotationWriter annotationWriter = annotationWriterArr[i15];
            if (annotationWriter == null) {
                i13 = 0;
            } else {
                i13 = annotationWriter.a((String) null) - 8;
            }
            i14 += i13;
        }
        byteVector.putShort(i11);
        byteVector.putInt(i14);
        byteVector.putByte(i12);
        for (int i16 = 0; i16 < i12; i16++) {
            int i17 = 0;
            AnnotationWriter annotationWriter2 = null;
            for (AnnotationWriter annotationWriter3 = annotationWriterArr[i16]; annotationWriter3 != null; annotationWriter3 = annotationWriter3.previousAnnotation) {
                annotationWriter3.visitEnd();
                i17++;
                annotationWriter2 = annotationWriter3;
            }
            byteVector.putShort(i17);
            while (annotationWriter2 != null) {
                ByteVector byteVector2 = annotationWriter2.annotation;
                byteVector.putByteArray(byteVector2.f27349a, 0, byteVector2.f27350b);
                annotationWriter2 = annotationWriter2.nextAnnotation;
            }
        }
    }

    public int a(String str) {
        if (str != null) {
            this.symbolTable.r(str);
        }
        int i11 = 8;
        for (AnnotationWriter annotationWriter = this; annotationWriter != null; annotationWriter = annotationWriter.previousAnnotation) {
            i11 += annotationWriter.annotation.f27350b;
        }
        return i11;
    }

    public void f(int i11, ByteVector byteVector) {
        int i12 = 2;
        int i13 = 0;
        AnnotationWriter annotationWriter = null;
        for (AnnotationWriter annotationWriter2 = this; annotationWriter2 != null; annotationWriter2 = annotationWriter2.previousAnnotation) {
            annotationWriter2.visitEnd();
            i12 += annotationWriter2.annotation.f27350b;
            i13++;
            annotationWriter = annotationWriter2;
        }
        byteVector.putShort(i11);
        byteVector.putInt(i12);
        byteVector.putShort(i13);
        while (annotationWriter != null) {
            ByteVector byteVector2 = annotationWriter.annotation;
            byteVector.putByteArray(byteVector2.f27349a, 0, byteVector2.f27350b);
            annotationWriter = annotationWriter.nextAnnotation;
        }
    }

    public void visit(String str, Object obj) {
        this.numElementValuePairs++;
        if (this.useNamedValues) {
            this.annotation.putShort(this.symbolTable.r(str));
        }
        if (obj instanceof String) {
            this.annotation.d(115, this.symbolTable.r((String) obj));
        } else if (obj instanceof Byte) {
            this.annotation.d(66, this.symbolTable.h(((Byte) obj).byteValue()).f27406a);
        } else if (obj instanceof Boolean) {
            this.annotation.d(90, this.symbolTable.h(((Boolean) obj).booleanValue() ? 1 : 0).f27406a);
        } else if (obj instanceof Character) {
            this.annotation.d(67, this.symbolTable.h(((Character) obj).charValue()).f27406a);
        } else if (obj instanceof Short) {
            this.annotation.d(83, this.symbolTable.h(((Short) obj).shortValue()).f27406a);
        } else if (obj instanceof Type) {
            this.annotation.d(99, this.symbolTable.r(((Type) obj).getDescriptor()));
        } else {
            int i11 = 0;
            if (obj instanceof byte[]) {
                byte[] bArr = (byte[]) obj;
                this.annotation.d(91, bArr.length);
                int length = bArr.length;
                while (i11 < length) {
                    this.annotation.d(66, this.symbolTable.h(bArr[i11]).f27406a);
                    i11++;
                }
            } else if (obj instanceof boolean[]) {
                boolean[] zArr = (boolean[]) obj;
                this.annotation.d(91, zArr.length);
                int length2 = zArr.length;
                while (i11 < length2) {
                    this.annotation.d(90, this.symbolTable.h(zArr[i11] ? 1 : 0).f27406a);
                    i11++;
                }
            } else if (obj instanceof short[]) {
                short[] sArr = (short[]) obj;
                this.annotation.d(91, sArr.length);
                int length3 = sArr.length;
                while (i11 < length3) {
                    this.annotation.d(83, this.symbolTable.h(sArr[i11]).f27406a);
                    i11++;
                }
            } else if (obj instanceof char[]) {
                char[] cArr = (char[]) obj;
                this.annotation.d(91, cArr.length);
                int length4 = cArr.length;
                while (i11 < length4) {
                    this.annotation.d(67, this.symbolTable.h(cArr[i11]).f27406a);
                    i11++;
                }
            } else if (obj instanceof int[]) {
                int[] iArr = (int[]) obj;
                this.annotation.d(91, iArr.length);
                int length5 = iArr.length;
                while (i11 < length5) {
                    this.annotation.d(73, this.symbolTable.h(iArr[i11]).f27406a);
                    i11++;
                }
            } else if (obj instanceof long[]) {
                long[] jArr = (long[]) obj;
                this.annotation.d(91, jArr.length);
                int length6 = jArr.length;
                while (i11 < length6) {
                    this.annotation.d(74, this.symbolTable.j(jArr[i11]).f27406a);
                    i11++;
                }
            } else if (obj instanceof float[]) {
                float[] fArr = (float[]) obj;
                this.annotation.d(91, fArr.length);
                int length7 = fArr.length;
                while (i11 < length7) {
                    this.annotation.d(70, this.symbolTable.g(fArr[i11]).f27406a);
                    i11++;
                }
            } else if (obj instanceof double[]) {
                double[] dArr = (double[]) obj;
                this.annotation.d(91, dArr.length);
                int length8 = dArr.length;
                while (i11 < length8) {
                    this.annotation.d(68, this.symbolTable.d(dArr[i11]).f27406a);
                    i11++;
                }
            } else {
                Symbol b11 = this.symbolTable.b(obj);
                this.annotation.d(".s.IFJDCS".charAt(b11.f27407b), b11.f27406a);
            }
        }
    }

    public AnnotationVisitor visitAnnotation(String str, String str2) {
        this.numElementValuePairs++;
        if (this.useNamedValues) {
            this.annotation.putShort(this.symbolTable.r(str));
        }
        this.annotation.d(64, this.symbolTable.r(str2)).putShort(0);
        return new AnnotationWriter(this.symbolTable, true, this.annotation, (AnnotationWriter) null);
    }

    public AnnotationVisitor visitArray(String str) {
        this.numElementValuePairs++;
        if (this.useNamedValues) {
            this.annotation.putShort(this.symbolTable.r(str));
        }
        this.annotation.d(91, 0);
        return new AnnotationWriter(this.symbolTable, false, this.annotation, (AnnotationWriter) null);
    }

    public void visitEnd() {
        int i11 = this.numElementValuePairsOffset;
        if (i11 != -1) {
            byte[] bArr = this.annotation.f27349a;
            int i12 = this.numElementValuePairs;
            bArr[i11] = (byte) (i12 >>> 8);
            bArr[i11 + 1] = (byte) i12;
        }
    }

    public void visitEnum(String str, String str2, String str3) {
        this.numElementValuePairs++;
        if (this.useNamedValues) {
            this.annotation.putShort(this.symbolTable.r(str));
        }
        this.annotation.d(101, this.symbolTable.r(str2)).putShort(this.symbolTable.r(str3));
    }
}
