package com.instabug.library.internal.dataretention.files.logs;

import androidx.annotation.NonNull;
import com.instabug.library.internal.dataretention.core.b;
import com.instabug.library.internal.dataretention.files.g;
import com.instabug.library.internal.dataretention.files.j;

class a extends c {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f50976a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ b f50977b;

    public a(b bVar, String str, g[] gVarArr, b bVar2) {
        this.f50976a = str;
        this.f50977b = bVar2;
    }

    @NonNull
    public b a() {
        return this.f50977b;
    }

    @NonNull
    public j b() {
        return new e().a(this.f50976a);
    }
}
