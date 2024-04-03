package com.iab.omid.library.deliveryhero3.walking.async;

import com.iab.omid.library.deliveryhero3.walking.async.b;
import java.util.HashSet;
import org.json.JSONObject;

public abstract class a extends b {

    /* renamed from: c  reason: collision with root package name */
    public final HashSet<String> f45030c;

    /* renamed from: d  reason: collision with root package name */
    public final JSONObject f45031d;

    /* renamed from: e  reason: collision with root package name */
    public final long f45032e;

    public a(b.C0053b bVar, HashSet<String> hashSet, JSONObject jSONObject, long j11) {
        super(bVar);
        this.f45030c = new HashSet<>(hashSet);
        this.f45031d = jSONObject;
        this.f45032e = j11;
    }
}
