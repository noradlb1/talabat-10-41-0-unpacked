package androidx.compose.ui.graphics.vector;

import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Matrix;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawTransform;
import f0.c;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b&\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010C\u001a\u00020\u00132\u0006\u0010D\u001a\u00020#2\u0006\u0010E\u001a\u00020\u0001J\u001e\u0010F\u001a\u00020\u00132\u0006\u0010G\u001a\u00020#2\u0006\u0010H\u001a\u00020#2\u0006\u0010I\u001a\u00020#J\u0016\u0010J\u001a\u00020\u00132\u0006\u0010D\u001a\u00020#2\u0006\u0010I\u001a\u00020#J\b\u0010K\u001a\u00020\u001cH\u0016J\b\u0010L\u001a\u00020\u0013H\u0002J\b\u0010M\u001a\u00020\u0013H\u0002J\f\u0010N\u001a\u00020\u0013*\u00020OH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R0\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001b\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0011R4\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00122\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012@PX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000R$\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0007\u001a\u00020\u001c@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0011\u0010\"\u001a\u00020#8F¢\u0006\u0006\u001a\u0004\b$\u0010%R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u000e¢\u0006\u0002\n\u0000R$\u0010)\u001a\u00020(2\u0006\u0010\u0007\u001a\u00020(@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R$\u0010.\u001a\u00020(2\u0006\u0010\u0007\u001a\u00020(@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010+\"\u0004\b0\u0010-R$\u00101\u001a\u00020(2\u0006\u0010\u0007\u001a\u00020(@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010+\"\u0004\b3\u0010-R$\u00104\u001a\u00020(2\u0006\u0010\u0007\u001a\u00020(@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010+\"\u0004\b6\u0010-R$\u00107\u001a\u00020(2\u0006\u0010\u0007\u001a\u00020(@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010+\"\u0004\b9\u0010-R$\u0010:\u001a\u00020(2\u0006\u0010\u0007\u001a\u00020(@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010+\"\u0004\b<\u0010-R$\u0010=\u001a\u00020(2\u0006\u0010\u0007\u001a\u00020(@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010+\"\u0004\b?\u0010-R\u0014\u0010@\u001a\u00020\u001a8BX\u0004¢\u0006\u0006\u001a\u0004\bA\u0010B\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006P"}, d2 = {"Landroidx/compose/ui/graphics/vector/GroupComponent;", "Landroidx/compose/ui/graphics/vector/VNode;", "()V", "children", "", "clipPath", "Landroidx/compose/ui/graphics/Path;", "value", "", "Landroidx/compose/ui/graphics/vector/PathNode;", "clipPathData", "getClipPathData", "()Ljava/util/List;", "setClipPathData", "(Ljava/util/List;)V", "groupMatrix", "Landroidx/compose/ui/graphics/Matrix;", "[F", "Lkotlin/Function0;", "", "invalidateListener", "getInvalidateListener$ui_release", "()Lkotlin/jvm/functions/Function0;", "setInvalidateListener$ui_release", "(Lkotlin/jvm/functions/Function0;)V", "isClipPathDirty", "", "isMatrixDirty", "", "name", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "numChildren", "", "getNumChildren", "()I", "parser", "Landroidx/compose/ui/graphics/vector/PathParser;", "", "pivotX", "getPivotX", "()F", "setPivotX", "(F)V", "pivotY", "getPivotY", "setPivotY", "rotation", "getRotation", "setRotation", "scaleX", "getScaleX", "setScaleX", "scaleY", "getScaleY", "setScaleY", "translationX", "getTranslationX", "setTranslationX", "translationY", "getTranslationY", "setTranslationY", "willClipPath", "getWillClipPath", "()Z", "insertAt", "index", "instance", "move", "from", "to", "count", "remove", "toString", "updateClipPath", "updateMatrix", "draw", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class GroupComponent extends VNode {
    @NotNull
    private final List<VNode> children = new ArrayList();
    @Nullable
    private Path clipPath;
    @NotNull
    private List<? extends PathNode> clipPathData = VectorKt.getEmptyPath();
    @Nullable
    private float[] groupMatrix;
    @Nullable
    private Function0<Unit> invalidateListener;
    private boolean isClipPathDirty = true;
    private boolean isMatrixDirty = true;
    @NotNull

    /* renamed from: name  reason: collision with root package name */
    private String f9659name = "";
    @Nullable
    private PathParser parser;
    private float pivotX;
    private float pivotY;
    private float rotation;
    private float scaleX = 1.0f;
    private float scaleY = 1.0f;
    private float translationX;
    private float translationY;

    public GroupComponent() {
        super((DefaultConstructorMarker) null);
    }

    private final boolean getWillClipPath() {
        return !this.clipPathData.isEmpty();
    }

    private final void updateClipPath() {
        if (getWillClipPath()) {
            PathParser pathParser = this.parser;
            if (pathParser == null) {
                pathParser = new PathParser();
                this.parser = pathParser;
            } else {
                pathParser.clear();
            }
            Path path = this.clipPath;
            if (path == null) {
                path = AndroidPath_androidKt.Path();
                this.clipPath = path;
            } else {
                path.reset();
            }
            pathParser.addPathNodes(this.clipPathData).toPath(path);
        }
    }

    private final void updateMatrix() {
        float[] fArr = this.groupMatrix;
        if (fArr == null) {
            fArr = Matrix.m3100constructorimpl$default((float[]) null, 1, (DefaultConstructorMarker) null);
            this.groupMatrix = fArr;
        } else {
            Matrix.m3109resetimpl(fArr);
        }
        Matrix.m3120translateimpl$default(fArr, this.pivotX + this.translationX, this.pivotY + this.translationY, 0.0f, 4, (Object) null);
        Matrix.m3112rotateZimpl(fArr, this.rotation);
        Matrix.m3113scaleimpl(fArr, this.scaleX, this.scaleY, 1.0f);
        Matrix.m3120translateimpl$default(fArr, -this.pivotX, -this.pivotY, 0.0f, 4, (Object) null);
    }

    public void draw(@NotNull DrawScope drawScope) {
        Intrinsics.checkNotNullParameter(drawScope, "<this>");
        if (this.isMatrixDirty) {
            updateMatrix();
            this.isMatrixDirty = false;
        }
        if (this.isClipPathDirty) {
            updateClipPath();
            this.isClipPathDirty = false;
        }
        DrawContext drawContext = drawScope.getDrawContext();
        long r22 = drawContext.m3403getSizeNHjbRc();
        drawContext.getCanvas().save();
        DrawTransform transform = drawContext.getTransform();
        float[] fArr = this.groupMatrix;
        if (fArr != null) {
            transform.m3480transform58bKbWc(Matrix.m3098boximpl(fArr).m3121unboximpl());
        }
        Path path = this.clipPath;
        if (getWillClipPath() && path != null) {
            c.c(transform, path, 0, 2, (Object) null);
        }
        List<VNode> list = this.children;
        int size = list.size();
        for (int i11 = 0; i11 < size; i11++) {
            list.get(i11).draw(drawScope);
        }
        drawContext.getCanvas().restore();
        drawContext.m3404setSizeuvyYCjk(r22);
    }

    @NotNull
    public final List<PathNode> getClipPathData() {
        return this.clipPathData;
    }

    @Nullable
    public Function0<Unit> getInvalidateListener$ui_release() {
        return this.invalidateListener;
    }

    @NotNull
    public final String getName() {
        return this.f9659name;
    }

    public final int getNumChildren() {
        return this.children.size();
    }

    public final float getPivotX() {
        return this.pivotX;
    }

    public final float getPivotY() {
        return this.pivotY;
    }

    public final float getRotation() {
        return this.rotation;
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

    public final void insertAt(int i11, @NotNull VNode vNode) {
        Intrinsics.checkNotNullParameter(vNode, "instance");
        if (i11 < getNumChildren()) {
            this.children.set(i11, vNode);
        } else {
            this.children.add(vNode);
        }
        vNode.setInvalidateListener$ui_release(getInvalidateListener$ui_release());
        invalidate();
    }

    public final void move(int i11, int i12, int i13) {
        int i14 = 0;
        if (i11 > i12) {
            while (i14 < i13) {
                this.children.remove(i11);
                this.children.add(i12, this.children.get(i11));
                i12++;
                i14++;
            }
        } else {
            while (i14 < i13) {
                this.children.remove(i11);
                this.children.add(i12 - 1, this.children.get(i11));
                i14++;
            }
        }
        invalidate();
    }

    public final void remove(int i11, int i12) {
        for (int i13 = 0; i13 < i12; i13++) {
            if (i11 < this.children.size()) {
                this.children.get(i11).setInvalidateListener$ui_release((Function0<Unit>) null);
                this.children.remove(i11);
            }
        }
        invalidate();
    }

    public final void setClipPathData(@NotNull List<? extends PathNode> list) {
        Intrinsics.checkNotNullParameter(list, "value");
        this.clipPathData = list;
        this.isClipPathDirty = true;
        invalidate();
    }

    public void setInvalidateListener$ui_release(@Nullable Function0<Unit> function0) {
        this.invalidateListener = function0;
        List<VNode> list = this.children;
        int size = list.size();
        for (int i11 = 0; i11 < size; i11++) {
            list.get(i11).setInvalidateListener$ui_release(function0);
        }
    }

    public final void setName(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "value");
        this.f9659name = str;
        invalidate();
    }

    public final void setPivotX(float f11) {
        this.pivotX = f11;
        this.isMatrixDirty = true;
        invalidate();
    }

    public final void setPivotY(float f11) {
        this.pivotY = f11;
        this.isMatrixDirty = true;
        invalidate();
    }

    public final void setRotation(float f11) {
        this.rotation = f11;
        this.isMatrixDirty = true;
        invalidate();
    }

    public final void setScaleX(float f11) {
        this.scaleX = f11;
        this.isMatrixDirty = true;
        invalidate();
    }

    public final void setScaleY(float f11) {
        this.scaleY = f11;
        this.isMatrixDirty = true;
        invalidate();
    }

    public final void setTranslationX(float f11) {
        this.translationX = f11;
        this.isMatrixDirty = true;
        invalidate();
    }

    public final void setTranslationY(float f11) {
        this.translationY = f11;
        this.isMatrixDirty = true;
        invalidate();
    }

    @NotNull
    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("VGroup: ");
        sb2.append(this.f9659name);
        List<VNode> list = this.children;
        int size = list.size();
        for (int i11 = 0; i11 < size; i11++) {
            sb2.append("\t");
            sb2.append(list.get(i11).toString());
            sb2.append(StringUtils.LF);
        }
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "sb.toString()");
        return sb3;
    }
}
