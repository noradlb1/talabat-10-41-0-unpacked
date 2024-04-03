package com.huawei.location.lite.common.util.filedownload;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.huawei.location.lite.common.http.response.BaseResponse;

public class DownLoadFileBean extends BaseResponse implements Parcelable {
    public static final Parcelable.Creator<DownLoadFileBean> CREATOR = new Parcelable.Creator<DownLoadFileBean>() {
        public DownLoadFileBean createFromParcel(Parcel parcel) {
            return new DownLoadFileBean(parcel);
        }

        public DownLoadFileBean[] newArray(int i11) {
            return new DownLoadFileBean[i11];
        }
    };
    @SerializedName("fileAccessInfo")
    private FileAccessInfo fileAccessInfo;

    public static class FileAccessInfo implements Parcelable {
        public static final Parcelable.Creator<FileAccessInfo> CREATOR = new Parcelable.Creator<FileAccessInfo>() {
            public FileAccessInfo createFromParcel(Parcel parcel) {
                return new FileAccessInfo(parcel);
            }

            public FileAccessInfo[] newArray(int i11) {
                return new FileAccessInfo[i11];
            }
        };
        @SerializedName("field")
        private String field;
        @SerializedName("fileSha256")
        private String fileSha256;
        @SerializedName("method")
        private String method;
        @SerializedName("url")
        private String url;
        @SerializedName("version")
        private String version;

        public FileAccessInfo() {
        }

        public FileAccessInfo(Parcel parcel) {
            this.url = parcel.readString();
            this.field = parcel.readString();
            this.method = parcel.readString();
            this.version = parcel.readString();
            this.fileSha256 = parcel.readString();
        }

        public int describeContents() {
            return 0;
        }

        public String getField() {
            return this.field;
        }

        public String getFileSha256() {
            return this.fileSha256;
        }

        public String getMethod() {
            return this.method;
        }

        public String getUrl() {
            return this.url;
        }

        public String getVersion() {
            return this.version;
        }

        public void setField(String str) {
            this.field = str;
        }

        public void setFileSha256(String str) {
            this.fileSha256 = str;
        }

        public void setMethod(String str) {
            this.method = str;
        }

        public void setUrl(String str) {
            this.url = str;
        }

        public void setVersion(String str) {
            this.version = str;
        }

        public void writeToParcel(Parcel parcel, int i11) {
            parcel.writeString(this.url);
            parcel.writeString(this.field);
            parcel.writeString(this.method);
            parcel.writeString(this.version);
            parcel.writeString(this.fileSha256);
        }
    }

    public DownLoadFileBean(Parcel parcel) {
        this.fileAccessInfo = (FileAccessInfo) parcel.readParcelable(FileAccessInfo.class.getClassLoader());
    }

    public int describeContents() {
        return 0;
    }

    public String getApiCode() {
        return this.code;
    }

    public FileAccessInfo getFileAccessInfo() {
        FileAccessInfo fileAccessInfo2 = this.fileAccessInfo;
        return fileAccessInfo2 == null ? new FileAccessInfo() : fileAccessInfo2;
    }

    public void setFileAccessInfo(FileAccessInfo fileAccessInfo2) {
        this.fileAccessInfo = fileAccessInfo2;
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeParcelable(this.fileAccessInfo, i11);
    }
}
