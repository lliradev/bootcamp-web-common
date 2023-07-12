package com.nttdata.bootcamp.web.common.app.util;

import com.nttdata.bootcamp.web.common.app.exception.TechnicalException;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

@UtilityClass
@Slf4j
public class FileUtil {

    private final String PATH_TEMP = "/tmp";

    public void base64ToFile(String file, String fileName, String fileExtension) {
        byte[] data = Base64.getDecoder().decode(file);
        String path = String.format("%s/%s.%s", PATH_TEMP, fileName, fileExtension);
        try (OutputStream stream = Files.newOutputStream(Paths.get(path))) {
            stream.write(data);
        } catch (IOException e) {
            throw new TechnicalException(e.getMessage());
        }
    }

    public String fileToBase64(String path) {
        String base64;
        File file = new File(path);
        try {
            FileInputStream stream = new FileInputStream(file);
            byte[] fileData = new byte[(int) file.length()];
            //  int read = stream.read(fileData);
            base64 = Base64.getEncoder().encodeToString(fileData);
            stream.close();
        } catch (IOException e) {
            throw new TechnicalException(e.getMessage());
        }
        return base64;
    }

    /**
     * Method that deletes a file
     *
     * @param path The path to the file to delete
     * @return {@code true} if the file was deleted by this method;
     * {@code false} if the file could not be deleted because it did not exist
     */
    public boolean deleteFile(String path) {
        try {
            return Files.deleteIfExists(Paths.get(path));
        } catch (IOException e) {
            throw new TechnicalException(e.getMessage());
        }
    }
}
