/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.miniproject4;

import java.util.Arrays;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import java.util.Random;
import javafx.scene.text.Text;

/**
 *
 * @author abw04
 */
public class AlgTab extends Tab{
    private Random rand = new Random();
    private TextField[] inputFields;
    private int numFields;
    private int[] userData;
    private Button randButton;
    private Button stepButton;
    
    //the constructor will require a sorting algorithm as an argument
    //the algorithm choices are represented by the enum Algorithms
    public static enum Algorithms { 
        selection, insertion, quick, merge
    }
    
    
    public AlgTab(int numFields, String title, Algorithms alg) {
        super(title);
        this.numFields = numFields;
        
        inputFields = new TextField[numFields];
        randButton = new Button("Random Numbers");
        stepButton = new Button("Show Next Step");
        
        
        randButton.setOnAction(this::processRandomButton);
        
        //decide which event handler to use depending on which algorithm is
        //selected in the constructor
        switch (alg) {
            case selection:
                stepButton.setOnAction(this::processSelectionStepButton);
                break;
            case insertion:
                stepButton.setOnAction(this::processInsertionStepButton);
                break;
            case quick:
                stepButton.setOnAction(this::processQuickStepButton);
                break;
            case merge:
                stepButton.setOnAction(this::processMergeStepButton);
                break;
            default:
                stepButton.setOnAction(this::processSelectionStepButton);
        }
        
        
        
        HBox fieldBox = new HBox();
        BorderPane tabContent = new BorderPane();
        
        //arrange the TextFields in an HBox
        for (int i = 0; i < inputFields.length; i++) {
            inputFields[i] = new TextField();
            fieldBox.getChildren().add(inputFields[i]);
        }
        
        //FIXME: ARRANGE TEXT OBJECTS IN A VBOX TO DISPLAY
        //EACH STEP IN THE PROCESS
        
        tabContent.setTop(fieldBox);
        tabContent.setLeft(randButton);
        tabContent.setCenter(stepButton);
        
        setContent(tabContent);
    }
    
    //Generate random data in the TextFields
    private void processRandomButton(ActionEvent e) {
        for (TextField field : inputFields) {
            field.setText(Integer.toString(rand.nextInt(0, 999)));
        }
    }
    
    //Event handlers for each sorting algorithm
    //Which event handler is used will depend on which
    //sorting algorithm is selected in the constructor
    private void processSelectionStepButton(ActionEvent e) {
        userData = new int[numFields];
        for (int i = 0; i < numFields; i++) {
            userData[i] = Integer.parseInt(inputFields[i].getText());
            
        }
        //Array of text objects to hold the updated userData array
        //after each step
        Text[] updatedData = new Text[numFields];
        
        
        
        
        
//        System.out.println(Arrays.toString(userData));
//        
//        Sorts.selectionSort(userData, 0, numFields);
//        System.out.println(Arrays.toString(userData));
        
//        for (int i = 0; i < numFields; i++) {
//            inputFields[i].setText(Integer.toString(userData[i]));
//        }
    }
    
    private void processInsertionStepButton(ActionEvent e) {
        
    }
    
    private void processQuickStepButton(ActionEvent e) {
        
    }
    
    private void processMergeStepButton(ActionEvent e) {
        
    }
    
}
