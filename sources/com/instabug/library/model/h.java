package com.instabug.library.model;

import android.annotation.SuppressLint;
import android.support.v4.media.session.PlaybackStateCompat;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.instabug.library.internal.storage.cache.Cacheable;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

@Instrumented
public class h implements Cacheable {
    @VisibleForTesting

    /* renamed from: m  reason: collision with root package name */
    public static final long f51530m = TimeUnit.HOURS.toSeconds(12);

    /* renamed from: a  reason: collision with root package name */
    private int f51531a = 0;

    /* renamed from: b  reason: collision with root package name */
    private int f51532b = 7;

    /* renamed from: c  reason: collision with root package name */
    private long f51533c = 20000;

    /* renamed from: d  reason: collision with root package name */
    private long f51534d = f51530m;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private Set f51535e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private Set f51536f;

    /* renamed from: g  reason: collision with root package name */
    private long f51537g = 2;

    /* renamed from: h  reason: collision with root package name */
    private long f51538h = PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;

    /* renamed from: i  reason: collision with root package name */
    private long f51539i = 10000;

    /* renamed from: j  reason: collision with root package name */
    private int f51540j = 4;

    /* renamed from: k  reason: collision with root package name */
    private boolean f51541k = false;

    /* renamed from: l  reason: collision with root package name */
    private long f51542l = 5000000;

    public void a(int i11) {
        this.f51531a = i11;
    }

    public void b(int i11) {
        this.f51532b = i11;
    }

    public long c() {
        return this.f51537g;
    }

    public int d() {
        return this.f51531a;
    }

    public int e() {
        return this.f51532b;
    }

    public void f(long j11) {
        this.f51534d = j11;
    }

    public void fromJson(String str) throws JSONException {
        b(new JSONObject(str));
    }

    public long g() {
        return this.f51538h;
    }

    public long h() {
        return this.f51533c;
    }

    public int i() {
        return this.f51540j;
    }

    public long j() {
        return this.f51534d;
    }

    @Nullable
    public Set k() {
        return this.f51536f;
    }

    public boolean l() {
        return this.f51541k;
    }

    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    public String toJson() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("level", d()).put("size_limit", h()).put("upload_interval", j()).put("retention_days", e()).put("uuids", (Object) k()).put("emails", (Object) a()).put("flush_char_limit", b()).put("flush_interval", c()).put("today_file_count", i()).put("keep_on_sdk_disabled", l()).put("single_log_limit", g());
        return JSONObjectInstrumentation.toString(jSONObject);
    }

    public void a(@Nullable Set set) {
        this.f51535e = set;
    }

    public void b(@Nullable Set set) {
        this.f51536f = set;
    }

    public void c(int i11) {
        this.f51540j = i11;
    }

    public void d(long j11) {
        this.f51538h = j11;
    }

    public void e(long j11) {
        this.f51533c = j11;
    }

    public long f() {
        return this.f51542l;
    }

    @Nullable
    public Set a() {
        return this.f51535e;
    }

    public void b(long j11) {
        this.f51537g = j11;
    }

    public void c(long j11) {
        this.f51542l = j11;
    }

    public void a(long j11) {
        this.f51539i = j11;
    }

    public long b() {
        return this.f51539i;
    }

    public void a(boolean z11) {
        this.f51541k = z11;
    }

    public void b(@NonNull JSONObject jSONObject) throws JSONException {
        a(jSONObject.optInt("level", 0));
        b(jSONObject.optInt("retention_days", 7));
        e(jSONObject.optLong("size_limit", 20000) * 1000);
        f(jSONObject.optLong("upload_interval", f51530m));
        b(a(jSONObject.optJSONObject("uuids")));
        a(a(jSONObject.optJSONObject("emails")));
        b(((long) jSONObject.optInt("flush_interval", 2)) * 1000);
        a(jSONObject.optLong("flush_char_limit", 10000));
        c(jSONObject.optInt("today_file_count", 4));
        a(jSONObject.optBoolean("keep_on_sdk_disabled", false));
        d(jSONObject.optLong("single_log_limit", PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM));
        c(this.f51533c / ((long) this.f51540j));
    }

    private Set a(@Nullable JSONObject jSONObject) {
        HashSet hashSet = new HashSet();
        if (jSONObject == null) {
            return hashSet;
        }
        Iterator<String> keys = jSONObject.keys();
        while (keys != null && keys.hasNext()) {
            hashSet.add(keys.next());
        }
        return hashSet;
    }
}
