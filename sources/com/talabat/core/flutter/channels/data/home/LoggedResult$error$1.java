package com.talabat.core.flutter.channels.data.home;

import android.util.Log;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class LoggedResult$error$1 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ String f55890g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ String f55891h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Object f55892i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LoggedResult$error$1(String str, String str2, Object obj) {
        super(0);
        this.f55890g = str;
        this.f55891h = str2;
        this.f55892i = obj;
    }

    public final void invoke() {
        String str = this.f55890g;
        String str2 = this.f55891h;
        Object obj = this.f55892i;
        Log.i("LoggedResult", "Result error: " + str + " " + str2 + " " + obj);
    }
}
