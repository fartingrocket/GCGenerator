package com.gcgenerator.utils;

import javafx.geometry.Insets;
import javafx.scene.control.Tab;
import javafx.scene.control.TextArea;

public class SimpleTextEditor extends Tab{
    private boolean isGCode = false;
    private TextArea textArea = new TextArea();

    public SimpleTextEditor(String title){
    	setText(title);
    	this.textArea.setPadding(new Insets(10, 0, 0, 10));
    	setContent(textArea);
    }

    public boolean isGCode() {
        return isGCode;
    }

    public void setGCode(boolean modified) {
        this.isGCode = modified;
    }

    public void setTextAreaContent(String text) {
        this.textArea.setText(text);
    }

    public String getTextAreaContent() {
        return this.textArea.getText();
    }
}