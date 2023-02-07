var player = "X";
var squares = document.getElementsByClassName("square");
var winner = null;

function markSquare(event) {
  if (winner !== null || event.target.innerHTML !== "") {
    return;
  }
  event.target.innerHTML = player;
  checkForWin();
  if (winner === null) {
    switchPlayer();
    document.getElementById("turn").innerHTML = "Player " + player + "'s turn";
  } else {
    document.getElementById("turn").innerHTML = "Player " + winner + " wins!";
  }
}

function checkForWin() {
  for (var i = 0; i < 9; i += 3) {
    if (squares[i].innerHTML === squares[i + 1].innerHTML && squares[i].innerHTML === squares[i + 2].innerHTML && squares[i].innerHTML !== "") {
      winner = squares[i].innerHTML;
      return;
    }
  }
  for (var i = 0; i < 3; i++) {
    if (squares[i].innerHTML === squares[i + 3].innerHTML && squares[i].innerHTML === squares[i + 6].innerHTML && squares[i].innerHTML !== "") {
      winner = squares[i].innerHTML;
      return;
    }
  }
  if (squares[0].innerHTML === squares[4].innerHTML && squares[0].innerHTML === squares[8].innerHTML && squares[0].innerHTML !== "") {
    winner = squares[0].innerHTML;
    return;
  }
  if (squares[2].innerHTML === squares[4].innerHTML && squares[2].innerHTML === squares[6].innerHTML && squares[2].innerHTML !== "") {
    winner = squares[2].innerHTML;
    return;
  }
}

function switchPlayer() {
  if (player === "X") {
    player = "O";
  } else {
    player = "X";
  }
}

function resetBoard() {
  for (var i = 0; i < squares.length; i++) {
    squares[i].innerHTML = "";
  }
  winner = null;
  player = "X";
  document.getElementById("turn").innerHTML = "Player " + player + "'s turn";
}

for (var i = 0; i < squares.length; i++) {
  squares[i].addEventListener("click", markSquare);
}

document.getElementById("reset").addEventListener("click", resetBoard);
document.getElementById("turn").innerHTML = "Player " + player + "'s turn";
