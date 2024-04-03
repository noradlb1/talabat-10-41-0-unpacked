package net.bytebuddy.jar.asm;

import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.jar.asm.Attribute;
import org.apache.commons.compress.harmony.unpack200.AttributeLayout;

final class MethodWriter extends MethodVisitor {
    private static final int NA = 0;
    private static final int[] STACK_SIZE_DELTA = {0, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 1, 1, 1, 2, 2, 1, 1, 1, 0, 0, 1, 2, 1, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, -1, 0, -1, -1, -1, -1, -1, -2, -1, -2, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -3, -4, -3, -4, -3, -3, -3, -3, -1, -2, 1, 1, 1, 2, 2, 2, 0, -1, -2, -1, -2, -1, -2, -1, -2, -1, -2, -1, -2, -1, -2, -1, -2, -1, -2, -1, -2, 0, 0, 0, 0, -1, -1, -1, -1, -1, -1, -1, -2, -1, -2, -1, -2, 0, 1, 0, 1, -1, -1, 0, 0, 1, 1, -1, 0, -1, 0, 0, 0, -3, -1, -1, -3, -3, -1, -1, -1, -1, -1, -1, -2, -2, -2, -2, -2, -2, -2, -2, 0, 1, 0, -1, -1, -1, -2, -1, -2, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, -1, -1, 0, 0, -1, -1, 0, 0};
    private final int accessFlags;
    private final ByteVector code = new ByteVector();
    private final int compute;
    private Label currentBasicBlock;
    private int[] currentFrame;
    private int currentLocals;
    private ByteVector defaultValue;
    private final String descriptor;
    private final int descriptorIndex;
    private final int[] exceptionIndexTable;
    private Attribute firstAttribute;
    private Label firstBasicBlock;
    private Attribute firstCodeAttribute;
    private Handler firstHandler;
    private boolean hasAsmInstructions;
    private boolean hasSubroutines;
    private int invisibleAnnotableParameterCount;
    private Label lastBasicBlock;
    private int lastBytecodeOffset;
    private AnnotationWriter lastCodeRuntimeInvisibleTypeAnnotation;
    private AnnotationWriter lastCodeRuntimeVisibleTypeAnnotation;
    private Handler lastHandler;
    private AnnotationWriter lastRuntimeInvisibleAnnotation;
    private AnnotationWriter[] lastRuntimeInvisibleParameterAnnotations;
    private AnnotationWriter lastRuntimeInvisibleTypeAnnotation;
    private AnnotationWriter lastRuntimeVisibleAnnotation;
    private AnnotationWriter[] lastRuntimeVisibleParameterAnnotations;
    private AnnotationWriter lastRuntimeVisibleTypeAnnotation;
    private ByteVector lineNumberTable;
    private int lineNumberTableLength;
    private ByteVector localVariableTable;
    private int localVariableTableLength;
    private ByteVector localVariableTypeTable;
    private int localVariableTypeTableLength;
    private int maxLocals;
    private int maxRelativeStackSize;
    private int maxStack;

    /* renamed from: name  reason: collision with root package name */
    private final String f27401name;
    private final int nameIndex;
    private final int numberOfExceptions;
    private ByteVector parameters;
    private int parametersCount;
    private int[] previousFrame;
    private int previousFrameOffset;
    private int relativeStackSize;
    private final int signatureIndex;
    private int sourceLength;
    private int sourceOffset;
    private ByteVector stackMapTableEntries;
    private int stackMapTableNumberOfEntries;
    private final SymbolTable symbolTable;
    private int visibleAnnotableParameterCount;

    public MethodWriter(SymbolTable symbolTable2, int i11, String str, String str2, String str3, String[] strArr, int i12) {
        super(Opcodes.ASM9);
        int i13;
        int i14;
        this.symbolTable = symbolTable2;
        if (MethodDescription.CONSTRUCTOR_INTERNAL_NAME.equals(str)) {
            i13 = 262144 | i11;
        } else {
            i13 = i11;
        }
        this.accessFlags = i13;
        this.nameIndex = symbolTable2.r(str);
        this.f27401name = str;
        this.descriptorIndex = symbolTable2.r(str2);
        this.descriptor = str2;
        if (str3 == null) {
            i14 = 0;
        } else {
            i14 = symbolTable2.r(str3);
        }
        this.signatureIndex = i14;
        if (strArr == null || strArr.length <= 0) {
            this.numberOfExceptions = 0;
            this.exceptionIndexTable = null;
        } else {
            int length = strArr.length;
            this.numberOfExceptions = length;
            this.exceptionIndexTable = new int[length];
            for (int i15 = 0; i15 < this.numberOfExceptions; i15++) {
                this.exceptionIndexTable[i15] = symbolTable2.c(strArr[i15]).f27406a;
            }
        }
        this.compute = i12;
        if (i12 != 0) {
            int argumentsAndReturnSizes = Type.getArgumentsAndReturnSizes(str2) >> 2;
            argumentsAndReturnSizes = (i11 & 8) != 0 ? argumentsAndReturnSizes - 1 : argumentsAndReturnSizes;
            this.maxLocals = argumentsAndReturnSizes;
            this.currentLocals = argumentsAndReturnSizes;
            Label label = new Label();
            this.firstBasicBlock = label;
            visitLabel(label);
        }
    }

    private void addSuccessorToCurrentBasicBlock(int i11, Label label) {
        Label label2 = this.currentBasicBlock;
        label2.f27397i = new Edge(i11, label, label2.f27397i);
    }

    private void computeAllFrames() {
        String str;
        int i11;
        Handler handler = this.firstHandler;
        while (true) {
            str = "java/lang/Throwable";
            if (handler == null) {
                break;
            }
            String str2 = handler.f27386e;
            if (str2 != null) {
                str = str2;
            }
            int e11 = Frame.e(this.symbolTable, str);
            Label d11 = handler.f27384c.d();
            d11.f27389a = (short) (d11.f27389a | 2);
            Label d12 = handler.f27383b.d();
            for (Label d13 = handler.f27382a.d(); d13 != d12; d13 = d13.f27396h) {
                d13.f27397i = new Edge(e11, d11, d13.f27397i);
            }
            handler = handler.f27387f;
        }
        Frame frame = this.firstBasicBlock.f27395g;
        frame.j(this.symbolTable, this.accessFlags, this.descriptor, this.maxLocals);
        frame.a(this);
        Label label = this.firstBasicBlock;
        label.f27398j = Label.f27388k;
        int i12 = 0;
        while (label != Label.f27388k) {
            Label label2 = label.f27398j;
            label.f27398j = null;
            label.f27389a = (short) (label.f27389a | 8);
            int f11 = label.f27395g.f() + label.f27393e;
            if (f11 > i12) {
                i12 = f11;
            }
            for (Edge edge = label.f27397i; edge != null; edge = edge.f27377c) {
                Label d14 = edge.f27376b.d();
                if (label.f27395g.g(this.symbolTable, d14.f27395g, edge.f27375a) && d14.f27398j == null) {
                    d14.f27398j = label2;
                    label2 = d14;
                }
            }
            label = label2;
        }
        for (Label label3 = this.firstBasicBlock; label3 != null; label3 = label3.f27396h) {
            if ((label3.f27389a & 10) == 10) {
                label3.f27395g.a(this);
            }
            if ((label3.f27389a & 8) == 0) {
                Label label4 = label3.f27396h;
                int i13 = label3.f27390b;
                if (label4 == null) {
                    i11 = this.code.f27350b;
                } else {
                    i11 = label4.f27390b;
                }
                int i14 = i11 - 1;
                if (i14 >= i13) {
                    for (int i15 = i13; i15 < i14; i15++) {
                        this.code.f27349a[i15] = 0;
                    }
                    this.code.f27349a[i14] = -65;
                    this.currentFrame[j(i13, 0, 1)] = Frame.e(this.symbolTable, str);
                    i();
                    this.firstHandler = Handler.d(this.firstHandler, label3, label4);
                    i12 = Math.max(i12, 1);
                }
            }
        }
        this.maxStack = i12;
    }

    private void computeMaxStackAndLocal() {
        int i11;
        for (Handler handler = this.firstHandler; handler != null; handler = handler.f27387f) {
            Label label = handler.f27384c;
            Label label2 = handler.f27383b;
            for (Label label3 = handler.f27382a; label3 != label2; label3 = label3.f27396h) {
                if ((label3.f27389a & 16) == 0) {
                    label3.f27397i = new Edge(Integer.MAX_VALUE, label, label3.f27397i);
                } else {
                    Edge edge = label3.f27397i.f27377c;
                    edge.f27377c = new Edge(Integer.MAX_VALUE, label, edge.f27377c);
                }
            }
        }
        if (this.hasSubroutines) {
            this.firstBasicBlock.e(1);
            short s11 = 1;
            for (short s12 = 1; s12 <= s11; s12 = (short) (s12 + 1)) {
                for (Label label4 = this.firstBasicBlock; label4 != null; label4 = label4.f27396h) {
                    if ((label4.f27389a & 16) != 0 && label4.f27394f == s12) {
                        Label label5 = label4.f27397i.f27377c.f27376b;
                        if (label5.f27394f == 0) {
                            s11 = (short) (s11 + 1);
                            label5.e(s11);
                        }
                    }
                }
            }
            for (Label label6 = this.firstBasicBlock; label6 != null; label6 = label6.f27396h) {
                if ((label6.f27389a & 16) != 0) {
                    label6.f27397i.f27377c.f27376b.c(label6);
                }
            }
        }
        Label label7 = this.firstBasicBlock;
        label7.f27398j = Label.f27388k;
        int i12 = this.maxStack;
        while (label7 != Label.f27388k) {
            Label label8 = label7.f27398j;
            short s13 = label7.f27391c;
            int i13 = label7.f27393e + s13;
            if (i13 > i12) {
                i12 = i13;
            }
            Edge edge2 = label7.f27397i;
            if ((label7.f27389a & 16) != 0) {
                edge2 = edge2.f27377c;
            }
            label7 = label8;
            while (edge2 != null) {
                Label label9 = edge2.f27376b;
                if (label9.f27398j == null) {
                    int i14 = edge2.f27375a;
                    if (i14 == Integer.MAX_VALUE) {
                        i11 = 1;
                    } else {
                        i11 = i14 + s13;
                    }
                    label9.f27391c = (short) i11;
                    label9.f27398j = label7;
                    label7 = label9;
                }
                edge2 = edge2.f27377c;
            }
        }
        this.maxStack = i12;
    }

    private void endCurrentBasicBlockWithNoSuccessor() {
        int i11 = this.compute;
        if (i11 == 4) {
            Label label = new Label();
            label.f27395g = new Frame(label);
            ByteVector byteVector = this.code;
            label.g(byteVector.f27349a, byteVector.f27350b);
            this.lastBasicBlock.f27396h = label;
            this.lastBasicBlock = label;
            this.currentBasicBlock = null;
        } else if (i11 == 1) {
            this.currentBasicBlock.f27393e = (short) this.maxRelativeStackSize;
            this.currentBasicBlock = null;
        }
    }

    private void putAbstractTypes(int i11, int i12) {
        while (i11 < i12) {
            Frame.h(this.symbolTable, this.currentFrame[i11], this.stackMapTableEntries);
            i11++;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0091  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00fe  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void putFrame() {
        /*
            r16 = this;
            r0 = r16
            int[] r1 = r0.currentFrame
            r2 = 1
            r3 = r1[r2]
            r4 = 2
            r1 = r1[r4]
            net.bytebuddy.jar.asm.SymbolTable r4 = r0.symbolTable
            int r4 = r4.z()
            r5 = 50
            r6 = 0
            r7 = 3
            if (r4 >= r5) goto L_0x0031
            net.bytebuddy.jar.asm.ByteVector r2 = r0.stackMapTableEntries
            int[] r4 = r0.currentFrame
            r4 = r4[r6]
            net.bytebuddy.jar.asm.ByteVector r2 = r2.putShort(r4)
            r2.putShort(r3)
            int r3 = r3 + r7
            r0.putAbstractTypes(r7, r3)
            net.bytebuddy.jar.asm.ByteVector r2 = r0.stackMapTableEntries
            r2.putShort(r1)
            int r1 = r1 + r3
            r0.putAbstractTypes(r3, r1)
            return
        L_0x0031:
            int r4 = r0.stackMapTableNumberOfEntries
            if (r4 != 0) goto L_0x003a
            int[] r4 = r0.currentFrame
            r4 = r4[r6]
            goto L_0x0044
        L_0x003a:
            int[] r4 = r0.currentFrame
            r4 = r4[r6]
            int[] r5 = r0.previousFrame
            r5 = r5[r6]
            int r4 = r4 - r5
            int r4 = r4 - r2
        L_0x0044:
            int[] r5 = r0.previousFrame
            r5 = r5[r2]
            int r8 = r3 - r5
            r9 = 252(0xfc, float:3.53E-43)
            r10 = 248(0xf8, float:3.48E-43)
            r11 = 247(0xf7, float:3.46E-43)
            r12 = 64
            r13 = 255(0xff, float:3.57E-43)
            r14 = 251(0xfb, float:3.52E-43)
            if (r1 != 0) goto L_0x0066
            switch(r8) {
                case -3: goto L_0x0064;
                case -2: goto L_0x0064;
                case -1: goto L_0x0064;
                case 0: goto L_0x005e;
                case 1: goto L_0x005c;
                case 2: goto L_0x005c;
                case 3: goto L_0x005c;
                default: goto L_0x005b;
            }
        L_0x005b:
            goto L_0x0072
        L_0x005c:
            r2 = r9
            goto L_0x0073
        L_0x005e:
            if (r4 >= r12) goto L_0x0062
            r2 = r6
            goto L_0x0073
        L_0x0062:
            r2 = r14
            goto L_0x0073
        L_0x0064:
            r2 = r10
            goto L_0x0073
        L_0x0066:
            if (r8 != 0) goto L_0x0072
            if (r1 != r2) goto L_0x0072
            r2 = 63
            if (r4 >= r2) goto L_0x0070
            r2 = r12
            goto L_0x0073
        L_0x0070:
            r2 = r11
            goto L_0x0073
        L_0x0072:
            r2 = r13
        L_0x0073:
            if (r2 == r13) goto L_0x008f
            r15 = r7
        L_0x0076:
            if (r6 >= r5) goto L_0x008f
            if (r6 >= r3) goto L_0x008f
            int[] r7 = r0.currentFrame
            r7 = r7[r15]
            int[] r13 = r0.previousFrame
            r13 = r13[r15]
            if (r7 == r13) goto L_0x0087
            r2 = 255(0xff, float:3.57E-43)
            goto L_0x008f
        L_0x0087:
            int r15 = r15 + 1
            int r6 = r6 + 1
            r7 = 3
            r13 = 255(0xff, float:3.57E-43)
            goto L_0x0076
        L_0x008f:
            if (r2 == 0) goto L_0x00fe
            if (r2 == r12) goto L_0x00f0
            if (r2 == r11) goto L_0x00df
            if (r2 == r10) goto L_0x00d4
            if (r2 == r14) goto L_0x00ca
            if (r2 == r9) goto L_0x00b9
            net.bytebuddy.jar.asm.ByteVector r2 = r0.stackMapTableEntries
            r5 = 255(0xff, float:3.57E-43)
            net.bytebuddy.jar.asm.ByteVector r2 = r2.putByte(r5)
            net.bytebuddy.jar.asm.ByteVector r2 = r2.putShort(r4)
            r2.putShort(r3)
            r2 = 3
            int r3 = r3 + r2
            r0.putAbstractTypes(r2, r3)
            net.bytebuddy.jar.asm.ByteVector r2 = r0.stackMapTableEntries
            r2.putShort(r1)
            int r1 = r1 + r3
            r0.putAbstractTypes(r3, r1)
            goto L_0x0103
        L_0x00b9:
            r2 = 3
            net.bytebuddy.jar.asm.ByteVector r1 = r0.stackMapTableEntries
            int r8 = r8 + r14
            net.bytebuddy.jar.asm.ByteVector r1 = r1.putByte(r8)
            r1.putShort(r4)
            int r5 = r5 + r2
            int r3 = r3 + r2
            r0.putAbstractTypes(r5, r3)
            goto L_0x0103
        L_0x00ca:
            net.bytebuddy.jar.asm.ByteVector r1 = r0.stackMapTableEntries
            net.bytebuddy.jar.asm.ByteVector r1 = r1.putByte(r14)
            r1.putShort(r4)
            goto L_0x0103
        L_0x00d4:
            net.bytebuddy.jar.asm.ByteVector r1 = r0.stackMapTableEntries
            int r8 = r8 + r14
            net.bytebuddy.jar.asm.ByteVector r1 = r1.putByte(r8)
            r1.putShort(r4)
            goto L_0x0103
        L_0x00df:
            net.bytebuddy.jar.asm.ByteVector r1 = r0.stackMapTableEntries
            net.bytebuddy.jar.asm.ByteVector r1 = r1.putByte(r11)
            r1.putShort(r4)
            int r1 = r3 + 3
            int r3 = r3 + 4
            r0.putAbstractTypes(r1, r3)
            goto L_0x0103
        L_0x00f0:
            net.bytebuddy.jar.asm.ByteVector r1 = r0.stackMapTableEntries
            int r4 = r4 + r12
            r1.putByte(r4)
            int r1 = r3 + 3
            int r3 = r3 + 4
            r0.putAbstractTypes(r1, r3)
            goto L_0x0103
        L_0x00fe:
            net.bytebuddy.jar.asm.ByteVector r1 = r0.stackMapTableEntries
            r1.putByte(r4)
        L_0x0103:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.jar.asm.MethodWriter.putFrame():void");
    }

    private void putFrameType(Object obj) {
        if (obj instanceof Integer) {
            this.stackMapTableEntries.putByte(((Integer) obj).intValue());
        } else if (obj instanceof String) {
            this.stackMapTableEntries.putByte(7).putShort(this.symbolTable.c((String) obj).f27406a);
        } else {
            this.stackMapTableEntries.putByte(8).putShort(((Label) obj).f27390b);
        }
    }

    private void visitSwitchInsn(Label label, Label[] labelArr) {
        Label label2 = this.currentBasicBlock;
        if (label2 != null) {
            int i11 = this.compute;
            if (i11 == 4) {
                label2.f27395g.c(Opcodes.LOOKUPSWITCH, 0, (Symbol) null, (SymbolTable) null);
                addSuccessorToCurrentBasicBlock(0, label);
                Label d11 = label.d();
                d11.f27389a = (short) (d11.f27389a | 2);
                for (Label label3 : labelArr) {
                    addSuccessorToCurrentBasicBlock(0, label3);
                    Label d12 = label3.d();
                    d12.f27389a = (short) (d12.f27389a | 2);
                }
            } else if (i11 == 1) {
                int i12 = this.relativeStackSize - 1;
                this.relativeStackSize = i12;
                addSuccessorToCurrentBasicBlock(i12, label);
                for (Label addSuccessorToCurrentBasicBlock : labelArr) {
                    addSuccessorToCurrentBasicBlock(this.relativeStackSize, addSuccessorToCurrentBasicBlock);
                }
            }
            endCurrentBasicBlockWithNoSuccessor();
        }
    }

    public boolean a(ClassReader classReader, boolean z11, boolean z12, int i11, int i12, int i13) {
        boolean z13;
        boolean z14;
        if (classReader == this.symbolTable.A() && i11 == this.descriptorIndex && i12 == this.signatureIndex) {
            if ((this.accessFlags & 131072) != 0) {
                z13 = true;
            } else {
                z13 = false;
            }
            if (z12 == z13) {
                if (this.symbolTable.z() >= 49 || (this.accessFlags & 4096) == 0) {
                    z14 = false;
                } else {
                    z14 = true;
                }
                if (z11 != z14) {
                    return false;
                }
                if (i13 == 0) {
                    if (this.numberOfExceptions != 0) {
                        return false;
                    }
                } else if (classReader.readUnsignedShort(i13) == this.numberOfExceptions) {
                    int i14 = i13 + 2;
                    for (int i15 = 0; i15 < this.numberOfExceptions; i15++) {
                        if (classReader.readUnsignedShort(i14) != this.exceptionIndexTable[i15]) {
                            return false;
                        }
                        i14 += 2;
                    }
                }
                return true;
            }
        }
        return false;
    }

    public final void b(Attribute.Set set) {
        set.a(this.firstAttribute);
        set.a(this.firstCodeAttribute);
    }

    public int c() {
        int i11;
        boolean z11;
        String str;
        if (this.sourceOffset != 0) {
            return this.sourceLength + 6;
        }
        int i12 = this.code.f27350b;
        if (i12 <= 0) {
            i11 = 8;
        } else if (i12 <= 65535) {
            this.symbolTable.r(AttributeLayout.ATTRIBUTE_CODE);
            i11 = this.code.f27350b + 16 + Handler.b(this.firstHandler) + 8;
            if (this.stackMapTableEntries != null) {
                if (this.symbolTable.z() >= 50) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                SymbolTable symbolTable2 = this.symbolTable;
                if (z11) {
                    str = "StackMapTable";
                } else {
                    str = "StackMap";
                }
                symbolTable2.r(str);
                i11 += this.stackMapTableEntries.f27350b + 8;
            }
            if (this.lineNumberTable != null) {
                this.symbolTable.r(AttributeLayout.ATTRIBUTE_LINE_NUMBER_TABLE);
                i11 += this.lineNumberTable.f27350b + 8;
            }
            if (this.localVariableTable != null) {
                this.symbolTable.r(AttributeLayout.ATTRIBUTE_LOCAL_VARIABLE_TABLE);
                i11 += this.localVariableTable.f27350b + 8;
            }
            if (this.localVariableTypeTable != null) {
                this.symbolTable.r(AttributeLayout.ATTRIBUTE_LOCAL_VARIABLE_TYPE_TABLE);
                i11 += this.localVariableTypeTable.f27350b + 8;
            }
            AnnotationWriter annotationWriter = this.lastCodeRuntimeVisibleTypeAnnotation;
            if (annotationWriter != null) {
                i11 += annotationWriter.a("RuntimeVisibleTypeAnnotations");
            }
            AnnotationWriter annotationWriter2 = this.lastCodeRuntimeInvisibleTypeAnnotation;
            if (annotationWriter2 != null) {
                i11 += annotationWriter2.a("RuntimeInvisibleTypeAnnotations");
            }
            Attribute attribute = this.firstCodeAttribute;
            if (attribute != null) {
                SymbolTable symbolTable3 = this.symbolTable;
                ByteVector byteVector = this.code;
                i11 += attribute.c(symbolTable3, byteVector.f27349a, byteVector.f27350b, this.maxStack, this.maxLocals);
            }
        } else {
            throw new MethodTooLargeException(this.symbolTable.w(), this.f27401name, this.descriptor, this.code.f27350b);
        }
        if (this.numberOfExceptions > 0) {
            this.symbolTable.r(AttributeLayout.ATTRIBUTE_EXCEPTIONS);
            i11 += (this.numberOfExceptions * 2) + 8;
        }
        int b11 = i11 + Attribute.b(this.symbolTable, this.accessFlags, this.signatureIndex) + AnnotationWriter.b(this.lastRuntimeVisibleAnnotation, this.lastRuntimeInvisibleAnnotation, this.lastRuntimeVisibleTypeAnnotation, this.lastRuntimeInvisibleTypeAnnotation);
        AnnotationWriter[] annotationWriterArr = this.lastRuntimeVisibleParameterAnnotations;
        if (annotationWriterArr != null) {
            int i13 = this.visibleAnnotableParameterCount;
            if (i13 == 0) {
                i13 = annotationWriterArr.length;
            }
            b11 += AnnotationWriter.c(AttributeLayout.ATTRIBUTE_RUNTIME_VISIBLE_PARAMETER_ANNOTATIONS, annotationWriterArr, i13);
        }
        AnnotationWriter[] annotationWriterArr2 = this.lastRuntimeInvisibleParameterAnnotations;
        if (annotationWriterArr2 != null) {
            int i14 = this.invisibleAnnotableParameterCount;
            if (i14 == 0) {
                i14 = annotationWriterArr2.length;
            }
            b11 += AnnotationWriter.c(AttributeLayout.ATTRIBUTE_RUNTIME_INVISIBLE_PARAMETER_ANNOTATIONS, annotationWriterArr2, i14);
        }
        if (this.defaultValue != null) {
            this.symbolTable.r(AttributeLayout.ATTRIBUTE_ANNOTATION_DEFAULT);
            b11 += this.defaultValue.f27350b + 6;
        }
        if (this.parameters != null) {
            this.symbolTable.r("MethodParameters");
            b11 += this.parameters.f27350b + 7;
        }
        Attribute attribute2 = this.firstAttribute;
        if (attribute2 != null) {
            return b11 + attribute2.a(this.symbolTable);
        }
        return b11;
    }

    public boolean d() {
        return this.hasAsmInstructions;
    }

    public boolean e() {
        return this.stackMapTableNumberOfEntries > 0;
    }

    public void f(ByteVector byteVector) {
        boolean z11;
        int i11;
        int i12;
        int i13;
        boolean z12;
        String str;
        if (this.symbolTable.z() < 49) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            i11 = 4096;
        } else {
            i11 = 0;
        }
        byteVector.putShort((~i11) & this.accessFlags).putShort(this.nameIndex).putShort(this.descriptorIndex);
        if (this.sourceOffset != 0) {
            byteVector.putByteArray(this.symbolTable.A().f27351a, this.sourceOffset, this.sourceLength);
            return;
        }
        if (this.code.f27350b > 0) {
            i12 = 1;
        } else {
            i12 = 0;
        }
        if (this.numberOfExceptions > 0) {
            i12++;
        }
        int i14 = this.accessFlags;
        if ((i14 & 4096) != 0 && z11) {
            i12++;
        }
        if (this.signatureIndex != 0) {
            i12++;
        }
        if ((131072 & i14) != 0) {
            i12++;
        }
        if (this.lastRuntimeVisibleAnnotation != null) {
            i12++;
        }
        if (this.lastRuntimeInvisibleAnnotation != null) {
            i12++;
        }
        if (this.lastRuntimeVisibleParameterAnnotations != null) {
            i12++;
        }
        if (this.lastRuntimeInvisibleParameterAnnotations != null) {
            i12++;
        }
        if (this.lastRuntimeVisibleTypeAnnotation != null) {
            i12++;
        }
        if (this.lastRuntimeInvisibleTypeAnnotation != null) {
            i12++;
        }
        if (this.defaultValue != null) {
            i12++;
        }
        if (this.parameters != null) {
            i12++;
        }
        Attribute attribute = this.firstAttribute;
        if (attribute != null) {
            i12 += attribute.d();
        }
        byteVector.putShort(i12);
        int i15 = this.code.f27350b;
        if (i15 > 0) {
            int b11 = i15 + 10 + Handler.b(this.firstHandler);
            ByteVector byteVector2 = this.stackMapTableEntries;
            if (byteVector2 != null) {
                b11 += byteVector2.f27350b + 8;
                i13 = 1;
            } else {
                i13 = 0;
            }
            ByteVector byteVector3 = this.lineNumberTable;
            if (byteVector3 != null) {
                b11 += byteVector3.f27350b + 8;
                i13++;
            }
            ByteVector byteVector4 = this.localVariableTable;
            if (byteVector4 != null) {
                b11 += byteVector4.f27350b + 8;
                i13++;
            }
            ByteVector byteVector5 = this.localVariableTypeTable;
            if (byteVector5 != null) {
                b11 += byteVector5.f27350b + 8;
                i13++;
            }
            AnnotationWriter annotationWriter = this.lastCodeRuntimeVisibleTypeAnnotation;
            if (annotationWriter != null) {
                b11 += annotationWriter.a("RuntimeVisibleTypeAnnotations");
                i13++;
            }
            AnnotationWriter annotationWriter2 = this.lastCodeRuntimeInvisibleTypeAnnotation;
            if (annotationWriter2 != null) {
                b11 += annotationWriter2.a("RuntimeInvisibleTypeAnnotations");
                i13++;
            }
            Attribute attribute2 = this.firstCodeAttribute;
            if (attribute2 != null) {
                SymbolTable symbolTable2 = this.symbolTable;
                ByteVector byteVector6 = this.code;
                b11 += attribute2.c(symbolTable2, byteVector6.f27349a, byteVector6.f27350b, this.maxStack, this.maxLocals);
                i13 += this.firstCodeAttribute.d();
            }
            ByteVector putInt = byteVector.putShort(this.symbolTable.r(AttributeLayout.ATTRIBUTE_CODE)).putInt(b11).putShort(this.maxStack).putShort(this.maxLocals).putInt(this.code.f27350b);
            ByteVector byteVector7 = this.code;
            putInt.putByteArray(byteVector7.f27349a, 0, byteVector7.f27350b);
            Handler.c(this.firstHandler, byteVector);
            byteVector.putShort(i13);
            if (this.stackMapTableEntries != null) {
                if (this.symbolTable.z() >= 50) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                SymbolTable symbolTable3 = this.symbolTable;
                if (z12) {
                    str = "StackMapTable";
                } else {
                    str = "StackMap";
                }
                ByteVector putShort = byteVector.putShort(symbolTable3.r(str)).putInt(this.stackMapTableEntries.f27350b + 2).putShort(this.stackMapTableNumberOfEntries);
                ByteVector byteVector8 = this.stackMapTableEntries;
                putShort.putByteArray(byteVector8.f27349a, 0, byteVector8.f27350b);
            }
            if (this.lineNumberTable != null) {
                ByteVector putShort2 = byteVector.putShort(this.symbolTable.r(AttributeLayout.ATTRIBUTE_LINE_NUMBER_TABLE)).putInt(this.lineNumberTable.f27350b + 2).putShort(this.lineNumberTableLength);
                ByteVector byteVector9 = this.lineNumberTable;
                putShort2.putByteArray(byteVector9.f27349a, 0, byteVector9.f27350b);
            }
            if (this.localVariableTable != null) {
                ByteVector putShort3 = byteVector.putShort(this.symbolTable.r(AttributeLayout.ATTRIBUTE_LOCAL_VARIABLE_TABLE)).putInt(this.localVariableTable.f27350b + 2).putShort(this.localVariableTableLength);
                ByteVector byteVector10 = this.localVariableTable;
                putShort3.putByteArray(byteVector10.f27349a, 0, byteVector10.f27350b);
            }
            if (this.localVariableTypeTable != null) {
                ByteVector putShort4 = byteVector.putShort(this.symbolTable.r(AttributeLayout.ATTRIBUTE_LOCAL_VARIABLE_TYPE_TABLE)).putInt(this.localVariableTypeTable.f27350b + 2).putShort(this.localVariableTypeTableLength);
                ByteVector byteVector11 = this.localVariableTypeTable;
                putShort4.putByteArray(byteVector11.f27349a, 0, byteVector11.f27350b);
            }
            AnnotationWriter annotationWriter3 = this.lastCodeRuntimeVisibleTypeAnnotation;
            if (annotationWriter3 != null) {
                annotationWriter3.f(this.symbolTable.r("RuntimeVisibleTypeAnnotations"), byteVector);
            }
            AnnotationWriter annotationWriter4 = this.lastCodeRuntimeInvisibleTypeAnnotation;
            if (annotationWriter4 != null) {
                annotationWriter4.f(this.symbolTable.r("RuntimeInvisibleTypeAnnotations"), byteVector);
            }
            Attribute attribute3 = this.firstCodeAttribute;
            if (attribute3 != null) {
                SymbolTable symbolTable4 = this.symbolTable;
                ByteVector byteVector12 = this.code;
                attribute3.g(symbolTable4, byteVector12.f27349a, byteVector12.f27350b, this.maxStack, this.maxLocals, byteVector);
            }
        }
        if (this.numberOfExceptions > 0) {
            byteVector.putShort(this.symbolTable.r(AttributeLayout.ATTRIBUTE_EXCEPTIONS)).putInt((this.numberOfExceptions * 2) + 2).putShort(this.numberOfExceptions);
            for (int putShort5 : this.exceptionIndexTable) {
                byteVector.putShort(putShort5);
            }
        }
        Attribute.e(this.symbolTable, this.accessFlags, this.signatureIndex, byteVector);
        AnnotationWriter.g(this.symbolTable, this.lastRuntimeVisibleAnnotation, this.lastRuntimeInvisibleAnnotation, this.lastRuntimeVisibleTypeAnnotation, this.lastRuntimeInvisibleTypeAnnotation, byteVector);
        if (this.lastRuntimeVisibleParameterAnnotations != null) {
            int r11 = this.symbolTable.r(AttributeLayout.ATTRIBUTE_RUNTIME_VISIBLE_PARAMETER_ANNOTATIONS);
            AnnotationWriter[] annotationWriterArr = this.lastRuntimeVisibleParameterAnnotations;
            int i16 = this.visibleAnnotableParameterCount;
            if (i16 == 0) {
                i16 = annotationWriterArr.length;
            }
            AnnotationWriter.h(r11, annotationWriterArr, i16, byteVector);
        }
        if (this.lastRuntimeInvisibleParameterAnnotations != null) {
            int r12 = this.symbolTable.r(AttributeLayout.ATTRIBUTE_RUNTIME_INVISIBLE_PARAMETER_ANNOTATIONS);
            AnnotationWriter[] annotationWriterArr2 = this.lastRuntimeInvisibleParameterAnnotations;
            int i17 = this.invisibleAnnotableParameterCount;
            if (i17 == 0) {
                i17 = annotationWriterArr2.length;
            }
            AnnotationWriter.h(r12, annotationWriterArr2, i17, byteVector);
        }
        if (this.defaultValue != null) {
            ByteVector putInt2 = byteVector.putShort(this.symbolTable.r(AttributeLayout.ATTRIBUTE_ANNOTATION_DEFAULT)).putInt(this.defaultValue.f27350b);
            ByteVector byteVector13 = this.defaultValue;
            putInt2.putByteArray(byteVector13.f27349a, 0, byteVector13.f27350b);
        }
        if (this.parameters != null) {
            ByteVector putByte = byteVector.putShort(this.symbolTable.r("MethodParameters")).putInt(this.parameters.f27350b + 1).putByte(this.parametersCount);
            ByteVector byteVector14 = this.parameters;
            putByte.putByteArray(byteVector14.f27349a, 0, byteVector14.f27350b);
        }
        Attribute attribute4 = this.firstAttribute;
        if (attribute4 != null) {
            attribute4.f(this.symbolTable, byteVector);
        }
    }

    public void g(int i11, int i12) {
        this.sourceOffset = i11 + 6;
        this.sourceLength = i12 - 6;
    }

    public void h(int i11, int i12) {
        this.currentFrame[i11] = i12;
    }

    public void i() {
        if (this.previousFrame != null) {
            if (this.stackMapTableEntries == null) {
                this.stackMapTableEntries = new ByteVector();
            }
            putFrame();
            this.stackMapTableNumberOfEntries++;
        }
        this.previousFrame = this.currentFrame;
        this.currentFrame = null;
    }

    public int j(int i11, int i12, int i13) {
        int i14 = i12 + 3 + i13;
        int[] iArr = this.currentFrame;
        if (iArr == null || iArr.length < i14) {
            this.currentFrame = new int[i14];
        }
        int[] iArr2 = this.currentFrame;
        iArr2[0] = i11;
        iArr2[1] = i12;
        iArr2[2] = i13;
        return 3;
    }

    public void visitAnnotableParameterCount(int i11, boolean z11) {
        if (z11) {
            this.visibleAnnotableParameterCount = i11;
        } else {
            this.invisibleAnnotableParameterCount = i11;
        }
    }

    public AnnotationVisitor visitAnnotation(String str, boolean z11) {
        if (z11) {
            AnnotationWriter e11 = AnnotationWriter.e(this.symbolTable, str, this.lastRuntimeVisibleAnnotation);
            this.lastRuntimeVisibleAnnotation = e11;
            return e11;
        }
        AnnotationWriter e12 = AnnotationWriter.e(this.symbolTable, str, this.lastRuntimeInvisibleAnnotation);
        this.lastRuntimeInvisibleAnnotation = e12;
        return e12;
    }

    public AnnotationVisitor visitAnnotationDefault() {
        ByteVector byteVector = new ByteVector();
        this.defaultValue = byteVector;
        return new AnnotationWriter(this.symbolTable, false, byteVector, (AnnotationWriter) null);
    }

    public void visitAttribute(Attribute attribute) {
        if (attribute.isCodeAttribute()) {
            attribute.f27348a = this.firstCodeAttribute;
            this.firstCodeAttribute = attribute;
            return;
        }
        attribute.f27348a = this.firstAttribute;
        this.firstAttribute = attribute;
    }

    public void visitCode() {
    }

    public void visitEnd() {
    }

    public void visitFieldInsn(int i11, String str, String str2, String str3) {
        int i12;
        int i13;
        this.lastBytecodeOffset = this.code.f27350b;
        Symbol f11 = this.symbolTable.f(str, str2, str3);
        this.code.d(i11, f11.f27406a);
        Label label = this.currentBasicBlock;
        if (label != null) {
            int i14 = this.compute;
            int i15 = 0;
            if (i14 == 4 || i14 == 3) {
                label.f27395g.c(i11, 0, f11, this.symbolTable);
                return;
            }
            char charAt = str3.charAt(0);
            int i16 = 1;
            int i17 = -2;
            switch (i11) {
                case Opcodes.GETSTATIC:
                    int i18 = this.relativeStackSize;
                    if (charAt == 'D' || charAt == 'J') {
                        i16 = 2;
                    }
                    i12 = i18 + i16;
                    break;
                case Opcodes.PUTSTATIC:
                    i13 = this.relativeStackSize;
                    if (!(charAt == 'D' || charAt == 'J')) {
                        i17 = -1;
                        break;
                    }
                case 180:
                    int i19 = this.relativeStackSize;
                    if (charAt == 'D' || charAt == 'J') {
                        i15 = 1;
                    }
                    i12 = i19 + i15;
                    break;
                default:
                    i13 = this.relativeStackSize;
                    if (charAt == 'D' || charAt == 'J') {
                        i17 = -3;
                        break;
                    }
            }
            i12 = i13 + i17;
            if (i12 > this.maxRelativeStackSize) {
                this.maxRelativeStackSize = i12;
            }
            this.relativeStackSize = i12;
        }
    }

    public void visitFrame(int i11, int i12, Object[] objArr, int i13, Object[] objArr2) {
        int i14;
        int i15 = i11;
        int i16 = i12;
        int i17 = i13;
        int i18 = this.compute;
        if (i18 != 4) {
            if (i18 == 3) {
                Label label = this.currentBasicBlock;
                Frame frame = label.f27395g;
                if (frame == null) {
                    label.f27395g = new CurrentFrame(label);
                    this.currentBasicBlock.f27395g.j(this.symbolTable, this.accessFlags, this.descriptor, i12);
                    this.currentBasicBlock.f27395g.a(this);
                } else {
                    if (i15 == -1) {
                        frame.i(this.symbolTable, i12, objArr, i13, objArr2);
                    }
                    this.currentBasicBlock.f27395g.a(this);
                }
            } else if (i15 == -1) {
                if (this.previousFrame == null) {
                    Frame frame2 = new Frame(new Label());
                    frame2.j(this.symbolTable, this.accessFlags, this.descriptor, Type.getArgumentsAndReturnSizes(this.descriptor) >> 2);
                    frame2.a(this);
                }
                this.currentLocals = i16;
                int j11 = j(this.code.f27350b, i12, i17);
                int i19 = 0;
                while (i19 < i16) {
                    this.currentFrame[j11] = Frame.d(this.symbolTable, objArr[i19]);
                    i19++;
                    j11++;
                }
                int i21 = 0;
                while (i21 < i17) {
                    this.currentFrame[j11] = Frame.d(this.symbolTable, objArr2[i21]);
                    i21++;
                    j11++;
                }
                i();
            } else if (this.symbolTable.z() >= 50) {
                if (this.stackMapTableEntries == null) {
                    this.stackMapTableEntries = new ByteVector();
                    i14 = this.code.f27350b;
                } else {
                    i14 = (this.code.f27350b - this.previousFrameOffset) - 1;
                    if (i14 < 0) {
                        if (i15 != 3) {
                            throw new IllegalStateException();
                        }
                        return;
                    }
                }
                if (i15 == 0) {
                    this.currentLocals = i16;
                    this.stackMapTableEntries.putByte(255).putShort(i14).putShort(i12);
                    for (int i22 = 0; i22 < i16; i22++) {
                        putFrameType(objArr[i22]);
                    }
                    this.stackMapTableEntries.putShort(i17);
                    for (int i23 = 0; i23 < i17; i23++) {
                        putFrameType(objArr2[i23]);
                    }
                } else if (i15 == 1) {
                    this.currentLocals += i16;
                    this.stackMapTableEntries.putByte(i16 + 251).putShort(i14);
                    for (int i24 = 0; i24 < i16; i24++) {
                        putFrameType(objArr[i24]);
                    }
                } else if (i15 == 2) {
                    this.currentLocals -= i16;
                    this.stackMapTableEntries.putByte(251 - i16).putShort(i14);
                } else if (i15 != 3) {
                    if (i15 == 4) {
                        if (i14 < 64) {
                            this.stackMapTableEntries.putByte(i14 + 64);
                        } else {
                            this.stackMapTableEntries.putByte(247).putShort(i14);
                        }
                        putFrameType(objArr2[0]);
                    } else {
                        throw new IllegalArgumentException();
                    }
                } else if (i14 < 64) {
                    this.stackMapTableEntries.putByte(i14);
                } else {
                    this.stackMapTableEntries.putByte(251).putShort(i14);
                }
                this.previousFrameOffset = this.code.f27350b;
                this.stackMapTableNumberOfEntries++;
            } else {
                throw new IllegalArgumentException("Class versions V1_5 or less must use F_NEW frames.");
            }
            if (this.compute == 2) {
                this.relativeStackSize = i17;
                for (int i25 = 0; i25 < i17; i25++) {
                    Integer num = objArr2[i25];
                    if (num == Opcodes.LONG || num == Opcodes.DOUBLE) {
                        this.relativeStackSize++;
                    }
                }
                int i26 = this.relativeStackSize;
                if (i26 > this.maxRelativeStackSize) {
                    this.maxRelativeStackSize = i26;
                }
            }
            this.maxStack = Math.max(this.maxStack, i17);
            this.maxLocals = Math.max(this.maxLocals, this.currentLocals);
        }
    }

    public void visitIincInsn(int i11, int i12) {
        int i13;
        int i14;
        ByteVector byteVector = this.code;
        this.lastBytecodeOffset = byteVector.f27350b;
        if (i11 > 255 || i12 > 127 || i12 < -128) {
            byteVector.putByte(196).d(Opcodes.IINC, i11).putShort(i12);
        } else {
            byteVector.putByte(Opcodes.IINC).b(i11, i12);
        }
        Label label = this.currentBasicBlock;
        if (label != null && ((i14 = this.compute) == 4 || i14 == 3)) {
            label.f27395g.c(Opcodes.IINC, i11, (Symbol) null, (SymbolTable) null);
        }
        if (this.compute != 0 && (i13 = i11 + 1) > this.maxLocals) {
            this.maxLocals = i13;
        }
    }

    public void visitInsn(int i11) {
        ByteVector byteVector = this.code;
        this.lastBytecodeOffset = byteVector.f27350b;
        byteVector.putByte(i11);
        Label label = this.currentBasicBlock;
        if (label != null) {
            int i12 = this.compute;
            if (i12 == 4 || i12 == 3) {
                label.f27395g.c(i11, 0, (Symbol) null, (SymbolTable) null);
            } else {
                int i13 = this.relativeStackSize + STACK_SIZE_DELTA[i11];
                if (i13 > this.maxRelativeStackSize) {
                    this.maxRelativeStackSize = i13;
                }
                this.relativeStackSize = i13;
            }
            if ((i11 >= 172 && i11 <= 177) || i11 == 191) {
                endCurrentBasicBlockWithNoSuccessor();
            }
        }
    }

    public AnnotationVisitor visitInsnAnnotation(int i11, TypePath typePath, String str, boolean z11) {
        if (z11) {
            AnnotationWriter d11 = AnnotationWriter.d(this.symbolTable, (i11 & -16776961) | (this.lastBytecodeOffset << 8), typePath, str, this.lastCodeRuntimeVisibleTypeAnnotation);
            this.lastCodeRuntimeVisibleTypeAnnotation = d11;
            return d11;
        }
        AnnotationWriter d12 = AnnotationWriter.d(this.symbolTable, (i11 & -16776961) | (this.lastBytecodeOffset << 8), typePath, str, this.lastCodeRuntimeInvisibleTypeAnnotation);
        this.lastCodeRuntimeInvisibleTypeAnnotation = d12;
        return d12;
    }

    public void visitIntInsn(int i11, int i12) {
        ByteVector byteVector = this.code;
        this.lastBytecodeOffset = byteVector.f27350b;
        if (i11 == 17) {
            byteVector.d(i11, i12);
        } else {
            byteVector.b(i11, i12);
        }
        Label label = this.currentBasicBlock;
        if (label != null) {
            int i13 = this.compute;
            if (i13 == 4 || i13 == 3) {
                label.f27395g.c(i11, i12, (Symbol) null, (SymbolTable) null);
            } else if (i11 != 188) {
                int i14 = this.relativeStackSize + 1;
                if (i14 > this.maxRelativeStackSize) {
                    this.maxRelativeStackSize = i14;
                }
                this.relativeStackSize = i14;
            }
        }
    }

    public void visitInvokeDynamicInsn(String str, String str2, Handle handle, Object... objArr) {
        this.lastBytecodeOffset = this.code.f27350b;
        Symbol i11 = this.symbolTable.i(str, str2, handle, objArr);
        this.code.d(Opcodes.INVOKEDYNAMIC, i11.f27406a);
        this.code.putShort(0);
        Label label = this.currentBasicBlock;
        if (label != null) {
            int i12 = this.compute;
            if (i12 == 4 || i12 == 3) {
                label.f27395g.c(Opcodes.INVOKEDYNAMIC, 0, i11, this.symbolTable);
                return;
            }
            int a11 = i11.a();
            int i13 = this.relativeStackSize + ((a11 & 3) - (a11 >> 2)) + 1;
            if (i13 > this.maxRelativeStackSize) {
                this.maxRelativeStackSize = i13;
            }
            this.relativeStackSize = i13;
        }
    }

    public void visitJumpInsn(int i11, Label label) {
        int i12;
        boolean z11;
        int i13;
        ByteVector byteVector = this.code;
        int i14 = byteVector.f27350b;
        this.lastBytecodeOffset = i14;
        if (i11 >= 200) {
            i12 = i11 - 33;
        } else {
            i12 = i11;
        }
        if ((label.f27389a & 4) == 0 || label.f27390b - i14 >= -32768) {
            if (i12 != i11) {
                byteVector.putByte(i11);
                ByteVector byteVector2 = this.code;
                label.f(byteVector2, byteVector2.f27350b - 1, true);
            } else {
                byteVector.putByte(i12);
                ByteVector byteVector3 = this.code;
                label.f(byteVector3, byteVector3.f27350b - 1, false);
            }
            z11 = false;
        } else {
            if (i12 == 167) {
                byteVector.putByte(200);
            } else if (i12 == 168) {
                byteVector.putByte(201);
            } else {
                if (i12 >= 198) {
                    i13 = i12 ^ 1;
                } else {
                    i13 = ((i12 + 1) ^ 1) - 1;
                }
                byteVector.putByte(i13);
                this.code.putShort(8);
                this.code.putByte(220);
                this.hasAsmInstructions = true;
                z11 = true;
                ByteVector byteVector4 = this.code;
                label.f(byteVector4, byteVector4.f27350b - 1, true);
            }
            z11 = false;
            ByteVector byteVector42 = this.code;
            label.f(byteVector42, byteVector42.f27350b - 1, true);
        }
        Label label2 = this.currentBasicBlock;
        if (label2 != null) {
            int i15 = this.compute;
            Label label3 = null;
            if (i15 == 4) {
                label2.f27395g.c(i12, 0, (Symbol) null, (SymbolTable) null);
                Label d11 = label.d();
                d11.f27389a = (short) (d11.f27389a | 2);
                addSuccessorToCurrentBasicBlock(0, label);
                if (i12 != 167) {
                    label3 = new Label();
                }
            } else if (i15 == 3) {
                label2.f27395g.c(i12, 0, (Symbol) null, (SymbolTable) null);
            } else if (i15 == 2) {
                this.relativeStackSize += STACK_SIZE_DELTA[i12];
            } else if (i12 == 168) {
                short s11 = label.f27389a;
                if ((s11 & 32) == 0) {
                    label.f27389a = (short) (s11 | 32);
                    this.hasSubroutines = true;
                }
                label2.f27389a = (short) (label2.f27389a | 16);
                addSuccessorToCurrentBasicBlock(this.relativeStackSize + 1, label);
                label3 = new Label();
            } else {
                int i16 = this.relativeStackSize + STACK_SIZE_DELTA[i12];
                this.relativeStackSize = i16;
                addSuccessorToCurrentBasicBlock(i16, label);
            }
            if (label3 != null) {
                if (z11) {
                    label3.f27389a = (short) (label3.f27389a | 2);
                }
                visitLabel(label3);
            }
            if (i12 == 167) {
                endCurrentBasicBlockWithNoSuccessor();
            }
        }
    }

    public void visitLabel(Label label) {
        boolean z11 = this.hasAsmInstructions;
        ByteVector byteVector = this.code;
        this.hasAsmInstructions = z11 | label.g(byteVector.f27349a, byteVector.f27350b);
        short s11 = label.f27389a;
        if ((s11 & 1) == 0) {
            int i11 = this.compute;
            if (i11 == 4) {
                Label label2 = this.currentBasicBlock;
                if (label2 != null) {
                    if (label.f27390b == label2.f27390b) {
                        label2.f27389a = (short) ((s11 & 2) | label2.f27389a);
                        label.f27395g = label2.f27395g;
                        return;
                    }
                    addSuccessorToCurrentBasicBlock(0, label);
                }
                Label label3 = this.lastBasicBlock;
                if (label3 != null) {
                    if (label.f27390b == label3.f27390b) {
                        label3.f27389a = (short) (label3.f27389a | (label.f27389a & 2));
                        label.f27395g = label3.f27395g;
                        this.currentBasicBlock = label3;
                        return;
                    }
                    label3.f27396h = label;
                }
                this.lastBasicBlock = label;
                this.currentBasicBlock = label;
                label.f27395g = new Frame(label);
            } else if (i11 == 3) {
                Label label4 = this.currentBasicBlock;
                if (label4 == null) {
                    this.currentBasicBlock = label;
                } else {
                    label4.f27395g.f27380a = label;
                }
            } else if (i11 == 1) {
                Label label5 = this.currentBasicBlock;
                if (label5 != null) {
                    label5.f27393e = (short) this.maxRelativeStackSize;
                    addSuccessorToCurrentBasicBlock(this.relativeStackSize, label);
                }
                this.currentBasicBlock = label;
                this.relativeStackSize = 0;
                this.maxRelativeStackSize = 0;
                Label label6 = this.lastBasicBlock;
                if (label6 != null) {
                    label6.f27396h = label;
                }
                this.lastBasicBlock = label;
            } else if (i11 == 2 && this.currentBasicBlock == null) {
                this.currentBasicBlock = label;
            }
        }
    }

    public void visitLdcInsn(Object obj) {
        boolean z11;
        char charAt;
        this.lastBytecodeOffset = this.code.f27350b;
        Symbol b11 = this.symbolTable.b(obj);
        int i11 = b11.f27406a;
        int i12 = b11.f27407b;
        int i13 = 1;
        if (i12 == 5 || i12 == 6 || (i12 == 17 && ((charAt = b11.f27410e.charAt(0)) == 'J' || charAt == 'D'))) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            this.code.d(20, i11);
        } else if (i11 >= 256) {
            this.code.d(19, i11);
        } else {
            this.code.b(18, i11);
        }
        Label label = this.currentBasicBlock;
        if (label != null) {
            int i14 = this.compute;
            if (i14 == 4 || i14 == 3) {
                label.f27395g.c(18, 0, b11, this.symbolTable);
                return;
            }
            int i15 = this.relativeStackSize;
            if (z11) {
                i13 = 2;
            }
            int i16 = i15 + i13;
            if (i16 > this.maxRelativeStackSize) {
                this.maxRelativeStackSize = i16;
            }
            this.relativeStackSize = i16;
        }
    }

    public void visitLineNumber(int i11, Label label) {
        if (this.lineNumberTable == null) {
            this.lineNumberTable = new ByteVector();
        }
        this.lineNumberTableLength++;
        this.lineNumberTable.putShort(label.f27390b);
        this.lineNumberTable.putShort(i11);
    }

    public void visitLocalVariable(String str, String str2, String str3, Label label, Label label2, int i11) {
        int i12 = 1;
        if (str3 != null) {
            if (this.localVariableTypeTable == null) {
                this.localVariableTypeTable = new ByteVector();
            }
            this.localVariableTypeTableLength++;
            this.localVariableTypeTable.putShort(label.f27390b).putShort(label2.f27390b - label.f27390b).putShort(this.symbolTable.r(str)).putShort(this.symbolTable.r(str3)).putShort(i11);
        }
        if (this.localVariableTable == null) {
            this.localVariableTable = new ByteVector();
        }
        this.localVariableTableLength++;
        this.localVariableTable.putShort(label.f27390b).putShort(label2.f27390b - label.f27390b).putShort(this.symbolTable.r(str)).putShort(this.symbolTable.r(str2)).putShort(i11);
        if (this.compute != 0) {
            char charAt = str2.charAt(0);
            if (charAt == 'J' || charAt == 'D') {
                i12 = 2;
            }
            int i13 = i11 + i12;
            if (i13 > this.maxLocals) {
                this.maxLocals = i13;
            }
        }
    }

    public AnnotationVisitor visitLocalVariableAnnotation(int i11, TypePath typePath, Label[] labelArr, Label[] labelArr2, int[] iArr, String str, boolean z11) {
        ByteVector byteVector = new ByteVector();
        byteVector.putByte(i11 >>> 24).putShort(labelArr.length);
        for (int i12 = 0; i12 < labelArr.length; i12++) {
            byteVector.putShort(labelArr[i12].f27390b).putShort(labelArr2[i12].f27390b - labelArr[i12].f27390b).putShort(iArr[i12]);
        }
        TypePath.a(typePath, byteVector);
        byteVector.putShort(this.symbolTable.r(str)).putShort(0);
        if (z11) {
            AnnotationWriter annotationWriter = new AnnotationWriter(this.symbolTable, true, byteVector, this.lastCodeRuntimeVisibleTypeAnnotation);
            this.lastCodeRuntimeVisibleTypeAnnotation = annotationWriter;
            return annotationWriter;
        }
        AnnotationWriter annotationWriter2 = new AnnotationWriter(this.symbolTable, true, byteVector, this.lastCodeRuntimeInvisibleTypeAnnotation);
        this.lastCodeRuntimeInvisibleTypeAnnotation = annotationWriter2;
        return annotationWriter2;
    }

    public void visitLookupSwitchInsn(Label label, int[] iArr, Label[] labelArr) {
        ByteVector byteVector = this.code;
        this.lastBytecodeOffset = byteVector.f27350b;
        byteVector.putByte(Opcodes.LOOKUPSWITCH).putByteArray((byte[]) null, 0, (4 - (this.code.f27350b % 4)) % 4);
        label.f(this.code, this.lastBytecodeOffset, true);
        this.code.putInt(labelArr.length);
        for (int i11 = 0; i11 < labelArr.length; i11++) {
            this.code.putInt(iArr[i11]);
            labelArr[i11].f(this.code, this.lastBytecodeOffset, true);
        }
        visitSwitchInsn(label, labelArr);
    }

    public void visitMaxs(int i11, int i12) {
        int i13 = this.compute;
        if (i13 == 4) {
            computeAllFrames();
        } else if (i13 == 1) {
            computeMaxStackAndLocal();
        } else if (i13 == 2) {
            this.maxStack = this.maxRelativeStackSize;
        } else {
            this.maxStack = i11;
            this.maxLocals = i12;
        }
    }

    public void visitMethodInsn(int i11, String str, String str2, String str3, boolean z11) {
        int i12;
        this.lastBytecodeOffset = this.code.f27350b;
        Symbol m11 = this.symbolTable.m(str, str2, str3, z11);
        if (i11 == 185) {
            this.code.d(Opcodes.INVOKEINTERFACE, m11.f27406a).b(m11.a() >> 2, 0);
        } else {
            this.code.d(i11, m11.f27406a);
        }
        Label label = this.currentBasicBlock;
        if (label != null) {
            int i13 = this.compute;
            if (i13 == 4 || i13 == 3) {
                label.f27395g.c(i11, 0, m11, this.symbolTable);
                return;
            }
            int a11 = m11.a();
            int i14 = (a11 & 3) - (a11 >> 2);
            if (i11 == 184) {
                i12 = this.relativeStackSize + i14 + 1;
            } else {
                i12 = this.relativeStackSize + i14;
            }
            if (i12 > this.maxRelativeStackSize) {
                this.maxRelativeStackSize = i12;
            }
            this.relativeStackSize = i12;
        }
    }

    public void visitMultiANewArrayInsn(String str, int i11) {
        this.lastBytecodeOffset = this.code.f27350b;
        Symbol c11 = this.symbolTable.c(str);
        this.code.d(Opcodes.MULTIANEWARRAY, c11.f27406a).putByte(i11);
        Label label = this.currentBasicBlock;
        if (label != null) {
            int i12 = this.compute;
            if (i12 == 4 || i12 == 3) {
                label.f27395g.c(Opcodes.MULTIANEWARRAY, i11, c11, this.symbolTable);
            } else {
                this.relativeStackSize += 1 - i11;
            }
        }
    }

    public void visitParameter(String str, int i11) {
        int i12;
        if (this.parameters == null) {
            this.parameters = new ByteVector();
        }
        this.parametersCount++;
        ByteVector byteVector = this.parameters;
        if (str == null) {
            i12 = 0;
        } else {
            i12 = this.symbolTable.r(str);
        }
        byteVector.putShort(i12).putShort(i11);
    }

    public AnnotationVisitor visitParameterAnnotation(int i11, String str, boolean z11) {
        if (z11) {
            if (this.lastRuntimeVisibleParameterAnnotations == null) {
                this.lastRuntimeVisibleParameterAnnotations = new AnnotationWriter[Type.getArgumentTypes(this.descriptor).length];
            }
            AnnotationWriter[] annotationWriterArr = this.lastRuntimeVisibleParameterAnnotations;
            AnnotationWriter e11 = AnnotationWriter.e(this.symbolTable, str, annotationWriterArr[i11]);
            annotationWriterArr[i11] = e11;
            return e11;
        }
        if (this.lastRuntimeInvisibleParameterAnnotations == null) {
            this.lastRuntimeInvisibleParameterAnnotations = new AnnotationWriter[Type.getArgumentTypes(this.descriptor).length];
        }
        AnnotationWriter[] annotationWriterArr2 = this.lastRuntimeInvisibleParameterAnnotations;
        AnnotationWriter e12 = AnnotationWriter.e(this.symbolTable, str, annotationWriterArr2[i11]);
        annotationWriterArr2[i11] = e12;
        return e12;
    }

    public void visitTableSwitchInsn(int i11, int i12, Label label, Label... labelArr) {
        ByteVector byteVector = this.code;
        this.lastBytecodeOffset = byteVector.f27350b;
        byteVector.putByte(Opcodes.TABLESWITCH).putByteArray((byte[]) null, 0, (4 - (this.code.f27350b % 4)) % 4);
        label.f(this.code, this.lastBytecodeOffset, true);
        this.code.putInt(i11).putInt(i12);
        for (Label f11 : labelArr) {
            f11.f(this.code, this.lastBytecodeOffset, true);
        }
        visitSwitchInsn(label, labelArr);
    }

    public AnnotationVisitor visitTryCatchAnnotation(int i11, TypePath typePath, String str, boolean z11) {
        if (z11) {
            AnnotationWriter d11 = AnnotationWriter.d(this.symbolTable, i11, typePath, str, this.lastCodeRuntimeVisibleTypeAnnotation);
            this.lastCodeRuntimeVisibleTypeAnnotation = d11;
            return d11;
        }
        AnnotationWriter d12 = AnnotationWriter.d(this.symbolTable, i11, typePath, str, this.lastCodeRuntimeInvisibleTypeAnnotation);
        this.lastCodeRuntimeInvisibleTypeAnnotation = d12;
        return d12;
    }

    public void visitTryCatchBlock(Label label, Label label2, Label label3, String str) {
        int i11;
        if (str != null) {
            i11 = this.symbolTable.c(str).f27406a;
        } else {
            i11 = 0;
        }
        Handler handler = new Handler(label, label2, label3, i11, str);
        if (this.firstHandler == null) {
            this.firstHandler = handler;
        } else {
            this.lastHandler.f27387f = handler;
        }
        this.lastHandler = handler;
    }

    public AnnotationVisitor visitTypeAnnotation(int i11, TypePath typePath, String str, boolean z11) {
        if (z11) {
            AnnotationWriter d11 = AnnotationWriter.d(this.symbolTable, i11, typePath, str, this.lastRuntimeVisibleTypeAnnotation);
            this.lastRuntimeVisibleTypeAnnotation = d11;
            return d11;
        }
        AnnotationWriter d12 = AnnotationWriter.d(this.symbolTable, i11, typePath, str, this.lastRuntimeInvisibleTypeAnnotation);
        this.lastRuntimeInvisibleTypeAnnotation = d12;
        return d12;
    }

    public void visitTypeInsn(int i11, String str) {
        this.lastBytecodeOffset = this.code.f27350b;
        Symbol c11 = this.symbolTable.c(str);
        this.code.d(i11, c11.f27406a);
        Label label = this.currentBasicBlock;
        if (label != null) {
            int i12 = this.compute;
            if (i12 == 4 || i12 == 3) {
                label.f27395g.c(i11, this.lastBytecodeOffset, c11, this.symbolTable);
            } else if (i11 == 187) {
                int i13 = this.relativeStackSize + 1;
                if (i13 > this.maxRelativeStackSize) {
                    this.maxRelativeStackSize = i13;
                }
                this.relativeStackSize = i13;
            }
        }
    }

    public void visitVarInsn(int i11, int i12) {
        int i13;
        int i14;
        ByteVector byteVector = this.code;
        this.lastBytecodeOffset = byteVector.f27350b;
        if (i12 < 4 && i11 != 169) {
            if (i11 < 54) {
                i14 = ((i11 - 21) << 2) + 26;
            } else {
                i14 = ((i11 - 54) << 2) + 59;
            }
            byteVector.putByte(i14 + i12);
        } else if (i12 >= 256) {
            byteVector.putByte(196).d(i11, i12);
        } else {
            byteVector.b(i11, i12);
        }
        Label label = this.currentBasicBlock;
        if (label != null) {
            int i15 = this.compute;
            if (i15 == 4 || i15 == 3) {
                label.f27395g.c(i11, i12, (Symbol) null, (SymbolTable) null);
            } else if (i11 == 169) {
                label.f27389a = (short) (label.f27389a | 64);
                label.f27392d = (short) this.relativeStackSize;
                endCurrentBasicBlockWithNoSuccessor();
            } else {
                int i16 = this.relativeStackSize + STACK_SIZE_DELTA[i11];
                if (i16 > this.maxRelativeStackSize) {
                    this.maxRelativeStackSize = i16;
                }
                this.relativeStackSize = i16;
            }
        }
        int i17 = this.compute;
        if (i17 != 0) {
            if (i11 == 22 || i11 == 24 || i11 == 55 || i11 == 57) {
                i13 = i12 + 2;
            } else {
                i13 = i12 + 1;
            }
            if (i13 > this.maxLocals) {
                this.maxLocals = i13;
            }
        }
        if (i11 >= 54 && i17 == 4 && this.firstHandler != null) {
            visitLabel(new Label());
        }
    }
}
