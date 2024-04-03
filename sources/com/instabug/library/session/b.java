package com.instabug.library.session;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import com.instabug.library.model.session.CoreSession;
import com.instabug.library.model.session.SessionMapper;
import com.instabug.library.model.session.SessionsBatchDTO;
import com.instabug.library.util.ListUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class b implements a {
    @NonNull
    private SessionsBatchDTO b(@NonNull List list) {
        SessionsBatchDTO sessionsBatchDTO;
        int size = list.size();
        if (size == 0) {
            sessionsBatchDTO = SessionMapper.toDTO(Collections.emptyMap(), Collections.emptyList());
        } else if (size != 1) {
            sessionsBatchDTO = i.a(list);
        } else {
            sessionsBatchDTO = SessionMapper.toDTO(SessionMapper.toRemoteEntity((CoreSession) list.get(0)));
        }
        if (!list.isEmpty()) {
            sessionsBatchDTO.setProductionUsage(((CoreSession) list.get(list.size() - 1)).getProductionUsage());
        }
        return sessionsBatchDTO;
    }

    @NonNull
    public List a(@NonNull List list, @IntRange(from = 1) int i11) {
        return a(ListUtils.split(list, i11));
    }

    @NonNull
    private List a(@NonNull List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(b((List) it.next()));
        }
        return arrayList;
    }
}
