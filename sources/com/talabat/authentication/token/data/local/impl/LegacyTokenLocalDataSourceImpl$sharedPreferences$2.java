package com.talabat.authentication.token.data.local.impl;

import android.content.SharedPreferences;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class LegacyTokenLocalDataSourceImpl$sharedPreferences$2 extends Lambda implements Function0<SharedPreferences> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ LegacyTokenLocalDataSourceImpl f55517g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LegacyTokenLocalDataSourceImpl$sharedPreferences$2(LegacyTokenLocalDataSourceImpl legacyTokenLocalDataSourceImpl) {
        super(0);
        this.f55517g = legacyTokenLocalDataSourceImpl;
    }

    public final SharedPreferences invoke() {
        return this.f55517g.context.getSharedPreferences("talabat", 0);
    }
}
