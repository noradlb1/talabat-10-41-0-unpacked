package com.google.firebase.auth;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.p002firebaseauthapi.zzabb;
import com.google.android.gms.internal.p002firebaseauthapi.zzacn;
import com.google.android.gms.internal.p002firebaseauthapi.zzaes;
import com.google.firebase.auth.internal.GenericIdpActivity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class OAuthProvider extends FederatedAuthProvider {
    private final Bundle zza;

    public static class Builder {
        @VisibleForTesting
        final Bundle zza;
        private final FirebaseAuth zzb;
        private final Bundle zzc;

        public /* synthetic */ Builder(String str, FirebaseAuth firebaseAuth, zzan zzan) {
            Bundle bundle = new Bundle();
            this.zza = bundle;
            Bundle bundle2 = new Bundle();
            this.zzc = bundle2;
            this.zzb = firebaseAuth;
            bundle.putString("com.google.firebase.auth.KEY_API_KEY", firebaseAuth.getApp().getOptions().getApiKey());
            bundle.putString("com.google.firebase.auth.KEY_PROVIDER_ID", str);
            bundle.putBundle("com.google.firebase.auth.KEY_PROVIDER_CUSTOM_PARAMS", bundle2);
            bundle.putString("com.google.firebase.auth.internal.CLIENT_VERSION", zzabb.zza().zzb());
            bundle.putString("com.google.firebase.auth.KEY_TENANT_ID", firebaseAuth.getTenantId());
            bundle.putString("com.google.firebase.auth.KEY_FIREBASE_APP_NAME", firebaseAuth.getApp().getName());
        }

        @NonNull
        public Builder addCustomParameter(@NonNull String str, @NonNull String str2) {
            this.zzc.putString(str, str2);
            return this;
        }

        @NonNull
        public Builder addCustomParameters(@NonNull Map<String, String> map) {
            for (Map.Entry next : map.entrySet()) {
                this.zzc.putString((String) next.getKey(), (String) next.getValue());
            }
            return this;
        }

        @NonNull
        public OAuthProvider build() {
            return new OAuthProvider(this.zza, (zzap) null);
        }

        @NonNull
        @KeepForSdk
        public List<String> getScopes() {
            ArrayList<String> stringArrayList = this.zza.getStringArrayList("com.google.firebase.auth.KEY_PROVIDER_SCOPES");
            if (stringArrayList != null) {
                return stringArrayList;
            }
            return Collections.emptyList();
        }

        @NonNull
        public Builder setScopes(@NonNull List<String> list) {
            this.zza.putStringArrayList("com.google.firebase.auth.KEY_PROVIDER_SCOPES", new ArrayList(list));
            return this;
        }
    }

    public static class CredentialBuilder {
        private final String zza;
        @Nullable
        private String zzb;
        @Nullable
        private String zzc;
        @Nullable
        private String zzd;

        public /* synthetic */ CredentialBuilder(String str, zzao zzao) {
            this.zza = str;
        }

        @NonNull
        public AuthCredential build() {
            String str = this.zza;
            String str2 = this.zzb;
            String str3 = this.zzc;
            String str4 = this.zzd;
            Parcelable.Creator<zze> creator = zze.CREATOR;
            Preconditions.checkNotEmpty(str, "Must specify a non-empty providerId");
            if (!TextUtils.isEmpty(str2) || !TextUtils.isEmpty(str3)) {
                return new zze(str, str2, str3, (zzaes) null, (String) null, (String) null, str4);
            }
            throw new IllegalArgumentException("Must specify an idToken or an accessToken.");
        }

        @KeepForSdk
        @Nullable
        public String getAccessToken() {
            return this.zzc;
        }

        @KeepForSdk
        @Nullable
        public String getIdToken() {
            return this.zzb;
        }

        @NonNull
        public CredentialBuilder setAccessToken(@NonNull String str) {
            this.zzc = str;
            return this;
        }

        @NonNull
        public CredentialBuilder setIdToken(@NonNull String str) {
            this.zzb = str;
            return this;
        }

        @NonNull
        public CredentialBuilder setIdTokenWithRawNonce(@NonNull String str, @Nullable String str2) {
            this.zzb = str;
            this.zzd = str2;
            return this;
        }
    }

    public /* synthetic */ OAuthProvider(Bundle bundle, zzap zzap) {
        this.zza = bundle;
    }

    @NonNull
    @Deprecated
    public static AuthCredential getCredential(@NonNull String str, @NonNull String str2, @NonNull String str3) {
        return zze.zzc(str, str2, str3, (String) null, (String) null);
    }

    @NonNull
    public static Builder newBuilder(@NonNull String str) {
        return newBuilder(str, FirebaseAuth.getInstance());
    }

    @NonNull
    public static CredentialBuilder newCredentialBuilder(@NonNull String str) {
        return new CredentialBuilder(Preconditions.checkNotEmpty(str), (zzao) null);
    }

    @Nullable
    public String getProviderId() {
        return this.zza.getString("com.google.firebase.auth.KEY_PROVIDER_ID");
    }

    public final void zza(@NonNull Activity activity) {
        Intent intent = new Intent("com.google.firebase.auth.internal.NONGMSCORE_LINK");
        intent.setClass(activity, GenericIdpActivity.class);
        intent.setPackage(activity.getPackageName());
        intent.putExtras(this.zza);
        activity.startActivity(intent);
    }

    public final void zzb(@NonNull Activity activity) {
        Intent intent = new Intent("com.google.firebase.auth.internal.NONGMSCORE_REAUTHENTICATE");
        intent.setClass(activity, GenericIdpActivity.class);
        intent.setPackage(activity.getPackageName());
        intent.putExtras(this.zza);
        activity.startActivity(intent);
    }

    public final void zzc(@NonNull Activity activity) {
        Intent intent = new Intent("com.google.firebase.auth.internal.NONGMSCORE_SIGN_IN");
        intent.setClass(activity, GenericIdpActivity.class);
        intent.setPackage(activity.getPackageName());
        intent.putExtras(this.zza);
        activity.startActivity(intent);
    }

    @NonNull
    public static Builder newBuilder(@NonNull String str, @NonNull FirebaseAuth firebaseAuth) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(firebaseAuth);
        if (!"facebook.com".equals(str) || zzacn.zzg(firebaseAuth.getApp())) {
            return new Builder(str, firebaseAuth, (zzan) null);
        }
        throw new IllegalArgumentException("Sign in with Facebook is not supported via this method; the Facebook TOS dictate that you must use the Facebook Android SDK for Facebook login.");
    }
}
