package com.google.android.gms.common;

import android.accounts.Account;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;
import java.util.ArrayList;
import java.util.List;

public final class AccountPicker {

    public static class AccountChooserOptions {
        /* access modifiers changed from: private */
        @Nullable
        public Account zza;
        /* access modifiers changed from: private */
        public boolean zzb;
        /* access modifiers changed from: private */
        @Nullable
        public ArrayList zzc;
        /* access modifiers changed from: private */
        @Nullable
        public ArrayList zzd;
        /* access modifiers changed from: private */
        public boolean zze;
        /* access modifiers changed from: private */
        @Nullable
        public String zzf;
        /* access modifiers changed from: private */
        @Nullable
        public Bundle zzg;
        /* access modifiers changed from: private */
        public boolean zzh;
        /* access modifiers changed from: private */
        public int zzi;
        /* access modifiers changed from: private */
        @Nullable
        public String zzj;
        /* access modifiers changed from: private */
        public boolean zzk;
        /* access modifiers changed from: private */
        @Nullable
        public zza zzl;
        /* access modifiers changed from: private */
        @Nullable
        public String zzm;
        /* access modifiers changed from: private */
        public boolean zzn;
        /* access modifiers changed from: private */
        public boolean zzo;

        public static class Builder {
            @Nullable
            private Account zza;
            @Nullable
            private ArrayList zzb;
            @Nullable
            private ArrayList zzc;
            private boolean zzd = false;
            @Nullable
            private String zze;
            @Nullable
            private Bundle zzf;

            @NonNull
            public AccountChooserOptions build() {
                Preconditions.checkArgument(true, "We only support hostedDomain filter for account chip styled account picker");
                Preconditions.checkArgument(true, "Consent is only valid for account chip styled account picker");
                AccountChooserOptions accountChooserOptions = new AccountChooserOptions();
                accountChooserOptions.zzd = this.zzc;
                accountChooserOptions.zzc = this.zzb;
                accountChooserOptions.zze = this.zzd;
                accountChooserOptions.zzl = null;
                accountChooserOptions.zzj = null;
                accountChooserOptions.zzg = this.zzf;
                accountChooserOptions.zza = this.zza;
                accountChooserOptions.zzb = false;
                accountChooserOptions.zzh = false;
                accountChooserOptions.zzm = null;
                accountChooserOptions.zzi = 0;
                accountChooserOptions.zzf = this.zze;
                accountChooserOptions.zzk = false;
                accountChooserOptions.zzn = false;
                accountChooserOptions.zzo = false;
                return accountChooserOptions;
            }

            @NonNull
            @CanIgnoreReturnValue
            public Builder setAllowableAccounts(@Nullable List<Account> list) {
                this.zzb = list == null ? null : new ArrayList(list);
                return this;
            }

            @NonNull
            @CanIgnoreReturnValue
            public Builder setAllowableAccountsTypes(@Nullable List<String> list) {
                this.zzc = list == null ? null : new ArrayList(list);
                return this;
            }

            @NonNull
            @CanIgnoreReturnValue
            public Builder setAlwaysShowAccountPicker(boolean z11) {
                this.zzd = z11;
                return this;
            }

            @NonNull
            @CanIgnoreReturnValue
            public Builder setOptionsForAddingAccount(@Nullable Bundle bundle) {
                this.zzf = bundle;
                return this;
            }

            @NonNull
            @CanIgnoreReturnValue
            public Builder setSelectedAccount(@Nullable Account account) {
                this.zza = account;
                return this;
            }

            @NonNull
            @CanIgnoreReturnValue
            public Builder setTitleOverrideText(@Nullable String str) {
                this.zze = str;
                return this;
            }
        }
    }

    private AccountPicker() {
    }

    @ResultIgnorabilityUnspecified
    @NonNull
    @Deprecated
    public static Intent newChooseAccountIntent(@Nullable Account account, @Nullable ArrayList<Account> arrayList, @Nullable String[] strArr, boolean z11, @Nullable String str, @Nullable String str2, @Nullable String[] strArr2, @Nullable Bundle bundle) {
        Intent intent = new Intent();
        Preconditions.checkArgument(true, "We only support hostedDomain filter for account chip styled account picker");
        intent.setAction("com.google.android.gms.common.account.CHOOSE_ACCOUNT");
        intent.setPackage("com.google.android.gms");
        intent.putExtra(com.huawei.hms.common.AccountPicker.EXTRA_ALLOWABLE_ACCOUNTS_ARRAYLIST, arrayList);
        intent.putExtra(com.huawei.hms.common.AccountPicker.EXTRA_ALLOWABLE_ACCOUNT_TYPES_STRING_ARRAY, strArr);
        intent.putExtra(com.huawei.hms.common.AccountPicker.EXTRA_ADD_ACCOUNT_OPTIONS_BUNDLE, bundle);
        intent.putExtra(com.huawei.hms.common.AccountPicker.EXTRA_SELECTED_ACCOUNT, account);
        intent.putExtra(com.huawei.hms.common.AccountPicker.EXTRA_ALWAYS_PROMPT_FOR_ACCOUNT, z11);
        intent.putExtra(com.huawei.hms.common.AccountPicker.EXTRA_DESCRIPTION_TEXT_OVERRIDE, str);
        intent.putExtra(com.huawei.hms.common.AccountPicker.EXTRA_ADD_ACCOUNT_AUTH_TOKEN_TYPE_STRING, str2);
        intent.putExtra(com.huawei.hms.common.AccountPicker.EXTRA_ADD_ACCOUNT_REQUIRED_FEATURES_STRING_ARRAY, strArr2);
        intent.putExtra("setGmsCoreAccount", false);
        intent.putExtra(com.huawei.hms.common.AccountPicker.EXTRA_OVERRIDE_THEME, 0);
        intent.putExtra(com.huawei.hms.common.AccountPicker.EXTRA_OVERRIDE_CUSTOM_THEME, 0);
        intent.putExtra(com.huawei.hms.common.AccountPicker.EXTRA_HOSTED_DOMAIN_FILTER, (String) null);
        return intent;
    }

    @NonNull
    public static Intent newChooseAccountIntent(@NonNull AccountChooserOptions accountChooserOptions) {
        Intent intent = new Intent();
        boolean unused = accountChooserOptions.zzk;
        String unused2 = accountChooserOptions.zzj;
        Preconditions.checkArgument(true, "We only support hostedDomain filter for account chip styled account picker");
        zza unused3 = accountChooserOptions.zzl;
        Preconditions.checkArgument(true, "Consent is only valid for account chip styled account picker");
        boolean unused4 = accountChooserOptions.zzb;
        Preconditions.checkArgument(true, "Making the selected account non-clickable is only supported for the THEME_DAY_NIGHT_GOOGLE_MATERIAL2, THEME_LIGHT_GOOGLE_MATERIAL3, THEME_DARK_GOOGLE_MATERIAL3 or THEME_DAY_NIGHT_GOOGLE_MATERIAL3 themes");
        boolean unused5 = accountChooserOptions.zzk;
        intent.setAction("com.google.android.gms.common.account.CHOOSE_ACCOUNT");
        intent.setPackage("com.google.android.gms");
        intent.putExtra(com.huawei.hms.common.AccountPicker.EXTRA_ALLOWABLE_ACCOUNTS_ARRAYLIST, accountChooserOptions.zzc);
        if (accountChooserOptions.zzd != null) {
            intent.putExtra(com.huawei.hms.common.AccountPicker.EXTRA_ALLOWABLE_ACCOUNT_TYPES_STRING_ARRAY, (String[]) accountChooserOptions.zzd.toArray(new String[0]));
        }
        intent.putExtra(com.huawei.hms.common.AccountPicker.EXTRA_ADD_ACCOUNT_OPTIONS_BUNDLE, accountChooserOptions.zzg);
        intent.putExtra(com.huawei.hms.common.AccountPicker.EXTRA_SELECTED_ACCOUNT, accountChooserOptions.zza);
        boolean unused6 = accountChooserOptions.zzb;
        intent.putExtra("selectedAccountIsNotClickable", false);
        intent.putExtra(com.huawei.hms.common.AccountPicker.EXTRA_ALWAYS_PROMPT_FOR_ACCOUNT, accountChooserOptions.zze);
        intent.putExtra(com.huawei.hms.common.AccountPicker.EXTRA_DESCRIPTION_TEXT_OVERRIDE, accountChooserOptions.zzf);
        boolean unused7 = accountChooserOptions.zzh;
        intent.putExtra("setGmsCoreAccount", false);
        String unused8 = accountChooserOptions.zzm;
        intent.putExtra(com.huawei.hms.common.AccountPicker.EXTRA_REAL_CLIENT_PACKAGE, (String) null);
        int unused9 = accountChooserOptions.zzi;
        intent.putExtra(com.huawei.hms.common.AccountPicker.EXTRA_OVERRIDE_THEME, 0);
        boolean unused10 = accountChooserOptions.zzk;
        intent.putExtra(com.huawei.hms.common.AccountPicker.EXTRA_OVERRIDE_CUSTOM_THEME, 0);
        String unused11 = accountChooserOptions.zzj;
        intent.putExtra(com.huawei.hms.common.AccountPicker.EXTRA_HOSTED_DOMAIN_FILTER, (String) null);
        Bundle bundle = new Bundle();
        boolean unused12 = accountChooserOptions.zzk;
        zza unused13 = accountChooserOptions.zzl;
        boolean unused14 = accountChooserOptions.zzn;
        boolean unused15 = accountChooserOptions.zzo;
        if (!bundle.isEmpty()) {
            intent.putExtra("first_party_options_bundle", bundle);
        }
        return intent;
    }
}
