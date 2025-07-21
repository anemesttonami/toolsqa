package tests;

import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import model.People;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static utils.ZipFileReader.readFileFromZipToInputStream;
import static utils.ZipFileReader.readFileFromZipToString;

public class FilesParsingTest {
    ClassLoader cl = FilesParsingTest.class.getClassLoader();

    @Test
    public void csvTest() throws IOException, CsvException {
        try (CSVReader reader = new CSVReader(new StringReader(readFileFromZipToString("zip.zip", "csvFile.csv")))) {
            List<String[]> csvLineArraysList = reader.readAll();

            Assertions.assertEquals(2, csvLineArraysList.size());
            Assertions.assertArrayEquals(new String[]{"First", "123"}, csvLineArraysList.get(0));
            Assertions.assertArrayEquals(new String[]{"Second", "456"}, csvLineArraysList.get(1));
        }
    }

    @Test
    public void upgradedCsvTest() throws IOException, CsvException {
        Path actualPath = Path.of("src/test/resources/actualCsvFile.csv");

        byte[] tested = readFileFromZipToString("zip.zip", "csvFile.csv").getBytes();
        byte[] actual = Files.readAllBytes(actualPath);

        Assertions.assertArrayEquals(actual, tested);
    }

    @Test
    public void excelTest() throws IOException {
        XLS xls;
        try (InputStream is = readFileFromZipToInputStream("zip.zip", "excelFile.xlsx")) {
            xls = new XLS(is);
        }

        String cellContent = xls.excel.getSheetAt(0).getRow(2).getCell(1).toString();

        Assertions.assertEquals("5000.0", cellContent);
    }

    @Test
    void pdfTest() throws Exception {
        open("https://junit.org/junit5/docs/current/user-guide/");

        PDF pdf = new PDF($("a[href='junit-user-guide-5.13.3.pdf']").download());

        Assertions.assertEquals("JUnit 5 User Guide", pdf.title);
    }

    @Test
    void readJsonTestFirstVariant() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        String jsonFile = readFileFromZipToString("zip.zip", "People.json");
        People people = mapper.readValue(jsonFile, People.class);

        Assertions.assertEquals(people.getId(), 0);
        Assertions.assertArrayEquals(people.getDetails().getPeopleNames(), new String[]{"Vita", "Olga", "Stepan"});
    }

    @Test
    void readJsonTestSecondVariant() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        JsonNode node = mapper.readTree(readFileFromZipToString("zip.zip", "People.json"));

        Assertions.assertEquals(node.get("Details").get("peopleCount").asText(), "3");
    }
}