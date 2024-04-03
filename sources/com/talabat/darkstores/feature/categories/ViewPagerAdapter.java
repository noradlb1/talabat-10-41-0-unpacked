package com.talabat.darkstores.feature.categories;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import com.talabat.darkstores.data.tracking.EventOrigin;
import com.talabat.darkstores.feature.categories.subcategories.SubcategoriesFragment;
import com.talabat.darkstores.model.Category;
import com.talabat.darkstores.model.SubCategory;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B7\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0010H\u0016J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0013\u001a\u00020\u0010H\u0016J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0013\u001a\u00020\u0010H\u0002R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/talabat/darkstores/feature/categories/ViewPagerAdapter;", "Landroidx/fragment/app/FragmentStatePagerAdapter;", "categories", "", "Lcom/talabat/darkstores/model/Category;", "initialSubcategoryId", "", "eventOrigin", "Lcom/talabat/darkstores/data/tracking/EventOrigin;", "isRtl", "", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "(Ljava/util/List;Ljava/lang/String;Lcom/talabat/darkstores/data/tracking/EventOrigin;ZLandroidx/fragment/app/FragmentManager;)V", "firstOpen", "getCount", "", "getItem", "Landroidx/fragment/app/Fragment;", "position", "getPageTitle", "", "getSubcategoryId", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ViewPagerAdapter extends FragmentStatePagerAdapter {
    @NotNull
    private final List<Category> categories;
    @Nullable
    private final EventOrigin eventOrigin;
    private boolean firstOpen = true;
    @Nullable
    private String initialSubcategoryId;
    private final boolean isRtl;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ViewPagerAdapter(@NotNull List<Category> list, @Nullable String str, @Nullable EventOrigin eventOrigin2, boolean z11, @NotNull FragmentManager fragmentManager) {
        super(fragmentManager, 1);
        Intrinsics.checkNotNullParameter(list, "categories");
        Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
        this.categories = list;
        this.initialSubcategoryId = str;
        this.eventOrigin = eventOrigin2;
        this.isRtl = z11;
    }

    private final String getSubcategoryId(int i11) {
        Iterable<SubCategory> subcategories = this.categories.get(i11).getSubcategories();
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(subcategories, 10));
        for (SubCategory id2 : subcategories) {
            arrayList.add(id2.getId());
        }
        if (!CollectionsKt___CollectionsKt.contains(arrayList, this.initialSubcategoryId)) {
            return null;
        }
        String str = this.initialSubcategoryId;
        this.initialSubcategoryId = null;
        return str;
    }

    public int getCount() {
        return this.categories.size();
    }

    @NotNull
    public Fragment getItem(int i11) {
        Category category = this.categories.get(i11);
        return SubcategoriesFragment.Companion.newInstance(category.getId(), category.getName(), getSubcategoryId(i11), this.eventOrigin);
    }

    @Nullable
    public CharSequence getPageTitle(int i11) {
        if (!this.isRtl || !this.firstOpen) {
            return this.categories.get(i11).getName();
        }
        if (i11 == 0) {
            this.firstOpen = false;
        }
        return this.categories.get((getCount() - i11) - 1).getName();
    }
}
