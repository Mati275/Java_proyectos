package main.java.service;

import main.java.domain.enums.CardValueState;
import main.java.domain.enums.RoundResultSolitary;
import main.java.domain.model.CroupierBeatable;
import main.java.domain.model.Player;

public class BettingService {

    // ATTRIBUTES
    int currentBet;

    // CONSTRUCTOR

    public BettingService(){
        this.bet = 0;
    }

    // GETTERS
    public int getBet() { return currentBet; }

    // SETTERS
    public void setBet(int value){ currentBet += value; }




    /**
     * Called when the round just end, this method gives the correct chips to both: player and croupier, also restarts the bet
     * @param player
     * @param croupier
     */
    public RoundResultSolitary resolveRound(Player player, CroupierBeatable croupier){

        RoundResultSolitary roundResult = setPlayerAndCroupierChips(player, croupier);  // Set the chips to both players and get the winner

        currentBet = 0;

        return roundResult;

    }

    /**
     * Set the chips to both players and get the winner
     * @param player
     * @param croupier
     * @return the winner of the round (with the enum RoundResultSolitary)
     */
    public RoundResultSolitary setPlayerAndCroupierChips(Player player, CroupierBeatable croupier){

        int currentCroupierPoints = croupier.getMaxCardValue();
        int currentPlayerPoints = player.getMaxCardValue();

        // The croupier and the player haven't passed 21 points
        if( croupier.getCardValueState() != CardValueState.NONE_CARD_VALUE && player.getCardValueState() != CardValueState.NONE_CARD_VALUE ) {

            // Impossible to have "points <= 0"

            // Croupier wins
            if( currentPlayerPoints < currentCroupierPoints ) {
                player.addChips( -currentBet );
                croupier.addChips( currentBet );
                return RoundResultSolitary.CROUPIER_WIN;
                // msg += player.toString() + " Ohh has perdido esta ronda, ahora tienes " + player.getChips() + " ficha(s)";
            }

            // Draw
            else if( currentPlayerPoints == currentCroupierPoints ) {
                return RoundResultSolitary.DRAW;
                //msg += player.toString() + " ¡Has empatado! Ahora tienes " + player.getChips() + " ficha(s)";
            }

            // Player wins
            else {
                player.addChips( currentBet );
                croupier.addChips( -currentBet );
                return RoundResultSolitary.PLAYER_WIN;
                // msg += player.toString() + " Tomaa, has ganadooo :D, ahora tienes " + player.getChips() + " ficha(s)";
            }

        }

        // The player passed 21 points
        else if( player.getCardValueState() == CardValueState.NONE_CARD_VALUE ) {
            player.addChips( -currentBet );
            croupier.addChips( currentBet );
            return RoundResultSolitary.CROUPIER_WIN;

            //msg += player.toString() + " Ohh has perdido esta ronda, ahora tienes " + player.getChips() + " ficha(s)";
        }

        // The croupier passed 21 points
        else {
            player.addChips( currentBet );
            croupier.addChips( -currentBet );
            return RoundResultSolitary.PLAYER_WIN;

            //msg += player.toString() + " Tomaa, has ganadooo :D, ahora tienes " + player.getChips() + " ficha(s)";
        }

    }

//
//    /**
//     * Set the chips to the player and get an string with the chips that the player has at the end of the round.
//     * The message received is also the information that the player has whether he won the round or not
//     */
//    public void setPlayerChips(Player player, CroupierBeatable croupier) {
//        // String msg = "";
//
//        int croupierPoints = croupier.getMaxCardValue();
//        int currentPlayerPoints = player.getMaxCardValue();
//
//        // The croupier and the player haven't passed 21 points
//        if( croupier.getCardValueState() != CardValueState.NONE_CARD_VALUE && player.getCardValueState() != CardValueState.NONE_CARD_VALUE ) {
//
//            // Impossible to have "points <= 0"
//            if( currentPlayerPoints < croupierPoints ) {
//                player.addChips( -currentBet );
//               // msg += player.toString() + " Ohh has perdido esta ronda, ahora tienes " + player.getChips() + " ficha(s)";
//            }
//            else if( currentPlayerPoints == croupierPoints ) {
//                //msg += player.toString() + " ¡Has empatado! Ahora tienes " + player.getChips() + " ficha(s)";
//            }
//            else {
//                player.addChips( currentBet );
//               // msg += player.toString() + " Tomaa, has ganadooo :D, ahora tienes " + player.getChips() + " ficha(s)";
//            }
//
//        }
//
//        // The player passed 21 points
//        else if( player.getCardValueState() == CardValueState.NONE_CARD_VALUE ) {
//            player.addChips( -currentBet );
//            //msg += player.toString() + " Ohh has perdido esta ronda, ahora tienes " + player.getChips() + " ficha(s)";
//        }
//
//        // The croupier passed 21 points
//        else {
//            player.addChips( currentBet );
//            //msg += player.toString() + " Tomaa, has ganadooo :D, ahora tienes " + player.getChips() + " ficha(s)";
//        }
//
//        //return msg;
//    }
//
//    /**
//     * Set the chips to the croupier and get an string with the chips that the cropuier hasat the end of the round
//     * @return
//     */
//    public void setCroupierChips(Player player, CroupierBeatable croupier) {
//        //String msg = "";
//
//        int croupierPoints = croupier.getMaxCardValue();
//        int currentPlayerPoints = player.getMaxCardValue();
//
//        // Remember: If the points are "-1" it means that the user passed 21 points
//
//        // The croupier and the player haven't passed 21 points
//        if( croupier.getCardValueState() != CardValueState.NONE_CARD_VALUE && player.getCardValueState() != CardValueState.NONE_CARD_VALUE ) {
//
//            // The croupier has more points than the player
//            if( currentPlayerPoints < croupierPoints ) {
//                croupier.addChips( currentBet );
//            }
//            // The player has more points than the croupier
//            else if( currentPlayerPoints > croupierPoints ) {
//                croupier.addChips( -currentBet );
//            }
//            // Draw: Nothing
//        }
//
//        // The croupier passed 21 points
//        else if( croupier.getCardValueState() == CardValueState.NONE_CARD_VALUE ) {
//            croupier.addChips( -currentBet );
//        }
//
//        // The player passed 21 points
//        else {
//            croupier.addChips( currentBet );
//        }
//
//        // Add the message (the same for every situation)
//        // msg += croupier.toString() + " tiene " + croupier.getChips() + " ficha(s)";
//
//        // return msg;
//    }


}
