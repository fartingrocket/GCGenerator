package com.gcgenerator.controllers;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import com.gcgenerator.Main;
import com.gcgenerator.utils.GCodeLibrary;
import com.gcgenerator.utils.SimpleTextEditor;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class MainController implements Initializable {

    @FXML
    private ComboBox<Integer> textSizeComboBox;

    @FXML
    private ComboBox<String> textFontComboBox;

    @FXML
    private TextField bedSizeX;

    @FXML
    private TextField bedSizeY;

    @FXML
    private TextField bedMarginX;

    @FXML
    private TextField bedMarginY;

    @FXML
    private TextField offsetY;

    @FXML
    private TextField offsetX;

    @FXML
    private TextField penZup;

    @FXML
    private TextField penZdown;

    @FXML
    private TextField writingSpeed;

    @FXML
    private TextField displacementSpeed;

    @FXML
    private MenuBar menuBar;

    @FXML
    private Menu menuFile;

    @FXML
    private MenuItem menuFileNew;

    @FXML
    private MenuItem menuFileOpen;

    @FXML
    private MenuItem menuFileSave;

    @FXML
    private MenuItem menuFileCloseAllTabs;

    @FXML
    private Menu menuHelp;

    @FXML
    private MenuItem menuHelpAbout;

    @FXML
    private Button generateGCodeButton;

    @FXML
    private TabPane documentTabPane;

    private int _textSize;
    private String _textFont;
    private int _bedSizeX;
    private int _bedSizeY;
    private int _bedMarginX;
    private int _bedMarginY;
    private int _offsetY;
    private int _offsetX;
    private int _penZup;
    private int _penZdown;
    private int _writingSpeed;
    private int _displacementSpeed;
	private ObservableList<Integer> sizeOptions = FXCollections.observableArrayList(8, 10, 12, 14, 16, 18, 20, 24, 26, 30);
	private ObservableList<String> fontOptions = FXCollections.observableArrayList("Cursive", "Futura", "Times");

	private Main mainApp;

    // Action functions

    @FXML
    void menuFileCloseAllTabs_actionPerformed(ActionEvent event) {
		// Init the TabPane
		this.documentTabPane.getTabs().clear();
		newTab();
    }

    @FXML
    void menuFileNew_actionPerformed(ActionEvent event){
    	newTab();
    }

    @FXML
    void menuFileOpen_actionPerformed(ActionEvent event) {

    }

	@FXML
	void menuHelpAbout_actionPerformed(ActionEvent event) {
		mainApp.about();
	}

    @FXML
    void generateGCodeButton_actionPerformed(ActionEvent event){

    	SimpleTextEditor thisTab = (SimpleTextEditor) this.documentTabPane.getSelectionModel().getSelectedItem();
		TextArea thisTextArea = (TextArea) thisTab.getContent();
		StringBuilder output = new StringBuilder();

		boolean paramsOK = getParameters();

		if (!thisTab.isGCode() && paramsOK){

			/*
			 * Uncomment this for debugging
			 */

//    		output.append("Size : " + this._textSize
//    				 + "\nFont : " + this._textFont
//    				 + "\nScale : " + (double)(this._textSize/14.0)
//    				 + "\nBed size X : " + this._bedSizeX
//    				 + "\nBed size Y : " + this._bedSizeY
//			 		 + "\nBed margin X : " + this._bedMarginX
//			         + "\nBed margin Y : " + this._bedMarginY
//    				 + "\nOffset X : " + this._offsetX
//    				 + "\nOffset Y : " + this._offsetY
//    				 + "\nZ up : " + this._penZup
//    				 + "\nZ down : " + this._penZdown
//    				 + "\nWriting speed : "+this._writingSpeed
//    				 + "\nDisplacement speed : "+this._displacementSpeed
//    				 + "\n\n============================\n");

	    	SimpleTextEditor newGCodeTab = newTab("GC "+this._textSize+" "+this._textFont+" "+thisTab.getText());
	    	output.append(convertTextToGCode(thisTextArea.getText()));
	    	newGCodeTab.setTextAreaContent(output.toString());
	    	newGCodeTab.setGCode(true);
    	}
    }

	private String convertTextToGCode(String plainText) {
		StringBuilder output = new StringBuilder();
		output.append(buildGCodeHeader());
		output.append(buildGCodeBody(plainText));
		output.append(buildGCodeFooter());
		return output.toString();
	}

	private String buildGCodeBody(String plainText) {
		StringBuilder output = new StringBuilder();
		char[] input = plainText.toCharArray();
		double[] initShift = {this._bedMarginX+this._offsetX, this._bedSizeY-this._bedMarginY+this._offsetY};

		GCodeLibrary library = new GCodeLibrary(initShift, this._textFont);

		double scale = (double)(this._textSize/14.0);
		int index = 0;
		char n = 0;
		for(char c : input){
			if(index < plainText.length()-1){
				n = input[index+1];
			}
			output.append(library.getGCodeForChar(c, n, scale, this._writingSpeed, this._displacementSpeed));
			index++;
		}

		return output.toString();
	}

	private String buildGCodeHeader() {
		StringBuilder s = new StringBuilder("G28 X Y Z\nG0 Z" + this._penZup + " F" + this._displacementSpeed + "\nG0 Z"
				+ this._penZup + " F" + this._displacementSpeed + "\n");
		return s.toString();
	}

	private String buildGCodeFooter() {
		StringBuilder s = new StringBuilder("G28 X\n");
		return s.toString();
	}

	public void setMainApp(Main mainApp){
		this.mainApp = mainApp;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		// Init Combo Boxes
		this.textSizeComboBox.setItems(sizeOptions);
		this.textSizeComboBox.getSelectionModel().select(3);
		this.textFontComboBox.setItems(fontOptions);
		this.textFontComboBox.getSelectionModel().select(0);

		// Init other values
		bedSizeX.setText("250");
		bedSizeY.setText("250");
		bedMarginX.setText("30");
		bedMarginY.setText("30");
		offsetX.setText("0");
		offsetY.setText("0");
		penZup.setText("1");
		penZdown.setText("0");
		writingSpeed.setText("1800");
		displacementSpeed.setText("6000");

		// Init the TabPane
		this.documentTabPane.getTabs().clear();
		//newTab();

		// TODO : Test for text area (To be removed and uncomment the newTab())
		TextArea testTextArea = (TextArea) newTab().getContent();
		testTextArea.setText("abcdefghijklmnopqrstuvwxyz\naaa bbb ccc\nacba");
	}

	private SimpleTextEditor newTab(){

		int n = this.documentTabPane.getTabs().size() + 1;
		return newTab("New Document "+n);

	}

	private SimpleTextEditor newTab(String title){

		SimpleTextEditor textEditor = new SimpleTextEditor(title);
		this.documentTabPane.getTabs().add(textEditor);

		SingleSelectionModel<Tab> tabPaneSelectionModel = this.documentTabPane.getSelectionModel();
		tabPaneSelectionModel.select(textEditor);

		return textEditor;
	}

	private boolean getParameters(){

		if (textSizeComboBox.getSelectionModel().getSelectedIndex() == -1 || textFontComboBox.getSelectionModel().getSelectedIndex() == -1) {
			alertDialog("Error", "Parameters error", "Text parameters not set", AlertType.ERROR);
			return false;
		}

		this._textSize = textSizeComboBox.getSelectionModel().getSelectedItem();
		this._textFont = textFontComboBox.getSelectionModel().getSelectedItem();
		this._bedSizeX = (bedSizeX.getText().isEmpty()) ? 0 : Integer.parseInt(bedSizeX.getText());
		this._bedSizeY = (bedSizeY.getText().isEmpty()) ? 0 : Integer.parseInt(bedSizeY.getText());
		this._bedMarginX = (bedMarginX.getText().isEmpty()) ? 0 : Integer.parseInt(bedMarginX.getText());
		this._bedMarginY = (bedMarginY.getText().isEmpty()) ? 0 : Integer.parseInt(bedMarginY.getText());
		this._offsetX = (offsetX.getText().isEmpty()) ? 0 : Integer.parseInt(offsetX.getText());
		this._offsetY = (offsetY.getText().isEmpty()) ? 0 : Integer.parseInt(offsetY.getText());
		this._penZup = (penZup.getText().isEmpty()) ? 0 : Integer.parseInt(penZup.getText());
		this._penZdown = (penZdown.getText().isEmpty()) ? 0 : Integer.parseInt(penZdown.getText());
		this._writingSpeed = (writingSpeed.getText().isEmpty()) ? 0 : Integer.parseInt(writingSpeed.getText());
		this._displacementSpeed = (displacementSpeed.getText().isEmpty()) ? 0 : Integer.parseInt(displacementSpeed.getText());

		if (this._bedSizeX == 0 || this._bedSizeY == 0){
			alertDialog("Error", "Parameters error", "Bed size parameters cannot be 0", AlertType.ERROR);
			return false;
		}

		if (this._penZup == 0 && !confirmationDialog("Warning", "Z up value is set to 0", "Do you wish to continue with this value ?")){
			return false;
		}

		if (this._penZdown < 0 && !confirmationDialog("Warning", "Z down value is negative", "Do you wish to continue with this value ?")){
			return false;
		}

		if (this._writingSpeed == 0 || this._displacementSpeed == 0){
			alertDialog("Error", "Parameters error", "Write speed and displacement speed cannot be 0", AlertType.ERROR);
			return false;
		}

		return true;
	}

	private void alertDialog(String title, String header, String content, AlertType alertType){
		Alert alert = new Alert(alertType);
		alert.setTitle(title);
		alert.setHeaderText(header);
		alert.setContentText(content);

		alert.showAndWait();
	}

	private boolean confirmationDialog(String title, String header, String content){
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle(title);
		alert.setHeaderText(header);
		alert.setContentText(content);

		ButtonType buttonYes = new ButtonType("Yes");
		ButtonType buttonNo = new ButtonType("No");

		alert.getButtonTypes().setAll(buttonYes, buttonNo);

		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == buttonYes){
		    return true;
		} else{
		    return false;
		}
	}

}
