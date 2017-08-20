package uk.co.assignment;

import javax.activation.MimetypesFileTypeMap;
import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.function.Function;

import static java.util.stream.Collectors.toList;

public class ScanFolderForFiles {

    private static final String FOLDER_TO_SCAN = "src/main/resources/vehicles_files";

    HashMap<String, String> mimeTypesToExtension = new HashMap() {
        {
            put("text/csv", ".csv");
            put("application/xls", ".xls");
        }
    };

    public static void main(String args[]) {
        System.out.print(new ScanFolderForFiles().getFilesMetadata());
        System.out.println(new ScanFolderForFiles().getFilesByMimeType("text/csv"));
    }
    public List<FileInformation> getFilesMetadata() {
        File files[] = new File(FOLDER_TO_SCAN).listFiles(file -> file.isFile());
        return Arrays.asList(files).stream().map(mapFileToMetaData).collect(toList());
    }

    private static Function<File, FileInformation> mapFileToMetaData = (file) -> {

        String mimeType = null;
        mimeType = new MimetypesFileTypeMap().getContentType(file);
        String fileName = file.getName();

        return new FileInformation(file.getName(),
                mimeType,
                fileName.substring(fileName.lastIndexOf(".") + 1),
                file.length());
    };

    public File[] getFilesByMimeType(String mimeType) {
        return new File(FOLDER_TO_SCAN).
                listFiles(file -> file.getName().endsWith(mimeTypesToExtension.get(mimeType)));
    }

}
