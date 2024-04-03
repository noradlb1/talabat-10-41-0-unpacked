package com.designsystem.ds_input_field;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.KeyboardType;
import androidx.compose.ui.text.input.VisualTransformation;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import net.bytebuddy.jar.asm.Opcodes;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class DSTextFieldKt$DSTextField$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Modifier f31504g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ String f31505h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ String f31506i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ String f31507j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Function1<String, Unit> f31508k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Function1<String, Unit> f31509l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ boolean f31510m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ DSInputFieldState f31511n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ Integer f31512o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ Integer f31513p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f31514q;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ boolean f31515r;

    /* renamed from: s  reason: collision with root package name */
    public final /* synthetic */ int f31516s;

    /* renamed from: t  reason: collision with root package name */
    public final /* synthetic */ int f31517t;

    /* renamed from: u  reason: collision with root package name */
    public final /* synthetic */ VisualTransformation f31518u;

    /* renamed from: v  reason: collision with root package name */
    public final /* synthetic */ Integer f31519v;

    /* renamed from: w  reason: collision with root package name */
    public final /* synthetic */ int f31520w;

    /* renamed from: x  reason: collision with root package name */
    public final /* synthetic */ int f31521x;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DSTextFieldKt$DSTextField$1(Modifier modifier, String str, String str2, String str3, Function1<? super String, Unit> function1, Function1<? super String, Unit> function12, boolean z11, DSInputFieldState dSInputFieldState, Integer num, Integer num2, Function0<Unit> function0, boolean z12, int i11, int i12, VisualTransformation visualTransformation, Integer num3, int i13, int i14) {
        super(2);
        this.f31504g = modifier;
        this.f31505h = str;
        this.f31506i = str2;
        this.f31507j = str3;
        this.f31508k = function1;
        this.f31509l = function12;
        this.f31510m = z11;
        this.f31511n = dSInputFieldState;
        this.f31512o = num;
        this.f31513p = num2;
        this.f31514q = function0;
        this.f31515r = z12;
        this.f31516s = i11;
        this.f31517t = i12;
        this.f31518u = visualTransformation;
        this.f31519v = num3;
        this.f31520w = i13;
        this.f31521x = i14;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    @Composable
    public final void invoke(@Nullable Composer composer, int i11) {
        if (((i11 & 11) ^ 2) != 0 || !composer.getSkipping()) {
            Modifier modifier = this.f31504g;
            String str = this.f31505h;
            String str2 = this.f31506i;
            String str3 = this.f31507j;
            Function1<String, Unit> function1 = this.f31508k;
            Function1<String, Unit> function12 = this.f31509l;
            boolean z11 = this.f31510m;
            DSInputFieldState dSInputFieldState = this.f31511n;
            Integer num = this.f31512o;
            Integer num2 = this.f31513p;
            Function0<Unit> function0 = this.f31514q;
            boolean z12 = this.f31515r;
            KeyboardType r14 = KeyboardType.m5213boximpl(this.f31516s);
            ImeAction r15 = ImeAction.m5180boximpl(this.f31517t);
            VisualTransformation visualTransformation = this.f31518u;
            Integer num3 = this.f31519v;
            int i12 = this.f31520w;
            int i13 = (i12 & 14) | (i12 & 112) | (i12 & 896) | (i12 & 7168) | (i12 & 57344) | (i12 & Opcodes.ASM7) | (i12 & 3670016) | (i12 & 29360128) | (i12 & 234881024) | (i12 & 1879048192);
            int i14 = this.f31521x;
            Modifier modifier2 = modifier;
            String str4 = str;
            TextFieldComposablesKt.m8471TextFieldInputFieldqQH3efY(modifier2, str4, str2, str3, function1, function12, z11, dSInputFieldState, num, num2, function0, z12, r14, r15, visualTransformation, num3, composer, i13, (i14 & 14) | 4608 | (i14 & 112) | (57344 & i14) | (i14 & Opcodes.ASM7), 0);
            return;
        }
        composer.skipToGroupEnd();
    }
}
