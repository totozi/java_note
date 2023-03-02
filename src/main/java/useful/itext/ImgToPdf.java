package useful.itext;

import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;

public class ImgToPdf {

    public static void main(String[] args) throws FileNotFoundException, MalformedURLException {


        String inputDirectoryPath = "C:\\z_workspace\\img-to-pdf\\src\\main\\resources\\img\\";
        String outputDirectoryPath = "C:\\z_workspace\\img-to-pdf\\src\\main\\resources\\img\\";

        // Get a list of all files in the input directory
        File inputDirectory = new File(inputDirectoryPath);
        File[] inputFiles = inputDirectory.listFiles();

        for (File file : inputFiles) {
            jpgToPdf(file.toString());
        }

    }

    static void jpgToPdf(String inputImagePath) throws MalformedURLException, FileNotFoundException {

        String outputPdfPath = inputImagePath.substring(0,inputImagePath.lastIndexOf(".")) + ".pdf";

        // Create a PDF document with a custom page size matching the image dimensions
        ImageData imageData = ImageDataFactory.create(inputImagePath);
        PageSize pageSize = new PageSize(imageData.getWidth(), imageData.getHeight());
        PdfDocument pdfDocument = new PdfDocument(new PdfWriter(outputPdfPath));
        pdfDocument.setDefaultPageSize(pageSize);

        // Create a document to add content to the PDF
        Document document = new Document(pdfDocument);

        // Create an Image object from the input image and add it to the document
        Image image = new Image(imageData);
        document.add(image);

        // Close the document
        document.close();

    }
}
