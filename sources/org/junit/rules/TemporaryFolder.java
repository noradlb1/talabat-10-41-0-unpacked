package org.junit.rules;

import java.io.File;
import java.io.IOException;

public class TemporaryFolder extends ExternalResource {
    private File folder;
    private final File parentFolder;

    public TemporaryFolder() {
        this((File) null);
    }

    private File createTemporaryFolderIn(File file) throws IOException {
        File createTempFile = File.createTempFile("junit", "", file);
        createTempFile.delete();
        createTempFile.mkdir();
        return createTempFile;
    }

    private boolean isLastElementInArray(int i11, String[] strArr) {
        return i11 == strArr.length - 1;
    }

    private void recursiveDelete(File file) {
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File recursiveDelete : listFiles) {
                recursiveDelete(recursiveDelete);
            }
        }
        file.delete();
    }

    private void validateFolderName(String str) throws IOException {
        if (new File(str).getParent() != null) {
            throw new IOException("Folder name cannot consist of multiple path components separated by a file separator. Please use newFolder('MyParentFolder','MyFolder') to create hierarchies of folders");
        }
    }

    public void a() {
        delete();
    }

    public void b() throws Throwable {
        create();
    }

    public void create() throws IOException {
        this.folder = createTemporaryFolderIn(this.parentFolder);
    }

    public void delete() {
        File file = this.folder;
        if (file != null) {
            recursiveDelete(file);
        }
    }

    public File getRoot() {
        File file = this.folder;
        if (file != null) {
            return file;
        }
        throw new IllegalStateException("the temporary folder has not yet been created");
    }

    public File newFile(String str) throws IOException {
        File file = new File(getRoot(), str);
        if (file.createNewFile()) {
            return file;
        }
        throw new IOException("a file with the name '" + str + "' already exists in the test folder");
    }

    public File newFolder(String str) throws IOException {
        return newFolder(str);
    }

    public TemporaryFolder(File file) {
        this.parentFolder = file;
    }

    public File newFolder(String... strArr) throws IOException {
        File root = getRoot();
        int i11 = 0;
        while (i11 < strArr.length) {
            String str = strArr[i11];
            validateFolderName(str);
            File file = new File(root, str);
            if (file.mkdir() || !isLastElementInArray(i11, strArr)) {
                i11++;
                root = file;
            } else {
                throw new IOException("a folder with the name '" + str + "' already exists");
            }
        }
        return root;
    }

    public File newFile() throws IOException {
        return File.createTempFile("junit", (String) null, getRoot());
    }

    public File newFolder() throws IOException {
        return createTemporaryFolderIn(getRoot());
    }
}
