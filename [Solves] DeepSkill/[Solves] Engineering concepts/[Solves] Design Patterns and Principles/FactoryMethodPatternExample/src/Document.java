interface Document {
    void open();

    void close();
}

class WordDocument implements Document {
    @Override
    public void open() {
        System.out.println("Opening Word Docs...");
    }

    @Override
    public void close() {
        System.out.println("Closing Word Docs...");
    }
}

class PdfDocument implements Document {
    @Override
    public void open() {
        System.out.println("Opening PDF Docs...");
    }

    @Override
    public void close() {
        System.out.println("Closing PDF Docs.");
    }
}

class ExcelDocument implements Document {
    @Override
    public void open() {
        System.out.println("Opening Excel Docs...");
    }

    @Override
    public void close() {
        System.out.println("Closing Excel Docs.");
    }
}
