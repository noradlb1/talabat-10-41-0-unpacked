package com.google.zxing.datamatrix.encoder;

import net.bytebuddy.jar.asm.Opcodes;

final class DataMatrixSymbolInfo144 extends SymbolInfo {
    public DataMatrixSymbolInfo144() {
        super(false, 1558, 620, 22, 22, 36, -1, 62);
    }

    public int getDataLengthForInterleavedBlock(int i11) {
        if (i11 <= 8) {
            return Opcodes.IFGE;
        }
        return 155;
    }

    public int getInterleavedBlockCount() {
        return 10;
    }
}
