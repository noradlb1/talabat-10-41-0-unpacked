package com.google.firebase.auth;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.p002firebaseauthapi.zzaal;
import com.google.android.gms.internal.p002firebaseauthapi.zzaap;
import com.google.android.gms.internal.p002firebaseauthapi.zzaau;
import com.google.android.gms.internal.p002firebaseauthapi.zzabe;
import com.google.android.gms.internal.p002firebaseauthapi.zzacd;
import com.google.android.gms.internal.p002firebaseauthapi.zzacn;
import com.google.android.gms.internal.p002firebaseauthapi.zzadr;
import com.google.android.gms.internal.p002firebaseauthapi.zzaeb;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.android.recaptcha.RecaptchaAction;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseError;
import com.google.firebase.annotations.concurrent.Background;
import com.google.firebase.annotations.concurrent.Blocking;
import com.google.firebase.annotations.concurrent.Lightweight;
import com.google.firebase.annotations.concurrent.UiThread;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.auth.internal.InternalAuthProvider;
import com.google.firebase.auth.internal.zzag;
import com.google.firebase.auth.internal.zzba;
import com.google.firebase.auth.internal.zzbr;
import com.google.firebase.auth.internal.zzbt;
import com.google.firebase.auth.internal.zzbv;
import com.google.firebase.auth.internal.zzbx;
import com.google.firebase.auth.internal.zzbz;
import com.google.firebase.auth.internal.zzf;
import com.google.firebase.auth.internal.zzr;
import com.google.firebase.auth.internal.zzw;
import com.google.firebase.auth.internal.zzx;
import com.google.firebase.inject.Provider;
import com.google.firebase.internal.InternalTokenResult;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

public abstract class FirebaseAuth implements InternalAuthProvider {
    public static final /* synthetic */ int zza = 0;
    /* access modifiers changed from: private */
    public final FirebaseApp zzb;
    /* access modifiers changed from: private */
    public final List zzc = new CopyOnWriteArrayList();
    /* access modifiers changed from: private */
    public final List zzd = new CopyOnWriteArrayList();
    /* access modifiers changed from: private */
    public final List zze = new CopyOnWriteArrayList();
    /* access modifiers changed from: private */
    public final zzaal zzf;
    /* access modifiers changed from: private */
    @Nullable
    public FirebaseUser zzg;
    /* access modifiers changed from: private */
    public final zzw zzh;
    private final Object zzi = new Object();
    /* access modifiers changed from: private */
    public String zzj;
    private final Object zzk = new Object();
    /* access modifiers changed from: private */
    public String zzl;
    private zzbr zzm;
    private final RecaptchaAction zzn = RecaptchaAction.custom("getOobCode");
    private final RecaptchaAction zzo = RecaptchaAction.custom("signInWithPassword");
    private final RecaptchaAction zzp = RecaptchaAction.custom("signUpPassword");
    private final zzbt zzq;
    private final zzbz zzr;
    private final zzf zzs;
    private final Provider zzt;
    private final Provider zzu;
    private zzbv zzv;
    private final Executor zzw;
    private final Executor zzx;
    private final Executor zzy;

    public interface AuthStateListener {
        void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth);
    }

    public interface IdTokenListener {
        void onIdTokenChanged(@NonNull FirebaseAuth firebaseAuth);
    }

    public FirebaseAuth(@NonNull FirebaseApp firebaseApp, @NonNull Provider provider, @NonNull Provider provider2, @Background @NonNull Executor executor, @NonNull @Blocking Executor executor2, @Lightweight @NonNull Executor executor3, @Lightweight @NonNull ScheduledExecutorService scheduledExecutorService, @NonNull @UiThread Executor executor4) {
        zzadr zzb2;
        zzaal zzaal = new zzaal(firebaseApp, executor2, scheduledExecutorService);
        zzbt zzbt = new zzbt(firebaseApp.getApplicationContext(), firebaseApp.getPersistenceKey());
        zzbz zzc2 = zzbz.zzc();
        zzf zzb3 = zzf.zzb();
        this.zzb = (FirebaseApp) Preconditions.checkNotNull(firebaseApp);
        this.zzf = (zzaal) Preconditions.checkNotNull(zzaal);
        zzbt zzbt2 = (zzbt) Preconditions.checkNotNull(zzbt);
        this.zzq = zzbt2;
        this.zzh = new zzw();
        zzbz zzbz = (zzbz) Preconditions.checkNotNull(zzc2);
        this.zzr = zzbz;
        this.zzs = (zzf) Preconditions.checkNotNull(zzb3);
        this.zzt = provider;
        this.zzu = provider2;
        this.zzw = executor2;
        this.zzx = executor3;
        this.zzy = executor4;
        FirebaseUser zza2 = zzbt2.zza();
        this.zzg = zza2;
        if (!(zza2 == null || (zzb2 = zzbt2.zzb(zza2)) == null)) {
            zzT(this, this.zzg, zzb2, false, false);
        }
        zzbz.zze(this);
    }

    @NonNull
    @Keep
    public static FirebaseAuth getInstance() {
        return (FirebaseAuth) FirebaseApp.getInstance().get(FirebaseAuth.class);
    }

    public static zzbv zzD(FirebaseAuth firebaseAuth) {
        if (firebaseAuth.zzv == null) {
            firebaseAuth.zzv = new zzbv((FirebaseApp) Preconditions.checkNotNull(firebaseAuth.zzb));
        }
        return firebaseAuth.zzv;
    }

    public static void zzR(@NonNull FirebaseAuth firebaseAuth, @Nullable FirebaseUser firebaseUser) {
        if (firebaseUser != null) {
            String uid = firebaseUser.getUid();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Notifying auth state listeners about user ( ");
            sb2.append(uid);
            sb2.append(" ).");
        }
        firebaseAuth.zzy.execute(new zzw(firebaseAuth));
    }

    public static void zzS(@NonNull FirebaseAuth firebaseAuth, @Nullable FirebaseUser firebaseUser) {
        String str;
        if (firebaseUser != null) {
            String uid = firebaseUser.getUid();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Notifying id token listeners about user ( ");
            sb2.append(uid);
            sb2.append(" ).");
        }
        if (firebaseUser != null) {
            str = firebaseUser.zze();
        } else {
            str = null;
        }
        firebaseAuth.zzy.execute(new zzv(firebaseAuth, new InternalTokenResult(str)));
    }

    @VisibleForTesting
    public static void zzT(FirebaseAuth firebaseAuth, FirebaseUser firebaseUser, zzadr zzadr, boolean z11, boolean z12) {
        boolean z13;
        boolean z14;
        Preconditions.checkNotNull(firebaseUser);
        Preconditions.checkNotNull(zzadr);
        boolean z15 = false;
        boolean z16 = true;
        if (firebaseAuth.zzg == null || !firebaseUser.getUid().equals(firebaseAuth.zzg.getUid())) {
            z13 = false;
        } else {
            z13 = true;
        }
        if (z13 || !z12) {
            FirebaseUser firebaseUser2 = firebaseAuth.zzg;
            if (firebaseUser2 == null) {
                z14 = true;
            } else {
                boolean z17 = !firebaseUser2.zzd().zze().equals(zzadr.zze());
                if (!z13 || z17) {
                    z15 = true;
                }
                z14 = true ^ z13;
                z16 = z15;
            }
            Preconditions.checkNotNull(firebaseUser);
            if (firebaseAuth.zzg == null || !firebaseUser.getUid().equals(firebaseAuth.getUid())) {
                firebaseAuth.zzg = firebaseUser;
            } else {
                firebaseAuth.zzg.zzc(firebaseUser.getProviderData());
                if (!firebaseUser.isAnonymous()) {
                    firebaseAuth.zzg.zzb();
                }
                firebaseAuth.zzg.zzi(firebaseUser.getMultiFactor().getEnrolledFactors());
            }
            if (z11) {
                firebaseAuth.zzq.zzd(firebaseAuth.zzg);
            }
            if (z16) {
                FirebaseUser firebaseUser3 = firebaseAuth.zzg;
                if (firebaseUser3 != null) {
                    firebaseUser3.zzh(zzadr);
                }
                zzS(firebaseAuth, firebaseAuth.zzg);
            }
            if (z14) {
                zzR(firebaseAuth, firebaseAuth.zzg);
            }
            if (z11) {
                firebaseAuth.zzq.zze(firebaseUser, zzadr);
            }
            FirebaseUser firebaseUser4 = firebaseAuth.zzg;
            if (firebaseUser4 != null) {
                zzD(firebaseAuth).zze(firebaseUser4.zzd());
            }
        }
    }

    public static final void zzX(@NonNull FirebaseAuthMissingActivityForRecaptchaException firebaseAuthMissingActivityForRecaptchaException, @NonNull PhoneAuthOptions phoneAuthOptions, @NonNull String str) {
        Log.e("FirebaseAuth", "Invoking verification failure callback with MissingActivity exception for phone number/uid - ".concat(String.valueOf(str)));
        phoneAuthOptions.zzi().execute(new zzi(zzacd.zza(str, phoneAuthOptions.zze(), (zzabp) null), firebaseAuthMissingActivityForRecaptchaException));
    }

    private final Task zzY(FirebaseUser firebaseUser, EmailAuthCredential emailAuthCredential, boolean z11) {
        return new zzab(this, z11, firebaseUser, emailAuthCredential).zzb(this, this.zzl, z11 ? this.zzn : this.zzo);
    }

    private final Task zzZ(String str, String str2, @Nullable String str3, @Nullable FirebaseUser firebaseUser, boolean z11) {
        return new zzz(this, str, z11, firebaseUser, str2, str3).zzb(this, str3, this.zzo);
    }

    private final Task zzaa(EmailAuthCredential emailAuthCredential, @Nullable FirebaseUser firebaseUser, boolean z11) {
        return new zzaa(this, z11, firebaseUser, emailAuthCredential).zzb(this, this.zzl, this.zzn);
    }

    /* access modifiers changed from: private */
    public final PhoneAuthProvider.OnVerificationStateChangedCallbacks zzab(@Nullable String str, PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks) {
        zzw zzw2 = this.zzh;
        if (!zzw2.zzd() || str == null || !str.equals(zzw2.zza())) {
            return onVerificationStateChangedCallbacks;
        }
        return new zzl(this, onVerificationStateChangedCallbacks);
    }

    private final boolean zzac(String str) {
        ActionCodeUrl parseLink = ActionCodeUrl.parseLink(str);
        if (parseLink == null || TextUtils.equals(this.zzl, parseLink.zza())) {
            return false;
        }
        return true;
    }

    public void addAuthStateListener(@NonNull AuthStateListener authStateListener) {
        this.zze.add(authStateListener);
        this.zzy.execute(new zzu(this, authStateListener));
    }

    public void addIdTokenListener(@NonNull IdTokenListener idTokenListener) {
        this.zzc.add(idTokenListener);
        this.zzy.execute(new zzt(this, idTokenListener));
    }

    @NonNull
    public Task<Void> applyActionCode(@NonNull String str) {
        Preconditions.checkNotEmpty(str);
        return this.zzf.zza(this.zzb, str, this.zzl);
    }

    @NonNull
    public Task<ActionCodeResult> checkActionCode(@NonNull String str) {
        Preconditions.checkNotEmpty(str);
        return this.zzf.zzb(this.zzb, str, this.zzl);
    }

    @NonNull
    public Task<Void> confirmPasswordReset(@NonNull String str, @NonNull String str2) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        return this.zzf.zzc(this.zzb, str, str2, this.zzl);
    }

    @NonNull
    public Task<AuthResult> createUserWithEmailAndPassword(@NonNull String str, @NonNull String str2) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        return new zzn(this, str, str2).zzb(this, this.zzl, this.zzp);
    }

    @NonNull
    public Task<SignInMethodQueryResult> fetchSignInMethodsForEmail(@NonNull String str) {
        Preconditions.checkNotEmpty(str);
        return this.zzf.zzf(this.zzb, str, this.zzl);
    }

    @NonNull
    public final Task getAccessToken(boolean z11) {
        return zzc(this.zzg, z11);
    }

    @NonNull
    public FirebaseApp getApp() {
        return this.zzb;
    }

    @Nullable
    public FirebaseUser getCurrentUser() {
        return this.zzg;
    }

    @NonNull
    public FirebaseAuthSettings getFirebaseAuthSettings() {
        return this.zzh;
    }

    @Nullable
    public String getLanguageCode() {
        String str;
        synchronized (this.zzi) {
            str = this.zzj;
        }
        return str;
    }

    @Nullable
    public Task<AuthResult> getPendingAuthResult() {
        return this.zzr.zza();
    }

    @Nullable
    public String getTenantId() {
        String str;
        synchronized (this.zzk) {
            str = this.zzl;
        }
        return str;
    }

    @Nullable
    public final String getUid() {
        FirebaseUser firebaseUser = this.zzg;
        if (firebaseUser == null) {
            return null;
        }
        return firebaseUser.getUid();
    }

    @NonNull
    public Task<Void> initializeRecaptchaConfig() {
        if (this.zzm == null) {
            this.zzm = new zzbr(this.zzb, this);
        }
        return this.zzm.zzb(this.zzl, Boolean.FALSE).continueWithTask(new zzy(this));
    }

    public boolean isSignInWithEmailLink(@NonNull String str) {
        return EmailAuthCredential.zzi(str);
    }

    public void removeAuthStateListener(@NonNull AuthStateListener authStateListener) {
        this.zze.remove(authStateListener);
    }

    public void removeIdTokenListener(@NonNull IdTokenListener idTokenListener) {
        this.zzc.remove(idTokenListener);
    }

    @NonNull
    public Task<Void> sendPasswordResetEmail(@NonNull String str) {
        Preconditions.checkNotEmpty(str);
        return sendPasswordResetEmail(str, (ActionCodeSettings) null);
    }

    @NonNull
    public Task<Void> sendSignInLinkToEmail(@NonNull String str, @NonNull ActionCodeSettings actionCodeSettings) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(actionCodeSettings);
        if (actionCodeSettings.canHandleCodeInApp()) {
            String str2 = this.zzj;
            if (str2 != null) {
                actionCodeSettings.zzf(str2);
            }
            return new zzp(this, str, actionCodeSettings).zzb(this, this.zzl, this.zzn);
        }
        throw new IllegalArgumentException("You must set canHandleCodeInApp in your ActionCodeSettings to true for Email-Link Sign-in.");
    }

    @NonNull
    public Task<Void> setFirebaseUIVersion(@Nullable String str) {
        return this.zzf.zzA(str);
    }

    public void setLanguageCode(@NonNull String str) {
        Preconditions.checkNotEmpty(str);
        synchronized (this.zzi) {
            this.zzj = str;
        }
    }

    public void setTenantId(@NonNull String str) {
        Preconditions.checkNotEmpty(str);
        synchronized (this.zzk) {
            this.zzl = str;
        }
    }

    @NonNull
    public Task<AuthResult> signInAnonymously() {
        FirebaseUser firebaseUser = this.zzg;
        if (firebaseUser == null || !firebaseUser.isAnonymous()) {
            return this.zzf.zzB(this.zzb, new zzac(this), this.zzl);
        }
        zzx zzx2 = (zzx) this.zzg;
        zzx2.zzq(false);
        return Tasks.forResult(new zzr(zzx2));
    }

    @NonNull
    public Task<AuthResult> signInWithCredential(@NonNull AuthCredential authCredential) {
        Preconditions.checkNotNull(authCredential);
        AuthCredential zza2 = authCredential.zza();
        if (zza2 instanceof EmailAuthCredential) {
            EmailAuthCredential emailAuthCredential = (EmailAuthCredential) zza2;
            if (!emailAuthCredential.zzg()) {
                return zzZ(emailAuthCredential.zzd(), (String) Preconditions.checkNotNull(emailAuthCredential.zze()), this.zzl, (FirebaseUser) null, false);
            } else if (zzac(Preconditions.checkNotEmpty(emailAuthCredential.zzf()))) {
                return Tasks.forException(zzaap.zza(new Status(17072)));
            } else {
                return zzaa(emailAuthCredential, (FirebaseUser) null, false);
            }
        } else if (!(zza2 instanceof PhoneAuthCredential)) {
            return this.zzf.zzC(this.zzb, zza2, this.zzl, new zzac(this));
        } else {
            return this.zzf.zzG(this.zzb, (PhoneAuthCredential) zza2, this.zzl, new zzac(this));
        }
    }

    @NonNull
    public Task<AuthResult> signInWithCustomToken(@NonNull String str) {
        Preconditions.checkNotEmpty(str);
        return this.zzf.zzD(this.zzb, str, this.zzl, new zzac(this));
    }

    @NonNull
    public Task<AuthResult> signInWithEmailAndPassword(@NonNull String str, @NonNull String str2) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        return zzZ(str, str2, this.zzl, (FirebaseUser) null, false);
    }

    @NonNull
    public Task<AuthResult> signInWithEmailLink(@NonNull String str, @NonNull String str2) {
        return signInWithCredential(EmailAuthProvider.getCredentialWithLink(str, str2));
    }

    public void signOut() {
        zzO();
        zzbv zzbv = this.zzv;
        if (zzbv != null) {
            zzbv.zzc();
        }
    }

    @NonNull
    public Task<AuthResult> startActivityForSignInWithProvider(@NonNull Activity activity, @NonNull FederatedAuthProvider federatedAuthProvider) {
        Preconditions.checkNotNull(federatedAuthProvider);
        Preconditions.checkNotNull(activity);
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        if (!this.zzr.zzi(activity, taskCompletionSource, this)) {
            return Tasks.forException(zzaap.zza(new Status(17057)));
        }
        this.zzr.zzg(activity.getApplicationContext(), this);
        federatedAuthProvider.zzc(activity);
        return taskCompletionSource.getTask();
    }

    @NonNull
    public Task<Void> updateCurrentUser(@NonNull FirebaseUser firebaseUser) {
        String str;
        if (firebaseUser != null) {
            String tenantId = firebaseUser.getTenantId();
            if ((tenantId != null && !tenantId.equals(this.zzl)) || ((str = this.zzl) != null && !str.equals(tenantId))) {
                return Tasks.forException(zzaap.zza(new Status(17072)));
            }
            String apiKey = firebaseUser.zza().getOptions().getApiKey();
            String apiKey2 = this.zzb.getOptions().getApiKey();
            if (!firebaseUser.zzd().zzj() || !apiKey2.equals(apiKey)) {
                return zzi(firebaseUser, new zzae(this));
            }
            zzQ(zzx.zzk(this.zzb, firebaseUser), firebaseUser.zzd(), true);
            return Tasks.forResult(null);
        }
        throw new IllegalArgumentException("Cannot update current user with null user!");
    }

    public void useAppLanguage() {
        synchronized (this.zzi) {
            this.zzj = zzabe.zza();
        }
    }

    public void useEmulator(@NonNull String str, int i11) {
        Preconditions.checkNotEmpty(str);
        boolean z11 = false;
        if (i11 >= 0 && i11 <= 65535) {
            z11 = true;
        }
        Preconditions.checkArgument(z11, "Port number must be in the range 0-65535");
        zzacn.zzf(this.zzb, str, i11);
    }

    @NonNull
    public Task<String> verifyPasswordResetCode(@NonNull String str) {
        Preconditions.checkNotEmpty(str);
        return this.zzf.zzR(this.zzb, str, this.zzl);
    }

    public final synchronized zzbr zzB() {
        return this.zzm;
    }

    @VisibleForTesting
    public final synchronized zzbv zzC() {
        return zzD(this);
    }

    @NonNull
    public final Provider zzE() {
        return this.zzt;
    }

    @NonNull
    public final Provider zzF() {
        return this.zzu;
    }

    @NonNull
    public final Executor zzL() {
        return this.zzw;
    }

    @NonNull
    public final Executor zzM() {
        return this.zzx;
    }

    @NonNull
    public final Executor zzN() {
        return this.zzy;
    }

    public final void zzO() {
        Preconditions.checkNotNull(this.zzq);
        FirebaseUser firebaseUser = this.zzg;
        if (firebaseUser != null) {
            zzbt zzbt = this.zzq;
            Preconditions.checkNotNull(firebaseUser);
            zzbt.zzc(String.format("com.google.firebase.auth.GET_TOKEN_RESPONSE.%s", new Object[]{firebaseUser.getUid()}));
            this.zzg = null;
        }
        this.zzq.zzc("com.google.firebase.auth.FIREBASE_USER");
        zzS(this, (FirebaseUser) null);
        zzR(this, (FirebaseUser) null);
    }

    public final synchronized void zzP(zzbr zzbr) {
        this.zzm = zzbr;
    }

    public final void zzQ(FirebaseUser firebaseUser, zzadr zzadr, boolean z11) {
        zzT(this, firebaseUser, zzadr, true, false);
    }

    public final void zzU(@NonNull PhoneAuthOptions phoneAuthOptions) {
        String str;
        String str2;
        if (phoneAuthOptions.zzm()) {
            FirebaseAuth zzb2 = phoneAuthOptions.zzb();
            if (((zzag) Preconditions.checkNotNull(phoneAuthOptions.zzc())).zzf()) {
                str2 = Preconditions.checkNotEmpty(phoneAuthOptions.zzh());
                str = str2;
            } else {
                PhoneMultiFactorInfo phoneMultiFactorInfo = (PhoneMultiFactorInfo) Preconditions.checkNotNull(phoneAuthOptions.zzf());
                String checkNotEmpty = Preconditions.checkNotEmpty(phoneMultiFactorInfo.getUid());
                str2 = phoneMultiFactorInfo.getPhoneNumber();
                str = checkNotEmpty;
            }
            if (phoneAuthOptions.zzd() == null || !zzacd.zzd(str, phoneAuthOptions.zze(), phoneAuthOptions.zza(), phoneAuthOptions.zzi())) {
                zzb2.zzs.zza(zzb2, str2, phoneAuthOptions.zza(), zzb2.zzW(), phoneAuthOptions.zzk()).addOnCompleteListener(new zzk(zzb2, phoneAuthOptions, str));
                return;
            }
            return;
        }
        FirebaseAuth zzb3 = phoneAuthOptions.zzb();
        String checkNotEmpty2 = Preconditions.checkNotEmpty(phoneAuthOptions.zzh());
        if (phoneAuthOptions.zzd() != null || !zzacd.zzd(checkNotEmpty2, phoneAuthOptions.zze(), phoneAuthOptions.zza(), phoneAuthOptions.zzi())) {
            zzb3.zzs.zza(zzb3, checkNotEmpty2, phoneAuthOptions.zza(), zzb3.zzW(), phoneAuthOptions.zzk()).addOnCompleteListener(new zzj(zzb3, phoneAuthOptions, checkNotEmpty2));
        }
    }

    public final void zzV(@NonNull PhoneAuthOptions phoneAuthOptions, @Nullable String str, @Nullable String str2) {
        boolean z11;
        PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks;
        long longValue = phoneAuthOptions.zzg().longValue();
        if (longValue < 0 || longValue > 120) {
            throw new IllegalArgumentException("We only support 0-120 seconds for sms-auto-retrieval timeout");
        }
        String checkNotEmpty = Preconditions.checkNotEmpty(phoneAuthOptions.zzh());
        if (phoneAuthOptions.zzd() != null) {
            z11 = true;
        } else {
            z11 = false;
        }
        zzaeb zzaeb = new zzaeb(checkNotEmpty, longValue, z11, this.zzj, this.zzl, str, str2, zzW());
        PhoneAuthProvider.OnVerificationStateChangedCallbacks zzab = zzab(checkNotEmpty, phoneAuthOptions.zze());
        if (TextUtils.isEmpty(str)) {
            onVerificationStateChangedCallbacks = zzy(phoneAuthOptions, zzab);
        } else {
            onVerificationStateChangedCallbacks = zzab;
        }
        this.zzf.zzT(this.zzb, zzaeb, onVerificationStateChangedCallbacks, phoneAuthOptions.zza(), phoneAuthOptions.zzi());
    }

    @VisibleForTesting
    public final boolean zzW() {
        return zzaau.zza(getApp().getApplicationContext());
    }

    @NonNull
    public final Task zza(@NonNull FirebaseUser firebaseUser) {
        Preconditions.checkNotNull(firebaseUser);
        return this.zzf.zze(firebaseUser, new zzr(this, firebaseUser));
    }

    @NonNull
    public final Task zzb(@NonNull FirebaseUser firebaseUser, @NonNull MultiFactorAssertion multiFactorAssertion, @Nullable String str) {
        Preconditions.checkNotNull(firebaseUser);
        Preconditions.checkNotNull(multiFactorAssertion);
        if (multiFactorAssertion instanceof PhoneMultiFactorAssertion) {
            return this.zzf.zzg(this.zzb, (PhoneMultiFactorAssertion) multiFactorAssertion, firebaseUser, str, new zzac(this));
        } else if (!(multiFactorAssertion instanceof TotpMultiFactorAssertion)) {
            return Tasks.forException(zzaap.zza(new Status(FirebaseError.ERROR_INTERNAL_ERROR)));
        } else {
            return this.zzf.zzh(this.zzb, (TotpMultiFactorAssertion) multiFactorAssertion, firebaseUser, str, this.zzl, new zzac(this));
        }
    }

    @NonNull
    public final Task zzc(@Nullable FirebaseUser firebaseUser, boolean z11) {
        if (firebaseUser == null) {
            return Tasks.forException(zzaap.zza(new Status(FirebaseError.ERROR_NO_SIGNED_IN_USER)));
        }
        zzadr zzd2 = firebaseUser.zzd();
        if (!zzd2.zzj() || z11) {
            return this.zzf.zzk(this.zzb, firebaseUser, zzd2.zzf(), new zzx(this));
        }
        return Tasks.forResult(zzba.zza(zzd2.zze()));
    }

    @NonNull
    public final Task zzd() {
        return this.zzf.zzl();
    }

    @NonNull
    public final Task zze(@NonNull String str) {
        return this.zzf.zzm(this.zzl, "RECAPTCHA_ENTERPRISE");
    }

    @NonNull
    public final Task zzf(@NonNull FirebaseUser firebaseUser, @NonNull AuthCredential authCredential) {
        Preconditions.checkNotNull(authCredential);
        Preconditions.checkNotNull(firebaseUser);
        return this.zzf.zzn(this.zzb, firebaseUser, authCredential.zza(), new zzad(this));
    }

    @NonNull
    public final Task zzg(@NonNull FirebaseUser firebaseUser, @NonNull AuthCredential authCredential) {
        Preconditions.checkNotNull(firebaseUser);
        Preconditions.checkNotNull(authCredential);
        AuthCredential zza2 = authCredential.zza();
        if (zza2 instanceof EmailAuthCredential) {
            EmailAuthCredential emailAuthCredential = (EmailAuthCredential) zza2;
            if ("password".equals(emailAuthCredential.getSignInMethod())) {
                return zzY(firebaseUser, emailAuthCredential, false);
            }
            if (zzac(Preconditions.checkNotEmpty(emailAuthCredential.zzf()))) {
                return Tasks.forException(zzaap.zza(new Status(17072)));
            }
            return zzY(firebaseUser, emailAuthCredential, true);
        } else if (zza2 instanceof PhoneAuthCredential) {
            return this.zzf.zzu(this.zzb, firebaseUser, (PhoneAuthCredential) zza2, this.zzl, new zzad(this));
        } else {
            return this.zzf.zzo(this.zzb, firebaseUser, zza2, firebaseUser.getTenantId(), new zzad(this));
        }
    }

    @NonNull
    public final Task zzh(@NonNull FirebaseUser firebaseUser, @NonNull AuthCredential authCredential) {
        Preconditions.checkNotNull(firebaseUser);
        Preconditions.checkNotNull(authCredential);
        AuthCredential zza2 = authCredential.zza();
        if (zza2 instanceof EmailAuthCredential) {
            EmailAuthCredential emailAuthCredential = (EmailAuthCredential) zza2;
            if ("password".equals(emailAuthCredential.getSignInMethod())) {
                return zzZ(emailAuthCredential.zzd(), Preconditions.checkNotEmpty(emailAuthCredential.zze()), firebaseUser.getTenantId(), firebaseUser, true);
            } else if (zzac(Preconditions.checkNotEmpty(emailAuthCredential.zzf()))) {
                return Tasks.forException(zzaap.zza(new Status(17072)));
            } else {
                return zzaa(emailAuthCredential, firebaseUser, true);
            }
        } else if (zza2 instanceof PhoneAuthCredential) {
            return this.zzf.zzv(this.zzb, firebaseUser, (PhoneAuthCredential) zza2, this.zzl, new zzad(this));
        } else {
            return this.zzf.zzp(this.zzb, firebaseUser, zza2, firebaseUser.getTenantId(), new zzad(this));
        }
    }

    public final Task zzi(FirebaseUser firebaseUser, zzbx zzbx) {
        Preconditions.checkNotNull(firebaseUser);
        return this.zzf.zzw(this.zzb, firebaseUser, zzbx);
    }

    public final Task zzj(MultiFactorAssertion multiFactorAssertion, zzag zzag, @Nullable FirebaseUser firebaseUser) {
        Preconditions.checkNotNull(multiFactorAssertion);
        Preconditions.checkNotNull(zzag);
        if (multiFactorAssertion instanceof PhoneMultiFactorAssertion) {
            return this.zzf.zzi(this.zzb, firebaseUser, (PhoneMultiFactorAssertion) multiFactorAssertion, Preconditions.checkNotEmpty(zzag.zze()), new zzac(this));
        } else if (multiFactorAssertion instanceof TotpMultiFactorAssertion) {
            return this.zzf.zzj(this.zzb, firebaseUser, (TotpMultiFactorAssertion) multiFactorAssertion, Preconditions.checkNotEmpty(zzag.zze()), this.zzl, new zzac(this));
        } else {
            throw new IllegalArgumentException("multiFactorAssertion must be either PhoneMultiFactorAssertion or TotpMultiFactorAssertion.");
        }
    }

    @NonNull
    public final Task zzk(@Nullable ActionCodeSettings actionCodeSettings, @NonNull String str) {
        Preconditions.checkNotEmpty(str);
        if (this.zzj != null) {
            if (actionCodeSettings == null) {
                actionCodeSettings = ActionCodeSettings.zzb();
            }
            actionCodeSettings.zzf(this.zzj);
        }
        return this.zzf.zzx(this.zzb, actionCodeSettings, str);
    }

    @NonNull
    public final Task zzl(@NonNull Activity activity, @NonNull FederatedAuthProvider federatedAuthProvider, @NonNull FirebaseUser firebaseUser) {
        Preconditions.checkNotNull(activity);
        Preconditions.checkNotNull(federatedAuthProvider);
        Preconditions.checkNotNull(firebaseUser);
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        if (!this.zzr.zzj(activity, taskCompletionSource, this, firebaseUser)) {
            return Tasks.forException(zzaap.zza(new Status(17057)));
        }
        this.zzr.zzh(activity.getApplicationContext(), this, firebaseUser);
        federatedAuthProvider.zza(activity);
        return taskCompletionSource.getTask();
    }

    @NonNull
    public final Task zzm(@NonNull Activity activity, @NonNull FederatedAuthProvider federatedAuthProvider, @NonNull FirebaseUser firebaseUser) {
        Preconditions.checkNotNull(activity);
        Preconditions.checkNotNull(federatedAuthProvider);
        Preconditions.checkNotNull(firebaseUser);
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        if (!this.zzr.zzj(activity, taskCompletionSource, this, firebaseUser)) {
            return Tasks.forException(zzaap.zza(new Status(17057)));
        }
        this.zzr.zzh(activity.getApplicationContext(), this, firebaseUser);
        federatedAuthProvider.zzb(activity);
        return taskCompletionSource.getTask();
    }

    public final Task zzn(zzag zzag) {
        Preconditions.checkNotNull(zzag);
        return this.zzf.zzI(zzag, this.zzl).continueWithTask(new zzs(this));
    }

    @NonNull
    public final Task zzo(@NonNull FirebaseUser firebaseUser, @NonNull String str) {
        Preconditions.checkNotNull(firebaseUser);
        Preconditions.checkNotEmpty(str);
        return this.zzf.zzK(this.zzb, firebaseUser, str, this.zzl, new zzad(this)).continueWithTask(new zzq(this));
    }

    @NonNull
    public final Task zzp(@NonNull FirebaseUser firebaseUser, @NonNull String str) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(firebaseUser);
        return this.zzf.zzL(this.zzb, firebaseUser, str, new zzad(this));
    }

    @NonNull
    public final Task zzq(@NonNull FirebaseUser firebaseUser, @NonNull String str) {
        Preconditions.checkNotNull(firebaseUser);
        Preconditions.checkNotEmpty(str);
        return this.zzf.zzM(this.zzb, firebaseUser, str, new zzad(this));
    }

    @NonNull
    public final Task zzr(@NonNull FirebaseUser firebaseUser, @NonNull String str) {
        Preconditions.checkNotNull(firebaseUser);
        Preconditions.checkNotEmpty(str);
        return this.zzf.zzN(this.zzb, firebaseUser, str, new zzad(this));
    }

    @NonNull
    public final Task zzs(@NonNull FirebaseUser firebaseUser, @NonNull PhoneAuthCredential phoneAuthCredential) {
        Preconditions.checkNotNull(firebaseUser);
        Preconditions.checkNotNull(phoneAuthCredential);
        return this.zzf.zzO(this.zzb, firebaseUser, phoneAuthCredential.clone(), new zzad(this));
    }

    @NonNull
    public final Task zzt(@NonNull FirebaseUser firebaseUser, @NonNull UserProfileChangeRequest userProfileChangeRequest) {
        Preconditions.checkNotNull(firebaseUser);
        Preconditions.checkNotNull(userProfileChangeRequest);
        return this.zzf.zzP(this.zzb, firebaseUser, userProfileChangeRequest, new zzad(this));
    }

    @NonNull
    public final Task zzu(@NonNull String str, @NonNull String str2, @Nullable ActionCodeSettings actionCodeSettings) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        if (actionCodeSettings == null) {
            actionCodeSettings = ActionCodeSettings.zzb();
        }
        String str3 = this.zzj;
        if (str3 != null) {
            actionCodeSettings.zzf(str3);
        }
        return this.zzf.zzQ(str, str2, actionCodeSettings);
    }

    @VisibleForTesting
    public final PhoneAuthProvider.OnVerificationStateChangedCallbacks zzy(PhoneAuthOptions phoneAuthOptions, PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks) {
        if (phoneAuthOptions.zzk()) {
            return onVerificationStateChangedCallbacks;
        }
        return new zzm(this, phoneAuthOptions, onVerificationStateChangedCallbacks);
    }

    @KeepForSdk
    public void removeIdTokenListener(@NonNull com.google.firebase.auth.internal.IdTokenListener idTokenListener) {
        Preconditions.checkNotNull(idTokenListener);
        this.zzd.remove(idTokenListener);
        zzC().zzd(this.zzd.size());
    }

    @NonNull
    @Keep
    public static FirebaseAuth getInstance(@NonNull FirebaseApp firebaseApp) {
        return (FirebaseAuth) firebaseApp.get(FirebaseAuth.class);
    }

    @KeepForSdk
    public void addIdTokenListener(@NonNull com.google.firebase.auth.internal.IdTokenListener idTokenListener) {
        Preconditions.checkNotNull(idTokenListener);
        this.zzd.add(idTokenListener);
        zzC().zzd(this.zzd.size());
    }

    @NonNull
    public Task<Void> sendPasswordResetEmail(@NonNull String str, @Nullable ActionCodeSettings actionCodeSettings) {
        Preconditions.checkNotEmpty(str);
        if (actionCodeSettings == null) {
            actionCodeSettings = ActionCodeSettings.zzb();
        }
        String str2 = this.zzj;
        if (str2 != null) {
            actionCodeSettings.zzf(str2);
        }
        actionCodeSettings.zzg(1);
        return new zzo(this, str, actionCodeSettings).zzb(this, this.zzl, this.zzn);
    }
}
