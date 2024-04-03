package com.talabat.authentication.authenticate.domain.repository;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0006\u001a\u00020\u0007H&J\u0012\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0003H&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\n"}, d2 = {"Lcom/talabat/authentication/authenticate/domain/repository/TokenExchangeRetriesRepository;", "", "currentSessionRetries", "", "getCurrentSessionRetries", "()I", "clear", "", "updateRetriesCount", "updateCount", "com_talabat_Authentication_Authentication"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface TokenExchangeRetriesRepository {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ void updateRetriesCount$default(TokenExchangeRetriesRepository tokenExchangeRetriesRepository, int i11, int i12, Object obj) {
            if (obj == null) {
                if ((i12 & 1) != 0) {
                    i11 = 1;
                }
                tokenExchangeRetriesRepository.updateRetriesCount(i11);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateRetriesCount");
        }
    }

    void clear();

    int getCurrentSessionRetries();

    void updateRetriesCount(int i11);
}
