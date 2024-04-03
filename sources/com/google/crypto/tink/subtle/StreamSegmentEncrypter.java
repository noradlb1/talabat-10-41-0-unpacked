package com.google.crypto.tink.subtle;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;

public interface StreamSegmentEncrypter {
    void encryptSegment(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, boolean z11, ByteBuffer byteBuffer3) throws GeneralSecurityException;

    void encryptSegment(ByteBuffer byteBuffer, boolean z11, ByteBuffer byteBuffer2) throws GeneralSecurityException;

    ByteBuffer getHeader();
}
