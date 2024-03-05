/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.orderdeliveryproject;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * Lamis Mohammed
 */
public class DATETIME {
    // ------Attribute------ 
    Date DateTime = new Date();
    SimpleDateFormat Time = new SimpleDateFormat("hh:mm:ss a");
    SimpleDateFormat Date = new SimpleDateFormat("dd/MM/yy");
    String date;
    String time;
    // ------Constractor------ 

    /**
     *
     */
    public DATETIME() {
    }

    // -------Methods------- 

    /**
     *
     * @return
     */

    public Date getDateTime() {
        return DateTime;
    }

    /**
     *
     * @param DateTime
     */
    public void setDateTime(Date DateTime) {
        this.DateTime = DateTime;
    }

    /**
     *
     * @return
     */
    public String getDate() {
        date = Date.format(DateTime).toString();
        return date;
    }

    /**
     *
     * @return
     */
    public String getTime() {
        time = (Time.format(DateTime)).toString();
        return time;
    }

   
    
}
