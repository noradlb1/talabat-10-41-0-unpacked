package com.newrelic.agent.android.util;

import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.Deflater;

public class Deflator {
    private static final AgentLog log = AgentLogManager.getAgentLog();

    public static byte[] deflate(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream;
        Deflater deflater = new Deflater();
        try {
            deflater.setInput(bArr);
            deflater.finish();
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] bArr2 = new byte[8192];
                while (!deflater.finished()) {
                    int deflate = deflater.deflate(bArr2);
                    if (deflate <= 0) {
                        log.error("HTTP request contains an incomplete payload");
                    }
                    byteArrayOutputStream.write(bArr2, 0, deflate);
                }
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                return byteArray;
            } catch (IOException unused) {
                deflater.end();
                return bArr;
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        } finally {
            deflater.end();
        }
    }
}
