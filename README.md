Ten Pin Bowling Application

This application would score a game of ten pin bowling. Input to the application will be passed as space seperated integers having the number
 of pin knocked down by a player in each roll. It is developed in scala.

Sample input to the application is : 4 5 4 5 4 5 4 5 4 5 4 5 4 5 4 5 4 5 4 5
Output would be a text line showing the score for the game with input rolls

Scoring in this application has been done in traditional scoring way as mentioned in article https://en.wikipedia.org/wiki/Ten-pin_bowling#Traditional_scoring . Summary of scoring rules are as mentioned below:

A game of bowling consists of ten frames. In each frame, the bowler will have two chances to knock down as many pins as possible with their
bowling ball. If a bowler is able to knock down all ten pins with the first ball, they are awarded a strike. If the bowler is able to knock
 down all 10 pins with the two balls of a frame, it is known as a spare. Bonus pins are awarded for both of these, depending on what is
 scored in the next two balls (for a strike) or one ball (for a spare). The bowler is allowed to throw two extra balls for achieving a
 strike in the tenth frame, or one extra ball for achieving a spare. This allows for a potential of 12 strikes in a single game,and a
 maximum score of 300 pins, a perfect game. Although, if there is a time limit and if time runs out before the end of ten frames bowling
 stops, and the person with the highest pinfall wins the game.
 Scoring is done with traditional scoring way. Scoring rules are :
1) In general, one pin is scored for each pin that is knocked over. So if a player bowls over three pins with the first shot, then six
 with the second, the player would receive a total of nine pins for that frame. If a player knocks down nine pins with the first shot,
 but misses with the second, the player would also score nine. When a player fails to knock down all ten pins after their second ball
 it is known as an open frame.
 
2) When all ten pins are knocked down with the first ball (called a strike), a player is awarded ten pins, plus a bonus of whatever
 is scored with the next two balls. In this way, the pinfall scored for the two balls after the strike are counted twice.
 
3) A "spare" is awarded when no pins are left standing after the second ball of a frame; i.e., a player uses both balls of a frame to clear all ten pins. A player achieving a spare is awarded ten pins, plus a bonus of whatever is scored with the next ball (only the first ball is counted).

This application is written in scala. To run it, download the project and open the sbt terminal window inside the project. Once done, run the application with below command.

run <input score>

Sample score can be : run 4 5 6 1 10 10 10

