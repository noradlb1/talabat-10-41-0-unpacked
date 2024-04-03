package com.huawei.wearengine.p2p;

import java.io.File;

public class FileIdentification {

    /* renamed from: a  reason: collision with root package name */
    private File f44756a;

    /* renamed from: b  reason: collision with root package name */
    private String f44757b;

    public static class Builder {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public File f44758a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public String f44759b;

        public FileIdentification build() {
            return new FileIdentification(this);
        }

        public Builder setDescription(String str) {
            this.f44759b = str;
            return this;
        }

        public Builder setFile(File file) {
            this.f44758a = file;
            return this;
        }
    }

    public FileIdentification(Builder builder) {
        this.f44756a = builder.f44758a;
        this.f44757b = builder.f44759b;
    }

    public String getDescription() {
        return this.f44757b;
    }

    public File getFile() {
        return this.f44756a;
    }
}
