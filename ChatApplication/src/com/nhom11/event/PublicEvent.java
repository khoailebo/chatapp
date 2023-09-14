/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom11.event;

/**
 *
 * @author btdun
 */
public class PublicEvent {

    /**
     * @return the eventMain
     */
    public EventMain getEventMain() {
        return eventMain;
    }

    /**
     * @param eventMain the eventMain to set
     */
    public void setEventMain(EventMain eventMain) {
        this.eventMain = eventMain;
    }

    /**
     * @return the eventLogin
     */
    public EventLogin getEventLogin() {
        return eventLogin;
    }

    /**
     * @param eventLogin the eventLogin to set
     */
    public void setEventLogin(EventLogin eventLogin) {
        this.eventLogin = eventLogin;
    }

    /**
     * @return the eventSendMessage
     */
    public EventSendMessage getEventSendMessage() {
        return eventSendMessage;
    }

    /**
     * @param eventSendMessage the eventSendMessage to set
     */
    public void setEventSendMessage(EventSendMessage eventSendMessage) {
        this.eventSendMessage = eventSendMessage;
    }
    private static PublicEvent instance;
    private static EventImageView eventImageView;
    private static EventImageDonwload eventImageDownload;
    private EventSendMessage eventSendMessage;
    private EventMain eventMain;
    private EventLogin eventLogin;
    private EventSetUserName eventSetUserName;
    
    private PublicEvent(){
        
    }
    public static PublicEvent getInstance(){
        if(instance == null)
        {
            instance = new PublicEvent();
        }
        return instance;
    }
    public void addEventImageView(EventImageView e){
        this.eventImageView = e;
    }
    public EventImageView geteEventImageView(){
        return eventImageView;
    }
    public void addEventImageDownload(EventImageDonwload e){
        this.eventImageDownload = e;
    }
    public EventImageDonwload getEventImageDonwload(){
        return eventImageDownload;
    }

    /**
     * @return the eventSetUserName
     */
    public EventSetUserName getEventSetUserName() {
        return eventSetUserName;
    }

    /**
     * @param eventSetUserName the eventSetUserName to set
     */
    public void setEventSetUserName(EventSetUserName eventSetUserName) {
        this.eventSetUserName = eventSetUserName;
    }
}
