package com.huawei.location.lite.common.security;

import android.text.TextUtils;
import com.google.common.base.Ascii;
import com.huawei.location.lite.common.log.LogConsole;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.engines.SM4Engine;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.pqc.math.linearalgebra.ByteUtils;
import org.bouncycastle.util.encoders.Hex;

public class LW implements Vw {
    public String decrypt(String str, String str2) {
        return str;
    }

    public String encrypt(String str, String str2) {
        ByteBuffer byteBuffer;
        byte[] bArr;
        String str3;
        if (TextUtils.isEmpty(str2)) {
            return str;
        }
        try {
            byteBuffer = Charset.forName("UTF-8").newEncoder().encode(CharBuffer.wrap(str));
        } catch (CharacterCodingException unused) {
            LogConsole.e("SM4Security", "CharacterCodingException ");
            byteBuffer = null;
        }
        int i11 = 0;
        if (byteBuffer != null) {
            bArr = new byte[byteBuffer.limit()];
            byteBuffer.get(bArr);
        } else {
            bArr = new byte[0];
        }
        if (bArr.length <= 0) {
            return str;
        }
        byte[] fromHexString = ByteUtils.fromHexString(str2);
        SM4Engine sM4Engine = new SM4Engine();
        sM4Engine.init(true, new KeyParameter(fromHexString));
        if (bArr.length == 0) {
            LogConsole.e("SM4Security", "handlePKCS5Padding error");
        } else {
            int length = bArr.length;
            int i12 = 16 - (length % 16);
            int i13 = length + i12;
            byte[] bArr2 = new byte[i13];
            byte[] bArr3 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, Ascii.CR, Ascii.SO, Ascii.SI, Ascii.DLE};
            for (int i14 = 0; i14 < i13; i14++) {
                if (i14 < length) {
                    bArr2[i14] = bArr[i14];
                } else {
                    bArr2[i14] = bArr3[i12];
                }
            }
            bArr = bArr2;
        }
        int length2 = bArr.length;
        byte[] bArr4 = new byte[length2];
        int i15 = length2 / 16;
        while (i11 < i15) {
            int i16 = i11 * 16;
            try {
                sM4Engine.processBlock(bArr, i16, bArr4, i16);
                i11++;
            } catch (DataLengthException unused2) {
                str3 = "encryptBySm4OutByte DataLengthException";
                LogConsole.e("SM4Security", str3);
                return Hex.toHexString(bArr4);
            } catch (IllegalStateException unused3) {
                str3 = "encryptBySm4OutByte IllegalStateException";
                LogConsole.e("SM4Security", str3);
                return Hex.toHexString(bArr4);
            }
        }
        return Hex.toHexString(bArr4);
    }
}
