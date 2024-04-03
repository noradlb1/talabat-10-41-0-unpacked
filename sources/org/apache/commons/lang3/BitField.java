package org.apache.commons.lang3;

public class BitField {
    private final int _mask;
    private final int _shift_count;

    public BitField(int i11) {
        this._mask = i11;
        int i12 = 0;
        if (i11 != 0) {
            while ((i11 & 1) == 0) {
                i12++;
                i11 >>= 1;
            }
        }
        this._shift_count = i12;
    }

    public int clear(int i11) {
        return i11 & (~this._mask);
    }

    public byte clearByte(byte b11) {
        return (byte) clear(b11);
    }

    public short clearShort(short s11) {
        return (short) clear(s11);
    }

    public int getRawValue(int i11) {
        return i11 & this._mask;
    }

    public short getShortRawValue(short s11) {
        return (short) getRawValue(s11);
    }

    public short getShortValue(short s11) {
        return (short) getValue(s11);
    }

    public int getValue(int i11) {
        return getRawValue(i11) >> this._shift_count;
    }

    public boolean isAllSet(int i11) {
        int i12 = this._mask;
        return (i11 & i12) == i12;
    }

    public boolean isSet(int i11) {
        return (i11 & this._mask) != 0;
    }

    public int set(int i11) {
        return i11 | this._mask;
    }

    public int setBoolean(int i11, boolean z11) {
        return z11 ? set(i11) : clear(i11);
    }

    public byte setByte(byte b11) {
        return (byte) set(b11);
    }

    public byte setByteBoolean(byte b11, boolean z11) {
        return z11 ? setByte(b11) : clearByte(b11);
    }

    public short setShort(short s11) {
        return (short) set(s11);
    }

    public short setShortBoolean(short s11, boolean z11) {
        return z11 ? setShort(s11) : clearShort(s11);
    }

    public short setShortValue(short s11, short s12) {
        return (short) setValue(s11, s12);
    }

    public int setValue(int i11, int i12) {
        int i13 = this._mask;
        return (i11 & (~i13)) | ((i12 << this._shift_count) & i13);
    }
}
