package net.bytebuddy.utility.visitor;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.implementation.bytecode.StackSize;
import net.bytebuddy.jar.asm.Handle;
import net.bytebuddy.jar.asm.Label;
import net.bytebuddy.jar.asm.MethodVisitor;
import net.bytebuddy.jar.asm.Opcodes;
import net.bytebuddy.jar.asm.Type;
import net.bytebuddy.utility.CompoundList;
import net.bytebuddy.utility.OpenedClassReader;

public class StackAwareMethodVisitor extends MethodVisitor {
    private static final int[] SIZE_CHANGE = new int[202];
    private List<StackSize> current = new ArrayList();
    private int freeIndex;
    private final Map<Label, List<StackSize>> sizes = new HashMap();

    /* renamed from: net.bytebuddy.utility.visitor.StackAwareMethodVisitor$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f27514a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                net.bytebuddy.implementation.bytecode.StackSize[] r0 = net.bytebuddy.implementation.bytecode.StackSize.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f27514a = r0
                net.bytebuddy.implementation.bytecode.StackSize r1 = net.bytebuddy.implementation.bytecode.StackSize.SINGLE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f27514a     // Catch:{ NoSuchFieldError -> 0x001d }
                net.bytebuddy.implementation.bytecode.StackSize r1 = net.bytebuddy.implementation.bytecode.StackSize.DOUBLE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.utility.visitor.StackAwareMethodVisitor.AnonymousClass1.<clinit>():void");
        }
    }

    static {
        int i11 = 0;
        while (true) {
            int[] iArr = SIZE_CHANGE;
            if (i11 < iArr.length) {
                iArr[i11] = "EFFFFFFFFGGFFFGGFFFEEFGFGFEEEEEEEEEEEEEEEEEEEEDEDEDDDDDCDCDEEEEEEEEEEEEEEEEEEEEBABABBBBDCFFFGGGEDCDCDCDCDCDCDCDCDCDCEEEEDDDDDDDCDCDCEFEFDDEEFFDEDEEEBDDBBDDDDDDCCCCCCCCEEEDDDCDCDEEEEEEEEEEFEEEEEEDDEEDDEE".charAt(i11) - 'E';
                i11++;
            } else {
                return;
            }
        }
    }

    public StackAwareMethodVisitor(MethodVisitor methodVisitor, MethodDescription methodDescription) {
        super(OpenedClassReader.ASM_API, methodVisitor);
        this.freeIndex = methodDescription.getStackSize();
    }

    private void adjustStack(int i11) {
        adjustStack(i11, 0);
    }

    private void doDrain(List<StackSize> list) {
        ListIterator<StackSize> listIterator = list.listIterator(list.size());
        while (listIterator.hasPrevious()) {
            StackSize previous = listIterator.previous();
            int i11 = AnonymousClass1.f27514a[previous.ordinal()];
            if (i11 == 1) {
                super.visitInsn(87);
            } else if (i11 == 2) {
                super.visitInsn(88);
            } else {
                throw new IllegalStateException("Unexpected stack size: " + previous);
            }
        }
    }

    public void drainStack() {
        doDrain(this.current);
    }

    public void register(Label label, List<StackSize> list) {
        this.sizes.put(label, list);
    }

    public void visitFieldInsn(int i11, String str, String str2, String str3) {
        int size = Type.getType(str3).getSize();
        switch (i11) {
            case Opcodes.GETSTATIC:
                adjustStack(size);
                break;
            case Opcodes.PUTSTATIC:
                adjustStack(-size);
                break;
            case 180:
                adjustStack(-1);
                adjustStack(size);
                break;
            case Opcodes.PUTFIELD:
                adjustStack((-size) - 1);
                break;
            default:
                throw new IllegalStateException("Unexpected opcode: " + i11);
        }
        super.visitFieldInsn(i11, str, str2, str3);
    }

    public void visitInsn(int i11) {
        if (i11 == 47 || i11 == 49) {
            adjustStack(-2);
            adjustStack(2);
        } else {
            if (i11 != 133) {
                if (i11 != 144) {
                    if (i11 != 191) {
                        if (i11 != 90) {
                            if (i11 != 91) {
                                if (i11 != 93) {
                                    if (i11 != 94) {
                                        switch (i11) {
                                            case 135:
                                                break;
                                            case Opcodes.L2I:
                                            case Opcodes.L2F:
                                                break;
                                            default:
                                                switch (i11) {
                                                    case Opcodes.F2L:
                                                    case Opcodes.F2D:
                                                        break;
                                                    case Opcodes.D2I:
                                                        break;
                                                    default:
                                                        switch (i11) {
                                                            case 172:
                                                            case Opcodes.LRETURN:
                                                            case Opcodes.FRETURN:
                                                            case Opcodes.DRETURN:
                                                            case Opcodes.ARETURN:
                                                            case Opcodes.RETURN:
                                                                break;
                                                            default:
                                                                adjustStack(SIZE_CHANGE[i11]);
                                                                break;
                                                        }
                                                }
                                        }
                                    }
                                }
                            }
                            int i12 = SIZE_CHANGE[i11];
                            adjustStack(i12, i12 + 2);
                        }
                        int i13 = SIZE_CHANGE[i11];
                        adjustStack(i13, i13 + 1);
                    }
                    this.current.clear();
                }
                adjustStack(-2);
                adjustStack(1);
            }
            adjustStack(-1);
            adjustStack(2);
        }
        super.visitInsn(i11);
    }

    public void visitIntInsn(int i11, int i12) {
        adjustStack(SIZE_CHANGE[i11]);
        super.visitIntInsn(i11, i12);
    }

    public void visitInvokeDynamicInsn(String str, String str2, Handle handle, Object... objArr) {
        int argumentsAndReturnSizes = Type.getArgumentsAndReturnSizes(str2);
        adjustStack((-(argumentsAndReturnSizes >> 2)) + 1);
        adjustStack(argumentsAndReturnSizes & 3);
        super.visitInvokeDynamicInsn(str, str2, handle, objArr);
    }

    public void visitJumpInsn(int i11, Label label) {
        List<StackSize> list;
        adjustStack(SIZE_CHANGE[i11]);
        Map<Label, List<StackSize>> map = this.sizes;
        if (i11 == 168) {
            list = CompoundList.of(this.current, StackSize.SINGLE);
        } else {
            list = this.current;
        }
        map.put(label, new ArrayList(list));
        if (i11 == 167) {
            this.current.clear();
        }
        super.visitJumpInsn(i11, label);
    }

    public void visitLabel(Label label) {
        List list = this.sizes.get(label);
        if (list != null) {
            this.current = new ArrayList(list);
        }
        super.visitLabel(label);
    }

    public void visitLdcInsn(Object obj) {
        int i11;
        if ((obj instanceof Long) || (obj instanceof Double)) {
            i11 = 2;
        } else {
            i11 = 1;
        }
        adjustStack(i11);
        super.visitLdcInsn(obj);
    }

    public void visitLineNumber(int i11, Label label) {
        super.visitLineNumber(i11, label);
    }

    public void visitLookupSwitchInsn(Label label, int[] iArr, Label[] labelArr) {
        adjustStack(-1);
        ArrayList arrayList = new ArrayList(this.current);
        this.sizes.put(label, arrayList);
        for (Label put : labelArr) {
            this.sizes.put(put, arrayList);
        }
        super.visitLookupSwitchInsn(label, iArr, labelArr);
    }

    public void visitMethodInsn(int i11, String str, String str2, String str3, boolean z11) {
        int i12;
        int argumentsAndReturnSizes = Type.getArgumentsAndReturnSizes(str3);
        int i13 = -(argumentsAndReturnSizes >> 2);
        if (i11 == 184) {
            i12 = 1;
        } else {
            i12 = 0;
        }
        adjustStack(i13 + i12);
        adjustStack(argumentsAndReturnSizes & 3);
        super.visitMethodInsn(i11, str, str2, str3, z11);
    }

    public void visitMultiANewArrayInsn(String str, int i11) {
        adjustStack(1 - i11);
        super.visitMultiANewArrayInsn(str, i11);
    }

    public void visitTableSwitchInsn(int i11, int i12, Label label, Label... labelArr) {
        adjustStack(-1);
        ArrayList arrayList = new ArrayList(this.current);
        this.sizes.put(label, arrayList);
        for (Label put : labelArr) {
            this.sizes.put(put, arrayList);
        }
        super.visitTableSwitchInsn(i11, i12, label, labelArr);
    }

    public void visitTryCatchBlock(Label label, Label label2, Label label3, String str) {
        this.sizes.put(label3, Collections.singletonList(StackSize.SINGLE));
        super.visitTryCatchBlock(label, label2, label3, str);
    }

    public void visitTypeInsn(int i11, String str) {
        adjustStack(SIZE_CHANGE[i11]);
        super.visitTypeInsn(i11, str);
    }

    @SuppressFBWarnings(justification = "No default behavior is applied", value = {"SF_SWITCH_NO_DEFAULT"})
    public void visitVarInsn(int i11, int i12) {
        if (i11 != 169) {
            switch (i11) {
                case 54:
                case 56:
                case 58:
                    this.freeIndex = Math.max(this.freeIndex, i12 + 1);
                    break;
                case 55:
                case 57:
                    this.freeIndex = Math.max(this.freeIndex, i12 + 2);
                    break;
            }
        } else {
            this.current.clear();
        }
        adjustStack(SIZE_CHANGE[i11]);
        super.visitVarInsn(i11, i12);
    }

    private void adjustStack(int i11, int i12) {
        if (i11 > 2) {
            throw new IllegalStateException("Cannot push multiple values onto the operand stack: " + i11);
        } else if (i11 > 0) {
            int size = this.current.size();
            while (i12 > 0 && size > 0) {
                size--;
                i12 -= this.current.get(size).getSize();
            }
            if (i12 >= 0) {
                this.current.add(size, StackSize.of(i11));
                return;
            }
            throw new IllegalStateException("Unexpected offset underflow: " + i12);
        } else if (i12 == 0) {
            while (i11 < 0) {
                if (!this.current.isEmpty()) {
                    List<StackSize> list = this.current;
                    i11 += list.remove(list.size() - 1).getSize();
                } else {
                    return;
                }
            }
            if (i11 == 1) {
                this.current.add(StackSize.SINGLE);
            } else if (i11 != 0) {
                throw new IllegalStateException("Unexpected remainder on the operand stack: " + i11);
            }
        } else {
            throw new IllegalStateException("Cannot specify non-zero offset " + i12 + " for non-incrementing value: " + i11);
        }
    }

    public int drainStack(int i11, int i12, StackSize stackSize) {
        List<StackSize> list = this.current;
        int size = list.get(list.size() - 1).getSize() - stackSize.getSize();
        if (this.current.size() == 1 && size == 0) {
            return 0;
        }
        super.visitVarInsn(i11, this.freeIndex);
        if (size == 1) {
            super.visitInsn(87);
        } else if (size != 0) {
            throw new IllegalStateException("Unexpected remainder on the operand stack: " + size);
        }
        List<StackSize> list2 = this.current;
        doDrain(list2.subList(0, list2.size() - 1));
        super.visitVarInsn(i12, this.freeIndex);
        return this.freeIndex + stackSize.getSize();
    }
}
