package com.gcgenerator.utils;

public class CursiveLibrary {

	private double[] shift = {0.0,0.0};
	private double[] initShift = {0.0,0.0};
	private LetterBox letterbox;
	private char lastchar;

	public CursiveLibrary(double[] initShift){
		this.shift = initShift.clone();
		this.initShift = initShift.clone();
		this.letterbox = new LetterBox(initShift[0], initShift[0], initShift[1], initShift[1]);
	}

	public String getGCodeForChar(char c, char nextChar, double scale, int writingSpeed, int displacementSpeed) {

		String returnString = "\n Undefined \n\n";

		switch(c){
			case 'a' :{

				this.letterbox.set_xmin(-3.40540540541);
				this.letterbox.set_xmax(2.64864864865);
				this.letterbox.set_ymin(-2.27027027027);
				this.letterbox.set_ymax(1.13513513514);
				this.shift[0] += Math.abs(this.letterbox.get_xmin());
//				this.shift[1] -= Math.abs(this.letterbox.get_ymin());

				returnString = ";lowercase a\n";
				returnString += "G0 X" + Double.toString(this.shift[0] + scale*0.0) + " Y" + Double.toString(this.shift[1] + scale*0.0) + " Z1.0F" + Double.toString(displacementSpeed) + "\n"+
						"G0 X" + Double.toString(this.shift[0] + scale*0.0) + " Y" + Double.toString(this.shift[1] + scale*0.0) + " Z0.0F" + Double.toString(displacementSpeed) + "\n"+
						"G1 X" + Double.toString(this.shift[0] + scale*-0.378378378378) + " Y" + Double.toString(this.shift[1] + scale*0.756756756757) + " Z0.0F" + Double.toString(displacementSpeed) + "\n"+
						"G1 X" + Double.toString(this.shift[0] + scale*-1.13513513514) + " Y" + Double.toString(this.shift[1] + scale*1.13513513514) + " Z0.0F" + Double.toString(displacementSpeed) + "\n"+
						"G1 X" + Double.toString(this.shift[0] + scale*-1.89189189189) + " Y" + Double.toString(this.shift[1] + scale*1.13513513514) + " Z0.0F" + Double.toString(displacementSpeed) + "\n"+
						"G1 X" + Double.toString(this.shift[0] + scale*-2.64864864865) + " Y" + Double.toString(this.shift[1] + scale*0.756756756757) + " Z0.0F" + Double.toString(displacementSpeed) + "\n"+
						"G1 X" + Double.toString(this.shift[0] + scale*-3.02702702703) + " Y" + Double.toString(this.shift[1] + scale*0.378378378378) + " Z0.0F" + Double.toString(displacementSpeed) + "\n"+
						"G1 X" + Double.toString(this.shift[0] + scale*-3.40540540541) + " Y" + Double.toString(this.shift[1] + scale*-0.378378378378) + " Z0.0F" + Double.toString(displacementSpeed) + "\n"+
						"G1 X" + Double.toString(this.shift[0] + scale*-3.40540540541) + " Y" + Double.toString(this.shift[1] + scale*-1.13513513514) + " Z0.0F" + Double.toString(displacementSpeed) + "\n"+
						"G1 X" + Double.toString(this.shift[0] + scale*-3.02702702703) + " Y" + Double.toString(this.shift[1] + scale*-1.89189189189) + " Z0.0F" + Double.toString(displacementSpeed) + "\n"+
						"G1 X" + Double.toString(this.shift[0] + scale*-2.27027027027) + " Y" + Double.toString(this.shift[1] + scale*-2.27027027027) + " Z0.0F" + Double.toString(displacementSpeed) + "\n"+
						"G1 X" + Double.toString(this.shift[0] + scale*-1.51351351351) + " Y" + Double.toString(this.shift[1] + scale*-2.27027027027) + " Z0.0F" + Double.toString(displacementSpeed) + "\n"+
						"G1 X" + Double.toString(this.shift[0] + scale*-0.756756756757) + " Y" + Double.toString(this.shift[1] + scale*-1.89189189189) + " Z0.0F" + Double.toString(displacementSpeed) + "\n"+
						"G1 X" + Double.toString(this.shift[0] + scale*-0.378378378378) + " Y" + Double.toString(this.shift[1] + scale*-1.13513513514) + " Z0.0F" + Double.toString(displacementSpeed) + "\n"+
						"G1 X" + Double.toString(this.shift[0] + scale*0.378378378378) + " Y" + Double.toString(this.shift[1] + scale*1.13513513514) + " Z0.0F" + Double.toString(displacementSpeed) + "\n"+
						"G1 X" + Double.toString(this.shift[0] + scale*0.0) + " Y" + Double.toString(this.shift[1] + scale*-0.756756756757) + " Z0.0F" + Double.toString(displacementSpeed) + "\n"+
						"G1 X" + Double.toString(this.shift[0] + scale*0.0) + " Y" + Double.toString(this.shift[1] + scale*-1.89189189189) + " Z0.0F" + Double.toString(displacementSpeed) + "\n"+
						"G1 X" + Double.toString(this.shift[0] + scale*0.378378378378) + " Y" + Double.toString(this.shift[1] + scale*-2.27027027027) + " Z0.0F" + Double.toString(displacementSpeed) + "\n"+
						"G1 X" + Double.toString(this.shift[0] + scale*0.756756756757) + " Y" + Double.toString(this.shift[1] + scale*-2.27027027027) + " Z0.0F" + Double.toString(displacementSpeed) + "\n"+
						"G1 X" + Double.toString(this.shift[0] + scale*1.51351351351) + " Y" + Double.toString(this.shift[1] + scale*-1.89189189189) + " Z0.0F" + Double.toString(displacementSpeed) + "\n"+
						"G1 X" + Double.toString(this.shift[0] + scale*1.89189189189) + " Y" + Double.toString(this.shift[1] + scale*-1.51351351351) + " Z0.0F" + Double.toString(displacementSpeed) + "\n"+
						"G1 X" + Double.toString(this.shift[0] + scale*2.64864864865) + " Y" + Double.toString(this.shift[1] + scale*-0.378378378378) + " Z0.0F" + Double.toString(displacementSpeed) + "\n"+
						"G0 X" + Double.toString(this.shift[0] + scale*2.64864864865) + " Y" + Double.toString(this.shift[1] + scale*-0.378378378378) + " Z1.0F" + Double.toString(displacementSpeed) + "\n";

				this.shift[0] += Math.abs(this.letterbox.get_xmax());
				break;
			}
			case 'b' :{
				this.letterbox.set_xmin(0.0);
				this.letterbox.set_xmax(5.2972972973);
				this.letterbox.set_ymin(-1.89189189189);
				this.letterbox.set_ymax(6.05405405405);
				this.shift[0] += Math.abs(this.letterbox.get_xmin());

				returnString = ";lowercase b\n";
				if (this.lastchar != 'b'){
					this.shift[1] -= 0.37837837838;
					returnString += "G0 X" + Double.toString(this.shift[0] + scale*0.0) + " Y" + Double.toString(this.shift[1] + scale*0.0) + " Z1.0F" + Double.toString(displacementSpeed) + "\n";
				}
				returnString += "G0 X" + Double.toString(this.shift[0] + scale*0.0) + " Y" + Double.toString(this.shift[1] + scale*0.0) + " Z0.0F" + Double.toString(displacementSpeed) + "\n"+
						"G1 X" + Double.toString(this.shift[0] + scale*0.756756756757) + " Y" + Double.toString(this.shift[1] + scale*1.13513513514) + " Z0.0F" + Double.toString(displacementSpeed) + "\n"+
						"G1 X" + Double.toString(this.shift[0] + scale*1.89189189189) + " Y" + Double.toString(this.shift[1] + scale*3.02702702703) + " Z0.0F" + Double.toString(displacementSpeed) + "\n"+
						"G1 X" + Double.toString(this.shift[0] + scale*2.27027027027) + " Y" + Double.toString(this.shift[1] + scale*3.78378378378) + " Z0.0F" + Double.toString(displacementSpeed) + "\n"+
						"G1 X" + Double.toString(this.shift[0] + scale*2.64864864865) + " Y" + Double.toString(this.shift[1] + scale*4.91891891892) + " Z0.0F" + Double.toString(displacementSpeed) + "\n"+
						"G1 X" + Double.toString(this.shift[0] + scale*2.64864864865) + " Y" + Double.toString(this.shift[1] + scale*5.67567567568) + " Z0.0F" + Double.toString(displacementSpeed) + "\n"+
						"G1 X" + Double.toString(this.shift[0] + scale*2.27027027027) + " Y" + Double.toString(this.shift[1] + scale*6.05405405405) + " Z0.0F" + Double.toString(displacementSpeed) + "\n"+
						"G1 X" + Double.toString(this.shift[0] + scale*1.51351351351) + " Y" + Double.toString(this.shift[1] + scale*5.67567567568) + " Z0.0F" + Double.toString(displacementSpeed) + "\n"+
						"G1 X" + Double.toString(this.shift[0] + scale*1.13513513514) + " Y" + Double.toString(this.shift[1] + scale*4.91891891892) + " Z0.0F" + Double.toString(displacementSpeed) + "\n"+
						"G1 X" + Double.toString(this.shift[0] + scale*0.756756756757) + " Y" + Double.toString(this.shift[1] + scale*3.40540540541) + " Z0.0F" + Double.toString(displacementSpeed) + "\n"+
						"G1 X" + Double.toString(this.shift[0] + scale*0.378378378378) + " Y" + Double.toString(this.shift[1] + scale*0.756756756757) + " Z0.0F" + Double.toString(displacementSpeed) + "\n"+
						"G1 X" + Double.toString(this.shift[0] + scale*0.378378378378) + " Y" + Double.toString(this.shift[1] + scale*-1.51351351351) + " Z0.0F" + Double.toString(displacementSpeed) + "\n"+
						"G1 X" + Double.toString(this.shift[0] + scale*0.756756756757) + " Y" + Double.toString(this.shift[1] + scale*-1.89189189189) + " Z0.0F" + Double.toString(displacementSpeed) + "\n"+
						"G1 X" + Double.toString(this.shift[0] + scale*1.13513513514) + " Y" + Double.toString(this.shift[1] + scale*-1.89189189189) + " Z0.0F" + Double.toString(displacementSpeed) + "\n"+
						"G1 X" + Double.toString(this.shift[0] + scale*1.89189189189) + " Y" + Double.toString(this.shift[1] + scale*-1.51351351351) + " Z0.0F" + Double.toString(displacementSpeed) + "\n"+
						"G1 X" + Double.toString(this.shift[0] + scale*2.64864864865) + " Y" + Double.toString(this.shift[1] + scale*-0.756756756757) + " Z0.0F" + Double.toString(displacementSpeed) + "\n"+
						"G1 X" + Double.toString(this.shift[0] + scale*3.02702702703) + " Y" + Double.toString(this.shift[1] + scale*0.378378378378) + " Z0.0F" + Double.toString(displacementSpeed) + "\n"+
						"G1 X" + Double.toString(this.shift[0] + scale*3.02702702703) + " Y" + Double.toString(this.shift[1] + scale*1.51351351351) + " Z0.0F" + Double.toString(displacementSpeed) + "\n"+
						"G1 X" + Double.toString(this.shift[0] + scale*3.40540540541) + " Y" + Double.toString(this.shift[1] + scale*0.0) + " Z0.0F" + Double.toString(displacementSpeed) + "\n"+
						"G1 X" + Double.toString(this.shift[0] + scale*3.78378378378) + " Y" + Double.toString(this.shift[1] + scale*-0.378378378378) + " Z0.0F" + Double.toString(displacementSpeed) + "\n"+
						"G1 X" + Double.toString(this.shift[0] + scale*4.54054054054) + " Y" + Double.toString(this.shift[1] + scale*-0.378378378378) + " Z0.0F" + Double.toString(displacementSpeed) + "\n"+
						"G1 X" + Double.toString(this.shift[0] + scale*5.2972972973) + " Y" + Double.toString(this.shift[1] + scale*0.0) + " Z0.0F" + Double.toString(displacementSpeed) + "\n";

				if (nextChar != c){
					returnString += "G0 X" + Double.toString(this.shift[0] + scale*5.2972972973) + " Y" + Double.toString(this.shift[1] + scale*0.0) + " Z1.0F" + Double.toString(displacementSpeed) + "\n";
				}

				this.lastchar = c;
				this.shift[0] += Math.abs(this.letterbox.get_xmax());
				break;
			}
			case 'c' :{

				this.letterbox.set_xmin(-2.64864864865);
				this.letterbox.set_xmax(1.51351351351);
				this.letterbox.set_ymin(-2.64864864865);
				this.letterbox.set_ymax(0.756756756757);
				this.shift[0] += Math.abs(this.letterbox.get_xmin());
//				this.shift[1] -= Math.abs(this.letterbox.get_ymin());

				returnString = ";lowercase c\n";
				if (this.lastchar != 'c'){
					returnString += "G0 X" + Double.toString(this.shift[0] + scale*0.0) + " Y" + Double.toString(this.shift[1] + scale*0.0) + " Z1.0F" + Double.toString(displacementSpeed) + "\n";
				}
				returnString += "G0 X" + Double.toString(this.shift[0] + scale*0.0) + " Y" + Double.toString(this.shift[1] + scale*0.0) + " Z0.0F" + Double.toString(displacementSpeed) + "\n"+
						"G1 X" + Double.toString(this.shift[0] + scale*0.0) + " Y" + Double.toString(this.shift[1] + scale*0.378378378378) + " Z0.0F" + Double.toString(displacementSpeed) + "\n"+
						"G1 X" + Double.toString(this.shift[0] + scale*-0.378378378378) + " Y" + Double.toString(this.shift[1] + scale*0.756756756757) + " Z0.0F" + Double.toString(displacementSpeed) + "\n"+
						"G1 X" + Double.toString(this.shift[0] + scale*-1.13513513514) + " Y" + Double.toString(this.shift[1] + scale*0.756756756757) + " Z0.0F" + Double.toString(displacementSpeed) + "\n"+
						"G1 X" + Double.toString(this.shift[0] + scale*-1.89189189189) + " Y" + Double.toString(this.shift[1] + scale*0.378378378378) + " Z0.0F" + Double.toString(displacementSpeed) + "\n"+
						"G1 X" + Double.toString(this.shift[0] + scale*-2.27027027027) + " Y" + Double.toString(this.shift[1] + scale*0.0) + " Z0.0F" + Double.toString(displacementSpeed) + "\n"+
						"G1 X" + Double.toString(this.shift[0] + scale*-2.64864864865) + " Y" + Double.toString(this.shift[1] + scale*-0.756756756757) + " Z0.0F" + Double.toString(displacementSpeed) + "\n"+
						"G1 X" + Double.toString(this.shift[0] + scale*-2.64864864865) + " Y" + Double.toString(this.shift[1] + scale*-1.51351351351) + " Z0.0F" + Double.toString(displacementSpeed) + "\n"+
						"G1 X" + Double.toString(this.shift[0] + scale*-2.27027027027) + " Y" + Double.toString(this.shift[1] + scale*-2.27027027027) + " Z0.0F" + Double.toString(displacementSpeed) + "\n"+
						"G1 X" + Double.toString(this.shift[0] + scale*-1.51351351351) + " Y" + Double.toString(this.shift[1] + scale*-2.64864864865) + " Z0.0F" + Double.toString(displacementSpeed) + "\n"+
						"G1 X" + Double.toString(this.shift[0] + scale*-0.378378378378) + " Y" + Double.toString(this.shift[1] + scale*-2.64864864865) + " Z0.0F" + Double.toString(displacementSpeed) + "\n"+
						"G1 X" + Double.toString(this.shift[0] + scale*0.756756756757) + " Y" + Double.toString(this.shift[1] + scale*-1.89189189189) + " Z0.0F" + Double.toString(displacementSpeed) + "\n"+
						"G1 X" + Double.toString(this.shift[0] + scale*1.51351351351) + " Y" + Double.toString(this.shift[1] + scale*-0.756756756757) + " Z0.0F" + Double.toString(displacementSpeed) + "\n";

				if (nextChar != c){
					returnString += "G0 X" + Double.toString(this.shift[0] + scale*1.51351351351) + " Y" + Double.toString(this.shift[1] + scale*-0.756756756757) + " Z1.0F" + Double.toString(displacementSpeed) + "\n";
				}

				this.lastchar = c;
				this.shift[0] += Math.abs(this.letterbox.get_xmax());
				break;
			}
			case 'd' :{
				System.out.println("Not a defined operation"); break;
			}
			case 'e' :{
				System.out.println("Not a defined operation"); break;
			}
			case 'f' :{
				System.out.println("Not a defined operation"); break;
			}
			case 'g' :{
				System.out.println("Not a defined operation"); break;
			}
			case 'h' :{
				System.out.println("Not a defined operation"); break;
			}
			case 'i' :{
				System.out.println("Not a defined operation"); break;
			}
			case 'j' :{
				System.out.println("Not a defined operation"); break;
			}
			case 'k' :{
				System.out.println("Not a defined operation"); break;
			}
			case 'l' :{
				System.out.println("Not a defined operation"); break;
			}
			case 'm' :{
				System.out.println("Not a defined operation"); break;
			}
			case 'n' :{
				System.out.println("Not a defined operation"); break;
			}
			case 'o' :{
				System.out.println("Not a defined operation"); break;
			}
			case 'p' :{
				System.out.println("Not a defined operation"); break;
			}
			case 'q' :{
				System.out.println("Not a defined operation"); break;
			}
			case 'r' :{
				System.out.println("Not a defined operation"); break;
			}
			case 's' :{
				System.out.println("Not a defined operation"); break;
			}
			case 't' :{
				System.out.println("Not a defined operation"); break;
			}
			case 'u' :{
				System.out.println("Not a defined operation"); break;
			}
			case 'v' :{
				System.out.println("Not a defined operation"); break;
			}
			case 'w' :{
				System.out.println("Not a defined operation"); break;
			}
			case 'x' :{
				System.out.println("Not a defined operation"); break;
			}
			case 'y' :{
				System.out.println("Not a defined operation"); break;
			}
			case 'z' :{
				System.out.println("Not a defined operation"); break;

			}
			case ' ':{
				// add an empty space by shifting right
				returnString = ";shift X "+Double.toString(this.shift[0])+"\n";
				this.shift[0] += scale*2;
				returnString += ";blank space shifted X to "+Double.toString(this.shift[0])+"\n";
				break;
			}
			case '\n' :{
				// line return
				returnString = ";shift X "+Double.toString(this.shift[0])+"\n";
				returnString = ";shift Y "+Double.toString(this.shift[1])+"\n";
				this.shift[0] = this.initShift[0];
				this.shift[1] -= scale*14;
				returnString += ";carriage return shifted X to "+Double.toString(this.shift[0])+"\n";
				returnString += ";carriage return shifted Y to "+Double.toString(this.shift[1])+"\n";
				break;
			}
			default : {
				System.out.println("Not a defined operation"); break;
			}
		}

		return returnString;
	}

}
