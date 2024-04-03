package com.designsystem.ds_input_field;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class TextFieldComposablesKt$TextFieldInputField$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Integer f31911g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ OuterState f31912h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ boolean f31913i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f31914j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ boolean f31915k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ int f31916l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ int f31917m;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TextFieldComposablesKt$TextFieldInputField$2(Integer num, OuterState outerState, boolean z11, Function0<Unit> function0, boolean z12, int i11, int i12) {
        super(2);
        this.f31911g = num;
        this.f31912h = outerState;
        this.f31913i = z11;
        this.f31914j = function0;
        this.f31915k = z12;
        this.f31916l = i11;
        this.f31917m = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    @Composable
    public final void invoke(@Nullable Composer composer, int i11) {
        if (((i11 & 11) ^ 2) != 0 || !composer.getSkipping()) {
            Integer num = this.f31911g;
            OuterState outerState = this.f31912h;
            boolean z11 = this.f31913i;
            Function0<Unit> function0 = this.f31914j;
            boolean z12 = this.f31915k;
            int i12 = this.f31916l;
            int i13 = this.f31917m;
            InputFieldCommonComposablesKt.InputFieldTrailingIconContainer(num, outerState, z11, function0, z12, composer, ((i12 >> 12) & 896) | ((i12 >> 27) & 14) | ((i12 >> 18) & 112) | ((i13 << 9) & 7168) | ((i13 << 9) & 57344), 0);
            return;
        }
        composer.skipToGroupEnd();
    }
}
