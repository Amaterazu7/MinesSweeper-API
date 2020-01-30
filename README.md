# MinesSweeper API
* Spring-boot REST API application to play MinesSweeper, this one save every move of the game status on an spring boot embedded MongoDB as a JSON document. I decided make it that way because REST microservices must be stateless, and a this app create, delete and save all the status of the game, given to the front end side the responsibility of the present and play the game.   

### Running the APP
* You can run the application installing the dependencies with Maven and then launch the app file:

`` com.exercise.minesweeper.MinesweeperApplication ``

* Or you can install docker and run this command on the directory in order to create a docker image:

`` docker image build -t docker-boot-minesweeper . ``

* and the run the application on a docker container:

`` docker container run -p 8080:8080 docker-boot-minesweeper ``

* when the application is started you can go to:
      
        * http://localhost:8080/swagger-ui.html#/
  and see all the documentation about it.


# MinesSweeper API - Deviget Code Challenge
API test

We ask that you complete the following challenge to evaluate your development skills. Please use the programming language and framework discussed during your interview to accomplish the following task.

## The Game
Develop the classic game of [Minesweeper](https://en.wikipedia.org/wiki/Minesweeper_(video_game))

## Show your work

1.  Create a Public repository ( please dont make a pull request, clone the private repository and create a new plublic one on your profile)
2.  Commit each step of your process so we can follow your thought process.

## What to build
The following is a list of items (prioritized from most important to least important) we wish to see:
* Design and implement  a documented RESTFull API for the game (think of a mobile app for your API)
* Implement an API client library for the API designed above. Ideally, in a different language, of your preference, to the one used for the API
* When a cell with no adjacent mines is revealed, all adjacent squares will be revealed (and repeat)
* Ability to 'flag' a cell with a question mark or red flag
* Detect when game is over
* Persistence
* Time tracking
* Ability to start a new game and preserve/resume the old ones
* Ability to select the game parameters: number of rows, columns, and mines
* Ability to support multiple users/accounts
 
## Deliverables we expect:
* URL where the game can be accessed and played (use any platform of your preference: heroku.com, aws.amazon.com, etc)
* Code in a public Github repo
* README file with the decisions taken and important notes

## Time Spent
You do not need to fully complete the challenge. We suggest not to spend more than 5 hours total, which can be done over the course of 2 days.  Please make commits as often as possible so we can see the time you spent and please do not make one commit.  We will evaluate the code and time spent.
 
What we want to see is how well you handle yourself given the time you spend on the problem, how you think, and how you prioritize when time is insufficient to solve everything.

Please email your solution as soon as you have completed the challenge or the time is up.