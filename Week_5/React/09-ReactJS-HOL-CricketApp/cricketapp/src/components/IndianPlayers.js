function IndianPlayers() {
  const indianPlayers = ['Sachin1', 'Dhoni2', 'Virat3', 'Rohit4', 'Yuvraj5', 'Raina6'];

  const [first, second, third, fourth, fifth, sixth] = indianPlayers;

  const oddPlayers = [first, third, fifth];
  const evenPlayers = [second, fourth, sixth];

  const t20Players = ['First Player', 'Second Player', 'Third Player'];
  const ranjiPlayers = ['Fourth Player', 'Fifth Player', 'Sixth Player'];

  const mergedPlayers = [...t20Players, ...ranjiPlayers];

  return (
    <div className="section">
      <h2>Indian Players</h2>

      <h3>Odd Players</h3>
      <ul>
        {oddPlayers.map((player, index) => (
          <li key={index}>{player}</li>
        ))}
      </ul>

      <h3>Even Players</h3>
      <ul>
        {evenPlayers.map((player, index) => (
          <li key={index}>{player}</li>
        ))}
      </ul>

      <h3>Merged Players</h3>
      <ul>
        {mergedPlayers.map((player, index) => (
          <li key={index}>{player}</li>
        ))}
      </ul>
    </div>
  );
}

export default IndianPlayers;
