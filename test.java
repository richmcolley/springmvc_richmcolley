import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ExcelToJsonConverter {

    public static void main(String[] args) {
        try (FileInputStream fileInputStream = new FileInputStream("path/to/excel/file.xlsx");
             Workbook workbook = new XSSFWorkbook(fileInputStream)) {

            Sheet sheet = workbook.getSheetAt(0); // Assuming the data is in the first sheet

            // Create a map to hold the nested JSON structure
            Map<String, Object> jsonMap = new HashMap<>();

            // Read and populate the values from the Excel file
            jsonMap.put("accountId", getStringValue(sheet.getRow(0).getCell(0)));
            jsonMap.put("externalReference", getStringValue(sheet.getRow(0).getCell(1)));
            jsonMap.put("transactionId", getStringValue(sheet.getRow(1).getCell(0)));
            // ... continue adding the remaining values

            // Create the assets map
            Map<String, Object> assetsMap = new HashMap<>();
            assetsMap.put("isin", getStringValue(sheet.getRow(2).getCell(0)));
            assetsMap.put("sed", getStringValue(sheet.getRow(2).getCell(1)));
            assetsMap.put("unit", getStringValue(sheet.getRow(2).getCell(2)));
            assetsMap.put("cR", getStringValue(sheet.getRow(2).getCell(3)));
            jsonMap.put("assets", assetsMap);

            // Create the pset map
            Map<String, Object> psetMap = new HashMap<>();
            // ... continue adding values to the pset map

            // Add the pset map to the jsonMap
            jsonMap.put("pset", psetMap);

            // Convert the map to JSON string
            String jsonString = new ObjectMapper().writeValueAsString(jsonMap);
            System.out.println(jsonString);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getStringValue(Cell cell) {
        if (cell == null) {
            return null;
        }
        cell.setCellType(CellType.STRING);
        return cell.getStringCellValue();
    }
}



public class Transaction {
    private String accountId;
    private String externalReference;
    private String transactionId;
    private String transactionStatus;
    private String transactionType;
    private String transactionMode;
    private String channel;
    private String business;
    private String productType;
    private Map<String, Object> assets;
    private String errors;
    private String accountH;
    private Map<String, Object> pset;

    // Getters and Setters
}

