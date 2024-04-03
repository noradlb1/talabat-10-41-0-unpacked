package com.deliveryhero.persistence.cache;

import android.content.Context;
import android.content.SharedPreferences;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/content/SharedPreferences;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class SharedPreferencesLocalStorage$sharedPreferences$2 extends Lambda implements Function0<SharedPreferences> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ SharedPreferencesLocalStorage f30434g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SharedPreferencesLocalStorage$sharedPreferences$2(SharedPreferencesLocalStorage sharedPreferencesLocalStorage) {
        super(0);
        this.f30434g = sharedPreferencesLocalStorage;
    }

    @NotNull
    public final SharedPreferences invoke() {
        SharedPreferencesLocalStorage sharedPreferencesLocalStorage = this.f30434g;
        Context access$getContext$p = sharedPreferencesLocalStorage.context;
        String access$getPreferenceName$p = this.f30434g.preferenceName;
        SharedPreferences sharedPreferences = this.f30434g.context.getSharedPreferences(this.f30434g.preferenceName, 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "context.getSharedPrefere…me, Context.MODE_PRIVATE)");
        return sharedPreferencesLocalStorage.createSharedPreference(access$getContext$p, access$getPreferenceName$p, sharedPreferences);
    }
}
