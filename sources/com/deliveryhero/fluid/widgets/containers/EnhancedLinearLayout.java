package com.deliveryhero.fluid.widgets.containers;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001)B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ \u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u0007H\u0002J \u0010\u001f\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u0007H\u0002J\u0010\u0010!\u001a\u00020\n2\u0006\u0010\"\u001a\u00020#H\u0014J\b\u0010$\u001a\u00020%H\u0014J\u0012\u0010&\u001a\u00020%2\b\u0010'\u001a\u0004\u0018\u00010#H\u0014J\u0018\u0010(\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u0007H\u0014R\u0014\u0010\t\u001a\u00020\n8BX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u000bR\u001e\u0010\f\u001a\u00020\n*\b\u0012\u0004\u0012\u00020\u000e0\r8BX\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0011\u001a\u00020\n*\b\u0012\u0004\u0012\u00020\u000e0\r8BX\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0010R\u0018\u0010\u0013\u001a\u00020\u0007*\u00020\u000e8BX\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0016\u001a\u00020\u0007*\u00020\u000e8BX\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0015R\u0018\u0010\u0018\u001a\u00020\u0007*\u00020\u000e8BX\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0015¨\u0006*"}, d2 = {"Lcom/deliveryhero/fluid/widgets/containers/EnhancedLinearLayout;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "isHorizontal", "", "()Z", "hasCompressionResistanceAmbiguity", "Lkotlin/sequences/Sequence;", "Landroid/view/View;", "getHasCompressionResistanceAmbiguity", "(Lkotlin/sequences/Sequence;)Z", "hasExpansionResistanceAmbiguity", "getHasExpansionResistanceAmbiguity", "mainAxisSize", "getMainAxisSize", "(Landroid/view/View;)I", "measuredMainAxisSize", "getMeasuredMainAxisSize", "measuredMainAxisSizeWithoutPadding", "getMeasuredMainAxisSizeWithoutPadding", "applyCompressionResistancePriority", "", "negativeFreeSpace", "widthMeasureSpec", "heightMeasureSpec", "applyExpansionResistancePriority", "freeSpace", "checkLayoutParams", "p", "Landroid/view/ViewGroup$LayoutParams;", "generateDefaultLayoutParams", "Landroid/widget/LinearLayout$LayoutParams;", "generateLayoutParams", "lp", "onMeasure", "LayoutParams", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class EnhancedLinearLayout extends LinearLayout {
    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public EnhancedLinearLayout(@NotNull Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public EnhancedLinearLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ EnhancedLinearLayout(Context context, AttributeSet attributeSet, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v6, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: android.view.View} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v7, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v7, resolved type: android.view.View} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v8, resolved type: android.view.View} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void applyCompressionResistancePriority(int r10, int r11, int r12) {
        /*
            r9 = this;
            r0 = 0
            if (r10 >= 0) goto L_0x0005
            r1 = 1
            goto L_0x0006
        L_0x0005:
            r1 = r0
        L_0x0006:
            if (r1 == 0) goto L_0x00b9
            kotlin.sequences.Sequence r1 = androidx.core.view.ViewGroupKt.getChildren(r9)
            boolean r1 = r9.getHasCompressionResistanceAmbiguity(r1)
            if (r1 == 0) goto L_0x0013
            return
        L_0x0013:
            java.util.LinkedHashSet r1 = new java.util.LinkedHashSet
            r1.<init>()
        L_0x0018:
            if (r10 >= 0) goto L_0x00b8
            kotlin.sequences.Sequence r2 = androidx.core.view.ViewGroupKt.getChildren(r9)
            com.deliveryhero.fluid.widgets.containers.EnhancedLinearLayout$applyCompressionResistancePriority$minChild$1 r3 = new com.deliveryhero.fluid.widgets.containers.EnhancedLinearLayout$applyCompressionResistancePriority$minChild$1
            r3.<init>(r1, r9)
            kotlin.sequences.Sequence r2 = kotlin.sequences.SequencesKt___SequencesKt.filter(r2, r3)
            java.util.Iterator r2 = r2.iterator()
            boolean r3 = r2.hasNext()
            if (r3 != 0) goto L_0x0033
            r2 = 0
            goto L_0x006e
        L_0x0033:
            java.lang.Object r3 = r2.next()
            boolean r4 = r2.hasNext()
            if (r4 != 0) goto L_0x003f
        L_0x003d:
            r2 = r3
            goto L_0x006e
        L_0x003f:
            r4 = r3
            android.view.View r4 = (android.view.View) r4
            android.view.ViewGroup$LayoutParams r4 = r4.getLayoutParams()
            java.lang.String r5 = "null cannot be cast to non-null type com.deliveryhero.fluid.widgets.containers.EnhancedLinearLayout.LayoutParams"
            if (r4 == 0) goto L_0x00b2
            com.deliveryhero.fluid.widgets.containers.EnhancedLinearLayout$LayoutParams r4 = (com.deliveryhero.fluid.widgets.containers.EnhancedLinearLayout.LayoutParams) r4
            int r4 = r4.getCompressionResistancePriority()
        L_0x0050:
            java.lang.Object r6 = r2.next()
            r7 = r6
            android.view.View r7 = (android.view.View) r7
            android.view.ViewGroup$LayoutParams r7 = r7.getLayoutParams()
            if (r7 == 0) goto L_0x00ac
            com.deliveryhero.fluid.widgets.containers.EnhancedLinearLayout$LayoutParams r7 = (com.deliveryhero.fluid.widgets.containers.EnhancedLinearLayout.LayoutParams) r7
            int r7 = r7.getCompressionResistancePriority()
            if (r4 <= r7) goto L_0x0067
            r3 = r6
            r4 = r7
        L_0x0067:
            boolean r6 = r2.hasNext()
            if (r6 != 0) goto L_0x0050
            goto L_0x003d
        L_0x006e:
            r4 = r2
            android.view.View r4 = (android.view.View) r4
            if (r4 != 0) goto L_0x0074
            return
        L_0x0074:
            int r2 = r9.getMeasuredMainAxisSize(r4)
            int r10 = r10 + r2
            android.view.ViewGroup$LayoutParams r2 = r4.getLayoutParams()
            if (r2 == 0) goto L_0x00a4
            android.view.ViewGroup$MarginLayoutParams r2 = (android.view.ViewGroup.MarginLayoutParams) r2
            boolean r3 = r9.isHorizontal()
            if (r3 == 0) goto L_0x008e
            int r3 = kotlin.ranges.RangesKt___RangesKt.coerceAtLeast((int) r10, (int) r0)
            r2.width = r3
            goto L_0x0094
        L_0x008e:
            int r3 = kotlin.ranges.RangesKt___RangesKt.coerceAtLeast((int) r10, (int) r0)
            r2.height = r3
        L_0x0094:
            r4.setLayoutParams(r2)
            r1.add(r4)
            r6 = 0
            r8 = 0
            r3 = r9
            r5 = r11
            r7 = r12
            r3.measureChildWithMargins(r4, r5, r6, r7, r8)
            goto L_0x0018
        L_0x00a4:
            java.lang.NullPointerException r10 = new java.lang.NullPointerException
            java.lang.String r11 = "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams"
            r10.<init>(r11)
            throw r10
        L_0x00ac:
            java.lang.NullPointerException r10 = new java.lang.NullPointerException
            r10.<init>(r5)
            throw r10
        L_0x00b2:
            java.lang.NullPointerException r10 = new java.lang.NullPointerException
            r10.<init>(r5)
            throw r10
        L_0x00b8:
            return
        L_0x00b9:
            java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException
            java.lang.String r11 = "Failed requirement."
            java.lang.String r11 = r11.toString()
            r10.<init>(r11)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.deliveryhero.fluid.widgets.containers.EnhancedLinearLayout.applyCompressionResistancePriority(int, int, int):void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: android.view.View} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v7, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v9, resolved type: android.view.View} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v10, resolved type: android.view.View} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void applyExpansionResistancePriority(int r8, int r9, int r10) {
        /*
            r7 = this;
            if (r8 <= 0) goto L_0x0004
            r0 = 1
            goto L_0x0005
        L_0x0004:
            r0 = 0
        L_0x0005:
            if (r0 == 0) goto L_0x00a9
            kotlin.sequences.Sequence r0 = androidx.core.view.ViewGroupKt.getChildren(r7)
            boolean r0 = r7.getHasExpansionResistanceAmbiguity(r0)
            if (r0 == 0) goto L_0x0012
            return
        L_0x0012:
            kotlin.sequences.Sequence r0 = androidx.core.view.ViewGroupKt.getChildren(r7)
            com.deliveryhero.fluid.widgets.containers.EnhancedLinearLayout$applyExpansionResistancePriority$minChild$1 r1 = new com.deliveryhero.fluid.widgets.containers.EnhancedLinearLayout$applyExpansionResistancePriority$minChild$1
            r1.<init>(r7)
            kotlin.sequences.Sequence r0 = kotlin.sequences.SequencesKt___SequencesKt.filter(r0, r1)
            java.util.Iterator r0 = r0.iterator()
            boolean r1 = r0.hasNext()
            if (r1 != 0) goto L_0x002b
            r0 = 0
            goto L_0x0066
        L_0x002b:
            java.lang.Object r1 = r0.next()
            boolean r2 = r0.hasNext()
            if (r2 != 0) goto L_0x0037
        L_0x0035:
            r0 = r1
            goto L_0x0066
        L_0x0037:
            r2 = r1
            android.view.View r2 = (android.view.View) r2
            android.view.ViewGroup$LayoutParams r2 = r2.getLayoutParams()
            java.lang.String r3 = "null cannot be cast to non-null type com.deliveryhero.fluid.widgets.containers.EnhancedLinearLayout.LayoutParams"
            if (r2 == 0) goto L_0x00a3
            com.deliveryhero.fluid.widgets.containers.EnhancedLinearLayout$LayoutParams r2 = (com.deliveryhero.fluid.widgets.containers.EnhancedLinearLayout.LayoutParams) r2
            int r2 = r2.getExpansionResistancePriority()
        L_0x0048:
            java.lang.Object r4 = r0.next()
            r5 = r4
            android.view.View r5 = (android.view.View) r5
            android.view.ViewGroup$LayoutParams r5 = r5.getLayoutParams()
            if (r5 == 0) goto L_0x009d
            com.deliveryhero.fluid.widgets.containers.EnhancedLinearLayout$LayoutParams r5 = (com.deliveryhero.fluid.widgets.containers.EnhancedLinearLayout.LayoutParams) r5
            int r5 = r5.getExpansionResistancePriority()
            if (r2 <= r5) goto L_0x005f
            r1 = r4
            r2 = r5
        L_0x005f:
            boolean r4 = r0.hasNext()
            if (r4 != 0) goto L_0x0048
            goto L_0x0035
        L_0x0066:
            r2 = r0
            android.view.View r2 = (android.view.View) r2
            if (r2 != 0) goto L_0x006c
            return
        L_0x006c:
            android.view.ViewGroup$LayoutParams r0 = r2.getLayoutParams()
            if (r0 == 0) goto L_0x0095
            android.view.ViewGroup$MarginLayoutParams r0 = (android.view.ViewGroup.MarginLayoutParams) r0
            boolean r1 = r7.isHorizontal()
            if (r1 == 0) goto L_0x0082
            int r1 = r2.getMeasuredWidth()
            int r8 = r8 + r1
            r0.width = r8
            goto L_0x0089
        L_0x0082:
            int r1 = r2.getMeasuredHeight()
            int r8 = r8 + r1
            r0.height = r8
        L_0x0089:
            r2.setLayoutParams(r0)
            r4 = 0
            r6 = 0
            r1 = r7
            r3 = r9
            r5 = r10
            r1.measureChildWithMargins(r2, r3, r4, r5, r6)
            return
        L_0x0095:
            java.lang.NullPointerException r8 = new java.lang.NullPointerException
            java.lang.String r9 = "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams"
            r8.<init>(r9)
            throw r8
        L_0x009d:
            java.lang.NullPointerException r8 = new java.lang.NullPointerException
            r8.<init>(r3)
            throw r8
        L_0x00a3:
            java.lang.NullPointerException r8 = new java.lang.NullPointerException
            r8.<init>(r3)
            throw r8
        L_0x00a9:
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
            java.lang.String r9 = "Failed requirement."
            java.lang.String r9 = r9.toString()
            r8.<init>(r9)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.deliveryhero.fluid.widgets.containers.EnhancedLinearLayout.applyExpansionResistancePriority(int, int, int):void");
    }

    private final boolean getHasCompressionResistanceAmbiguity(Sequence<? extends View> sequence) {
        boolean z11;
        boolean z12;
        if (getChildCount() > 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            ViewGroup.LayoutParams layoutParams = ((View) SequencesKt___SequencesKt.first(sequence)).getLayoutParams();
            if (layoutParams != null) {
                int compressionResistancePriority = ((LayoutParams) layoutParams).getCompressionResistancePriority();
                for (View layoutParams2 : sequence) {
                    ViewGroup.LayoutParams layoutParams3 = layoutParams2.getLayoutParams();
                    if (layoutParams3 != null) {
                        if (((LayoutParams) layoutParams3).getCompressionResistancePriority() == compressionResistancePriority) {
                            z12 = true;
                            continue;
                        } else {
                            z12 = false;
                            continue;
                        }
                        if (!z12) {
                            return false;
                        }
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type com.deliveryhero.fluid.widgets.containers.EnhancedLinearLayout.LayoutParams");
                    }
                }
                return true;
            }
            throw new NullPointerException("null cannot be cast to non-null type com.deliveryhero.fluid.widgets.containers.EnhancedLinearLayout.LayoutParams");
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    private final boolean getHasExpansionResistanceAmbiguity(Sequence<? extends View> sequence) {
        boolean z11;
        boolean z12;
        if (getChildCount() > 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            ViewGroup.LayoutParams layoutParams = ((View) SequencesKt___SequencesKt.first(sequence)).getLayoutParams();
            if (layoutParams != null) {
                int expansionResistancePriority = ((LayoutParams) layoutParams).getExpansionResistancePriority();
                for (View layoutParams2 : sequence) {
                    ViewGroup.LayoutParams layoutParams3 = layoutParams2.getLayoutParams();
                    if (layoutParams3 != null) {
                        if (((LayoutParams) layoutParams3).getExpansionResistancePriority() == expansionResistancePriority) {
                            z12 = true;
                            continue;
                        } else {
                            z12 = false;
                            continue;
                        }
                        if (!z12) {
                            return false;
                        }
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type com.deliveryhero.fluid.widgets.containers.EnhancedLinearLayout.LayoutParams");
                    }
                }
                return true;
            }
            throw new NullPointerException("null cannot be cast to non-null type com.deliveryhero.fluid.widgets.containers.EnhancedLinearLayout.LayoutParams");
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    /* access modifiers changed from: private */
    public final int getMainAxisSize(View view) {
        boolean isHorizontal = isHorizontal();
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        return isHorizontal ? layoutParams.width : layoutParams.height;
    }

    private final int getMeasuredMainAxisSize(View view) {
        return isHorizontal() ? view.getMeasuredWidth() : view.getMeasuredHeight();
    }

    private final int getMeasuredMainAxisSizeWithoutPadding(View view) {
        int i11;
        int i12;
        if (isHorizontal()) {
            i12 = view.getMeasuredWidth() - view.getPaddingLeft();
            i11 = view.getPaddingRight();
        } else {
            i12 = view.getMeasuredHeight() - view.getPaddingTop();
            i11 = view.getPaddingBottom();
        }
        return i12 - i11;
    }

    private final boolean isHorizontal() {
        return getOrientation() == 0;
    }

    public boolean checkLayoutParams(@NotNull ViewGroup.LayoutParams layoutParams) {
        Intrinsics.checkNotNullParameter(layoutParams, "p");
        return layoutParams instanceof LayoutParams;
    }

    /* JADX WARNING: type inference failed for: r3v5, types: [android.view.ViewGroup$LayoutParams] */
    /* JADX WARNING: type inference failed for: r3v7, types: [android.view.ViewGroup$LayoutParams] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMeasure(int r11, int r12) {
        /*
            r10 = this;
            super.onMeasure(r11, r12)
            int r0 = r10.getChildCount()
            if (r0 != 0) goto L_0x000a
            return
        L_0x000a:
            kotlin.sequences.Sequence r0 = androidx.core.view.ViewGroupKt.getChildren(r10)
            java.util.Iterator r0 = r0.iterator()
            r1 = 0
            r2 = r1
        L_0x0014:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L_0x008f
            java.lang.Object r3 = r0.next()
            android.view.View r3 = (android.view.View) r3
            int r4 = r3.getVisibility()
            if (r4 != 0) goto L_0x0028
            r4 = 1
            goto L_0x0029
        L_0x0028:
            r4 = r1
        L_0x0029:
            if (r4 != 0) goto L_0x002c
            goto L_0x0014
        L_0x002c:
            r7 = 0
            r9 = 0
            r4 = r10
            r5 = r3
            r6 = r11
            r8 = r12
            r4.measureChildWithMargins(r5, r6, r7, r8, r9)
            boolean r4 = r10.isHorizontal()
            r5 = 0
            if (r4 == 0) goto L_0x0064
            int r4 = r3.getMeasuredWidth()
            android.view.ViewGroup$LayoutParams r6 = r3.getLayoutParams()
            boolean r7 = r6 instanceof android.view.ViewGroup.MarginLayoutParams
            if (r7 == 0) goto L_0x004b
            android.view.ViewGroup$MarginLayoutParams r6 = (android.view.ViewGroup.MarginLayoutParams) r6
            goto L_0x004c
        L_0x004b:
            r6 = r5
        L_0x004c:
            if (r6 != 0) goto L_0x0050
            r6 = r1
            goto L_0x0052
        L_0x0050:
            int r6 = r6.leftMargin
        L_0x0052:
            int r4 = r4 + r6
            android.view.ViewGroup$LayoutParams r3 = r3.getLayoutParams()
            boolean r6 = r3 instanceof android.view.ViewGroup.MarginLayoutParams
            if (r6 == 0) goto L_0x005e
            r5 = r3
            android.view.ViewGroup$MarginLayoutParams r5 = (android.view.ViewGroup.MarginLayoutParams) r5
        L_0x005e:
            if (r5 != 0) goto L_0x0061
            goto L_0x0088
        L_0x0061:
            int r3 = r5.rightMargin
            goto L_0x008c
        L_0x0064:
            int r4 = r3.getMeasuredHeight()
            android.view.ViewGroup$LayoutParams r6 = r3.getLayoutParams()
            boolean r7 = r6 instanceof android.view.ViewGroup.MarginLayoutParams
            if (r7 == 0) goto L_0x0073
            android.view.ViewGroup$MarginLayoutParams r6 = (android.view.ViewGroup.MarginLayoutParams) r6
            goto L_0x0074
        L_0x0073:
            r6 = r5
        L_0x0074:
            if (r6 != 0) goto L_0x0078
            r6 = r1
            goto L_0x007a
        L_0x0078:
            int r6 = r6.topMargin
        L_0x007a:
            int r4 = r4 + r6
            android.view.ViewGroup$LayoutParams r3 = r3.getLayoutParams()
            boolean r6 = r3 instanceof android.view.ViewGroup.MarginLayoutParams
            if (r6 == 0) goto L_0x0086
            r5 = r3
            android.view.ViewGroup$MarginLayoutParams r5 = (android.view.ViewGroup.MarginLayoutParams) r5
        L_0x0086:
            if (r5 != 0) goto L_0x008a
        L_0x0088:
            r3 = r1
            goto L_0x008c
        L_0x008a:
            int r3 = r5.bottomMargin
        L_0x008c:
            int r4 = r4 + r3
            int r2 = r2 + r4
            goto L_0x0014
        L_0x008f:
            int r0 = r10.getMeasuredMainAxisSizeWithoutPadding(r10)
            int r0 = r0 - r2
            if (r0 <= 0) goto L_0x009a
            r10.applyExpansionResistancePriority(r0, r11, r12)
            goto L_0x009f
        L_0x009a:
            if (r0 >= 0) goto L_0x009f
            r10.applyCompressionResistancePriority(r0, r11, r12)
        L_0x009f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.deliveryhero.fluid.widgets.containers.EnhancedLinearLayout.onMeasure(int, int):void");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public EnhancedLinearLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @NotNull
    public LinearLayout.LayoutParams generateDefaultLayoutParams() {
        if (getOrientation() == 0) {
            return new LayoutParams(-2, -2);
        }
        return new LayoutParams(-1, -2);
    }

    @NotNull
    public LinearLayout.LayoutParams generateLayoutParams(@Nullable ViewGroup.LayoutParams layoutParams) {
        return new LinearLayout.LayoutParams(layoutParams);
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005B'\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bB\r\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bR\u001a\u0010\u0007\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0006\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/deliveryhero/fluid/widgets/containers/EnhancedLinearLayout$LayoutParams;", "Landroid/widget/LinearLayout$LayoutParams;", "width", "", "height", "(II)V", "expansionResistancePriority", "compressionResistancePriority", "(IIII)V", "lp", "Landroid/view/ViewGroup$LayoutParams;", "(Landroid/view/ViewGroup$LayoutParams;)V", "getCompressionResistancePriority", "()I", "setCompressionResistancePriority", "(I)V", "getExpansionResistancePriority", "setExpansionResistancePriority", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class LayoutParams extends LinearLayout.LayoutParams {
        private int compressionResistancePriority;
        private int expansionResistancePriority;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public LayoutParams(@NotNull ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            Intrinsics.checkNotNullParameter(layoutParams, "lp");
            this.expansionResistancePriority = 251;
            this.compressionResistancePriority = 750;
        }

        public final int getCompressionResistancePriority() {
            return this.compressionResistancePriority;
        }

        public final int getExpansionResistancePriority() {
            return this.expansionResistancePriority;
        }

        public final void setCompressionResistancePriority(int i11) {
            this.compressionResistancePriority = i11;
        }

        public final void setExpansionResistancePriority(int i11) {
            this.expansionResistancePriority = i11;
        }

        public LayoutParams(int i11, int i12) {
            this(new ViewGroup.LayoutParams(i11, i12));
        }

        public LayoutParams(int i11, int i12, int i13, int i14) {
            this(i11, i12);
            this.expansionResistancePriority = i13;
            this.compressionResistancePriority = i14;
        }
    }
}
