package org.apache.commons.compress.harmony.unpack200.bytecode;

import java.io.DataOutputStream;
import java.io.IOException;

public class CPFieldRef extends ConstantPoolEntry {
    private int cachedHashCode;
    CPClass className;
    transient int classNameIndex;
    private boolean hashcodeComputed;
    private final CPNameAndType nameAndType;
    transient int nameAndTypeIndex;

    public CPFieldRef(CPClass cPClass, CPNameAndType cPNameAndType, int i11) {
        super((byte) 9, i11);
        this.className = cPClass;
        this.nameAndType = cPNameAndType;
    }

    private void generateHashCode() {
        int i11;
        this.hashcodeComputed = true;
        CPClass cPClass = this.className;
        int i12 = 0;
        if (cPClass == null) {
            i11 = 0;
        } else {
            i11 = cPClass.hashCode();
        }
        int i13 = (i11 + 31) * 31;
        CPNameAndType cPNameAndType = this.nameAndType;
        if (cPNameAndType != null) {
            i12 = cPNameAndType.hashCode();
        }
        this.cachedHashCode = i13 + i12;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        CPFieldRef cPFieldRef = (CPFieldRef) obj;
        CPClass cPClass = this.className;
        if (cPClass == null) {
            if (cPFieldRef.className != null) {
                return false;
            }
        } else if (!cPClass.equals(cPFieldRef.className)) {
            return false;
        }
        CPNameAndType cPNameAndType = this.nameAndType;
        if (cPNameAndType == null) {
            if (cPFieldRef.nameAndType != null) {
                return false;
            }
        } else if (!cPNameAndType.equals(cPFieldRef.nameAndType)) {
            return false;
        }
        return true;
    }

    public ClassFileEntry[] getNestedClassFileEntries() {
        return new ClassFileEntry[]{this.className, this.nameAndType};
    }

    public int hashCode() {
        if (!this.hashcodeComputed) {
            generateHashCode();
        }
        return this.cachedHashCode;
    }

    public void resolve(ClassConstantPool classConstantPool) {
        super.resolve(classConstantPool);
        this.nameAndTypeIndex = classConstantPool.indexOf(this.nameAndType);
        this.classNameIndex = classConstantPool.indexOf(this.className);
    }

    public String toString() {
        return "FieldRef: " + this.className + "#" + this.nameAndType;
    }

    public void writeBody(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeShort(this.classNameIndex);
        dataOutputStream.writeShort(this.nameAndTypeIndex);
    }
}
