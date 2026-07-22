import { useParams } from "react-router-dom";
import trainers from "../TrainersMock";

function TrainerDetails() {
  const { id } = useParams();

  const trainer = trainers.find(
    (t) => t.trainerId === id
  );

  if (!trainer) {
    return <h2>Trainer Not Found</h2>;
  }

  return (
    <div>
      <h2>Trainer Details</h2>

      <h3>
        {trainer.name} ({trainer.technology})
      </h3>

      <p>{trainer.email}</p>

      <p>{trainer.phone}</p>

      <ul>
        {trainer.skills.map((skill, index) => (
          <li key={index}>{skill}</li>
        ))}
      </ul>
    </div>
  );
}

export default TrainerDetails;