package com.designsystem.ds_list_item_v2;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import com.designsystem.ds_list_item_v2.composables.SelectableListItemComposablesKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import org.apache.commons.compress.archivers.cpio.CpioConstants;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class DSSelectionListItemKt$DSSelectionListItem$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ String f32082g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ boolean f32083h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function1<Boolean, Unit> f32084i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Modifier f32085j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ String f32086k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ String f32087l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ Integer f32088m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ Integer f32089n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ Integer f32090o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ float f32091p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ boolean f32092q;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ String f32093r;

    /* renamed from: s  reason: collision with root package name */
    public final /* synthetic */ String f32094s;

    /* renamed from: t  reason: collision with root package name */
    public final /* synthetic */ boolean f32095t;

    /* renamed from: u  reason: collision with root package name */
    public final /* synthetic */ int f32096u;

    /* renamed from: v  reason: collision with root package name */
    public final /* synthetic */ int f32097v;

    /* renamed from: w  reason: collision with root package name */
    public final /* synthetic */ Function3<Boolean, Composer, Integer, Unit> f32098w;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DSSelectionListItemKt$DSSelectionListItem$1(String str, boolean z11, Function1<? super Boolean, Unit> function1, Modifier modifier, String str2, String str3, Integer num, Integer num2, Integer num3, float f11, boolean z12, String str4, String str5, boolean z13, int i11, int i12, Function3<? super Boolean, ? super Composer, ? super Integer, Unit> function3) {
        super(2);
        this.f32082g = str;
        this.f32083h = z11;
        this.f32084i = function1;
        this.f32085j = modifier;
        this.f32086k = str2;
        this.f32087l = str3;
        this.f32088m = num;
        this.f32089n = num2;
        this.f32090o = num3;
        this.f32091p = f11;
        this.f32092q = z12;
        this.f32093r = str4;
        this.f32094s = str5;
        this.f32095t = z13;
        this.f32096u = i11;
        this.f32097v = i12;
        this.f32098w = function3;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    @Composable
    public final void invoke(@Nullable Composer composer, int i11) {
        if (((i11 & 11) ^ 2) != 0 || !composer.getSkipping()) {
            String str = this.f32082g;
            boolean z11 = this.f32083h;
            Function1<Boolean, Unit> function1 = this.f32084i;
            Modifier modifier = this.f32085j;
            String str2 = this.f32086k;
            String str3 = this.f32087l;
            Integer num = this.f32088m;
            Integer num2 = this.f32089n;
            Integer num3 = this.f32090o;
            float f11 = this.f32091p;
            boolean z12 = this.f32092q;
            String str4 = this.f32093r;
            String str5 = this.f32094s;
            boolean z13 = this.f32095t;
            String str6 = str;
            final Function3<Boolean, Composer, Integer, Unit> function3 = this.f32098w;
            boolean z14 = z11;
            final int i12 = this.f32097v;
            Function1<Boolean, Unit> function12 = function1;
            ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composer, -819894075, true, new Function3<Boolean, Composer, Integer, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                    invoke(((Boolean) obj).booleanValue(), (Composer) obj2, ((Number) obj3).intValue());
                    return Unit.INSTANCE;
                }

                @Composable
                public final void invoke(boolean z11, @Nullable Composer composer, int i11) {
                    if ((i11 & 14) == 0) {
                        i11 |= composer.changed(z11) ? 4 : 2;
                    }
                    if (((i11 & 91) ^ 18) != 0 || !composer.getSkipping()) {
                        Function3<Boolean, Composer, Integer, Unit> function3 = function3;
                        if (function3 == null) {
                            composer.startReplaceableGroup(-397851603);
                        } else {
                            composer.startReplaceableGroup(-1398307244);
                            function3.invoke(Boolean.valueOf(z11), composer, Integer.valueOf((i11 & 14) | ((i12 >> 9) & 112)));
                        }
                        composer.endReplaceableGroup();
                        return;
                    }
                    composer.skipToGroupEnd();
                }
            });
            int i13 = this.f32096u;
            int i14 = (i13 & 14) | (i13 & 112) | (i13 & 896) | (i13 & 7168) | (57344 & i13) | (458752 & i13) | (3670016 & i13) | (29360128 & i13) | (234881024 & i13) | (i13 & 1879048192);
            int i15 = this.f32097v;
            String str7 = str6;
            boolean z15 = z14;
            Function1<Boolean, Unit> function13 = function12;
            SelectableListItemComposablesKt.m8492SelectionListItem_zuBKE(str7, z15, function13, modifier, str2, str3, num, num2, num3, f11, z12, str4, str5, z13, composableLambda, composer, i14, (i15 & 14) | CpioConstants.C_ISBLK | (i15 & 112) | (i15 & 896) | (i15 & 7168), 0);
            return;
        }
        composer.skipToGroupEnd();
    }
}
