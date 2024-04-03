package com.huawei.location.crowdsourcing.upload.entity;

import androidx.annotation.NonNull;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class FB {
    public final List<yn> FB = new LinkedList();
    public final String Vw;

    /* renamed from: yn  reason: collision with root package name */
    public final String f50080yn;

    public static class yn {
        public final Map<String, String> FB;
        public final long Vw;

        /* renamed from: yn  reason: collision with root package name */
        public final String f50081yn;

        public yn(String str, long j11, Map<String, String> map) {
            this.f50081yn = str;
            this.Vw = j11;
            this.FB = map;
        }
    }

    public FB(@NonNull String str, @NonNull String str2) {
        this.f50080yn = str;
        this.Vw = str2;
    }
}
