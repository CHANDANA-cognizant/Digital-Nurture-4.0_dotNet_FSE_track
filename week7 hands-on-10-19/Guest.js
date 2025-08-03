import React from 'react';

function Guest() {
  return (
    <div>
      <h2>Welcome, Guest!</h2>
      <p>You can browse available flights but booking requires login.</p>
      <ul>
        <li>Flight A - ₹6000</li>
        <li>Flight B - ₹7500</li>
        <li>Flight C - ₹9200</li>
      </ul>
    </div>
  );
}

export default Guest;
