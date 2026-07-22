import { useState } from "react";
import Guest from "./Components/Guest";
import User from "./Components/User";

function App() {
  const [isLoggedIn, setIsLoggedIn] = useState(false);

  let page;

  if (isLoggedIn) {
    page = <User />;
  } else {
    page = <Guest />;
  }

  return (
    <div>
      <h1>Ticket Booking App</h1>

      {isLoggedIn ? (
        <button onClick={() => setIsLoggedIn(false)}>
          Logout
        </button>
      ) : (
        <button onClick={() => setIsLoggedIn(true)}>
          Login
        </button>
      )}

      <hr />

      {page}
    </div>
  );
}

export default App;