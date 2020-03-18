# MathTicTacToe
The Application is the classic tictactoe game which replaces Xs and Os with the odd and even numbers. The same game can be extended to various sizes to cover wide range of odd and even numbers.

Language: Kotlin
Archictecture: MVMM(Model View ViewModel)

Model: Data + State + Business Logic (Cell, Player, Game)
View: Binds to observable variables and actions exposed to view model (GameActivity, GameBeginDialog, GameEndDialog)
ViewModel: Uses LiveData (GameViewModel)

Testing: Junit Testing of the model
UI Testing: Barista
