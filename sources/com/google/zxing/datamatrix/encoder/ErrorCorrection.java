package com.google.zxing.datamatrix.encoder;

import com.google.android.exoplayer2.extractor.ts.PsExtractor;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.tagmanager.ModuleDescriptor;
import net.bytebuddy.jar.asm.Opcodes;

public final class ErrorCorrection {
    private static final int[] ALOG = new int[255];
    private static final int[][] FACTORS = {new int[]{228, 48, 15, 111, 62}, new int[]{23, 68, Opcodes.D2F, 134, PsExtractor.VIDEO_STREAM_MASK, 92, 254}, new int[]{28, 24, Opcodes.INVOKEINTERFACE, Opcodes.IF_ACMPNE, 223, 248, 116, 255, 110, 61}, new int[]{Opcodes.DRETURN, 138, 205, 12, Opcodes.MONITORENTER, Opcodes.JSR, 39, 245, 60, 97, 120}, new int[]{41, Opcodes.IFEQ, Opcodes.IFLE, 91, 61, 42, Opcodes.D2I, 213, 97, Opcodes.GETSTATIC, 100, 242}, new int[]{Opcodes.IFGE, 97, 192, 252, 95, 9, Opcodes.IFGT, 119, 138, 45, 18, Opcodes.INVOKEDYNAMIC, 83, Opcodes.INVOKEINTERFACE}, new int[]{83, Opcodes.MONITOREXIT, 100, 39, 188, 75, 66, 61, 241, 213, 109, 129, 94, 254, 225, 48, 90, 188}, new int[]{15, Opcodes.MONITOREXIT, 244, 9, 233, 71, Opcodes.JSR, 2, 188, Opcodes.IF_ICMPNE, Opcodes.IFEQ, Opcodes.I2B, 253, 79, 108, 82, 27, Opcodes.FRETURN, Opcodes.INVOKEDYNAMIC, 172}, new int[]{52, 190, 88, 205, 109, 39, Opcodes.ARETURN, 21, 155, Opcodes.MULTIANEWARRAY, 251, 223, 155, 21, 5, 172, 254, 124, 12, Opcodes.PUTFIELD, Opcodes.INVOKESTATIC, 96, 50, Opcodes.INSTANCEOF}, new int[]{211, 231, 43, 97, 71, 96, 103, Opcodes.FRETURN, 37, Opcodes.DCMPL, Opcodes.TABLESWITCH, 53, 75, 34, 249, 121, 17, 138, 110, 213, Opcodes.F2D, Opcodes.L2I, 120, Opcodes.DCMPL, 233, Opcodes.JSR, 93, 255}, new int[]{245, 127, 242, 218, 130, 250, Opcodes.IF_ICMPGE, Opcodes.PUTFIELD, 102, 120, 84, Opcodes.PUTSTATIC, 220, 251, 80, Opcodes.INVOKEVIRTUAL, 229, 18, 2, 4, 68, 33, 101, Opcodes.L2F, 95, 119, 115, 44, Opcodes.DRETURN, Opcodes.INVOKESTATIC, 59, 25, 225, 98, 81, 112}, new int[]{77, Opcodes.INSTANCEOF, Opcodes.L2F, 31, 19, 38, 22, Opcodes.IFEQ, 247, 105, 122, 2, 245, Opcodes.I2L, 242, 8, Opcodes.DRETURN, 95, 100, 9, Opcodes.GOTO, 105, ModuleDescriptor.MODULE_VERSION, 111, 57, 121, 21, 1, 253, 57, 54, 101, 248, 202, 69, 50, 150, Opcodes.RETURN, 226, 5, 9, 5}, new int[]{245, Opcodes.IINC, 172, 223, 96, 32, 117, 22, 238, Opcodes.I2L, 238, 231, 205, 188, 237, 87, Opcodes.ATHROW, 106, 16, Opcodes.I2S, 118, 23, 37, 90, Opcodes.TABLESWITCH, 205, 131, 88, 120, 100, 66, 138, Opcodes.INVOKEDYNAMIC, PsExtractor.VIDEO_STREAM_MASK, 82, 44, Opcodes.ARETURN, 87, Opcodes.NEW, Opcodes.I2S, Opcodes.IF_ICMPNE, Opcodes.DRETURN, 69, 213, 92, 253, 225, 19}, new int[]{Opcodes.DRETURN, 9, 223, 238, 12, 17, 220, 208, 100, 29, Opcodes.DRETURN, Opcodes.TABLESWITCH, 230, 192, 215, 235, 150, Opcodes.IF_ICMPEQ, 36, 223, 38, 200, Opcodes.IINC, 54, 228, Opcodes.I2C, 218, 234, 117, 203, 29, 232, Opcodes.D2F, 238, 22, 150, 201, 117, 62, 207, Opcodes.IF_ICMPLE, 13, Opcodes.L2F, 245, 127, 67, 247, 28, 155, 43, 203, 107, 233, 53, Opcodes.D2L, 46}, new int[]{242, 93, Opcodes.RET, 50, Opcodes.D2F, 210, 39, 118, 202, 188, 201, 189, Opcodes.D2L, 108, 196, 37, Opcodes.INVOKEINTERFACE, 112, 134, 230, 245, 63, Opcodes.MULTIANEWARRAY, 190, 250, 106, Opcodes.INVOKEINTERFACE, 221, Opcodes.DRETURN, 64, 114, 71, Opcodes.IF_ICMPLT, 44, Opcodes.I2S, 6, 27, 218, 51, 63, 87, 10, 40, 130, 188, 17, Opcodes.IF_ICMPGT, 31, Opcodes.ARETURN, Opcodes.TABLESWITCH, 4, 107, 232, 7, 94, Opcodes.IF_ACMPNE, 224, 124, 86, 47, 11, 204}, new int[]{220, 228, Opcodes.LRETURN, 89, 251, Opcodes.FCMPL, Opcodes.IF_ICMPEQ, 56, 89, 33, Opcodes.I2S, 244, Opcodes.IFNE, 36, 73, 127, 213, Opcodes.L2I, 248, 180, 234, Opcodes.MULTIANEWARRAY, Opcodes.IFLE, Opcodes.RETURN, 68, 122, 93, 213, 15, Opcodes.IF_ICMPNE, 227, 236, 66, Opcodes.F2I, Opcodes.IFEQ, Opcodes.INVOKEINTERFACE, 202, Opcodes.GOTO, Opcodes.PUTSTATIC, 25, 220, 232, 96, 210, 231, Opcodes.L2I, 223, 239, Opcodes.PUTFIELD, 241, 59, 52, 172, 25, 49, 232, 211, 189, 64, 54, 108, Opcodes.IFEQ, Opcodes.IINC, 63, 96, 103, 82, Opcodes.INVOKEDYNAMIC}};
    private static final int[] FACTOR_SETS = {5, 7, 10, 11, 12, 14, 18, 20, 24, 28, 36, 42, 48, 56, 62, 68};
    private static final int[] LOG = new int[256];
    private static final int MODULO_VALUE = 301;

    static {
        int i11 = 1;
        for (int i12 = 0; i12 < 255; i12++) {
            ALOG[i12] = i11;
            LOG[i11] = i12;
            i11 <<= 1;
            if (i11 >= 256) {
                i11 ^= 301;
            }
        }
    }

    private ErrorCorrection() {
    }

    private static String createECCBlock(CharSequence charSequence, int i11) {
        return createECCBlock(charSequence, 0, charSequence.length(), i11);
    }

    public static String encodeECC200(String str, SymbolInfo symbolInfo) {
        if (str.length() == symbolInfo.getDataCapacity()) {
            StringBuilder sb2 = new StringBuilder(symbolInfo.getDataCapacity() + symbolInfo.getErrorCodewords());
            sb2.append(str);
            int interleavedBlockCount = symbolInfo.getInterleavedBlockCount();
            if (interleavedBlockCount == 1) {
                sb2.append(createECCBlock(str, symbolInfo.getErrorCodewords()));
            } else {
                sb2.setLength(sb2.capacity());
                int[] iArr = new int[interleavedBlockCount];
                int[] iArr2 = new int[interleavedBlockCount];
                int[] iArr3 = new int[interleavedBlockCount];
                int i11 = 0;
                while (i11 < interleavedBlockCount) {
                    int i12 = i11 + 1;
                    iArr[i11] = symbolInfo.getDataLengthForInterleavedBlock(i12);
                    iArr2[i11] = symbolInfo.getErrorLengthForInterleavedBlock(i12);
                    iArr3[i11] = 0;
                    if (i11 > 0) {
                        iArr3[i11] = iArr3[i11 - 1] + iArr[i11];
                    }
                    i11 = i12;
                }
                for (int i13 = 0; i13 < interleavedBlockCount; i13++) {
                    StringBuilder sb3 = new StringBuilder(iArr[i13]);
                    for (int i14 = i13; i14 < symbolInfo.getDataCapacity(); i14 += interleavedBlockCount) {
                        sb3.append(str.charAt(i14));
                    }
                    String createECCBlock = createECCBlock(sb3.toString(), iArr2[i13]);
                    int i15 = i13;
                    int i16 = 0;
                    while (i15 < iArr2[i13] * interleavedBlockCount) {
                        sb2.setCharAt(symbolInfo.getDataCapacity() + i15, createECCBlock.charAt(i16));
                        i15 += interleavedBlockCount;
                        i16++;
                    }
                }
            }
            return sb2.toString();
        }
        throw new IllegalArgumentException("The number of codewords does not match the selected symbol");
    }

    private static String createECCBlock(CharSequence charSequence, int i11, int i12, int i13) {
        int i14;
        int i15;
        int i16 = 0;
        while (true) {
            int[] iArr = FACTOR_SETS;
            if (i16 >= iArr.length) {
                i16 = -1;
                break;
            } else if (iArr[i16] == i13) {
                break;
            } else {
                i16++;
            }
        }
        if (i16 >= 0) {
            int[] iArr2 = FACTORS[i16];
            char[] cArr = new char[i13];
            for (int i17 = 0; i17 < i13; i17++) {
                cArr[i17] = 0;
            }
            for (int i18 = i11; i18 < i11 + i12; i18++) {
                int i19 = i13 - 1;
                char charAt = cArr[i19] ^ charSequence.charAt(i18);
                while (i19 > 0) {
                    if (charAt == 0 || (i15 = iArr2[i19]) == 0) {
                        cArr[i19] = cArr[i19 - 1];
                    } else {
                        char c11 = cArr[i19 - 1];
                        int[] iArr3 = ALOG;
                        int[] iArr4 = LOG;
                        cArr[i19] = (char) (iArr3[(iArr4[charAt] + iArr4[i15]) % 255] ^ c11);
                    }
                    i19--;
                }
                if (charAt == 0 || (i14 = iArr2[0]) == 0) {
                    cArr[0] = 0;
                } else {
                    int[] iArr5 = ALOG;
                    int[] iArr6 = LOG;
                    cArr[0] = (char) iArr5[(iArr6[charAt] + iArr6[i14]) % 255];
                }
            }
            char[] cArr2 = new char[i13];
            for (int i21 = 0; i21 < i13; i21++) {
                cArr2[i21] = cArr[(i13 - i21) - 1];
            }
            return String.valueOf(cArr2);
        }
        throw new IllegalArgumentException("Illegal number of error correction codewords specified: ".concat(String.valueOf(i13)));
    }
}
