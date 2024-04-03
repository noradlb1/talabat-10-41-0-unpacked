package com.instabug.library.networkv2.connection;

import androidx.annotation.NonNull;
import com.instabug.library.networkv2.RequestResponse;
import com.instabug.library.networkv2.request.Request;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;

public class FileDownloadConnectionManager extends NormalConnectionManager {
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0035 A[SYNTHETIC, Splitter:B:25:0x0035] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0045  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void copyStream(java.net.HttpURLConnection r5, java.io.File r6) throws java.io.IOException {
        /*
            r4 = this;
            java.lang.String r0 = "Error while closing output stream"
            java.lang.String r1 = "IBG-Core"
            r2 = 0
            java.io.InputStream r5 = r5.getInputStream()     // Catch:{ all -> 0x0030 }
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ all -> 0x002e }
            r3.<init>(r6)     // Catch:{ all -> 0x002e }
        L_0x000e:
            int r6 = r5.read()     // Catch:{ all -> 0x002b }
            r2 = -1
            if (r6 == r2) goto L_0x0019
            r3.write(r6)     // Catch:{ all -> 0x002b }
            goto L_0x000e
        L_0x0019:
            r3.flush()     // Catch:{ IOException -> 0x001d }
            goto L_0x0020
        L_0x001d:
            com.instabug.library.util.InstabugSDKLogger.e(r1, r0)
        L_0x0020:
            r3.close()     // Catch:{ IOException -> 0x0024 }
            goto L_0x0027
        L_0x0024:
            com.instabug.library.util.InstabugSDKLogger.e(r1, r0)
        L_0x0027:
            r5.close()
            return
        L_0x002b:
            r6 = move-exception
            r2 = r3
            goto L_0x0033
        L_0x002e:
            r6 = move-exception
            goto L_0x0033
        L_0x0030:
            r5 = move-exception
            r6 = r5
            r5 = r2
        L_0x0033:
            if (r2 == 0) goto L_0x0043
            r2.flush()     // Catch:{ IOException -> 0x0039 }
            goto L_0x003c
        L_0x0039:
            com.instabug.library.util.InstabugSDKLogger.e(r1, r0)
        L_0x003c:
            r2.close()     // Catch:{ IOException -> 0x0040 }
            goto L_0x0043
        L_0x0040:
            com.instabug.library.util.InstabugSDKLogger.e(r1, r0)
        L_0x0043:
            if (r5 == 0) goto L_0x0048
            r5.close()
        L_0x0048:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.library.networkv2.connection.FileDownloadConnectionManager.copyStream(java.net.HttpURLConnection, java.io.File):void");
    }

    public RequestResponse handleResponse(HttpURLConnection httpURLConnection, @NonNull Request request) throws IOException {
        RequestResponse requestResponse = new RequestResponse();
        requestResponse.setResponseCode(httpURLConnection.getResponseCode());
        requestResponse.setHeaders(getHeaderFields(httpURLConnection));
        File downloadedFile = request.getDownloadedFile();
        if (downloadedFile != null) {
            copyStream(httpURLConnection, downloadedFile);
        } else {
            requestResponse.setResponseBody((Object) null);
        }
        requestResponse.setResponseBody(downloadedFile);
        httpURLConnection.disconnect();
        return requestResponse;
    }
}
