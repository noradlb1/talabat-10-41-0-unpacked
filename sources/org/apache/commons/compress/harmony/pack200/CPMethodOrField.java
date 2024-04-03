package org.apache.commons.compress.harmony.pack200;

public class CPMethodOrField extends ConstantPoolEntry implements Comparable {
    private final CPClass className;
    private int indexInClass = -1;
    private int indexInClassForConstructor = -1;
    private final CPNameAndType nameAndType;

    public CPMethodOrField(CPClass cPClass, CPNameAndType cPNameAndType) {
        this.className = cPClass;
        this.nameAndType = cPNameAndType;
    }

    public int compareTo(Object obj) {
        if (!(obj instanceof CPMethodOrField)) {
            return 0;
        }
        CPMethodOrField cPMethodOrField = (CPMethodOrField) obj;
        int compareTo = this.className.compareTo(cPMethodOrField.className);
        if (compareTo == 0) {
            return this.nameAndType.compareTo(cPMethodOrField.nameAndType);
        }
        return compareTo;
    }

    public int getClassIndex() {
        return this.className.getIndex();
    }

    public CPClass getClassName() {
        return this.className;
    }

    public CPNameAndType getDesc() {
        return this.nameAndType;
    }

    public int getDescIndex() {
        return this.nameAndType.getIndex();
    }

    public int getIndexInClass() {
        return this.indexInClass;
    }

    public int getIndexInClassForConstructor() {
        return this.indexInClassForConstructor;
    }

    public void setIndexInClass(int i11) {
        this.indexInClass = i11;
    }

    public void setIndexInClassForConstructor(int i11) {
        this.indexInClassForConstructor = i11;
    }

    public String toString() {
        return this.className + ": " + this.nameAndType;
    }
}
