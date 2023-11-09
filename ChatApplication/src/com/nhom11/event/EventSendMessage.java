/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nhom11.event;

import com.nhom11.model.Model_Recieve_Message;
import com.nhom11.model.Model_Send_Message;

/**
 *
 * @author btdun
 */
public interface EventSendMessage {
    public void sendMessage(Model_Send_Message ms);
    public void receivedMessage(Model_Recieve_Message ms);
}
