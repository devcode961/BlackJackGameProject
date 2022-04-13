package com.game.blackjack.utils;

import com.game.blackjack.constants.GameConstants;
import com.game.blackjack.model.Player;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

class UtilitiesTest {

    @TempDir
    Path tempDir;

    @Test
    void validate_File_Exists_And_Deck_Created() throws IOException {
        Path tempFile = tempDir.resolve("blackjacktest.txt");
        String inputCardValues = "CA, HA, DQ, HQ, S4, H2, C6, C10, S5, DJ, H8, D3, C7, H5, D9, S2, SQ, C4, H6, D5, SK, S3, H4, C2, D8, C8, S6, D6, HK, D4, S8, D7, S7, SA, H10, DK, DA, H7, CK, D10, H3, C5, CQ, C3, S9, CJ, S10, HJ, SJ, C9, D2, H9";
        Files.write(tempFile, inputCardValues.getBytes(StandardCharsets.UTF_8));
        Assertions.assertTrue(tempFile.toFile().exists());
        System.out.println(tempFile.toFile().getPath());
        ArrayDeque<String> initializedDeck = Utilities.validateInputFileAndCreateDeck(tempFile.toFile().getPath());
        Assertions.assertFalse(initializedDeck.isEmpty());
        Assertions.assertEquals(GameConstants.STANDARD_DECK_SIZE, initializedDeck.size());
    }

    @Test
    void validate_Deck_Not_Created_When_Input_Card_Value_Not_In_Correct_Format() throws IOException {
        Path tempFile = tempDir.resolve("blackjacktest.txt");
        String inputCardValues = "CA, HA, DQ, H#%#R%#^, S4, H2, C6, C10, S5, DJ, H8, D3, C7, H5, D9, S2, SQ, C4, H6, D5, SK, S3, H4, C2, D8, C8, S6, D6, HK, D4, S8, D7, S7, SA, H10, DK, DA, H7, CK, D10, H3, C5, CQ, C3, S9, CJ, S10, HJ, SJ, C9, D2, H9";
        Files.write(tempFile, inputCardValues.getBytes(StandardCharsets.UTF_8));
        Assertions.assertTrue(tempFile.toFile().exists());
        System.out.println(tempFile.toFile().getPath());
        ArrayDeque<String> initializedDeck = Utilities.validateInputFileAndCreateDeck(tempFile.toFile().getPath());
        Assertions.assertTrue(initializedDeck.isEmpty());
    }

    @Test
    void validate_Deck_Not_Created_When_Input_File_Does_Not_Have_Exact_52_Card_Values() throws IOException {
        Path tempFile = tempDir.resolve("blackjacktest.txt");
        //Following input has 51 cards, 1 less than required 52 cards
        String inputCardValues = "CA, HA, DQ, S4, H2, C6, C10, S5, DJ, H8, D3, C7, H5, D9, S2, SQ, C4, H6, D5, SK, S3, H4, C2, D8, C8, S6, D6, HK, D4, S8, D7, S7, SA, H10, DK, DA, H7, CK, D10, H3, C5, CQ, C3, S9, CJ, S10, HJ, SJ, C9, D2, H9";
        Files.write(tempFile, inputCardValues.getBytes(StandardCharsets.UTF_8));
        Assertions.assertTrue(tempFile.toFile().exists());
        System.out.println(tempFile.toFile().getPath());
        ArrayDeque<String> initializedDeck = Utilities.validateInputFileAndCreateDeck(tempFile.toFile().getPath());
        Assertions.assertTrue(initializedDeck.isEmpty());
    }

    @Test
    void validate_Calculates_Correct_Hand_Value() {
        Player player = new Player();
        player.setPlayerHand(Arrays.asList("H5", "CK"));
        Utilities.calculateHandValue(player);
        Assertions.assertEquals(15, player.getCurrentHandValue());
        player.setPlayerHand(new ArrayList<>());
        Utilities.calculateHandValue(player);
        Assertions.assertEquals(0, player.getCurrentHandValue());
        player.setPlayerHand(null);
        Utilities.calculateHandValue(player);
        Assertions.assertEquals(0, player.getCurrentHandValue());
    }
}