public class Main {
    public static void main(String[] args) {
        Document wordDocument = DocumentFactory.createDocument("word");
        Document pdfDocument = DocumentFactory.createDocument("pdf");
        Document excelDocument = DocumentFactory.createDocument("excel");

        wordDocument.open();
        pdfDocument.open();
        excelDocument.open();
    }
}
