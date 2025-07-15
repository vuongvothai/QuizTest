/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vtv.utils.theme;

import com.vtv.quiztestv1.App;

/**
 *
 * @author vuong
 */
public class LightFactory implements ThemeFactory{

    @Override
    public String getStyleSheet() {
        return App.class.getResource("light.css").toExternalForm();
    }
    
}
