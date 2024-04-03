package com.talabat.flutter.usecase;

import com.talabat.fluttercore.domain.entities.FlutterVertical;
import com.talabat.homescreen.adapter.model.vetrical.VerticalItem;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\tH\u0002R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\r"}, d2 = {"Lcom/talabat/flutter/usecase/AvailableVerticalsUseCase;", "", "showMoreInHomeSearchUseCase", "Lcom/talabat/flutter/usecase/ShowMoreInHomeSearchUseCase;", "(Lcom/talabat/flutter/usecase/ShowMoreInHomeSearchUseCase;)V", "getShowMoreInHomeSearchUseCase", "()Lcom/talabat/flutter/usecase/ShowMoreInHomeSearchUseCase;", "setShowMoreInHomeSearchUseCase", "invoke", "", "Lcom/talabat/fluttercore/domain/entities/FlutterVertical;", "availableVerticalList", "Lcom/talabat/homescreen/adapter/model/vetrical/VerticalItem;", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AvailableVerticalsUseCase {
    @NotNull
    private ShowMoreInHomeSearchUseCase showMoreInHomeSearchUseCase;

    public AvailableVerticalsUseCase(@NotNull ShowMoreInHomeSearchUseCase showMoreInHomeSearchUseCase2) {
        Intrinsics.checkNotNullParameter(showMoreInHomeSearchUseCase2, "showMoreInHomeSearchUseCase");
        this.showMoreInHomeSearchUseCase = showMoreInHomeSearchUseCase2;
    }

    @NotNull
    public final ShowMoreInHomeSearchUseCase getShowMoreInHomeSearchUseCase() {
        return this.showMoreInHomeSearchUseCase;
    }

    @NotNull
    public final List<FlutterVertical> invoke(@Nullable List<VerticalItem> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (VerticalItem next : list) {
                if (next.getId() == 1 || next.getId() == 2 || next.getId() == 3 || next.getId() == 0) {
                    arrayList.add(new FlutterVertical(String.valueOf(next.getId()), next.getTitle(), next.getVerticalIds()));
                } else {
                    FlutterVertical invoke = this.showMoreInHomeSearchUseCase.invoke(next);
                    if (invoke != null) {
                        arrayList.add(invoke);
                    }
                }
            }
        }
        return arrayList;
    }

    public final void setShowMoreInHomeSearchUseCase(@NotNull ShowMoreInHomeSearchUseCase showMoreInHomeSearchUseCase2) {
        Intrinsics.checkNotNullParameter(showMoreInHomeSearchUseCase2, "<set-?>");
        this.showMoreInHomeSearchUseCase = showMoreInHomeSearchUseCase2;
    }
}
