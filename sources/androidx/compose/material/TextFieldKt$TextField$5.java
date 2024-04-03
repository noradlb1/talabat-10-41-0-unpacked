package androidx.compose.material;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.VisualTransformation;
import com.huawei.wisesecurity.kfs.constant.KfsConstant;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import net.bytebuddy.jar.asm.Opcodes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class TextFieldKt$TextField$5 extends Lambda implements Function3<Function2<? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ TextFieldValue f6043g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ boolean f6044h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ boolean f6045i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ VisualTransformation f6046j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ MutableInteractionSource f6047k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ boolean f6048l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f6049m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f6050n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f6051o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f6052p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ TextFieldColors f6053q;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ int f6054r;

    /* renamed from: s  reason: collision with root package name */
    public final /* synthetic */ int f6055s;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TextFieldKt$TextField$5(TextFieldValue textFieldValue, boolean z11, boolean z12, VisualTransformation visualTransformation, MutableInteractionSource mutableInteractionSource, boolean z13, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, TextFieldColors textFieldColors, int i11, int i12) {
        super(3);
        this.f6043g = textFieldValue;
        this.f6044h = z11;
        this.f6045i = z12;
        this.f6046j = visualTransformation;
        this.f6047k = mutableInteractionSource;
        this.f6048l = z13;
        this.f6049m = function2;
        this.f6050n = function22;
        this.f6051o = function23;
        this.f6052p = function24;
        this.f6053q = textFieldColors;
        this.f6054r = i11;
        this.f6055s = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((Function2<? super Composer, ? super Integer, Unit>) (Function2) obj, (Composer) obj2, ((Number) obj3).intValue());
        return Unit.INSTANCE;
    }

    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    @Composable
    public final void invoke(@NotNull Function2<? super Composer, ? super Integer, Unit> function2, @Nullable Composer composer, int i11) {
        int i12;
        Function2<? super Composer, ? super Integer, Unit> function22 = function2;
        Intrinsics.checkNotNullParameter(function22, "innerTextField");
        Composer composer2 = composer;
        if ((i11 & 14) == 0) {
            i12 = i11 | (composer2.changed((Object) function22) ? 4 : 2);
        } else {
            i12 = i11;
        }
        if ((i12 & 91) != 18 || !composer.getSkipping()) {
            TextFieldDefaults textFieldDefaults = TextFieldDefaults.INSTANCE;
            String text = this.f6043g.getText();
            boolean z11 = this.f6044h;
            boolean z12 = this.f6045i;
            VisualTransformation visualTransformation = this.f6046j;
            MutableInteractionSource mutableInteractionSource = this.f6047k;
            boolean z13 = this.f6048l;
            Function2<Composer, Integer, Unit> function23 = this.f6049m;
            Function2<Composer, Integer, Unit> function24 = this.f6050n;
            Function2<Composer, Integer, Unit> function25 = this.f6051o;
            Function2<Composer, Integer, Unit> function26 = this.f6052p;
            TextFieldColors textFieldColors = this.f6053q;
            int i13 = this.f6054r;
            int i14 = this.f6055s;
            textFieldDefaults.TextFieldDecorationBox(text, function2, z11, z12, visualTransformation, mutableInteractionSource, z13, function23, function24, function25, function26, textFieldColors, (PaddingValues) null, composer, ((i14 >> 3) & 7168) | ((i12 << 3) & 112) | ((i13 >> 3) & 896) | ((i14 << 9) & 57344) | ((i14 >> 3) & Opcodes.ASM7) | ((i14 << 18) & 3670016) | ((i13 << 3) & 29360128) | ((i13 << 3) & 234881024) | ((i13 << 3) & 1879048192), ((i13 >> 27) & 14) | KfsConstant.KFS_RSA_KEY_LEN_3072 | ((i14 >> 21) & 112), 4096);
            return;
        }
        composer.skipToGroupEnd();
    }
}
