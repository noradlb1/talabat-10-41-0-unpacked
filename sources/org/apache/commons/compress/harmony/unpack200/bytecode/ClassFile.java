package org.apache.commons.compress.harmony.unpack200.bytecode;

import java.io.DataOutputStream;
import java.io.IOException;

public class ClassFile {
    public int accessFlags;
    public Attribute[] attributes;
    public ClassFileEntry[] fields;
    public int[] interfaces;
    private final int magic = -889275714;
    public int major;
    public ClassFileEntry[] methods;
    public int minor;
    public ClassConstantPool pool = new ClassConstantPool();
    public int superClass;
    public int thisClass;

    public void write(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeInt(-889275714);
        dataOutputStream.writeShort(this.minor);
        dataOutputStream.writeShort(this.major);
        dataOutputStream.writeShort(this.pool.size() + 1);
        int i11 = 1;
        while (i11 <= this.pool.size()) {
            ConstantPoolEntry constantPoolEntry = (ConstantPoolEntry) this.pool.get(i11);
            constantPoolEntry.doWrite(dataOutputStream);
            if (constantPoolEntry.getTag() == 6 || constantPoolEntry.getTag() == 5) {
                i11++;
            }
            i11++;
        }
        dataOutputStream.writeShort(this.accessFlags);
        dataOutputStream.writeShort(this.thisClass);
        dataOutputStream.writeShort(this.superClass);
        dataOutputStream.writeShort(this.interfaces.length);
        int i12 = 0;
        int i13 = 0;
        while (true) {
            int[] iArr = this.interfaces;
            if (i13 >= iArr.length) {
                break;
            }
            dataOutputStream.writeShort(iArr[i13]);
            i13++;
        }
        dataOutputStream.writeShort(this.fields.length);
        int i14 = 0;
        while (true) {
            ClassFileEntry[] classFileEntryArr = this.fields;
            if (i14 >= classFileEntryArr.length) {
                break;
            }
            classFileEntryArr[i14].write(dataOutputStream);
            i14++;
        }
        dataOutputStream.writeShort(this.methods.length);
        int i15 = 0;
        while (true) {
            ClassFileEntry[] classFileEntryArr2 = this.methods;
            if (i15 >= classFileEntryArr2.length) {
                break;
            }
            classFileEntryArr2[i15].write(dataOutputStream);
            i15++;
        }
        dataOutputStream.writeShort(this.attributes.length);
        while (true) {
            Attribute[] attributeArr = this.attributes;
            if (i12 < attributeArr.length) {
                attributeArr[i12].write(dataOutputStream);
                i12++;
            } else {
                return;
            }
        }
    }
}
