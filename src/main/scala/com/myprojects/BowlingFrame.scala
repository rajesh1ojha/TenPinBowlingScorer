package com.myprojects

/**
  * Created by Rajesh Ojha on 6/24/2018.
  */
sealed trait BowlingFrame {
  val rolls: List[Int]

  def totalScore: Int = rolls.sum
}

case class Strike(rolls: List[Int]) extends BowlingFrame

case class Spare(rolls: List[Int]) extends BowlingFrame

case class Open(rolls: List[Int]) extends BowlingFrame

case class IntScores(rolls: List[Int]) {
  private def nextRollIsStrike: Boolean = rolls.headOption contains 10

  private def nextRollIsSpare: Boolean = rolls.take(2).sum == 10

  private def nextRollIsOpen: Boolean = rolls.take(2).sum < 10

  private def rollsOfNextFrame: Int = if (nextRollIsStrike) 1 else 2

  def dropFirstFrame: IntScores = this.copy(rolls drop rollsOfNextFrame)

  def nextFrame: BowlingFrame =
    if (nextRollIsStrike) Strike(rolls.take(3))
    else if (nextRollIsSpare) Spare(rolls.take(3))
    else if (nextRollIsOpen) Open(rolls.take(2))
    else throw InvalidFrameException()
}

