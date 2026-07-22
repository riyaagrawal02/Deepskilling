import { useState } from "react";

function ComplaintRegister() {
  const [employeeName, setEmployeeName] = useState("");
  const [complaint, setComplaint] = useState("");

  const handleSubmit = (event) => {
    event.preventDefault();

    if (employeeName.trim() === "" || complaint.trim() === "") {
      alert("Please fill all fields");
      return;
    }

    const referenceNumber =
      "REF" + Math.floor(100000 + Math.random() * 900000);

    alert(
      `Complaint Raised Successfully!\n\nReference Number: ${referenceNumber}`
    );

    setEmployeeName("");
    setComplaint("");
  };

  return (
    <div className="container">
      <h2>Complaint Registration</h2>

      <form onSubmit={handleSubmit}>

        <label>Employee Name</label>

        <input
          type="text"
          value={employeeName}
          onChange={(e) => setEmployeeName(e.target.value)}
          placeholder="Enter Employee Name"
        />

        <label>Complaint</label>

        <textarea
          rows="5"
          value={complaint}
          onChange={(e) => setComplaint(e.target.value)}
          placeholder="Enter Complaint"
        />

        <button type="submit">
          Raise Complaint
        </button>

      </form>
    </div>
  );
}

export default ComplaintRegister;