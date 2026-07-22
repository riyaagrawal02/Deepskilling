import { useState } from "react";

function EventExamples() {
  const [count, setCount] = useState(0);
  const [rupees, setRupees] = useState("");
  const [euros, setEuros] = useState("");

  const increment = () => {
    setCount(count + 1);
  };

  const sayHello = () => {
    alert("Hello! Have a nice day.");
  };

  const handleIncrement = () => {
    increment();
    sayHello();
  };

  const decrement = () => {
    setCount(count - 1);
  };

  const sayWelcome = (message) => {
    alert(message);
  };

  const syntheticEvent = () => {
    alert("I was clicked");
  };

  const convertCurrency = () => {
    const rate = 0.011;
    setEuros((Number(rupees) * rate).toFixed(2));
  };

  return (
    <div>
      <h1>React Event Examples</h1>

      <h2>Counter : {count}</h2>

      <button onClick={handleIncrement}>
        Increment
      </button>

      <button onClick={decrement}>
        Decrement
      </button>

      <br /><br />

      <button onClick={() => sayWelcome("Welcome to React Events")}>
        Say Welcome
      </button>

      <br /><br />

      <button onClick={syntheticEvent}>
        Synthetic Event
      </button>

      <hr />

      <h2>Currency Converter</h2>

      <input
        type="number"
        placeholder="Enter Rupees"
        value={rupees}
        onChange={(e) => setRupees(e.target.value)}
      />

      <button onClick={convertCurrency}>
        Convert to Euro
      </button>

      {euros && (
        <h3>Euro : € {euros}</h3>
      )}
    </div>
  );
}

export default EventExamples;