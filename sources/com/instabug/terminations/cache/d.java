package com.instabug.terminations.cache;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.instabug.terminations.model.b;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

final class d extends Lambda implements Function1 {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Cursor f52600g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ boolean f52601h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Context f52602i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(Cursor cursor, boolean z11, Context context) {
        super(1);
        this.f52600g = cursor;
        this.f52601h = z11;
        this.f52602i = context;
    }

    public final void a(@NotNull b bVar) {
        Uri uri;
        Intrinsics.checkNotNullParameter(bVar, "$this$invoke");
        Cursor cursor = this.f52600g;
        bVar.a(cursor.getInt(cursor.getColumnIndexOrThrow("termination_state")));
        Cursor cursor2 = this.f52600g;
        bVar.b(cursor2.getString(cursor2.getColumnIndexOrThrow("temporary_server_token")));
        Cursor cursor3 = this.f52600g;
        String string = cursor3.getString(cursor3.getColumnIndexOrThrow("state"));
        if (string == null) {
            uri = null;
        } else {
            uri = Uri.parse(string);
        }
        bVar.a(uri);
        if (this.f52601h) {
            bVar.a(this.f52602i);
        }
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((b) obj);
        return Unit.INSTANCE;
    }
}
