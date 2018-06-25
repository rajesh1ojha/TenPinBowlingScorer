package com.myprojects

/**
  * Created by Rajesh on 6/24/2018.
  *
  * This is the main entry method for this application. It takes arguments to the application as input and calculates
  * the score for a bowling game.
  */

import com.myprojects.Scorer.logger
import org.slf4j.LoggerFactory

import scala.annotation.tailrec
import scala.util.{Failure, Success, Try}


object TenPinBowling  {
  def main(args: Array[String]): Unit = {

    // Parse the arguments. If valid argument then calculate scores for the game
    Try(Scorer.getScore(args)) match {
      case Failure(ex) => Scorer.logger.error(ex.printStackTrace().toString) ; throw ex
      case Success(totalScore) => logger.info(s"Total score for this game is : $totalScore")
    }
  }
}