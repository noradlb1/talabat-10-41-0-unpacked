package net.bytebuddy.jar.asm.signature;

import kotlin.text.Typography;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import net.bytebuddy.jar.asm.Opcodes;
import net.bytebuddy.pool.TypePool;

public class SignatureWriter extends SignatureVisitor {
    private int argumentStack;
    private boolean hasFormals;
    private boolean hasParameters;
    private final StringBuilder stringBuilder = new StringBuilder();

    public SignatureWriter() {
        super(Opcodes.ASM9);
    }

    private void endArguments() {
        if (this.argumentStack % 2 == 1) {
            this.stringBuilder.append(Typography.greater);
        }
        this.argumentStack /= 2;
    }

    private void endFormals() {
        if (this.hasFormals) {
            this.hasFormals = false;
            this.stringBuilder.append(Typography.greater);
        }
    }

    public String toString() {
        return this.stringBuilder.toString();
    }

    public SignatureVisitor visitArrayType() {
        this.stringBuilder.append('[');
        return this;
    }

    public void visitBaseType(char c11) {
        this.stringBuilder.append(c11);
    }

    public SignatureVisitor visitClassBound() {
        return this;
    }

    public void visitClassType(String str) {
        this.stringBuilder.append('L');
        this.stringBuilder.append(str);
        this.argumentStack *= 2;
    }

    public void visitEnd() {
        endArguments();
        this.stringBuilder.append(TypePool.Default.LazyTypeDescription.GenericTypeToken.INDEXED_TYPE_DELIMITER);
    }

    public SignatureVisitor visitExceptionType() {
        this.stringBuilder.append('^');
        return this;
    }

    public void visitFormalTypeParameter(String str) {
        if (!this.hasFormals) {
            this.hasFormals = true;
            this.stringBuilder.append(Typography.less);
        }
        this.stringBuilder.append(str);
        this.stringBuilder.append(AbstractJsonLexerKt.COLON);
    }

    public void visitInnerClassType(String str) {
        endArguments();
        this.stringBuilder.append('.');
        this.stringBuilder.append(str);
        this.argumentStack *= 2;
    }

    public SignatureVisitor visitInterface() {
        return this;
    }

    public SignatureVisitor visitInterfaceBound() {
        this.stringBuilder.append(AbstractJsonLexerKt.COLON);
        return this;
    }

    public SignatureVisitor visitParameterType() {
        endFormals();
        if (!this.hasParameters) {
            this.hasParameters = true;
            this.stringBuilder.append('(');
        }
        return this;
    }

    public SignatureVisitor visitReturnType() {
        endFormals();
        if (!this.hasParameters) {
            this.stringBuilder.append('(');
        }
        this.stringBuilder.append(')');
        return this;
    }

    public SignatureVisitor visitSuperclass() {
        endFormals();
        return this;
    }

    public void visitTypeArgument() {
        int i11 = this.argumentStack;
        if (i11 % 2 == 0) {
            this.argumentStack = i11 | 1;
            this.stringBuilder.append(Typography.less);
        }
        this.stringBuilder.append(TypePool.Default.LazyTypeDescription.GenericTypeToken.WILDCARD_TYPE_PATH);
    }

    public void visitTypeVariable(String str) {
        this.stringBuilder.append('T');
        this.stringBuilder.append(str);
        this.stringBuilder.append(TypePool.Default.LazyTypeDescription.GenericTypeToken.INDEXED_TYPE_DELIMITER);
    }

    public SignatureVisitor visitTypeArgument(char c11) {
        int i11 = this.argumentStack;
        if (i11 % 2 == 0) {
            this.argumentStack = i11 | 1;
            this.stringBuilder.append(Typography.less);
        }
        if (c11 != '=') {
            this.stringBuilder.append(c11);
        }
        return this;
    }
}
