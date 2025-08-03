import React from 'react';

function ListofPlayers() {
  // Declare players array
  const players = [
    { name: "Virat", score: 95 },
    { name: "Rohit", score: 45 },
    { name: "Rahul", score: 60 },
    { name: "Jadeja", score: 85 },
    { name: "Pant", score: 25 },
    { name: "Shami", score: 70 },
    { name: "Bumrah", score: 90 },
    { name: "Iyer", score: 30 },
    { name: "Hardik", score: 75 },
    { name: "Ashwin", score: 65 },
    { name: "Kuldeep", score: 55 }
  ];

  // Filter players with score < 70
  const lowScorers = players.filter(p => p.score < 70);

  return (
    <div>
      <h2>All Players</h2>
      <ul>
        {players.map((player, index) => (
          <li key={index}>{player.name} - {player.score}</li>
        ))}
      </ul>

      <h3>Players with score below 70</h3>
      <ul>
        {lowScorers.map((player, index) => (
          <li key={index}>{player.name} - {player.score}</li>
        ))}
      </ul>
    </div>
  );
}

export default ListofPlayers;
