package net.bytebuddy.implementation.bytecode;

import net.bytebuddy.description.type.TypeDefinition;
import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.implementation.bytecode.StackManipulation;
import net.bytebuddy.jar.asm.MethodVisitor;

public enum Duplication implements StackManipulation {
    ZERO(StackSize.ZERO, 0) {
        public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
            return this.f27326b;
        }

        public StackManipulation flipOver(TypeDefinition typeDefinition) {
            throw new IllegalStateException("Cannot flip zero value");
        }
    },
    SINGLE(StackSize.SINGLE, 89) {
        public StackManipulation flipOver(TypeDefinition typeDefinition) {
            int i11 = AnonymousClass4.f27327a[typeDefinition.getStackSize().ordinal()];
            if (i11 == 1) {
                return WithFlip.SINGLE_SINGLE;
            }
            if (i11 == 2) {
                return WithFlip.SINGLE_DOUBLE;
            }
            throw new IllegalArgumentException("Cannot flip: " + typeDefinition);
        }
    },
    DOUBLE(StackSize.DOUBLE, 92) {
        public StackManipulation flipOver(TypeDefinition typeDefinition) {
            int i11 = AnonymousClass4.f27327a[typeDefinition.getStackSize().ordinal()];
            if (i11 == 1) {
                return WithFlip.DOUBLE_SINGLE;
            }
            if (i11 == 2) {
                return WithFlip.DOUBLE_DOUBLE;
            }
            throw new IllegalArgumentException("Cannot flip: " + typeDefinition);
        }
    };
    

    /* renamed from: b  reason: collision with root package name */
    public final StackManipulation.Size f27326b;
    private final int opcode;

    /* renamed from: net.bytebuddy.implementation.bytecode.Duplication$4  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass4 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f27327a = null;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                net.bytebuddy.implementation.bytecode.StackSize[] r0 = net.bytebuddy.implementation.bytecode.StackSize.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f27327a = r0
                net.bytebuddy.implementation.bytecode.StackSize r1 = net.bytebuddy.implementation.bytecode.StackSize.SINGLE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f27327a     // Catch:{ NoSuchFieldError -> 0x001d }
                net.bytebuddy.implementation.bytecode.StackSize r1 = net.bytebuddy.implementation.bytecode.StackSize.DOUBLE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f27327a     // Catch:{ NoSuchFieldError -> 0x0028 }
                net.bytebuddy.implementation.bytecode.StackSize r1 = net.bytebuddy.implementation.bytecode.StackSize.ZERO     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.implementation.bytecode.Duplication.AnonymousClass4.<clinit>():void");
        }
    }

    public enum WithFlip implements StackManipulation {
        SINGLE_SINGLE(90, r1),
        SINGLE_DOUBLE(91, r1),
        DOUBLE_SINGLE(93, r4),
        DOUBLE_DOUBLE(94, r4);
        
        private final int opcode;
        private final StackSize stackSize;

        private WithFlip(int i11, StackSize stackSize2) {
            this.opcode = i11;
            this.stackSize = stackSize2;
        }

        public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
            methodVisitor.visitInsn(this.opcode);
            return this.stackSize.toIncreasingSize();
        }

        public boolean isValid() {
            return true;
        }
    }

    public static Duplication of(TypeDefinition typeDefinition) {
        int i11 = AnonymousClass4.f27327a[typeDefinition.getStackSize().ordinal()];
        if (i11 == 1) {
            return SINGLE;
        }
        if (i11 == 2) {
            return DOUBLE;
        }
        if (i11 == 3) {
            return ZERO;
        }
        throw new AssertionError("Unexpected type: " + typeDefinition);
    }

    public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
        methodVisitor.visitInsn(this.opcode);
        return this.f27326b;
    }

    public abstract StackManipulation flipOver(TypeDefinition typeDefinition);

    public boolean isValid() {
        return true;
    }

    private Duplication(StackSize stackSize, int i11) {
        this.f27326b = stackSize.toIncreasingSize();
        this.opcode = i11;
    }
}
