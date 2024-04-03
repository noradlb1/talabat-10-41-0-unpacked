package com.talabat.authentication.token.data.local.impl;

import android.content.SharedPreferences;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/content/SharedPreferences;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class TokenLocalDataSourceImpl$sharedPreferences$2 extends Lambda implements Function0<SharedPreferences> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ TokenLocalDataSourceImpl f55518g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TokenLocalDataSourceImpl$sharedPreferences$2(TokenLocalDataSourceImpl tokenLocalDataSourceImpl) {
        super(0);
        this.f55518g = tokenLocalDataSourceImpl;
    }

    @NotNull
    public final SharedPreferences invoke() {
        return this.f55518g.encryptedStorageProvider.getStorage(TokenLocalDataSourceImpl.PREFERENCE);
    }
}
