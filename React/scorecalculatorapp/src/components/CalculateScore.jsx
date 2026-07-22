import "../stylesheet/myStyle.css";

function CalculateScore(props) {
  const average = props.Total / props.Goal;

  return (
    <div className="container">
      <h1>Student Details</h1>

      <p><b>Name:</b> {props.Name}</p>

      <p><b>School:</b> {props.School}</p>

      <p><b>Total Marks:</b> {props.Total}</p>

      <p><b>Total Subjects:</b> {props.Goal}</p>

      <h2>Average Score : {average.toFixed(2)}</h2>
    </div>
  );
}

export default CalculateScore;