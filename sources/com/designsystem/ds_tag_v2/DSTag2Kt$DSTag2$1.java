package com.designsystem.ds_tag_v2;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import net.bytebuddy.jar.asm.Opcodes;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class DSTag2Kt$DSTag2$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Modifier f33094g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ String f33095h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ DSTagPriority f33096i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ DSTagSize f33097j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ DSTagColor f33098k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Integer f33099l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ int f33100m;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DSTag2Kt$DSTag2$1(Modifier modifier, String str, DSTagPriority dSTagPriority, DSTagSize dSTagSize, DSTagColor dSTagColor, Integer num, int i11) {
        super(2);
        this.f33094g = modifier;
        this.f33095h = str;
        this.f33096i = dSTagPriority;
        this.f33097j = dSTagSize;
        this.f33098k = dSTagColor;
        this.f33099l = num;
        this.f33100m = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    @Composable
    public final void invoke(@Nullable Composer composer, int i11) {
        if (((i11 & 11) ^ 2) != 0 || !composer.getSkipping()) {
            Modifier modifier = this.f33094g;
            String str = this.f33095h;
            DSTagPriority dSTagPriority = this.f33096i;
            DSTagSize dSTagSize = this.f33097j;
            DSTagColor dSTagColor = this.f33098k;
            Integer num = this.f33099l;
            int i12 = this.f33100m;
            DSTag2ComposablesKt.DSTag2Surface(modifier, str, dSTagPriority, dSTagSize, dSTagColor, num, composer, (i12 & 14) | (i12 & 112) | (i12 & 896) | (i12 & 7168) | (57344 & i12) | (i12 & Opcodes.ASM7), 0);
            return;
        }
        composer.skipToGroupEnd();
    }
}
