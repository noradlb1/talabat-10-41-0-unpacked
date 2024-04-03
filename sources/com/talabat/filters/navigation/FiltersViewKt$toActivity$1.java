package com.talabat.filters.navigation;

import android.content.Context;
import androidx.appcompat.app.AppCompatActivity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.filters.navigation.FiltersViewKt", f = "FiltersView.kt", i = {}, l = {158}, m = "toActivity", n = {}, s = {})
public final class FiltersViewKt$toActivity$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f59581h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f59582i;

    /* renamed from: j  reason: collision with root package name */
    public int f59583j;

    public FiltersViewKt$toActivity$1(Continuation<? super FiltersViewKt$toActivity$1> continuation) {
        super(continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f59582i = obj;
        this.f59583j |= Integer.MIN_VALUE;
        return FiltersViewKt.toActivity((Context) null, (Function2<? super AppCompatActivity, ? super Continuation<? super Unit>, ? extends Object>) null, this);
    }
}
