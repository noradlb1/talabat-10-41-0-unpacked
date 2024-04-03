package org.apache.commons.compress.harmony.unpack200.bytecode;

import java.io.DataOutputStream;
import java.io.IOException;

public class ConstantValueAttribute extends Attribute {
    private static CPUTF8 attributeName;
    private int constantIndex;
    private final ClassFileEntry entry;

    public ConstantValueAttribute(ClassFileEntry classFileEntry) {
        super(attributeName);
        classFileEntry.getClass();
        this.entry = classFileEntry;
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
        ConstantValueAttribute constantValueAttribute = (ConstantValueAttribute) obj;
        ClassFileEntry classFileEntry = this.entry;
        if (classFileEntry == null) {
            if (constantValueAttribute.entry != null) {
                return false;
            }
        } else if (!classFileEntry.equals(constantValueAttribute.entry)) {
            return false;
        }
        return true;
    }

    public int getLength() {
        return 2;
    }

    public ClassFileEntry[] getNestedClassFileEntries() {
        return new ClassFileEntry[]{getAttributeName(), this.entry};
    }

    public int hashCode() {
        int i11;
        int hashCode = super.hashCode() * 31;
        ClassFileEntry classFileEntry = this.entry;
        if (classFileEntry == null) {
            i11 = 0;
        } else {
            i11 = classFileEntry.hashCode();
        }
        return hashCode + i11;
    }

    public void resolve(ClassConstantPool classConstantPool) {
        super.resolve(classConstantPool);
        this.entry.resolve(classConstantPool);
        this.constantIndex = classConstantPool.indexOf(this.entry);
    }

    public String toString() {
        return "Constant:" + this.entry;
    }

    public void writeBody(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeShort(this.constantIndex);
    }
}
