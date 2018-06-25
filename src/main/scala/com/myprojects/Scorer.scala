package com.myprojects

import org.slf4j.LoggerFactory

import scala.annotation.tailrec
import scala.util.{Failure, Success, Try}

/**
  * Created by Rajesh Ojha on 6/24/2018.
  */
object Scorer {

  val logger = LoggerFactory.getLogger("TenPinBowlingScorer")

  //Parse the Space separated arguments and converts it to list of integers to calculate score
  def parseInputArguments(args: Array[String]): List[Int] = {
    if (args.isEmpty) throw EmptyInputScoreException()
    else
      args
        .flatMap(_.split("\\s+"))
        .toList
        .map(_.trim)
        .map(_.toInt)
  }

  def getScore(args: Array[String]): Int = {
    Try(parseInputArguments(args)) match {
      case Success(intList) => calculateScore(IntScores(intList))
      case Failure(ex) => throw ex
    }
  }

  // Calculates the score
  def calculateScore(inScores: IntScores): Int = {
    validateFrameCounts(getFrames(inScores))
      .map(_.totalScore)
      .sum
  }

  // Converts input of List[Int] in to corresponding Bowling frames that may include Strike, Spare and Open
  @tailrec
  def getFrames(scoreInts: IntScores, frames: List[BowlingFrame] = Nil): List[BowlingFrame] =
  scoreInts.rolls match {
    case Nil => frames.reverse
    case r :: r1 => getFrames(scoreInts.dropFirstFrame, scoreInts.nextFrame :: frames)
  }

  // Validate if the number of frames in input is less than equal to 10. Also drop the last two frames in case of a perfect game
  def validateFrameCounts(frameList: List[BowlingFrame]): List[BowlingFrame] = {
    if (frameList.size <= 10) frameList
    else if (frameList.size <= 12) frameList.take(10)
    else throw InvalidFrameCountException()
  }

}
