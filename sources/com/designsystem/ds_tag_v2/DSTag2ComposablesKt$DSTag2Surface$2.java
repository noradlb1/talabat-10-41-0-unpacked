package com.designsystem.ds_tag_v2;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material.IconKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.TestTagKt;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextOverflow;
import com.designsystem.ds_text.DSTextKt;
import com.designsystem.ds_theme.DSTheme;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class DSTag2ComposablesKt$DSTag2Surface$2 extends Lambda implements Function3<RowScope, Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Integer f33080g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ DSTagSize f33081h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ int f33082i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ DSTagColor f33083j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ DSTagPriority f33084k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ String f33085l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DSTag2ComposablesKt$DSTag2Surface$2(Integer num, DSTagSize dSTagSize, int i11, DSTagColor dSTagColor, DSTagPriority dSTagPriority, String str) {
        super(3);
        this.f33080g = num;
        this.f33081h = dSTagSize;
        this.f33082i = i11;
        this.f33083j = dSTagColor;
        this.f33084k = dSTagPriority;
        this.f33085l = str;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((RowScope) obj, (Composer) obj2, ((Number) obj3).intValue());
        return Unit.INSTANCE;
    }

    @Composable
    public final void invoke(@NotNull RowScope rowScope, @Nullable Composer composer, int i11) {
        Composer composer2 = composer;
        Intrinsics.checkNotNullParameter(rowScope, "$this$DSTag2Background");
        if (((i11 & 81) ^ 16) != 0 || !composer.getSkipping()) {
            Integer num = this.f33080g;
            if (num == null) {
                composer2.startReplaceableGroup(-942920152);
            } else {
                composer2.startReplaceableGroup(108130553);
                Integer num2 = this.f33080g;
                int i12 = this.f33082i;
                DSTagColor dSTagColor = this.f33083j;
                DSTagPriority dSTagPriority = this.f33084k;
                num.intValue();
                Modifier.Companion companion = Modifier.Companion;
                DSTheme dSTheme = DSTheme.INSTANCE;
                IconKt.m1278Iconww6aTOc(PainterResources_androidKt.painterResource(num2.intValue(), composer2, (i12 >> 15) & 14), (String) null, TestTagKt.testTag(PaddingKt.m490paddingqDBjuR0$default(SizeKt.m558size3ABfNKs(companion, dSTheme.getDimens(composer2, 0).m8842getDsSD9Ej5fM()), 0.0f, 0.0f, dSTheme.getDimens(composer2, 0).m8848getDsXxxsD9Ej5fM(), 0.0f, 11, (Object) null), DSTag2ComposablesKt.Tag2IconTestTag), DSTag2ComposablesKt.getTextOrIconColor(dSTagColor, dSTagPriority, composer2, ((i12 >> 12) & 14) | ((i12 >> 3) & 112)), composer, 56, 0);
            }
            composer.endReplaceableGroup();
            Modifier testTag = TestTagKt.testTag(Modifier.Companion, DSTag2ComposablesKt.Tag2LabelTestTag);
            TextStyle access$getTextStyle = DSTag2ComposablesKt.getTextStyle(this.f33081h, composer2, (this.f33082i >> 9) & 14);
            DSTagColor dSTagColor2 = this.f33083j;
            DSTagPriority dSTagPriority2 = this.f33084k;
            int i13 = this.f33082i;
            DSTextKt.m8635DSTextqBUjsXY(this.f33085l, testTag, 0.0f, DSTag2ComposablesKt.getTextOrIconColor(dSTagColor2, dSTagPriority2, composer2, ((i13 >> 3) & 112) | ((i13 >> 12) & 14)), 0, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0, (TextDecoration) null, (TextAlign) null, 0, TextOverflow.Companion.m5403getEllipsisgIe3tQ8(), false, 1, (Function1<? super TextLayoutResult, Unit>) null, access$getTextStyle, composer, ((this.f33082i >> 3) & 14) | 48, 25088, 45044);
            return;
        }
        composer.skipToGroupEnd();
    }
}
