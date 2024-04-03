package com.instabug.library.invocation.invoker;

import android.content.ContentResolver;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.provider.MediaStore;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.instabug.library.internal.storage.cache.db.InstabugDbContract;
import com.instabug.library.invocation.a;
import com.instabug.library.util.threading.PoolProvider;

public class t extends ContentObserver {

    /* renamed from: a  reason: collision with root package name */
    private final String[] f51397a = {InstabugDbContract.FeatureRequestEntry.COLUMN_ID, "_display_name", "_data"};

    /* renamed from: b  reason: collision with root package name */
    private final String f51398b = MediaStore.Images.Media.EXTERNAL_CONTENT_URI.toString();
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final a f51399c;

    /* renamed from: d  reason: collision with root package name */
    private ContentResolver f51400d;

    /* renamed from: e  reason: collision with root package name */
    public int f51401e = 0;

    public t(Handler handler, ContentResolver contentResolver, a aVar) {
        super(handler);
        this.f51400d = contentResolver;
        this.f51399c = aVar;
    }

    @RequiresApi(api = 30)
    private boolean a(int i11) {
        return (i11 & 8) != 0;
    }

    private void b(int i11) {
        if (Build.VERSION.SDK_INT >= 30) {
            if (!a(i11) || a()) {
                this.f51401e = i11 | this.f51401e;
            } else {
                c();
            }
        }
    }

    private void c() {
        this.f51401e = 0;
    }

    public void onChange(boolean z11, @Nullable Uri uri, int i11) {
        if (uri != null) {
            String uri2 = uri.toString();
            if (uri2.matches(this.f51398b + "/[0-9]+")) {
                b(i11);
                if (b()) {
                    c();
                    Cursor query = this.f51400d.query(uri, this.f51397a, (String) null, (String[]) null, (String) null);
                    if (query != null) {
                        try {
                            if (query.moveToFirst()) {
                                String string = query.getString(query.getColumnIndexOrThrow("_display_name"));
                                String string2 = query.getString(query.getColumnIndexOrThrow("_data"));
                                if (u.a(string2) && u.b(string)) {
                                    PoolProvider.postIOTask(new s(this, string2));
                                }
                            }
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    }
                    if (query != null) {
                        query.close();
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        return;
        throw th;
    }

    @RequiresApi(api = 30)
    private boolean a() {
        return (this.f51401e & 4) != 0;
    }

    private boolean b() {
        if (Build.VERSION.SDK_INT < 30) {
            return true;
        }
        int i11 = this.f51401e;
        if ((i11 & 4) == 0 || (i11 & 8) == 0) {
            return false;
        }
        return true;
    }
}
