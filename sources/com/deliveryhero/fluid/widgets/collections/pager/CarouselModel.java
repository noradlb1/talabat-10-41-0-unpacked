package com.deliveryhero.fluid.widgets.collections.pager;

import com.deliveryhero.fluid.expression.Expression;
import com.deliveryhero.fluid.values.LogicalPixel;
import com.deliveryhero.fluid.values.Size;
import com.deliveryhero.fluid.widgets.WidgetModel;
import com.deliveryhero.fluid.widgets.collections.CollectionModel;
import com.deliveryhero.fluid.widgets.collections.pager.indicators.PagerDotsIndicatorModel;
import com.talabat.fluid.homescreen.data.parser.ComponentMapper;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001Ba\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004\u0012\u0012\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u000b0\u0004\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0004\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0002\u0010\u0012J\u000f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0003J\u000f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004HÆ\u0003J\u000f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\t0\u0004HÆ\u0003J\u0015\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u000b0\u0004HÆ\u0003J\u000f\u0010!\u001a\b\u0012\u0004\u0012\u00020\r0\u0004HÆ\u0003J\t\u0010\"\u001a\u00020\u000fHÆ\u0003J\t\u0010#\u001a\u00020\u0011HÆ\u0003Js\u0010$\u001a\u00020\u00002\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u00042\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00042\u0014\b\u0002\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u000b0\u00042\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u00042\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u0011HÆ\u0001J\u0013\u0010%\u001a\u00020\u00052\b\u0010&\u001a\u0004\u0018\u00010'HÖ\u0003J\t\u0010(\u001a\u00020\u0007HÖ\u0001J\t\u0010)\u001a\u00020*HÖ\u0001R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0014\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0014R \u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u000b0\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0014R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u0006+"}, d2 = {"Lcom/deliveryhero/fluid/widgets/collections/pager/CarouselModel;", "Lcom/deliveryhero/fluid/widgets/collections/CollectionModel;", "Lcom/deliveryhero/fluid/widgets/collections/pager/PagerCell;", "autoScrollEnabled", "Lcom/deliveryhero/fluid/expression/Expression;", "", "autoScrollDelayInMillis", "", "cellWidthRatio", "Lcom/deliveryhero/fluid/values/Size;", "cells", "", "cellSpacing", "Lcom/deliveryhero/fluid/values/LogicalPixel;", "indicator", "Lcom/deliveryhero/fluid/widgets/collections/pager/indicators/PagerDotsIndicatorModel;", "baseProperties", "Lcom/deliveryhero/fluid/widgets/WidgetModel$BaseProperties;", "(Lcom/deliveryhero/fluid/expression/Expression;Lcom/deliveryhero/fluid/expression/Expression;Lcom/deliveryhero/fluid/expression/Expression;Lcom/deliveryhero/fluid/expression/Expression;Lcom/deliveryhero/fluid/expression/Expression;Lcom/deliveryhero/fluid/widgets/collections/pager/indicators/PagerDotsIndicatorModel;Lcom/deliveryhero/fluid/widgets/WidgetModel$BaseProperties;)V", "getAutoScrollDelayInMillis", "()Lcom/deliveryhero/fluid/expression/Expression;", "getAutoScrollEnabled", "getBaseProperties", "()Lcom/deliveryhero/fluid/widgets/WidgetModel$BaseProperties;", "getCellSpacing", "getCellWidthRatio", "getCells", "getIndicator", "()Lcom/deliveryhero/fluid/widgets/collections/pager/indicators/PagerDotsIndicatorModel;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "", "hashCode", "toString", "", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CarouselModel implements CollectionModel<PagerCell> {
    @NotNull
    private final Expression<Integer> autoScrollDelayInMillis;
    @NotNull
    private final Expression<Boolean> autoScrollEnabled;
    @NotNull
    private final WidgetModel.BaseProperties baseProperties;
    @NotNull
    private final Expression<LogicalPixel> cellSpacing;
    @NotNull
    private final Expression<Size> cellWidthRatio;
    @NotNull
    private final Expression<List<PagerCell>> cells;
    @NotNull
    private final PagerDotsIndicatorModel indicator;

    public CarouselModel(@NotNull Expression<Boolean> expression, @NotNull Expression<Integer> expression2, @NotNull Expression<Size> expression3, @NotNull Expression<List<PagerCell>> expression4, @NotNull Expression<LogicalPixel> expression5, @NotNull PagerDotsIndicatorModel pagerDotsIndicatorModel, @NotNull WidgetModel.BaseProperties baseProperties2) {
        Intrinsics.checkNotNullParameter(expression, "autoScrollEnabled");
        Intrinsics.checkNotNullParameter(expression2, "autoScrollDelayInMillis");
        Intrinsics.checkNotNullParameter(expression3, "cellWidthRatio");
        Intrinsics.checkNotNullParameter(expression4, ComponentMapper.CELLS);
        Intrinsics.checkNotNullParameter(expression5, "cellSpacing");
        Intrinsics.checkNotNullParameter(pagerDotsIndicatorModel, "indicator");
        Intrinsics.checkNotNullParameter(baseProperties2, "baseProperties");
        this.autoScrollEnabled = expression;
        this.autoScrollDelayInMillis = expression2;
        this.cellWidthRatio = expression3;
        this.cells = expression4;
        this.cellSpacing = expression5;
        this.indicator = pagerDotsIndicatorModel;
        this.baseProperties = baseProperties2;
    }

    public static /* synthetic */ CarouselModel copy$default(CarouselModel carouselModel, Expression<Boolean> expression, Expression<Integer> expression2, Expression<Size> expression3, Expression<List<PagerCell>> expression4, Expression<LogicalPixel> expression5, PagerDotsIndicatorModel pagerDotsIndicatorModel, WidgetModel.BaseProperties baseProperties2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            expression = carouselModel.autoScrollEnabled;
        }
        if ((i11 & 2) != 0) {
            expression2 = carouselModel.autoScrollDelayInMillis;
        }
        Expression<Integer> expression6 = expression2;
        if ((i11 & 4) != 0) {
            expression3 = carouselModel.cellWidthRatio;
        }
        Expression<Size> expression7 = expression3;
        if ((i11 & 8) != 0) {
            expression4 = carouselModel.getCells();
        }
        Expression<List<PagerCell>> expression8 = expression4;
        if ((i11 & 16) != 0) {
            expression5 = carouselModel.getCellSpacing();
        }
        Expression<LogicalPixel> expression9 = expression5;
        if ((i11 & 32) != 0) {
            pagerDotsIndicatorModel = carouselModel.indicator;
        }
        PagerDotsIndicatorModel pagerDotsIndicatorModel2 = pagerDotsIndicatorModel;
        if ((i11 & 64) != 0) {
            baseProperties2 = carouselModel.getBaseProperties();
        }
        return carouselModel.copy(expression, expression6, expression7, expression8, expression9, pagerDotsIndicatorModel2, baseProperties2);
    }

    @NotNull
    public final Expression<Boolean> component1() {
        return this.autoScrollEnabled;
    }

    @NotNull
    public final Expression<Integer> component2() {
        return this.autoScrollDelayInMillis;
    }

    @NotNull
    public final Expression<Size> component3() {
        return this.cellWidthRatio;
    }

    @NotNull
    public final Expression<List<PagerCell>> component4() {
        return getCells();
    }

    @NotNull
    public final Expression<LogicalPixel> component5() {
        return getCellSpacing();
    }

    @NotNull
    public final PagerDotsIndicatorModel component6() {
        return this.indicator;
    }

    @NotNull
    public final WidgetModel.BaseProperties component7() {
        return getBaseProperties();
    }

    @NotNull
    public final CarouselModel copy(@NotNull Expression<Boolean> expression, @NotNull Expression<Integer> expression2, @NotNull Expression<Size> expression3, @NotNull Expression<List<PagerCell>> expression4, @NotNull Expression<LogicalPixel> expression5, @NotNull PagerDotsIndicatorModel pagerDotsIndicatorModel, @NotNull WidgetModel.BaseProperties baseProperties2) {
        Intrinsics.checkNotNullParameter(expression, "autoScrollEnabled");
        Intrinsics.checkNotNullParameter(expression2, "autoScrollDelayInMillis");
        Intrinsics.checkNotNullParameter(expression3, "cellWidthRatio");
        Intrinsics.checkNotNullParameter(expression4, ComponentMapper.CELLS);
        Intrinsics.checkNotNullParameter(expression5, "cellSpacing");
        Intrinsics.checkNotNullParameter(pagerDotsIndicatorModel, "indicator");
        WidgetModel.BaseProperties baseProperties3 = baseProperties2;
        Intrinsics.checkNotNullParameter(baseProperties3, "baseProperties");
        return new CarouselModel(expression, expression2, expression3, expression4, expression5, pagerDotsIndicatorModel, baseProperties3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CarouselModel)) {
            return false;
        }
        CarouselModel carouselModel = (CarouselModel) obj;
        return Intrinsics.areEqual((Object) this.autoScrollEnabled, (Object) carouselModel.autoScrollEnabled) && Intrinsics.areEqual((Object) this.autoScrollDelayInMillis, (Object) carouselModel.autoScrollDelayInMillis) && Intrinsics.areEqual((Object) this.cellWidthRatio, (Object) carouselModel.cellWidthRatio) && Intrinsics.areEqual((Object) getCells(), (Object) carouselModel.getCells()) && Intrinsics.areEqual((Object) getCellSpacing(), (Object) carouselModel.getCellSpacing()) && Intrinsics.areEqual((Object) this.indicator, (Object) carouselModel.indicator) && Intrinsics.areEqual((Object) getBaseProperties(), (Object) carouselModel.getBaseProperties());
    }

    @NotNull
    public final Expression<Integer> getAutoScrollDelayInMillis() {
        return this.autoScrollDelayInMillis;
    }

    @NotNull
    public final Expression<Boolean> getAutoScrollEnabled() {
        return this.autoScrollEnabled;
    }

    @NotNull
    public WidgetModel.BaseProperties getBaseProperties() {
        return this.baseProperties;
    }

    @NotNull
    public Expression<LogicalPixel> getCellSpacing() {
        return this.cellSpacing;
    }

    @NotNull
    public final Expression<Size> getCellWidthRatio() {
        return this.cellWidthRatio;
    }

    @NotNull
    public Expression<List<PagerCell>> getCells() {
        return this.cells;
    }

    @NotNull
    public final PagerDotsIndicatorModel getIndicator() {
        return this.indicator;
    }

    public int hashCode() {
        return (((((((((((this.autoScrollEnabled.hashCode() * 31) + this.autoScrollDelayInMillis.hashCode()) * 31) + this.cellWidthRatio.hashCode()) * 31) + getCells().hashCode()) * 31) + getCellSpacing().hashCode()) * 31) + this.indicator.hashCode()) * 31) + getBaseProperties().hashCode();
    }

    @NotNull
    public String toString() {
        return "CarouselModel(autoScrollEnabled=" + this.autoScrollEnabled + ", autoScrollDelayInMillis=" + this.autoScrollDelayInMillis + ", cellWidthRatio=" + this.cellWidthRatio + ", cells=" + getCells() + ", cellSpacing=" + getCellSpacing() + ", indicator=" + this.indicator + ", baseProperties=" + getBaseProperties() + ')';
    }
}
