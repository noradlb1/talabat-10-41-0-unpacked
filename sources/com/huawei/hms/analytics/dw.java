package com.huawei.hms.analytics;

import android.os.Bundle;
import com.huawei.hms.analytics.core.log.HiLog;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.zip.Deflater;
import org.json.JSONException;
import org.json.JSONObject;

public final class dw {
    private static final Charset lmn = Charset.forName("UTF-8");

    public static String lmn(File file) {
        byte[] bArr;
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                dk dkVar = new dk((byte) 0);
                byte[] bArr2 = new byte[1024];
                while (true) {
                    int read = fileInputStream2.read(bArr2);
                    if (read == -1) {
                        break;
                    } else if (read > 0) {
                        byte[] bArr3 = dkVar.lmn;
                        int length = bArr3.length;
                        int i11 = dkVar.klm;
                        if (length - i11 >= read) {
                            System.arraycopy(bArr2, 0, bArr3, i11, read);
                        } else {
                            byte[] bArr4 = new byte[((bArr3.length + read) << 1)];
                            System.arraycopy(bArr3, 0, bArr4, 0, i11);
                            System.arraycopy(bArr2, 0, bArr4, dkVar.klm, read);
                            dkVar.lmn = bArr4;
                        }
                        dkVar.klm += read;
                    }
                }
                int i12 = dkVar.klm;
                if (i12 == 0) {
                    lmn((Closeable) fileInputStream2);
                    return "";
                }
                if (i12 <= 0) {
                    bArr = new byte[0];
                } else {
                    byte[] bArr5 = new byte[i12];
                    System.arraycopy(dkVar.lmn, 0, bArr5, 0, i12);
                    bArr = bArr5;
                }
                String str = new String(bArr, lmn);
                lmn((Closeable) fileInputStream2);
                return str;
            } catch (FileNotFoundException unused) {
                fileInputStream = fileInputStream2;
                HiLog.w("StreamToolsKit", "getInfoFromFile(): No files need to be read");
                lmn((Closeable) fileInputStream);
                return "";
            } catch (IOException unused2) {
                fileInputStream = fileInputStream2;
                try {
                    HiLog.w("StreamToolsKit", "getInfoFromFile(): stream.read or new string exception");
                    lmn((Closeable) fileInputStream);
                    return "";
                } catch (Throwable th2) {
                    th = th2;
                    lmn((Closeable) fileInputStream);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                fileInputStream = fileInputStream2;
                lmn((Closeable) fileInputStream);
                throw th;
            }
        } catch (FileNotFoundException unused3) {
            HiLog.w("StreamToolsKit", "getInfoFromFile(): No files need to be read");
            lmn((Closeable) fileInputStream);
            return "";
        } catch (IOException unused4) {
            HiLog.w("StreamToolsKit", "getInfoFromFile(): stream.read or new string exception");
            lmn((Closeable) fileInputStream);
            return "";
        }
    }

    public static String lmn(CharSequence charSequence, CharSequence... charSequenceArr) {
        if (charSequenceArr == null || charSequenceArr.length == 0) {
            return "";
        }
        StringBuilder sb2 = null;
        for (CharSequence charSequence2 : charSequenceArr) {
            if (sb2 == null) {
                sb2 = new StringBuilder();
            } else {
                sb2.append(charSequence);
            }
            sb2.append(charSequence2);
        }
        return sb2.toString();
    }

    public static JSONObject lmn(Bundle bundle) {
        JSONObject jSONObject = new JSONObject();
        if (!(bundle == null || bundle.size() == 0)) {
            for (String next : bundle.keySet()) {
                try {
                    jSONObject.put(next, bundle.get(next));
                } catch (JSONException unused) {
                    HiLog.w("StreamToolsKit", "bundleToJSON exception");
                }
            }
        }
        return jSONObject;
    }

    private static void lmn(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
                HiLog.w("StreamToolsKit", "closeQuietly(): Exception when closing the closeable!");
            }
        }
    }

    public static void lmn(File file, String str) {
        FileOutputStream fileOutputStream = null;
        try {
            FileOutputStream fileOutputStream2 = new FileOutputStream(file);
            try {
                fileOutputStream2.write(str.getBytes("UTF-8"));
                fileOutputStream2.flush();
                lmn((Closeable) fileOutputStream2);
            } catch (FileNotFoundException unused) {
                fileOutputStream = fileOutputStream2;
                HiLog.w("StreamToolsKit", "saveInfoToFile(): No files need to be read");
                lmn((Closeable) fileOutputStream);
            } catch (IOException unused2) {
                fileOutputStream = fileOutputStream2;
                try {
                    HiLog.w("StreamToolsKit", "saveInfoToFile(): io exc from write info to file!");
                    lmn((Closeable) fileOutputStream);
                } catch (Throwable th2) {
                    th = th2;
                    lmn((Closeable) fileOutputStream);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream = fileOutputStream2;
                lmn((Closeable) fileOutputStream);
                throw th;
            }
        } catch (FileNotFoundException unused3) {
            HiLog.w("StreamToolsKit", "saveInfoToFile(): No files need to be read");
            lmn((Closeable) fileOutputStream);
        } catch (IOException unused4) {
            HiLog.w("StreamToolsKit", "saveInfoToFile(): io exc from write info to file!");
            lmn((Closeable) fileOutputStream);
        }
    }

    public static byte[] lmn(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Deflater deflater = new Deflater();
        try {
            deflater.setInput(bArr);
            deflater.finish();
            byte[] bArr2 = new byte[1024];
            while (!deflater.finished()) {
                byteArrayOutputStream.write(bArr2, 0, deflater.deflate(bArr2));
            }
            return byteArrayOutputStream.toByteArray();
        } finally {
            deflater.end();
            lmn((Closeable) byteArrayOutputStream);
        }
    }
}
