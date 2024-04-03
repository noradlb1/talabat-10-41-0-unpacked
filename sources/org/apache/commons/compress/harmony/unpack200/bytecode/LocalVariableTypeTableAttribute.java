package org.apache.commons.compress.harmony.unpack200.bytecode;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.compress.harmony.pack200.Pack200Exception;

public class LocalVariableTypeTableAttribute extends BCIRenumberedAttribute {
    private static CPUTF8 attributeName;
    private int codeLength;
    private final int[] indexes;
    private final int[] lengths;
    private final int local_variable_type_table_length;
    private int[] name_indexes;
    private final CPUTF8[] names;
    private int[] signature_indexes;
    private final CPUTF8[] signatures;
    private final int[] start_pcs;

    public LocalVariableTypeTableAttribute(int i11, int[] iArr, int[] iArr2, CPUTF8[] cputf8Arr, CPUTF8[] cputf8Arr2, int[] iArr3) {
        super(attributeName);
        this.local_variable_type_table_length = i11;
        this.start_pcs = iArr;
        this.lengths = iArr2;
        this.names = cputf8Arr;
        this.signatures = cputf8Arr2;
        this.indexes = iArr3;
    }

    public static void setAttributeName(CPUTF8 cputf8) {
        attributeName = cputf8;
    }

    public int getLength() {
        return (this.local_variable_type_table_length * 10) + 2;
    }

    public ClassFileEntry[] getNestedClassFileEntries() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(getAttributeName());
        for (int i11 = 0; i11 < this.local_variable_type_table_length; i11++) {
            arrayList.add(this.names[i11]);
            arrayList.add(this.signatures[i11]);
        }
        ClassFileEntry[] classFileEntryArr = new ClassFileEntry[arrayList.size()];
        arrayList.toArray(classFileEntryArr);
        return classFileEntryArr;
    }

    public int[] getStartPCs() {
        return this.start_pcs;
    }

    public void renumber(List list) throws Pack200Exception {
        int i11;
        int[] iArr = this.start_pcs;
        int[] iArr2 = new int[iArr.length];
        int i12 = 0;
        System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
        super.renumber(list);
        int i13 = this.codeLength;
        while (true) {
            int[] iArr3 = this.lengths;
            if (i12 < iArr3.length) {
                int i14 = this.start_pcs[i12];
                int i15 = iArr2[i12] + iArr3[i12];
                if (i15 >= 0) {
                    if (i15 == list.size()) {
                        i11 = i13 - i14;
                    } else {
                        i11 = ((Integer) list.get(i15)).intValue() - i14;
                    }
                    this.lengths[i12] = i11;
                    i12++;
                } else {
                    throw new Pack200Exception("Error renumbering bytecode indexes");
                }
            } else {
                return;
            }
        }
    }

    public void resolve(ClassConstantPool classConstantPool) {
        super.resolve(classConstantPool);
        int i11 = this.local_variable_type_table_length;
        this.name_indexes = new int[i11];
        this.signature_indexes = new int[i11];
        for (int i12 = 0; i12 < this.local_variable_type_table_length; i12++) {
            this.names[i12].resolve(classConstantPool);
            this.signatures[i12].resolve(classConstantPool);
            this.name_indexes[i12] = classConstantPool.indexOf(this.names[i12]);
            this.signature_indexes[i12] = classConstantPool.indexOf(this.signatures[i12]);
        }
    }

    public void setCodeLength(int i11) {
        this.codeLength = i11;
    }

    public String toString() {
        return "LocalVariableTypeTable: " + this.local_variable_type_table_length + " varaibles";
    }

    public void writeBody(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeShort(this.local_variable_type_table_length);
        for (int i11 = 0; i11 < this.local_variable_type_table_length; i11++) {
            dataOutputStream.writeShort(this.start_pcs[i11]);
            dataOutputStream.writeShort(this.lengths[i11]);
            dataOutputStream.writeShort(this.name_indexes[i11]);
            dataOutputStream.writeShort(this.signature_indexes[i11]);
            dataOutputStream.writeShort(this.indexes[i11]);
        }
    }
}
