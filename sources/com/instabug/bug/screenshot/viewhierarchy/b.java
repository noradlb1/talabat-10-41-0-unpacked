package com.instabug.bug.screenshot.viewhierarchy;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.net.Uri;
import android.view.View;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import org.json.JSONObject;

public class b {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private String f45741a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private String f45742b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private JSONObject f45743c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private String f45744d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private JSONObject f45745e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private b f45746f;

    /* renamed from: g  reason: collision with root package name */
    private ArrayList f45747g = new ArrayList();

    /* renamed from: h  reason: collision with root package name */
    private boolean f45748h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f45749i;
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    private Bitmap f45750j;
    @Nullable

    /* renamed from: k  reason: collision with root package name */
    private Uri f45751k;
    @Nullable

    /* renamed from: l  reason: collision with root package name */
    private Rect f45752l;
    @Nullable

    /* renamed from: m  reason: collision with root package name */
    private Rect f45753m;
    @Nullable

    /* renamed from: n  reason: collision with root package name */
    private View f45754n;

    /* renamed from: o  reason: collision with root package name */
    private int f45755o = 1;

    @Nullable
    public JSONObject a() {
        return this.f45743c;
    }

    public void a(int i11) {
        this.f45755o = i11;
    }

    public void a(@Nullable Bitmap bitmap) {
        this.f45750j = bitmap;
    }

    public void a(@Nullable Rect rect) {
        this.f45752l = rect;
    }

    public void a(@Nullable Uri uri) {
        this.f45751k = uri;
    }

    public void a(@Nullable View view) {
        this.f45754n = view;
    }

    public void a(b bVar) {
        this.f45747g.add(bVar);
    }

    public void a(@Nullable String str) {
        this.f45742b = str;
    }

    public void a(@Nullable JSONObject jSONObject) {
        this.f45743c = jSONObject;
    }

    public void a(boolean z11) {
        this.f45748h = z11;
    }

    @Nullable
    public String b() {
        return this.f45742b;
    }

    public void b(@Nullable Rect rect) {
        this.f45753m = rect;
    }

    public void b(@Nullable b bVar) {
        this.f45746f = bVar;
    }

    public void b(@Nullable String str) {
        this.f45741a = str;
    }

    public void b(@Nullable JSONObject jSONObject) {
        this.f45745e = jSONObject;
    }

    public void b(boolean z11) {
        this.f45749i = z11;
    }

    @Nullable
    public String c() {
        return this.f45741a;
    }

    public void c(@Nullable String str) {
        this.f45744d = str;
    }

    @Nullable
    public Bitmap d() {
        return this.f45750j;
    }

    @Nullable
    public Uri e() {
        return this.f45751k;
    }

    public ArrayList f() {
        return this.f45747g;
    }

    @Nullable
    public Rect g() {
        return this.f45752l;
    }

    @Nullable
    public b h() {
        return this.f45746f;
    }

    @Nullable
    public JSONObject i() {
        return this.f45745e;
    }

    public int j() {
        return this.f45755o;
    }

    @Nullable
    public String k() {
        return this.f45744d;
    }

    @Nullable
    public View l() {
        return this.f45754n;
    }

    @Nullable
    public Rect m() {
        return this.f45753m;
    }

    public boolean n() {
        return this.f45748h;
    }

    public boolean o() {
        return this.f45749i;
    }

    public void p() {
        this.f45750j = null;
    }
}
