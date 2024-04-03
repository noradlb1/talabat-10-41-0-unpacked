package com.instabug.library.networkv2;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import org.json.HTTP;

public class e {

    /* renamed from: a  reason: collision with root package name */
    private final String f51652a;

    /* renamed from: b  reason: collision with root package name */
    private OutputStream f51653b;

    /* renamed from: c  reason: collision with root package name */
    private PrintWriter f51654c = new PrintWriter(new OutputStreamWriter(this.f51653b, "UTF-8"), true);

    public e(HttpURLConnection httpURLConnection) throws IOException {
        String str = "===" + System.currentTimeMillis() + "===";
        this.f51652a = str;
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setDoInput(true);
        httpURLConnection.setChunkedStreamingMode(1048576);
        httpURLConnection.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + str);
        this.f51653b = httpURLConnection.getOutputStream();
    }

    public void a(String str, String str2) {
        this.f51654c.append("--").append(this.f51652a).append(HTTP.CRLF);
        this.f51654c.append("Content-Disposition: form-data; name=\"").append(str).append("\"").append(HTTP.CRLF);
        this.f51654c.append(HTTP.CRLF);
        this.f51654c.append(str2).append(HTTP.CRLF);
        this.f51654c.flush();
    }

    public void a(String str, String str2, String str3, String str4) throws IOException {
        this.f51654c.append("--").append(this.f51652a).append(HTTP.CRLF).append("Content-Disposition: file; name=\"").append(str).append("\"; filename=\"").append(str3).append("\"").append(HTTP.CRLF).append("Content-Type: ").append(str4).append(HTTP.CRLF).append(HTTP.CRLF).flush();
        FileInputStream fileInputStream = new FileInputStream(str2);
        try {
            byte[] bArr = new byte[1048576];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read != -1) {
                    this.f51653b.write(bArr, 0, read);
                } else {
                    this.f51653b.flush();
                    this.f51654c.append(HTTP.CRLF);
                    this.f51654c.flush();
                    return;
                }
            }
        } finally {
            fileInputStream.close();
        }
    }

    public void a() {
        this.f51654c.append(HTTP.CRLF).flush();
        this.f51654c.append("--").append(this.f51652a).append("--").append(HTTP.CRLF);
        this.f51654c.close();
    }
}
