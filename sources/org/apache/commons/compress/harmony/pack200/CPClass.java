package org.apache.commons.compress.harmony.pack200;

public class CPClass extends CPConstant {
    private final String className;
    private final boolean isInnerClass;
    private final CPUTF8 utf8;

    public CPClass(CPUTF8 cputf8) {
        this.utf8 = cputf8;
        String underlyingString = cputf8.getUnderlyingString();
        this.className = underlyingString;
        char[] charArray = underlyingString.toCharArray();
        for (char c11 : charArray) {
            if (c11 <= '-') {
                this.isInnerClass = true;
                return;
            }
        }
        this.isInnerClass = false;
    }

    public int compareTo(Object obj) {
        return this.className.compareTo(((CPClass) obj).className);
    }

    public int getIndexInCpUtf8() {
        return this.utf8.getIndex();
    }

    public boolean isInnerClass() {
        return this.isInnerClass;
    }

    public String toString() {
        return this.className;
    }
}
