package com.huawei.location.lite.common.http.response;

import android.content.Context;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.huawei.location.lite.common.android.context.ContextUtil;
import com.huawei.location.lite.common.log.LogConsole;
import com.huawei.location.lite.common.util.SDKComponentType;
import java.io.File;
import java.nio.charset.StandardCharsets;

public class ResponseInfo implements Parcelable {
    public static final Parcelable.Creator<ResponseInfo> CREATOR = new Parcelable.Creator<ResponseInfo>() {
        public ResponseInfo createFromParcel(Parcel parcel) {
            return new ResponseInfo(parcel);
        }

        public ResponseInfo[] newArray(int i11) {
            return new ResponseInfo[i11];
        }
    };
    public static final int ERROR_EXCEPTION_LEVEL = 100;
    public static final int FAILURE_EXCEPTION_LEVEL = 101;
    private static final int MAX_TRANSFER_DATA_LIMIT = 468992;
    private static final String TAG = "ResponseInfo";
    private String bigDataPath;
    private int errorCode;
    private int errorLevel;
    private String msg;
    private byte[] responseBytes;
    private String responseString;

    public ResponseInfo() {
    }

    public ResponseInfo(Parcel parcel) {
        this.errorLevel = parcel.readInt();
        this.errorCode = parcel.readInt();
        this.msg = parcel.readString();
        this.responseString = parcel.readString();
        this.responseBytes = parcel.createByteArray();
        this.bigDataPath = parcel.readString();
    }

    private String getFilePath(Context context) {
        if (Build.VERSION.SDK_INT >= 24) {
            context = context.createDeviceProtectedStorageContext();
        }
        return context.getFilesDir().getPath();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x003a, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0043, code lost:
        throw r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void readFromSd() {
        /*
            r4 = this;
            java.io.BufferedReader r0 = new java.io.BufferedReader     // Catch:{ IOException -> 0x0044 }
            java.io.InputStreamReader r1 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x0044 }
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ IOException -> 0x0044 }
            java.lang.String r3 = r4.bigDataPath     // Catch:{ IOException -> 0x0044 }
            r2.<init>(r3)     // Catch:{ IOException -> 0x0044 }
            java.nio.charset.Charset r3 = java.nio.charset.StandardCharsets.UTF_8     // Catch:{ IOException -> 0x0044 }
            r1.<init>(r2, r3)     // Catch:{ IOException -> 0x0044 }
            r0.<init>(r1)     // Catch:{ IOException -> 0x0044 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0038 }
            java.lang.String r2 = ""
            r1.<init>(r2)     // Catch:{ all -> 0x0038 }
        L_0x001a:
            java.lang.String r2 = r0.readLine()     // Catch:{ all -> 0x0038 }
            if (r2 == 0) goto L_0x0024
            r1.append(r2)     // Catch:{ all -> 0x0038 }
            goto L_0x001a
        L_0x0024:
            java.io.File r2 = new java.io.File     // Catch:{ all -> 0x0038 }
            java.lang.String r3 = r4.bigDataPath     // Catch:{ all -> 0x0038 }
            r2.<init>(r3)     // Catch:{ all -> 0x0038 }
            r2.delete()     // Catch:{ all -> 0x0038 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0038 }
            r4.responseString = r1     // Catch:{ all -> 0x0038 }
            r0.close()     // Catch:{ IOException -> 0x0044 }
            goto L_0x004b
        L_0x0038:
            r1 = move-exception
            throw r1     // Catch:{ all -> 0x003a }
        L_0x003a:
            r2 = move-exception
            r0.close()     // Catch:{ all -> 0x003f }
            goto L_0x0043
        L_0x003f:
            r0 = move-exception
            r1.addSuppressed(r0)     // Catch:{ IOException -> 0x0044 }
        L_0x0043:
            throw r2     // Catch:{ IOException -> 0x0044 }
        L_0x0044:
            java.lang.String r0 = "Fly"
            java.lang.String r1 = "readFromSd stream exception"
            com.huawei.location.lite.common.log.LogConsole.e(r0, r1)
        L_0x004b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.location.lite.common.http.response.ResponseInfo.readFromSd():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001a, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0023, code lost:
        throw r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.io.File saveToSd(byte[] r5) {
        /*
            r4 = this;
            java.io.File r0 = new java.io.File
            java.lang.String r1 = r4.bigDataPath
            r0.<init>(r1)
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x0024 }
            r2 = 0
            r1.<init>(r0, r2)     // Catch:{ IOException -> 0x0024 }
            int r3 = r5.length     // Catch:{ all -> 0x0018 }
            r1.write(r5, r2, r3)     // Catch:{ all -> 0x0018 }
            r1.flush()     // Catch:{ all -> 0x0018 }
            r1.close()     // Catch:{ IOException -> 0x0024 }
            goto L_0x002b
        L_0x0018:
            r5 = move-exception
            throw r5     // Catch:{ all -> 0x001a }
        L_0x001a:
            r2 = move-exception
            r1.close()     // Catch:{ all -> 0x001f }
            goto L_0x0023
        L_0x001f:
            r1 = move-exception
            r5.addSuppressed(r1)     // Catch:{ IOException -> 0x0024 }
        L_0x0023:
            throw r2     // Catch:{ IOException -> 0x0024 }
        L_0x0024:
            java.lang.String r5 = "Fly"
            java.lang.String r1 = "saveToSd write exception"
            com.huawei.location.lite.common.log.LogConsole.e(r5, r1)
        L_0x002b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.location.lite.common.http.response.ResponseInfo.saveToSd(byte[]):java.io.File");
    }

    public int describeContents() {
        return 0;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public int getErrorLevel() {
        return this.errorLevel;
    }

    public String getMsg() {
        return this.msg;
    }

    public byte[] getResponseBytes() {
        byte[] bArr = this.responseBytes;
        return bArr == null ? new byte[0] : (byte[]) bArr.clone();
    }

    public String getResponseString() {
        if (!TextUtils.isEmpty(this.bigDataPath)) {
            readFromSd();
        }
        return this.responseString;
    }

    public void setErrorCode(int i11) {
        this.errorCode = i11;
    }

    public void setErrorLevel(int i11) {
        this.errorLevel = i11;
    }

    public void setMsg(String str) {
        this.msg = str;
    }

    public void setResponseBytes(byte[] bArr) {
        if (bArr != null) {
            this.responseBytes = (byte[]) bArr.clone();
        }
    }

    public void setResponseString(String str) {
        if (SDKComponentType.getComponentType() == 200 && !TextUtils.isEmpty(str)) {
            byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
            if (bytes.length >= MAX_TRANSFER_DATA_LIMIT) {
                LogConsole.i(TAG, "response data over MAX_TRANSFER_DATA_LIMIT");
                this.bigDataPath = getFilePath(ContextUtil.getContext()) + File.separator + "http_parcelable_data.temp";
                saveToSd(bytes);
                return;
            }
        }
        this.responseString = str;
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeInt(this.errorLevel);
        parcel.writeInt(this.errorCode);
        parcel.writeString(this.msg);
        parcel.writeString(this.responseString);
        parcel.writeByteArray(this.responseBytes);
        parcel.writeString(this.bigDataPath);
    }
}
