package com.google.android.libraries.places.widget;

import android.view.MotionEvent;
import android.view.View;
import com.google.android.libraries.places.widget.internal.ui.AutocompleteImplFragment;

public final /* synthetic */ class zzb implements View.OnTouchListener {
    public final /* synthetic */ AutocompleteActivity zza;
    public final /* synthetic */ AutocompleteImplFragment zzb;
    public final /* synthetic */ View zzc;

    public /* synthetic */ zzb(AutocompleteActivity autocompleteActivity, AutocompleteImplFragment autocompleteImplFragment, View view) {
        this.zza = autocompleteActivity;
        this.zzb = autocompleteImplFragment;
        this.zzc = view;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        return this.zza.zzb(this.zzb, this.zzc, view, motionEvent);
    }
}
