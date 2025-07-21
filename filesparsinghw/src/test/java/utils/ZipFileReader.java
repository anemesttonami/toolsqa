package utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ZipFileReader {
    private static ClassLoader cl = ZipFileReader.class.getClassLoader();

    public static String readFileFromZipToString(String zipName, String fileName) throws IOException {
        try (InputStream is = cl.getResourceAsStream(zipName)) {
            if (is == null) {
                throw new FileNotFoundException("Zip file not found");
            }

            try (ZipInputStream zs = new ZipInputStream(is)) {
                ZipEntry zipEntry;

                while ((zipEntry = zs.getNextEntry()) != null) {
                    System.out.println(zipEntry.getName());
                    if (zipEntry.getName().equals(fileName)) {
                        return new String(zs.readAllBytes(), StandardCharsets.UTF_8);
                    }
                }
            }
        }
        throw new FileNotFoundException("File not found in Zip");
    }

    public static InputStream readFileFromZipToInputStream(String zipName, String fileName) throws IOException {
        InputStream is = cl.getResourceAsStream(zipName);

        if (is == null) {
            throw new FileNotFoundException("Zip file not found");
        }
        ZipInputStream zs = new ZipInputStream(is);
        ZipEntry zipEntry;

        while ((zipEntry = zs.getNextEntry()) != null) {
            System.out.println(zipEntry.getName());
            if (zipEntry.getName().equals(fileName)) {
                return zs;
            }
        }

        throw new FileNotFoundException("File not found in Zip");
    }
}