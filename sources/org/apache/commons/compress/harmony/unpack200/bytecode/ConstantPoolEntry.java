package org.apache.commons.compress.harmony.unpack200.bytecode;

import java.io.DataOutputStream;
import java.io.IOException;

public abstract class ConstantPoolEntry extends ClassFileEntry {
    public static final byte CP_Class = 7;
    public static final byte CP_Double = 6;
    public static final byte CP_Fieldref = 9;
    public static final byte CP_Float = 4;
    public static final byte CP_Integer = 3;
    public static final byte CP_InterfaceMethodref = 11;
    public static final byte CP_Long = 5;
    public static final byte CP_Methodref = 10;
    public static final byte CP_NameAndType = 12;
    public static final byte CP_String = 8;
    public static final byte CP_UTF8 = 1;
    protected int globalIndex;
    byte tag;

    public ConstantPoolEntry(byte b11, int i11) {
        this.tag = b11;
        this.globalIndex = i11;
    }

    public void doWrite(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeByte(this.tag);
        writeBody(dataOutputStream);
    }

    public abstract boolean equals(Object obj);

    public int getGlobalIndex() {
        return this.globalIndex;
    }

    public byte getTag() {
        return this.tag;
    }

    public abstract int hashCode();

    public abstract void writeBody(DataOutputStream dataOutputStream) throws IOException;
}
