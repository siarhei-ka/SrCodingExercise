# Live Football World Cup Score Board 
version 1

## The scoreboard supports the following operations:
1. Start a new match, assuming initial score 0 – 0 and adding it the scoreboard.
   This should capture following parameters:
   a. Home team
   b. Away team
2. Update score. This should receive a pair of absolute scores: home team score and away
   team score.
3. Finish match currently in progress. This removes a match from the scoreboard.
4. Get a summary of matches in progress ordered by their total score. The matches with the
   same total score will be returned ordered by the most recently started match in the
   scoreboard.
  
## For example, if following matches are started in the specified order and their scores respectively updated:
   1. Mexico 0 - Canada 5
   2. Spain 10 - Brazil 2
   3. Germany 2 - France 2
   4. Uruguay 6 - Italy 6
   5. Argentina 3 - Australia 1

## Usage

Create a Score Board:
```java
IScoreBoard scoreBoard = ScoreBoard.getInstance();
```


Start a new match:
```java
// throws StartMatchException when Match alredy started.
scoreBoard.startNewMatch("HomeTeam", "AwayTeam"));
```

Update score we new values:
```java
// throws MatchNotFoundException when Match not found
// throws UpdateScoreException when new values are:
//                1. negative
//                2. new score less than existion
//                3. (total score + 1) != (newHomeTeamScore + awayTeamScore) 
scoreBoard.updateScore("HomeTeam", "AwayTeam", 1, 2);
```

Finish match:
```java
// throws MatchNotFoundException when Match not found
scoreBoard.finishMatch("HomeTeam", "AwayTeam");
```

Get a summary:
```java
List<Match> matches = scoreBoard.getMatchesInProgressOrderedByTotalScore()
```

