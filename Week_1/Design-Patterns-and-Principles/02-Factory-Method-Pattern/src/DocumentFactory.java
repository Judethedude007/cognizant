public class DocumentFactory {
    public static Document createDocument(String documentType) {
        if (documentType == null) {
            return null;
        }

        if (documentType.equalsIgnoreCase("word")) {
            return new WordDocument();
        } else if (documentType.equalsIgnoreCase("pdf")) {
            return new PdfDocument();
        } else if (documentType.equalsIgnoreCase("excel")) {
            return new ExcelDocument();
        }

        return null;
    }
}
