package org.apache.commons.compress.harmony.unpack200.bytecode;

import java.io.DataOutputStream;
import java.io.IOException;

public abstract class Attribute extends ClassFileEntry {
    protected final CPUTF8 attributeName;
    private int attributeNameIndex;

    public Attribute(CPUTF8 cputf8) {
        this.attributeName = cputf8;
    }

    public void doWrite(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeShort(this.attributeNameIndex);
        dataOutputStream.writeInt(getLength());
        writeBody(dataOutputStream);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Attribute attribute = (Attribute) obj;
        CPUTF8 cputf8 = this.attributeName;
        if (cputf8 == null) {
            if (attribute.attributeName != null) {
                return false;
            }
        } else if (!cputf8.equals(attribute.attributeName)) {
            return false;
        }
        return true;
    }

    public CPUTF8 getAttributeName() {
        return this.attributeName;
    }

    public abstract int getLength();

    public int getLengthIncludingHeader() {
        return getLength() + 2 + 4;
    }

    public ClassFileEntry[] getNestedClassFileEntries() {
        return new ClassFileEntry[]{getAttributeName()};
    }

    public boolean hasBCIRenumbering() {
        return false;
    }

    public int hashCode() {
        CPUTF8 cputf8 = this.attributeName;
        return 31 + (cputf8 == null ? 0 : cputf8.hashCode());
    }

    public boolean isSourceFileAttribute() {
        return false;
    }

    public void resolve(ClassConstantPool classConstantPool) {
        super.resolve(classConstantPool);
        this.attributeNameIndex = classConstantPool.indexOf(this.attributeName);
    }

    public abstract void writeBody(DataOutputStream dataOutputStream) throws IOException;
}
