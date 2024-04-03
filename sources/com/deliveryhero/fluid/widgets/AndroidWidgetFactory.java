package com.deliveryhero.fluid.widgets;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.ViewCompat;
import com.deliveryhero.fluid.expression.literal.Literal;
import com.deliveryhero.fluid.values.Color;
import com.deliveryhero.fluid.values.LinearGradientOrientation;
import com.deliveryhero.fluid.values.LogicalPixel;
import com.deliveryhero.fluid.values.Shape;
import com.deliveryhero.fluid.values.Size;
import com.deliveryhero.fluid.widgets.WidgetModel;
import com.deliveryhero.fluid.widgets.containers.HorizontalAlignment;
import com.deliveryhero.fluid.widgets.containers.VerticalAlignment;
import com.deliveryhero.fluid.widgets.utils.WidgetTagsKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B\u000f\u0012\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u001e\u0010\u001fJH\u0010\f\u001a\u00028\u0000\"\f\b\u0001\u0010\u0006*\u00060\u0004j\u0002`\u00052\u0006\u0010\u0007\u001a\u00028\u00012!\u0010\u000b\u001a\u001d\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00028\u00000\bH\u0004¢\u0006\u0004\b\f\u0010\rJ*\u0010\u0015\u001a\u00020\u0014*\u00060\u0004j\u0002`\u00052\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0004J\u0014\u0010\u0016\u001a\u00020\u000e2\n\u0010\u0007\u001a\u00060\u0004j\u0002`\u0005H\u0004R\u0017\u0010\u0018\u001a\u00020\u00178\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0018\u0010\u001c\u001a\u0004\u0018\u00018\u00008\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001d¨\u0006 "}, d2 = {"Lcom/deliveryhero/fluid/widgets/AndroidWidgetFactory;", "Lcom/deliveryhero/fluid/widgets/WidgetModel;", "ModelT", "Lcom/deliveryhero/fluid/widgets/WidgetFactory;", "Landroid/view/View;", "Lcom/deliveryhero/fluid/widgets/Widget;", "WidgetT", "widget", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "init", "b", "(Landroid/view/View;Lkotlin/jvm/functions/Function1;)Lcom/deliveryhero/fluid/widgets/WidgetModel;", "Lcom/deliveryhero/fluid/widgets/WidgetModel$BaseProperties;", "props", "Lcom/deliveryhero/fluid/Host;", "host", "Lcom/deliveryhero/fluid/template/data/TemplateUiData;", "data", "", "c", "a", "Landroid/content/Context;", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "_defaults", "Lcom/deliveryhero/fluid/widgets/WidgetModel;", "<init>", "(Landroid/content/Context;)V", "core_release"}, k = 1, mv = {1, 6, 0})
public abstract class AndroidWidgetFactory<ModelT extends WidgetModel> implements WidgetFactory<ModelT> {
    @Nullable
    private ModelT _defaults;
    @NotNull
    private final Context context;

    public AndroidWidgetFactory(@NotNull Context context2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        this.context = context2;
    }

    @NotNull
    public final WidgetModel.BaseProperties a(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "widget");
        Size.WrapContent wrapContent = Size.WrapContent.INSTANCE;
        Literal literal = new Literal(wrapContent);
        Literal literal2 = new Literal(wrapContent);
        Boolean bool = Boolean.TRUE;
        Literal literal3 = new Literal(bool);
        Literal literal4 = new Literal(251);
        Literal literal5 = new Literal(750);
        List emptyList = CollectionsKt__CollectionsKt.emptyList();
        Literal literal6 = new Literal(Shape.RECT);
        Literal literal7 = new Literal(LinearGradientOrientation.LEFT_RIGHT);
        LogicalPixel.Companion companion = LogicalPixel.Companion;
        Literal literal8 = new Literal(companion.getZERO());
        Literal literal9 = new Literal(companion.getZERO());
        Literal literal10 = new Literal(companion.getZERO());
        Literal literal11 = new Literal(companion.getZERO());
        Literal literal12 = new Literal(companion.getZERO());
        Literal literal13 = new Literal(Color.Companion.getOPAQUE_WHITE());
        Context context2 = view.getContext();
        Literal literal14 = literal11;
        Intrinsics.checkNotNullExpressionValue(context2, "widget.context");
        Literal literal15 = literal10;
        Literal literal16 = new Literal(new LogicalPixel(ViewCompat.getElevation(view) / context2.getResources().getDisplayMetrics().density));
        Literal literal17 = new Literal(bool);
        Context context3 = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context3, "widget.context");
        Literal literal18 = literal16;
        Literal literal19 = literal17;
        Literal literal20 = new Literal(new LogicalPixel(((float) view.getPaddingStart()) / context3.getResources().getDisplayMetrics().density));
        Context context4 = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context4, "widget.context");
        Literal literal21 = literal20;
        Literal literal22 = new Literal(new LogicalPixel(((float) view.getPaddingTop()) / context4.getResources().getDisplayMetrics().density));
        Context context5 = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context5, "widget.context");
        Literal literal23 = literal22;
        Literal literal24 = new Literal(new LogicalPixel(((float) view.getPaddingEnd()) / context5.getResources().getDisplayMetrics().density));
        Context context6 = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context6, "widget.context");
        Literal literal25 = literal24;
        Literal literal26 = new Literal(new LogicalPixel(((float) view.getPaddingBottom()) / context6.getResources().getDisplayMetrics().density));
        Context context7 = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context7, "widget.context");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        Literal literal27 = literal26;
        Literal literal28 = new Literal(new LogicalPixel(((float) (layoutParams instanceof ViewGroup.MarginLayoutParams ? MarginLayoutParamsCompat.getMarginStart((ViewGroup.MarginLayoutParams) layoutParams) : 0)) / context7.getResources().getDisplayMetrics().density));
        Context context8 = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context8, "widget.context");
        ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
        Literal literal29 = literal28;
        Literal literal30 = literal9;
        ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams2 instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams2 : null;
        Literal literal31 = new Literal(new LogicalPixel(((float) (marginLayoutParams == null ? 0 : marginLayoutParams.topMargin)) / context8.getResources().getDisplayMetrics().density));
        Context context9 = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context9, "widget.context");
        ViewGroup.LayoutParams layoutParams3 = view.getLayoutParams();
        Literal literal32 = new Literal(new LogicalPixel(((float) (layoutParams3 instanceof ViewGroup.MarginLayoutParams ? MarginLayoutParamsCompat.getMarginEnd((ViewGroup.MarginLayoutParams) layoutParams3) : 0)) / context9.getResources().getDisplayMetrics().density));
        Context context10 = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context10, "widget.context");
        ViewGroup.LayoutParams layoutParams4 = view.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams2 = layoutParams4 instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams4 : null;
        Literal literal33 = new Literal(new LogicalPixel(((float) (marginLayoutParams2 == null ? 0 : marginLayoutParams2.bottomMargin)) / context10.getResources().getDisplayMetrics().density));
        Literal literal34 = r1;
        Literal literal35 = new Literal(HorizontalAlignment.LEADING);
        Literal literal36 = r1;
        Literal literal37 = new Literal(VerticalAlignment.TOP);
        Literal literal38 = r1;
        Literal literal39 = new Literal(null);
        Literal literal40 = r1;
        Literal literal41 = new Literal(null);
        Literal literal42 = r1;
        Literal literal43 = new Literal(null);
        return new WidgetModel.BaseProperties(literal, literal2, literal3, literal4, literal5, emptyList, literal6, literal7, literal8, literal30, literal15, literal14, literal12, literal13, literal18, literal19, literal21, literal23, literal25, literal27, literal29, literal31, literal32, literal33, literal34, literal36, literal38, literal40, literal42);
    }

    @NotNull
    public final <WidgetT extends View> ModelT b(@NotNull WidgetT widgett, @NotNull Function1<? super WidgetT, ? extends ModelT> function1) {
        Intrinsics.checkNotNullParameter(widgett, "widget");
        Intrinsics.checkNotNullParameter(function1, "init");
        ModelT modelt = this._defaults;
        if (modelt != null) {
            return modelt;
        }
        ModelT modelt2 = (WidgetModel) function1.invoke(widgett);
        WidgetTagsKt.initWidgetTags(widgett);
        this._defaults = modelt2;
        return modelt2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v92, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v9, resolved type: com.deliveryhero.fluid.widgets.utils.WidgetTags} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v102, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v14, resolved type: com.deliveryhero.fluid.widgets.utils.WidgetTags} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void c(@org.jetbrains.annotations.NotNull android.view.View r19, @org.jetbrains.annotations.NotNull com.deliveryhero.fluid.widgets.WidgetModel.BaseProperties r20, @org.jetbrains.annotations.NotNull com.deliveryhero.fluid.Host r21, @org.jetbrains.annotations.Nullable com.deliveryhero.fluid.template.data.TemplateUiData r22) {
        /*
            r18 = this;
            r12 = r19
            r13 = r21
            r14 = r22
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            java.lang.String r0 = "props"
            r15 = r20
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "host"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            r11 = r18
            ModelT r0 = r11._defaults
            if (r0 == 0) goto L_0x03db
            com.deliveryhero.fluid.widgets.WidgetModel$BaseProperties r16 = r0.getBaseProperties()
            if (r16 == 0) goto L_0x03db
            com.deliveryhero.fluid.expression.Expression r0 = r20.isVisible()
            com.deliveryhero.fluid.expression.Expression r1 = r16.isVisible()
            java.lang.Object r0 = r0.get((com.deliveryhero.fluid.template.data.TemplateUiData) r14, r1)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            com.deliveryhero.fluid.widgets.utils.WidgetUtilsKt.updateVisibility(r12, r0)
            com.deliveryhero.fluid.telemetry.log.Logger r1 = r21.getLogger()
            com.deliveryhero.fluid.expression.Expression r0 = r20.getWidth()
            com.deliveryhero.fluid.expression.Expression r2 = r16.getWidth()
            java.lang.Object r0 = r0.get((com.deliveryhero.fluid.template.data.TemplateUiData) r14, r2)
            r2 = r0
            com.deliveryhero.fluid.values.Size r2 = (com.deliveryhero.fluid.values.Size) r2
            com.deliveryhero.fluid.expression.Expression r0 = r20.getHeight()
            com.deliveryhero.fluid.expression.Expression r3 = r16.getHeight()
            java.lang.Object r0 = r0.get((com.deliveryhero.fluid.template.data.TemplateUiData) r14, r3)
            r3 = r0
            com.deliveryhero.fluid.values.Size r3 = (com.deliveryhero.fluid.values.Size) r3
            com.deliveryhero.fluid.expression.Expression r0 = r20.getExpansionResistancePriority()
            com.deliveryhero.fluid.expression.Expression r4 = r16.getExpansionResistancePriority()
            java.lang.Object r0 = r0.get((com.deliveryhero.fluid.template.data.TemplateUiData) r14, r4)
            java.lang.Number r0 = (java.lang.Number) r0
            int r4 = r0.intValue()
            com.deliveryhero.fluid.expression.Expression r0 = r20.getCompressionResistancePriority()
            com.deliveryhero.fluid.expression.Expression r5 = r16.getCompressionResistancePriority()
            java.lang.Object r0 = r0.get((com.deliveryhero.fluid.template.data.TemplateUiData) r14, r5)
            java.lang.Number r0 = (java.lang.Number) r0
            int r5 = r0.intValue()
            com.deliveryhero.fluid.expression.Expression r0 = r20.getHorizontalAlignment()
            com.deliveryhero.fluid.expression.Expression r6 = r16.getHorizontalAlignment()
            java.lang.Object r0 = r0.get((com.deliveryhero.fluid.template.data.TemplateUiData) r14, r6)
            r6 = r0
            com.deliveryhero.fluid.widgets.containers.HorizontalAlignment r6 = (com.deliveryhero.fluid.widgets.containers.HorizontalAlignment) r6
            com.deliveryhero.fluid.expression.Expression r0 = r20.getVerticalAlignment()
            com.deliveryhero.fluid.expression.Expression r7 = r16.getVerticalAlignment()
            java.lang.Object r0 = r0.get((com.deliveryhero.fluid.template.data.TemplateUiData) r14, r7)
            r7 = r0
            com.deliveryhero.fluid.widgets.containers.VerticalAlignment r7 = (com.deliveryhero.fluid.widgets.containers.VerticalAlignment) r7
            com.deliveryhero.fluid.expression.Expression r0 = r20.getMarginLeading()
            com.deliveryhero.fluid.expression.Expression r8 = r16.getMarginLeading()
            java.lang.Object r0 = r0.get((com.deliveryhero.fluid.template.data.TemplateUiData) r14, r8)
            com.deliveryhero.fluid.values.LogicalPixel r0 = (com.deliveryhero.fluid.values.LogicalPixel) r0
            android.content.Context r8 = r19.getContext()
            java.lang.String r10 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r10)
            float r0 = r0.getValue()
            android.content.res.Resources r8 = r8.getResources()
            android.util.DisplayMetrics r8 = r8.getDisplayMetrics()
            r9 = 1
            float r0 = android.util.TypedValue.applyDimension(r9, r0, r8)
            int r8 = (int) r0
            com.deliveryhero.fluid.expression.Expression r0 = r20.getMarginTop()
            com.deliveryhero.fluid.expression.Expression r9 = r16.getMarginTop()
            java.lang.Object r0 = r0.get((com.deliveryhero.fluid.template.data.TemplateUiData) r14, r9)
            com.deliveryhero.fluid.values.LogicalPixel r0 = (com.deliveryhero.fluid.values.LogicalPixel) r0
            android.content.Context r9 = r19.getContext()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r10)
            float r0 = r0.getValue()
            android.content.res.Resources r9 = r9.getResources()
            android.util.DisplayMetrics r9 = r9.getDisplayMetrics()
            r11 = 1
            float r0 = android.util.TypedValue.applyDimension(r11, r0, r9)
            int r9 = (int) r0
            com.deliveryhero.fluid.expression.Expression r0 = r20.getMarginTrailing()
            com.deliveryhero.fluid.expression.Expression r11 = r16.getMarginTrailing()
            java.lang.Object r0 = r0.get((com.deliveryhero.fluid.template.data.TemplateUiData) r14, r11)
            com.deliveryhero.fluid.values.LogicalPixel r0 = (com.deliveryhero.fluid.values.LogicalPixel) r0
            android.content.Context r11 = r19.getContext()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r10)
            float r0 = r0.getValue()
            android.content.res.Resources r11 = r11.getResources()
            android.util.DisplayMetrics r11 = r11.getDisplayMetrics()
            r15 = 1
            float r0 = android.util.TypedValue.applyDimension(r15, r0, r11)
            int r11 = (int) r0
            com.deliveryhero.fluid.expression.Expression r0 = r20.getMarginBottom()
            com.deliveryhero.fluid.expression.Expression r15 = r16.getMarginBottom()
            java.lang.Object r0 = r0.get((com.deliveryhero.fluid.template.data.TemplateUiData) r14, r15)
            com.deliveryhero.fluid.values.LogicalPixel r0 = (com.deliveryhero.fluid.values.LogicalPixel) r0
            android.content.Context r15 = r19.getContext()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r15, r10)
            float r0 = r0.getValue()
            android.content.res.Resources r15 = r15.getResources()
            android.util.DisplayMetrics r15 = r15.getDisplayMetrics()
            r17 = r10
            r10 = 1
            float r0 = android.util.TypedValue.applyDimension(r10, r0, r15)
            int r15 = (int) r0
            r0 = r19
            r13 = r17
            r10 = r11
            r11 = r15
            com.deliveryhero.fluid.widgets.utils.LayoutParamsUtilsKt.updateLayoutParams(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            com.deliveryhero.fluid.expression.Expression r0 = r20.getPaddingLeading()
            com.deliveryhero.fluid.expression.Expression r1 = r16.getPaddingLeading()
            java.lang.Object r0 = r0.get((com.deliveryhero.fluid.template.data.TemplateUiData) r14, r1)
            com.deliveryhero.fluid.values.LogicalPixel r0 = (com.deliveryhero.fluid.values.LogicalPixel) r0
            android.content.Context r1 = r19.getContext()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r13)
            float r0 = r0.getValue()
            android.content.res.Resources r1 = r1.getResources()
            android.util.DisplayMetrics r1 = r1.getDisplayMetrics()
            r2 = 1
            float r0 = android.util.TypedValue.applyDimension(r2, r0, r1)
            int r0 = (int) r0
            com.deliveryhero.fluid.expression.Expression r1 = r20.getPaddingTop()
            com.deliveryhero.fluid.expression.Expression r3 = r16.getPaddingTop()
            java.lang.Object r1 = r1.get((com.deliveryhero.fluid.template.data.TemplateUiData) r14, r3)
            com.deliveryhero.fluid.values.LogicalPixel r1 = (com.deliveryhero.fluid.values.LogicalPixel) r1
            android.content.Context r3 = r19.getContext()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r13)
            float r1 = r1.getValue()
            android.content.res.Resources r3 = r3.getResources()
            android.util.DisplayMetrics r3 = r3.getDisplayMetrics()
            float r1 = android.util.TypedValue.applyDimension(r2, r1, r3)
            int r1 = (int) r1
            com.deliveryhero.fluid.expression.Expression r3 = r20.getPaddingTrailing()
            com.deliveryhero.fluid.expression.Expression r4 = r16.getPaddingTrailing()
            java.lang.Object r3 = r3.get((com.deliveryhero.fluid.template.data.TemplateUiData) r14, r4)
            com.deliveryhero.fluid.values.LogicalPixel r3 = (com.deliveryhero.fluid.values.LogicalPixel) r3
            android.content.Context r4 = r19.getContext()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r13)
            float r3 = r3.getValue()
            android.content.res.Resources r4 = r4.getResources()
            android.util.DisplayMetrics r4 = r4.getDisplayMetrics()
            float r3 = android.util.TypedValue.applyDimension(r2, r3, r4)
            int r3 = (int) r3
            com.deliveryhero.fluid.expression.Expression r4 = r20.getPaddingBottom()
            com.deliveryhero.fluid.expression.Expression r5 = r16.getPaddingBottom()
            java.lang.Object r4 = r4.get((com.deliveryhero.fluid.template.data.TemplateUiData) r14, r5)
            com.deliveryhero.fluid.values.LogicalPixel r4 = (com.deliveryhero.fluid.values.LogicalPixel) r4
            android.content.Context r5 = r19.getContext()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r13)
            float r4 = r4.getValue()
            android.content.res.Resources r5 = r5.getResources()
            android.util.DisplayMetrics r5 = r5.getDisplayMetrics()
            float r4 = android.util.TypedValue.applyDimension(r2, r4, r5)
            int r2 = (int) r4
            com.deliveryhero.fluid.widgets.utils.WidgetUtilsKt.updatePaddings(r12, r0, r1, r3, r2)
            java.util.List r0 = r20.getBackgroundColors()
            java.util.List r0 = com.deliveryhero.fluid.expression.utils.ExpressionUtilsKt.get(r0, r14)
            boolean r1 = r0.isEmpty()
            r8 = 0
            if (r1 == 0) goto L_0x020a
            java.lang.Object r0 = r19.getTag()
            boolean r1 = r0 instanceof com.deliveryhero.fluid.widgets.utils.WidgetTags
            if (r1 == 0) goto L_0x01fb
            r8 = r0
            com.deliveryhero.fluid.widgets.utils.WidgetTags r8 = (com.deliveryhero.fluid.widgets.utils.WidgetTags) r8
        L_0x01fb:
            if (r8 != 0) goto L_0x0201
            com.deliveryhero.fluid.widgets.utils.WidgetTags r8 = com.deliveryhero.fluid.widgets.utils.WidgetTagsKt.initWidgetTags(r19)
        L_0x0201:
            android.graphics.drawable.Drawable r0 = r8.getDefaultBackground()
            r12.setBackground(r0)
            goto L_0x036a
        L_0x020a:
            com.deliveryhero.fluid.expression.Expression r1 = r20.getBorderWidth()
            com.deliveryhero.fluid.expression.Expression r2 = r16.getBorderWidth()
            java.lang.Object r1 = r1.get((com.deliveryhero.fluid.template.data.TemplateUiData) r14, r2)
            com.deliveryhero.fluid.values.LogicalPixel r1 = (com.deliveryhero.fluid.values.LogicalPixel) r1
            android.content.Context r2 = r19.getContext()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r13)
            float r1 = r1.getValue()
            android.content.res.Resources r2 = r2.getResources()
            android.util.DisplayMetrics r2 = r2.getDisplayMetrics()
            r3 = 1
            float r1 = android.util.TypedValue.applyDimension(r3, r1, r2)
            int r1 = (int) r1
            com.deliveryhero.fluid.widgets.utils.background.Background$Companion r2 = com.deliveryhero.fluid.widgets.utils.background.Background.Companion
            com.deliveryhero.fluid.widgets.utils.background.Background r9 = r2.getOrInit(r12, r0, r1)
            java.lang.Object r1 = r19.getTag()
            boolean r2 = r1 instanceof com.deliveryhero.fluid.widgets.utils.WidgetTags
            if (r2 == 0) goto L_0x0242
            com.deliveryhero.fluid.widgets.utils.WidgetTags r1 = (com.deliveryhero.fluid.widgets.utils.WidgetTags) r1
            goto L_0x0243
        L_0x0242:
            r1 = r8
        L_0x0243:
            if (r1 != 0) goto L_0x0249
            com.deliveryhero.fluid.widgets.utils.WidgetTags r1 = com.deliveryhero.fluid.widgets.utils.WidgetTagsKt.initWidgetTags(r19)
        L_0x0249:
            r9.setColors(r1, r0)
            com.deliveryhero.fluid.expression.Expression r0 = r20.getBackgroundLinearGradientOrientation()
            com.deliveryhero.fluid.expression.Expression r1 = r16.getBackgroundLinearGradientOrientation()
            java.lang.Object r0 = r0.get((com.deliveryhero.fluid.template.data.TemplateUiData) r14, r1)
            com.deliveryhero.fluid.values.LinearGradientOrientation r0 = (com.deliveryhero.fluid.values.LinearGradientOrientation) r0
            r9.setLinearGradientOrientation(r0)
            com.deliveryhero.fluid.expression.Expression r0 = r20.getBackgroundShape()
            com.deliveryhero.fluid.expression.Expression r1 = r16.getBackgroundShape()
            java.lang.Object r0 = r0.get((com.deliveryhero.fluid.template.data.TemplateUiData) r14, r1)
            r2 = r0
            com.deliveryhero.fluid.values.Shape r2 = (com.deliveryhero.fluid.values.Shape) r2
            r9.setShape(r2)
            java.lang.Object r0 = r19.getTag()
            boolean r1 = r0 instanceof com.deliveryhero.fluid.widgets.utils.WidgetTags
            if (r1 == 0) goto L_0x027a
            com.deliveryhero.fluid.widgets.utils.WidgetTags r0 = (com.deliveryhero.fluid.widgets.utils.WidgetTags) r0
            goto L_0x027b
        L_0x027a:
            r0 = r8
        L_0x027b:
            if (r0 != 0) goto L_0x0281
            com.deliveryhero.fluid.widgets.utils.WidgetTags r0 = com.deliveryhero.fluid.widgets.utils.WidgetTagsKt.initWidgetTags(r19)
        L_0x0281:
            r3 = r0
            com.deliveryhero.fluid.expression.Expression r0 = r20.getBackgroundCornerRadiusTopLeft()
            com.deliveryhero.fluid.expression.Expression r1 = r16.getBackgroundCornerRadiusTopLeft()
            java.lang.Object r0 = r0.get((com.deliveryhero.fluid.template.data.TemplateUiData) r14, r1)
            com.deliveryhero.fluid.values.LogicalPixel r0 = (com.deliveryhero.fluid.values.LogicalPixel) r0
            android.content.Context r1 = r19.getContext()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r13)
            float r0 = r0.getValue()
            android.content.res.Resources r1 = r1.getResources()
            android.util.DisplayMetrics r1 = r1.getDisplayMetrics()
            r4 = 1
            float r5 = android.util.TypedValue.applyDimension(r4, r0, r1)
            com.deliveryhero.fluid.expression.Expression r0 = r20.getBackgroundCornerRadiusTopRight()
            com.deliveryhero.fluid.expression.Expression r1 = r16.getBackgroundCornerRadiusTopRight()
            java.lang.Object r0 = r0.get((com.deliveryhero.fluid.template.data.TemplateUiData) r14, r1)
            com.deliveryhero.fluid.values.LogicalPixel r0 = (com.deliveryhero.fluid.values.LogicalPixel) r0
            android.content.Context r1 = r19.getContext()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r13)
            float r0 = r0.getValue()
            android.content.res.Resources r1 = r1.getResources()
            android.util.DisplayMetrics r1 = r1.getDisplayMetrics()
            float r6 = android.util.TypedValue.applyDimension(r4, r0, r1)
            com.deliveryhero.fluid.expression.Expression r0 = r20.getBackgroundCornerRadiusBottomRight()
            com.deliveryhero.fluid.expression.Expression r1 = r16.getBackgroundCornerRadiusBottomRight()
            java.lang.Object r0 = r0.get((com.deliveryhero.fluid.template.data.TemplateUiData) r14, r1)
            com.deliveryhero.fluid.values.LogicalPixel r0 = (com.deliveryhero.fluid.values.LogicalPixel) r0
            android.content.Context r1 = r19.getContext()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r13)
            float r0 = r0.getValue()
            android.content.res.Resources r1 = r1.getResources()
            android.util.DisplayMetrics r1 = r1.getDisplayMetrics()
            float r7 = android.util.TypedValue.applyDimension(r4, r0, r1)
            com.deliveryhero.fluid.expression.Expression r0 = r20.getBackgroundCornerRadiusBottomLeft()
            com.deliveryhero.fluid.expression.Expression r1 = r16.getBackgroundCornerRadiusBottomLeft()
            java.lang.Object r0 = r0.get((com.deliveryhero.fluid.template.data.TemplateUiData) r14, r1)
            com.deliveryhero.fluid.values.LogicalPixel r0 = (com.deliveryhero.fluid.values.LogicalPixel) r0
            android.content.Context r1 = r19.getContext()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r13)
            float r0 = r0.getValue()
            android.content.res.Resources r1 = r1.getResources()
            android.util.DisplayMetrics r1 = r1.getDisplayMetrics()
            float r10 = android.util.TypedValue.applyDimension(r4, r0, r1)
            r0 = r9
            r1 = r19
            r4 = r5
            r5 = r6
            r6 = r7
            r7 = r10
            r0.setCornerRadius(r1, r2, r3, r4, r5, r6, r7)
            java.lang.Object r0 = r19.getTag()
            boolean r1 = r0 instanceof com.deliveryhero.fluid.widgets.utils.WidgetTags
            if (r1 == 0) goto L_0x032c
            r8 = r0
            com.deliveryhero.fluid.widgets.utils.WidgetTags r8 = (com.deliveryhero.fluid.widgets.utils.WidgetTags) r8
        L_0x032c:
            if (r8 != 0) goto L_0x0332
            com.deliveryhero.fluid.widgets.utils.WidgetTags r8 = com.deliveryhero.fluid.widgets.utils.WidgetTagsKt.initWidgetTags(r19)
        L_0x0332:
            com.deliveryhero.fluid.expression.Expression r0 = r20.getBorderWidth()
            com.deliveryhero.fluid.expression.Expression r1 = r16.getBorderWidth()
            java.lang.Object r0 = r0.get((com.deliveryhero.fluid.template.data.TemplateUiData) r14, r1)
            com.deliveryhero.fluid.values.LogicalPixel r0 = (com.deliveryhero.fluid.values.LogicalPixel) r0
            android.content.Context r1 = r19.getContext()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r13)
            float r0 = r0.getValue()
            android.content.res.Resources r1 = r1.getResources()
            android.util.DisplayMetrics r1 = r1.getDisplayMetrics()
            r2 = 1
            float r0 = android.util.TypedValue.applyDimension(r2, r0, r1)
            int r0 = (int) r0
            com.deliveryhero.fluid.expression.Expression r1 = r20.getBorderColor()
            com.deliveryhero.fluid.expression.Expression r2 = r16.getBorderColor()
            java.lang.Object r1 = r1.get((com.deliveryhero.fluid.template.data.TemplateUiData) r14, r2)
            com.deliveryhero.fluid.values.Color r1 = (com.deliveryhero.fluid.values.Color) r1
            r9.setBorder(r8, r0, r1)
        L_0x036a:
            com.deliveryhero.fluid.expression.Expression r0 = r20.getClipToBounds()
            com.deliveryhero.fluid.expression.Expression r1 = r16.getClipToBounds()
            java.lang.Object r0 = r0.get((com.deliveryhero.fluid.template.data.TemplateUiData) r14, r1)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            com.deliveryhero.fluid.widgets.utils.WidgetUtilsKt.updateClipToBounds(r12, r0)
            com.deliveryhero.fluid.expression.Expression r0 = r20.getElevation()
            com.deliveryhero.fluid.expression.Expression r1 = r16.getElevation()
            java.lang.Object r0 = r0.get((com.deliveryhero.fluid.template.data.TemplateUiData) r14, r1)
            com.deliveryhero.fluid.values.LogicalPixel r0 = (com.deliveryhero.fluid.values.LogicalPixel) r0
            android.content.Context r1 = r19.getContext()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r13)
            float r0 = r0.getValue()
            android.content.res.Resources r1 = r1.getResources()
            android.util.DisplayMetrics r1 = r1.getDisplayMetrics()
            r2 = 1
            float r0 = android.util.TypedValue.applyDimension(r2, r0, r1)
            androidx.core.view.ViewCompat.setElevation(r12, r0)
            com.deliveryhero.fluid.expression.Expression r0 = r20.getAccessibilityLabel()
            com.deliveryhero.fluid.expression.Expression r1 = r16.getAccessibilityLabel()
            java.lang.Object r0 = r0.getOrNull(r14, r1)
            java.lang.String r0 = (java.lang.String) r0
            com.deliveryhero.fluid.expression.Expression r1 = r20.getAccessibilityId()
            com.deliveryhero.fluid.expression.Expression r2 = r16.getAccessibilityId()
            java.lang.Object r1 = r1.getOrNull(r14, r2)
            java.lang.String r1 = (java.lang.String) r1
            com.deliveryhero.fluid.widgets.utils.WidgetUtilsKt.updateAccessibility(r12, r0, r1)
            com.deliveryhero.fluid.expression.Expression r0 = r20.getOnClick()
            com.deliveryhero.fluid.expression.Expression r1 = r16.getOnClick()
            java.lang.Object r0 = r0.getOrNull(r14, r1)
            java.lang.String r0 = (java.lang.String) r0
            r1 = r21
            com.deliveryhero.fluid.widgets.utils.ClickUtilsKt.updateOnClick(r12, r1, r0, r14)
            return
        L_0x03db:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "Defaults not initialized"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.deliveryhero.fluid.widgets.AndroidWidgetFactory.c(android.view.View, com.deliveryhero.fluid.widgets.WidgetModel$BaseProperties, com.deliveryhero.fluid.Host, com.deliveryhero.fluid.template.data.TemplateUiData):void");
    }

    @NotNull
    public final Context getContext() {
        return this.context;
    }
}
