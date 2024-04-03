package com.apptimize;

import android.util.Pair;
import java.net.URI;
import java.util.List;

public interface bj {

    public interface a {
        void a();

        void a(int i11, String str);

        void a(Exception exc);

        void a(String str);

        void a(byte[] bArr);
    }

    public interface b {
        bj a(URI uri, a aVar, List<Pair<String, String>> list);
    }

    a a();

    void a(byte[] bArr);

    void b();

    void b(byte[] bArr);

    void c();
}
