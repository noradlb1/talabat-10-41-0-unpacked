package com.google.android.gms.dynamic;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IFragmentWrapper;

@KeepForSdk
public final class SupportFragmentWrapper extends IFragmentWrapper.Stub {
    private final Fragment zza;

    private SupportFragmentWrapper(Fragment fragment) {
        this.zza = fragment;
    }

    @KeepForSdk
    @Nullable
    public static SupportFragmentWrapper wrap(@Nullable Fragment fragment) {
        if (fragment != null) {
            return new SupportFragmentWrapper(fragment);
        }
        return null;
    }

    public final boolean zzA() {
        return this.zza.isVisible();
    }

    public final int zzb() {
        return this.zza.getId();
    }

    public final int zzc() {
        return this.zza.getTargetRequestCode();
    }

    @Nullable
    public final Bundle zzd() {
        return this.zza.getArguments();
    }

    @Nullable
    public final IFragmentWrapper zze() {
        return wrap(this.zza.getParentFragment());
    }

    @Nullable
    public final IFragmentWrapper zzf() {
        return wrap(this.zza.getTargetFragment());
    }

    @NonNull
    public final IObjectWrapper zzg() {
        return ObjectWrapper.wrap(this.zza.getActivity());
    }

    @NonNull
    public final IObjectWrapper zzh() {
        return ObjectWrapper.wrap(this.zza.getResources());
    }

    @NonNull
    public final IObjectWrapper zzi() {
        return ObjectWrapper.wrap(this.zza.getView());
    }

    @Nullable
    public final String zzj() {
        return this.zza.getTag();
    }

    public final void zzk(@NonNull IObjectWrapper iObjectWrapper) {
        View view = (View) ObjectWrapper.unwrap(iObjectWrapper);
        Fragment fragment = this.zza;
        Preconditions.checkNotNull(view);
        fragment.registerForContextMenu(view);
    }

    public final void zzl(boolean z11) {
        this.zza.setHasOptionsMenu(z11);
    }

    public final void zzm(boolean z11) {
        this.zza.setMenuVisibility(z11);
    }

    public final void zzn(boolean z11) {
        this.zza.setRetainInstance(z11);
    }

    public final void zzo(boolean z11) {
        this.zza.setUserVisibleHint(z11);
    }

    public final void zzp(@NonNull Intent intent) {
        this.zza.startActivity(intent);
    }

    public final void zzq(@NonNull Intent intent, int i11) {
        this.zza.startActivityForResult(intent, i11);
    }

    public final void zzr(@NonNull IObjectWrapper iObjectWrapper) {
        View view = (View) ObjectWrapper.unwrap(iObjectWrapper);
        Fragment fragment = this.zza;
        Preconditions.checkNotNull(view);
        fragment.unregisterForContextMenu(view);
    }

    public final boolean zzs() {
        return this.zza.getRetainInstance();
    }

    public final boolean zzt() {
        return this.zza.getUserVisibleHint();
    }

    public final boolean zzu() {
        return this.zza.isAdded();
    }

    public final boolean zzv() {
        return this.zza.isDetached();
    }

    public final boolean zzw() {
        return this.zza.isHidden();
    }

    public final boolean zzx() {
        return this.zza.isInLayout();
    }

    public final boolean zzy() {
        return this.zza.isRemoving();
    }

    public final boolean zzz() {
        return this.zza.isResumed();
    }
}
