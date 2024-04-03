package com.afollestad.materialdialogs.checkbox;

import android.widget.CompoundButton;
import com.afollestad.materialdialogs.MaterialDialog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\t\u001a\u00020\u00052\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Landroid/widget/CompoundButton;", "kotlin.jvm.PlatformType", "<anonymous parameter 0>", "L;", "checked", "", "onCheckedChanged", "(Landroid/widget/CompoundButton;L;)V", "kotlin/Boolean", "<anonymous>"}, k = 3, mv = {1, 4, 0})
public final class DialogCheckboxExtKt$checkBoxPrompt$$inlined$run$lambda$1 implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MaterialDialog f40391b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f40392c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f40393d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ boolean f40394e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ Function1 f40395f;

    public DialogCheckboxExtKt$checkBoxPrompt$$inlined$run$lambda$1(MaterialDialog materialDialog, String str, int i11, boolean z11, Function1 function1) {
        this.f40391b = materialDialog;
        this.f40392c = str;
        this.f40393d = i11;
        this.f40394e = z11;
        this.f40395f = function1;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z11) {
        Function1 function1 = this.f40395f;
        if (function1 != null) {
            Unit unit = (Unit) function1.invoke(Boolean.valueOf(z11));
        }
    }
}
