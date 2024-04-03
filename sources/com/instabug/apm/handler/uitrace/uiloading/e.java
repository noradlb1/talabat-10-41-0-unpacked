package com.instabug.apm.handler.uitrace.uiloading;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.instabug.apm.cache.model.i;
import com.instabug.apm.logger.internal.a;
import com.instabug.apm.model.d;
import java.util.Arrays;

public class e implements d {

    /* renamed from: a  reason: collision with root package name */
    private final com.instabug.apm.model.e[] f45448a;

    /* renamed from: b  reason: collision with root package name */
    private final a f45449b;

    /* renamed from: c  reason: collision with root package name */
    private final a f45450c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f45451d = false;

    public e(@NonNull a aVar, @NonNull a aVar2) {
        com.instabug.apm.model.e[] eVarArr = new com.instabug.apm.model.e[11];
        this.f45448a = eVarArr;
        this.f45449b = aVar;
        this.f45450c = aVar2;
        Arrays.fill(eVarArr, new d());
    }

    private boolean a(int i11) {
        return !b(i11);
    }

    private boolean a(int i11, long j11) {
        return this.f45448a[i11].b() > j11;
    }

    private boolean a(long j11) {
        return b(8, j11) && b(9, j11);
    }

    private boolean b(int i11) {
        return this.f45448a[i11] instanceof d;
    }

    private boolean b(int i11, long j11) {
        return b(i11) || a(i11, j11);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c() {
        a(9, new com.instabug.apm.model.e());
    }

    private boolean c(int i11) {
        if (i11 < 0 || i11 >= this.f45448a.length) {
            return false;
        }
        return b(i11);
    }

    private boolean d() {
        return Build.VERSION.SDK_INT < 29 && a(1) && !this.f45451d;
    }

    public void a() {
        if (d()) {
            this.f45451d = true;
            new Handler(Looper.getMainLooper()).postAtFrontOfQueue(new rb.a(this));
        }
    }

    public void a(int i11, @NonNull com.instabug.apm.model.e eVar) {
        if (c(i11)) {
            this.f45448a[i11] = eVar;
        }
    }

    public void a(com.instabug.apm.model.e eVar) {
        a aVar;
        if (!b(10)) {
            a aVar2 = this.f45450c;
            if (aVar2 != null) {
                aVar2.i("endScreenLoading has already been called for the current screen visit. Multiple calls to this API are not allowed during a single screen visit, only the first call will be considered.");
                return;
            }
            return;
        }
        if (a(eVar.b()) && (aVar = this.f45450c) != null) {
            aVar.e("endScreenLoading was called too early in the Screen Loading cycle. Please make sure to call the API after the screen is done loading.");
        }
        this.f45448a[10] = eVar;
    }

    @Nullable
    public i b() {
        i a11;
        a aVar = this.f45449b;
        if (aVar == null || (a11 = aVar.a(this.f45448a)) == null || !a11.g()) {
            return null;
        }
        return a11;
    }
}
