package androidx.compose.material;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.Stable;
import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b1\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001Bp\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0010ø\u0001\u0000¢\u0006\u0002\u0010\u0011J\u0001\u0010>\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u0010ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b?\u0010@J\b\u0010A\u001a\u00020BH\u0016R4\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00038F@@X\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R4\u0010\t\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00038F@@X\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\b\u001b\u0010\u0018\u001a\u0004\b\u0019\u0010\u0014\"\u0004\b\u001a\u0010\u0016R+\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00108F@@X\u0002¢\u0006\u0012\n\u0004\b\u001f\u0010\u0018\u001a\u0004\b\u000f\u0010\u001c\"\u0004\b\u001d\u0010\u001eR4\u0010\f\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00038F@@X\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\b\"\u0010\u0018\u001a\u0004\b \u0010\u0014\"\u0004\b!\u0010\u0016R4\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00038F@@X\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\b%\u0010\u0018\u001a\u0004\b#\u0010\u0014\"\u0004\b$\u0010\u0016R4\u0010\n\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00038F@@X\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\b(\u0010\u0018\u001a\u0004\b&\u0010\u0014\"\u0004\b'\u0010\u0016R4\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00038F@@X\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\b+\u0010\u0018\u001a\u0004\b)\u0010\u0014\"\u0004\b*\u0010\u0016R4\u0010\r\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00038F@@X\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\b.\u0010\u0018\u001a\u0004\b,\u0010\u0014\"\u0004\b-\u0010\u0016R4\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00038F@@X\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\b1\u0010\u0018\u001a\u0004\b/\u0010\u0014\"\u0004\b0\u0010\u0016R4\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00038F@@X\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\b4\u0010\u0018\u001a\u0004\b2\u0010\u0014\"\u0004\b3\u0010\u0016R4\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00038F@@X\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\b7\u0010\u0018\u001a\u0004\b5\u0010\u0014\"\u0004\b6\u0010\u0016R4\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00038F@@X\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\b:\u0010\u0018\u001a\u0004\b8\u0010\u0014\"\u0004\b9\u0010\u0016R4\u0010\b\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00038F@@X\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\b=\u0010\u0018\u001a\u0004\b;\u0010\u0014\"\u0004\b<\u0010\u0016\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006C"}, d2 = {"Landroidx/compose/material/Colors;", "", "primary", "Landroidx/compose/ui/graphics/Color;", "primaryVariant", "secondary", "secondaryVariant", "background", "surface", "error", "onPrimary", "onSecondary", "onBackground", "onSurface", "onError", "isLight", "", "(JJJJJJJJJJJJZLkotlin/jvm/internal/DefaultConstructorMarker;)V", "<set-?>", "getBackground-0d7_KjU", "()J", "setBackground-8_81llA$material_release", "(J)V", "background$delegate", "Landroidx/compose/runtime/MutableState;", "getError-0d7_KjU", "setError-8_81llA$material_release", "error$delegate", "()Z", "setLight$material_release", "(Z)V", "isLight$delegate", "getOnBackground-0d7_KjU", "setOnBackground-8_81llA$material_release", "onBackground$delegate", "getOnError-0d7_KjU", "setOnError-8_81llA$material_release", "onError$delegate", "getOnPrimary-0d7_KjU", "setOnPrimary-8_81llA$material_release", "onPrimary$delegate", "getOnSecondary-0d7_KjU", "setOnSecondary-8_81llA$material_release", "onSecondary$delegate", "getOnSurface-0d7_KjU", "setOnSurface-8_81llA$material_release", "onSurface$delegate", "getPrimary-0d7_KjU", "setPrimary-8_81llA$material_release", "primary$delegate", "getPrimaryVariant-0d7_KjU", "setPrimaryVariant-8_81llA$material_release", "primaryVariant$delegate", "getSecondary-0d7_KjU", "setSecondary-8_81llA$material_release", "secondary$delegate", "getSecondaryVariant-0d7_KjU", "setSecondaryVariant-8_81llA$material_release", "secondaryVariant$delegate", "getSurface-0d7_KjU", "setSurface-8_81llA$material_release", "surface$delegate", "copy", "copy-pvPzIIM", "(JJJJJJJJJJJJZ)Landroidx/compose/material/Colors;", "toString", "", "material_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Stable
public final class Colors {
    @NotNull
    private final MutableState background$delegate;
    @NotNull
    private final MutableState error$delegate;
    @NotNull
    private final MutableState isLight$delegate;
    @NotNull
    private final MutableState onBackground$delegate;
    @NotNull
    private final MutableState onError$delegate;
    @NotNull
    private final MutableState onPrimary$delegate;
    @NotNull
    private final MutableState onSecondary$delegate;
    @NotNull
    private final MutableState onSurface$delegate;
    @NotNull
    private final MutableState primary$delegate;
    @NotNull
    private final MutableState primaryVariant$delegate;
    @NotNull
    private final MutableState secondary$delegate;
    @NotNull
    private final MutableState secondaryVariant$delegate;
    @NotNull
    private final MutableState surface$delegate;

    private Colors(long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j21, long j22, long j23, boolean z11) {
        this.primary$delegate = SnapshotStateKt.mutableStateOf(Color.m2909boximpl(j11), SnapshotStateKt.structuralEqualityPolicy());
        this.primaryVariant$delegate = SnapshotStateKt.mutableStateOf(Color.m2909boximpl(j12), SnapshotStateKt.structuralEqualityPolicy());
        this.secondary$delegate = SnapshotStateKt.mutableStateOf(Color.m2909boximpl(j13), SnapshotStateKt.structuralEqualityPolicy());
        this.secondaryVariant$delegate = SnapshotStateKt.mutableStateOf(Color.m2909boximpl(j14), SnapshotStateKt.structuralEqualityPolicy());
        this.background$delegate = SnapshotStateKt.mutableStateOf(Color.m2909boximpl(j15), SnapshotStateKt.structuralEqualityPolicy());
        this.surface$delegate = SnapshotStateKt.mutableStateOf(Color.m2909boximpl(j16), SnapshotStateKt.structuralEqualityPolicy());
        this.error$delegate = SnapshotStateKt.mutableStateOf(Color.m2909boximpl(j17), SnapshotStateKt.structuralEqualityPolicy());
        this.onPrimary$delegate = SnapshotStateKt.mutableStateOf(Color.m2909boximpl(j18), SnapshotStateKt.structuralEqualityPolicy());
        this.onSecondary$delegate = SnapshotStateKt.mutableStateOf(Color.m2909boximpl(j19), SnapshotStateKt.structuralEqualityPolicy());
        this.onBackground$delegate = SnapshotStateKt.mutableStateOf(Color.m2909boximpl(j21), SnapshotStateKt.structuralEqualityPolicy());
        this.onSurface$delegate = SnapshotStateKt.mutableStateOf(Color.m2909boximpl(j22), SnapshotStateKt.structuralEqualityPolicy());
        this.onError$delegate = SnapshotStateKt.mutableStateOf(Color.m2909boximpl(j23), SnapshotStateKt.structuralEqualityPolicy());
        this.isLight$delegate = SnapshotStateKt.mutableStateOf(Boolean.valueOf(z11), SnapshotStateKt.structuralEqualityPolicy());
    }

    public /* synthetic */ Colors(long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j21, long j22, long j23, boolean z11, DefaultConstructorMarker defaultConstructorMarker) {
        this(j11, j12, j13, j14, j15, j16, j17, j18, j19, j21, j22, j23, z11);
    }

    /* renamed from: copy-pvPzIIM$default  reason: not valid java name */
    public static /* synthetic */ Colors m1170copypvPzIIM$default(Colors colors, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j21, long j22, long j23, boolean z11, int i11, Object obj) {
        long j24;
        long j25;
        long j26;
        long j27;
        long j28;
        long j29;
        long j31;
        long j32;
        long j33;
        long j34;
        long j35;
        long j36;
        boolean z12;
        int i12 = i11;
        if ((i12 & 1) != 0) {
            j24 = colors.m1179getPrimary0d7_KjU();
        } else {
            j24 = j11;
        }
        if ((i12 & 2) != 0) {
            j25 = colors.m1180getPrimaryVariant0d7_KjU();
        } else {
            j25 = j12;
        }
        if ((i12 & 4) != 0) {
            j26 = colors.m1181getSecondary0d7_KjU();
        } else {
            j26 = j13;
        }
        if ((i12 & 8) != 0) {
            j27 = colors.m1182getSecondaryVariant0d7_KjU();
        } else {
            j27 = j14;
        }
        if ((i12 & 16) != 0) {
            j28 = colors.m1172getBackground0d7_KjU();
        } else {
            j28 = j15;
        }
        if ((i12 & 32) != 0) {
            j29 = colors.m1183getSurface0d7_KjU();
        } else {
            j29 = j16;
        }
        if ((i12 & 64) != 0) {
            j31 = colors.m1173getError0d7_KjU();
        } else {
            j31 = j17;
        }
        if ((i12 & 128) != 0) {
            j32 = colors.m1176getOnPrimary0d7_KjU();
        } else {
            j32 = j18;
        }
        long j37 = j32;
        if ((i12 & 256) != 0) {
            j33 = colors.m1177getOnSecondary0d7_KjU();
        } else {
            j33 = j19;
        }
        long j38 = j33;
        if ((i12 & 512) != 0) {
            j34 = colors.m1174getOnBackground0d7_KjU();
        } else {
            j34 = j21;
        }
        long j39 = j34;
        if ((i12 & 1024) != 0) {
            j35 = colors.m1178getOnSurface0d7_KjU();
        } else {
            j35 = j22;
        }
        long j41 = j35;
        if ((i12 & 2048) != 0) {
            j36 = colors.m1175getOnError0d7_KjU();
        } else {
            j36 = j23;
        }
        if ((i12 & 4096) != 0) {
            z12 = colors.isLight();
        } else {
            z12 = z11;
        }
        return colors.m1171copypvPzIIM(j24, j25, j26, j27, j28, j29, j31, j37, j38, j39, j41, j36, z12);
    }

    @NotNull
    /* renamed from: copy-pvPzIIM  reason: not valid java name */
    public final Colors m1171copypvPzIIM(long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j21, long j22, long j23, boolean z11) {
        return new Colors(j11, j12, j13, j14, j15, j16, j17, j18, j19, j21, j22, j23, z11, (DefaultConstructorMarker) null);
    }

    /* renamed from: getBackground-0d7_KjU  reason: not valid java name */
    public final long m1172getBackground0d7_KjU() {
        return ((Color) this.background$delegate.getValue()).m2929unboximpl();
    }

    /* renamed from: getError-0d7_KjU  reason: not valid java name */
    public final long m1173getError0d7_KjU() {
        return ((Color) this.error$delegate.getValue()).m2929unboximpl();
    }

    /* renamed from: getOnBackground-0d7_KjU  reason: not valid java name */
    public final long m1174getOnBackground0d7_KjU() {
        return ((Color) this.onBackground$delegate.getValue()).m2929unboximpl();
    }

    /* renamed from: getOnError-0d7_KjU  reason: not valid java name */
    public final long m1175getOnError0d7_KjU() {
        return ((Color) this.onError$delegate.getValue()).m2929unboximpl();
    }

    /* renamed from: getOnPrimary-0d7_KjU  reason: not valid java name */
    public final long m1176getOnPrimary0d7_KjU() {
        return ((Color) this.onPrimary$delegate.getValue()).m2929unboximpl();
    }

    /* renamed from: getOnSecondary-0d7_KjU  reason: not valid java name */
    public final long m1177getOnSecondary0d7_KjU() {
        return ((Color) this.onSecondary$delegate.getValue()).m2929unboximpl();
    }

    /* renamed from: getOnSurface-0d7_KjU  reason: not valid java name */
    public final long m1178getOnSurface0d7_KjU() {
        return ((Color) this.onSurface$delegate.getValue()).m2929unboximpl();
    }

    /* renamed from: getPrimary-0d7_KjU  reason: not valid java name */
    public final long m1179getPrimary0d7_KjU() {
        return ((Color) this.primary$delegate.getValue()).m2929unboximpl();
    }

    /* renamed from: getPrimaryVariant-0d7_KjU  reason: not valid java name */
    public final long m1180getPrimaryVariant0d7_KjU() {
        return ((Color) this.primaryVariant$delegate.getValue()).m2929unboximpl();
    }

    /* renamed from: getSecondary-0d7_KjU  reason: not valid java name */
    public final long m1181getSecondary0d7_KjU() {
        return ((Color) this.secondary$delegate.getValue()).m2929unboximpl();
    }

    /* renamed from: getSecondaryVariant-0d7_KjU  reason: not valid java name */
    public final long m1182getSecondaryVariant0d7_KjU() {
        return ((Color) this.secondaryVariant$delegate.getValue()).m2929unboximpl();
    }

    /* renamed from: getSurface-0d7_KjU  reason: not valid java name */
    public final long m1183getSurface0d7_KjU() {
        return ((Color) this.surface$delegate.getValue()).m2929unboximpl();
    }

    public final boolean isLight() {
        return ((Boolean) this.isLight$delegate.getValue()).booleanValue();
    }

    /* renamed from: setBackground-8_81llA$material_release  reason: not valid java name */
    public final void m1184setBackground8_81llA$material_release(long j11) {
        this.background$delegate.setValue(Color.m2909boximpl(j11));
    }

    /* renamed from: setError-8_81llA$material_release  reason: not valid java name */
    public final void m1185setError8_81llA$material_release(long j11) {
        this.error$delegate.setValue(Color.m2909boximpl(j11));
    }

    public final void setLight$material_release(boolean z11) {
        this.isLight$delegate.setValue(Boolean.valueOf(z11));
    }

    /* renamed from: setOnBackground-8_81llA$material_release  reason: not valid java name */
    public final void m1186setOnBackground8_81llA$material_release(long j11) {
        this.onBackground$delegate.setValue(Color.m2909boximpl(j11));
    }

    /* renamed from: setOnError-8_81llA$material_release  reason: not valid java name */
    public final void m1187setOnError8_81llA$material_release(long j11) {
        this.onError$delegate.setValue(Color.m2909boximpl(j11));
    }

    /* renamed from: setOnPrimary-8_81llA$material_release  reason: not valid java name */
    public final void m1188setOnPrimary8_81llA$material_release(long j11) {
        this.onPrimary$delegate.setValue(Color.m2909boximpl(j11));
    }

    /* renamed from: setOnSecondary-8_81llA$material_release  reason: not valid java name */
    public final void m1189setOnSecondary8_81llA$material_release(long j11) {
        this.onSecondary$delegate.setValue(Color.m2909boximpl(j11));
    }

    /* renamed from: setOnSurface-8_81llA$material_release  reason: not valid java name */
    public final void m1190setOnSurface8_81llA$material_release(long j11) {
        this.onSurface$delegate.setValue(Color.m2909boximpl(j11));
    }

    /* renamed from: setPrimary-8_81llA$material_release  reason: not valid java name */
    public final void m1191setPrimary8_81llA$material_release(long j11) {
        this.primary$delegate.setValue(Color.m2909boximpl(j11));
    }

    /* renamed from: setPrimaryVariant-8_81llA$material_release  reason: not valid java name */
    public final void m1192setPrimaryVariant8_81llA$material_release(long j11) {
        this.primaryVariant$delegate.setValue(Color.m2909boximpl(j11));
    }

    /* renamed from: setSecondary-8_81llA$material_release  reason: not valid java name */
    public final void m1193setSecondary8_81llA$material_release(long j11) {
        this.secondary$delegate.setValue(Color.m2909boximpl(j11));
    }

    /* renamed from: setSecondaryVariant-8_81llA$material_release  reason: not valid java name */
    public final void m1194setSecondaryVariant8_81llA$material_release(long j11) {
        this.secondaryVariant$delegate.setValue(Color.m2909boximpl(j11));
    }

    /* renamed from: setSurface-8_81llA$material_release  reason: not valid java name */
    public final void m1195setSurface8_81llA$material_release(long j11) {
        this.surface$delegate.setValue(Color.m2909boximpl(j11));
    }

    @NotNull
    public String toString() {
        return "Colors(primary=" + Color.m2927toStringimpl(m1179getPrimary0d7_KjU()) + ", primaryVariant=" + Color.m2927toStringimpl(m1180getPrimaryVariant0d7_KjU()) + ", secondary=" + Color.m2927toStringimpl(m1181getSecondary0d7_KjU()) + ", secondaryVariant=" + Color.m2927toStringimpl(m1182getSecondaryVariant0d7_KjU()) + ", background=" + Color.m2927toStringimpl(m1172getBackground0d7_KjU()) + ", surface=" + Color.m2927toStringimpl(m1183getSurface0d7_KjU()) + ", error=" + Color.m2927toStringimpl(m1173getError0d7_KjU()) + ", onPrimary=" + Color.m2927toStringimpl(m1176getOnPrimary0d7_KjU()) + ", onSecondary=" + Color.m2927toStringimpl(m1177getOnSecondary0d7_KjU()) + ", onBackground=" + Color.m2927toStringimpl(m1174getOnBackground0d7_KjU()) + ", onSurface=" + Color.m2927toStringimpl(m1178getOnSurface0d7_KjU()) + ", onError=" + Color.m2927toStringimpl(m1175getOnError0d7_KjU()) + ", isLight=" + isLight() + ')';
    }
}
