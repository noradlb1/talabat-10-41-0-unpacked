package com.deliveryhero.persistence.cache;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Float;"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class SharedPreferencesLocalStorage$getFloat$1 extends Lambda implements Function0<Float> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ SharedPreferencesLocalStorage f30418g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ String f30419h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ float f30420i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SharedPreferencesLocalStorage$getFloat$1(SharedPreferencesLocalStorage sharedPreferencesLocalStorage, String str, float f11) {
        super(0);
        this.f30418g = sharedPreferencesLocalStorage;
        this.f30419h = str;
        this.f30420i = f11;
    }

    @NotNull
    public final Float invoke() {
        return Float.valueOf(this.f30418g.getSharedPreferences().getFloat(this.f30419h, this.f30420i));
    }
}
