package org.sk.storage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.sk.modal.Match;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class ScoreBoardStorageTest {

    private ScoreBoardStorage scoreBoardStorage;

    @BeforeEach
    void setUp() {
        scoreBoardStorage = ScoreBoardStorage.getInstance();

        while(scoreBoardStorage.getAll().size() !=0) {
            scoreBoardStorage.remove(scoreBoardStorage.getAll().get(0));
        }
    }

    @Test
    void testGetAllWhenNoMatchesAddedThenListEmpty() {
        assertTrue(scoreBoardStorage.getAll().isEmpty());
    }

    @Test
    void testAddWhenMatchAddedThenMatchPresentInList() {
        Match match = new Match("Team1", "Team2");
        scoreBoardStorage.add(match);
        assertTrue(scoreBoardStorage.getAll().contains(match));
    }

    @Test
    void testRemoveWhenMatchRemovedThenMatchNotPresentInList() {
        Match match = new Match("Team1", "Team2");
        scoreBoardStorage.add(match);
        scoreBoardStorage.remove(match);
        assertFalse(scoreBoardStorage.getAll().contains(match));
    }

    @Test
    void testGetWhenMatchExistsThenMatchReturned() {
        Match match = new Match("Team1", "Team2");
        scoreBoardStorage.add(match);
        Optional<Match> retrievedMatch = scoreBoardStorage.get("Team1", "Team2");
        assertTrue(retrievedMatch.isPresent());
        assertEquals(match, retrievedMatch.get());
    }

    @Test
    void testGetWhenMatchDoesNotExistThenMatchNotReturned() {
        Optional<Match> retrievedMatch = scoreBoardStorage.get("Team1", "Team2");
        assertFalse(retrievedMatch.isPresent());
    }
}