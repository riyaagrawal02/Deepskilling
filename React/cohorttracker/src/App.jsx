import CohortDetails from "./Components/CohortDetails";

function App() {
  const cohorts = [
    {
      name: "React Fundamentals",
      startDate: "01-Jul-2026",
      status: "ongoing",
      coach: "John",
      trainer: "Alice",
    },
    {
      name: "Java Full Stack",
      startDate: "15-Jun-2026",
      status: "completed",
      coach: "David",
      trainer: "Bob",
    },
    {
      name: "Spring Boot",
      startDate: "20-May-2026",
      status: "ongoing",
      coach: "Steve",
      trainer: "Carol",
    },
  ];

  return (
    <div>
      <h1>Cohort Dashboard</h1>

      {cohorts.map((cohort, index) => (
        <CohortDetails
          key={index}
          cohort={cohort}
        />
      ))}
    </div>
  );
}

export default App;