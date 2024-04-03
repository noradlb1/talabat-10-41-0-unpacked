package com.google.zxing.aztec.encoder;

import com.google.zxing.common.BitArray;
import java.util.LinkedList;

final class State {
    static final State INITIAL_STATE = new State(Token.EMPTY, 0, 0, 0);
    private final int binaryShiftByteCount;
    private final int bitCount;
    private final int mode;
    private final Token token;

    private State(Token token2, int i11, int i12, int i13) {
        this.token = token2;
        this.mode = i11;
        this.binaryShiftByteCount = i12;
        this.bitCount = i13;
    }

    public State addBinaryShiftChar(int i11) {
        int i12;
        Token token2 = this.token;
        int i13 = this.mode;
        int i14 = this.bitCount;
        if (i13 == 4 || i13 == 2) {
            int i15 = HighLevelEncoder.LATCH_TABLE[i13][0];
            int i16 = 65535 & i15;
            int i17 = i15 >> 16;
            token2 = token2.add(i16, i17);
            i14 += i17;
            i13 = 0;
        }
        int i18 = this.binaryShiftByteCount;
        if (i18 == 0 || i18 == 31) {
            i12 = 18;
        } else if (i18 == 62) {
            i12 = 9;
        } else {
            i12 = 8;
        }
        State state = new State(token2, i13, i18 + 1, i14 + i12);
        if (state.binaryShiftByteCount == 2078) {
            return state.endBinaryShift(i11 + 1);
        }
        return state;
    }

    public State endBinaryShift(int i11) {
        int i12 = this.binaryShiftByteCount;
        if (i12 == 0) {
            return this;
        }
        return new State(this.token.addBinaryShift(i11 - i12, i12), this.mode, 0, this.bitCount);
    }

    public int getBinaryShiftByteCount() {
        return this.binaryShiftByteCount;
    }

    public int getBitCount() {
        return this.bitCount;
    }

    public int getMode() {
        return this.mode;
    }

    public Token getToken() {
        return this.token;
    }

    public boolean isBetterThanOrEqualTo(State state) {
        int i11;
        int i12 = this.bitCount + (HighLevelEncoder.LATCH_TABLE[this.mode][state.mode] >> 16);
        int i13 = state.binaryShiftByteCount;
        if (i13 > 0 && ((i11 = this.binaryShiftByteCount) == 0 || i11 > i13)) {
            i12 += 10;
        }
        if (i12 <= state.bitCount) {
            return true;
        }
        return false;
    }

    public State latchAndAppend(int i11, int i12) {
        int i13;
        int i14 = this.bitCount;
        Token token2 = this.token;
        int i15 = this.mode;
        if (i11 != i15) {
            int i16 = HighLevelEncoder.LATCH_TABLE[i15][i11];
            int i17 = 65535 & i16;
            int i18 = i16 >> 16;
            token2 = token2.add(i17, i18);
            i14 += i18;
        }
        if (i11 == 2) {
            i13 = 4;
        } else {
            i13 = 5;
        }
        return new State(token2.add(i12, i13), i11, 0, i14 + i13);
    }

    public State shiftAndAppend(int i11, int i12) {
        int i13;
        Token token2 = this.token;
        int i14 = this.mode;
        if (i14 == 2) {
            i13 = 4;
        } else {
            i13 = 5;
        }
        return new State(token2.add(HighLevelEncoder.SHIFT_TABLE[i14][i11], i13).add(i12, 5), this.mode, 0, this.bitCount + i13 + 5);
    }

    public BitArray toBitArray(byte[] bArr) {
        LinkedList<Token> linkedList = new LinkedList<>();
        for (Token token2 = endBinaryShift(bArr.length).token; token2 != null; token2 = token2.getPrevious()) {
            linkedList.addFirst(token2);
        }
        BitArray bitArray = new BitArray();
        for (Token appendTo : linkedList) {
            appendTo.appendTo(bitArray, bArr);
        }
        return bitArray;
    }

    public String toString() {
        return String.format("%s bits=%d bytes=%d", new Object[]{HighLevelEncoder.MODE_NAMES[this.mode], Integer.valueOf(this.bitCount), Integer.valueOf(this.binaryShiftByteCount)});
    }
}
