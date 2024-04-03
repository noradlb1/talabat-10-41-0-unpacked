package com.designsystem.ds_input_field;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.input.ImeAction;
import androidx.fragment.app.FragmentManager;
import com.designsystem.ds_input_field.country.DSCountryModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class DSPhoneNumberFieldKt$DSPhoneNumberField$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Modifier f31441g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ String f31442h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ String f31443i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function2<DSCountryModel, String, Unit> f31444j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Function2<DSCountryModel, String, Unit> f31445k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ String f31446l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ boolean f31447m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ DSInputFieldState f31448n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ int f31449o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ FragmentManager f31450p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ String f31451q;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ String f31452r;

    /* renamed from: s  reason: collision with root package name */
    public final /* synthetic */ String f31453s;

    /* renamed from: t  reason: collision with root package name */
    public final /* synthetic */ int f31454t;

    /* renamed from: u  reason: collision with root package name */
    public final /* synthetic */ int f31455u;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DSPhoneNumberFieldKt$DSPhoneNumberField$1(Modifier modifier, String str, String str2, Function2<? super DSCountryModel, ? super String, Unit> function2, Function2<? super DSCountryModel, ? super String, Unit> function22, String str3, boolean z11, DSInputFieldState dSInputFieldState, int i11, FragmentManager fragmentManager, String str4, String str5, String str6, int i12, int i13) {
        super(2);
        this.f31441g = modifier;
        this.f31442h = str;
        this.f31443i = str2;
        this.f31444j = function2;
        this.f31445k = function22;
        this.f31446l = str3;
        this.f31447m = z11;
        this.f31448n = dSInputFieldState;
        this.f31449o = i11;
        this.f31450p = fragmentManager;
        this.f31451q = str4;
        this.f31452r = str5;
        this.f31453s = str6;
        this.f31454t = i12;
        this.f31455u = i13;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    @Composable
    public final void invoke(@Nullable Composer composer, int i11) {
        if (((i11 & 11) ^ 2) != 0 || !composer.getSkipping()) {
            Modifier modifier = this.f31441g;
            String str = this.f31442h;
            String str2 = this.f31443i;
            Function2<DSCountryModel, String, Unit> function2 = this.f31444j;
            Function2<DSCountryModel, String, Unit> function22 = this.f31445k;
            String str3 = this.f31446l;
            boolean z11 = this.f31447m;
            DSInputFieldState dSInputFieldState = this.f31448n;
            ImeAction r102 = ImeAction.m5180boximpl(this.f31449o);
            FragmentManager fragmentManager = this.f31450p;
            String str4 = this.f31451q;
            String str5 = this.f31452r;
            String str6 = this.f31453s;
            int i12 = this.f31454t;
            Modifier modifier2 = modifier;
            int i13 = (i12 & 896) | (i12 & 14) | 1207959552 | (i12 & 112) | (i12 & 7168) | (57344 & i12) | (458752 & i12) | (3670016 & i12) | (i12 & 29360128);
            int i14 = this.f31455u;
            Modifier modifier3 = modifier2;
            PhoneFieldComposablesKt.m8448PhoneNumberInputField4mkn5s(modifier3, str, str2, function2, function22, str3, z11, dSInputFieldState, r102, fragmentManager, str4, str5, str6, composer, i13, (i14 & 14) | (i14 & 112) | (i14 & 896), 0);
            return;
        }
        composer.skipToGroupEnd();
    }
}
