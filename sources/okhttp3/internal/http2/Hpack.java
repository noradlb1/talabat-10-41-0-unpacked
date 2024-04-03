package okhttp3.internal.http2;

import androidx.webkit.ProxyConfig;
import com.instabug.library.model.NetworkLog;
import com.pichillilorenzo.flutter_inappwebview.credential_database.URLProtectionSpaceContract;
import com.talabat.observability.squads.nfv.ObservableAttributesNames;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;
import okio.Source;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\u0018\u0019B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0005J\u0014\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0002R\u001d\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u0019\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001a"}, d2 = {"Lokhttp3/internal/http2/Hpack;", "", "()V", "NAME_TO_FIRST_INDEX", "", "Lokio/ByteString;", "", "getNAME_TO_FIRST_INDEX", "()Ljava/util/Map;", "PREFIX_4_BITS", "PREFIX_5_BITS", "PREFIX_6_BITS", "PREFIX_7_BITS", "SETTINGS_HEADER_TABLE_SIZE", "SETTINGS_HEADER_TABLE_SIZE_LIMIT", "STATIC_HEADER_TABLE", "", "Lokhttp3/internal/http2/Header;", "getSTATIC_HEADER_TABLE", "()[Lokhttp3/internal/http2/Header;", "[Lokhttp3/internal/http2/Header;", "checkLowercase", "name", "nameToFirstIndex", "Reader", "Writer", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class Hpack {
    @NotNull
    public static final Hpack INSTANCE;
    @NotNull
    private static final Map<ByteString, Integer> NAME_TO_FIRST_INDEX;
    private static final int PREFIX_4_BITS = 15;
    private static final int PREFIX_5_BITS = 31;
    private static final int PREFIX_6_BITS = 63;
    private static final int PREFIX_7_BITS = 127;
    private static final int SETTINGS_HEADER_TABLE_SIZE = 4096;
    private static final int SETTINGS_HEADER_TABLE_SIZE_LIMIT = 16384;
    @NotNull
    private static final Header[] STATIC_HEADER_TABLE;

    static {
        Hpack hpack = new Hpack();
        INSTANCE = hpack;
        ByteString byteString = Header.TARGET_METHOD;
        ByteString byteString2 = Header.TARGET_PATH;
        ByteString byteString3 = Header.TARGET_SCHEME;
        ByteString byteString4 = Header.RESPONSE_STATUS;
        STATIC_HEADER_TABLE = new Header[]{new Header(Header.TARGET_AUTHORITY, ""), new Header(byteString, "GET"), new Header(byteString, "POST"), new Header(byteString2, "/"), new Header(byteString2, "/index.html"), new Header(byteString3, (String) ProxyConfig.MATCH_HTTP), new Header(byteString3, "https"), new Header(byteString4, "200"), new Header(byteString4, "204"), new Header(byteString4, "206"), new Header(byteString4, "304"), new Header(byteString4, (String) ObservableAttributesNames.DEFAULT_RESPONSE_CODE), new Header(byteString4, "404"), new Header(byteString4, "500"), new Header("accept-charset", ""), new Header("accept-encoding", "gzip, deflate"), new Header("accept-language", ""), new Header("accept-ranges", ""), new Header("accept", ""), new Header("access-control-allow-origin", ""), new Header("age", ""), new Header("allow", ""), new Header("authorization", ""), new Header("cache-control", ""), new Header("content-disposition", ""), new Header("content-encoding", ""), new Header("content-language", ""), new Header("content-length", ""), new Header("content-location", ""), new Header("content-range", ""), new Header((String) NetworkLog.CONTENT_TYPE, ""), new Header("cookie", ""), new Header("date", ""), new Header("etag", ""), new Header("expect", ""), new Header("expires", ""), new Header("from", ""), new Header((String) URLProtectionSpaceContract.FeedEntry.COLUMN_NAME_HOST, ""), new Header("if-match", ""), new Header("if-modified-since", ""), new Header("if-none-match", ""), new Header("if-range", ""), new Header("if-unmodified-since", ""), new Header("last-modified", ""), new Header("link", ""), new Header("location", ""), new Header("max-forwards", ""), new Header("proxy-authenticate", ""), new Header("proxy-authorization", ""), new Header((String) BasketDeliveryFeeTiersInfoKeys.KEY_RANGE, ""), new Header("referer", ""), new Header("refresh", ""), new Header("retry-after", ""), new Header("server", ""), new Header("set-cookie", ""), new Header("strict-transport-security", ""), new Header("transfer-encoding", ""), new Header("user-agent", ""), new Header("vary", ""), new Header("via", ""), new Header("www-authenticate", "")};
        NAME_TO_FIRST_INDEX = hpack.nameToFirstIndex();
    }

    private Hpack() {
    }

    private final Map<ByteString, Integer> nameToFirstIndex() {
        Header[] headerArr = STATIC_HEADER_TABLE;
        LinkedHashMap linkedHashMap = new LinkedHashMap(headerArr.length);
        int length = headerArr.length;
        int i11 = 0;
        while (i11 < length) {
            int i12 = i11 + 1;
            Header[] headerArr2 = STATIC_HEADER_TABLE;
            if (!linkedHashMap.containsKey(headerArr2[i11].f27529name)) {
                linkedHashMap.put(headerArr2[i11].f27529name, Integer.valueOf(i11));
            }
            i11 = i12;
        }
        Map<ByteString, Integer> unmodifiableMap = Collections.unmodifiableMap(linkedHashMap);
        Intrinsics.checkNotNullExpressionValue(unmodifiableMap, "unmodifiableMap(result)");
        return unmodifiableMap;
    }

    @NotNull
    public final ByteString checkLowercase(@NotNull ByteString byteString) throws IOException {
        boolean z11;
        Intrinsics.checkNotNullParameter(byteString, "name");
        int size = byteString.size();
        int i11 = 0;
        while (i11 < size) {
            int i12 = i11 + 1;
            byte b11 = byteString.getByte(i11);
            if (65 > b11 || b11 > 90) {
                z11 = false;
            } else {
                z11 = true;
            }
            if (!z11) {
                i11 = i12;
            } else {
                throw new IOException(Intrinsics.stringPlus("PROTOCOL_ERROR response malformed: mixed case name: ", byteString.utf8()));
            }
        }
        return byteString;
    }

    @NotNull
    public final Map<ByteString, Integer> getNAME_TO_FIRST_INDEX() {
        return NAME_TO_FIRST_INDEX;
    }

    @NotNull
    public final Header[] getSTATIC_HEADER_TABLE() {
        return STATIC_HEADER_TABLE;
    }

    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\b\u0010\u0012\u001a\u00020\u0013H\u0002J\b\u0010\u0014\u001a\u00020\u0013H\u0002J\u0010\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0005H\u0002J\u0010\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0005H\u0002J\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\n0\u001aJ\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0016\u001a\u00020\u0005H\u0002J\u0018\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\nH\u0002J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010\u0016\u001a\u00020\u0005H\u0002J\u0006\u0010\u0006\u001a\u00020\u0005J\b\u0010!\u001a\u00020\u0005H\u0002J\u0006\u0010\"\u001a\u00020\u001cJ\u0006\u0010#\u001a\u00020\u0013J\u0010\u0010$\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0005H\u0002J\u0016\u0010%\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\u00052\u0006\u0010'\u001a\u00020\u0005J\u0010\u0010(\u001a\u00020\u00132\u0006\u0010)\u001a\u00020\u0005H\u0002J\b\u0010*\u001a\u00020\u0013H\u0002J\u0010\u0010+\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0005H\u0002J\b\u0010,\u001a\u00020\u0013H\u0002R\u001c\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t8\u0006@\u0006X\u000e¢\u0006\u0004\n\u0002\u0010\u000bR\u0012\u0010\f\u001a\u00020\u00058\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u00020\u00058\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lokhttp3/internal/http2/Hpack$Reader;", "", "source", "Lokio/Source;", "headerTableSizeSetting", "", "maxDynamicTableByteCount", "(Lokio/Source;II)V", "dynamicTable", "", "Lokhttp3/internal/http2/Header;", "[Lokhttp3/internal/http2/Header;", "dynamicTableByteCount", "headerCount", "headerList", "", "nextHeaderIndex", "Lokio/BufferedSource;", "adjustDynamicTableByteCount", "", "clearDynamicTable", "dynamicTableIndex", "index", "evictToRecoverBytes", "bytesToRecover", "getAndResetHeaderList", "", "getName", "Lokio/ByteString;", "insertIntoDynamicTable", "entry", "isStaticHeader", "", "readByte", "readByteString", "readHeaders", "readIndexedHeader", "readInt", "firstByte", "prefixMask", "readLiteralHeaderWithIncrementalIndexingIndexedName", "nameIndex", "readLiteralHeaderWithIncrementalIndexingNewName", "readLiteralHeaderWithoutIndexingIndexedName", "readLiteralHeaderWithoutIndexingNewName", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Reader {
        @NotNull
        @JvmField
        public Header[] dynamicTable;
        @JvmField
        public int dynamicTableByteCount;
        @JvmField
        public int headerCount;
        @NotNull
        private final List<Header> headerList;
        private final int headerTableSizeSetting;
        private int maxDynamicTableByteCount;
        private int nextHeaderIndex;
        @NotNull
        private final BufferedSource source;

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        @JvmOverloads
        public Reader(@NotNull Source source2, int i11) {
            this(source2, i11, 0, 4, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(source2, "source");
        }

        @JvmOverloads
        public Reader(@NotNull Source source2, int i11, int i12) {
            Intrinsics.checkNotNullParameter(source2, "source");
            this.headerTableSizeSetting = i11;
            this.maxDynamicTableByteCount = i12;
            this.headerList = new ArrayList();
            this.source = Okio.buffer(source2);
            Header[] headerArr = new Header[8];
            this.dynamicTable = headerArr;
            this.nextHeaderIndex = headerArr.length - 1;
        }

        private final void adjustDynamicTableByteCount() {
            int i11 = this.maxDynamicTableByteCount;
            int i12 = this.dynamicTableByteCount;
            if (i11 >= i12) {
                return;
            }
            if (i11 == 0) {
                clearDynamicTable();
            } else {
                evictToRecoverBytes(i12 - i11);
            }
        }

        private final void clearDynamicTable() {
            ArraysKt___ArraysJvmKt.fill$default((Object[]) this.dynamicTable, (Object) null, 0, 0, 6, (Object) null);
            this.nextHeaderIndex = this.dynamicTable.length - 1;
            this.headerCount = 0;
            this.dynamicTableByteCount = 0;
        }

        private final int dynamicTableIndex(int i11) {
            return this.nextHeaderIndex + 1 + i11;
        }

        private final int evictToRecoverBytes(int i11) {
            int i12;
            int i13 = 0;
            if (i11 > 0) {
                int length = this.dynamicTable.length;
                while (true) {
                    length--;
                    i12 = this.nextHeaderIndex;
                    if (length < i12 || i11 <= 0) {
                        Header[] headerArr = this.dynamicTable;
                        System.arraycopy(headerArr, i12 + 1, headerArr, i12 + 1 + i13, this.headerCount);
                        this.nextHeaderIndex += i13;
                    } else {
                        Header header = this.dynamicTable[length];
                        Intrinsics.checkNotNull(header);
                        int i14 = header.hpackSize;
                        i11 -= i14;
                        this.dynamicTableByteCount -= i14;
                        this.headerCount--;
                        i13++;
                    }
                }
                Header[] headerArr2 = this.dynamicTable;
                System.arraycopy(headerArr2, i12 + 1, headerArr2, i12 + 1 + i13, this.headerCount);
                this.nextHeaderIndex += i13;
            }
            return i13;
        }

        private final ByteString getName(int i11) throws IOException {
            if (isStaticHeader(i11)) {
                return Hpack.INSTANCE.getSTATIC_HEADER_TABLE()[i11].f27529name;
            }
            int dynamicTableIndex = dynamicTableIndex(i11 - Hpack.INSTANCE.getSTATIC_HEADER_TABLE().length);
            if (dynamicTableIndex >= 0) {
                Header[] headerArr = this.dynamicTable;
                if (dynamicTableIndex < headerArr.length) {
                    Header header = headerArr[dynamicTableIndex];
                    Intrinsics.checkNotNull(header);
                    return header.f27529name;
                }
            }
            throw new IOException(Intrinsics.stringPlus("Header index too large ", Integer.valueOf(i11 + 1)));
        }

        private final void insertIntoDynamicTable(int i11, Header header) {
            this.headerList.add(header);
            int i12 = header.hpackSize;
            if (i11 != -1) {
                Header header2 = this.dynamicTable[dynamicTableIndex(i11)];
                Intrinsics.checkNotNull(header2);
                i12 -= header2.hpackSize;
            }
            int i13 = this.maxDynamicTableByteCount;
            if (i12 > i13) {
                clearDynamicTable();
                return;
            }
            int evictToRecoverBytes = evictToRecoverBytes((this.dynamicTableByteCount + i12) - i13);
            if (i11 == -1) {
                int i14 = this.headerCount + 1;
                Header[] headerArr = this.dynamicTable;
                if (i14 > headerArr.length) {
                    Header[] headerArr2 = new Header[(headerArr.length * 2)];
                    System.arraycopy(headerArr, 0, headerArr2, headerArr.length, headerArr.length);
                    this.nextHeaderIndex = this.dynamicTable.length - 1;
                    this.dynamicTable = headerArr2;
                }
                int i15 = this.nextHeaderIndex;
                this.nextHeaderIndex = i15 - 1;
                this.dynamicTable[i15] = header;
                this.headerCount++;
            } else {
                this.dynamicTable[i11 + dynamicTableIndex(i11) + evictToRecoverBytes] = header;
            }
            this.dynamicTableByteCount += i12;
        }

        private final boolean isStaticHeader(int i11) {
            return i11 >= 0 && i11 <= Hpack.INSTANCE.getSTATIC_HEADER_TABLE().length - 1;
        }

        private final int readByte() throws IOException {
            return Util.and(this.source.readByte(), 255);
        }

        private final void readIndexedHeader(int i11) throws IOException {
            if (isStaticHeader(i11)) {
                this.headerList.add(Hpack.INSTANCE.getSTATIC_HEADER_TABLE()[i11]);
                return;
            }
            int dynamicTableIndex = dynamicTableIndex(i11 - Hpack.INSTANCE.getSTATIC_HEADER_TABLE().length);
            if (dynamicTableIndex >= 0) {
                Header[] headerArr = this.dynamicTable;
                if (dynamicTableIndex < headerArr.length) {
                    Header header = headerArr[dynamicTableIndex];
                    Intrinsics.checkNotNull(header);
                    this.headerList.add(header);
                    return;
                }
            }
            throw new IOException(Intrinsics.stringPlus("Header index too large ", Integer.valueOf(i11 + 1)));
        }

        private final void readLiteralHeaderWithIncrementalIndexingIndexedName(int i11) throws IOException {
            insertIntoDynamicTable(-1, new Header(getName(i11), readByteString()));
        }

        private final void readLiteralHeaderWithIncrementalIndexingNewName() throws IOException {
            insertIntoDynamicTable(-1, new Header(Hpack.INSTANCE.checkLowercase(readByteString()), readByteString()));
        }

        private final void readLiteralHeaderWithoutIndexingIndexedName(int i11) throws IOException {
            this.headerList.add(new Header(getName(i11), readByteString()));
        }

        private final void readLiteralHeaderWithoutIndexingNewName() throws IOException {
            this.headerList.add(new Header(Hpack.INSTANCE.checkLowercase(readByteString()), readByteString()));
        }

        @NotNull
        public final List<Header> getAndResetHeaderList() {
            List<Header> list = CollectionsKt___CollectionsKt.toList(this.headerList);
            this.headerList.clear();
            return list;
        }

        public final int maxDynamicTableByteCount() {
            return this.maxDynamicTableByteCount;
        }

        @NotNull
        public final ByteString readByteString() throws IOException {
            boolean z11;
            int readByte = readByte();
            if ((readByte & 128) == 128) {
                z11 = true;
            } else {
                z11 = false;
            }
            long readInt = (long) readInt(readByte, 127);
            if (!z11) {
                return this.source.readByteString(readInt);
            }
            Buffer buffer = new Buffer();
            Huffman.INSTANCE.decode(this.source, readInt, buffer);
            return buffer.readByteString();
        }

        public final void readHeaders() throws IOException {
            while (!this.source.exhausted()) {
                int and = Util.and(this.source.readByte(), 255);
                if (and == 128) {
                    throw new IOException("index == 0");
                } else if ((and & 128) == 128) {
                    readIndexedHeader(readInt(and, 127) - 1);
                } else if (and == 64) {
                    readLiteralHeaderWithIncrementalIndexingNewName();
                } else if ((and & 64) == 64) {
                    readLiteralHeaderWithIncrementalIndexingIndexedName(readInt(and, 63) - 1);
                } else if ((and & 32) == 32) {
                    int readInt = readInt(and, 31);
                    this.maxDynamicTableByteCount = readInt;
                    if (readInt < 0 || readInt > this.headerTableSizeSetting) {
                        throw new IOException(Intrinsics.stringPlus("Invalid dynamic table size update ", Integer.valueOf(this.maxDynamicTableByteCount)));
                    }
                    adjustDynamicTableByteCount();
                } else if (and == 16 || and == 0) {
                    readLiteralHeaderWithoutIndexingNewName();
                } else {
                    readLiteralHeaderWithoutIndexingIndexedName(readInt(and, 15) - 1);
                }
            }
        }

        public final int readInt(int i11, int i12) throws IOException {
            int i13 = i11 & i12;
            if (i13 < i12) {
                return i13;
            }
            int i14 = 0;
            while (true) {
                int readByte = readByte();
                if ((readByte & 128) == 0) {
                    return i12 + (readByte << i14);
                }
                i12 += (readByte & 127) << i14;
                i14 += 7;
            }
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Reader(Source source2, int i11, int i12, int i13, DefaultConstructorMarker defaultConstructorMarker) {
            this(source2, i11, (i13 & 4) != 0 ? i11 : i12);
        }
    }

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\u0018\u00002\u00020\u0001B#\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u0013\u001a\u00020\u0014H\u0002J\b\u0010\u0015\u001a\u00020\u0014H\u0002J\u0010\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0003H\u0002J\u0010\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u000bH\u0002J\u000e\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u0002\u001a\u00020\u0003J\u000e\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u001dJ\u0014\u0010\u001e\u001a\u00020\u00142\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u000b0 J\u001e\u0010!\u001a\u00020\u00142\u0006\u0010\"\u001a\u00020\u00032\u0006\u0010#\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\u0003R\u001c\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n8\u0006@\u0006X\u000e¢\u0006\u0004\n\u0002\u0010\fR\u0012\u0010\r\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0010\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lokhttp3/internal/http2/Hpack$Writer;", "", "headerTableSizeSetting", "", "useCompression", "", "out", "Lokio/Buffer;", "(IZLokio/Buffer;)V", "dynamicTable", "", "Lokhttp3/internal/http2/Header;", "[Lokhttp3/internal/http2/Header;", "dynamicTableByteCount", "emitDynamicTableSizeUpdate", "headerCount", "maxDynamicTableByteCount", "nextHeaderIndex", "smallestHeaderTableSizeSetting", "adjustDynamicTableByteCount", "", "clearDynamicTable", "evictToRecoverBytes", "bytesToRecover", "insertIntoDynamicTable", "entry", "resizeHeaderTable", "writeByteString", "data", "Lokio/ByteString;", "writeHeaders", "headerBlock", "", "writeInt", "value", "prefixMask", "bits", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Writer {
        @NotNull
        @JvmField
        public Header[] dynamicTable;
        @JvmField
        public int dynamicTableByteCount;
        private boolean emitDynamicTableSizeUpdate;
        @JvmField
        public int headerCount;
        @JvmField
        public int headerTableSizeSetting;
        @JvmField
        public int maxDynamicTableByteCount;
        private int nextHeaderIndex;
        @NotNull
        private final Buffer out;
        private int smallestHeaderTableSizeSetting;
        private final boolean useCompression;

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        @JvmOverloads
        public Writer(int i11, @NotNull Buffer buffer) {
            this(i11, false, buffer, 2, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(buffer, "out");
        }

        @JvmOverloads
        public Writer(int i11, boolean z11, @NotNull Buffer buffer) {
            Intrinsics.checkNotNullParameter(buffer, "out");
            this.headerTableSizeSetting = i11;
            this.useCompression = z11;
            this.out = buffer;
            this.smallestHeaderTableSizeSetting = Integer.MAX_VALUE;
            this.maxDynamicTableByteCount = i11;
            Header[] headerArr = new Header[8];
            this.dynamicTable = headerArr;
            this.nextHeaderIndex = headerArr.length - 1;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        @JvmOverloads
        public Writer(@NotNull Buffer buffer) {
            this(0, false, buffer, 3, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(buffer, "out");
        }

        private final void adjustDynamicTableByteCount() {
            int i11 = this.maxDynamicTableByteCount;
            int i12 = this.dynamicTableByteCount;
            if (i11 >= i12) {
                return;
            }
            if (i11 == 0) {
                clearDynamicTable();
            } else {
                evictToRecoverBytes(i12 - i11);
            }
        }

        private final void clearDynamicTable() {
            ArraysKt___ArraysJvmKt.fill$default((Object[]) this.dynamicTable, (Object) null, 0, 0, 6, (Object) null);
            this.nextHeaderIndex = this.dynamicTable.length - 1;
            this.headerCount = 0;
            this.dynamicTableByteCount = 0;
        }

        private final int evictToRecoverBytes(int i11) {
            int i12;
            int i13 = 0;
            if (i11 > 0) {
                int length = this.dynamicTable.length;
                while (true) {
                    length--;
                    i12 = this.nextHeaderIndex;
                    if (length < i12 || i11 <= 0) {
                        Header[] headerArr = this.dynamicTable;
                        System.arraycopy(headerArr, i12 + 1, headerArr, i12 + 1 + i13, this.headerCount);
                        Header[] headerArr2 = this.dynamicTable;
                        int i14 = this.nextHeaderIndex;
                        Arrays.fill(headerArr2, i14 + 1, i14 + 1 + i13, (Object) null);
                        this.nextHeaderIndex += i13;
                    } else {
                        Header header = this.dynamicTable[length];
                        Intrinsics.checkNotNull(header);
                        i11 -= header.hpackSize;
                        int i15 = this.dynamicTableByteCount;
                        Header header2 = this.dynamicTable[length];
                        Intrinsics.checkNotNull(header2);
                        this.dynamicTableByteCount = i15 - header2.hpackSize;
                        this.headerCount--;
                        i13++;
                    }
                }
                Header[] headerArr3 = this.dynamicTable;
                System.arraycopy(headerArr3, i12 + 1, headerArr3, i12 + 1 + i13, this.headerCount);
                Header[] headerArr22 = this.dynamicTable;
                int i142 = this.nextHeaderIndex;
                Arrays.fill(headerArr22, i142 + 1, i142 + 1 + i13, (Object) null);
                this.nextHeaderIndex += i13;
            }
            return i13;
        }

        private final void insertIntoDynamicTable(Header header) {
            int i11 = header.hpackSize;
            int i12 = this.maxDynamicTableByteCount;
            if (i11 > i12) {
                clearDynamicTable();
                return;
            }
            evictToRecoverBytes((this.dynamicTableByteCount + i11) - i12);
            int i13 = this.headerCount + 1;
            Header[] headerArr = this.dynamicTable;
            if (i13 > headerArr.length) {
                Header[] headerArr2 = new Header[(headerArr.length * 2)];
                System.arraycopy(headerArr, 0, headerArr2, headerArr.length, headerArr.length);
                this.nextHeaderIndex = this.dynamicTable.length - 1;
                this.dynamicTable = headerArr2;
            }
            int i14 = this.nextHeaderIndex;
            this.nextHeaderIndex = i14 - 1;
            this.dynamicTable[i14] = header;
            this.headerCount++;
            this.dynamicTableByteCount += i11;
        }

        public final void resizeHeaderTable(int i11) {
            this.headerTableSizeSetting = i11;
            int min = Math.min(i11, 16384);
            int i12 = this.maxDynamicTableByteCount;
            if (i12 != min) {
                if (min < i12) {
                    this.smallestHeaderTableSizeSetting = Math.min(this.smallestHeaderTableSizeSetting, min);
                }
                this.emitDynamicTableSizeUpdate = true;
                this.maxDynamicTableByteCount = min;
                adjustDynamicTableByteCount();
            }
        }

        public final void writeByteString(@NotNull ByteString byteString) throws IOException {
            Intrinsics.checkNotNullParameter(byteString, "data");
            if (this.useCompression) {
                Huffman huffman = Huffman.INSTANCE;
                if (huffman.encodedLength(byteString) < byteString.size()) {
                    Buffer buffer = new Buffer();
                    huffman.encode(byteString, buffer);
                    ByteString readByteString = buffer.readByteString();
                    writeInt(readByteString.size(), 127, 128);
                    this.out.write(readByteString);
                    return;
                }
            }
            writeInt(byteString.size(), 127, 0);
            this.out.write(byteString);
        }

        public final void writeHeaders(@NotNull List<Header> list) throws IOException {
            int i11;
            int i12;
            boolean z11;
            Intrinsics.checkNotNullParameter(list, "headerBlock");
            if (this.emitDynamicTableSizeUpdate) {
                int i13 = this.smallestHeaderTableSizeSetting;
                if (i13 < this.maxDynamicTableByteCount) {
                    writeInt(i13, 31, 32);
                }
                this.emitDynamicTableSizeUpdate = false;
                this.smallestHeaderTableSizeSetting = Integer.MAX_VALUE;
                writeInt(this.maxDynamicTableByteCount, 31, 32);
            }
            int size = list.size();
            int i14 = 0;
            while (i14 < size) {
                int i15 = i14 + 1;
                Header header = list.get(i14);
                ByteString asciiLowercase = header.f27529name.toAsciiLowercase();
                ByteString byteString = header.value;
                Hpack hpack = Hpack.INSTANCE;
                Integer num = hpack.getNAME_TO_FIRST_INDEX().get(asciiLowercase);
                if (num != null) {
                    i11 = num.intValue() + 1;
                    if (2 > i11 || i11 >= 8) {
                        z11 = false;
                    } else {
                        z11 = true;
                    }
                    if (z11) {
                        if (Intrinsics.areEqual((Object) hpack.getSTATIC_HEADER_TABLE()[i11 - 1].value, (Object) byteString)) {
                            i12 = i11;
                        } else if (Intrinsics.areEqual((Object) hpack.getSTATIC_HEADER_TABLE()[i11].value, (Object) byteString)) {
                            int i16 = i11;
                            i11++;
                            i12 = i16;
                        }
                    }
                    i12 = i11;
                    i11 = -1;
                } else {
                    i12 = -1;
                    i11 = -1;
                }
                if (i11 == -1) {
                    int i17 = this.nextHeaderIndex + 1;
                    int length = this.dynamicTable.length;
                    while (true) {
                        if (i17 >= length) {
                            break;
                        }
                        int i18 = i17 + 1;
                        Header header2 = this.dynamicTable[i17];
                        Intrinsics.checkNotNull(header2);
                        if (Intrinsics.areEqual((Object) header2.f27529name, (Object) asciiLowercase)) {
                            Header header3 = this.dynamicTable[i17];
                            Intrinsics.checkNotNull(header3);
                            if (Intrinsics.areEqual((Object) header3.value, (Object) byteString)) {
                                i11 = Hpack.INSTANCE.getSTATIC_HEADER_TABLE().length + (i17 - this.nextHeaderIndex);
                                break;
                            } else if (i12 == -1) {
                                i12 = Hpack.INSTANCE.getSTATIC_HEADER_TABLE().length + (i17 - this.nextHeaderIndex);
                            }
                        }
                        i17 = i18;
                    }
                }
                if (i11 != -1) {
                    writeInt(i11, 127, 128);
                } else if (i12 == -1) {
                    this.out.writeByte(64);
                    writeByteString(asciiLowercase);
                    writeByteString(byteString);
                    insertIntoDynamicTable(header);
                } else if (!asciiLowercase.startsWith(Header.PSEUDO_PREFIX) || Intrinsics.areEqual((Object) Header.TARGET_AUTHORITY, (Object) asciiLowercase)) {
                    writeInt(i12, 63, 64);
                    writeByteString(byteString);
                    insertIntoDynamicTable(header);
                } else {
                    writeInt(i12, 15, 0);
                    writeByteString(byteString);
                }
                i14 = i15;
            }
        }

        public final void writeInt(int i11, int i12, int i13) {
            if (i11 < i12) {
                this.out.writeByte(i11 | i13);
                return;
            }
            this.out.writeByte(i13 | i12);
            int i14 = i11 - i12;
            while (i14 >= 128) {
                this.out.writeByte(128 | (i14 & 127));
                i14 >>>= 7;
            }
            this.out.writeByte(i14);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Writer(int i11, boolean z11, Buffer buffer, int i12, DefaultConstructorMarker defaultConstructorMarker) {
            this((i12 & 1) != 0 ? 4096 : i11, (i12 & 2) != 0 ? true : z11, buffer);
        }
    }
}
