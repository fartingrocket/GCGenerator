package com.gcgenerator.utils;
import com.gcgenerator.utils.CursiveLibrary;

public class GCodeLibrary {

	private String font = null;
	private CursiveLibrary cursiveLibrary;
	private FuturaLibrary futuraLibrary;
	private TimesLibrary timesLibrary;

	public GCodeLibrary(double[] initShift, String font){

		this.font = font;
		cursiveLibrary = new CursiveLibrary(initShift);
		futuraLibrary = new FuturaLibrary(initShift);
		timesLibrary = new TimesLibrary(initShift);
	}

	public String getGCodeForChar(char c, char n, double scale, int writingSpeed, int displacementSpeed) {

		switch (font) {
			case "Cursive" :{
				return cursiveLibrary.getGCodeForChar(c, n, scale, writingSpeed, displacementSpeed);
			}
			case "Futura" :{
				return futuraLibrary.getGCodeForChar(c, n, scale, writingSpeed, displacementSpeed);
			}
			case "Times" :{
				return timesLibrary.getGCodeForChar(c, n, scale, writingSpeed, displacementSpeed);
			}
			default :{
				return null;
			}
		}

	}

}
