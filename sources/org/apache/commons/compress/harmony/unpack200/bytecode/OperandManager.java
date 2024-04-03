package org.apache.commons.compress.harmony.unpack200.bytecode;

import org.apache.commons.compress.harmony.unpack200.Segment;
import org.apache.commons.compress.harmony.unpack200.SegmentConstantPool;

public class OperandManager {
    int[] bcByte;
    int bcByteIndex;
    int[] bcCaseCount;
    int bcCaseCountIndex;
    int[] bcCaseValue;
    int bcCaseValueIndex;
    int[] bcClassRef;
    int bcClassRefIndex;
    int[] bcDoubleRef;
    int bcDoubleRefIndex;
    int[] bcFieldRef;
    int bcFieldRefIndex;
    int[] bcFloatRef;
    int bcFloatRefIndex;
    int[] bcIMethodRef;
    int bcIMethodRefIndex;
    int[] bcInitRef;
    int bcInitRefIndex;
    int[] bcIntRef;
    int bcIntRefIndex;
    int[] bcLabel;
    int bcLabelIndex;
    int[] bcLocal;
    int bcLocalIndex;
    int[] bcLongRef;
    int bcLongRefIndex;
    int[] bcMethodRef;
    int bcMethodRefIndex;
    int[] bcShort;
    int bcShortIndex;
    int[] bcStringRef;
    int bcStringRefIndex;
    int[] bcSuperField;
    int bcSuperFieldIndex;
    int[] bcSuperMethod;
    int bcSuperMethodIndex;
    int[] bcThisField;
    int bcThisFieldIndex;
    int[] bcThisMethod;
    int bcThisMethodIndex;
    String currentClass;
    String newClass;
    Segment segment;
    String superClass;
    int wideByteCodeIndex;
    int[] wideByteCodes;

    public OperandManager(int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4, int[] iArr5, int[] iArr6, int[] iArr7, int[] iArr8, int[] iArr9, int[] iArr10, int[] iArr11, int[] iArr12, int[] iArr13, int[] iArr14, int[] iArr15, int[] iArr16, int[] iArr17, int[] iArr18, int[] iArr19, int[] iArr20, int[] iArr21) {
        this.bcCaseCount = iArr;
        this.bcCaseValue = iArr2;
        this.bcByte = iArr3;
        this.bcShort = iArr4;
        this.bcLocal = iArr5;
        this.bcLabel = iArr6;
        this.bcIntRef = iArr7;
        this.bcFloatRef = iArr8;
        this.bcLongRef = iArr9;
        this.bcDoubleRef = iArr10;
        this.bcStringRef = iArr11;
        this.bcClassRef = iArr12;
        this.bcFieldRef = iArr13;
        this.bcMethodRef = iArr14;
        this.bcIMethodRef = iArr15;
        this.bcThisField = iArr16;
        this.bcSuperField = iArr17;
        this.bcThisMethod = iArr18;
        this.bcSuperMethod = iArr19;
        this.bcInitRef = iArr20;
        this.wideByteCodes = iArr21;
    }

    public String getCurrentClass() {
        String str = this.currentClass;
        if (str != null) {
            return str;
        }
        throw new Error("Current class not set yet");
    }

    public String getNewClass() {
        String str = this.newClass;
        if (str != null) {
            return str;
        }
        throw new Error("New class not set yet");
    }

    public String getSuperClass() {
        String str = this.superClass;
        if (str != null) {
            return str;
        }
        throw new Error("SuperClass not set yet");
    }

    public SegmentConstantPool globalConstantPool() {
        return this.segment.getConstantPool();
    }

    public int nextByte() {
        int[] iArr = this.bcByte;
        int i11 = this.bcByteIndex;
        this.bcByteIndex = i11 + 1;
        return iArr[i11];
    }

    public int nextCaseCount() {
        int[] iArr = this.bcCaseCount;
        int i11 = this.bcCaseCountIndex;
        this.bcCaseCountIndex = i11 + 1;
        return iArr[i11];
    }

    public int nextCaseValues() {
        int[] iArr = this.bcCaseValue;
        int i11 = this.bcCaseValueIndex;
        this.bcCaseValueIndex = i11 + 1;
        return iArr[i11];
    }

    public int nextClassRef() {
        int[] iArr = this.bcClassRef;
        int i11 = this.bcClassRefIndex;
        this.bcClassRefIndex = i11 + 1;
        return iArr[i11];
    }

    public int nextDoubleRef() {
        int[] iArr = this.bcDoubleRef;
        int i11 = this.bcDoubleRefIndex;
        this.bcDoubleRefIndex = i11 + 1;
        return iArr[i11];
    }

    public int nextFieldRef() {
        int[] iArr = this.bcFieldRef;
        int i11 = this.bcFieldRefIndex;
        this.bcFieldRefIndex = i11 + 1;
        return iArr[i11];
    }

    public int nextFloatRef() {
        int[] iArr = this.bcFloatRef;
        int i11 = this.bcFloatRefIndex;
        this.bcFloatRefIndex = i11 + 1;
        return iArr[i11];
    }

    public int nextIMethodRef() {
        int[] iArr = this.bcIMethodRef;
        int i11 = this.bcIMethodRefIndex;
        this.bcIMethodRefIndex = i11 + 1;
        return iArr[i11];
    }

    public int nextInitRef() {
        int[] iArr = this.bcInitRef;
        int i11 = this.bcInitRefIndex;
        this.bcInitRefIndex = i11 + 1;
        return iArr[i11];
    }

    public int nextIntRef() {
        int[] iArr = this.bcIntRef;
        int i11 = this.bcIntRefIndex;
        this.bcIntRefIndex = i11 + 1;
        return iArr[i11];
    }

    public int nextLabel() {
        int[] iArr = this.bcLabel;
        int i11 = this.bcLabelIndex;
        this.bcLabelIndex = i11 + 1;
        return iArr[i11];
    }

    public int nextLocal() {
        int[] iArr = this.bcLocal;
        int i11 = this.bcLocalIndex;
        this.bcLocalIndex = i11 + 1;
        return iArr[i11];
    }

    public int nextLongRef() {
        int[] iArr = this.bcLongRef;
        int i11 = this.bcLongRefIndex;
        this.bcLongRefIndex = i11 + 1;
        return iArr[i11];
    }

    public int nextMethodRef() {
        int[] iArr = this.bcMethodRef;
        int i11 = this.bcMethodRefIndex;
        this.bcMethodRefIndex = i11 + 1;
        return iArr[i11];
    }

    public int nextShort() {
        int[] iArr = this.bcShort;
        int i11 = this.bcShortIndex;
        this.bcShortIndex = i11 + 1;
        return iArr[i11];
    }

    public int nextStringRef() {
        int[] iArr = this.bcStringRef;
        int i11 = this.bcStringRefIndex;
        this.bcStringRefIndex = i11 + 1;
        return iArr[i11];
    }

    public int nextSuperFieldRef() {
        int[] iArr = this.bcSuperField;
        int i11 = this.bcSuperFieldIndex;
        this.bcSuperFieldIndex = i11 + 1;
        return iArr[i11];
    }

    public int nextSuperMethodRef() {
        int[] iArr = this.bcSuperMethod;
        int i11 = this.bcSuperMethodIndex;
        this.bcSuperMethodIndex = i11 + 1;
        return iArr[i11];
    }

    public int nextThisFieldRef() {
        int[] iArr = this.bcThisField;
        int i11 = this.bcThisFieldIndex;
        this.bcThisFieldIndex = i11 + 1;
        return iArr[i11];
    }

    public int nextThisMethodRef() {
        int[] iArr = this.bcThisMethod;
        int i11 = this.bcThisMethodIndex;
        this.bcThisMethodIndex = i11 + 1;
        return iArr[i11];
    }

    public int nextWideByteCode() {
        int[] iArr = this.wideByteCodes;
        int i11 = this.wideByteCodeIndex;
        this.wideByteCodeIndex = i11 + 1;
        return iArr[i11];
    }

    public void setCurrentClass(String str) {
        this.currentClass = str;
    }

    public void setNewClass(String str) {
        this.newClass = str;
    }

    public void setSegment(Segment segment2) {
        this.segment = segment2;
    }

    public void setSuperClass(String str) {
        this.superClass = str;
    }
}
