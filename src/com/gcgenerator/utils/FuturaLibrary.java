package com.gcgenerator.utils;

public class FuturaLibrary {

	private double[] shift = {0.0,0.0};

	public FuturaLibrary(double[] initShift){
		this.shift = initShift;
	}

	public String getGCodeForChar(char c, char n,double scale, int writingSpeed, int displacementSpeed) {

		String returnString = "";

		switch(c){
			case 'a' :{
				// do nothing
			}
			case 'b' :{
				// do nothing
			}
			case 'c' :{
				// do nothing
			}
			case 'd' :{
				// do nothing
			}
			case 'e' :{
				// do nothing
			}
			case 'f' :{
				// do nothing
			}
			case 'g' :{
				// do nothing
			}
			case 'h' :{
				// do nothing
			}
			case 'i' :{
				// do nothing
			}
			case 'j' :{
				// do nothing
			}
			case 'k' :{
				// do nothing
			}
			case 'l' :{
				// do nothing
			}
			case 'm' :{
				// do nothing
			}
			case 'n' :{
				// do nothing
			}
			case 'o' :{
				// do nothing
			}
			case 'p' :{
				// do nothing
			}
			case 'q' :{
				// do nothing
			}
			case 'r' :{
				// do nothing
			}
			case 's' :{
				// do nothing
			}
			case 't' :{
				// do nothing
			}
			case 'u' :{
				// do nothing
			}
			case 'v' :{
				// do nothing
			}
			case 'w' :{
				// do nothing
			}
			case 'x' :{
				// do nothing
			}
			case 'y' :{
				// do nothing
			}
			case 'z' :{
				// do nothing
			}
			case ' ':{
				// add an empty space by shifting right
				this.shift[0] += scale*2;
			}
			default : {
				// do nothing
				break;
			}
		}

		return returnString;
	}

}
