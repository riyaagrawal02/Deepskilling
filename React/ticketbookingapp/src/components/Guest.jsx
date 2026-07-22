import FlightDetails from "./FlightDetails";

function Guest() {
  return (
    <div>
      <h1>Welcome Guest</h1>

      <p>You can browse available flights.</p>

      <FlightDetails />
    </div>
  );
}

export default Guest;