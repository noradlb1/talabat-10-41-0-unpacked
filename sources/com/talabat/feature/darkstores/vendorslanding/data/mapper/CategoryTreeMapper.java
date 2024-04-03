package com.talabat.feature.darkstores.vendorslanding.data.mapper;

import com.talabat.feature.darkstores.vendorlanding.domain.model.CategoryTree;
import com.talabat.feature.darkstores.vendorlanding.domain.model.ImageUrl;
import com.talabat.feature.darkstores.vendorlanding.domain.model.SubCategory;
import com.talabat.feature.darkstores.vendorslanding.data.model.CategoryTreeResponse;
import com.talabat.feature.darkstores.vendorslanding.data.model.ImageUrlResponse;
import com.talabat.mapper.ModelMapper;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001B\u001d\b\u0007\u0012\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0001¢\u0006\u0002\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\t\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b*\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u000bH\u0002R\u001c\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/talabat/feature/darkstores/vendorslanding/data/mapper/CategoryTreeMapper;", "Lcom/talabat/mapper/ModelMapper;", "Lcom/talabat/feature/darkstores/vendorslanding/data/model/CategoryTreeResponse;", "Lcom/talabat/feature/darkstores/vendorlanding/domain/model/CategoryTree;", "imageUrlMapper", "Lcom/talabat/feature/darkstores/vendorslanding/data/model/ImageUrlResponse;", "Lcom/talabat/feature/darkstores/vendorlanding/domain/model/ImageUrl;", "(Lcom/talabat/mapper/ModelMapper;)V", "apply", "source", "mapToSubCategory", "", "Lcom/talabat/feature/darkstores/vendorlanding/domain/model/SubCategory;", "Lcom/talabat/feature/darkstores/vendorslanding/data/model/SubCategoryResponse;", "com_talabat_feature_darkstores-vendor-landing_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CategoryTreeMapper implements ModelMapper<CategoryTreeResponse, CategoryTree> {
    @NotNull
    private final ModelMapper<ImageUrlResponse, ImageUrl> imageUrlMapper;

    @Inject
    public CategoryTreeMapper(@NotNull ModelMapper<ImageUrlResponse, ImageUrl> modelMapper) {
        Intrinsics.checkNotNullParameter(modelMapper, "imageUrlMapper");
        this.imageUrlMapper = modelMapper;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x000d A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.util.List<com.talabat.feature.darkstores.vendorlanding.domain.model.SubCategory> mapToSubCategory(java.util.List<com.talabat.feature.darkstores.vendorslanding.data.model.SubCategoryResponse> r7) {
        /*
            r6 = this;
            if (r7 == 0) goto L_0x004a
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.Iterator r7 = r7.iterator()
        L_0x000d:
            boolean r1 = r7.hasNext()
            if (r1 == 0) goto L_0x004e
            java.lang.Object r1 = r7.next()
            com.talabat.feature.darkstores.vendorslanding.data.model.SubCategoryResponse r1 = (com.talabat.feature.darkstores.vendorslanding.data.model.SubCategoryResponse) r1
            java.lang.String r2 = r1.getId()
            java.lang.String r1 = r1.getName()
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L_0x002e
            boolean r5 = kotlin.text.StringsKt__StringsJVMKt.isBlank(r2)
            if (r5 == 0) goto L_0x002c
            goto L_0x002e
        L_0x002c:
            r5 = r3
            goto L_0x002f
        L_0x002e:
            r5 = r4
        L_0x002f:
            if (r5 != 0) goto L_0x0043
            if (r1 == 0) goto L_0x0039
            boolean r5 = kotlin.text.StringsKt__StringsJVMKt.isBlank(r1)
            if (r5 == 0) goto L_0x003a
        L_0x0039:
            r3 = r4
        L_0x003a:
            if (r3 == 0) goto L_0x003d
            goto L_0x0043
        L_0x003d:
            com.talabat.feature.darkstores.vendorlanding.domain.model.SubCategory r3 = new com.talabat.feature.darkstores.vendorlanding.domain.model.SubCategory
            r3.<init>(r2, r1)
            goto L_0x0044
        L_0x0043:
            r3 = 0
        L_0x0044:
            if (r3 == 0) goto L_0x000d
            r0.add(r3)
            goto L_0x000d
        L_0x004a:
            java.util.List r0 = kotlin.collections.CollectionsKt__CollectionsKt.emptyList()
        L_0x004e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.darkstores.vendorslanding.data.mapper.CategoryTreeMapper.mapToSubCategory(java.util.List):java.util.List");
    }

    @Nullable
    public CategoryTree apply(@NotNull CategoryTreeResponse categoryTreeResponse) {
        List list;
        Intrinsics.checkNotNullParameter(categoryTreeResponse, "source");
        String id2 = categoryTreeResponse.getId();
        String name2 = categoryTreeResponse.getName();
        List<ImageUrlResponse> imageUrls = categoryTreeResponse.getImageUrls();
        if (imageUrls != null) {
            list = new ArrayList();
            for (ImageUrlResponse apply : imageUrls) {
                ImageUrl apply2 = this.imageUrlMapper.apply(apply);
                if (apply2 != null) {
                    list.add(apply2);
                }
            }
        } else {
            list = CollectionsKt__CollectionsKt.emptyList();
        }
        List<SubCategory> mapToSubCategory = mapToSubCategory(categoryTreeResponse.getSubCategories());
        boolean z11 = false;
        if (!(id2 == null || StringsKt__StringsJVMKt.isBlank(id2))) {
            if (name2 == null || StringsKt__StringsJVMKt.isBlank(name2)) {
                z11 = true;
            }
            if (!z11) {
                return new CategoryTree(id2, list, name2, mapToSubCategory);
            }
        }
        return null;
    }
}
