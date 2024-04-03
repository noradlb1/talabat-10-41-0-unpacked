package com.talabat.darkstores.feature.home.banner;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.talabat.darkstores.R;
import com.talabat.darkstores.common.bindingAdapters.BindingAdaptersKt;
import com.talabat.darkstores.common.bindingAdapters.ResizeStrategy;
import com.talabat.darkstores.feature.home.LoopingPagerAdapter;
import com.talabat.darkstores.model.Banner;
import ej.a;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B%\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00020\u001d\u0012\u0006\u0010 \u001a\u00020\u001f¢\u0006\u0004\b!\u0010\"J \u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0003H\u0014J \u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0014R\u0017\u0010\u000e\u001a\u00020\r8\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011RT\u0010\u0017\u001a4\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00128\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006#"}, d2 = {"Lcom/talabat/darkstores/feature/home/banner/BannerPagerAdapter;", "Lcom/talabat/darkstores/feature/home/LoopingPagerAdapter;", "Lcom/talabat/darkstores/model/Banner;", "", "viewType", "Landroid/view/ViewGroup;", "container", "listPosition", "Landroid/view/View;", "b", "convertView", "", "a", "Landroid/content/Context;", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "banner", "position", "onBannerClickedListener", "Lkotlin/jvm/functions/Function2;", "getOnBannerClickedListener", "()Lkotlin/jvm/functions/Function2;", "setOnBannerClickedListener", "(Lkotlin/jvm/functions/Function2;)V", "", "itemList", "", "isInfinite", "<init>", "(Landroid/content/Context;Ljava/util/List;Z)V", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0})
public final class BannerPagerAdapter extends LoopingPagerAdapter<Banner> {
    @NotNull
    private final Context context;
    @Nullable
    private Function2<? super Banner, ? super Integer, Unit> onBannerClickedListener;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BannerPagerAdapter(@NotNull Context context2, @NotNull List<Banner> list, boolean z11) {
        super(list, z11);
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(list, "itemList");
        this.context = context2;
    }

    /* access modifiers changed from: private */
    /* renamed from: bindView$lambda-0  reason: not valid java name */
    public static final void m9974bindView$lambda0(BannerPagerAdapter bannerPagerAdapter, int i11, View view) {
        Intrinsics.checkNotNullParameter(bannerPagerAdapter, "this$0");
        Function2<? super Banner, ? super Integer, Unit> function2 = bannerPagerAdapter.onBannerClickedListener;
        if (function2 != null) {
            function2.invoke(bannerPagerAdapter.getItemList().get(i11), Integer.valueOf(i11));
        }
    }

    public void a(@NotNull View view, int i11, int i12) {
        Intrinsics.checkNotNullParameter(view, "convertView");
        BindingAdaptersKt.loadImageWithGlide((ImageView) view, ((Banner) getItemList().get(i11)).getBannerUrl(), (Integer) null, ResizeStrategy.Default, new RoundedCorners(this.context.getResources().getDimensionPixelSize(R.dimen.default_corner_radius)), Integer.MIN_VALUE);
        view.setOnClickListener(new a(this, i11));
    }

    @NotNull
    public View b(int i11, @NotNull ViewGroup viewGroup, int i12) {
        Intrinsics.checkNotNullParameter(viewGroup, TtmlNode.RUBY_CONTAINER);
        View inflate = LayoutInflater.from(this.context).inflate(R.layout.darkstores_item_banner_pager, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(context)\n          …_pager, container, false)");
        return inflate;
    }

    @NotNull
    public final Context getContext() {
        return this.context;
    }

    @Nullable
    public final Function2<Banner, Integer, Unit> getOnBannerClickedListener() {
        return this.onBannerClickedListener;
    }

    public final void setOnBannerClickedListener(@Nullable Function2<? super Banner, ? super Integer, Unit> function2) {
        this.onBannerClickedListener = function2;
    }
}
