package com.merlan.theater.web.view;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.merlan.theater.data.entity.User;
import org.joda.time.LocalDate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

public class PdfView extends AbstractPdfView {
    @Override
    protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer, HttpServletRequest request, HttpServletResponse response) throws Exception {
        // change the file name
       response.setHeader("Content-Disposition", "attachment; filename=\"user_all.pdf\"");
System.out.println("response header : " + response.getHeaderNames());
       List<User> users = (List<User>) model.get("User_all");
        System.out.println("users : " + users.size());

        document.add(new Paragraph("Generated Users " + LocalDate.now()));

        //PdfPTable table = new PdfPTable(users.stream().findAny().get().getClass().getFields().length);
        PdfPTable table = new PdfPTable(6);
        table.setWidthPercentage(100.0f);
        table.setSpacingBefore(10);

        // define font for table header row
        Font font = FontFactory.getFont(FontFactory.TIMES);
        font.setColor(BaseColor.WHITE);

        // define table header cell
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(BaseColor.DARK_GRAY);
        cell.setPadding(5);

        // write table header
        cell.setPhrase(new Phrase("User ID", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("First Name", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Last Name", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Email", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Birthday", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Bought Tickets", font));
        table.addCell(cell);

        for(User user : users){
            table.addCell(user.getUserId().toString());
            table.addCell(user.getFirstName());
            table.addCell(user.getLastName());
            table.addCell(user.getEmail());
            table.addCell(user.getBirthday().toString());
            table.addCell(String.valueOf(user.getNumberOfTickets()));
        }
        document.add(table);
    }
}
