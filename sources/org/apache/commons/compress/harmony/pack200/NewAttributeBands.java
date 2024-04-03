package org.apache.commons.compress.harmony.pack200;

import androidx.exifinterface.media.ExifInterface;
import com.talabat.sidemenu.SideMenuRewardViewHolder;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.apache.commons.compress.harmony.pack200.AttributeDefinitionBands;
import org.objectweb.asm.Label;

public class NewAttributeBands extends BandSet {
    protected List attributeLayoutElements;
    /* access modifiers changed from: private */
    public int[] backwardsCallCounts;
    /* access modifiers changed from: private */
    public final CpBands cpBands;
    private final AttributeDefinitionBands.AttributeDefinition def;
    private Integral lastPIntegral;
    private boolean usedAtLeastOnce;

    public interface AttributeLayoutElement {
        void addAttributeToBand(NewAttribute newAttribute, InputStream inputStream);

        void pack(OutputStream outputStream) throws IOException, Pack200Exception;

        void renumberBci(IntList intList, Map map);
    }

    public class Call extends LayoutElement {
        private Callable callable;
        /* access modifiers changed from: private */
        public final int callableIndex;

        public Call(int i11) {
            super();
            this.callableIndex = i11;
        }

        public void addAttributeToBand(NewAttribute newAttribute, InputStream inputStream) {
            this.callable.addAttributeToBand(newAttribute, inputStream);
            if (this.callableIndex < 1) {
                this.callable.addBackwardsCall();
            }
        }

        public Callable getCallable() {
            return this.callable;
        }

        public int getCallableIndex() {
            return this.callableIndex;
        }

        public void pack(OutputStream outputStream) {
        }

        public void renumberBci(IntList intList, Map map) {
        }

        public void setCallable(Callable callable2) {
            this.callable = callable2;
            if (this.callableIndex < 1) {
                callable2.setBackwardsCallable();
            }
        }
    }

    public class Callable implements AttributeLayoutElement {
        private int backwardsCallableIndex;
        /* access modifiers changed from: private */
        public final List body;
        /* access modifiers changed from: private */
        public boolean isBackwardsCallable;

        public Callable(List list) throws IOException {
            this.body = list;
        }

        public void addAttributeToBand(NewAttribute newAttribute, InputStream inputStream) {
            for (AttributeLayoutElement addAttributeToBand : this.body) {
                addAttributeToBand.addAttributeToBand(newAttribute, inputStream);
            }
        }

        public void addBackwardsCall() {
            int[] access$800 = NewAttributeBands.this.backwardsCallCounts;
            int i11 = this.backwardsCallableIndex;
            access$800[i11] = access$800[i11] + 1;
        }

        public List getBody() {
            return this.body;
        }

        public boolean isBackwardsCallable() {
            return this.isBackwardsCallable;
        }

        public void pack(OutputStream outputStream) throws IOException, Pack200Exception {
            for (AttributeLayoutElement pack : this.body) {
                pack.pack(outputStream);
            }
        }

        public void renumberBci(IntList intList, Map map) {
            for (AttributeLayoutElement renumberBci : this.body) {
                renumberBci.renumberBci(intList, map);
            }
        }

        public void setBackwardsCallable() {
            this.isBackwardsCallable = true;
        }

        public void setBackwardsCallableIndex(int i11) {
            this.backwardsCallableIndex = i11;
        }
    }

    public abstract class LayoutElement implements AttributeLayoutElement {
        public LayoutElement() {
        }

        public int getLength(char c11) {
            if (c11 == 'B') {
                return 1;
            }
            if (c11 == 'V') {
                return 0;
            }
            if (c11 != 'H') {
                return c11 != 'I' ? 0 : 4;
            }
            return 2;
        }
    }

    public class Reference extends LayoutElement {
        private List band;
        private boolean nullsAllowed = false;
        private final String tag;

        public Reference(String str) {
            super();
            boolean z11 = false;
            this.tag = str;
            this.nullsAllowed = str.indexOf(78) != -1 ? true : z11;
        }

        public void addAttributeToBand(NewAttribute newAttribute, InputStream inputStream) {
            int access$500 = NewAttributeBands.this.readInteger(4, inputStream);
            if (this.tag.startsWith("RC")) {
                this.band.add(NewAttributeBands.this.cpBands.getCPClass(newAttribute.readClass(access$500)));
            } else if (this.tag.startsWith("RU")) {
                this.band.add(NewAttributeBands.this.cpBands.getCPUtf8(newAttribute.readUTF8(access$500)));
            } else if (this.tag.startsWith("RS")) {
                this.band.add(NewAttributeBands.this.cpBands.getCPSignature(newAttribute.readUTF8(access$500)));
            } else {
                this.band.add(NewAttributeBands.this.cpBands.getConstant(newAttribute.readConst(access$500)));
            }
        }

        public String getTag() {
            return this.tag;
        }

        public void pack(OutputStream outputStream) throws IOException, Pack200Exception {
            int[] iArr;
            if (this.nullsAllowed) {
                iArr = NewAttributeBands.this.cpEntryOrNullListToArray(this.band);
            } else {
                iArr = NewAttributeBands.this.cpEntryListToArray(this.band);
            }
            byte[] encodeBandInt = NewAttributeBands.this.encodeBandInt(this.tag, iArr, Codec.UNSIGNED5);
            outputStream.write(encodeBandInt);
            PackingUtils.log("Wrote " + encodeBandInt.length + " bytes from " + this.tag + "[" + iArr.length + "]");
        }

        public void renumberBci(IntList intList, Map map) {
        }
    }

    public class Replication extends LayoutElement {
        private final Integral countElement;
        /* access modifiers changed from: private */
        public final List layoutElements = new ArrayList();

        public Replication(String str, String str2) throws IOException {
            super();
            this.countElement = new Integral(str);
            StringReader stringReader = new StringReader(str2);
            while (true) {
                LayoutElement access$600 = NewAttributeBands.this.readNextLayoutElement(stringReader);
                if (access$600 != null) {
                    this.layoutElements.add(access$600);
                } else {
                    return;
                }
            }
        }

        public void addAttributeToBand(NewAttribute newAttribute, InputStream inputStream) {
            this.countElement.addAttributeToBand(newAttribute, inputStream);
            int latestValue = this.countElement.latestValue();
            for (int i11 = 0; i11 < latestValue; i11++) {
                for (AttributeLayoutElement addAttributeToBand : this.layoutElements) {
                    addAttributeToBand.addAttributeToBand(newAttribute, inputStream);
                }
            }
        }

        public Integral getCountElement() {
            return this.countElement;
        }

        public List getLayoutElements() {
            return this.layoutElements;
        }

        public void pack(OutputStream outputStream) throws IOException, Pack200Exception {
            this.countElement.pack(outputStream);
            for (AttributeLayoutElement pack : this.layoutElements) {
                pack.pack(outputStream);
            }
        }

        public void renumberBci(IntList intList, Map map) {
            for (AttributeLayoutElement renumberBci : this.layoutElements) {
                renumberBci.renumberBci(intList, map);
            }
        }
    }

    public class Union extends LayoutElement {
        private final List defaultCaseBody;
        private final List unionCases;
        private final Integral unionTag;

        public Union(String str, List list, List list2) {
            super();
            this.unionTag = new Integral(str);
            this.unionCases = list;
            this.defaultCaseBody = list2;
        }

        public void addAttributeToBand(NewAttribute newAttribute, InputStream inputStream) {
            this.unionTag.addAttributeToBand(newAttribute, inputStream);
            long latestValue = (long) this.unionTag.latestValue();
            boolean z11 = true;
            for (int i11 = 0; i11 < this.unionCases.size(); i11++) {
                UnionCase unionCase = (UnionCase) this.unionCases.get(i11);
                if (unionCase.hasTag(latestValue)) {
                    unionCase.addAttributeToBand(newAttribute, inputStream);
                    z11 = false;
                }
            }
            if (z11) {
                for (int i12 = 0; i12 < this.defaultCaseBody.size(); i12++) {
                    ((LayoutElement) this.defaultCaseBody.get(i12)).addAttributeToBand(newAttribute, inputStream);
                }
            }
        }

        public List getDefaultCaseBody() {
            return this.defaultCaseBody;
        }

        public List getUnionCases() {
            return this.unionCases;
        }

        public Integral getUnionTag() {
            return this.unionTag;
        }

        public void pack(OutputStream outputStream) throws IOException, Pack200Exception {
            this.unionTag.pack(outputStream);
            for (UnionCase pack : this.unionCases) {
                pack.pack(outputStream);
            }
            for (AttributeLayoutElement pack2 : this.defaultCaseBody) {
                pack2.pack(outputStream);
            }
        }

        public void renumberBci(IntList intList, Map map) {
            for (UnionCase renumberBci : this.unionCases) {
                renumberBci.renumberBci(intList, map);
            }
            for (AttributeLayoutElement renumberBci2 : this.defaultCaseBody) {
                renumberBci2.renumberBci(intList, map);
            }
        }
    }

    public NewAttributeBands(int i11, CpBands cpBands2, SegmentHeader segmentHeader, AttributeDefinitionBands.AttributeDefinition attributeDefinition) throws IOException {
        super(i11, segmentHeader);
        this.def = attributeDefinition;
        this.cpBands = cpBands2;
        parseLayout();
    }

    /* access modifiers changed from: private */
    public BHSDCodec getCodec(String str) {
        if (str.indexOf(79) >= 0) {
            return Codec.BRANCH5;
        }
        if (str.indexOf(80) >= 0) {
            return Codec.BCI5;
        }
        if (str.indexOf(83) >= 0 && str.indexOf("KS") < 0 && str.indexOf("RS") < 0) {
            return Codec.SIGNED5;
        }
        if (str.indexOf(66) >= 0) {
            return Codec.BYTE1;
        }
        return Codec.UNSIGNED5;
    }

    private StringReader getStreamUpToMatchingBracket(StringReader stringReader) throws IOException {
        StringBuffer stringBuffer = new StringBuffer();
        int i11 = -1;
        while (i11 != 0) {
            char read = (char) stringReader.read();
            if (read == ']') {
                i11++;
            }
            if (read == '[') {
                i11--;
            }
            if (i11 != 0) {
                stringBuffer.append(read);
            }
        }
        return new StringReader(stringBuffer.toString());
    }

    private void parseLayout() throws IOException {
        String underlyingString = this.def.layout.getUnderlyingString();
        if (this.attributeLayoutElements == null) {
            this.attributeLayoutElements = new ArrayList();
            StringReader stringReader = new StringReader(underlyingString);
            while (true) {
                AttributeLayoutElement readNextAttributeElement = readNextAttributeElement(stringReader);
                if (readNextAttributeElement != null) {
                    this.attributeLayoutElements.add(readNextAttributeElement);
                } else {
                    resolveCalls();
                    return;
                }
            }
        }
    }

    private List readBody(StringReader stringReader) throws IOException {
        ArrayList arrayList = new ArrayList();
        while (true) {
            LayoutElement readNextLayoutElement = readNextLayoutElement(stringReader);
            if (readNextLayoutElement == null) {
                return arrayList;
            }
            arrayList.add(readNextLayoutElement);
        }
    }

    /* access modifiers changed from: private */
    public int readInteger(int i11, InputStream inputStream) {
        int i12 = 0;
        byte b11 = 0;
        while (i12 < i11) {
            try {
                b11 = (b11 << 8) | inputStream.read();
                i12++;
            } catch (IOException unused) {
                throw new RuntimeException("Error reading unknown attribute");
            }
        }
        if (i11 == 1) {
            b11 = (byte) b11;
        }
        if (i11 == 2) {
            return (short) b11;
        }
        return b11;
    }

    private AttributeLayoutElement readNextAttributeElement(StringReader stringReader) throws IOException {
        stringReader.mark(1);
        int read = stringReader.read();
        if (read == -1) {
            return null;
        }
        if (read == 91) {
            return new Callable(readBody(getStreamUpToMatchingBracket(stringReader)));
        }
        stringReader.reset();
        return readNextLayoutElement(stringReader);
    }

    /* access modifiers changed from: private */
    public LayoutElement readNextLayoutElement(StringReader stringReader) throws IOException {
        int read = stringReader.read();
        List list = null;
        if (read == -1) {
            return null;
        }
        if (read != 40) {
            if (read != 66) {
                if (read != 70) {
                    if (read != 75) {
                        if (!(read == 86 || read == 72 || read == 73)) {
                            switch (read) {
                                case 78:
                                    stringReader.read();
                                    return new Replication("" + ((char) stringReader.read()), readUpToMatchingBracket(stringReader));
                                case 79:
                                    stringReader.mark(1);
                                    if (stringReader.read() != 83) {
                                        stringReader.reset();
                                        return new Integral("O" + ((char) stringReader.read()), this.lastPIntegral);
                                    }
                                    return new Integral("OS" + ((char) stringReader.read()), this.lastPIntegral);
                                case 80:
                                    stringReader.mark(1);
                                    if (stringReader.read() != 79) {
                                        stringReader.reset();
                                        Integral integral = new Integral("P" + ((char) stringReader.read()));
                                        this.lastPIntegral = integral;
                                        return integral;
                                    }
                                    Integral integral2 = new Integral("PO" + ((char) stringReader.read()), this.lastPIntegral);
                                    this.lastPIntegral = integral2;
                                    return integral2;
                                default:
                                    switch (read) {
                                        case 82:
                                            break;
                                        case 83:
                                            break;
                                        case 84:
                                            String str = "" + ((char) stringReader.read());
                                            if (str.equals(ExifInterface.LATITUDE_SOUTH)) {
                                                str = str + ((char) stringReader.read());
                                            }
                                            ArrayList arrayList = new ArrayList();
                                            while (true) {
                                                UnionCase readNextUnionCase = readNextUnionCase(stringReader);
                                                if (readNextUnionCase != null) {
                                                    arrayList.add(readNextUnionCase);
                                                } else {
                                                    stringReader.read();
                                                    stringReader.read();
                                                    stringReader.read();
                                                    stringReader.mark(1);
                                                    if (((char) stringReader.read()) != ']') {
                                                        stringReader.reset();
                                                        list = readBody(getStreamUpToMatchingBracket(stringReader));
                                                    }
                                                    return new Union(str, arrayList, list);
                                                }
                                            }
                                        default:
                                            return null;
                                    }
                                    break;
                            }
                        }
                    }
                    StringBuilder sb2 = new StringBuilder("");
                    sb2.append((char) read);
                    sb2.append((char) stringReader.read());
                    char read2 = (char) stringReader.read();
                    sb2.append(read2);
                    if (read2 == 'N') {
                        sb2.append((char) stringReader.read());
                    }
                    return new Reference(sb2.toString());
                }
                return new Integral(new String(new char[]{(char) read, (char) stringReader.read()}));
            }
            return new Integral(new String(new char[]{(char) read}));
        }
        int intValue = readNumber(stringReader).intValue();
        stringReader.read();
        return new Call(intValue);
    }

    private UnionCase readNextUnionCase(StringReader stringReader) throws IOException {
        Integer readNumber;
        stringReader.mark(2);
        stringReader.read();
        if (((char) stringReader.read()) == ')') {
            stringReader.reset();
            return null;
        }
        stringReader.reset();
        stringReader.read();
        ArrayList arrayList = new ArrayList();
        do {
            readNumber = readNumber(stringReader);
            if (readNumber != null) {
                arrayList.add(readNumber);
                stringReader.read();
                continue;
            }
        } while (readNumber != null);
        stringReader.read();
        stringReader.mark(1);
        if (((char) stringReader.read()) == ']') {
            return new UnionCase(arrayList);
        }
        stringReader.reset();
        return new UnionCase(arrayList, readBody(getStreamUpToMatchingBracket(stringReader)));
    }

    private Integer readNumber(StringReader stringReader) throws IOException {
        String str;
        boolean z11 = true;
        stringReader.mark(1);
        int i11 = 0;
        if (((char) stringReader.read()) != '-') {
            z11 = false;
        }
        if (!z11) {
            stringReader.reset();
        }
        stringReader.mark(100);
        while (true) {
            int read = stringReader.read();
            if (read == -1 || !Character.isDigit((char) read)) {
                stringReader.reset();
            } else {
                i11++;
            }
        }
        stringReader.reset();
        if (i11 == 0) {
            return null;
        }
        char[] cArr = new char[i11];
        if (stringReader.read(cArr) == i11) {
            StringBuilder sb2 = new StringBuilder();
            if (z11) {
                str = SideMenuRewardViewHolder.DEFAULT_LOGGED_IN_USER_POINTS_VALUE;
            } else {
                str = "";
            }
            sb2.append(str);
            sb2.append(new String(cArr));
            return Integer.valueOf(Integer.parseInt(sb2.toString()));
        }
        throw new IOException("Error reading from the input stream");
    }

    private String readUpToMatchingBracket(StringReader stringReader) throws IOException {
        StringBuffer stringBuffer = new StringBuffer();
        int i11 = -1;
        while (i11 != 0) {
            char read = (char) stringReader.read();
            if (read == ']') {
                i11++;
            }
            if (read == '[') {
                i11--;
            }
            if (i11 != 0) {
                stringBuffer.append(read);
            }
        }
        return stringBuffer.toString();
    }

    private void resolveCalls() {
        for (int i11 = 0; i11 < this.attributeLayoutElements.size(); i11++) {
            AttributeLayoutElement attributeLayoutElement = (AttributeLayoutElement) this.attributeLayoutElements.get(i11);
            if (attributeLayoutElement instanceof Callable) {
                Callable callable = (Callable) attributeLayoutElement;
                List access$000 = callable.body;
                for (int i12 = 0; i12 < access$000.size(); i12++) {
                    resolveCallsForElement(i11, callable, (LayoutElement) access$000.get(i12));
                }
            }
        }
        int i13 = 0;
        for (int i14 = 0; i14 < this.attributeLayoutElements.size(); i14++) {
            AttributeLayoutElement attributeLayoutElement2 = (AttributeLayoutElement) this.attributeLayoutElements.get(i14);
            if (attributeLayoutElement2 instanceof Callable) {
                Callable callable2 = (Callable) attributeLayoutElement2;
                if (callable2.isBackwardsCallable) {
                    callable2.setBackwardsCallableIndex(i13);
                    i13++;
                }
            }
        }
        this.backwardsCallCounts = new int[i13];
    }

    private void resolveCallsForElement(int i11, Callable callable, LayoutElement layoutElement) {
        if (layoutElement instanceof Call) {
            Call call = (Call) layoutElement;
            int access$200 = call.callableIndex;
            if (access$200 == 0) {
                call.setCallable(callable);
            } else if (access$200 > 0) {
                while (true) {
                    i11++;
                    if (i11 < this.attributeLayoutElements.size()) {
                        AttributeLayoutElement attributeLayoutElement = (AttributeLayoutElement) this.attributeLayoutElements.get(i11);
                        if ((attributeLayoutElement instanceof Callable) && access$200 - 1 == 0) {
                            call.setCallable((Callable) attributeLayoutElement);
                            return;
                        }
                    } else {
                        return;
                    }
                }
            } else {
                int i12 = i11 - 1;
                while (i12 >= 0) {
                    AttributeLayoutElement attributeLayoutElement2 = (AttributeLayoutElement) this.attributeLayoutElements.get(i12);
                    if (!(attributeLayoutElement2 instanceof Callable) || (access$200 = access$200 + 1) != 0) {
                        i12--;
                    } else {
                        call.setCallable((Callable) attributeLayoutElement2);
                        return;
                    }
                }
            }
        } else if (layoutElement instanceof Replication) {
            for (LayoutElement resolveCallsForElement : ((Replication) layoutElement).layoutElements) {
                resolveCallsForElement(i11, callable, resolveCallsForElement);
            }
        }
    }

    public void addAttribute(NewAttribute newAttribute) {
        this.usedAtLeastOnce = true;
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(newAttribute.getBytes());
        for (AttributeLayoutElement addAttributeToBand : this.attributeLayoutElements) {
            addAttributeToBand.addAttributeToBand(newAttribute, byteArrayInputStream);
        }
    }

    public String getAttributeName() {
        return this.def.f27726name.getUnderlyingString();
    }

    public int getFlagIndex() {
        return this.def.index;
    }

    public boolean isUsedAtLeastOnce() {
        return this.usedAtLeastOnce;
    }

    public int[] numBackwardsCalls() {
        return this.backwardsCallCounts;
    }

    public void pack(OutputStream outputStream) throws IOException, Pack200Exception {
        for (AttributeLayoutElement pack : this.attributeLayoutElements) {
            pack.pack(outputStream);
        }
    }

    public void renumberBci(IntList intList, Map map) {
        for (AttributeLayoutElement renumberBci : this.attributeLayoutElements) {
            renumberBci.renumberBci(intList, map);
        }
    }

    public class UnionCase extends LayoutElement {
        private final List body;
        private final List tags;

        public UnionCase(List list) {
            super();
            this.tags = list;
            this.body = Collections.EMPTY_LIST;
        }

        public void addAttributeToBand(NewAttribute newAttribute, InputStream inputStream) {
            for (int i11 = 0; i11 < this.body.size(); i11++) {
                ((LayoutElement) this.body.get(i11)).addAttributeToBand(newAttribute, inputStream);
            }
        }

        public List getBody() {
            return this.body;
        }

        public boolean hasTag(long j11) {
            return this.tags.contains(Integer.valueOf((int) j11));
        }

        public void pack(OutputStream outputStream) throws IOException, Pack200Exception {
            for (int i11 = 0; i11 < this.body.size(); i11++) {
                ((LayoutElement) this.body.get(i11)).pack(outputStream);
            }
        }

        public void renumberBci(IntList intList, Map map) {
            for (int i11 = 0; i11 < this.body.size(); i11++) {
                ((LayoutElement) this.body.get(i11)).renumberBci(intList, map);
            }
        }

        public UnionCase(List list, List list2) throws IOException {
            super();
            this.tags = list;
            this.body = list2;
        }
    }

    public class Integral extends LayoutElement {
        private final List band = new ArrayList();
        private final BHSDCodec defaultCodec;
        private Integral previousIntegral;
        private int previousPValue;
        private final String tag;

        public Integral(String str) {
            super();
            this.tag = str;
            this.defaultCodec = NewAttributeBands.this.getCodec(str);
        }

        private void renumberOffsetBci(List list, IntList intList, Map map) {
            int size = this.band.size() - 1;
            while (size >= 0) {
                Object obj = this.band.get(size);
                if (!(obj instanceof Integer)) {
                    if (obj instanceof Label) {
                        this.band.remove(size);
                        this.band.add(size, Integer.valueOf(intList.get(((Integer) map.get(obj)).intValue()) - ((Integer) list.get(size)).intValue()));
                    }
                    size--;
                } else {
                    return;
                }
            }
        }

        public void addAttributeToBand(NewAttribute newAttribute, InputStream inputStream) {
            int i11;
            int i12;
            Label label = null;
            if (this.tag.equals("B") || this.tag.equals("FB")) {
                i11 = NewAttributeBands.this.readInteger(1, inputStream) & 255;
            } else if (this.tag.equals("SB")) {
                i11 = NewAttributeBands.this.readInteger(1, inputStream);
            } else if (this.tag.equals("H") || this.tag.equals("FH")) {
                i11 = NewAttributeBands.this.readInteger(2, inputStream) & 65535;
            } else if (this.tag.equals("SH")) {
                i11 = NewAttributeBands.this.readInteger(2, inputStream);
            } else if (this.tag.equals("I") || this.tag.equals("FI")) {
                i11 = NewAttributeBands.this.readInteger(4, inputStream);
            } else if (this.tag.equals("SI")) {
                i11 = NewAttributeBands.this.readInteger(4, inputStream);
            } else {
                if (!this.tag.equals(ExifInterface.GPS_MEASUREMENT_INTERRUPTED) && !this.tag.equals("FV") && !this.tag.equals("SV")) {
                    if (this.tag.startsWith("PO") || this.tag.startsWith("OS")) {
                        i12 = NewAttributeBands.this.readInteger(getLength(this.tag.substring(2).toCharArray()[0]), inputStream) + this.previousIntegral.previousPValue;
                        label = newAttribute.getLabel(i12);
                        this.previousPValue = i12;
                    } else if (this.tag.startsWith("P")) {
                        i12 = NewAttributeBands.this.readInteger(getLength(this.tag.substring(1).toCharArray()[0]), inputStream);
                        label = newAttribute.getLabel(i12);
                        this.previousPValue = i12;
                    } else if (this.tag.startsWith("O")) {
                        i12 = NewAttributeBands.this.readInteger(getLength(this.tag.substring(1).toCharArray()[0]), inputStream) + this.previousIntegral.previousPValue;
                        label = newAttribute.getLabel(i12);
                        this.previousPValue = i12;
                    }
                    i11 = i12;
                }
                i11 = 0;
            }
            if (label == null) {
                label = Integer.valueOf(i11);
            }
            this.band.add(label);
        }

        public String getTag() {
            return this.tag;
        }

        public int latestValue() {
            List list = this.band;
            return ((Integer) list.get(list.size() - 1)).intValue();
        }

        public void pack(OutputStream outputStream) throws IOException, Pack200Exception {
            PackingUtils.log("Writing new attribute bands...");
            NewAttributeBands newAttributeBands = NewAttributeBands.this;
            byte[] encodeBandInt = newAttributeBands.encodeBandInt(this.tag, newAttributeBands.integerListToArray(this.band), this.defaultCodec);
            outputStream.write(encodeBandInt);
            PackingUtils.log("Wrote " + encodeBandInt.length + " bytes from " + this.tag + "[" + this.band.size() + "]");
        }

        public void renumberBci(IntList intList, Map map) {
            if (this.tag.startsWith("O") || this.tag.startsWith("PO")) {
                renumberOffsetBci(this.previousIntegral.band, intList, map);
            } else if (this.tag.startsWith("P")) {
                int size = this.band.size() - 1;
                while (size >= 0) {
                    Object obj = this.band.get(size);
                    if (!(obj instanceof Integer)) {
                        if (obj instanceof Label) {
                            this.band.remove(size);
                            this.band.add(size, Integer.valueOf(intList.get(((Integer) map.get(obj)).intValue())));
                        }
                        size--;
                    } else {
                        return;
                    }
                }
            }
        }

        public Integral(String str, Integral integral) {
            super();
            this.tag = str;
            this.defaultCodec = NewAttributeBands.this.getCodec(str);
            this.previousIntegral = integral;
        }
    }
}
