package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.collection.ArraySet;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.signin.SignInOptions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

@KeepForSdk
@VisibleForTesting
public final class ClientSettings {
    @Nullable
    private final Account zaa;
    private final Set zab;
    private final Set zac;
    private final Map zad;
    private final int zae;
    @Nullable
    private final View zaf;
    private final String zag;
    private final String zah;
    private final SignInOptions zai;
    private Integer zaj;

    @KeepForSdk
    public static final class Builder {
        @Nullable
        private Account zaa;
        private ArraySet zab;
        private String zac;
        private String zad;
        private final SignInOptions zae = SignInOptions.zaa;

        @NonNull
        @KeepForSdk
        public ClientSettings build() {
            return new ClientSettings(this.zaa, this.zab, (Map) null, 0, (View) null, this.zac, this.zad, this.zae, false);
        }

        @NonNull
        @KeepForSdk
        @CanIgnoreReturnValue
        public Builder setRealClientPackageName(@NonNull String str) {
            this.zac = str;
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public final Builder zaa(@NonNull Collection collection) {
            if (this.zab == null) {
                this.zab = new ArraySet();
            }
            this.zab.addAll(collection);
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public final Builder zab(@Nullable Account account) {
            this.zaa = account;
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public final Builder zac(@NonNull String str) {
            this.zad = str;
            return this;
        }
    }

    @KeepForSdk
    public ClientSettings(@NonNull Account account, @NonNull Set<Scope> set, @NonNull Map<Api<?>, zab> map, int i11, @Nullable View view, @NonNull String str, @NonNull String str2, @Nullable SignInOptions signInOptions) {
        this(account, set, map, i11, view, str, str2, signInOptions, false);
    }

    @NonNull
    @KeepForSdk
    public static ClientSettings createDefault(@NonNull Context context) {
        return new GoogleApiClient.Builder(context).zaa();
    }

    @KeepForSdk
    @androidx.annotation.Nullable
    public Account getAccount() {
        return this.zaa;
    }

    @KeepForSdk
    @Deprecated
    @androidx.annotation.Nullable
    public String getAccountName() {
        Account account = this.zaa;
        if (account != null) {
            return account.name;
        }
        return null;
    }

    @NonNull
    @KeepForSdk
    public Account getAccountOrDefault() {
        Account account = this.zaa;
        return account != null ? account : new Account("<<default account>>", "com.google");
    }

    @NonNull
    @KeepForSdk
    public Set<Scope> getAllRequestedScopes() {
        return this.zac;
    }

    @NonNull
    @KeepForSdk
    public Set<Scope> getApplicableScopes(@NonNull Api<?> api) {
        zab zab2 = (zab) this.zad.get(api);
        if (zab2 == null || zab2.zaa.isEmpty()) {
            return this.zab;
        }
        HashSet hashSet = new HashSet(this.zab);
        hashSet.addAll(zab2.zaa);
        return hashSet;
    }

    @KeepForSdk
    public int getGravityForPopups() {
        return this.zae;
    }

    @NonNull
    @KeepForSdk
    public String getRealClientPackageName() {
        return this.zag;
    }

    @NonNull
    @KeepForSdk
    public Set<Scope> getRequiredScopes() {
        return this.zab;
    }

    @KeepForSdk
    @androidx.annotation.Nullable
    public View getViewForPopups() {
        return this.zaf;
    }

    @NonNull
    public final SignInOptions zaa() {
        return this.zai;
    }

    @androidx.annotation.Nullable
    public final Integer zab() {
        return this.zaj;
    }

    @androidx.annotation.Nullable
    public final String zac() {
        return this.zah;
    }

    @NonNull
    public final Map zad() {
        return this.zad;
    }

    public final void zae(@NonNull Integer num) {
        this.zaj = num;
    }

    public ClientSettings(@Nullable Account account, @NonNull Set set, @NonNull Map map, int i11, @Nullable View view, @NonNull String str, @NonNull String str2, @Nullable SignInOptions signInOptions, boolean z11) {
        this.zaa = account;
        Set emptySet = set == null ? Collections.emptySet() : Collections.unmodifiableSet(set);
        this.zab = emptySet;
        map = map == null ? Collections.emptyMap() : map;
        this.zad = map;
        this.zaf = view;
        this.zae = i11;
        this.zag = str;
        this.zah = str2;
        this.zai = signInOptions == null ? SignInOptions.zaa : signInOptions;
        HashSet hashSet = new HashSet(emptySet);
        for (zab zab2 : map.values()) {
            hashSet.addAll(zab2.zaa);
        }
        this.zac = Collections.unmodifiableSet(hashSet);
    }
}
