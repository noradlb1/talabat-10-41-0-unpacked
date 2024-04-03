package org.apache.commons.compress.harmony.unpack200.bytecode;

import java.io.DataOutputStream;
import java.io.IOException;

public class SignatureAttribute extends Attribute {
    private static CPUTF8 attributeName;
    private final CPUTF8 signature;
    private int signature_index;

    public SignatureAttribute(CPUTF8 cputf8) {
        super(attributeName);
        this.signature = cputf8;
    }

    public static void setAttributeName(CPUTF8 cputf8) {
        attributeName = cputf8;
    }

    public int getLength() {
        return 2;
    }

    public ClassFileEntry[] getNestedClassFileEntries() {
        return new ClassFileEntry[]{getAttributeName(), this.signature};
    }

    public void resolve(ClassConstantPool classConstantPool) {
        super.resolve(classConstantPool);
        this.signature.resolve(classConstantPool);
        this.signature_index = classConstantPool.indexOf(this.signature);
    }

    public String toString() {
        return "Signature: " + this.signature;
    }

    public void writeBody(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeShort(this.signature_index);
    }
}
