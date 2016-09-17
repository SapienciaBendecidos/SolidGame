/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.solidgame;

/**
 *
 * @author David
 */
class CommandNotFoundException extends Exception {

    CommandNotFoundException(String commandName) {
        super(commandName + " Not found");
    }
    
}
