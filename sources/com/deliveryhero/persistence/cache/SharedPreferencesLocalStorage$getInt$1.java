package com.deliveryhero.persistence.cache;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Integer;"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class SharedPreferencesLocalStorage$getInt$1 extends Lambda implements Function0<Integer> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ SharedPreferencesLocalStorage f30421g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ String f30422h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ int f30423i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SharedPreferencesLocalStorage$getInt$1(SharedPreferencesLocalStorage sharedPreferencesLocalStorage, String str, int i11) {
        super(0);
        this.f30421g = sharedPreferencesLocalStorage;
        this.f30422h = str;
        this.f30423i = i11;
    }

    @NotNull
    public final Integer invoke() {
        return Integer.valueOf(this.f30421g.getSharedPreferences().getInt(this.f30422h, this.f30423i));
    }
}
