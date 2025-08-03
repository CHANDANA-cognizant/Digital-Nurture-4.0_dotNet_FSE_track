import React from 'react';

function IndianPlayers() {
  
  const T20Players = ["Virat", "Rohit", "Pant", "Jadeja", "Bumrah"];
  const RanjiPlayers = ["Sundar", "Gill", "Shaw", "Sarfaraz", "Saini"];

 
  const allPlayers = [...T20Players, ...RanjiPlayers];


  const oddTeam = allPlayers.filter((_, index) => index % 2 === 0);
  const evenTeam = allPlayers.filter((_, index) => index % 2 !== 0);

  return (
    <div>
      <h2>All Indian Players</h2>
      <p><strong>Odd Team:</strong> {oddTeam.join(", ")}</p>
      <p><strong>Even Team:</strong> {evenTeam.join(", ")}</p>
    </div>
  );
}

export default IndianPlayers;
