package com.iab.omid.library.deliveryhero3.walking;

import androidx.annotation.VisibleForTesting;
import com.iab.omid.library.deliveryhero3.walking.async.b;
import com.iab.omid.library.deliveryhero3.walking.async.c;
import com.iab.omid.library.deliveryhero3.walking.async.d;
import com.iab.omid.library.deliveryhero3.walking.async.e;
import com.iab.omid.library.deliveryhero3.walking.async.f;
import java.util.HashSet;
import org.json.JSONObject;

public class b implements b.C0053b {

    /* renamed from: a  reason: collision with root package name */
    private JSONObject f45039a;

    /* renamed from: b  reason: collision with root package name */
    private final c f45040b;

    public b(c cVar) {
        this.f45040b = cVar;
    }

    @VisibleForTesting
    public JSONObject a() {
        return this.f45039a;
    }

    @VisibleForTesting
    public void a(JSONObject jSONObject) {
        this.f45039a = jSONObject;
    }

    public void a(JSONObject jSONObject, HashSet<String> hashSet, long j11) {
        this.f45040b.b(new e(this, hashSet, jSONObject, j11));
    }

    public void b() {
        this.f45040b.b(new d(this));
    }

    public void b(JSONObject jSONObject, HashSet<String> hashSet, long j11) {
        this.f45040b.b(new f(this, hashSet, jSONObject, j11));
    }
}
