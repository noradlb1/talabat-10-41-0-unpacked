package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import java.util.ArrayList;

class RunGroup {
    public static final int BASELINE = 2;
    public static final int END = 1;
    public static final int START = 0;
    public static int index;

    /* renamed from: a  reason: collision with root package name */
    public WidgetRun f10810a = null;

    /* renamed from: b  reason: collision with root package name */
    public WidgetRun f10811b = null;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<WidgetRun> f10812c = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    public int f10813d;
    public boolean dual = false;

    /* renamed from: e  reason: collision with root package name */
    public int f10814e;
    public int position = 0;

    public RunGroup(WidgetRun widgetRun, int i11) {
        int i12 = index;
        this.f10813d = i12;
        index = i12 + 1;
        this.f10810a = widgetRun;
        this.f10811b = widgetRun;
        this.f10814e = i11;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0072, code lost:
        r2 = (androidx.constraintlayout.core.widgets.analyzer.DependencyNode) r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0022, code lost:
        r2 = (androidx.constraintlayout.core.widgets.analyzer.DependencyNode) r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean defineTerminalWidget(androidx.constraintlayout.core.widgets.analyzer.WidgetRun r6, int r7) {
        /*
            r5 = this;
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r6.f10831a
            boolean[] r0 = r0.isTerminalWidget
            boolean r0 = r0[r7]
            r1 = 0
            if (r0 != 0) goto L_0x000a
            return r1
        L_0x000a:
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r6.start
            java.util.List<androidx.constraintlayout.core.widgets.analyzer.Dependency> r0 = r0.f10807f
            java.util.Iterator r0 = r0.iterator()
        L_0x0012:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x005a
            java.lang.Object r2 = r0.next()
            androidx.constraintlayout.core.widgets.analyzer.Dependency r2 = (androidx.constraintlayout.core.widgets.analyzer.Dependency) r2
            boolean r3 = r2 instanceof androidx.constraintlayout.core.widgets.analyzer.DependencyNode
            if (r3 == 0) goto L_0x0012
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r2 = (androidx.constraintlayout.core.widgets.analyzer.DependencyNode) r2
            androidx.constraintlayout.core.widgets.analyzer.WidgetRun r3 = r2.f10802a
            if (r3 != r6) goto L_0x0029
            goto L_0x0012
        L_0x0029:
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r3 = r3.start
            if (r2 != r3) goto L_0x0012
            boolean r3 = r6 instanceof androidx.constraintlayout.core.widgets.analyzer.ChainRun
            if (r3 == 0) goto L_0x004a
            r3 = r6
            androidx.constraintlayout.core.widgets.analyzer.ChainRun r3 = (androidx.constraintlayout.core.widgets.analyzer.ChainRun) r3
            java.util.ArrayList<androidx.constraintlayout.core.widgets.analyzer.WidgetRun> r3 = r3.f10800g
            java.util.Iterator r3 = r3.iterator()
        L_0x003a:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x0054
            java.lang.Object r4 = r3.next()
            androidx.constraintlayout.core.widgets.analyzer.WidgetRun r4 = (androidx.constraintlayout.core.widgets.analyzer.WidgetRun) r4
            r5.defineTerminalWidget(r4, r7)
            goto L_0x003a
        L_0x004a:
            boolean r3 = r6 instanceof androidx.constraintlayout.core.widgets.analyzer.HelperReferences
            if (r3 != 0) goto L_0x0054
            androidx.constraintlayout.core.widgets.ConstraintWidget r3 = r6.f10831a
            boolean[] r3 = r3.isTerminalWidget
            r3[r7] = r1
        L_0x0054:
            androidx.constraintlayout.core.widgets.analyzer.WidgetRun r2 = r2.f10802a
            r5.defineTerminalWidget(r2, r7)
            goto L_0x0012
        L_0x005a:
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r6.end
            java.util.List<androidx.constraintlayout.core.widgets.analyzer.Dependency> r0 = r0.f10807f
            java.util.Iterator r0 = r0.iterator()
        L_0x0062:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x00aa
            java.lang.Object r2 = r0.next()
            androidx.constraintlayout.core.widgets.analyzer.Dependency r2 = (androidx.constraintlayout.core.widgets.analyzer.Dependency) r2
            boolean r3 = r2 instanceof androidx.constraintlayout.core.widgets.analyzer.DependencyNode
            if (r3 == 0) goto L_0x0062
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r2 = (androidx.constraintlayout.core.widgets.analyzer.DependencyNode) r2
            androidx.constraintlayout.core.widgets.analyzer.WidgetRun r3 = r2.f10802a
            if (r3 != r6) goto L_0x0079
            goto L_0x0062
        L_0x0079:
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r3 = r3.start
            if (r2 != r3) goto L_0x0062
            boolean r3 = r6 instanceof androidx.constraintlayout.core.widgets.analyzer.ChainRun
            if (r3 == 0) goto L_0x009a
            r3 = r6
            androidx.constraintlayout.core.widgets.analyzer.ChainRun r3 = (androidx.constraintlayout.core.widgets.analyzer.ChainRun) r3
            java.util.ArrayList<androidx.constraintlayout.core.widgets.analyzer.WidgetRun> r3 = r3.f10800g
            java.util.Iterator r3 = r3.iterator()
        L_0x008a:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x00a4
            java.lang.Object r4 = r3.next()
            androidx.constraintlayout.core.widgets.analyzer.WidgetRun r4 = (androidx.constraintlayout.core.widgets.analyzer.WidgetRun) r4
            r5.defineTerminalWidget(r4, r7)
            goto L_0x008a
        L_0x009a:
            boolean r3 = r6 instanceof androidx.constraintlayout.core.widgets.analyzer.HelperReferences
            if (r3 != 0) goto L_0x00a4
            androidx.constraintlayout.core.widgets.ConstraintWidget r3 = r6.f10831a
            boolean[] r3 = r3.isTerminalWidget
            r3[r7] = r1
        L_0x00a4:
            androidx.constraintlayout.core.widgets.analyzer.WidgetRun r2 = r2.f10802a
            r5.defineTerminalWidget(r2, r7)
            goto L_0x0062
        L_0x00aa:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.analyzer.RunGroup.defineTerminalWidget(androidx.constraintlayout.core.widgets.analyzer.WidgetRun, int):boolean");
    }

    private long traverseEnd(DependencyNode dependencyNode, long j11) {
        WidgetRun widgetRun = dependencyNode.f10802a;
        if (widgetRun instanceof HelperReferences) {
            return j11;
        }
        int size = dependencyNode.f10807f.size();
        long j12 = j11;
        for (int i11 = 0; i11 < size; i11++) {
            Dependency dependency = dependencyNode.f10807f.get(i11);
            if (dependency instanceof DependencyNode) {
                DependencyNode dependencyNode2 = (DependencyNode) dependency;
                if (dependencyNode2.f10802a != widgetRun) {
                    j12 = Math.min(j12, traverseEnd(dependencyNode2, ((long) dependencyNode2.f10804c) + j11));
                }
            }
        }
        if (dependencyNode != widgetRun.end) {
            return j12;
        }
        long wrapDimension = j11 - widgetRun.getWrapDimension();
        return Math.min(Math.min(j12, traverseEnd(widgetRun.start, wrapDimension)), wrapDimension - ((long) widgetRun.start.f10804c));
    }

    private long traverseStart(DependencyNode dependencyNode, long j11) {
        WidgetRun widgetRun = dependencyNode.f10802a;
        if (widgetRun instanceof HelperReferences) {
            return j11;
        }
        int size = dependencyNode.f10807f.size();
        long j12 = j11;
        for (int i11 = 0; i11 < size; i11++) {
            Dependency dependency = dependencyNode.f10807f.get(i11);
            if (dependency instanceof DependencyNode) {
                DependencyNode dependencyNode2 = (DependencyNode) dependency;
                if (dependencyNode2.f10802a != widgetRun) {
                    j12 = Math.max(j12, traverseStart(dependencyNode2, ((long) dependencyNode2.f10804c) + j11));
                }
            }
        }
        if (dependencyNode != widgetRun.start) {
            return j12;
        }
        long wrapDimension = j11 + widgetRun.getWrapDimension();
        return Math.max(Math.max(j12, traverseStart(widgetRun.end, wrapDimension)), wrapDimension - ((long) widgetRun.end.f10804c));
    }

    public void add(WidgetRun widgetRun) {
        this.f10812c.add(widgetRun);
        this.f10811b = widgetRun;
    }

    public long computeWrapSize(ConstraintWidgetContainer constraintWidgetContainer, int i11) {
        WidgetRun widgetRun;
        WidgetRun widgetRun2;
        int i12;
        long j11;
        WidgetRun widgetRun3 = this.f10810a;
        long j12 = 0;
        if (widgetRun3 instanceof ChainRun) {
            if (((ChainRun) widgetRun3).orientation != i11) {
                return 0;
            }
        } else if (i11 == 0) {
            if (!(widgetRun3 instanceof HorizontalWidgetRun)) {
                return 0;
            }
        } else if (!(widgetRun3 instanceof VerticalWidgetRun)) {
            return 0;
        }
        if (i11 == 0) {
            widgetRun = constraintWidgetContainer.horizontalRun;
        } else {
            widgetRun = constraintWidgetContainer.verticalRun;
        }
        DependencyNode dependencyNode = widgetRun.start;
        if (i11 == 0) {
            widgetRun2 = constraintWidgetContainer.horizontalRun;
        } else {
            widgetRun2 = constraintWidgetContainer.verticalRun;
        }
        DependencyNode dependencyNode2 = widgetRun2.end;
        boolean contains = widgetRun3.start.f10808g.contains(dependencyNode);
        boolean contains2 = this.f10810a.end.f10808g.contains(dependencyNode2);
        long wrapDimension = this.f10810a.getWrapDimension();
        if (contains && contains2) {
            long traverseStart = traverseStart(this.f10810a.start, 0);
            long traverseEnd = traverseEnd(this.f10810a.end, 0);
            long j13 = traverseStart - wrapDimension;
            WidgetRun widgetRun4 = this.f10810a;
            int i13 = widgetRun4.end.f10804c;
            if (j13 >= ((long) (-i13))) {
                j13 += (long) i13;
            }
            int i14 = widgetRun4.start.f10804c;
            long j14 = ((-traverseEnd) - wrapDimension) - ((long) i14);
            if (j14 >= ((long) i14)) {
                j14 -= (long) i14;
            }
            float biasPercent = widgetRun4.f10831a.getBiasPercent(i11);
            if (biasPercent > 0.0f) {
                j12 = (long) ((((float) j14) / biasPercent) + (((float) j13) / (1.0f - biasPercent)));
            }
            float f11 = (float) j12;
            long j15 = ((long) ((f11 * biasPercent) + 0.5f)) + wrapDimension + ((long) ((f11 * (1.0f - biasPercent)) + 0.5f));
            WidgetRun widgetRun5 = this.f10810a;
            j11 = ((long) widgetRun5.start.f10804c) + j15;
            i12 = widgetRun5.end.f10804c;
        } else if (contains) {
            DependencyNode dependencyNode3 = this.f10810a.start;
            return Math.max(traverseStart(dependencyNode3, (long) dependencyNode3.f10804c), ((long) this.f10810a.start.f10804c) + wrapDimension);
        } else if (contains2) {
            DependencyNode dependencyNode4 = this.f10810a.end;
            return Math.max(-traverseEnd(dependencyNode4, (long) dependencyNode4.f10804c), ((long) (-this.f10810a.end.f10804c)) + wrapDimension);
        } else {
            WidgetRun widgetRun6 = this.f10810a;
            j11 = ((long) widgetRun6.start.f10804c) + widgetRun6.getWrapDimension();
            i12 = this.f10810a.end.f10804c;
        }
        return j11 - ((long) i12);
    }

    public void defineTerminalWidgets(boolean z11, boolean z12) {
        if (z11) {
            WidgetRun widgetRun = this.f10810a;
            if (widgetRun instanceof HorizontalWidgetRun) {
                defineTerminalWidget(widgetRun, 0);
            }
        }
        if (z12) {
            WidgetRun widgetRun2 = this.f10810a;
            if (widgetRun2 instanceof VerticalWidgetRun) {
                defineTerminalWidget(widgetRun2, 1);
            }
        }
    }
}
