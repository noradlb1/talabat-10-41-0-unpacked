package com.uxcam.internals;

import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import javax.crypto.CipherOutputStream;
import org.json.JSONObject;

@Instrumented
public class il {

    /* renamed from: a  reason: collision with root package name */
    public final File f13643a;

    /* renamed from: b  reason: collision with root package name */
    public File f13644b;

    public il(File file) {
        this.f13643a = file;
    }

    public void a() {
        hj hjVar = new hj();
        FileOutputStream fileOutputStream = new FileOutputStream(new File(this.f13643a.getParentFile(), "video.zip"));
        ZipOutputStream zipOutputStream = new ZipOutputStream(fileOutputStream);
        byte[] bArr = new byte[16384];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        this.f13644b = new File(this.f13643a.getParentFile(), "video.aes");
        FileOutputStream fileOutputStream2 = new FileOutputStream(this.f13644b);
        CipherOutputStream a11 = hjVar.a(fileOutputStream2);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(this.f13643a), 16384);
        while (true) {
            int read = bufferedInputStream.read(bArr, 0, 16384);
            if (read == -1) {
                break;
            }
            a11.write(bArr, 0, read);
            byteArrayOutputStream.write(bArr, 0, read);
        }
        a11.close();
        bufferedInputStream.close();
        fileOutputStream2.close();
        zipOutputStream.putNextEntry(new ZipEntry("video.mp4.aes"));
        byte[] bArr2 = new byte[16384];
        FileInputStream fileInputStream = new FileInputStream(this.f13644b);
        while (true) {
            int read2 = fileInputStream.read(bArr2, 0, 16384);
            if (read2 != -1) {
                zipOutputStream.write(bArr2, 0, read2);
            } else {
                fileInputStream.close();
                zipOutputStream.closeEntry();
                zipOutputStream.putNextEntry(new ZipEntry("metadata.json"));
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("decryptKey", (Object) hjVar.c());
                jSONObject.put("decryptiv", (Object) hjVar.b());
                zipOutputStream.write(JSONObjectInstrumentation.toString(jSONObject).getBytes());
                zipOutputStream.closeEntry();
                zipOutputStream.close();
                fileOutputStream.close();
                return;
            }
        }
    }
}
