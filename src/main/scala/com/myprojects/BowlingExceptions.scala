package com.myprojects

/**
  * Created by Rajesh Ojha on 6/24/2018.
  */
trait BowlingExceptions extends RuntimeException
case class InvalidFrameCountException(message: String = "Number of input frames can't exceed 10" )
  extends IllegalArgumentException(message)
case class InvalidFrameException(message: String = "Score of a frame can't exceed 10")
  extends IllegalArgumentException(message)
case class EmptyInputScoreException(message: String = "No input score to calculate scoring")
  extends Exception(message)