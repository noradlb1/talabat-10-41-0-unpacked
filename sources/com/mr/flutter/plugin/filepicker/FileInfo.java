package com.mr.flutter.plugin.filepicker;

import android.net.Uri;
import com.talabat.darkstores.common.bindingAdapters.BindingAdaptersKt;
import io.flutter.plugins.firebase.crashlytics.Constants;
import java.util.HashMap;

public class FileInfo {

    /* renamed from: a  reason: collision with root package name */
    public final String f52756a;

    /* renamed from: b  reason: collision with root package name */
    public final String f52757b;

    /* renamed from: c  reason: collision with root package name */
    public final Uri f52758c;

    /* renamed from: d  reason: collision with root package name */
    public final long f52759d;

    /* renamed from: e  reason: collision with root package name */
    public final byte[] f52760e;

    public static class Builder {
        private byte[] bytes;

        /* renamed from: name  reason: collision with root package name */
        private String f52761name;
        private String path;
        private long size;
        private Uri uri;

        public FileInfo build() {
            return new FileInfo(this.path, this.f52761name, this.uri, this.size, this.bytes);
        }

        public Builder withData(byte[] bArr) {
            this.bytes = bArr;
            return this;
        }

        public Builder withName(String str) {
            this.f52761name = str;
            return this;
        }

        public Builder withPath(String str) {
            this.path = str;
            return this;
        }

        public Builder withSize(long j11) {
            this.size = j11;
            return this;
        }

        public Builder withUri(Uri uri2) {
            this.uri = uri2;
            return this;
        }
    }

    public FileInfo(String str, String str2, Uri uri, long j11, byte[] bArr) {
        this.f52756a = str;
        this.f52757b = str2;
        this.f52759d = j11;
        this.f52760e = bArr;
        this.f52758c = uri;
    }

    public HashMap<String, Object> toMap() {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("path", this.f52756a);
        hashMap.put("name", this.f52757b);
        hashMap.put(BindingAdaptersKt.QUERY_SIZE, Long.valueOf(this.f52759d));
        hashMap.put("bytes", this.f52760e);
        hashMap.put(Constants.IDENTIFIER, this.f52758c.toString());
        return hashMap;
    }
}
