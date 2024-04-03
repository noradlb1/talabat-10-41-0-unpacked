package com.newrelic.agent.android.util;

public interface Encoder {
    String encode(byte[] bArr);

    String encodeNoWrap(byte[] bArr);
}
