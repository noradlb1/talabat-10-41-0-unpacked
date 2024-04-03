package com.deliveryhero.persistence.cache;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class SharedPreferencesLocalStorage$getString$2 extends Lambda implements Function0<String> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ SharedPreferencesLocalStorage f30429g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ String f30430h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ String f30431i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SharedPreferencesLocalStorage$getString$2(SharedPreferencesLocalStorage sharedPreferencesLocalStorage, String str, String str2) {
        super(0);
        this.f30429g = sharedPreferencesLocalStorage;
        this.f30430h = str;
        this.f30431i = str2;
    }

    @Nullable
    public final String invoke() {
        return this.f30429g.getSharedPreferences().getString(this.f30430h, this.f30431i);
    }
}
