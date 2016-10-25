package com.NovikIgor.dao.impl;

import com.NovikIgor.dao.CardManagementDAO;
import com.NovikIgor.dao.pool.ConnectionPool;
import com.NovikIgor.dto.Card;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Class implement Card DAO model for takes cards information from DB.
 * <p>
 * Created by nolik on 25.10.16.
 */
public class CardManagmentDAOimpl implements CardManagementDAO {

    private static final String SQL_SELECT_ALL_CARDS = "SELECT * FROM InternetBanking.Cards";
    private static final String SQL_SELECT_ALL_CARDS_MAIN_INFO = "SELECT cardNumber,summ,Users_login,currencyName FROM InternetBanking.Cards INNER JOIN Currencies ON Currencies_idCurrency=Currencies.idCurrency";
    private static final String SQL_SELECT_CARDS_BY_LOGIN = "SELECT cardNumber,summ,Users_login,currencyName FROM InternetBanking.Cards INNER JOIN Currencies ON Currencies_idCurrency=Currencies.idCurrency WHERE Cards.Users_login=?";
    private static final String SQL_SELECT_CARDS_BY_CARDID ="SELECT cardNumber,summ,Users_login,currencyName FROM InternetBanking.Cards INNER JOIN Currencies ON Currencies_idCurrency=Currencies.idCurrency WHERE Cards.cardNumber=?";

    private static final Logger logger = Logger.getLogger(CardManagmentDAOimpl.class);

    public List<Card> getAllCards() {
        Connection conn = null;
        PreparedStatement state = null;
        //TODO: change here to ConcurentLinkedQueue<Card> implementation
        List<Card> allCards = new ArrayList<Card>();

        try {
            conn = ConnectionPool.getConnection();
            state = conn.prepareStatement(SQL_SELECT_ALL_CARDS_MAIN_INFO);
            ResultSet resultSet = state.executeQuery();

            while (resultSet.next()) {
                Card card = new Card();
                card.setCardNumber(resultSet.getInt(1));
                card.setSum(resultSet.getInt(2));
                card.setUser(resultSet.getString(3));
                card.setCurrency(resultSet.getString(4));
                allCards.add(card);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            ConnectionPool.close(state);
            ConnectionPool.close(conn);
        }

        return allCards;
    }

    public List<Card> getCardsByLogin(String login) {
        Connection conn = null;
        PreparedStatement state = null;
        List<Card> allCards = new ArrayList<Card>();

        try {
            conn = ConnectionPool.getConnection();
            state = conn.prepareStatement(SQL_SELECT_CARDS_BY_LOGIN);
            state.setString(1, login);
            ResultSet resultSet = state.executeQuery();

            while (resultSet.next()) {
                Card card = new Card();
                card.setCardNumber(resultSet.getInt(1));
                card.setSum(resultSet.getInt(2));
                card.setUser(resultSet.getString(3));
                card.setCurrency(resultSet.getString(4));
                allCards.add(card);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            ConnectionPool.close(state);
            ConnectionPool.close(conn);
        }

        return allCards;
    }

    public Card getCardByCardID(int userID) {
        Connection conn = null;
        PreparedStatement state = null;
        Card card = null;

        try {
            conn=ConnectionPool.getConnection();
            state=conn.prepareStatement(SQL_SELECT_CARDS_BY_CARDID);
            state.setInt(1,userID);
            ResultSet resultSet = state.executeQuery();

            while (resultSet.next()) {
                card = new Card();
                card.setCardNumber(resultSet.getInt(1));
                card.setSum(resultSet.getInt(2));
                card.setUser(resultSet.getString(3));
                card.setCurrency(resultSet.getString(4));
                return card;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return card;
    }
}
