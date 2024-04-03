package com.deliveryhero.persistence.cache;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Long;"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class SharedPreferencesLocalStorage$getLong$1 extends Lambda implements Function0<Long> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ SharedPreferencesLocalStorage f30424g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ String f30425h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ long f30426i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SharedPreferencesLocalStorage$getLong$1(SharedPreferencesLocalStorage sharedPreferencesLocalStorage, String str, long j11) {
        super(0);
        this.f30424g = sharedPreferencesLocalStorage;
        this.f30425h = str;
        this.f30426i = j11;
    }

    @NotNull
    public final Long invoke() {
        return Long.valueOf(this.f30424g.getSharedPreferences().getLong(this.f30425h, this.f30426i));
    }
}
