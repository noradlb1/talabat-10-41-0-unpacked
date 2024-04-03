package com.uxcam.video.screen.codec.codecs.h264.io.model;

import com.uxcam.internals.ak;
import java.nio.ByteBuffer;
import java.util.ArrayList;

public class SEI {
    public SEIMessage[] messages;

    public static class SEIMessage {
        public byte[] payload;
        public int payloadSize;
        public int payloadType;

        public SEIMessage(int i11, int i12, byte[] bArr) {
            this.payload = bArr;
            this.payloadType = i11;
            this.payloadSize = i12;
        }
    }

    public SEI(SEIMessage[] sEIMessageArr) {
        this.messages = sEIMessageArr;
    }

    public static SEI read(ByteBuffer byteBuffer) {
        SEIMessage sei_message;
        ArrayList arrayList = new ArrayList();
        do {
            sei_message = sei_message(byteBuffer);
            if (sei_message != null) {
                arrayList.add(sei_message);
                continue;
            }
        } while (sei_message != null);
        return new SEI((SEIMessage[]) arrayList.toArray(new SEIMessage[0]));
    }

    private static SEIMessage sei_message(ByteBuffer byteBuffer) {
        byte b11;
        byte b12;
        int i11 = 0;
        int i12 = 0;
        while (true) {
            b11 = byteBuffer.get() & 255;
            if (b11 != 255) {
                break;
            }
            i12 += 255;
        }
        if (b11 == -1) {
            return null;
        }
        int i13 = i12 + b11;
        while (true) {
            b12 = byteBuffer.get() & 255;
            if (b12 != 255) {
                break;
            }
            i11 += 255;
        }
        if (b12 == -1) {
            return null;
        }
        int i14 = i11 + b12;
        byte[] sei_payload = sei_payload(i13, i14, byteBuffer);
        if (sei_payload.length != i14) {
            return null;
        }
        return new SEIMessage(i13, i14, sei_payload);
    }

    private static byte[] sei_payload(int i11, int i12, ByteBuffer byteBuffer) {
        byte[] bArr = new byte[i12];
        byteBuffer.get(bArr);
        return bArr;
    }

    public void write(ByteBuffer byteBuffer) {
        ak akVar = new ak(byteBuffer);
        akVar.b(1);
        akVar.a();
    }
}
