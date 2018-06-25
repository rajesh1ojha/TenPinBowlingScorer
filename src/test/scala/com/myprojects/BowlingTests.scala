package com.myprojects

import org.scalatest.FlatSpec

/**
  * Created by Raj on 6/24/2018.
  */
class BowlingTests extends FlatSpec {

  """
    |This application would score a game of ten pin bowling. Input to the application will be passed as space seperated integers having the number
    | of pin knocked down by a player in each roll. It is developed in scala.
    |
    | Sample input to the application is : 4 5 4 5 4 5 4 5 4 5 4 5 4 5 4 5 4 5 4 5
    | Output would be a text line showing the score for the game with input rolls
    |
    |  Scoring in this application has been done in traditional scoring way as mentioned in article
    |  https://en.wikipedia.org/wiki/Ten-pin_bowling#Traditional_scoring . Summary of scoring rules are as mentioned below:
    |
    |A game of bowling consists of ten frames. In each frame, the bowler will have two chances to knock down as many pins as possible with their
    |bowling ball. If a bowler is able to knock down all ten pins with the first ball, they are awarded a strike. If the bowler is able to knock
    | down all 10 pins with the two balls of a frame, it is known as a spare. Bonus pins are awarded for both of these, depending on what is
    | scored in the next two balls (for a strike) or one ball (for a spare). The bowler is allowed to throw two extra balls for achieving a
    | strike in the tenth frame, or one extra ball for achieving a spare. This allows for a potential of 12 strikes in a single game,and a
    | maximum score of 300 pins, a perfect game. Although, if there is a time limit and if time runs out before the end of ten frames bowling
    | stops, and the person with the highest pinfall wins the game.
    | Scoring is done with traditional scoring way. Scoring rules are :
    | 1) In general, one pin is scored for each pin that is knocked over. So if a player bowls over three pins with the first shot, then six
    | with the second, the player would receive a total of nine pins for that frame. If a player knocks down nine pins with the first shot,
    | but misses with the second, the player would also score nine. When a player fails to knock down all ten pins after their second ball
    | it is known as an open frame.
    | 2)When all ten pins are knocked down with the first ball (called a strike), a player is awarded ten pins, plus a bonus of whatever
    | is scored with the next two balls. In this way, the pinfall scored for the two balls after the strike are counted twice.
    | 3)A "spare" is awarded when no pins are left standing after the second ball of a frame; i.e., a player uses both balls of a frame
    |  to clear all ten pins. A player achieving a spare is awarded ten pins, plus a bonus of whatever is scored with the next ball
    |   (only the first ball is counted).
  """.stripMargin
  it should "produce valid score as for a strike and open frame" in {
    assert(Scorer.getScore(Array("10 3 6")) == 28)
  }

  it should "produce valid score for two consecutive strikes" in {
    assert(Scorer.getScore(Array("10 10 9 0")) == 57  )
  }

  it should "produce valid score for a turkey that is 3 consecutive strikes" in {
    assert(Scorer.getScore(Array("10 10 10 8 2 8")) == 104  )
  }

  it should "produce valid score for a player who scores multiple strikes in succession" in {
    assert(Scorer.getScore(Array("10 10 10 10 10 7 2")) == 145  )
  }

  it should "produce valid score for a player who scores a spare" in {
    assert(Scorer.getScore(Array("7 3 4 2")) == 20  )
  }

  it should "produce score as 300 for a perfect game with all strikes" in {
    assert(Scorer.getScore(Array("10 10 10 10 10 10 10 10 10 10 10 10")) == 300  )
  }

  it should "produce valid score for a player with last frame as spare" in {
    assert(Scorer.getScore(Array("10 10 10 10 10 10 10 10 10 1 9 5")) == 266  )
  }

  it should "produce valid score for a player with all open frames" in {
    assert(Scorer.getScore(Array("4 5 4 5 4 5 4 5 4 5 4 5 4 5 4 5 4 5 4 5 ")) == 90  )
  }

  "An empty input" should "produce EmptyInputScoreException when score is calculated on Empty input" in {
    assertThrows[EmptyInputScoreException] {
      TenPinBowling.main(Array())
    }
  }
  it should "produce InvalidFrameCountException when the number of frames is more than 10" in {
    assertThrows[InvalidFrameCountException] {
      TenPinBowling.main(Array("5 4 10 4 5 6 3  4 3 5 4 4 2 7 3 2 1 10 10 10 4 5 6 3 3 3 2 6  1"))
    }
  }

  it should "produce InvalidFrameException when the number of frames is more than 10" in {
    assertThrows[InvalidFrameException] {
      TenPinBowling.main(Array("5 9 10 4 5 6 3  4 3"))
    }
  }


  it should "produce InvalidInputException when the number of frames is more than 10" in {
    assertThrows[NumberFormatException] {
      TenPinBowling.main(Array("5 a 10 4 5 6 3  4 3"))
    }
  }
}