package com.designsystem.ds_search_field;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class DSSearchFieldKt$DSSearchField$3 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Modifier f32610g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ String f32611h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function1<String, Unit> f32612i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f32613j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f32614k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ String f32615l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ long f32616m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ int f32617n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ int f32618o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ int f32619p;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DSSearchFieldKt$DSSearchField$3(Modifier modifier, String str, Function1<? super String, Unit> function1, Function0<Unit> function0, Function0<Unit> function02, String str2, long j11, int i11, int i12, int i13) {
        super(2);
        this.f32610g = modifier;
        this.f32611h = str;
        this.f32612i = function1;
        this.f32613j = function0;
        this.f32614k = function02;
        this.f32615l = str2;
        this.f32616m = j11;
        this.f32617n = i11;
        this.f32618o = i12;
        this.f32619p = i13;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        DSSearchFieldKt.DSSearchField(this.f32610g, this.f32611h, this.f32612i, this.f32613j, this.f32614k, this.f32615l, this.f32616m, this.f32617n, composer, this.f32618o | 1, this.f32619p);
    }
}
