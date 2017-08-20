package uk.co.assignment;


public class FileInformation {
    private String extension;
    private String fileName;
    private String mimeType;
    private long fileSize;

    public FileInformation(String fileName, String mimeType, String extension, long fileSize) {
        this.fileName = fileName;
        this.mimeType = mimeType;
        this.extension = extension;
        this.fileSize = fileSize;
    }


    public long getFileSize() {
        return fileSize;
    }

    public String getMimeType() {
        return mimeType;
    }

    public String getFileName() {
        return fileName;
    }

    public String getExtension() {
        return extension;
    }

    @Override
    public String toString() {
         return String.format("File name:%s, Mime type:%s, Extension:%s FileSize in bytes:%d \n", this.fileName, this.mimeType, this.extension, this.fileSize);
    }
}
