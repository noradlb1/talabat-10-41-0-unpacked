package com.designsystem.ds_input_field;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.input.ImeAction;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class DSPasswordFieldKt$DSPasswordField$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Modifier f31419g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ String f31420h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ String f31421i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ String f31422j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Function1<String, Unit> f31423k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Function1<String, Unit> f31424l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ DSInputFieldState f31425m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ int f31426n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ int f31427o;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DSPasswordFieldKt$DSPasswordField$1(Modifier modifier, String str, String str2, String str3, Function1<? super String, Unit> function1, Function1<? super String, Unit> function12, DSInputFieldState dSInputFieldState, int i11, int i12) {
        super(2);
        this.f31419g = modifier;
        this.f31420h = str;
        this.f31421i = str2;
        this.f31422j = str3;
        this.f31423k = function1;
        this.f31424l = function12;
        this.f31425m = dSInputFieldState;
        this.f31426n = i11;
        this.f31427o = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    @Composable
    public final void invoke(@Nullable Composer composer, int i11) {
        if (((i11 & 11) ^ 2) != 0 || !composer.getSkipping()) {
            Modifier modifier = this.f31419g;
            String str = this.f31420h;
            String str2 = this.f31421i;
            String str3 = this.f31422j;
            Function1<String, Unit> function1 = this.f31423k;
            Function1<String, Unit> function12 = this.f31424l;
            DSInputFieldState dSInputFieldState = this.f31425m;
            ImeAction r72 = ImeAction.m5180boximpl(this.f31426n);
            int i12 = this.f31427o;
            PasswordFieldComposablesKt.m8443PasswordFieldInputFieldtulg0WA(modifier, str, str2, str3, function1, function12, dSInputFieldState, r72, composer, (i12 & 14) | 16777216 | (i12 & 112) | (i12 & 896) | (i12 & 7168) | (57344 & i12) | (458752 & i12) | (i12 & 3670016), 0);
            return;
        }
        composer.skipToGroupEnd();
    }
}
