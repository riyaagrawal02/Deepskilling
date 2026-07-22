function FlightDetails() {
  const flights = [
    {
      id: 1,
      from: "Delhi",
      to: "Mumbai",
      fare: "₹4500",
    },
    {
      id: 2,
      from: "Bangalore",
      to: "Chennai",
      fare: "₹3000",
    },
    {
      id: 3,
      from: "Hyderabad",
      to: "Kolkata",
      fare: "₹5500",
    },
  ];

  return (
    <>
      <h2>Flight Details</h2>

      <table border="1" cellPadding="10">
        <thead>
          <tr>
            <th>From</th>
            <th>To</th>
            <th>Fare</th>
          </tr>
        </thead>

        <tbody>
          {flights.map((flight) => (
            <tr key={flight.id}>
              <td>{flight.from}</td>
              <td>{flight.to}</td>
              <td>{flight.fare}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </>
  );
}

export default FlightDetails;