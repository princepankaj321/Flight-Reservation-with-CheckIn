package com.pankajcreation.flightreservation.utilmail;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.pankajcreation.flightreservation.entities.Reservation;

@Component
public class Pdfgenerator {

	@Autowired
	private static final Logger logger = LoggerFactory.getLogger(Pdfgenerator.class);

	
	public void generateitnary(Reservation reservation, String filepathlater)
	{
		
		logger.info("this is inside of this method -> generateitnary() ");
		
		Document dc = new Document();
		
		try {
			PdfWriter.getInstance(dc,new FileOutputStream(filepathlater) );
		
		dc.open();
		dc.add(generatetable (reservation) );
		dc.close();
		} 
		catch (FileNotFoundException | DocumentException e) {
			// TODO Auto-generated catch block

			logger.error("exception is happen in this method generateitnary()"+e);
		
		}
	
	}

	private PdfPTable generatetable(Reservation reservation) {
		// TODO Auto-generated method stub
		
		PdfPTable table = new PdfPTable(2);
		
		PdfPCell cell = new PdfPCell(new Phrase("Flight Itinerary ") );
		cell.setColspan(2);
		
		table.addCell(cell);
		
		PdfPCell cell2 = new PdfPCell(new Phrase("Flight Details ") );
		cell2.setColspan(2);
		
		table.addCell(cell2);
		
		
		table.addCell("Flight Number");
		table.addCell(reservation.getFlight().getFlightnum());
		
		table.addCell("Flight Name");
		table.addCell(reservation.getFlight().getOperatingairline());
		
		table.addCell("Departure City");
		table.addCell(reservation.getFlight().getDeparturecity());
		
		table.addCell("Arrival City");
		table.addCell(reservation.getFlight().getArrivalcity());
		
		
		table.addCell("Date of Departure");
		table.addCell(reservation.getFlight().getDateofdeparture().toString());
		
		table.addCell("Flight Time");
		table.addCell(reservation.getFlight().getEstimateddeparturetime().toString());
		
		PdfPCell cell3 = new PdfPCell(new Phrase("Passenger Details ") );
		cell3.setColspan(2);
		
		table.addCell(cell3);
		

		table.addCell("Reservation ID (Note- Use this ID for CheckIn)");
		table.addCell(String.valueOf(reservation.getId()));
		
		table.addCell("First Name");
		table.addCell(reservation.getPassenger().getFirstname());
		
		table.addCell("Last Name");
		table.addCell(reservation.getPassenger().getLastname());
		
		table.addCell("Email ID");
		table.addCell(reservation.getPassenger().getEmail());
		
		table.addCell("Phone Number");
		table.addCell(reservation.getPassenger().getPhone());
		
		
		
		
		return table;
	}
	
}
