/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.solidgame.refactor.boards;

import com.solidgame.refactor.instructions.DIRECTION;

/**
 *
 * @author lisaula
 */
public interface Board {

    public void init();

    public boolean hasPlayerArrivedDestination();

    public void movePlayer(DIRECTION direction) throws Exception;
    
}
