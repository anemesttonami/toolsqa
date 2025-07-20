package tests;

import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class FilesParsingTest {
    ClassLoader cl = FilesParsingTest.class.getClassLoader();

    @Test
    public void csvTest() throws IOException, CsvException {
        try (CSVReader reader = new CSVReader(new InputStreamReader(cl.getResourceAsStream("csvFile.csv")))) {
            List<String[]> csvLineArraysList = reader.readAll();

            Assertions.assertEquals(2, csvLineArraysList.size());
            Assertions.assertArrayEquals(new String[]{"First", "123"}, csvLineArraysList.get(0));
            Assertions.assertArrayEquals(new String[]{"Second", "456"}, csvLineArraysList.get(1));
        }
    }

    @Test
    public void upgradedCsvTest() throws IOException, CsvException {
        Path actualPath = Path.of("src/test/resources/actualCsvFile.csv");
        Path testedPath = Path.of("src/test/resources/csvFile.csv");

        byte[] actual = Files.readAllBytes(actualPath);
        byte[] tested = Files.readAllBytes(testedPath);

        Assertions.assertArrayEquals(actual, tested);
    }

    @Test
    public void excelTest() throws IOException {
        XLS xls = new XLS(cl.getResourceAsStream("excelFile.xlsx"));

        String cellContent = xls.excel.getSheetAt(0).getRow(2).getCell(1).toString();

        Assertions.assertEquals("5000.0",cellContent);
    }

    @Test
    void pdfTest() throws Exception {
        open("https://junit.org/junit5/docs/current/user-guide/");

        PDF pdf = new PDF($("a[href='junit-user-guide-5.13.3.pdf']").download());

        Assertions.assertEquals("JUnit 5 User Guide",pdf.title);
    }
}
