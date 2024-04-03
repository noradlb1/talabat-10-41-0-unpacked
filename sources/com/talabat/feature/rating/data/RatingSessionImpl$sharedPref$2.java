package com.talabat.feature.rating.data;

import android.content.SharedPreferences;
import com.talabat.authentication.token.data.local.EncryptedStorageProvider;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/content/SharedPreferences;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class RatingSessionImpl$sharedPref$2 extends Lambda implements Function0<SharedPreferences> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ EncryptedStorageProvider f58675g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RatingSessionImpl$sharedPref$2(EncryptedStorageProvider encryptedStorageProvider) {
        super(0);
        this.f58675g = encryptedStorageProvider;
    }

    @NotNull
    public final SharedPreferences invoke() {
        return this.f58675g.getStorage(RatingSessionImplKt.KEY_RATING_SHARE_PREF);
    }
}
