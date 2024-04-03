package org.apache.commons.compress.harmony.unpack200.bytecode;

import java.io.DataOutputStream;
import java.io.IOException;
import org.apache.commons.compress.harmony.unpack200.Segment;
import org.apache.commons.compress.harmony.unpack200.bytecode.forms.ByteCodeForm;

public class ByteCode extends ClassFileEntry {
    private static ByteCode[] noArgByteCodes = new ByteCode[255];
    private final ByteCodeForm byteCodeForm;
    private int byteCodeOffset;
    private int[] byteCodeTargets;
    private ClassFileEntry[] nested;
    private int[][] nestedPositions;
    private int[] rewrite;

    public ByteCode(int i11) {
        this(i11, ClassFileEntry.NONE);
    }

    public static ByteCode getByteCode(int i11) {
        int i12 = i11 & 255;
        if (!ByteCodeForm.get(i12).hasNoOperand()) {
            return new ByteCode(i12);
        }
        ByteCode[] byteCodeArr = noArgByteCodes;
        if (byteCodeArr[i12] == null) {
            byteCodeArr[i12] = new ByteCode(i12);
        }
        return noArgByteCodes[i12];
    }

    public void applyByteCodeTargetFixup(CodeAttribute codeAttribute) {
        getByteCodeForm().fixUpByteCodeTargets(this, codeAttribute);
    }

    public void doWrite(DataOutputStream dataOutputStream) throws IOException {
        int i11 = 0;
        while (true) {
            int[] iArr = this.rewrite;
            if (i11 < iArr.length) {
                dataOutputStream.writeByte(iArr[i11]);
                i11++;
            } else {
                return;
            }
        }
    }

    public boolean equals(Object obj) {
        return this == obj;
    }

    public void extractOperands(OperandManager operandManager, Segment segment, int i11) {
        getByteCodeForm().setByteCodeOperands(this, operandManager, i11);
    }

    public ByteCodeForm getByteCodeForm() {
        return this.byteCodeForm;
    }

    public int getByteCodeIndex() {
        return this.byteCodeOffset;
    }

    public int[] getByteCodeTargets() {
        return this.byteCodeTargets;
    }

    public int getLength() {
        return this.rewrite.length;
    }

    public String getName() {
        return getByteCodeForm().getName();
    }

    public ClassFileEntry[] getNestedClassFileEntries() {
        return this.nested;
    }

    public int[] getNestedPosition(int i11) {
        return getNestedPositions()[i11];
    }

    public int[][] getNestedPositions() {
        return this.nestedPositions;
    }

    public int getOpcode() {
        return getByteCodeForm().getOpcode();
    }

    public int[] getRewrite() {
        return this.rewrite;
    }

    public boolean hasMultipleByteCodes() {
        return getByteCodeForm().hasMultipleByteCodes();
    }

    public int hashCode() {
        return objectHashCode();
    }

    public boolean nestedMustStartClassPool() {
        return this.byteCodeForm.nestedMustStartClassPool();
    }

    public void resolve(ClassConstantPool classConstantPool) {
        super.resolve(classConstantPool);
        if (this.nested.length > 0) {
            for (int i11 = 0; i11 < this.nested.length; i11++) {
                int i12 = getNestedPosition(i11)[1];
                if (i12 == 1) {
                    setOperandByte(classConstantPool.indexOf(this.nested[i11]), getNestedPosition(i11)[0]);
                } else if (i12 == 2) {
                    setOperand2Bytes(classConstantPool.indexOf(this.nested[i11]), getNestedPosition(i11)[0]);
                } else {
                    throw new Error("Unhandled resolve " + this);
                }
            }
        }
    }

    public void setByteCodeIndex(int i11) {
        this.byteCodeOffset = i11;
    }

    public void setByteCodeTargets(int[] iArr) {
        this.byteCodeTargets = iArr;
    }

    public void setNested(ClassFileEntry[] classFileEntryArr) {
        this.nested = classFileEntryArr;
    }

    public void setNestedPositions(int[][] iArr) {
        this.nestedPositions = iArr;
    }

    public void setOperand2Bytes(int i11, int i12) {
        int firstOperandIndex = getByteCodeForm().firstOperandIndex();
        int length = getByteCodeForm().getRewrite().length;
        if (firstOperandIndex >= 1) {
            int i13 = firstOperandIndex + i12;
            int i14 = i13 + 1;
            if (i14 <= length) {
                int[] iArr = this.rewrite;
                iArr[i13] = (65280 & i11) >> 8;
                iArr[i14] = i11 & 255;
                return;
            }
            throw new Error("Trying to rewrite " + this + " with an int at position " + i12 + " but this won't fit in the rewrite array");
        }
        throw new Error("Trying to rewrite " + this + " that has no rewrite");
    }

    public void setOperandByte(int i11, int i12) {
        int firstOperandIndex = getByteCodeForm().firstOperandIndex();
        int operandLength = getByteCodeForm().operandLength();
        if (firstOperandIndex >= 1) {
            int i13 = firstOperandIndex + i12;
            if (i13 <= operandLength) {
                this.rewrite[i13] = i11 & 255;
                return;
            }
            throw new Error("Trying to rewrite " + this + " with an byte at position " + i12 + " but this won't fit in the rewrite array");
        }
        throw new Error("Trying to rewrite " + this + " that has no rewrite");
    }

    public void setOperandBytes(int[] iArr) {
        int firstOperandIndex = getByteCodeForm().firstOperandIndex();
        int operandLength = getByteCodeForm().operandLength();
        if (firstOperandIndex < 1) {
            throw new Error("Trying to rewrite " + this + " that has no rewrite");
        } else if (operandLength == iArr.length) {
            for (int i11 = 0; i11 < operandLength; i11++) {
                this.rewrite[i11 + firstOperandIndex] = iArr[i11] & 255;
            }
        } else {
            throw new Error("Trying to rewrite " + this + " with " + iArr.length + " but bytecode has length " + this.byteCodeForm.operandLength());
        }
    }

    public void setOperandSigned2Bytes(int i11, int i12) {
        if (i11 >= 0) {
            setOperand2Bytes(i11, i12);
        } else {
            setOperand2Bytes(i11 + 65536, i12);
        }
    }

    public void setRewrite(int[] iArr) {
        this.rewrite = iArr;
    }

    public String toString() {
        return getByteCodeForm().getName();
    }

    public ByteCode(int i11, ClassFileEntry[] classFileEntryArr) {
        this.byteCodeOffset = -1;
        ByteCodeForm byteCodeForm2 = ByteCodeForm.get(i11);
        this.byteCodeForm = byteCodeForm2;
        this.rewrite = byteCodeForm2.getRewriteCopy();
        this.nested = classFileEntryArr;
    }
}
