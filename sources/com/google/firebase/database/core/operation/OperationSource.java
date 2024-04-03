package com.google.firebase.database.core.operation;

import com.google.firebase.database.core.utilities.Utilities;
import com.google.firebase.database.core.view.QueryParams;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public class OperationSource {
    public static final OperationSource SERVER = new OperationSource(Source.Server, (QueryParams) null, false);
    public static final OperationSource USER = new OperationSource(Source.User, (QueryParams) null, false);
    private final QueryParams queryParams;
    private final Source source;
    private final boolean tagged;

    public enum Source {
        User,
        Server
    }

    public OperationSource(Source source2, QueryParams queryParams2, boolean z11) {
        boolean z12;
        this.source = source2;
        this.queryParams = queryParams2;
        this.tagged = z11;
        if (!z11 || isFromServer()) {
            z12 = true;
        } else {
            z12 = false;
        }
        Utilities.hardAssert(z12);
    }

    public static OperationSource forServerTaggedQuery(QueryParams queryParams2) {
        return new OperationSource(Source.Server, queryParams2, true);
    }

    public QueryParams getQueryParams() {
        return this.queryParams;
    }

    public boolean isFromServer() {
        return this.source == Source.Server;
    }

    public boolean isFromUser() {
        return this.source == Source.User;
    }

    public boolean isTagged() {
        return this.tagged;
    }

    public String toString() {
        return "OperationSource{source=" + this.source + ", queryParams=" + this.queryParams + ", tagged=" + this.tagged + AbstractJsonLexerKt.END_OBJ;
    }
}
