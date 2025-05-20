groupe 025 etudiants:
    22412672 YOCOLI Konan Jean Epiphane

.
└── games
    ├── factoredgames
    │   ├── AbstractGame.java
    │   ├── DemoNim.java
    │   ├── DemoTicTacToe.java
    │   ├── Nim.java
    │   ├── Test.java
    │   └── TicTacToe.java
    ├── genericgames
    │   ├── AbstractGame.java
    │   ├── Game.java
    │   ├── Nim.java
    │   ├── Test.java
    │   └── TicTacToe.java
    ├── nim
    │   ├── Demo.java
    │   ├── Nim.java
    │   └── Test.java
    ├── players
    │   ├── Human.java
    │   ├── NegamaxPlayer.java
    │   ├── Player.java
    │   ├── RandomPlayer.java
    │   ├── Test.java
    │   └── TestNegamax.java
    ├── plays
    │   ├── DemoNim.java
    │   ├── DemoTicTacToe.java
    │   ├── Orchestrator.java
    │   └── Test.java
    └── tictactoe
        ├── Demo.java
        ├── Test.java
        └── TicTacToe.java


Démonstration :
    +Compilation
        
        src$ javac -d ../build games/nim/Demo.java
        src$ javac -d ../build games/tictactoe/Demo.java

        src$ javac -d ../build games/factoredgames/DemoNim.java
        src$ javac -d ../build games/factoredgames/DemoTicTacToe.java

        src$ javac -d ../build games/genericgames/Nim.java
        src$ javac -d ../build games/genericgames/TicTacToe.java

        src$ javac -d ../build games/players/Human.java
        src$ javac -d ../build games/players/RandomPlayer.java
        src$ javac -d ../build games/players/NegamaxPlayer.java

        src$ javac -d ../build games/plays/DemoNim.java
        src$ javac -d ../build games/plays/DemoTicTacToe.java


    +Exécution

        src$ java -cp ../build/ games.nim.Demo
        src$ java -cp ../build/ games.tictactoe.Demo

        src$ java -cp ../build/ games.factoredgames.DemoNim
        src$ java -cp ../build/ games.factoredgames.DemoTicTacToe

        src$ java -cp ../build/ games.plays.DemoNim
        src$ java -cp ../build/ games.plays.DemoTicTacToe


    + Jeux
        Nous avons réaliser plusieurs jeux, ils sont dans les fichiers
        
        ├── jeu_01.txt
        ├── jeu_02.txt
        ├── jeu_03.txt
        ├── jeu_04.txt
        ├── jeu_05.txt
        ├── jeu_06.txt


Javadoc
    +Ligne de géneration

    javadoc -d ../docs games/nim/Nim.java games/tictactoe/Demo.java games/factoredgames/Nim.java games/factoredgames/TicTacToe.java games/factoredgames/AbstractGame.java games/genericgames/Nim.java games/genericgames/TicTacToe.java games/genericgames/AbstractGame.java games/genericgames/Game.java games/players/Player.java games/players/Human.java games/players/RandomPlayer.java games/players/NegamaxPlayer.java games/plays/Orchestrator.java -cp ../lib/gamestests.jar



Test
    src$ javac -d ../build -cp ../lib/gamestests.jar games/nim/Test.java
    src$ java -cp ../build/:../lib/gamestests.jar games.nim.Test

    src$ javac -d ../build -cp ../lib/gamestests.jar games/tictactoe/Test.java
    src$ java -cp ../build/:../lib/gamestests.jar games.tictactoe.Test

    src$ javac -d ../build -cp ../lib/gamestests.jar games/factoredgames/Test.java
    src$ java -cp ../build/:../lib/gamestests.jar games.factoredgames.Test

    src$ javac -d ../build -cp ../lib/gamestests.jar games/genericgames/Test.java
    src$ java -cp ../build/:../lib/gamestests.jar games.genericgames.Test

    src$ javac -d ../build -cp ../lib/gamestests.jar games/plays/Test.java
    src$ java -cp ../build/:../lib/gamestests.jar games.plays.Test

    src$ javac -d ../build -cp ../lib/gamestests.jar games/players/Test.java
    src$ java -cp ../build/:../lib/gamestests.jar games.players.Test

    src$ javac -d ../build -cp ../lib/gamestests.jar games/players/TestNegamax.java
    src$ java -cp ../build/:../lib/gamestests.jar games.players.TestNegamax