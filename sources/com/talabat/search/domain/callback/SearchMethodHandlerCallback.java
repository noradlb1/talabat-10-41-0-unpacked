package com.talabat.search.domain.callback;

import com.talabat.fluttercore.domain.entities.FlutterVertical;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0013\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H&¢\u0006\u0002\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\u0007H&J\u0013\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\u0003H&¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/talabat/search/domain/callback/SearchMethodHandlerCallback;", "", "getAvailableVertical", "", "Lcom/talabat/fluttercore/domain/entities/FlutterVertical;", "()[Lcom/talabat/fluttercore/domain/entities/FlutterVertical;", "getSelectedCollectionId", "", "getSelectedCuisine", "getSelectedFliterIds", "()[Ljava/lang/Integer;", "com_talabat_feature_search_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface SearchMethodHandlerCallback {
    @NotNull
    FlutterVertical[] getAvailableVertical();

    int getSelectedCollectionId();

    int getSelectedCuisine();

    @NotNull
    Integer[] getSelectedFliterIds();
}
