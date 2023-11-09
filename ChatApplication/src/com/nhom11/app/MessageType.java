/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom11.app;

/**
 *
 * @author btdun
 */
public enum MessageType {
    TEXT(1),EMOJI(2),FILE(3);
    final int value;
    MessageType(int v){
        this.value = v;
    }
    public int getValue(){
        return this.value;
    }
    public static MessageType toMessageType(int id){
        if(id == 1)return TEXT;
        else if(id == 2)return EMOJI;
        else return FILE;
    }
}
