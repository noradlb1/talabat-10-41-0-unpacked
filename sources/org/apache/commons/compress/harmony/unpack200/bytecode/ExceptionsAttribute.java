package org.apache.commons.compress.harmony.unpack200.bytecode;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class ExceptionsAttribute extends Attribute {
    private static CPUTF8 attributeName;
    private transient int[] exceptionIndexes;
    private final CPClass[] exceptions;

    public ExceptionsAttribute(CPClass[] cPClassArr) {
        super(attributeName);
        this.exceptions = cPClassArr;
    }

    private static int hashCode(Object[] objArr) {
        if (objArr == null) {
            return 0;
        }
        int i11 = 1;
        for (int i12 = 0; i12 < objArr.length; i12++) {
            int i13 = i11 * 31;
            Object obj = objArr[i12];
            i11 = i13 + (obj == null ? 0 : obj.hashCode());
        }
        return i11;
    }

    public static void setAttributeName(CPUTF8 cputf8) {
        attributeName = cputf8;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (super.equals(obj) && getClass() == obj.getClass() && Arrays.equals(this.exceptions, ((ExceptionsAttribute) obj).exceptions)) {
            return true;
        }
        return false;
    }

    public int getLength() {
        return (this.exceptions.length * 2) + 2;
    }

    public ClassFileEntry[] getNestedClassFileEntries() {
        ClassFileEntry[] classFileEntryArr = new ClassFileEntry[(this.exceptions.length + 1)];
        int i11 = 0;
        while (true) {
            CPClass[] cPClassArr = this.exceptions;
            if (i11 < cPClassArr.length) {
                classFileEntryArr[i11] = cPClassArr[i11];
                i11++;
            } else {
                classFileEntryArr[cPClassArr.length] = getAttributeName();
                return classFileEntryArr;
            }
        }
    }

    public void resolve(ClassConstantPool classConstantPool) {
        super.resolve(classConstantPool);
        this.exceptionIndexes = new int[this.exceptions.length];
        int i11 = 0;
        while (true) {
            CPClass[] cPClassArr = this.exceptions;
            if (i11 < cPClassArr.length) {
                cPClassArr[i11].resolve(classConstantPool);
                this.exceptionIndexes[i11] = classConstantPool.indexOf(this.exceptions[i11]);
                i11++;
            } else {
                return;
            }
        }
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Exceptions: ");
        int i11 = 0;
        while (true) {
            CPClass[] cPClassArr = this.exceptions;
            if (i11 >= cPClassArr.length) {
                return stringBuffer.toString();
            }
            stringBuffer.append(cPClassArr[i11]);
            stringBuffer.append(' ');
            i11++;
        }
    }

    public void writeBody(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeShort(this.exceptionIndexes.length);
        int i11 = 0;
        while (true) {
            int[] iArr = this.exceptionIndexes;
            if (i11 < iArr.length) {
                dataOutputStream.writeShort(iArr[i11]);
                i11++;
            } else {
                return;
            }
        }
    }

    public int hashCode() {
        return (super.hashCode() * 31) + hashCode(this.exceptions);
    }
}
