/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom11.swing;

import javax.swing.JProgressBar;

/**
 *
 * @author btdun
 */
public class Progress extends JProgressBar{
    private ProgressType progressType;
    public Progress(){
        setUI(new ProgressCircleUI(this));
        setOpaque(false);
    }
    public void setProgressType(ProgressType type){
        this.progressType = type;
    }
    
    public ProgressType getProgressType(){
        return progressType;
    }
    public static enum ProgressType{
        NON,FILE,CANCLE,DOWN
    }
}
