package com.huawei.location.activity;

import com.huawei.location.lite.common.http.response.BaseResponse;

public class DownLoadFileBean extends BaseResponse {
    private FileAccessInfo fileAccessInfo;

    public static class FileAccessInfo {
        private String field;
        private String fileSha256;
        private String method;
        private String url;
        private String version;

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
    }

    public String getApiCode() {
        return this.code;
    }

    public FileAccessInfo getFileAccessInfo() {
        FileAccessInfo fileAccessInfo2 = this.fileAccessInfo;
        return fileAccessInfo2 == null ? new FileAccessInfo() : fileAccessInfo2;
    }

    public boolean isSuccess() {
        return "0".equals(this.code);
    }

    public void setFileAccessInfo(FileAccessInfo fileAccessInfo2) {
        this.fileAccessInfo = fileAccessInfo2;
    }
}
