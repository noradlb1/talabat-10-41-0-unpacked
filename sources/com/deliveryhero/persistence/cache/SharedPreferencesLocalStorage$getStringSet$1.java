package com.deliveryhero.persistence.cache;

import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\"\n\u0000\u0010\u0000\u001a(\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0018\u0001 \u0003*\u0012\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0018\u00010\u00040\u0001H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "", "kotlin.jvm.PlatformType", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class SharedPreferencesLocalStorage$getStringSet$1 extends Lambda implements Function0<Set<String>> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ SharedPreferencesLocalStorage f30432g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ String f30433h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SharedPreferencesLocalStorage$getStringSet$1(SharedPreferencesLocalStorage sharedPreferencesLocalStorage, String str) {
        super(0);
        this.f30432g = sharedPreferencesLocalStorage;
        this.f30433h = str;
    }

    @Nullable
    public final Set<String> invoke() {
        return this.f30432g.getSharedPreferences().getStringSet(this.f30433h, (Set) null);
    }
}
