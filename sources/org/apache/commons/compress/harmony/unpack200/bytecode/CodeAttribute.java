package org.apache.commons.compress.harmony.unpack200.bytecode;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.compress.harmony.unpack200.Segment;

public class CodeAttribute extends BCIRenumberedAttribute {
    private static CPUTF8 attributeName;
    public List attributes = new ArrayList();
    public List byteCodeOffsets = new ArrayList();
    public List byteCodes = new ArrayList();
    public int codeLength;
    public List exceptionTable;
    public int maxLocals;
    public int maxStack;

    public CodeAttribute(int i11, int i12, byte[] bArr, Segment segment, OperandManager operandManager, List list) {
        super(attributeName);
        this.maxLocals = i12;
        this.maxStack = i11;
        this.codeLength = 0;
        this.exceptionTable = list;
        this.byteCodeOffsets.add(0);
        int i13 = 0;
        int i14 = 0;
        while (i13 < bArr.length) {
            ByteCode byteCode = ByteCode.getByteCode(bArr[i13] & 255);
            byteCode.setByteCodeIndex(i14);
            i14++;
            byteCode.extractOperands(operandManager, segment, this.codeLength);
            this.byteCodes.add(byteCode);
            this.codeLength += byteCode.getLength();
            List list2 = this.byteCodeOffsets;
            int intValue = ((Integer) list2.get(list2.size() - 1)).intValue();
            if (byteCode.hasMultipleByteCodes()) {
                this.byteCodeOffsets.add(Integer.valueOf(intValue + 1));
                i14++;
            }
            if (i13 < bArr.length - 1) {
                this.byteCodeOffsets.add(Integer.valueOf(intValue + byteCode.getLength()));
            }
            if (byteCode.getOpcode() == 196) {
                i13++;
            }
            i13++;
        }
        for (int i15 = 0; i15 < this.byteCodes.size(); i15++) {
            ((ByteCode) this.byteCodes.get(i15)).applyByteCodeTargetFixup(this);
        }
    }

    public static void setAttributeName(CPUTF8 cputf8) {
        attributeName = cputf8;
    }

    public void addAttribute(Attribute attribute) {
        this.attributes.add(attribute);
        if (attribute instanceof LocalVariableTableAttribute) {
            ((LocalVariableTableAttribute) attribute).setCodeLength(this.codeLength);
        }
        if (attribute instanceof LocalVariableTypeTableAttribute) {
            ((LocalVariableTypeTableAttribute) attribute).setCodeLength(this.codeLength);
        }
    }

    public int getLength() {
        int i11 = 0;
        for (int i12 = 0; i12 < this.attributes.size(); i12++) {
            i11 += ((Attribute) this.attributes.get(i12)).getLengthIncludingHeader();
        }
        return this.codeLength + 8 + 2 + (this.exceptionTable.size() * 8) + 2 + i11;
    }

    public ClassFileEntry[] getNestedClassFileEntries() {
        ArrayList arrayList = new ArrayList(this.attributes.size() + this.byteCodes.size() + 10);
        arrayList.add(getAttributeName());
        arrayList.addAll(this.byteCodes);
        arrayList.addAll(this.attributes);
        for (int i11 = 0; i11 < this.exceptionTable.size(); i11++) {
            CPClass catchType = ((ExceptionTableEntry) this.exceptionTable.get(i11)).getCatchType();
            if (catchType != null) {
                arrayList.add(catchType);
            }
        }
        ClassFileEntry[] classFileEntryArr = new ClassFileEntry[arrayList.size()];
        arrayList.toArray(classFileEntryArr);
        return classFileEntryArr;
    }

    public int[] getStartPCs() {
        return null;
    }

    public void renumber(List list) {
        for (int i11 = 0; i11 < this.exceptionTable.size(); i11++) {
            ((ExceptionTableEntry) this.exceptionTable.get(i11)).renumber(list);
        }
    }

    public void resolve(ClassConstantPool classConstantPool) {
        super.resolve(classConstantPool);
        for (int i11 = 0; i11 < this.attributes.size(); i11++) {
            ((Attribute) this.attributes.get(i11)).resolve(classConstantPool);
        }
        for (int i12 = 0; i12 < this.byteCodes.size(); i12++) {
            ((ByteCode) this.byteCodes.get(i12)).resolve(classConstantPool);
        }
        for (int i13 = 0; i13 < this.exceptionTable.size(); i13++) {
            ((ExceptionTableEntry) this.exceptionTable.get(i13)).resolve(classConstantPool);
        }
    }

    public String toString() {
        return "Code: " + getLength() + " bytes";
    }

    public void writeBody(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeShort(this.maxStack);
        dataOutputStream.writeShort(this.maxLocals);
        dataOutputStream.writeInt(this.codeLength);
        for (int i11 = 0; i11 < this.byteCodes.size(); i11++) {
            ((ByteCode) this.byteCodes.get(i11)).write(dataOutputStream);
        }
        dataOutputStream.writeShort(this.exceptionTable.size());
        for (int i12 = 0; i12 < this.exceptionTable.size(); i12++) {
            ((ExceptionTableEntry) this.exceptionTable.get(i12)).write(dataOutputStream);
        }
        dataOutputStream.writeShort(this.attributes.size());
        for (int i13 = 0; i13 < this.attributes.size(); i13++) {
            ((Attribute) this.attributes.get(i13)).write(dataOutputStream);
        }
    }
}
