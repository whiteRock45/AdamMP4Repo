/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.miniproject4;

import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;

/**
 *
 * @author abw04
 */
public class SortAlgPane extends TabPane{
    private AlgTab[] theTabs;
    private int numTabs;
    
    //constructor -- create a SortAlgPane with numTabs tabs
    public SortAlgPane(int numTabs) {
        numTabs = numTabs;
        theTabs = new AlgTab[numTabs];
        
        for (AlgTab tab : theTabs) {
            tab = new AlgTab(11, "Sort 1", AlgTab.Algorithms.selection);
            getTabs().add(tab);
        }
        
        
        
    }
    
}
