package org.apache.commons.compress.harmony.pack200;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.jar.JarInputStream;
import java.util.zip.GZIPOutputStream;

public class Archive {
    private long currentSegmentSize;
    private JarFile jarFile;
    private final JarInputStream jarInputStream;
    private final PackingOptions options;
    private final OutputStream outputStream;

    public static class SegmentUnit {
        private int byteAmount = 0;
        private final List classList;
        private final List fileList;
        private int packedByteAmount = 0;

        public SegmentUnit(List list, List list2) {
            this.classList = list;
            this.fileList = list2;
            Iterator it = list.iterator();
            while (it.hasNext()) {
                this.byteAmount += ((Pack200ClassReader) it.next()).b.length;
            }
            for (PackingFile a11 : this.fileList) {
                this.byteAmount += a11.contents.length;
            }
        }

        public void addPackedByteAmount(int i11) {
            this.packedByteAmount += i11;
        }

        public int classListSize() {
            return this.classList.size();
        }

        public int fileListSize() {
            return this.fileList.size();
        }

        public int getByteAmount() {
            return this.byteAmount;
        }

        public List getClassList() {
            return this.classList;
        }

        public List getFileList() {
            return this.fileList;
        }

        public int getPackedByteAmount() {
            return this.packedByteAmount;
        }
    }

    public Archive(JarInputStream jarInputStream2, OutputStream outputStream2, PackingOptions packingOptions) throws IOException {
        this.jarInputStream = jarInputStream2;
        packingOptions = packingOptions == null ? new PackingOptions() : packingOptions;
        this.options = packingOptions;
        this.outputStream = new BufferedOutputStream(packingOptions.isGzip() ? new GZIPOutputStream(outputStream2) : outputStream2);
        PackingUtils.config(packingOptions);
    }

    private boolean addJarEntry(PackingFile packingFile, List list, List list2) throws IOException, Pack200Exception {
        long segmentLimit = this.options.getSegmentLimit();
        if (!(segmentLimit == -1 || segmentLimit == 0)) {
            long estimateSize = estimateSize(packingFile);
            long j11 = this.currentSegmentSize;
            if (estimateSize + j11 > segmentLimit && j11 > 0) {
                return false;
            }
            this.currentSegmentSize = j11 + estimateSize;
        }
        String name2 = packingFile.getName();
        if (name2.endsWith(".class") && !this.options.isPassFile(name2)) {
            Pack200ClassReader pack200ClassReader = new Pack200ClassReader(packingFile.contents);
            pack200ClassReader.setFileName(name2);
            list.add(pack200ClassReader);
            byte[] unused = packingFile.contents = new byte[0];
        }
        list2.add(packingFile);
        return true;
    }

    private void doNormalPack() throws IOException, Pack200Exception {
        List list;
        PackingUtils.log("Start to perform a normal packing");
        JarInputStream jarInputStream2 = this.jarInputStream;
        if (jarInputStream2 != null) {
            list = PackingUtils.getPackingFileListFromJar(jarInputStream2, this.options.isKeepFileOrder());
        } else {
            list = PackingUtils.getPackingFileListFromJar(this.jarFile, this.options.isKeepFileOrder());
        }
        List splitIntoSegments = splitIntoSegments(list);
        int size = splitIntoSegments.size();
        int i11 = 0;
        int i12 = 0;
        for (int i13 = 0; i13 < size; i13++) {
            SegmentUnit segmentUnit = (SegmentUnit) splitIntoSegments.get(i13);
            new Segment().pack(segmentUnit, this.outputStream, this.options);
            i11 += segmentUnit.getByteAmount();
            i12 += segmentUnit.getPackedByteAmount();
        }
        PackingUtils.log("Total: Packed " + i11 + " input bytes of " + list.size() + " files into " + i12 + " bytes in " + size + " segments");
        this.outputStream.close();
    }

    private void doZeroEffortPack() throws IOException, Pack200Exception {
        PackingUtils.log("Start to perform a zero-effort packing");
        JarInputStream jarInputStream2 = this.jarInputStream;
        if (jarInputStream2 != null) {
            PackingUtils.copyThroughJar(jarInputStream2, this.outputStream);
        } else {
            PackingUtils.copyThroughJar(this.jarFile, this.outputStream);
        }
    }

    private long estimateSize(PackingFile packingFile) {
        String name2 = packingFile.getName();
        long j11 = 0;
        if (name2.startsWith("META-INF") || name2.startsWith("/META-INF")) {
            return 0;
        }
        long length = (long) packingFile.contents.length;
        if (length >= 0) {
            j11 = length;
        }
        return ((long) name2.length()) + j11 + 5;
    }

    private List splitIntoSegments(List list) throws IOException, Pack200Exception {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        long segmentLimit = this.options.getSegmentLimit();
        int size = list.size();
        for (int i11 = 0; i11 < size; i11++) {
            PackingFile packingFile = (PackingFile) list.get(i11);
            if (!addJarEntry(packingFile, arrayList2, arrayList3)) {
                arrayList.add(new SegmentUnit(arrayList2, arrayList3));
                arrayList2 = new ArrayList();
                arrayList3 = new ArrayList();
                this.currentSegmentSize = 0;
                addJarEntry(packingFile, arrayList2, arrayList3);
                this.currentSegmentSize = 0;
            } else if (segmentLimit == 0 && estimateSize(packingFile) > 0) {
                arrayList.add(new SegmentUnit(arrayList2, arrayList3));
                arrayList2 = new ArrayList();
                arrayList3 = new ArrayList();
            }
        }
        if (arrayList2.size() > 0 || arrayList3.size() > 0) {
            arrayList.add(new SegmentUnit(arrayList2, arrayList3));
        }
        return arrayList;
    }

    public void pack() throws Pack200Exception, IOException {
        if (this.options.getEffort() == 0) {
            doZeroEffortPack();
        } else {
            doNormalPack();
        }
    }

    public static class PackingFile {
        /* access modifiers changed from: private */
        public byte[] contents;
        private final boolean deflateHint;
        private final boolean isDirectory;
        private final long modtime;

        /* renamed from: name  reason: collision with root package name */
        private final String f27725name;

        public PackingFile(String str, byte[] bArr, long j11) {
            this.f27725name = str;
            this.contents = bArr;
            this.modtime = j11;
            this.deflateHint = false;
            this.isDirectory = false;
        }

        public byte[] getContents() {
            return this.contents;
        }

        public long getModtime() {
            return this.modtime;
        }

        public String getName() {
            return this.f27725name;
        }

        public boolean isDefalteHint() {
            return this.deflateHint;
        }

        public boolean isDirectory() {
            return this.isDirectory;
        }

        public void setContents(byte[] bArr) {
            this.contents = bArr;
        }

        public String toString() {
            return this.f27725name;
        }

        public PackingFile(byte[] bArr, JarEntry jarEntry) {
            this.f27725name = jarEntry.getName();
            this.contents = bArr;
            this.modtime = jarEntry.getTime();
            this.deflateHint = jarEntry.getMethod() == 8;
            this.isDirectory = jarEntry.isDirectory();
        }
    }

    public Archive(JarFile jarFile2, OutputStream outputStream2, PackingOptions packingOptions) throws IOException {
        packingOptions = packingOptions == null ? new PackingOptions() : packingOptions;
        this.options = packingOptions;
        this.outputStream = new BufferedOutputStream(packingOptions.isGzip() ? new GZIPOutputStream(outputStream2) : outputStream2);
        this.jarFile = jarFile2;
        this.jarInputStream = null;
        PackingUtils.config(packingOptions);
    }
}
