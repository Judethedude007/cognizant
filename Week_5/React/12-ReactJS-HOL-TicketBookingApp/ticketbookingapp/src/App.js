import { useState } from 'react';
import './App.css';
import GuestPage from './components/GuestPage';
import UserPage from './components/UserPage';
import LoginButton from './components/LoginButton';
import LogoutButton from './components/LogoutButton';

function App() {
  const [isLoggedIn, setIsLoggedIn] = useState(false);

  const login = () => {
    setIsLoggedIn(true);
  };

  const logout = () => {
    setIsLoggedIn(false);
  };

  return (
    <div className="App">
      <h1>Ticket Booking App</h1>

      {isLoggedIn ? (
        <LogoutButton onClick={logout} />
      ) : (
        <LoginButton onClick={login} />
      )}

      {isLoggedIn ? <UserPage /> : <GuestPage />}
    </div>
  );
}

export default App;
