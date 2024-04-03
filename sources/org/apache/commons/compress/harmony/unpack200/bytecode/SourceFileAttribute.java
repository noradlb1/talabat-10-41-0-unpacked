package org.apache.commons.compress.harmony.unpack200.bytecode;

import java.io.DataOutputStream;
import java.io.IOException;

public class SourceFileAttribute extends Attribute {
    private static CPUTF8 attributeName;

    /* renamed from: name  reason: collision with root package name */
    private final CPUTF8 f27767name;
    private int nameIndex;

    public SourceFileAttribute(CPUTF8 cputf8) {
        super(attributeName);
        this.f27767name = cputf8;
    }

    public static void setAttributeName(CPUTF8 cputf8) {
        attributeName = cputf8;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!super.equals(obj) || getClass() != obj.getClass()) {
            return false;
        }
        SourceFileAttribute sourceFileAttribute = (SourceFileAttribute) obj;
        CPUTF8 cputf8 = this.f27767name;
        if (cputf8 == null) {
            if (sourceFileAttribute.f27767name != null) {
                return false;
            }
        } else if (!cputf8.equals(sourceFileAttribute.f27767name)) {
            return false;
        }
        return true;
    }

    public int getLength() {
        return 2;
    }

    public ClassFileEntry[] getNestedClassFileEntries() {
        return new ClassFileEntry[]{getAttributeName(), this.f27767name};
    }

    public int hashCode() {
        int i11;
        int hashCode = super.hashCode() * 31;
        CPUTF8 cputf8 = this.f27767name;
        if (cputf8 == null) {
            i11 = 0;
        } else {
            i11 = cputf8.hashCode();
        }
        return hashCode + i11;
    }

    public boolean isSourceFileAttribute() {
        return true;
    }

    public void resolve(ClassConstantPool classConstantPool) {
        super.resolve(classConstantPool);
        this.nameIndex = classConstantPool.indexOf(this.f27767name);
    }

    public String toString() {
        return "SourceFile: " + this.f27767name;
    }

    public void writeBody(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeShort(this.nameIndex);
    }
}
