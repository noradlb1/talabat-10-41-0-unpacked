package com.talabat.feature.rating.data;

import android.content.Context;
import android.content.SharedPreferences;
import com.talabat.authentication.token.data.local.EncryptedStorageProvider;
import com.talabat.feature.rating.domain.repo.RatingSession;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0010H\u0016J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\u0010H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\t\u001a\u00020\n8BX\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/talabat/feature/rating/data/RatingSessionImpl;", "Lcom/talabat/feature/rating/domain/repo/RatingSession;", "context", "Landroid/content/Context;", "encryptedStorageProvider", "Lcom/talabat/authentication/token/data/local/EncryptedStorageProvider;", "(Landroid/content/Context;Lcom/talabat/authentication/token/data/local/EncryptedStorageProvider;)V", "getContext", "()Landroid/content/Context;", "sharedPref", "Landroid/content/SharedPreferences;", "getSharedPref", "()Landroid/content/SharedPreferences;", "sharedPref$delegate", "Lkotlin/Lazy;", "isRatingDismissed", "", "orderId", "", "isRatingShown", "setRatingDismissed", "", "isDismissed", "setRatingShown", "com_talabat_feature_rating_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RatingSessionImpl implements RatingSession {
    @NotNull
    private final Context context;
    @NotNull
    private final Lazy sharedPref$delegate;

    @Inject
    public RatingSessionImpl(@NotNull Context context2, @NotNull EncryptedStorageProvider encryptedStorageProvider) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(encryptedStorageProvider, "encryptedStorageProvider");
        this.context = context2;
        this.sharedPref$delegate = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, new RatingSessionImpl$sharedPref$2(encryptedStorageProvider));
    }

    private final SharedPreferences getSharedPref() {
        return (SharedPreferences) this.sharedPref$delegate.getValue();
    }

    @NotNull
    public final Context getContext() {
        return this.context;
    }

    public boolean isRatingDismissed(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "orderId");
        if (!getSharedPref().getBoolean(RatingSessionImplKt.KEY_IS_RATING_DISMISSED, false) || !Intrinsics.areEqual((Object) str, (Object) getSharedPref().getString(RatingSessionImplKt.KEY_ORDER_ID, ""))) {
            return false;
        }
        return true;
    }

    public boolean isRatingShown() {
        return RatingShown.INSTANCE.isRatingShown();
    }

    public void setRatingDismissed(boolean z11, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "orderId");
        SharedPreferences.Editor edit = getSharedPref().edit();
        edit.putBoolean(RatingSessionImplKt.KEY_IS_RATING_DISMISSED, z11);
        edit.putString(RatingSessionImplKt.KEY_ORDER_ID, str);
        edit.apply();
    }

    public void setRatingShown(boolean z11) {
        RatingShown.INSTANCE.setRatingShown(true);
    }
}
