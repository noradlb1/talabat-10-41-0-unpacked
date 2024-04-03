package com.talabat.darkstores.feature.home;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.load.Transformation;
import com.talabat.darkstores.R;
import com.talabat.darkstores.common.bindingAdapters.BindingAdaptersKt;
import com.talabat.darkstores.common.bindingAdapters.ResizeStrategy;
import com.talabat.darkstores.common.extensions.ViewExtensionsKt;
import com.talabat.darkstores.data.discovery.model.ImageUrl;
import com.talabat.darkstores.model.Category;
import com.talabat.talabatcommon.extension.ViewKt;
import dj.a;
import dj.b;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.extensions.LayoutContainer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0006\b\u0000\u0018\u0000 &2\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0004&'()Bm\u0012:\u0010\u0004\u001a6\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0005j\u0002`\r\u0012\u0016\b\u0002\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\f\u0018\u00010\u000fj\u0004\u0018\u0001`\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0013\u001a\u00020\n¢\u0006\u0002\u0010\u0014J\u0010\u0010\u001a\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u001c\u0010\u001b\u001a\u00020\f2\n\u0010\u001c\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u001c\u0010\u001d\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\nH\u0016J\u0014\u0010!\u001a\u00020\f2\n\u0010\u001c\u001a\u00060\u0003R\u00020\u0000H\u0016J\u0014\u0010\"\u001a\u00020\f2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00060$J\u0014\u0010%\u001a\u00020\f2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00060$R\u001e\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0012@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u000e\u0010\u0019\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000RB\u0010\u0004\u001a6\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0005j\u0002`\rX\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\f\u0018\u00010\u000fj\u0004\u0018\u0001`\u0010X\u0004¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/talabat/darkstores/feature/home/CategoriesListAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/talabat/darkstores/feature/home/CategoriesListAdapter$Tile;", "Lcom/talabat/darkstores/feature/home/CategoriesListAdapter$ViewHolder;", "onCategoryClicked", "Lkotlin/Function2;", "Lcom/talabat/darkstores/model/Category;", "Lkotlin/ParameterName;", "name", "item", "", "position", "", "Lcom/talabat/darkstores/feature/home/OnCategoryClicked;", "onViewAllClicked", "Lkotlin/Function0;", "Lcom/talabat/darkstores/feature/home/OnStaticTileClicked;", "limitTiles", "", "categoriesRowsCount", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;ZI)V", "<set-?>", "isSearchCategory", "()Z", "getLimitTiles", "maxCount", "getItemViewType", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onViewRecycled", "submitCategories", "categories", "", "submitSearchCategories", "Companion", "DiffCallback", "Tile", "ViewHolder", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CategoriesListAdapter extends ListAdapter<Tile, ViewHolder> {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int MAX_COUNT = 4;
    private boolean isSearchCategory;
    private final boolean limitTiles;
    private final int maxCount;
    @NotNull
    private final Function2<Category, Integer, Unit> onCategoryClicked;
    @Nullable
    private final Function0<Unit> onViewAllClicked;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/talabat/darkstores/feature/home/CategoriesListAdapter$Companion;", "", "()V", "MAX_COUNT", "", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¨\u0006\t"}, d2 = {"Lcom/talabat/darkstores/feature/home/CategoriesListAdapter$DiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/talabat/darkstores/feature/home/CategoriesListAdapter$Tile;", "()V", "areContentsTheSame", "", "old", "new", "areItemsTheSame", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class DiffCallback extends DiffUtil.ItemCallback<Tile> {
        public boolean areContentsTheSame(@NotNull Tile tile, @NotNull Tile tile2) {
            Intrinsics.checkNotNullParameter(tile, "old");
            Intrinsics.checkNotNullParameter(tile2, "new");
            return Intrinsics.areEqual((Object) tile, (Object) tile2);
        }

        public boolean areItemsTheSame(@NotNull Tile tile, @NotNull Tile tile2) {
            Intrinsics.checkNotNullParameter(tile, "old");
            Intrinsics.checkNotNullParameter(tile2, "new");
            return Intrinsics.areEqual((Object) tile.getId(), (Object) tile2.getId());
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0002\u0007\bB\u0007\b\u0004¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u0001\u0002\t\n¨\u0006\u000b"}, d2 = {"Lcom/talabat/darkstores/feature/home/CategoriesListAdapter$Tile;", "", "()V", "id", "", "getId", "()Ljava/lang/String;", "Category", "ViewAll", "Lcom/talabat/darkstores/feature/home/CategoriesListAdapter$Tile$Category;", "Lcom/talabat/darkstores/feature/home/CategoriesListAdapter$Tile$ViewAll;", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static abstract class Tile {

        @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/talabat/darkstores/feature/home/CategoriesListAdapter$Tile$Category;", "Lcom/talabat/darkstores/feature/home/CategoriesListAdapter$Tile;", "category", "Lcom/talabat/darkstores/model/Category;", "(Lcom/talabat/darkstores/model/Category;)V", "getCategory", "()Lcom/talabat/darkstores/model/Category;", "id", "", "getId", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class Category extends Tile {
            @NotNull
            private final com.talabat.darkstores.model.Category category;
            @NotNull

            /* renamed from: id  reason: collision with root package name */
            private final String f56373id;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Category(@NotNull com.talabat.darkstores.model.Category category2) {
                super((DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(category2, "category");
                this.category = category2;
                this.f56373id = category2.getId();
            }

            public static /* synthetic */ Category copy$default(Category category2, com.talabat.darkstores.model.Category category3, int i11, Object obj) {
                if ((i11 & 1) != 0) {
                    category3 = category2.category;
                }
                return category2.copy(category3);
            }

            @NotNull
            public final com.talabat.darkstores.model.Category component1() {
                return this.category;
            }

            @NotNull
            public final Category copy(@NotNull com.talabat.darkstores.model.Category category2) {
                Intrinsics.checkNotNullParameter(category2, "category");
                return new Category(category2);
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Category) && Intrinsics.areEqual((Object) this.category, (Object) ((Category) obj).category);
            }

            @NotNull
            public final com.talabat.darkstores.model.Category getCategory() {
                return this.category;
            }

            @NotNull
            public String getId() {
                return this.f56373id;
            }

            public int hashCode() {
                return this.category.hashCode();
            }

            @NotNull
            public String toString() {
                com.talabat.darkstores.model.Category category2 = this.category;
                return "Category(category=" + category2 + ")";
            }
        }

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/talabat/darkstores/feature/home/CategoriesListAdapter$Tile$ViewAll;", "Lcom/talabat/darkstores/feature/home/CategoriesListAdapter$Tile;", "()V", "id", "", "getId", "()Ljava/lang/String;", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class ViewAll extends Tile {
            @NotNull
            public static final ViewAll INSTANCE = new ViewAll();
            @NotNull

            /* renamed from: id  reason: collision with root package name */
            private static final String f56374id = "viewAll";

            private ViewAll() {
                super((DefaultConstructorMarker) null);
            }

            @NotNull
            public String getId() {
                return f56374id;
            }
        }

        private Tile() {
        }

        public /* synthetic */ Tile(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public abstract String getId();
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0016\u0010\u000e\u001a\n \u0010*\u0004\u0018\u00010\u000f0\u000fX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\n \u0010*\u0004\u0018\u00010\u00120\u0012X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/talabat/darkstores/feature/home/CategoriesListAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lkotlinx/android/extensions/LayoutContainer;", "containerView", "Landroid/view/View;", "(Lcom/talabat/darkstores/feature/home/CategoriesListAdapter;Landroid/view/View;)V", "getContainerView", "()Landroid/view/View;", "disposable", "Lio/reactivex/disposables/Disposable;", "getDisposable", "()Lio/reactivex/disposables/Disposable;", "setDisposable", "(Lio/reactivex/disposables/Disposable;)V", "imageView", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "textView", "Landroid/widget/TextView;", "bind", "", "category", "Lcom/talabat/darkstores/model/Category;", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public final class ViewHolder extends RecyclerView.ViewHolder implements LayoutContainer {
        @NotNull
        private final View containerView;
        @Nullable
        private Disposable disposable;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ CategoriesListAdapter f56375h;
        private final ImageView imageView = ((ImageView) getContainerView().findViewById(R.id.imageView));
        private final TextView textView = ((TextView) getContainerView().findViewById(R.id.textView));

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ViewHolder(@NotNull CategoriesListAdapter categoriesListAdapter, View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "containerView");
            this.f56375h = categoriesListAdapter;
            this.containerView = view;
        }

        public final void bind(@NotNull Category category) {
            String str;
            ImageUrl imageUrl;
            Intrinsics.checkNotNullParameter(category, "category");
            ImageView imageView2 = this.imageView;
            Intrinsics.checkNotNullExpressionValue(imageView2, "imageView");
            List<ImageUrl> imageUrls = category.getImageUrls();
            if (imageUrls == null || (imageUrl = (ImageUrl) CollectionsKt___CollectionsKt.firstOrNull(imageUrls)) == null) {
                str = null;
            } else {
                str = imageUrl.getUrl();
            }
            BindingAdaptersKt.loadImageWithGlide$default(imageView2, str, Integer.valueOf(R.drawable.product_tile_placeholder), (ResizeStrategy) null, (Transformation) null, (Integer) null, 28, (Object) null);
            this.textView.setText(category.getName());
        }

        @NotNull
        public View getContainerView() {
            return this.containerView;
        }

        @Nullable
        public final Disposable getDisposable() {
            return this.disposable;
        }

        public final void setDisposable(@Nullable Disposable disposable2) {
            this.disposable = disposable2;
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CategoriesListAdapter(Function2 function2, Function0 function0, boolean z11, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(function2, (i12 & 2) != 0 ? null : function0, (i12 & 4) != 0 ? false : z11, (i12 & 8) != 0 ? 2 : i11);
    }

    /* access modifiers changed from: private */
    /* renamed from: onBindViewHolder$lambda-0  reason: not valid java name */
    public static final void m9943onBindViewHolder$lambda0(CategoriesListAdapter categoriesListAdapter, Tile tile, int i11, Unit unit) {
        Intrinsics.checkNotNullParameter(categoriesListAdapter, "this$0");
        categoriesListAdapter.onCategoryClicked.invoke(((Tile.Category) tile).getCategory(), Integer.valueOf(i11));
    }

    /* access modifiers changed from: private */
    /* renamed from: onBindViewHolder$lambda-1  reason: not valid java name */
    public static final void m9944onBindViewHolder$lambda1(CategoriesListAdapter categoriesListAdapter, Unit unit) {
        Intrinsics.checkNotNullParameter(categoriesListAdapter, "this$0");
        Function0<Unit> function0 = categoriesListAdapter.onViewAllClicked;
        if (function0 != null) {
            function0.invoke();
        }
    }

    public int getItemViewType(int i11) {
        Tile tile = (Tile) getItem(i11);
        if (tile instanceof Tile.Category) {
            return R.layout.darkstores_item_category_tile_new;
        }
        if (Intrinsics.areEqual((Object) tile, (Object) Tile.ViewAll.INSTANCE)) {
            return R.layout.darkstores_item_category_tile_all_new;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final boolean getLimitTiles() {
        return this.limitTiles;
    }

    public final boolean isSearchCategory() {
        return this.isSearchCategory;
    }

    public final void submitCategories(@NotNull List<Category> list) {
        Intrinsics.checkNotNullParameter(list, "categories");
        this.isSearchCategory = false;
        Collection emptyList = CollectionsKt__CollectionsKt.emptyList();
        Iterable<Category> take = CollectionsKt___CollectionsKt.take(list, this.maxCount);
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(take, 10));
        for (Category category : take) {
            arrayList.add(new Tile.Category(category));
        }
        List take2 = CollectionsKt___CollectionsKt.take(CollectionsKt___CollectionsKt.plus(emptyList, arrayList), this.maxCount - 1);
        Tile.ViewAll viewAll = Tile.ViewAll.INSTANCE;
        if (this.limitTiles) {
            take2 = CollectionsKt___CollectionsKt.plus(take2, viewAll);
        }
        super.submitList(take2);
    }

    public final void submitSearchCategories(@NotNull List<Category> list) {
        Intrinsics.checkNotNullParameter(list, "categories");
        this.isSearchCategory = true;
        Iterable<Category> iterable = list;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
        for (Category category : iterable) {
            arrayList.add(new Tile.Category(category));
        }
        super.submitList(arrayList);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CategoriesListAdapter(@NotNull Function2<? super Category, ? super Integer, Unit> function2, @Nullable Function0<Unit> function0, boolean z11, int i11) {
        super(new DiffCallback());
        Intrinsics.checkNotNullParameter(function2, "onCategoryClicked");
        this.onCategoryClicked = function2;
        this.onViewAllClicked = function0;
        this.limitTiles = z11;
        this.maxCount = !z11 ? Integer.MAX_VALUE : i11 * 4;
    }

    public void onBindViewHolder(@NotNull ViewHolder viewHolder, int i11) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        Tile tile = (Tile) getItem(i11);
        if (tile instanceof Tile.Category) {
            viewHolder.bind(((Tile.Category) tile).getCategory());
            View view = viewHolder.itemView;
            Intrinsics.checkNotNullExpressionValue(view, "holder.itemView");
            viewHolder.setDisposable(ViewExtensionsKt.setSingleOnClickListener$default(view, 0, 1, (Object) null).subscribe(new a(this, tile, i11)));
        } else if (Intrinsics.areEqual((Object) tile, (Object) Tile.ViewAll.INSTANCE)) {
            View view2 = viewHolder.itemView;
            Intrinsics.checkNotNullExpressionValue(view2, "holder.itemView");
            viewHolder.setDisposable(ViewExtensionsKt.setSingleOnClickListener$default(view2, 0, 1, (Object) null).subscribe(new b(this)));
        }
    }

    @NotNull
    public ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i11) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        return new ViewHolder(this, ViewKt.inflate(viewGroup, i11));
    }

    public void onViewRecycled(@NotNull ViewHolder viewHolder) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        super.onViewRecycled(viewHolder);
        Disposable disposable = viewHolder.getDisposable();
        if (disposable != null) {
            disposable.dispose();
        }
    }
}
