package com.instabug.library.networkv2.request;

import android.net.Uri;
import androidx.annotation.NonNull;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private Uri.Builder f51660a = new Uri.Builder();

    private a() {
    }

    public static a a() {
        return new a();
    }

    @NonNull
    public String toString() {
        return this.f51660a.toString();
    }

    public void a(String str, String str2) {
        this.f51660a.appendQueryParameter(str, str2);
    }
}
