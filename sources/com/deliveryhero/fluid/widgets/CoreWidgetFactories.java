package com.deliveryhero.fluid.widgets;

import android.content.Context;
import com.deliveryhero.fluid.widgets.collections.grid.horizontal.HorizontalGridFactory;
import com.deliveryhero.fluid.widgets.collections.grid.horizontal.HorizontalGridModel;
import com.deliveryhero.fluid.widgets.collections.grid.vertical.VerticalGridFactory;
import com.deliveryhero.fluid.widgets.collections.grid.vertical.VerticalGridModel;
import com.deliveryhero.fluid.widgets.collections.list.ListFactory;
import com.deliveryhero.fluid.widgets.collections.list.ListModel;
import com.deliveryhero.fluid.widgets.collections.pager.CarouselFactory;
import com.deliveryhero.fluid.widgets.collections.pager.CarouselModel;
import com.deliveryhero.fluid.widgets.collections.pager.PagerFactory;
import com.deliveryhero.fluid.widgets.collections.pager.PagerModel;
import com.deliveryhero.fluid.widgets.containers.column.ColumnFactory;
import com.deliveryhero.fluid.widgets.containers.column.ColumnModel;
import com.deliveryhero.fluid.widgets.containers.row.RowFactory;
import com.deliveryhero.fluid.widgets.containers.row.RowModel;
import com.deliveryhero.fluid.widgets.containers.stack.StackFactory;
import com.deliveryhero.fluid.widgets.containers.stack.StackModel;
import com.deliveryhero.fluid.widgets.image.ImageFactory;
import com.deliveryhero.fluid.widgets.image.ImageModel;
import com.deliveryhero.fluid.widgets.lottie.LottieModel;
import com.deliveryhero.fluid.widgets.lottie.LottieWidgetFactory;
import com.deliveryhero.fluid.widgets.plain.PlainFactory;
import com.deliveryhero.fluid.widgets.plain.PlainModel;
import com.deliveryhero.fluid.widgets.space.SpaceFactory;
import com.deliveryhero.fluid.widgets.space.SpaceModel;
import com.deliveryhero.fluid.widgets.text.TextFactory;
import com.deliveryhero.fluid.widgets.text.TextModel;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u00102\u001a\u000201¢\u0006\u0004\b3\u00104J(\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\"\b\b\u0000\u0010\u0003*\u00020\u00022\u0006\u0010\u0004\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u0006\u0010\u0007R \u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00058\u0014X\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR \u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u00058\u0014X\u0004¢\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\fR \u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u00058\u0014X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\n\u001a\u0004\b\u0012\u0010\fR \u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00058\u0014X\u0004¢\u0006\f\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0015\u0010\fR \u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00058\u0014X\u0004¢\u0006\f\n\u0004\b\u0017\u0010\n\u001a\u0004\b\u0018\u0010\fR \u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u00058\u0014X\u0004¢\u0006\f\n\u0004\b\u001a\u0010\n\u001a\u0004\b\u001b\u0010\fR \u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00058\u0014X\u0004¢\u0006\f\n\u0004\b\u001d\u0010\n\u001a\u0004\b\u001e\u0010\fR \u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0\u00058\u0014X\u0004¢\u0006\f\n\u0004\b \u0010\n\u001a\u0004\b!\u0010\fR \u0010#\u001a\b\u0012\u0004\u0012\u00020\"0\u00058\u0014X\u0004¢\u0006\f\n\u0004\b#\u0010\n\u001a\u0004\b$\u0010\fR \u0010&\u001a\b\u0012\u0004\u0012\u00020%0\u00058\u0014X\u0004¢\u0006\f\n\u0004\b&\u0010\n\u001a\u0004\b'\u0010\fR \u0010)\u001a\b\u0012\u0004\u0012\u00020(0\u00058\u0014X\u0004¢\u0006\f\n\u0004\b)\u0010\n\u001a\u0004\b*\u0010\fR \u0010,\u001a\b\u0012\u0004\u0012\u00020+0\u00058\u0014X\u0004¢\u0006\f\n\u0004\b,\u0010\n\u001a\u0004\b-\u0010\fR \u0010/\u001a\b\u0012\u0004\u0012\u00020.0\u00058\u0014X\u0004¢\u0006\f\n\u0004\b/\u0010\n\u001a\u0004\b0\u0010\f¨\u00065"}, d2 = {"Lcom/deliveryhero/fluid/widgets/CoreWidgetFactories;", "Lcom/deliveryhero/fluid/widgets/WidgetFactories;", "Lcom/deliveryhero/fluid/widgets/WidgetModel;", "ModelT", "model", "Lcom/deliveryhero/fluid/widgets/WidgetFactory;", "get", "(Lcom/deliveryhero/fluid/widgets/WidgetModel;)Lcom/deliveryhero/fluid/widgets/WidgetFactory;", "Lcom/deliveryhero/fluid/widgets/collections/pager/PagerModel;", "pagerFactory", "Lcom/deliveryhero/fluid/widgets/WidgetFactory;", "g", "()Lcom/deliveryhero/fluid/widgets/WidgetFactory;", "Lcom/deliveryhero/fluid/widgets/collections/grid/vertical/VerticalGridModel;", "verticalGridFactory", "m", "Lcom/deliveryhero/fluid/widgets/collections/grid/horizontal/HorizontalGridModel;", "horizontalGridFactory", "c", "Lcom/deliveryhero/fluid/widgets/collections/pager/CarouselModel;", "carouselFactory", "a", "Lcom/deliveryhero/fluid/widgets/collections/list/ListModel;", "listFactory", "e", "Lcom/deliveryhero/fluid/widgets/containers/column/ColumnModel;", "columnFactory", "b", "Lcom/deliveryhero/fluid/widgets/containers/row/RowModel;", "rowFactory", "i", "Lcom/deliveryhero/fluid/widgets/containers/stack/StackModel;", "stackFactory", "k", "Lcom/deliveryhero/fluid/widgets/image/ImageModel;", "imageFactory", "d", "Lcom/deliveryhero/fluid/widgets/lottie/LottieModel;", "lottieFactory", "f", "Lcom/deliveryhero/fluid/widgets/plain/PlainModel;", "plainFactory", "h", "Lcom/deliveryhero/fluid/widgets/space/SpaceModel;", "spaceFactory", "j", "Lcom/deliveryhero/fluid/widgets/text/TextModel;", "textFactory", "l", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "core_release"}, k = 1, mv = {1, 6, 0})
public class CoreWidgetFactories implements WidgetFactories {
    @NotNull
    private final WidgetFactory<CarouselModel> carouselFactory;
    @NotNull
    private final WidgetFactory<ColumnModel> columnFactory;
    @NotNull
    private final WidgetFactory<HorizontalGridModel> horizontalGridFactory;
    @NotNull
    private final WidgetFactory<ImageModel> imageFactory;
    @NotNull
    private final WidgetFactory<ListModel> listFactory;
    @NotNull
    private final WidgetFactory<LottieModel> lottieFactory;
    @NotNull
    private final WidgetFactory<PagerModel> pagerFactory;
    @NotNull
    private final WidgetFactory<PlainModel> plainFactory;
    @NotNull
    private final WidgetFactory<RowModel> rowFactory;
    @NotNull
    private final WidgetFactory<SpaceModel> spaceFactory;
    @NotNull
    private final WidgetFactory<StackModel> stackFactory;
    @NotNull
    private final WidgetFactory<TextModel> textFactory;
    @NotNull
    private final WidgetFactory<VerticalGridModel> verticalGridFactory;

    public CoreWidgetFactories(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.pagerFactory = new PagerFactory(context);
        this.verticalGridFactory = new VerticalGridFactory(context);
        this.horizontalGridFactory = new HorizontalGridFactory(context);
        this.carouselFactory = new CarouselFactory(context);
        this.listFactory = new ListFactory(context);
        this.columnFactory = new ColumnFactory(context);
        this.rowFactory = new RowFactory(context);
        this.stackFactory = new StackFactory(context);
        this.imageFactory = new ImageFactory(context);
        this.lottieFactory = new LottieWidgetFactory(context);
        this.plainFactory = new PlainFactory(context);
        this.spaceFactory = new SpaceFactory(context);
        this.textFactory = new TextFactory(context);
    }

    @NotNull
    public WidgetFactory<CarouselModel> a() {
        return this.carouselFactory;
    }

    @NotNull
    public WidgetFactory<ColumnModel> b() {
        return this.columnFactory;
    }

    @NotNull
    public WidgetFactory<HorizontalGridModel> c() {
        return this.horizontalGridFactory;
    }

    @NotNull
    public WidgetFactory<ImageModel> d() {
        return this.imageFactory;
    }

    @NotNull
    public WidgetFactory<ListModel> e() {
        return this.listFactory;
    }

    @NotNull
    public WidgetFactory<LottieModel> f() {
        return this.lottieFactory;
    }

    @NotNull
    public WidgetFactory<PagerModel> g() {
        return this.pagerFactory;
    }

    @NotNull
    public <ModelT extends WidgetModel> WidgetFactory<ModelT> get(@NotNull ModelT modelt) {
        Intrinsics.checkNotNullParameter(modelt, DeviceRequestsHelper.DEVICE_INFO_MODEL);
        if (modelt instanceof PagerModel) {
            return g();
        }
        if (modelt instanceof VerticalGridModel) {
            return m();
        }
        if (modelt instanceof HorizontalGridModel) {
            return c();
        }
        if (modelt instanceof CarouselModel) {
            return a();
        }
        if (modelt instanceof ListModel) {
            return e();
        }
        if (modelt instanceof ColumnModel) {
            return b();
        }
        if (modelt instanceof RowModel) {
            return i();
        }
        if (modelt instanceof StackModel) {
            return k();
        }
        if (modelt instanceof ImageModel) {
            return d();
        }
        if (modelt instanceof LottieModel) {
            return f();
        }
        if (modelt instanceof PlainModel) {
            return h();
        }
        if (modelt instanceof SpaceModel) {
            return j();
        }
        if (modelt instanceof TextModel) {
            return l();
        }
        throw new IllegalArgumentException('`' + Reflection.getOrCreateKotlinClass(modelt.getClass()).getQualifiedName() + "` is not registered in CoreWidgetFactories");
    }

    @NotNull
    public WidgetFactory<PlainModel> h() {
        return this.plainFactory;
    }

    @NotNull
    public WidgetFactory<RowModel> i() {
        return this.rowFactory;
    }

    @NotNull
    public WidgetFactory<SpaceModel> j() {
        return this.spaceFactory;
    }

    @NotNull
    public WidgetFactory<StackModel> k() {
        return this.stackFactory;
    }

    @NotNull
    public WidgetFactory<TextModel> l() {
        return this.textFactory;
    }

    @NotNull
    public WidgetFactory<VerticalGridModel> m() {
        return this.verticalGridFactory;
    }
}
