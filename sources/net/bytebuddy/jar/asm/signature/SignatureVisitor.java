package net.bytebuddy.jar.asm.signature;

public abstract class SignatureVisitor {
    public static final char EXTENDS = '+';
    public static final char INSTANCEOF = '=';
    public static final char SUPER = '-';

    /* renamed from: a  reason: collision with root package name */
    public final int f27424a;

    public SignatureVisitor(int i11) {
        if (i11 == 589824 || i11 == 524288 || i11 == 458752 || i11 == 393216 || i11 == 327680 || i11 == 262144 || i11 == 17432576) {
            this.f27424a = i11;
            return;
        }
        throw new IllegalArgumentException("Unsupported api " + i11);
    }

    public SignatureVisitor visitArrayType() {
        return this;
    }

    public void visitBaseType(char c11) {
    }

    public SignatureVisitor visitClassBound() {
        return this;
    }

    public void visitClassType(String str) {
    }

    public void visitEnd() {
    }

    public SignatureVisitor visitExceptionType() {
        return this;
    }

    public void visitFormalTypeParameter(String str) {
    }

    public void visitInnerClassType(String str) {
    }

    public SignatureVisitor visitInterface() {
        return this;
    }

    public SignatureVisitor visitInterfaceBound() {
        return this;
    }

    public SignatureVisitor visitParameterType() {
        return this;
    }

    public SignatureVisitor visitReturnType() {
        return this;
    }

    public SignatureVisitor visitSuperclass() {
        return this;
    }

    public SignatureVisitor visitTypeArgument(char c11) {
        return this;
    }

    public void visitTypeArgument() {
    }

    public void visitTypeVariable(String str) {
    }
}
