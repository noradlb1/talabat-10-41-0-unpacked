package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class TabRowDefaults$Divider$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ TabRowDefaults f5786g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Modifier f5787h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ float f5788i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ long f5789j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f5790k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ int f5791l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TabRowDefaults$Divider$1(TabRowDefaults tabRowDefaults, Modifier modifier, float f11, long j11, int i11, int i12) {
        super(2);
        this.f5786g = tabRowDefaults;
        this.f5787h = modifier;
        this.f5788i = f11;
        this.f5789j = j11;
        this.f5790k = i11;
        this.f5791l = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        this.f5786g.m1417Divider9IZ8Weo(this.f5787h, this.f5788i, this.f5789j, composer, this.f5790k | 1, this.f5791l);
    }
}
