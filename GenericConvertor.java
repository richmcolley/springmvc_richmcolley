import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class ExcelToJsonConverter {

    public static Map<String, Object> convertExcelToJson(String filePath) throws IOException {
        try (FileInputStream fileInputStream = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(fileInputStream)) {

            Sheet sheet = workbook.getSheetAt(0); // Assuming the data is in the first sheet

            Map<String, Object> jsonMap = new HashMap<>();

            int rows = sheet.getPhysicalNumberOfRows();
            for (int rowIndex = 0; rowIndex < rows; rowIndex++) {
                Row row = sheet.getRow(rowIndex);
                if (row != null) {
                    int cells = row.getPhysicalNumberOfCells();
                    for (int cellIndex = 0; cellIndex < cells; cellIndex++) {
                        Cell cell = row.getCell(cellIndex);
                        if (cell != null) {
                            String key = getCellValue(sheet.getRow(0).getCell(cellIndex));
                            Object value = getCellValue(cell);
                            jsonMap.put(key, value);
                        }
                    }
                }
            }

            return jsonMap;
        }
    }

    private static Object getCellValue(Cell cell) {
        if (cell == null) {
            return null;
        }
        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();
            case BOOLEAN:
                return cell.getBooleanCellValue();
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    return cell.getDateCellValue();
                }
                return cell.getNumericCellValue();
            case FORMULA:
                return cell.getCellFormula();
            default:
                return null;
        }
    }
}





import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Map;

public class ExcelToJsonConverter {

    public static Transaction convertExcelToTransaction(String filePath) throws IOException {
        Map<String, Object> jsonMap = convertExcelToJson(filePath);
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = objectMapper.writeValueAsString(jsonMap);
        return objectMapper.readValue(jsonString, Transaction.class);
    }

    // ... Rest of the code

}
