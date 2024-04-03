package org.apache.commons.compress.harmony.unpack200.bytecode;

public class CPMethodRef extends CPRef {
    private int cachedHashCode;
    private boolean hashcodeComputed;

    public CPMethodRef(CPClass cPClass, CPNameAndType cPNameAndType, int i11) {
        super((byte) 10, cPClass, cPNameAndType, i11);
    }

    private void generateHashCode() {
        this.hashcodeComputed = true;
        this.cachedHashCode = ((this.className.hashCode() + 31) * 31) + this.nameAndType.hashCode();
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
}
