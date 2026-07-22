import officeImage from "./assets/office.jpeg";

function App() {

  const office = {
    name: "Regus Business Center",
    rent: 55000,
    address: "Noida Sector 62"
  };

  const officeSpaces = [
    {
      id: 1,
      name: "Regus Business Center",
      rent: 55000,
      address: "Noida Sector 62"
    },
    {
      id: 2,
      name: "WeWork",
      rent: 85000,
      address: "Gurugram"
    },
    {
      id: 3,
      name: "SmartWorks",
      rent: 70000,
      address: "Bangalore"
    }
  ];

  return (
    <div>

      <h1>Office Space Rental App</h1>

      <img
        src={officeImage}
        alt="Office"
        width="450"
      />

      <h2>Featured Office</h2>

      <p><b>Name:</b> {office.name}</p>

      <p
        style={{
          color: office.rent < 60000 ? "red" : "green"
        }}
      >
        <b>Rent:</b> ₹{office.rent}
      </p>

      <p><b>Address:</b> {office.address}</p>

      <hr />

      <h2>Available Office Spaces</h2>

      {officeSpaces.map((item) => (

        <div
          key={item.id}
          style={{
            border: "1px solid gray",
            padding: "15px",
            marginBottom: "15px",
            borderRadius: "8px"
          }}
        >

          <h3>{item.name}</h3>

          <p
            style={{
              color: item.rent < 60000 ? "red" : "green"
            }}
          >
            Rent : ₹{item.rent}
          </p>

          <p>Address : {item.address}</p>

        </div>

      ))}

    </div>
  );
}

export default App;