package androidx.compose.ui.graphics.vector;

import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.unit.Dp;
import java.util.ArrayList;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import n.e;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Immutable
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u0000 *2\u00020\u0001:\u0002)*BR\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011ø\u0001\u0000¢\u0006\u0002\u0010\u0012J\u0013\u0010%\u001a\u00020\u00112\b\u0010&\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010'\u001a\u00020(H\u0016R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0006\u001a\u00020\u0005ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0004\u001a\u00020\u0005ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0018\u0010\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u001c\u0010\u000e\u001a\u00020\u000fø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b\u001d\u0010\u001eR\u001c\u0010\f\u001a\u00020\rø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b \u0010!R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0016R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0016\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006+"}, d2 = {"Landroidx/compose/ui/graphics/vector/ImageVector;", "", "name", "", "defaultWidth", "Landroidx/compose/ui/unit/Dp;", "defaultHeight", "viewportWidth", "", "viewportHeight", "root", "Landroidx/compose/ui/graphics/vector/VectorGroup;", "tintColor", "Landroidx/compose/ui/graphics/Color;", "tintBlendMode", "Landroidx/compose/ui/graphics/BlendMode;", "autoMirror", "", "(Ljava/lang/String;FFFFLandroidx/compose/ui/graphics/vector/VectorGroup;JIZLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getAutoMirror", "()Z", "getDefaultHeight-D9Ej5fM", "()F", "F", "getDefaultWidth-D9Ej5fM", "getName", "()Ljava/lang/String;", "getRoot", "()Landroidx/compose/ui/graphics/vector/VectorGroup;", "getTintBlendMode-0nO6VwU", "()I", "I", "getTintColor-0d7_KjU", "()J", "J", "getViewportHeight", "getViewportWidth", "equals", "other", "hashCode", "", "Builder", "Companion", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ImageVector {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final boolean autoMirror;
    private final float defaultHeight;
    private final float defaultWidth;
    @NotNull

    /* renamed from: name  reason: collision with root package name */
    private final String f9660name;
    @NotNull
    private final VectorGroup root;
    private final int tintBlendMode;
    private final long tintColor;
    private final float viewportHeight;
    private final float viewportWidth;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Landroidx/compose/ui/graphics/vector/ImageVector$Companion;", "", "()V", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private ImageVector(String str, float f11, float f12, float f13, float f14, VectorGroup vectorGroup, long j11, int i11, boolean z11) {
        this.f9660name = str;
        this.defaultWidth = f11;
        this.defaultHeight = f12;
        this.viewportWidth = f13;
        this.viewportHeight = f14;
        this.root = vectorGroup;
        this.tintColor = j11;
        this.tintBlendMode = i11;
        this.autoMirror = z11;
    }

    public /* synthetic */ ImageVector(String str, float f11, float f12, float f13, float f14, VectorGroup vectorGroup, long j11, int i11, boolean z11, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, f11, f12, f13, f14, vectorGroup, j11, i11, z11);
    }

    public boolean equals(@Nullable Object obj) {
        boolean z11;
        boolean z12;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ImageVector)) {
            return false;
        }
        ImageVector imageVector = (ImageVector) obj;
        if (!Intrinsics.areEqual((Object) this.f9660name, (Object) imageVector.f9660name) || !Dp.m5483equalsimpl0(this.defaultWidth, imageVector.defaultWidth) || !Dp.m5483equalsimpl0(this.defaultHeight, imageVector.defaultHeight)) {
            return false;
        }
        if (this.viewportWidth == imageVector.viewportWidth) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11) {
            return false;
        }
        if (this.viewportHeight == imageVector.viewportHeight) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (z12 && Intrinsics.areEqual((Object) this.root, (Object) imageVector.root) && Color.m2920equalsimpl0(this.tintColor, imageVector.tintColor) && BlendMode.m2826equalsimpl0(this.tintBlendMode, imageVector.tintBlendMode) && this.autoMirror == imageVector.autoMirror) {
            return true;
        }
        return false;
    }

    public final boolean getAutoMirror() {
        return this.autoMirror;
    }

    /* renamed from: getDefaultHeight-D9Ej5fM  reason: not valid java name */
    public final float m3518getDefaultHeightD9Ej5fM() {
        return this.defaultHeight;
    }

    /* renamed from: getDefaultWidth-D9Ej5fM  reason: not valid java name */
    public final float m3519getDefaultWidthD9Ej5fM() {
        return this.defaultWidth;
    }

    @NotNull
    public final String getName() {
        return this.f9660name;
    }

    @NotNull
    public final VectorGroup getRoot() {
        return this.root;
    }

    /* renamed from: getTintBlendMode-0nO6VwU  reason: not valid java name */
    public final int m3520getTintBlendMode0nO6VwU() {
        return this.tintBlendMode;
    }

    /* renamed from: getTintColor-0d7_KjU  reason: not valid java name */
    public final long m3521getTintColor0d7_KjU() {
        return this.tintColor;
    }

    public final float getViewportHeight() {
        return this.viewportHeight;
    }

    public final float getViewportWidth() {
        return this.viewportWidth;
    }

    public int hashCode() {
        return (((((((((((((((this.f9660name.hashCode() * 31) + Dp.m5484hashCodeimpl(this.defaultWidth)) * 31) + Dp.m5484hashCodeimpl(this.defaultHeight)) * 31) + Float.floatToIntBits(this.viewportWidth)) * 31) + Float.floatToIntBits(this.viewportHeight)) * 31) + this.root.hashCode()) * 31) + Color.m2926hashCodeimpl(this.tintColor)) * 31) + BlendMode.m2827hashCodeimpl(this.tintBlendMode)) * 31) + e.a(this.autoMirror);
    }

    @StabilityInferred(parameters = 0)
    @Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001DBH\b\u0017\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\rø\u0001\u0000¢\u0006\u0002\u0010\u000eBP\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010ø\u0001\u0000¢\u0006\u0002\u0010\u0011Jf\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u001f\u001a\u00020\b2\b\b\u0002\u0010 \u001a\u00020\b2\b\b\u0002\u0010!\u001a\u00020\b2\b\b\u0002\u0010\"\u001a\u00020\b2\b\b\u0002\u0010#\u001a\u00020\b2\b\b\u0002\u0010$\u001a\u00020\b2\b\b\u0002\u0010%\u001a\u00020\b2\u000e\b\u0002\u0010&\u001a\b\u0012\u0004\u0012\u00020(0'J§\u0001\u0010)\u001a\u00020\u00002\f\u0010*\u001a\b\u0012\u0004\u0012\u00020(0'2\b\b\u0002\u0010+\u001a\u00020,2\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010-\u001a\u0004\u0018\u00010.2\b\b\u0002\u0010/\u001a\u00020\b2\n\b\u0002\u00100\u001a\u0004\u0018\u00010.2\b\b\u0002\u00101\u001a\u00020\b2\b\b\u0002\u00102\u001a\u00020\b2\b\b\u0002\u00103\u001a\u0002042\b\b\u0002\u00105\u001a\u0002062\b\b\u0002\u00107\u001a\u00020\b2\b\b\u0002\u00108\u001a\u00020\b2\b\b\u0002\u00109\u001a\u00020\b2\b\b\u0002\u0010:\u001a\u00020\bø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b;\u0010<J\u0006\u0010=\u001a\u00020>J\u0006\u0010?\u001a\u00020\u0000J\b\u0010@\u001a\u00020AH\u0002J\f\u0010B\u001a\u00020C*\u00020\u0013H\u0002R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\u00020\u00138BX\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0019\u0010\u0006\u001a\u00020\u0005X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0016R\u0019\u0010\u0004\u001a\u00020\u0005X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00130\u0019X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u0019\u0010\f\u001a\u00020\rX\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u001cR\u0019\u0010\n\u001a\u00020\u000bX\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u001dR\u000e\u0010\t\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006E"}, d2 = {"Landroidx/compose/ui/graphics/vector/ImageVector$Builder;", "", "name", "", "defaultWidth", "Landroidx/compose/ui/unit/Dp;", "defaultHeight", "viewportWidth", "", "viewportHeight", "tintColor", "Landroidx/compose/ui/graphics/Color;", "tintBlendMode", "Landroidx/compose/ui/graphics/BlendMode;", "(Ljava/lang/String;FFFFJILkotlin/jvm/internal/DefaultConstructorMarker;)V", "autoMirror", "", "(Ljava/lang/String;FFFFJIZLkotlin/jvm/internal/DefaultConstructorMarker;)V", "currentGroup", "Landroidx/compose/ui/graphics/vector/ImageVector$Builder$GroupParams;", "getCurrentGroup", "()Landroidx/compose/ui/graphics/vector/ImageVector$Builder$GroupParams;", "F", "isConsumed", "nodes", "Landroidx/compose/ui/graphics/vector/Stack;", "Ljava/util/ArrayList;", "root", "I", "J", "addGroup", "rotate", "pivotX", "pivotY", "scaleX", "scaleY", "translationX", "translationY", "clipPathData", "", "Landroidx/compose/ui/graphics/vector/PathNode;", "addPath", "pathData", "pathFillType", "Landroidx/compose/ui/graphics/PathFillType;", "fill", "Landroidx/compose/ui/graphics/Brush;", "fillAlpha", "stroke", "strokeAlpha", "strokeLineWidth", "strokeLineCap", "Landroidx/compose/ui/graphics/StrokeCap;", "strokeLineJoin", "Landroidx/compose/ui/graphics/StrokeJoin;", "strokeLineMiter", "trimPathStart", "trimPathEnd", "trimPathOffset", "addPath-oIyEayM", "(Ljava/util/List;ILjava/lang/String;Landroidx/compose/ui/graphics/Brush;FLandroidx/compose/ui/graphics/Brush;FFIIFFFF)Landroidx/compose/ui/graphics/vector/ImageVector$Builder;", "build", "Landroidx/compose/ui/graphics/vector/ImageVector;", "clearGroup", "ensureNotConsumed", "", "asVectorGroup", "Landroidx/compose/ui/graphics/vector/VectorGroup;", "GroupParams", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Builder {
        public static final int $stable = 8;
        private final boolean autoMirror;
        private final float defaultHeight;
        private final float defaultWidth;
        private boolean isConsumed;
        @NotNull

        /* renamed from: name  reason: collision with root package name */
        private final String f9661name;
        @NotNull
        private final ArrayList nodes;
        @NotNull
        private GroupParams root;
        private final int tintBlendMode;
        private final long tintColor;
        private final float viewportHeight;
        private final float viewportWidth;

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "Replace with ImageVector.Builder that consumes an optional auto mirror parameter", replaceWith = @ReplaceWith(expression = "Builder(name, defaultWidth, defaultHeight, viewportWidth, viewportHeight, tintColor, tintBlendMode, false)", imports = {"androidx.compose.ui.graphics.vector"}))
        public /* synthetic */ Builder(String str, float f11, float f12, float f13, float f14, long j11, int i11, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, f11, f12, f13, f14, j11, i11);
        }

        private Builder(String str, float f11, float f12, float f13, float f14, long j11, int i11, boolean z11) {
            this.f9661name = str;
            this.defaultWidth = f11;
            this.defaultHeight = f12;
            this.viewportWidth = f13;
            this.viewportHeight = f14;
            this.tintColor = j11;
            this.tintBlendMode = i11;
            this.autoMirror = z11;
            ArrayList r12 = Stack.m3534constructorimpl$default((ArrayList) null, 1, (DefaultConstructorMarker) null);
            this.nodes = r12;
            GroupParams groupParams = new GroupParams((String) null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, (List) null, (List) null, 1023, (DefaultConstructorMarker) null);
            this.root = groupParams;
            Stack.m3541pushimpl(r12, groupParams);
        }

        public /* synthetic */ Builder(String str, float f11, float f12, float f13, float f14, long j11, int i11, boolean z11, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, f11, f12, f13, f14, j11, i11, z11);
        }

        public static /* synthetic */ Builder addGroup$default(Builder builder, String str, float f11, float f12, float f13, float f14, float f15, float f16, float f17, List list, int i11, Object obj) {
            String str2;
            float f18;
            float f19;
            float f21;
            float f22;
            float f23;
            List list2;
            int i12 = i11;
            if ((i12 & 1) != 0) {
                str2 = "";
            } else {
                str2 = str;
            }
            float f24 = 0.0f;
            if ((i12 & 2) != 0) {
                f18 = 0.0f;
            } else {
                f18 = f11;
            }
            if ((i12 & 4) != 0) {
                f19 = 0.0f;
            } else {
                f19 = f12;
            }
            if ((i12 & 8) != 0) {
                f21 = 0.0f;
            } else {
                f21 = f13;
            }
            float f25 = 1.0f;
            if ((i12 & 16) != 0) {
                f22 = 1.0f;
            } else {
                f22 = f14;
            }
            if ((i12 & 32) == 0) {
                f25 = f15;
            }
            if ((i12 & 64) != 0) {
                f23 = 0.0f;
            } else {
                f23 = f16;
            }
            if ((i12 & 128) == 0) {
                f24 = f17;
            }
            if ((i12 & 256) != 0) {
                list2 = VectorKt.getEmptyPath();
            } else {
                list2 = list;
            }
            return builder.addGroup(str2, f18, f19, f21, f22, f25, f23, f24, list2);
        }

        /* renamed from: addPath-oIyEayM$default  reason: not valid java name */
        public static /* synthetic */ Builder m3522addPathoIyEayM$default(Builder builder, List list, int i11, String str, Brush brush, float f11, Brush brush2, float f12, float f13, int i12, int i13, float f14, float f15, float f16, float f17, int i14, Object obj) {
            int i15;
            String str2;
            Brush brush3;
            float f18;
            float f19;
            float f21;
            int i16;
            int i17;
            float f22;
            float f23;
            int i18 = i14;
            if ((i18 & 2) != 0) {
                i15 = VectorKt.getDefaultFillType();
            } else {
                i15 = i11;
            }
            if ((i18 & 4) != 0) {
                str2 = "";
            } else {
                str2 = str;
            }
            Brush brush4 = null;
            if ((i18 & 8) != 0) {
                brush3 = null;
            } else {
                brush3 = brush;
            }
            float f24 = 1.0f;
            if ((i18 & 16) != 0) {
                f18 = 1.0f;
            } else {
                f18 = f11;
            }
            if ((i18 & 32) == 0) {
                brush4 = brush2;
            }
            if ((i18 & 64) != 0) {
                f19 = 1.0f;
            } else {
                f19 = f12;
            }
            float f25 = 0.0f;
            if ((i18 & 128) != 0) {
                f21 = 0.0f;
            } else {
                f21 = f13;
            }
            if ((i18 & 256) != 0) {
                i16 = VectorKt.getDefaultStrokeLineCap();
            } else {
                i16 = i12;
            }
            if ((i18 & 512) != 0) {
                i17 = VectorKt.getDefaultStrokeLineJoin();
            } else {
                i17 = i13;
            }
            if ((i18 & 1024) != 0) {
                f22 = 4.0f;
            } else {
                f22 = f14;
            }
            if ((i18 & 2048) != 0) {
                f23 = 0.0f;
            } else {
                f23 = f15;
            }
            if ((i18 & 4096) == 0) {
                f24 = f16;
            }
            if ((i18 & 8192) == 0) {
                f25 = f17;
            }
            return builder.m3523addPathoIyEayM(list, i15, str2, brush3, f18, brush4, f19, f21, i16, i17, f22, f23, f24, f25);
        }

        private final VectorGroup asVectorGroup(GroupParams groupParams) {
            return new VectorGroup(groupParams.getName(), groupParams.getRotate(), groupParams.getPivotX(), groupParams.getPivotY(), groupParams.getScaleX(), groupParams.getScaleY(), groupParams.getTranslationX(), groupParams.getTranslationY(), groupParams.getClipPathData(), groupParams.getChildren());
        }

        private final void ensureNotConsumed() {
            if (!(!this.isConsumed)) {
                throw new IllegalStateException("ImageVector.Builder is single use, create a new instance to create a new ImageVector".toString());
            }
        }

        private final GroupParams getCurrentGroup() {
            return (GroupParams) Stack.m3539peekimpl(this.nodes);
        }

        @NotNull
        public final Builder addGroup(@NotNull String str, float f11, float f12, float f13, float f14, float f15, float f16, float f17, @NotNull List<? extends PathNode> list) {
            String str2 = str;
            Intrinsics.checkNotNullParameter(str2, "name");
            List<? extends PathNode> list2 = list;
            Intrinsics.checkNotNullParameter(list2, "clipPathData");
            ensureNotConsumed();
            Stack.m3541pushimpl(this.nodes, new GroupParams(str2, f11, f12, f13, f14, f15, f16, f17, list2, (List) null, 512, (DefaultConstructorMarker) null));
            return this;
        }

        @NotNull
        /* renamed from: addPath-oIyEayM  reason: not valid java name */
        public final Builder m3523addPathoIyEayM(@NotNull List<? extends PathNode> list, int i11, @NotNull String str, @Nullable Brush brush, float f11, @Nullable Brush brush2, float f12, float f13, int i12, int i13, float f14, float f15, float f16, float f17) {
            List<? extends PathNode> list2 = list;
            Intrinsics.checkNotNullParameter(list2, "pathData");
            String str2 = str;
            Intrinsics.checkNotNullParameter(str2, "name");
            ensureNotConsumed();
            List<VectorNode> children = getCurrentGroup().getChildren();
            VectorPath vectorPath = r1;
            VectorPath vectorPath2 = new VectorPath(str2, list2, i11, brush, f11, brush2, f12, f13, i12, i13, f14, f15, f16, f17, (DefaultConstructorMarker) null);
            children.add(vectorPath);
            return this;
        }

        @NotNull
        public final ImageVector build() {
            ensureNotConsumed();
            while (Stack.m3537getSizeimpl(this.nodes) > 1) {
                clearGroup();
            }
            ImageVector imageVector = new ImageVector(this.f9661name, this.defaultWidth, this.defaultHeight, this.viewportWidth, this.viewportHeight, asVectorGroup(this.root), this.tintColor, this.tintBlendMode, this.autoMirror, (DefaultConstructorMarker) null);
            this.isConsumed = true;
            return imageVector;
        }

        @NotNull
        public final Builder clearGroup() {
            ensureNotConsumed();
            getCurrentGroup().getChildren().add(asVectorGroup((GroupParams) Stack.m3540popimpl(this.nodes)));
            return this;
        }

        @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u001c\b\u0002\u0018\u00002\u00020\u0001Bu\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\u0002\u0010\u0012R \u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R \u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0014\"\u0004\b\u0018\u0010\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u0006\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010\u0007\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001e\"\u0004\b\"\u0010 R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001e\"\u0004\b$\u0010 R\u001a\u0010\b\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u001e\"\u0004\b&\u0010 R\u001a\u0010\t\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u001e\"\u0004\b(\u0010 R\u001a\u0010\n\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u001e\"\u0004\b*\u0010 R\u001a\u0010\u000b\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u001e\"\u0004\b,\u0010 ¨\u0006-"}, d2 = {"Landroidx/compose/ui/graphics/vector/ImageVector$Builder$GroupParams;", "", "name", "", "rotate", "", "pivotX", "pivotY", "scaleX", "scaleY", "translationX", "translationY", "clipPathData", "", "Landroidx/compose/ui/graphics/vector/PathNode;", "children", "", "Landroidx/compose/ui/graphics/vector/VectorNode;", "(Ljava/lang/String;FFFFFFFLjava/util/List;Ljava/util/List;)V", "getChildren", "()Ljava/util/List;", "setChildren", "(Ljava/util/List;)V", "getClipPathData", "setClipPathData", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "getPivotX", "()F", "setPivotX", "(F)V", "getPivotY", "setPivotY", "getRotate", "setRotate", "getScaleX", "setScaleX", "getScaleY", "setScaleY", "getTranslationX", "setTranslationX", "getTranslationY", "setTranslationY", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class GroupParams {
            @NotNull
            private List<VectorNode> children;
            @NotNull
            private List<? extends PathNode> clipPathData;
            @NotNull

            /* renamed from: name  reason: collision with root package name */
            private String f9662name;
            private float pivotX;
            private float pivotY;
            private float rotate;
            private float scaleX;
            private float scaleY;
            private float translationX;
            private float translationY;

            public GroupParams() {
                this((String) null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, (List) null, (List) null, 1023, (DefaultConstructorMarker) null);
            }

            public GroupParams(@NotNull String str, float f11, float f12, float f13, float f14, float f15, float f16, float f17, @NotNull List<? extends PathNode> list, @NotNull List<VectorNode> list2) {
                Intrinsics.checkNotNullParameter(str, "name");
                Intrinsics.checkNotNullParameter(list, "clipPathData");
                Intrinsics.checkNotNullParameter(list2, "children");
                this.f9662name = str;
                this.rotate = f11;
                this.pivotX = f12;
                this.pivotY = f13;
                this.scaleX = f14;
                this.scaleY = f15;
                this.translationX = f16;
                this.translationY = f17;
                this.clipPathData = list;
                this.children = list2;
            }

            @NotNull
            public final List<VectorNode> getChildren() {
                return this.children;
            }

            @NotNull
            public final List<PathNode> getClipPathData() {
                return this.clipPathData;
            }

            @NotNull
            public final String getName() {
                return this.f9662name;
            }

            public final float getPivotX() {
                return this.pivotX;
            }

            public final float getPivotY() {
                return this.pivotY;
            }

            public final float getRotate() {
                return this.rotate;
            }

            public final float getScaleX() {
                return this.scaleX;
            }

            public final float getScaleY() {
                return this.scaleY;
            }

            public final float getTranslationX() {
                return this.translationX;
            }

            public final float getTranslationY() {
                return this.translationY;
            }

            public final void setChildren(@NotNull List<VectorNode> list) {
                Intrinsics.checkNotNullParameter(list, "<set-?>");
                this.children = list;
            }

            public final void setClipPathData(@NotNull List<? extends PathNode> list) {
                Intrinsics.checkNotNullParameter(list, "<set-?>");
                this.clipPathData = list;
            }

            public final void setName(@NotNull String str) {
                Intrinsics.checkNotNullParameter(str, "<set-?>");
                this.f9662name = str;
            }

            public final void setPivotX(float f11) {
                this.pivotX = f11;
            }

            public final void setPivotY(float f11) {
                this.pivotY = f11;
            }

            public final void setRotate(float f11) {
                this.rotate = f11;
            }

            public final void setScaleX(float f11) {
                this.scaleX = f11;
            }

            public final void setScaleY(float f11) {
                this.scaleY = f11;
            }

            public final void setTranslationX(float f11) {
                this.translationX = f11;
            }

            public final void setTranslationY(float f11) {
                this.translationY = f11;
            }

            /* JADX WARNING: Illegal instructions before constructor call */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public /* synthetic */ GroupParams(java.lang.String r11, float r12, float r13, float r14, float r15, float r16, float r17, float r18, java.util.List r19, java.util.List r20, int r21, kotlin.jvm.internal.DefaultConstructorMarker r22) {
                /*
                    r10 = this;
                    r0 = r21
                    r1 = r0 & 1
                    if (r1 == 0) goto L_0x0009
                    java.lang.String r1 = ""
                    goto L_0x000a
                L_0x0009:
                    r1 = r11
                L_0x000a:
                    r2 = r0 & 2
                    r3 = 0
                    if (r2 == 0) goto L_0x0011
                    r2 = r3
                    goto L_0x0012
                L_0x0011:
                    r2 = r12
                L_0x0012:
                    r4 = r0 & 4
                    if (r4 == 0) goto L_0x0018
                    r4 = r3
                    goto L_0x0019
                L_0x0018:
                    r4 = r13
                L_0x0019:
                    r5 = r0 & 8
                    if (r5 == 0) goto L_0x001f
                    r5 = r3
                    goto L_0x0020
                L_0x001f:
                    r5 = r14
                L_0x0020:
                    r6 = r0 & 16
                    r7 = 1065353216(0x3f800000, float:1.0)
                    if (r6 == 0) goto L_0x0028
                    r6 = r7
                    goto L_0x0029
                L_0x0028:
                    r6 = r15
                L_0x0029:
                    r8 = r0 & 32
                    if (r8 == 0) goto L_0x002e
                    goto L_0x0030
                L_0x002e:
                    r7 = r16
                L_0x0030:
                    r8 = r0 & 64
                    if (r8 == 0) goto L_0x0036
                    r8 = r3
                    goto L_0x0038
                L_0x0036:
                    r8 = r17
                L_0x0038:
                    r9 = r0 & 128(0x80, float:1.794E-43)
                    if (r9 == 0) goto L_0x003d
                    goto L_0x003f
                L_0x003d:
                    r3 = r18
                L_0x003f:
                    r9 = r0 & 256(0x100, float:3.59E-43)
                    if (r9 == 0) goto L_0x0048
                    java.util.List r9 = androidx.compose.ui.graphics.vector.VectorKt.getEmptyPath()
                    goto L_0x004a
                L_0x0048:
                    r9 = r19
                L_0x004a:
                    r0 = r0 & 512(0x200, float:7.175E-43)
                    if (r0 == 0) goto L_0x0054
                    java.util.ArrayList r0 = new java.util.ArrayList
                    r0.<init>()
                    goto L_0x0056
                L_0x0054:
                    r0 = r20
                L_0x0056:
                    r11 = r10
                    r12 = r1
                    r13 = r2
                    r14 = r4
                    r15 = r5
                    r16 = r6
                    r17 = r7
                    r18 = r8
                    r19 = r3
                    r20 = r9
                    r21 = r0
                    r11.<init>(r12, r13, r14, r15, r16, r17, r18, r19, r20, r21)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.vector.ImageVector.Builder.GroupParams.<init>(java.lang.String, float, float, float, float, float, float, float, java.util.List, java.util.List, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
            }
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public /* synthetic */ Builder(java.lang.String r14, float r15, float r16, float r17, float r18, long r19, int r21, boolean r22, int r23, kotlin.jvm.internal.DefaultConstructorMarker r24) {
            /*
                r13 = this;
                r0 = r23
                r1 = r0 & 1
                if (r1 == 0) goto L_0x000a
                java.lang.String r1 = ""
                r3 = r1
                goto L_0x000b
            L_0x000a:
                r3 = r14
            L_0x000b:
                r1 = r0 & 32
                if (r1 == 0) goto L_0x0017
                androidx.compose.ui.graphics.Color$Companion r1 = androidx.compose.ui.graphics.Color.Companion
                long r1 = r1.m2955getUnspecified0d7_KjU()
                r8 = r1
                goto L_0x0019
            L_0x0017:
                r8 = r19
            L_0x0019:
                r1 = r0 & 64
                if (r1 == 0) goto L_0x0025
                androidx.compose.ui.graphics.BlendMode$Companion r1 = androidx.compose.ui.graphics.BlendMode.Companion
                int r1 = r1.m2855getSrcIn0nO6VwU()
                r10 = r1
                goto L_0x0027
            L_0x0025:
                r10 = r21
            L_0x0027:
                r0 = r0 & 128(0x80, float:1.794E-43)
                if (r0 == 0) goto L_0x002e
                r0 = 0
                r11 = r0
                goto L_0x0030
            L_0x002e:
                r11 = r22
            L_0x0030:
                r12 = 0
                r2 = r13
                r4 = r15
                r5 = r16
                r6 = r17
                r7 = r18
                r2.<init>((java.lang.String) r3, (float) r4, (float) r5, (float) r6, (float) r7, (long) r8, (int) r10, (boolean) r11, (kotlin.jvm.internal.DefaultConstructorMarker) r12)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.vector.ImageVector.Builder.<init>(java.lang.String, float, float, float, float, long, int, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Builder(String str, float f11, float f12, float f13, float f14, long j11, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
            this((i12 & 1) != 0 ? "" : str, f11, f12, f13, f14, (i12 & 32) != 0 ? Color.Companion.m2955getUnspecified0d7_KjU() : j11, (i12 & 64) != 0 ? BlendMode.Companion.m2855getSrcIn0nO6VwU() : i11, (DefaultConstructorMarker) null);
        }

        private Builder(String str, float f11, float f12, float f13, float f14, long j11, int i11) {
            this(str, f11, f12, f13, f14, j11, i11, false, (DefaultConstructorMarker) null);
        }
    }
}
