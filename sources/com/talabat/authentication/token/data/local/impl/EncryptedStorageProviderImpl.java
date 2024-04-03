package com.talabat.authentication.token.data.local.impl;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.security.crypto.EncryptedSharedPreferences;
import androidx.security.crypto.MasterKeys;
import com.talabat.authentication.token.data.local.EncryptedStorageProvider;
import com.talabat.core.context.domain.ApplicationContext;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/talabat/authentication/token/data/local/impl/EncryptedStorageProviderImpl;", "Lcom/talabat/authentication/token/data/local/EncryptedStorageProvider;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getStorage", "Landroid/content/SharedPreferences;", "name", "", "com_talabat_Authentication_Authentication"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class EncryptedStorageProviderImpl implements EncryptedStorageProvider {
    @NotNull
    private final Context context;

    @Inject
    public EncryptedStorageProviderImpl(@NotNull @ApplicationContext Context context2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        this.context = context2;
    }

    @NotNull
    public SharedPreferences getStorage(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        SharedPreferences create = EncryptedSharedPreferences.create(str, MasterKeys.getOrCreate(MasterKeys.AES256_GCM_SPEC), this.context, EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV, EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM);
        Intrinsics.checkNotNullExpressionValue(create, "create(\n        name,\n  …onScheme.AES256_GCM\n    )");
        return create;
    }
}
