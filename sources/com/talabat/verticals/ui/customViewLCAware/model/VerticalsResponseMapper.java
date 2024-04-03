package com.talabat.verticals.ui.customViewLCAware.model;

import com.integration.IntegrationGlobalDataModel;
import com.talabat.verticals.features.dynamicLauncher.model.response.VerticalsResult;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00032\u00020\u0001:\u0002\u0003\u0004B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0005"}, d2 = {"Lcom/talabat/verticals/ui/customViewLCAware/model/VerticalsResponseMapper;", "", "()V", "Companion", "Vertical", "com_talabat_NewArchi_VerticalsSquad_VerticalsSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VerticalsResponseMapper {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¨\u0006\u0007"}, d2 = {"Lcom/talabat/verticals/ui/customViewLCAware/model/VerticalsResponseMapper$Companion;", "", "()V", "map", "Lcom/talabat/verticals/ui/customViewLCAware/model/VerticalsDisplayModel;", "data", "Lcom/talabat/verticals/features/dynamicLauncher/model/response/VerticalsResult;", "com_talabat_NewArchi_VerticalsSquad_VerticalsSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final VerticalsDisplayModel map(@Nullable VerticalsResult verticalsResult) {
            List<com.talabat.verticals.features.dynamicLauncher.model.response.Vertical> verticals;
            VerticalsDisplayModel verticalsDisplayModel = new VerticalsDisplayModel();
            if (!(verticalsResult == null || (verticals = verticalsResult.getVerticals()) == null)) {
                int size = verticals.size();
                for (int i11 = 0; i11 < size; i11++) {
                    Integer id2 = verticals.get(i11).getId();
                    int id3 = Vertical.RESTAURANT.getId();
                    if (id2 == null || id2.intValue() != id3) {
                        Integer id4 = verticals.get(i11).getId();
                        int id5 = Vertical.GROCERY.getId();
                        if (id4 == null || id4.intValue() != id5) {
                            Integer id6 = verticals.get(i11).getId();
                            int id7 = Vertical.FLOWERS.getId();
                            if (id6 != null) {
                                if (id6.intValue() != id7) {
                                }
                            }
                        }
                    }
                    ArrayList<Vertical> verticals2 = verticalsDisplayModel.getVerticals();
                    Vertical vertical = new Vertical();
                    vertical.setId(verticals.get(i11).getId());
                    vertical.setName(verticals.get(i11).getName());
                    String baseImageUrl = IntegrationGlobalDataModel.Companion.baseImageUrl();
                    String imageUrl = verticals.get(i11).getImageUrl();
                    vertical.setImageUrl(baseImageUrl + imageUrl);
                    vertical.setDeeplink(verticals.get(i11).getDeeplink());
                    vertical.setPosition(verticals.get(i11).getPosition());
                    vertical.setColorCode(verticals.get(i11).getColorCode());
                    verticals2.add(vertical);
                }
                if (verticalsDisplayModel.getVerticals().size() > 1) {
                    verticalsDisplayModel.setVerticals(new ArrayList(CollectionsKt___CollectionsKt.sortedWith(verticalsDisplayModel.getVerticals(), new VerticalsResponseMapper$Companion$map$lambda4$lambda3$lambda2$$inlined$compareBy$1())));
                }
            }
            return verticalsDisplayModel;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/talabat/verticals/ui/customViewLCAware/model/VerticalsResponseMapper$Vertical;", "", "id", "", "(Ljava/lang/String;II)V", "getId", "()I", "RESTAURANT", "GROCERY", "PHARMACY", "FLOWERS", "ELECTRONICS", "PET_SHOP", "COSMETIC", "com_talabat_NewArchi_VerticalsSquad_VerticalsSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public enum Vertical {
        RESTAURANT(0),
        GROCERY(1),
        PHARMACY(2),
        FLOWERS(3),
        ELECTRONICS(4),
        PET_SHOP(5),
        COSMETIC(6);
        

        /* renamed from: id  reason: collision with root package name */
        private final int f12454id;

        private Vertical(int i11) {
            this.f12454id = i11;
        }

        public final int getId() {
            return this.f12454id;
        }
    }
}
