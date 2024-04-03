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
public final class DSSwitchListItemKt$DSSwitchListItem$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ String f32121g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ boolean f32122h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function1<Boolean, Unit> f32123i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Modifier f32124j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ String f32125k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ String f32126l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ Integer f32127m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ Integer f32128n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ Integer f32129o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ float f32130p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ boolean f32131q;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ String f32132r;

    /* renamed from: s  reason: collision with root package name */
    public final /* synthetic */ String f32133s;

    /* renamed from: t  reason: collision with root package name */
    public final /* synthetic */ boolean f32134t;

    /* renamed from: u  reason: collision with root package name */
    public final /* synthetic */ int f32135u;

    /* renamed from: v  reason: collision with root package name */
    public final /* synthetic */ int f32136v;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DSSwitchListItemKt$DSSwitchListItem$1(String str, boolean z11, Function1<? super Boolean, Unit> function1, Modifier modifier, String str2, String str3, Integer num, Integer num2, Integer num3, float f11, boolean z12, String str4, String str5, boolean z13, int i11, int i12) {
        super(2);
        this.f32121g = str;
        this.f32122h = z11;
        this.f32123i = function1;
        this.f32124j = modifier;
        this.f32125k = str2;
        this.f32126l = str3;
        this.f32127m = num;
        this.f32128n = num2;
        this.f32129o = num3;
        this.f32130p = f11;
        this.f32131q = z12;
        this.f32132r = str4;
        this.f32133s = str5;
        this.f32134t = z13;
        this.f32135u = i11;
        this.f32136v = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    @Composable
    public final void invoke(@Nullable Composer composer, int i11) {
        if (((i11 & 11) ^ 2) != 0 || !composer.getSkipping()) {
            String str = this.f32121g;
            boolean z11 = this.f32122h;
            Function1<Boolean, Unit> function1 = this.f32123i;
            Modifier modifier = this.f32124j;
            String str2 = this.f32125k;
            String str3 = this.f32126l;
            Integer num = this.f32127m;
            Integer num2 = this.f32128n;
            Integer num3 = this.f32129o;
            float f11 = this.f32130p;
            final boolean z12 = this.f32131q;
            boolean z13 = z12;
            String str4 = this.f32132r;
            String str5 = this.f32133s;
            boolean z14 = this.f32134t;
            boolean z15 = z11;
            final int i12 = this.f32136v;
            Function1<Boolean, Unit> function12 = function1;
            ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composer, -819893684, true, new Function3<Boolean, Composer, Integer, Unit>() {
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
                        SelectableListItemComposablesKt.ListItemSwitch(z11, z12, composer, (i11 & 14) | ((i12 << 3) & 112));
                    } else {
                        composer.skipToGroupEnd();
                    }
                }
            });
            int i13 = this.f32135u;
            int i14 = (i13 & 14) | (i13 & 112) | (i13 & 896) | (i13 & 7168) | (57344 & i13) | (458752 & i13) | (3670016 & i13) | (29360128 & i13) | (234881024 & i13) | (i13 & 1879048192);
            int i15 = this.f32136v;
            String str6 = str;
            boolean z16 = z15;
            Function1<Boolean, Unit> function13 = function12;
            SelectableListItemComposablesKt.m8492SelectionListItem_zuBKE(str6, z16, function13, modifier, str2, str3, num, num2, num3, f11, z13, str4, str5, z14, composableLambda, composer, i14, (i15 & 14) | CpioConstants.C_ISBLK | (i15 & 112) | (i15 & 896) | (i15 & 7168), 0);
            return;
        }
        composer.skipToGroupEnd();
    }
}
