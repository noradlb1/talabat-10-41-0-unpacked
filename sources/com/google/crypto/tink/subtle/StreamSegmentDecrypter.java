package com.google.crypto.tink.subtle;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;

public interface StreamSegmentDecrypter {
    void decryptSegment(ByteBuffer byteBuffer, int i11, boolean z11, ByteBuffer byteBuffer2) throws GeneralSecurityException;

    void init(ByteBuffer byteBuffer, byte[] bArr) throws GeneralSecurityException;
}
