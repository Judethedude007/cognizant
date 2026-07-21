import './App.css';
import ListofPlayers from './components/ListofPlayers';
import IndianPlayers from './components/IndianPlayers';

function App() {
  const showListOfPlayers = true;
  const showIndianPlayers = true;

  return (
    <div className="App">
      <h1>Cricket App</h1>

      {showListOfPlayers && <ListofPlayers />}
      {showIndianPlayers && <IndianPlayers />}
    </div>
  );
}

export default App;
