package com.instabug.library;

public interface OnSdkDismissCallback {

    public enum DismissType {
        SUBMIT,
        CANCEL,
        ADD_ATTACHMENT
    }

    public enum ReportType {
        BUG("bug"),
        FEEDBACK("feedback"),
        QUESTION("question"),
        OTHER("other");
        

        /* renamed from: name  reason: collision with root package name */
        private final String f50527name;

        private ReportType(String str) {
            this.f50527name = str;
        }

        public String toString() {
            return this.f50527name;
        }
    }

    void call(DismissType dismissType, ReportType reportType);
}
