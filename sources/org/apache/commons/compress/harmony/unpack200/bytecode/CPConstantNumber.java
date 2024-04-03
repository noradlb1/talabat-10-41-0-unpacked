package org.apache.commons.compress.harmony.unpack200.bytecode;

public abstract class CPConstantNumber extends CPConstant {
    public CPConstantNumber(byte b11, Object obj, int i11) {
        super(b11, obj, i11);
    }

    public Number getNumber() {
        return (Number) getValue();
    }
}
