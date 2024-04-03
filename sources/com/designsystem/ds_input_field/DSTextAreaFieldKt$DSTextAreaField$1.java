package com.designsystem.ds_input_field;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.KeyboardType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class DSTextAreaFieldKt$DSTextAreaField$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Modifier f31475g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ String f31476h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ String f31477i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ String f31478j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Function1<String, Unit> f31479k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Function1<String, Unit> f31480l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ boolean f31481m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ DSInputFieldState f31482n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ int f31483o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ int f31484p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ int f31485q;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ int f31486r;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DSTextAreaFieldKt$DSTextAreaField$1(Modifier modifier, String str, String str2, String str3, Function1<? super String, Unit> function1, Function1<? super String, Unit> function12, boolean z11, DSInputFieldState dSInputFieldState, int i11, int i12, int i13, int i14) {
        super(2);
        this.f31475g = modifier;
        this.f31476h = str;
        this.f31477i = str2;
        this.f31478j = str3;
        this.f31479k = function1;
        this.f31480l = function12;
        this.f31481m = z11;
        this.f31482n = dSInputFieldState;
        this.f31483o = i11;
        this.f31484p = i12;
        this.f31485q = i13;
        this.f31486r = i14;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    @Composable
    public final void invoke(@Nullable Composer composer, int i11) {
        if (((i11 & 11) ^ 2) != 0 || !composer.getSkipping()) {
            Modifier modifier = this.f31475g;
            String str = this.f31476h;
            String str2 = this.f31477i;
            String str3 = this.f31478j;
            Function1<String, Unit> function1 = this.f31479k;
            Function1<String, Unit> function12 = this.f31480l;
            boolean z11 = this.f31481m;
            DSInputFieldState dSInputFieldState = this.f31482n;
            Integer valueOf = Integer.valueOf(this.f31483o);
            KeyboardType r11 = KeyboardType.m5213boximpl(this.f31484p);
            ImeAction r12 = ImeAction.m5180boximpl(this.f31485q);
            int i12 = this.f31486r;
            TextAreaComposablesKt.m8469TextAreaInputFieldJIo6yoo(modifier, str, str2, str3, function1, function12, z11, dSInputFieldState, valueOf, r11, r12, composer, (i12 & 14) | 1073741824 | (i12 & 112) | (i12 & 896) | (i12 & 7168) | (57344 & i12) | (458752 & i12) | (3670016 & i12) | (29360128 & i12) | (i12 & 234881024), 8, 0);
            return;
        }
        composer.skipToGroupEnd();
    }
}
