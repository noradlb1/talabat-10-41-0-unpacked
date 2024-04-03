package com.google.zxing.datamatrix.encoder;

import androidx.core.view.InputDeviceCompat;
import net.bytebuddy.jar.asm.Opcodes;

final class Base256Encoder implements Encoder {
    private static char randomize255State(char c11, int i11) {
        int i12 = c11 + ((i11 * Opcodes.FCMPL) % 255) + 1;
        return i12 <= 255 ? (char) i12 : (char) (i12 + InputDeviceCompat.SOURCE_ANY);
    }

    public void encode(EncoderContext encoderContext) {
        boolean z11;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(0);
        while (true) {
            if (!encoderContext.hasMoreCharacters()) {
                break;
            }
            sb2.append(encoderContext.getCurrentChar());
            encoderContext.pos++;
            if (HighLevelEncoder.lookAheadTest(encoderContext.getMessage(), encoderContext.pos, getEncodingMode()) != getEncodingMode()) {
                encoderContext.signalEncoderChange(0);
                break;
            }
        }
        int length = sb2.length() - 1;
        int codewordCount = encoderContext.getCodewordCount() + length + 1;
        encoderContext.updateSymbolInfo(codewordCount);
        if (encoderContext.getSymbolInfo().getDataCapacity() - codewordCount > 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (encoderContext.hasMoreCharacters() || z11) {
            if (length <= 249) {
                sb2.setCharAt(0, (char) length);
            } else if (length <= 1555) {
                sb2.setCharAt(0, (char) ((length / 250) + 249));
                sb2.insert(1, (char) (length % 250));
            } else {
                throw new IllegalStateException("Message length not in valid ranges: ".concat(String.valueOf(length)));
            }
        }
        int length2 = sb2.length();
        for (int i11 = 0; i11 < length2; i11++) {
            encoderContext.writeCodeword(randomize255State(sb2.charAt(i11), encoderContext.getCodewordCount() + 1));
        }
    }

    public int getEncodingMode() {
        return 5;
    }
}
