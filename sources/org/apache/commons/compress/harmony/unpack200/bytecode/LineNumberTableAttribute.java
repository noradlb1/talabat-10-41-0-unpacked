package org.apache.commons.compress.harmony.unpack200.bytecode;

import java.io.DataOutputStream;
import java.io.IOException;

public class LineNumberTableAttribute extends BCIRenumberedAttribute {
    private static CPUTF8 attributeName;
    private final int line_number_table_length;
    private final int[] line_numbers;
    private final int[] start_pcs;

    public LineNumberTableAttribute(int i11, int[] iArr, int[] iArr2) {
        super(attributeName);
        this.line_number_table_length = i11;
        this.start_pcs = iArr;
        this.line_numbers = iArr2;
    }

    public static void setAttributeName(CPUTF8 cputf8) {
        attributeName = cputf8;
    }

    public boolean equals(Object obj) {
        return this == obj;
    }

    public int getLength() {
        return (this.line_number_table_length * 4) + 2;
    }

    public ClassFileEntry[] getNestedClassFileEntries() {
        return new ClassFileEntry[]{getAttributeName()};
    }

    public int[] getStartPCs() {
        return this.start_pcs;
    }

    public void resolve(ClassConstantPool classConstantPool) {
        super.resolve(classConstantPool);
    }

    public String toString() {
        return "LineNumberTable: " + this.line_number_table_length + " lines";
    }

    public void writeBody(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeShort(this.line_number_table_length);
        for (int i11 = 0; i11 < this.line_number_table_length; i11++) {
            dataOutputStream.writeShort(this.start_pcs[i11]);
            dataOutputStream.writeShort(this.line_numbers[i11]);
        }
    }
}
