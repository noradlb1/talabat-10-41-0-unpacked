package net.bytebuddy.jar.asm.commons;

import java.util.ArrayList;
import net.bytebuddy.jar.asm.Opcodes;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;

public class SignatureRemapper extends SignatureVisitor {
    private ArrayList<String> classNames;
    private final Remapper remapper;
    private final SignatureVisitor signatureVisitor;

    public SignatureRemapper(SignatureVisitor signatureVisitor2, Remapper remapper2) {
        this(Opcodes.ASM9, signatureVisitor2, remapper2);
    }

    public SignatureVisitor visitArrayType() {
        this.signatureVisitor.visitArrayType();
        return this;
    }

    public void visitBaseType(char c11) {
        this.signatureVisitor.visitBaseType(c11);
    }

    public SignatureVisitor visitClassBound() {
        this.signatureVisitor.visitClassBound();
        return this;
    }

    public void visitClassType(String str) {
        this.classNames.add(str);
        this.signatureVisitor.visitClassType(this.remapper.mapType(str));
    }

    public void visitEnd() {
        this.signatureVisitor.visitEnd();
        ArrayList<String> arrayList = this.classNames;
        arrayList.remove(arrayList.size() - 1);
    }

    public SignatureVisitor visitExceptionType() {
        this.signatureVisitor.visitExceptionType();
        return this;
    }

    public void visitFormalTypeParameter(String str) {
        this.signatureVisitor.visitFormalTypeParameter(str);
    }

    public void visitInnerClassType(String str) {
        int i11;
        ArrayList<String> arrayList = this.classNames;
        String remove = arrayList.remove(arrayList.size() - 1);
        String str2 = remove + '$' + str;
        this.classNames.add(str2);
        String str3 = this.remapper.mapType(remove) + '$';
        String mapType = this.remapper.mapType(str2);
        if (mapType.startsWith(str3)) {
            i11 = str3.length();
        } else {
            i11 = mapType.lastIndexOf(36) + 1;
        }
        this.signatureVisitor.visitInnerClassType(mapType.substring(i11));
    }

    public SignatureVisitor visitInterface() {
        this.signatureVisitor.visitInterface();
        return this;
    }

    public SignatureVisitor visitInterfaceBound() {
        this.signatureVisitor.visitInterfaceBound();
        return this;
    }

    public SignatureVisitor visitParameterType() {
        this.signatureVisitor.visitParameterType();
        return this;
    }

    public SignatureVisitor visitReturnType() {
        this.signatureVisitor.visitReturnType();
        return this;
    }

    public SignatureVisitor visitSuperclass() {
        this.signatureVisitor.visitSuperclass();
        return this;
    }

    public void visitTypeArgument() {
        this.signatureVisitor.visitTypeArgument();
    }

    public void visitTypeVariable(String str) {
        this.signatureVisitor.visitTypeVariable(str);
    }

    public SignatureRemapper(int i11, SignatureVisitor signatureVisitor2, Remapper remapper2) {
        super(i11);
        this.classNames = new ArrayList<>();
        this.signatureVisitor = signatureVisitor2;
        this.remapper = remapper2;
    }

    public SignatureVisitor visitTypeArgument(char c11) {
        this.signatureVisitor.visitTypeArgument(c11);
        return this;
    }
}
