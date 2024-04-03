package com.iab.omid.library.deliveryhero3.internal;

import android.view.View;
import androidx.annotation.Nullable;
import com.iab.omid.library.deliveryhero3.adsession.FriendlyObstructionPurpose;
import com.iab.omid.library.deliveryhero3.weakreference.a;

public class e {

    /* renamed from: a  reason: collision with root package name */
    private final a f44960a;

    /* renamed from: b  reason: collision with root package name */
    private final String f44961b;

    /* renamed from: c  reason: collision with root package name */
    private final FriendlyObstructionPurpose f44962c;

    /* renamed from: d  reason: collision with root package name */
    private final String f44963d;

    public e(View view, FriendlyObstructionPurpose friendlyObstructionPurpose, @Nullable String str) {
        this.f44960a = new a(view);
        this.f44961b = view.getClass().getCanonicalName();
        this.f44962c = friendlyObstructionPurpose;
        this.f44963d = str;
    }

    public String a() {
        return this.f44963d;
    }

    public FriendlyObstructionPurpose b() {
        return this.f44962c;
    }

    public a c() {
        return this.f44960a;
    }

    public String d() {
        return this.f44961b;
    }
}
