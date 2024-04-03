package androidx.compose.material3;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.Stable;
import androidx.compose.ui.graphics.Color;
import com.google.android.exoplayer2.C;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b|\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001Bð\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u0012\u0006\u0010\u0013\u001a\u00020\u0003\u0012\u0006\u0010\u0014\u001a\u00020\u0003\u0012\u0006\u0010\u0015\u001a\u00020\u0003\u0012\u0006\u0010\u0016\u001a\u00020\u0003\u0012\u0006\u0010\u0017\u001a\u00020\u0003\u0012\u0006\u0010\u0018\u001a\u00020\u0003\u0012\u0006\u0010\u0019\u001a\u00020\u0003\u0012\u0006\u0010\u001a\u001a\u00020\u0003\u0012\u0006\u0010\u001b\u001a\u00020\u0003\u0012\u0006\u0010\u001c\u001a\u00020\u0003\u0012\u0006\u0010\u001d\u001a\u00020\u0003\u0012\u0006\u0010\u001e\u001a\u00020\u0003\u0012\u0006\u0010\u001f\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0002\u0010 Jµ\u0002\u0010|\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u00032\b\b\u0002\u0010\u0018\u001a\u00020\u00032\b\b\u0002\u0010\u0019\u001a\u00020\u00032\b\b\u0002\u0010\u001a\u001a\u00020\u00032\b\b\u0002\u0010\u001b\u001a\u00020\u00032\b\b\u0002\u0010\u001c\u001a\u00020\u00032\b\b\u0002\u0010\u001d\u001a\u00020\u00032\b\b\u0002\u0010\u001e\u001a\u00020\u00032\b\b\u0002\u0010\u001f\u001a\u00020\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b}\u0010~J\t\u0010\u001a\u00030\u0001H\u0016R4\u0010\u0010\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00038F@@X\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R4\u0010\u0019\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00038F@@X\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\b*\u0010'\u001a\u0004\b(\u0010#\"\u0004\b)\u0010%R4\u0010\u001b\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00038F@@X\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\b-\u0010'\u001a\u0004\b+\u0010#\"\u0004\b,\u0010%R4\u0010\u0018\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00038F@@X\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\b0\u0010'\u001a\u0004\b.\u0010#\"\u0004\b/\u0010%R4\u0010\u0007\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00038F@@X\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\b3\u0010'\u001a\u0004\b1\u0010#\"\u0004\b2\u0010%R4\u0010\u0017\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00038F@@X\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\b6\u0010'\u001a\u0004\b4\u0010#\"\u0004\b5\u0010%R4\u0010\u0011\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00038F@@X\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\b9\u0010'\u001a\u0004\b7\u0010#\"\u0004\b8\u0010%R4\u0010\u001a\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00038F@@X\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\b<\u0010'\u001a\u0004\b:\u0010#\"\u0004\b;\u0010%R4\u0010\u001c\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00038F@@X\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\b?\u0010'\u001a\u0004\b=\u0010#\"\u0004\b>\u0010%R4\u0010\u0004\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00038F@@X\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\bB\u0010'\u001a\u0004\b@\u0010#\"\u0004\bA\u0010%R4\u0010\u0006\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00038F@@X\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\bE\u0010'\u001a\u0004\bC\u0010#\"\u0004\bD\u0010%R4\u0010\t\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00038F@@X\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\bH\u0010'\u001a\u0004\bF\u0010#\"\u0004\bG\u0010%R4\u0010\u000b\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00038F@@X\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\bK\u0010'\u001a\u0004\bI\u0010#\"\u0004\bJ\u0010%R4\u0010\u0013\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00038F@@X\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\bN\u0010'\u001a\u0004\bL\u0010#\"\u0004\bM\u0010%R4\u0010\u0015\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00038F@@X\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\bQ\u0010'\u001a\u0004\bO\u0010#\"\u0004\bP\u0010%R4\u0010\r\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00038F@@X\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\bT\u0010'\u001a\u0004\bR\u0010#\"\u0004\bS\u0010%R4\u0010\u000f\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00038F@@X\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\bW\u0010'\u001a\u0004\bU\u0010#\"\u0004\bV\u0010%R4\u0010\u001d\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00038F@@X\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\bZ\u0010'\u001a\u0004\bX\u0010#\"\u0004\bY\u0010%R4\u0010\u001e\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00038F@@X\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\b]\u0010'\u001a\u0004\b[\u0010#\"\u0004\b\\\u0010%R4\u0010\u0002\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00038F@@X\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\b`\u0010'\u001a\u0004\b^\u0010#\"\u0004\b_\u0010%R4\u0010\u0005\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00038F@@X\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\bc\u0010'\u001a\u0004\ba\u0010#\"\u0004\bb\u0010%R4\u0010\u001f\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00038F@@X\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\bf\u0010'\u001a\u0004\bd\u0010#\"\u0004\be\u0010%R4\u0010\b\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00038F@@X\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\bi\u0010'\u001a\u0004\bg\u0010#\"\u0004\bh\u0010%R4\u0010\n\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00038F@@X\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\bl\u0010'\u001a\u0004\bj\u0010#\"\u0004\bk\u0010%R4\u0010\u0012\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00038F@@X\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\bo\u0010'\u001a\u0004\bm\u0010#\"\u0004\bn\u0010%R4\u0010\u0016\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00038F@@X\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\br\u0010'\u001a\u0004\bp\u0010#\"\u0004\bq\u0010%R4\u0010\u0014\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00038F@@X\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\bu\u0010'\u001a\u0004\bs\u0010#\"\u0004\bt\u0010%R4\u0010\f\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00038F@@X\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\bx\u0010'\u001a\u0004\bv\u0010#\"\u0004\bw\u0010%R4\u0010\u000e\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00038F@@X\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\b{\u0010'\u001a\u0004\by\u0010#\"\u0004\bz\u0010%\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0001"}, d2 = {"Landroidx/compose/material3/ColorScheme;", "", "primary", "Landroidx/compose/ui/graphics/Color;", "onPrimary", "primaryContainer", "onPrimaryContainer", "inversePrimary", "secondary", "onSecondary", "secondaryContainer", "onSecondaryContainer", "tertiary", "onTertiary", "tertiaryContainer", "onTertiaryContainer", "background", "onBackground", "surface", "onSurface", "surfaceVariant", "onSurfaceVariant", "surfaceTint", "inverseSurface", "inverseOnSurface", "error", "onError", "errorContainer", "onErrorContainer", "outline", "outlineVariant", "scrim", "(JJJJJJJJJJJJJJJJJJJJJJJJJJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "<set-?>", "getBackground-0d7_KjU", "()J", "setBackground-8_81llA$material3_release", "(J)V", "background$delegate", "Landroidx/compose/runtime/MutableState;", "getError-0d7_KjU", "setError-8_81llA$material3_release", "error$delegate", "getErrorContainer-0d7_KjU", "setErrorContainer-8_81llA$material3_release", "errorContainer$delegate", "getInverseOnSurface-0d7_KjU", "setInverseOnSurface-8_81llA$material3_release", "inverseOnSurface$delegate", "getInversePrimary-0d7_KjU", "setInversePrimary-8_81llA$material3_release", "inversePrimary$delegate", "getInverseSurface-0d7_KjU", "setInverseSurface-8_81llA$material3_release", "inverseSurface$delegate", "getOnBackground-0d7_KjU", "setOnBackground-8_81llA$material3_release", "onBackground$delegate", "getOnError-0d7_KjU", "setOnError-8_81llA$material3_release", "onError$delegate", "getOnErrorContainer-0d7_KjU", "setOnErrorContainer-8_81llA$material3_release", "onErrorContainer$delegate", "getOnPrimary-0d7_KjU", "setOnPrimary-8_81llA$material3_release", "onPrimary$delegate", "getOnPrimaryContainer-0d7_KjU", "setOnPrimaryContainer-8_81llA$material3_release", "onPrimaryContainer$delegate", "getOnSecondary-0d7_KjU", "setOnSecondary-8_81llA$material3_release", "onSecondary$delegate", "getOnSecondaryContainer-0d7_KjU", "setOnSecondaryContainer-8_81llA$material3_release", "onSecondaryContainer$delegate", "getOnSurface-0d7_KjU", "setOnSurface-8_81llA$material3_release", "onSurface$delegate", "getOnSurfaceVariant-0d7_KjU", "setOnSurfaceVariant-8_81llA$material3_release", "onSurfaceVariant$delegate", "getOnTertiary-0d7_KjU", "setOnTertiary-8_81llA$material3_release", "onTertiary$delegate", "getOnTertiaryContainer-0d7_KjU", "setOnTertiaryContainer-8_81llA$material3_release", "onTertiaryContainer$delegate", "getOutline-0d7_KjU", "setOutline-8_81llA$material3_release", "outline$delegate", "getOutlineVariant-0d7_KjU", "setOutlineVariant-8_81llA$material3_release", "outlineVariant$delegate", "getPrimary-0d7_KjU", "setPrimary-8_81llA$material3_release", "primary$delegate", "getPrimaryContainer-0d7_KjU", "setPrimaryContainer-8_81llA$material3_release", "primaryContainer$delegate", "getScrim-0d7_KjU", "setScrim-8_81llA$material3_release", "scrim$delegate", "getSecondary-0d7_KjU", "setSecondary-8_81llA$material3_release", "secondary$delegate", "getSecondaryContainer-0d7_KjU", "setSecondaryContainer-8_81llA$material3_release", "secondaryContainer$delegate", "getSurface-0d7_KjU", "setSurface-8_81llA$material3_release", "surface$delegate", "getSurfaceTint-0d7_KjU", "setSurfaceTint-8_81llA$material3_release", "surfaceTint$delegate", "getSurfaceVariant-0d7_KjU", "setSurfaceVariant-8_81llA$material3_release", "surfaceVariant$delegate", "getTertiary-0d7_KjU", "setTertiary-8_81llA$material3_release", "tertiary$delegate", "getTertiaryContainer-0d7_KjU", "setTertiaryContainer-8_81llA$material3_release", "tertiaryContainer$delegate", "copy", "copy-G1PFc-w", "(JJJJJJJJJJJJJJJJJJJJJJJJJJJJJ)Landroidx/compose/material3/ColorScheme;", "toString", "", "material3_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@Stable
public final class ColorScheme {
    @NotNull
    private final MutableState background$delegate;
    @NotNull
    private final MutableState error$delegate;
    @NotNull
    private final MutableState errorContainer$delegate;
    @NotNull
    private final MutableState inverseOnSurface$delegate;
    @NotNull
    private final MutableState inversePrimary$delegate;
    @NotNull
    private final MutableState inverseSurface$delegate;
    @NotNull
    private final MutableState onBackground$delegate;
    @NotNull
    private final MutableState onError$delegate;
    @NotNull
    private final MutableState onErrorContainer$delegate;
    @NotNull
    private final MutableState onPrimary$delegate;
    @NotNull
    private final MutableState onPrimaryContainer$delegate;
    @NotNull
    private final MutableState onSecondary$delegate;
    @NotNull
    private final MutableState onSecondaryContainer$delegate;
    @NotNull
    private final MutableState onSurface$delegate;
    @NotNull
    private final MutableState onSurfaceVariant$delegate;
    @NotNull
    private final MutableState onTertiary$delegate;
    @NotNull
    private final MutableState onTertiaryContainer$delegate;
    @NotNull
    private final MutableState outline$delegate;
    @NotNull
    private final MutableState outlineVariant$delegate;
    @NotNull
    private final MutableState primary$delegate;
    @NotNull
    private final MutableState primaryContainer$delegate;
    @NotNull
    private final MutableState scrim$delegate;
    @NotNull
    private final MutableState secondary$delegate;
    @NotNull
    private final MutableState secondaryContainer$delegate;
    @NotNull
    private final MutableState surface$delegate;
    @NotNull
    private final MutableState surfaceTint$delegate;
    @NotNull
    private final MutableState surfaceVariant$delegate;
    @NotNull
    private final MutableState tertiary$delegate;
    @NotNull
    private final MutableState tertiaryContainer$delegate;

    private ColorScheme(long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, long j31, long j32, long j33, long j34, long j35, long j36, long j37, long j38, long j39, long j41, long j42) {
        this.primary$delegate = SnapshotStateKt.mutableStateOf(Color.m2909boximpl(j11), SnapshotStateKt.structuralEqualityPolicy());
        this.onPrimary$delegate = SnapshotStateKt.mutableStateOf(Color.m2909boximpl(j12), SnapshotStateKt.structuralEqualityPolicy());
        this.primaryContainer$delegate = SnapshotStateKt.mutableStateOf(Color.m2909boximpl(j13), SnapshotStateKt.structuralEqualityPolicy());
        this.onPrimaryContainer$delegate = SnapshotStateKt.mutableStateOf(Color.m2909boximpl(j14), SnapshotStateKt.structuralEqualityPolicy());
        this.inversePrimary$delegate = SnapshotStateKt.mutableStateOf(Color.m2909boximpl(j15), SnapshotStateKt.structuralEqualityPolicy());
        this.secondary$delegate = SnapshotStateKt.mutableStateOf(Color.m2909boximpl(j16), SnapshotStateKt.structuralEqualityPolicy());
        this.onSecondary$delegate = SnapshotStateKt.mutableStateOf(Color.m2909boximpl(j17), SnapshotStateKt.structuralEqualityPolicy());
        this.secondaryContainer$delegate = SnapshotStateKt.mutableStateOf(Color.m2909boximpl(j18), SnapshotStateKt.structuralEqualityPolicy());
        this.onSecondaryContainer$delegate = SnapshotStateKt.mutableStateOf(Color.m2909boximpl(j19), SnapshotStateKt.structuralEqualityPolicy());
        this.tertiary$delegate = SnapshotStateKt.mutableStateOf(Color.m2909boximpl(j21), SnapshotStateKt.structuralEqualityPolicy());
        this.onTertiary$delegate = SnapshotStateKt.mutableStateOf(Color.m2909boximpl(j22), SnapshotStateKt.structuralEqualityPolicy());
        this.tertiaryContainer$delegate = SnapshotStateKt.mutableStateOf(Color.m2909boximpl(j23), SnapshotStateKt.structuralEqualityPolicy());
        this.onTertiaryContainer$delegate = SnapshotStateKt.mutableStateOf(Color.m2909boximpl(j24), SnapshotStateKt.structuralEqualityPolicy());
        this.background$delegate = SnapshotStateKt.mutableStateOf(Color.m2909boximpl(j25), SnapshotStateKt.structuralEqualityPolicy());
        this.onBackground$delegate = SnapshotStateKt.mutableStateOf(Color.m2909boximpl(j26), SnapshotStateKt.structuralEqualityPolicy());
        this.surface$delegate = SnapshotStateKt.mutableStateOf(Color.m2909boximpl(j27), SnapshotStateKt.structuralEqualityPolicy());
        this.onSurface$delegate = SnapshotStateKt.mutableStateOf(Color.m2909boximpl(j28), SnapshotStateKt.structuralEqualityPolicy());
        this.surfaceVariant$delegate = SnapshotStateKt.mutableStateOf(Color.m2909boximpl(j29), SnapshotStateKt.structuralEqualityPolicy());
        this.onSurfaceVariant$delegate = SnapshotStateKt.mutableStateOf(Color.m2909boximpl(j31), SnapshotStateKt.structuralEqualityPolicy());
        this.surfaceTint$delegate = SnapshotStateKt.mutableStateOf(Color.m2909boximpl(j32), SnapshotStateKt.structuralEqualityPolicy());
        this.inverseSurface$delegate = SnapshotStateKt.mutableStateOf(Color.m2909boximpl(j33), SnapshotStateKt.structuralEqualityPolicy());
        this.inverseOnSurface$delegate = SnapshotStateKt.mutableStateOf(Color.m2909boximpl(j34), SnapshotStateKt.structuralEqualityPolicy());
        this.error$delegate = SnapshotStateKt.mutableStateOf(Color.m2909boximpl(j35), SnapshotStateKt.structuralEqualityPolicy());
        this.onError$delegate = SnapshotStateKt.mutableStateOf(Color.m2909boximpl(j36), SnapshotStateKt.structuralEqualityPolicy());
        this.errorContainer$delegate = SnapshotStateKt.mutableStateOf(Color.m2909boximpl(j37), SnapshotStateKt.structuralEqualityPolicy());
        this.onErrorContainer$delegate = SnapshotStateKt.mutableStateOf(Color.m2909boximpl(j38), SnapshotStateKt.structuralEqualityPolicy());
        this.outline$delegate = SnapshotStateKt.mutableStateOf(Color.m2909boximpl(j39), SnapshotStateKt.structuralEqualityPolicy());
        this.outlineVariant$delegate = SnapshotStateKt.mutableStateOf(Color.m2909boximpl(j41), SnapshotStateKt.structuralEqualityPolicy());
        this.scrim$delegate = SnapshotStateKt.mutableStateOf(Color.m2909boximpl(j42), SnapshotStateKt.structuralEqualityPolicy());
    }

    public /* synthetic */ ColorScheme(long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, long j31, long j32, long j33, long j34, long j35, long j36, long j37, long j38, long j39, long j41, long j42, DefaultConstructorMarker defaultConstructorMarker) {
        this(j11, j12, j13, j14, j15, j16, j17, j18, j19, j21, j22, j23, j24, j25, j26, j27, j28, j29, j31, j32, j33, j34, j35, j36, j37, j38, j39, j41, j42);
    }

    /* renamed from: copy-G1PFc-w$default  reason: not valid java name */
    public static /* synthetic */ ColorScheme m1547copyG1PFcw$default(ColorScheme colorScheme, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, long j31, long j32, long j33, long j34, long j35, long j36, long j37, long j38, long j39, long j41, long j42, int i11, Object obj) {
        int i12 = i11;
        return colorScheme.m1548copyG1PFcw((i12 & 1) != 0 ? colorScheme.m1568getPrimary0d7_KjU() : j11, (i12 & 2) != 0 ? colorScheme.m1558getOnPrimary0d7_KjU() : j12, (i12 & 4) != 0 ? colorScheme.m1569getPrimaryContainer0d7_KjU() : j13, (i12 & 8) != 0 ? colorScheme.m1559getOnPrimaryContainer0d7_KjU() : j14, (i12 & 16) != 0 ? colorScheme.m1553getInversePrimary0d7_KjU() : j15, (i12 & 32) != 0 ? colorScheme.m1571getSecondary0d7_KjU() : j16, (i12 & 64) != 0 ? colorScheme.m1560getOnSecondary0d7_KjU() : j17, (i12 & 128) != 0 ? colorScheme.m1572getSecondaryContainer0d7_KjU() : j18, (i12 & 256) != 0 ? colorScheme.m1561getOnSecondaryContainer0d7_KjU() : j19, (i12 & 512) != 0 ? colorScheme.m1576getTertiary0d7_KjU() : j21, (i12 & 1024) != 0 ? colorScheme.m1564getOnTertiary0d7_KjU() : j22, (i12 & 2048) != 0 ? colorScheme.m1577getTertiaryContainer0d7_KjU() : j23, (i12 & 4096) != 0 ? colorScheme.m1565getOnTertiaryContainer0d7_KjU() : j24, (i12 & 8192) != 0 ? colorScheme.m1549getBackground0d7_KjU() : j25, (i12 & 16384) != 0 ? colorScheme.m1555getOnBackground0d7_KjU() : j26, (i12 & 32768) != 0 ? colorScheme.m1573getSurface0d7_KjU() : j27, (i12 & 65536) != 0 ? colorScheme.m1562getOnSurface0d7_KjU() : j28, (i12 & 131072) != 0 ? colorScheme.m1575getSurfaceVariant0d7_KjU() : j29, (i12 & 262144) != 0 ? colorScheme.m1563getOnSurfaceVariant0d7_KjU() : j31, (i12 & 524288) != 0 ? colorScheme.m1574getSurfaceTint0d7_KjU() : j32, (i12 & 1048576) != 0 ? colorScheme.m1554getInverseSurface0d7_KjU() : j33, (i12 & 2097152) != 0 ? colorScheme.m1552getInverseOnSurface0d7_KjU() : j34, (i12 & 4194304) != 0 ? colorScheme.m1550getError0d7_KjU() : j35, (i12 & 8388608) != 0 ? colorScheme.m1556getOnError0d7_KjU() : j36, (i12 & 16777216) != 0 ? colorScheme.m1551getErrorContainer0d7_KjU() : j37, (i12 & 33554432) != 0 ? colorScheme.m1557getOnErrorContainer0d7_KjU() : j38, (i12 & 67108864) != 0 ? colorScheme.m1566getOutline0d7_KjU() : j39, (i12 & C.BUFFER_FLAG_FIRST_SAMPLE) != 0 ? colorScheme.m1567getOutlineVariant0d7_KjU() : j41, (i12 & 268435456) != 0 ? colorScheme.m1570getScrim0d7_KjU() : j42);
    }

    @NotNull
    /* renamed from: copy-G1PFc-w  reason: not valid java name */
    public final ColorScheme m1548copyG1PFcw(long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, long j31, long j32, long j33, long j34, long j35, long j36, long j37, long j38, long j39, long j41, long j42) {
        return new ColorScheme(j11, j12, j13, j14, j15, j16, j17, j18, j19, j21, j22, j23, j24, j25, j26, j27, j28, j29, j31, j32, j33, j34, j35, j36, j37, j38, j39, j41, j42, (DefaultConstructorMarker) null);
    }

    /* renamed from: getBackground-0d7_KjU  reason: not valid java name */
    public final long m1549getBackground0d7_KjU() {
        return ((Color) this.background$delegate.getValue()).m2929unboximpl();
    }

    /* renamed from: getError-0d7_KjU  reason: not valid java name */
    public final long m1550getError0d7_KjU() {
        return ((Color) this.error$delegate.getValue()).m2929unboximpl();
    }

    /* renamed from: getErrorContainer-0d7_KjU  reason: not valid java name */
    public final long m1551getErrorContainer0d7_KjU() {
        return ((Color) this.errorContainer$delegate.getValue()).m2929unboximpl();
    }

    /* renamed from: getInverseOnSurface-0d7_KjU  reason: not valid java name */
    public final long m1552getInverseOnSurface0d7_KjU() {
        return ((Color) this.inverseOnSurface$delegate.getValue()).m2929unboximpl();
    }

    /* renamed from: getInversePrimary-0d7_KjU  reason: not valid java name */
    public final long m1553getInversePrimary0d7_KjU() {
        return ((Color) this.inversePrimary$delegate.getValue()).m2929unboximpl();
    }

    /* renamed from: getInverseSurface-0d7_KjU  reason: not valid java name */
    public final long m1554getInverseSurface0d7_KjU() {
        return ((Color) this.inverseSurface$delegate.getValue()).m2929unboximpl();
    }

    /* renamed from: getOnBackground-0d7_KjU  reason: not valid java name */
    public final long m1555getOnBackground0d7_KjU() {
        return ((Color) this.onBackground$delegate.getValue()).m2929unboximpl();
    }

    /* renamed from: getOnError-0d7_KjU  reason: not valid java name */
    public final long m1556getOnError0d7_KjU() {
        return ((Color) this.onError$delegate.getValue()).m2929unboximpl();
    }

    /* renamed from: getOnErrorContainer-0d7_KjU  reason: not valid java name */
    public final long m1557getOnErrorContainer0d7_KjU() {
        return ((Color) this.onErrorContainer$delegate.getValue()).m2929unboximpl();
    }

    /* renamed from: getOnPrimary-0d7_KjU  reason: not valid java name */
    public final long m1558getOnPrimary0d7_KjU() {
        return ((Color) this.onPrimary$delegate.getValue()).m2929unboximpl();
    }

    /* renamed from: getOnPrimaryContainer-0d7_KjU  reason: not valid java name */
    public final long m1559getOnPrimaryContainer0d7_KjU() {
        return ((Color) this.onPrimaryContainer$delegate.getValue()).m2929unboximpl();
    }

    /* renamed from: getOnSecondary-0d7_KjU  reason: not valid java name */
    public final long m1560getOnSecondary0d7_KjU() {
        return ((Color) this.onSecondary$delegate.getValue()).m2929unboximpl();
    }

    /* renamed from: getOnSecondaryContainer-0d7_KjU  reason: not valid java name */
    public final long m1561getOnSecondaryContainer0d7_KjU() {
        return ((Color) this.onSecondaryContainer$delegate.getValue()).m2929unboximpl();
    }

    /* renamed from: getOnSurface-0d7_KjU  reason: not valid java name */
    public final long m1562getOnSurface0d7_KjU() {
        return ((Color) this.onSurface$delegate.getValue()).m2929unboximpl();
    }

    /* renamed from: getOnSurfaceVariant-0d7_KjU  reason: not valid java name */
    public final long m1563getOnSurfaceVariant0d7_KjU() {
        return ((Color) this.onSurfaceVariant$delegate.getValue()).m2929unboximpl();
    }

    /* renamed from: getOnTertiary-0d7_KjU  reason: not valid java name */
    public final long m1564getOnTertiary0d7_KjU() {
        return ((Color) this.onTertiary$delegate.getValue()).m2929unboximpl();
    }

    /* renamed from: getOnTertiaryContainer-0d7_KjU  reason: not valid java name */
    public final long m1565getOnTertiaryContainer0d7_KjU() {
        return ((Color) this.onTertiaryContainer$delegate.getValue()).m2929unboximpl();
    }

    /* renamed from: getOutline-0d7_KjU  reason: not valid java name */
    public final long m1566getOutline0d7_KjU() {
        return ((Color) this.outline$delegate.getValue()).m2929unboximpl();
    }

    /* renamed from: getOutlineVariant-0d7_KjU  reason: not valid java name */
    public final long m1567getOutlineVariant0d7_KjU() {
        return ((Color) this.outlineVariant$delegate.getValue()).m2929unboximpl();
    }

    /* renamed from: getPrimary-0d7_KjU  reason: not valid java name */
    public final long m1568getPrimary0d7_KjU() {
        return ((Color) this.primary$delegate.getValue()).m2929unboximpl();
    }

    /* renamed from: getPrimaryContainer-0d7_KjU  reason: not valid java name */
    public final long m1569getPrimaryContainer0d7_KjU() {
        return ((Color) this.primaryContainer$delegate.getValue()).m2929unboximpl();
    }

    /* renamed from: getScrim-0d7_KjU  reason: not valid java name */
    public final long m1570getScrim0d7_KjU() {
        return ((Color) this.scrim$delegate.getValue()).m2929unboximpl();
    }

    /* renamed from: getSecondary-0d7_KjU  reason: not valid java name */
    public final long m1571getSecondary0d7_KjU() {
        return ((Color) this.secondary$delegate.getValue()).m2929unboximpl();
    }

    /* renamed from: getSecondaryContainer-0d7_KjU  reason: not valid java name */
    public final long m1572getSecondaryContainer0d7_KjU() {
        return ((Color) this.secondaryContainer$delegate.getValue()).m2929unboximpl();
    }

    /* renamed from: getSurface-0d7_KjU  reason: not valid java name */
    public final long m1573getSurface0d7_KjU() {
        return ((Color) this.surface$delegate.getValue()).m2929unboximpl();
    }

    /* renamed from: getSurfaceTint-0d7_KjU  reason: not valid java name */
    public final long m1574getSurfaceTint0d7_KjU() {
        return ((Color) this.surfaceTint$delegate.getValue()).m2929unboximpl();
    }

    /* renamed from: getSurfaceVariant-0d7_KjU  reason: not valid java name */
    public final long m1575getSurfaceVariant0d7_KjU() {
        return ((Color) this.surfaceVariant$delegate.getValue()).m2929unboximpl();
    }

    /* renamed from: getTertiary-0d7_KjU  reason: not valid java name */
    public final long m1576getTertiary0d7_KjU() {
        return ((Color) this.tertiary$delegate.getValue()).m2929unboximpl();
    }

    /* renamed from: getTertiaryContainer-0d7_KjU  reason: not valid java name */
    public final long m1577getTertiaryContainer0d7_KjU() {
        return ((Color) this.tertiaryContainer$delegate.getValue()).m2929unboximpl();
    }

    /* renamed from: setBackground-8_81llA$material3_release  reason: not valid java name */
    public final void m1578setBackground8_81llA$material3_release(long j11) {
        this.background$delegate.setValue(Color.m2909boximpl(j11));
    }

    /* renamed from: setError-8_81llA$material3_release  reason: not valid java name */
    public final void m1579setError8_81llA$material3_release(long j11) {
        this.error$delegate.setValue(Color.m2909boximpl(j11));
    }

    /* renamed from: setErrorContainer-8_81llA$material3_release  reason: not valid java name */
    public final void m1580setErrorContainer8_81llA$material3_release(long j11) {
        this.errorContainer$delegate.setValue(Color.m2909boximpl(j11));
    }

    /* renamed from: setInverseOnSurface-8_81llA$material3_release  reason: not valid java name */
    public final void m1581setInverseOnSurface8_81llA$material3_release(long j11) {
        this.inverseOnSurface$delegate.setValue(Color.m2909boximpl(j11));
    }

    /* renamed from: setInversePrimary-8_81llA$material3_release  reason: not valid java name */
    public final void m1582setInversePrimary8_81llA$material3_release(long j11) {
        this.inversePrimary$delegate.setValue(Color.m2909boximpl(j11));
    }

    /* renamed from: setInverseSurface-8_81llA$material3_release  reason: not valid java name */
    public final void m1583setInverseSurface8_81llA$material3_release(long j11) {
        this.inverseSurface$delegate.setValue(Color.m2909boximpl(j11));
    }

    /* renamed from: setOnBackground-8_81llA$material3_release  reason: not valid java name */
    public final void m1584setOnBackground8_81llA$material3_release(long j11) {
        this.onBackground$delegate.setValue(Color.m2909boximpl(j11));
    }

    /* renamed from: setOnError-8_81llA$material3_release  reason: not valid java name */
    public final void m1585setOnError8_81llA$material3_release(long j11) {
        this.onError$delegate.setValue(Color.m2909boximpl(j11));
    }

    /* renamed from: setOnErrorContainer-8_81llA$material3_release  reason: not valid java name */
    public final void m1586setOnErrorContainer8_81llA$material3_release(long j11) {
        this.onErrorContainer$delegate.setValue(Color.m2909boximpl(j11));
    }

    /* renamed from: setOnPrimary-8_81llA$material3_release  reason: not valid java name */
    public final void m1587setOnPrimary8_81llA$material3_release(long j11) {
        this.onPrimary$delegate.setValue(Color.m2909boximpl(j11));
    }

    /* renamed from: setOnPrimaryContainer-8_81llA$material3_release  reason: not valid java name */
    public final void m1588setOnPrimaryContainer8_81llA$material3_release(long j11) {
        this.onPrimaryContainer$delegate.setValue(Color.m2909boximpl(j11));
    }

    /* renamed from: setOnSecondary-8_81llA$material3_release  reason: not valid java name */
    public final void m1589setOnSecondary8_81llA$material3_release(long j11) {
        this.onSecondary$delegate.setValue(Color.m2909boximpl(j11));
    }

    /* renamed from: setOnSecondaryContainer-8_81llA$material3_release  reason: not valid java name */
    public final void m1590setOnSecondaryContainer8_81llA$material3_release(long j11) {
        this.onSecondaryContainer$delegate.setValue(Color.m2909boximpl(j11));
    }

    /* renamed from: setOnSurface-8_81llA$material3_release  reason: not valid java name */
    public final void m1591setOnSurface8_81llA$material3_release(long j11) {
        this.onSurface$delegate.setValue(Color.m2909boximpl(j11));
    }

    /* renamed from: setOnSurfaceVariant-8_81llA$material3_release  reason: not valid java name */
    public final void m1592setOnSurfaceVariant8_81llA$material3_release(long j11) {
        this.onSurfaceVariant$delegate.setValue(Color.m2909boximpl(j11));
    }

    /* renamed from: setOnTertiary-8_81llA$material3_release  reason: not valid java name */
    public final void m1593setOnTertiary8_81llA$material3_release(long j11) {
        this.onTertiary$delegate.setValue(Color.m2909boximpl(j11));
    }

    /* renamed from: setOnTertiaryContainer-8_81llA$material3_release  reason: not valid java name */
    public final void m1594setOnTertiaryContainer8_81llA$material3_release(long j11) {
        this.onTertiaryContainer$delegate.setValue(Color.m2909boximpl(j11));
    }

    /* renamed from: setOutline-8_81llA$material3_release  reason: not valid java name */
    public final void m1595setOutline8_81llA$material3_release(long j11) {
        this.outline$delegate.setValue(Color.m2909boximpl(j11));
    }

    /* renamed from: setOutlineVariant-8_81llA$material3_release  reason: not valid java name */
    public final void m1596setOutlineVariant8_81llA$material3_release(long j11) {
        this.outlineVariant$delegate.setValue(Color.m2909boximpl(j11));
    }

    /* renamed from: setPrimary-8_81llA$material3_release  reason: not valid java name */
    public final void m1597setPrimary8_81llA$material3_release(long j11) {
        this.primary$delegate.setValue(Color.m2909boximpl(j11));
    }

    /* renamed from: setPrimaryContainer-8_81llA$material3_release  reason: not valid java name */
    public final void m1598setPrimaryContainer8_81llA$material3_release(long j11) {
        this.primaryContainer$delegate.setValue(Color.m2909boximpl(j11));
    }

    /* renamed from: setScrim-8_81llA$material3_release  reason: not valid java name */
    public final void m1599setScrim8_81llA$material3_release(long j11) {
        this.scrim$delegate.setValue(Color.m2909boximpl(j11));
    }

    /* renamed from: setSecondary-8_81llA$material3_release  reason: not valid java name */
    public final void m1600setSecondary8_81llA$material3_release(long j11) {
        this.secondary$delegate.setValue(Color.m2909boximpl(j11));
    }

    /* renamed from: setSecondaryContainer-8_81llA$material3_release  reason: not valid java name */
    public final void m1601setSecondaryContainer8_81llA$material3_release(long j11) {
        this.secondaryContainer$delegate.setValue(Color.m2909boximpl(j11));
    }

    /* renamed from: setSurface-8_81llA$material3_release  reason: not valid java name */
    public final void m1602setSurface8_81llA$material3_release(long j11) {
        this.surface$delegate.setValue(Color.m2909boximpl(j11));
    }

    /* renamed from: setSurfaceTint-8_81llA$material3_release  reason: not valid java name */
    public final void m1603setSurfaceTint8_81llA$material3_release(long j11) {
        this.surfaceTint$delegate.setValue(Color.m2909boximpl(j11));
    }

    /* renamed from: setSurfaceVariant-8_81llA$material3_release  reason: not valid java name */
    public final void m1604setSurfaceVariant8_81llA$material3_release(long j11) {
        this.surfaceVariant$delegate.setValue(Color.m2909boximpl(j11));
    }

    /* renamed from: setTertiary-8_81llA$material3_release  reason: not valid java name */
    public final void m1605setTertiary8_81llA$material3_release(long j11) {
        this.tertiary$delegate.setValue(Color.m2909boximpl(j11));
    }

    /* renamed from: setTertiaryContainer-8_81llA$material3_release  reason: not valid java name */
    public final void m1606setTertiaryContainer8_81llA$material3_release(long j11) {
        this.tertiaryContainer$delegate.setValue(Color.m2909boximpl(j11));
    }

    @NotNull
    public String toString() {
        return "ColorScheme(primary=" + Color.m2927toStringimpl(m1568getPrimary0d7_KjU()) + "onPrimary=" + Color.m2927toStringimpl(m1558getOnPrimary0d7_KjU()) + "primaryContainer=" + Color.m2927toStringimpl(m1569getPrimaryContainer0d7_KjU()) + "onPrimaryContainer=" + Color.m2927toStringimpl(m1559getOnPrimaryContainer0d7_KjU()) + "inversePrimary=" + Color.m2927toStringimpl(m1553getInversePrimary0d7_KjU()) + "secondary=" + Color.m2927toStringimpl(m1571getSecondary0d7_KjU()) + "onSecondary=" + Color.m2927toStringimpl(m1560getOnSecondary0d7_KjU()) + "secondaryContainer=" + Color.m2927toStringimpl(m1572getSecondaryContainer0d7_KjU()) + "onSecondaryContainer=" + Color.m2927toStringimpl(m1561getOnSecondaryContainer0d7_KjU()) + "tertiary=" + Color.m2927toStringimpl(m1576getTertiary0d7_KjU()) + "onTertiary=" + Color.m2927toStringimpl(m1564getOnTertiary0d7_KjU()) + "tertiaryContainer=" + Color.m2927toStringimpl(m1577getTertiaryContainer0d7_KjU()) + "onTertiaryContainer=" + Color.m2927toStringimpl(m1565getOnTertiaryContainer0d7_KjU()) + "background=" + Color.m2927toStringimpl(m1549getBackground0d7_KjU()) + "onBackground=" + Color.m2927toStringimpl(m1555getOnBackground0d7_KjU()) + "surface=" + Color.m2927toStringimpl(m1573getSurface0d7_KjU()) + "onSurface=" + Color.m2927toStringimpl(m1562getOnSurface0d7_KjU()) + "surfaceVariant=" + Color.m2927toStringimpl(m1575getSurfaceVariant0d7_KjU()) + "onSurfaceVariant=" + Color.m2927toStringimpl(m1563getOnSurfaceVariant0d7_KjU()) + "surfaceTint=" + Color.m2927toStringimpl(m1574getSurfaceTint0d7_KjU()) + "inverseSurface=" + Color.m2927toStringimpl(m1554getInverseSurface0d7_KjU()) + "inverseOnSurface=" + Color.m2927toStringimpl(m1552getInverseOnSurface0d7_KjU()) + "error=" + Color.m2927toStringimpl(m1550getError0d7_KjU()) + "onError=" + Color.m2927toStringimpl(m1556getOnError0d7_KjU()) + "errorContainer=" + Color.m2927toStringimpl(m1551getErrorContainer0d7_KjU()) + "onErrorContainer=" + Color.m2927toStringimpl(m1557getOnErrorContainer0d7_KjU()) + "outline=" + Color.m2927toStringimpl(m1566getOutline0d7_KjU()) + "outlineVariant=" + Color.m2927toStringimpl(m1567getOutlineVariant0d7_KjU()) + "scrim=" + Color.m2927toStringimpl(m1570getScrim0d7_KjU()) + ')';
    }
}
