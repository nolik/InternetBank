package com.NovikIgor.dao;

import com.NovikIgor.dto.Card;

import java.util.List;

/**
 * Interface that describe Card Management DAO model.
 * <p>
 * Created by nolik on 25.10.16.
 */
public interface CardManagementDAO {

    public List<Card> getAllCards();

    public List<Card> getCardsByLogin();

    public Card getCardByID();
}
